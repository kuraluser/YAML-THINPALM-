import { Component, Input, OnInit, OnDestroy } from '@angular/core';
import { ICargo, ILoadableQuantityCargo, IShipCargoTank, IAlgoResponse, IAlgoError, OPERATIONS } from '../../../core/models/common.model';
import { ILoadingDischargingSequences, IToppingOffSequence } from '../../models/loading-discharging.model';
import { LoadingPlanApiService } from './../../services/loading-plan-api.service';
import { QUANTITY_UNIT } from '../../../../shared/models/common.model';
import { LoadingDischargingTransformationService } from '../../services/loading-discharging-transformation.service';
import { AppConfigurationService } from '../../../../shared/services/app-configuration/app-configuration.service';
import { NgxSpinnerService } from 'ngx-spinner';
import { ILoadingPlanDetails, ULLAGE_STATUS_VALUE } from '../../models/loading-discharging.model';
import { OperationsApiService } from '../../services/operations-api.service';
import { MessageService } from 'primeng/api';
import { TranslateService } from '@ngx-translate/core';
import { IPermission } from '../../../../shared/models/user-profile.model';
import { Subject } from 'rxjs';
import { takeUntil } from 'rxjs/operators';

/**
 * Component class for loading plan component
 *
 * @export
 * @class LoadingPlanComponent
 * @implements {OnInit}
 */

@Component({
  selector: 'cpdss-portal-loading-plan',
  templateUrl: './loading-plan.component.html',
  styleUrls: ['./loading-plan.component.scss']
})

export class LoadingPlanComponent implements OnInit, OnDestroy {
  @Input() get cargos(): ICargo[] {
    return this._cargos;
  }

  set cargos(cargos: ICargo[]) {
    this._cargos = cargos;
  }

  @Input() vesselId: number;
  @Input() voyageId: number;
  @Input() portRotationId: number;
  @Input() loadingInfoId: number;
  @Input() permission: IPermission;

  private _cargos: ICargo[];
  toppingOffSequence: IToppingOffSequence[];
  cargoTanks: IShipCargoTank[][];
  loadableQuantityCargoDetails: ILoadableQuantityCargo[];
  loadingSequences: ILoadingDischargingSequences;
  loadingPlanDetails: ILoadingPlanDetails;
  prevQuantitySelectedUnit: QUANTITY_UNIT;
  currentQuantitySelectedUnit = <QUANTITY_UNIT>localStorage.getItem('unit');
  errorMessage: IAlgoError[];
  errorPopUp = false;
  loadingPlanDetailsTemp: ILoadingPlanDetails;

  readonly OPERATIONS = OPERATIONS;
  private ngUnsubscribe: Subject<any> = new Subject();


  constructor(
    private loadingPlanApiService: LoadingPlanApiService,
    private operationsApiService: OperationsApiService,
    private loadingDischargingTransformationService: LoadingDischargingTransformationService,
    private ngxSpinnerService: NgxSpinnerService,
    private messageService: MessageService,
    private translateService: TranslateService
  ) { }

  ngOnInit(): void {
    this.initSubscriptions();
    this.getLoadingPlanDetails();
  }

  ngOnDestroy() {
    this.ngUnsubscribe.next();
    this.ngUnsubscribe.complete();
  }

  /**
  * Get loading plan details
  *
  * @private
  * @memberof LoadingInformationComponent
  */
  async getLoadingPlanDetails() {
    try {
      this.ngxSpinnerService.show();
      this.loadingPlanDetails = await this.loadingPlanApiService.getLoadingPlanDetails(this.vesselId, this.voyageId, this.loadingInfoId, this.portRotationId).toPromise();
      this.loadingPlanDetailsTemp = { ...this.loadingPlanDetails };
      this.setCommingleCargo();
      this.toppingOffSequence = this.loadingPlanDetails?.loadingInformation?.toppingOffSequence;
      this.loadableQuantityCargoDetails = this.loadingPlanDetails?.loadingInformation?.cargoVesselTankDetails?.loadableQuantityCargoDetails;
      this.loadingSequences = this.loadingPlanDetails?.loadingInformation?.loadingSequences;
      this.loadingSequences.loadingDischargingDelays = this.loadingPlanDetails?.loadingInformation?.loadingSequences['loadingDelays'];
      this.cargoTanks = this.loadingPlanDetails?.cargoTanks;
      this.ngxSpinnerService.hide();
    } catch (e) {
      this.ngxSpinnerService.hide();
    }
  }

  /**
  * Set commingle cargo flag
  *
  * @private
  * @memberof LoadingInformationComponent
  */
  setCommingleCargo() {
    if (this.loadingPlanDetails?.planCommingleDetails?.length && this.loadingPlanDetails?.planStowageDetails?.length) {
      this.loadingPlanDetails?.planStowageDetails.map(plan => {
      this.loadingPlanDetails?.planCommingleDetails.map(item => {
          if (Number(item.tankId) === Number(plan.tankId) && item.conditionType === plan.conditionType && plan.valueType === item.valueType) {
            plan.isCommingleCargo = true;
            plan.quantityMT = item.quantityMT;
            plan.api = item.api;
            plan.temperature = item.temperature;
            plan.abbreviation = item.abbreviation;
            plan.cargoNominationId = null;
            plan.colorCode = item.colorCode;
            plan.ullage = item.ullage;
          }
        });
      });
    }
  }

  /**
  * Initialization for all subscriptions
  *
  * @private
  * @memberof LoadingInformationComponent
  */
  private async initSubscriptions() {
    this.loadingDischargingTransformationService.unitChange$.pipe(takeUntil(this.ngUnsubscribe)).subscribe((res) => {
      this.prevQuantitySelectedUnit = this.currentQuantitySelectedUnit ?? AppConfigurationService.settings.baseUnit
      this.currentQuantitySelectedUnit = <QUANTITY_UNIT>localStorage.getItem('unit');
    });

    this.loadingDischargingTransformationService.showUllageErrorPopup$.pipe(takeUntil(this.ngUnsubscribe)).subscribe((res) => {
      this.getAlgoErrorMessage(res);
    });

    this.loadingDischargingTransformationService.setUllageArrivalBtnStatus$.pipe(takeUntil(this.ngUnsubscribe)).subscribe((value) => {
      if (value.status === ULLAGE_STATUS_VALUE.SUCCESS) {
        this.getLoadingPlanDetails();
      }
    });
    this.loadingDischargingTransformationService.setUllageDepartureBtnStatus$.pipe(takeUntil(this.ngUnsubscribe)).subscribe((value) => {
      if (value.status === ULLAGE_STATUS_VALUE.SUCCESS) {
        this.getLoadingPlanDetails();
      }
    });
  }

  /**
   * Method to get algo error 
   *
   * @memberof LoadingComponent
   */
  async getAlgoErrorMessage(status) {
    const translationKeys = await this.translateService.get(['GENERATE_LOADABLE_PLAN_ERROR_OCCURED', 'GENERATE_LODABLE_PLAN_NO_PLAN_AVAILABLE']).toPromise();
    const algoError: IAlgoResponse = await this.operationsApiService.getAlgoErrorDetails(this.vesselId, this.voyageId, this.loadingInfoId, status.status).toPromise();
    if (algoError.responseStatus.status === 'SUCCESS') {
      this.errorMessage = algoError.algoErrors;
      this.errorPopUp = status.value;
    }
    this.messageService.add({ severity: 'error', summary: translationKeys['GENERATE_LOADABLE_PLAN_ERROR_OCCURED'], detail: translationKeys["GENERATE_LODABLE_PLAN_NO_PLAN_AVAILABLE"] });
  }

  /**
   * Method to display view error pop up.
   *
   * @memberof LoadingComponent
   */
  viewError(status) {
    this.errorPopUp = status;
  }
}
