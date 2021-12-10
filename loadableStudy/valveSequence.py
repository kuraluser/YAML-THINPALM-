import json
import pandas as pd
import numpy as np


class Constants:
    def __init__(self):
        self.EVENTS = 'events'
        self.SEQUENCE = 'sequence'
        self.TIMEEND = 'timeEnd'
        self.TIMESTART = 'timeStart'
        self.SLOPDISCHARGE = 'slopDischarge'
        self.COWSTRIPPING = 'COWStripping'
        self.REDUCEDRATE = 'reducedRate'
        self.FINALSTRIPPING = 'finalStripping'
        self.START = 'start'
        self.END = 'end'
        self.MID = 'mid'
        self.RATE = 'rate'
        self.CLEANING = 'Cleaning'
        self.stages = ['stage', self.TIMESTART]
        self.SIMCARGODISCHARGE_KEY = 'simCargoDischargingRatePerTankM3_Hr'
        self.TANKSHORTNAME = 'tankShortName'
        self.TANKOPEN = 'TankOpen'
        self.TANKCLOSE = 'TankClose'
        self.OPEN = 'open'
        self.CLOSE = 'close'
        self.FULLCLEAN = 'FullClean'
        self.TANKSTRIPOPEN = 'Tso'
        self.TANKSTRIPCLOSE = 'Tsc'
        self.FILLINGUPTCP = 'FillingUpOfTCP'
        self.WARMTCP = 'WarmTCP'
        self.DRAINTCLINE = 'TCline'
        self.cow_strip_operation_time_map = {}
        self.cow_strip_operation_time_map[self.FILLINGUPTCP] = 30
        self.cow_strip_operation_time_map[self.WARMTCP] = 28
        self.final_strip_operation_time_map = {}
        self.final_strip_operation_time_map[self.DRAINTCLINE] = 40
        self.TANKOPEN_TIMELINE = 32
        self.ops_arr = ['floodSeparator', 'warmPumps', 'initialRate', 'FillingUpOfTCP', 'WarmTCP', 'COWStripping',
                        'COWStripping_end',
                        'dryCheck', 'slopDischarge_start', 'slopDischarge_end', 'slopDischarge_mid', 'finalStripping',
                        'TCline', 'finalStripping_end']
        self.ops_abbr_dict = {}
        self.ops_abbr_dict['floodSeparator'] = 'FS'
        self.ops_abbr_dict['warmPumps'] = 'WP'
        self.ops_abbr_dict['initialRate'] = 'PCOP'
        self.ops_abbr_dict['FillingUpOfTCP'] = 'FTCP'
        self.ops_abbr_dict['WarmTCP'] = 'WTCP'
        self.ops_abbr_dict['COWStripping'] = 'COWS'
        self.ops_abbr_dict['COWStripping_end'] = 'COWE'
        self.ops_abbr_dict['dryCheck'] = 'DC'
        self.ops_abbr_dict['slopDischarge_start'] = 'SDstart'
        self.ops_abbr_dict['slopDischarge_end'] = 'SDend'
        self.ops_abbr_dict['slopDischarge_mid'] = 'SDmid'
        self.ops_abbr_dict['finalStripping'] = 'FStrip'
        self.ops_abbr_dict['TCline'] = 'FStripmid'
        self.ops_abbr_dict['finalStripping_end'] = 'FStripend'
        self.START_OPERATIONS = ['COWS', 'SDstart', 'FStrip', 'FStripmid']
        self.END_OPERATIONS = ['COWE', 'SDend', 'FStripend']

        # valve category name
        self.BALLAST_TANK_NAME = 'BALLLAST VALVES'
        self.BALLAST_PUMP_NAME = 'Ballast Pump'
        self.CARGO_TANK_NAME = 'CARGO PIPE LINE VALVES'
        self.MANIFOLD_NAME = 'MANIFOLD GATE VALVE'
        self.BALLAST_STRIP_TANK_NAME = "STRIPPER SUCTION VALVE"
        self.BALLAST_EDUCTOR_NAME = ["EDUCTOR DRIVE VALVE", "EDUCTOR SUCTION VALVE", "EDUCTOR DISCHARGE VALVE"]
        # Parameters
        self.BALLAST_TANKS = ['LFPT', 'WB1P', 'WB1S', 'WB2P', 'WB2S', 'WB3P', 'WB3S', 'WB4P', 'WB4S', 'WB5P', 'WB5S']
        self.BALLAST_MAP = {'pump': {"4": 'BP1', "5": 'BP2'},
                            'eductor': {"10": 'Ballast Eductor 1', "11": 'Ballast Eductor 2'}}

        # valve variable/operation
        self.VALVE_TYPE_VARIABLE = 'valveTypeName'
        self.PUMP_TYPE_VARIABLE = 'pumpType'
        self.VALVE_OP_VARIABLE = 'operation'
        self.VALVE_NAME_VARIABLE = 'valveNumber'
        self.PUMP_NAME_VARIABLE = 'pumpCode'
        self.MANIFOLD_NAME_VARIABLE = 'manifoldName'
        self.MANIFOLD_SIDE_VARIABLE = 'manifoldSide'
        self.VALVE = 'valve'
        self.PUMP = 'pump'
        self.EDUCTOR = 'eductor'
        self.RATEM3 = 'rateM3_Hr'
        self.TANK = 'tank'
        self.STAGE = 'stage'
        self.SHUT = 'shut'
        self.GRAVITY = 'Gravity'
        self.CARGO = 'Cargo'
        self.LOADINGINFO = "loadingInformation"
        self.MACHINERYINUSES = "machineryInUses"
        self.LOADINGMACHINEINUSES = "loadingMachinesInUses"
        self.MACHINETYPENAME = "machineTypeName"
        self.MACHINENAME = "machineName"
        self.TANKTYPENAME = "tankTypeName"
        self.MANIFOLD = "MANIFOLD"

        # cargo stages/sequences
        self.INITIAL = 'initialCondition'
        self.OPENSINGLETANK = 'openSingleTank'
        self.INITIALRATE = 'initialRate'
        self.OPENALLTANKS = 'openAllTanks'
        self.INCREASETOMAXRATE = 'increaseToMaxRate'
        self.LOADINGATMAXRATE = 'loadingAtMaxRate'
        self.TOPPING = 'topping'
        self.LOADING_STAGES = [self.INITIAL, self.OPENSINGLETANK, self.INITIALRATE, self.OPENALLTANKS,
                               self.INCREASETOMAXRATE,
                               self.LOADINGATMAXRATE, self.TOPPING]

        # valve sequences
        self.BALLAST_GRAVITY = 'ballastingByGravity'
        self.BALLAST_FLOOD = 'floodingOfBallastPumpBeforeBallasting'
        self.BALLAST_PUMP_GRAVITY = 'ballastingByPumpsAfterGravity'
        self.BALLAST_PUMP = 'startingOfBallastingByPumpsWhenNoGravity'
        self.BALLAST_STS = 'seaToSea'
        self.BALLAST_SHUT = 'shuttingSequence'
        self.BALLAST_TANK_OPEN = 'openBallastTank'
        self.BALLAST_TANK_CLOSE = 'closeBallastTank'
        self.BALLAST_PUMP_OPEN = 'openBallastPump'
        self.BALLAST_PUMP_CLOSE = 'closeBallastPump'
        self.BALLAST_OPS = 'ballast'

        self.DEBALLAST_GRAVITY = 'startOfDeballasingByGravity'
        self.DEBALLAST_FLOOD = 'floodingTheBallastPump'
        self.DEBALLAST_PUMP_GRAVITY = 'debalastingByPumpAfterGravity'
        self.DEBALLAST_PUMP = 'startingOfDeballastingByPumpsWhenNoGravity'
        self.DEBALLAST_STSP = 'seaToSea'
        self.DEBALLAST_EDUCTOR = 'strippingByEductor'
        self.DEBALLAST_STSE = 'seaTosea'
        self.DEBALLAST_SHUT = 'shuttingSequence'
        self.DEBALLAST_OPS = 'deballast'

        self.LOADING_SINGLE = 'startOfLoading'
        self.LOADING_ALL = 'fullLoadingRate'
        self.LOADING_TOPPING = 'toppingOff'
        self.LOADING_SHUT = 'shuttingSequence'
        self.CARGO_TANK_OPEN = 'openCargoTank'
        self.CARGO_TANK_CLOSE = 'closeCargoTank'
        self.LOADING_OPS = 'loading'

        # ATTRIBUTE NAME IN FINAL JSON
        self.VALVES_JSON = 'valves'
        self.TIME_JSON = 'time'
        self.OP_JSON = 'operation'

        self.SIMCARGOLOADING_KEY = "simCargoLoadingRatePerTankM3_Hr"
        self.SIMBALLASTING_KEY = "simBallastingRateM3_Hr"
        self.SIMDEBALLASTING_KEY = "simDeballastingRateM3_Hr"
        self.BALLAST_KEY = 'ballast'
        self.EDUCTION_KEY = 'eduction'
        self.PUMP_VARIABLE = 'pumpSelected'
        self.BALLASTPUMP_VARIABLE = 'ballastPumpSelected'
        self.PUMPNAME_VARIABLE = 'pumpName'

        self.ops_abbr_dict['ballast'] = {}
        self.ops_abbr_dict['ballast']['ballastingByGravity'] = 'BG'
        self.ops_abbr_dict['ballast']['floodingOfBallastPumpBeforeBallasting'] = 'FBP'
        self.ops_abbr_dict['ballast']['ballastingByPumpsAfterGravity'] = 'BPG'
        self.ops_abbr_dict['ballast']['startingOfBallastingByPumpsWhenNoGravity'] = 'BPWG'
        self.ops_abbr_dict['ballast']['seaToSea'] = 'STSP'
        self.ops_abbr_dict['ballast']['shuttingSequence'] = 'SB'
        self.ops_abbr_dict['ballast']['openBallastTank'] = 'WBTO'
        self.ops_abbr_dict['ballast']['closeBallastTank'] = 'WBTC'
        self.ops_abbr_dict['ballast']['openBallastPump'] = 'BPO'
        self.ops_abbr_dict['ballast']['closeBallastPump'] = 'BPC'

        self.ops_abbr_dict['deballast'] = {}
        self.ops_abbr_dict['deballast']['startOfDeballasingByGravity'] = 'DG'
        self.ops_abbr_dict['deballast']['floodingTheBallastPump'] = 'DFBP'
        self.ops_abbr_dict['deballast']['debalastingByPumpAfterGravity'] = 'DPG'
        self.ops_abbr_dict['deballast']['startingOfDeballastingByPumpsWhenNoGravity'] = 'DPWG'
        self.ops_abbr_dict['deballast']['seaToSea'] = 'DSTSP'
        self.ops_abbr_dict['deballast']['strippingByEductor'] = 'DSE'
        self.ops_abbr_dict['deballast']['seaTosea'] = 'STSE'
        self.ops_abbr_dict['deballast']['shuttingSequence'] = 'SD'
        self.ops_abbr_dict['deballast']['openBallastTank'] = 'WBTO'
        self.ops_abbr_dict['deballast']['closeBallastTank'] = 'WBTC'
        self.ops_abbr_dict['deballast']['openBallastPump'] = 'BPO'
        self.ops_abbr_dict['deballast']['closeBallastPump'] = 'BPC'

        self.ops_abbr_dict['loading'] = {}
        self.ops_abbr_dict['loading']['startOfLoading'] = 'OST'
        self.ops_abbr_dict['loading']['fullLoadingRate'] = 'OAT'
        self.ops_abbr_dict['loading']['shuttingSequence'] = 'SL'
        self.ops_abbr_dict['loading']['openCargoTank'] = 'CTO'
        self.ops_abbr_dict['loading']['closeCargoTank'] = 'CTC'


# Valve filter class to filter valves of a particular type
class ValveFilters:
    def __init__(self, constants):
        self.constants = constants

    # Filter for generic valves with no specific requirements
    def no_filter(self, valve_seq, seqno):
        valves = []
        for valve in valve_seq:
            valveName = valve[self.constants.VALVE_NAME_VARIABLE]
            valveOpen = self.constants.CLOSE if valve[
                self.constants.SHUT] else self.constants.OPEN  # close or open valve
            value = {self.constants.VALVE: valveName, self.constants.VALVE_OP_VARIABLE: valveOpen}
            valves.append(value)
        return valves

    # Filter for ballast pump valves for specifc pumps
    def ballast_pump_filter(self, valve_seq, pumps, seqno):
        pumpValves = []
        for valve in valve_seq:
            valveName = valve[self.constants.PUMP_NAME_VARIABLE]
            valveOpen = self.constants.CLOSE if valve[
                self.constants.SHUT] else self.constants.OPEN  # close or open pump
            if valveName in pumps:  # filter for specific pumps
                value = {self.constants.VALVE: valveName, self.constants.VALVE_OP_VARIABLE: valveOpen}
                pumpValves.append(value)
        return pumpValves

    # Filter for ballast tank valves for specifc tanks
    def ballast_tank_filter(self, valve_seq, tanks, seqno):
        tankValves = []
        for valve in valve_seq:
            valveName = valve[self.constants.VALVE_NAME_VARIABLE]
            valveOpen = self.constants.CLOSE if valve[
                self.constants.SHUT] else self.constants.OPEN  # close or open tank
            tankName = valve[self.constants.TANKSHORTNAME]
            if tankName in tanks:  # filter for specific tanks
                value = {self.constants.VALVE: valveName, self.constants.TANK: tankName,
                         self.constants.VALVE_OP_VARIABLE: valveOpen}
                tankValves.append(value)
        return tankValves

    # Filter for deballast strip tank valves for specifc tanks
    def ballast_strip_tank_filter(self, valve_seq, tanks, seqno):
        stripTankValves = []
        for valve in valve_seq:
            valveName = valve[self.constants.VALVE_NAME_VARIABLE]
            valveOpen = self.constants.CLOSE if valve[
                self.constants.SHUT] else self.constants.OPEN  # close or open tank
            tankName = valve[self.constants.TANKSHORTNAME]
            if tankName in tanks:  # filter for specific tanks
                value = {self.constants.VALVE: valveName, self.constants.TANK: tankName,
                         self.constants.VALVE_OP_VARIABLE: valveOpen}
                stripTankValves.append(value)
        return stripTankValves

    # Filter for deballast eductor related valves for specifc tanks
    def ballast_eductor_filter(self, valve_seq, eductor, seqno):
        eductorValves = []
        for valve in valve_seq:
            valveName = valve[self.constants.VALVE_NAME_VARIABLE]
            valveOpen = self.constants.CLOSE if valve[
                self.constants.SHUT] else self.constants.OPEN  # close or open tank
            eductorCheck = sum(
                [str(i) in valveName for i in eductor])  # If valve corresponds to any of the ballast eductor being used
            if eductorCheck:
                value = {self.constants.VALVE: valveName, self.constants.VALVE_OP_VARIABLE: valveOpen}
                eductorValves.append(value)
        return eductorValves

    # Filter for cargo tank valves for specifc tanks
    def cargo_tank_filter(self, valve_seq, tanks, seqno):
        tankValves = []
        for valve in valve_seq:
            valveName = valve[self.constants.VALVE_NAME_VARIABLE]
            valveOpen = self.constants.CLOSE if valve[
                self.constants.SHUT] else self.constants.OPEN  # close or open tank
            tankName = valve[self.constants.TANKSHORTNAME]
            if tankName in tanks:  # filter for specific tanks
                value = {self.constants.VALVE: valveName, self.constants.TANK: tankName,
                         self.constants.VALVE_OP_VARIABLE: valveOpen}
                tankValves.append(value)
        return tankValves

    # Filter for manifold valves for specifc pipelines and side(port/stbd)
    def manifold_filter(self, valve_seq, pipelines, side, seqno):
        tankValves = []
        for valve in valve_seq:
            valveName = valve[self.constants.VALVE_NAME_VARIABLE]
            valveOpen = self.constants.CLOSE if valve[
                self.constants.SHUT] else self.constants.OPEN  # close or open tank
            lineCheck = sum([str(i) in valve[self.constants.MANIFOLD_NAME_VARIABLE] for i in
                             pipelines]) > 0  # If valve corresponds to any of the manifold pipeline connection
            sideCheck = (
                        side.lower() in valve[self.constants.MANIFOLD_SIDE_VARIABLE].lower())  # port/stbd side manifold
            if sideCheck & lineCheck:
                value = {self.constants.VALVE: valveName, self.constants.VALVE_OP_VARIABLE: valveOpen}
                tankValves.append(value)
        return tankValves


class ValveOperations:
    def __init__(self, filters, vessel_json, constants):
        self.vfilters = filters
        self.constants = constants
        self.vessel_json = vessel_json

        # Operations
        self.key_operation_mapping = {}
        # BALLAST
        ops = self.constants.ops_abbr_dict[self.constants.BALLAST_OPS]
        self.key_operation_mapping[ops[self.constants.BALLAST_GRAVITY]] = self.ballast_gravity_operation
        self.key_operation_mapping[ops[self.constants.BALLAST_FLOOD]] = self.ballast_flood_pump_operation
        self.key_operation_mapping[ops[self.constants.BALLAST_PUMP_GRAVITY]] = self.ballast_pump_after_gravity_operation
        self.key_operation_mapping[ops[self.constants.BALLAST_PUMP]] = self.ballast_pump_wo_gravity_operation
        self.key_operation_mapping[ops[self.constants.BALLAST_STS]] = self.sea_to_sea_pump_operation
        self.key_operation_mapping[ops[self.constants.BALLAST_SHUT]] = self.ballast_shut_operation
        # BALLAST/DEBALLAST
        self.key_operation_mapping[ops[self.constants.BALLAST_TANK_OPEN]] = self.WBT_open_operation
        self.key_operation_mapping[ops[self.constants.BALLAST_TANK_CLOSE]] = self.WBT_close_operation
        self.key_operation_mapping[ops[self.constants.BALLAST_PUMP_OPEN]] = self.BP_open_operation
        self.key_operation_mapping[ops[self.constants.BALLAST_PUMP_CLOSE]] = self.BP_close_operation
        # DEBALLAST
        ops = self.constants.ops_abbr_dict[self.constants.DEBALLAST_OPS]
        self.key_operation_mapping[ops[self.constants.DEBALLAST_GRAVITY]] = self.deballast_gravity_operation
        self.key_operation_mapping[ops[self.constants.DEBALLAST_FLOOD]] = self.deballast_flood_pump_operation
        self.key_operation_mapping[
            ops[self.constants.DEBALLAST_PUMP_GRAVITY]] = self.deballast_pump_after_gravity_operation
        self.key_operation_mapping[ops[self.constants.DEBALLAST_PUMP]] = self.deballast_pump_wo_gravity_operation
        self.key_operation_mapping[ops[self.constants.DEBALLAST_STSP]] = self.deballast_sea_to_sea_pump_operation
        self.key_operation_mapping[ops[self.constants.DEBALLAST_EDUCTOR]] = self.deballast_stripping_eductor_operation
        self.key_operation_mapping[ops[self.constants.DEBALLAST_STSE]] = self.deballast_sea_to_sea_eductor_operation
        self.key_operation_mapping[ops[self.constants.DEBALLAST_SHUT]] = self.deballast_shut_operation
        # LOADING
        ops = self.constants.ops_abbr_dict[self.constants.LOADING_OPS]
        self.key_operation_mapping[ops[self.constants.LOADING_SINGLE]] = self.open_single_tank_operation
        self.key_operation_mapping[ops[self.constants.LOADING_ALL]] = self.open_all_tank_operation
        self.key_operation_mapping[ops[self.constants.CARGO_TANK_OPEN]] = self.CT_open_operation
        self.key_operation_mapping[ops[self.constants.CARGO_TANK_CLOSE]] = self.CT_close_operation
        self.key_operation_mapping[ops[self.constants.LOADING_SHUT]] = self.shutting_loading_operation
        self.valves = self.vessel_json['vessel']['vesselValveSequence']

        # BALLAST
        self.ballast_gravity = self.valves[self.constants.BALLAST_OPS][self.constants.BALLAST_GRAVITY]
        self.ballast_flood_pump = self.valves[self.constants.BALLAST_OPS][self.constants.BALLAST_FLOOD]
        self.ballast_pump_after_gravity = self.valves[self.constants.BALLAST_OPS][self.constants.BALLAST_PUMP_GRAVITY]
        self.ballast_pump_wo_gravity = self.valves[self.constants.BALLAST_OPS][self.constants.BALLAST_PUMP]
        self.sea_to_sea_pump = self.valves[self.constants.BALLAST_OPS][self.constants.BALLAST_STS]
        self.ballast_shut = self.valves[self.constants.BALLAST_OPS][self.constants.BALLAST_SHUT]
        # BALLAST/DEBALLAST
        self.WBT_open = self.extractBallastTankValves(self.ballast_gravity)
        self.WBT_close = self.extractBallastTankValves(self.ballast_gravity)
        self.BP_open = self.extractBallastPumpValves(self.ballast_pump_after_gravity)
        self.BP_close = self.extractBallastPumpValves(self.ballast_pump_after_gravity)
        # DEBALLAST
        self.deballast_gravity = self.valves[self.constants.DEBALLAST_OPS][self.constants.DEBALLAST_GRAVITY]
        self.deballast_flood_pump = self.valves[self.constants.DEBALLAST_OPS][self.constants.DEBALLAST_FLOOD]
        self.deballast_pump_after_gravity = self.valves[self.constants.DEBALLAST_OPS][
            self.constants.DEBALLAST_PUMP_GRAVITY]
        self.deballast_pump_wo_gravity = self.valves[self.constants.DEBALLAST_OPS][self.constants.DEBALLAST_PUMP]
        self.deballast_sea_to_sea_pump = self.valves[self.constants.DEBALLAST_OPS][self.constants.DEBALLAST_STSP]
        self.deballast_stripping_eductor = self.valves[self.constants.DEBALLAST_OPS][self.constants.DEBALLAST_EDUCTOR]
        self.deballast_sea_to_sea_eductor = self.valves[self.constants.DEBALLAST_OPS][self.constants.DEBALLAST_STSE]
        self.deballast_shut = self.valves[self.constants.DEBALLAST_OPS][self.constants.DEBALLAST_SHUT]
        # LOADING
        self.open_single_tank = self.valves[self.constants.LOADING_OPS][self.constants.LOADING_SINGLE]
        self.open_all_tank = self.valves[self.constants.LOADING_OPS][self.constants.LOADING_ALL]
        self.CT_open = self.valves[self.constants.LOADING_OPS][self.constants.LOADING_TOPPING]
        self.CT_close = self.valves[self.constants.LOADING_OPS][self.constants.LOADING_TOPPING]
        self.shutting_loading = self.valves[self.constants.LOADING_OPS][self.constants.LOADING_SHUT]

    # Get ballast tank valve sequence given a dictionary of different sequences
    def extractBallastTankValves(self, sequence):
        tank_valves = {idx: seq for idx, seq in sequence.items() if
                       seq[0][self.constants.VALVE_TYPE_VARIABLE] == self.constants.BALLAST_TANK_NAME}
        return tank_valves

    # Get ballast pump valve sequence given a dictionary of different sequences
    def extractBallastPumpValves(self, sequence):
        pump_valves = {idx: seq for idx, seq in sequence.items() if
                       seq[0][self.constants.PUMP_TYPE_VARIABLE] == self.constants.BALLAST_PUMP_NAME}
        return pump_valves

    # Get cargo tank valve sequence given a dictionary of different sequences
    def extractCargoTankValves(self, sequence):
        tank_valves = {idx: seq for idx, seq in sequence.items() if
                       seq[0][self.constants.VALVE_TYPE_VARIABLE] == self.constants.CARGO_TANK_NAME}
        return tank_valves

    def getManifoldParameters(self, json):
        lines = []
        side = ''
        machines = json[self.constants.LOADINGINFO][self.constants.MACHINERYINUSES][self.constants.LOADINGMACHINEINUSES]
        for i in machines:
            if i[self.constants.MACHINETYPENAME] == self.constants.MANIFOLD:
                lines.append(int(i[self.constants.MACHINENAME][-1]))
                side = i[self.constants.TANKTYPENAME]
        self.MANIFOLD = lines
        self.SIDE = side

    ###### BALLAST ######

    # Ballasting by gravity operation with tank valves filters
    def ballast_gravity_operation(self, time, time_dict):
        tank_filter = self.vfilters.ballast_tank_filter
        no_filter = self.vfilters.no_filter

        operation_valves = []
        for idx, seq in self.ballast_gravity.items():  # loop through sequence and get filtered valves
            count = int(idx.split('_')[1])
            if seq[0][self.constants.VALVE_TYPE_VARIABLE] == self.constants.BALLAST_TANK_NAME:
                tanks = time_dict[time][self.constants.OPEN]
                valves = tank_filter(seq, tanks, count)  # ballast tank filter
            else:
                valves = no_filter(seq, count)  # no filter, take all valves
            operation_valves += valves
        return operation_valves

    # Flooding ballast pump operation for ballasting with no filters
    def ballast_flood_pump_operation(self, time, time_dict):
        no_filter = self.vfilters.no_filter

        operation_valves = []
        for idx, seq in self.ballast_flood_pump.items():  # loop through sequence and get filtered valves
            count = int(idx.split('_')[1])
            valves = no_filter(seq, count)  # no filter, take all valves
            operation_valves += valves
        return operation_valves

    # ballasting by pump after gravity with pump filters
    def ballast_pump_after_gravity_operation(self, time, time_dict):
        pump_filter = self.vfilters.ballast_pump_filter
        no_filter = self.vfilters.no_filter

        operation_valves = []
        for idx, seq in self.ballast_pump_after_gravity.items():  # loop through sequence and get filtered valves
            count = int(idx.split('_')[1])
            if seq[0][self.constants.PUMP_TYPE_VARIABLE] == self.constants.BALLAST_PUMP_NAME:
                pumps = [i for i in time_dict[time][self.constants.OPEN] if
                         i in self.constants.BALLAST_MAP[self.constants.PUMP].values()]
                valves = pump_filter(seq, pumps, count)  # ballast pump fiter
            else:
                valves = no_filter(seq, count)  # no filter, take all valves
            operation_valves += valves
        return operation_valves

    # ballasting by pump without gravity with pump filters
    def ballast_pump_wo_gravity_operation(self, time, time_dict):
        pump_filter = self.vfilters.ballast_pump_filter
        tank_filter = self.vfilters.ballast_tank_filter
        no_filter = self.vfilters.no_filter

        operation_valves = []
        for idx, seq in self.ballast_pump_wo_gravity.items():  # loop through sequence and get filtered valves
            count = int(idx.split('_')[1])
            if seq[0][self.constants.VALVE_TYPE_VARIABLE] == self.constants.BALLAST_TANK_NAME:
                tanks = time_dict[time][self.constants.OPEN]
                valves = tank_filter(seq, tanks, count)  # ballast tank filter
            elif seq[0][self.constants.PUMP_TYPE_VARIABLE] == self.constants.BALLAST_PUMP_NAME:
                pumps = [i for i in time_dict[time][self.constants.OPEN] if
                         i in self.constants.BALLAST_MAP[self.constants.PUMP].values()]
                valves = pump_filter(seq, pumps, count)  # ballast pump filter
            else:
                valves = no_filter(seq, count)  # no filter, take all valves
            operation_valves += valves
        return operation_valves

    # ballasting sea to sea operation for pumps with pump filters
    def sea_to_sea_pump_operation(self, time, time_dict):
        tank_filter = self.vfilters.ballast_tank_filter
        no_filter = self.vfilters.no_filter

        operation_valves = []
        for idx, seq in self.sea_to_sea_pump.items():  # loop through sequence and get filtered valves
            count = int(idx.split('_')[1])
            if seq[0][self.constants.VALVE_TYPE_VARIABLE] == self.constants.BALLAST_TANK_NAME:
                tanks = time_dict[time][self.constants.CLOSE]
                valves = tank_filter(seq, tanks, count)  # ballast tank filter
            else:
                valves = no_filter(seq, count)  # no filter, take all valves
            operation_valves += valves
        return operation_valves

    # ballasting shutting operation with pump filters
    def ballast_shut_operation(self, time, time_dict):
        pump_filter = self.vfilters.ballast_pump_filter
        no_filter = self.vfilters.no_filter

        operation_valves = []
        for idx, seq in self.ballast_shut.items():  # loop through sequence and get filtered valves
            count = int(idx.split('_')[1])
            if seq[0][self.constants.PUMP_TYPE_VARIABLE] == self.constants.BALLAST_PUMP_NAME:
                pumps = [i for i in time_dict[time][self.constants.OPEN] if
                         i in self.constants.BALLAST_MAP[self.constants.PUMP].values()]
                valves = pump_filter(seq, pumps, count)  # ballast pump filter
            else:
                valves = no_filter(seq, count)  # no filter, take all valves
            operation_valves += valves
        return operation_valves

    ###### DEBALLAST/BALLAST ######

    # water ballast tank opening operation with tank filters
    def WBT_open_operation(self, time, time_dict):
        tank_filter = self.vfilters.ballast_tank_filter

        operation_valves = []
        for idx, seq in self.WBT_open.items():
            count = -1
            if seq[0][self.constants.VALVE_TYPE_VARIABLE] == self.constants.BALLAST_TANK_NAME:
                tanks = time_dict[time][self.constants.OPEN]
                valves = tank_filter(seq, tanks, count)  # ballast tank filter
                for v in valves:
                    v[
                        self.constants.VALVE_OP_VARIABLE] = self.constants.OPEN  # ensure all ballast tank valve operation is open
                operation_valves += valves
        return operation_valves

    # water ballast tank closing operation with tank filters
    def WBT_close_operation(self, time, time_dict):
        tank_filter = self.vfilters.ballast_tank_filter

        operation_valves = []
        for idx, seq in self.WBT_close.items():
            count = -1
            if seq[0][self.constants.VALVE_TYPE_VARIABLE] == self.constants.BALLAST_TANK_NAME:
                tanks = time_dict[time][self.constants.CLOSE]
                valves = tank_filter(seq, tanks, count)  # ballast tank filter
                for v in valves:
                    v[
                        self.constants.VALVE_OP_VARIABLE] = self.constants.CLOSE  # ensure all ballast tank valve operation is close
                operation_valves += valves
        return operation_valves

    # ballast pump opening operation with pump filters
    def BP_open_operation(self, time, time_dict):
        pump_filter = self.vfilters.ballast_pump_filter

        operation_valves = []
        for idx, seq in self.BP_open.items():
            count = -1
            if seq[0][self.constants.PUMP_TYPE_VARIABLE] == self.constants.BALLAST_PUMP_NAME:
                pumps = [i for i in time_dict[time][self.constants.OPEN] if
                         i in self.constants.BALLAST_MAP[self.constants.PUMP].values()]
                valves = pump_filter(seq, pumps, count)  # ballast pump filter
                for v in valves:
                    v[
                        self.constants.VALVE_OP_VARIABLE] = self.constants.OPEN  # ensure all ballast pump valve operation is open
                operation_valves += valves
        return operation_valves

    # ballast pump closing operation with pump filters
    def BP_close_operation(self, time, time_dict):
        pump_filter = self.vfilters.ballast_pump_filter

        operation_valves = []
        for idx, seq in self.BP_close.items():
            count = -1
            if seq[0][self.constants.VALVE_TYPE_VARIABLE] == self.constants.BALLAST_PUMP_NAME:
                pumps = [i for i in time_dict[time][self.constants.OPEN] if
                         i in self.constants.BALLAST_MAP[self.constants.PUMP].values()]
                valves = pump_filter(seq, pumps, count)  # ballast pump filter
                for v in valves:
                    v[
                        self.constants.VALVE_OP_VARIABLE] = self.constants.CLOSE  # ensure all ballast pump valve operation is close
                operation_valves += valves
        return operation_valves

    ###### DEBALLAST ######

    # Deballasting by gravity operation with tank valves filters
    def deballast_gravity_operation(self, time, time_dict):
        tank_filter = self.vfilters.ballast_tank_filter
        no_filter = self.vfilters.no_filter

        operation_valves = []
        for idx, seq in self.deballast_gravity.items():  # loop through sequence and get filtered valves
            count = int(idx.split('_')[1])
            if seq[0][self.constants.VALVE_TYPE_VARIABLE] == self.constants.BALLAST_TANK_NAME:
                tanks = time_dict[time][self.constants.OPEN]
                valves = tank_filter(seq, tanks, count)  # ballast tank filter
            else:
                valves = no_filter(seq, count)
            operation_valves += valves
        return operation_valves

    # Flooding ballast pump operation for deballasting with no filters
    def deballast_flood_pump_operation(self, time, time_dict):
        no_filter = self.vfilters.no_filter

        operation_valves = []
        for idx, seq in self.deballast_flood_pump.items():  # loop through sequence and get filtered valves
            count = int(idx.split('_')[1])
            valves = no_filter(seq, count)  # no filter, take all valves
            operation_valves += valves
        return operation_valves

    # deballasting by pump after gravity with pump filters
    def deballast_pump_after_gravity_operation(self, time, time_dict):
        pump_filter = self.vfilters.ballast_pump_filter
        no_filter = self.vfilters.no_filter

        operation_valves = []
        for idx, seq in self.deballast_pump_after_gravity.items():  # loop through sequence and get filtered valves
            count = int(idx.split('_')[1])
            if seq[0][self.constants.PUMP_TYPE_VARIABLE] == self.constants.BALLAST_PUMP_NAME:
                pumps = [i for i in time_dict[time][self.constants.OPEN] if
                         i in self.constants.BALLAST_MAP[self.constants.PUMP].values()]
                valves = pump_filter(seq, pumps, count)  # ballast pump filter
            else:
                valves = no_filter(seq, count)  # no filter, take all valves
            operation_valves += valves
        return operation_valves

    # deballasting by pump without gravity with pump filters
    def deballast_pump_wo_gravity_operation(self, time, time_dict):
        pump_filter = self.vfilters.ballast_pump_filter
        tank_filter = self.vfilters.ballast_tank_filter
        no_filter = self.vfilters.no_filter

        operation_valves = []
        for idx, seq in self.deballast_pump_wo_gravity.items():  # loop through sequence and get filtered valves
            count = int(idx.split('_')[1])
            if seq[0][self.constants.VALVE_TYPE_VARIABLE] == self.constants.BALLAST_TANK_NAME:
                tanks = time_dict[time][self.constants.OPEN]
                valves = tank_filter(seq, tanks, count)  # ballast tank filter
            elif seq[0][self.constants.PUMP_TYPE_VARIABLE] == self.constants.BALLAST_PUMP_NAME:
                pumps = [i for i in time_dict[time][self.constants.OPEN] if
                         i in self.constants.BALLAST_MAP[self.constants.PUMP].values()]
                valves = pump_filter(seq, pumps, count)  # ballast pump filter
            else:
                valves = no_filter(seq, count)  # no filter, take all valves
            operation_valves += valves
        return operation_valves

    # deballasting sea to sea operation for pumps with pump filters
    def deballast_sea_to_sea_pump_operation(self, time, time_dict):
        tank_filter = self.vfilters.ballast_tank_filter
        no_filter = self.vfilters.no_filter

        operation_valves = []
        for idx, seq in self.deballast_sea_to_sea_pump.items():  # loop through sequence and get filtered valves
            count = int(idx.split('_')[1])
            if seq[0][self.constants.VALVE_TYPE_VARIABLE] == self.constants.BALLAST_TANK_NAME:
                tanks = time_dict[time][self.constants.CLOSE]
                valves = tank_filter(seq, tanks, count)  # ballast tank filter
            else:
                valves = no_filter(seq, count)  # no filter, take all valves
            operation_valves += valves
        return operation_valves

    # deballasting sea to sea operation for eductor with tank strip and eductor filters
    def deballast_sea_to_sea_eductor_operation(self, time, time_dict):
        ballast_eductor_filter = self.vfilters.ballast_eductor_filter
        strip_tank_filter = self.vfilters.ballast_strip_tank_filter
        no_filter = self.vfilters.no_filter

        operation_valves = []
        for idx, seq in self.deballast_sea_to_sea_eductor.items():  # loop through sequence and get filtered valves
            count = int(idx.split('_')[1])
            if seq[0][self.constants.VALVE_TYPE_VARIABLE] == self.constants.BALLAST_STRIP_TANK_NAME:
                tanks = time_dict[time][self.constants.CLOSE]
                valves = strip_tank_filter(seq, tanks, count)  # ballast strip tank filter
            elif seq[0][self.constants.VALVE_TYPE_VARIABLE] in self.constants.BALLAST_EDUCTOR_NAME:
                eductor = [i[-1] for i in time_dict[time][self.constants.CLOSE] if
                           i in self.constants.BALLAST_MAP[self.constants.EDUCTOR].values()]
                valves = ballast_eductor_filter(seq, eductor, count)  # ballast eductor related filter
            else:
                valves = no_filter(seq, count)  # no filter, take all valves
            operation_valves += valves
        return operation_valves

    # deballasting stripping by eductor with tank strip and eductor filters
    def deballast_stripping_eductor_operation(self, time, time_dict):
        ballast_eductor_filter = self.vfilters.ballast_eductor_filter
        strip_tank_filter = self.vfilters.ballast_strip_tank_filter
        no_filter = self.vfilters.no_filter

        operation_valves = []
        for idx, seq in self.deballast_stripping_eductor.items():  # loop through sequence and get filtered valves
            count = int(idx.split('_')[1])
            if seq[0][self.constants.VALVE_TYPE_VARIABLE] == self.constants.BALLAST_STRIP_TANK_NAME:
                tanks = time_dict[time][self.constants.CLOSE]
                valves = strip_tank_filter(seq, tanks, count)  # ballast strip tank filter
            elif seq[0][self.constants.VALVE_TYPE_VARIABLE] in self.constants.BALLAST_EDUCTOR_NAME:
                eductor = [i[-1] for i in time_dict[time][self.constants.OPEN] if
                           i in self.constants.BALLAST_MAP[self.constants.EDUCTOR].values()]
                valves = ballast_eductor_filter(seq, eductor, count)  # ballast eductor related filter
            else:
                valves = no_filter(seq, count)  # no filter, take all valves
            operation_valves += valves
        return operation_valves

    # deballasting shutting operation with pump filters
    def deballast_shut_operation(self, time, time_dict):
        pump_filter = self.vfilters.ballast_pump_filter
        no_filter = self.vfilters.no_filter

        operation_valves = []
        for idx, seq in self.deballast_shut.items():
            count = int(idx.split('_')[1])
            if seq[0][self.constants.PUMP_TYPE_VARIABLE] == self.constants.BALLAST_PUMP_NAME:
                pumps = [i for i in time_dict[time][self.constants.OPEN] if
                         i in self.constants.BALLAST_MAP[self.constants.PUMP].values()]
                valves = pump_filter(seq, pumps, count)  # ballast pump filter
            else:
                valves = no_filter(seq, count)  # no filter, take all valves
            operation_valves += valves
        return operation_valves

        ###### LOADING ######

    # Open single tank operation for loading with tank and manifold filter
    def open_single_tank_operation(self, time, time_dict):
        tank_filter = self.vfilters.cargo_tank_filter
        manifold_filter = self.vfilters.manifold_filter
        no_filter = self.vfilters.no_filter

        operation_valves = []
        for idx, seq in list(self.open_single_tank.items())[
                        :-1]:  # last item in sequence is a repeat of 1st item so ignore
            count = int(idx.split('_')[1])
            if seq[0][self.constants.VALVE_TYPE_VARIABLE] == self.constants.CARGO_TANK_NAME:
                tanks = time_dict[time][self.constants.OPEN]
                valves = tank_filter(seq, tanks, count)  # cargo tank filter
            elif self.constants.MANIFOLD_NAME in seq[0][self.constants.VALVE_TYPE_VARIABLE]:
                valves = manifold_filter(seq, self.MANIFOLD, self.SIDE, count)  # cargo manifold filter
            else:
                valves = no_filter(seq, count)  # no filter, take all valves
            operation_valves += valves
        return operation_valves

    # Open all tank operations for loading with tank filter
    def open_all_tank_operation(self, time, time_dict):
        tank_filter = self.vfilters.cargo_tank_filter
        no_filter = self.vfilters.no_filter

        operation_valves = []
        for idx, seq in self.open_all_tank.items():
            count = int(idx.split('_')[1])
            if seq[0][self.constants.VALVE_TYPE_VARIABLE] == self.constants.CARGO_TANK_NAME:
                tanks = time_dict[time][self.constants.OPEN]
                valves = tank_filter(seq, tanks, count)  # cargo tank filter
            else:
                valves = no_filter(seq, count)  # no filter, take all valves
            operation_valves += valves
        return operation_valves

    # Open cargo tank for loading with tank filter
    def CT_open_operation(self, time, time_dict):
        tank_filter = self.vfilters.cargo_tank_filter

        operation_valves = []
        for idx, seq in self.CT_open.items():
            count = -1
            if seq[0][self.constants.VALVE_TYPE_VARIABLE] == self.constants.CARGO_TANK_NAME:
                tanks = time_dict[time][self.constants.OPEN]
                valves = tank_filter(seq, tanks, count)  # cargo tank filter
                for v in valves:
                    v[
                        self.constants.VALVE_OP_VARIABLE] = self.constants.OPEN  # ensure all cargo tank valve operation is open
                operation_valves += valves
        return operation_valves

    # Close cargo tank for loading with tank filter
    def CT_close_operation(self, time, time_dict):
        tank_filter = self.vfilters.cargo_tank_filter

        operation_valves = []
        for idx, seq in self.CT_close.items():
            count = -1
            if seq[0][self.constants.VALVE_TYPE_VARIABLE] == self.constants.CARGO_TANK_NAME:
                tanks = time_dict[time][self.constants.CLOSE]
                valves = tank_filter(seq, tanks, count)  # cargo tank filter
                for v in valves:
                    v[
                        self.constants.VALVE_OP_VARIABLE] = self.constants.CLOSE  # ensure all cargo tank valve operation is close
                operation_valves += valves
        return operation_valves

    # Shutting sequence for loading with tank and manifold filter
    def shutting_loading_operation(self, time, time_dict):
        tank_filter = self.vfilters.cargo_tank_filter
        manifold_filter = self.vfilters.manifold_filter
        no_filter = self.vfilters.no_filter

        operation_valves = []
        for idx, seq in self.shutting_loading.items():
            count = int(idx.split('_')[1])
            if seq[0][self.constants.VALVE_TYPE_VARIABLE] == self.constants.CARGO_TANK_NAME:
                tanks = time_dict[time][self.constants.CLOSE]
                valves = tank_filter(seq, tanks, count)  # cargo tank filter
            elif self.constants.MANIFOLD_NAME in seq[0][self.constants.VALVE_TYPE_VARIABLE]:
                valves = manifold_filter(seq, self.MANIFOLD, self.SIDE, count)  # cargo manifold filter
            else:
                valves = no_filter(seq, count)  # no filter, take all valves
            operation_valves += valves
        return operation_valves


# write sequencing for loading
class ValveSequencing:
    def __init__(self, valve_sequence, voperation, mode, constants):
        self.constants = constants
        self.operation = voperation
        self.valve_sequence = valve_sequence
        self.mode = mode

        if self.mode == self.constants.LOADING_OPS:
            # Loading
            cargo_loading_events = self.getEventsFromJSON(self.constants.LOADING_OPS)
            loading_arr = [np.nan] * len(cargo_loading_events)
            for c in cargo_loading_events:
                loading_rates, loading_tanks, loading_timelines = self.getTankTimelines(
                    cargo_loading_events[c])  # tank rates and timelines for current cargo parcel
                temp = self.createTimelinesDF(loading_tanks, loading_timelines,
                                              loading_rates)  # create df with timelines/rates for each tank
                loading_arr[c] = temp
            self.loading_df = pd.concat(loading_arr, axis=1).sort_index()  # combine all timelines/rates df of all cargo parcels
            self.correctLoadingSingleTank()
            # sort timings
            self.loading_df = self.loading_df.reindex(sorted(self.loading_df.columns), axis=1)
            # map tank timelines/rates to loading operations
            if len(self.loading_df.columns) > 0:
                self.createLoadingOperationsDF()
                self.load_valves = self.generateSequence(self.loading_df, self.loading_operations_df)

            # Deballasting
            deballast_events, deballast_pump = self.getEventsFromJSON(self.constants.DEBALLAST_OPS)
            deballast_arr = [np.nan] * len(deballast_events)
            # deballast eduction events for each cargo parcel, not applicable to discharging
            if mode == self.constants.LOADING_OPS:
                deballast_eduction_events = self.getEventsFromBallastEduction(valve_sequence, self.constants.EDUCTION_KEY)
            for c in deballast_events:
                cur_deballast_df = self.extractBallastTankPump(deballast_events[c], deballast_pump[c])
                if mode == self.constants.LOADING_OPS:  # add deballasting eduction for loading operations
                    deballast_arr[c] = self.addDeballastEduction(deballast_eduction_events[c], cur_deballast_df)
                else:
                    deballast_arr[c] = cur_deballast_df
            self.deballast_df = pd.concat(deballast_arr, axis=1).sort_index()  # combine all timelines/rates df of all cargo parcels
            # Find out all pumps and eductor used for deballasting
            self.deballast_pump = [i for i in self.deballast_df.index if (i not in self.constants.BALLAST_TANKS) & ( i in self.constants.BALLAST_MAP['pump'].values())]
            self.deballast_eductor = [i for i in self.deballast_df.index if (i not in self.constants.BALLAST_TANKS) & ( i in self.constants.BALLAST_MAP['eductor'].values())]
            # map tank timelines/rates to deballasting operations
            if len(self.deballast_df.columns) > 0:
                self.createDeballastOperationsDF()
                self.deballast_valves = self.generateSequence(self.deballast_df, self.deballast_operations_df)

        else:
            # Ballasting
            ballast_events, ballast_pump = self.getEventsFromJSON(self.constants.BALLAST_OPS)
            ballast_arr = [np.nan] * len(ballast_events)
            for c in ballast_events:
                cur_ballast_df = self.extractBallastTankPump(ballast_events[c], ballast_pump[c])
                if self.ballasting_timing[c][self.constants.END] == cur_ballast_df.columns[-1]:
                    ballast_arr[c] = cur_ballast_df.iloc[:, :-1]
                else:
                    ballast_arr[c] = cur_ballast_df
            # combine all timelines/rates df of all cargo parcels
            self.ballast_df = pd.concat(ballast_arr, axis=1).sort_index()
            # Find out all pumps and eductor used for deballasting
            self.ballast_pump = [i for i in self.ballast_df.index if (i not in self.constants.BALLAST_TANKS) & (
                        i in self.constants.BALLAST_MAP['pump'].values())]
            # map tank timelines/rates to ballasting operations
            if len(self.ballast_df.columns) > 0:
                self.createBallastOperationsDF()
                self.ballast_valves = self.generateSequence(self.ballast_df, self.ballast_operations_df)

    # get events and timings from output json
    def getEventsFromJSON(self, module):
        if module == self.constants.LOADING_OPS:
            # stage wise timing for each cargo parcel
            self.loading_timing = self.getStagesTiming(self.valve_sequence)
            # cargo tank events for each cargo parcel
            cargo_loading_events = self.getEventsFromOutput(self.valve_sequence, self.constants.SIMCARGOLOADING_KEY)
            return cargo_loading_events
        elif module == self.constants.DEBALLAST_OPS:
            # stage wise timing
            self.deballasting_timing = self.getStagesTiming(self.valve_sequence)
            # deballast tank events for each cargo parcel
            deballast_events = self.getEventsFromOutput(self.valve_sequence, self.constants.SIMDEBALLASTING_KEY)
            # deballast pump events for each cargo parcel
            deballast_pump = self.getEventsFromOutputPump(self.valve_sequence, self.constants.BALLAST_KEY)
            return deballast_events, deballast_pump
        elif module == self.constants.BALLAST_OPS:
            # stage wise timing
            self.ballasting_timing = self.getStagesTiming(self.valve_sequence)
            # ballast tank events for each cargo parcel
            ballast_events = self.getEventsFromOutput(self.valve_sequence, self.constants.SIMBALLASTING_KEY)
            ballast_pump = self.getEventsFromOutputPump(self.valve_sequence, self.constants.BALLAST_KEY)
            return ballast_events, ballast_pump

    # reformat and extract information about ballast tanks and pumps into dataframe
    def extractBallastTankPump(self, tank_event, pump_event):
        # tank rates and timelines for current cargo
        ballast_rates, ballast_tanks, ballast_timelines = self.getTankTimelines(tank_event)
        # pump rates and timelines for current cargo
        pump_rates, ballast_pumps, pump_timelines = self.getPumpTimelines(pump_event)
        # combine tank and pump timelines
        tanks_pumps = np.unique(np.concatenate([ballast_tanks, ballast_pumps]))
        timelines = np.unique(np.concatenate([ballast_timelines, pump_timelines]))
        rates = {**pump_rates, **ballast_rates}
        cur_ballast_df = self.createTimelinesDF(tanks_pumps, timelines, rates)
        return cur_ballast_df

    # correct tanks for open single tank during loading stage
    def correctLoadingSingleTank(self):
        # ensure that openSingleTank has indication of which tank to open
        for c in self.loading_timing:
            initial_rate_time = self.loading_timing[c][self.constants.INITIALRATE][0]
            initial_tank_idx = pd.notna(self.loading_df.loc[:, initial_rate_time])
            open_single_tank_time = self.loading_timing[c][self.constants.OPENSINGLETANK][0]
            if open_single_tank_time not in self.loading_df.columns:
                self.loading_df[open_single_tank_time] = np.nan
            self.loading_df.loc[initial_tank_idx, open_single_tank_time] = -1  # indicate -1 on open single tank timing

    # Get start time of each stage for each cargo
    def getStagesTiming(self, sequence):
        seq = sequence[self.constants.EVENTS]
        events = {}
        for c in range(len(seq)):  # loop through cargo
            events[c] = {}
            cargo_details = seq[c][self.constants.SEQUENCE]
            for s in range(len(cargo_details)):  # loop through stages
                stage = cargo_details[s][self.constants.STAGE]
                timing = float(cargo_details[s][self.constants.TIMESTART])
                # get stage and timing
                if stage in events:
                    events[c][stage].append(timing)
                else:
                    events[c][stage] = [timing]
            # get end time of cargo
            lastTiming = float(cargo_details[s][self.constants.TIMEEND])
            events[c][self.constants.END] = [lastTiming]
        return events

    # get tank rates using key in output dictionary
    def getEventsFromOutput(self, sequence, key):
        seq = sequence[self.constants.EVENTS]
        events = {}
        for c in range(len(seq)):
            # extract "key" from input sequence
            events[c] = list(pd.DataFrame(seq[c][self.constants.SEQUENCE])[key])
        return events

    # get tank rates for cargo tank COW/Stripping using key in output dictionary
    def getEventsFromOutputCOW(self, sequence, key):
        seq = sequence[self.constants.EVENTS]
        events = {}
        for c in range(len(seq)):
            events[c] = []
            for stage in list(pd.DataFrame(seq[c][self.constants.SEQUENCE])[key]):
                # extract "key" from input sequence and reformat it
                for actions in stage.keys():
                    if len(stage[actions]) > 0:
                        events[c] += [[{idx: action for idx, action in enumerate(stage[actions])}]]
        return events

    # get pump rates for normal ballasting/deballasting using key in output dictionary
    def getEventsFromOutputPump(self, sequence, key):
        seq = sequence[self.constants.EVENTS]
        events = {}
        for c in range(len(seq)):
            events[c] = {}
            for stage in list(pd.DataFrame(seq[c][self.constants.SEQUENCE])[key]):
                # extract "key" from input sequence and reformat it
                for pump in stage.keys():
                    if len(stage[pump]) > 0:
                        pump_name = self.constants.BALLAST_MAP[self.constants.PUMP][str(pump)] if str(pump) in \
                                                                                                  self.constants.BALLAST_MAP[
                                                                                                      self.constants.PUMP] else str(
                            pump)
                        pump_timeline = [time_info for idx, time_info in enumerate(stage[pump]) if
                                         float(time_info[self.constants.RATEM3]) > 0.0]
                        if pump_name in events[c]:
                            events[c][pump_name] += pump_timeline
                        else:
                            events[c][pump_name] = pump_timeline
        return events

    # get pump/tank rates for eduction of ballast tank using key in output dictionary
    def getEventsFromBallastEduction(self, sequence, key):
        seq = sequence[self.constants.EVENTS]
        events = {}
        for c in range(len(seq)):
            events[c] = {}
            for stage in list(pd.DataFrame(seq[c][self.constants.SEQUENCE])[key]):
                if len(stage) > 0:
                    # ballast tanks
                    for tank in stage[self.constants.TANK].values():
                        events[c][tank] = {}
                        events[c][tank][self.constants.TIMESTART] = stage[self.constants.TIMESTART]
                        events[c][tank][self.constants.TIMEEND] = stage[self.constants.TIMEEND]
                        events[c][tank][self.constants.RATE] = -1
                    # ballast eductor
                    for eductorInfo in stage[self.constants.PUMP_VARIABLE].values():
                        eductor = eductorInfo[self.constants.PUMPNAME_VARIABLE]
                        events[c][eductor] = {}
                        events[c][eductor][self.constants.TIMESTART] = stage[self.constants.TIMESTART]
                        events[c][eductor][self.constants.TIMEEND] = stage[self.constants.TIMEEND]
                        events[c][eductor][self.constants.RATE] = -1
                        break  # only choose 1 ballast eductor
                    # ballast pumps
                    for eductorInfo in stage[self.constants.BALLASTPUMP_VARIABLE].values():
                        eductor = eductorInfo[self.constants.PUMPNAME_VARIABLE]
                        events[c][eductor] = {}
                        events[c][eductor][self.constants.TIMESTART] = stage[self.constants.TIMESTART]
                        events[c][eductor][self.constants.TIMEEND] = stage[self.constants.TIMEEND]
                        events[c][eductor][self.constants.RATE] = -1
        return events

    # get end and start timing of each pump for a cargo using output from getEventsFromOutputPump()
    def getPumpTimelines(self, events):
        timelines = []
        pumps = []
        pump_rates = {}
        for pump in events:  # Loop through list of rate events for each stage
            for time_info in events[pump]:
                if len(time_info) > 0:  # ensure pump event is available
                    if float(time_info[self.constants.TIMESTART]) <= float(time_info[self.constants.TIMEEND]): # ensure pump event is correct
                        if pump not in pumps: # record pumps
                            pumps.append(pump)
                        # initialise current pump
                        if pump not in pump_rates:
                            pump_rates[pump] = []
                        # time
                        timelines.append(float(time_info[self.constants.TIMESTART]))
                        timelines.append(float(time_info[self.constants.TIMEEND]))
                        # rates at current time
                        pump_rate_dict = {}
                        rates = float(time_info[self.constants.RATEM3]) if float(
                            time_info[self.constants.RATEM3]) > 0.0 else np.nan
                        pump_rate_dict[float(time_info[self.constants.TIMESTART])] = rates
                        pump_rate_dict[float(time_info[self.constants.TIMEEND])] = 0.0
                        pump_rates[pump].append(pump_rate_dict)
        pumps = np.unique(pumps)
        timelines = np.unique(timelines)
        return pump_rates, pumps, timelines

    # get end and start timing of each tank for a cargo using output from getEventsFromOutput()
    def getTankTimelines(self, events):
        timelines = []
        tanks = []
        tanks_rates = {}
        for event in events:  # Loop through list of rate events for each stage
            if isinstance(event, list):
                for sub_event in event:  # for each sub stage
                    for tank in sub_event.keys():  # extract timing, rates for each tank
                        tank_details = sub_event[tank]
                        # initialise current tank
                        if (tank_details[self.constants.TANKSHORTNAME] not in tanks_rates):
                            tanks_rates[tank_details[self.constants.TANKSHORTNAME]] = []
                        # tank name
                        tanks.append(tank_details[self.constants.TANKSHORTNAME])
                        # time
                        timelines.append(float(tank_details[self.constants.TIMESTART]))
                        timelines.append(float(tank_details[self.constants.TIMEEND]))
                        # tank rate at time
                        time_rate_dict = {}
                        rates = float(
                            tank_details[self.constants.RATE]) if self.constants.RATE in tank_details else -1.0
                        time_rate_dict[float(tank_details[self.constants.TIMESTART])] = rates
                        time_rate_dict[float(tank_details[self.constants.TIMEEND])] = 0.0
                        tanks_rates[tank_details[self.constants.TANKSHORTNAME]].append(time_rate_dict)
        tanks = np.unique(tanks)
        timelines = np.unique(timelines)
        return tanks_rates, tanks, timelines

    # Create dataframe of timings for each tank
    def createTimelinesDF(self, tanks, timelines, tanks_rates):
        df = pd.DataFrame(index=tanks, columns=timelines)
        for tank in tanks_rates.keys():
            for timeline in tanks_rates[tank]:
                # start/end timing of tank
                times = list(timeline.keys())
                start_time_in_minutes = times[0]
                end_time_in_minutes = times[1]
                # rate at that time period
                rate = float(timeline[start_time_in_minutes])
                # Populate rate for that time period for that tank
                cols_from_start_to_end = [i for i in timelines if
                                          (i >= start_time_in_minutes) & (i < end_time_in_minutes)]
                df.loc[tank][cols_from_start_to_end] = rate
        return df

    # timing and tank of tanks to be educted during deballasting
    def addDeballastEduction(self, events, df):
        for tank in events:
            # start/end timing of tank
            timeStart = float(events[tank][self.constants.TIMESTART])
            timeEnd = float(events[tank][self.constants.TIMEEND])
            # rate at that time
            startRate = events[tank][self.constants.RATE]
            endRate = np.nan
            # Populate rate for that time period for that tank
            df.loc[tank, timeStart] = startRate
            df.loc[tank, timeEnd] = endRate
        return df

    def getEquipmentTiming(self, df):
        result_dict = {time: {self.constants.OPEN: [], self.constants.CLOSE: []} for time in df.columns}
        for tank in df.index:
            prev = np.nan
            for idx, rate in enumerate(df.loc[tank, :].values):
                time = df.columns[idx]
                cur_operation = df.loc[tank, time]
                # open
                if np.isnan(prev) & (not np.isnan(rate)):
                    result_dict[time][self.constants.OPEN].append(tank)
                # close
                elif (not np.isnan(prev)) & (np.isnan(rate)):
                    result_dict[time][self.constants.CLOSE].append(tank)
                # close main ballast valve then open strip valve
                elif (not np.isnan(prev)) & (rate == -1):
                    result_dict[time][self.constants.CLOSE].append(tank)
                    result_dict[time][self.constants.OPEN].append(tank)
                prev = rate
        return result_dict

    # Create dataframe of loading operations for each tank using timings df
    def createLoadingOperationsDF(self):
        # operations
        ops = self.constants.ops_abbr_dict[self.constants.LOADING_OPS]
        OST = ops[self.constants.LOADING_SINGLE]
        OAT = ops[self.constants.LOADING_ALL]
        CTO = ops[self.constants.CARGO_TANK_OPEN]
        CTC = ops[self.constants.CARGO_TANK_CLOSE]
        SL = ops[self.constants.LOADING_SHUT]
        self.loading_operations_df = pd.DataFrame(index=self.loading_df.index, columns=self.loading_df.columns)

        # Timings for fixed operations of loading
        singleTankTime = [stages[self.constants.OPENSINGLETANK][0] for c, stages in self.loading_timing.items()]
        allTanksTime = [stages[self.constants.OPENALLTANKS][0] for c, stages in self.loading_timing.items()]
        shuttingTime = [stages[self.constants.END][0] for c, stages in self.loading_timing.items()]

        # Fixed Operations -  standard valve procedures
        for i in range(len(singleTankTime)):
            self.loading_operations_df[shuttingTime[i]] = f'{i}_{SL}'  # initialise shutting time
            if singleTankTime[i] in shuttingTime:  # for multiple cargo
                self.loading_operations_df[singleTankTime[i]] = f'{i - 1}_{SL}, {i}_{OST}'
            else:
                self.loading_operations_df[singleTankTime[i]] = f'{i}_{OST}'
            self.loading_operations_df[allTanksTime[i]] = f'{i}_{OAT}'

        # sort timings_OST
        self.loading_operations_df = self.loading_operations_df.reindex(sorted(self.loading_operations_df.columns),
                                                                        axis=1)

        # Variable Operations
        for tank in self.loading_df.index:  # loop through each tank
            prev = np.nan  # tank closed, no rate
            for idx, rate in enumerate(self.loading_df.loc[tank, :].values):  # loop thruogh timeline of tank
                time = self.loading_df.columns[idx]
                cur_operation = self.loading_operations_df.loc[tank, time]
                # open tank
                if np.isnan(prev) & (not np.isnan(rate)):
                    if pd.isna(cur_operation):
                        self.loading_operations_df.loc[tank, time] = CTO
                    elif not any(substring in cur_operation for substring in [OST, OAT]):
                        self.loading_operations_df.loc[tank, time] += f", {CTO}"
                # Close Tank
                elif (not np.isnan(prev)) & np.isnan(rate):
                    if pd.isna(cur_operation):
                        self.loading_operations_df.loc[tank, time] = CTC
                    elif not any(substring in cur_operation for substring in [SL]):
                        self.loading_operations_df.loc[tank, time] += f", {CTC}"
                prev = rate
        return

    def getDeballastValveTiming(self, start, end):
        col = (self.deballast_df.columns >= start) & (self.deballast_df.columns < end)
        if self.constants.GRAVITY in list(self.deballast_df.index):
            gravityTime = self.deballast_df.loc[self.constants.GRAVITY, col].first_valid_index()
        else:
            gravityTime = np.nan
        pumpTime = self.deballast_df.loc[self.deballast_pump, col].apply(lambda x: x.first_valid_index(), axis=1).min()
        eductorTime = self.deballast_df.loc[self.deballast_eductor, col].apply(lambda x: x.first_valid_index(),
                                                                               axis=1).min()
        if not np.isnan(eductorTime):
            beforeLast = self.deballast_df.loc[self.deballast_eductor, col].apply(lambda x: x.last_valid_index(),
                                                                                  axis=1).max()
            endTime = list(self.deballast_df.columns)[list(self.deballast_df.columns).index(beforeLast) + 1]
        else:
            beforeLast = self.deballast_df.loc[self.deballast_pump, col].apply(lambda x: x.last_valid_index(),
                                                                               axis=1).max()
            endTime = list(self.deballast_df.columns)[list(self.deballast_df.columns).index(beforeLast) + 1]
            # Latest shutting procedures should be at the end time of the cargo
        if endTime > end:
            endTime = end
        return (gravityTime, pumpTime, eductorTime, endTime)

    def getDeballastEductorPumps(self, eductorTime):
        boolean_eductor_pumps = pd.notna(self.deballast_df.loc[self.deballast_pump, eductorTime])
        eductor_pumps = boolean_eductor_pumps.index[boolean_eductor_pumps].tolist()
        boolean_eductor_closedpump = pd.isna(self.deballast_df.loc[self.deballast_pump, eductorTime])
        unused_pumps = boolean_eductor_closedpump.index[boolean_eductor_closedpump].tolist()
        return (eductor_pumps, unused_pumps)

    # Create dataframe of deballasting operations for each tank using timings df
    def createDeballastOperationsDF(self):
        # operations
        ops = self.constants.ops_abbr_dict[self.constants.DEBALLAST_OPS]
        DG = ops[self.constants.DEBALLAST_GRAVITY]
        DFBP = ops[self.constants.DEBALLAST_FLOOD]
        DPG = ops[self.constants.DEBALLAST_PUMP_GRAVITY]
        DPWG = ops[self.constants.DEBALLAST_PUMP]
        DSTSP = ops[self.constants.DEBALLAST_STSP]
        DSE = ops[self.constants.DEBALLAST_EDUCTOR]
        STSE = ops[self.constants.DEBALLAST_STSE]
        SD = ops[self.constants.DEBALLAST_SHUT]
        WBTC = ops[self.constants.BALLAST_TANK_CLOSE]
        WBTO = ops[self.constants.BALLAST_TANK_OPEN]
        BPO = ops[self.constants.BALLAST_PUMP_OPEN]
        BPC = ops[self.constants.BALLAST_PUMP_CLOSE]

        self.deballast_operations_df = pd.DataFrame(index=self.deballast_df.index, columns=self.deballast_df.columns)
        # Timings for fixed operations
        startEndTime = [(stages[self.constants.OPENSINGLETANK][0], stages[self.constants.END][0]) for c, stages in
                        self.deballasting_timing.items()]

        # Fixed Operations -  standard valve procedures
        for i in range(len(startEndTime)):
            s, e = startEndTime[i]
            # timing for fixed operations
            gravityTime, pumpTime, eductorTime, endTime = self.getDeballastValveTiming(s, e)

            # start with Gravity
            if pd.notna(gravityTime):
                # Gravity
                if not isinstance(self.deballast_operations_df[gravityTime][0], str):
                    self.deballast_operations_df[gravityTime] = f"{i}_{DG}"
                else:
                    self.deballast_operations_df[gravityTime] += f", {i}_{DG}"
                # Gravity then Pump
                self.deballast_operations_df[pumpTime] = f"{i}_{DFBP}, {i}_{DPG}"
                # Start without Gravity
            else:
                if not isinstance(self.deballast_operations_df[pumpTime][0], str):
                    self.deballast_operations_df[pumpTime] = f"{i}_{DFBP}, {i}_{DPWG}"
                else:
                    self.deballast_operations_df[pumpTime] += f", {i}_{DFBP}, {i}_{DPWG}"

            # if eductor is present at the end of deballasting
            if pd.notna(eductorTime):
                # pumps for eductor, pumps to be closed
                eductor_pumps, unused_pumps = self.getDeballastEductorPumps(eductorTime)

                # Pump to eductor
                self.deballast_operations_df[eductorTime] = f"{i}_{DSTSP}, {i}_{DSE}"

                if len(unused_pumps) > 0:  # close unused ballast pumps during eduction stage
                    for pump in unused_pumps:
                        self.deballast_operations_df.loc[pump, eductorTime] += f", {i}_{BPC}"
                # shutting sequence after eductor
                self.deballast_operations_df[endTime] = f"{i}_{STSE}, {i}_{SD}"
            # NO EDUCTOR
            else:
                # shutting sequence after pumps
                self.deballast_operations_df[endTime] = f"{i}_{DSTSP}, {i}_{SD}"

        # sort timings
        self.deballast_operations_df = self.deballast_operations_df.reindex(
            sorted(self.deballast_operations_df.columns), axis=1)

        # Variable Tank/Pump Operations
        for tank in self.deballast_df.index:
            prev = np.nan
            for idx, rate in enumerate(self.deballast_df.loc[tank, :].values):
                time = self.deballast_df.columns[idx]
                cur_operation = self.deballast_operations_df.loc[tank, time]
                # Ballast Tanks
                if (tank in self.constants.BALLAST_TANKS):
                    # Compare prev tank rate (nan means no rate) and current tank rate
                    # Open tank
                    if pd.isna(prev) & pd.notna(rate):  # prev ballast tank closed, current ballast tank flowing
                        if pd.isna(cur_operation):
                            self.deballast_operations_df.loc[tank, time] = WBTO
                        elif not any(substring in cur_operation for substring in [DG, DPWG]):
                            self.deballast_operations_df.loc[tank, time] += f", {WBTO}"
                    # Close Tank
                    elif pd.notna(prev) & pd.isna(rate):  # prev ballast tank flowing, current ballast tank closed
                        if pd.isna(cur_operation):
                            self.deballast_operations_df.loc[tank, time] = WBTC
                        elif not any(substring in cur_operation for substring in [DSTSP, STSE]):
                            self.deballast_operations_df.loc[tank, time] += f", {WBTC}"
                prev = rate

    def getBallastValveTiming(self, start, end):
        col = (self.ballast_df.columns >= start) & (self.ballast_df.columns <= end)
        if self.constants.GRAVITY in list(self.ballast_df.index):
            gravityTime = self.ballast_df.loc[self.constants.GRAVITY, col].first_valid_index()
        else:
            gravityTime = np.nan
        pumpTime = self.ballast_df.loc[self.ballast_pump, col].apply(lambda x: x.first_valid_index(), axis=1).min()
        beforeLast = self.ballast_df.loc[self.ballast_pump, col].apply(lambda x: x.last_valid_index(), axis=1).max()
        endTime = list(self.ballast_df.columns)[list(self.ballast_df.columns).index(beforeLast) + 1]
        if endTime > end:
            endTime = end
        return (gravityTime, pumpTime, endTime)

    # Create dataframe of ballasting operations for each tank using timings df
    def createBallastOperationsDF(self):
        # operations
        ops = self.constants.ops_abbr_dict[self.constants.BALLAST_OPS]
        BG = ops[self.constants.BALLAST_GRAVITY]
        FBP = ops[self.constants.BALLAST_FLOOD]
        BPG = ops[self.constants.BALLAST_PUMP_GRAVITY]
        BPWG = ops[self.constants.BALLAST_PUMP]
        STSP = ops[self.constants.BALLAST_STS]
        SB = ops[self.constants.BALLAST_SHUT]
        BPC = ops[self.constants.BALLAST_TANK_CLOSE]
        BPO = ops[self.constants.BALLAST_TANK_OPEN]
        WBTO = ops[self.constants.BALLAST_PUMP_OPEN]
        WBTC = ops[self.constants.BALLAST_PUMP_CLOSE]
        self.ballast_operations_df = pd.DataFrame(index=self.ballast_df.index, columns=self.ballast_df.columns)

        startEndTime = [(stages['floodSeparator'][0], stages[self.constants.END][0]) for c, stages in
                        self.ballasting_timing.items()]

        # Fixed Operations -  standard valve procedures
        for i in range(len(startEndTime)):
            s, e = startEndTime[i]
            if i == 3:
                i = 1
            # timing for fixed operations
            gravityTime, pumpTime, endTime = self.getBallastValveTiming(s, e)

            # start with Gravity
            if isinstance(gravityTime, float):
                # Gravity
                if not isinstance(self.ballast_operations_df[gravityTime][0], str):
                    self.ballast_operations_df[gravityTime] = f"{i}_{BG}"
                else:
                    self.ballast_operations_df[gravityTime] += f", {i}_{BG}"

                # Gravity then Pump
                self.ballast_operations_df[pumpTime] = f"{i}_{FBP}, {i}_{BPG}"

            # Start without Gravity
            else:
                if not isinstance(self.ballast_operations_df[pumpTime][0], str):
                    self.ballast_operations_df[pumpTime] = f"{i}_{FBP}, {i}_{BPWG}"
                else:
                    self.ballast_operations_df[pumpTime] += f", {i}_{FBP}, {i}_{BPWG}"

            # End
            self.ballast_operations_df[endTime] = f"{i}_{STSP}, {i}_{SB}"

        # sort timings
        self.ballast_operations_df = self.ballast_operations_df.reindex(sorted(self.ballast_operations_df.columns),
                                                                        axis=1)

        # Variable Tank/Pump Operations
        for tank in self.ballast_df.index:
            prev = np.nan
            for idx, rate in enumerate(self.ballast_df.loc[tank, :].values):
                time = self.ballast_df.columns[idx]
                cur_operation = self.ballast_operations_df.loc[tank, time]

                if tank in self.constants.BALLAST_TANKS:
                    # Open tank
                    if np.isnan(prev) & (not np.isnan(rate)):  # prev ballast tank closed, current ballast tank flowing
                        if pd.isna(cur_operation):
                            self.ballast_operations_df.loc[tank, time] = WBTO
                        elif not any(substring in cur_operation for substring in [BG, BPWG]):
                            self.ballast_operations_df.loc[tank, time] += f", {WBTO}"
                    # Close Tank
                    elif (not np.isnan(prev)) & np.isnan(
                            rate):  # prev ballast tank flowing, current ballast tank closed
                        if pd.isna(cur_operation):
                            self.ballast_operations_df.loc[tank, time] = WBTC
                        elif not any(substring in cur_operation for substring in [STSP]):
                            self.ballast_operations_df.loc[tank, time] += f", {WBTC}"
                prev = rate

    # Populate valves operations according to operations df
    def generateSequence(self, time_df, operations_df):
        voperation = self.operation
        tank_time = self.getEquipmentTiming(time_df)
        all_valves = {}  # list of all valves info to open/close at each timing
        cur_cargo = 0
        for time in operations_df.columns:  # for each timing
            all_valves[time] = []
            flatten_ops = sum([i.split(',') for i in operations_df.loc[:, time].dropna()], [])
            ops = [flatten_ops[i] for i in
                   sorted(np.unique(flatten_ops, return_index=True)[1])]  # unique while retaining order
            for op in ops:  # for each operation to be carried out
                op = op.strip()
                if '_' in op:
                    cargo, op = op.split('_')
                    cur_cargo = cargo
                valves = voperation.key_operation_mapping[op](time, tank_time)
                for v in valves:
                    v[self.constants.CARGO] = cur_cargo
                all_valves[time] += valves
        return all_valves


class ValveConversion:
    def __init__(self, final_json, constants):
        self.constants = constants
        self.json = final_json
        return

    def getValveInfo(self, valve, time):
        valves_code = valve[self.constants.VALVE] if len(valve[self.constants.VALVE]) > 0 else valve[
            self.constants.PUMP]
        json = {self.constants.TIME_JSON: time, self.constants.OP_JSON: valve[self.constants.VALVE_OP_VARIABLE],
                self.constants.VALVES_JSON: [valves_code]}
        operation = valve[self.constants.VALVE_OP_VARIABLE]
        return json, operation

    def convertValves(self, valves_dict, field):
        for c in range(len(self.json[self.constants.EVENTS])):
            for stage in range(len(self.json[self.constants.EVENTS][c][self.constants.SEQUENCE])):
                stage_info = self.json[self.constants.EVENTS][c][self.constants.SEQUENCE][stage]
                timeStart = float(stage_info[self.constants.TIMESTART])
                timeEnd = float(stage_info[self.constants.TIMEEND])
                if stage == (len(self.json[self.constants.EVENTS][c][self.constants.SEQUENCE]) - 1):
                    timeEnd = timeEnd + 1
                valves = {}
                for t in valves_dict:
                    if (t >= timeStart) & (t < timeEnd):
                        if t in valves:
                            valves[t] += valves_dict[t]
                        else:
                            valves[t] = valves_dict[t]

                cargoValves = []
                json = {}
                operation = None
                prev_time = None
                if str(c) == '3':
                    cargo = '1'
                else:
                    cargo = str(c)
                for time, valve_arr in valves.items():
                    for valve in valve_arr:
                        if str(valve[self.constants.CARGO]) == cargo:
                            if (operation != valve[self.constants.VALVE_OP_VARIABLE]) | (prev_time != time):
                                json, operation = self.getValveInfo(valve, time)
                                prev_time = time
                                cargoValves.append(json)
                            else:
                                valves_code = valve[self.constants.VALVE] if len(valve[self.constants.VALVE]) > 0 else \
                                valve[self.constants.PUMP]
                                cargoValves[-1][self.constants.VALVES_JSON].append(valves_code)
                self.json[self.constants.EVENTS][c][self.constants.SEQUENCE][stage][field] = cargoValves