# -*- coding: utf-8 -*-
### Changelog: 1 Mar 2021
# Added Condition114b, Condition114c, Condition114d1, Condition114d2, 
# Condition114e1, Condition114e2, Condition114e3, Condition114f1
# PH -> uncomment param depArrPort1, depArrPort2, depArrPort2, fixBallastPort,
# B_locked, loadingPortNotLast, loadingPort
# ----------------------------------------------------------------------------
### Changelog: 2 Mar 2021
# Added Constr17a, Constr13c1, Constr13, Constr13a, Constr15b2, Constr15c2,
# Constr153, Constr154
# PH -> uncomment param displacement, P_stable, ListMOM
# ----------------------------------------------------------------------------
### Changelog: 2 Mar 2021
# Added ship stability constraints
# Constr161 Constr16a, Constr16b, Constr18a, Constr18b, Constr19a, Constr19b
# Condition20a, , Condition20b, Condition21a, Condition21b
# PH -> uncomment param trim_upper, Fr, Frames, weightRatio_ct, weightRatio_bt, weightRatio_ot,
# LCG_ct, LCG_ot, LCG_bt, BV_SF, CD_SF, mean_draft, upperSFlimit, lowerSFlimit, LCG_fr,
# upperBMlimit
# ----------------------------------------------------------------------------
### Changelog: 4/5 Mar 2021
# Added Constr15b1, Constr15c1, Constr163, Constr164, Constr18d
# PH -> uncomment bTank1-9, mTank1-10, yTank1-10, bLCB1-9, mLCB1-10, yLCB1-10,
# bMTC1-9, mMTC1-10, yMTC1-10, bDraft1-9, mDraft1-10, yDraft1-10
# ----------------------------------------------------------------------------
### Changelog: 10 Mar 2021
# Corrected var xB, wB
# Corrected Condition050, Condition24 Constr5a, Constr13c1, Constr154
# ----------------------------------------------------------------------------
### Changelog: 22 Mar 2021
# C_max firstloadingPort loadingPortAmt deballastPercent densityBallast 
# lastLoadingPortBallastBan specialBallastPort zeroBallastPort cargoTankNonSym
# cargoweight trim_lower mean_draft
# ----------------------------------------------------------------------------
### Changelog: 31 Mar 2021
# Modified the piecewise constraints (Tank, LCB, MTC, Draft)
# Commented out Constraint 13c1, 20b, 21a for causing infeasibility
# Removed default value for specialBallastPort and zeroBallastPort 
# ----------------------------------------------------------------------------
"""
Created on Wed Mar 24 12:37:49 2021

@author: I2R
"""
import numpy as np
from ortools.linear_solver import pywraplp

RUN_TIME = 900 # in sec

def vlcc_ortools(inputs):
    
    # print('run ortools ...')

     # Create the mip solver with the SCIP backend.
    solver = pywraplp.Solver.CreateSolver('SCIP')   # 'SCIP', 'CBC'
    solver.SetTimeLimit(RUN_TIME*1000)
    # solver.SetNumThreads(4)
    
    infinity = solver.infinity()
    
    ##############################
    # Parameter initialization
    ##############################

    # set of all cargo tanks
    T = [t for t in inputs.vessel.info['cargoTanks'].keys()]

    # set of cargo tanks without pw tcg details
    T1 = [t for t in inputs.vessel.info['cargoTanks'].keys() if t not in inputs.vessel.info['tankTCG']['tcg_pw']]

    # set of all cargos
    if inputs.module in ['LOADABLE', 'DISCHARGE']:
        C = [c for c in inputs.loadable.info['parcel'].keys()]
    elif inputs.module in ['LOADING']:
        C = [c for c in inputs.loadable['parcel'].keys()]
    
    # set of tanks compatible with cargo c (consider tank coating, cargo history, tank heating)
    Tc = {}
    if inputs.module in ['LOADABLE', 'DISCHARGE']:
        for c, t in inputs.loadable.info['parcel'].items():
             Tc[c] = [t for t in T if t not in inputs.vessel.info['banCargo'][c]]
    elif inputs.module in ['LOADING']:
        for c, t in inputs.loadable['parcel'].items():
             Tc[c] = [t for t in T if t not in inputs.vessel.info['banCargo'].get(c, [])]
         
    # set of tanks compatible with cargo c (consider tank coating, cargo history, tank heating)
    Ct = {}
    for t in T:
        Ct[t] = C

    # list of tanks: before arrival at the first loading port, tank has been loaded with cargo
    T_loaded = []
    if inputs.module in ['LOADABLE']:
        for k in inputs.preloaded_cargo:
            for k1 in inputs.loadable.info['preloadOperation'][k]['0']:
                T_loaded.append(k1['tank'])
    elif inputs.module in ['DISCHARGE']:
        for v in inputs.loadable.info['preloadOperation'].values():
            for k in v.keys():
                T_loaded.append(k)
    elif inputs.module in ['LOADING']:
        for v in inputs.loadable['preloadOperation'].values():
            for k in v.keys():
                if k not in T_loaded:
                    T_loaded.append(k)

    # list of cargos preloaded before arriving at the first loading port
    C_loaded = []
    if inputs.module in ['LOADABLE']:
        for k in inputs.preloaded_cargo:
            C_loaded.append(k)
    elif inputs.module in ['DISCHARGE']:
        for k in inputs.loadable.info['preloadOperation'].keys():
            C_loaded.append(k)
    elif inputs.module in ['LOADING']:
        for k in inputs.loadable['preloadOperation'].keys():
            C_loaded.append(k)

    # 1 if cargo c has been loaded in tank t (preloaded condition)
    I_loaded = {}
    if inputs.module in ['LOADABLE']:
        for c in inputs.preloaded_cargo:
            I_loaded[c] = {}
            for k in inputs.loadable.info['preloadOperation'][c]['0']:
                t = k['tank']
                I_loaded[c][t] = 1
    elif inputs.module in ['DISCHARGE']:
        for c, v in inputs.loadable.info['preloadOperation'].items():
            I_loaded[c] = {}
            for t in v.keys():
                I_loaded[c][t] = 1
    elif inputs.module in ['LOADING']:
        for c, v in inputs.loadable['preloadOperation'].items():
            I_loaded[c] = {}
            for t in v.keys():
                I_loaded[c][t] = 1

    if inputs.module in ['LOADABLE', 'DISCHARGE']:
        # cargo density @ low temperature (in t/m3)
        densityCargo_High = {str(c): round(v['mintempSG'], 6) for c, v in inputs.loadable.info['parcel'].items()}
        # cargo density @ high temperature (in t/m3)
        densityCargo_Low = {str(c): round(v['maxtempSG'], 6) for c, v in inputs.loadable.info['parcel'].items()}
    elif inputs.module in ['LOADING']:
        densityCargo_High = {str(c): round(v['mintempSG'], 6) for c, v in inputs.loadable['parcel'].items()}
        densityCargo_Low = {str(c): round(v['maxtempSG'], 6) for c, v in inputs.loadable['parcel'].items()}

    # # density of cargo (under average temperature)
    aveCargoDensity = 1
    if inputs.module in ['LOADABLE', 'DISCHARGE']:
        density = [v['maxtempSG'] for v in inputs.loadable.info['parcel'].values()]
    elif inputs.module in ['LOADING']:
        density = [v['maxtempSG'] for v in inputs.loadable['parcel'].values()]
    aveCargoDensity = round(np.mean(density), 4)

    # density used for the upper loading bound, default dcLow[c] (density at high temp)
    density_up = densityCargo_Low
    # density used for the lower loading bound, default dcHigh[c] (density at low temp)
    density_low = densityCargo_High

    # weight of cargo c remained in tank t at initial state (before ship entering the first port)
    W0 = {}
    # volume of cargo c remained in tank t at initial state (before ship entering the first port)
    Q0 = {}
    for c in C:
        W0[c] = {}
        Q0[c] = {}
        for t in T:
            W0[c][t] = 0
            Q0[c][t] = W0[c][t]/densityCargo_Low[c]
    if inputs.module in ['LOADABLE']:
        for c in inputs.preloaded_cargo:
            for k in inputs.loadable.info['preloadOperation'][c]['0']:
                t = k['tank']
                W0[c][t] = round(k['qty'], 3)
                Q0[c][t] = W0[c][t] / densityCargo_Low[c]
    elif inputs.module in ['DISCHARGE']:
        for c, v in inputs.loadable.info['preloadOperation'].items():
            for t, w in v.items():
                W0[c][t] = round(w, 1)
                Q0[c][t] = W0[c][t] / densityCargo_Low[c]
    elif inputs.module in ['LOADING']:
        for c, v in inputs.loadable['preloadOperation'].items():
            for t, w in v.items():
                W0[c][t] = round(w, 1)
                Q0[c][t] = W0[c][t] / densityCargo_Low[c]

    # total number of ports in the booking list (including virtual ports)
    if inputs.module in ['LOADABLE', 'DISCHARGE']:
        NP = int(inputs.loadable.info['lastVirtualPort'])
    elif inputs.module in ['LOADING']:
        NP = int(inputs.loadable['lastVirtualPort'])

    # the last loading port
    if inputs.module in ['LOADABLE']:
        LP = int(inputs.loadable.info['lastVirtualPort']-1)
    elif inputs.module in ['DISCHARGE']:
        LP = 0
    elif inputs.module in ['LOADING']:
        LP = int(inputs.loadable['lastVirtualPort'])
    
    # set of ports
    P = list(range(1, NP+1))
    # a virtual port before the first port
    P_org = [0]
    # union P and P_org
    Pbar = P + P_org
    # set of loading ports
    P_load = list(range(1, LP+1))
    # set of discharging ports
    P_dis = list(range(LP+1, NP+1))
    # the last loading port
    P_last_loading = [LP]

    # weight of preloaded cargo to be moved from tank t at port p
    W_loaded = {}
    # volume of preloaded cargo to be moved from tank t at port p
    V_loaded = {}
    for c in C_loaded:
        W_loaded[c] = {}
        V_loaded[c] = {}
        for t in T_loaded:
            W_loaded[c][t] = {}
            V_loaded[c][t] = {}
            for p in P:
                W_loaded[c][t][p] = 0
                V_loaded[c][t][p] = W_loaded[c][t][p] / densityCargo_Low[c]

    # cargo with higher priority will be loaded as close to the intended quantity as possible
    priority = {}
    for c in C:
        priority[c] = 100
        
    cargoPriority = []  # input
    if inputs.module in ['LOADABLE']:
        if inputs.mode in ['Auto']:
            for i in range(inputs.loadable.info['maxPriority'], 1, -1):
                for p1 in inputs.loadable.info['priority'][i]:
                    for j in range(i-1, 0, -1):
                        for p2 in inputs.loadable.info['priority'][j]:
                            # p2 has higher priority than p1
                            cargoPriority.append((p2, p1))

    # weight (in metric tone) of cargo to be moved at port p.
    # positive -> to be loaded; negative -> to be discharged; zero -> no action is required.
    Wcp = {}
    for c in C:
        Wcp[c] = {}
        for p in P:
            Wcp[c][p] = 0
    if inputs.module in ['LOADABLE', 'DISCHARGE']:
        # Wcp = {str(c): {} for c in inputs.loadable.info['operation'].keys()}
        for c, pw in inputs.loadable.info['operation'].items():
            for p, w in pw.items():
                if int(p) > 0:
                    Wcp[str(c)][int(p)] = round(w, 1)
    elif inputs.module in ['LOADING']:
        # Wcp = {str(c): {} for c in inputs.loadable['operation'].keys()}
        for c, pw in inputs.loadable['operation'].items():
            for p, w in pw.items():
                if int(p) > 0:
                    Wcp[str(c)][int(p)] = round(w, 1)

    # volume (in t/m3) of cargo to be moved at port p based on low density.
    Vcp = {}
    for c in C:
        Vcp[c] = {}
        for p in P:
            Vcp[c][p] = Wcp.get(c, {}).get(p, 0.) / densityCargo_Low[c]

    # loading ports
    loadPort = []
    # loadingPortAmt: amount of all the cargos to be loaded at port p
    loadingPortAmt = {}
    if inputs.module in ['LOADABLE']:
        loadPort = [p for p in inputs.loadable.info['toLoadPort1'].keys()]
        loadingPortAmt = {p: round(w, 1) for p, w in inputs.loadable.info['toLoadPort1'].items()}
    elif inputs.module in ['LOADING']:
        loadPort = [p for p in inputs.loadable['toLoadPort1'].keys()]
        loadingPortAmt = {p: round(w, 1) for p, w in inputs.loadable['toLoadPort1'].items()}

    # ratio of ballast water that could be de-ballasted when loading cargoes
    deballastPercent = 0.4
    deballastPercent = round(inputs.deballast_percent, 4)

    # discharge ports
    dischargePort = []
    dischargePortAmt = {}
    if inputs.module in ['DISCHARGE']:
        dischargePort = [p for p in inputs.loadable.info['toDischargePort1'].keys()]
        dischargePortAmt = {p: -round(w, 1) for p, w in inputs.loadable.info['toDischargePort1'].items()}

    ballastPercent = 0.4

    # min amount of all the cargos to be loaded
    minCargoLoad = {c: 0 for c in C}
    # intended cargo to load
    toLoad = {c: 0 for c in C}
    diffSlop = 1
    if inputs.module in ['LOADABLE']:
        for c, w in inputs.loadable.info['toLoadMin'].items():
            minCargoLoad[c] = round(w, 3)
        for c, w in inputs.loadable.info['toLoad'].items():
            toLoad[c] = round(w, 3)
        diffSlop = 10 if inputs.loadable.info['numParcel'] == 1 else 1
    elif inputs.module in ['LOADING']:
        for c, w in inputs.loadable['toLoad'].items():
            toLoad[c] = round(w, 1)

    ## Commingle cargos
    Cm_1 = []  # Commingle cargos
    Cm_2 = []  # Commingle cargos
    Tm = []  # Possible commingled tanks
    density_Cm = {}  # Density commingled cargo
    for c in C:
        density_Cm[c] = 1

    if inputs.module in ['LOADABLE']:
        if inputs.loadable.info['commingleCargo']:
            Cm_1 = [inputs.loadable.info['commingleCargo']['parcel1']]
            Cm_2 = [inputs.loadable.info['commingleCargo']['parcel2']]
            density_Cm[inputs.loadable.info['commingleCargo']['parcel1']] = inputs.loadable.info['commingleCargo']['SG1']
            density_Cm[inputs.loadable.info['commingleCargo']['parcel2']] = inputs.loadable.info['commingleCargo']['SG2']
            if inputs.loadable.info['commingleCargo'].get('tank', []):
                Tm = [inputs.vessel.info['tankId'][int(t)] for t in inputs.loadable.info['commingleCargo']['tank']]
            elif not inputs.loadable.info['commingleCargo']['slopOnly']:
                Tm = ['2C', '3C', '4C', 'SLS', 'SLP']
            else:
                Tm = ['SLS', 'SLP']

    Qm_1 = 0    # default value
    Qm_2 = 0    # default value
    Mm = 1e5

    if inputs.module in ['LOADABLE']:
        if inputs.loadable.info['commingleCargo'].get('mode', '0') == '2':
            Qm_1 = inputs.loadable.info['commingleCargo']['wt1']
            Qm_2 = inputs.loadable.info['commingleCargo']['wt2']
            Mm = 0.

    # cargo tank capacity (in m3)
    capacityCargoTank = {}
    for t, v in inputs.vessel.info['cargoTanks'].items():
        vol = inputs.vessel.info['onboard'].get(t, {}).get('vol', 0.)
        if vol > 0:
            print(t, v['capacityCubm'], round(vol, 3))
        capacityCargoTank[t] = round(v['capacityCubm']-vol/0.98, 3)

    # onboard qty (in mt): there are some residuals in the tank
    onboard = {t: round(qty['wt'], 3) for t, qty in inputs.vessel.info['onboard'].items()
               if t not in ['totalWeight']}

    # upper loading bound for each tank: 0.98 for tank capacity more than 0.5 km^3,
    # and 1 for the other cargo tanks.
    # lower loading bound for each tank, e.g. 0.6 upperBound = {}
    upperBound = {}
    lowerBound = {}
    for t in T:
        upperBound[t] = 0.98
        lowerBound[t] = 0.60

    # for each cargo c, the upper loading bound for each tank
    upperBoundC = {}
    for c in C:
        upperBoundC[c] = {}
        for t in T:
            upperBoundC[c][t] = upperBound[t]

    # locked tank: pre-define the cargo allocation to tank, used for manual
    T_locked = []
    if inputs.module in ['LOADABLE']:
        for v in inputs.loadable.info['manualOperation'].values():
            for v1 in v.values():
                for v2 in v1:
                    if 'tankId' in v2.keys():
                        tank = inputs.vessel.info['tankId'][int(v2['tankId'])]
                    else:
                        tank = v2['tank']
                    if tank not in T_locked:
                        T_locked.append(tank)
    elif inputs.module in ['DISCHARGE']:
        for v in inputs.loadable.info['manualOperation'].values():
            for k1 in v.keys():
                if k1 not in T_locked:
                    T_locked.append(k1)
                    
    elif inputs.module in ['LOADING']:
        for v in inputs.loadable['manualOperation'].values():
            for k1, v1 in v.items():
                if k1 not in T_locked and len(v1) > 0:
                    T_locked.append(k1)

    # locked cargo: same as above
    C_locked = []
    if inputs.module in ['LOADABLE', 'DISCHARGE']:
        for c in inputs.loadable.info['manualOperation'].keys():
            if c not in C_locked:
                C_locked.append(c)
    elif inputs.module in ['LOADING']:
        for c in inputs.loadable['manualOperation'].keys():
            if c not in C_locked:
                C_locked.append(c)

    # 1 if tank t is locked for cargo c
    # A_locked = {c: {} for c in C_locked}
    A_locked = {}
    if inputs.module in ['LOADABLE']:
        for c, v in inputs.loadable.info['manualOperation'].items():
            A_locked[c] = {}
            tanks = []
            for v1 in v.values():
                for v2 in v1:
                    if 'tankId' in v2.keys():
                        tank = inputs.vessel.info['tankId'][int(v2['tankId'])]
                    else:
                        tank = v2['tank']
                    if tank not in tanks:
                        A_locked[c][tank] = 1
                        tanks.append(tank)
    elif inputs.module in ['DISCHARGE']:
        for c, v in inputs.loadable.info['manualOperation'].items():
            A_locked[c] = {}
            tanks = []
            for c1, v1 in v.items():
                tank = c1
                if v1 and tank not in tanks:
                    A_locked[c][tank] = 1
                    tanks.append(tank)
    elif inputs.module in ['LOADING']:
        for c, v in inputs.loadable['manualOperation'].items():
            A_locked[c] = {}
            tanks = []
            for c1, v1 in v.items():
                tank = c1
                if v1 and tank not in tanks:
                    A_locked[c][tank] = 1
                    tanks.append(tank)

    # the amount (weight) of cargo locked to put/unload into/from tank t at port p
    # W_locked = {c: {} for c in C_locked}
    W_locked = {}
    # volumn of cargo locked to load/unload into/from tank t at port p
    # V_locked = {c: {} for c in C_locked}
    V_locked = {}
    if inputs.module in ['LOADABLE']:
        for c, v in inputs.loadable.info['manualOperation'].items():
            W_locked[c] = {}
            V_locked[c] = {}
            for p, v1 in v.items():
                for v2 in v1:
                    if 'tankId' in v2.keys():
                        tank = inputs.vessel.info['tankId'][int(v2['tankId'])]
                    else:
                        tank = v2['tank']

                    if tank not in W_locked[c].keys():
                        W_locked[c][tank] = {}
                        V_locked[c][tank] = {}

                    W_locked[c][tank][p] = round(v2['qty'], 1)
                    V_locked[c][tank][p] = W_locked[c][tank][p] / densityCargo_Low[c]

    elif inputs.module in ['DISCHARGE']:
        for c, v in inputs.loadable.info['manualOperation'].items():
            W_locked[c] = {}
            V_locked[c] = {}
            for k1, v1 in v.items():
                if k1 not in W_locked[c].keys():
                    W_locked[c][k1] = {}
                    V_locked[c][k1] = {}
                for k2, v2 in v1.items():
                    W_locked[c][k1][k2] = round(v2, 1)
                    V_locked[c][k1][k2] = W_locked[c][k1][k2] / densityCargo_Low[c]

    elif inputs.module in ['LOADING']:
        for c, v in inputs.loadable['manualOperation'].items():
            W_locked[c] = {}
            V_locked[c] = {}
            for c1, v1 in v.items():
                W_locked[c][c1] = {}
                V_locked[c][c1] = {}
                for c2, v2 in v1.items():
                    W_locked[c][c1][c2] = round(v2, 1)
                    V_locked[c][c1][c2] = W_locked[c][c1][c2] / densityCargo_Low[c]

    # set of other tanks, non-cargo non-ballast tanks, e.g. fuel tanks, water tanks
    other_tanks = {**inputs.vessel.info['fuelTanks'],
                   **inputs.vessel.info['dieselTanks'],
                   **inputs.vessel.info['freshWaterTanks']}
    OtherTanks = [t for t in other_tanks.keys()]

    # weight of each tank
    if inputs.module in ['LOADABLE', 'DISCHARGE']:
        weightOtherTank = {t: {} for t in inputs.vessel.info['onhand'].keys()}
        for t, v in inputs.vessel.info['onhand'].items():
            for k in v.keys():
                if k not in ['1A']:
                    for p, v1 in inputs.loadable.info['virtualArrDepPort'].items():
                        if v1 == k:
                            wt = v[k]['wt']
                            weightOtherTank[t][int(p)] = round(wt, 3)
    elif inputs.module in ['LOADING']:
        weightOtherTank = {t: {} for t in inputs.loading.info['ROB'][1].keys()}
        for t, v in inputs.loading.info['ROB'][1].items():
            for p in range(1, inputs.loadable['lastVirtualPort']+1):
                wt = v[0]['quantityMT']
                weightOtherTank[t][int(p)] = round(wt, 3)

    # max num tanks, default 100, to limit the number of tanks allocated
    maxTankUsed = 100
    if inputs.module in ['LOADABLE']:
        maxTankUsed = inputs.maxTankUsed if inputs.maxTankUsed else 100

    # mismatch between the weight of cargo planned to move at port and the actual amount moved
    intended = 1e6

    # capacity of each ballast tanks
    capacityBallastTank = {t: round(v['capacityCubm'], 3) for t, v in inputs.vessel.info['ballastTanks'].items()
                           if t not in inputs.vessel.info['banBallast']}

    # set of ballast tanks
    TB = [t for t in inputs.vessel.info['ballastTanks'].keys() if t not in inputs.vessel.info['banBallast']]

    # ballast tanks with non-pw tcg details (for list constraint)
    tb_list = list(inputs.vessel.info['tankTCG']['tcg_pw'].keys()) + inputs.vessel.info['banBallast']
    TB1 = [t for t in inputs.vessel.info['ballastTanks'].keys() if t not in tb_list]

    minBallastAmt = {i_: round(j_, 3) for i_, j_ in inputs.vessel.info['ullage30cm'].items()
                     if i_ not in inputs.vessel.info['banBallast']}

    # set of ballast tanks with no pw lcg details (lcg is for trim calculation)
    tb_list = list(inputs.vessel.info['tankLCG']['lcg_pw'].keys()) + inputs.vessel.info['banBallast']
    TB2 = [t for t in inputs.vessel.info['ballastTanks'].keys() if t not in tb_list]

    # upper and lower loading bound for each ballast tank
    upperBoundB1 = {}
    lowerBoundB1 = {}
    for t in TB:
        upperBoundB1[t] = 0.99
        lowerBoundB1[t] = 0.0

    # initial weight of ballast water before arrival at the first port
    initBallast = {t: 0 for t in TB}
    if inputs.module in ['LOADABLE', 'DISCHARGE']:
        for t, wt in inputs.vessel.info['initBallast']['wt'].items():
            initBallast[t] = round(wt, 4)
    elif inputs.module in ['LOADING']:
        for t, wt in inputs.loading.info['ballast'][0].items():
            initBallast[t] = round(wt[0]['quantityMT'], 3)

    # default value for upper/lower trim
    trim_upper = 0.0001
    trim_lower = -0.0001
    if inputs.module in ['LOADABLE']:
        # upper trim, default 0.001
        trim_upper = {int(p): round(v, 6) for p, v in inputs.trim_upper.items()}
        # lower trim, default -0.001
        trim_lower = {int(p): round(v, 6) for p, v in inputs.trim_lower.items()}
    elif inputs.module in ['DISCHARGE', 'LOADING']:
        trim_upper = {int(p): round(v, 3) for p, v in inputs.trim_upper.items()}
        trim_lower = {int(p): round(v, 3) for p, v in inputs.trim_lower.items()}

    # cargo tank restrictions: non-symmetrical cargo tanks
    cargoTankNonSym = []
    if inputs.module in ['LOADABLE']:
        cargoTankNonSym = inputs.vessel.info['notSym']
    
    # cargo tank restrictions: symmetrical cargo tanks
    if inputs.module in ['LOADABLE']:
        symmetricVolTank = inputs.config['sym_vol_tanks']
    else:
        symmetricVolTank = [('1P', '1S'), ('2P', '2S'), ('SLS', 'SLP'), ('3P', '3S'), ('4P', '4S'), ('5P', '5S')]

    # single value: weight of the cargo with highest load
    C_max = []
    if inputs.module in ['LOADABLE']:
        C_max = inputs.vessel.info['maxCargo']

    if inputs.module in ['LOADABLE', 'DISCHARGE']:
        # ballast tank to increase water
        incTB = inputs.vessel.info['initBallast']['inc']
        # ballast tank to decrease water
        decTB = inputs.vessel.info['initBallast']['dec']
    elif inputs.module in ['LOADING']:
        incTB = inputs.vessel.info['incInitBallast']
        decTB = inputs.vessel.info['decInitBallast']

    loadingPort = []    # loading ports
    loadingPortNotLast = []  # loading port except the last
    if inputs.module in ['LOADABLE']:
        for p_id, p in enumerate(inputs.vessel.info['loading']):
            if p_id < len(inputs.vessel.info['loading'])-1:
                # (loading port, next loading port)
                loadingPort.append((p, inputs.vessel.info['loading'][p_id+1]))
        loadingPortNotLast = list(loadingPort[:-1])

    depArrPort1, depArrPort2, same_ballast = [], [], []
    if inputs.module in ['LOADABLE']:
        # departure arrival ports with empty ROB
        for (a_, b_) in inputs.vessel.info['sameROB']:
            if int(b_) < inputs.loadable.info['lastVirtualPort']-1:
                depArrPort2.append((int(a_), int(b_)))
                same_ballast.append(int(b_))
        # departure arrival ports with non-empty ROB
        for k__, k_  in enumerate(inputs.vessel.info['loading']): # same tank
            if k__ < len(inputs.vessel.info['loading'])-1:
                if (int(k_), int(k_)+1) not in depArrPort2:
                    depArrPort1.append((int(k_), int(k_)+1))
    elif inputs.module in ['DISCHARGE']:
        # departure arrival ports with empty ROB
        for (a_, b_) in inputs.vessel.info['sameROB']:
            depArrPort2.append((int(a_), int(b_)))
            same_ballast.append(int(b_))
    elif inputs.module in ['LOADING']:
        for p in inputs.loading.seq['sameBallast']:
            depArrPort2.append((int(p), int(p)+1))
            same_ballast.append(int(p))
    
    sameBallastPort = same_ballast

    rotatingPort1 = []
    rotatingPort2 = []
    if inputs.module in ['LOADABLE']:
        if len(inputs.vessel.info['rotationVirtual']) >= 1:
            for p_id, p in enumerate(inputs.vessel.info['rotationVirtual'][0]):
                if p_id < len(inputs.vessel.info['rotationVirtual'][0]) - 1:
                    rotatingPort1.append((p, inputs.vessel.info['rotationVirtual'][0][p_id+1]))
        if len(inputs.vessel.info['rotationVirtual']) >= 2:
            for p_id, p in enumerate(inputs.vessel.info['rotationVirtual'][1]):
                if p_id < len(inputs.vessel.info['rotationVirtual'][1]) - 1:
                    rotatingPort2.append((p, inputs.vessel.info['rotationVirtual'][1][p_id+1]))
    elif inputs.module in ['DISCHARGE']:
        for p in range(inputs.loadable.info['lastVirtualPort']):
            rotatingPort1.append((p, p+1))
    elif inputs.module in ['LOADING']:
        for p in range(inputs.loadable['lastVirtualPort']):
            rotatingPort1.append((p, p+1))

    # list of tanks that cannot contain water at last loading port
    lastLoadingPortBallastBan = []
    if inputs.module in ['LOADABLE']:
        lastLoadingPortBallastBan = inputs.config['last_loading_port_ballast_ban']

    toDeballastTank = []
    if inputs.module in ['LOADING']:
        for i in inputs.loading.info['tankToDeballast']:
            toDeballastTank.append(i)

    ballastLimit = {p: 1e6 for p in Pbar}
    if inputs.module in ['LOADING']:
        for p, j in inputs.loading.seq['ballastLimit'].items():
            if j > 0:
                ballastLimit[p] = round(j, 3)

    ballastBan = []
    if inputs.module in ['DISCHARGE']:
        ballastBan = ['AWBP', 'AWBS', 'APT']

    # first loading Port, default 1
    firstLoadingPort = 1
    if inputs.module in ['LOADABLE']:
        firstLoadingPort = int(inputs.loadable.info['arrDepVirtualPort']['1D'])
    
    # certain port can only use special ballast tank (restriction), default LP-1 (original)
    specialBallastPort = [LP-1, LP]
    
    # at these ports, no ballast in the tank when departing, default LP
    zeroBallastPort = []

    # light weight of the ship
    lightWeight = inputs.vessel.info['lightweight']['weight']
    
    # LCG of ship
    LCGship = inputs.vessel.info['lightweight']['lcg']
    
    # deadweight constant
    deadweightConst = inputs.vessel.info['deadweightConst']['weight']
                
    # LCG of deadweight constant
    LCGdw = float(inputs.vessel.info['deadweightConst']['lcg'])
    
    # TCG of deadweight constant
    TCGdw = float(inputs.vessel.info['deadweightConst']['tcg'])

    firstDisCargo = []
    if inputs.module in ['LOADABLE']:
        if inputs.firstDisCargo not in ['None'] and 'P' + inputs.firstDisCargo not in ['P']:
            firstDisCargo.append('P' + inputs.firstDisCargo)

    cargoweight = 1e6
    if inputs.module in ['LOADABLE']:
        cargoweight = float(inputs.cargoweight)

    tanks = {**inputs.vessel.info['cargoTanks'], **inputs.vessel.info['ballastTanks'],
             **inputs.vessel.info['fuelTanks'], **inputs.vessel.info['dieselTanks'],
             **inputs.vessel.info['freshWaterTanks']}

    # LCGs of tanks
    LCGt = {t: round(v['lcg'], 4) for t, v in tanks.items() if t not in inputs.vessel.info['banBallast']}

    # TCGs of tanks
    TCGt = {}
    for t in tanks.keys():
        if t not in inputs.vessel.info['banBallast']:
            tcg = inputs.vessel.info['tankTCG']['tcg'].get(t, {}).get('tcg', [0., 0., 0., 0.])[-3] # FPTU missing
            TCGt[t] = round(tcg, 4)

    # # num of pw TCG curves for ballast tank
    # slopes of TCG curves for tanks
    #   (m1,y1)  (m2,y2)
    #  |-------|---------|----|----| ... ----|----|
    # b0      b1         b2   b3   b4         b9   b10
    # 
    #  curve is broken into 10 pieces: start point b0 and end point b10
    #  b0 is not provided
    #  b1, ... b10 = breaks
    #  m1, ... m10 = slopes
    #  y1, ... y10 = intercepts
    #  (m1,y1) is the linear curve for b0 - b1
    #  (m2,y2) is the linear curve for b1 - b2

    # TCG: for list constraint
    # slopes/breaks/intercepts of TCG curve
    # mTank: mTankTCG, bTank: bTankTCG
    mTank, bTank, yTank = {}, {}, {}
    bTank[0] = {}
    for m in range(1, inputs.vessel.info['tankTCG']['tcg_pw']['npw']+1):
        mTank[m] = {}
        bTank[m] = {}
        yTank[m] = {}
        for k, v in inputs.vessel.info['tankTCG']['tcg_pw'].items():
            if k not in (['npw']+inputs.vessel.info['banBallast']):
                mTank[m][k] = round(v['slopes'][m-1], 8)
                bTank[m][k] = round(v['breaks'][m-1], 8)
                yTank[m][k] = round(v['intercepts'][m-1], 8)

    # inital value
    for k in inputs.vessel.info['tankTCG']['tcg_pw'].keys():
        bTank[0][k] = 0
    
    bTank_n, cTank_n = {}, {}
    for i in range(len(bTank)):
        bTank_n[i], cTank_n[i] = {}, {}
        k = i+1 if i < len(mTank) else i
        for j in bTank[i]:
            if j not in ['npw']:
                bTank_n[i][j] = bTank[i][j]
                cTank_n[i][j] = mTank[k][j]*bTank_n[i][j]+yTank[k][j]

    # TCGs for others tanks
    if inputs.module in ['LOADABLE', 'DISCHARGE']:
        TCGtp = {k: {} for k in inputs.vessel.info['onhand'].keys()}
        for i, j in inputs.vessel.info['onhand'].items():
            for k, v in j.items():
                tcg = j[k]['tcg']
                if k not in ['1A']:
                    for k1, v1 in inputs.loadable.info['virtualArrDepPort'].items():
                        if v1 == k:
                            TCGtp[i][int(k1)] = round(tcg, 4)
    elif inputs.module in ['LOADING']:
        TCGtp = {k: {} for k in inputs.loading.info['ROB'][1].keys()}
        for i, j in inputs.loading.info['ROB'][1].items():
            for k in range(1, inputs.loadable['lastVirtualPort']+1):
                TCGtp[i][k] = round(j[0]['tcg'], 4)

    ## LCG: for trim constraint
    # slopes/breaks/intercepts of LCG curve
    # mTankl: mTankLCG, bTankl: bTankLCG, yTankl: yTankLCG
    mTankl, bTankl, yTankl = {}, {}, {}
    bTankl[0] = {}
    for m in range(1, inputs.vessel.info['tankLCG']['lcg_pw']['npw']+1):
        mTankl[m] = {}
        bTankl[m] = {}
        yTankl[m] = {}
        for k, v in inputs.vessel.info['tankLCG']['lcg_pw'].items():
            if k not in (['npw']+inputs.vessel.info['banBallast']):
                mTankl[m][k] = round(v['slopes'][m-1], 8)
                bTankl[m][k] = round(v['breaks'][m-1], 8)
                yTankl[m][k] = round(v['intercepts'][m-1], 8)

    # initial value
    for k in inputs.vessel.info['tankLCG']['lcg_pw'].keys():
        bTankl[0][k] = 0

    bTankl_n, cTankl_n = {}, {}
    for i in range(len(bTankl)):
        bTankl_n[i], cTankl_n[i] = {}, {}
        k = i+1 if i < len(mTankl) else i
        for j in bTankl[i]:
            if j not in ['npw']:
                bTankl_n[i][j] = bTankl[i][j]
                cTankl_n[i][j] = mTankl[k][j]*bTankl_n[i][j]+yTankl[k][j]

    # LCGs for others tanks
    if inputs.module in ['LOADABLE', 'DISCHARGE']:
        LCGtp = {k: {} for k in inputs.vessel.info['onhand'].keys()}
        for i, j in inputs.vessel.info['onhand'].items():
            for k, v in j.items():
                lcg = j[k]['lcg']
                if k not in ['1A']:
                    for k1, v1 in inputs.loadable.info['virtualArrDepPort'].items():
                        if v1 == k:
                            LCGtp[i][int(k1)] = round(lcg, 4)
    elif inputs.module in ['LOADING']:
        LCGtp = {k: {} for k in inputs.loading.info['ROB'][1].keys()}
        for i, j in inputs.loading.info['ROB'][1].items():
            for k in range(1, inputs.loadable['lastVirtualPort']+1):
                LCGtp[i][k] = round(j[0]['lcg'], 4)

    # slopes/breaks/intercepts of LCB x Disp curve
    mLCB, bLCB, yLCB = {}, {}, {}
    bLCB[0] = inputs.vessel.info['hydrostatic']['displacement'][0]
    for m in range(1, len(inputs.vessel.info['lcb_mtc']['lcb']['slopes'])+1):
        mLCB[m] = round(inputs.vessel.info['lcb_mtc']['lcb']['slopes'][m-1], 8)
        bLCB[m] = round(inputs.vessel.info['lcb_mtc']['lcb']['breaks'][m-1], 8)
        yLCB[m] = round(inputs.vessel.info['lcb_mtc']['lcb']['intercepts'][m-1], 8)

    bLCB_n, cLCB_n = {}, {}
    for i in range(len(bLCB)):
        k = i+1 if i < len(mLCB) else i
        bLCB_n[i] = bLCB[i]
        cLCB_n[i] = mLCB[k]*bLCB_n[i]+yLCB[k]

    # slopes/breaks/intercepts of MTC curve
    mMTC, bMTC, yMTC = {}, {}, {}
    bMTC[0] = inputs.vessel.info['hydrostatic']['displacement'][0]
    for m in range(1, len(inputs.vessel.info['lcb_mtc']['mtc']['slopes'])+1):
        mMTC[m] = round(inputs.vessel.info['lcb_mtc']['mtc']['slopes'][m-1], 10)
        bMTC[m] = round(inputs.vessel.info['lcb_mtc']['mtc']['breaks'][m-1], 10)
        yMTC[m] = round(inputs.vessel.info['lcb_mtc']['mtc']['intercepts'][m-1], 10)

    bMTC_n, cMTC_n = {}, {}
    for i in range(len(bMTC)):
        k = i+1 if i < len(mMTC) else i
        bMTC_n[i] = bMTC[i]
        cMTC_n[i] = mMTC[k]*bMTC_n[i]+yMTC[k]

    # stability - draft
    # upper limit on displacement derived from maximum permissible draft and hydrostatic table
    displacementLimit = {int(p): round(v, 5) for p, v in inputs.displacement_upper.items()}
    
    # lower limit on displacement
    displacementLowLimit = {int(p): round(v, 5) for p, v in inputs.displacement_lower.items()}
    
    # deadweight constraint
    deadweight = 1e6
    if inputs.module in ['LOADABLE']:
        deadweight = inputs.vessel.info['draftCondition']['deadweight']
    
    # base draft
    base_draft = {int(p): round(v, 2) for p, v in inputs.base_draft.items()}

    # slopes/breaks/intercepts of draft curve
    mDraft, bDraft, yDraft = {}, {}, {}
    bDraft[0] = inputs.vessel.info['hydrostatic']['displacement'][0]
    for m in range(1, len(inputs.vessel.info['lcb_mtc']['draft']['slopes'])+1):
        mDraft[m] = round(inputs.vessel.info['lcb_mtc']['draft']['slopes'][m-1], 18)
        bDraft[m] = round(inputs.vessel.info['lcb_mtc']['draft']['breaks'][m-1], 8)
        yDraft[m] = round(inputs.vessel.info['lcb_mtc']['draft']['intercepts'][m-1], 10)

    bDraft_n, cDraft_n = {}, {}
    for i in range(len(bDraft)):
        k = i+1 if i < len(mDraft) else i
        bDraft_n[i] = bDraft[i]
        cDraft_n[i] = mDraft[k]*bDraft_n[i]+yDraft[k]

    # number of frames
    Fr = len(inputs.vessel.info['frames'])

    # weight ratio for SF and BM
    weightRatio_ct, weightRatio_bt, weightRatio_ot = {}, {}, {}
    for fr, v in inputs.vessel.info['tankGroup'].items():
        weightRatio_ct[int(fr)] = {}
        weightRatio_bt[int(fr)] = {}
        weightRatio_ot[int(fr)] = {}
        for t, v_ in v.items():
            if t in inputs.vessel.info['cargoTanks'].keys():
                weightRatio_ct[int(fr)][t] = round(v_['wr'], 4)
            if t in TB:
                weightRatio_bt[int(fr)][t] = round(v_['wr'], 4)
            if t in OtherTanks:
                weightRatio_ot[int(fr)][t] = round(v_['wr'], 4)

    # LCG for SF and BM
    LCG_ct, LCG_bt, LCG_ot = {}, {}, {}
    for fr, v in inputs.vessel.info['tankGroup'].items():
        LCG_ct[int(fr)] = {}
        LCG_bt[int(fr)] = {}
        for t, v_ in v.items():
            if t in inputs.vessel.info['cargoTanks'].keys():
                LCG_ct[int(fr)][t] = round(v_['lcg'], 4)
            if t in TB:
                LCG_bt[int(fr)][t] = round(v_['lcg'], 4)
            if t in other_tanks:
                LCG_ot[int(fr)][t] = round(v_['lcg'], 4)

    LCG_fr = {}
    for fr, v in inputs.vessel.info['tankGroupLCG'].items():
        LCG_fr[int(fr)] = round(v, 3)

    # lower/upper limit for SF
    lowerSFlimit, upperSFlimit = {}, {}
    for fr, v in enumerate(inputs.vessel.info['frames']):
        lowerSFlimit[fr+1] = round(float(inputs.vessel.info['SFlimits'][v][0])/1000*inputs.sf_bm_frac, 5)
        upperSFlimit[fr+1] = round(float(inputs.vessel.info['SFlimits'][v][1])/1000*inputs.sf_bm_frac, 5)

    BV_SF, CD_SF, CT_SF = {}, {}, {}
    for fr in inputs.vessel.info['tankGroup'].keys():
        BV_SF[int(fr)] = {}
        CD_SF[int(fr)] = {}
        CT_SF[int(fr)] = {}
        for p, v in inputs.sf_base_value.items():
            BV_SF[int(fr)][int(p)] = round(v[int(fr)-1], 5)
        for p, v in inputs.sf_draft_corr.items():
            CD_SF[int(fr)][int(p)] = round(v[int(fr)-1], 5)
        for p, v in inputs.sf_trim_corr.items():
            CT_SF[int(fr)][int(p)] = round(v[int(fr)-1], 5)

    # lower/upper limit for BM
    lowerBMlimit, upperBMlimit = {}, {}
    for fr, v in enumerate(inputs.vessel.info['frames']):
        lowerBMlimit[fr+1] = round(float(inputs.vessel.info['BMlimits'][v][0])/1000*inputs.sf_bm_frac, 5)
        upperBMlimit[fr+1] = round(float(inputs.vessel.info['BMlimits'][v][1])/1000*inputs.sf_bm_frac, 5)

    BV_BM, CD_BM, CT_BM = {}, {}, {}
    for fr in inputs.vessel.info['tankGroup'].keys():
        BV_BM[int(fr)] = {}
        CD_BM[int(fr)] = {}
        CT_BM[int(fr)] = {}
        for p, v in inputs.bm_base_value.items():
            BV_BM[int(fr)][int(p)] = round(v[int(fr)-1], 5)
        for p, v in inputs.bm_draft_corr.items():
            CD_BM[int(fr)][int(p)] = round(v[int(fr)-1], 5)
        for p, v in inputs.bm_trim_corr.items():
            CT_BM[int(fr)][int(p)] = round(v[int(fr)-1], 5)

    ###
    ## default in AMPL
    minCargoAmt = 1000  # for each cargo
    ListMOM = 500   # upper and lower limits of tcg moment

    C_equal = C
    if inputs.module in ['LOADING']:
        C_equal = []

    C_slop = C
    if inputs.module in ['DISCHARGE', 'LOADING']:
        C_slop = []

    minTB = [] # for loading module
    if inputs.module in ['LOADING']:
        for i in inputs.loading.info['eduction']:
            if i not in inputs.vessel.info['banBallast']:
                minTB.append(i)

    # density of seawater for different port
    # densitySeaWater = {int(p): 1.025 for p in Pbar}
    densitySeaWater = {}
    if inputs.module in ['LOADABLE', 'DISCHARGE']:
        for p in range(1, inputs.loadable.info['lastVirtualPort'] + 1):
            port = inputs.loadable.info['virtualArrDepPort'][str(p)][:-1]
            portName = inputs.port.info['portOrder'][port]  # convert virtual port to exact port
            density = inputs.port.info['portRotation'][portName]['seawaterDensity']
            densitySeaWater[int(p)] = round(density, 4)
    elif inputs.module in ['LOADING']:
        for p in range(1, inputs.loadable['lastVirtualPort']+1):
            density = inputs.seawater_density
            densitySeaWater[int(p)] = round(density, 4)

    # density of ballast water
    densityBallast = 1.025

    # locked ballast: algo should not change the allocation of water in ballast tanks
    B_locked = {}
    if inputs.module in ['LOADABLE']:
        if inputs.mode in ['Auto']:
            for t, v in inputs.loadable.info['ballastOperation'].items():
                B_locked[t] = {}
                for v1 in v:
                    if v1['order'] != '0':
                        B_locked[t][v1['order']] = round(v1['qty'], 3)
    elif inputs.module in ['DISCHARGE']:
        for t, v in inputs.loadable.info['ballastOperation'].items():
            B_locked[t] = {}
            for k1, v1 in v.items():
                if k1 not in ['0']:
                    B_locked[t][k1] = round(v1, 3)
    elif inputs.module in ['LOADING']:
        for t, v in inputs.loadable['ballastOperation'].items():
            B_locked[t] = {}
            for k1, v1 in v.items():
                if k1 not in ['0']:
                    B_locked[t][int(k1)] = round(v1, 3)

    # at these ports, you cannot change the water ballast
    fixBallastPort = []
    if inputs.module in ['LOADABLE']:
        fixBallastPort = [int(p) for p in inputs.loadable.info['fixedBallastPort'] if p not in ['0']]
    elif inputs.module in ['LOADING']:
        fixBallastPort = [int(p) for p in inputs.loadable['fixedBallastPort'] if p not in ['0']]

    # stable port: at these port, you must consider stability
    P_stable0 = []
    if inputs.module in ['LOADABLE']:
        P_stable0 = list(set([i for i in range(1, NP)]))
    elif inputs.module in ['DISCHARGE']:
        for p in range(1, inputs.loadable.info['lastVirtualPort']+1):
            P_stable0.append(p)
    elif inputs.module in ['LOADING']:
        for p in range(1, NP):
            P_stable0.append(p)

    P_stable = list(set(P_stable0) - set(fixBallastPort) - set(sameBallastPort))

    # for departure of last discharging port min draft constraint
    P_stable1 = list(set(P_stable) - set([NP]))

    diffVol = 0.05
    if inputs.module in ['LOADABLE']:
        if inputs.mode in ['Manual', 'FullManual']:
            diffVol = 0.101
    if inputs.module in ['LOADING']:
        diffVol = 1

    ##########################
    ##  Decision Variables  ##
    ##########################
    x = {}
    w = {}
    qw2f = {}   # qty (ampl) = qw2f/10/densityCargo_Low
    
    for c in C:
        x[c] = {}
        w[c] = {}
        qw2f[c] = {}
        
        for t in T:
            # 1 if cargo c is allocated into tank t for capacity
            x[c][t] = solver.IntVar(0, 1, 'x[%s][%s]' % (c, t))
            w[c][t] = {}
            qw2f[c][t] = {}

            for p in P:
                # weight of cargo (w.r.t. low density) planned to be serviced from/to tank t at port p. 
                # positive -> load; zero -> no action; negative -> unload.
                w[c][t][p] = solver.NumVar(-infinity, infinity, 'w[%s][%s][%d]' % (c, t, p))
                
            for p in Pbar:
                # weight of cargo remained in tank t after visiting port p
                qw2f[c][t][p] = solver.IntVar(0, 100*1000*10, 'qw2f[%s][%s][%d]' % (c, t, p))
    
    # TMom TB 
    T_tmom = {}
    for t in T:
        T_tmom[t] = {}
        for p in P:
            T_tmom[t][p] = solver.NumVar(-infinity, infinity, 'T_tmom[%s][%d]' % (t, p))
    
    xt = {}
    for t in T:
        # 1 if tank t is allocated
        xt[t] = solver.IntVar(0, 1, 'xt[%s]' % t)

    xB = {}     # 1 if ballast tank t is filled with water at port p
    xwB = {}    # 1 if ballast tank t is filled with water at port p
    wB = {}     # weight of water in ballast tank t at port p
    # yB = {}     # volume of water (w.r.t. low density) planned to be added into ballast tank t at port p
    zBa1, zBb1 = {}, {}
    zBa2, zBb2 = {}, {}
    # t-moment/l-moment of ballast tank
    TB_tmom, TB_lmom = {}, {}
    for t in TB:
        xB[t] = {}
        wB[t] = {}
        xwB[t] = {}
        # yB[TB[i]] = {}
        TB_tmom[t], TB_lmom[t] = {}, {}
        zBa1[t] = solver.IntVar(0, 1, 'zBa1[%s]' % t)
        zBb1[t] = solver.IntVar(0, 1, 'zBb1[%s]' % t)
        zBa2[t] = solver.IntVar(0, 1, 'zBa2[%s]' % t)
        zBb2[t] = solver.IntVar(0, 1, 'zBb2[%s]' % t)
        for p in Pbar:
            xB[t][p] = solver.IntVar(0, 1, 'xB[%s][%d]' % (t, p))
            xwB[t][p] = solver.IntVar(0, 1, 'xwB[%s][%d]' % (t, p))
            wB[t][p] = solver.NumVar(0, infinity, 'wB[%s][%d]' % (t, p))
            
        for p in P:
            # yB[t][p] = wB[t][p] / densityBallast[p]
            TB_tmom[t][p] = solver.NumVar(-infinity, infinity, 'TB_tmom[%s][%d]' % (t, p))
            TB_lmom[t][p] = solver.NumVar(-infinity, infinity, 'TB_lmom[%s][%d]' % (t, p))

    T_mom = {}  # tcg moment
    L_mom = {}  # lcg moment
    LCBp = {}
    MTCp = {}
    for p in P:
        T_mom[p] = solver.NumVar(-infinity, infinity, 'T_mom[%d]' % p)
        L_mom[p] = solver.NumVar(-infinity, infinity, 'L_mom[%d]' % p)
        LCBp[p] = solver.NumVar(-infinity, infinity, 'LCBp[%d]' % p)
        MTCp[p] = solver.NumVar(-infinity, infinity, 'MTCp[%d]' % p)
    
    delta = {}
    for c in list(set(C) - set(C_locked)):
        delta[c] = {}
        for p in P_dis:
            delta[c][p] = solver.IntVar(0, 1, 'delta[%s][%d]' % (c, p))

    zz = {}
    for c in C:
        zz[c] = {}
        for c_ in list(set(C)-set([c])):
            zz[c][c_] = {}
            for t in Tm:    # Tm: tank for commingle cargo
                zz[c][c_][t] = solver.IntVar(0, 1, 'zz[%s][%s][%s]' % (c, c_, t))
            
    # BM and SF
    displacement = {}   # displacement
    displacement1 = {}  # displacement corrected for seawater density
    mean_draft = {}
    for p in P:
        displacement[p] = solver.NumVar(0, infinity, 'displacement[%d]' % p)
        displacement1[p] = solver.NumVar(0, infinity, 'displacement1[%d]' % p)
        mean_draft[p] = solver.NumVar(0, infinity, 'mean_draft[%d]' % p)
    
    wn, mn = {}, {}
    SS, SB = {}, {}
    for fr in range(0, Fr+1):
        wn[fr] = {}
        mn[fr] = {}
        SS[fr] = {}
        SB[fr] = {}
        for p in P:
            wn[fr][p] = solver.NumVar(0, infinity, 'wn[%d][%d]' % (fr, p))
            mn[fr][p] = solver.NumVar(-infinity, infinity, 'mn[%d][%d]' % (fr, p))
            SS[fr][p] = solver.NumVar(-infinity, infinity, 'SS[%d][%d]' % (fr, p))
            SB[fr][p] = solver.NumVar(-infinity, infinity, 'SB[%d][%d]' % (fr, p))

    est_trim = {}
    for p in P:
        est_trim[p] = solver.NumVar(0, infinity, 'est_trim[%d]' % p)

    wC = {}
    for t in T:
        wC[t] = {}
        for p in P:
            wC[t][p] = solver.NumVar(0, infinity, 'wC[%s][%d]' % (t, p))

    ##########################
    ##  Objective Function  ##
    ##########################
    Action_Amount = solver.Sum([priority[c] * (solver.Sum([qw2f[c][t][p]/10 for p in P_last_loading]) -
                                               solver.Sum([w[c][t][p] for p in P_dis])) for c in C for t in Tc[c]]) - \
                    1 * solver.Sum([wB[t][p] for t in TB for p in P])

    solver.Maximize(Action_Amount)
    
    ###################
    ##  Constraints  ##
    ###################

    ## basic conditions

    # Condition0: cargo c is not allocated to tank t if t is not compatible with cargo c
    for c in list(set(C)-set(C_loaded)-set(C_locked)):
        solver.Add(solver.Sum([x[c][t] for t in list(set(T)-set(Tc[c]))]) == 0)
    
    # # Condition01: one tank can only take in one cargo
    if inputs.module not in ['LOADING']:
        for t in list(set(T)-set(Tm)):
            solver.Add(solver.Sum([x[c][t] for c in C]) <= 1)
            
    

    # commingled cargo
    # Condition01a, 01b, 01c
    for t in Tm:
        # Condition01a: one tank can take at most 1 cargo
        solver.Add(solver.Sum([x[c][t] for c in list(set(C)-set(Cm_1))]) <= 1)
        # Condition01b: one tank can take at most 1 cargo
        solver.Add(solver.Sum([x[c][t] for c in list(set(C)-set(Cm_2))]) <= 1)
        
        for c1 in Cm_1:
            for c2 in Cm_2:
                # Condition01c: one tank for commingled cargo can take at most 2 cargos
                solver.Add(x[c1][t] + x[c2][t] <= 2)
        
    # Condition01z: at last loading port, each cargo must be loaded at least min amt
    for c in list(set(C)-set(C_locked)):
        for p in P_last_loading:
            solver.Add(solver.Sum([qw2f[c][t][p]/10 for t in Tc[c]]) >= minCargoLoad[c])
    
    # Condition020, 021
    for c in C:
        for t in list(set(T)-set(Tc[c])):
            # Condition020: cargo c is not allocated to tank t if t is not compatible with cargo c
            solver.Add(x[c][t] == 0)
            for p in P:
                # Condition020
                solver.Add(w[c][t][p] == 0)
                # Condition021: cargo c is not allocated to tank t if t is not compatible with cargo c
                solver.Add(qw2f[c][t][p] == 0)

    # # Condition03, 04 (for loading)
    for c in list(set(C)-set(C_locked)):
        # Condition03: total loaded >= total discharged
        solver.Add(solver.Sum([Q0.get(c, {}).get(t, 0.) for t in Tc[c]]) +
                   solver.Sum([w[c][t][p]/densityCargo_Low[c] for t in Tc[c] for p in P_load]) >=
                   -solver.Sum([w[c][t][p]/densityCargo_Low[c] for t in Tc[c] for p in P_dis]))
        for p in P_load:
            if Vcp[c][p] <= 0:
                continue
            # Condition04: 0<= amount of cargo to be loaded <= amount of cargo available at the port
            solver.Add(solver.Sum([w[c][t][p]/densityCargo_Low[c] for t in Tc[c]]) >= 0)
            solver.Add(solver.Sum([w[c][t][p]/densityCargo_Low[c] for t in Tc[c]]) <= Vcp[c][p])
        
    # Condition041: amount of cargo to be loaded at each loading port >= 0
    for c in C:
        for t in Tc[c]:
            for p in P_load:
                solver.Add(w[c][t][p]/densityCargo_Low[c] >= 0)

    # Condition05, 050, 050a, 050b, 050b1, 050c, 050c1
    for c in list(set(C)-set(C_locked)):
        for p in P_dis:
            if Vcp[c][p] >= 0:
                continue
            # Condition05: 0 <= amount of cargo to be unloaded <= amount of cargo required to be unloaded at port p
            # w has negative value for unloading
            solver.Add(solver.Sum([w[c][t][p]/densityCargo_Low[c] for t in Tc[c]]) <= 0)
            solver.Add(solver.Sum([w[c][t][p]/densityCargo_Low[c] for t in Tc[c]]) >= Vcp[c][p])
            # Condition050
            solver.Add(solver.Sum([qw2f[c][t][p-1]/10/densityCargo_Low[c] for t in Tc[c]]) >=
                        -Vcp[c][p]-1e6*(1-delta[c][p]))
            # Condition050a: (big MN formulation for MIP: to form if-else constraint)
            solver.Add(solver.Sum([qw2f[c][t][p-1]/10/densityCargo_Low[c] for t in Tc[c]]) <=
                        -Vcp[c][p]+1e6*(delta[c][p]))
            # Condition050b
            solver.Add(-solver.Sum([w[c][t][p]/densityCargo_Low[c] for t in Tc[c]]) >=
                        -Vcp[c][p]-1e6*(1-delta[c][p]))
            # Condition050b1
            solver.Add(-solver.Sum([w[c][t][p]/densityCargo_Low[c] for t in Tc[c]]) <=
                        -Vcp[c][p]+1e6*(1-delta[c][p]))
            # Condition050c
            solver.Add(-solver.Sum([qw2f[c][t][p]/10/densityCargo_Low[c] for t in Tc[c]]) >=
                        -1e6*delta[c][p])
            # Condition050c1
            solver.Add(-solver.Sum([qw2f[c][t][p]/10/densityCargo_Low[c] for t in Tc[c]]) <=
                        1e6*delta[c][p])
                
    # Condition051: amount of cargo to be unloaded from any tank at any discharging port >= 0
    for c in C:
        for t in Tc[c]:
            for p in P_dis:
                solver.Add(w[c][t][p]/densityCargo_Low[c] <= 0)
    
    # Condition052
    for c in list(set(C)-set(C_locked)):
        for t in Tc[c]:
            for p in P:
                if Vcp[c][p] != 0:
                    continue
                solver.Add(w[c][t][p]/densityCargo_Low[c] == 0)
    
    # Condition06: amount of cargo c left in tank when leaving port p for port p+1 is equal to the amount of cargo c
    # moved from/to tank t at port p.
    for c in C:
        for t in Tc[c]:
            for p in list(set(Pbar)-set([NP])):
                solver.Add(qw2f[c][t][p]/10/densityCargo_Low[c] + w[c][t][p+1]/densityCargo_Low[c] ==
                            qw2f[c][t][p+1]/10/densityCargo_Low[c])

    ## preloaded condition
    # Condition22, 23, 23a, 23b, 24, 24a
    for c in C_loaded:
        for t in T_loaded:
            # Condition22: follow the existing stowage of preloaded cargoes
            solver.Add(x[c][t] == I_loaded.get(c, {}).get(t, 0))

            if inputs.module not in ['DISCHARGE']:
                for p in P:
                    # Condition24a: follow the existing stowage of preloaded cargoes
                    solver.Add(w[c][t][p]/densityCargo_Low[c] == V_loaded[c][t][p])
            
        for t in list(set(T)-set(T_loaded)):
            # Condition23: preloaded cargo can only be loaded to its corresponding preloaded tanks
            solver.Add(x[c][t] == 0)
            
            for p in P:
                # Condition23a, 23b
                solver.Add(w[c][t][p] == 0)
                solver.Add(qw2f[c][t][p] == 0)

    # Condition24: follow the existing stowage of preloaded cargos
    for c in C:
        for t in T:
            solver.Add(qw2f[c][t][0]/10/densityCargo_Low[c] == Q0.get(c, {}).get(t, 0))

    ## locked tank / pre-allocated condition
    # Condition25, 26, 26a, 26b, 27
    for c in C_locked:
        for t in T_locked:
            # Condition25: follow the existing stowage of locked cargos
            solver.Add(x[c][t] == A_locked.get(c, {}).get(t, 0))

            # Condition27: follow the existing stowage of locked cargos
            for p in P:
                solver.Add(w[c][t][p] / densityCargo_Low[c] == V_locked.get(c, {}).get(t, {}).get(p, 0))

        # Condition26: locked cargo can only be loaded to its corresponding locked tanks
        for t in list(set(T)-set(T_locked)):
            solver.Add(x[c][t] == 0)

            # Condition26a, Condition26b: locked cargo can only be loaded to its corresponding locked tanks
            for p in P:
                solver.Add(w[c][t][p] == 0)
                solver.Add(qw2f[c][t][p] == 0)

    ## capacity constraint 98% rule
    for c in list(set(C)-set(C_loaded)-set(C_locked)):
        for t in Tc[c]:
            for p in P_last_loading:
                # Constr5a
                solver.Add(qw2f[c][t][p]/10/densityCargo_Low[c] <= upperBoundC[c][t]*capacityCargoTank[t]*x[c][t])

    # commingled
    # Constr5b
    for c1, c2 in zip(Cm_1, Cm_2):
        for t in T:
            for p in P_last_loading:
                solver.Add(qw2f[c1][t][p] / 10 / density_Cm[c1] + qw2f[c2][t][p] / 10 / density_Cm[c2] <=
                            upperBound[t] * capacityCargoTank[t])
    # Constr5c
    for c1, c2 in zip(Cm_1, Cm_2):
        solver.Add(solver.Sum([zz[c1][c2][t] for t in Tm]) <= 1)  # zz = x1*x2
        for t in Tm:
            solver.Add(zz[c1][c2][t] <= x[c1][t])  # zz <= x1
            solver.Add(zz[c1][c2][t] <= x[c2][t])  # zz <= x2
            solver.Add(zz[c1][c2][t] >= x[c1][t] + x[c2][t] - 1)  # zz >= x1+x2-1

    # manual commingle
    # Constr5d1, 5d2, 5d3, 5d4
    for c1, c2 in zip(Cm_1,Cm_2):
        for t in Tm:
            for p in P_last_loading:
                # Constr5d1
                solver.Add((x[c2][t]*Qm_2 - qw2f[c2][t][p]/10) <= Mm*(1-x[c1][t]))
                # Constr5d2
                solver.Add((qw2f[c2][t][p]/10 - x[c2][t]*(Qm_2+Mm)) <= Mm*(1-x[c1][t]))
                # Constr5d3
                solver.Add((x[c1][t]*Qm_1 - qw2f[c1][t][p]/10) <= Mm*(1-x[c2][t]))
                # Constr5d4
                solver.Add((qw2f[c1][t][p]/10 - x[c1][t]*(Qm_1+Mm)) <= Mm*(1-x[c2][t]))

    ## capacity constraint 60% rule
    # Constr8
    for c in C:
        for t in Tc[c]:
            for p in P_last_loading:
                solver.Add((qw2f[c][t][p]/1000 - 1e4*x[c][t]) <= 0)

    ## ballast capacity constraint
    # Constr11, Constr12
    for t in TB:
        for p in P_stable:
            solver.Add(wB[t][p]/densityBallast <= upperBoundB1[t]*capacityBallastTank[t]*xB[t][p])
            solver.Add(wB[t][p]/densityBallast >= lowerBoundB1[t]*capacityBallastTank[t]*xB[t][p])

    ## max num of tanks available
    for t in T:
        # Constr12a1
        solver.Add(solver.Sum([x[c][t] for c in C]) <= 100*xt[t])
    # Constr12a2
    solver.Add(solver.Sum([xt[t] for t in T]) <= maxTankUsed)

    ## load all  cargo
    # Condition111
    for p in P_last_loading:
        solver.Add(solver.Sum([Wcp.get(c, {}).get(pp, 0.) for c in C for pp in P if Wcp.get(c, {}).get(pp, 0.) > 0]) -
                    solver.Sum([qw2f[c][t][p] / 10 for c in C for t in T]) >= -intended)
        solver.Add(solver.Sum([Wcp.get(c, {}).get(pp, 0.) for c in C for pp in P if Wcp.get(c, {}).get(pp, 0.) > 0]) -
                    solver.Sum([qw2f[c][t][p] / 10 for c in C for t in T]) <= intended)

    ## priority 1 and 2
    # Constr122
    for c1, c2 in cargoPriority:
        solver.Add(solver.Sum([qw2f[c2][t][p] / 10 / toLoad[c2] for t in Tc[c2] for p in P_last_loading]) <=
                    solver.Sum([qw2f[c1][t][p] / 10 / toLoad[c1] for t in Tc[c1] for p in P_last_loading]))

    # symmetric loading
    for c in C:
        # Condition112a, 112b, 112c1, 112c2, 112c3
        solver.Add(x[c]['1P'] == x[c]['1S'])
        solver.Add(x[c]['2P'] == x[c]['2S'])
        solver.Add(x[c]['3P'] == x[c]['3S'])
        solver.Add(x[c]['4P'] == x[c]['4S'])
        solver.Add(x[c]['5P'] == x[c]['5S'])

    # Condition112a1, 112a2
    for t1, t2 in symmetricVolTank:
        for p in P_last_loading:
            solver.Add(solver.Sum([qw2f[c][t1][p]/10/densityCargo_Low[c]/capacityCargoTank[t1] for c in C]) -
                        solver.Sum([qw2f[c][t2][p]/10/densityCargo_Low[c]/capacityCargoTank[t2] for c in C]) <= diffVol)
            solver.Add(solver.Sum([qw2f[c][t1][p]/10/densityCargo_Low[c]/capacityCargoTank[t1] for c in C]) -
                        solver.Sum([qw2f[c][t2][p]/10/densityCargo_Low[c]/capacityCargoTank[t2] for c in C]) >= -diffVol)

    for c in C_equal:
        for p in P_stable:
            # Condition112d1, 112d2, 112d3, 112d4: equal weight in 1W, 2W, 4W, 5W
            solver.Add(qw2f[c]['1P'][p] == qw2f[c]['1S'][p])
            solver.Add(qw2f[c]['2P'][p] == qw2f[c]['2S'][p])
            solver.Add(qw2f[c]['4P'][p] == qw2f[c]['4S'][p])
            solver.Add(qw2f[c]['5P'][p] == qw2f[c]['5S'][p])
            # Condition112d5
            if inputs.module in ['DISCHARGE']:
                solver.Add(qw2f[c]['3P'][p] == qw2f[c]['3S'][p])
            elif inputs.module in ['LOADABLE']:
                if inputs.mode not in ['FullManual']:
                    print('Condition112d5 dropped under LOADABLE, not FullManual')
                else:
                    solver.Add(qw2f[c]['3P'][p] == qw2f[c]['3S'][p])
            elif inputs.module in ['LOADING']:
                print('Condition112d5 dropped under LOADING')

    # Condition112f: diff cargos in slop tanks, except when only one cargo
    for c in C:
        for t1, t2 in cargoTankNonSym:
            solver.Add(x[c][t1] + x[c][t2] <= diffSlop)

    # Condition112g1, Condition112g2: slop tanks have to be used
    if inputs.module not in ['DISCHARGE', 'LOADING']:
        solver.Add(solver.Sum([x[c]['SLS'] for c in C_slop]) == 1)
        solver.Add(solver.Sum([x[c]['SLP'] for c in C_slop]) == 1)

    for c in C_max:
        # Condition112h1, Condition112h2, Condition112h3, Condition112h4, Condition112h5
        # Each row must have a cargo for C_max, empty when only 1 cargo is loaded
        solver.Add(x[c]['1P'] + x[c]['1C'] >= 1)
        solver.Add(x[c]['2P'] + x[c]['2C'] >= 1)
        solver.Add(x[c]['3P'] + x[c]['3C'] >= 1)
        solver.Add(x[c]['4P'] + x[c]['4C'] >= 1)
        solver.Add(x[c]['5P'] + x[c]['5C'] >= 1)

        # Condition112i1, Condition112i2, Condition112i3, Condition112i4
        # C_max cannot occupy 2 consecutive rows
        solver.Add(x[c]['1P'] + x[c]['1C'] + x[c]['1S'] + x[c]['2P'] + x[c]['2C'] + x[c]['2S'] <= 5)
        solver.Add(x[c]['2P'] + x[c]['2C'] + x[c]['2S'] + x[c]['3P'] + x[c]['3C'] + x[c]['3S'] <= 5)
        solver.Add(x[c]['3P'] + x[c]['3C'] + x[c]['3S'] + x[c]['4P'] + x[c]['4C'] + x[c]['4S'] <= 5)
        solver.Add(x[c]['4P'] + x[c]['4C'] + x[c]['4S'] + x[c]['5P'] + x[c]['5C'] + x[c]['5S'] <= 5)

    # Condition112j: first discharge cargo
    for c in firstDisCargo:
        solver.Add(x[c]['SLS'] + x[c]['SLP'] >= 1)

    # Condition112b1, Condition112b2
    for c in list(set(C)-set(C_loaded)-set(C_locked)):
        for t in T:
            for p in P_last_loading:
                solver.Add(qw2f[c][t][p] / 10 >= minCargoAmt * x[c][t])
                solver.Add(qw2f[c][t][p] / 10 <= 1e5 * x[c][t])

    # # Condition113a, Condition113b, Condition113c
    # for t in TB:
    #     for p in P:
    #         solver.Add(xB[t][p] <= 1e6 * wB[t][p])
    #         solver.Add(wB[t][p] <= 1e6 * xB[t][p])  # link xB and wB
    #         solver.Add(wB[t][p] <= 1e6 * xwB[t][p])

    ## ballast requirement
    # Condition113d1, Condition113d2
    for t in TB:
        for p in P_stable:
            solver.Add(wB[t][p] >= minBallastAmt[t] * xB[t][p]) # loaded min ballast
            solver.Add(wB[t][p] <= 1e4 * xB[t][p])  # loaded min ballast

    # Condition113d3 for loading module
    for t in minTB:
        for p in P_stable:
            solver.Add(wB[t][p] >= minBallastAmt[t])  # loaded min ballast

    ## initial ballast condition
    # Condition114a1
    for t in incTB:
        solver.Add(initBallast[t] <= wB[t][firstLoadingPort])

    # Condition114a2
    for t in decTB:
        solver.Add(initBallast[t] >= wB[t][firstLoadingPort])

    # Condition114a3
    for t in TB:
        solver.Add(initBallast[t] == wB[t][0])

    # Condition114b: decreasing ballast except last loading port
    for t in TB:
        for (p1, p2) in loadingPortNotLast:
            solver.Add(wB[t][p1] >= wB[t][p2])

    # Condition114c: decreasing ballast tank
    for p1, p2 in loadingPort:
        solver.Add(solver.Sum([xB[t][p1] for t in TB]) >= solver.Sum([xB[t][p2] for t in TB]))

    # depart and arrival has to use same tank
    for t in TB:
        # Condition114d1: non-zero ROB
        for (p1, p2) in depArrPort1:
            solver.Add(wB[t][p1] >= wB[t][p2])
        # Condition114d2: fixed ROB
        for (p1, p2) in depArrPort2:
            solver.Add(wB[t][p1] == wB[t][p2])

    # rotation loading ports
    for t in TB:
        # Condition114e1, Condition114e2
        for p1, p2 in rotatingPort1:
            solver.Add(wB[t][p2] - wB[t][p1] <= 1e6 * (1 - zBa1[t]))
            solver.Add(wB[t][p1] - wB[t][p2] <= 1e6 * (1 - zBb1[t]))

        # Condition114e3
        solver.Add(zBa1[t] + zBb1[t] == 1)

        # Condition114e4, Condition114e5
        for p1, p2 in rotatingPort2:
            solver.Add(wB[t][p2] - wB[t][p1] <= 1e6 * (1 - zBa2[t]))
            solver.Add(wB[t][p1] - wB[t][p2] <= 1e6 * (1 - zBb2[t]))

        # Condition114e6
        solver.Add(zBa2[t] + zBb2[t] == 1)

    # fixed ballast
    for t in TB:
        # Condition114f1
        for p in fixBallastPort:
            if int(p) > 0:
                solver.Add(B_locked.get(t, {}).get(int(p), 0) == wB[t][int(p)])

    # deballast amt
    # Condition114g1
    for p in list(set(loadPort).intersection(set(P_stable))):
        solver.Add(solver.Sum([wB[t][p] for t in TB]) + deballastPercent * loadingPortAmt[p] >=
                    solver.Sum([wB[t][p - 1] for t in TB]))

    # ballast amount
    # Condition114g2:
    if inputs.module in ['LOADABLE']:
        if inputs.mode in ['FullManual']:
            for p in list(set(dischargePort).intersection(set(P_stable))):
                solver.Add(solver.Sum([wB[t][p - 1] for t in TB]) + ballastPercent * dischargePortAmt[p] >=
                            solver.Sum([wB[t][p] for t in TB]))
        else:
            print('Condition114g2 dropped under LOADABLE but not FullManual')
    elif inputs.module in ['LOADING']:
        print('Condition114g2 dropped under LOADING')
    elif inputs.module in ['DISCHARGE']:
        for p in list(set(dischargePort).intersection(set(P_stable))):
            solver.Add(solver.Sum([wB[t][p-1] for t in TB]) + ballastPercent * dischargePortAmt[p] >=
                        solver.Sum([wB[t][p] for t in TB]))

    # cond_one = inputs.module in ['DISCHARGE']
    # cond_two = inputs.module in ['LOADABLE'] and inputs.mode not in ['FullManual']
    # cond_three = inputs.module not in ['LOADING']
    # cond = cond_one or cond_two or cond_three
    # if cond:
    #     for p in list(set(dischargePort).intersection(set(P_stable))):
    #         solver.Add(solver.Sum([wB[t][p-1] for t in TB]) + ballastPercent * dischargePortAmt[p] >=
    #                    solver.Sum([wB[t][p] for t in TB]))

    # Condition114h: departure of last loading port
    for t in lastLoadingPortBallastBan:
        for p in specialBallastPort:
            solver.Add(xB[t][p] == 0)

    # Condition114h1: arrival of last loading port
    for t in TB:
        for p in zeroBallastPort:
            solver.Add(xB[t][p] == 0)

    # Condition114i1: banned ballast
    for t in ballastBan:
        for p in P:
            solver.Add(xB[t][p] == 0)

    # LOADING
    # Condition115
    for p in P:
        solver.Add(solver.Sum([wB[t][p-1] for t in toDeballastTank]) -
                    solver.Sum([wB[t][p] for t in toDeballastTank]) <=
                    ballastLimit[p])

    ### ship stability
    # assume the ship satisfies all the stability conditions when entering the first port,
    # and ballast tank allocation will be refreshed before leaving each port.

    # Constr17a: displacement
    for t in T:
        for p in P:
            solver.Add(wC[t][p] == onboard.get(t, 0.) + solver.Sum([qw2f[c][t][p]/10 for c in C]))

    ## draft constraint
    # displacement
    for p in P:
        # Constr13c1
        solver.Add(displacement[p] ==
                    solver.Sum([wC[t][p] for t in T]) + solver.Sum([wB[t][p] for t in TB]) +
                    solver.Sum([weightOtherTank.get(t, {}).get(p, 0.) for t in OtherTanks]) +
                    lightWeight + deadweightConst)
        # Constr13c2
        solver.Add(displacement1[p] == displacement[p] * 1.025 / densitySeaWater[p])

    # loading and unloading port
    # Constr13
    for p in P_stable1:
        solver.Add(displacement[p] >= displacementLowLimit[p] + 0.001)
        solver.Add(displacement[p] <= displacementLimit[p] - 0.001)

    # deadweight constraint
    # Constr13a
    for p in P_stable:
        solver.Add(solver.Sum([wC[t][p] for t in T]) +
                    solver.Sum([wB[t][p] for t in TB]) +
                    solver.Sum([weightOtherTank.get(t, {}).get(p, 0.) for t in OtherTanks]) +
                    deadweightConst <= deadweight)

    # Constr13b
    if inputs.module not in ['DISCHARGE']:
        for p in P_last_loading:
            solver.Add(solver.Sum([wC[t][p] for t in T]) <= cargoweight)

    ## New list constraint -----------------------------------------------
    # ballast
    # Constr15b1: 10 pieces in multi-pieces linear curve
    lambda1_TB = {}
    lambda2_TB = {}
    lambda3_TB = {}
    lambda4_TB = {}
    lambda5_TB = {}
    lambda6_TB = {}
    lambda7_TB = {}
    lambda8_TB = {}
    lambda9_TB = {}
    lambda10_TB = {}
    lambda11_TB = {}

    z1_TB = {}
    z2_TB = {}
    z3_TB = {}
    z4_TB = {}

    for t in list(set(TB) - set(TB1)):
        lambda1_TB[t] = {}
        lambda2_TB[t] = {}
        lambda3_TB[t] = {}
        lambda4_TB[t] = {}
        lambda5_TB[t] = {}
        lambda6_TB[t] = {}
        lambda7_TB[t] = {}
        lambda8_TB[t] = {}
        lambda9_TB[t] = {}
        lambda10_TB[t] = {}
        lambda11_TB[t] = {}
        z1_TB[t] = {}
        z2_TB[t] = {}
        z3_TB[t] = {}
        z4_TB[t] = {}

        for p in P_stable:
            lambda1_TB[t][p] = solver.NumVar(0, 1, 'lambda1_TB[%s][%d]' % (t, p))
            lambda2_TB[t][p] = solver.NumVar(0, 1, 'lambda2_TB[%s][%d]' % (t, p))
            lambda3_TB[t][p] = solver.NumVar(0, 1, 'lambda3_TB[%s][%d]' % (t, p))
            lambda4_TB[t][p] = solver.NumVar(0, 1, 'lambda4_TB[%s][%d]' % (t, p))
            lambda5_TB[t][p] = solver.NumVar(0, 1, 'lambda5_TB[%s][%d]' % (t, p))
            lambda6_TB[t][p] = solver.NumVar(0, 1, 'lambda6_TB[%s][%d]' % (t, p))
            lambda7_TB[t][p] = solver.NumVar(0, 1, 'lambda7_TB[%s][%d]' % (t, p))
            lambda8_TB[t][p] = solver.NumVar(0, 1, 'lambda8_TB[%s][%d]' % (t, p))
            lambda9_TB[t][p] = solver.NumVar(0, 1, 'lambda9_TB[%s][%d]' % (t, p))
            lambda10_TB[t][p] = solver.NumVar(0, 1, 'lambda10_TB[%s][%d]' % (t, p))
            lambda11_TB[t][p] = solver.NumVar(0, 1, 'lambda11_TB[%s][%d]' % (t, p))
            z1_TB[t][p] = solver.IntVar(0, 1, 'z1_TB[%s][%d]' % (t, p))
            z2_TB[t][p] = solver.IntVar(0, 1, 'z2_TB[%s][%d]' % (t, p))
            z3_TB[t][p] = solver.IntVar(0, 1, 'z3_TB[%s][%d]' % (t, p))
            z4_TB[t][p] = solver.IntVar(0, 1, 'z4_TB[%s][%d]' % (t, p))

            solver.Add(lambda3_TB[t][p] + lambda7_TB[t][p] + lambda11_TB[t][p] <= z1_TB[t][p])
            solver.Add(lambda1_TB[t][p] + lambda5_TB[t][p] + lambda9_TB[t][p] <= 1 - z1_TB[t][p])
            solver.Add(lambda4_TB[t][p] + lambda5_TB[t][p] + lambda6_TB[t][p] <= z2_TB[t][p])
            solver.Add(lambda1_TB[t][p] + lambda2_TB[t][p] + lambda8_TB[t][p] +
                        lambda9_TB[t][p] + lambda10_TB[t][p] + lambda11_TB[t][p] <= 1 - z2_TB[t][p])
            solver.Add(lambda6_TB[t][p] + lambda7_TB[t][p] + lambda8_TB[t][p] +
                        lambda9_TB[t][p] + lambda10_TB[t][p] + lambda11_TB[t][p] <= z3_TB[t][p])
            solver.Add(lambda1_TB[t][p] + lambda2_TB[t][p] + lambda3_TB[t][p] +
                        lambda4_TB[t][p] <= 1 - z3_TB[t][p])
            solver.Add(lambda10_TB[t][p] + lambda11_TB[t][p] <= z4_TB[t][p])
            solver.Add(lambda1_TB[t][p] + lambda2_TB[t][p] + lambda3_TB[t][p] +
                        lambda4_TB[t][p] + lambda5_TB[t][p] + lambda6_TB[t][p] +
                        lambda7_TB[t][p] + lambda8_TB[t][p] <= 1 - z4_TB[t][p])

            solver.Add(lambda1_TB[t][p] + lambda2_TB[t][p] + lambda3_TB[t][p] +
                        lambda4_TB[t][p] + lambda5_TB[t][p] + lambda6_TB[t][p] +
                        lambda7_TB[t][p] + lambda8_TB[t][p] + lambda9_TB[t][p] +
                        lambda10_TB[t][p] + lambda11_TB[t][p] == 1)

            # Constr15b1
            solver.Add(wB[t][p] ==
                        lambda1_TB[t][p] * bTank_n[0][t] + lambda2_TB[t][p] * bTank_n[1][t] + lambda3_TB[t][p] *
                        bTank_n[2][t] +
                        lambda4_TB[t][p] * bTank_n[3][t] + lambda5_TB[t][p] * bTank_n[4][t] + lambda6_TB[t][p] *
                        bTank_n[5][t] +
                        lambda7_TB[t][p] * bTank_n[6][t] + lambda8_TB[t][p] * bTank_n[7][t] + lambda9_TB[t][p] *
                        bTank_n[8][t] +
                        lambda10_TB[t][p] * bTank_n[9][t] + lambda11_TB[t][p] * bTank_n[10][t])

            # Constr15b1
            solver.Add(TB_tmom[t][p] ==
                        lambda1_TB[t][p] * cTank_n[0][t] + lambda2_TB[t][p] * cTank_n[1][t] + lambda3_TB[t][p] *
                        cTank_n[2][t] +
                        lambda4_TB[t][p] * cTank_n[3][t] + lambda5_TB[t][p] * cTank_n[4][t] + lambda6_TB[t][p] *
                        cTank_n[5][t] +
                        lambda7_TB[t][p] * cTank_n[6][t] + lambda8_TB[t][p] * cTank_n[7][t] + lambda9_TB[t][p] *
                        cTank_n[8][t] +
                        lambda10_TB[t][p] * cTank_n[9][t] + lambda11_TB[t][p] * cTank_n[10][t])

    # Constr15b2
    for t in TB1:
        for p in P_stable:
            solver.Add(TB_tmom[t][p] == wB[t][p] * TCGt[t])

    # cargo
    # Constr15c1
    lambda1_T = {}
    lambda2_T = {}
    lambda3_T = {}
    lambda4_T = {}
    lambda5_T = {}
    lambda6_T = {}
    lambda7_T = {}
    lambda8_T = {}
    lambda9_T = {}
    lambda10_T = {}
    lambda11_T = {}

    z1_T = {}
    z2_T = {}
    z3_T = {}
    z4_T = {}

    for t in list(set(T) - set(T1)):
        lambda1_T[t] = {}
        lambda2_T[t] = {}
        lambda3_T[t] = {}
        lambda4_T[t] = {}
        lambda5_T[t] = {}
        lambda6_T[t] = {}
        lambda7_T[t] = {}
        lambda8_T[t] = {}
        lambda9_T[t] = {}
        lambda10_T[t] = {}
        lambda11_T[t] = {}
        z1_T[t] = {}
        z2_T[t] = {}
        z3_T[t] = {}
        z4_T[t] = {}

        for p in P_stable:
            lambda1_T[t][p] = solver.NumVar(0, 1, 'lambda1_T[%s][%d]' % (t, p))
            lambda2_T[t][p] = solver.NumVar(0, 1, 'lambda2_T[%s][%d]' % (t, p))
            lambda3_T[t][p] = solver.NumVar(0, 1, 'lambda3_T[%s][%d]' % (t, p))
            lambda4_T[t][p] = solver.NumVar(0, 1, 'lambda4_T[%s][%d]' % (t, p))
            lambda5_T[t][p] = solver.NumVar(0, 1, 'lambda5_T[%s][%d]' % (t, p))
            lambda6_T[t][p] = solver.NumVar(0, 1, 'lambda6_T[%s][%d]' % (t, p))
            lambda7_T[t][p] = solver.NumVar(0, 1, 'lambda7_T[%s][%d]' % (t, p))
            lambda8_T[t][p] = solver.NumVar(0, 1, 'lambda8_T[%s][%d]' % (t, p))
            lambda9_T[t][p] = solver.NumVar(0, 1, 'lambda9_T[%s][%d]' % (t, p))
            lambda10_T[t][p] = solver.NumVar(0, 1, 'lambda10_T[%s][%d]' % (t, p))
            lambda11_T[t][p] = solver.NumVar(0, 1, 'lambda11_T[%s][%d]' % (t, p))
            z1_T[t][p] = solver.IntVar(0, 1, 'z1_T[%s][%d]' % (t, p))
            z2_T[t][p] = solver.IntVar(0, 1, 'z2_T[%s][%d]' % (t, p))
            z3_T[t][p] = solver.IntVar(0, 1, 'z3_T[%s][%d]' % (t, p))
            z4_T[t][p] = solver.IntVar(0, 1, 'z4_T[%s][%d]' % (t, p))

            solver.Add(lambda3_T[t][p] + lambda7_T[t][p] + lambda11_T[t][p] <= z1_T[t][p])
            solver.Add(lambda1_T[t][p] + lambda5_T[t][p] + lambda9_T[t][p] <= 1 - z1_T[t][p])
            solver.Add(lambda4_T[t][p] + lambda5_T[t][p] + lambda6_T[t][p] <= z2_T[t][p])
            solver.Add(lambda1_T[t][p] + lambda2_T[t][p] + lambda8_T[t][p] +
                        lambda9_T[t][p] + lambda10_T[t][p] + lambda11_T[t][p] <= 1 - z2_T[t][p])
            solver.Add(lambda6_T[t][p] + lambda7_T[t][p] + lambda8_T[t][p] +
                        lambda9_T[t][p] + lambda10_T[t][p] + lambda11_T[t][p] <= z3_T[t][p])
            solver.Add(lambda1_T[t][p] + lambda2_T[t][p] + lambda3_T[t][p] +
                        lambda4_T[t][p] <= 1 - z3_T[t][p])
            solver.Add(lambda10_T[t][p] + lambda11_T[t][p] <= z4_T[t][p])
            solver.Add(lambda1_T[t][p] + lambda2_T[t][p] + lambda3_T[t][p] +
                        lambda4_T[t][p] + lambda5_T[t][p] + lambda6_T[t][p] +
                        lambda7_T[t][p] + lambda8_T[t][p] <= 1 - z4_T[t][p])

            solver.Add(lambda1_T[t][p] + lambda2_T[t][p] + lambda3_T[t][p] +
                        lambda4_T[t][p] + lambda5_T[t][p] + lambda6_T[t][p] +
                        lambda7_T[t][p] + lambda8_T[t][p] + lambda9_T[t][p] +
                        lambda10_T[t][p] + lambda11_T[t][p] == 1)

            # Constr15c1
            solver.Add(wC[t][p] ==
                        lambda1_T[t][p] * bTank_n[0][t] + lambda2_T[t][p] * bTank_n[1][t] + lambda3_T[t][p] *
                        bTank_n[2][t] +
                        lambda4_T[t][p] * bTank_n[3][t] + lambda5_T[t][p] * bTank_n[4][t] + lambda6_T[t][p] *
                        bTank_n[5][t] +
                        lambda7_T[t][p] * bTank_n[6][t] + lambda8_T[t][p] * bTank_n[7][t] + lambda9_T[t][p] *
                        bTank_n[8][t] +
                        lambda10_T[t][p] * bTank_n[9][t] + lambda11_T[t][p] * bTank_n[10][t])

            # Constr15c1
            solver.Add(T_tmom[t][p] ==
                        lambda1_T[t][p] * cTank_n[0][t] + lambda2_T[t][p] * cTank_n[1][t] + lambda3_T[t][p] *
                        cTank_n[2][t] +
                        lambda4_T[t][p] * cTank_n[3][t] + lambda5_T[t][p] * cTank_n[4][t] + lambda6_T[t][p] *
                        cTank_n[5][t] +
                        lambda7_T[t][p] * cTank_n[6][t] + lambda8_T[t][p] * cTank_n[7][t] + lambda9_T[t][p] *
                        cTank_n[8][t] +
                        lambda10_T[t][p] * cTank_n[9][t] + lambda11_T[t][p] * cTank_n[10][t])

    # Constr15c2
    for t in T1:
        for p in P_stable:
            solver.Add(T_tmom[t][p] == wC[t][p] * TCGt[t])

    for p in P_stable:
        # Constr153
        solver.Add(T_mom[p] ==
                    solver.Sum([T_tmom[t][p] for t in T]) +
                    solver.Sum([TB_tmom[t][p] for t in TB]) +
                    solver.Sum([weightOtherTank.get(t,{}).get(p,0.) * TCGtp.get(t,{}).get(p,0.) for t in OtherTanks]) +
                    deadweightConst * TCGdw)
        # Constr154
        solver.Add(T_mom[p] >= -ListMOM)
        solver.Add(T_mom[p] <= ListMOM)

    ## Trim constraint -----------------------------------------------------------
    lambda1l_TB = {}
    lambda2l_TB = {}
    lambda3l_TB = {}
    lambda4l_TB = {}
    lambda5l_TB = {}
    lambda6l_TB = {}
    lambda7l_TB = {}
    lambda8l_TB = {}
    lambda9l_TB = {}
    lambda10l_TB = {}
    lambda11l_TB = {}

    z1l_TB = {}
    z2l_TB = {}
    z3l_TB = {}
    z4l_TB = {}

    for t in list(set(TB) - set(TB2)):
        lambda1l_TB[t] = {}
        lambda2l_TB[t] = {}
        lambda3l_TB[t] = {}
        lambda4l_TB[t] = {}
        lambda5l_TB[t] = {}
        lambda6l_TB[t] = {}
        lambda7l_TB[t] = {}
        lambda8l_TB[t] = {}
        lambda9l_TB[t] = {}
        lambda10l_TB[t] = {}
        lambda11l_TB[t] = {}
        z1l_TB[t] = {}
        z2l_TB[t] = {}
        z3l_TB[t] = {}
        z4l_TB[t] = {}

        for p in P_stable:
            lambda1l_TB[t][p] = solver.NumVar(0, 1, 'lambda1l_TB[%s][%d]' % (t, p))
            lambda2l_TB[t][p] = solver.NumVar(0, 1, 'lambda2l_TB[%s][%d]' % (t, p))
            lambda3l_TB[t][p] = solver.NumVar(0, 1, 'lambda3l_TB[%s][%d]' % (t, p))
            lambda4l_TB[t][p] = solver.NumVar(0, 1, 'lambda4l_TB[%s][%d]' % (t, p))
            lambda5l_TB[t][p] = solver.NumVar(0, 1, 'lambda5l_TB[%s][%d]' % (t, p))
            lambda6l_TB[t][p] = solver.NumVar(0, 1, 'lambda6l_TB[%s][%d]' % (t, p))
            lambda7l_TB[t][p] = solver.NumVar(0, 1, 'lambda7l_TB[%s][%d]' % (t, p))
            lambda8l_TB[t][p] = solver.NumVar(0, 1, 'lambda8l_TB[%s][%d]' % (t, p))
            lambda9l_TB[t][p] = solver.NumVar(0, 1, 'lambda9l_TB[%s][%d]' % (t, p))
            lambda10l_TB[t][p] = solver.NumVar(0, 1, 'lambda10l_TB[%s][%d]' % (t, p))
            lambda11l_TB[t][p] = solver.NumVar(0, 1, 'lambda11l_TB[%s][%d]' % (t, p))
            z1l_TB[t][p] = solver.IntVar(0, 1, 'z1l_TB[%s][%d]' % (t, p))
            z2l_TB[t][p] = solver.IntVar(0, 1, 'z2l_TB[%s][%d]' % (t, p))
            z3l_TB[t][p] = solver.IntVar(0, 1, 'z3l_TB[%s][%d]' % (t, p))
            z4l_TB[t][p] = solver.IntVar(0, 1, 'z4l_TB[%s][%d]' % (t, p))

            solver.Add(lambda3l_TB[t][p] + lambda7l_TB[t][p] + lambda11l_TB[t][p] <= z1l_TB[t][p])
            solver.Add(lambda1l_TB[t][p] + lambda5l_TB[t][p] + lambda9l_TB[t][p] <= 1 - z1l_TB[t][p])
            solver.Add(lambda4l_TB[t][p] + lambda5l_TB[t][p] + lambda6l_TB[t][p] <= z2l_TB[t][p])
            solver.Add(lambda1l_TB[t][p] + lambda2l_TB[t][p] + lambda8l_TB[t][p] +
                        lambda9l_TB[t][p] + lambda10l_TB[t][p] + lambda11l_TB[t][p] <= 1 - z2l_TB[t][p])
            solver.Add(lambda6l_TB[t][p] + lambda7l_TB[t][p] + lambda8l_TB[t][p] +
                        lambda9l_TB[t][p] + lambda10l_TB[t][p] + lambda11l_TB[t][p] <= z3l_TB[t][p])
            solver.Add(lambda1l_TB[t][p] + lambda2l_TB[t][p] + lambda3l_TB[t][p] +
                        lambda4l_TB[t][p] <= 1 - z3l_TB[t][p])
            solver.Add(lambda10l_TB[t][p] + lambda11l_TB[t][p] <= z4l_TB[t][p])
            solver.Add(lambda1l_TB[t][p] + lambda2l_TB[t][p] + lambda3l_TB[t][p] +
                        lambda4l_TB[t][p] + lambda5l_TB[t][p] + lambda6l_TB[t][p] +
                        lambda7l_TB[t][p] + lambda8l_TB[t][p] <= 1 - z4l_TB[t][p])

            solver.Add(lambda1l_TB[t][p] + lambda2l_TB[t][p] + lambda3l_TB[t][p] +
                        lambda4l_TB[t][p] + lambda5l_TB[t][p] + lambda6l_TB[t][p] +
                        lambda7l_TB[t][p] + lambda8l_TB[t][p] + lambda9l_TB[t][p] +
                        lambda10l_TB[t][p] + lambda11l_TB[t][p] == 1)

            # Constr16b1
            solver.Add(wB[t][p] ==
                        lambda1l_TB[t][p] * bTankl_n[0][t] + lambda2l_TB[t][p] * bTankl_n[1][t] + lambda3l_TB[t][p] *
                        bTankl_n[2][t] +
                        lambda4l_TB[t][p] * bTankl_n[3][t] + lambda5l_TB[t][p] * bTankl_n[4][t] + lambda6l_TB[t][p] *
                        bTankl_n[5][t] +
                        lambda7l_TB[t][p] * bTankl_n[6][t] + lambda8l_TB[t][p] * bTankl_n[7][t] + lambda9l_TB[t][p] *
                        bTankl_n[8][t] +
                        lambda10l_TB[t][p] * bTankl_n[9][t] + lambda11l_TB[t][p] * bTankl_n[10][t])

            # Constr16b1
            solver.Add(TB_lmom[t][p] == 1000 *
                        (lambda1l_TB[t][p] * cTankl_n[0][t] + lambda2l_TB[t][p] * cTankl_n[1][t] + lambda3l_TB[t][
                            p] * cTankl_n[2][t] +
                        lambda4l_TB[t][p] * cTankl_n[3][t] + lambda5l_TB[t][p] * cTankl_n[4][t] + lambda6l_TB[t][
                            p] * cTankl_n[5][t] +
                        lambda7l_TB[t][p] * cTankl_n[6][t] + lambda8l_TB[t][p] * cTankl_n[7][t] + lambda9l_TB[t][
                            p] * cTankl_n[8][t] +
                        lambda10l_TB[t][p] * cTankl_n[9][t] + lambda11l_TB[t][p] * cTankl_n[10][t]))

    # Constr16b2
    for t in TB2:
        for p in P_stable:
            solver.Add(TB_lmom[t][p] == wB[t][p] * LCGt[t])

    lambda1_LCB = {}
    lambda2_LCB = {}
    lambda3_LCB = {}
    lambda4_LCB = {}
    lambda5_LCB = {}
    lambda6_LCB = {}
    lambda7_LCB = {}
    lambda8_LCB = {}
    lambda9_LCB = {}
    lambda10_LCB = {}
    lambda11_LCB = {}

    z1_LCB = {}
    z2_LCB = {}
    z3_LCB = {}
    z4_LCB = {}

    lambda1_MTC = {}
    lambda2_MTC = {}
    lambda3_MTC = {}
    lambda4_MTC = {}
    lambda5_MTC = {}
    lambda6_MTC = {}
    lambda7_MTC = {}
    lambda8_MTC = {}
    lambda9_MTC = {}
    lambda10_MTC = {}
    lambda11_MTC = {}

    z1_MTC = {}
    z2_MTC = {}
    z3_MTC = {}
    z4_MTC = {}

    for p in P_stable:
        # Constr161
        solver.Add(L_mom[p] ==
                    solver.Sum([wC[t][p] * LCGt[t] for t in T]) +
                    solver.Sum([TB_lmom[t][p] for t in TB]) +
                    solver.Sum(
                        [weightOtherTank.get(t, {}).get(p, 0.) * LCGtp.get(t, {}).get(p, 0.) for t in OtherTanks]) +
                    lightWeight * LCGship + deadweightConst * LCGdw)

        # Constr163
        lambda1_LCB[p] = solver.NumVar(0, 1, 'lambda1_LCB[%d]' % p)
        lambda2_LCB[p] = solver.NumVar(0, 1, 'lambda2_LCB[%d]' % p)
        lambda3_LCB[p] = solver.NumVar(0, 1, 'lambda3_LCB[%d]' % p)
        lambda4_LCB[p] = solver.NumVar(0, 1, 'lambda4_LCB[%d]' % p)
        lambda5_LCB[p] = solver.NumVar(0, 1, 'lambda5_LCB[%d]' % p)
        lambda6_LCB[p] = solver.NumVar(0, 1, 'lambda6_LCB[%d]' % p)
        lambda7_LCB[p] = solver.NumVar(0, 1, 'lambda7_LCB[%d]' % p)
        lambda8_LCB[p] = solver.NumVar(0, 1, 'lambda8_LCB[%d]' % p)
        lambda9_LCB[p] = solver.NumVar(0, 1, 'lambda9_LCB[%d]' % p)
        lambda10_LCB[p] = solver.NumVar(0, 1, 'lambda10_LCB[%d]' % p)
        lambda11_LCB[p] = solver.NumVar(0, 1, 'lambda11_LCB[%d]' % p)
        z1_LCB[p] = solver.IntVar(0, 1, 'z1_LCB[%d]' % p)
        z2_LCB[p] = solver.IntVar(0, 1, 'z2_LCB[%d]' % p)
        z3_LCB[p] = solver.IntVar(0, 1, 'z3_LCB[%d]' % p)
        z4_LCB[p] = solver.IntVar(0, 1, 'z4_LCB[%d]' % p)

        solver.Add(lambda3_LCB[p] + lambda7_LCB[p] + lambda11_LCB[p] <= z1_LCB[p])
        solver.Add(lambda1_LCB[p] + lambda5_LCB[p] + lambda9_LCB[p] <= 1 - z1_LCB[p])
        solver.Add(lambda4_LCB[p] + lambda5_LCB[p] + lambda6_LCB[p] <= z2_LCB[p])
        solver.Add(lambda1_LCB[p] + lambda2_LCB[p] + lambda8_LCB[p] +
                    lambda9_LCB[p] + lambda10_LCB[p] + lambda11_LCB[p] <= 1 - z2_LCB[p])
        solver.Add(lambda6_LCB[p] + lambda7_LCB[p] + lambda8_LCB[p] +
                    lambda9_LCB[p] + lambda10_LCB[p] + lambda11_LCB[p] <= z3_LCB[p])
        solver.Add(lambda1_LCB[p] + lambda2_LCB[p] + lambda3_LCB[p] +
                    lambda4_LCB[p] <= 1 - z3_LCB[p])
        solver.Add(lambda10_LCB[p] + lambda11_LCB[p] <= z4_LCB[p])
        solver.Add(lambda1_LCB[p] + lambda2_LCB[p] + lambda3_LCB[p] +
                    lambda4_LCB[p] + lambda5_LCB[p] + lambda6_LCB[p] +
                    lambda7_LCB[p] + lambda8_LCB[p] <= 1 - z4_LCB[p])

        solver.Add(lambda1_LCB[p] + lambda2_LCB[p] + lambda3_LCB[p] +
                    lambda4_LCB[p] + lambda5_LCB[p] + lambda6_LCB[p] +
                    lambda7_LCB[p] + lambda8_LCB[p] + lambda9_LCB[p] +
                    lambda10_LCB[p] + lambda11_LCB[p] == 1)

        # Constr163
        solver.Add(displacement1[p] ==
                    lambda1_LCB[p] * bLCB_n[0] + lambda2_LCB[p] * bLCB_n[1] + lambda3_LCB[p] * bLCB_n[2] +
                    lambda4_LCB[p] * bLCB_n[3] + lambda5_LCB[p] * bLCB_n[4] + lambda6_LCB[p] * bLCB_n[5] +
                    lambda7_LCB[p] * bLCB_n[6] + lambda8_LCB[p] * bLCB_n[7] + lambda9_LCB[p] * bLCB_n[8] +
                    lambda10_LCB[p] * bLCB_n[9] + lambda11_LCB[p] * bLCB_n[10])

        # Constr163
        solver.Add(LCBp[p] ==
                    lambda1_LCB[p] * cLCB_n[0] + lambda2_LCB[p] * cLCB_n[1] + lambda3_LCB[p] * cLCB_n[2] +
                    lambda4_LCB[p] * cLCB_n[3] + lambda5_LCB[p] * cLCB_n[4] + lambda6_LCB[p] * cLCB_n[5] +
                    lambda7_LCB[p] * cLCB_n[6] + lambda8_LCB[p] * cLCB_n[7] + lambda9_LCB[p] * cLCB_n[8] +
                    lambda10_LCB[p] * cLCB_n[9] + lambda11_LCB[p] * cLCB_n[10])

        # Constr164
        lambda1_MTC[p] = solver.NumVar(0, 1, 'lambda1_MTC[%d]' % p)
        lambda2_MTC[p] = solver.NumVar(0, 1, 'lambda2_MTC[%d]' % p)
        lambda3_MTC[p] = solver.NumVar(0, 1, 'lambda3_MTC[%d]' % p)
        lambda4_MTC[p] = solver.NumVar(0, 1, 'lambda4_MTC[%d]' % p)
        lambda5_MTC[p] = solver.NumVar(0, 1, 'lambda5_MTC[%d]' % p)
        lambda6_MTC[p] = solver.NumVar(0, 1, 'lambda6_MTC[%d]' % p)
        lambda7_MTC[p] = solver.NumVar(0, 1, 'lambda7_MTC[%d]' % p)
        lambda8_MTC[p] = solver.NumVar(0, 1, 'lambda8_MTC[%d]' % p)
        lambda9_MTC[p] = solver.NumVar(0, 1, 'lambda9_MTC[%d]' % p)
        lambda10_MTC[p] = solver.NumVar(0, 1, 'lambda10_MTC[%d]' % p)
        lambda11_MTC[p] = solver.NumVar(0, 1, 'lambda11_MTC[%d]' % p)
        z1_MTC[p] = solver.IntVar(0, 1, 'z1_MTC[%d]' % p)
        z2_MTC[p] = solver.IntVar(0, 1, 'z2_MTC[%d]' % p)
        z3_MTC[p] = solver.IntVar(0, 1, 'z3_MTC[%d]' % p)
        z4_MTC[p] = solver.IntVar(0, 1, 'z4_MTC[%d]' % p)

        solver.Add(lambda3_MTC[p] + lambda7_MTC[p] + lambda11_MTC[p] <= z1_MTC[p])
        solver.Add(lambda1_MTC[p] + lambda5_MTC[p] + lambda9_MTC[p] <= 1 - z1_MTC[p])
        solver.Add(lambda4_MTC[p] + lambda5_MTC[p] + lambda6_MTC[p] <= z2_MTC[p])
        solver.Add(lambda1_MTC[p] + lambda2_MTC[p] + lambda8_MTC[p] +
                    lambda9_MTC[p] + lambda10_MTC[p] + lambda11_MTC[p] <= 1 - z2_MTC[p])
        solver.Add(lambda6_MTC[p] + lambda7_MTC[p] + lambda8_MTC[p] +
                    lambda9_MTC[p] + lambda10_MTC[p] + lambda11_MTC[p] <= z3_MTC[p])
        solver.Add(lambda1_MTC[p] + lambda2_MTC[p] + lambda3_MTC[p] +
                    lambda4_MTC[p] <= 1 - z3_MTC[p])
        solver.Add(lambda10_MTC[p] + lambda11_MTC[p] <= z4_MTC[p])
        solver.Add(lambda1_MTC[p] + lambda2_MTC[p] + lambda3_MTC[p] +
                    lambda4_MTC[p] + lambda5_MTC[p] + lambda6_MTC[p] +
                    lambda7_MTC[p] + lambda8_MTC[p] <= 1 - z4_MTC[p])

        solver.Add(lambda1_MTC[p] + lambda2_MTC[p] + lambda3_MTC[p] +
                    lambda4_MTC[p] + lambda5_MTC[p] + lambda6_MTC[p] +
                    lambda7_MTC[p] + lambda8_MTC[p] + lambda9_MTC[p] +
                    lambda10_MTC[p] + lambda11_MTC[p] == 1)

        # Constr164
        solver.Add(displacement1[p] ==
                    lambda1_MTC[p] * bMTC_n[0] + lambda2_MTC[p] * bMTC_n[1] + lambda3_MTC[p] * bMTC_n[2] +
                    lambda4_MTC[p] * bMTC_n[3] + lambda5_MTC[p] * bMTC_n[4] + lambda6_MTC[p] * bMTC_n[5] +
                    lambda7_MTC[p] * bMTC_n[6] + lambda8_MTC[p] * bMTC_n[7] + lambda9_MTC[p] * bMTC_n[8] +
                    lambda10_MTC[p] * bMTC_n[9] + lambda11_MTC[p] * bMTC_n[10])

        # Constr164
        solver.Add(MTCp[p] ==
                    lambda1_MTC[p] * cMTC_n[0] + lambda2_MTC[p] * cMTC_n[1] + lambda3_MTC[p] * cMTC_n[2] +
                    lambda4_MTC[p] * cMTC_n[3] + lambda5_MTC[p] * cMTC_n[4] + lambda6_MTC[p] * cMTC_n[5] +
                    lambda7_MTC[p] * cMTC_n[6] + lambda8_MTC[p] * cMTC_n[7] + lambda9_MTC[p] * cMTC_n[8] +
                    lambda10_MTC[p] * cMTC_n[9] + lambda11_MTC[p] * cMTC_n[10])

        # Constr16a
        solver.Add(MTCp[p] * trim_lower.get(p, -0.001) * 100 <= L_mom[p] - LCBp[p])

        # Constr16b
        solver.Add(MTCp[p] * trim_upper.get(p, 0.001) * 100 >= L_mom[p] - LCBp[p])

    ## SF and BM
    # wn, mn
    lambda1_Draft = {}
    lambda2_Draft = {}
    lambda3_Draft = {}
    lambda4_Draft = {}
    lambda5_Draft = {}
    lambda6_Draft = {}
    lambda7_Draft = {}
    lambda8_Draft = {}
    lambda9_Draft = {}
    lambda10_Draft = {}
    lambda11_Draft = {}

    z1_Draft = {}
    z2_Draft = {}
    z3_Draft = {}
    z4_Draft = {}

    for p in P:
        # Constr18a
        solver.Add(wn[0][p] == 0)

        # Constr19a
        solver.Add(mn[0][p] == 0)

        # Constr18d: mean_draft=pwl(displacement)
        lambda1_Draft[p] = solver.NumVar(0, 1, 'lambda1_Draft[%d]' % p)
        lambda2_Draft[p] = solver.NumVar(0, 1, 'lambda2_Draft[%d]' % p)
        lambda3_Draft[p] = solver.NumVar(0, 1, 'lambda3_Draft[%d]' % p)
        lambda4_Draft[p] = solver.NumVar(0, 1, 'lambda4_Draft[%d]' % p)
        lambda5_Draft[p] = solver.NumVar(0, 1, 'lambda5_Draft[%d]' % p)
        lambda6_Draft[p] = solver.NumVar(0, 1, 'lambda6_Draft[%d]' % p)
        lambda7_Draft[p] = solver.NumVar(0, 1, 'lambda7_Draft[%d]' % p)
        lambda8_Draft[p] = solver.NumVar(0, 1, 'lambda8_Draft[%d]' % p)
        lambda9_Draft[p] = solver.NumVar(0, 1, 'lambda9_Draft[%d]' % p)
        lambda10_Draft[p] = solver.NumVar(0, 1, 'lambda10_Draft[%d]' % p)
        lambda11_Draft[p] = solver.NumVar(0, 1, 'lambda11_Draft[%d]' % p)
        z1_Draft[p] = solver.IntVar(0, 1, 'z1_Draft[%d]' % p)
        z2_Draft[p] = solver.IntVar(0, 1, 'z2_Draft[%d]' % p)
        z3_Draft[p] = solver.IntVar(0, 1, 'z3_Draft[%d]' % p)
        z4_Draft[p] = solver.IntVar(0, 1, 'z4_Draft[%d]' % p)

        solver.Add(lambda3_Draft[p] + lambda7_Draft[p] + lambda11_Draft[p] <= z1_Draft[p])
        solver.Add(lambda1_Draft[p] + lambda5_Draft[p] + lambda9_Draft[p] <= 1 - z1_Draft[p])
        solver.Add(lambda4_Draft[p] + lambda5_Draft[p] + lambda6_Draft[p] <= z2_Draft[p])
        solver.Add(lambda1_Draft[p] + lambda2_Draft[p] + lambda8_Draft[p] +
                    lambda9_Draft[p] + lambda10_Draft[p] + lambda11_Draft[p] <= 1 - z2_Draft[p])
        solver.Add(lambda6_Draft[p] + lambda7_Draft[p] + lambda8_Draft[p] +
                    lambda9_Draft[p] + lambda10_Draft[p] + lambda11_Draft[p] <= z3_Draft[p])
        solver.Add(lambda1_Draft[p] + lambda2_Draft[p] + lambda3_Draft[p] +
                    lambda4_Draft[p] <= 1 - z3_Draft[p])
        solver.Add(lambda10_Draft[p] + lambda11_Draft[p] <= z4_Draft[p])
        solver.Add(lambda1_Draft[p] + lambda2_Draft[p] + lambda3_Draft[p] +
                    lambda4_Draft[p] + lambda5_Draft[p] + lambda6_Draft[p] +
                    lambda7_Draft[p] + lambda8_Draft[p] <= 1 - z4_Draft[p])

        solver.Add(lambda1_Draft[p] + lambda2_Draft[p] + lambda3_Draft[p] +
                    lambda4_Draft[p] + lambda5_Draft[p] + lambda6_Draft[p] +
                    lambda7_Draft[p] + lambda8_Draft[p] + lambda9_Draft[p] +
                    lambda10_Draft[p] + lambda11_Draft[p] == 1)
        # Constr18d
        solver.Add(displacement[p] ==
                    lambda1_Draft[p] * bDraft_n[0] + lambda2_Draft[p] * bDraft_n[1] + lambda3_Draft[p] * bDraft_n[2] +
                    lambda4_Draft[p] * bDraft_n[3] + lambda5_Draft[p] * bDraft_n[4] + lambda6_Draft[p] * bDraft_n[5] +
                    lambda7_Draft[p] * bDraft_n[6] + lambda8_Draft[p] * bDraft_n[7] + lambda9_Draft[p] * bDraft_n[8] +
                    lambda10_Draft[p] * bDraft_n[9] + lambda11_Draft[p] * bDraft_n[10])
        # Constr18d
        solver.Add(mean_draft[p] ==
                    lambda1_Draft[p] * cDraft_n[0] + lambda2_Draft[p] * cDraft_n[1] + lambda3_Draft[p] * cDraft_n[2] +
                    lambda4_Draft[p] * cDraft_n[3] + lambda5_Draft[p] * cDraft_n[4] + lambda6_Draft[p] * cDraft_n[5] +
                    lambda7_Draft[p] * cDraft_n[6] + lambda8_Draft[p] * cDraft_n[7] + lambda9_Draft[p] * cDraft_n[8] +
                    lambda10_Draft[p] * cDraft_n[9] + lambda11_Draft[p] * cDraft_n[10])

    for fr in range(1, Fr + 1):
        for p in P_stable:
            # Constr18b
            solver.Add(wn[fr][p] ==
                        wn[fr - 1][p] +
                        solver.Sum([weightRatio_ct.get(fr, {}).get(t, 0.) * wC[t][p] / 1000 for t in T]) +
                        solver.Sum([weightRatio_bt.get(fr, {}).get(t, 0.) * wB[t][p] / 1000 for t in TB]) +
                        solver.Sum(
                            [weightRatio_ot.get(fr, {}).get(t, 0.) * weightOtherTank.get(t, {}).get(p, 0.) / 1000
                            for t in OtherTanks]))

            # Constr19b
            solver.Add(mn[fr][p] ==
                        mn[fr - 1][p] +
                        solver.Sum(
                            [LCG_ct.get(fr, {}).get(t, 0.) * weightRatio_ct.get(fr, {}).get(t, 0.) * wC[t][p] / 1000
                            for t in T]) +
                        solver.Sum(
                            [LCG_bt.get(fr, {}).get(t, 0.) * weightRatio_bt.get(fr, {}).get(t, 0.) * wB[t][p] / 1000
                            for t in TB]) +
                        solver.Sum([LCG_ot.get(fr, {}).get(t, 0.) * weightRatio_ot.get(fr, {}).get(t,
                                                                                                  0.) * weightOtherTank.get(
                            t, {}).get(p, 0.) / 1000
                                    for t in OtherTanks]))

            # SF -> zero trim

            if inputs.vessel_id not in [1]:
                # Condition20a2
                solver.Add(SS[fr][p] ==
                            BV_SF[fr][p] +
                            CD_SF[fr][p] * (mean_draft[p] - base_draft[p]) +
                            CT_SF[fr][p] * est_trim[p])

            if inputs.vessel_id not in [2]:
                # Condition20a1
                solver.Add(SS[fr][p] ==
                            BV_SF[fr][p] +
                            CD_SF[fr][p] * (mean_draft[p] + 0.5 * est_trim[p] - base_draft[p]) +
                            CT_SF[fr][p] * est_trim[p])

            # Condition20b
            solver.Add(lowerSFlimit[fr] <= SS[fr][p] - wn[fr][p])

            # Condition20c
            solver.Add(SS[fr][p] - wn[fr][p] <= upperSFlimit[fr])

            if inputs.vessel_id not in [1]:
                # Condition21a2
                solver.Add(SB[fr][p] ==
                            BV_BM[fr][p] +
                            CD_BM[fr][p] * (mean_draft[p] - base_draft[p]) +
                            CT_BM[fr][p] * est_trim[p])

            if inputs.vessel_id not in [2]:
                # Condition21a1
                solver.Add(SB[fr][p] ==
                            BV_BM[fr][p] +
                            CD_BM[fr][p] * (mean_draft[p] + 0.5 * est_trim[p] - base_draft[p]) +
                            CT_BM[fr][p] * est_trim[p])

            # Condition21b
            solver.Add(lowerBMlimit[fr] <= wn[fr][p] * LCG_fr[fr] + mn[fr][p] - SB[fr][p])

            # Condition21c
            solver.Add(wn[fr][p] * LCG_fr[fr] + mn[fr][p] - SB[fr][p] <= upperBMlimit[fr])

    # Condition200a
    for p in P_stable:
        solver.Add(est_trim[p] == (trim_upper.get(p, 0.001) + trim_lower.get(p, -0.001))/2)

    # solver.ExportModelToProto('./model.proto')

    ##########################################
    ## Output
    ##########################################
    print(solver.ExportModelAsLpFormat(False).replace('\\', '').replace(',_', ','), sep='\n', file=open("or.txt", "w"))
    # Solve
    print('Number of variables = %d' % solver.NumVariables())
    print('Number of constraints = %d' % solver.NumConstraints())
    status = solver.Solve()
    # assert solver.VerifySolution(1e-5, True)

    if status in [0, 1]:
        if status == 0:
            print('Optimum solution is found.')
        else:
            print('Feasibile solution is found.')
        print('Objective value =', solver.Objective().Value())
        print('Problem solved in %f milliseconds' % solver.wall_time())
        print('Problem solved in %d branch-and-bound nodes' % solver.nodes())
        print('Problem solved in %d iterations' % solver.iterations())
        totloaded = 0
        for c in C:
            for t in Tc[c]:
                for p in P_last_loading:
                    totloaded = totloaded + qw2f[c][t][p].solution_value()/10

        num_sol = 1.0
        cargoloaded = {}
        cargoloaded[num_sol] = {}
        for c in C:
            cargoloaded[num_sol][c] = sum([qw2f[c][t][p].solution_value() / 10
                                           for t in Tc[c] for p in P_last_loading])
        res = {}
        shipStatus = {}
        xx = {}
        res[num_sol] = {}
        shipStatus[num_sol] = {}
        xx[num_sol] = {}

        for c in C:
            res[num_sol][c] = {}
            shipStatus[num_sol][c] = {}
            xx[num_sol][c] = {}
            for t in T:
                res[num_sol][c][t] = {}
                shipStatus[num_sol][c][t] = {}
                xx[num_sol][c][t] = x[c][t].solution_value()
                for p in P:
                    res[num_sol][c][t][p] = w[c][t][p].solution_value()
                    shipStatus[num_sol][c][t][p] = qw2f[c][t][p].solution_value() / 10

        wtB = {}
        wtB[num_sol] = {}
        for t in TB:
            wtB[num_sol][t] = {}
            for p in P:
                wtB[num_sol][t][p] = wB[t][p].solution_value()

        cargoloadedport = {}
        cargoloadedport[num_sol] = {}
        for c in C:
            cargoloadedport[num_sol][c] = {}
            for p in P:
                cargoloadedport[num_sol][c][p] = 0
                cargoloadedport[num_sol][c][p] = sum([qw2f[c][t][p].solution_value() / 10 for t in Tc[c]])

        return {'status': status,
                'totloaded': [(1, totloaded)],
                'cargoloaded': [(k, t, x) for k, v, in cargoloaded.items() for t, x in v.items()],
                'res': [(k, t, u, w, p) for k, v, in res.items() for t, x in v.items() for u, y in x.items() for w, p in
                        y.items()],
                'shipStatus': [(k, t, u, w, p) for k, v, in shipStatus.items() for t, x in v.items() for u, y in
                               x.items() for w, p in y.items()],
                'xx': [(k, t, u, y) for k, v, in xx.items() for t, x in v.items() for u, y in x.items()],
                'wtB': [(k, t, u, y) for k, v, in wtB.items() for t, x in v.items() for u, y in x.items()],
                'cargoloadedport': [(k, t, u, y) for k, v, in cargoloadedport.items() for t, x in v.items() for u, y in
                                    x.items()],
                'obj': [(1, Action_Amount.solution_value())]}

        # for i in TB:
        #     for j in P:
        #         print(wB[i][j].name(), ' = ', wB[i][j].solution_value())

    else:
        print(status, 'The problem does not have an feasible solution.')
        return {'status': None,
                'totloaded': [],
                'cargoloaded': [],
                'res': [],
                'shipStatus': [],
                'xx': [],
                'wtB': [],
                'cargoloadedport': [],
                'obj': []}
    
