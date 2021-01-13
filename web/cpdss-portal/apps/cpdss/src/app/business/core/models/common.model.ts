import { IResponseStatus } from '../../../shared/models/common.model';

/**
 *  vessel-info model
 */
export interface IVesselInfo {
    responseStatus: {
        status: string
    },
    vessels: IVessels[]
}

/**
 *  model for new-loadable-study-list-names
 */
export interface INewLoadableStudyListNames {
    name: string;
    value: string;
}

/**
 *  model for loadline-list
 */
export interface ILoadLineList {
    id: number;
    name: string;
    draftMarks: IdraftMarks[]
}

/**
 *  model for draft-marks
 */
export interface IdraftMarks {
    id: number,
    name: string
}

/**
 *  model for vessel-info
 */
export interface IVessels {
    id: string,
    name: string,
    captainId: string,
    captainName: string,
    chiefOfficerId: string,
    chiefOfficerName: string,
    loadlines: ILoadLineList[]
}

/**
 * Model for voyage list 
 */
export class Voyage {
    public voyageNo: string;
    public id: number;
}

/**
 * Interface for voyage response
 *
 * @export
 * @interface IVoyageResponse
 */
export interface IVoyageResponse {
    responseStatus: IResponseStatus;
    voyages: Voyage[];
}

/**
 * Interface for tank data
 *
 * @export
 * @interface ITank
 */
export interface ITank {
    id: number;
    categoryId: number;
    categoryName: string;
    name: string;
    frameNumberFrom: number;
    frameNumberTo: number;
    shortName: string;
    heightFrom?: number;
    heightTo?: number;
    fillCapcityCubm?: number;
    fullCapacityCubm?: string;
    density: number;
    group: number;
    order: number;
    slopTank: boolean;
    commodity?: any;
    gridColumn?: string;
    percentageFilled?: string;
}

/**
 * Interface for  cargo tank layout tank
 *
 * @export
 * @interface ICargoTank
 */
export interface ICargoTank extends ITank {
    id: number;
    categoryId: number;
    categoryName: string;
    name: string;
    frameNumberFrom: number;
    frameNumberTo: number;
    shortName: string;
    heightFrom?: number;
    heightTo?: number;
    fillCapcityCubm: number;
    fullCapacityCubm?: string;
    density: number;
    group: number;
    order: number;
    slopTank: boolean;
    commodity?: ILoadableCargo;
    gridColumn?: string;
    percentageFilled?: string;
}

/**
 * Interface for setting tank details options
 *
 * @export
 * @interface ITankOptions
 */
export interface ITankOptions {
    class?: string;
    isFullyFilled?: boolean;
    showFillingPercentage?: boolean;
    fillingPercentageField?: string;
    showVolume?: boolean;
    volumeField?: string;
    volumeUnit?: string;
    showWeight?: boolean;
    weightField?: string;
    weightUnit?: string;
    showUllage?: boolean;
    ullageField?: string;
    ullageUnit?: string;
    showCommodityName?: boolean;
}

/**
 * ENUM for tank layout tabs
 *
 * @export
 * @enum {number}
 */
export enum TANKTYPE {
    CARGO = "CARGO",
    BALLAST = "BALLAST",
    BUNKER = "BUNKER",
}

/**
 * Interface for loadable cargo details
 *
 * @export
 * @interface ILoadableCargo
 */
export interface ILoadableCargo {
    cargoAbbreviation: string;
    colorCode: string;
    tankId: number;
    quantity: string;
    isCommingle: boolean;
    volume?: number;
    ullage?: number;
}

/**
 * Interface for ballast stowage
 *
 * @export
 * @interface 
 */
export interface IBallastStowageDetails {
    id: number,
    tankName?: string,
    tankId: number,
    rdgLevel: string,
    correctionFactor: string,
    correctedLevel: string,
    metricTon: string,
    cubicMeter: string,
    percentage: string,
    sg: string,
    lcg: string,
    vcg: string,
    tcg: string,
    inertia: string;
    colorCode?: string;
}

/**
 * Interface for ballast Tank details
 * @export
 * @interface 
 */
export interface IBallastTank extends ITank {
    id: number,
    categoryId: number,
    categoryName: string,
    name: string,
    frameNumberFrom: number,
    frameNumberTo: number,
    shortName: string,
    fullCapacityCubm: string,
    density: number,
    group: number,
    order: number,
    slopTank: boolean,
    commodity: IBallastStowageDetails;
}