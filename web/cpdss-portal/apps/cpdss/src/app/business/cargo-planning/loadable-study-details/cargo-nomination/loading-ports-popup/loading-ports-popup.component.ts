import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { TranslateService } from '@ngx-translate/core';
import { ConfirmationService, MessageService } from 'primeng/api';
import { DATATABLE_EDITMODE, IDataTableColumn, IDataTableEvent } from '../../../../../shared/components/datatable/datatable.model';
import { numberValidator } from '../../../../core/directives/number-validator.directive';
import { ILoadingPort, ILoadingPortValueObject, ILoadingPopupData } from '../../../models/cargo-planning.model';
import { LoadableStudyDetailsTransformationService } from '../../../services/loadable-study-details-transformation.service';
import { IPortList, LOADABLE_STUDY_STATUS, Voyage, VOYAGE_STATUS } from '../../../../core/models/common.model';
import { IPermission } from '../../../../../shared/models/user-profile.model';
import { LoadableStudy } from '../../../models/loadable-study-list.model';
import { QuantityDecimalService } from '../../../../../shared/services/quantity-decimal/quantity-decimal.service';

/**
 * Component class for loading ports popup
 *
 * @export
 * @class LoadingPortsPopupComponent
 * @implements {OnInit}
 */
@Component({
  selector: 'cpdss-portal-loading-ports-popup',
  templateUrl: './loading-ports-popup.component.html',
  styleUrls: ['./loading-ports-popup.component.scss']
})
export class LoadingPortsPopupComponent implements OnInit {

  @Input()
  get visible(): boolean {
    return this._visible;
  }
  set visible(visible: boolean) {
    this._visible = visible;
  }

  @Input() voyage: Voyage;

  @Input() permission: IPermission;

  @Input()
  get loadableStudy() {
    return this._loadableStudy;
  }
  set loadableStudy(value: LoadableStudy) {
    this._loadableStudy = value;
    this.editMode = (this.permission?.edit === undefined || this.permission?.edit) && [LOADABLE_STUDY_STATUS.PLAN_PENDING, LOADABLE_STUDY_STATUS.PLAN_NO_SOLUTION, LOADABLE_STUDY_STATUS.PLAN_ERROR].includes(this.loadableStudy?.statusId) && ![VOYAGE_STATUS.CLOSE].includes(this.voyage?.statusId) && !this.voyage?.isDischargeStarted ? DATATABLE_EDITMODE.CELL : null;
  }

  @Input()
  get popupData(): ILoadingPopupData {
    return this._popupData;
  }
  set popupData(popupData: ILoadingPopupData) {
    this._popupData = popupData;
    this.ports = this.popupData.ports;
    this.loadingPort = popupData.rowData.loadingPorts.value ? [...popupData.rowData.loadingPorts.value].reverse().map(port => this.loadableStudyDetailsTransformationService.getCargoNominationLoadingPortAsValueObject(port, false)) : [];
    this.updatePorts(popupData);
    const loadingPortArray = this.loadingPort.map(port => this.initLoadingPortFormGroup(port));
    this.loadingPortsFrom = this.fb.group({
      dataTable: this.fb.array([...loadingPortArray], Validators.required),
      addPort: this.fb.control(null)
    });
  }

  @Output() visibleChange = new EventEmitter<boolean>();
  @Output() popupDataChange = new EventEmitter<ILoadingPopupData>();
  @Output() portOhqTabStatusUpdate = new EventEmitter<boolean>();

  loadingPortsFrom: FormGroup;
  columns: IDataTableColumn[];
  loadingPort: ILoadingPortValueObject[];
  ports: IPortList[];
  editMode: DATATABLE_EDITMODE;

  private _popupData: ILoadingPopupData;
  private _visible: boolean;
  private _loadableStudy: LoadableStudy;

  constructor(private fb: FormBuilder,
    private loadableStudyDetailsTransformationService: LoadableStudyDetailsTransformationService,
    private messageService: MessageService,
    private translateService: TranslateService,
    private confirmationService: ConfirmationService,
    private quantityDecimalService: QuantityDecimalService) { }

  ngOnInit(): void {
    this.columns = this.loadableStudyDetailsTransformationService.getCargoNominationLoadingPortDatatableColumns(this.permission, this.loadableStudy?.statusId, this.voyage);
  }

  /**
   * Method for closing loading ports popup
   *
   * @memberof LoadingPortsPopupComponent
   */
  closePopup() {
    this.loadingPort = null;
    this.visible = false;
    this.visibleChange.emit(this.visible);
  }

  /**
   * Method for adding new port
   *
   * @param {ILoadingPort} port
   * @memberof LoadingPortsPopupComponent
   */
  addPort(port: ILoadingPort) {
    port.quantity = null;
    const loadingPort: ILoadingPortValueObject = this.loadableStudyDetailsTransformationService.getCargoNominationLoadingPortAsValueObject(port);
    this.loadingPort = [loadingPort, ...this.loadingPort];
    const dataTableControl = <FormArray>this.loadingPortsFrom.get('dataTable');
    dataTableControl.insert(0, this.initLoadingPortFormGroup(loadingPort));
    this.loadingPortsFrom.get('addPort').setValue(null);
    this.updatePorts(this.popupData);
  }

  /**
   * Update ports dropdown list
   *
   * @param {ILoadingPopupData} popupData
   * @memberof LoadingPortsPopupComponent
   */
  updatePorts(popupData: ILoadingPopupData) {
    popupData.ports = this.ports?.filter(port => !this.loadingPort?.some(lport => lport.id === port.id));
  }

  /**
   * Event handler for filed edit complete evnt
   *
   * @param {IDataTableEvent} event
   * @memberof LoadingPortsPopupComponent
   */
  onEditComplete(event: IDataTableEvent) {
    this.updatePorts(this.popupData);
  }

  /**
   *
   *
   * @param {IDataTableEvent} event
   * @memberof LoadingPortsPopupComponent
   */
  async onDeleteRow(event: IDataTableEvent) {
    const translationKeys = await this.translateService.get(['LOADED_PORT_DELETE_SUMMARY', 'LOADED_PORT_DELETE_DETAILS', 'LOADED_PORT_DELETE_CONFIRM_LABEL', 'LOADED_PORT_DELETE_REJECT_LABEL']).toPromise();

    this.confirmationService.confirm({
      key: 'confirmation-alert',
      header: translationKeys['LOADED_PORT_DELETE_SUMMARY'],
      message: translationKeys['LOADED_PORT_DELETE_DETAILS'],
      icon: 'pi pi-exclamation-triangle',
      acceptLabel: translationKeys['LOADED_PORT_DELETE_CONFIRM_LABEL'],
      acceptIcon: 'pi',
      acceptButtonStyleClass: 'btn btn-main mr-5',
      rejectVisible: true,
      rejectLabel: translationKeys['LOADED_PORT_DELETE_REJECT_LABEL'],
      rejectIcon: 'pi',
      rejectButtonStyleClass: 'btn btn-main',
      accept: () => {
        this.loadingPort.splice(event.index, 1);
        const dataTableControl = <FormArray>this.loadingPortsFrom.get('dataTable');
        dataTableControl.removeAt(event.index);
        this.updatePorts(this.popupData);
      }
    });
  }

  /**
   * Method for save popup
   *
   * @param {IDataTableEvent} event
   * @memberof LoadingPortsPopupComponent
   */
  async savePopup() {
    if (this.loadingPortsFrom.valid) {
      this.popupData.isUpdate = true;
      this.popupData.rowData.loadingPorts.value = this.loadingPort?.reverse().map(port => this.loadableStudyDetailsTransformationService.getCargoNominationLoadingPortAsValue(port));
      this.popupDataChange.emit(this.popupData);
      if (this.checkNewPortOccured()) {
        this.portOhqTabStatusUpdate.emit(false);
      }
      this.closePopup();
    } else {
      if (this.loadingPortsFrom.controls.dataTable?.errors?.required) {
        const translationKeys = await this.translateService.get(['CARGO_NOMINATION_LOADING_PORT_REQUIRED_ERROR_DETAILS', 'CARGO_NOMINATION_LOADING_PORT_REQUIRED_ERROR']).toPromise();
        this.messageService.add({ severity: 'error', summary: translationKeys['CARGO_NOMINATION_LOADING_PORT_REQUIRED_ERROR'], detail: translationKeys['CARGO_NOMINATION_LOADING_PORT_REQUIRED_ERROR_DETAILS'] });
      }

      this.loadingPortsFrom.markAllAsTouched();
      this.loadingPortsFrom.updateValueAndValidity();
    }

  }

  /**
   *
   * Method for initialiing loading ports form
   * @private
   * @param {ILoadingPortValueObject} loadingPort
   * @returns
   * @memberof LoadingPortsPopupComponent
   */
  private initLoadingPortFormGroup(loadingPort: ILoadingPortValueObject) {
    const quantityDecimal = this.quantityDecimalService.quantityDecimal();
    const min = quantityDecimal ? (1/Math.pow(10, quantityDecimal)) : 1;
    return this.fb.group({
      name: this.fb.control(loadingPort.name.value, Validators.required),
      sequenceNumber: this.fb.control(loadingPort?.sequenceNumber),
      quantity: this.fb.control(loadingPort.quantity.value, [Validators.required, Validators.min(min), numberValidator(quantityDecimal, 7, false)])
    });
  }

  /**
   * function to check new loading port occured
   * @return {*}  {boolean}
   * @memberof LoadingPortsPopupComponent
   */
  checkNewPortOccured(): boolean {
    const isNewPort = this.loadingPort.some(port => (!this.popupData.loadableStudyPorts.includes(port.id)));
    return isNewPort;
  }

}
