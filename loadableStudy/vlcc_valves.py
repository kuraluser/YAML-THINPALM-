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
        self.manifoldSide = 'port' ## waiting for updates
        self.bottomLines = input_param.loading.load_param['BottomLines']
        self.cargoPumps = []
        ##Tanks
        preloaded = input_param.loading.preloaded_cargos
        self.tanks = {cargo: tanks for cargo, tanks in input_param.loading.info['cargo_tank'].items() if cargo not in preloaded}
        self.initialTanks = {cargo: [input_param.loading.seq[cargo]['firstTank']] for cargo in self.tanks} ## for loading ## check simCargoRate
        self.toppingSequence = {} ## topping sequence for loading, staggering sequence for discharging
        self.lastTank = {} # last tank to top off

        # Ballast
        ## Machinery
        self.ballastPumps = []
        self.BWTS = False # False for all MOL VLCC, need to update for other vessel
        ## Tanks
        self.ballastTanks = {} # at each time interval what tanks are being used, need to close the tanks not in use, open the tanks in use

        # Valve Sequence
        self.valves = input_param.vessel_json['vessel']['vesselValveSequence']

        # Valves Config
        with open('valves_config.json') as f_:
            self.valve_config = json.load(f_)
        self.opened_cargovalves = {}

        # other data
        self.input = input_param
        self.output = output
        self.raw_output = raw_output

    def prepOperation(self):
        self.getToppingSequence('topping')
        self.getBallastTanks()
        return

    # TODO: split valves up according to timing, pipelines info (generatlise for single segregation)
    def getLoadingValves(self):
        final_valves = {}
        for cargo in self.tanks:
            cargo_valves = {}
            for stage, info in self.valve_config['loading'].items():
                if len(info) == 0:
                    cargo_valves[stage] = info
                else:
                    stage_valves = []
                    for i in info:
                        raw_valves = self.valves['loading'][i] ### raw valve sequence from json
                        ### extract required info and valves from each sequence
                        for step in raw_valves:
                            if '0' not in step:
                                valveType = raw_valves[step][0]['valveTypeName'] ## check type of valve
                                # get valves for each type of valves in sequence
                                if 'MANIFOLD' in valveType:
                                    name = 'manifoldValves'
                                    valves = self.getManifoldValves(raw_valves[step])
                                    self.updateCargoValveStatus(valves, name)
                                elif 'CARGO PIPE LINE VALVES' == valveType:
                                    name = 'tankValves'
                                    tanks = self.getTanksForStage(stage, cargo, step)
                                    valves = self.getTankValves(tanks, raw_valves[step]) ### problem here
                                    self.updateCargoValveStatus(valves, name)
                                else:
                                    name = self.nameTankValve(valveType)
                                    valves = self.getOtherValves(raw_valves[step], name)
                                    self.updateCargoValveStatus(valves, name)
                                if len(valves) > 0:
                                    stage_valves.append([name] + valves)
                    cargo_valves[stage] = stage_valves
            final_valves[cargo] = cargo_valves
            print(cargo_valves)
            print()

        return final_valves

    def updateCargoValveStatus(self, valves, name):
        if name not in self.opened_cargovalves:
            self.opened_cargovalves[name] = []
        for valve in valves:
            if valve.startswith('O'): ## open valve
                if valve[1:] in self.opened_cargovalves[name]:
                    pass ## cannot open valve that is already opened
                else:
                    self.opened_cargovalves[name].append(valve[1:])
            else: ## close valve
                if valve[1:] in self.opened_cargovalves[name]:
                    self.opened_cargovalves[name].remove(valve[1:])
                else:
                    pass # cannot close valve thats already closed
        return


    def nameTankValve(self, raw_name):
        name = ''.join([i[0].upper() + i[1:].lower() for i in raw_name.split(' ')])
        name = name[0].lower() + name[1:]
        return name

    def getTanksForStage(self, stage, cargo, step):
        if stage == 'openSingleTank':
            tanks = self.initialTanks[cargo]
        elif stage == 'topping':
            if 'shutting' in step:
                tanks = self.lastTank[cargo]
            else:
                tanks = sum(self.toppingSequence[cargo].values(), [])
                tanks = [tank for tank in tanks if tank not in self.lastTank[cargo]]
        else:
            tanks = [tank for tank in self.tanks[cargo] if tank not in self.initialTanks[cargo]]

        newTanks = []
        for tank in tanks: ## separate wing tanks into individual tank to get individual tank valves

            if tank[-1] == 'W':
                newTanks.append(tank[:-1]+'P')
                newTanks.append(tank[:-1] + 'S')
            else:

                newTanks.append(tank)
        return newTanks


    ## Filter valves for required tank from valve sequence givenfor(valveTypeName: CARGO PIPE LINE VALVES)
    def getTankValves(self, tanks, seq):  # E.g tanks:['1W', '1C', 'SLS'], seq: sequence0/1 from vessel json
        tankValves = [] ## final set of tank valves to return
        if 'tankValves' not in self.opened_cargovalves:
            self.opened_cargovalves['tankValves'] = []
        for valve in seq: ## loop through all tank valves given and extract valves of required tank
            if valve['valveTypeName'] == 'CARGO PIPE LINE VALVES':
                valveName = valve['valveNumber']
                valveOpen = 'C' if valve['shut'] else 'O' ## C for Close, O for Open
                tankName = valve['tankShortName']
                if tankName in tanks:
                    if valveOpen == 'C':
                        if valveName in self.opened_cargovalves['tankValves']:
                            tankValves.append(valveOpen + valveName)
                    else:
                        if valveName not in self.opened_cargovalves['tankValves']:
                            tankValves.append(valveOpen + valveName)
        return tankValves

    def getManifoldValves(self,  seq): # E.g lines:[1,2,3], side = port/stbd, seq: sequence0/1 from vessel json
        lines=self.manifold
        side = self.manifoldSide
        manifoldValves = []
        if 'manifoldValves' not in self.opened_cargovalves:
            self.opened_cargovalves['manifoldValves'] = []
        for valve in seq:
            # identify corect valves
            valveline = int(valve['pipelineName'][-1])
            valveTypeName = valve['valveTypeName'].lower() #MANIFOLD GATE VALVE PORT SIDE
            if 'manifold' in valveTypeName:
                # valve info
                valveName = valve['valveNumber']
                valveOpen = 'C' if valve['shut'] else 'O'
                if (side.lower() in valveTypeName) & (valveline in lines):
                    if valveOpen == 'C':
                        if valveName in self.opened_cargovalves['manifoldValves']:
                            manifoldValves.append(valveOpen + valveName)
                    else:
                        if valveName not in self.opened_cargovalves['manifoldValves']:
                            manifoldValves.append(valveOpen + valveName)
        return manifoldValves

    def getOtherValves(self, seq, name):
        valves = []
        if name not in self.opened_cargovalves:
            self.opened_cargovalves[name] = []
        for valve in seq:
            valveOpen = 'C' if valve['shut'] else 'O'
            valveName = valve['valveNumber']
            if valveOpen == 'C':
                if valveName in self.opened_cargovalves[name]:
                    valves.append(valveOpen + valveName)
            else:
                if valveName not in self.opened_cargovalves[name]:
                    valves.append(valveOpen + valveName)
        return valves


    def getBallastTanks(self):
        output = self.output
        result = {}
        for e in output['events']:
            cargo = e['cargoNominationId']
            ballast_time = {} ## tanks being used for ballasting at each timestamp
            deballast_time = {}
            if cargo in self.tanks:
                for stages in e['sequence'][1:]: ## first stage is arrival condition
                    for substages in stages['simDeballastingRateM3_Hr']:
                        for tankId, tanks in substages.items():
                            time = tanks['timeStart']
                            tankName = tanks['tankName']
                            if time in deballast_time:
                                deballast_time[time].append([tankName, tankId])
                            else:
                                deballast_time[time] = [[tankName, tankId]]
                    for substages in stages['simBallastingRateM3_Hr']:
                        for tankId, tanks in substages.items():
                            time = tanks['timeStart']
                            tankName = tanks['tankName']
                            if time in ballast_time:
                                ballast_time[time].append([tankName, tankId])
                            else:
                                ballast_time[time] = [[tankName, tankId]]
            result[cargo] = {'ballast':ballast_time, 'deballast':deballast_time}
        self.ballastTanks = result
        return

    def getToppingSequence(self, stage = 'topping'):
        output = self.output
        topping = {}
        last = {}
        for e in output['events']:
            cargo = 'P'+str(e['cargoNominationId'])
            tank_endTime = {} ## tanks being used for ballasting at each timestamp
            if cargo in self.tanks:
                for stages in e['sequence'][1:]: ## first stage is arrival condition
                    if stages['stage'] == stage:
                        for tankId, tanks in stages['simCargoLoadingRatePerTankM3_Hr'].items():
                            time = int(tanks['timeEnd'])
                            tankName = tanks['tankName']
                            if time in tank_endTime:
                                tank_endTime[time].append(tankName)
                            else:
                                tank_endTime[time] = [tankName]

            topping[cargo] = tank_endTime
            last[cargo] = tank_endTime[max(tank_endTime.keys())]
        self.toppingSequence = topping
        self.lastTank = last
        return
