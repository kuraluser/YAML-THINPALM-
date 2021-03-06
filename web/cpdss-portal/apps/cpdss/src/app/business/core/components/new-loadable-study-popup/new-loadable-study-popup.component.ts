import { Component, ElementRef, EventEmitter, Input, OnInit, Output, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { FileUpload } from 'primeng/fileupload';
import { IDropdownEvent, ILoadableStudy } from "./new-loadable-study-popup.model";
import { IdraftMarks, ILoadLineList, INewLoadableStudyListNames, Voyage } from "../../models/common.model";
import { IVessel } from '../../../core/models/vessel-details.model';
import { LoadableStudyListApiService } from '../../../cargo-planning/services/loadable-study-list-api.service';
import { LoadableStudy } from '../../../cargo-planning/models/loadable-study-list.model';
import { LOADABLE_STUDY_STATUS } from '../../../core/models/common.model';
import { Router } from '@angular/router';
import { numberValidator } from '../../../core/directives/number-validator.directive'
import { MessageService } from 'primeng/api';
import { TranslateService } from '@ngx-translate/core';
import { NgxSpinnerService } from 'ngx-spinner';
import { whiteSpaceValidator } from '../../directives/space-validator.directive';
import { saveAs } from 'file-saver';
import { LoadableStudyDetailsTransformationService } from '../../../cargo-planning/services/loadable-study-details-transformation.service';
import { isAlphaCharacterAvaiable } from '../../directives/alpha-validator.directive';
import { TimeZoneTransformationService } from '../../../../shared/services/time-zone-conversion/time-zone-transformation.service';

/**
 *  popup for creating / editing loadable-study
 */
@Component({
  selector: 'cpdss-portal-new-loadable-study-popup',
  templateUrl: './new-loadable-study-popup.component.html',
  styleUrls: ['./new-loadable-study-popup.component.scss']
})
export class NewLoadableStudyPopupComponent implements OnInit {

  @ViewChild('fileUpload') fileUpload: FileUpload;
  @Input() display;
  @Input()
  get vesselInfoList(): IVessel { return this._vesselInfoList; }
  set vesselInfoList(vesselInfoList: IVessel) {
    this._vesselInfoList = vesselInfoList;
  }
  @Input()
  get loadableStudies(): LoadableStudy[] { return this._loadableStudyList; }
  set loadableStudies(value: LoadableStudy[]) {
    this._loadableStudyList = value.filter(loadable =>
      ![LOADABLE_STUDY_STATUS.PLAN_ALGO_PROCESSING, LOADABLE_STUDY_STATUS.PLAN_ALGO_PROCESSING_COMPETED, LOADABLE_STUDY_STATUS.PLAN_COMMUNICATED_TO_SHORE, LOADABLE_STUDY_STATUS.PLAN_LOADICATOR_CHECKING].includes(loadable?.statusId));
  }

  @Input()
  get duplicateLoadableStudy(): LoadableStudy { return this._duplicateLoadableStudy; }
  set duplicateLoadableStudy(duplicateLoadableStudy: LoadableStudy) {
    this._duplicateLoadableStudy = duplicateLoadableStudy;
  }
  @Input() isEdit = false;
  @Input() selectedLoadableStudy: LoadableStudy;
  @Input()
  set voyages(value: Voyage[]) {
    const pastVoyages = value?.filter((voyage) => {
      const date = new Date();
      date.setFullYear(date.getFullYear() - 5);
      return (this.timeZoneTransformationService.convertToDate(voyage?.actualStartDate)?.getTime() > date?.getTime() || this.timeZoneTransformationService.convertToDate(voyage?.startDate)?.getTime() > date?.getTime()) || (!voyage?.actualStartDate && !voyage?.startDate);
    })
    .sort((a, b) => this.timeZoneTransformationService.convertToDate(b?.actualStartDate)?.getTime() - this.timeZoneTransformationService.convertToDate(a?.actualStartDate)?.getTime());
    this._voyages = pastVoyages;
  }
  get voyages(): Voyage[] {
    return this._voyages;
  }

  @Input()
  get voyage(): Voyage { return this._voyage; }
  set voyage(voyage: Voyage) {
    this._voyage = this.voyages?.find(_voyage => voyage?.voyageNo === _voyage?.voyageNo);
    this.createdFromVoyage = this.voyages?.find(_voyage => voyage?.voyageNo === _voyage?.voyageNo);
    this.getVesselInfo();
  }

  @Output() displayPopup = new EventEmitter();
  @Output() addedNewLoadableStudy = new EventEmitter<Object>();

  @ViewChild('fileUpload') fileUploadVariable: ElementRef;

  private _vesselInfoList: IVessel;
  private _voyage: Voyage;
  private _loadableStudyList: LoadableStudy[];
  private _duplicateLoadableStudy: LoadableStudy;
  private _voyages: Voyage[];

  createdFromVoyage: Voyage;
  newLoadableStudyFormGroup: FormGroup;
  newLoadableStudyPopupModel: ILoadableStudy;
  newLoadableStudyListNames: INewLoadableStudyListNames;
  loadlineList: ILoadLineList;
  draftMarkList: IdraftMarks[] = [];
  uploadedFiles: any[] = [];
  editUploadFiles: any[] = [];
  loadlineLists: ILoadLineList[];
  showError = false;
  uploadError = "";
  newLoadableStudyNameExist = false;
  popUpHeader = "";
  saveButtonLabel = "";
  savedloadableDetails: any;
  deletedAttachments: number[];

  constructor(private loadableStudyListApiService: LoadableStudyListApiService,
    private formBuilder: FormBuilder,
    private router: Router,
    private messageService: MessageService,
    private translateService: TranslateService,
    private ngxSpinnerService: NgxSpinnerService,
    private loadableStudyDetailsTransformationService: LoadableStudyDetailsTransformationService,
    private timeZoneTransformationService: TimeZoneTransformationService) { }

  ngOnInit(): void {
    this.deletedAttachments = [];
    this.popUpHeader = this.isEdit ? "NEW_LOADABLE_STUDY_POPUP_EDIT_HEADER" : "NEW_LOADABLE_STUDY_POPUP_HEADER"
    this.saveButtonLabel = this.isEdit ? "NEW_LOADABLE_STUDY_POPUP_UPDATE_BUTTON" : "NEW_LOADABLE_STUDY_POPUP_SAVE_BUTTON";
  }

  //get loadlines data and create form group
  async getVesselInfo() {
    this.ngxSpinnerService.show();
    this.uploadedFiles = [];
    this.loadlineLists = this.vesselInfoList?.loadlines;
    this.createNewLoadableStudyFormGroup();
    const result = await this.loadableStudyListApiService.getLoadableStudies(this.vesselInfoList?.id, this.isEdit && this.selectedLoadableStudy?.createdFromVoyageId ? this.selectedLoadableStudy?.createdFromVoyageId : this.voyage?.id).toPromise();
    this.loadableStudies = result?.loadableStudies ?? [];
    this.duplicateLoadableStudy = this.loadableStudies?.find(loadableStudy => this.isEdit ? loadableStudy?.id === this.selectedLoadableStudy?.createdFromId : loadableStudy?.id === this.duplicateLoadableStudy?.id);
    if (this.isEdit) {
      this.createdFromVoyage = this.voyages.find(voyage => voyage.id === this.selectedLoadableStudy?.createdFromVoyageId);
      this.updateLoadableStudyFormGroup(this.selectedLoadableStudy, true);
    } else {
      let isLoadableStudyAvailable;
      isLoadableStudyAvailable = this.duplicateLoadableStudy && Object.keys(this.duplicateLoadableStudy)?.length === 0 && this.duplicateLoadableStudy.constructor === Object
      if (!isLoadableStudyAvailable && this.duplicateLoadableStudy) {
        this.updateLoadableStudyFormGroup(this.duplicateLoadableStudy, false);
      } else {
        this.getLoadlineSummer();
      }
    }
    this.ngxSpinnerService.hide();
  }

  //get summer loadline data
  getLoadlineSummer() {
    const result = this.loadlineLists.filter(e => e.name.toLowerCase() === 'summer');
    if (result.length > 0) {
      this.loadlineList = result[0];
      const draftMarkSummer = this.loadlineList.draftMarks[0];
      this.newLoadableStudyFormGroup.patchValue({
        loadLine: this.loadlineList,
        draftMark: { id: draftMarkSummer, name: draftMarkSummer }
      });
      this.onloadLineChange();
    }
  }

  // creating form-group for new-loadable-study
  async createNewLoadableStudyFormGroup() {
    this.newLoadableStudyFormGroup = this.formBuilder.group({
      duplicateExisting: this.formBuilder.control(false),
      createdFromVoyage: this.formBuilder.control(null),
      createdFromLS: '',
      newLoadableStudyName: this.formBuilder.control('', [Validators.required, Validators.maxLength(100), whiteSpaceValidator , isAlphaCharacterAvaiable]),
      enquiryDetails: this.formBuilder.control('', [Validators.maxLength(1000)]),
      attachMail: null,
      charterer: this.vesselInfoList?.charterer,
      subCharterer: this.formBuilder.control('', [Validators.maxLength(30)]),
      loadLine: '',
      draftMark: '',
      draftRestriction: this.formBuilder.control('', [numberValidator(2, 2), Validators.min(0.01)]),
      maxAirTempExpected: this.formBuilder.control('', [numberValidator(2, 2), Validators.min(-99), Validators.max(99)]),
      maxWaterTempExpected: this.formBuilder.control('', [numberValidator(2, 3), Validators.min(-99), Validators.max(999)])
    });
  }

  // post newLoadableStudyFormGroup for saving newly created loadable-study
  public async saveLoadableStudy() {
    console.log('saveLoadableStudy' + Date.now()); // TODO: Need to remove after testing
    if (this.newLoadableStudyFormGroup.valid) {
      const translationKeys = await this.translateService.get(['NEW_LOADABLE_STUDY_POPUP__NAME_EXIST', 'LOADABLE_STUDY_CREATE_SUCCESS', 'LOADABLE_STUDY_CREATED_SUCCESSFULLY', 'LOADABLE_STUDY_CREATE_ERROR', 'LOADABLE_STUDY_ALREADY_EXIST', 'LOADABLE_STUDY_UPDATE_SUCCESS', 'LOADABLE_STUDY_UPDATED_SUCCESSFULLY', 'NEW_LOADABLE_STUDY_POPUP_VOYAGE_ACTIVE_CLOSED', 'NEW_LOADABLE_STUDY_POPUP_UPDATE_VOYAGE_ACTIVE_CLOSED', 'NEW_LOADABLE_STUDY_POPUP_DUPLICATE_VOYAGE_ACTIVE_CLOSED']).toPromise();
      let isLoadableStudyAvailable;
      isLoadableStudyAvailable = this.duplicateLoadableStudy && Object.keys(this.duplicateLoadableStudy)?.length === 0 && this.duplicateLoadableStudy.constructor === Object;
      this.newLoadableStudyPopupModel = {
        id: this.isEdit ? this.selectedLoadableStudy.id : 0,
        voyageId: (!isLoadableStudyAvailable && this.duplicateLoadableStudy && !this.isEdit) ?
          this.newLoadableStudyFormGroup.controls.createdFromVoyage.value?.id : '',
        createdFromId: (!isLoadableStudyAvailable && this.duplicateLoadableStudy && !this.isEdit) ?
          this.newLoadableStudyFormGroup.controls.createdFromLS.value?.id : '',
        name: this.newLoadableStudyFormGroup.controls.newLoadableStudyName.value.trim(),
        detail: this.newLoadableStudyFormGroup.controls.enquiryDetails.value,
        attachMail: this.uploadedFiles,
        charterer: this.newLoadableStudyFormGroup.controls.charterer.value,
        subCharterer: this.newLoadableStudyFormGroup?.controls?.subCharterer?.value ? this.newLoadableStudyFormGroup?.controls?.subCharterer?.value : "",
        loadLineXId: this.newLoadableStudyFormGroup.controls.loadLine.value?.id,
        draftMark: this.newLoadableStudyFormGroup.controls.draftMark.value?.id,
        draftRestriction: this.newLoadableStudyFormGroup.controls.draftRestriction.value,
        maxAirTempExpected: this.newLoadableStudyFormGroup.controls.maxAirTempExpected.value !== undefined ? this.newLoadableStudyFormGroup.controls.maxAirTempExpected.value + '' : '',
        maxWaterTempExpected: this.newLoadableStudyFormGroup.controls.maxWaterTempExpected.value !== undefined ? this.newLoadableStudyFormGroup.controls.maxWaterTempExpected.value + '' : '',
        deletedAttachments: this.deletedAttachments.join(',')
      }
      this.ngxSpinnerService.show();
      try {
        const result = await this.loadableStudyListApiService.setLodableStudy(this.vesselInfoList?.id, this.voyage.id, this.newLoadableStudyPopupModel).toPromise();
        if (result.responseStatus.status === "200") {
          this.newLoadableStudyNameExist = false;
          if (this.isEdit) {
            if (this.isLoadlineChanged()) {
              this.loadableStudyDetailsTransformationService.setLoadLineChange(true);
            }
            this.messageService.add({ severity: 'success', summary: translationKeys['LOADABLE_STUDY_UPDATE_SUCCESS'], detail: translationKeys['LOADABLE_STUDY_UPDATED_SUCCESSFULLY'] });
            this.ngxSpinnerService.hide();
            this.loadableStudyDetailsTransformationService.updateLoadableStudyData(true);
          } else {
            this.messageService.add({ severity: 'success', summary: translationKeys['LOADABLE_STUDY_CREATE_SUCCESS'], detail: translationKeys['LOADABLE_STUDY_CREATED_SUCCESSFULLY'] });
            this.ngxSpinnerService.hide();
          }
          this.closeDialog();
          this.addedNewLoadableStudy.emit(result.loadableStudyId);
        }
      } catch (error) {
        if (error.error.errorCode === 'ERR-RICO-105') {
          this.newLoadableStudyNameExist = true;
          this.messageService.add({ severity: 'error', summary: translationKeys['LOADABLE_STUDY_CREATE_ERROR'], detail: translationKeys['NEW_LOADABLE_STUDY_POPUP__NAME_EXIST'] });
        } else if (error.error.errorCode === 'ERR-RICO-110' || error.error.errorCode === 'ERR-RICO-392') {
          const messageKey = this.isEdit ? translationKeys['NEW_LOADABLE_STUDY_POPUP_UPDATE_VOYAGE_ACTIVE_CLOSED'] : this.newLoadableStudyPopupModel?.createdFromId ? translationKeys['NEW_LOADABLE_STUDY_POPUP_DUPLICATE_VOYAGE_ACTIVE_CLOSED'] : translationKeys['NEW_LOADABLE_STUDY_POPUP_VOYAGE_ACTIVE_CLOSED'];
          this.messageService.add({ severity: 'error', summary: translationKeys['LOADABLE_STUDY_CREATE_ERROR'], detail: messageKey, life: 10000 });
        }
        this.ngxSpinnerService.hide();
      }
    } else {
      this.newLoadableStudyFormGroup.markAllAsTouched();
    }
  }

  // this function triggers when choosing the files in fileUpload (primeng)
  async selectFilesToUpload() {
    let uploadFile = [];
    const sizeErrorFiles = [];
    const uploadedFileVar = this.fileUploadVariable.nativeElement.files;
    const extensions = ["docx","doc","pdf","txt","jpg","png","msg","eml","xlsx","xls","csv"];
    if (this.uploadedFiles.length < 5) {
      for (let i = 0; i < uploadedFileVar.length; i++) {
        const fileExtension = uploadedFileVar[i].name.substr((uploadedFileVar[i].name.lastIndexOf('.') + 1));
        if (extensions.includes(fileExtension.toLowerCase())) {
          if (uploadedFileVar[i].size / 1024 / 1024 >= 1) {
            sizeErrorFiles.push(uploadedFileVar[i].name)
            continue;
          } else {
            if ((uploadFile.length + this.uploadedFiles.length) < 5) {
              const fileNameExist = this.uploadedFiles.some(file => file?.id ? (file?.fileName?.toLowerCase() === uploadedFileVar[i].name.toLowerCase()) : (file?.name?.toLowerCase() === uploadedFileVar[i].name.toLowerCase()));
              if (fileNameExist) {
                this.showError = true;
                this.uploadError = "NEW_LOADABLE_STUDY_LIST_POPUP_FILE_NAME_EXIST_ERROR"
              } else {
                this.showError = false;
                uploadFile.push(uploadedFileVar[i]);
              }
            } else {
              this.showError = true;
              this.uploadError = "NEW_LOADABLE_STUDY_LIST_POPUP_FILE_LIMIT_ERROR"
            }
          }
        } else {
          this.showError = true;
          this.uploadError = "NEW_LOADABLE_STUDY_LIST_POPUP_FILE_FORMAT_ERROR";
          continue;
        }
      }
      const translationKeys = await this.translateService.get(['NEW_LOADABLE_STUDY_LIST_POPUP_FILE_SIZE_ERROR', 'NEW_LOADABLE_STUDY_LIST_POPUP_ERROR']).toPromise();
      if (sizeErrorFiles?.length) {
        const errMessage = sizeErrorFiles.toString() + ' ' + translationKeys['NEW_LOADABLE_STUDY_LIST_POPUP_FILE_SIZE_ERROR'];
        this.messageService.add({ severity: 'error', summary: translationKeys['NEW_LOADABLE_STUDY_LIST_POPUP_ERROR'], detail: errMessage });
      }
    } else {
      this.showError = true;
      this.uploadError = "NEW_LOADABLE_STUDY_LIST_POPUP_FILE_LIMIT_ERROR"
    }
    this.uploadedFiles.push(...uploadFile);
    uploadFile = [];
    this.fileUploadVariable.nativeElement.value = "";
  }

  //open selected file
  openFile(index, fileID = null, file?: any) {
    const fileName = file?.name ? file?.name : file?.fileName
    if (fileID) {
      this.loadableStudyListApiService.downloadAttachment(this.vesselInfoList?.id, this.voyage.id, this.selectedLoadableStudy?.id, fileID).subscribe((data) => {
        const blob = new Blob([data], { type: data.type })
        const fileurl = window.URL.createObjectURL(blob)
        saveAs(fileurl, fileName)
      });
    } else {
      const blob = new Blob([this.uploadedFiles[index]], { type: this.uploadedFiles[index].type })
      const fileurl = window.URL.createObjectURL(blob)
      saveAs(fileurl, this.uploadedFiles[index]?.name)
    }
  }

  //remove selected file
  removeFile(index, fileID = null) {
    if (fileID) {
      this.deletedAttachments.push(fileID);
    }
    this.uploadedFiles.splice(index, 1);
    this.showError = false;
  }

  // returns form-controls of newLoadableStudyFormGroup
  get form() { return this.newLoadableStudyFormGroup.controls; }

  // for closing active modal popup
  closeDialog() {
    this.newLoadableStudyFormGroup.reset();
    this.displayPopup.emit(false);
    this.uploadError = "";
  }

  /**
   * Load draft mark List based on selected loadLine vaule
   */
  onloadLineChange() {
    const loadLine = this.newLoadableStudyFormGroup.get('loadLine').value;
    this.draftMarkList = loadLine.draftMarks.map(draftMarks => ({ id: draftMarks, name: draftMarks.toFixed(2) }));
    this.newLoadableStudyFormGroup.controls.draftMark.setValue(this.draftMarkList[0]);
  }

  //for set selcted loadable study value in loadable study form
  onDuplicateExisting(event: IDropdownEvent) {
    this.updateLoadableStudyFormGroup(event.value, false);
  }

  //for edit/duplicate update the values
  updateLoadableStudyFormGroup(loadableStudyObj: LoadableStudy, isEdit: boolean) {
    if (isEdit) {
      this.newLoadableStudyFormGroup.controls['duplicateExisting'].disable();
      this.newLoadableStudyFormGroup.controls['createdFromVoyage'].disable();
      this.newLoadableStudyFormGroup.controls['createdFromLS'].disable();
      this.savedloadableDetails = {
        draftMark: loadableStudyObj?.draftMark,
        loadLineXId: loadableStudyObj?.loadLineXId,
        draftRestriction: loadableStudyObj?.draftRestriction ? loadableStudyObj?.draftRestriction : ''
      }
      if (loadableStudyObj?.createdFromId) {
        this.loadableStudies?.map((loadableStudy) => {
          if (loadableStudyObj.createdFromId === loadableStudy.id) {
            this.newLoadableStudyFormGroup.patchValue({
              duplicateExisting: true,
              createdFromLS: loadableStudy,
              createdFromVoyage: this.createdFromVoyage
            })
          }
        })
      }
    } else {
      this.newLoadableStudyFormGroup.patchValue({
        duplicateExisting: true,
        createdFromLS: loadableStudyObj,
        createdFromVoyage: this.createdFromVoyage
      })
      this.duplicateLoadableStudy = loadableStudyObj;
      this.newLoadableStudyFormGroup.controls.createdFromVoyage.setValidators([Validators.required]);
      this.newLoadableStudyFormGroup.controls.createdFromLS.setValidators([Validators.required]);
    }
    this.newLoadableStudyFormGroup.patchValue({
      newLoadableStudyName: loadableStudyObj.name,
      enquiryDetails: loadableStudyObj.detail ? loadableStudyObj.detail : '',
      charterer: loadableStudyObj.charterer,
      subCharterer: loadableStudyObj?.subCharterer,
      loadLine: loadableStudyObj,
      draftMark: loadableStudyObj,
      draftRestriction: loadableStudyObj.draftRestriction ? loadableStudyObj.draftRestriction : '',
      maxAirTempExpected: loadableStudyObj.maxAirTemperature !== undefined ? loadableStudyObj.maxAirTemperature : '',
      maxWaterTempExpected: loadableStudyObj.maxWaterTemperature !== undefined ? loadableStudyObj.maxWaterTemperature : ''
    });
    const result = this.loadlineLists.filter(loadline => loadline.id === loadableStudyObj.loadLineXId);
    if (result.length > 0) {
      this.loadlineList = result[0];
      const selectedDraftMark = loadableStudyObj.draftMark;
      this.newLoadableStudyFormGroup.patchValue({
        loadLine: this.loadlineList,
        draftMark: { id: selectedDraftMark, name: selectedDraftMark.toFixed(2) }
      });
    }
    const loadLine = this.newLoadableStudyFormGroup.get('loadLine').value;
    this.draftMarkList = loadLine.draftMarks?.map(draftMarks => ({ id: draftMarks, name: draftMarks.toFixed(2) }));
    loadableStudyObj.loadableStudyAttachment ? this.uploadedFiles = [...loadableStudyObj.loadableStudyAttachment] : this.uploadedFiles = [];
  }

  /**
   * check whether new draftMark , loadLineXId , draftRestriction
   * has been selected
   * @memberof NewLoadableStudyPopupComponent
  */
  isLoadlineChanged() {
    const savedloadableDetails = this.savedloadableDetails;
    if (savedloadableDetails && (this.savedloadableDetails.draftMark !== this.newLoadableStudyFormGroup.controls['draftMark'].value?.id ||
      this.savedloadableDetails.loadLineXId !== this.newLoadableStudyFormGroup.controls['loadLine'].value?.id ||
      (this.savedloadableDetails.draftRestriction !== this.newLoadableStudyFormGroup.controls['draftRestriction']?.value))) {
      return true;
    }
  }

  /**
   *
   * @param type
   * Get form control value to label
   */
  getControlLabel(type: string) {
    return this.newLoadableStudyFormGroup.controls[type].value;
  }

  /**
   * Handler for change event of voyages dropdown
   *
   * @param {*} event
   * @memberof NewLoadableStudyPopupComponent
   */
  async onVoyageChange(event) {
    this.ngxSpinnerService.show();
    this.createdFromVoyage = event.value;
    const result = await this.loadableStudyListApiService.getLoadableStudies(this.vesselInfoList?.id, event.value?.id).toPromise();
    this.loadableStudies = result?.loadableStudies ?? [];
    this.newLoadableStudyFormGroup.controls.createdFromLS.reset(null);
    this.newLoadableStudyFormGroup.controls.newLoadableStudyName.reset(null);
    this.duplicateLoadableStudy = null;
    this.ngxSpinnerService.hide();
  }

  /**
   * Handler for change event of duplicate existing checkbox
   *
   * @param {*} event
   * @memberof NewLoadableStudyPopupComponent
   */
  onDuplicateExistingToggle(event: Event) {
    if ((<HTMLInputElement>event?.target)?.checked) {
      this.newLoadableStudyFormGroup.controls.createdFromVoyage.setValidators([Validators.required]);
      this.newLoadableStudyFormGroup.controls.createdFromLS.setValidators([Validators.required]);
    } else {
      this.newLoadableStudyFormGroup.controls.createdFromVoyage.reset(null);
      this.newLoadableStudyFormGroup.controls.createdFromVoyage.clearValidators();
      this.newLoadableStudyFormGroup.controls.createdFromVoyage.updateValueAndValidity();
      this.newLoadableStudyFormGroup.controls.createdFromLS.reset(null);
      this.newLoadableStudyFormGroup.controls.createdFromLS.clearValidators();
      this.newLoadableStudyFormGroup.controls.createdFromLS.updateValueAndValidity();
    }

  }

}
