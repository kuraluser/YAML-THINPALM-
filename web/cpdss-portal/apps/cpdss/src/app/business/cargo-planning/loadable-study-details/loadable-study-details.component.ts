import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subject } from 'rxjs';
import { LOADABLE_STUDY_DETAILS_TABS } from '../models/cargo-planning.model';
import { LoadableStudyDetailsTransformationService } from '../services/loadable-study-details-transformation.service';
import { LoadableStudyDetailsApiService } from '../services/loadable-study-details-api.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Voyage, IPort, LOADABLE_STUDY_STATUS, VOYAGE_STATUS, LOADABLE_STUDY_STATUS_TEXT, IAlgoResponse, IAlgoError, IPortList, OPERATIONS, ICargo } from '../../core/models/common.model';
import { VoyageService } from '../../core/services/voyage.service';
import { IDischargingPortIds, LoadableStudy } from '../models/loadable-study-list.model';
import { LoadableStudyListApiService } from '../services/loadable-study-list-api.service';
import { NgxSpinnerService } from 'ngx-spinner';
import { IVessel } from '../../core/models/vessel-details.model';
import { VesselsApiService } from '../../core/services/vessels-api.service';
import { TranslateService } from '@ngx-translate/core';
import { MessageService } from 'primeng/api';
import { AppConfigurationService } from '../../../shared/services/app-configuration/app-configuration.service';
import { PermissionsService } from '../../../shared/services/permissions/permissions.service';
import { IPermissionContext, PERMISSION_ACTION, QUANTITY_UNIT, ISubTotal } from '../../../shared/models/common.model';
import { LoadableQuantityModel } from '../models/loadable-quantity.model';
import { LoadableQuantityApiService } from '../services/loadable-quantity-api.service';
import { IPermission } from '../../../shared/models/user-profile.model';
import { takeUntil, switchMap } from 'rxjs/operators';
import { GlobalErrorHandler } from '../../../shared/services/error-handlers/global-error-handler';
import { SecurityService } from '../../../shared/services/security/security.service';
import * as moment from 'moment';
import { environment } from '../../../../environments/environment';


/**
 * Component class for loadable study details component
 *
 * @export
 * @class LoadableStudyDetailsComponent
 * @implements {OnInit}
 */
@Component({
  selector: 'cpdss-portal-loadable-study-details',
  templateUrl: './loadable-study-details.component.html',
  styleUrls: ['./loadable-study-details.component.scss']
})
export class LoadableStudyDetailsComponent implements OnInit, OnDestroy {

  get selectedLoadableStudy(): LoadableStudy {
    return this._selectedLoadableStudy;
  }
  set selectedLoadableStudy(selectedLoadableStudy: LoadableStudy) {
    this._selectedLoadableStudy = selectedLoadableStudy;
    this.isPatternGenerated = (this._selectedLoadableStudy?.statusId === 3 || this._selectedLoadableStudy?.statusId === 2) ? true : false;
    this.isPatternOpenOrNoplan = (this._selectedLoadableStudy?.statusId === 1 || this._selectedLoadableStudy?.statusId === 6) ? false : this.inProcessing();
    this.loadableStudyId = selectedLoadableStudy ? selectedLoadableStudy?.id : this.loadableStudies?.length ? this.loadableStudies[0]?.id : 0;
    this.getLoadableStudyDetails(this.vesselId, this.voyageId, selectedLoadableStudy?.id);
  }

  get ports(): IPortList[] {
    return this._ports;
  }

  set ports(value: IPortList[]) {
    this._ports = value;
    this.dischargingPorts = value?.filter(port => port?.operationId === OPERATIONS?.DISCHARGING);
    this.loadingPorts = value?.filter(port => port?.operationId === OPERATIONS?.LOADING);
  }

  private _selectedLoadableStudy: LoadableStudy;
  private _ports: IPortList[] = [];
  private ngUnsubscribe: Subject<any> = new Subject();

  LOADABLE_STUDY_DETAILS_TABS = LOADABLE_STUDY_DETAILS_TABS;
  dischargingPorts: IPortList[] = [];//TODO to be populated form loadable study details
  loadingPorts: IPortList[] = [];
  dischargingPortsNames: string;//TODO to be populated form loadable study details
  totalQuantity: number;
  voyageId: number;
  loadableStudyId: number;
  vesselId: number;
  vesselInfo: IVessel;
  selectedVoyage: Voyage;
  voyages: Voyage[];
  loadableStudies: LoadableStudy[];
  openSidePane = true;
  selectedTab: string;
  cargoNominationTabPermissionContext: IPermissionContext;
  portsTabPermissionContext: IPermissionContext;
  addCargoBtnPermissionContext: IPermissionContext;
  addPortBtnPermissionContext: IPermissionContext;
  displayLoadableQuantity: boolean;
  loadableQuantityNew: string;
  loadableQuantityModel: LoadableQuantityModel;
  cargoNominationTabPermission: IPermission;
  portsTabPermission: IPermission;
  ohqTabPermissionContext: IPermissionContext;
  ohqTabPermission: IPermission;
  obqTabPermissionContext: IPermissionContext;
  obqTabPermission: IPermission;
  loadableQuantityPermission: IPermission;
  displayCommingle: boolean;
  showCommingleButton = false;
  addCommingleBtnPermissionContext: IPermissionContext;
  errorMesages: any;
  isSelectedDischargePort = true;
  selectedDischargeCargo: ICargo;
  dischargeCargos: ICargo[] = [];
  currentUnit = <QUANTITY_UNIT>localStorage.getItem('unit');
  currentObqUnit = <QUANTITY_UNIT>localStorage.getItem('unitObs');
  baseUnit = this.loadableStudyDetailsApiService.baseUnit;
  isPatternGenerated = false;
  isGenerateClicked = false;
  showGenerateBtn = false;
  isPatternOpenOrNoplan = false;
  showLoadableQuantityButton = false;
  LOADABLE_STUDY_STATUS = LOADABLE_STUDY_STATUS;
  VOYAGE_STATUS = VOYAGE_STATUS;
  generateBtnPermissionContext: IPermission;
  cargoNominationComplete: boolean;
  portsComplete: boolean;
  ohqComplete: boolean;
  obqComplete: boolean;
  addComminglePermission: IPermission;
  loadablePatternHistoryPermission: IPermission;
  errorPopup: boolean;
  errorMessage: IAlgoError[];
  isServiceWorkerCallActive = false;
  isRuleModalVisible = false;
  dischargingPortData: any = [];
  loadLineChange: boolean;

  constructor(public loadableStudyDetailsApiService: LoadableStudyDetailsApiService,
    private loadableStudyDetailsTransformationService: LoadableStudyDetailsTransformationService,
    private loadableStudyListApiService: LoadableStudyListApiService,
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private voyageService: VoyageService,
    private vesselsApiService: VesselsApiService,
    private ngxSpinnerService: NgxSpinnerService,
    private translateService: TranslateService,
    private messageService: MessageService,
    private permissionsService: PermissionsService,
    private loadableQuantityApiService: LoadableQuantityApiService,
    private globalErrorHandler: GlobalErrorHandler) {
  }

  ngOnInit(): void {
    this.initSubsciptions();
    this.listenEvents();
    this.activatedRoute.paramMap
      .pipe(takeUntil(this.ngUnsubscribe))
      .subscribe(params => {
        this.vesselId = Number(params.get('vesselId'));
        this.voyageId = Number(params.get('voyageId'));
        this.loadableStudyId = Number(params.get('loadableStudyId'));
        localStorage.setItem("vesselId", this.vesselId.toString())
        localStorage.setItem("voyageId", this.voyageId.toString())
        localStorage.setItem("loadableStudyId", this.loadableStudyId.toString())
        localStorage.removeItem("loadablePatternId")
        localStorage.removeItem("dischargeStudyId")
        this.loadableStudies = null;
        this.loadableQuantityNew = '0';
        this.loadableStudyDetailsTransformationService.setCargoNominationValidity(false);
        this.loadableStudyDetailsTransformationService.setTotalQuantityCargoNomination(0);
        this.tabPermission();
        this.getLoadableStudies(this.vesselId, this.voyageId, this.loadableStudyId);
      });
    this.errorMesages = this.loadableStudyDetailsTransformationService.setValidationErrorMessage();
    this.setPagePermissionContext();
  }

  /**
   * NgOnDestroy lifecycle hook
   *
   * @memberof LoadableStudyDetailsComponent
   */
  ngOnDestroy() {
    this.ngUnsubscribe.next();
    this.ngUnsubscribe.complete();
    navigator.serviceWorker.removeEventListener('message', this.swMessageHandler);
  }

  /**
   * Set page permission
   *
   * @memberof LoadableStudyDetailsComponent
   */
  setPagePermissionContext() {


    this.cargoNominationTabPermission = this.permissionsService.getPermission(AppConfigurationService.settings.permissionMapping['CargoNominationComponent'], false);
    this.cargoNominationTabPermissionContext = { key: AppConfigurationService.settings.permissionMapping['CargoNominationComponent'], actions: [PERMISSION_ACTION.VIEW] };

    this.portsTabPermission = this.permissionsService.getPermission(AppConfigurationService.settings.permissionMapping['PortsComponent'], false);
    this.portsTabPermissionContext = { key: AppConfigurationService.settings.permissionMapping['PortsComponent'], actions: [PERMISSION_ACTION.VIEW] };

    this.ohqTabPermission = this.permissionsService.getPermission(AppConfigurationService.settings.permissionMapping['OnHandQuantityComponent'], false);
    this.ohqTabPermissionContext = { key: AppConfigurationService.settings.permissionMapping['OnHandQuantityComponent'], actions: [PERMISSION_ACTION.VIEW] };

    this.loadableQuantityPermission = this.permissionsService.getPermission(AppConfigurationService.settings.permissionMapping['LoadableQuantityComponent'], false);

    this.obqTabPermission = this.permissionsService.getPermission(AppConfigurationService.settings.permissionMapping['OnBoardQuantityComponent'], false);
    this.obqTabPermissionContext = { key: AppConfigurationService.settings.permissionMapping['OnBoardQuantityComponent'], actions: [PERMISSION_ACTION.VIEW] };

    this.tabPermission();
    this.addComminglePermission = this.permissionsService.getPermission(AppConfigurationService.settings.permissionMapping['CargoCommingle'], false);

    this.addCargoBtnPermissionContext = { key: AppConfigurationService.settings.permissionMapping['CargoNominationComponent'], actions: [PERMISSION_ACTION.VIEW, PERMISSION_ACTION.ADD] };
    this.addPortBtnPermissionContext = { key: AppConfigurationService.settings.permissionMapping['PortsComponent'], actions: [PERMISSION_ACTION.VIEW, PERMISSION_ACTION.ADD] };
    this.addCommingleBtnPermissionContext = { key: AppConfigurationService.settings.permissionMapping['CargoCommingle'], actions: [PERMISSION_ACTION.VIEW, PERMISSION_ACTION.EDIT] };
    this.generateBtnPermissionContext = this.permissionsService.getPermission(AppConfigurationService.settings.permissionMapping['GenerateButton'], false);
    this.loadablePatternHistoryPermission = this.permissionsService.getPermission(AppConfigurationService.settings.permissionMapping['LoadablePatternHistoryComponent'], false);
  }

  /**
   * select tab permission
   * @memberof LoadableStudyDetailsComponent
   */
  tabPermission() {
    if (this.portsTabPermission === undefined || this.portsTabPermission?.view) {
      this.selectedTab = LOADABLE_STUDY_DETAILS_TABS.PORTS;
    } else if (this.cargoNominationTabPermission?.view) {
      this.selectedTab = LOADABLE_STUDY_DETAILS_TABS.CARGONOMINATION;
    } else if (this.ohqTabPermission?.view) {
      this.selectedTab = LOADABLE_STUDY_DETAILS_TABS.OHQ;
    } else if (this.obqTabPermission?.view) {
      this.selectedTab = LOADABLE_STUDY_DETAILS_TABS.OBQ;
    } else {
      this.selectedTab = LOADABLE_STUDY_DETAILS_TABS.PORTS;
    }
  }

  /**
   * Method to fetch all voyages in the vessel
   *
   * @param {number} vesselId
   * @param {number} voyageId
   * @memberof LoadableStudyDetailsComponent
   */
  async getVoyages(vesselId: number, voyageId: number) {
    const result = await this.voyageService.getVoyagesByVesselId(vesselId).toPromise();
    const voyages = result ?? [];
    this.selectedVoyage = voyages.find(voyage => voyage.id === voyageId);
    return voyages;
  }

  /**
   * Method to fetch all loadableStudies
   *
   * @param {number} vesselId
   * @param {number} voyageId
   * @param {number} loadableStudyId
   * @memberof LoadableStudyDetailsComponent
   */
  async getLoadableStudies(vesselId: number, voyageId: number, loadableStudyId: number) {
    this.ngxSpinnerService.show();
    const res = await this.vesselsApiService.getVesselsInfo().toPromise();
    this.vesselInfo = res[0] ?? <IVessel>{};
    this.loadableStudyDetailsTransformationService.vesselInfo = this.vesselInfo
    this.voyages = await this.getVoyages(this.vesselId, this.voyageId);
    const result = await this.loadableStudyListApiService.getLoadableStudies(vesselId, voyageId).toPromise();
    const loadableStudies = result?.loadableStudies ?? [];
    this.displayLoadableQuantity = this.loadLineChange;
    this.loadLineChange = false;
    if (loadableStudies.length) {
      this.setProcessingLoadableStudyActions(0, 0, loadableStudies);
      this.selectedLoadableStudy = loadableStudyId ? this.loadableStudies.find(loadableStudy => loadableStudy.id === loadableStudyId) : this.loadableStudies[0];
      this.isDischargePortAvailable();
      if (this.selectedLoadableStudy.statusId === LOADABLE_STUDY_STATUS.PLAN_NO_SOLUTION || this.selectedLoadableStudy.statusId === LOADABLE_STUDY_STATUS.PLAN_ERROR) {
        this.getAlgoErrorMessage(false);
      } else if (this.selectedLoadableStudy.statusId === LOADABLE_STUDY_STATUS.PLAN_COMMUNICATED_TO_SHORE || this.selectedLoadableStudy.statusId === LOADABLE_STUDY_STATUS.PLAN_ALGO_PROCESSING || this.selectedLoadableStudy.statusId === LOADABLE_STUDY_STATUS.PLAN_ALGO_PROCESSING_COMPETED || this.selectedLoadableStudy.statusId === LOADABLE_STUDY_STATUS.PLAN_LOADICATOR_CHECKING) {
        this.isGenerateClicked = true;
      }
      this.loadableStudyDetailsTransformationService.setCargoNominationValidity(this.selectedLoadableStudy.isCargoNominationComplete)
      this.loadableStudyDetailsTransformationService.setPortValidity(this.selectedLoadableStudy.isPortsComplete)
      this.loadableStudyDetailsTransformationService.setOHQValidity(this.selectedLoadableStudy.ohqPorts ?? [])
      this.loadableStudyDetailsTransformationService.setObqValidity(this.selectedLoadableStudy.isObqComplete);
      this.loadableStudyDetailsTransformationService.portUpdated();
    } else {
      this.selectedLoadableStudy = null;
      this.loadableStudies = [];
    }
    this.showGenerateBtn = true;
    this.ngxSpinnerService.hide();
  }

  /**
   * Fetch loadable study details
   *
   * @param {number} vesselId
   * @param {number} voyageId
   * @param {number} loadableStudyId
   * @memberof LoadableStudyDetailsComponent
   */
  async getLoadableStudyDetails(vesselId: number, voyageId: number, loadableStudyId: number) {
    const translationKeys = await this.translateService.get(['TOTAL_QUANTITY_WARNING', 'TOTAL_QUANTITY_ERROR_DETAILS']).toPromise();
    if (this.selectedLoadableStudy?.dischargingCargoId) {
      this.selectedDischargeCargo = { id: this.selectedLoadableStudy?.dischargingCargoId }
    } else {
      this.selectedDischargeCargo = null;
    }
    if (this.selectedDischargeCargo && this.dischargeCargos?.length) {
      this.selectedDischargeCargo = this.dischargeCargos.find(cargo => cargo.id === this.selectedDischargeCargo.id)
    }
    if (!this.dischargingPorts) {
      this.dischargingPorts = [];
      this.dischargingPortData = null;
    } else {
      this.dischargingPortData = this.dischargingPorts[0];
    }
    this.dischargingPortsNames = this.dischargingPorts?.map(port => port?.name).join(", ");

    // if no loadable study is selected set 1st loadable study as selected one and reload
    if (!loadableStudyId) {
      this.router.navigate([`business/cargo-planning/loadable-study-details/${vesselId}/${voyageId}/${this.loadableStudyId}`]);
    } else {
      const portsData = await this.loadableStudyDetailsApiService.getPortsDetails(vesselId, voyageId, this.loadableStudyId).toPromise();
      const portRotationId = portsData.portList ? (portsData?.lastModifiedPortId ? portsData?.lastModifiedPortId : 0) : 0;
      const loadableQuantityResult = await this.loadableQuantityApiService.getLoadableQuantity(this.vesselId, this.voyageId, this.selectedLoadableStudy.id, portRotationId).toPromise();
      if (loadableQuantityResult.responseStatus.status === "200") {
        this.loadableQuantityNew = loadableQuantityResult.loadableQuantity.totalQuantity === '' ? this.getSubTotal(loadableQuantityResult) : loadableQuantityResult.loadableQuantity.totalQuantity;
        if (Number(this.totalQuantity) > Number(this.loadableQuantityNew)) {
          this.messageService.clear();
          this.messageService.add({ severity: 'warn', summary: translationKeys['TOTAL_QUANTITY_WARNING'], detail: translationKeys['TOTAL_QUANTITY_ERROR_DETAILS'] });
        }
        this.loadableQuantityModel = loadableQuantityResult;
      }
    }
  }

  /**
   * Triggering add cargo nomination
   *
   * @memberof LoadableStudyDetailsComponent
   */
  async addCargoNomination() {
    if (AppConfigurationService.settings.restrictMaxNumberOfCargo && this.loadableStudyDetailsApiService.cargoNominations.length >= AppConfigurationService.settings.maxCargoLimit) {
      const translationKeys = await this.translateService.get(['MAXIMUM_CARGO_WARNING', 'MAXIMUM_CARGO_LIMIT_REACHED']).toPromise();
      this.messageService.add({ severity: 'warn', summary: translationKeys['MAXIMUM_CARGO_WARNING'], detail: translationKeys['MAXIMUM_CARGO_LIMIT_REACHED'] });
      return;
    }

    console.log('addCargoNomination' + Date.now()); // TODO: Need to remove after testing.
    this.loadableStudyDetailsTransformationService.addCargoNomination();
  }

  /**
   * Initialise all subscription in this page
   *
   * @private
   * @memberof LoadableStudyDetailsComponent
   */
  private async initSubsciptions() {
    this.loadableStudyDetailsTransformationService.totalQuantityCargoNomination$.pipe(takeUntil(this.ngUnsubscribe)).subscribe(totalQuantity => {
      this.totalQuantity = totalQuantity;
    });
    this.loadableStudyDetailsTransformationService.cargoNominationValidity$.pipe(takeUntil(this.ngUnsubscribe)).subscribe((res) => {
      this.cargoNominationComplete = res;
    })
    this.loadableStudyDetailsTransformationService.portValidity$.pipe(takeUntil(this.ngUnsubscribe)).subscribe((res) => {
      this.portsComplete = res;
    })
    this.loadableStudyDetailsTransformationService.ohqValidity$.pipe(takeUntil(this.ngUnsubscribe)).subscribe((res) => {
      this.ohqComplete = res;
    })
    this.loadableStudyDetailsTransformationService.obqValidity$.pipe(takeUntil(this.ngUnsubscribe)).subscribe((res) => {
      this.obqComplete = res;
    });
    this.loadableStudyDetailsTransformationService.loadableStudyUpdate$.pipe(takeUntil(this.ngUnsubscribe)).subscribe(value => {
      if (value) {
        this.getLoadableStudies(this.vesselId, this.voyageId, this.loadableStudyId);
      }
    });
    this.loadableStudyDetailsApiService.cargoNominationChange.asObservable()
      .pipe(takeUntil(this.ngUnsubscribe))
      .subscribe(() => {
        this.onCargoNominationChange();
      })
    let portRotationId;
    this.loadableStudyDetailsTransformationService.portUpdate$?.pipe(takeUntil(this.ngUnsubscribe),
      switchMap(() => {
        return this.loadableStudyDetailsApiService.getPortsDetails(this.vesselId, this.voyageId, this.loadableStudyId);
      })
    ).subscribe((portResult) => {
      if (portResult.responseStatus?.status === "200") {
        portRotationId = portResult?.lastModifiedPortId;
        this.loadableStudyDetailsTransformationService.ohqUpdated();
      }
    });

    this.loadableStudyDetailsTransformationService.ohqUpdate$?.pipe(takeUntil(this.ngUnsubscribe),
      switchMap(() => {
        return this.loadableQuantityApiService.getLoadableQuantity(this.vesselId, this.voyageId, this.loadableStudyId, portRotationId);
      })
    ).subscribe((loadableQuantityResult: any) => {
      if (loadableQuantityResult?.responseStatus?.status === "200") {
        this.loadableQuantityNew = loadableQuantityResult.loadableQuantity.totalQuantity === '' ? this.getSubTotal(loadableQuantityResult) : loadableQuantityResult.loadableQuantity.totalQuantity;
      }
    });
    this.loadableStudyDetailsTransformationService.loadLineChange$.pipe(takeUntil(this.ngUnsubscribe)).subscribe((res) => {
      this.loadLineChange = res;
    });
    this.loadableStudyDetailsTransformationService.loadablePatternBtnDisable$.pipe(takeUntil(this.ngUnsubscribe)).subscribe(value => {
      this.isServiceWorkerCallActive = value;
    });
    this.loadableStudyDetailsTransformationService.compareLQvalues$.pipe(takeUntil(this.ngUnsubscribe)).subscribe(success => {
      this.checkLoadableQuntityChangeInPopup();
    });
  }

  /**
   * Listen events in this page
   *
   * @private
   * @memberof LoadableStudyDetailsComponent
   */
  private async listenEvents() {
    navigator.serviceWorker.addEventListener('message', this.swMessageHandler);
  }

  /**
   * Handler for service worker message event
   *
   * @private
   * @memberof LoadableStudyDetailsComponent
   */
  private swMessageHandler = async event => {
    let isValidStatus = false;
    if (event?.data?.syncType === 'loadable-study-pattern-status') {
      isValidStatus = true;
    }
    if (event?.data?.status === '401' && event?.data?.errorCode === '210' && isValidStatus) {
      this.globalErrorHandler.sessionOutMessage();
    } else if (environment.name !== 'shore' && (event?.data?.status === '200' || event?.data?.responseStatus?.status === '200') && isValidStatus) {
      SecurityService.refreshToken(event?.data?.refreshedToken)
    }
    if (event.data.type === 'loadable-pattern-processing' && this.router.url.includes('loadable-study-details')) {
      if (event.data.pattern?.loadableStudyId === this.loadableStudyId) {
        this.isGenerateClicked = true;
        this.processingMessage();
      } else {
        this.messageService.clear();
      }
    } else if (event.data.type === 'loadable-study-communicated-to-shore' && this.router.url.includes('loadable-study-details')) {
      if (event.data.pattern?.loadableStudyId === this.loadableStudyId) {
        this.isGenerateClicked = true;
        this.selectedLoadableStudy.statusId = LOADABLE_STUDY_STATUS.PLAN_COMMUNICATED_TO_SHORE;
        this.selectedLoadableStudy.status = LOADABLE_STUDY_STATUS_TEXT.PLAN_COMMUNICATED_TO_SHORE;
        this.messageService.clear();
        const translationKeys = await this.translateService.get(['GENERATE_LOADABLE_PATTERN_COMMUNICATION_TO_SHORE_DETAILS', 'GENERATE_LOADABLE_PATTERN_COMMUNICATION_TO_SHORE_INFO']).toPromise();
        this.messageService.add({ severity: 'info', summary: translationKeys['GENERATE_LOADABLE_PATTERN_COMMUNICATION_TO_SHORE_INFO'], detail: translationKeys['GENERATE_LOADABLE_PATTERN_COMMUNICATION_TO_SHORE_DETAILS'], life: 1000, closable: false });
      } else {
        this.messageService.clear();
      }
    }
    else if (event.data.type === 'loadable-pattern-loadicator-checking' && this.router.url.includes('loadable-study-details')) {
      if (event.data.pattern?.loadableStudyId === this.loadableStudyId) {
        this.isGenerateClicked = true;
        this.selectedLoadableStudy.statusId = LOADABLE_STUDY_STATUS.PLAN_LOADICATOR_CHECKING;
        this.selectedLoadableStudy.status = LOADABLE_STUDY_STATUS_TEXT.PLAN_LOADICATOR_CHECKING;
        this.messageService.clear();
        const translationKeys = await this.translateService.get(['GENERATE_LOADABLE_PATTERN_INFO', 'GENERATE_LOADABLE_PATTERN_LOADICATOR_CHECKING']).toPromise();
        this.messageService.add({ severity: 'info', summary: translationKeys['GENERATE_LOADABLE_PATTERN_INFO'], detail: translationKeys['GENERATE_LOADABLE_PATTERN_LOADICATOR_CHECKING'], life: 1000, closable: false });
      } else {
        this.messageService.clear();
      }
    }
    else if (event.data.type === 'loadable-pattern-completed') {
      if (event.data.pattern?.loadableStudyId === this.loadableStudyId) {
        this.isPatternGenerated = true;
        this.selectedLoadableStudy.statusId = LOADABLE_STUDY_STATUS.PLAN_GENERATED;
        this.selectedLoadableStudy.status = LOADABLE_STUDY_STATUS_TEXT.PLAN_GENERATED;
      }
      this.generatedMessage(event.data.pattern.selectedVoyageNo, event.data.pattern.selectedLoadableStudyName);
    }
    else if (event.data.type === 'loadable-pattern-no-solution') {
      if (event.data.pattern?.loadableStudyId === this.loadableStudyId) {
        this.isPatternOpenOrNoplan = false;
        this.isPatternGenerated = false;
        this.isGenerateClicked = false;
        this.getAlgoErrorMessage(true);
        this.selectedLoadableStudy.statusId = LOADABLE_STUDY_STATUS.PLAN_NO_SOLUTION;
        this.selectedLoadableStudy.status = LOADABLE_STUDY_STATUS_TEXT.PLAN_NO_SOLUTION;
      }
      this.noPlanMessage(event.data.pattern.selectedVoyageNo, event.data.pattern.selectedLoadableStudyName)
    }
    else if (event.data.type === 'loadable-pattern-error-occured') {
      if (event.data.pattern?.loadableStudyId === this.loadableStudyId) {
        this.isPatternOpenOrNoplan = false;
        this.isPatternGenerated = false;
        this.isGenerateClicked = false;
        this.getAlgoErrorMessage(true);
        this.selectedLoadableStudy.statusId = LOADABLE_STUDY_STATUS.PLAN_ERROR;
        this.selectedLoadableStudy.status = LOADABLE_STUDY_STATUS_TEXT.PLAN_ERROR;
      }
      this.errorOccurdMessage(event.data.pattern.selectedVoyageNo, event.data.pattern.selectedLoadableStudyName)
    }
    else if (event.data.type === 'loadable-pattern-no-response') {
      if (event.data.pattern?.loadableStudyId === this.loadableStudyId) {
        this.isPatternOpenOrNoplan = false;
        this.isPatternGenerated = false;
        this.isGenerateClicked = false;
      }
      this.noResponseMessage(event.data.pattern.selectedVoyageNo, event.data.pattern.selectedLoadableStudyName);
    }
    if (isValidStatus) {
      this.setProcessingLoadableStudyActions(event.data?.pattern?.loadableStudyId, event.data.statusId);
    }
  }

  /**
* Get algo error response
* @returns {Promise<IAlgoResponse>}
* @memberof LoadablePlanComponent
*/
  async getAlgoErrorMessage(status: boolean) {
    const algoError: IAlgoResponse = await this.loadableStudyDetailsApiService.getAlgoErrorDetails(this.vesselId, this.voyageId, this.loadableStudyId).toPromise();
    if (algoError.responseStatus.status === '200') {
      this.errorMessage = algoError.algoErrors;
      this.errorPopup = status;
    }
  }

  /**
* view algo error message
* @param {boolean} status
* @memberof LoadablePlanComponent
*/
  public viewError(status: boolean) {
    this.errorPopup = status;
  }

  /**
   * Enable/ Disable actions of currently processing/processed loadable study
   *
   * @param {*} event
   * @memberof LoadableStudyDetailsComponent
   */
  setProcessingLoadableStudyActions(loadableStudyId: number, statusId: number, loadableStudies: LoadableStudy[] = null) {
    loadableStudies = loadableStudies ?? this.loadableStudies;
    const _loadableStudies = loadableStudies?.map(loadableStudy => {
      if (loadableStudyId === loadableStudy?.id) {
        loadableStudy.statusId = statusId;
        switch (statusId) {
          case 1:
            loadableStudy.status = LOADABLE_STUDY_STATUS_TEXT.PLAN_PENDING
            break;
          case 2:
            loadableStudy.status = LOADABLE_STUDY_STATUS_TEXT.PLAN_CONFIRMED
            break;
          case 3:
            loadableStudy.status = LOADABLE_STUDY_STATUS_TEXT.PLAN_GENERATED
            break;
          case 4:
            loadableStudy.status = LOADABLE_STUDY_STATUS_TEXT.PLAN_ALGO_PROCESSING
            break;
          case 5:
            loadableStudy.status = LOADABLE_STUDY_STATUS_TEXT.PLAN_ALGO_PROCESSING_COMPETED
            break;
          case 6:
            loadableStudy.status = LOADABLE_STUDY_STATUS_TEXT.PLAN_NO_SOLUTION
            break;
          case 7:
            loadableStudy.status = LOADABLE_STUDY_STATUS_TEXT.PLAN_LOADICATOR_CHECKING
            break;
          case 11:
            loadableStudy.status = LOADABLE_STUDY_STATUS_TEXT.PLAN_ERROR
            break;
          case 21:
            loadableStudy.status = LOADABLE_STUDY_STATUS_TEXT.PLAN_COMMUNICATED_TO_SHORE
            break;
          default:
            break;
        }
        if ([LOADABLE_STUDY_STATUS.PLAN_ALGO_PROCESSING, LOADABLE_STUDY_STATUS.PLAN_ALGO_PROCESSING_COMPETED, LOADABLE_STUDY_STATUS.PLAN_LOADICATOR_CHECKING, LOADABLE_STUDY_STATUS.PLAN_COMMUNICATED_TO_SHORE].includes(statusId) && this.router.url.includes('loadable-study-details')) {
          loadableStudy.isActionsEnabled = false;
        }
        else if ([2, 3].includes(statusId)) {
          loadableStudy.isEditable = false;
          loadableStudy.isDeletable = false;
          loadableStudy.isActionsEnabled = true;
        }
        else if ([6, 1, 11].includes(statusId)) {
          loadableStudy.isActionsEnabled = true;
          if (this.loadableStudyId === loadableStudyId) {
            this.selectedLoadableStudy = JSON.parse(JSON.stringify(loadableStudy));
          }
        }
      } else if (!loadableStudyId && !statusId) {
        loadableStudy.isActionsEnabled = [LOADABLE_STUDY_STATUS.PLAN_COMMUNICATED_TO_SHORE, LOADABLE_STUDY_STATUS.PLAN_ALGO_PROCESSING, LOADABLE_STUDY_STATUS.PLAN_ALGO_PROCESSING_COMPETED, LOADABLE_STUDY_STATUS.PLAN_LOADICATOR_CHECKING].includes(loadableStudy?.statusId) ? false : true;
        loadableStudy.isEditable = (loadableStudy?.statusId === 3 || loadableStudy?.statusId === 2) ? false : true;
        loadableStudy.isDeletable = (loadableStudy?.statusId === 3 || loadableStudy?.statusId === 2) ? false : true;
      }
      return loadableStudy;
    });
    this.loadableStudies = _loadableStudies;
  }

  /**
   * Method for fetching all ports from master
   *
   * @private
   * @memberof LoadableStudyDetailsComponent
   */
  private async getPorts(): Promise<IPort[]> {
    const result = await this.loadableStudyDetailsApiService.getPorts().toPromise();
    return result;
  }

  /**
   * Handler for discharge port dropdown change
   *
   * @param {Event} event
   * @memberof LoadableStudyDetailsComponent
   */
  async onDischargePortChange(event) {
    this.dischargingPorts = [event?.value];
    this.updatingDischargingPort();
    this.loadableStudyDetailsTransformationService.setPortValidity(false);
  }

  /**
   * updating discharging port
   * @memberof LoadableStudyDetailsComponent
   */
  updatingDischargingPort() {
    const sucessKeys = ['LOADABLE_STUDY_DISCHARGING_PORT_UPDATE_SUCCESS', 'LOADABLE_STUDY_DISCHARGING_PORT_UPDATE_SUCCESSFULLY']
    this.updateDischargeData(sucessKeys);
  }

  /**
   * Handler for voyage dropdown change
   *
   * @param {*} event
   * @memberof LoadableStudyDetailsComponent
   */
  onVoyageChange(event) {
    this.voyageId = event?.value?.id;
    this.loadableStudies = null;
    this.loadableStudyId = 0;
    this.loadableQuantityNew = '0';
    this.loadableStudyDetailsTransformationService.setTotalQuantityCargoNomination(0);
    this.loadableStudyDetailsTransformationService.setCargoNominationValidity(false);
    this.loadableStudyDetailsTransformationService.setPortValidity(false);
    this.loadableStudyDetailsTransformationService.setOHQValidity([]);
    this.loadableStudyDetailsTransformationService.setObqValidity(false);
    this.tabPermission();
    this.selectedLoadableStudy = null;
    this.initSubsciptions();
    this.router.navigate([`business/cargo-planning/loadable-study-details/${this.vesselId}/${this.voyageId}/0`]);
  }

  /**
  * Triggering add port
  *
  * @memberof LoadableStudyDetailsComponent
  */
  addPort() {
    this.loadableStudyDetailsTransformationService.addPort();
  }

  /**
   * Handler for on delete event from side panel
   *
   * @param {*} event
   * @memberof LoadableStudyDetailsComponent
   */
  onDeleteLoadableStudy(event) {
    this.loadableStudies.splice(event?.index, 1);
    //If deleted loadable study is equal to currently selected loadable study then we need reset the selection
    if (event?.data?.id === this.loadableStudyId) {
      if (this.loadableStudies && this.loadableStudies.length) {
        this.selectedLoadableStudy = this.loadableStudies[0];
      } else {
        this.loadableStudyId = 0;
        this.loadableQuantityNew = '0';
        this.loadableStudyDetailsTransformationService.setTotalQuantityCargoNomination(0);
        this.loadableStudyDetailsTransformationService.setCargoNominationValidity(false);
        this.selectedTab = LOADABLE_STUDY_DETAILS_TABS.PORTS;
        this.selectedLoadableStudy = null;
        this.router.navigate([`business/cargo-planning/loadable-study-details/${this.vesselId}/${this.voyageId}/0`]);
      }
    }
  }

  /**
   * On Click of tab in lodable study details page
   *
   * @param {string} selectedTab
   * @memberof LoadableStudyDetailsComponent
   */
  async onTabClick(selectedTab: string) {
    if (!this?.loadableStudies?.length) {
      this.selectedTab = selectedTab;
      return;
    }
    const translationKeys = await this.translateService.get(['CARGONOMINATION_DISCHARGE_PORT_ERROR_SUMMARY', 'CARGONOMINATION_LOADING_DISCHARGING_PORT_ERROR_DETAILS']).toPromise();
    if (selectedTab !== LOADABLE_STUDY_DETAILS_TABS.PORTS) {
      if (this.dischargingPorts?.length && this.loadingPorts?.length) {
        this.selectedTab = selectedTab;
        this.isSelectedDischargePort = true;
      }
      else {
        this.isSelectedDischargePort = false;
        this.messageService.add({ severity: 'error', summary: translationKeys['CARGONOMINATION_DISCHARGE_PORT_ERROR_SUMMARY'], detail: translationKeys['CARGONOMINATION_LOADING_DISCHARGING_PORT_ERROR_DETAILS'] });
      }
    } else {
      this.selectedTab = selectedTab;
    }
    if (this.selectedTab !== 'PORTS') {
      this.portUpdate(false);
    }
    this.loadableStudyDetailsTransformationService.disableGenerateLoadablePatternBtn(false);
  }

  /**
   * Show loadable quantity popup
   */
  showLoadableQuantityPopup() {
    if (!this.loadableStudies?.length) {
      return;
    }
    this.displayLoadableQuantity = true;
  }

  /**
   * Value from Loadable Quantity Popup
   */
  displayPopUpTab(displayNew_: boolean) {
    this.displayLoadableQuantity = displayNew_;
  }


  /**
   * Loadable quantity  from loadable quantity popup
   */
  async loadableQuantity(newloadableQuantity: string) {
    this.loadableQuantityNew = newloadableQuantity;
    const translationKeys = await this.translateService.get(['TOTAL_QUANTITY_WARNING', 'TOTAL_QUANTITY_ERROR_DETAILS']).toPromise();
    if (Number(this.totalQuantity) > Number(this.loadableQuantityNew)) {
      this.messageService.add({ severity: 'warn', summary: translationKeys['TOTAL_QUANTITY_WARNING'], detail: translationKeys['TOTAL_QUANTITY_ERROR_DETAILS'] });
    }
  }

  /**
   * Display commingle popup
   */
  showComminglePopup() {
    this.displayCommingle = true;
  }

  /**
   * Value from commingle popup
   */
  displayComminglePopUpTab(displayNew_: boolean) {
    this.displayCommingle = displayNew_;
  }

  /**
 * Cargo nomination update event haandler get value from commingle button
 */
  async cargoNominationUpdate(event) {
    this.showCommingleButton = event.value;
    // Show alert if total quantity exceeds loadable quantity
    if (event.error) {
      const translationKeys = await this.translateService.get(['TOTAL_QUANTITY_WARNING', 'TOTAL_QUANTITY_ERROR_DETAILS']).toPromise();
      if (Number(this.loadableQuantityNew) && Number(this.totalQuantity) > Number(this.loadableQuantityNew)) {
        this.messageService.clear();
        this.messageService.add({ severity: 'warn', summary: translationKeys['TOTAL_QUANTITY_WARNING'], detail: translationKeys['TOTAL_QUANTITY_ERROR_DETAILS'] });
      }
    }
  }


  /**
 * Port update event haandler get value from commingle button
 */
  async portUpdate(event) {
    this.showLoadableQuantityButton = event;
  }

  /**
   * function to emit incomplete status change
   * @param {*} event
   * @memberof LoadableStudyDetailsComponent
   */
  async portOhqStatusUpdate(event) {
    this.portsComplete = event;
    this.ohqComplete = event;
  }

  /**
   * Function to emit status change of ohq tab while adding new ports
   *
   * @param {*} event
   * @memberof LoadableStudyDetailsComponent
   */
  async ohqStatusUpdate(event) {
    this.ohqComplete = event;
  }

  /**
 * Take the user to particular pattern history
 */
  navigateToPatternHistory(isViewPattern) {
    this.router.navigate([`/business/cargo-planning/loadable-pattern-history/${isViewPattern}/${this.vesselId}/${this.voyageId}/${this.loadableStudyId}`]);
  }

  /**
   * Handler for loadable study chnage change
   *
   * @param {*} event
   * @memberof LoadableStudyDetailsComponent
   */
  async onLoadableStudyChange(event) {
    if (event !== this.loadableStudyId) {
      this.ngxSpinnerService.show();
      this.loadableStudyId = event;
      this.loadableStudyDetailsTransformationService.setCargoNominationValidity(false);
      this.loadableStudyDetailsTransformationService.setPortValidity(false);
      this.loadableStudyDetailsTransformationService.setOHQValidity([]);
      this.loadableStudyDetailsTransformationService.setObqValidity(false);
      this.isGenerateClicked = false;
      this.tabPermission();
      this.ngxSpinnerService.hide();
      this.router.navigate([`business/cargo-planning/loadable-study-details/${this.vesselId}/${this.voyageId}/${this.loadableStudyId}`]);
    }
  }

  /**
   * is discharge port available
   *
   * @param {*} event
   * @memberof LoadableStudyDetailsComponent
   */
  async isDischargePortAvailable() {
    this.dischargingPorts = this.selectedLoadableStudy?.dischargingPortIds?.map(portId => this.ports.find(port => port?.id === portId));
    if (!this.dischargingPorts) {
      this.dischargingPorts = [];
    }
    this.dischargingPortsNames = this.dischargingPorts?.map(port => port?.name).join(", ");
  }

  /**
   * Get error if no discharge port is selected
   */
  fieldError() {
    if (this.dischargingPorts?.length > 0) {
      return null;
    }
    else {
      return { required: true };
    }
  }

  /**
   * Actions to do when cargo nomination data changes
   */
  onCargoNominationChange() {
    this.dischargeCargos = []
    this.loadableStudyDetailsApiService.cargoNominations.forEach(cargoNomination => {
      if (!cargoNomination.isAdd && !this.dischargeCargos.some(cargo => cargo?.id === cargoNomination?.id)) {
        const _cargo: ICargo = { id: cargoNomination.id, name: cargoNomination.cargo.value.name, colorCode: cargoNomination.color.value, abbreviation: cargoNomination.abbreviation.value };
        this.dischargeCargos.push(_cargo);
      }
    });
    this.selectedDischargeCargo = this.dischargeCargos?.find(cargo => cargo?.id === this.selectedLoadableStudy?.dischargingCargoId)
  }


  /**
 * Handler for discharge cargo dropdown change
 *
 * @param {Event} event
 * @memberof LoadableStudyDetailsComponent
 */
  async onDischargeCargoChange(event) {
    const sucessKeys = ['LOADABLE_STUDY_DISCHARGING_CARGO_UPDATE_SUCCESS', 'LOADABLE_STUDY_DISCHARGING_CARGO_UPDATE_SUCCESSFULLY']
    this.updateDischargeData(sucessKeys)
  }

  /**
   * Method to save discharge data for loadable study
   *
   * @param {string[]} sucessKeys
   * @memberof LoadableStudyDetailsComponent
   */
  async updateDischargeData(sucessKeys: string[]) {
    this.ngxSpinnerService.show();
    this.selectedLoadableStudy.dischargingPortIds = this.dischargingPorts?.map(port => port.id);
    this.selectedLoadableStudy.dischargingCargoId = this.selectedDischargeCargo?.id;
    const dischargingPortIds: IDischargingPortIds = {
      portIds: this.selectedLoadableStudy.dischargingPortIds,
      cargoNominationId: this.selectedDischargeCargo?.id ?? null,
      isDischargingPortComplete: !!this.selectedLoadableStudy.dischargingPortIds?.length
    };
    try {
      const res = await this.loadableStudyDetailsApiService.setLoadableStudyDischargingPorts(this.vesselId, this.voyageId, this.loadableStudyId, dischargingPortIds).toPromise();
      if (res?.responseStatus?.status === "200") {
        const translationKeys = await this.translateService.get(sucessKeys).toPromise();
        this.messageService.add({ severity: 'success', summary: translationKeys[sucessKeys[0]], detail: translationKeys[sucessKeys[1]] });
      }
    }
    catch (errorResponse) {
      const translationKeys = await this.translateService.get(['CARGO_NOMINATION_PORT_SELECTION_ERROR_DETAIL', 'CARGO_NOMINATION_PORT_SELECTION_ERROR', 'LOADABLE_STUDY_DISCHARGE_PORT_ERROR', 'LOADABLE_STUDY_DISCHARGE_PORT_STATUS_ERROR']).toPromise();
      if (errorResponse?.error?.errorCode === 'ERR-RICO-110' || errorResponse?.error?.errorCode === 'ERR-RICO-392') {
        this.messageService.add({ severity: 'error', summary: translationKeys['LOADABLE_STUDY_DISCHARGE_PORT_ERROR'], detail: translationKeys['LOADABLE_STUDY_DISCHARGE_PORT_STATUS_ERROR'], life: 10000 });
      } else {
        if (errorResponse.error.errorCode === 'ERR-RICO-107') {
          this.messageService.add({ severity: 'error', summary: translationKeys['CARGO_NOMINATION_PORT_SELECTION_ERROR'], detail: translationKeys['CARGO_NOMINATION_PORT_SELECTION_ERROR_DETAIL'] });
          const dischargingPorts = [...this.dischargingPorts];
          dischargingPorts.splice(dischargingPorts.length - 1, 1);
          this.dischargingPorts = [...dischargingPorts];
        }
      }
    }

    this.dischargingPortsNames = this.dischargingPorts?.map(port => port?.name).join(", ");
    this.ngxSpinnerService.hide();
  }

  /**
  * Calculation for subtotal
  */
  getSubTotal(loadableQuantityResult: any): any {
    const loadableQuantity = loadableQuantityResult.loadableQuantity;
    let subTotal = 0;
    const sgCorrection = (loadableQuantity.estSeaDensity && loadableQuantity.displacmentDraftRestriction) && (Number(loadableQuantity.estSeaDensity) - 1.025) / 1.025 * Number(loadableQuantity.displacmentDraftRestriction);
    if (loadableQuantityResult.caseNo === 1 || loadableQuantityResult.caseNo === 2) {
      const data: ISubTotal = {
        dwt: loadableQuantity.dwt,
        sagCorrection: loadableQuantity.saggingDeduction,
        sgCorrection: sgCorrection.toString(),
        foOnboard: loadableQuantity.estFOOnBoard,
        doOnboard: loadableQuantity.estDOOnBoard,
        freshWaterOnboard: loadableQuantity.estFreshWaterOnBoard,
        ballast: loadableQuantity.ballast,
        constant: loadableQuantity.constant,
        obqSlops: loadableQuantity.obqSlops === '' ? 0 : loadableQuantity.obqSlops,
        others: loadableQuantity.otherIfAny === '' ? 0 : loadableQuantity.otherIfAny
      }
      subTotal = Number(this.loadableStudyDetailsTransformationService.getSubTotal(data));
      return this.getTotalLoadableQuantity(subTotal, loadableQuantityResult);
    } else {
      const dwt = (Number(loadableQuantity.displacmentDraftRestriction) - Number(loadableQuantity.vesselLightWeight))?.toString();
      const data: ISubTotal = {
        dwt: dwt,
        sagCorrection: loadableQuantity.saggingDeduction,
        sgCorrection: sgCorrection.toString(),
        foOnboard: loadableQuantity.estFOOnBoard,
        doOnboard: loadableQuantity.estDOOnBoard,
        freshWaterOnboard: loadableQuantity.estFreshWaterOnBoard,
        ballast: loadableQuantity.ballast,
        constant: loadableQuantity.constant,
        obqSlops: loadableQuantity.obqSlops === '' ? 0 : loadableQuantity.obqSlops,
        others: loadableQuantity.otherIfAny === '' ? 0 : loadableQuantity.otherIfAny
      }
      subTotal = Number(this.loadableStudyDetailsTransformationService.getSubTotal(data));
      return this.getTotalLoadableQuantity(subTotal, loadableQuantityResult);
    }
  }


  /**
   * Calculation for Loadable quantity
  */
  getTotalLoadableQuantity(subTotal: number, loadableQuantityResult: any): any {
    const loadableQuantity = loadableQuantityResult.loadableQuantity;
    let loadableQuantityNew;
    if (loadableQuantityResult.caseNo === 1) {
      const total = Number(subTotal) + Number(loadableQuantity.foConInSZ);
      if (total < 0) {
        loadableQuantityNew = '0';
      } else {
        loadableQuantityNew = total?.toString();
      }
    } else {
      if (subTotal < 0) {
        loadableQuantityNew = '0';
      } else {
        loadableQuantityNew = subTotal?.toString();
      }
    }
    return loadableQuantityNew;
  }

  /**
* Handler for Generate loadable pattern button
*
* @memberof LoadableStudyDetailsComponent
*/
  async onGenerateLoadablePattern() {
    this.ngxSpinnerService.show();
    const isLQvalueNotChanged = await this.checkLoadableQuntityChangeInPopup();
    if (isLQvalueNotChanged) {
      await this.generateLoadablePattern(this.vesselId, this.voyageId, this.loadableStudyId, this.selectedVoyage.voyageNo, this.selectedLoadableStudy.name);
      this.ngxSpinnerService.hide();
    }
  }

  /**
   * function to compare the lQ total with front-end calculated and DB
   *
   * @return {*}  {Promise<boolean>}
   * @memberof LoadableStudyDetailsComponent
   */
  async checkLoadableQuntityChangeInPopup(): Promise<boolean> {
    let isEqual = false;
    const translationKeys = await this.translateService.get(['LOADABLE_QUANTITY_WARNING', 'TOTAL_QUANTITY_ERROR_DETAILS', 'LOADABLE_QUANTITY_WARNING_MISMATCH']).toPromise();
    const portsData = await this.loadableStudyDetailsApiService.getPortsDetails(this.vesselId, this.voyageId, this.loadableStudyId).toPromise();
    const portRotationId = (portsData.portList && portsData?.lastModifiedPortId) ?? portsData?.lastModifiedPortId;
    const loadableQuantityResult = await this.loadableQuantityApiService.getLoadableQuantity(this.vesselId, this.voyageId, this.selectedLoadableStudy.id, portRotationId).toPromise();
    if (loadableQuantityResult.responseStatus.status === "200") {
      let calculatedTotQty = this.sliceToTwoDecimalPoint(this.getSubTotal(loadableQuantityResult), 2);
      const databaseTotQty = this.sliceToTwoDecimalPoint(loadableQuantityResult.loadableQuantity.totalQuantity, 2);

      this.loadableQuantityNew = calculatedTotQty;
      if (Number(this.totalQuantity) > Number(this.loadableQuantityNew)) {
        this.messageService.add({ severity: 'warn', summary: translationKeys['TOTAL_QUANTITY_WARNING'], detail: translationKeys['TOTAL_QUANTITY_ERROR_DETAILS'],sticky: true });
        this.ngxSpinnerService.hide();
        return false;
      }

      if (loadableQuantityResult.caseNo === 1) {
        calculatedTotQty = loadableQuantityResult.loadableQuantity.foConInSZ === '' ? '0' : calculatedTotQty;
      }

      if (Number(calculatedTotQty) === Number(databaseTotQty)) {
        isEqual = true;
      } else {
        this.ngxSpinnerService.hide();
        this.messageService.clear();
        this.messageService.add({ severity: 'warn', summary: translationKeys['LOADABLE_QUANTITY_WARNING'], detail: translationKeys['LOADABLE_QUANTITY_WARNING_MISMATCH'] });
      }
    }
    return isEqual;
  }

  /**
   * function to slice the stringified decimal value
   * @param {string} value
   * @param {number} limit
   * @return {*}  {string}
   * @memberof LoadableStudyDetailsComponent
   */
  sliceToTwoDecimalPoint(value: string, limit: number): string {
    if (value && value.includes('.')) {
      const wholepart = value.split('.')[0];
      const decimalPart = value.split('.')[1].slice(0, limit);
      return [wholepart, decimalPart].join('.');
    } else {
      return value;
    }
  }

  /**
  * Handler for Generate loadable pattern
  *
  * @param {number} vesselId
  * @param {number} voyageId
  * @param {number} loadableStudyId
  * @memberof LoadableStudyDetailsComponent
  */
  async generateLoadablePattern(vesselId: number, voyageId: number, loadableStudyId: number, selectedVoyageNo: string, selectedLoadableStudyName: string) {
    this.ngxSpinnerService.show();
    const data = {
      vesselId: vesselId,
      voyageId: voyageId,
      loadableStudyId: loadableStudyId,
      selectedVoyageNo: selectedVoyageNo,
      selectedLoadableStudyName: selectedLoadableStudyName,
      processId: null
    }

    try {
      this.selectedLoadableStudy.isActionsEnabled = false;
      const res = await this.loadableStudyDetailsApiService.generateLoadablePattern(vesselId, voyageId, loadableStudyId).toPromise();
      if (res.responseStatus.status === '200') {
        this.isGenerateClicked = true;
        if (environment.name === 'shore') {
          this.selectedLoadableStudy.statusId = LOADABLE_STUDY_STATUS.PLAN_ALGO_PROCESSING;
          this.selectedLoadableStudy.status = LOADABLE_STUDY_STATUS_TEXT.PLAN_ALGO_PROCESSING;
        } else {
          this.selectedLoadableStudy.statusId = LOADABLE_STUDY_STATUS.PLAN_COMMUNICATED_TO_SHORE;
          this.selectedLoadableStudy.status = LOADABLE_STUDY_STATUS_TEXT.PLAN_COMMUNICATED_TO_SHORE;
        }
        data.processId = res.processId;
        if (res.processId) {
          navigator.serviceWorker.controller.postMessage({ type: 'loadable-pattern-status', data });
          this.selectedLoadableStudy = { ...this.selectedLoadableStudy };
        } else {
          this.isGenerateClicked = false;
        }
      } else {
        this.selectedLoadableStudy.isActionsEnabled = true;
        this.isGenerateClicked = false;
      }
    }
    catch (errorResponse) {
      this.selectedLoadableStudy.statusId = 11;
      this.selectedLoadableStudy.status = LOADABLE_STUDY_STATUS_TEXT.PLAN_ERROR;
      this.selectedLoadableStudy.isActionsEnabled = true;
      if (errorResponse?.error?.errorCode === 'ERR-RICO-110' || errorResponse?.error?.errorCode === 'ERR-RICO-392') {
        const translationKeys = await this.translateService.get(['LOADABLE_STUDY_GENERATE_PATTERN_ERROR', 'LOADABLE_STUDY_GENERATE_PATTERN_STATUS_ERROR']).toPromise();
        this.messageService.add({ severity: 'error', summary: translationKeys['LOADABLE_STUDY_GENERATE_PATTERN_ERROR'], detail: translationKeys['LOADABLE_STUDY_GENERATE_PATTERN_STATUS_ERROR'], life: 10000 });
      }
      if (errorResponse?.error?.errorCode === 'ERR-RICO-521') {
        const translationKeys = await this.translateService.get(['LOADABLE_STUDY_GENERATE_PATTERN_QUANTITY_ERROR', 'LOADABLE_STUDY_GENERATE_PATTERN_QUANTITY_STATUS_ERROR']).toPromise();
        this.messageService.add({ severity: 'error', summary: translationKeys['LOADABLE_STUDY_GENERATE_PATTERN_QUANTITY_ERROR'], detail: translationKeys['LOADABLE_STUDY_GENERATE_PATTERN_QUANTITY_STATUS_ERROR'], life: 10000 });
      }
      if (errorResponse?.error?.errorCode === 'ERR-RICO-114') {
        const translationKeys = await this.translateService.get(['LOADABLE_STUDY_GENERATE_PATTERN_QUANTITY_ERROR', 'LOADABLE_STUDY_COMMINGLE_LOADABLE_QTY_ERROR']).toPromise();
        this.messageService.add({ severity: 'error', summary: translationKeys['LOADABLE_STUDY_GENERATE_PATTERN_QUANTITY_ERROR'], detail: translationKeys['LOADABLE_STUDY_COMMINGLE_LOADABLE_QTY_ERROR'], life: 10000 });
      }
      if (errorResponse?.error?.errorCode === 'ERR-RICO-395') {
        const translationKeys = await this.translateService.get(['LOADABLE_STUDY_GENERATE_PATTERN_ERROR', 'LOADABLE_STUDY_COMMINGLE_LOADING_PORT_ERROR']).toPromise();
        this.messageService.add({ severity: 'error', summary: translationKeys['LOADABLE_STUDY_GENERATE_PATTERN_ERROR'], detail: translationKeys['LOADABLE_STUDY_COMMINGLE_LOADING_PORT_ERROR'], life: 10000 });
      }
    }
    this.ngxSpinnerService.hide();
  }

  /**
   * Toast to show pattern processing
   *
   * @memberof LoadableStudyDetailsComponent
   */
  async processingMessage() {
    this.messageService.clear();
    const translationKeys = await this.translateService.get(['GENERATE_LOADABLE_PATTERN_INFO', 'GENERATE_LOADABLE_PATTERN_PROCESSING']).toPromise();
    this.messageService.add({ severity: 'info', summary: translationKeys['GENERATE_LOADABLE_PATTERN_INFO'], detail: translationKeys['GENERATE_LOADABLE_PATTERN_PROCESSING'], life: 1000, closable: false });
  }

  /**
 * Toast to show pattern generate complete
 *
 * @param {string} selectedVoyageNo
 * @param {string} selectedLoadableStudyName
 * @memberof LoadableStudyDetailsComponent
 */
  async generatedMessage(selectedVoyageNo: string, selectedLoadableStudyName: string) {
    const translationKeys = await this.translateService.get(['GENERATE_LOADABLE_PATTERN_COMPLETE_DONE', 'GENERATE_LOADABLE_PATTERN_COMPLETED']).toPromise();
    this.messageService.add({ severity: 'success', summary: translationKeys['GENERATE_LOADABLE_PATTERN_COMPLETE_DONE'], detail: selectedVoyageNo + " " + selectedLoadableStudyName + " " + translationKeys['GENERATE_LOADABLE_PATTERN_COMPLETED'], sticky: true, closable: true });
  }

  /**
 * Toast to show for generating pattern have no solution
 *
 * @param {string} selectedVoyageNo
 * @param {string} selectedLoadableStudyName
 * @memberof LoadableStudyDetailsComponent
 */
  async noPlanMessage(selectedVoyageNo: string, selectedLoadableStudyName: string) {
    this.messageService.clear();
    const translationKeys = await this.translateService.get(['GENERATE_LOADABLE_PATTERN_NO_PLAN', 'GENERATE_LOADABLE_PATTERN_NO_PLAN_MESSAGE']).toPromise();
    this.messageService.add({ severity: 'error', summary: translationKeys['GENERATE_LOADABLE_PATTERN_NO_PLAN'], detail: selectedVoyageNo + " " + selectedLoadableStudyName + " " + translationKeys['GENERATE_LOADABLE_PATTERN_NO_PLAN_MESSAGE'] });
  }

  /**
   * Toast to show for generating pattern have algo error
   * @param {string} selectedVoyageNo
   * @param {string} selectedLoadableStudyName
   * @memberof LoadableStudyDetailsComponent
   */
  async errorOccurdMessage(selectedVoyageNo: string, selectedLoadableStudyName: string) {
    this.messageService.clear();
    const translationKeys = await this.translateService.get(['GENERATE_LOADABLE_PATTERN_ERROR_OCCURED', 'GENERATE_LOADABLE_PATTERN_ERROR_OCCURED_MESSAGE']).toPromise();
    this.messageService.add({ severity: 'error', summary: translationKeys['GENERATE_LOADABLE_PATTERN_ERROR_OCCURED'], detail: selectedVoyageNo + " " + selectedLoadableStudyName + " " + translationKeys['GENERATE_LOADABLE_PATTERN_ERROR_OCCURED_MESSAGE'] });
  }

  /**
* Toast to show pattern bo reposnse
*
* @param {string} selectedVoyageNo
* @param {string} selectedLoadableStudyName
* @memberof LoadableStudyDetailsComponent
*/
  async noResponseMessage(selectedVoyageNo: string, selectedLoadableStudyName: string) {
    const translationKeys = await this.translateService.get(['GENERATE_LOADABLE_PATTERN_NO_RESPONSE_ERROR', 'GENERATE_LOADABLE_PATTERN_RESPONSE']).toPromise();
    this.messageService.add({ severity: 'error', summary: translationKeys['GENERATE_LOADABLE_PATTERN_NO_RESPONSE_ERROR'], detail: selectedVoyageNo + " " + selectedLoadableStudyName + " " + translationKeys['GENERATE_LOADABLE_PATTERN_RESPONSE'], sticky: true, closable: true });
  }

  /* Handler for unit change event
 *
 * @param {*} event
 * @memberof LoadableStudyDetailsComponent
 */
  onUnitChange(event) {
    this.loadableStudyDetailsApiService.unitChange.next();
    this.currentUnit = <QUANTITY_UNIT>localStorage.getItem('unit');
    this.currentObqUnit = <QUANTITY_UNIT>localStorage.getItem('unitObs');
  }

  /**
  * Handler for unit change blocked event
  *
  * @memberof LoadableStudyDetailsComponent
  */
  unitChangeBlocked() {
    this.loadableStudyDetailsApiService.unitChangeBlocked.next();
  }

  /**
  * Method for set button visibility on processing
  *
  * @returns {boolean}
  * @memberof LoadableStudyDetailsComponent
  */
  inProcessing() {
    if (this.selectedLoadableStudy?.statusId === 4) {
      let dateString = this.selectedLoadableStudy?.loadableStudyStatusLastModifiedTime;
      const dateTimeParts = dateString?.split(' ');
      const dateParts = dateTimeParts[0]?.split('-');

      if (dateParts?.length) {
        dateString = Number(dateParts[1]) + "/" + Number(dateParts[0]) + "/" + Number(dateParts[2]) + " " + dateTimeParts[1];
        const modifiedDate = moment.utc(dateString).toDate();
        const addProcessingTimeout = new Date(modifiedDate.getTime() + 600);
        const now = new Date();
        if (addProcessingTimeout < now) {
          return false;
        } else {
          return true;
        }
      } else {
        return true;
      }

    }
  }


  /**
   * Method to close rules pop up.
   *
   * @memberof LoadableStudyDetailsComponent
   */
  closeModal(event) {
    this.isRuleModalVisible = event;
  }
}
