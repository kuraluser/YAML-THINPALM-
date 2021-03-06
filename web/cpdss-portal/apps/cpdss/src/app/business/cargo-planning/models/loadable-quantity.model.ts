/**
 * Model for loadable quantity model
 */
export class LoadableQuantityModel {
    public responseStatus: Status;
    public loadableQuantity: LodadableQuantity;
    public isSummerZone?: boolean;
    public caseNo: number;
    public selectedZone: string;
}
/**
 * Model for loadable quantity
 */
export class LodadableQuantity {
    public portRotationId?: number;
    public portId?: number;
    public draftRestriction: string;
    public displacmentDraftRestriction?: string;
    public vesselLightWeight?: string;
    public dwt: string;
    public tpc: string;
    public estSeaDensity?: string;
    public sgCorrection?: string;
    public estSagging: string;
    public saggingDeduction?: string;
    public ballast: string;
    public constant: string;
    public estFOOnBoard: string;
    public estDOOnBoard: string;
    public estFreshWaterOnBoard?: string;
    public otherIfAny: string;
    public obqSlops?: string;
    public distanceFromLastPort?: string;
    public vesselAverageSpeed?: string;
    public runningHours?: string;
    public runningDays?: string;
    public foConsumptionPerDay?: string;
    public estTotalFOConsumption?: string;
    public updateDateAndTime?: string;
    public lastUpdatedTime?: string;
    public foConInSZ?: string;
    public subTotal?: string;
    public totalQuantity?: string;
    public loadableQuantityId?: number;
    public id?: number;
    private loadableStudyId?: number;
}

/**
 * Response model for loadable quantity
 */
export class LoadableQuantityResponseModel {
    public responseStatus: Status;
    public loadableQuantityId: number;
}
/**
 *  Model for loadable quantity response status
 */
export class Status {
    status: string;
}





