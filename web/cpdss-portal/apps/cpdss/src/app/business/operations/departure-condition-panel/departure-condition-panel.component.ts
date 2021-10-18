import { Component, OnInit, Input } from '@angular/core';
import { QUANTITY_UNIT, LENGTH_UNIT } from './../../../shared/models/common.model';
import { AppConfigurationService } from '../../../shared/services/app-configuration/app-configuration.service';

/**
 * Component class for departure condition panel
 *
 * @export
 * @class DepartureConditionPanelComponent
 * @implements {OnInit}
 */
@Component({
  selector: 'cpdss-portal-departure-condition-panel',
  templateUrl: './departure-condition-panel.component.html',
  styleUrls: ['./departure-condition-panel.component.scss']
})
export class DepartureConditionPanelComponent implements OnInit {

  @Input() get loadingDischargingPlanData(): any {
    return this._loadingDischargingPlanData;
  }

  set loadingDischargingPlanData(value: any) {
    this._loadingDischargingPlanData = value;
    this.formatData();
  }

  _loadingDischargingPlanData: any;
  departureConditionCargoInfo: any = [];
  departureConditionCargoTotalQuantity = 0;
  ballastQuantity = 0;
  draftFValue = 0;
  draftAValue = 0;
  draftMValue = 0;
  trimValue = 0;
  freeboard = 0;
  manifoldHeight: number;

  readonly QUANTITY_UNIT = QUANTITY_UNIT;
  readonly LENGTH_UNIT = LENGTH_UNIT;
  constructor() { }

  ngOnInit(): void {
  }

  /**
  * initialise plan data
  *
  * @memberof DepartureConditionPanelComponent
  */
  formatData() {
    this.departureConditionCargoInfo = [];
    const commingleArray = [];
    this.departureConditionCargoTotalQuantity = 0;
    this.loadingDischargingPlanData?.planCommingleDetails?.map(com => {
      if (com.conditionType === 2) {
        commingleArray.push({ abbreviation: com.abbreviation, colorCode: AppConfigurationService.settings.commingleColor, quantity: 0, tankId: com.tankId });
      }
    });
    const loadingDischargingPlanInfo = this.loadingDischargingPlanData?.loadingInformation ? this.loadingDischargingPlanData?.loadingInformation : this.loadingDischargingPlanData?.dischargingInformation
    this.loadingDischargingPlanData?.currentPortCargos?.map(cargo => {
      let cargoQuantity = 0;
      this.loadingDischargingPlanData?.planStowageDetails?.map(item => {
        if (item.conditionType === 2 && item.valueType === 2 && cargo.cargoNominationId === item.cargoNominationId) {
          if (item.isCommingleCargo) {
            commingleArray?.map(com => {
              if (com.tankId === item.tankId) {
                com.quantity += Number(item.quantityMT);
              }
            });
          } else {
            cargoQuantity += Number(item.quantityMT);
          }
        }
      });
      this.departureConditionCargoTotalQuantity += cargoQuantity;
      this.departureConditionCargoInfo.push({ abbreviation: cargo.cargoAbbreviation, colorCode: cargo.colorCode, quantity: cargoQuantity });
    });
    commingleArray?.map(com => {
      this.loadingDischargingPlanData?.planStowageDetails?.map(item => {
        if (item.isCommingleCargo && item.conditionType === 2 && item.valueType === 2) {
          if (com.tankId === item.tankId) {
            com.quantity += Number(item.quantityMT);
            this.departureConditionCargoTotalQuantity += Number(item.quantityMT);
          }
        }
      });
    });
    this.departureConditionCargoInfo = [...commingleArray, ...this.departureConditionCargoInfo];
    let ballastQuantity = 0;
    this.loadingDischargingPlanData?.planBallastDetails?.map(item => {
      if (item.conditionType === 2) {
        ballastQuantity += Number(item.quantityMT);
      }
    });
    this.ballastQuantity = Number(ballastQuantity.toFixed(2));
    let draftFValue = 0;
    let draftAValue = 0;
    let draftMValue = 0;
    let trimValue = 0;
    this.loadingDischargingPlanData?.planStabilityParams?.map(item => {
      if (item.conditionType === 2) {
        draftFValue += Number(item?.foreDraft);
        draftAValue += Number(item?.aftDraft);
        draftMValue += Number(item?.meanDraft);
        trimValue += Number(item?.trim);
      }
    });
    this.draftFValue = Number(draftFValue.toFixed(2));
    this.draftAValue = Number(draftAValue.toFixed(2));
    this.draftMValue = Number(draftMValue.toFixed(2));
    this.trimValue = Number(trimValue.toFixed(2));
    this.manifoldHeight = loadingDischargingPlanInfo?.berthDetails?.availableBerths?.length ? loadingDischargingPlanInfo?.berthDetails?.availableBerths[0].maxManifoldHeight : 0;
  }

}
