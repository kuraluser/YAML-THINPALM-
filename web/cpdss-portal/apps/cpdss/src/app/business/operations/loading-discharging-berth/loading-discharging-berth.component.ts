import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { numberValidator } from '../../core/directives/number-validator.directive';
import { IBerth } from '../models/loading-information.model';
import { LoadingDischargingBerthTransformationService } from './loading-discharging-berth-transformation.service';

/**
 * Component class for loading discharging berth component
 *
 * @export
 * @class LoadingDischargingBerthComponent
 * @implements {OnInit}
 */
@Component({
  selector: 'cpdss-portal-loading-discharging-berth',
  templateUrl: './loading-discharging-berth.component.html',
  styleUrls: ['./loading-discharging-berth.component.scss']
})
export class LoadingDischargingBerthComponent implements OnInit {
  @Input() editMode = true;
  @Input() loadingInfoId: number;
  @Input() availableBerths: IBerth[];
  @Input() selectedBerths: IBerth[];
  @Output() berthChange: EventEmitter<IBerth[]> = new EventEmitter();
  berthDetailsForm: FormGroup;
  berthForm: FormGroup;
  berthFormArray: FormArray;
  selectedIndex: number;
  errorMesages: any;

  get berths(): FormArray {
    return this.berthForm.get("berth") as FormArray
  }

  constructor(
    private fb: FormBuilder,
    private loadingDischargingBerthTransformationService: LoadingDischargingBerthTransformationService
  ) { }

  ngOnInit(): void {
    this.errorMesages = this.loadingDischargingBerthTransformationService.setValidationErrorMessage();
    this.availableBerths = this.availableBerths.map(berth => {
      const found = this.selectedBerths.find(selectedBerth => selectedBerth.berthId === berth.berthId);
      if (found) {
        found.berthName = berth.berthName;
      }
      return found ?? berth;
    });
    this.berthForm = this.fb.group({
      berth: this.fb.array([])
    });
    this.berthDetailsForm = this.fb.group({
      berthId: 0,
      berthName: '',
      maxShipDepth: '',
      hoseConnections: this.fb.control('', [Validators.maxLength(100)]),
      seaDraftLimitation: this.fb.control(null, [numberValidator(4, 2)]),
      airDraftLimitation: this.fb.control('', [numberValidator(4, 2)]),
      maxManifoldHeight: this.fb.control('', [numberValidator(4, 2)]),
      regulationAndRestriction: this.fb.control('', [Validators.maxLength(500)]),
      itemsToBeAgreedWith: '',
      loadingInfoId: '',
      maxShpChannel: '',
      loadingBerthId: 0,
      maxLoa: '',
      maxDraft: '',
    });
    this.berthDetailsForm.disable();
    this.initFormArray();
  }

  /**
 * Return the form controlls of the berth details form
 */
  get berthDetailsFormComtrol() {
    return this.berthDetailsForm.controls;
  }

  /**
* initialise berth details form
*/
  initFormArray() {
    if (this.selectedBerths.length > 0) {
      this.selectedBerths = this.selectedBerths.map((berth) => {
        const foundedBerth = this.availableBerths.find((availBerth) => availBerth.berthId === berth.berthId);
        berth.berthName = foundedBerth.berthName;
        return berth;
      })
      this.selectedBerths.forEach((selectedBerth) => {
        this.addBerth(selectedBerth);
      })
      this.setBerthDetails(this.selectedBerths[0])
      this.selectedIndex = 0;
    }

  }

  /**
  * Metgod for adding new berth form
  *
  * @memberof LoadingDischargingBerthComponent
  */
  createBerth(berth: IBerth): FormGroup {
    return this.fb.group({
      name: [berth],
      edit: berth ? false : true
    });
  }

  /**
  * Change value
  *
  * @memberof LoadingDischargingBerthComponent
  */
  change(field) {
    if (this.berthDetailsForm.value[field]) {
      this.selectedBerths.map((berth) => {
        if (berth.berthId === this.berthDetailsForm.value.id) {
          berth[field] = this.berthDetailsForm.value[field];
        }
        return berth;
      })
      this.berthChange.emit(this.selectedBerths);
    }

  }
  clearFilter(data) {

  }

  /**
   * Add new berth
   *
   * @memberof LoadingDischargingBerthComponent
   */
  addBerth(berth: IBerth) {
    this.berthFormArray = this.berthForm.get('berth') as FormArray;
    this.berthFormArray.push(this.createBerth(berth));
  }

  /**
   * Berth change 
   * @param {Event}
   * @memberof LoadingDischargingBerthComponent
   */
  onBerthChange(event, index) {
    const duplicate = this.selectedBerths.some((berth) => berth?.berthId === event?.value?.berthId)
    if (duplicate) {
      const formControl = this.field(index, 'name');
      formControl.setErrors({ duplicateBerth: true });
    } else {
      this.selectedBerths.push(event.value)
      this.setBerthDetails(event.value);
      this.selectedBerths = this.selectedBerths.map((berth) => {
        if (!berth.loadingBerthId) {
          berth.loadingBerthId = 0;
        }
        return berth;
      })
      this.berthFormArray.at(index).patchValue({
        edit: false
      })
      this.berthChange.emit(this.selectedBerths);
    }

  }

  /**
   * choose berth 
   * @param berth
   * @memberof LoadingDischargingBerthComponent
   */
  selectBerth(berth, index) {
    this.selectedIndex = index;
    this.setBerthDetails(berth.value.name);
  }

  /**
   * Assign values for berth display
   * @param berthInfo
   * @memberof LoadingDischargingBerthComponent
   */
  setBerthDetails(berthInfo: IBerth) {
    this.berthDetailsForm.enable();
    this.berthDetailsForm.patchValue({
      id: berthInfo.berthId,
      portId: berthInfo.portId,
      berthName: berthInfo.berthName,
      maxShipDepth: berthInfo.maxShipDepth,
      hoseConnections: berthInfo.hoseConnections,
      seaDraftLimitation: berthInfo.seaDraftLimitation,
      airDraftLimitation: berthInfo.airDraftLimitation,
      maxManifoldHeight: berthInfo.maxManifoldHeight,
      regulationAndRestriction: berthInfo.regulationAndRestriction,
      itemsToBeAgreedWith: berthInfo.itemsToBeAgreedWith,
      loadingInfoId: berthInfo.loadingInfoId,
      maxShpChannel: berthInfo.maxShpChannel,
      loadingBerthId: berthInfo.loadingBerthId ? berthInfo.loadingBerthId : 0,
      maxLoa: berthInfo.maxLoa,
      maxDraft: berthInfo.maxDraft
    });
  }

  /**
   * edit berth info
   * @param berth
   * @memberof LoadingDischargingBerthComponent
   */
  editBerth(index) {
    this.berthFormArray.at(index).patchValue({
      edit: true
    })
  }

  /**
   * Remove berth info
   * @param berth
   * @memberof LoadingDischargingBerthComponent
   */
  deleteBerth(event, index: number) {
    this.selectedBerths = this.selectedBerths?.filter((berth) => berth.berthId !== event.value.name.berthId) ?? [];
    this.berths.removeAt(index);
    if (this.selectedBerths?.length > 0) {
      this.setBerthDetails(this.selectedBerths[0])
    } else {
      this.berthDetailsForm.reset();
      this.berthDetailsForm.disable();
    }
    this.berthChange.emit(this.selectedBerths);
  }

  /**
  * Get form control of form
  *
  * @param {number} formGroupIndex
  * @param {string} formControlName
  * @returns {FormControl}
  * @memberof LoadingDischargingBerthComponent
  */
  field(formGroupIndex: number, formControlName: string): FormControl {
    const formControl = <FormControl>(<FormArray>this.berthForm.get('berth')).at(formGroupIndex).get(formControlName);
    return formControl;
  }


}
