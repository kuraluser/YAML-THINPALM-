import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NewLoadableStudyPopupComponent } from './new-loadable-study-popup.component';
import { ReactiveFormsModule } from '@angular/forms';
import { DropdownModule } from 'primeng/dropdown';
import { FileUploadModule } from 'primeng/fileupload';
import { TranslateModule } from '@ngx-translate/core';
import { DialogModule } from 'primeng/dialog';

/**
 *  this module will load all the dependencies of new-loadable-study-popup component
 */
@NgModule({
  declarations: [NewLoadableStudyPopupComponent],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    DropdownModule,
    FileUploadModule,
    TranslateModule,
    DialogModule
  ],
  exports: [NewLoadableStudyPopupComponent]
})
export class NewLoadableStudyPopupModule { }
