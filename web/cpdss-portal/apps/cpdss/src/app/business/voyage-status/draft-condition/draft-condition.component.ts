import { Component, Input, OnInit } from '@angular/core';
import { IDataTableColumn } from '../../../shared/components/datatable/datatable.model';
import { IDraftCondition } from '../models/voyage-status.model';
import { VoyageStatusTransformationService } from '../services/voyage-status-transformation.service';

/**
 * Component for Draft Conditions
 *
 * @export
 * @class DraftConditionComponent
 * @implements {OnInit}
 */
@Component({
  selector: 'cpdss-portal-draft-condition',
  templateUrl: './draft-condition.component.html',
  styleUrls: ['./draft-condition.component.scss']
})
export class DraftConditionComponent implements OnInit {

  @Input() get draftCondition(): IDraftCondition {
    return this._draftCondition;
  }

  set draftCondition(value: IDraftCondition) {
    this._draftCondition = value;
    this.setConditions();
  }

  @Input() hasLoadicator = false;
  columns: IDataTableColumn[];
  value = [];

  private _draftCondition: IDraftCondition;

  constructor(private voyageStatusTransformationService: VoyageStatusTransformationService) { }

  ngOnInit(): void {
    this.columns = this.voyageStatusTransformationService.getDraftConditionColumnFields();
  }

  /**
   * Set grid values from draft conditions
   *
   * @memberof DraftConditionComponent
   */
  setConditions() {
    let deflection;
    deflection = this.hasLoadicator ?  this.draftCondition?.deflection : 0;    
    this.value = [
      { header: 'VOYAGE_STATUS_DRAFT_CONDITION_CALCULATED', aft: this.draftCondition?.finalDraftAft - deflection, mid: this.draftCondition?.finalDraftMid - deflection, fore: this.draftCondition?.finalDraftFwd - deflection},
      { header: 'VOYAGE_STATUS_DRAFT_CONDITION_CORRECTED', aft: this.draftCondition?.finalDraftAft, mid: this.draftCondition?.finalDraftMid, fore: this.draftCondition?.finalDraftFwd }
    ]
  }

}