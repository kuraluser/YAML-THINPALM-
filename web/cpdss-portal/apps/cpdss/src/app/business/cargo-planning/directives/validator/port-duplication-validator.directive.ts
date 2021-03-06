import { FormControl, ValidationErrors, ValidatorFn } from '@angular/forms';
import { OPERATIONS } from '../../../core/models/common.model';

/**
 * Validator Function for date range
 * @param control
 */
export function portDuplicationValidator(field, isLS = true): ValidatorFn {
  return (control: FormControl): ValidationErrors | null => {
    if (control.root && control.parent) {
      let filtered = [];
      let portId, operationId;
      const dataTableArray = control.root.value.dataTable?.filter(portData => portData.portOrder !== control.parent.value?.portOrder);
      if (dataTableArray?.length) {
        if (control?.value) {
          if (field === 'operation') {
            operationId = control.value?.id;
            if (control.parent.value?.port) {
              portId = control.parent.value.port?.id;
              filtered = dataTableArray.filter(portData => portData.port?.id === portId && portData.operation?.id === operationId && ((portData?.operation?.id !== OPERATIONS.LOADING && isLS) || (portData?.operation?.id !== OPERATIONS.DISCHARGING && !isLS)));
            }
          } else if (field === 'port') {
            portId = control.value?.id;
            if (control.parent.value?.operation) {
              operationId = control.parent?.value?.operation?.id;
              filtered = dataTableArray.filter(portData => portData.port?.id === portId && portData.operation?.id === operationId && ((portData?.operation?.id !== OPERATIONS.LOADING && isLS) || (portData?.operation?.id !== OPERATIONS.DISCHARGING && !isLS)));
            }
          }
        }
        if (filtered.length >= 1) {
          return { duplicate: true };
        }
        if (operationId === OPERATIONS.TRANSIT) {
          filtered = dataTableArray.filter(portData => portData.port?.id === portId);
        } else {
          filtered = dataTableArray.filter(portData => portData.port?.id === portId && portData.operation?.id === OPERATIONS.TRANSIT);
        }
        if (filtered.length >= 1) {
          return { transitDuplicate: true }
        }

        if (isLS) {
          const dischargingPorts = dataTableArray?.filter(portData => portData.operation?.id === OPERATIONS.DISCHARGING);
          if (operationId === OPERATIONS.DISCHARGING) {
            dischargingPorts.push(control.root.value.dataTable?.filter(portData => portData.portOrder === control.parent.value?.portOrder))
          }
          if (dischargingPorts.length > 1) {
            return { singleDischargePort: true }
          }
        }
      }
    }
    return null;
  }
};
