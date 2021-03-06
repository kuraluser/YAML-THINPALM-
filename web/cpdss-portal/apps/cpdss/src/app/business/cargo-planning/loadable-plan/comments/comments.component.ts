import { Component, OnInit, Input , ViewChild , ElementRef, OnDestroy } from '@angular/core';
import { DatePipe } from '@angular/common';
import { FormBuilder, FormControl, FormGroup, ValidationErrors, Validators } from '@angular/forms';

import { NgxSpinnerService } from 'ngx-spinner';
import { MessageService } from 'primeng/api';
import { TranslateService } from '@ngx-translate/core';

import { ILoadablePlanCommentsDetails, ISaveComment , VALIDATION_AND_SAVE_STATUS , ICommentResponse } from '../../models/loadable-plan.model';
import { IResponse } from '../../../../shared/models/common.model';

import { LoadablePlanApiService } from '../../services/loadable-plan-api.service';
import { SecurityService } from "../../../../shared/services/security/security.service";
import { LoadablePlanTransformationService } from '../../services/loadable-plan-transformation.service';
import { AppConfigurationService } from '../../../../shared/services/app-configuration/app-configuration.service';
import { PermissionsService } from '../../../../shared/services/permissions/permissions.service';
import { TimeZoneTransformationService } from './../../../../shared/services/time-zone-conversion/time-zone-transformation.service';
import { whiteSpaceValidator } from '../../../core/directives/space-validator.directive';
import { Subject } from 'rxjs';
import { takeUntil } from 'rxjs/operators';

/**
 * Component class of comments component in loadable plan
 *
 * @export
 * @class CommentsComponent
 * @implements {OnInit}
 */
@Component({
  selector: 'cpdss-portal-comments',
  templateUrl: './comments.component.html',
  styleUrls: ['./comments.component.scss']
})
export class CommentsComponent implements OnInit, OnDestroy {

  @ViewChild('submitBtn') submitBtnRef: ElementRef;

  @Input() vesselId: number;
  @Input() loadableStudyId: number;
  @Input() voyageId: number;
  @Input() loadablePatternId: number;
  @Input() enableSubmit: boolean;

  @Input() set commentsDetails(value: ILoadablePlanCommentsDetails[]) {
    this._commentsDetails = value && this.showCommentedDateTimeInUTC(value);
  }

  get commentsDetails(): ILoadablePlanCommentsDetails[] {
    return this._commentsDetails;
  }

  @Input() set loadablePatternValidationStatus(value: number) {
    this._loadablePatternValidationStatus = value;
    [VALIDATION_AND_SAVE_STATUS.LOADABLE_PLAN_STARTED].includes(value) ? this.commentButtonStatus = true : this.commentButtonStatus = false;
  }

  get loadablePatternValidationStatus(): number {
    return this._loadablePatternValidationStatus;
  }

  @Input() set isVoyageClosed(value: boolean) {
    this._isVoyageClosed = value;
  }

  get isVoyageClosed(): boolean {
    return this._isVoyageClosed;
  }


  private _commentsDetails: ILoadablePlanCommentsDetails[];
  private _loadablePatternValidationStatus: number;
  private _isVoyageClosed: boolean;
  private ngUnsubscribe: Subject<any> = new Subject();

  public commentButtonStatus: boolean;
  public commentForm: FormGroup;
  public formError: boolean;
  public isPermissionAvaliable: boolean;
  public validateAndSaveProcessing: boolean;
  public errorMessages = {
    'maxlength': 'LOADABLE_PLAN_SAVE_STOWAGE_COMMENT_MAXLENGTH',
    'whitespace': 'COMMENTS_REQUIRED'
  };

  constructor(
    private loadablePlanApiService: LoadablePlanApiService,
    private datePipe: DatePipe,
    private fb: FormBuilder,
    private timeZoneTransformationService: TimeZoneTransformationService,
    private messageService: MessageService,
    private translateService: TranslateService,
    private ngxSpinnerService: NgxSpinnerService,
    private permissionsService: PermissionsService,
    private appConfigurationService: AppConfigurationService,
    private loadablePlanTransformationService: LoadablePlanTransformationService
  ) { }

  /**
   * Component lifecycle ngOnit
   *
   * @returns {void}
   * @memberof CommentsComponent
  */
  ngOnInit(): void {
    this.isPermissionAvaliable = this.permissionsService.getPermission(AppConfigurationService.settings.permissionMapping['LoadablePlanAddComments'], false).view;
    this.commentForm = this.fb.group({
      comment: [{value:'', disabled: !this.isPermissionAvaliable}, [Validators.maxLength(100) , whiteSpaceValidator]]
    })
    this.loadablePlanTransformationService.editBallastStatus$.pipe(takeUntil(this.ngUnsubscribe)).subscribe((value: any) => {
      this.validateAndSaveProcessing = value.validateAndSaveProcessing;
    });
  }

  ngOnDestroy() {
    this.ngUnsubscribe.next();
    this.ngUnsubscribe.complete();
  }

  /**
   * add new comments
  */
  async submitComments() {
    if (this.commentForm.valid && !this.isVoyageClosed) {
      const translationKeys = await this.translateService.get(['LOADABLE_PLAN_SAVE_STOWAGE_POPUP_COMMENT_SUCCESS', 'LOADABLE_PLAN_SAVE_STOWAGE_POPUP_COMMENT_SUCCESS_DETAILS']).toPromise();
      const comments: ISaveComment = {
        comment: this.commentForm.controls['comment'].value
      }
      const userProfile = SecurityService.getUserProfile();
      this.ngxSpinnerService.show();
      const response:ICommentResponse = await this.loadablePlanApiService.saveComments(this.vesselId, this.voyageId, this.loadableStudyId, this.loadablePatternId , comments).toPromise();
      this.ngxSpinnerService.hide();
      if(response.responseStatus.status === '200') {
        this.messageService.add({ severity: 'success', summary: translationKeys['LOADABLE_PLAN_SAVE_STOWAGE_POPUP_COMMENT_SUCCESS'], detail: translationKeys['LOADABLE_PLAN_SAVE_STOWAGE_POPUP_COMMENT_SUCCESS_DETAILS'] });
        const commentDetails: ILoadablePlanCommentsDetails  = response.comment;
        commentDetails['dataAndTime'] = this.timeZoneTransformationService.formatDateTime(commentDetails.dataAndTime, {utcFormat: true});
        this.commentsDetails.unshift(commentDetails);
        this.submitBtnRef.nativeElement.focus();
        this.commentForm.reset();
        this.formError = false;
      }
    } else {
      this.formError = true;
      const translationKeys = await this.translateService.get(['LOADABLE_PLAN_SAVE_STOWAGE_POPUP_COMMENT_FAIL', 'LOADABLE_PLAN_SAVE_STOWAGE_POPUP_COMMENT_FAIL_DETAILS']).toPromise();
      if(this.isVoyageClosed) {
        this.messageService.add({ severity: 'error', summary: translationKeys['LOADABLE_PLAN_SAVE_STOWAGE_POPUP_COMMENT_FAIL'], detail: translationKeys['LOADABLE_PLAN_SAVE_STOWAGE_POPUP_COMMENT_FAIL_DETAILS'] });
      }
    }
  }

  /**
  * Get field errors
  *
  * @param {string} formControlName
  * @returns {ValidationErrors}
  * @memberof CommentsComponent
  */
  fieldError(formControlName: string): ValidationErrors {
    const formControl = this.field(formControlName);
    return formControl.invalid && (formControl.dirty || formControl.touched) || this.formError ? formControl.errors : null;
  }

  /**
  * Get form control of comments form
  *
  * @param {string} formControlName
  * @returns {FormControl}
  * @memberof CommentsComponent
  */
  field(formControlName: string): FormControl {
    const formControl = <FormControl>this.commentForm.get(formControlName);
    return formControl;
  }

  /**
   * function to show commented date-time in UTC format
   *
   * @param {ILoadablePlanCommentsDetails[]} commentArray
   * @return {*}  {ILoadablePlanCommentsDetails[]}
   * @memberof CommentsComponent
   */
  showCommentedDateTimeInUTC(commentArray: ILoadablePlanCommentsDetails[]): ILoadablePlanCommentsDetails[]  {
    commentArray.map(comment => (comment.dataAndTime = this.timeZoneTransformationService.formatDateTime(comment.dataAndTime, {utcFormat: true})));
    return commentArray;
  }

    /**
   * Trim blank space
   * @param {string} formControlName
   * @memberof CommentsComponent
   */
    trimFormControl(formControlName: string) {
      this.commentForm.controls[formControlName].setValue((this.commentForm.get(formControlName).value).trim());
    }

}
