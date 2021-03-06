import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';

import { Observable, of } from 'rxjs';

import { IPort, IPortsResponse, IInstructionResponse, ITankResponse, ICargoResponseModel , IConfirmStatusResponse } from '../../core/models/common.model';

import { IPortCargoResponse, IDischargeStudiesResponse } from '../models/discharge-study-list.model';
import { IDischargeStudyDetailsResponse } from '../models/discharge-study-view-plan.model';

import { CommonApiService } from '../../../shared/services/common/common-api.service';
import { IResponse } from '../../../shared/models/common.model';
/**
 * Api Service for Discharge Plan Details module
 *
 * @export
 * @class DischargePlanApiService
*/
@Injectable()
export class DischargePlanApiService {
  private _ports: IPort[];

  constructor(
    private commonApiService: CommonApiService
  ) { }

  /**
    * Get port cargo list
    * @param {number} vesselId
    * @param {number} dischargeStudyId
    * @returns {Promise<IPortCargoResponse>}
    * @memberof DischargePlanApiService
 */
  getPortCargoDetails(dischargeStudyId: number): Observable<IPortCargoResponse> {
    return this.commonApiService.get<IPortCargoResponse>(`discharge-studies/${dischargeStudyId}/port-cargos`);
  }


  /**
   * Get instruction list
   *
   * @returns {Promise<IInstructionResponse>}
   * @memberof DischargePlanApiService
  */
  getInstructionDetails(): Observable<IInstructionResponse> {
    return this.commonApiService.get<IInstructionResponse>(`port-instructions`);
  }

  /**
    * Get tank List
    * @param {number} vesselId
    * @returns {Promise<ITankResponse>}
    * @memberof DischargePlanApiService
  */
  getTankDetails(vesselId: number): Observable<ITankResponse> {
    return this.commonApiService.get<ITankResponse>(`vessel/${vesselId}/cargo-tanks`);
  }


  /**
   * Method to get all ports in port master
   *
   * @returns {Observable<IPort[]>}
   * @memberof DischargePlanApiService
  */
  getPorts(): Observable<IPort[]> {
    if (this._ports) {
      return of(this._ports);
    } else {
      return this.commonApiService.get<IPortsResponse>('ports').pipe(map((response) => {
        this._ports = response?.ports;
        return this._ports;
      }));
    }
  }

  /**
   * Get cargo details
   * @returns {Promise<ICargoResponse>}
   * @memberof DischargePlanApiService
  */
  getCargoDetails(): Observable<ICargoResponseModel> {
    return this.commonApiService.get<ICargoResponseModel>(`cargos`);
  }

  /**
   * Get discharge details
   * @param {number} vesselId
   * @param {number} voyageId
   * @returns {Promise<ICargoResponse>}
   * @memberof DischargePlanApiService
  */
  getDischargeStudyDetails(vesselId: number, voyageId: number, dischargeStudyId: number): Observable<IDischargeStudyDetailsResponse> {
    return this.commonApiService.get<IDischargeStudyDetailsResponse>(`vessels/${vesselId}/voyages/${voyageId}/discharge-studies/${dischargeStudyId}/discharge-pattern-details`);
  }

  /**
   * Get discharge study list
   * @param {number} vesselId
   * @param {number} voyageId
   * @memberof DischargePlanApiService
  */
  getDischargeStudies(vesselId: number, voyageId: number): Observable<IDischargeStudiesResponse> {
    const planningType = 2;
    return this.commonApiService.get<IDischargeStudiesResponse>(`vessels/${vesselId}/voyages/${voyageId}/loadable-studies?planningType=${planningType}`);
  }

  /**
* Api for get confirm status
*
* @param {number} vesselId
* @param {number} voyageId
* @param {number} dischargeStudyId
* @param {number} dischargePatternId
* @returns {Observable<ICommingleCargoDetailsResponse>}
* @memberof DischargePlanApiService
*/
  getConfirmStatus(vesselId: number, voyageId: number, dischargeStudyId: number, dischargePatternId: number): Observable<IConfirmStatusResponse> {
    return this.commonApiService.get<IConfirmStatusResponse>(`vessels/${vesselId}/voyages/${voyageId}/discharge-studies/${dischargeStudyId}/confirm-plan-status/${dischargePatternId}`);
  }

  /**
  * Api for get confirm status
  *
  * @param {number} vesselId
  * @param {number} voyageId
  * @param {number} dischargeStudyId
  * @param {number} dischargePatternId
  * @returns {Observable<ICommingleCargoDetailsResponse>}
  * @memberof DischargePlanApiService
  */
  confirm(vesselId: number, voyageId: number, dischargeStudyId: number, dischargePatternId: number): Observable<IResponse> {
    return this.commonApiService.post<any, IResponse>(`vessels/${vesselId}/voyages/${voyageId}/discharge-studies/${dischargeStudyId}/confirm-plan/${dischargePatternId}`, {});
  }

  /**
   * API to download .dat file
   *
   * @param {number} vesselId
   * @param {number} dischargePatternId
   * @return {*}  {Observable<any>}
   * @memberof DischargePlanApiService
   */
   downloadDATfile(vesselId: number, dischargePatternId: number): Observable<any> {
    return this.commonApiService.getFile<any>(`vessel/${vesselId}/loadable-pattern/${dischargePatternId}/zip`, { responseType: 'blob' as 'json' });
  }
}
