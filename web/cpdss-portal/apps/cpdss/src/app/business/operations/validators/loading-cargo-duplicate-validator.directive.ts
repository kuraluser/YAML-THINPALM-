import { FormControl, ValidationErrors, ValidatorFn } from '@angular/forms';

/**
 * Validator Function for cargo duplicates
 * @param control 
 */
export function LoadingCargoDuplicateValidator(index): ValidatorFn {
    return (control: FormControl): ValidationErrors | null => {
        if (!control.root || !control.parent) {
            return null;
        }
        const dataTableArray = control.root.value.dataTable;
        if (control?.value && dataTableArray) {
            dataTableArray.splice(index,1);
            const found = dataTableArray.some(data => data?.cargo?.cargoNominationId === control?.value?.cargoNominationId );
            if(found){
                return {duplicateCargo: true}
            }else{
                return null;
            }
        } else {
            return null;
        }

    }
}