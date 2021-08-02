import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { DATATABLE_EDITMODE, IDataTableColumn } from '../../../shared/components/datatable/datatable.model';
import { ICargo, ILoadableQuantityCargo, OPERATIONS } from '../../core/models/common.model';
import { ILoadingDischargingDelays, ILoadingSequenceDropdownData, ILoadingDischargingSequences, ILoadingSequenceValueObject } from '../models/loading-discharging.model';
import { durationValidator } from '../validators/duration-validator.directive';
import { ConfirmationService } from 'primeng/api';
import { TranslateService } from '@ngx-translate/core';
import { LoadingCargoDuplicateValidator } from '../validators/loading-cargo-duplicate-validator.directive';
import { LoadingDischargingTransformationService } from '../services/loading-discharging-transformation.service';

/**
 * Component class for loading discharging manage sequence component
 *
 * @export
 * @class LoadingDischargingManageSequenceComponent
 * @implements {OnInit}
 */
@Component({
  selector: 'cpdss-portal-loading-discharging-manage-sequence',
  templateUrl: './loading-discharging-manage-sequence.component.html',
  styleUrls: ['./loading-discharging-manage-sequence.component.scss']
})
export class LoadingDischargingManageSequenceComponent implements OnInit {
  @Input() cargos: ICargo[];
  @Input() loadableQuantityCargo: ILoadableQuantityCargo[];
  @Input() operation: OPERATIONS;
  @Input() loadingInfoId: number;
  @Input() dischargingInfoId: number;

  @Input() get loadingDischargingSequences(): ILoadingDischargingSequences {
    return this._loadingDischargingSequences;
  }

  set loadingDischargingSequences(loadingDischargingSequences: ILoadingDischargingSequences) {
    this._loadingDischargingSequences = loadingDischargingSequences;
    if (this.loadingDischargingSequences) {
      this.initiLoadingDischargingSequenceArray();
    }
  }

  @Input() get editable(): boolean {
    return this._editable;
  }

  set editable(editable: boolean) {
    this._editable = editable;
  }

  @Output() updateLoadingDischargingDelays: EventEmitter<ILoadingDischargingDelays[]> = new EventEmitter();

  private _loadingDischargingSequences: ILoadingDischargingSequences;
  private _editable = true;

  loadingDischargingSequenceForm: FormGroup;
  columns: IDataTableColumn[];
  listData = <ILoadingSequenceDropdownData>{};
  cargoTobeLoaded: ILoadableQuantityCargo[];
  loadingDischargingDelays: ILoadingSequenceValueObject[] = [];
  editMode: DATATABLE_EDITMODE = DATATABLE_EDITMODE.CELL;
  loadingDischargingDelayList: ILoadingDischargingDelays[];
  addInitialDelay = false;
  constructor(
    private confirmationService: ConfirmationService,
    private translateService: TranslateService,
    private fb: FormBuilder,
    private loadingDischargingTransformationService: LoadingDischargingTransformationService) { }

  async ngOnInit(): Promise<void> {
    this.columns = this.loadingDischargingTransformationService.getLoadingDischargingDelayDatatableColumns();
    await this.initiLoadingDischargingSequenceArray();
  }

  /**
  * Method for init loading sequence array
  *
  * @memberof LoadingDischargingManageSequenceComponent
  */
  async initiLoadingDischargingSequenceArray() {
    this.listData = await this.getDropdownData();
    this.listData.reasonForDelays = this.loadingDischargingSequences.reasonForDelays;
    const initialDelay = this.loadingDischargingSequences.loadingDischargingDelays?.find(loadingDischargingDelay => !loadingDischargingDelay.cargoId && !loadingDischargingDelay.quantity)
    if (initialDelay) {
      this.loadingDischargingSequences.loadingDischargingDelays = this.loadingDischargingSequences.loadingDischargingDelays?.filter(loadingDischargingDelay => loadingDischargingDelay?.cargoId && loadingDischargingDelay?.quantity);
      this.loadingDischargingSequences.loadingDischargingDelays.unshift(initialDelay)
    }
    const _loadingDischargingDelays = this.loadingDischargingSequences.loadingDischargingDelays?.map((loadingDischargingDelay) => {
      const loadingSequenceData = this.loadingDischargingTransformationService.getLoadingDischargingDelayAsValueObject(loadingDischargingDelay, false, this.editable, this.listData);
      if (!loadingDischargingDelay.cargoId && !loadingDischargingDelay.quantity) {
        this.addInitialDelay = true;
      }
      return loadingSequenceData;
    });
    const loadingDischargingDelayArray = _loadingDischargingDelays?.map((loadingDischargingDelay, index) =>
      this.initLoadingDischargingSequenceFormGroup(loadingDischargingDelay, index, false)
    );
    this.loadingDischargingDelays = _loadingDischargingDelays;
    this.loadingDischargingSequenceForm = this.fb.group({
      dataTable: this.fb.array([...loadingDischargingDelayArray])
    });
  }

  /**
  * Get all lookups for loading sequence screen
  *
  * @returns {Promise<ILoadingSequenceDropdownData>}
  * @memberof LoadingDischargingManageSequenceComponent
  */
  async getDropdownData(): Promise<ILoadingSequenceDropdownData> {
    const cargoTobeLoaded = this.loadableQuantityCargo?.map(loadable => {
      if (loadable) {
        loadable.grade = this.findCargo(loadable);
      }
      return loadable;
    })
    this.listData = <ILoadingSequenceDropdownData>{};
    this.listData.loadableQuantityCargo = cargoTobeLoaded;
    return this.listData;
  }



  /**
   * Method to find out cargo
   *
   * @memberof LoadingDischargingManageSequenceComponent
   */
  findCargo(loadableQuantityCargoDetails): string {
    let cargoDetail;
    this.cargos?.map((cargo) => {
      if (cargo.id === loadableQuantityCargoDetails?.cargoId) {
        cargoDetail = cargo;
      }
    })
    return cargoDetail?.name;
  }

  /**
  * Method for initializing loading sequence row
  *
  * @private
  * @param {ILoadingSequenceValueObject} loadingDischargingDelay
  * @returns
  * @memberof LoadingDischargingManageSequenceComponent
  */
  initLoadingDischargingSequenceFormGroup(loadingDischargingDelay: ILoadingSequenceValueObject, index: number, initialDelay: boolean) {
    return this.fb.group({
      id: loadingDischargingDelay.id,
      reasonForDelay: this.fb.control(loadingDischargingDelay.reasonForDelay.value, [Validators.required]),
      duration: this.fb.control(loadingDischargingDelay.duration.value, [Validators.required, durationValidator(24, 59)]),
      cargo: this.fb.control(loadingDischargingDelay.cargo.value, initialDelay ? [] : [Validators.required, LoadingCargoDuplicateValidator(index)]),
      quantity: this.fb.control(loadingDischargingDelay.quantity, initialDelay ? [] : [Validators.required]),
      colorCode: this.fb.control(loadingDischargingDelay.colorCode)
    })
  }


  /**
   * Method for adding new port
   *
   * @private
   * @memberof LoadingDischargingManageSequenceComponent
   */
  addLoadingDischargingSequence(loadingDischargingDelay: ILoadingDischargingDelays = null) {
    loadingDischargingDelay = loadingDischargingDelay ?? <ILoadingDischargingDelays>{ id: 0, loadingInfoId: null, dischargingInfoId: null, reasonForDelayId: null, duration: null, cargoId: null, quantity: null };
    const _loadingDischargingDelays = this.loadingDischargingTransformationService.getLoadingDischargingDelayAsValueObject(loadingDischargingDelay, true, true, this.listData);
    const dataTableControl = <FormArray>this.loadingDischargingSequenceForm.get('dataTable');
    dataTableControl.push(this.initLoadingDischargingSequenceFormGroup(_loadingDischargingDelays, this.loadingDischargingDelays.length, false));
    this.loadingDischargingDelays = [...this.loadingDischargingDelays, _loadingDischargingDelays];

  }

  /**
   * Event handler for edit complete event
   *
   * @memberof LoadingDischargingManageSequenceComponent
   */
  onEditComplete(event) {
    const index = event.index;
    const form = this.row(index);
    if (event.field === 'cargo') {
      this.loadingDischargingDelays[index]['quantity'] = event.data.cargo.value.loadableMT;
      this.loadingDischargingDelays[index]['colorCode'] = event.data.cargo.value.colorCode;
      this.updateField(index, 'quantity', event.data.cargo.value.loadableMT);
      this.updateField(index, 'colorCode', event.data.cargo.value.colorCode);
    }
    if (form.valid) {
      const loadingDischargingDelaysList = this.loadingDischargingTransformationService.getLoadingDischargingDelayAsValue(this.loadingDischargingDelays, this.operation === OPERATIONS.LOADING ? this.loadingInfoId : this.dischargingInfoId, this.operation)
      this.updateLoadingDischargingDelays.emit(loadingDischargingDelaysList);
      for (const key in this.loadingDischargingDelays[index]) {
        if (this.loadingDischargingDelays[index]?.hasOwnProperty(key) && this.loadingDischargingDelays[index][key]?.hasOwnProperty('_isEditMode')) {
          this.loadingDischargingDelays[index][key].isEditMode = false;
        }
      }
    }
  }

  /**
  * Method for fetching form group
  *
  * @private
  * @param {number} formGroupIndex
  * @returns {FormGroup}
  * @memberof LoadingDischargingManageSequenceComponent
  */
  private row(formGroupIndex: number): FormGroup {
    const formGroup = <FormGroup>(<FormArray>this.loadingDischargingSequenceForm.get('dataTable')).at(formGroupIndex);
    return formGroup;
  }

  /**
  * Method for add initial delay
  *
  * @private
  * @memberof LoadingDischargingManageSequenceComponent
  */
  onAddInitialDelay(loadingDischargingDelay: ILoadingDischargingDelays = null) {
    const dataTableControl = <FormArray>this.loadingDischargingSequenceForm.get('dataTable');
    if (this.addInitialDelay) {
      loadingDischargingDelay = loadingDischargingDelay ?? <ILoadingDischargingDelays>{ id: 0, loadingInfoId: null, dischargingInfoId: null, reasonForDelayId: null, duration: null, cargoId: null, quantity: null };
      const _loadingDischargingDelays = this.loadingDischargingTransformationService.getLoadingDischargingDelayAsValueObject(loadingDischargingDelay, true, !this.addInitialDelay, this.listData);
      dataTableControl.insert(0, this.initLoadingDischargingSequenceFormGroup(_loadingDischargingDelays, this.loadingDischargingDelays.length, true));
      this.loadingDischargingDelays = [_loadingDischargingDelays, ...this.loadingDischargingDelays];
    } else {
      this.loadingDischargingDelays.splice(0, 1);
      dataTableControl.removeAt(0);
    }
  }

  /**
  * Method for delete row
  *
  * @private
  * @param {event} event
  * @memberof LoadingDischargingManageSequenceComponent
  */
  async onDelete(event) {
    const translationKeys = await this.translateService.get(['LOADING_MANAGE_SEQUENCE_DELETE_SUMMARY', 'LOADING_MANAGE_SEQUENCE_DELETE_CONFIRM_DETAILS', 'LOADING_MANAGE_SEQUENCE_DELETE_CONFIRM_LABEL', 'LOADING_MANAGE_SEQUENCE_DELETE_REJECT_LABEL']).toPromise();
    if (!event?.data?.isAdd) {
      this.confirmationService.confirm({
        key: 'confirmation-alert',
        header: translationKeys['LOADING_MANAGE_SEQUENCE_DELETE_SUMMARY'],
        message: translationKeys['LOADING_MANAGE_SEQUENCE_DELETE_CONFIRM_DETAILS'],
        icon: 'pi pi-exclamation-triangle',
        acceptLabel: translationKeys['LOADING_MANAGE_SEQUENCE_DELETE_CONFIRM_LABEL'],
        acceptIcon: 'pi',
        acceptButtonStyleClass: 'btn btn-main mr-5',
        rejectVisible: true,
        rejectLabel: translationKeys['LOADING_MANAGE_SEQUENCE_DELETE_REJECT_LABEL'],
        rejectIcon: 'pi',
        rejectButtonStyleClass: 'btn btn-main',
        accept: async () => {
          await this.removeFromLoadingDelay(event);
        },
      });
    }
    else {
      await this.removeFromLoadingDelay(event);
    }
  }

  /**
   * Method to remove loading delay from list
   *
   * @param {*} event
   * @memberof LoadingDischargingManageSequenceComponent
   */
  async removeFromLoadingDelay(event) {
    this.loadingDischargingDelays.splice(event.index, 1);
    this.loadingDischargingDelays = [...this.loadingDischargingDelays];
    const dataTableControl = <FormArray>this.loadingDischargingSequenceForm.get('dataTable');
    dataTableControl.removeAt(event?.index);
    if (!event.data.isAdd) {
      const loadingDelaysList = this.loadingDischargingTransformationService.getLoadingDischargingDelayAsValue(this.loadingDischargingDelays, this.operation === OPERATIONS.LOADING ? this.loadingInfoId : this.dischargingInfoId, this.operation);
      this.updateLoadingDischargingDelays.emit(loadingDelaysList);
    }
    if (event.index === 0) {
      this.addInitialDelay = false;
    }
  }

  /**
  * Method for updating form field
  *
  * @private
  * @param {number} index
  * @param {string} field
  * @param {*} value
  * @memberof LoadingDischargingManageSequenceComponent
  */
  private updateField(index: number, field: string, value?: any) {
    const control = this.field(index, field);
    control.setValue(value);
    control.markAsDirty();
    control.markAsTouched();
  }

  /**
   * Method for fetching form fields
   *
   * @private
   * @param {number} formGroupIndex
   * @param {string} formControlName
   * @returns {FormControl}
   * @memberof LoadingDischargingManageSequenceComponent
   */
  private field(formGroupIndex: number, formControlName: string): FormControl {
    const formControl = <FormControl>(<FormArray>this.loadingDischargingSequenceForm.get('dataTable')).at(formGroupIndex).get(formControlName);
    return formControl;
  }


}
