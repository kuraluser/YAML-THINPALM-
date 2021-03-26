import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CommonApiService } from '../../../shared/services/common/common-api.service';
import { ILoadablePlanResponse } from '../../cargo-planning/models/loadable-plan.model';
import { NewVoyageModel } from '../models/new-voyage.model';
import { IVoyageDetails, IVoyageStatus } from '../models/voyage-status.model';
import { NewVoyageResponseModel } from '../models/new-voyage.model'

/**
 * Service for voyage api
 */
@Injectable()
export class VoyageApiService {

  constructor(private commonApiService: CommonApiService) { }

  /**
   * Save new-voyage api
   */
  saveNewVoyageData(newVoyage: NewVoyageModel, vesselId: number): Observable<NewVoyageResponseModel> {
    return this.commonApiService.post<NewVoyageModel, NewVoyageResponseModel>(`vessels/${vesselId}/voyages`, newVoyage);
  }

  /**
   * Set validation Error to form control
   */
  setValidationErrorMessage() {
    return {
      voyageNo: {
        'required': 'VOYAGE_POPUP_VOYAGE_NO_REQUIRED_ERROR',
        'maxlength': 'NEW_VOYAGE_POPUP_CHARACTER_LIMIT',
        'specialCharacter': 'NEW_VOYAGE_POPUP_SPECIAL_CHARACTER_NOT_ALLOWED'
      },
      start_date: {
        'required': 'VOYAGE_POPUP_START_DATE_REQUIRED_ERROR',
        'failedCompare': 'VOYAGE_POPUP_START_DATE_COMPARE_ERROR'
      },
      end_date: {
        'required': 'VOYAGE_POPUP_END_DATE_REQUIRED_ERROR',
        'failedCompare': 'VOYAGE_POPUP_END_DATE_COMPARE_ERROR'
      },
      selectStartDateTimeZone: {
        'required': 'VOYAGE_POPUP_START_DATE_TIME_ZONE_REQUIRED_ERROR',
      },
      selectEndDateTimeZone: {
        'required': 'VOYAGE_POPUP_END_DATE_TIME_ZONE_REQUIRED_ERROR'
      }
    }
  }
  /**
   * Api to get voyage status
   */
  getVoyageDetails(vesselId: number, voyageId: number, loadableStudyId: number, voyageDetails: IVoyageDetails): Observable<IVoyageStatus> {
    const portId = voyageDetails.portId;
    return this.commonApiService.post<IVoyageDetails, IVoyageStatus>(`vessels/${vesselId}/voyages/${voyageId}/loadable-studies/${loadableStudyId}/ports/${portId}/voyage-status`, voyageDetails);
  }
}