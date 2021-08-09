import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { OperationsRoutingModule } from './operations-routing.module';
import { OperationsComponent } from './operations.component';
import { VesselsApiService } from '../core/services/vessels-api.service';
import { VesselInfoModule } from '../core/components/vessel-info/vessel-info.module';
import { UnitDropdownModule } from '../../shared/components/unit-dropdown/unit-dropdown.module';
import { DropdownModule } from 'primeng/dropdown';
import { TranslateModule } from '@ngx-translate/core';
import { PortRotationRibbonModule } from '../core/components/port-rotation-ribbon/port-rotation-ribbon.module';
import { AddPortPopupModule } from './add-port-popup/add-port-popup.module';
import { RulesModule } from './rules/rules.module';
import { RulesService } from './services/rules/rules.service';
import { LoadingDischargingTransformationService } from './services/loading-discharging-transformation.service';
import { QuantityPipeModule } from '../../shared/pipes/quantity/quantity-pipe.module';
import { QuantityPipe } from '../../shared/pipes/quantity/quantity.pipe';
import { OperationsApiService } from './services/operations-api.service';

/**
 * Module class for operations module
 *
 * @export
 * @class OperationsModule
 */
@NgModule({
  declarations: [
    OperationsComponent
  ],
  imports: [
    CommonModule,
    DropdownModule,
    TranslateModule,
    OperationsRoutingModule,
    VesselInfoModule,
    UnitDropdownModule,
    PortRotationRibbonModule,
    AddPortPopupModule,
    RulesModule,
    QuantityPipeModule
  ],
  providers: [VesselsApiService, RulesService, LoadingDischargingTransformationService, QuantityPipe, OperationsApiService ]
})
export class OperationsModule { }