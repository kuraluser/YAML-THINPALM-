# ACA AMPL model # full model
# changelog upon aca_model_v2 (Aug 05, 2019)
# Added by CC
##-------------------------------------------------------------------------
# Changelog: 31 Jan 2021
# 1. Added ballast  parameters
# ballast requirement
# set ballastSet1;
# set ballastSet2;
# set ballastSet3;
# param minBallastAmt default 100;
# 2. Added ballast constraints
# Condition113a, Condition113b, Condition113c, Condition113d
# Condition114a, Condition114b
##-------------------------------------------------------------------------
# Changelog: 27 Jan 2021
# 1. Added Commingle parameters
# set Cm_1 within C; # cargo 1 commingle 
# set Cm_2 within C; # cargo 2 commingle 
# set Tm within T; # Suitable tank for commingle
# param density_Cm{c in C} default 1; # SG when commingle
# 2. Added Commingle Constraints
# Condition01a, Condition01b, Condition01c
# Constr5b, Constr5c
# Disable Constr7a will add back later
##-------------------------------------------------------------------------
# Changelog: 15 Jan 2021
#1. Added Draft parameters
# param Mean_draft{p in P} default 0;
# param Base_draft{p in P} default 0;
#  param mDraft1,..., mDraft10 ;
#  param bDraft1, ...,bDraft10;
#2. Added New SF and BM parameters
# param Fr >= 0 integer, default 1; #frame
# set Frames := 0..Fr;
# # weight ratio
# param weightRatio_ct {f in Frames, t in T} default 0;
# param weightRatio_bt {f in Frames, t in TB} default 0;
# param weightRatio_ot {f in Frames, t in OtherTanks} default 0;
# # LCG
# param LCG_ct {f in Frames, t in T} default 0;
# param LCG_bt {f in Frames, t in TB} default 0;
# param LCG_ot {f in Frames, t in OtherTanks} default 0;
# param LCG_fr {f in Frames} default 0;
# # Sn
# param lowerSFlimit{f in Frames} default -100000;
# param upperSFlimit{f in Frames} default 100000;
# param BV_SF {f in 1..Fr, p in P} default 0;
# param CD_SF {f in 1..Fr, p in P} default 0;
# # Bn
# param lowerBMlimit{f in Frames} default -100000;
# param upperBMlimit{f in Frames} default 100000;
# param BV_BM {f in 1..Fr, p in P} default 0;
# param CD_BM {f in 1..Fr, p in P} default 0;

#3. Added New SF and BM Constraints
# Constr17a 
# Constr18a to Constr18c Constr18d 
# Constr19a  to Constr19c 
# Condition20a to Condition20b 
# Condition21a to Condition21b

#4. Modified Objective Function to maximize the amout of loaded cargoes in terms of total loaded amount & minimize the ballast amount & minimize the number of cargo tanks to be used.
# Revised version:minus the weighted (10000 to 15000)*sum{t in T, c in C} x[c,t]; (that minimize total number of cargo tanks) in the Objective Function
# Removed the previous Minus sum of zTank, not required now.
# Removed the previous Constr22c, not required now.
 
##-------------------------------------------------------------------------
# Changelog: 10 Jan 2021
# Incorporated to PengHui's program model  model_1c.mod (also renamed as model_1c_CC20210110.mod);

##-------------------------------------------------------------------------
# Changelog: 24 Dec 2020
#1. Added new variables/parameters:
# param MBallast default 10000; #MBallast is an arbitrary number much larger (10 times) than the largest value of wB
# var zBallast{P} binary default 0; # to be optimised to either 0 or 1 for each port P by the program as follows:
# zBallast=0, Ballast tanks can be both filled and discharged at each loading and discharging port.
# zBallast=1, Ballast tanks can only be filled at each discharging port. Ballast tanks can only be discharged) loading port.

#2. Modify new ballast constraints at loading ports and discharging ports
#Constr22a
#Constr22b

#3. Renamed # param gamma (Constr15c7 to Constr15c10) and replaced with ListMOM as in original version.
#4. Updated new trim constraints, now in terms of 10-piece-wise linear approximation for each of the LCB.

##-------------------------------------------------------------------------
# Changelog: 8 Dec 2020
#1. Added new variables/parameters:
# param gamma default 0.01;
#For Constr22c:
#var zTank{T} binary; # 1 if cargo tank t is used/filled by any cargo type;
#For Constr15:
#var Vertical_moment{p in P} default 0; 
#var Final_list_moment{p in P} default 0;  
#param dterms{p in P} default 1; 

#2. Modified Objective Function to maximize the amout of loaded cargoes in terms of total loaded amount & minimize the ballast amount & minimize the number of cargo tanks to be used.
# Added the Minus sum of zTank (that minimize total number of cargo tanks) in the Objective Function

#3. i) Derived and added new List constraints: Constr15c1 to Constr15c10 associated with gamma
#   ii) Remarked previous List constraints: Constr15a3,  Constr15a4 associated with ListMOM

##-------------------------------------------------------------------------
# Changelog: 30 Nov 2020
#1. Removed irrelevant sets/parameters/functions
#2. Added new list constraints using 10-piece linear functions
#3. Removed McCormick envelope method
#Constr15b1
#Constr15b2 
#Constr15
#Constr151 
#4. Added new ballast constraints at loading ports and discharging ports
#Constr22a
#Constr22b
#5.  Renamed  sets/parameters
#6.  Modified objective function: Removed sum of zBt (that minimize number of ballast tanks) from the objective function



## basic: set and params -----------------------------------------------------------
set T; # set of all cargo tanks
set T1; # set of cargos tanks without pw tcg details
set T_loaded within T; # set of loaded tanks (preloaded condition)

set C; # set of all cargoes
set C_loaded within C; # set of all loaded cargoes preloaded condition)
set C_max;
set C_equal default C;

param I_loaded{c in C_loaded, t in T_loaded} binary default 0; # 1 if cargo c has been loaded in tank t ((preloaded condition)

## compatibility: set and params
set Tc{c in C} within T default T; # set of tanks compatible with cargo c (consider tank coating, cargo history, tank heating);
#check {c in C_loaded}: sum{t in T_loaded diff Tc[c]}I[c,t] = 0; # check cargo-tank compatibility in existing allocation.
set Ct{t in T} default C; # set of cargoes compatible with tank t (consider tank coating, cargo history, tank heating);

set Cbarc{c in C}; # set of cargoes in conflict with cargo c (consider USCG list);

## ballast-cargo tank compatibility: set and params

## capacity: set and params
param NP >= 0 integer; # total number of ports in the booking list
param LP >=0, <= NP integer; # the last loading port


set P := 1 .. NP; # set of ports
set P_org := {0}; # a virtual port before the first port
set Pbar := P_org union P;
set P_load := 1 .. LP ; # set of loading ports
set P_dis := LP+1 .. NP ; # set of discharging ports
set P_last_loading := {LP} ; # the last loading port

param firstloadingPort default 1;

param densityCargo_Low{c in C} >=0 default 1; # cargo density @ high temperature (in t/m3)
param densityCargo_High{c in C} >=0 default 1; # cargo density @ low temperature (in t/m3)
#param highDensityOn default 1; # change highDensityOn to a large number to deactivate high density check

param density_up{c in C} default densityCargo_Low[c]; # density used for the upper loading bound
param density_low{c in C} default densityCargo_High[c]; # density used for the lower loading bound
param upperHighDensity{c in C, t in T} default 1; # upper filling limit for high density cargo, (0,1)

param aveCargoDensity default 1;

# cargo priority
param priority{c in C} >0 default 100; # cargo with higher priority will be loaded as close to the intended quantity as possible
# priority 1 and 2 cargo
set cargoPriority within {C,C};

# tank priority
param priorityTank{c in C, t in T}  default 1; 

param Wcp{c in C, p in P} default 0; # weight (in metric tone) of cargo to be moved at port p. positive -> to be loaded; negative -> to be discharged; zero -> no action is required.
param Vcp{c in C, p in P} = Wcp[c,p]/densityCargo_Low[c]; # volume (in t/m3) to be moved at port p based on low density.

param W0{c in C, t in T} >=0 default 0; # weight of cargo c remained in tank t at initial state (before ship entering the first port)
param Q0{c in C, t in T} = W0[c,t]/densityCargo_Low[c]; # volume of cargo c remained in tank t at initial state
check {c in C_loaded, t in T_loaded diff Tc[c]}: Q0[c,t]=I_loaded[c,t]; # check cargo-tank compatibility in existing allocation.

param W_loaded{C_loaded,T_loaded,P} default 0; # the weight of preloaded cargo to be moved from tank t at port p
param V_loaded{c in C_loaded, t in T_loaded, p in P} = W_loaded[c,t,p]/densityCargo_Low[c]; # the volume of preloaded cargo to be moved from tank t at port p

# loading ports
set loadPort;
param loadingPortAmt{p in loadPort} default 0;
param deballastPercent default 0.4;

## ballast tanks
set TB; #set of ballast tanks
set TB1; # set of ballast tanks with no pw tcg details
set TB2; # set of ballast tanks with no pw lcg details

param densitySeaWater{p in Pbar} default 1.025; # density of water @ high temperature
param densityBallast{p in Pbar} default 1.025; # density of water @ high temperature


# locked ballast
param B_locked{TB,Pbar} default 0;
set fixBallastPort; 
set P_stable = 1 .. (NP-1) diff fixBallastPort; # stable port


param capacityCargoTank{t in T} >= 0; # cargo tank capacity (in m3)
param densityCargoTank{t in T} >= 0 default 1.0; # cargo tank density (in t/m3)
param onboard{t in T} >=0 default 0; # onboard qty

## parameters for capacity rules
param upperBound{t in T} default 0.980; #upper loading bound for each tank: 0.98 for tank capacity more than 0.5 km^3, and 1 for the other cargo tanks.
param lowerBound{t in T} default 0.6; #lower loading bound for each tank, e.g. 0.6
param upperBoundC{ c in C, t in T} default upperBound[t]; 
#check {c in C_loaded, t in Tc[c] inter T_loaded}: Q0[c,t] <= upperBound[t]*gt[t]*I[c,t]; # amount of cargo preloaded <= capacity of the tank.

## locked tank, locked allocation plan.
set T_locked within T;
set C_locked within C;
param A_locked{C_locked,T_locked} binary default 0; # 1 if tank t is locked for cargo c
#check {c in C_locked}: sum{t in T_locked diff Tc[c]}A_locked[c,t] = 0; # check cargo-tank compatibility in locked allocation.
#check {c in C_locked, t in T_locked inter Tc[c]}: sum{k in C_locked inter Cbarc[c], u in T_locked inter Tadj[t]}(A_locked[k,u])-M[t]*(1-A_locked[c,t]) <= 0; # check cargo-cargo compatibility in locked allocation.

param W_locked{C_locked,T_locked,P} default 0; # the amount of cargo locked to put/unload into/from tank t at port p
param V_locked{c in C_locked, t in T_locked, p in P} = W_locked[c,t,p]/densityCargo_Low[c];
#check {c in C_locked, t in T_locked diff Tc[c],p in P_load}: W_locked[c,t,p]=A_locked[c,t]; # check cargo-tank compatibility in locked allocation.
#check {c in C_locked, p in P_load}:  0 <= sum{t in Tc[c] inter T_locked} V_locked[c,t,p] <= Vcp[c,p]; # amount of cargo to be loaded <= amount available at the port.
#check {c in C_locked, t in Tc[c] inter T_locked, p in P_load}: V_locked[c,t,p] <= upperBound[t]*gt[t]*A_locked[c,t]; # amount of cargo pre-allocated <= capacity of the tank.

## other tanks
set OtherTanks; # set of other tanks, e.g. fuel tanks, water tanks,
param  weightOtherTank{t in OtherTanks, p in P} default 0; # weight of each tank

param maxTankUsed default 100;
param intended default 1e6; 


#set CargoSolid; # solidifying cargo

param capacityBallastTank{t in TB}; # capacity of each ballast tank
param upperBoundB1{t in TB} default 0.99; #upper loading bound for each ballast tank
param lowerBoundB1{t in TB} default 0; #lower loading bound for each ballast tank
param initBallast {t in TB} default 0; # initial ballast
param finalBallast {t in TB} default 0; # final ballast
set incTB;  # TB to inc
set decTB;  # TB to dec 
#set finalBallastPort;
set lastLoadingPortBallastBan;

param minCargoLoad{c in C} default 0;
param toLoad{c in C} default 0;
param diffSlop default 1;

## commingled cargo
set Cm_1 within C;
set Cm_2 within C;
set Tm within T;
param density_Cm{c in C} default 1;
param Qm_1 default 0; # manual fix cargo1 wt
param Qm_2 default 0; # manual fix cargo2 wt
param Mm default 1e5;

## ballast requirement
set loadingPort within 1..NP cross 1..NP; # loading port
set loadingPortNotLast within 1..NP cross 1..NP; # loading port except last

set depArrPort1 within 1..NP cross 1..NP; # with ROB
set depArrPort2 within 1..NP cross 1..NP; # no ROB
set rotatingPort1 within 0..NP cross 0..NP; 
set rotatingPort2 within 0..NP cross 0..NP; 
set specialBallastPort default {LP-1, LP}; # default LP-1
set zeroBallastPort default {}; # default LP

param minBallastAmt{t in TB} default 10;
param minCargoAmt default 1000;

## cargo tank
set cargoTankNonSym within T cross T; # non-sym cargo tanks
set symmetricVolTank within T cross T default  {('1P','1S'), ('2P','2S'),('SLS','SLP'), ('3P','3S'), ('4P','4S'), ('5P','5S')};


## stability: set and params
set AllTanks = T union OtherTanks union TB; # set of all tanks
param lightWeight; # lightweight of the ship
param deadweightConst default 0; # deadweight constant

param deadweight > 0 default 1e6; # deadweight
param cargoweight > 0 default 1e6;
set firstDisCargo;


param diffVol default 0.1;

# stability - draft
param displacementLimit{p in P}; # displacement limit derived from maximum permissible draft and hydrostatic table.
param displacementLowLimit{p in P} default 0; # displacement limit lower bound

# stability - list
#param upListMOM; # upperbound on the tranversal moment
#param lowListMOM; # lowerbound on the tranversal moment
param TCGt{t in AllTanks} default 0; #tank TCG
param TCGtp{t in OtherTanks, p in P} default 0;
param ListMOM default 500; # upper and lower limits of tcg mom
param TCGdw default 0; # TCG deadweight constant

param pwTCG default 0;
param mTankTCG{p in 1..pwTCG,   t in T union TB} default 0; # need update input based on tcg details
param bTankTCG{p in 1..pwTCG-1, t in T union TB} default 0; # need update input based on tcg details

# stability - trim
param LCGt{t in AllTanks}; #tank LCG
param LCGship;
param LCGdw default 0;
param LCGtp{t in OtherTanks, p in P} default 0;

#param TrimMOM default 1;
param trim_upper{p in P} default 0.0001;
param trim_lower{p in P} default -0.0001;

param pwLCG default 0;
param mTankLCG{p in 1..pwLCG,   t in T union TB} default 0; # need update input based on tcg details
param bTankLCG{p in 1..pwLCG-1, t in T union TB} default 0; # need update input based on tcg details


param pwLCB default 0;
param mLCB{p in 1..pwLCB} default 0;
param bLCB{p in 1..pwLCB-1}  default 0;

param pwMTC default 0;
param mMTC{p in 1..pwMTC} default 0;
param bMTC{p in 1..pwMTC-1}  default 0;



# stability - Draft 
param base_draft{p in P} default 0;

param pwDraft default 0;
param mDraft{p in 1..pwDraft} default 0;
param bDraft{p in 1..pwDraft-1}  default 0;


param disp0 default 123177.0;
# stability - SF and BM
param adjMeanDraft default 0.166895;
param adjLCB default -13665.8;
param adjMTC default 2239.64;

param Fr >= 0 integer, default 1; #frame
set Frames := 0..Fr;
# weight ratio
param weightRatio_ct {f in Frames, t in T} default 0;
param weightRatio_bt {f in Frames, t in TB} default 0;
param weightRatio_ot {f in Frames, t in OtherTanks} default 0;
# LCG
param LCG_ct {f in Frames, t in T} default 0;
param LCG_bt {f in Frames, t in TB} default 0;
param LCG_ot {f in Frames, t in OtherTanks} default 0;
param LCG_fr {f in Frames} default 0;
# Sn
param lowerSFlimit{f in Frames} default -100000;
param upperSFlimit{f in Frames} default 100000;

param BV_SF {f in 1..Fr, p in P} default 0;
param CD_SF {f in 1..Fr, p in P} default 0;
param CT_SF {f in 1..Fr, p in P} default 0;

# Bn
param lowerBMlimit{f in Frames} default -100000;
param upperBMlimit{f in Frames} default 100000;

param BV_BM {f in 1..Fr, p in P} default 0;
param CD_BM {f in 1..Fr, p in P} default 0;
param CT_BM {f in 1..Fr, p in P} default 0;

param numSolutions integer default 3;
param runtimeLimit integer default 30;
param seed integer default 0;

param tolerance := 0; # tolerance for rounding
param IIS integer default 1;

### Decision Variables ###
# for compatibility
var x{C,T} binary; # 1 if cargo c is allocated into tank t
var xt{T} binary;
# for capacity
var w{C,T,P}; # weight of cargo (w.r.t. low density) planned to be serviced from/to tank t at port p. positive -> load; zero -> no action; negative -> unload.
var y{c in C,t in T,p in P} = w[c,t,p]/densityCargo_Low[c]; # volume of cargo (w.r.t. low density) planned to be serviced from/to tank t at port p. positive -> load; zero -> no action; negative -> unload.

var qw2f{C,T,Pbar} >=0 integer; # weight of cargo remained in tank t after visiting port p.
var qw{c in C,t in T,p in Pbar} = qw2f[c,t,p]/10;
var qty{c in C,t in T,p in Pbar} = qw[c,t,p]/densityCargo_Low[c]; # volume of cargo remained in tank t after visiting port p.

var xwB{TB,Pbar} binary; # 1 if ballast tank t is filled with water at port p
var xB{TB,Pbar} binary; # 1 if ballast tank t is filled with water at port p
var wB{TB,Pbar}  >= 0; # weight of water in ballast tank t at port p
var zBa1{TB} binary;
var zBb1{TB} binary;
var zBa2{TB} binary;
var zBb2{TB} binary;


var yB{t in TB,p in P} = wB[t,p]/densityBallast[p]; # volume of water (w.r.t. low density) planned to be added into ballast tank t at port p

var TB_tmom{t in TB, p in P} default 0; # TMom TB
var TB_lmom{t in TB, p in P} default 0; # TMom TB
var T_tmom{t in T, p in P} default 0; # TMom T
var T_mom{p in P} default 0; # TCG Mom
var L_mom{p in P} default 0; # LCG Mom
var LCBp {p in P} default 0; 
var MTCp {p in P} default 0; 
# extra amout (w.r.t. metric tone) of cargo c that the tank can take in
#var extraWeight{c in C, t in T} = x[c,t]*min((upperBound[t]*capacityCargoTank[t]-sum{p in P_last_loading}q[c,t,p]*densityCargo_Low[c]/density_up[c])*density_up[c],(min(1,highDensityOn*densityCargoTank[t]/densityCargo_High[c])*capacityCargoTank[t]-sum{p in P_last_loading}q[c,t,p]*densityCargo_Low[c]/densityCargo_High[c])*densityCargo_High[c]); 

var delta{c in C diff C_loaded diff C_locked, p in P_dis} binary;

# BM and SF
var displacement{p in P} >=0; # displacement
var displacement1{p in P} >=0; # displacement corrected for seawater density
var mean_draft{p in P} default 0;
var wn{f in Frames, p in P} >= 0;
var mn{f in Frames, p in P};
var wC{t in T, p in P} >= 0;
var SS{f in Frames, p in P} default 0;
var SB{f in Frames, p in P} default 0;
var est_trim{p in P}default 0;



## objective function
#####################
# to maximize the amout of loaded cargoes in terms of total loaded amount + minimize the ballast amount.
maximize Action_Amount:
sum{c in C, t in Tc[c]} priority[c]*(sum{p in P_last_loading} qw[c,t,p]- sum{p in P_dis} w[c,t,p])-1*sum{t in TB, p in P}wB[t,p];

#####################
#original
# to maximize the amout of loaded cargoes in terms of total loaded amount + minimize the ballast usage.
# maximize Action_Amount:
#sum{c in C, t in Tc[c]} priority[c]*(sum{p in P_last_loading} qw[c,t,p]- sum{p in P_dis} w[c,t,p])-1*sum{t in TB, p in P}wB[t,p]-100*sum{t in TB}zB[t];
##sum{c in C, t in Tc[c]} priority[c]*(sum{p in P_last_loading} qw[c,t,p]- sum{p in P_dis} w[c,t,p])+sum{c in C, t in Tc[c], p in P} priorityTank[c,t]*q[c,t,p]/gt[t]-1*sum{t in TB, p in P}wB[t,p]-100*sum{t in TB}zB[t];

### Constraints ###
## basic conditions
subject to Condition0 {c in C diff C_loaded diff C_locked}: sum{t in T diff Tc[c]}x[c,t] = 0; # cargo c is not allocated to tank t if t is not compatible with cargo c
subject to Condition01 {t in T diff Tm}: sum{k in C}x[k,t] <= 1; # one tank can only take in one cargo
# commingled cargo
subject to Condition01a {t in Tm}: sum{k in C diff Cm_1} x[k,t] <= 1; # one tank can only take in one cargo
subject to Condition01b {t in Tm}: sum{k in C diff Cm_2} x[k,t] <= 1; # one tank can only take in one cargo
subject to Condition01c {t in Tm, k1 in Cm_1, k2 in Cm_2}:  x[k1,t] + x[k2,t] <= 2; # one tank can only take in two cargo


subject to Condition01z {c in C diff C_loaded diff C_locked, p in P_last_loading}: sum{t in Tc[c]} qw[c,t,p] >= minCargoLoad[c]; # a cargo is loaded to at min amt at last loading port

subject to Condition020 {c in C, t in T diff Tc[c], p in P}: y[c,t,p] = x[c,t]; # cargo c is not allocated to tank t if t is not compatible with cargo c
subject to Condition021 {c in C, t in T diff Tc[c], p in P}: qty[c,t,p] = x[c,t]; # cargo c is not allocated to tank t if t is not compatible with cargo c
subject to Condition03 {c in C diff C_loaded diff C_locked}: sum{t in Tc[c]} Q0[c,t] + sum{p in P_load, t in Tc[c]} y[c,t,p] >= sum{p in P_dis, t in Tc[c]} -y[c,t,p]; # total loaded >= total discharged

subject to Condition04 {c in C diff C_loaded diff C_locked, p in P_load : Vcp[c,p]>0}:  0 <= sum{t in Tc[c]} y[c,t,p] <= Vcp[c,p]; # amount of cargo to be loaded <= amount available at the port.
subject to Condition041 {c in C, t in Tc[c], p in P_load}: y[c,t,p]>=0;

subject to Condition05 {c in C diff C_loaded diff C_locked, p in P_dis : Vcp[c,p]<0}:  0 >= sum{t in Tc[c]} y[c,t,p] >= Vcp[c,p]; # amount of cargo to be discharged is not more than the amount needed at the port.
subject to Condition050 {c in C diff C_loaded diff C_locked, p in P_dis : Vcp[c,p]<0}:  sum{t in Tc[c]}qty[c,t,p-1]>=-Vcp[c,p]-1e6*(1-delta[c,p]);

subject to Condition050a {c in C diff C_loaded diff C_locked, p in P_dis : Vcp[c,p]<0}:  sum{t in Tc[c]}qty[c,t,p-1]<=-Vcp[c,p]+1e6*delta[c,p];
subject to Condition050b {c in C diff C_loaded diff C_locked, p in P_dis : Vcp[c,p]<0}:  -Vcp[c,p]-1e6*(1-delta[c,p])<=-sum{t in Tc[c]} y[c,t,p];
subject to Condition050b1 {c in C diff C_loaded diff C_locked, p in P_dis : Vcp[c,p]<0}:  -sum{t in Tc[c]} y[c,t,p]<=-Vcp[c,p]+1e6*(1-delta[c,p]);
subject to Condition050c {c in C diff C_loaded diff C_locked, p in P_dis : Vcp[c,p]<0}:  -1e6*(delta[c,p])<=-sum{t in Tc[c]} qty[c,t,p];
subject to Condition050c1 {c in C diff C_loaded diff C_locked, p in P_dis : Vcp[c,p]<0}:  -sum{t in Tc[c]} qty[c,t,p]<=1e6*(delta[c,p]);

subject to Condition051 {c in C, t in Tc[c], p in P_dis}: y[c,t,p]<=0;
subject to Condition052 {c in C diff C_loaded diff C_locked, t in Tc[c], p in P : Vcp[c,p]==0}: y[c,t,p]=0;

subject to Condition06 {c in C, t in Tc[c], p in Pbar diff {NP} }: qty[c,t,p] + y[c,t,p+1] = qty[c,t,p+1]; # amount of cargo c left in tank when leaving port p for port p+1 is equal to the amount of cargo c moved from/to tank t at port p.

## preloaded condition
subject to condition22 {c in C_loaded, t in T_loaded}: x[c,t] = I_loaded[c,t]; # follow the existing stowage of preloaded cargoes
subject to condition23 {c in C_loaded, t in T diff T_loaded}: x[c,t] = 0; # preloaded cargo can only be loaded to its corresponding preloaded tanks.
subject to condition23a {c in C_loaded, t in T diff T_loaded, p in P}: y[c,t,p]=x[c,t]; # preloaded cargo can only be loaded to its corresponding preloaded tanks.
subject to condition23b {c in C_loaded, t in T diff T_loaded, p in P}: qty[c,t,p]=x[c,t]; # preloaded cargo can only be loaded to its corresponding preloaded tanks.

subject to condition24 {c in C, t in T}: qty[c,t,0] = Q0[c,t]; # follow the existing stowage of preloaded cargoes
subject to condition24a {c in C_loaded, t in T_loaded, p in P}: y[c,t,p] = V_loaded[c,t,p]; # follow the existing stowage of preloaded cargoes

## locked tank / pre-allocated condition
subject to condition25 {c in C_locked, t in T_locked}: x[c,t] = A_locked[c,t]; # follow the existing stowage of locked cargoes
subject to condition26 {c in C_locked, t in T diff T_locked}: x[c,t] = 0; # locked cargo can only be loaded to its corresponding locked tanks.
subject to condition26a {c in C_locked, t in T diff T_locked, p in P}: y[c,t,p]=x[c,t]; # locked cargo can only be loaded to its corresponding locked tanks.
subject to condition26b {c in C_locked, t in T diff T_locked, p in P}: qty[c,t,p]=x[c,t]; # locked cargo can only be loaded to its corresponding locked tanks.

subject to condition27 {c in C_locked, t in T_locked, p in P}: y[c,t,p] = V_locked[c,t,p]; # follow the existing stowage of locked cargoes


## capacity constraint 98% rule
subject to Constr5a {c in C diff C_loaded diff C_locked, t in Tc[c], p in P_last_loading}: qty[c,t,p] <= upperBoundC[c,t]*capacityCargoTank[t]*x[c,t];
# commingled
subject to Constr5b {k1 in Cm_1, k2 in Cm_2, t in T, p in P_last_loading}: qty[k1,t,p]*densityCargo_Low[k1]/density_Cm[k1] + qty[k2,t,p]*densityCargo_Low[k2]/density_Cm[k2] <= upperBound[t]*capacityCargoTank[t];
#subject to Constr5a {c in C diff C_loaded diff C_locked, t in Tc[c], p in P_last_loading}: q[c,t,p]*dcLow[c]/density_up[c] + tolerance*x[c,t]/density_up[c] <= upperBound[t]*gt[t]*x[c,t];
subject to Constr5c {k1 in Cm_1, k2 in Cm_2}:sum{t in Tm} x[k1,t]*x[k2,t] <= 1; # limit commingle tank to 1

