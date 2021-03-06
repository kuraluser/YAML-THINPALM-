import { Component, EventEmitter, Input, OnInit, Output, ViewChild } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup, ValidationErrors } from '@angular/forms';
import { TranslateService } from '@ngx-translate/core';
import { MenuItem, SortEvent, LazyLoadEvent } from 'primeng/api';
import { Table } from 'primeng/table';
import { ObjectUtils } from 'primeng/utils';
import { DATATABLE_ACTION, DATATABLE_EDITMODE, DATATABLE_BUTTON, DATATABLE_FIELD_TYPE, DATATABLE_FILTER_MATCHMODE, DATATABLE_FILTER_TYPE, DATATABLE_SELECTIONMODE, IDataTableColumn, IDataTableEvent, IDataTableFilterEvent, IDataTableSortEvent, IDataTablePageChangeEvent } from './datatable.model';
import { Paginator } from 'primeng/paginator';
import { DecimalPipe } from '@angular/common';
import { Dropdown } from 'primeng/dropdown';
import * as moment from 'moment';
import { QUANTITY_UNIT } from '../../models/common.model';
import { TimeZoneTransformationService } from '../../services/time-zone-conversion/time-zone-transformation.service';
import { IDateTimeFormatOptions } from '../../models/common.model';
import { AppConfigurationService } from '../../services/app-configuration/app-configuration.service';


/**
 * Compoent for Datatable
 *
 * @export
 * @class DatatableComponent
 * @implements {OnInit}
 */
@Component({
  selector: 'cpdss-portal-datatable',
  templateUrl: './datatable.component.html',
  styleUrls: ['./datatable.component.scss']
})
export class DatatableComponent implements OnInit {

  @ViewChild('datatable') datatable: Table;
  @ViewChild('paginator') paginatorRef: Paginator

  // properties
  @Input()
  get columns(): IDataTableColumn[] {
    return this._columns;
  }
  set columns(columns: IDataTableColumn[]) {
    this._columns = columns;
    const colsWithSubCol = columns.filter(col => col?.columns?.length);
    this.totalColSpan = columns.length - colsWithSubCol?.length;
    colsWithSubCol.forEach(col => {
      this.totalColSpan += col?.columns.length;
    });
    this.setActions(columns);
  }

  @Input()
  get value(): Array<any> {
    return this._value;
  }
  set value(value: Array<any>) {
    if (value) {
      this._value = value;
      if (this.paginator) {
        this.form = this.fb.group({
          dataTable: this.fb.array([...this.value])
        });
      }
      this.filteredValue = value;
    }
  }

  @Input()
  get form(): FormGroup {
    return this._form;
  }
  set form(form: FormGroup) {
    if (form) {
      this._form = form;
    }
  }

  @Input() selection: Object;

  @Input() selectionMode: DATATABLE_SELECTIONMODE;

  @Input()
  get progress(): boolean {
    return this._progress;
  }
  set progress(value) {
    this._progress = value;
    this.totalColSpan += value ? 1 : 0;
  }

  @Input()
  get editMode(): DATATABLE_EDITMODE {
    return this._editMode;
  }

  set editMode(editMode: DATATABLE_EDITMODE) {
    this.customSort = editMode ? true : false;
    this._editMode = editMode;
  }

  @Input() filterable: boolean;

  @Input() listData: Object;

  @Input() sortMode: boolean;

  @Input()
  get tableRowReOrder(): boolean {
    return this._tableRowReOrder;
  }
  set tableRowReOrder(value) {
    this._tableRowReOrder = value;
    this.totalColSpan += value ? 1 : 0;
  }

  @Input() tableId: string;

  @Input() showTotal = false;

  @Input() scrollable = true;

  @Input() showHeader = true;

  @Input() showTotalClass: string;

  @Input() showManualTotal = false;

  @Input() totalValue: number;

  @Input() showTotalTooltip: false;

  @Input() totalToolTipKey: string;

  @Input()
  set loading(loading: boolean) {
    this._loading = loading;
  }

  get loading(): boolean {
    return this._loading;
  }

  @Input() paginator: boolean;

  @Input()
  set rowsPerPage(rows: number[]) {
    this._rowsPerPage = rows;
  }

  get rowsPerPage(): Array<number> {
    return this._rowsPerPage;
  }

  @Input()
  set rows(rows: number) {
    this._rows = rows;
  }

  get rows(): number {
    return this._rows;
  }

  @Input()
  set totalRecords(totalRecords: number) {
    this._totalRecords = totalRecords;
  }

  get totalRecords(): number {
    return this._totalRecords;
  }

  @Input()
  set currentPageReportTemplate(totalRecords: string) {
    this._currentPageReportTemplate = totalRecords;
  }

  get currentPageReportTemplate(): string {
    return this._currentPageReportTemplate;
  }

  @Input()
  set lazy(lazy: boolean) {
    this._lazy = lazy;
  }

  get lazy(): boolean {
    return this._lazy;
  }

  @Input()
  set currentPage(currentPage: number) {
    this._currentPage = currentPage;
  }

  @Input()
  set first(first: number) {
    this._first = first;
  }

  get first(): number {
    return this._first;
  }

  @Input()
  set reset(resetDataTable: boolean) {
    if (resetDataTable) {
      this.datatable.reset();
      this.filterObject = {};
      this.resetChange.emit(false);
    }
  }

  get dataTable() {
    return this.form.get('dataTable') as FormArray;
  }

  // output event
  @Output() cellValueClick = new EventEmitter<IDataTableEvent>();
  @Output() editComplete = new EventEmitter<IDataTableEvent>();
  @Output() duplicateRow = new EventEmitter<IDataTableEvent>();
  @Output() deleteRow = new EventEmitter<IDataTableEvent>();
  @Output() viewRow = new EventEmitter<IDataTableEvent>();
  @Output() saveRow = new EventEmitter<IDataTableEvent>();
  @Output() rowSelection = new EventEmitter<IDataTableEvent>();
  @Output() columnClick = new EventEmitter<IDataTableEvent>();
  @Output() rowReorder = new EventEmitter<IDataTableEvent>();
  @Output() filter = new EventEmitter<IDataTableFilterEvent>();
  @Output() sort = new EventEmitter<IDataTableSortEvent>();
  @Output() editRow = new EventEmitter<IDataTableEvent>();
  @Output() resetPassword = new EventEmitter<IDataTableEvent>();
  @Output() dataStateChange = new EventEmitter<IDataTablePageChangeEvent>();
  @Output() firstChange = new EventEmitter<number>();
  @Output() currentPageChange = new EventEmitter<number>();
  @Output() resetChange = new EventEmitter<boolean>();
  @Output() buttonClick = new EventEmitter<IDataTableEvent>();
  @Output() cellOnBlur = new EventEmitter<IDataTableEvent>();

  // public fields
  readonly fieldType = DATATABLE_FIELD_TYPE;
  readonly filterType = DATATABLE_FILTER_TYPE;
  readonly filterMatchMode = DATATABLE_FILTER_MATCHMODE;
  moreOptions: MenuItem[];
  selectedRowEvent: IDataTableEvent;
  totalColSpan: number;
  customSort: boolean;
  filterObject: object = {};
  filteredValue: Array<any>;
  onInputRange = false;
  onInputTime = false;


  // private fields
  private _columns: IDataTableColumn[];
  private _value: Array<any>;
  private _form: FormGroup;
  private _editMode: DATATABLE_EDITMODE;
  private _lazy: boolean;
  private _totalRecords: number;
  private _rows: number;
  private _rowsPerPage: number[];
  private _currentPageReportTemplate: string;
  private _currentPage: number;
  private _loading: boolean;
  private _first: number;
  private _progress = false;
  private _tableRowReOrder = false;


  // public methods
  constructor(
    private translateService: TranslateService,
    private timeZoneTransformationService: TimeZoneTransformationService,
    private fb: FormBuilder,
    private decimalPipe: DecimalPipe) { }

  ngOnInit(): void {
    this._first = 0;
    this._rowsPerPage = [10, 25, 50, 100];
    this._currentPageReportTemplate = "Showing {first} to {last} of {totalRecords} entries";
    this._loading = false;
    if (!this.form) {
      this.form = this.fb.group({
        dataTable: this.fb.array([...this.value])
      });
    }
  }

  /**
   * Handler for on edit complete event
   *
   * @param {IDataTableEvent} event
   * @memberof DatatableComponent
   */
  onEditComplete(event: IDataTableEvent): void {
    let colEditable, col;
    for (let index = 0; index < this.columns.length; index++) {
      if (this.columns[index].field === event?.field) {
        col = this.columns[index];
        break;
      } else {
        col = this.columns[index]?.columns?.find(column => column?.field === event?.field);
        if (col !== undefined) {
          break;
        }
      }
    }
    colEditable = col?.editable
    if (this.editMode && (colEditable === undefined || colEditable) && event?.data[event.field]?.isEditable && !event.data?.isAdd && event.field !== 'actions') {
      for(let i= event.index; i >= 0; i--){
        const control = this.field(i, event.field);
        if (col?.fieldType !== this.fieldType.DATETIME && col?.fieldType !== this.fieldType.MULTISELECT && col?.fieldType !== this.fieldType.DATERANGE && event.data[event.field].value) {
          event.data[event.field].isEditMode = control?.invalid;
          control.updateValueAndValidity();
        }
      }
    }
  }

  /**
   * Handler for on multiselect close event
   *
   * @param {IDataTableEvent} event
   * @memberof DatatableComponent
   */
  onMultiselectClose(rowData, rowIndex, col){
    const control = this.field(rowIndex, col.field);
    rowData[col.field].isEditMode = control?.invalid;
    control.updateValueAndValidity();
  }

  /**
   * Hadler for table cell edit change event
   *
   * @param event
   * @param {any} rowData
   * @param {number} rowIndex
   * @param {IDataTableColumn} col
   * @memberof DatatableComponent
   */
  onChange(event, rowData: any, rowIndex: number, col: IDataTableColumn) {
    const previousValue = { ...rowData[col.field].value };
    rowData[col.field].value = this.field(rowIndex, col.field).value;
    this.editComplete.emit({ originalEvent: event, data: rowData, index: rowIndex, field: col.field, previousValue });
  }

  /**
   * Hadler for cell blur 
   *
   * @param event
   * @param {any} rowData
   * @param {number} rowIndex
   * @param {IDataTableColumn} col
   * @memberof DatatableComponent
   */
  onBlur(event, rowData: any, rowIndex: number, col: IDataTableColumn) {
    this.cellOnBlur.emit({ originalEvent: event, data: rowData, index: rowIndex, field: col.field })
  }

  /**
   * Hadler for table cell value click event
   *
   * @param {MouseEvent} event
   * @param {any} rowData
   * @param {number} rowIndex
   * @param {IDataTableColumn} col
   * @memberof DatatableComponent
   */
  onCellValueClick(event: MouseEvent, rowData: any, rowIndex: number, col: IDataTableColumn) {
    //event.stopPropagation(); // Please dont remove this line
    const control = this.field(rowIndex, col.field);
    control.markAsTouched();
    control.updateValueAndValidity();
    this.cellValueClick.emit({ originalEvent: event, data: rowData, index: rowIndex, field: col.field });
  }

  /**
   * Handler for api new row save event
   *
   * @param {MouseEvent} event
   * @param {Object} rowData
   * @param {number} rowIndex
   * @memberof DatatableComponent
   */
  onRowSave() {
    console.log('datatableRowsave' + Date.now()); // TODO: Need to remove after testing.
    this.saveRow.emit(this.selectedRowEvent);
  }

  /**
   * Handler for cell tab on focus event
   * @param event
   * @param rowData
   * @param rowIndex
   * @param col
   * @param colIndex
   */
  onKeyChange(event, rowData: any, col: IDataTableColumn, colIndex: number, rowIndex: number) {
    const code = (event.keyCode ? event.keyCode : event.which);
    if ((code === 9 || code === 13) && col.fieldType !== this.fieldType.ACTION && (col.editable === undefined || col.editable) && rowData[col.field]?.isEditable && !rowData?.isAdd) {
      const prevField = this.columns[colIndex - 1].field;
      if (prevField && rowData[prevField]) {
        const control = this.field(rowIndex, prevField);
        rowData[prevField].isEditMode = !control.valid;
      }
      rowData[col.field].isEditMode = true;
    }
  }

  /**
   * Handler for cell tab on focus event
   * @param event
   * @param rowData
   * @param rowIndex
   * @param col
   * @param colIndex
   */
  onFocusKeyDown(event, rowData: any, col: IDataTableColumn, colIndex: number, rowIndex: number) {
    const nextField = this.columns[colIndex + 1];
    if((event.keyCode === 9 || event.keyCode === 13) && !event.shiftKey && nextField.fieldType === 'DATETIME') {
      const id = `${nextField.field}_${rowIndex}input`;
      setTimeout(() => {
        if(document.getElementById(id) !== document.activeElement && this.value[rowIndex][nextField.field].isEditMode) {
          document.getElementById(id).focus();
        }
      },250)
    }
  }

  /**
  * Handler for cell on click event
  * @param event
  * @param rowData
  * @param rowIndex
  * @param col
  * @param colIndex
  */
  onClick(event, rowData, rowIndex, col: IDataTableColumn) {
    if (rowData[col.field]?.isEditable && this.row(rowIndex) && this.editMode && (col.editable === undefined || col.editable) && col.fieldType !== this.fieldType.ACTION) {
      rowData[col.field].isEditMode = true;
    }
    this.columnClick.emit({ originalEvent: event, data: rowData, index: rowIndex, field: col.field });
  }

  /**
   * Handler for filter event
   *
   * @param {IDataTableFilterEvent} event
   * @memberof DatatableComponent
   */
  onFilter(event: IDataTableFilterEvent) {
    this.filter.emit(event);
    this.filteredValue = event.filteredValue;
  }

  /**
   * Get form control of form
   *
   * @param {number} formGroupIndex
   * @param {string} formControlName
   * @returns {FormControl}
   * @memberof DatatableComponent
   */
  field(formGroupIndex: number, formControlName: string): FormControl {
    const formControl = <FormControl>(<FormArray>this.form.get('dataTable')).at(formGroupIndex).get(formControlName);
    return formControl;
  }

  /**
   * Get field errors
   *
   * @param {number} formGroupIndex
   * @param {string} formControlName
   * @returns {ValidationErrors}
   * @memberof DatatableComponent
   */
  fieldError(formGroupIndex: number, formControlName: string): ValidationErrors {
    const formControl = this.field(formGroupIndex, formControlName);
    return formControl.invalid && (formControl.dirty || formControl.touched) ? formControl.errors : null;
  }

  /**
   * Get form row group
   *
   * @param {number} formGroupIndex
   * @returns {FormGroup}
   * @memberof DatatableComponent
   */
  row(formGroupIndex: number): FormGroup {
    const formGroup = <FormGroup>(<FormArray>this.form.get('dataTable')).at(formGroupIndex);
    return formGroup;
  }

  /**
   * Handler for actions dropdown button
   *
   * @param {MouseEvent} event
   * @param {any} rowData
   * @param {number} rowIndex
   * @param {IDataTableColumn} col
   * @memberof DatatableComponent
   */
  onDropdownClick(event: MouseEvent, rowData: any, rowIndex: number, col: IDataTableColumn) {
    this.selectedRowEvent = { originalEvent: event, data: rowData, index: rowIndex, field: col.field };
  }

  /**
   * for setting focus on filter of drop down.
   *
   * @param {DropDown} dropDown
   */
  setDropDownFocus(dropDown: Dropdown): void {
    if (dropDown?.filterViewChild?.nativeElement !== undefined) {
      dropDown.filterViewChild.nativeElement.focus();
    }
  }


  /**
   * Handler for row delete event
   *
   * @memberof DatatableComponent
   */
  onDelete() {
    this.selectedRowEvent.data.isDelete = true;
    this.deleteRow.emit(this.selectedRowEvent);
    // this.editComplete.emit(this.selectedRowEvent);
  }

  /**
   * Handle for row duplicate event
   *
   * @memberof DatatableComponent
   */
  onDuplicate() {
    this.duplicateRow.emit(this.selectedRowEvent);
  }

  /**
   * Handler for view action button click
   *
   * @memberof DatatableComponent
   */
  onView(): void {
    this.viewRow.emit(this.selectedRowEvent);
  }

  /**
   * Handler for option click
   *
   * @param {MouseEvent} event
   * @param {any} rowData
   * @param {number} rowIndex
   * @param {IDataTableColumn} col
   * @param {MenuItem} option
   * @memberof DatatableComponent
   */
  onOptionClick(event: MouseEvent, rowData: any, rowIndex: number, col: IDataTableColumn, option: MenuItem) {
    this.selectedRowEvent = { originalEvent: event, data: rowData, index: rowIndex, field: col.field };
    option.command();
  }

  /**
   * Handler for row selection
   *
   * @param {IDataTableEvent} event
   * @memberof DatatableComponent
   */
  onRowSelect(event: IDataTableEvent) {
    this.rowSelection.emit(event);
  }

  /**
   * Method for getting all more options
   *
   * @param {*} rowData
   * @returns
   * @memberof DatatableComponent
   */
  getMoreOptions(rowData: any) {
    return this.moreOptions.map(option => {
      if (option.id === DATATABLE_ACTION.SAVE) {
        option.visible = rowData?.isAdd;
      }
      if (option.id === DATATABLE_ACTION.EDIT) {
        option.visible = rowData?.isEditable === undefined || rowData?.isEditable;
      }
      if (option.id === DATATABLE_ACTION.DELETE) {
        option.visible = rowData?.isDeletable === undefined || rowData?.isDeletable;
      }
      if (option.id === DATATABLE_ACTION.DUPLICATE) {
        option.visible = rowData?.isDuplicate === undefined || rowData?.isDuplicate;
      }
      return option;
    });
  }

  /**
   * Method for options for icon
   *
   * @param {*} rowData
   * @param {*} col
   * @returns
   * @memberof DatatableComponent
   */
  isIconVisible(rowData: any,col) {
    const action = col.actions?.length ? col.actions[0] : null;
    if(!action) { return false };
    let iconVisible;
    switch(action) {
      case DATATABLE_ACTION.SAVE: {
        if (rowData?.isAdd) {
          iconVisible =  true;
        }
      }
      break;
      case DATATABLE_ACTION.EDIT: {
        if (rowData?.isEditable === undefined || rowData?.isEditable) {
          iconVisible =  true;
        }
      }
      break;
      case DATATABLE_ACTION.DELETE: {
        if (rowData?.isDeletable === undefined || rowData?.isDeletable) {
          iconVisible =  true;
        }
      }
      break;
      case DATATABLE_ACTION.DUPLICATE: {
        if (rowData?.isDuplicate === undefined || rowData?.isDuplicate) {
          iconVisible =  true;
        }
      }
      break;
    }
    return iconVisible;
  }

  // private methods
  /**
   * Method for setting actions for data table
   *
   * @private
   * @param {IDataTableColumn[]} columns
   * @memberof DatatableComponent
   */
  private setActions(columns: IDataTableColumn[]) {
    const actionsCol = columns?.find(col => col.fieldType === this.fieldType.ACTION);
    const moreOptions: DATATABLE_ACTION[] = actionsCol?.actions ?? [];
    this.moreOptions = moreOptions.map(option => {
      let label: string;
      this.translateService.get(option).subscribe(response => {
        label = response
      });
      let _option;
      switch (option) {
        case DATATABLE_ACTION.SAVE:
          _option = {
            id: DATATABLE_ACTION.SAVE,
            label: label,
            icon: 'save-icon',
            command: () => {
              this.onRowSave();
            }
          }
          break;

        case DATATABLE_ACTION.DUPLICATE:
          _option = {
            id: DATATABLE_ACTION.DUPLICATE,
            label: label,
            icon: 'action-btn pi pi-clone',
            command: () => {
              this.onDuplicate();
            }
          }
          break;

        case DATATABLE_ACTION.DELETE:
          _option = {
            id: DATATABLE_ACTION.DELETE,
            label: label,
            icon: 'delete-icon',
            command: () => {
              this.onDelete();
            }
          }
          break;

        case DATATABLE_ACTION.VIEW:
          _option = {
            id: DATATABLE_ACTION.VIEW,
            label: label,
            icon: 'view-icon',
            command: () => {
              this.onView();
            }
          }
          break;

        case DATATABLE_ACTION.EDIT:
          _option = {
            id: DATATABLE_ACTION.EDIT,
            label: label,
            icon: 'pencil-icon',
            command: () => {
              this.onEdit();
            }
          }
          break;
        default:
          break;
      }
      return _option;
    });

  }

  /**
 * Handler for option click
 *
 * @param {MouseEvent} event
 * @param {any} rowData
 * @param {number} rowIndex
 * @param {IDataTableColumn} col
 * @param {MenuItem} option
 * @memberof DatatableComponent
 */
  buttonEvent(event: MouseEvent, rowData: any, rowIndex: number, field: string, option: MenuItem) {
    this.selectedRowEvent = { originalEvent: event, data: rowData, index: rowIndex, field: field };
    this.buttonClick.emit(this.selectedRowEvent);
  }


  /**
  * Handler for api row edit event
  *
  * @param {MouseEvent} event
  * @param {Object} rowData
  * @param {number} rowIndex
  * @memberof DatatableComponent
  */
  onEdit() {
    this.editRow.emit(this.selectedRowEvent);
  }


  /**
  * Filter date
  */
  onDateSelect(value, col, field, filterMatchMode) {
    if (col?.filterByServer) {
      this._first = 0;
      this._currentPage = 0;
      this.filterObject[col.filterField] = value ? this.formatDateTime(value) : '';
      const data = this.setStateValue('filter');
      this.firstChange.emit(this._first);
      this.currentPageChange.emit(this._currentPage);
      this.dataStateChange.emit(data);
    } else {
      if (value && col?.dateFormat && col?.dateFormat === this.timeZoneTransformationService.getMappedConfigurationDateFormat(AppConfigurationService.settings?.dateFormat)) {
        this.datatable.filter(moment(value).format(AppConfigurationService.settings?.dateFormat.split(' ')[0]), field, filterMatchMode);
      } else {
        this.datatable.filter(this.formatDateTime(value), field, filterMatchMode);
      }
    }
  }

  /**
   * Method for filtering date on enter key press
   * @param value
   */
  onDateFilter(value, col, field) {
    if (col?.filterByServer) {
      this._first = 0;
      this._currentPage = 0;
      this.filterObject[col.filterField] = value.trim();
      const data = this.setStateValue('filter');
      this.firstChange.emit(this._first);
      this.currentPageChange.emit(this._currentPage);
      this.dataStateChange.emit(data);
    } else {
      this.datatable.filter(value, field, 'equals');
    }
  }



  /**
  * Format date(dd-mm-yyyy)
  * Format date time(dd-mm-yyyy hh:mm)
  */
  formatDateTime(date, isTime = false) {
    if (!date)
      return ""
    let month = date.getMonth() + 1;
    let day = date.getDate();
    let hour = date.getHours();
    let minute = date.getMinutes();

    if (month < 10) {
      month = '0' + month;
    }

    if (day < 10) {
      day = '0' + day;
    }

    if (hour < 10) {
      hour = '0' + hour;
    }

    if (minute < 10) {
      minute = '0' + minute;
    }

    if (isTime) {
      return day + '-' + month + '-' + date.getFullYear() + ' ' + hour + ':' + minute;
    } else {
      return day + '-' + month + '-' + date.getFullYear();
    }
  }

  /**
  * Range date onblur
  */
  onBlurDateRange(event, formGroupIndex: number, col, rowData: Object){
    if(this.onInputRange){
      this.onDateRangeSelect(event, formGroupIndex, col, rowData);
      const formControlName: string = col.field;
      const formControl = this.field(formGroupIndex, formControlName);
      rowData[formControlName].isEditMode = formControl.invalid;
    }
  }

  /**
  * Range date selected
  */
  onDateRangeSelect(event, formGroupIndex: number, col, rowData: Object) {
    const formControlName: string = col.field;
    const formControl = this.field(formGroupIndex, formControlName);
    let hasError = false;
    if (col.minDate && formControl.value?.length) {
      const minDate = new Date(col.minDate);
      formControl.value?.map(date => {
        const inputValue = new Date(date);
        if (moment(moment(inputValue).format('YYYY-MM-DD')).isBefore(moment(minDate).format('YYYY-MM-DD'))) {
          hasError = true;
          formControl.setErrors({ invalid: true });
          rowData[formControlName].isEditMode = true;
        }
      });
      if (hasError) {
        return;
      } else {
        const errors = formControl.errors;
        if(errors) {
          if(errors?.hasOwnProperty('invalid')) {delete errors.invalid};
          formControl.setErrors(Object.keys(errors)?.length ? errors : null);
        }
      }
    } else {
      const errors = formControl.errors;
      if(errors) {
        if(errors?.hasOwnProperty('invalid')) {delete errors.invalid};
        formControl.setErrors(Object.keys(errors).length ? errors : null);
      }
    }
    if (formControl?.value && formControl?.value[0] && formControl?.value[1]) {
      if (col?.allowEqualDates === false && formControl?.value[0]?.toDateString() === formControl?.value[1]?.toDateString()) {
        formControl.setErrors({ 'datesEqual': true });
      } else {
        if (col?.dateFormat && col?.dateFormat === this.timeZoneTransformationService.getMappedConfigurationDateFormat(AppConfigurationService.settings?.dateFormat)) {
          const laycanFormat: IDateTimeFormatOptions = { customFormat: AppConfigurationService.settings?.dateFormat.split(' ')[0] };
          rowData[formControlName].value = this.timeZoneTransformationService.formatDateTime(formControl?.value[0], laycanFormat) + ' to ' + this.timeZoneTransformationService.formatDateTime(formControl?.value[1], laycanFormat);
        } else {
          rowData[formControlName].value = this.formatDateTime(formControl?.value[0]) + ' to ' + this.formatDateTime(formControl?.value[1]);
        }
        rowData[formControlName].isEditMode = this.onInputRange ? true : false;
        this.onInputRange = false;
        this.editComplete.emit({ originalEvent: event, data: rowData, index: formGroupIndex, field: formControlName });
      }
    }
    else if (formControl?.value && formControl?.value[0] && !formControl?.value[1]) {
      formControl.setErrors({ 'toDate': true });
    }
  }


  /**
  * Range date cleared
  */
  onClearDateRange(event, formGroupIndex: number, formControlName: string, rowData: Object) {
    const formControl = this.field(formGroupIndex, formControlName);
    rowData[formControlName].value = "";
    this.editComplete.emit({ originalEvent: event, data: rowData, index: formGroupIndex, field: formControlName });
  }

  /**
  * date time onblur
  */
  onBlurDateTime(event, formGroupIndex: number, formControlName: string, rowData: any, col: any){
    if(this.onInputTime){
      this.onDatePanelClosed(event, formGroupIndex, formControlName, rowData, col);
      const formControl = this.field(formGroupIndex, formControlName);
      rowData[formControlName].isEditMode = formControl?.invalid;
    }
  }

  /**
  * On closing Date panel
  */
  onDatePanelClosed(event, formGroupIndex: number, formControlName: string, rowData: any, col: any) {
    const formControl = this.field(formGroupIndex, formControlName);
    let hasError = false;
    if(col.minDate && formControl.value){
      const minDate = new Date(col.minDate);
      const inputValue = new Date(formControl.value);
      if(minDate.getTime() > inputValue.getTime()){
        hasError = true;
        formControl.setErrors({ invalid : true});
        rowData[formControlName].isEditMode = true;
        return;
      }
    } else {
      const errors = formControl.errors;
      if(errors) {
        if(errors?.hasOwnProperty('invalid')) {delete errors.invalid};
        formControl.setErrors(Object.keys(errors).length ? errors : null);
      }
    }
    if(!hasError){
      const errors = formControl.errors;
      if(errors) {
        if(errors?.hasOwnProperty('invalid')) {delete errors.invalid};
        formControl.setErrors(Object.keys(errors).length ? errors : null);
      }
    }
    const oldValue = rowData[formControlName].value;
    const newValue = formControl.value ? this.convertDT_PortBasedTimeZone(formControl.value, rowData.port.value?.timezoneOffsetVal, rowData.port.value?.timezoneAbbreviation) : null;
    rowData[formControlName].value = newValue;
    rowData[formControlName].isEditMode = this.onInputTime ? true : formControl?.invalid;
    this.onInputTime = false;
    if (oldValue !== newValue) {
      this.editComplete.emit({ originalEvent: event, data: rowData, index: formGroupIndex, field: formControlName });
    }
  }

  /**
  * Handler for row re order
  *
  * @memberof DatatableComponent
  */
  onRowReorder(event) {
    this.rowReorder.emit(event)
  }

  /**
   * Custom sort function
   *
   * @param {SortEvent} event
   * @memberof DatatableComponent
   */
  sortFunction(event: SortEvent) {
    event.data.sort((data1, data2) => {
      const value1 = ObjectUtils.resolveFieldData(data1, event?.field);
      const value2 = ObjectUtils.resolveFieldData(data2, event?.field);
      let result = null;
      if (value1 == null && value2 != null)
        result = -1;
      else if (value1 != null && value2 == null)
        result = 1;
      else if (value1 == null && value2 == null)
        result = 0;
      else if (typeof value1 === 'string' && typeof value2 === 'string')
        result = value1.localeCompare(value2);
      else
        result = (value1 < value2) ? -1 : (value1 > value2) ? 1 : 0;
      return (event?.order * result);
    });
    this.sort.emit(event);
  }

  /**
   * lazy loading for sorting
   * @param {LazyLoadEvent}  event
   */
  loadDetails(event: LazyLoadEvent) {
    if (event.sortField) {
      this._first = 0;
      this._currentPage = 0;
      this.currentPageChange.emit(this._currentPage);
      this.firstChange.emit(this._first);
      const data = this.setStateValue('sort');
      this.dataStateChange.emit(data);
    }
  }

  /**
   * Checks field disabled or not
   * @param formGroupIndex
   * @param formControlName
   */
  disabledField(formGroupIndex: number, formControlName: string) {
    const formControl = this.field(formGroupIndex, formControlName);
    return formControl.disabled;
  }

  /**
 * Get the total value of a column
 * @param col
 * @param index
 */
  getTotal(col: IDataTableColumn, index: number) {
    if (!index)
      return "Total"
    else if (col.showTotal && col.fieldType === this.fieldType.NUMBER) {
      let total = 0;
      const unit = col.unit ? col.unit : <QUANTITY_UNIT>localStorage.getItem('unit');
      this.filteredValue.forEach(row => {
        if (row[col.field]) {
          const value = row[col.field].value ?? 0;
          isNaN(Number(value)) ? total += 0 : total += Number(value)
        }
      })
      return total;
    }
    return ""
  }

  /**
   * Method to get rowspan
   *
   * @param {IDataTableColumn[]} columns
   * @param {*} filterable
   * @returns
   * @memberof DatatableComponent
   */
  getRowSpan(columns: IDataTableColumn[], filterable) {
    let rowSpan = filterable ? 1 : 0;
    columns.forEach(col => {
      rowSpan = rowSpan < col?.columns?.length ? col?.columns?.length : rowSpan;
    });

    return rowSpan;
  }

  /**
   * Method called on PageChange
   *
   * @returns
   * @memberof DatatableComponent
   */
  onPageChange(event) {
    const data = {
      paginator: {
        currentPage: event?.page ? event.page : 0,
        rows: event.rows ? event.rows : 0
      },
      filter: this.filterObject,
      action: 'paginator',
      sort: {
        sortField: this.datatable._sortField,
        sortOrder: this.datatable._sortField ? this.datatable._sortOrder === 1 ? 'asc' : 'desc' : '',
      }
    }
    this._first = event.first;
    this.firstChange.emit(this._first);
    this.currentPageChange.emit(event?.page ? event.page : 0)
    this.dataStateChange.emit(data);
  }

  /**
   * Method called on filter the data
   *
   * @returns
   * @memberof DatatableComponent
   */
  filterData($event, col, field) {
    this.filterObject[field] = ($event.target.value).trim();
    if (col?.filterByServer) {
      this._first = 0;
      this._currentPage = 0;
      const data = this.setStateValue('filter');
      this.firstChange.emit(this._first);
      this.currentPageChange.emit(this._currentPage);
      this.dataStateChange.emit(data);
    } else {
      this.datatable.filter(($event.target.value).trim(), field, col.filterMatchMode)
    }
  }

  /**
   * set state value for server side sorting
   *
   * @param {string} action
   * @memberof DatatableComponent
   */
  setStateValue(action: string) {
    return {
      paginator: {
        currentPage: this.paginatorRef.paginatorState.page ? this.paginatorRef.paginatorState.page : 0,
        rows: this.paginatorRef.paginatorState.rows
      },
      filter: this.filterObject,
      action: action,
      sort: {
        sortField: this.datatable._sortField,
        sortOrder: this.datatable._sortField ? this.datatable._sortOrder === 1 ? 'asc' : 'desc' : '',
      }
    }
  }

  /**
   * update current page
   *
   * @param {number} currentPage
   * @memberof DatatableComponent
   */
  private updateCurrentPage(currentPage: number): void {
    setTimeout(() => { this.paginatorRef.changePage(currentPage), this.currentPageChange.emit(currentPage) });
  }

  /**
   * function to convert date-time to port local
   *
   * @param {Date} dateTime
   * @param {number} portTimezoneId
   * @return {*}  {string}
   * @memberof PortRotationRibbonComponent
   */
  convertDT_PortBasedTimeZone(dateTime: Date | string, offsetValue: string, abbreviation?: string): any {
    if (dateTime && offsetValue && abbreviation) {
      const formatOptions: IDateTimeFormatOptions = {
        portLocalFormat: true,
        portTimeZoneOffset: offsetValue,
        portTimeZoneAbbr: abbreviation
      };
      const portAbbr = this.timeZoneTransformationService.formatDateTime(dateTime, formatOptions)?.slice(17);
      return moment(dateTime).format(AppConfigurationService.settings?.dateFormat) + portAbbr;
    } else {
      return moment(dateTime).format(AppConfigurationService.settings?.dateFormat);
    }
  }

   /**
   * get the label from multi slected array
   *
   * @param {any} multiSelectedArray
   * @param {string} fieldOptionLabel
   * @memberof DatatableComponent
   */
  getMultiselectedDataAsLabel(multiSelectedArray:any, fieldOptionLabel: string, maxSelectedLabels: number){
    if(multiSelectedArray?.length <= maxSelectedLabels) {
      return multiSelectedArray?.map(e => e[fieldOptionLabel]).join(",") ?? '';
    } else {
      return `${multiSelectedArray?.length} items selected`;
    }

  }

  /**
   * get the class for heading
   *
   * @param {any} col
   * @memberof DatatableComponent
   */
  getColumnCellClass(col){
    return (col.fieldType === 'NUMBER' ? ('text-right' + (col?.fieldColumnClass ? (' ' + col.fieldColumnClass) : '')) : col.fieldColumnClass );
  }

  /**
   * get the class for field
   *
   * @param {any} col
   * @param {any} rowData
   * @memberof DatatableComponent
   */
  getFieldCellClass(col, rowData){
    let className = '';
    if(col?.fieldClass){
      className = className + col?.fieldClass;
    }
    if(col.fieldType === 'NUMBER'){
      className = className + ' text-right';
    }
    if(col.fieldType === 'NUMBER' && (!this.editMode || !rowData[col.field]?.isEditMode)) {
      className = className + ' no-ediable-field';
    }
    return className;
  }

  /**
   * get the class for total field
   *
   * @param {any} col
   * @param {number} index
   * @memberof DatatableComponent
   */
  getFieldTotalClass(col, index){
    let clasName = '';
    if(this.showTotalClass && !index){
      clasName = this.showTotalClass;
    } else {
      clasName = 'text-right';
    }

    if(col.totalFieldClass){
      clasName = col.totalFieldClass + ' ' + clasName;
    }

    return clasName;
  }

}

