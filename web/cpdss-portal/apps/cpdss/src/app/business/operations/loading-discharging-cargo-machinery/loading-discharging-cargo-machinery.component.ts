import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { ILoadingMachinesInUses, IMachineryInUses, IMachineTankTypes } from '../models/loading-discharging.model';

@Component({
  selector: 'cpdss-portal-loading-discharging-cargo-machinery',
  templateUrl: './loading-discharging-cargo-machinery.component.html',
  styleUrls: ['./loading-discharging-cargo-machinery.component.scss']
})

/**
 * Component class for loading discharging cargo machinery component
 *
 * @export
 * @class LoadingDischargingCargoMachineryComponent
 * @implements {OnInit}
 */
export class LoadingDischargingCargoMachineryComponent implements OnInit {
  @Input() loadingInfoId: number;

  @Input() get machineryInUses(): IMachineryInUses {
    return this._machineryInUses;
  }

  set machineryInUses(machineryInUses: IMachineryInUses) {
    this._machineryInUses = machineryInUses;
    if(machineryInUses){
      this.initMachinery();
    }
  }

  @Output() updatemachineryInUses: EventEmitter<ILoadingMachinesInUses[]> = new EventEmitter();

  private _machineryInUses: IMachineryInUses;

  machineries: any = [];
  machineriesKey: string[] = [];
  cargoMachineryValues: any = [];
  pumpValues: any = [];
  machinery: any = [];
  selectedType: IMachineTankTypes;

  constructor() { }

  ngOnInit(): void {
    
  }

  /**
  * Method for Initialise machinery
  *
  * @memberof LoadingDischargingCargoMachineryComponent
  */
   initMachinery() {
    this.machineryInUses.loadingMachinesInUses = this.machineryInUses?.loadingMachinesInUses ?? [];
    const usedManifold = this.machineryInUses?.loadingMachinesInUses?.find(machine => machine.machineTypeId === this.machineryInUses.machineTypes.MANIFOLD);
    const usedType = this.machineryInUses?.vesselManifold?.find(manifold => manifold.id === usedManifold?.machineId)
    this.selectedType = usedType ? this.machineryInUses?.tankTypes?.find(type => type.id === usedType.componentType) : this.machineryInUses?.tankTypes[0];
    this.updateMachinery();
   }

  /**
  * Method for Update machinery
  *
  * @memberof LoadingDischargingCargoMachineryComponent
  */
  updateMachinery() {
    this.machineries = [];
    this.machineryInUses?.vesselPumps?.map((vesselpump) => {
      vesselpump.isUsing = this.machineryInUses?.loadingMachinesInUses?.some(loadingmachine => loadingmachine.machineId === vesselpump.id && loadingmachine.machineTypeId === vesselpump.machineType);
      const machinaryUsed = this.machineryInUses?.loadingMachinesInUses?.find((loadingmachine) => loadingmachine.machineId === vesselpump.id && loadingmachine.machineTypeId === vesselpump.machineType);
      if (machinaryUsed) {
        vesselpump.capacity = machinaryUsed.capacity;
      } else {
        vesselpump.capacity = vesselpump.pumpCapacity;
      }
    })
    this.machinery = this.machineryInUses?.vesselPumps?.reduce((acc, obj) => {
      const key = obj['pumpTypeId'];
      if (!acc[key]) {
        acc[key] = [];
      }
      // Add object to list for given key's value
      acc[key].push(obj);
      return acc;
    }, {});
    let filteredManiFoldMachineByTankType = [];
    filteredManiFoldMachineByTankType = this.machineryInUses.vesselManifold.filter((manifold) => manifold.componentType === this.selectedType.id);
    filteredManiFoldMachineByTankType?.map((manifold) => {
      manifold.isUsing = this.machineryInUses?.loadingMachinesInUses?.some(loadingmachine => loadingmachine.machineId === manifold.id && loadingmachine.machineTypeId === manifold.machineTypeId);
    });
    const manifoldObject = {
      machine: 'Manifold',
      columns: [...filteredManiFoldMachineByTankType],
      field: 'componentCode'
    }
    this.machineryInUses.vesselBottomLine.map((bottoLine) => {
      bottoLine.isUsing = this.machineryInUses?.loadingMachinesInUses?.some(loadingmachine => loadingmachine.machineId === bottoLine.id && loadingmachine.machineTypeId === bottoLine.machineTypeId);
    });
    const bottomLineObject = {
      machine: 'BottomLine',
      columns: [...this.machineryInUses.vesselBottomLine],
      field: 'componentCode'
    }
    this.cargoMachineryValues = [];
    this.cargoMachineryValues.push(manifoldObject);
    this.cargoMachineryValues.push(bottomLineObject);
    this.machineries['cargoMachineryValues'] = this.cargoMachineryValues;
    const vesselPumbArray = this.machineryInUses?.pumpTypes?.map((pump) => {
      return {
        machine: pump.name,
        columns: this.machinery[pump.id],
        field: 'pumpName'
      }
    })
    this.pumpValues = [...vesselPumbArray];
    this.machineries['pumpValues'] = this.pumpValues;
    this.machineriesKey = Object.keys(this.machineries);
  }

  /**
  * Method for changing capacity
  *
  * @memberof LoadingDischargingCargoMachineryComponent
  */
  onChange(column) {
    this.machineryInUses.loadingMachinesInUses = this.machineryInUses.loadingMachinesInUses.map((machine) => {
      if (machine.machineId === column.id) {
        machine.capacity = column.capacity;
      }
      return machine;
    })
    this.updatemachineryInUses.emit(this.machineryInUses.loadingMachinesInUses)
  }

  /**
  * Method for when using a machinary
  *
  * @memberof LoadingDischargingCargoMachineryComponent
  */
  onUse(column) {
    if (column?.isUsing) {
      const machineInUse: ILoadingMachinesInUses = {
        id: 0,
        loadingInfoId: this.loadingInfoId,
        machineId: column.id,
        capacity: column.capacity,
        isUsing: column.isUsing,
        machineTypeId: column?.machineType ?? column?.machineTypeId
      }
      this.machineryInUses.loadingMachinesInUses.push(machineInUse)
      this.updatemachineryInUses.emit(this.machineryInUses.loadingMachinesInUses);
    } else {
      const machineTypeId = column?.machineType ?? column?.machineTypeId;
      this.machineryInUses?.loadingMachinesInUses?.map(machineUse => {
        if (machineUse.machineId === column.id && machineUse.machineTypeId === machineTypeId) {
          machineUse.isUsing = false;
        }
      });
      this.updatemachineryInUses.emit(this.machineryInUses.loadingMachinesInUses);
    }

  }

  /**
  * Method for changing type
  *
  * @memberof LoadingDischargingCargoMachineryComponent
  */
  onTypeChange(event) {
    this.updateMachinery();
  }


}
