import { FormControl, ValidationErrors, ValidatorFn } from '@angular/forms';

/**
 * Validator Function for cargo duplicates
 * @param control 
 */
export function CargoDuplicateValidator(field, dependentField): ValidatorFn {
    return (control: FormControl): ValidationErrors | null => {
        if (!control.root || !control.parent) {
            return null;
        }
        const dataTableArray = control.root.value.dataTable;
        if(control?.value && control?.parent?.value[dependentField]){
            const data = control?.parent?.value;
            data[field] = control.value;
            const found = dataTableArray.filter(cargoData => (cargoData?.cargo1?.cargoId === data?.cargo1?.cargoId  &&  cargoData?.cargo2?.cargoId === data?.cargo2?.cargoId ) || (cargoData?.cargo2?.cargoId === data?.cargo1?.cargoId  &&  cargoData?.cargo1?.cargoId === data?.cargo2?.cargoId ));
            if(found.length > 1){
                return { duplicate: true };
            }else{
                return null;
            }
        }else{
            return null;
        }
      
    }
};