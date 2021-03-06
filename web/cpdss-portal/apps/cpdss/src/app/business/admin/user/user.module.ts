import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { TranslateModule } from '@ngx-translate/core';
import { DialogModule } from 'primeng/dialog';
import { DropdownModule } from 'primeng/dropdown';
import { FocusTrapModule } from 'primeng/focustrap';

import { DatatableModule } from '../../../shared/components/datatable/datatable.module';
import { PermissionDirectiveModule } from '../../../shared/directives/permission/permission-directive.module';
import { ValidationErrorModule } from '../../../shared/components/validation-error/validation-error.module';

import { UserRoutingModule } from './user-routing.module'
import { UserListingComponent } from './user-listing/user-listing.component';
import { AddUserComponent } from './add-user/add-user.component';
import { ResetPasswordComponent } from './reset-password/reset-password.component'

/**
 * Module class User Module
 *
 * @export
 * @class UserModule
 */
@NgModule({
  declarations: [UserListingComponent, AddUserComponent, ResetPasswordComponent],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    DialogModule,
    DropdownModule,
    FocusTrapModule,
    ValidationErrorModule,
    TranslateModule,
    DatatableModule,
    PermissionDirectiveModule,
    UserRoutingModule
  ]
})
export class UserModule { }
