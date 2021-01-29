import { IValidationErrorMessages } from "../../../shared/components/validation-error/validation-error.model";
import { IResponse, ValueObject } from "../../../shared/models/common.model";

/**
 * Model for synoptical table records
 */
export interface ISynopticalRecords {
    cargos: any[];
    portName: string
    id: number,
    operationType: string,
    distance: number,
    speed: number,
    runningHours: number,
    inPortHours: number,
    timeOfSunrise: string,
    timeOfSunset: string,
    hwTideFrom: number,
    hwTideTo: number,
    hwTideTimeFrom: string,
    hwTideTimeTo: string,
    lwTideFrom: number,
    lwTideTo: number,
    lwTideTimeFrom: string,
    lwTideTimeTo: string,
    specificGravity: number,
    portId: number,

}
/**
 * Model for synoptical response 
 */
export interface ISynopticalResponse {
    responseStatus: IResponse;
    synopticalRecords: ISynopticalRecords[];
}

/**
* Model for synoptical column 
*/
export interface SynopticField {
    key: string;
    type?: string;
    isEditMode?: boolean;
    validators?: string[];
    max?: {
        fieldKey?:string,
        value?:string
    }
    min?: {
        fieldKey?:string,
        value?:string
    }
}

/**
* Model for synoptical column 
*/
export interface SynopticalColumn {
    fields?: SynopticField[];
    header: string;
    expandable?: boolean;
    editable?: boolean;
    editableByCondition?: boolean;
    subHeaders?: SynopticalColumn[];
    expandedFields?: SynopticalColumn[];
    inputs?: SynopticField[];
    dynamicKey?: string;
}

/**
* Model for synoptical dynamic column 
*/
export interface SynopticalDynamicColumn {
    fieldKey: string;
    primaryKey: string;
    headerLabel: string;
    subHeaders?: SynopticalColumn[];
}
