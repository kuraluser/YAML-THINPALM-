# -*- coding: utf-8 -*-
"""
Created on Tue Feb 23 15:32:14 2021

@author: I2R
"""
import numpy as np
from ortools.linear_solver import pywraplp

def vlcc_ortools(inputs):
    
    # print('run ortools ...')
    
     # Create the mip solver with the SCIP backend.
    solver = pywraplp.Solver.CreateSolver('SCIP')
    solver.SetTimeLimit(30*1000)
    
    infinity = solver.infinity()
    
    ## parameters ------------------------------------------------------------------
    # set of all cargo tanks'
    # cargo_tanks_ = []
    T = [i_ for i_,j_ in inputs.vessel.info['cargoTanks'].items()]
    # cargo tanks with non-pw tcg details
    T1 = [i_ for i_, j_ in inputs.vessel.info['cargoTanks'].items() if i_ not in inputs.vessel.info['tankTCG']['tcg_pw']]
    # set of all cargoes
    C = [i_ for i_,j_ in inputs.loadable.info['parcel'].items()]
    
    # set of tanks compatible with cargo c (consider tank coating, cargo history, tank heating)
    Tc = {}
    for i in C:
        Tc[i] = T
    
    # print('# set of tanks compatible with cargo c',file=text_file)
    for i_,j_ in inputs.loadable.info['parcel'].items():
         Tc[i_] = [j_ for j_ in T if j_ not in inputs.vessel.info['banCargo']]
         
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
    # min cargo to must be loaded
    minCargoLoad = {i_:round(j_,3) for i_, j_ in inputs.loadable.info['toLoadMin'].items()}  
    
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
        upperBound[T[i]] = 0.9802
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
                if v2_['tank'] not in T_locked:
                    T_locked.append(v2_['tank']) 
                    
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
                if v2_['tank']  not in tank_:
                    A_locked[k_][v2_['tank']] = 1
                    tank_.append(v2_['tank'])
                    
    W_locked  = {c_:{} for c_ in C_locked}     
    V_locked = {c_:{} for c_ in C_locked}
    for k_, v_ in inputs.loadable.info['manualOperation'].items():
        for k1_, v1_ in v_.items():
            for v2_ in v1_:
                if v2_['tank'] not in W_locked[k_].keys():
                    W_locked[k_][v2_['tank']] = {}
                    V_locked[k_][v2_['tank']] = {}
                    
                W_locked[k_][v2_['tank']][k1_] = round(v2_['qty'],3)
                V_locked[k_][v2_['tank']][k1_] = W_locked[k_][v2_['tank']][k1_]/densityCargo_Low[k_]
                
                
                # str1 = 'param B_locked := '
                # print(str1, file=text_file) 
                # for k_, v_ in self.loadable.info['ballastOperation'].items():
                #     tank_ = k_
                #     str1 = '[' + tank_ + ', *] := '
                #     for v__ in v_:
                #         if v__['order'] != '0':
                #             str1 += v__['order'] + ' ' + "{:.3f}".format(v__['qty']) + ' '
                #     print(str1, file=text_file)
                # print(';', file=text_file)  
                        
                
                # str1 = 'set fixBallastPort := '
                # for k_ in self.loadable.info['fixedBallastPort']:
                #     if k_ != '0':
                #         str1 += k_ + ' ' 
                # print(str1+';', file=text_file)
                
                # str1 = 'param trim_upper := '
                # for k_, v_ in self.trim_upper.items():
                #     str1 += k_ + ' ' + v_ + ' '
                # print(str1+';', file=text_file)
                
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
   
                
    # print('# initial ballast ',file=text_file)#
    initBallast = {k_:v_ for k_, v_ in inputs.vessel.info['initBallast']['wt'].items()}
    
    # print('# inc initial ballast ',file=text_file)#
    incTB  = inputs.vessel.info['initBallast']['inc']
    
    # print('# dec initial ballast ',file=text_file)#
    decTB = inputs.vessel.info['initBallast']['dec']
    
    
    # print('# loading ports ',file=text_file)#
    # str1 = 'set loadingPort := '
    # for k__, k_  in enumerate(self.vessel.info['loading']):
    #     if k__ < len(self.vessel.info['loading'])-1:
    #         str1 += '('+ str(k_)  + ',' + str(self.vessel.info['loading'][k__+1]) + ') '
    # print(str1+';', file=text_file)
    
    # print('# loading ports not last ',file=text_file)#
    # str1 = 'set loadingPortNotLast := '
    # for k__, k_  in enumerate(self.vessel.info['loading']):
    #     if k__ < len(self.vessel.info['loading'])-2:
    #         str1 += '('+ str(k_)  + ',' + str(self.vessel.info['loading'][k__+1]) + ') '
    # print(str1+';', file=text_file)
    
    # print('# departure arrival ports ',file=text_file)#
    # str1 = 'set depArrPort1 := '
    # if self.vessel.info['onhand'] : # non-empty ROB
    #     for k__, k_  in enumerate(self.vessel.info['loading']):
    #         if k__ < len(self.vessel.info['loading']):
    #             str1 += '('+ str(k_)  + ',' + str(int(k_)+1) + ') '
    # print(str1+';', file=text_file)
    # str1 = 'set depArrPort2 := '
    # if not self.vessel.info['onhand'] : # empty ROB
    #     for k__, k_  in enumerate(self.vessel.info['loading']):
    #         if k__ < len(self.vessel.info['loading']):
    #             str1 += '('+ str(k_)  + ',' + str(int(k_)+1) + ') '
    # print(str1+';', file=text_file)
    
    
    # print('# rotating ports ',file=text_file)#
    # str1 = 'set rotatingPort := '
    # for k__, k_  in enumerate(self.vessel.info['rotationVirtual']):
    #     if k__ < len(self.vessel.info['rotationVirtual'])-1:
    #         str1 += '('+ str(k_)  + ',' + str(self.vessel.info['rotationVirtual'][k__+1])+ ') '
    # print(str1+';', file=text_file)
    
    
    
    
    # capacity of ballast tanks', file=text_file)
    capacityBallastTank = {i_: round(j_['capacityCubm'],3) for i_, j_ in inputs.vessel.info['ballastTanks'].items() if i_ not in inputs.vessel.info['banBallast']}
    
    #upper loading bound for each ballast tank    
    upperBoundB1 = {}
    #lower loading bound for each ballast tank
    lowerBoundB1 = {}
    for i in range(len(TB)):
        upperBoundB1[TB[i]] = 1.0
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
    LCGdw = inputs.vessel.info['deadweightConst']['lcg']
    
    # TCG of deadweight constant', file=text_file)
    TCGdw  =  inputs.vessel.info['deadweightConst']['tcg'] 
    
    # max num tanks', file=text_file)
    maxTankUsed = inputs.maxTankUsed if inputs.maxTankUsed else 100
        
    
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
    # for m_ in range(1,self.vessel.info['tankTCG']['tcg_pw']['npw']+1):
    #     str1 = 'param mTank' + str(m_) + ' := '
    #     for k_, v_ in self.vessel.info['tankTCG']['tcg_pw'].items():
    #         if k_ not in (['npw']+self.vessel.info['banBallast']):
    #             str1 += k_ + ' ' + str(round(v_['slopes'][m_-1],8)) + ' '
    #     print(str1+';', file=text_file)
        
    # print('# breaks of TCG curves for tanks', file=text_file)
    # for m_ in range(1,self.vessel.info['tankTCG']['tcg_pw']['npw']):
    #     str1 = 'param bTank' + str(m_) + ' := '
    #     for k_, v_ in self.vessel.info['tankTCG']['tcg_pw'].items():
    #         if k_ not in (['npw']+self.vessel.info['banBallast']):
    #             str1 += k_ + ' ' + str(round(v_['breaks'][m_-1],8)) + ' '
    #     print(str1+';', file=text_file)
        
        
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
    # for m_ in range(1, len(self.vessel.info['lcb_mtc']['lcb']['slopes'])+1):
    #     str1 = 'param mLCB' + str(m_) + ' := ' + str(round(self.vessel.info['lcb_mtc']['lcb']['slopes'][m_-1],8))  
    #     print(str1+';', file=text_file)
        
    # print('# breaks of LCB x Disp curve', file=text_file)
    # for m_ in range(1,len(self.vessel.info['lcb_mtc']['lcb']['slopes'])):
    #     str1 = 'param bLCB' + str(m_) + ' := ' + str(round(self.vessel.info['lcb_mtc']['lcb']['breaks'][m_-1],8))  
    #     print(str1+';', file=text_file)
        
    # print('# slopes of MTC curve', file=text_file)
    # for m_ in range(1, len(self.vessel.info['lcb_mtc']['mtc']['slopes'])+1):
    #     str1 = 'param mMTC' + str(m_) + ' := ' + str(round(self.vessel.info['lcb_mtc']['mtc']['slopes'][m_-1],10))  
    #     print(str1+';', file=text_file)
        
    # print('# breaks of MTC curve', file=text_file)
    # for m_ in range(1,len(self.vessel.info['lcb_mtc']['mtc']['slopes'])):
    #     str1 = 'param bMTC' + str(m_) + ' := ' + str(round(self.vessel.info['lcb_mtc']['mtc']['breaks'][m_-1],10))  
    #     print(str1+';', file=text_file)
    
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
    # for m_ in range(1, len(self.vessel.info['lcb_mtc']['draft']['slopes'])+1):
    #     str1 = 'param mDraft' + str(m_) + ' := ' + str(round(self.vessel.info['lcb_mtc']['draft']['slopes'][m_-1],18))  
    #     print(str1+';', file=text_file)
        
    # print('# breaks of draft curve', file=text_file)
    # for m_ in range(1,len(self.vessel.info['lcb_mtc']['draft']['slopes'])):
    #     str1 = 'param bDraft' + str(m_) + ' := ' + str(round(self.vessel.info['lcb_mtc']['draft']['breaks'][m_-1],8))  
    #     print(str1+';', file=text_file)
    
    # print('# number of frames ',file=text_file)#
    # str1 = 'param Fr := ' + str(len(self.vessel.info['frames'])) 
    # print(str1+';', file=text_file)
    
    # print('# weight ratio for SF and BM',file=text_file)#
    # str1 = 'param weightRatio_ct := '
    # print(str1, file=text_file)
    # for i_, j_ in self.vessel.info['tankGroup'].items():
    #     str1 = '['+ str(i_) + ',*] = '
    #     for u_, v_ in j_.items():
    #         if u_ in cargo_tanks_:
    #             str1 += u_ + ' ' + str(round(v_['wr'],4)) + ' '
        
    #     if str1 != '['+ str(i_) + ',*] = ':
    #         print(str1, file=text_file)
    # print(';', file=text_file)
    
    # str1 = 'param weightRatio_bt := '
    # print(str1, file=text_file)
    # for i_, j_ in self.vessel.info['tankGroup'].items():
    #     str1 = '['+ str(i_) + ',*] = '
    #     for u_, v_ in j_.items():
    #         if u_ in ballast_tanks_:
    #             str1 += u_ + ' ' + str(round(v_['wr'],4)) + ' '
        
    #     if str1 != '['+ str(i_) + ',*] = ':
    #         print(str1, file=text_file)
    # print(';', file=text_file)
    
    # str1 = 'param weightRatio_ot := '
    # print(str1, file=text_file)
    # for i_, j_ in self.vessel.info['tankGroup'].items():
    #     str1 = '['+ str(i_) + ',*] = '
    #     for u_, v_ in j_.items():
    #         if u_ in other_tanks_:
    #             str1 += u_ + ' ' + str(round(v_['wr'],4)) + ' '
        
    #     if str1 != '['+ str(i_) + ',*] = ':
    #         print(str1, file=text_file)
    # print(';', file=text_file)
    
    
    # print('# LCG for SF and BM ',file=text_file)#
    # str1 = 'param LCG_ct := '
    # print(str1, file=text_file)
    # for i_, j_ in self.vessel.info['tankGroup'].items():
    #     str1 = '['+ str(i_) + ',*] = '
    #     for u_, v_ in j_.items():
    #         if u_ in cargo_tanks_:
    #             str1 += u_ + ' ' + str(round(v_['lcg'],4)) + ' '
        
    #     if str1 != '['+ str(i_) + ',*] = ':
    #         print(str1, file=text_file)
    # print(';', file=text_file)
    
    # str1 = 'param LCG_bt := '
    # print(str1, file=text_file)
    # for i_, j_ in self.vessel.info['tankGroup'].items():
    #     str1 = '['+ str(i_) + ',*] = '
    #     for u_, v_ in j_.items():
    #         if u_ in ballast_tanks_:
    #             str1 += u_ + ' ' + str(round(v_['lcg'],4)) + ' '
        
    #     if str1 != '['+ str(i_) + ',*] = ':
    #         print(str1, file=text_file)
    # print(';', file=text_file)
   
    # str1 = 'param LCG_ot := '
    # print(str1, file=text_file)
    # for i_, j_ in self.vessel.info['tankGroup'].items():
    #     str1 = '['+ str(i_) + ',*] = '
    #     for u_, v_ in j_.items():
    #         if u_ in other_tanks_:
    #             str1 += u_ + ' ' + str(round(v_['lcg'],4)) + ' '
        
    #     if str1 != '['+ str(i_) + ',*] = ':
    #         print(str1, file=text_file)
    # print(';', file=text_file)
     
    # str1 = 'param LCG_fr := '
    # for i_, j_ in self.vessel.info['tankGroupLCG'].items():
    #     str1 += str(i_) + ' ' + str(round(j_,3)) + ' '
    # print(str1+';', file=text_file)
    
    # print('# lower limit SF ',file=text_file)#
    # str1 = 'param lowerSFlimit := '
    # for i_, j_ in enumerate(self.vessel.info['frames']):
    #     str1 += str(i_+1) + ' ' +  str(round(float(self.vessel.info['SFlimits'][j_][0])/1000*self.sf_bm_frac,5)) + ' '      
    # print(str1+';', file=text_file)
    
    # print('# upper limit SF ',file=text_file)#
    # str1 = 'param upperSFlimit := '
    # for i_, j_ in enumerate(self.vessel.info['frames']):
    #     str1 += str(i_+1) + ' ' +  str(round(float(self.vessel.info['SFlimits'][j_][1])/1000*self.sf_bm_frac,5)) + ' '      
    # print(str1+';', file=text_file)
    
    # str1 = 'param BV_SF := '
    # print(str1, file=text_file)
    # for i_, j_ in self.vessel.info['tankGroup'].items():
    #     str1 = '['+ str(i_) + ',*] = '
    #     for k_, v_ in self.sf_base_value.items():
    #         str1 += str(k_) + ' ' + str(round(v_[int(i_)-1],5)) + ' '
    #     print(str1, file=text_file)
    # print(';', file=text_file)
    
    # str1 = 'param CD_SF := '
    # print(str1, file=text_file)
    # for i_, j_ in self.vessel.info['tankGroup'].items():
    #     str1 = '['+ str(i_) + ',*] = '
    #     for k_, v_ in self.sf_draft_corr.items():
    #         str1 += str(k_) + ' ' + str(round(v_[int(i_)-1],5)) + ' '
    #     print(str1, file=text_file)
    # print(';', file=text_file)
    
    
    
    # print('# lower limit BM ',file=text_file)#
    # str1 = 'param lowerBMlimit := '
    # for i_, j_ in enumerate(self.vessel.info['frames']):
    #     str1 += str(i_+1) + ' ' +  str(round(float(self.vessel.info['BMlimits'][j_][0])/1000*self.sf_bm_frac,5)) + ' '      
    # print(str1+';', file=text_file)
    
    # print('# upper limit BM ',file=text_file)#
    # str1 = 'param upperBMlimit := '
    # for i_, j_ in enumerate(self.vessel.info['frames']):
    #     str1 += str(i_+1) + ' ' +  str(round(float(self.vessel.info['BMlimits'][j_][1])/1000*self.sf_bm_frac,5)) + ' '      
    # print(str1+';', file=text_file)
    
    
    # str1 = 'param BV_BM := '
    # print(str1, file=text_file)
    # for i_, j_ in self.vessel.info['tankGroup'].items():
    #     str1 = '['+ str(i_) + ',*] = '
    #     for k_, v_ in self.bm_base_value.items():
    #         str1 += str(k_) + ' ' + str(round(v_[int(i_)-1],5)) + ' '
    #     print(str1, file=text_file)
    # print(';', file=text_file)
    
    # str1 = 'param CD_BM := '
    # print(str1, file=text_file)
    # for i_, j_ in self.vessel.info['tankGroup'].items():
    #     str1 = '['+ str(i_) + ',*] = '
    #     for k_, v_ in self.bm_draft_corr.items():
    #         str1 += str(k_) + ' ' + str(round(v_[int(i_)-1],5)) + ' '
    #     print(str1, file=text_file)
    # print(';', file=text_file)
    
    
    minCargoAmt = 1000
    minBallastAmt = 200
    
    ## decision variables --------------------------------------------------
    
    x = {}
    w = {}
    qw2f = {}
    # TMom TB 
    T_tmom = {}
    for i in range(len(C)):
        x[C[i]] = {}
        w[C[i]] = {}
        qw2f[C[i]] = {}
        T_tmom[C[i]] = {}
        for j in range(len(T)):
            # 1 if cargo c is allocated into tank t for capacity
            x[C[i]][T[j]] = solver.IntVar(0, 1, 'x[%s][%s]' % (C[i], T[j])) 
            w[C[i]][T[j]] = {}
            qw2f[C[i]][T[j]] =  {}
            T_tmom[C[i]][T[j]] = {}
            for k in range(len(P)):
                # weight of cargo (w.r.t. low density) planned to be serviced from/to tank t at port p. 
                # positive -> load; zero -> no action; negative -> unload.
                w[C[i]][T[j]][P[k]] = solver.NumVar(-infinity, infinity, 'w[%s][%s][%d]' % (C[i], T[j], P[k]))
                T_tmom[C[i]][T[j]][P[k]] = solver.NumVar(-infinity, infinity, 'T_tmom[%s][%s][%d]' % (C[i], T[j], P[k]))
            for k in range(len(Pbar)):
                qw2f[C[i]][T[j]][Pbar[k]] = solver.IntVar(0, infinity, 'qw2f[%s][%s][%d]' % (C[i], T[j], Pbar[k]))

    
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
        for j in range(len(P)):
            xB[TB[i]][P[j]] = solver.IntVar(0, 1, 'xB[%s][%d]' % (TB[i], P[j]))
            wB[TB[i]][P[j]] = solver.NumVar(0, 10000, 'wB[%s][%d]' % (TB[i], P[j]))
            # yB[TB[i]][P[j]] = wB[TB[i]][P[j]] / densitySeaWater[P[j]]
            TB_tmom[TB[i]][P[j]] = solver.NumVar(-infinity, infinity, 'TB_tmom[%s][%d]' % (TB[i], P[j]))
            
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
            
    ## objective -----------------------------------------------------------
    Action_Amount = solver.Sum([priority[c]*(solver.Sum([qw2f[c][t][p]/10 for p in P_last_loading]) - 
                                              solver.Sum([w[c][t][p] for p in P_dis])) for c in C for t in Tc[c]]) - 1*solver.Sum([wB[t][p] for t in TB for p in P])
    solver.Maximize(Action_Amount)
    ## constraints ---------------------------------------------------------
    
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
                solver.Add(w[i][j][k]/densityCargo_Low[i] == x[i,j])
                # Condition 021  cargo c is not allocated to tank t if t is not compatible with cargo c
                solver.Add(qw2f[i][j][k]/10/densityCargo_Low[i] == x[i,j])
                
    # Condition 03 Condition 04
    for i in list(set(C)-set(C_loaded)-set(C_locked)):
        # total loaded >= total discharged
        solver.Add((solver.Sum([Q0.get(i,{}).get(j,0.) for j in Tc[i]]) + 
                    solver.Sum([w[i][j][k]/densityCargo_Low[i] for j in Tc[i] for k in P_load])) >= 
                    solver.Sum([-w[i][j][k]/densityCargo_Low[i] for j in Tc[i] for k in P_dis]))

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
                solver.Add(w[i][j][k] / densityCargo_Low[i] >= 0)
            
            
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

            solver.Add(-Vcp[i][j]-1e6*(1-delta[i][j]) <= solver.Sum([w[i][k][j] / densityCargo_Low[i] for k in Tc[i]]))

            solver.Add(-solver.Sum([w[i][k][j] / densityCargo_Low[i] for k in Tc[i]]) <= -Vcp[i][j]+1e6*(1-delta[i][j]))
            
            solver.Add(-1e6*(delta[i][j]) <= -solver.Sum([qw2f[i][k][j]/10/densityCargo_Low[i] for k in Tc[i]]))

            solver.Add(-solver.Sum([qw2f[i][k][j]/10/densityCargo_Low[i] for k in Tc[i]]) <= 1e6*(delta[i][j]))
    
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
                solver.Add(qw2f[i][j][k]/10/densityCargo_Low[i] + w[i][j][k+1]/densityCargo_Low[i] == qw2f[i][j][k+1]/10/densityCargo_Low[i])
         
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
                solver.Add(qw2f[i][j][k]/10/densityCargo_Low[i]*densityCargo_Low[i]/density_up[i] <= upperBoundC[i][j]*capacityCargoTank[j]*x[i][j])
        
    # commingled
    # Constr 5b
    for i1, i2 in zip(Cm_1,Cm_2):
        for j in T:
            for k in P_last_loading:
                solver.Add(qw2f[i1][j][k]/10/densityCargo_Low[i1]*densityCargo_Low[i1]/density_Cm[i1] + qw2f[i2][j][k]/10/densityCargo_Low[i2]*densityCargo_Low[i2]/density_Cm[i2] <= upperBound[j]*capacityCargoTank[j])
    # Constr 5c    
    # for i1, i2 in zip(Cm_1,Cm_2):
    #      solver.Add(solver.Sum([x[i1][j]*x[i2][j]  for j in Tm]) <= 1)
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
                solver.Add(x[i2][j]*Qm_2 - qw2f[i2][j][k]/10 <= Mm*(1-x[i1][j]))
                # Constr5d2
                solver.Add(qw2f[i2][j][k]/10 - x[i2][j]*(Qm_2+Mm) <= Mm*(1-x[i1][j]))
                # Constr5d3
                solver.Add(x[i1][j]*Qm_1 - qw2f[i1][j][k]/10 <= Mm*(1-x[i2][j]))
                # Constr5d4
                solver.Add(qw2f[i1][j][k]/10 - x[i1][j]*(Qm_1+Mm) <= Mm*(1-x[i2][j]))
        
    
    
    
    # Constr7a
    for i in list(set(C)-set(C_loaded)-set(C_locked)):
        for j in Tc[i]:
            for k in P_last_loading:
                # Constr7a DISABLE CURRENTLY
                # solver.Add(lowerBound[j]*capacityCargoTank[j]*x[i][j] <= qw2f[i][j][k]/10/densityCargo_Low[i]*densityCargo_Low[i]/density_low[i])
                pass
    
    
    # Constr8 
    for i in C:
        for j in Tc[i]:
            for k in P_last_loading:
                # Constr8
                solver.Add((qw2f[i][j][k]/1000 - 1e4*(x[i][j])) <= 0)
        
    # Constr11  # Constr12
    for i in TB:
        for j in P:
            solver.Add(wB[i][j]/densitySeaWater[j] <= upperBoundB1[i]*capacityBallastTank[i]*xB[i][j])
            solver.Add(lowerBoundB1[i]*capacityBallastTank[i]*xB[i][j] <= wB[i][j]/densitySeaWater[j])
            
    ## max num of tanks available
    # Constr12a1 12a2
    # solver.Add(solver.Sum([x[i][j] for i in C for j in T]) <= maxTankUsed) Constr12a
    for j in T:
        solver.Add(solver.Sum([x[i][j] for i in C]) <= 100*xt[j])
        
    solver.Add(solver.Sum([xt[j] for j in T]) <= maxTankUsed) 
        
    # load all  cargo 
    # Condition111
    
    # symmetric loading
    # Condition112a, 112b, 112c, 112d, 112e
    for i in C:
        for j in P_last_loading:
            solver.Add(qw2f[i]['1P'][j]/10 == qw2f[i]['1S'][j]/10)
            solver.Add(qw2f[i]['2P'][j]/10 == qw2f[i]['2S'][j]/10)
            solver.Add(qw2f[i]['3P'][j]/10 == qw2f[i]['3S'][j]/10)
            solver.Add(qw2f[i]['4P'][j]/10 == qw2f[i]['4S'][j]/10)
            solver.Add(qw2f[i]['5P'][j]/10 == qw2f[i]['5S'][j]/10)
            
            
    # diff cargos in slop tanks, except when only one cargo
    # Condition112f
    for i in C:
        solver.Add(x[i]['SLS'] + x[i]['SLP'] <= diffSlop)
        
    # Condition112b1 Condition112b2
    for i in C:
        for j in T:
            for k in P_last_loading:
                solver.Add(qw2f[i][j][k]/10 >= minCargoAmt*x[i][j])
                solver.Add(qw2f[i][j][k]/10 <= 1e5*x[i][j])
                
    # ballast requirement
    # Condition113d1 Condition113d2
    for j in TB:
        for k in P:
            solver.Add(wB[j][k] >= minBallastAmt*xB[j][k])
            solver.Add(wB[j][k] <= 1e4*xB[j][k])
    
    # initial ballast condition
    # Condition114a1, Condition114a2, Condition114a3
    for j in incTB:
        solver.Add(initBallast.get(j,0.) <= wB[j][1])
    for j in decTB:
        solver.Add(initBallast.get(j,0.) >= wB[j][1])
    # for j in TB:
    #     solver.Add(initBallast.get(j,0.) == wB[j][0])
    
        
        
        
        
   
        
    
    
    
    
    
    
#    print('print model:')
#    print(solver.ExportModelAsLpFormat(False).replace('\\', '').replace(',_', ','), sep='\n')
    

    ##------------------------------------------------------------------------------------------
    # Solve
    print('Number of variables = %d' % solver.NumVariables())
    print('Number of constraints = %d' % solver.NumConstraints())    
    status = solver.Solve()
    assert solver.VerifySolution(1e-5, True)
    if status in [0, 1]:
        print('Objective value =', solver.Objective().Value())
        print('Problem solved in %f milliseconds' % solver.wall_time())
        print('Problem solved in %d branch-and-bound nodes' % solver.nodes())
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
                'res': [(k, t, u, w, p) for k, v, in res.items() for t, x in v.items() for u, y in x.items() for w, p in y.items()],
                'shipStatus': [(k, t, u, w, p) for k, v, in shipStatus.items() for t, x in v.items() for u, y in x.items() for w, p in y.items()],
                'xx': [],
                'wtB': [],
                'cargoloadedport': [],
                'obj':[]}
    
                
                
