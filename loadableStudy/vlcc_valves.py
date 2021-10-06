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
        # Machinery/Processes
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
        # Machinery/Processes
        self.ballastPumps = {'pump': [], 'eductor': []}
        self.eductor = []
        self.BWTS = False  # False for all MOL VLCC, need to update for other vessel
        self.firstport = len(output['plans']['arrival']['cargoVol']) == 0  # TBC
        self.timeSwitch = {}
        ## Tanks
        self.ballastTanks = {}  # at each timing what tanks are being used
        self.eductionTanks = input_param.loading.info['eduction']  # Tanks to be educted
        self.ballastTanksValves = {}  # mapping of ballast tank and main valve
        # self.ballastTankOperation = {}  # at each stage and time, operation of main valve

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
        self.opened_valves = {}  ## track record of what valves are opened
        ## filtered valves and operation (for selected tanks, manifold, bottom lines) for each stage
        self.loading_valves = {}
        self.deballast_valves = {}
        self.discharging_valves = {}
        self.ballast_valves = {}
        # timeline for valves (cargo and ballast)
        self.loading_timeline = {}

    def prepOperation(self):
        """Extract and reformat data required from output to generate valves"""
        self.getToppingSequence('topping')
        self.getBallastTanks('deballasting')
        self.getDeballastTiming('loadingAtMaxRate')
        return

    def integrateValves(self):
        """Get valves sequence (cargo and ballast) and integrate into output"""
        # get valves from vessel json and put into its respective stages.
        # E.g valves for start of loading seq into open single tank stage
        self.getLoadingValves()
        self.getDeballastValves()
        # self.getDeballastTanksValves()

        # # combine ballast and cargo valves and timing for valves
        self.getLoadingValvesTimeLine()
        self.combineValves()

    def combineValves(self):
        """Combine valves sequence with timeline into output format"""
        for cargo in self.loading_timeline:
            cargo_idx = \
                [idx for idx, info in enumerate(self.output["events"]) if str(info['cargoNominationId']) == cargo[1:]][
                    0]
            for stage in self.loading_timeline[cargo]:
                cargo_valves = []
                ballast_valves = []
                stage_idx = [idx for idx, info in enumerate(self.output["events"][cargo_idx]["sequence"]) if
                             str(info['stage']) == stage][0]
                stageTimeEnd = int(self.output["events"][cargo_idx]["sequence"][stage_idx]['timeEnd'])
                for time, info in self.loading_timeline[cargo][stage].items():
                    currCargoTime = time
                    currCargoValve = {"time": 0, "operation": "", "valves": []}
                    currBallastTime = time
                    currBallastValve = {"time": 0, "operation": "", "valves": []}
                    # Cargo
                    for cvalves in info['cargo']:  # Loop through each type of valve
                        if currCargoValve["operation"] == "":
                            currCargoValve["operation"] = cvalves[0]["operation"]
                            currCargoValve["time"] = currCargoTime
                        elif currCargoValve["operation"] != cvalves[0]["operation"]:
                            if len(currCargoValve['valves']) > 0:
                                cargo_valves.append(currCargoValve)
                            if currCargoTime < stageTimeEnd:  # Ensure valve operation dont exceed end of stage
                                currCargoTime += 1
                            currCargoValve = {"time": currCargoTime, "operation": cvalves[0]["operation"], "valves": []}
                        for valve in cvalves:  # Loop through different lines/tanks of each type of valve
                            if len(currCargoValve["valves"]) > 0:
                                prevValve = currCargoValve["valves"][-1]
                                prevValveKey = list(prevValve.keys())[0]
                                if prevValveKey == valve['category']:
                                    currCargoValve["valves"][-1][prevValveKey].append(valve['valve'])
                                else:
                                    newValveType = {valve['category']: [valve['valve']]}
                                    currCargoValve["valves"].append(newValveType)
                            else:
                                newValveType = {valve['category']: [valve['valve']]}
                                currCargoValve["valves"].append(newValveType)
                    if len(currCargoValve['valves']) > 0:
                        cargo_valves.append(currCargoValve)
                    # Ballast
                    for bvalves in info['ballast']:  # Loop through each type of valve
                        if currBallastValve["operation"] == "":
                            currBallastValve["operation"] = bvalves[0]["operation"]
                            currBallastValve["time"] = currBallastTime
                        elif currBallastValve["operation"] != bvalves[0]["operation"]:
                            if len(currBallastValve['valves']) > 0:
                                ballast_valves.append(currBallastValve)
                            if currBallastTime < stageTimeEnd:  # Ensure valve operation dont exceed end of stage
                                currBallastTime += 1
                            currBallastValve = {"time": currBallastTime, "operation": bvalves[0]["operation"],
                                                "valves": []}
                        for valve in bvalves:  # Loop through different lines/tanks of each type of valve
                            if len(currBallastValve["valves"]) > 0:
                                prevValve = currBallastValve["valves"][-1]
                                prevValveKey = list(prevValve.keys())[0]
                                if prevValveKey == valve['category']:
                                    currBallastValve["valves"][-1][prevValveKey].append(valve['valve'])
                                else:
                                    newValveType = {valve['category']: [valve['valve']], 'valveStage': valve['stageNo']}
                                    currBallastValve["valves"].append(newValveType)
                            else:
                                newValveType = {valve['category']: [valve['valve']], 'valveStage': valve['stageNo']}
                                currBallastValve["valves"].append(newValveType)
                    if len(currBallastValve['valves']) > 0:
                        ballast_valves.append(currBallastValve)
                self.output["events"][cargo_idx]["sequence"][stage_idx]['cargoValves'] = cargo_valves
                self.output["events"][cargo_idx]["sequence"][stage_idx]['ballastValves'] = ballast_valves
        return

    # TODO: pipelines info (generalise for single segregation)
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
                                    self.updateValveStatus(valves, name)
                                elif 'CARGO PIPE LINE VALVES' == valveType:
                                    name = 'tankValves'
                                    tanks = self.getCargoTanksForStage(stage, cargo, isTopping)
                                    valves = self.getTankValves(tanks, raw_valves[step],
                                                                'CARGO PIPE LINE VALVES')  ### problem here
                                    self.updateValveStatus(valves, name)
                                else:
                                    name = self.nameTankValve(valveType)
                                    valves = self.getOtherValves(raw_valves[step], name)
                                    self.updateValveStatus(valves, name)
                                if len(valves) > 0:
                                    for j in valves:  ## add category to valves
                                        j['category'] = name
                                    allsteps.append(valves)
                        stage_valves[i] = allsteps
                    cargo_valves[stage] = stage_valves
            final_valves[cargo] = cargo_valves
        self.loading_valves = final_valves

        return

    def getDeballastValves(self):
        """Get deballast loading valves from the given valves sequence and classify it into the
            different stages in loading"""
        final_valves = {}
        # Loop through all cargoes
        for cargo in self.tanks:
            ballast_valves = {}
            # Get correct valves based on loading plan
            # 1) with gravity or not
            # self.firstport
            if (not self.BWTS) & self.firstport:  # no BWTS and is first loading port
                deballast_config = self.valve_config['deballasting']['gravity']
            else:
                deballast_config = self.valve_config['deballasting']['nogravity']
            # 2) with eduction or not
            if len(self.eductionTanks) == 0:
                del deballast_config['loadingAtMaxRate']['seaTosea']
                del deballast_config['loadingAtMaxRate']['strippingByEductor']

            # Loop through each stage in loading process and get required valve process
            for stage, info in deballast_config.items():
                stage_valves = {}
                if len(info) == 0:  # no valve process
                    ballast_valves[stage] = stage_valves
                else:
                    for i in info:  # loop through all valve processes
                        # For each step in valve process, get required valve info
                        raw_valves = self.valves['deballast'][i]
                        allsteps = []
                        for step in raw_valves:
                            if ('0' not in step):
                                valveType = raw_valves[step][0]['valveTypeName']  # Check type of valve
                                # get valves for each type of valves in sequence
                                if valveType == 'BALLAST PUMP':  # Ballast Pumps
                                    name = 'ballastPumps'
                                    valves = self.getBallastPumps(raw_valves[step], name)
                                    self.updateValveStatus(valves, name)

                                elif valveType.startswith('EDUCTOR'):  # Eductor related valves
                                    name = self.nameTankValve(valveType)
                                    valves = self.getBallastEductorValves(raw_valves[step], name)
                                    self.updateValveStatus(valves, name)

                                elif valveType.startswith('STRIPPER SUCTION'):  # Tank stripping valve
                                    name = self.nameTankValve(valveType)
                                    valves = self.getTankValves(self.eductionTanks, raw_valves[step],
                                                                'STRIPPER SUCTION')
                                    self.updateValveStatus(valves, name)

                                elif 'BALLLAST VALVES' == valveType:  # Main Tank Valves
                                    name = 'tankValves'
                                    tanks = list(self.input.loadable['ballastOperation'].keys())
                                    valves = self.getTankValves(tanks, raw_valves[step], 'BALLLAST VALVES')
                                    self.updateValveStatus(valves, name)
                                    if len(self.ballastTanksValves) == 0:  # save tank to valve mapping
                                        for valve in valves:
                                            self.ballastTanksValves[valve['tank']] = valve
                                #     tanks_arr = self.getBallastTanksForStage(stage, cargo)
                                #     valves = []
                                #     for tanks in tanks_arr:
                                #         subvalve = self.getTankValves(tanks, raw_valves[step], 'BALLLAST VALVES')
                                #         self.updateValveStatus(subvalve, name)
                                #         valves += subvalve
                                else:  # Others
                                    name = self.nameTankValve(valveType)
                                    valves = self.getOtherValves(raw_valves[step], name)
                                    self.updateValveStatus(valves, name)
                                if len(valves) > 0:
                                    for j in valves:  ## add category to valves
                                        j['category'] = name
                                    allsteps.append(valves)
                        stage_valves[i] = allsteps
                    ballast_valves[stage] = stage_valves
            final_valves[cargo] = ballast_valves
        self.deballast_valves = final_valves

        return

    def getLoadingValvesTimeLine(self):
        """Format cargo and ballast valve according to time to open each valve"""
        # cargo: only topping have variable timeline for valves
        # ballast: max rate: by pump only if theres gravity, change to eductor/seatosea (2hrs), shut down/sea to sea at the end
        result = {}
        # Loop through all cargo in current loading plan
        for c in self.output['events']:
            cargo = 'P' + str(c['cargoNominationId'])
            result[cargo] = {}
            # Loop through all stages for each cargo
            for s in c['sequence']:
                # Get information of stage
                stage = s['stage']
                time = int(s['timeStart'])
                timeEnd = int(s['timeEnd'])
                stage_timeline = {}
                # Process valve timing for each stage
                if stage == 'loadingAtMaxRate':
                    pumpTime = self.timeSwitch[cargo]['pump']
                    stage_timeline[pumpTime] = {'cargo': [], 'ballast': []}
                    shutTime = self.timeSwitch[cargo]['shut']
                    stage_timeline[shutTime] = {'cargo': [], 'ballast': []}
                    if len(self.eductionTanks) > 0:
                        eductorTime = self.timeSwitch[cargo]['eductor']
                        stage_timeline[eductorTime] = {'cargo': [], 'ballast': []}

                    # Ballast Gravity -> Pump: valve sequence for change over (after 2h/4 if <10k)
                    if (not self.BWTS) & self.firstport:  # no BWTS and is first loading port: gravity
                        stage_timeline[pumpTime]['ballast'] += self.deballast_valves[cargo][stage][
                            'floodingTheBallastPump']
                        stage_timeline[pumpTime]['ballast'] += self.deballast_valves[cargo][stage][
                            'debalastingByPumpAfterGravity']
                    else:  # no gravity
                        pass

                    # Ballast Pump -> Eductor: Eductor and Sea to Sea sequence 3hours before stage end
                    # Ballast Shutting: shutting sequence 1hr before stage end
                    if len(self.eductionTanks) > 0:
                        stage_timeline[eductorTime]['ballast'] += self.deballast_valves[cargo][stage]['seaToSea']
                        if len(self.ballastPumps) == 2:
                            closePump = self.ballastPumps['pump'][-1]
                            closePump['operation'] = 'close'
                            self.deballast_valves[cargo][stage]['strippingByEductor'] = [[closePump]] + \
                                                                                        self.deballast_valves[cargo][
                                                                                            stage]['strippingByEductor']
                        stage_timeline[eductorTime]['ballast'] += self.deballast_valves[cargo][stage][
                            'strippingByEductor']
                        stage_timeline[shutTime]['ballast'] += self.deballast_valves[cargo][stage]['seaTosea']
                        stage_timeline[shutTime]['ballast'] += self.deballast_valves[cargo][stage]['shuttingSequence']
                    else:
                        stage_timeline[shutTime]['ballast'] += self.deballast_valves[cargo][stage]['seaToSea']
                        stage_timeline[shutTime]['ballast'] += self.deballast_valves[cargo][stage]['shuttingSequence']

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
                    for process, valves in self.deballast_valves[cargo][stage].items():
                        stage_timeline[time]['ballast'] += valves
                stage_timeline = {k: stage_timeline[k] for k in sorted(stage_timeline)}
                result[cargo][stage] = stage_timeline
        self.loading_timeline = result
        return

    def updateValveStatus(self, valves, category):
        """Update current status of valve which are opened while extracting valve action.
            To track opening and closing of valves to identify errors"""
        if category not in self.opened_valves:
            self.opened_valves[category] = []
        # Loop through sequence of valves
        for valve in valves:
            operation = valve['operation']
            valveName = valve['valve']
            # If valve is to be opened
            if operation == 'open':
                # Check if valve is already opened, cannot open an opened valve
                if valveName in self.opened_valves[category]:
                    pass
                else:
                    self.opened_valves[category].append(valveName)
            # If valve is to be closed
            else:
                # Check if valve is already closed, cannot close a closed valve
                if valveName in self.opened_valves[category]:
                    self.opened_valves[category].remove(valveName)
                else:
                    pass  # cannot close valve thats already closed
        return

    def nameTankValve(self, raw_name):
        """To extract short name of valves for labelling"""
        name = ''.join([i[0].upper() + i[1:].lower() for i in raw_name.split(' ')])
        name = name[0].lower() + name[1:]
        return name

    def getCargoTanksForStage(self, stage, cargo, topping):
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

    # # TODO
    # def getBallastTanksForStage(self, stage, cargo):
    #
    #     set_tanks = self.ballastTanks[cargo]['deballast'][stage]
    #
    #     newTanks = []
    #     for time, tanks in set_tanks.items():
    #         newTanks.append(tanks)
    #     return newTanks

    def getTankValves(self, tanks, seq, valveType):  # E.g tanks:['1W', '1C', 'SLS'], seq: sequence0/1 from vessel json
        """Filter Tank Valves (valveTypeName: CARGO PIPE LINE VALVES) for required tanks.
            Valves for all tanks are given for all valve processes"""
        tankValves = []  # Final set of tank valves to return
        if 'tankValves' not in self.opened_valves:
            self.opened_valves['tankValves'] = []
        # Loop through all tank valves given and extract valves of required tank
        for valve in seq:
            if valve['valveTypeName'] == valveType:
                valveName = valve['valveNumber']
                valveOpen = 'close' if valve['shut'] else 'open'  # C for Close, O for Open
                tankName = valve['tankShortName']
                if tankName in tanks:
                    value = {'valve': valveName, 'tank': tankName, 'operation': valveOpen,
                             'stageNo': valve['stageNumber']}
                    if valveOpen == 'close':  # Can only close tanks that are already opened
                        if valveName in self.opened_valves['tankValves']:
                            tankValves += [value]
                    else:  # Can only open tanks that are closed
                        if valveName not in self.opened_valves['tankValves']:
                            tankValves += [value]
        tankValves = sorted(tankValves, key=lambda x: tanks.index(x['tank']))
        return tankValves

    def getManifoldValves(self, seq):  # E.g lines:[1,2,3], side = port/stbd, seq: sequence0/1 from vessel json
        """Filter Manifold valves for required manifold.
                    Valves for all manifold are given for all valve processes"""
        lines = self.manifold
        side = self.manifoldSide
        manifoldValves = []
        if 'manifoldValves' not in self.opened_valves:
            self.opened_valves['manifoldValves'] = []
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
                    value = {'valve': valveName, 'line': valveLine, 'operation': valveOpen,
                             'stageNo': valve['stageNumber']}
                    if valveOpen == 'close':  # Can only close manifold that are already opened
                        if valveName in self.opened_valves['manifoldValves']:
                            manifoldValves.append(value)
                    else:  # Can only open manifold that are closed
                        if valveName not in self.opened_valves['manifoldValves']:
                            manifoldValves.append(value)
        return manifoldValves

    def getOtherValves(self, seq, name):
        """Filter all the types of valves for required info. """
        valves = []
        if name not in self.opened_valves:
            self.opened_valves[name] = []
        for valve in seq:
            valveOpen = 'close' if valve['shut'] else 'open'
            valveName = valve['valveNumber']
            valveLine = valve['pipelineName']
            value = {'valve': valveName, 'line': valveLine, 'operation': valveOpen, 'stageNo': valve['stageNumber']}
            if valveOpen == 'close':
                if valveName in self.opened_valves[name]:
                    valves.append(value)
            else:
                if valveName not in self.opened_valves[name]:
                    valves.append(value)
        return valves

    def getBallastPumps(self, seq, name):
        valves = []
        if name not in self.opened_valves:
            self.opened_valves[name] = []
        for valve in seq:
            valveOpen = 'close' if valve['shut'] else 'open'
            valveName = valve['valveNumber']
            valveLine = valve['pipelineName']
            value = {'valve': valveName, 'line': valveLine, 'operation': valveOpen, 'stageNo': valve['stageNumber']}
            if valveOpen == 'close':
                if valveName in self.opened_valves[name]:
                    valves.append(value)
            else:
                if valveName not in self.opened_valves[name]:
                    valves.append(value)
                    self.ballastPumps['pump'].append(value)
        return valves

    def getBallastEductorValves(self, seq, name):
        valves = []
        if name not in self.opened_valves:
            self.opened_valves[name] = []
        for valve in seq[:-1]:
            valveOpen = 'close' if valve['shut'] else 'open'
            valveName = valve['valveNumber']
            valveLine = valve['pipelineName']
            value = {'valve': valveName, 'line': valveLine, 'operation': valveOpen, 'stageNo': valve['stageNumber']}
            if valveOpen == 'close':
                if valveName in self.opened_valves[name]:
                    valves.append(value)
            else:
                if valveName not in self.opened_valves[name]:
                    valves.append(value)
        return valves

    # TODO: input.loading.info-> tanksto ballast/tanksto deballast?
    def getBallastTanks(self, operation='deballasting'):
        """Get Ballast tanks used at each stage and time.
            Certain ballast tanks may start deballasting at a later time,
            rather than right from the start"""
        output = self.output
        result = {}
        for e in output['events']:
            cargo = 'P' + str(e['cargoNominationId'])
            ballast_time = {}  # Tanks being used for ballasting at each timestamp
            deballast_time = {}
            if cargo in self.tanks:
                for stages in e['sequence'][1:]:  # First stage omitted, arrival condition
                    stageName = stages['stage']
                    prevDeballastTank = []
                    # Tanks used for deballasting
                    if f'sim{operation.title()}RateM3_Hr' in stages:
                        deballast_time[stageName] = {}
                        prevEndTime = 0
                        for substages in stages[f'sim{operation.title()}RateM3_Hr']:
                            if len(substages) > 0:
                                startTime = int(list(substages.values())[0]["timeStart"])
                                endTime = int(list(substages.values())[0]["timeEnd"])
                                deballast_time[stageName][startTime] = {'close': [], 'open': []}
                                deballast_time[stageName][endTime] = {'close': [], 'open': []}
                            tanks = [info['tankName'] for i, info in substages.items()]  # Current stage opened tanks
                            # Close tanks in previous stages but not in current stages
                            tanksToBeClosed = [prevTank for prevTank in prevDeballastTank if prevTank not in tanks]
                            for prevTank in tanksToBeClosed:
                                deballast_time[stageName][prevEndTime]['close'].append(prevTank)
                                prevDeballastTank.remove(prevTank)

                            # Open tanks not in previous stages but in current stages
                            tanksToBeOpened = [tank for tank in tanks if tank not in prevDeballastTank]
                            for tank in tanksToBeOpened:
                                deballast_time[stageName][startTime]['open'].append(tank)
                                prevDeballastTank.append(tank)

                            if len(substages) > 0:
                                prevEndTime = endTime
                # Close last set of tanks opened at the stage
                lastStageName = list(deballast_time.keys())[-1]
                if len(deballast_time[lastStageName][endTime]['close']) == 0:
                    tanks = deballast_time[lastStageName][startTime]['open']
                    deballast_time[lastStageName][endTime]['close'] = tanks
            result[cargo] = {operation: deballast_time}
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
            tank_endTime = []
            if cargo in self.tanks:
                for stages in e['sequence'][1:]:  # First stage omitted, arrival condition
                    if stages['stage'] == stage:  # Topping stage for loading, staggering for discharging
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
            else:  # For wing tanks (both wing tanks)
                last[cargo] = [tank_endTime[-2]['tank'], tank_endTime[-1]['tank']]
        self.toppingSequence = topping
        self.lastTank = last
        return

    def getDeballastTiming(self, stage='loadingAtMaxRate'):
        for e in self.output['events']:
            cargo = 'P' + str(e['cargoNominationId'])
            if cargo in self.tanks:
                self.timeSwitch[cargo] = {}
                for stages in e['sequence'][1:]:  # First stage omitted, arrival condition
                    if stages['stage'] == stage:
                        print(stages["timeEnd"])
                        if len(self.eductionTanks) > 0:
                            self.timeSwitch[cargo]['eductor'] = max(
                                self.ballastTanks[cargo]['deballasting']['loadingAtMaxRate'].keys())
                            self.timeSwitch[cargo]['shut'] = self.timeSwitch[cargo]['eductor'] + \
                                                             self.valve_config['deballasting']['timing'][
                                                                 'eductor']

                        else:
                            self.timeSwitch[cargo]['shut'] = int(stages["timeEnd"])
                    elif stages['stage'] == 'openSingleTank':
                        time = int(stages['timeStart'])  # TODO
                        self.timeSwitch[cargo]['pump'] = time + self.valve_config['deballasting']['timing']['pump']

        return
