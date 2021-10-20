import { Injectable } from '@angular/core';
import { IDataTableColumn, DATATABLE_FILTER_TYPE, DATATABLE_FILTER_MATCHMODE, DATATABLE_FIELD_TYPE, DATATABLE_BUTTON, DATATABLE_ACTION } from './../../../shared/components/datatable/datatable.model'

/**
 * Transformation Service for file repository
 *
 * @export
 * @class FileRepositoryTransformationService
 */

@Injectable()
export class FileRepositoryTransformationService {

  sectionList = [
    { id: 1, label: 'Loadable Study' },
    { id: 2, label: 'Loading' },
    { id: 3, label: 'Discharge Study' },
    { id: 4, label: 'Discharging' },
    { id: 5, label: 'Bunkering' }
  ];

  category = [
    { id: 1, label: 'Port' },
    { id: 2, label: 'Cargo' },
    { id: 3, label: 'Vessel' },
    { id: 4, label: 'Process' },
  ]
  constructor() { }

  /**
   * Method for getting table columns
   * @memberof FileRepositoryTransformationService
   */
  repositoryTableColumn() {
    const columns: IDataTableColumn[] = [
      {
        header: 'FILE_REPOSITORY_SL',
        fieldType: DATATABLE_FIELD_TYPE.SLNO
      },
      {
        field: 'voyageNumber',
        header: 'FILE_REPOSITORY_VOY_NO',
        filter: true,
        filterPlaceholder: 'FILE_REPOSITORY_SEARCH_VOY',
        filterType: DATATABLE_FILTER_TYPE.TEXT,
        filterMatchMode: DATATABLE_FILTER_MATCHMODE.CONTAINS,
        filterField: 'voyageNumber',
        filterByServer: true
      },
      {
        field: 'fileName',
        header: 'FILE_REPOSITORY_FILE_NAME',
        filter: true,
        filterPlaceholder: 'FILE_REPOSITORY_SEARCH_FILE',
        filterType: DATATABLE_FILTER_TYPE.TEXT,
        filterMatchMode: DATATABLE_FILTER_MATCHMODE.CONTAINS,
        filterField: 'fileName',
        filterByServer: true
      },
      {
        field: 'fileType',
        header: 'FILE_REPOSITORY_FILE_TYPE',
        fieldType: DATATABLE_FIELD_TYPE.FILEICONS,
        iconField: 'fileIcon',
        filter: true,
        filterPlaceholder: 'FILE_REPOSITORY_SEARCH_TYPE',
        filterType: DATATABLE_FILTER_TYPE.TEXT,
        filterMatchMode: DATATABLE_FILTER_MATCHMODE.CONTAINS,
        filterField: 'fileType',
        filterByServer: true
      },
      {
        field: 'section',
        header: 'FILE_REPOSITORY_FILE_SECTION',
        filter: true,
        filterPlaceholder: 'FILE_REPOSITORY_SEARCH_SECTION',
        filterType: DATATABLE_FILTER_TYPE.TEXT,
        filterMatchMode: DATATABLE_FILTER_MATCHMODE.CONTAINS,
        filterField: 'section',
        filterByServer: true
      },
      {
        field: 'category',
        header: 'FILE_REPOSITORY_FILE_CATEGORY',
        filter: true,
        filterPlaceholder: 'FILE_REPOSITORY_SEARCH_CATEGORY',
        filterType: DATATABLE_FILTER_TYPE.TEXT,
        filterMatchMode: DATATABLE_FILTER_MATCHMODE.CONTAINS,
        filterField: 'category',
        filterByServer: true
      },
      {
        field: 'createdDate',
        header: 'FILE_REPOSITORY_FILE_DATE',
        filter: true,
        filterPlaceholder: 'FILE_REPOSITORY_SEARCH_DATE',
        filterType: DATATABLE_FILTER_TYPE.DATE,
        filterMatchMode: DATATABLE_FILTER_MATCHMODE.CONTAINS,
        filterField: 'createdDate',
        filterByServer: true
      },
      {
        field: 'buttons',
        header: '',
        fieldClass: 'text-center',
        fieldColumnClass: 'text-center',
        fieldType: DATATABLE_FIELD_TYPE.BUTTON,
        buttons: [
          { type: DATATABLE_BUTTON.VIEW_BUTTON, field: 'download', class: 'view-icon' },
          { type: DATATABLE_BUTTON.EDIT_BUTTON, field: 'edit', class: 'pencil-icon' },
          { type: DATATABLE_BUTTON.DELETE_BUTTON, field: 'delete', class: 'delete-icon' },
        ]
      }

    ];
    return columns;
  }

  /**
   * Method for getting validation messages
   * @memberof FileRepositoryTransformationService
   */
  setValidationErrorMessage() {
    return {
      voyageNo: {
        'required': 'FILE_REPOSITORY_VOYAGE_REQUIRED',
      },
      section: {
        'required': 'FILE_REPOSITORY_SECTION_REQUIRED',
      },
      category: {
        'required': 'FILE_REPOSITORY_CATEGORY_REQUIRED',
      },
      fileName: {
        'required': 'FILE_REPOSITORY_FILE_REQUIRED',
      },

    }
  }
}
