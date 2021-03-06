import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DepartureConditionComponent } from './departure-condition.component';
import { CargoTankLayoutModule } from '../../../business/core/components/cargo-tank-layout/cargo-tank-layout.module';
import { UllageUpdatePopupModule } from '../ullage-update-popup/ullage-update-popup.module';
import { DepartureConditionTransformationService } from './departure-condition-transformation.service';
import { DatatableModule } from '../../../shared/components/datatable/datatable.module'
import { LoadingDischargingCargoDetailsTableModule } from './../loading-discharging-cargo-details-table/loading-discharging-cargo-details-table.module';
import { BallastLayoutModule } from '../../../business/core/components/ballast-layout/ballast-layout.module';
import { TranslateModule } from '@ngx-translate/core';
import { TooltipModule } from 'primeng/tooltip';
import { CargoToBeLoadedDischargedModule } from '../cargo-to-be-loaded-discharged/cargo-to-be-loaded-discharged.module';
import { LoadingDischargingCommingleDetailsModule } from './../loading-discharging-commingle-details/loading-discharging-commingle-details.module';

/**
 * Module for Departure condition block
 *
 * @export
 * @class DepartureConditionModule
 */
@NgModule({
  declarations: [DepartureConditionComponent],
  imports: [
    CommonModule,
    CargoTankLayoutModule,
    UllageUpdatePopupModule,
    DatatableModule,
    LoadingDischargingCargoDetailsTableModule,
    BallastLayoutModule,
    TranslateModule,
    TooltipModule,
    CargoToBeLoadedDischargedModule,
    LoadingDischargingCommingleDetailsModule
  ],
  exports: [DepartureConditionComponent],
  providers: [DepartureConditionTransformationService]
})
export class DepartureConditionModule { }
