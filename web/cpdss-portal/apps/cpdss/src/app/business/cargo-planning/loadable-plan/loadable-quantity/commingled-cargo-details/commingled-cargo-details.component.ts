import { Component, OnInit, Input } from '@angular/core';
import { NgxSpinnerService } from 'ngx-spinner';

import { ITableHeaderModel } from '../../../models/loadable-plan.model';

import { LoadablePlanTransformationService } from '../../../services/loadable-plan-transformation.service';
import { LoadablePlanApiService } from '../../../services/loadable-plan-api.service';

/**
 * Component class of commingle cargo details component in loadable plan
 *
 * @export
 * @class CommingledCargoDetailsComponent
 * @implements {OnInit}
 */
@Component({
  selector: 'cpdss-portal-commingled-cargo-details',
  templateUrl: './commingled-cargo-details.component.html',
  styleUrls: ['./commingled-cargo-details.component.scss']
})
export class CommingledCargoDetailsComponent implements OnInit {

  columns: any[];
  value: any[];

  constructor(
    private ngxSpinnerService: NgxSpinnerService,
    private loadablePlanTransformationService: LoadablePlanTransformationService,
    private loadablePlanApiService: LoadablePlanApiService
  ) { }

  ngOnInit(): void {
    this.columns = this.loadablePlanTransformationService.getCommingledCargoTableColumn();
    this.value = [1, 2, 3];
  }
}
