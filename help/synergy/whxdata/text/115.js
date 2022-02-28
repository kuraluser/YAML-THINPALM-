rh._.exports({"0":[[" ","Loadable Plan"]],"2":[[" ","A loadable plan is an output generated from the loadable study. Once the user generates multiple loadable patterns for a loadable study and selects one option based on the ranking, loading order, and the quantity achievable, the user can proceed to the loadable plan. "," ","The user can select and confirm a Loadable plan only for the loadable study for which the status is ","Plan Generated",". "," ","To view the loadable plan for a loadable study, from the ","Loadable Study"," page, click ","View Pattern",". "," ","The ","Loadable Pattern ","page corresponding to the selected loadable study appears."," ","The loadable pattern page displays all the loadable patterns generated against the selected loadable study. Click ","View Plan"," to review each plan and select the optimal loadable plan that meets all the cargo allocation requirements in the best way possible. "," ","The ","Loadable Plan ","page appears."," ","The loadable plan is the stowage plan generated before the loading operation and displays the loadable quantity, cargo allocation, and arrival and departure condition details. All these details are explained in three sections:"," ","Loadable quantity"," ","Stowage pattern"," ","Arrival and Departure condition at each port"],[" ","The loadable quantity section populates the maximum quantity of cargo that can be loaded at each loading port during the voyage."," ","The application auto-calculates the loadable quantity value considering the following factors:"," ","The onboard quantities at each port should not exceed the deadweight."," ","The feasibility of cargo allocation in the tanks."," ","The tolerance limit."," ","Volume maximization."," ","Reduce the loading and discharging time."," ","Usage of the minimal number of tanks for loading operations."," ","To load new cargoes in the empty tanks when required. "," ","The Loadable Quantity section on the Loadable Plan page displays the following details:"," ","Field"," ","Description"," ","Grade "," ","Displays the name of the cargo selected in the loadable study."," ","Estimated API"," ","Displays the estimated value of the API used for the calculation of loadable study. "," ","Estimated Temp"," ","Displays the estimated value of temperature used for the calculation of loadable study."," ","Order Quantity"," ","Displays the actual volume of each cargo based on the enquiry received against the voyage.","\n            The Order Quantity of each cargo is displayed in both BBLS and MT units. "," ","Tolerance"," ","Displays the minimum and maximum tolerance value of each cargo. "," ","Loadable Quantity"," ","Displays the volume or weight of each cargo that is feasible with the selected loadable pattern. "," ","The Loadable Quantity is displayed in multiple units, including BBLS, MT, KL, and LT."," ","% Diff"," ","Displays the percentage difference between the order quantity and the loadable quantity. "," ","The % Diff value can be either positive or negative. "," ","The details of the commingled cargoes appears under the ","Loadable Quantity ","section if any."," ","The ","Commingle Cargo Details ","section displays the following details:"," ","Field"," ","Description"," ","Grade "," ","Displays the name of the commingled cargo selected in the loadable study."," ","Tank"," ","Displays the tank allocation of commingled cargoes."," ","Quantity"," ","Displays the volume or weight of the commingled cargoes loaded in the respective tank. "," ","API"," ","Displays the API of commingled cargoes."," ","Temp"," ","Displays the temperature of commingled cargoes."," ","Composition Breakdown"," ","Displays the commingled cargo breakdown into different grades, percentage of commingle, and units. "," ","The commingled cargo quantity is displayed in the following units:"," ","BBLS at observed temperature"," ","BBLS at 60F"," ","LT"," ","MT"," ","KL"],[" ","The stowage pattern section displays the cargo and ballast allocation details. "," ","The CP-DSS application displays the cargo allocation details of the selected loadable study by default. To view the ballast allocation details, click ","Ballast",". "," ","The stowage layout of cargo and ballast tanks displays the following details of each cargo when the user mouse hovers the respective tank name."," ","Field"," ","Description"," ","Tank Name"," ","Displays the name of the selected tank."," ","Cargo ABV"," ","Displays the cargo allocated in the selected tank as per the loadable plan. Different cargoes in the tanks are represented with unique colors. "," ","Volume"," ","Displays the calculated volume of cargo that can be loaded in each tank as per the loadable plan. "," ","Weight"," ","Displays the expected weight of the cargo in each tank as per the selected loadable plan."," ","Ullage"," ","Displays the ullage level in each tank. This value is calculated based on the volume of cargo in each tank."," ","Filling percentage"," ","Displays the percentage of filling in each tank. "," ","Click ","More ","to view more details on the stowage plan. "," ","The stowage details mapped against the selected loadable study appears in a table format. The stowage data is fetched from the Loadicator."," ","The stowage data table displays the quantity and volume of each cargo is in different units."," ","The stowage data table displays the following tank allocation details based on the selected loadable plan:"," ","Field"," ","Description"," ","Tank Name"," ","Displays the name of the tanks in the vessel."," ","Cargo Abbreviation"," ","Displays the abbreviation of the cargoes loaded in the tanks."," ","Ullage"," ","Displays the observed ullage value updated by the user. The ullage value is displayed in centimeters. "," ","Correction Factor"," ","Displays the correction factor value. The data is updated from the Loadicator. "," ","Corrected Ullage"," ","Displays the corrected ullage value based on the correction factor."," ","Observed Volume"," ","Displays the quantity of cargo at observed temperature. The value is updated from the Loadicator. "," ","Weight"," ","Displays the weight of cargo in each tank. The default unit is MT."," ","Percentage Filling"," ","Displays the percentage of filling in each tank."," ","API"," ","Displays the API of the cargo loaded in each tank."," ","Temperature"," ","Displays the temperature of cargo loaded in each tank. "," ","Click ","Hide ","to hide the stowage data."," ","Click ","Edit Stowage"," to edit the stowage data."," ","The ","RDG Ullage"," field becomes editable."," ","Edit the RDG Ullage value against the required tanks. The other stowage values are auto-updated based on the RDG Ullage value. "," ","The RDG Ullage value for each tank must be positive. The updated total cargo quantity must stay within the tolerance limit and must not exceed the loadable quantity calculated in the respective loadable study."," ","Click"," Validate and Save ","to update the changes. "," ","A success message appears on the screen indicating that the ullage value is updated successfully. "," ","The Loadicator validates the new loadable plan for stability parameters. The CP-DSS application saves the updated loadable plan only if the plan satisfies all the stability parameters. "],[" ","The ","ETA/ETD Condition at Each Port ","section displays the arrival and departure data of the vessel at each port in a table format. "," ","The arrival and departure data is updated from the ","Synoptical Table",". The table displays the following ETA/ETD values of the vessel. "," ","Field"," ","Description"," ","Port Name"," ","Displays the names of the ports selected in the respective loadable study. "," ","ETA/ETD Date"," ","Displays the estimated date of arrival and departure of the vessel at each port. "," ","ETA/ETD Time"," ","Displays the estimated time of arrival and departure of the vessel at each port."," ","Draft"," ","Displays the Fore Draft, After Draft, and Mid Ship Draft values of the vessel at each port. The draft values are updated from the Loadicator. "," ","Trim"," ","Displays the trim condition of the vessel at each port. The trim values are updated from the Loadicator. "," ","Bending Moment"," ","Displays the bending moment of the vessel at each port. The data is updated from the Loadicator. "," ","Shearing Force"," ","Displays the shearing force on the vessel at each port. The data is updated from the Loadicator. "," ","List"," ","Displays the list condition of the vessel at each port. The data is updated from the Loadicator. "," ","Cargo MT"," ","Displays the cargo on board at each port during the arrival and departure. "," ","Fuel Oil"," ","Displays the amount of fuel oil on board at each port during the arrival and departure. "," ","Diesel Oil"," ","Displays the amount of diesel oil on board at each port during the arrival and departure. "," ","Ballast"," ","Displays the quantity of water ballast on board at each port during the arrival and departure. "," ","Fresh Water"," ","Displays the amount of fresh water on board at each port during the arrival and departure. "," ","Others"," ","Displays the number of other residues on board at each port during arrival and departure. "," ","Total DWT"," ","Displays the total weight the vessel can carry."," ","Displacement"," ","Displays the total weight of the vessel."," ","SP Gravity"," ","Displays the specific gravity of seawater at each port. The default value is 1.025."],[" ","The user can change the loadable plan by updating the ullage value in the stowage section. The CP-DSS application regenerates an updated loadable plan based on the changes in the stowage quantities."," ","The user must enter the reason for updating the current loadable plan in the ","Comments ","field once the Loadicator validates the updated plan. "," ","Related Topics"," ","View Loadable Plan"," ","Confirm Loadable Plan"," ","Export Loadable Plan"]],"5":[[" ","Loadable Quantity"],[" ","Stowage Pattern"],[" ","Arrival/Departure Condition at Each Port"],[" ","User Comments"]],"6":[[" ","Loadable Plan"]],"id":"115"})