import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { map } from 'rxjs/operators';
import { CommonApiService } from '../../../shared/services/common/common-api.service';
import { IVesselsResponse, VesselDetailsModel } from '../../model/vessel-details.model';

/**
 * Service for vessels api
 */
@Injectable()
export class VesselsApiService {
  private _vesselDetails: VesselDetailsModel[];

  constructor(private commonApiService: CommonApiService) { }

  /**
   * Vessel details api result mock
   */
  getVesselsInfo(): Observable<VesselDetailsModel[]> {
    if (this._vesselDetails) {
      return of(this._vesselDetails);
    } else {
      return this.commonApiService.get<IVesselsResponse>('vessels').pipe(map((response) => {
        this._vesselDetails = response.vessels;
        return this._vesselDetails;
      }));
    }

  }
}
