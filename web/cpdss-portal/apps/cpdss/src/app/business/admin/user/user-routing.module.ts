import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserListingComponent } from './user-listing/user-listing.component';

const routes: Routes = [
    {
        path: '',
        component: UserListingComponent
    }
];

/**
 * Routing Module for User Routing Module
 *
 * @export
 * @class UserRoutingModule
 */

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class UserRoutingModule { }
