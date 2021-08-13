import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { CommonApiService } from '../../../shared/services/common/common-api.service';
import { IDischargingInstructionResponse } from '../models/discharging-instruction.model';

/**
 * API service for discharging instruction
 */
@Injectable()
export class DischargingInstructionApiService {

  constructor(
    private commonApiService: CommonApiService
  ) { }

  /**
   * function to get discharging instruction data
   *
   * @param {number} vesselId
   * @param {number} dischargingInfoId
   * @param {number} portRotationId
   * @return {*}  {Observable<IDischargingInstructionResponse>}
   * @memberof DischargingInstructionApiService
   */
  getDischargingInstructionData(vesselId: number, dischargingInfoId: number, portRotationId: number): Observable<IDischargingInstructionResponse> {
    return this.commonApiService.get<IDischargingInstructionResponse>(`vessels/${vesselId}/discharging-info/${dischargingInfoId}/port-rotation/${portRotationId}`)
  }
}
