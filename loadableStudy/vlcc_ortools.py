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

def vlcc_ortools(inputs):
    
    # print('run ortools ...')
    
     # Create the mip solver with the SCIP backend.
    solver = pywraplp.Solver.CreateSolver('CBC') # 'SCIP', 'CBC', 'GLPK'
    solver.SetTimeLimit(900*1000)
    # solver.SetNumThreads(4)
    
    infinity = solver.infinity()
    
    # Parameter initialization
    ## ------------------------------------------------------------------
    # set of all cargo tanks'
    # cargo_tanks_ = []
    T = [i_ for i_,j_ in inputs.vessel.info['cargoTanks'].items()]
    # cargo tanks with non-pw tcg details
    T1 = [i_ for i_, j_ in inputs.vessel.info['cargoTanks'].items() if i_ not in inputs.vessel.info['tankTCG']['tcg_pw']]
    # set of all cargoes
    C = [i_ for i_,j_ in inputs.loadable.info['parcel'].items()]
    
    # set of tanks compatible with cargo c (consider tank coating, cargo history, tank heating)
    Tc = {}
    # print('# set of tanks compatible with cargo c',file=text_file)
    for i_,j_ in inputs.loadable.info['parcel'].items():
         Tc[i_] = [j_ for j_ in T if j_ not in inputs.vessel.info['banCargo'][i_]]
         
    # set of tanks compatible with cargo c (consider tank coating, cargo history, tank heating)
    Ct = {}
    for i in T:
        Ct[i] = [j for j in C if i in Tc[j]]
    
    # set of all loaded cargoes (partial loading condition)
    # set of loaded tanks (partial loading condition
    T_loaded = []
    C_loaded = []        
    I_loaded = {}
    W_loaded = {}     
    V_loaded = {}
    W0 = {}
    Q0 = {}           
              
    # total number of ports in the booking list
    NP = int(inputs.loadable.info['lastVirtualPort'])
    # the last loading port
    LP = int(inputs.loadable.info['lastVirtualPort']-1)
    
    # set of ports
    P = list(range(1,NP+1))
    # a virtual port before the first port
    P_org = [0]
    # union P and P_org
    Pbar = P + P_org
    # set of loading ports
    P_load = list(range(1,LP+1))
    # set of discharging ports
    P_dis = list(range(LP+1,NP+1))
    # the last loading port
    P_last_loading = [LP]
    
        
    # cargo density @ low temperature (in t/m3)
    densityCargo_High = {str(i_): round(j_['mintempSG'],4) for i_,j_ in inputs.loadable.info['parcel'].items()}
    # cargo density @ high temperature (in t/m3) 
    densityCargo_Low = {str(i_): round(j_['maxtempSG'],4) for i_,j_ in inputs.loadable.info['parcel'].items()}
    density_ = [j_['maxtempSG'] for i_,j_ in inputs.loadable.info['parcel'].items()]
    # ave cargo density
    aveCargoDensity = round(np.mean(density_), 4)
    
    # density used for the upper loading bound, default dcLow[c] (density at high temp)
    density_up = densityCargo_Low
    # density used for the lower loading bound, default dcHigh[c] (density at low temp)
    density_low = densityCargo_High
    
    # cargo with higher priority will be loaded as close to the intended quantity as possible
    priority = {}
    for i in range(len(C)):
        priority[C[i]] = 100
        
    cargoPriority = [] # input
    if inputs.mode in ['Auto']:
        for i_ in range(inputs.loadable.info['maxPriority'],1,-1):
            # print(i_)
            for l1_ in inputs.loadable.info['priority'][i_]:
                # print(l1_)
                for j_ in range(i_-1,0,-1):
                    # print(j_)
                    for l2_ in inputs.loadable.info['priority'][j_]:
                        # print(l2_) # higher priority
                        cargoPriority.append((l2_ , l1_))
                       
    #weight (in metric tone) of cargo to be moved at port p
    Wcp = {str(i_):{}  for i_, j_ in inputs.loadable.info['operation'].items()}
    for i_, j_ in inputs.loadable.info['operation'].items(): 
        for k_,v_ in j_.items():
            if int(k_) > 0:
                Wcp[str(i_)][int(k_)] = round(v_,3)
                
    # volume (in t/m3) to be moved at port p based on low density.
    Vcp = {}
    for i in range(len(C)):
        Vcp[C[i]] = {}
        for j in range(len(P)):
            Vcp[C[i]][P[j]] = Wcp.get(C[i], {}).get(P[j],0.) / densityCargo_Low[C[i]]
            
    # loading ports     
    loadPort   = [i_ for i_, j_ in inputs.loadable.info['toLoadPort1'].items()]
    
    # loadingPortAmt 
    loadingPortAmt = {i_:round(j_,3) for i_, j_ in inputs.loadable.info['toLoadPort1'].items()}
    
    # min cargo to must be loaded
    minCargoLoad = {i_:round(j_,3) for i_, j_ in inputs.loadable.info['toLoadMin'].items()}  
    
    toLoad = inputs.loadable.info['toLoad'] # input
    
    diffSlop = 10 if inputs.loadable.info['numParcel'] == 1 else 1
      
    # # Commingle cargos
    # print('# Commingle cargos',file=text_file)#  
    Cm_1 = [] 
    if inputs.loadable.info['commingleCargo']:
        Cm_1 = [inputs.loadable.info['commingleCargo']['parcel1']]
    
    Cm_2 = []
    if inputs.loadable.info['commingleCargo']:
        Cm_2 = [inputs.loadable.info['commingleCargo']['parcel2']]
    
    # print('# Possible commingled tanks',file=text_file)#
    # str1 = 'set Tm := '
    Tm = []
    if inputs.loadable.info['commingleCargo']:
        
        if inputs.loadable.info['commingleCargo'].get('tank',[]):
            Tm = [inputs.vessel.info['tankId'][int(t_)] for t_ in inputs.loadable.info['commingleCargo']['tank']]
        else:
            Tm = ['2C', '3C','4C','SLS','SLP']
    # print(str1+';', file=text_file)
    
    # print('# Density commingled cargo',file=text_file)#
    density_Cm = {}
    if inputs.loadable.info['commingleCargo']:
        density_Cm[inputs.loadable.info['commingleCargo']['parcel1']] = inputs.loadable.info['commingleCargo']['SG1']
        density_Cm[inputs.loadable.info['commingleCargo']['parcel2']] = inputs.loadable.info['commingleCargo']['SG2']
        
    #     str1 += self.loadable.info['commingleCargo']['parcel1'] + ' ' + "{:.4f}".format(self.loadable.info['commingleCargo']['SG1'])+ ' '
    #     str1 += self.loadable.info['commingleCargo']['parcel2'] + ' ' + "{:.4f}".format(self.loadable.info['commingleCargo']['SG2'])+ ' '
        
    # print(str1+';', file=text_file)
    
    
    if inputs.loadable.info['commingleCargo'].get('mode','0') == '2':
        Qm_1 = inputs.loadable.info['commingleCargo']['wt1']
        Qm_2 = inputs.loadable.info['commingleCargo']['wt2']
        Mm = 0.
    else:
        Qm_1 = 0.
        Qm_2 = 0.
        Mm = 1e5
    
    
    # cargo tank capacity (in m3)
    capacityCargoTank = {}
    for i_, j_ in inputs.vessel.info['cargoTanks'].items():
        o_ = inputs.vessel.info['onboard'].get(i_,{}).get('vol',0.)
        if o_ > 0:
            print(i_,j_['capacityCubm'],round(o_,3))
        capacityCargoTank[i_] = round(j_['capacityCubm']-o_,3)
            
    # upper loading bound for each tank
    upperBound = {}
    # lower loading bound for each tank
    lowerBound = {}
    for i in range(len(T)):
#        capacityCargoTank[T[i]] = capacityCargoTank_d[i]
#        densityCargoTank[T[i]] = 1.3
        upperBound[T[i]] = 0.98
        lowerBound[T[i]] = 0.60
    
    upperBoundC = {}
    for i in range(len(C)):
        upperBoundC[C[i]] = {}
        for j in range(len(T)):
            upperBoundC[C[i]][T[j]] = upperBound[T[j]]
            
    # onboard cargo tank (in mt)',file=text_file)#  
    onboard = {i_: round(j_['wt'],3) for i_, j_ in inputs.vessel.info['onboard'].items() if i_ not in ['totalWeight']}
    
    # locked tank',file=text_file)#   
    # locked_tank_ = []
    T_locked = []
    for k_, v_ in inputs.loadable.info['manualOperation'].items():
        for k1_, v1_ in v_.items():
            for v2_ in v1_:
                if 'tankId' in v2_.keys():
                    tank_ = inputs.vessel.info['tankId'][int(v2_['tankId'])]
                else:
                    tank_ = v2_['tank']
                if tank_ not in T_locked:
                    T_locked.append(tank_) 
                    
    #            
    # locked cargo',file=text_file)#  
    C_locked = []
    for k_, v_ in inputs.loadable.info['manualOperation'].items():
        if k_ not in C_locked:
            C_locked.append(k_)
                
    # 1 if tank t is locked for cargo c',file=text_file)#  
    A_locked = {c_:{} for c_ in C_locked} 
    for k_, v_ in inputs.loadable.info['manualOperation'].items():
        tank_ = []
        for k1_, v1_ in v_.items():
            for v2_ in v1_:
                
                if 'tankId' in v2_.keys():
                    tank__ = inputs.vessel.info['tankId'][int(v2_['tankId'])]
                else:
                    tank__ = v2_['tank']
                
                
                if tank__  not in tank_:
                    A_locked[k_][tank__] = 1
                    tank_.append(tank__)
                    
    W_locked  = {c_:{} for c_ in C_locked}     
    V_locked = {c_:{} for c_ in C_locked}
    for k_, v_ in inputs.loadable.info['manualOperation'].items():
        for k1_, v1_ in v_.items():
            for v2_ in v1_:
                
                
                if 'tankId' in v2_.keys():
                    tank_ = inputs.vessel.info['tankId'][int(v2_['tankId'])]
                else:
                    tank_ = v2_['tank']
                
                if tank_ not in W_locked[k_].keys():
                    W_locked[k_][tank_] = {}
                    V_locked[k_][tank_] = {}
                    
                W_locked[k_][tank_][k1_] = round(v2_['qty'],3)
                V_locked[k_][tank_][k1_] = W_locked[k_][tank_][k1_]/densityCargo_Low[k_]
                
    B_locked = {}
    for k_, v_ in inputs.loadable.info['ballastOperation'].items():
        tank_ = k_
        B_locked[tank_] = {}
        for v__ in v_:
            if v__['order'] != '0':
                B_locked[tank_][v__['order'] ] = round(v__['qty'],3)
                
            
        
                        
    fixBallastPort = [k_ for k_ in inputs.loadable.info['fixedBallastPort'] if k_ not in [0]]
    
    # upper trim
    trim_upper = {int(k_):v_  for k_,v_ in inputs.trim_upper.items()} # default 0.0001 for others
    # lower trim
    trim_lower  = {int(k_):v_  for k_,v_ in inputs.trim_lower.items()} # default -0.0001  for others
                    
                
    # set of other tanks, e.g. fuel tanks, water tanks,
    other_tanks_ = {**inputs.vessel.info['fuelTanks'], **inputs.vessel.info['dieselTanks'], **inputs.vessel.info['freshWaterTanks'] }
    OtherTanks = [i_ for i_, j_ in other_tanks_.items()]
    
    # weight of each tank
    weightOtherTank = {i_:{} for i_, j_ in inputs.vessel.info['onhand'].items()}
    for i_, j_ in inputs.vessel.info['onhand'].items():
        for k_, v_ in j_.items():
            if k_ not in ['1A']:
                for k1_, v1_ in inputs.loadable.info['virtualArrDepPort'].items():
                    if v1_ == k_:
                        wt_ = j_[k_]['wt']
                        weightOtherTank[i_][int(k1_)] = round(wt_,3)
                        
                        
    
    # ballast tanks ',file=text_file)#  
    TB = [i_ for i_, j_ in inputs.vessel.info['ballastTanks'].items() if i_ not in  inputs.vessel.info['banBallast']]
    
    # ballast tanks with non-pw tcg details',file=text_file)#  
    tb_list_ = list(inputs.vessel.info['tankTCG']['tcg_pw'].keys()) + inputs.vessel.info['banBallast']
    TB1 = [i_ for i_, j_ in inputs.vessel.info['ballastTanks'].items() if i_ not in tb_list_]
           
    # density of seawater
    # density of seawater ',file=text_file)#
    densitySeaWater = {}
    # str1 = 'param densitySeaWater := '
    for p_ in range(1,inputs.loadable.info['lastVirtualPort']+1):
        port_ = inputs.loadable.info['virtualArrDepPort'][str(p_)][:-1]
        portName_ = inputs.port.info['portOrder'][port_] # convert virtual port to exact port
        density_ = inputs.port.info['portRotation'][portName_]['seawaterDensity']
        densitySeaWater[int(p_)] = round(density_,4)
   
    densityBallast = 1.025
    
    # cargo tanks restrictions 
    cargoTankNonSym  = inputs.vessel.info['notSym']
    
    # symmetricVolTank 
    symmetricVolTank = [('1P','1S'), ('2P','2S'),('SLS','SLP'), ('3P','3S'), ('4P','4S'), ('5P','5S')]
    
    
    # cargo with highest load
    C_max = inputs.vessel.info['maxCargo']
                
    # print('# initial ballast ',file=text_file)#
    initBallast = {k_:v_ for k_, v_ in inputs.vessel.info['initBallast']['wt'].items()}
    
    # print('# inc initial ballast ',file=text_file)#
    incTB  = inputs.vessel.info['initBallast']['inc']
    
    # print('# dec initial ballast ',file=text_file)#
    decTB = inputs.vessel.info['initBallast']['dec']
    
    # print('# loading ports ',file=text_file)#
    loadingPort = []
    for k__, k_  in enumerate(inputs.vessel.info['loading']):
        if k__ < len(inputs.vessel.info['loading'])-1:
            loadingPort.append((k_,inputs.vessel.info['loading'][k__+1]))
            
    
    # print('# loading ports not last ',file=text_file)#
    loadingPortNotLast = list(loadingPort[:-1])
    
    # print('# departure arrival ports ',file=text_file)#
    depArrPort1 = []
    if inputs.vessel.info['onhand'] : # non-empty ROB
        for k__, k_  in enumerate(inputs.vessel.info['loading']):
            if k__ < len(inputs.vessel.info['loading']):
                depArrPort1.append((k_, k_+1))
   
    
    depArrPort2 = []
    if not inputs.vessel.info['onhand'] : # empty ROB
        for k__, k_  in enumerate(inputs.vessel.info['loading']):
            if k__ < len(inputs.vessel.info['loading']):
                depArrPort2.append((k_, k_+1))
                
    
    rotatingPort  = []
    for k__, k_  in enumerate(inputs.vessel.info['rotationVirtual']):
        if k__ < len(inputs.vessel.info['rotationVirtual'])-1:
            rotatingPort.append((k_, inputs.vessel.info['rotationVirtual'][k__+1]))
            
    # lastLoadingPortBallastBan
    lastLoadingPortBallastBan = ['WB1P','WB1S','WB2P','WB2S','WB3P','WB3S','WB4P','WB4S','WB5P','WB5S']
    
    # first loading Port
    firstloadingPort = inputs.loadable.info['arrDepVirtualPort']['1D']
    
    # specialBallastPort
    specialBallastPort = [LP-1, LP] # default LP-1
    
    # zeroBallastPort
    zeroBallastPort = [] # default LP
    
    # capacity of ballast tanks', file=text_file)
    capacityBallastTank = {i_: round(j_['capacityCubm'],3) for i_, j_ in inputs.vessel.info['ballastTanks'].items() if i_ not in inputs.vessel.info['banBallast']}
    
    #upper loading bound for each ballast tank    
    upperBoundB1 = {}
    #lower loading bound for each ballast tank
    lowerBoundB1 = {}
    for i in range(len(TB)):
        upperBoundB1[TB[i]] = 0.99
        # upperBoundB2[TB[i]] = 0.0
        lowerBoundB1[TB[i]] = 0.0
        # lowerBoundB2[TB[i]] = 0.0
    
    
    # light weight of ship', file=text_file)
    lightWeight = inputs.vessel.info['lightweight']['weight']
    
    # LCG of ship', file=text_file)
    LCGship = inputs.vessel.info['lightweight']['lcg']
    
    # deadweight constant', file=text_file)
    deadweightConst = inputs.vessel.info['deadweightConst']['weight']
                
    # LCG of deadweight constant', file=text_file)
    LCGdw = float(inputs.vessel.info['deadweightConst']['lcg'])
    
    # TCG of deadweight constant', file=text_file)
    TCGdw  =  float(inputs.vessel.info['deadweightConst']['tcg'])
    
    # max num tanks', file=text_file)
    maxTankUsed = inputs.maxTankUsed if inputs.maxTankUsed else 100
    
    # load all cargo -> intended <1
    intended  = 1e6
        
    
    # print('# random seed for Gurobi', file=text_file)
    # str1 = 'param seed   := ' + str(np.random.randint(0,1000)) 
    # # str1 = 'param seed   := 11' 
    # print(str1+';', file=text_file)
    
    
    tanks_ = {**inputs.vessel.info['cargoTanks'], **inputs.vessel.info['ballastTanks'], 
              **inputs.vessel.info['fuelTanks'], **inputs.vessel.info['dieselTanks'], **inputs.vessel.info['freshWaterTanks']}
    # LCGs of tanks', file=text_file)
    LCGt = {i_:round(j_['lcg'],3) for i_, j_ in tanks_.items() if i_ not in  inputs.vessel.info['banBallast']}
   
    # self.vessel.info['TCGt'] = {}
    # TCGs of tanks', file=text_file)
    TCGt = {}
    # TCGs of tanks', file=text_file)
    for i_, j_ in tanks_.items():
        if i_ not in inputs.vessel.info['banBallast']:
            tcg_ = inputs.vessel.info['tankTCG']['tcg'].get(i_,{}).get('tcg',[0.,0.,0.,0.])[-3] # FPTU missing
            TCGt[i_] = round(tcg_,3)
            
                
    
    
    # print('# num of pw TCG curves for ballast tank', file=text_file)
    # str1 = 'param pwBallast := ' +  str(self.vessel.info['tankTCG']['tcg_pw']['npw'])
    # print(str1+';', file=text_file)
    
    # print('# slopes of TCG curves for tanks', file=text_file)
    #   (m1,y1)  (m2,y2)
    #  |-------|---------|----|----| ... ----|----|
    # b0      b1         b2   b3   b4         b9   b10
    # 
    #  curve is broken into 10 pieces: start point b0 and end point b10
    #  b0 is not provided
    #  m1, ... m10 = slopes
    #  y1, ... y10 = slopes
    #  (m1,y1) is the linear curve for b0 - b1
    #  (m2,y2) is the linear curve for b1 - b2
    
    mTank = {}
    for m_ in range(1,inputs.vessel.info['tankTCG']['tcg_pw']['npw']+1):
        mTank[m_] = {}
        for k_, v_ in inputs.vessel.info['tankTCG']['tcg_pw'].items():
            if k_ not in (['npw']+inputs.vessel.info['banBallast']):
                mTank[m_][k_] = round(v_['slopes'][m_-1],8)
    
    # print('# breaks of TCG curves for tanks', file=text_file)
    bTank =  {}
    bTank[0] = {}
    for m_ in range(1,inputs.vessel.info['tankTCG']['tcg_pw']['npw']+1):
        bTank[m_] = {}
        for k_, v_ in inputs.vessel.info['tankTCG']['tcg_pw'].items():
            if k_ not in (['npw']+inputs.vessel.info['banBallast']):
                bTank[m_][k_] = round(v_['breaks'][m_-1],8)
    # inital value
    for k_, v_ in inputs.vessel.info['tankTCG']['tcg_pw'].items():
        bTank[0][k_] = 0
        
        
    # print('# intercepts of TCG curves for tanks', file=text_file)
    yTank =  {}
    for m_ in range(1,inputs.vessel.info['tankTCG']['tcg_pw']['npw']+1):
        yTank[m_] = {}
        for k_, v_ in inputs.vessel.info['tankTCG']['tcg_pw'].items():
            if k_ not in (['npw']+inputs.vessel.info['banBallast']):
                yTank[m_][k_] = round(v_['intercepts'][m_-1],8)
    
    bTank_n, cTank_n = {}, {}
    for i_ in range(len(bTank)):
        bTank_n[i_], cTank_n[i_] = {}, {}
         
        # if i==0:
        #     for j in bTank[1]:
        #         bTank_n[i][j] = 0
        #         cTank_n[i][j] = mTank[1][j]*0+yTank[1][j]
        # else:
        k_ = i_+1 if i_ < len(mTank) else i_
        # print(i_,k_)
        for j_ in bTank[i_]:
            if j_ not in ['npw']:
                bTank_n[i_][j_] = bTank[i_][j_]
                cTank_n[i_][j_] = mTank[k_][j_]*bTank_n[i_][j_]+yTank[k_][j_]

    
   
        
    # TCGs for others tanks', file=text_file)
    TCGtp = {i_:{} for i_, j_ in inputs.vessel.info['onhand'].items()}
    for i_, j_ in inputs.vessel.info['onhand'].items():
        for k_, v_ in j_.items():
            tcg_ = j_[k_]['tcg']
            if k_ not in ['1A']:
                for k1_,v1_ in inputs.loadable.info['virtualArrDepPort'].items():
                    if v1_ == k_:
                        TCGtp[i_][int(k1_)] = round(tcg_,3)
                        
        
    # print('# slopes of LCB x Disp curve', file=text_file)
    mLCB = {}
    for m_ in range(1, len(inputs.vessel.info['lcb_mtc']['lcb']['slopes'])+1):
        mLCB[m_] = round(inputs.vessel.info['lcb_mtc']['lcb']['slopes'][m_-1],8)
        
    # print('# breaks of LCB x Disp curve', file=text_file)
    bLCB = {}
    bLCB[0] = inputs.vessel.info['hydrostatic']['displacement'][0]
    for m_ in range(1,len(inputs.vessel.info['lcb_mtc']['lcb']['slopes'])+1):
        bLCB[m_] = round(inputs.vessel.info['lcb_mtc']['lcb']['breaks'][m_-1],8)
        
    # print('# intercepts of LCB x Disp curve', file=text_file)
    yLCB = {}
    for m_ in range(1,len(inputs.vessel.info['lcb_mtc']['lcb']['slopes'])+1):
        yLCB[m_] = round(inputs.vessel.info['lcb_mtc']['lcb']['intercepts'][m_-1],8)
    
    bLCB_n, cLCB_n = {}, {}
    for i_ in range(len(bLCB)):
        # if i==0:
        #     bLCB_n[i] = 0
        #     cLCB_n[i] = mLCB[1]*0+yLCB[1]
        # else:
        k_ = i_+1 if i_ < len(mLCB) else i_
        # print(i_,k_)
        bLCB_n[i_] = bLCB[i_] 
        cLCB_n[i_] = mLCB[k_]*bLCB_n[i_]+yLCB[k_]
        
    # print('# slopes of MTC curve', file=text_file)
    mMTC = {}
    for m_ in range(1, len(inputs.vessel.info['lcb_mtc']['mtc']['slopes'])+1): 
        mMTC[m_] = round(inputs.vessel.info['lcb_mtc']['mtc']['slopes'][m_-1],10)
        
    # print('# breaks of MTC curve', file=text_file)    
    bMTC = {}
    bMTC[0] = inputs.vessel.info['hydrostatic']['displacement'][0]
    for m_ in range(1,len(inputs.vessel.info['lcb_mtc']['mtc']['slopes'])+1):
        bMTC[m_] = round(inputs.vessel.info['lcb_mtc']['mtc']['breaks'][m_-1],10)
    
    # print('# breaks of MTC curve', file=text_file)    
    yMTC = {}
    for m_ in range(1,len(inputs.vessel.info['lcb_mtc']['mtc']['slopes'])+1):
        yMTC[m_] = round(inputs.vessel.info['lcb_mtc']['mtc']['intercepts'][m_-1],10)
    
    bMTC_n, cMTC_n  = {}, {}
    for i_ in range(len(bMTC)):
        # if i==0:
        #     bMTC_n[i] = 0
        #     cMTC_n[i] = mMTC[1]*0+yMTC[1]
        # else:
        k_ = i_+1 if i_ < len(mMTC) else i_
        # print(i_,k_)
        bMTC_n[i_] = bMTC[i_] 
        cMTC_n[i_] = mMTC[k_]*bMTC_n[i_]+yMTC[k_]
       
    # upper limit on displacement', file=text_file)
    # stability - draft
    displacementLimit = {int(i_):round(j_,5) for i_, j_ in inputs.displacement_upper.items()}
    
    # lower limit on displacement', file=text_file)
    displacementLowLimit = {int(i_):round(j_,5) for i_, j_ in inputs.displacement_lower.items()}
    
    # deadweight constraint', file=text_file)
    deadweight  = inputs.vessel.info['draftCondition']['deadweight'] 
    
    # base draft', file=text_file)
    base_draft = {int(i_): round(j_,2) for i_, j_ in inputs.base_draft.items()}
   
    # print('# slopes of draft curve', file=text_file)
    mDraft = {}
    for m_ in range(1, len(inputs.vessel.info['lcb_mtc']['draft']['slopes'])+1):
        mDraft[m_] = round(inputs.vessel.info['lcb_mtc']['draft']['slopes'][m_-1],10)
        
    # print('# breaks of draft curve', file=text_file)
    bDraft = {}
    bDraft[0] = inputs.vessel.info['hydrostatic']['displacement'][0]
    for m_ in range(1,len(inputs.vessel.info['lcb_mtc']['draft']['slopes'])+1):
        bDraft[m_] = round(inputs.vessel.info['lcb_mtc']['draft']['breaks'][m_-1],8)
        
    yDraft = {}
    for m_ in range(1,len(inputs.vessel.info['lcb_mtc']['draft']['slopes'])+1):
        yDraft[m_] = round(inputs.vessel.info['lcb_mtc']['draft']['intercepts'][m_-1],10)
        
        
    bDraft_n, cDraft_n  = {}, {}
    for i_ in range(len(bDraft)):
        
        k_ = i_+1 if i_ < len(mDraft) else i_
        # print(i_,k_)
        bDraft_n[i_] = bDraft[i_] 
        cDraft_n[i_] = mDraft[k_]*bDraft_n[i_]+yDraft[k_]
    
    # print('# number of frames ',file=text_file)#
    Fr = len(inputs.vessel.info['frames'])
  
    
    # print('# weight ratio for SF and BM',file=text_file)#
    weightRatio_ct = {}
    for i_, j_ in inputs.vessel.info['tankGroup'].items():
        weightRatio_ct[int(i_)] = {}
        for u_, v_ in j_.items():
            if u_ in inputs.vessel.info['cargoTanks'].keys():
                weightRatio_ct[int(i_)][u_] = round(v_['wr'],4)
                
    weightRatio_bt  = {}
    for i_, j_ in inputs.vessel.info['tankGroup'].items():
        weightRatio_bt[int(i_)] = {}
        for u_, v_ in j_.items():
            if u_ in TB:
                weightRatio_bt[int(i_)][u_] = round(v_['wr'],4)
            
        
        
    weightRatio_ot = {}
    
    
    # print('# LCG for SF and BM ',file=text_file)#
    LCG_ct = {} 
    for i_, j_ in inputs.vessel.info['tankGroup'].items():
        LCG_ct[int(i_)] = {}
        for u_, v_ in j_.items():
            if u_ in inputs.vessel.info['cargoTanks'].keys():
                LCG_ct[int(i_)][u_] = round(v_['lcg'],4)
                
            
    LCG_bt = {}
    for i_, j_ in inputs.vessel.info['tankGroup'].items():
        LCG_bt[int(i_)] = {}
        for u_, v_ in j_.items():
            if u_ in TB:
                LCG_bt[int(i_)][u_] = round(v_['lcg'],4)
        
    LCG_ot = {}
  
    LCG_fr = {}
    for i_, j_ in inputs.vessel.info['tankGroupLCG'].items():
        LCG_fr[int(i_)] = round(j_,3)
     
   
    # print('# lower limit SF ',file=text_file)#
    lowerSFlimit  = {}
    for i_, j_ in enumerate(inputs.vessel.info['frames']):
        lowerSFlimit[i_+1] = round(float(inputs.vessel.info['SFlimits'][j_][0])/1000*inputs.sf_bm_frac,5)
        
        
    # print('# upper limit SF ',file=text_file)#
    upperSFlimit = {}
    for i_, j_ in enumerate(inputs.vessel.info['frames']):
        upperSFlimit[i_+1] = round(float(inputs.vessel.info['SFlimits'][j_][1])/1000*inputs.sf_bm_frac,5)
        
    BV_SF = {}
    for i_, j_ in inputs.vessel.info['tankGroup'].items():
        BV_SF[int(i_)] = {}
        for k_, v_ in inputs.sf_base_value.items():
            BV_SF[int(i_)][int(k_)] = round(v_[int(i_)-1],5)
            
    
    CD_SF = {}
    for i_, j_ in inputs.vessel.info['tankGroup'].items():
        CD_SF[int(i_)] = {}
        for k_, v_ in inputs.sf_draft_corr.items():
            CD_SF[int(i_)][int(k_)] = round(v_[int(i_)-1],5)
            
    # print('# lower limit BM ',file=text_file)#
    lowerBMlimit = {}
    for i_, j_ in enumerate(inputs.vessel.info['frames']):
        lowerBMlimit[i_+1] = round(float(inputs.vessel.info['BMlimits'][j_][0])/1000*inputs.sf_bm_frac,5)
        
   
    # print('# upper limit BM ',file=text_file)#
    upperBMlimit = {}
    for i_, j_ in enumerate(inputs.vessel.info['frames']):
        upperBMlimit[i_+1] = round(float(inputs.vessel.info['BMlimits'][j_][1])/1000*inputs.sf_bm_frac,5)
    
    BV_BM = {}
    for i_, j_ in inputs.vessel.info['tankGroup'].items():
        BV_BM[int(i_)] = {}
        for k_, v_ in inputs.bm_base_value.items():
            BV_BM[int(i_)][int(k_)] = round(v_[int(i_)-1],5)
   
    
    CD_BM = {}
    for i_, j_ in inputs.vessel.info['tankGroup'].items():
        CD_BM[int(i_)] = {}
        for k_, v_ in inputs.bm_draft_corr.items():
            CD_BM[int(i_)][int(k_)] = round(v_[int(i_)-1],5)
            
       
    
    minCargoAmt = 1000
    minBallastAmt = 10
    ListMOM = 500
    
    cargoweight = 1e6
    deballastPercent = 0.4
    
    P_stable = list(set([i for i in range(1, NP)]) - set(fixBallastPort)) # stable port
    
    
    # Decision variables
    ## --------------------------------------------------
        
    x = {}
    w = {}
    qw2f = {}
    
    for i in range(len(C)):
        x[C[i]] = {}
        w[C[i]] = {}
        qw2f[C[i]] = {}
        
        for j in range(len(T)):
            # 1 if cargo c is allocated into tank t for capacity
            x[C[i]][T[j]] = solver.IntVar(0, 1, 'x[%s][%s]' % (C[i], T[j])) 
            w[C[i]][T[j]] = {}
            qw2f[C[i]][T[j]] =  {}

            for k in range(len(P)):
                # weight of cargo (w.r.t. low density) planned to be serviced from/to tank t at port p. 
                # positive -> load; zero -> no action; negative -> unload.
                w[C[i]][T[j]][P[k]] = solver.NumVar(-infinity, infinity, 'w[%s][%s][%d]' % (C[i], T[j], P[k]))
                
            for k in range(len(Pbar)):
                qw2f[C[i]][T[j]][Pbar[k]] = solver.IntVar(0, infinity, 'qw2f[%s][%s][%d]' % (C[i], T[j], Pbar[k]))
    
    # TMom TB 
    T_tmom = {}
    for i in range(len(T)):
        T_tmom[T[i]] = {}
        for j in range(len(P)):
            T_tmom[T[i]][P[j]] = solver.NumVar(-infinity, infinity, 'T_tmom[%s][%d]' % (T[i], P[j]))
    
    xt = {}
    for i in range(len(T)):
        xt[T[i]] = solver.IntVar(0, 1, 'xt[%s]' % (T[i]))
        
    # 1 if ballast tank t is filled with water at port p
    xB = {}
    # weight of water in ballast tank t at port p
    wB = {}
    # volume of water (w.r.t. low density) planned to be added into ballast tank t at port p
    # yB = {}
    zBa = {}
    zBb = {}
    # TMom TB
    TB_tmom = {}
    for i in range(len(TB)):
        xB[TB[i]] = {}
        wB[TB[i]] = {}
        # yB[TB[i]] = {}
        TB_tmom[TB[i]] = {}
        zBa[TB[i]] = solver.IntVar(0, 1, 'zBa[%s]' % (TB[i]))
        zBb[TB[i]] = solver.IntVar(0, 1, 'zBb[%s]' % (TB[i]))
        for j in range(len(Pbar)):
            xB[TB[i]][Pbar[j]] = solver.IntVar(0, 1, 'xB[%s][%d]' % (TB[i], Pbar[j]))
            wB[TB[i]][Pbar[j]] = solver.NumVar(0, infinity, 'wB[%s][%d]' % (TB[i], Pbar[j]))
            
        for j in range(len(P)):
            # yB[TB[i]][P[j]] = wB[TB[i]][P[j]] / densitySeaWater[P[j]]
            TB_tmom[TB[i]][P[j]] = solver.NumVar(-infinity, infinity, 'TB_tmom[%s][%d]' % (TB[i], P[j]))
           
            
    T_mom = {}
    L_mom = {}
    LCBp = {}
    MTCp = {}
    for i in range(len(P)):
        T_mom[P[i]] = solver.NumVar(-infinity, infinity, 'T_mom[%d]' % (P[i]))
        L_mom[P[i]] = solver.NumVar(-infinity, infinity, 'L_mom[%d]' % (P[i]))
        LCBp[P[i]] = solver.NumVar(-infinity, infinity, 'LCBp[%d]' % (P[i]))
        MTCp[P[i]] =  solver.NumVar(-infinity, infinity, 'MTCp[%d]' % (P[i]))
    
    delta = {}
    for i in C:
        delta[i] = {}
        for j in range(len(P_dis)):
            delta[i][P_dis[j]] = solver.IntVar(0, 1, 'delta[%s][%d]' % (i, P_dis[j]))        
            
            
    zz = {}
    for i in C:
        zz[i] = {}
        for j in list(set(C)-set([i])):
            zz[i][j] = {}
            for k in Tm:
                zz[i][j][k] = solver.IntVar(0, 1, 'zz[%s][%s][%s]' % (i, j, k))
            
    # BM and SF

    # displacement
    displacement = {}
    # displacement corrected for seawater density
    displacement1 = {}
    
    mean_draft = {}
    for i in range(len(P)):
        displacement[P[i]] = solver.NumVar(0, infinity, 'displacement[%d]' % (P[i]))
        displacement1[P[i]] = solver.NumVar(0, infinity, 'displacement1[%d]' % (P[i]))
        mean_draft[P[i]] = solver.NumVar(0, infinity, 'mean_draft[%d]' % (P[i]))
    
    wn = {}
    mn = {}
    Frames = range(0,Fr+1)
    for i in Frames:
        wn[i] = {}
        mn[i] = {}
        for j in P:
            wn[i][j] = solver.NumVar(0, infinity, 'wn[%d][%d]' % (i, j))
            mn[i][j] = solver.NumVar(-infinity, infinity, 'mn[%d][%d]' % (i, j))
            
    wC = {}
    for i in range(len(T)):
        wC[T[i]] = {}
        for j in range(len(P)):
            wC[T[i]][P[j]] = solver.NumVar(0, infinity, 'wC[%s][%d]' % (T[i], P[j]))
    
    ## -----------------------------------------------------------
    Action_Amount = solver.Sum([priority[c]*(solver.Sum([qw2f[c][t][p]/10 for p in P_last_loading]) - 
                                              solver.Sum([w[c][t][p] for p in P_dis])) for c in C for t in Tc[c]]) - 1*solver.Sum([wB[t][p] for t in TB for p in P])
    solver.Maximize(Action_Amount)
    
    # Constraints
    ## -----------------------------------------------------------
    # Condition 0
    for i in list(set(C)-set(C_loaded)-set(C_locked)):
        # cargo c is not allocated to tank t if t is not compatible with cargo c
        solver.Add(solver.Sum([x[i][j] for j in list(set(T)-set(Tc[i]))]) == 0)
        
    # Condition 01
    for i in list(set(T)-set(Tm)):
        # one tank can only take in one cargo
        solver.Add(solver.Sum([x[j][i] for j in C]) <= 1)
    
    # commingled cargo
    # Condition 01a 01b 01c
    for i in Tm:
        # Condition 01a
        # a cargo is loaded to at least one tank
        solver.Add(solver.Sum([x[j][i] for j in list(set(C)-set(Cm_1))]) <= 1)
        # Condition 01b
        # one tank can only take in one cargo
        solver.Add(solver.Sum([x[j][i] for j in list(set(C)-set(Cm_2))]) <= 1)
        
        for j in Cm_1:
            for k in Cm_2:
                # Condition 01c
                # one tank can only take in two cargo
                solver.Add(x[j][i] + x[k][i] <= 2)
    
    # Condition01z
    for i in list(set(C)-set(C_loaded)-set(C_locked)):
        for k in P_last_loading:
            # a cargo is loaded to at min amt at last loading port
            solver.Add(solver.Sum([qw2f[i][j][k]/10 for j in Tc[i]]) >= minCargoLoad[i])
    
    # Condition 020 Condition 021
    for i in C:
        for j in list(set(T)-set(Tc[i])):
            for k in P:
                # Condition 020  cargo c is not allocated to tank t if t is not compatible with cargo c
                solver.Add(w[i][j][k]/densityCargo_Low[i] == x[i][j])
                # Condition 021  cargo c is not allocated to tank t if t is not compatible with cargo c
                solver.Add(qw2f[i][j][k]/10/densityCargo_Low[i] == x[i][j])
                
    # Condition 03 Condition 04
    for i in list(set(C)-set(C_loaded)-set(C_locked)):
        # total loaded >= total discharged
        solver.Add((solver.Sum([Q0.get(i,{}).get(j,0.) for j in Tc[i]]) + 
                    solver.Sum([w[i][j][k]/densityCargo_Low[i] for j in Tc[i] for k in P_load])) >= 
                    -solver.Sum([w[i][j][k]/densityCargo_Low[i] for j in Tc[i] for k in P_dis]))

        for j in P_load:
            if Vcp[i][j] <= 0:
                continue
            # Condition 04
            # amount of cargo to be loaded <= amount available at the port.
            solver.Add(solver.Sum([w[i][k][j]/densityCargo_Low[i] for k in Tc[i]]) >= 0)
            solver.Add(solver.Sum([w[i][k][j]/densityCargo_Low[i] for k in Tc[i]]) <= Vcp[i][j])
    
    # Condition 041
    for i in C:
        for j in Tc[i]:
            for k in P_load:
                solver.Add(w[i][j][k]/densityCargo_Low[i] >= 0)
            
            
    # Condition 05, 050, 050a, 050b, 050b1, 050c, 050c1
    for i in list(set(C)-set(C_loaded)-set(C_locked)):
        for j in P_dis:
            if Vcp[i][j] >= 0:
                continue
            # Condition 05, 050, 050a, 050b, 050b1, 050c, 050c1
            # amount of cargo to be discharged is not more than the amount needed at the port.
            solver.Add(solver.Sum([w[i][k][j]/densityCargo_Low[i] for k in Tc[i]]) <= 0)
            solver.Add(solver.Sum([w[i][k][j]/densityCargo_Low[i] for k in Tc[i]]) >= Vcp[i][j])
            
            solver.Add(solver.Sum([qw2f[i][k][j-1]/10/densityCargo_Low[i] for k in Tc[i]]) >= -Vcp[i][j]-1e6*(1-delta[i][j]))
            
            solver.Add(solver.Sum([qw2f[i][k][j-1]/10/densityCargo_Low[i] for k in Tc[i]]) <= -Vcp[i][j]+1e6*(delta[i][j]))

            solver.Add(-Vcp[i][j]-1e6*(1-delta[i][j]) <= -solver.Sum([w[i][k][j] / densityCargo_Low[i] for k in Tc[i]]))

            solver.Add(-solver.Sum([w[i][k][j]/densityCargo_Low[i] for k in Tc[i]]) <= -Vcp[i][j]+1e6*(1-delta[i][j]))
            
            solver.Add(-1e6*delta[i][j] <= -solver.Sum([qw2f[i][k][j]/10/densityCargo_Low[i] for k in Tc[i]]))

            solver.Add(-solver.Sum([qw2f[i][k][j]/10/densityCargo_Low[i] for k in Tc[i]]) <= 1e6*delta[i][j])
            
    # Condition 051 
    for i in C:
        for j in Tc[i]:
            for k in P_dis:
                solver.Add(w[i][j][k]/densityCargo_Low[i] <= 0)
    
    # Condition 052    
    for i in list(set(C)-set(C_loaded)-set(C_locked)):
        for j in Tc[i]:
            for k in P:
                if Vcp[i][k] != 0:
                    continue
                # Condition 052
                solver.Add(w[i][j][k]/densityCargo_Low[i] == 0)
    
    # Condition 06
    for i in C:
        for j in Tc[i]:
            for k in list(set(Pbar)-set([NP])):
                # amount of cargo c left in tank when leaving port p for port p+1 is equal to the amount of cargo c moved from/to tank t at port p.
                solver.Add((qw2f[i][j][k]/10/densityCargo_Low[i] + w[i][j][k+1]/densityCargo_Low[i]) == qw2f[i][j][k+1]/10/densityCargo_Low[i])

   
    
    
    ## preloaded condition
    # condition22, condition 23, # condition 23a, 23b, condition 24, 24a
    for i in C_loaded:
        for j in T_loaded:
            # condition 22
            # follow the existing stowage of preloaded cargoes
            solver.Add(x[i][j] == I_loaded[i][j])
            
            for k in P:
                  # condition 24a
                # follow the existing stowage of preloaded cargoes
                solver.Add(w[i][j][k]/densityCargo_Low[i] == V_loaded[i][j][k])
            
        for j in list(set(T)-set(T_loaded)):
            # condition 23
            # preloaded cargo can only be loaded to its corresponding preloaded tanks
            solver.Add(x[i][j] == 0)
            
            for k in P:
                # condition 23a, 23b
                solver.Add(w[i][j][k]/densityCargo_Low[i] == x[i][j])
                solver.Add(qw2f[i][j][k]/10/densityCargo_Low[i] == x[i][j])
                
    for i in C:
        for j in T:
            # condition 24
            # follow the existing stowage of preloaded cargoes
            solver.Add(qw2f[i][j][0]/10/densityCargo_Low[i] == Q0.get(i, {}).get(j,0))
    

    
    
    ## locked tank / pre-allocated condition
    # condition 25, condition 26, condition 26a, 26b, condition 27
    for i in C_locked:
        for j in T_locked:
            # condition 25
            # follow the existing stowage of locked cargoes
            solver.Add(x[i][j] == A_locked.get(i,{}).get(j, 0))
        
        for j in list(set(T)-set(T_locked)):
            # condition 26
            # locked cargo can only be loaded to its corresponding locked tanks
            solver.Add(x[i][j] == 0)
            
            for k in P:
                # condition 26a, 26b
                # locked cargo can only be loaded to its corresponding locked tanks
                solver.Add(w[i][j][k]/densityCargo_Low[i] == x[i][j])
                solver.Add(qw2f[i][j][k]/10/densityCargo_Low[i] == x[i][j])
                
        for j in T_locked:
            for k in P:
                # condition 27
                # follow the existing stowage of locked cargoes
                solver.Add(w[i][j][k]/densityCargo_Low[i] == V_locked.get(i,{}).get(j,{}).get(str(k),0))
                
    # Constr5a,  
    for i in list(set(C)-set(C_loaded)-set(C_locked)):
        for j in Tc[i]:
            for k in P_last_loading:
                solver.Add(qw2f[i][j][k]/10/densityCargo_Low[i] <= upperBoundC[i][j]*capacityCargoTank[j]*x[i][j])
        
             
    
    # commingled
    # Constr 5b
    for i1, i2 in zip(Cm_1,Cm_2):
        for j in T:
            for k in P_last_loading:
                solver.Add((qw2f[i1][j][k]/10/densityCargo_Low[i1]*densityCargo_Low[i1]/density_Cm[i1] + qw2f[i2][j][k]/10/densityCargo_Low[i2]*densityCargo_Low[i2]/density_Cm[i2]) <= upperBound[j]*capacityCargoTank[j])
    # Constr 5c    
    # for i1, i2 in zip(Cm_1,Cm_2):
    #       solver.Add(solver.Sum([x[i1][j]*x[i2][j]  for j in Tm]) <= 1)
    for i1, i2 in zip(Cm_1,Cm_2):
        solver.Add(solver.Sum([zz[i1][i2][j]  for j in Tm]) <= 1) # zz = x1*x2
        for j in Tm:
            solver.Add(zz[i1][i2][j] <= x[i1][j])  # zz <= x1
            solver.Add(zz[i1][i2][j] <= x[i2][j])  # zz <= x2
            solver.Add(zz[i1][i2][j] >= x[i1][j]+x[i2][j]-1)  # zz >= x1+x2-1
        
    # manual commingle
    # Constr5d1, 5d2, 5d3, 5d4
    for i1, i2 in zip(Cm_1,Cm_2):
        for j in Tm:
            for k in P_last_loading:
                # Constr5d1
                solver.Add((x[i2][j]*Qm_2 - qw2f[i2][j][k]/10) <= Mm*(1-x[i1][j]))
                # Constr5d2
                solver.Add((qw2f[i2][j][k]/10 - x[i2][j]*(Qm_2+Mm)) <= Mm*(1-x[i1][j]))
                # Constr5d3
                solver.Add((x[i1][j]*Qm_1 - qw2f[i1][j][k]/10) <= Mm*(1-x[i2][j]))
                # Constr5d4
                solver.Add((qw2f[i1][j][k]/10 - x[i1][j]*(Qm_1+Mm)) <= Mm*(1-x[i2][j]))
        
    # # Constr7a
    # for i in list(set(C)-set(C_loaded)-set(C_locked)):
    #     for j in Tc[i]:
    #         for k in P_last_loading:
    #             # Constr7a DISABLE CURRENTLY
    #             # solver.Add(lowerBound[j]*capacityCargoTank[j]*x[i][j] <= qw2f[i][j][k]/10/densityCargo_Low[i]*densityCargo_Low[i]/density_low[i])
    #             pass
    
    
    # Constr8 
    for i in C:
        for j in Tc[i]:
            for k in P_last_loading:
                # Constr8
                solver.Add((qw2f[i][j][k]/1000 - 1e4*(x[i][j])) <= 0)
        
    # Constr11  # Constr12
    for i in TB:
        for j in P:
            solver.Add(wB[i][j]/densityBallast <= upperBoundB1[i]*capacityBallastTank[i]*xB[i][j])
            solver.Add(lowerBoundB1[i]*capacityBallastTank[i]*xB[i][j] <= wB[i][j]/densityBallast)
            
            
    ## max num of tanks available
    # Constr12a1 12a2
    # solver.Add(solver.Sum([x[i][j] for i in C for j in T]) <= maxTankUsed) Constr12a
    for j in T:
        solver.Add(solver.Sum([x[i][j] for i in C]) <= 100*xt[j])
        
    solver.Add(solver.Sum([xt[j] for j in T]) <= maxTankUsed) 
    
    ##?? why remove?
    # load all  cargo 
    # Condition111
    # for i in P_last_loading:
    #     solver.Add((solver.Sum([Wcp[c][pp] for c in C for pp in P if Wcp[c][pp]>0])-
    #                 solver.Sum([qw2f[c][t][i]/10 for c in C for t in T])) >= -intended)
    #     solver.Add((solver.Sum([Wcp[c][pp] for c in C for pp in P if Wcp[c][pp]>0])-
    #                 solver.Sum([qw2f[c][t][i]/10 for c in C for t in T])) <= intended)       
    
    # Constr122
    for u, v in cargoPriority:
        solver.Add(solver.Sum([qw2f[v][t][p]/10/toLoad[v] for t in Tc[v] for p in P_last_loading]) <= solver.Sum([qw2f[u][t][p]/10/toLoad[u] for t in Tc[u] for p in P_last_loading]))
    # symmetric loading
    # Condition112a, 112b, 112c1, 112c2, 112c3
    for i in C:
        solver.Add(x[i]['1P'] == x[i]['1S']) 
        solver.Add(x[i]['2P'] == x[i]['2S'])
        solver.Add(x[i]['3P'] == x[i]['3S']) 
        solver.Add(x[i]['4P'] == x[i]['4S'])
        solver.Add(x[i]['5P'] == x[i]['5S'])

        # for j in P_last_loading:
        #     solver.Add(qw2f[i]['1P'][j]/10 == qw2f[i]['1S'][j]/10)
        #     solver.Add(qw2f[i]['2P'][j]/10 == qw2f[i]['2S'][j]/10)            
           
    # Condition112a1, 112a2 
    for u, v in symmetricVolTank:
        for p in P_last_loading:
            solver.Add(solver.Sum([qw2f[c][u][p]/10/densityCargo_Low[c]/capacityCargoTank[u] for c in C]) - 
                        solver.Sum([qw2f[c][v][p]/10/densityCargo_Low[c]/capacityCargoTank[v] for c in C]) <= 0.1)
            solver.Add(-0.1 <= (solver.Sum([qw2f[c][u][p]/10/densityCargo_Low[c]/capacityCargoTank[u] for c in C]) - 
                        solver.Sum([qw2f[c][v][p]/10/densityCargo_Low[c]/capacityCargoTank[v] for c in C])))
 
    # diff cargos in slop tanks, except when only one cargo
    # Condition112f
    for i in C:
        for u, v in cargoTankNonSym:
            solver.Add(x[i][u] + x[i][v] <= diffSlop)
            
    # Condition112g1, Condition112g2
    solver.Add(solver.Sum([x[i]['SLS'] for i in C]) == 1)
    solver.Add(solver.Sum([x[i]['SLP'] for i in C]) == 1)
    
    for i in C_max:
        # Condition112h1, Condition112h2, Condition112h3, Condition112h4, Condition112h5
        solver.Add(x[i]['1P'] + x[i]['1C'] >= 1)
        solver.Add(x[i]['2P'] + x[i]['2C'] >= 1)
        solver.Add(x[i]['3P'] + x[i]['3C'] >= 1)
        solver.Add(x[i]['4P'] + x[i]['4C'] >= 1)
        solver.Add(x[i]['5P'] + x[i]['5C'] >= 1)
        # C_max cannot occupy 2 consecutive rows
        # Condition112i1, Condition112i2, Condition112i3, Condition112i4
        solver.Add(x[i]['1P'] + x[i]['1C'] + x[i]['1P'] + x[i]['2P'] + x[i]['2C'] + x[i]['2S'] <= 5)
        solver.Add(x[i]['2P'] + x[i]['2C'] + x[i]['2P'] + x[i]['3P'] + x[i]['3C'] + x[i]['3S'] <= 5)
        solver.Add(x[i]['3P'] + x[i]['3C'] + x[i]['3P'] + x[i]['4P'] + x[i]['4C'] + x[i]['4S'] <= 5)
        solver.Add(x[i]['4P'] + x[i]['4C'] + x[i]['4P'] + x[i]['5P'] + x[i]['5C'] + x[i]['5S'] <= 5)
                
    
    # Condition112b1 Condition112b2
    for i in C:
        for j in T:
            for k in P_last_loading:
                solver.Add(qw2f[i][j][k]/10 >= minCargoAmt*x[i][j])
                solver.Add(qw2f[i][j][k]/10 <= 1e5*x[i][j])
    
    for j in TB:
        # ballast requirement
        # Condition113d1 Condition113d2
        for k in P:
            solver.Add(wB[j][k] >= minBallastAmt*xB[j][k])
            solver.Add(wB[j][k] <= 1e4*xB[j][k])

            
    
    # initial ballast condition
    # Condition114a1, Condition114a2, Condition114a3
    for j in incTB:
        solver.Add(initBallast.get(j,0.) <= wB[j][int(firstloadingPort)])
    for j in decTB:
        solver.Add(initBallast.get(j,0.) >= wB[j][int(firstloadingPort)])
    for j in TB:
        solver.Add(initBallast.get(j,0.) == wB[j][0])
    
    # decreasing ballast except last loading port
    # Condition 114b
    for i in TB:
        for (u_, v_) in loadingPortNotLast:
            solver.Add(wB[i][u_] >= wB[i][v_])
    
        
    # decreasing ballast tank
    # Condition 114c
    for u_, v_ in loadingPort:
        solver.Add(solver.Sum([xB[t][u_] for t in TB]) >= solver.Sum([xB[t][v_] for t in TB]))
        
    for j in TB:
        # depart and arrival has to use same tank
        # Condition 114d1, Condition 114d2
        for (u, v) in depArrPort1:
            solver.Add(xB[j][u] == xB[j][v])
        for (u, v) in depArrPort2:
            solver.Add(wB[j][u] == wB[j][v])
        
        # rotation loading ports
        # Condition 114e1, Condition 114e2
        for u_, v_ in rotatingPort:
            solver.Add((-wB[j][u_] +  wB[j][v_]) <= 1e6*(1-zBa[j]))
            solver.Add((wB[j][u_] -  wB[j][v_]) <= 1e6*(1-zBb[j]))
            
        # Condition 114e3
        solver.Add((zBa[j] + zBb[j]) == 1)
        
        # fixed ballast
        # Condition 114f1
        for p in fixBallastPort:
            if int(p) > 0:
                solver.Add(B_locked.get(j,{}).get(int(p),0) == wB[j][int(p)])
            
    # deballast amt
    # Condition 114g1
    for i in list(set(loadPort).intersection(set(P_stable))):
        solver.Add(solver.Sum([wB[t][i] for t in TB]) + deballastPercent*loadingPortAmt[i] >= solver.Sum([wB[t][i-1] for t in TB]))
        
    # departure of last loading port
    # Condition114h
    for i in lastLoadingPortBallastBan:
        for j in specialBallastPort:
            solver.Add(xB[i][j] == 0)
    # arrival of last loading port
    # Condition114h1
    for i in TB:
        for j in zeroBallastPort:
            solver.Add(xB[i][j] == 0)
            
    ## ship stabilty
    # assume the ship satisfies all the stability conditions when entering the first port, and ballast tank allocation will be refreshed before leaving each port.
     
    # Constr 17a
    for i in T:
        for j in P:
            solver.Add(wC[i][j] == onboard.get(i,0.) + solver.Sum([qw2f[k][i][j]/10 for k in C]))

            
    # draft constraint
    # displacement
    # Constr13c1
    # Constr13c2
    # loading and unloading port
    # Constr13
    for i in P_stable:
        solver.Add(displacement[i] == (solver.Sum([wC[t][i] for t in T]) + 
                      solver.Sum([wB[t][i] for t in TB]) + 
                      solver.Sum([weightOtherTank.get(t,{}).get(i,0.) for t in OtherTanks]) + 
                      lightWeight + deadweightConst))
        solver.Add(displacement1[i] == displacement[i]*1.025/densitySeaWater[i])
        solver.Add(displacement[i] >= (displacementLowLimit[i] + 0.001))
        solver.Add(displacement[i] <= (displacementLimit[i] - 0.001))
    
    # deadweight constraint
    # Constr13a
    for i in P_stable:
        solver.Add((solver.Sum([wC[t][i] for t in T]) + 
                    solver.Sum([wB[t][i] for t in TB]) +
                    solver.Sum([weightOtherTank.get(t,{}).get(i,0.) for t in OtherTanks]) + 
                    deadweightConst) <= deadweight)
    
    # Constr13b
    for i in P_last_loading:
        solver.Add(solver.Sum([wC[t][i] for t in T]) <= cargoweight)
        
        
    ## New list constraint
    # 10 pieces
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
  
    for i in list(set(TB)-set(TB1)):
        lambda1_TB[i] = {}
        lambda2_TB[i] = {}
        lambda3_TB[i] = {}
        lambda4_TB[i] = {}
        lambda5_TB[i] = {}
        lambda6_TB[i] = {}
        lambda7_TB[i] = {}
        lambda8_TB[i] = {}
        lambda9_TB[i] = {}
        lambda10_TB[i] = {}
        lambda11_TB[i] = {}
        z1_TB[i] = {}
        z2_TB[i] = {}
        z3_TB[i] = {}
        z4_TB[i] = {}
        
           
        for j in P_stable:
            lambda1_TB[i][j] = solver.NumVar(0, 1, 'lambda1_TB[%s][%d]' % (i,j))
            lambda2_TB[i][j] = solver.NumVar(0, 1, 'lambda2_TB[%s][%d]' % (i,j))
            lambda3_TB[i][j] = solver.NumVar(0, 1, 'lambda3_TB[%s][%d]' % (i,j))
            lambda4_TB[i][j] = solver.NumVar(0, 1, 'lambda4_TB[%s][%d]' % (i,j))
            lambda5_TB[i][j] = solver.NumVar(0, 1, 'lambda5_TB[%s][%d]' % (i,j))
            lambda6_TB[i][j] = solver.NumVar(0, 1, 'lambda6_TB[%s][%d]' % (i,j))
            lambda7_TB[i][j] = solver.NumVar(0, 1, 'lambda7_TB[%s][%d]' % (i,j))
            lambda8_TB[i][j] = solver.NumVar(0, 1, 'lambda8_TB[%s][%d]' % (i,j))
            lambda9_TB[i][j] = solver.NumVar(0, 1, 'lambda9_TB[%s][%d]' % (i,j))
            lambda10_TB[i][j] = solver.NumVar(0, 1, 'lambda10_TB[%s][%d]' % (i,j))
            lambda11_TB[i][j] = solver.NumVar(0, 1, 'lambda11_TB[%s][%d]' % (i,j))
            z1_TB[i][j] = solver.IntVar(0, 1, 'z1_TB[%s][%d]' % (i,j))
            z2_TB[i][j] = solver.IntVar(0, 1, 'z2_TB[%s][%d]' % (i,j))
            z3_TB[i][j] = solver.IntVar(0, 1, 'z3_TB[%s][%d]' % (i,j))
            z4_TB[i][j] = solver.IntVar(0, 1, 'z4_TB[%s][%d]' % (i,j))
  
            solver.Add(lambda3_TB[i][j] + lambda7_TB[i][j] + lambda11_TB[i][j] <= z1_TB[i][j])
            solver.Add(lambda1_TB[i][j] + lambda5_TB[i][j] + lambda9_TB[i][j] <= 1 - z1_TB[i][j])
            solver.Add(lambda4_TB[i][j] + lambda5_TB[i][j] + lambda6_TB[i][j] <= z2_TB[i][j])
            solver.Add(lambda1_TB[i][j] + lambda2_TB[i][j] + lambda8_TB[i][j]  + 
                        lambda9_TB[i][j] + lambda10_TB[i][j] + lambda11_TB[i][j] <= 1 - z2_TB[i][j])
            solver.Add(lambda6_TB[i][j] + lambda7_TB[i][j] + lambda8_TB[i][j]  + 
                        lambda9_TB[i][j] + lambda10_TB[i][j] + lambda11_TB[i][j] <= z3_TB[i][j])
            solver.Add(lambda1_TB[i][j] + lambda2_TB[i][j] + lambda3_TB[i][j]  + 
                        lambda4_TB[i][j] <= 1 - z3_TB[i][j])
            solver.Add(lambda10_TB[i][j] + lambda11_TB[i][j] <= z4_TB[i][j])
            solver.Add(lambda1_TB[i][j] + lambda2_TB[i][j] + lambda3_TB[i][j]  + 
                        lambda4_TB[i][j] + lambda5_TB[i][j] + lambda6_TB[i][j]  + 
                        lambda7_TB[i][j] + lambda8_TB[i][j]<= 1 - z4_TB[i][j])
            
            solver.Add(lambda1_TB[i][j]+lambda2_TB[i][j]+lambda3_TB[i][j]+
                        lambda4_TB[i][j]+lambda5_TB[i][j]+lambda6_TB[i][j]+
                        lambda7_TB[i][j]+lambda8_TB[i][j]+lambda9_TB[i][j]+
                        lambda10_TB[i][j]+lambda11_TB[i][j] == 1)

            ##?? check on need for seawater density
            solver.Add(wB[i][j] == lambda1_TB[i][j]*bTank_n[0][i]+lambda2_TB[i][j]*bTank_n[1][i]+lambda3_TB[i][j]*bTank_n[2][i]+
                                    lambda4_TB[i][j]*bTank_n[3][i]+lambda5_TB[i][j]*bTank_n[4][i]+lambda6_TB[i][j]*bTank_n[5][i]+
                                    lambda7_TB[i][j]*bTank_n[6][i]+lambda8_TB[i][j]*bTank_n[7][i]+lambda9_TB[i][j]*bTank_n[8][i]+
                                    lambda10_TB[i][j]*bTank_n[9][i]+lambda11_TB[i][j]*bTank_n[10][i])
            
            
            # Constr15b1
            solver.Add(TB_tmom[i][j] == (lambda1_TB[i][j]*cTank_n[0][i]+lambda2_TB[i][j]*cTank_n[1][i]+lambda3_TB[i][j]*cTank_n[2][i]+
                                        lambda4_TB[i][j]*cTank_n[3][i]+lambda5_TB[i][j]*cTank_n[4][i]+lambda6_TB[i][j]*cTank_n[5][i]+
                                        lambda7_TB[i][j]*cTank_n[6][i]+lambda8_TB[i][j]*cTank_n[7][i]+lambda9_TB[i][j]*cTank_n[8][i]+
                                        lambda10_TB[i][j]*cTank_n[9][i]+lambda11_TB[i][j]*cTank_n[10][i]))
                    
    # Constr15b2
    for i in TB1:
        for j in P_stable:
            # solver.Add(TB_tmom[i][j] == wB[i][j]*TCGt[i])
            TB_tmom[i][j] = wB[i][j]*TCGt[i]
            
            
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

    for i in list(set(T)-set(T1)):
        lambda1_T[i] = {}
        lambda2_T[i] = {}
        lambda3_T[i] = {}
        lambda4_T[i] = {}
        lambda5_T[i] = {}
        lambda6_T[i] = {}
        lambda7_T[i] = {}
        lambda8_T[i] = {}
        lambda9_T[i] = {}
        lambda10_T[i] = {}
        lambda11_T[i] = {}
        z1_T[i] = {}
        z2_T[i] = {}
        z3_T[i] = {}
        z4_T[i] = {}

        for j in P_stable:
            lambda1_T[i][j] = solver.NumVar(0, 1, 'lambda1_T[%s][%d]' % (i,j))
            lambda2_T[i][j] = solver.NumVar(0, 1, 'lambda2_T[%s][%d]' % (i,j))
            lambda3_T[i][j] = solver.NumVar(0, 1, 'lambda3_T[%s][%d]' % (i,j))
            lambda4_T[i][j] = solver.NumVar(0, 1, 'lambda4_T[%s][%d]' % (i,j))
            lambda5_T[i][j] = solver.NumVar(0, 1, 'lambda5_T[%s][%d]' % (i,j))
            lambda6_T[i][j] = solver.NumVar(0, 1, 'lambda6_T[%s][%d]' % (i,j))
            lambda7_T[i][j] = solver.NumVar(0, 1, 'lambda7_T[%s][%d]' % (i,j))
            lambda8_T[i][j] = solver.NumVar(0, 1, 'lambda8_T[%s][%d]' % (i,j))
            lambda9_T[i][j] = solver.NumVar(0, 1, 'lambda9_T[%s][%d]' % (i,j))
            lambda10_T[i][j] = solver.NumVar(0, 1, 'lambda10_T[%s][%d]' % (i,j))
            lambda11_T[i][j] = solver.NumVar(0, 1, 'lambda11_T[%s][%d]' % (i,j))
            z1_T[i][j] = solver.IntVar(0, 1, 'z1_T[%s][%d]' % (i,j))
            z2_T[i][j] = solver.IntVar(0, 1, 'z2_T[%s][%d]' % (i,j))
            z3_T[i][j] = solver.IntVar(0, 1, 'z3_T[%s][%d]' % (i,j))
            z4_T[i][j] = solver.IntVar(0, 1, 'z4_T[%s][%d]' % (i,j))

            solver.Add(lambda3_T[i][j] + lambda7_T[i][j] + lambda11_T[i][j] <= z1_T[i][j])
            solver.Add(lambda1_T[i][j] + lambda5_T[i][j] + lambda9_T[i][j] <= 1 - z1_T[i][j])
            solver.Add(lambda4_T[i][j] + lambda5_T[i][j] + lambda6_T[i][j] <= z2_T[i][j])
            solver.Add(lambda1_T[i][j] + lambda2_T[i][j] + lambda8_T[i][j]  + 
                        lambda9_T[i][j] + lambda10_T[i][j] + lambda11_T[i][j] <= 1 - z2_T[i][j])
            solver.Add(lambda6_T[i][j] + lambda7_T[i][j] + lambda8_T[i][j]  + 
                        lambda9_T[i][j] + lambda10_T[i][j] + lambda11_T[i][j] <= z3_T[i][j])
            solver.Add(lambda1_T[i][j] + lambda2_T[i][j] + lambda3_T[i][j]  + 
                        lambda4_T[i][j] <= 1 - z3_T[i][j])
            solver.Add(lambda10_T[i][j] + lambda11_T[i][j] <= z4_T[i][j])
            solver.Add(lambda1_T[i][j] + lambda2_T[i][j] + lambda3_T[i][j]  + 
                        lambda4_T[i][j] + lambda5_T[i][j] + lambda6_T[i][j]  + 
                        lambda7_T[i][j] + lambda8_T[i][j]<= 1 - z4_T[i][j])
            
            solver.Add(lambda1_T[i][j]+lambda2_T[i][j]+lambda3_T[i][j]+
                        lambda4_T[i][j]+lambda5_T[i][j]+lambda6_T[i][j]+
                        lambda7_T[i][j]+lambda8_T[i][j]+lambda9_T[i][j]+
                        lambda10_T[i][j]+lambda11_T[i][j] == 1)
            
            solver.Add(wC[i][j] == lambda1_T[i][j]*bTank_n[0][i]+lambda2_T[i][j]*bTank_n[1][i]+lambda3_T[i][j]*bTank_n[2][i]+
                                    lambda4_T[i][j]*bTank_n[3][i]+lambda5_T[i][j]*bTank_n[4][i]+lambda6_T[i][j]*bTank_n[5][i]+
                                    lambda7_T[i][j]*bTank_n[6][i]+lambda8_T[i][j]*bTank_n[7][i]+lambda9_T[i][j]*bTank_n[8][i]+
                                    lambda10_T[i][j]*bTank_n[9][i]+lambda11_T[i][j]*bTank_n[10][i])
            
            solver.Add(T_tmom[i][j] == lambda1_T[i][j]*cTank_n[0][i]+lambda2_T[i][j]*cTank_n[1][i]+lambda3_T[i][j]*cTank_n[2][i]+
                                        lambda4_T[i][j]*cTank_n[3][i]+lambda5_T[i][j]*cTank_n[4][i]+lambda6_T[i][j]*cTank_n[5][i]+
                                        lambda7_T[i][j]*cTank_n[6][i]+lambda8_T[i][j]*cTank_n[7][i]+lambda9_T[i][j]*cTank_n[8][i]+
                                        lambda10_T[i][j]*cTank_n[9][i]+lambda11_T[i][j]*cTank_n[10][i])

    # Constr15c2
    for i in T1:
        for j in P_stable:
            solver.Add(T_tmom[i][j] == wC[i][j]*TCGt[i])    
            
    for i in P_stable:
        # Constr153
        
        solver.Add(T_mom[i] == (solver.Sum([T_tmom[t][i] for t in T]) + 
                    solver.Sum([TB_tmom[t][i] for t in TB]) + 
                    solver.Sum([weightOtherTank.get(t,{}).get(i,0.)*TCGtp.get(t,{}).get(i,0.) for t in OtherTanks]) + 
                    deadweightConst*TCGdw))
        
        # Constr154
        solver.Add(T_mom[i] >= -ListMOM)
        solver.Add(T_mom[i] <= ListMOM)
    
    ## Trim constraint
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
    
    for i in P_stable:
        # Constr161
        solver.Add(L_mom[i] == (solver.Sum([wC[t][i]*LCGt[t] for t in T]) + 
                    solver.Sum([wB[t][i]*LCGt[t] for t in TB]) + 
                    solver.Sum([weightOtherTank.get(t,{}).get(i,0.)*LCGt[t] for t in OtherTanks]) + 
                    lightWeight*LCGship + deadweightConst*LCGdw))
        
        # Constr163
        lambda1_LCB[i] = solver.NumVar(0, 1, 'lambda1_LCB[%d]' % (i))
        lambda2_LCB[i] = solver.NumVar(0, 1, 'lambda2_LCB[%d]' % (i))
        lambda3_LCB[i] = solver.NumVar(0, 1, 'lambda3_LCB[%d]' % (i))
        lambda4_LCB[i] = solver.NumVar(0, 1, 'lambda4_LCB[%d]' % (i))
        lambda5_LCB[i] = solver.NumVar(0, 1, 'lambda5_LCB[%d]' % (i))
        lambda6_LCB[i] = solver.NumVar(0, 1, 'lambda6_LCB[%d]' % (i))
        lambda7_LCB[i] = solver.NumVar(0, 1, 'lambda7_LCB[%d]' % (i))
        lambda8_LCB[i] = solver.NumVar(0, 1, 'lambda8_LCB[%d]' % (i))
        lambda9_LCB[i] = solver.NumVar(0, 1, 'lambda9_LCB[%d]' % (i))
        lambda10_LCB[i] = solver.NumVar(0, 1, 'lambda10_LCB[%d]' % (i))
        lambda11_LCB[i] = solver.NumVar(0, 1, 'lambda11_LCB[%d]' % (i))
        z1_LCB[i] = solver.IntVar(0, 1, 'z1_LCB[%d]' % (i))
        z2_LCB[i] = solver.IntVar(0, 1, 'z2_LCB[%d]' % (i))
        z3_LCB[i] = solver.IntVar(0, 1, 'z3_LCB[%d]' % (i))
        z4_LCB[i] = solver.IntVar(0, 1, 'z4_LCB[%d]' % (i))
 
        solver.Add(lambda3_LCB[i] + lambda7_LCB[i] + lambda11_LCB[i] <= z1_LCB[i])
        solver.Add(lambda1_LCB[i] + lambda5_LCB[i] + lambda9_LCB[i] <= 1 - z1_LCB[i])
        solver.Add(lambda4_LCB[i] + lambda5_LCB[i] + lambda6_LCB[i] <= z2_LCB[i])
        solver.Add(lambda1_LCB[i] + lambda2_LCB[i] + lambda8_LCB[i] + 
                    lambda9_LCB[i] + lambda10_LCB[i] + lambda11_LCB[i] <= 1 - z2_LCB[i])
        solver.Add(lambda6_LCB[i] + lambda7_LCB[i] + lambda8_LCB[i] + 
                    lambda9_LCB[i] + lambda10_LCB[i] + lambda11_LCB[i] <= z3_LCB[i])
        solver.Add(lambda1_LCB[i] + lambda2_LCB[i] + lambda3_LCB[i] + 
                    lambda4_LCB[i] <= 1 - z3_LCB[i])
        solver.Add(lambda10_LCB[i] + lambda11_LCB[i] <= z4_LCB[i])
        solver.Add(lambda1_LCB[i] + lambda2_LCB[i] + lambda3_LCB[i] + 
                    lambda4_LCB[i] + lambda5_LCB[i] + lambda6_LCB[i] + 
                    lambda7_LCB[i] + lambda8_LCB[i]<= 1 - z4_LCB[i])
        
        solver.Add(lambda1_LCB[i]+lambda2_LCB[i]+lambda3_LCB[i]+
                    lambda4_LCB[i]+lambda5_LCB[i]+lambda6_LCB[i]+
                    lambda7_LCB[i]+lambda8_LCB[i]+lambda9_LCB[i]+
                    lambda10_LCB[i]+lambda11_LCB[i] == 1)
        
        solver.Add(displacement1[i] == lambda1_LCB[i]*bLCB_n[0]+lambda2_LCB[i]*bLCB_n[1]+lambda3_LCB[i]*bLCB_n[2]+
                                      lambda4_LCB[i]*bLCB_n[3]+lambda5_LCB[i]*bLCB_n[4]+lambda6_LCB[i]*bLCB_n[5]+
                                      lambda7_LCB[i]*bLCB_n[6]+lambda8_LCB[i]*bLCB_n[7]+lambda9_LCB[i]*bLCB_n[8]+
                                      lambda10_LCB[i]*bLCB_n[9]+lambda11_LCB[i]*bLCB_n[10])
            
              
        solver.Add(LCBp[i] == lambda1_LCB[i]*cLCB_n[0]+lambda2_LCB[i]*cLCB_n[1]+lambda3_LCB[i]*cLCB_n[2]+
                              lambda4_LCB[i]*cLCB_n[3]+lambda5_LCB[i]*cLCB_n[4]+lambda6_LCB[i]*cLCB_n[5]+
                              lambda7_LCB[i]*cLCB_n[6]+lambda8_LCB[i]*cLCB_n[7]+lambda9_LCB[i]*cLCB_n[8]+
                              lambda10_LCB[i]*cLCB_n[9]+lambda11_LCB[i]*cLCB_n[10])
        
        # Constr164
        lambda1_MTC[i] = solver.NumVar(0, 1, 'lambda1_MTC[%d]' % (i))
        lambda2_MTC[i] = solver.NumVar(0, 1, 'lambda2_MTC[%d]' % (i))
        lambda3_MTC[i] = solver.NumVar(0, 1, 'lambda3_MTC[%d]' % (i))
        lambda4_MTC[i] = solver.NumVar(0, 1, 'lambda4_MTC[%d]' % (i))
        lambda5_MTC[i] = solver.NumVar(0, 1, 'lambda5_MTC[%d]' % (i))
        lambda6_MTC[i] = solver.NumVar(0, 1, 'lambda6_MTC[%d]' % (i))
        lambda7_MTC[i] = solver.NumVar(0, 1, 'lambda7_MTC[%d]' % (i))
        lambda8_MTC[i] = solver.NumVar(0, 1, 'lambda8_MTC[%d]' % (i))
        lambda9_MTC[i] = solver.NumVar(0, 1, 'lambda9_MTC[%d]' % (i))
        lambda10_MTC[i] = solver.NumVar(0, 1, 'lambda10_MTC[%d]' % (i))
        lambda11_MTC[i] = solver.NumVar(0, 1, 'lambda11_MTC[%d]' % (i))
        z1_MTC[i] = solver.IntVar(0, 1, 'z1_MTC[%d]' % (i))
        z2_MTC[i] = solver.IntVar(0, 1, 'z2_MTC[%d]' % (i))
        z3_MTC[i] = solver.IntVar(0, 1, 'z3_MTC[%d]' % (i))
        z4_MTC[i] = solver.IntVar(0, 1, 'z4_MTC[%d]' % (i))
        
        solver.Add(lambda3_MTC[i] + lambda7_MTC[i] + lambda11_MTC[i] <= z1_MTC[i])
        solver.Add(lambda1_MTC[i] + lambda5_MTC[i] + lambda9_MTC[i] <= 1 - z1_MTC[i])
        solver.Add(lambda4_MTC[i] + lambda5_MTC[i] + lambda6_MTC[i] <= z2_MTC[i])
        solver.Add(lambda1_MTC[i] + lambda2_MTC[i] + lambda8_MTC[i] + 
                    lambda9_MTC[i] + lambda10_MTC[i] + lambda11_MTC[i] <= 1 - z2_MTC[i])
        solver.Add(lambda6_MTC[i] + lambda7_MTC[i] + lambda8_MTC[i] + 
                    lambda9_MTC[i] + lambda10_MTC[i] + lambda11_MTC[i] <= z3_MTC[i])
        solver.Add(lambda1_MTC[i] + lambda2_MTC[i] + lambda3_MTC[i] + 
                    lambda4_MTC[i] <= 1 - z3_MTC[i])
        solver.Add(lambda10_MTC[i] + lambda11_MTC[i] <= z4_MTC[i])
        solver.Add(lambda1_MTC[i] + lambda2_MTC[i] + lambda3_MTC[i] + 
                    lambda4_MTC[i] + lambda5_MTC[i] + lambda6_MTC[i] + 
                    lambda7_MTC[i] + lambda8_MTC[i]<= 1 - z4_MTC[i])
        
        solver.Add(lambda1_MTC[i]+lambda2_MTC[i]+lambda3_MTC[i]+
                    lambda4_MTC[i]+lambda5_MTC[i]+lambda6_MTC[i]+
                    lambda7_MTC[i]+lambda8_MTC[i]+lambda9_MTC[i]+
                    lambda10_MTC[i]+lambda11_MTC[i] == 1)
        
        
        solver.Add(displacement1[i] == lambda1_MTC[i]*bMTC_n[0]+lambda2_MTC[i]*bMTC_n[1]+lambda3_MTC[i]*bMTC_n[2]+
                                      lambda4_MTC[i]*bMTC_n[3]+lambda5_MTC[i]*bMTC_n[4]+lambda6_MTC[i]*bMTC_n[5]+
                                      lambda7_MTC[i]*bMTC_n[6]+lambda8_MTC[i]*bMTC_n[7]+lambda9_MTC[i]*bMTC_n[8]+
                                      lambda10_MTC[i]*bMTC_n[9]+lambda11_MTC[i]*bMTC_n[10])

        solver.Add(MTCp[i] == lambda1_MTC[i]*cMTC_n[0]+lambda2_MTC[i]*cMTC_n[1]+lambda3_MTC[i]*cMTC_n[2]+
                              lambda4_MTC[i]*cMTC_n[3]+lambda5_MTC[i]*cMTC_n[4]+lambda6_MTC[i]*cMTC_n[5]+
                              lambda7_MTC[i]*cMTC_n[6]+lambda8_MTC[i]*cMTC_n[7]+lambda9_MTC[i]*cMTC_n[8]+
                              lambda10_MTC[i]*cMTC_n[9]+lambda11_MTC[i]*cMTC_n[10])
        
        #Constr16a
        solver.Add(MTCp[i]*trim_lower.get(i,-0.001)*100 <= (L_mom[i] - LCBp[i]))
        
        # Constr16b
        solver.Add((L_mom[i] - LCBp[i]) <= MTCp[i]*trim_upper.get(i,0.001)*100)
    
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
    
    for i in P_stable:
        # Constr18a
        solver.Add(wn[0][i] == 0)
        # Constr19a
        solver.Add(mn[0][i] == 0)
        
        # Constr18d
        lambda1_Draft[i] = solver.NumVar(0, 1, 'lambda1_Draft[%d]' % (i))
        lambda2_Draft[i] = solver.NumVar(0, 1, 'lambda2_Draft[%d]' % (i))
        lambda3_Draft[i] = solver.NumVar(0, 1, 'lambda3_Draft[%d]' % (i))
        lambda4_Draft[i] = solver.NumVar(0, 1, 'lambda4_Draft[%d]' % (i))
        lambda5_Draft[i] = solver.NumVar(0, 1, 'lambda5_Draft[%d]' % (i))
        lambda6_Draft[i] = solver.NumVar(0, 1, 'lambda6_Draft[%d]' % (i))
        lambda7_Draft[i] = solver.NumVar(0, 1, 'lambda7_Draft[%d]' % (i))
        lambda8_Draft[i] = solver.NumVar(0, 1, 'lambda8_Draft[%d]' % (i))
        lambda9_Draft[i] = solver.NumVar(0, 1, 'lambda9_Draft[%d]' % (i))
        lambda10_Draft[i] = solver.NumVar(0, 1, 'lambda10_Draft[%d]' % (i))
        lambda11_Draft[i] = solver.NumVar(0, 1, 'lambda11_Draft[%d]' % (i))
        z1_Draft[i] = solver.IntVar(0, 1, 'z1_Draft[%d]' % (i))
        z2_Draft[i] = solver.IntVar(0, 1, 'z2_Draft[%d]' % (i))
        z3_Draft[i] = solver.IntVar(0, 1, 'z3_Draft[%d]' % (i))
        z4_Draft[i] = solver.IntVar(0, 1, 'z4_Draft[%d]' % (i))
        
        solver.Add(lambda3_Draft[i] + lambda7_Draft[i] + lambda11_Draft[i] <= z1_Draft[i])
        solver.Add(lambda1_Draft[i] + lambda5_Draft[i] + lambda9_Draft[i] <= 1 - z1_Draft[i])
        solver.Add(lambda4_Draft[i] + lambda5_Draft[i] + lambda6_Draft[i] <= z2_Draft[i])
        solver.Add(lambda1_Draft[i] + lambda2_Draft[i] + lambda8_Draft[i] + 
                    lambda9_Draft[i] + lambda10_Draft[i] + lambda11_Draft[i] <= 1 - z2_Draft[i])
        solver.Add(lambda6_Draft[i] + lambda7_Draft[i] + lambda8_Draft[i] + 
                    lambda9_Draft[i] + lambda10_Draft[i] + lambda11_Draft[i] <= z3_Draft[i])
        solver.Add(lambda1_Draft[i] + lambda2_Draft[i] + lambda3_Draft[i] + 
                    lambda4_Draft[i] <= 1 - z3_Draft[i])
        solver.Add(lambda10_Draft[i] + lambda11_Draft[i] <= z4_Draft[i])
        solver.Add(lambda1_Draft[i] + lambda2_Draft[i] + lambda3_Draft[i] + 
                    lambda4_Draft[i] + lambda5_Draft[i] + lambda6_Draft[i] + 
                    lambda7_Draft[i] + lambda8_Draft[i]<= 1 - z4_Draft[i])
        
        solver.Add(lambda1_Draft[i]+lambda2_Draft[i]+lambda3_Draft[i]+
                    lambda4_Draft[i]+lambda5_Draft[i]+lambda6_Draft[i]+
                    lambda7_Draft[i]+lambda8_Draft[i]+lambda9_Draft[i]+
                    lambda10_Draft[i]+lambda11_Draft[i] == 1)
        
        solver.Add(displacement[i] == lambda1_Draft[i]*bDraft_n[0]+lambda2_Draft[i]*bDraft_n[1]+lambda3_Draft[i]*bDraft_n[2]+
                                      lambda4_Draft[i]*bDraft_n[3]+lambda5_Draft[i]*bDraft_n[4]+lambda6_Draft[i]*bDraft_n[5]+
                                      lambda7_Draft[i]*bDraft_n[6]+lambda8_Draft[i]*bDraft_n[7]+lambda9_Draft[i]*bDraft_n[8]+
                                      lambda10_Draft[i]*bDraft_n[9]+lambda11_Draft[i]*bDraft_n[10])
            
        solver.Add(mean_draft[i] == lambda1_Draft[i]*cDraft_n[0]+lambda2_Draft[i]*cDraft_n[1]+lambda3_Draft[i]*cDraft_n[2]+
                                    lambda4_Draft[i]*cDraft_n[3]+lambda5_Draft[i]*cDraft_n[4]+lambda6_Draft[i]*cDraft_n[5]+
                                    lambda7_Draft[i]*cDraft_n[6]+lambda8_Draft[i]*cDraft_n[7]+lambda9_Draft[i]*cDraft_n[8]+
                                    lambda10_Draft[i]*cDraft_n[9]+lambda11_Draft[i]*cDraft_n[10])
    
    for i in range(1,Fr+1):
        
        for j in P_stable:
            
            # Constr18b
            solver.Add(wn[i][j] == wn[i-1][j] + 
                        solver.Sum([weightRatio_ct.get(i,{}).get(t,0.)*wC[t][j]/1000 for t in T]) + 
                        solver.Sum([weightRatio_bt.get(i,{}).get(t,0.)*wB[t][j]/1000 for t in TB]) + 
                        solver.Sum([weightRatio_ot.get(i,{}).get(t,0.)*weightOtherTank.get(t,{}).get(j,0.)/1000 for t in OtherTanks]))
            
            # Constr19b
            solver.Add(mn[i][j] == mn[i-1][j] + 
                        solver.Sum([LCG_ct.get(i,{}).get(t,0.)*weightRatio_ct.get(i,{}).get(t,0.)*wC[t][j]/1000 for t in T]) + 
                        solver.Sum([LCG_bt.get(i,{}).get(t,0.)*weightRatio_bt.get(i,{}).get(t,0.)*wB[t][j]/1000 for t in TB]) + 
                        solver.Sum([LCG_ot.get(i,{}).get(t,0.)*weightRatio_ot.get(i,{}).get(t,0.)*weightOtherTank.get(t,{}).get(j,0.)/1000 for t in OtherTanks]))
            
            #Condition20a
            solver.Add(lowerSFlimit[i] <= BV_SF[i][j] + CD_SF[i][j]*(mean_draft[j]-base_draft[j]) - wn[i][j])
            
            # Condition20b
            solver.Add(BV_SF[i][j] + CD_SF[i][j]*(mean_draft[j]-base_draft[j]) - wn[i][j] <= upperSFlimit[i])
            
            # Condition21a
            solver.Add(lowerBMlimit[i] <= wn[i][j]*LCG_fr[i] +mn[i][j] - (BV_BM[i][j]+CD_BM[i][j]*(mean_draft[j]-base_draft[j])))
            
            # Condition21b
            solver.Add(wn[i][j]*LCG_fr[i] + mn[i][j] - (BV_BM[i][j]+ CD_BM[i][j]*(mean_draft[j]- base_draft[j])) <= upperBMlimit[i])
            
            
   
    
    
    #    print('print model:')
    #    print(solver.ExportModelAsLpFormat(False).replace('\\', '').replace(',_', ','), sep='\n')
    
    # Output
    ##------------------------------------------------------------------------------------------
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
        for i in C:
            for j in Tc[i]:
                for k in P_last_loading:
                    totloaded = totloaded + qw2f[i][j][k].solution_value()/10
                
        num_sol = 1.0;
        cargoloaded = {}
        cargoloaded[num_sol] = {}
        for i in C:
            cargoloaded[num_sol][i] = sum([qw2f[i][j][k].solution_value()/10 for j in Tc[i] for k in P_last_loading])
        # print(totloaded)
        res = {}
        shipStatus = {}
        xx = {}
        res[num_sol] = {}
        shipStatus[num_sol] = {}
        xx[num_sol] = {}
        for i in C:
            res[num_sol][i] = {}
            shipStatus[num_sol][i] = {}
            xx[num_sol][i] = {}
            for j in T:
                res[num_sol][i][j] = {}
                shipStatus[num_sol][i][j] = {}
                xx[num_sol][i][j] = x[i][j].solution_value()
                for k in P:
                    res[num_sol][i][j][k] = w[i][j][k].solution_value()
                    shipStatus[num_sol][i][j][k] = qw2f[i][j][k].solution_value()/10
        
        wtB = {}
        wtB[num_sol] = {}
        for i in TB:
            wtB[num_sol][i] = {}
            for j in P:
                wtB[num_sol][i][j] = wB[i][j].solution_value()
                    
        cargoloadedport = {}
        cargoloadedport[num_sol] = {}
        for i in C:
            cargoloadedport[num_sol][i] = {}
            for j in P:
                cargoloadedport[num_sol][i][j] = 0
                cargoloadedport[num_sol][i][j] = sum([qw2f[i][k][j].solution_value()/10 for k in Tc[i]])
        
        # ## to be removed
        # TB_moment = {}
        # wB1 = {}
        # TCGt1 = {}
        # for i in TB:
        #     TB_moment[i] = {}
        #     wB1[i] = {}
        #     TCGt1[i] = TCGt[i]
        #     for j in P_stable:
        #         TB_moment[i][j] = TB_tmom[i][j].solution_value()
        #         wB1[i][j] = wB[i][j].solution_value()
        # # T_mom1 = {}
        # # for i in P:
        # #     T_mom1[i] = T_mom[i].solution_value() 
        # MTCp1 = {}
        # for i in P_stable:
        #     MTCp1[i] = MTCp[i].solution_value()
            
        # mean_draft1 = {}
        # displacement_1 = {}
        # for i in P:
        #     displacement_1[i] = displacement[i].solution_value()
        #     mean_draft1[i] = mean_draft[i].solution_value()
        
        
        # return {'TB_moment': [(k, t, x) for k, v, in TB_moment.items() for t, x in v.items()],
        #         'wB1': [(k, t, x) for k, v, in wB1.items() for t, x in v.items()],
        #         'TCGt1': [(k, v) for k, v, in TCGt1.items()],
        #         # 'T_mom1': [(k, v) for k, v, in T_mom1.items()],
        #         'MTCp1': [(k, v) for k, v, in MTCp1.items()],
        #         'displacement_1': [(k, v) for k, v, in displacement_1.items()],
        #         'mean_draft1': [(k, v) for k, v, in mean_draft1.items()]}
        # ## to be removed

        # for i in TB:
        #     for j in P:
        #         print(wB[i][j].name(), ' = ', wB[i][j].solution_value())
        return {'status': status,
                'totloaded': [(1,totloaded)],
                'cargoloaded': [(k, t, x) for k, v, in cargoloaded.items() for t, x in v.items()],
                'res': [(k, t, u, w, p) for k, v, in res.items() for t, x in v.items() for u, y in x.items() for w, p in y.items()],
                'shipStatus': [(k, t, u, w, p) for k, v, in shipStatus.items() for t, x in v.items() for u, y in x.items() for w, p in y.items()],
                'xx': [(k, t, u, y) for k, v, in xx.items() for t, x in v.items() for u, y in x.items()],
                'wtB': [(k, t, u, y) for k, v, in wtB.items() for t, x in v.items() for u, y in x.items()],
                'cargoloadedport': [(k, t, u, y) for k, v, in cargoloadedport.items() for t, x in v.items() for u, y in x.items()],
                'obj':[(1, Action_Amount.solution_value())]}

        # for i in TB:
        #     for j in P:
        #         print(wB[i][j].name(), ' = ', wB[i][j].solution_value())

    else:
        print('The problem does not have an feasible solution.')
        return {'status': None,
                'totloaded': [],
                'cargoloaded': [],
                'res': [],
                'shipStatus': [],
                'xx': [],
                'wtB': [],
                'cargoloadedport': [],
                'obj':[]}
    


    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
     