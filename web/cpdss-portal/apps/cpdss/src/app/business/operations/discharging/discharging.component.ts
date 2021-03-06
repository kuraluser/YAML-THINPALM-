import { Component, HostListener, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NgxSpinnerService } from 'ngx-spinner';
import { Observable, Subject } from 'rxjs';
import { takeUntil } from 'rxjs/operators';
import { MessageService } from 'primeng/api';
import { TranslateService } from '@ngx-translate/core';

import { DischargingInformationComponent } from './discharging-information/discharging-information.component';
import { UnsavedChangesGuard } from '../../../shared/services/guards/unsaved-data-guard';

import { AppConfigurationService } from '../../../shared/services/app-configuration/app-configuration.service';
import { PermissionsService } from '../../../shared/services/permissions/permissions.service';
import { GlobalErrorHandler } from '../../../shared/services/error-handlers/global-error-handler';
import { OperationsApiService } from '../services/operations-api.service';
import { LoadingDischargingTransformationService } from '../services/loading-discharging-transformation.service';

import { IPermission } from '../../../shared/models/user-profile.model';
import { ComponentCanDeactivate } from '../../../shared/models/common.model';
import { IAlgoError, IAlgoResponse, ICargo, ICargoResponseModel, OPERATIONS_PLAN_STATUS } from '../../core/models/common.model';
import { OPERATIONS } from '../../core/models/common.model';
import { OPERATION_TAB } from '../models/operations.model';
import { IGenerateDischargePlanResponse, ULLAGE_STATUS_VALUE } from '../models/loading-discharging.model';
import { saveAs } from 'file-saver';

/**
 * Component for discharging module
 *
 * @export
 * @class DischargingComponent
 * @implements {OnInit}
 */
@Component({
  selector: 'cpdss-portal-discharging',
  templateUrl: './discharging.component.html',
  styleUrls: ['./discharging.component.scss']
})
export class DischargingComponent implements OnInit, OnDestroy, ComponentCanDeactivate {

  @ViewChild(DischargingInformationComponent) dischargingInformationComponent: DischargingInformationComponent;
  @ViewChild('dischargingInstruction') dischargingInstruction;

  currentTab: OPERATION_TAB = OPERATION_TAB.INFORMATION;
  OPERATION_TAB = OPERATION_TAB;
  vesselId: number;
  voyageId: number;
  portRotationId: number;
  dischargeInfoId: number;
  cargoTanks = [];
  cargos: ICargo[];
  display = false;
  selectedPortName: string;
  dischargingInformationComplete: boolean;
  dischargingInstructionComplete: boolean;
  dischargeSequenceGenerated: boolean;
  dischargePlanGenerated: boolean;
  dischargingInfoTabPermission: IPermission;
  dischargingInstructionTabPermission: IPermission;
  dischargingSequenceTabPermission: IPermission;
  dischargingPlanTabPermission: IPermission;
  generateDischargingPlanPermission: IPermission;
  disablePlanGenerateBtn = false;
  disablePlanViewErrorBtn = true;
  errorMessage: IAlgoError[];
  errorPopUp = false;
  version: string;


  private ngUnsubscribe: Subject<any> = new Subject();
  readonly OPERATIONS = OPERATIONS;

  @HostListener('window:beforeunload')
  canDeactivate(): Observable<boolean> | boolean {
    return !(this.dischargingInstruction?.instructionCheckList?.hasUnsavedChanges || this.dischargingInstruction?.instructionCheckList?.instructionForm?.dirty || this.dischargingInformationComponent?.hasUnSavedData);
  }

  constructor(
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private unsavedChangesGuard: UnsavedChangesGuard,
    private permissionsService: PermissionsService,
    private globalErrorHandler: GlobalErrorHandler,
    private operationsApiService: OperationsApiService,
    private loadingDischargingTransformationService: LoadingDischargingTransformationService,
    private messageService: MessageService,
    private translateService: TranslateService,
    private ngxSpinnerService: NgxSpinnerService
  ) { }

  ngOnInit(): void {
    this.initSubsciptions();
    this.setPagePermission();
    this.getCargos();
    this.listenEvents();
    this.activatedRoute.paramMap
      .pipe(takeUntil(this.ngUnsubscribe))
      .subscribe(params => {
        this.vesselId = Number(params.get('vesselId'));
        this.voyageId = Number(params.get('voyageId'));
        this.portRotationId = Number(params.get('portRotationId'));
        localStorage.setItem("vesselId", this.vesselId.toString());
        localStorage.setItem("voyageId", this.voyageId.toString());
        localStorage.removeItem("loadableStudyId");
        this.selectedPortName = localStorage.getItem('selectedPortName');
        this.version = localStorage.getItem('portVersion');
        this.tabPermission();
      });
  }

  ngOnDestroy() {
    this.ngUnsubscribe.next();
    this.ngUnsubscribe.complete();
  }

  /**
  * Method to set discharging info id
  * @param tab
  * @memberof DischargingComponent
  */
  setDischargingInfoId(data) {
    this.dischargeInfoId = data;
  }

  /**
   * Initialise all subscription in this page
   *
   * @private
   * @memberof DischargingComponent
   */
  private async initSubsciptions() {
    this.loadingDischargingTransformationService.dischargingInformationValidity$.pipe(takeUntil(this.ngUnsubscribe)).subscribe((isCompleted) => {
      this.dischargingInformationComplete = isCompleted;
    });

    this.loadingDischargingTransformationService.dischargingInstructionValidity$.pipe(takeUntil(this.ngUnsubscribe)).subscribe((isCompleted) => {
      this.dischargingInstructionComplete = isCompleted;
    });

    this.loadingDischargingTransformationService.disableDischargePlanGenerate$.pipe(takeUntil(this.ngUnsubscribe)).subscribe((isDisabled) => {
      this.disablePlanGenerateBtn = isDisabled;
    });

    this.loadingDischargingTransformationService.dischargingSequenceValidity$.pipe(takeUntil(this.ngUnsubscribe)).subscribe((isGenerated) => {
      this.dischargeSequenceGenerated = isGenerated;
    });

    this.loadingDischargingTransformationService.dischargingPlanValidity$.pipe(takeUntil(this.ngUnsubscribe)).subscribe((isGenerated) => {
      this.dischargePlanGenerated = isGenerated;
    });

    this.loadingDischargingTransformationService.disableDischargePlanViewError$.pipe(takeUntil(this.ngUnsubscribe)).subscribe((isDisabled) => {
      this.disablePlanViewErrorBtn = isDisabled;
    });

    this.loadingDischargingTransformationService.validateUllageData$.pipe(takeUntil(this.ngUnsubscribe)).subscribe((res) => {
      if (res?.validate && this.portRotationId === res?.portRotationId) {
        this.validateUllage(res);
      }
    });

    this.loadingDischargingTransformationService.setUllageDepartureBtnStatus$.pipe(takeUntil(this.ngUnsubscribe)).subscribe((value) => {
      if (value && value.status === ULLAGE_STATUS_VALUE.SUCCESS) {
        this.disablePlanGenerateBtn = true;
      }
    });
  }

  /**
   * Method to listen to service worker events.
   *
   * @private
   * @memberof DischargingComponent
   */
  private listenEvents() {
    navigator.serviceWorker.addEventListener('message', this.swMessageHandler);
  }

  /**
   * Method to show service worker status messages based on api result.
   *
   * @private
   * @param {*} event
   * @memberof DischargingComponent
   */
  private swMessageHandler = async event => {
    const translationKeys = await this.translateService.get([
      'PORT',
      'GENERATE_DISCHARGING_PLAN_INFO',
      'GENERATE_DISCHARGING_PLAN_ERROR',
      'GENERATE_DISCHARGING_PLAN_SUCCESS',
      'GENERATE_DISCHARGING_PLAN_PENDING',
      'GENERATE_DISCHARGING_PLAN_NO_PLAN_AVAILABLE',
      'GENERATE_DISCHARGING_PLAN_CONFIRMED',
      'GENERATE_DISCHARGING_PLAN_ALGO_PROCESSING_STARTED',
      'GENERATE_DISCHARGING_PLAN_PLAN_GENERATED',
      'GENERATE_DISCHARGING_PLAN_ALGO_PROCESSING_COMPLETED',
      'GENERATE_DISCHARGING_PLAN_ERROR_OCCURED',
      'GENERATE_DISCHARGING_PLAN_VERIFICATION_WITH_LOADICATOR',
      'GENERATE_DISCHARGING_PLAN_VERIFICATIOON_WITH_LOADER_COMPLETED',
      'GENERATE_DISCHARGING_PLAN_ALGO_VERIFICATION',
      'GENERATE_DISCHARGING_PLAN_ALGO_VERIFICATION_COMPLETED',
      'GENERATE_DISCHARGING_PLAN_COMMUNICATED_TO_SHORE',
      'ULLAGE_UPDATE_VALIDATION_SUCCESS_LABEL',
      'ULLAGE_UPDATE_PLAN_COMMUNICATED_TO_SHORE'
    ]).toPromise();

    if (event?.data?.status === '401' && event?.data?.errorCode === '210') {
      this.globalErrorHandler.sessionOutMessage();
    }
    this.ngxSpinnerService.hide();

    if (event?.data?.pattern?.type === 'discharging-plan-status') {
      if (event?.data.statusId === OPERATIONS_PLAN_STATUS.ERROR_OCCURED) {
        this.messageService.clear();
        this.setButtonStatusInProcessing(false, true);
        this.getAlgoErrorMessage(true, 0, event?.data?.pattern?.dischargingInfoId);
        this.messageService.add({ severity: 'error', summary: translationKeys['GENERATE_DISCHARGING_PLAN_ERROR'], detail: translationKeys['GENERATE_DISCHARGING_PLAN_ERROR_OCCURED'] });
      } else if (event?.data?.statusId === OPERATIONS_PLAN_STATUS.NO_PLAN_AVAILABLE) {
        this.messageService.clear();
        this.setButtonStatusInProcessing(false, true);
        this.getAlgoErrorMessage(true, 0, event?.data?.pattern?.dischargingInfoId);
        this.messageService.add({ severity: 'error', summary: translationKeys['GENERATE_DISCHARGING_PLAN_ERROR'], detail: translationKeys['GENERATE_DISCHARGING_PLAN_NO_PLAN_AVAILABLE'] });
      } else if (event?.data?.statusId === OPERATIONS_PLAN_STATUS.PLAN_GENERATED) {
        this.messageService.clear();
        if (this.dischargeInfoId === event?.data?.pattern?.dischargingInfoId) {
          this.setButtonStatusInProcessing(false);
        }
        this.messageService.add({ severity: 'success', summary: translationKeys['GENERATE_DISCHARGING_PLAN_SUCCESS'], detail: event?.data?.pattern?.portName + ' ' + translationKeys['PORT']?.toLowerCase() + ' ' + translationKeys['GENERATE_DISCHARGING_PLAN_PLAN_GENERATED'], sticky: true, closable: true });
      }

      if (this.router.url.includes('operations/discharging') && this.loadingDischargingTransformationService.portRotationId === event?.data?.pattern?.portRotationId) {
        switch (event?.data?.statusId) {
          case OPERATIONS_PLAN_STATUS.PENDING:
            this.setButtonStatusInProcessing(true);
            this.processingMessages(translationKeys['GENERATE_DISCHARGING_PLAN_INFO'], translationKeys['GENERATE_DISCHARGING_PLAN_PENDING']);
            break;
          case OPERATIONS_PLAN_STATUS.CONFIRMED:
            this.setButtonStatusInProcessing(true);
            this.processingMessages(translationKeys['GENERATE_DISCHARGING_PLAN_INFO'], translationKeys['GENERATE_DISCHARGING_PLAN_CONFIRMED']);
            break;
          case OPERATIONS_PLAN_STATUS.PLAN_ALGO_PROCESSING_STARTED:
            this.setButtonStatusInProcessing(true);
            this.processingMessages(translationKeys['GENERATE_DISCHARGING_PLAN_INFO'], translationKeys['GENERATE_DISCHARGING_PLAN_ALGO_PROCESSING_STARTED']);
            break;
          case OPERATIONS_PLAN_STATUS.VERIFICATION_WITH_LOADICATOR:
            this.setButtonStatusInProcessing(true);
            this.processingMessages(translationKeys['GENERATE_DISCHARGING_PLAN_INFO'], translationKeys['GENERATE_DISCHARGING_PLAN_VERIFICATION_WITH_LOADICATOR']);
            break;
          case OPERATIONS_PLAN_STATUS.VERFICATION_WITH_LOADICATOT_COMPLETED:
            this.setButtonStatusInProcessing(true);
            this.processingMessages(translationKeys['GENERATE_DISCHARGING_PLAN_INFO'], translationKeys['GENERATE_DISCHARGING_PLAN_VERIFICATIOON_WITH_LOADER_COMPLETED']);
            break;
          case OPERATIONS_PLAN_STATUS.ALGO_PROCESSING_COMPLETED:
            this.setButtonStatusInProcessing(true);
            this.processingMessages(translationKeys['GENERATE_DISCHARGING_PLAN_INFO'], translationKeys['GENERATE_DISCHARGING_PLAN_ALGO_PROCESSING_COMPLETED']);
            break;
          case OPERATIONS_PLAN_STATUS.LOADICATOR_VERIFICATION_WITH_ALGO_COMPLETED:
            this.setButtonStatusInProcessing(true);
            this.processingMessages(translationKeys['GENERATE_DISCHARGING_PLAN_INFO'], translationKeys['GENERATE_DISCHARGING_PLAN_ALGO_VERIFICATION_COMPLETED']);
            break;
          case OPERATIONS_PLAN_STATUS.COMMUNICATED_TO_SHORE:
            this.setButtonStatusInProcessing(true);
            this.processingMessages(translationKeys['GENERATE_DISCHARGING_PLAN_INFO'], translationKeys['GENERATE_DISCHARGING_PLAN_COMMUNICATED_TO_SHORE']);
            break;
        }
      }
    }

    if (event?.data?.pattern?.type === 'discharge-ullage-update-status') {
      if (event?.data.statusId === ULLAGE_STATUS_VALUE.ERROR) {
        const errorStatus = {value: true, status: event?.data?.pattern?.status};
        this.loadingDischargingTransformationService.showUllageError(errorStatus);
      } else if (event?.data?.statusId === ULLAGE_STATUS_VALUE.SUCCESS) {
        this.messageService.add({ severity: 'success', summary: translationKeys['GENERATE_DISCHARGING_PLAN_SUCCESS'], detail: translationKeys['ULLAGE_UPDATE_VALIDATION_SUCCESS_LABEL'] });
      }

      if (this.router.url.includes('operations/discharging') && this.loadingDischargingTransformationService.portRotationId === event?.data?.pattern?.portRotationId) {
        switch (event?.data?.statusId) {
          case ULLAGE_STATUS_VALUE.IN_PROGRESS:
            this.messageService.add({ severity: 'info', summary: translationKeys['GENERATE_DISCHARGING_PLAN_INFO'], detail: translationKeys['GENERATE_DISCHARGING_PLAN_ALGO_PROCESSING_STARTED'] });
            break;
          case ULLAGE_STATUS_VALUE.LOADICATOR_IN_PROGRESS:
            this.messageService.add({ severity: 'info', summary: translationKeys['GENERATE_DISCHARGING_PLAN_INFO'], detail: translationKeys['GENERATE_DISCHARGING_PLAN_VERIFICATION_WITH_LOADICATOR'] });
            break;
          case ULLAGE_STATUS_VALUE.COMMUNICATED_TO_SHORE:
            this.messageService.add({ severity: 'info', summary: translationKeys['GENERATE_DISCHARGING_PLAN_INFO'], detail: translationKeys['ULLAGE_UPDATE_PLAN_COMMUNICATED_TO_SHORE'] });
            break;
        }
      }
      if (event?.data?.pattern?.status === 1) {
        this.loadingDischargingTransformationService.setUllageArrivalBtnStatus({ status: event?.data.statusId, portRotationId: event?.data?.pattern?.portRotationId });
      }
      if (event?.data?.pattern?.status === 2) {
        this.loadingDischargingTransformationService.setUllageDepartureBtnStatus({ status: event?.data.statusId, portRotationId: event?.data?.pattern?.portRotationId });
      }
    }
  }

  /**
  * Method to get cargos
  *
  * @memberof DischargingComponent
  */
  async getCargos() {
    this.ngxSpinnerService.show();
    const cargos: ICargoResponseModel = await this.operationsApiService.getCargos().toPromise();
    if (cargos.responseStatus.status === '200') {
      this.cargos = cargos.cargos;
    }
    this.ngxSpinnerService.hide();
  }

  /**
  * Method to switch tabs
  * @param tab
  * @memberof DischargingComponent
  */
  async switchTab(tab) {
    const value = await this.unsavedChangesGuard.canDeactivate(this);
    if (!value) { return };
    this.currentTab = tab;
    this.loadingDischargingTransformationService.setTabChange(tab);
    if (tab === OPERATION_TAB.INSTRUCTION) {
      if(!this.dischargingInstructionComplete){
        this.dischargingInstructionComplete = true;
        if(this.dischargingInformationComplete){
          this.disablePlanGenerateBtn = false;
        }
      }
    }
  }

  /**
  * Set page permission
  *
  * @memberof DischargingComponent
  */
  setPagePermission() {
    this.permissionsService.getPermission(AppConfigurationService.settings.permissionMapping['DischargingComponent']);
    this.generateDischargingPlanPermission = this.permissionsService.getPermission(AppConfigurationService.settings.permissionMapping['OperationDischargingGeneratePlan'], false);
    this.dischargingInfoTabPermission = this.permissionsService.getPermission(AppConfigurationService.settings.permissionMapping['DischargingInformationComponent'], false);
    this.dischargingInstructionTabPermission = this.permissionsService.getPermission(AppConfigurationService.settings.permissionMapping['DischargingInstructionComponent'], false);
    this.dischargingSequenceTabPermission = this.permissionsService.getPermission(AppConfigurationService.settings.permissionMapping['DischargingSequenceComponent'], false);
    this.dischargingPlanTabPermission = this.permissionsService.getPermission(AppConfigurationService.settings.permissionMapping['DischargingPlanComponent'], false);
  }

  /**
  * Select tab permission
  * @memberof DischargingComponent
  */
  tabPermission() {
    if (this.dischargingInfoTabPermission === undefined || this.dischargingInfoTabPermission?.view) {
      this.currentTab = OPERATION_TAB.INFORMATION;
    } else if (this.dischargingInstructionTabPermission?.view) {
      this.currentTab = OPERATION_TAB.INSTRUCTION;
    } else if (this.dischargingSequenceTabPermission?.view) {
      this.currentTab = OPERATION_TAB.SEQUENCE;
    } else if (this.dischargingPlanTabPermission?.view) {
      this.currentTab = OPERATION_TAB.PLAN;
    }
    this.loadingDischargingTransformationService.setTabChange(this.currentTab);
  }

  /**
   * function to generate discharging plan
   *
   * @memberof DischargingComponent
   */
  async generateDischargingPlan(): Promise<void> {
    const value = await this.unsavedChangesGuard.canDeactivate(this);
    if (!value) { return };
    this.ngxSpinnerService.show();
    const response: IGenerateDischargePlanResponse = await this.operationsApiService.generateDischargePlan(this.vesselId, this.voyageId, this.dischargeInfoId).toPromise();
    if (response.responseStatus.status === "200" && response.processId) {
      this.setButtonStatusInProcessing(true);
      const data = {
        processId: response.processId,
        vesselId: this.vesselId,
        voyageId: this.voyageId,
        dischargingInfoId: this.dischargeInfoId,
        portRotationId: this.portRotationId,
        portName: localStorage.getItem('selectedPortName'),
        type: 'discharging-plan-status'
      }
      navigator.serviceWorker.controller.postMessage({ type: 'discharging-plan-status', data });
    } else {
      this.ngxSpinnerService.hide();
    }
  }

  /**
   * Method to show different status toast
   *
   * @param {*} summary
   * @param {*} detail
   * @memberof DischargingComponent
   */
  processingMessages(summary, detail): void {
    this.messageService.clear("process");
    this.messageService.add({ severity: 'info', summary: summary, detail: detail, life: 1000, key: "process", closable: false });
  }

  /**
   * Method to disable or enable buttons based on algo status
   * discharge-plan generate button, discharge-info save, discharge-instruction save
   * rule popup
   *
   * @param {boolean} isProcesing
   * @memberof DischargingComponent
   */
  setButtonStatusInProcessing(isProcesing: boolean, hasError = false): void {
    this.disablePlanGenerateBtn = isProcesing;
    this.disablePlanViewErrorBtn = !hasError;
    this.loadingDischargingTransformationService.disableDischargeInfoSave(isProcesing);
    this.loadingDischargingTransformationService.disableInfoInstructionRuleSave.next(isProcesing);
    this.dischargeSequenceGenerated = (!isProcesing && !hasError);
    this.dischargePlanGenerated = (!isProcesing && !hasError);
  }

  /**
   * Method to get algo error details for discharge plan generation
   *
   * @param {boolean} status
   * @param {number} conditionType
   * @param {number} [currentDischargeInfoId]
   * @memberof DischargingComponent
   */
  async getAlgoErrorMessage(status: boolean, conditionType: number, currentDischargeInfoId?: number) {
    this.ngxSpinnerService.show();
    const infoId = (currentDischargeInfoId && currentDischargeInfoId === this.dischargeInfoId) ? currentDischargeInfoId : this.dischargeInfoId;
    if (infoId === undefined) return;
    const algoError: IAlgoResponse = await this.operationsApiService.getDischargePlanAlgoError(this.vesselId, this.voyageId, infoId, conditionType).toPromise();
    if (algoError.responseStatus.status === '200') {
      this.ngxSpinnerService.hide();
      this.errorMessage = algoError.algoErrors;
      this.errorPopUp = status;
    }
  }

  /**
   * function to validate ullage
   *
   * @param {*} value
   * @memberof DischargingComponent
   */
  validateUllage(value) {
    const data = {
      processId: value.processId,
      vesselId: this.vesselId,
      voyageId: this.voyageId,
      dischargingInfoId: this.dischargeInfoId,
      type: 'discharge-ullage-update-status',
      status: value.status,
      portRotationId: this.portRotationId
    }
    navigator.serviceWorker.controller.postMessage({ type: 'discharge-ullage-update-status', data });
  }

  /**
   * Method to show algo-error details on btn click
   *
   * @memberof DischargingComponent
   */
  viewError(): void {
    this.getAlgoErrorMessage(true, 0);
  }

  /**
   * function to download discharge-plan file as xls
   *
   * @memberof DischargingComponent
   */
   downloadDischargePlanTemplate(): void {
    this.ngxSpinnerService.show();
    this.operationsApiService.downloadPlanTemplate(this.vesselId, this.voyageId, this.dischargeInfoId, this.portRotationId, OPERATIONS.DISCHARGING, null).subscribe((result) => {
      const fileName = result.headers.get('content-disposition').split('filename=')[1];
      const blob = new Blob([result.body], { type: result.type });
      const fileurl = window.URL.createObjectURL(blob);
      saveAs(fileurl, fileName);
      this.ngxSpinnerService.hide();
    });
  }

}
