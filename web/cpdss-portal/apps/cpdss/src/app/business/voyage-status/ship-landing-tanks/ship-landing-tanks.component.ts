import { Component, Input, OnInit } from '@angular/core';
import { ICargoQuantities, IFuelType, IShipCargoTank, ITankOptions, IVoyagePortDetails, TANKTYPE, IBallastQuantities, IShipBallastTank, IShipBunkerTank } from '../../core/models/common.model';
import { VoyageStatusTransformationService } from '../services/voyage-status-transformation.service';
import { IVoyageStatus } from '../models/voyage-status.model';
import { OHQ_MODE } from '../../cargo-planning/models/cargo-planning.model';
import { IDataTableColumn } from '../../../shared/components/datatable/datatable.model';
import { QUANTITY_UNIT } from '../../../shared/models/common.model';
import { AppConfigurationService } from '../../../shared/services/app-configuration/app-configuration.service';

/**
 * Component class of ship landing screen
 *
 * @export
 * @class ShipLandingTanksComponent
 * @implements {OnInit}
 */
@Component({
  selector: 'cpdss-portal-ship-landing-tanks',
  templateUrl: './ship-landing-tanks.component.html',
  styleUrls: ['./ship-landing-tanks.component.scss']
})
export class ShipLandingTanksComponent implements OnInit {

  @Input() vesselId: number;
  @Input() voyageId: number;
  @Input() loadableStudyId: number;
  @Input() selectedPortDetails: IVoyagePortDetails;
  @Input() showPlannedValues = false;
  @Input() get shipLandingTanks(): IVoyageStatus {
    return this._shipLandingTanks;
  }

  set shipLandingTanks(value: IVoyageStatus) {
    this._shipLandingTanks = value;
    this.cargoTankOptions.weightField = this.showPlannedValues ? 'plannedWeight' : 'actualWeight';
    this.ballastTankOptions.weightField = this.showPlannedValues ? 'plannedWeight' : 'actualWeight';
    this.getShipLandingTanks();
  }

  @Input() get currentQuantitySelectedUnit(): QUANTITY_UNIT {
    return this._currentQuantitySelectedUnit;
  }

  set currentQuantitySelectedUnit(value: QUANTITY_UNIT) {
    this.prevQuantitySelectedUnit = this.currentQuantitySelectedUnit;
    this._currentQuantitySelectedUnit = value;
    if (this.prevQuantitySelectedUnit) {
      this.convertQuantityToSelectedUnit();
    }
  }

  cargoTanks: IShipCargoTank[][];
  rearBallastTanks: IShipBallastTank[][];
  frontBallastTanks: IShipBallastTank[][];
  centerBallastTanks: IShipBallastTank[][];
  bunkerTanks: IShipBunkerTank[][];
  rearBunkerTanks: IShipBunkerTank[][];
  cargoColumns: IDataTableColumn[];
  ballastColumns: IDataTableColumn[];
  cargoQuantities: ICargoQuantities[];
  ballastQuantities: IBallastQuantities[];
  fuelTypes: IFuelType[];
  selectedTab = TANKTYPE.CARGO;
  viewAll = false;
  prevQuantitySelectedUnit: QUANTITY_UNIT;

  readonly tankType = TANKTYPE;

  cargoTankOptions: ITankOptions = { showFillingPercentage: true, showTooltip: true, isSelectable: false, ullageField: 'correctedUllage', ullageUnit: AppConfigurationService.settings?.ullageUnit, densityField: 'api', commodityNameField: 'abbreviation' };
  ballastTankOptions: ITankOptions = { showFillingPercentage: true, showTooltip: true, isSelectable: false, ullageField: 'correctedUllage', ullageUnit: AppConfigurationService.settings?.ullageUnit, densityField: 'sg', weightUnit: AppConfigurationService.settings.baseUnit };
  ohqTankOptions: ITankOptions = { showFillingPercentage: true, showTooltip: true, densityField: 'density', weightField: 'quantity', weightUnit: AppConfigurationService.settings.baseUnit };

  private _currentQuantitySelectedUnit: QUANTITY_UNIT;
  private _shipLandingTanks: IVoyageStatus;

  constructor(private voyageStatusTransformationService: VoyageStatusTransformationService) { }

  ngOnInit(): void {
    this.cargoColumns = this.voyageStatusTransformationService.getCargoTankDatatableColumns();
    this.ballastColumns = this.voyageStatusTransformationService.getBallastTankDatatableColumns();
  }

  /**
   * Handler for tab click
   *
   * @param {TANKTYPE} selectedTab
   * @memberof ShipLandingTanksComponent
   */
  onTabClick(selectedTab: TANKTYPE) {
    this.selectedTab = selectedTab;
  }

  /**
 * initialise tanks data
 *
 * @memberof ShipLandingTanksComponent
 */
  async getShipLandingTanks() {
    this.prevQuantitySelectedUnit = AppConfigurationService.settings.baseUnit;
    this.convertQuantityToSelectedUnit();
  }

  /**
   * Convert quantity to selected uint
   *
   * @memberof ShipLandingTanksComponent
   */
  convertQuantityToSelectedUnit() {
    this.cargoTankOptions.weightUnit = this.currentQuantitySelectedUnit;
    const mode = this.selectedPortDetails?.operationType === 'ARR' ? OHQ_MODE.ARRIVAL : OHQ_MODE.DEPARTURE;
    this.cargoQuantities = this.shipLandingTanks?.cargoQuantities ?? [];
    this.ballastQuantities = this.shipLandingTanks?.ballastQuantities ?? [];
    this.bunkerTanks = this.voyageStatusTransformationService.formatBunkerTanks(this.shipLandingTanks?.bunkerTanks, this.shipLandingTanks?.bunkerQuantities, mode, this.showPlannedValues);
    this.rearBunkerTanks = this.voyageStatusTransformationService.formatBunkerTanks(this.shipLandingTanks?.bunkerRearTanks, this.shipLandingTanks?.bunkerQuantities, mode, this.showPlannedValues);
    this.cargoTanks = this.voyageStatusTransformationService.formatCargoTanks(this.shipLandingTanks?.cargoTanks, this.shipLandingTanks?.cargoQuantities, this.prevQuantitySelectedUnit, this.currentQuantitySelectedUnit, this.showPlannedValues);
    this.rearBallastTanks = this.voyageStatusTransformationService.formatBallastTanks(this.shipLandingTanks?.ballastRearTanks, this.shipLandingTanks?.ballastQuantities, this.prevQuantitySelectedUnit, this.currentQuantitySelectedUnit, this.showPlannedValues);
    this.centerBallastTanks = this.voyageStatusTransformationService.formatBallastTanks(this.shipLandingTanks?.ballastCenterTanks, this.shipLandingTanks?.ballastQuantities, this.prevQuantitySelectedUnit, this.currentQuantitySelectedUnit, this.showPlannedValues);
    this.frontBallastTanks = this.voyageStatusTransformationService.formatBallastTanks(this.shipLandingTanks?.ballastFrontTanks, this.shipLandingTanks?.ballastQuantities, this.prevQuantitySelectedUnit, this.currentQuantitySelectedUnit, this.showPlannedValues);
    this.fuelTypes = [...new Map(this.shipLandingTanks.bunkerQuantities.map(item => [item['fuelTypeId'], { id: item?.fuelTypeId, name: item?.fuelTypeName, colorCode: item?.colorCode, shortName: item?.fuelTypeShortName }])).values()];
  }



}
