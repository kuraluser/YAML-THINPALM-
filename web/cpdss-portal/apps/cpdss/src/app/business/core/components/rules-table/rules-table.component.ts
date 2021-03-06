import { Component, EventEmitter, Input, OnChanges, OnDestroy, OnInit, Output, SimpleChanges , HostListener } from '@angular/core';
import { Observable } from 'rxjs';
import { FormArray, FormControl, FormGroup, ValidationErrors, Validators } from '@angular/forms';
import { TranslateService } from '@ngx-translate/core';
import { IValidationErrorMessages } from '../../../../shared/components/validation-error/validation-error.model';
import { MessageService } from 'primeng/api';
import { Subject } from 'rxjs';
import { takeUntil } from 'rxjs/operators';
import { RULE_TYPES } from '../../models/rules.model'
import { numberValidator } from '../../../core/directives/number-validator.directive'
import { RulesValidator } from '../../../core/directives/rules-validator-directive'
import { NgxSpinnerService } from 'ngx-spinner';
import { UnsavedChangesGuard } from '../../../../shared/services/guards/unsaved-data-guard';
import { IVessel } from '../../models/vessel-details.model';
import { VesselsApiService } from '../../services/vessels-api.service';

/**
 * Component Class for Rules Table
 *
 * @export
 * @class RulesTableComponent
 * @implements {OnInit}
 */
@Component({
  selector: 'cpdss-portal-rules-table',
  templateUrl: './rules-table.component.html',
  styleUrls: ['./rules-table.component.scss']
})
export class RulesTableComponent implements OnInit, OnDestroy, OnChanges {

  selectedTab = 'plan';
  data = 'plan';
  tabIndex = 1;
  ngUnsubscribe: Subject<void> = new Subject();
  adminRules;
  ruleTypes = [
    { value: RULE_TYPES.ABSOLUTE },
    { value: RULE_TYPES.PREFERRABLE }
  ]
  columns = [
    { header: "" },
    { header: "Rule Type" },
    { header: "Enable/Disable" }
  ];
  error = [];
  errorProperty: any;
  selectedValueForRadio = []
  rulesForm: FormArray = new FormArray([])
  errorMessages: IValidationErrorMessages = {
    'required': 'RULES_REQUIRED',
    'invalidNumber': 'RULES_INVALID'
  }
  selectedIndex = 0;
  @Input() rulesJson;
  @Input() rulesService;
  @Input() displaySettings = true;
  @Input() editMode = true;
  @Output() isSaveClicked: EventEmitter<any> = new EventEmitter();
  @Output() formChanges: EventEmitter<any> = new EventEmitter();
  @Input() isCancelChanges = false;
  @Input() pageName = "Admin"

  rulesFormTemp: any;
  rules: any;
  vessels: IVessel[];

  @HostListener('window:beforeunload')
  canDeactivate(): Observable<boolean> | boolean {
    return !(this.rulesForm?.dirty);
  }

  constructor(private translateService: TranslateService,
    private messageService: MessageService, private ngxSpinner: NgxSpinnerService,
    private unsavedChangesGuard: UnsavedChangesGuard, private vesselsApiService: VesselsApiService) { }

  /**
  * Component lifecycle ngOnInit
  *
  * @returns {Promise<void>}
  * @memberof RulesTableComponent
  */
  async ngOnInit(): Promise<void> {
    this.ngxSpinner.show();
    this.vessels = await this.vesselsApiService.getVesselsInfo(true).toPromise();
    this.showHideDisplaySetttingsColumn();
    this.initActionSubscriptions();
    this.setIndex(this.selectedIndex);
    this.initForm();
    this.disableForm();
    this.checkForFormValueChanges();
    if (this.rulesJson && this.rulesJson[this.data] && this.rulesJson[this.data][this.selectedIndex])
      this.rules = this.rulesJson[this.data][this.selectedIndex].rules;
    this.ngxSpinner.hide();
  }

  /**
   * Method to show/hide DisplaySettings column
   *
   * @memberof RulesTableComponent
   */
  showHideDisplaySetttingsColumn() {
    if (this.displaySettings) {
      this.columns.unshift({ header: "Display in Rules" });
    }
  }

  /**
   * Component lifecycle ngonchanges.
   *
   * @param {SimpleChanges} changes
   * @memberof RulesTableComponent
   */
  ngOnChanges(changes: SimpleChanges) {
    this.ngxSpinner.show();
    this.resetForm(changes);
    this.ngxSpinner.hide();
  }


  /**
   * Method to reset form when cancel changes button is clicked.
   *
   * @param {*} changes
   * @memberof RulesTableComponent
   */

  resetForm(changes) {
    if (changes?.isCancelChanges?.currentValue) {
      this.initForm();
      this.disableForm();
      this.error.length = 0;
    }
    if (changes?.rulesJson) {

      this.initForm();
      this.selectedIndex = 0;
      this.error=[];

      this.rulesJson[this.data] = changes?.rulesJson?.currentValue?.plan;
      if (this.rulesJson[this.data]?.length > 0) {
        this.rules = this.rulesJson[this.data][this.selectedIndex].rules;
        this.disableForm();
      }
    }
  }

  /**
   * Method to check whether values of form has changed.
   *
   * @memberof RulesTableComponent
   */

  checkForFormValueChanges() {
    console.log("checkForFormValueChanges")
    if (this.rulesForm.dirty) {
      this.formChanges.emit(true);
    }
  }


  /**
   * Method to set index.
   *
   * @param {*} index
   * @memberof RulesTableComponent
   */
  async setIndex(index: any) {
    this.selectedIndex = index;
    this.setRules();
  }


  /**
   * Method to set rules.
   *
   * @memberof RulesTableComponent
   */

  setRules() {
    if (!this.rulesJson[this.data]) {
      this.rules = [];
    }
    else {
      if (this.rulesJson[this.data]?.length > 0) {
        this.rules = this.rulesJson[this.data][this.selectedIndex].rules;
      }
    }
  }

  /**
   * Method to set tab errors.
   *
   * @param {*} index
   * @memberof RulesTableComponent
   */
  setTabError(index: any) {
    if (!this.rulesForm?.controls[index]?.valid && this.rulesForm?.controls[index]?.touched) {
      this.error[index] = true;
    }
    else {
      this.error[index] = false;
    }
  }


  /**
  * Component lifecycle ngOnDestroy
  *
  * @returns {Promise<void>}
  * @memberof RulesTableComponent
  */
  ngOnDestroy() {
    this.ngUnsubscribe.next();
    this.ngUnsubscribe.complete();
  }


  /**
   * Method to init all action subscriptions
   *
   * @returns {void}
   * @memberof RulesTableComponent
   */
  initActionSubscriptions() {
    this.rulesService.save
      .pipe(takeUntil(this.ngUnsubscribe))
      .subscribe(() => {
        this.saveChanges()
      })
  }

  /**
  * Method to save changes
  *
  * @returns {void}
  * @memberof RulesTableComponent
  */
  async saveChanges() {
    for (let i = 0; i < this.rulesForm.controls.length; i++) {
      if (!this.rulesForm.controls[i].disabled) {
        this.rulesForm.controls[i].markAllAsTouched();
        this.setTabError(i);
      }
    }
    const isError = this.error.find(err => err === true);
    if (!isError) {
      for (let index = 0; index < this.rulesForm.controls.length; index++) {
        for (let j = 0; j < this.rulesForm.controls[index]['controls'].length; j++) {
          const controls = this.rulesForm.controls[index]['controls'][j];
          for (const t in controls["controls"]["inputs"].controls) {
            if (this.rulesJson[this.data][index] && this.rulesJson["plan"][index]["rules"][j]) {
              if (this.rulesJson[this.data][index]["rules"][j]["inputs"] && this.rulesJson["plan"][index]["rules"][j]["inputs"][t]) {
                if (Array.isArray(controls["controls"]["inputs"]["controls"][t].value)) {
                  this.rulesJson[this.data][index]["rules"][j]["inputs"][t].defaultValue = this.convertIntoString(controls["controls"]["inputs"]["controls"][t].value, 'id', 'Array');
                }
                else if (typeof controls["controls"]["inputs"]["controls"][t].value == 'object') {
                  this.rulesJson[this.data][index]["rules"][j]["inputs"][t].defaultValue = this.convertIntoString(controls["controls"]["inputs"]["controls"][t].value, 'id', 'Object');
                }

                else {
                  this.rulesJson[this.data][index]["rules"][j]["inputs"][t].defaultValue = controls["controls"]["inputs"]["controls"][t].value?.toString();
                }
              }
              this.rulesJson[this.data][index]["rules"][j].enable = controls["controls"]["enable"].value;
              if (this.rulesJson[this.data][index]["rules"][j]) {
                this.rulesJson[this.data][index]["rules"][j].ruleType = controls["controls"]["ruleType"].value.value;
              }

              if (this.displaySettings) {
                this.rulesJson[this.data][index]["rules"][j].displayInSettings = controls["controls"]["displayInSettings"].value;
              }
            }
          }
        }
      }
      const postData = {
        [this.data]: this.rulesJson[this.data]
      }
      this.isSaveClicked.emit(postData);
    }
    else {
      const msgkeys = ['RULES_UPDATE_INVALID_HEADER', 'RULES_UPDATE_INVALID_FIELDS']
      const severity = 'warn';
      const translationKeys = await this.translateService.get(msgkeys).toPromise();
      this.messageService.add({ severity: severity, summary: translationKeys[msgkeys[0]], detail: translationKeys[msgkeys[1]] });
    }

  }

  /**
  * Method to init form controls based on the rules JSON
  *
  * @returns {void}
  * @memberof RulesTableComponent
  */
  initForm() {
    this.ngxSpinner.show();
    let errorMessageGreater, errorMessageLesser;
    this.translateService.get(['ADMIN_RULE_GREATER_THAN', 'ADMIN_RULE_LESSER_THAN']).subscribe((res) => {
      errorMessageGreater = res['ADMIN_RULE_GREATER_THAN'];
      errorMessageLesser = res['ADMIN_RULE_LESSER_THAN'];
    })
    this.rulesForm = new FormArray([]);
    if (!this.displaySettings) {
      this.rulesJson[this.selectedTab].forEach(element => {
        element.rules = element.rules.filter(el => el.displayInSettings);
      });
    }
    this.rulesJson[this.selectedTab].forEach((element, elementIndex) => {
      const formArrayTemp = new FormArray([])
      element.rules.forEach((rule, rowIndex) => {
        const formGroup = new FormGroup({})
        formGroup.addControl('ruleType', new FormControl({ value: rule.ruleType }))
        if (this.displaySettings) {
          formGroup.addControl('displayInSettings', new FormControl(rule.displayInSettings))
        }

        formGroup.addControl('enable', new FormControl(rule?.enable))

        const formArray = new FormArray([])
        if (rule?.inputs.length > 0) {
          rule.inputs.forEach((input, inputIndex) => {

            let value = null;
            if (input.type === 'String' || input.type === 'Number' || input.type === 'number' || input.type === 'Boolean') {
              if (input?.value) {
                value = input.value;
              }
              else if (input?.defaultValue) {
                value = input.defaultValue
              }
            }
            if (input.type === 'MultiSelect' && input.ruleDropDownMaster != null) {
              value = [];
              const defaultValuesArray = input?.defaultValue?.split(',');
              defaultValuesArray?.forEach((elem: any) => {
                const result = input?.ruleDropDownMaster?.find(r => r.id === Number(elem))
                value?.push(result);
              });
            }
            if (input.type === "Dropdown" && input.ruleDropDownMaster != null) {
              value = input?.ruleDropDownMaster?.find(r => r.id === Number(input?.defaultValue))
            }
            const validationArray = [];
            if (input.isMandatory && rule?.isHardRule == false && input.type) {
              validationArray.push(Validators.required);
            }
            if (input && (input.max || input.min)) {
              if (input?.max) {
                const maxkey = elementIndex + '_' + rowIndex + '_' + inputIndex + '_' + 'max';
                this.errorMessages[maxkey] = errorMessageLesser + input.max;
              }

              if (input?.min) {
                const minkey = elementIndex + '_' + rowIndex + '_' + inputIndex + '_' + 'min';
                this.errorMessages[minkey] = errorMessageGreater + input.min;
              }
              validationArray.push(RulesValidator('inputs', elementIndex, rowIndex, inputIndex, input.max, input.min))
            }


            if (input.type === 'Number' || input.type === 'number') {
              if (rule.numericPrecision !== 0) {
                validationArray.push(numberValidator(rule.numericScale, (rule.numericPrecision - rule.numericScale)))
              }
            }
            formArray.push(new FormControl(value, validationArray))
          });

          formGroup.addControl('inputs', formArray)
        }
        this.disableOrEnableRule(rowIndex, formGroup)
        formArrayTemp.push(formGroup);
      }
      )
      this.rulesForm.push(formArrayTemp);
    })
    if (this.editMode) {
      this.rulesForm.enable();
    } else {
      this.rulesForm.disable();
    }
    this.ngxSpinner.hide();
  }



  /**
  * Method to get a control at a particular index
  *
  * @returns {void}
  * @memberof RulesTableComponent
  */
  getControl(key: string, rowIndex: number, inputIndex: number = null): FormControl {
    const temp: FormArray = <FormArray>this.rulesForm.at(this.selectedIndex);
    if (inputIndex !== null) {
      return <FormControl>(<FormArray>(<FormGroup>temp?.at(rowIndex))?.get(key))?.at(inputIndex)
    }
    else {
      return <FormControl>(<FormGroup>temp?.at(rowIndex))?.get(key);
    }
  }

  /**
  * Get field errors
  *
  * @param {number} formGroupIndex
  * @param {string} formControlName
  * @returns {ValidationErrors}
  * @memberof RulesTableComponent
  */
  fieldError(key: string, rowIndex: number, inputIndex: number = null): ValidationErrors {
    const formControl = this.getControl(key, rowIndex, inputIndex);
    return formControl?.invalid && (formControl.dirty || formControl.touched) ? formControl.errors : null;
  }

  /**
  * Method to disable form if specified in the rules JSON
  *
  * @returns {void}
  * @memberof RulesTableComponent
  */
  disableForm() {
    this.rulesJson[this.selectedTab].forEach((element, index) => {
      const temp: FormArray = <FormArray>this.rulesForm.at(index);
      element.rules.forEach((rule, rowIndex) => {
        if (rule?.isHardRule) {
          temp?.at(rowIndex)?.disable()
        }
      })
    }
    )
  }


  /**
   * Method on ruletypeselected.
   *
   * @memberof RulesTableComponent
   */
  onRuleTypeSelected() {
    this.checkForFormValueChanges()
  }


  /**
   *Method to convert array into string, seperated by commas based on property.
   *
   * @memberof RulesTableComponent
   */
  convertIntoString(value: any, propertyName: any, convertFrom: any) {
    if (convertFrom == 'Array') {
      if (value[0] != undefined) {
        return Array.prototype.map.call(value, s => s[propertyName]).toString();
      }
      else {
        return '';
      }
    }
    else if (convertFrom == 'Object') {
      if (value != null)
        return JSON.stringify(value[propertyName]);
      else {
        return '';
      }
    }
  }

  /**
 *Method to disable or enable rule
 *
 * @memberof RulesTableComponent
 */
  disableOrEnableRule(rowIndex, fg = null) {
    const formGroup = fg ? fg : <FormGroup>(<FormArray>this.rulesForm.at(this.selectedIndex)).at(rowIndex);
    if (formGroup.get('enable')?.value) {
      formGroup?.enable()
    } else {
      formGroup?.disable();
      formGroup.get('enable')?.enable();
    }
    formGroup.get('displayInSettings')?.enable();
  }

  /**
  * Method to sort the multiselect array
  *
  * @memberof RulesTableComponent
  */
  onChangeMultiSelect(key,rowIndex,inputIndex){
    const fc = this.getControl(key,rowIndex,inputIndex);
    if(fc.value && fc.value.length && fc.value.length > 0){
      fc.value.sort(function(a, b) { return a.id - b.id; })
    }
  }

}


