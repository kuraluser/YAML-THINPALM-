import { NgModule } from '@angular/core';
import { CommonModule, DatePipe } from '@angular/common';

import { LoadableStudyDetailsComponent } from './loadable-study-details.component';
import { LoadableStudyDetailsRoutingModule } from './loadable-study-details-routing.module';
import { DatatableModule } from '../../../shared/components/datatable/datatable.module';
import { CargoNominationComponent } from './cargo-nomination/cargo-nomination.component';
import { LoadingPortsPopupComponent } from './cargo-nomination/loading-ports-popup/loading-ports-popup.component';
import { DialogModule } from 'primeng/dialog';
import { ApiTemperatureHistoryPopupComponent } from './cargo-nomination/api-temperature-history-popup/api-temperature-history-popup.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MultiSelectModule } from 'primeng/multiselect';
import { DropdownModule } from 'primeng/dropdown';
import { TranslateModule } from '@ngx-translate/core';
import { VesselInfoModule } from '../../core/components/vessel-info/vessel-info.module';
import { NewLoadableStudyPopupModule } from '../../core/components/new-loadable-study-popup/new-loadable-study-popup.module';
import { OnHandQuantityComponent } from './on-hand-quantity/on-hand-quantity.component';
import { PortsComponent } from './ports/ports.component';
import { PermissionDirectiveModule } from '../../../shared/directives/permission/permission-directive.module';
import { LoadableQuantityComponent } from './loadable-quantity/loadable-quantity.component';
import { LoadableQuantityApiService } from '../services/loadable-quantity-api.service';
import { SidePanelLoadableStudyListModule } from '../../core/components/side-panel-loadable-study-list/side-panel-loadable-study-list.module';
import { ValidationErrorModule } from '../../../shared/components/validation-error/validation-error.module';
import { CommingleComponent } from './commingle/commingle.component';
import { CheckboxModule } from 'primeng/checkbox';
import { ColorPickerModule } from 'primeng/colorpicker';
import { CommingleApiService } from '../services/commingle-api.service';
import { OnBoardQuantityComponent } from './on-board-quantity/on-board-quantity.component';
import { BunkeringLayoutModule } from '../../core/components/bunkering-layout/bunkering-layout.module';
import { CargoTankLayoutModule } from '../../core/components/cargo-tank-layout/cargo-tank-layout.module';
import { NumberDirectiveModule } from '../../../shared/directives/number-directive/number-directive.module';
import { UnitDropdownModule } from '../../../shared/components/unit-dropdown/unit-dropdown.module';
import { QuantityPipeModule } from '../../../shared/pipes/quantity/quantity-pipe.module';
import { QuantityPipe } from '../../../shared/pipes/quantity/quantity.pipe';
import { TableModule } from 'primeng/table';
import { TooltipModule } from 'primeng/tooltip';
import { QuantityDecimalFormatPipeModule } from '../../../shared/pipes/quantity-decimal-format/quantity-decimal-format.module';

import { ErrorLogPopupModule } from '../../core/components/error-log-popup/error-log-popup.module';
import { QuantityDecimalFormatPipe } from '../../../shared/pipes/quantity-decimal-format/quantity-decimal-format.pipe';
import { InputSwitchModule } from 'primeng/inputswitch';
import { RulesTableModule } from '../../core/components/rules-table/rules-table.module'
import { RulesModule } from './rules/rules.module'
import { FocusTrapModule } from 'primeng/focustrap';

/**
 * Routing Module for Loadable Study Details Screen
 *
 * @export
 * @class LoadableStudyDetailsModule
 */
@NgModule({
  declarations: [LoadableStudyDetailsComponent, CargoNominationComponent, LoadingPortsPopupComponent, ApiTemperatureHistoryPopupComponent, PortsComponent, LoadableQuantityComponent, OnHandQuantityComponent, CommingleComponent, OnBoardQuantityComponent],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    FormsModule,
    LoadableStudyDetailsRoutingModule,
    DatatableModule,
    DialogModule,
    MultiSelectModule,
    DropdownModule,
    TranslateModule,
    VesselInfoModule,
    NewLoadableStudyPopupModule,
    SidePanelLoadableStudyListModule,
    PermissionDirectiveModule,
    ValidationErrorModule,
    CheckboxModule,
    ColorPickerModule,
    BunkeringLayoutModule,
    CargoTankLayoutModule,
    NumberDirectiveModule,
    UnitDropdownModule,
    QuantityPipeModule,
    TableModule,
    TooltipModule,
    QuantityDecimalFormatPipeModule,
    ErrorLogPopupModule,
    InputSwitchModule,
    RulesTableModule,
    RulesModule,
    FocusTrapModule


  ],
  providers: [
    LoadableQuantityApiService, CommingleApiService, QuantityPipe, DatePipe, QuantityDecimalFormatPipe
  ]
})
export class LoadableStudyDetailsModule { }
