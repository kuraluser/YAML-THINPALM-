import Dexie from 'dexie';

/**
 * Class for converting values to value object with additional status like modified, visible, edited etc
 *
 * @export
 * @class ValueObject
 * @template T
 */
export class ValueObject<T = any> {
    private _value: T;

    public get value(): T {
        return this._value;
    }
    public set value(v: T) {
        this._value = v;
        this._isModified = true;
    }

    public get isVisible(): boolean {
        return this._isVisible;
    }

    public set isVisible(v: boolean) {
        this._isVisible = v;
    }

    // Value Object is in edit mode or not
    public get isEditMode(): boolean {
        return this._isEditMode;
    }

    public set isEditMode(v: boolean) {
        this._isEditMode = v;
    }

    // Value Object is in editable or not
    public get isEditable(): boolean {
        return this._isEditable;
    }

    public set isEditable(v: boolean) {
        this._isEditable = v;
    }

    public get isModified(): boolean {
        return this._isModified;
    }

    public cloneData(): ValueObject<T> {
        return new ValueObject<T>(this.value);
    }

    constructor(prop: T, private _isVisible = true, private _isEditMode = true, private _isModified = false, private _isEditable = true) {
        this._value = prop;
    }

}

/**
 * Inteface for response status from api calls
 *
 * @export
 * @interface IResponseStatus
 */
export interface IResponseStatus {
    status?: string;
    message?: string,
    errorCode?: string,
    correlationId?: string;
}

/**
 * Generic Response interface
 *
 * @export
 * @interface IResponse
 */
export interface IResponse extends IResponseStatus {
    responseStatus?: IResponseStatus;
}

/**
 * Interface for generic dictionary type
 *
 * @export
 * @interface IDictionary
 * @template T
 */
export interface IDictionary<T> {
    [key: string]: T;
}

/**
 * Interface for permission context input params
 *
 * @export
 * @interface IPermissionContext
 */
export interface IPermissionContext {
    key: string;
    actions: PERMISSION_ACTION[];
    hideElementOnViewFalse?: boolean;
}

/**
 * Permission actions
 *
 * @export
 * @enum {number}
 */
export enum PERMISSION_ACTION {
    ADD = 'ADD',
    EDIT = 'EDIT',
    DELETE = 'DELETE',
    VIEW = 'VIEW'
}

/**
 * Common class for indexed db database
 *
 * @export
 * @class CPDSSDB
 * @extends {Dexie}
 */
export class CPDSSDB extends Dexie {
    cargoNominations!: Dexie.Table<any, number>;
    ports!: Dexie.Table<any, number>;
    ohq!: Dexie.Table<any, number>;
    obq!: Dexie.Table<any, number>;
    properties!: Dexie.Table<any>;
    constructor() {
        super('CPDSS');
        this.version(1).stores({
            cargoNominations: "++,storeKey,timeStamp,vesselId,voyageId,loadableStudyId,status",
            ports: "++,storeKey,timeStamp,vesselId,voyageId,loadableStudyId,status",
            ohq: "++,storeKey,timeStamp,vesselId,voyageId,loadableStudyId,status",
            obq: "++,storeKey,timeStamp,vesselId,voyageId,loadableStudyId,status",
            properties: ""
        });
    }
}

/**
 * Class for Properties Dexie db
 *
 * @export
 * @class PropertiesDB
 * @extends {CPDSSDB}
 */
export class PropertiesDB extends CPDSSDB {
    properties!: Dexie.Table<any>;

    constructor() {
        super();
    }

}

/**
 * ENUM for units of quantity
 *
 * @export
 * @enum {number}
 */
export enum QUANTITY_UNIT {
    MT = "MT",
    KL = "KL",
    BBLS = "BBLS",
    OBSBBLS = "OBSBBLS",
    LT = "LT"
}

/**
 * Interface for port
 *
 * @export
 * @interface IPort
 */
export interface IPort {
    id: number;
    name: string;
    code: string;
    maxAirDraft: number;
    maxDraft: number;
    waterDensity: number;
}

/**
 * Interface for port api response
 *
 * @export
 * @interface IPortsResponse
 */
export interface IPortsResponse {
    responseStatus: IResponseStatus;
    ports: IPort[];
}

/**
 * Interface for Operations
 *
 * @export
 * @interface IOperations
 */
export interface IOperations {
    id: number;
    operationName: string;
}
/**
 * Interface for Ports api response
 *
 * @export
 * @interface IPortsDetailsResponse
 */
export interface IPortsDetailsResponse {
    responseStatus: IResponseStatus;
    portList: IPortList[];
    operations: IOperations[];
    portId?: number;
}

/**
 * Interface for port
 *
 * @export
 * @interface IPortList
 */
export interface IPortList {
    id: number;
    portOrder: number;
    loadableStudyId: number;
    portId: number;
    operationId: number;
    seaWaterDensity: number;
    distanceBetweenPorts: number;
    timeOfStay: number;
    maxDraft: number;
    maxAirDraft: number;
    eta: string;
    etd: string;
    layCanFrom: string;
    layCanTo: string;
    isDelete?: boolean;
    isAdd?: boolean;
    storeKey?: number;
    vesselId?: number;
    voyageId?: number;
    etaActual?: string;
    etdActual?: string;
}

/**
 * Interface for fuel type
 *
 * @export
 * @interface IFuelType
 */
export interface IFuelType {
    id: number;
    name: string;
    colorCode: string;
    shortName: string;
}

/**
 * Interface for cargo response
 * @export
 * @interface 
 */
export interface ICargoResponseModel {
    cargos: ICargo[],
    responseStatus: IResponseStatus;
}

/**
 * Interface for cargo
 *
 * @export
 * @interface ICargo
 */
export interface ICargo {
    id: number;
    name?: string;
    abbreviation?: string;
    api?: number;
    ports?: IPort[];
}

/**
 * Interface for get confirm status
 *
 * @export
 * @interface IConfirmStatusResponse
 */
 export interface IConfirmStatusResponse {
    responseStatus: IResponse;
    confirmed: boolean;
}

/**
 * Interface for time zone API response
 *
 * @export
 * @interface ITimeZoneResponse
 */
export interface ITimeZoneResponse {
    responseStatus: IResponseStatus;
    timezones: ITimeZone[];
}

/**
 * Interface for list time zones
 *
 * @export
 * @interface ITimeZone
 */
export interface ITimeZone {
    id: number;
    timezone: string;
    offsetValue: string;
}

/**
 * Interface for enable time format options
 *
 * @export
 * @interface IDateTimeFormatOptions
 */
export interface IDateTimeFormatOptions {
    isTime?: boolean;
    isTimeSeconds?: boolean;
}