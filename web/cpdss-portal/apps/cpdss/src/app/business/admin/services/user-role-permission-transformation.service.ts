import { Injectable } from '@angular/core';

import { AdminModule } from '../admin.module';

import { DATATABLE_ACTION, DATATABLE_FIELD_TYPE, DATATABLE_FILTER_MATCHMODE, DATATABLE_FILTER_TYPE, IDataTableColumn } from '../../../shared/components/datatable/datatable.model';

/**
 * Api Service for user role tranformation of data
 *
 * @export
 * @class UserRolePermissionTransformationService
*/

@Injectable({
  providedIn: AdminModule
})

export class UserRolePermissionTransformationService {

  constructor() { }

    /**
   * Method for setting Role List grid column
   *
   * @returns {IDataTableColumn[]}
   * @memberof UserRolePermissionTransformationService
   */
  getRoleListDatatableColumns(): IDataTableColumn[] {
    return [
      {
        field: 'slNo',
        header: 'USER_ROLE_SL',
        fieldType: DATATABLE_FIELD_TYPE.SLNO,
        fieldHeaderClass: 'column-sl',
        fieldClass: 'sl'
      },
      {
        field: 'name',
        header: 'USER_ROLE_NAME_HEADING',
        filter: true,
        filterPlaceholder: 'SEARCH_ROLE_NAME',
        filterType: DATATABLE_FILTER_TYPE.TEXT,
        filterMatchMode: DATATABLE_FILTER_MATCHMODE.CONTAINS,
        filterField: 'name',
        sortable: true,
        sortField: 'name',
        filterByServer: true
      },
      {
        field: 'description',
        header: 'USER_DESCRIPTION_HEADING',
        filter: true,
        filterPlaceholder: 'SEARCH_ROLE_DESCRIPTION',
        filterType: DATATABLE_FILTER_TYPE.TEXT,
        filterMatchMode: DATATABLE_FILTER_MATCHMODE.CONTAINS,
        filterField: 'description',
        filterByServer: true
      },
      {
        field: 'actions',
        header: '',
        fieldType: DATATABLE_FIELD_TYPE.ACTION,
        actions: []
      }
    ]
  }

  /**
   * Set validation Error to form control
   * @memberof UserRolePermissionTransformationService
  */
  setValidationErrorMessage() {
    return {
      roleName: {
        'required': 'ADD_ROLE_POPUP_ROLE_REQUIRED_ERROR',
        'pattern':'ROLE_NAME_VALIDATION_ERROR',
        'maxlength': 'ROLE_NAME_MAX_LENGTH'
      },
      roleDescription: {
        'required': 'ADD_ROLE_POPUP_DESCRIPTION_REQUIRED_ERROR'
      }
    }
  }
}
