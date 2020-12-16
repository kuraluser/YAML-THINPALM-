import { IdraftMarks } from '../core/models/common.model';

/**
 * Vessel details Model
 */
export class VesselDetailsModel {
    public id: number;
    public name: string;
    public captainId: number;
    public captainName: string;
    public chiefOfficerId: number;
    public chiefOfficerName: string;
    public loadlines: LoadLine[];
    public charterer: string;
    public imoNumber: string;

}

/**
 * Loadline Model
 */
export class LoadLine {
    public id: number;
    public name: string;
    public draftMarks: IdraftMarks[];
}

/** Interface for vessel api response */
export interface IVesselsResponse {
    responseStatus: any;
    vessels: VesselDetailsModel[];
}