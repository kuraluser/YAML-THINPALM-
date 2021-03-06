import { IResponseStatus } from '../../../shared/models/common.model';
import { ICargoTank, ILoadableCargo } from '../../core/models/common.model';


/**
 * Interface for  user role permission api response
 *
 * @export
 * @interface IUserRolePermissionResponse
 */
export interface IUserRolePermissionResponse {
    responseStatus: IResponseStatus;
    screens: IScreenNode[];
    role: IRoleDetails;
    users: number[];
}

/**
 * Interface for  role detail
 *
 * @export
 * @interface IRoleDetails
 */
export interface IRoleDetails {
    id: number;
    name: string;
    description: string;
    companyId: string;
}


/**
 * Interface for  user role permission inner nodes
 *
 * @export
 * @interface IScreenNode
 */
export interface IScreenNode {
    id: number;
    name: string;
    languageKey: string;
    add: boolean;
    edit: boolean;
    delete: boolean;
    view: boolean;
    moduleId: number;
    childs: IScreenNode[];
}

/**
 * Interface for  user details api response
 *
 * @export
 * @interface IUserDetailsResponse
 */
export interface IUserDetailsResponse {
    responseStatus: IResponseStatus;
    users: IUserDetail[];
}

/**
 * Interface for  user details
 *
 * @export
 * @interface IUserDetail
 */
export interface IUserDetail {
    id: number;
    rolePermissions: null;
    username: string;
    firstName: string;
    lastName: string;
    name?: string;
}

/**
 * Interface for  tree node data
 *
 * @export
 * @interface ITreeNodeData
 */
export interface ITreeNodeData {
    name: string;
    add: boolean;
    edit: boolean;
    delete: boolean;
    view: boolean;
    id: number;
    moduleId: number;
    isChecked: boolean;
    isAddVisible: boolean;
    isDeleteVisible: boolean;
    isEditVisible: boolean;
    isViewVisible: boolean;
    nodeChecked: boolean;
    isReadOnlyAdd: boolean;
    isReadOnlyEdit: boolean;
    isReadOnlyDelete: boolean;
    isReadOnlyView: boolean;
}

/**
 * Interface for  role response
 *
 * @export
 * @interface IRoleResponse
 */
export interface IRoleResponse {
    responseStatus: IResponseStatus;
    roles: IRoleDetails[];
    totalElements: number;
}

/**
 * Interface for  Role detail
 *
 * @export
 * @interface IRoleDetails
 */
export interface IRoleDetails {
    id: number;
    name: string;
    description: string;
    isUserMapped: boolean;
}

/**
 * Interface for  Role delete response
 *
 * @export
 * @interface IRoleDeleteResponse
 */
export interface IRoleDeleteResponse {
    responseStatus: IResponseStatus;
    roleId: number;
    message: string;
}

/**
 * Interface for creating a new user
 *
 * @export
 * @interface IUserRoleModel
 */
export interface IUserRoleModel {
    name: string;
    description: string;
    roleId?:number;
}

/**
 * Interface for saved user response
 *
 * @export
 * @interface ISaveUserRoleResponse
 */
export interface ISaveUserRoleResponse {
    roles: string;
    responseStatus: IResponseStatus;
    roleId: number;
    message: string;
}
/**
 * Interface for user permission
 *
 * @export
 * @interface IUserPermissionModel
 */
export interface IUserPermissionModel {
    screens: IUserPermissionScreen[];
    roleId: number;
    userId: number[];
    deselectedUserId: number[];
    role: IUserPermissionRole;
}

/**
 * Interface for user permission  screen
 *
 * @export
 * @interface IUserPermissionScreen
 */
export interface IUserPermissionScreen {
    id: number;
    name: string;
    add: boolean;
    edit: boolean;
    view: boolean;
    delete: boolean;
}

/**
 * Interface for user permission role
 *
 * @export
 * @interface IUserPermissionRole
 */
export interface IUserPermissionRole {
    name: string;
    description: string;
}

/**
 * Interface for save user permission
 *
 * @export
 * @interface ISavePermissionResponse
 */
export interface ISavePermissionResponse {
    responseStatus: IResponseStatus;
    roleId: number;
    message: string;
}
