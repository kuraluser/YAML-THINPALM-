import numpy as np
import json
import pandas as pd


class Generate_valves:
    def __init__(self, input_param, output, raw_output):
        print('')
        print('GENERATE VALVES')
        # Operation
        self.module = input_param.module

        # Cargo
        ## Machinery
        self.manifold = input_param.loading.load_param['Manifolds']
        self.manifoldSide = 'port'  ## waiting for updates
        self.bottomLines = input_param.loading.load_param['BottomLines']
        self.cargoPumps = []
        ##Tanks
        preloaded = input_param.loading.preloaded_cargos
        self.tanks = {cargo: tanks for cargo, tanks in input_param.loading.info['cargo_tank'].items() if
                      cargo not in preloaded}
        self.initialTanks = {cargo: [input_param.loading.seq[cargo]['firstTank']] for cargo in
                             self.tanks}  ## for loading ## check simCargoRate
        self.toppingSequence = {}  ## topping sequence for loading, staggering sequence for discharging
        self.lastTank = {}  # last tank to top off

        # Ballast
        ## Machinery
        self.ballastPumps = []
        self.BWTS = False  # False for all MOL VLCC, need to update for other vessel
        ## Tanks
        self.ballastTanks = {}  # at each time interval what tanks are being used, need to close the tanks not in use, open the tanks in use

        # Valve Sequence
        self.valves = input_param.vessel_json['vessel']['vesselValveSequence']

        # Valves Config
        with open('valves_config.json') as f_:
            self.valve_config = json.load(f_)

        # other data
        self.input = input_param
        self.output = output
        self.raw_output = raw_output

        # Processed data
        self.opened_cargovalves = {}  ## track record of what valves are opened
        ## filtered valves and operation (for selected tanks, manifold, bottom lines) for each stage
        self.loading_valves = {}
        self.deballast_valves = {}
        self.deballast_valves = {}
        self.ballast_valves = {}
        # timeline for valves (cargo and ballast)
        self.loading_timeline = {}

    def prepOperation(self):
        """Extract and reformat data required from output to generate valves"""
        self.getToppingSequence('topping')
        self.getBallastTanks()
        return

    def integrateValves(self):
        """Get valves sequence (cargo and ballast) and integrate into output"""
        # get valves from vessel json and put into its respective stages.
        # E.g valves for start of loading seq into open single tank stage
        self.getLoadingValves()
        # self.getBallastValves()
        # combine ballast and cargo valves and timing for valves
        self.getLoadingValvesTimeLine()
        self.combineValves()

    def combineValves(self):
        """Combine valves sequence with timeline into output format"""
        return

    # TODO: pipelines info (generalise for single segregation), ballast
    def getLoadingValves(self):
        """Get cargo loading valves from the given valves sequence and classify it into the
            different stages in loading"""
        final_valves = {}
        # Loop through all cargoes
        for cargo in self.tanks:
            cargo_valves = {}
            # Loop through each stage in loading process and get required valve process
            for stage, info in self.valve_config['loading'].items():
                stage_valves = {}
                if len(info) == 0:  # no valve process
                    cargo_valves[stage] = stage_valves
                else:
                    for i in info:  # loop through all valve processes
                        # Check if current stage is topping
                        isTopping = '_' in i
                        if isTopping:
                            seqno = i.split('_')[-1]
                            raw_valves = self.valves['loading'][i.split('_')[0]]
                        else:
                            seqno = '0'
                            raw_valves = self.valves['loading'][i]
                        # For each step in valve process, get required valve info
                        allsteps = []
                        for step in raw_valves:
                            if (('0' not in step) & (not isTopping)) | ((seqno in step) & isTopping):
                                valveType = raw_valves[step][0]['valveTypeName']  ## check type of valve
                                # get valves for each type of valves in sequence
                                if 'MANIFOLD' in valveType:
                                    name = 'manifoldValves'
                                    valves = self.getManifoldValves(raw_valves[step])
                                    self.updateCargoValveStatus(valves, name)
                                elif 'CARGO PIPE LINE VALVES' == valveType:
                                    name = 'tankValves'
                                    tanks = self.getTanksForStage(stage, cargo, isTopping)
                                    valves = self.getTankValves(tanks, raw_valves[step])  ### problem here
                                    self.updateCargoValveStatus(valves, name)
                                else:
                                    name = self.nameTankValve(valveType)
                                    valves = self.getOtherValves(raw_valves[step], name)
                                    self.updateCargoValveStatus(valves, name)
                                if len(valves) > 0:
                                    for j in valves:  ## add category to valves
                                        j['category'] = name
                                    allsteps.append(valves)
                        stage_valves[i] = allsteps
                    cargo_valves[stage] = stage_valves
            final_valves[cargo] = cargo_valves
        self.loading_valves = final_valves

        return

    def getLoadingValvesTimeLine(self):
        """Format cargo and ballast valve according to time to open each valve"""
        # cargo: only topping have variable timeline for valves
        # ballast: max rate: by pump only if theres gravity, change to eductor/seatosea (2hrs), shut down/sea to sea at the end
        result = {}
        # Loop through all cargo in current loading plan
        for c in self.output['events']:
            cargo = 'P' + str(c['cargoNominationId'])
            print(cargo)
            result[cargo] = {}
            # Loop through all stages for each cargo
            for s in c['sequence']:
                # Get information of stage
                stage = s['stage']
                time = int(s['timeStart'])
                timeEnd = int(s['timeEnd'])
                print(stage, time, timeEnd)
                stage_timeline = {}
                # Process valve timing for each stage
                if stage == 'loadingAtMaxRate':
                    # Ballast Gravity -> Pump: valve sequence for change over (after 2h/4 if <10k)
                    # Ballast Pump -> Eductor: Eductor and Sea to Sea sequence 3hours before stage end
                    # Ballast Shutting: shutting sequence 1hr before stage end
                    pass
                elif stage == 'topping':
                    # Cargo Topping: close valves for topping sequence
                    # Cargo Shutting: shutting sequence and close final tank in topping sequence
                    toppingSeq = self.toppingSequence[cargo]
                    for process, valves in self.loading_valves[cargo][stage].items():
                        for valve in valves:
                            if (valve[0]['category'] != 'tankValves'):
                                # Other valves
                                if timeEnd not in stage_timeline:
                                    stage_timeline[timeEnd] = {'cargo': [], 'ballast': []}
                                stage_timeline[timeEnd]['cargo'] += [valve]
                            else:
                                # Tank Valves in topping sequence order
                                for tankinfo in valve:
                                    tanktime = [i['time'] for i in toppingSeq if i['tank'] == tankinfo['tank']][0]
                                    if tanktime not in stage_timeline:
                                        stage_timeline[tanktime] = {'cargo': [], 'ballast': []}
                                    stage_timeline[tanktime]['cargo'].append([tankinfo])

                else:
                    # Other stages: empty stages with no valve action
                    # Other stages where valve action occurs at the start of the stage
                    stage_timeline[time] = {'cargo': [], 'ballast': []}
                    for process, valves in self.loading_valves[cargo][stage].items():
                        stage_timeline[time]['cargo'] += valves
                    # for process, valves in self.ballast_valves[cargo][stage].items():
                    #     stage_timeline[time]['ballast'] += valves
                print(stage_timeline)
                result[cargo][stage] = stage_timeline
        self.loading_timeline = result
        return

    def updateCargoValveStatus(self, valves, category):
        """Update current status of valve which are opened while extracting valve action.
            To track opening and closing of valves to identify errors"""
        if category not in self.opened_cargovalves:
            self.opened_cargovalves[category] = []
        # Loop through sequence of valves
        for valve in valves:
            operation = valve['operation']
            valveName = valve['valve']
            # If valve is to be opened
            if operation == 'open':
                # Check if valve is already opened, cannot open an opened valve
                if valveName in self.opened_cargovalves[category]:
                    pass
                else:
                    self.opened_cargovalves[category].append(valveName)
            # If valve is to be closed
            else:
                # Check if valve is already closed, cannot close a closed valve
                if valveName in self.opened_cargovalves[category]:
                    self.opened_cargovalves[category].remove(valveName)
                else:
                    pass  # cannot close valve thats already closed
        return

    def nameTankValve(self, raw_name):
        """To extract short name of valves for labelling"""
        name = ''.join([i[0].upper() + i[1:].lower() for i in raw_name.split(' ')])
        name = name[0].lower() + name[1:]
        return name

    def getTanksForStage(self, stage, cargo, topping):
        """Get tanks being used for a particular stage"""
        if stage == 'openSingleTank':
            tanks = self.initialTanks[cargo]
        elif stage == 'topping':
            if topping:  # If isTopping is true, then get tanks in order except final tank
                tanks = [i['tank'] for i in self.toppingSequence[cargo] if i['tank'] not in self.lastTank[cargo]]
            else:  # get final tank for shutting sequence
                tanks = self.lastTank[cargo]
        else:
            tanks = [tank for tank in self.tanks[cargo] if tank not in self.initialTanks[cargo]]

        newTanks = []
        for tank in tanks:
            # Separate wing tanks into individual tank to get individual tank valves
            if tank[-1] == 'W':
                newTanks.append(tank[:-1] + 'P')
                newTanks.append(tank[:-1] + 'S')
            else:
                newTanks.append(tank)
        return newTanks

    def getTankValves(self, tanks, seq):  # E.g tanks:['1W', '1C', 'SLS'], seq: sequence0/1 from vessel json
        """Filter Tank Valves (valveTypeName: CARGO PIPE LINE VALVES) for required tanks.
            Valves for all tanks are given for all valve processes"""
        tankValves = []  # Final set of tank valves to return
        if 'tankValves' not in self.opened_cargovalves:
            self.opened_cargovalves['tankValves'] = []
        # Loop through all tank valves given and extract valves of required tank
        for valve in seq:
            if valve['valveTypeName'] == 'CARGO PIPE LINE VALVES':
                valveName = valve['valveNumber']
                valveOpen = 'close' if valve['shut'] else 'open'  # C for Close, O for Open
                tankName = valve['tankShortName']
                if tankName in tanks:
                    value = {'valve': valveName, 'tank': tankName, 'operation': valveOpen}
                    if valveOpen == 'close':  # Can only close tanks that are already opened
                        if valveName in self.opened_cargovalves['tankValves']:
                            tankValves += [value]
                    else:  # Can only open tanks that are closed
                        if valveName not in self.opened_cargovalves['tankValves']:
                            tankValves += [value]
        tankValves = sorted(tankValves, key=lambda x: tanks.index(x['tank']))
        return tankValves

    def getManifoldValves(self, seq):  # E.g lines:[1,2,3], side = port/stbd, seq: sequence0/1 from vessel json
        """Filter Manifold valves for required manifold.
                    Valves for all manifold are given for all valve processes"""
        lines = self.manifold
        side = self.manifoldSide
        manifoldValves = []
        if 'manifoldValves' not in self.opened_cargovalves:
            self.opened_cargovalves['manifoldValves'] = []
        for valve in seq:
            # identify corect valves
            valveline = int(valve['pipelineName'][-1])
            valveTypeName = valve['valveTypeName'].lower()  # MANIFOLD GATE VALVE PORT SIDE
            if 'manifold' in valveTypeName:
                # valve info
                valveName = valve['valveNumber']
                valveOpen = 'close' if valve['shut'] else 'open'
                valveLine = valve['pipelineName']
                if (side.lower() in valveTypeName) & (valveline in lines):
                    value = {'valve': valveName, 'line': valveLine, 'operation': valveOpen}
                    if valveOpen == 'close':  # Can only close manifold that are already opened
                        if valveName in self.opened_cargovalves['manifoldValves']:
                            manifoldValves.append(value)
                    else:  # Can only open manifold that are closed
                        if valveName not in self.opened_cargovalves['manifoldValves']:
                            manifoldValves.append(value)
        return manifoldValves

    def getOtherValves(self, seq, name):
        """Filter all the types of valves for required info. """
        valves = []
        if name not in self.opened_cargovalves:
            self.opened_cargovalves[name] = []
        for valve in seq:
            valveOpen = 'close' if valve['shut'] else 'open'
            valveName = valve['valveNumber']
            valveLine = valve['pipelineName']
            value = {'valve': valveName, 'line': valveLine, 'operation': valveOpen}
            if valveOpen == 'close':
                if valveName in self.opened_cargovalves[name]:
                    valves.append(value)
            else:
                if valveName not in self.opened_cargovalves[name]:
                    valves.append(value)
        return valves

    def getBallastTanks(self):
        """Get Ballast tanks used at each stage and time.
            Certain ballast tanks may start deballasting at a later time,
            rather than right from the start"""
        output = self.output
        result = {}
        for e in output['events']:
            cargo = e['cargoNominationId']
            ballast_time = {}  # Tanks being used for ballasting at each timestamp
            deballast_time = {}
            if cargo in self.tanks:
                for stages in e['sequence'][1:]:  # First stage omitted, arrival condition
                    # Tanks used for deballasting
                    for substages in stages['simDeballastingRateM3_Hr']:
                        for tankId, tanks in substages.items():
                            # ballast tank info at that stage/substage
                            time = tanks['timeStart']
                            tankName = tanks['tankName']
                            if time in deballast_time:
                                deballast_time[time].append([tankName, tankId])
                            else:
                                deballast_time[time] = [[tankName, tankId]]
                    # Tanks used for ballasting
                    for substages in stages['simBallastingRateM3_Hr']:
                        for tankId, tanks in substages.items():
                            # ballast tank info at that stage/substage
                            time = tanks['timeStart']
                            tankName = tanks['tankName']
                            if time in ballast_time:
                                ballast_time[time].append([tankName, tankId])
                            else:
                                ballast_time[time] = [[tankName, tankId]]
            result[cargo] = {'ballast': ballast_time, 'deballast': deballast_time}
        self.ballastTanks = result
        return

    def getToppingSequence(self, stage='topping'):
        """Get Ballast tanks used at each stage and time.
            Certain ballast tanks may start deballasting at a later time,
            rather than right from the start"""
        output = self.output
        topping = {}
        last = {}
        for e in output['events']:
            cargo = 'P' + str(e['cargoNominationId'])
            tank_endTime = []  # Tanks being used for ballasting at each timestamp
            if cargo in self.tanks:
                for stages in e['sequence'][1:]:  # First stage omitted, arrival condition
                    if stages['stage'] == stage: # Topping stage for loading, staggering for discharging
                        # Get end time of each tank
                        for tankId, tanks in stages['simCargoLoadingRatePerTankM3_Hr'].items():
                            time = int(tanks['timeEnd'])
                            tankName = tanks['tankName']
                            tank_endTime.append({'time': time, 'tank': tankName})
            # Sort tanks according to first to end to last
            tank_endTime = sorted(tank_endTime, key=lambda k: k['time'])
            topping[cargo] = tank_endTime
            # For center tanks, sls, slp
            if ('C' in tank_endTime[-1]['tank'][-1]) | (tank_endTime[-1]['tank'] in ['SLS', 'SLP']):
                last[cargo] = [tank_endTime[-1]['tank']]
            else: # For wing tanks (both wing tanks)
                last[cargo] = [tank_endTime[-2]['tank'], tank_endTime[-1]['tank']]
        self.toppingSequence = topping
        self.lastTank = last
        return
