import { Routes } from '@angular/router';
import { BusinessRoutingCommonConfig } from './business-routing.config.common';
import { BusinessComponent } from '../../business.component';

export class BusinessRoutingConfig {
    static getRoutesForEnvironment(): Routes {
        return [
            {
                path: '',
                component: BusinessComponent,
                children: [
                    { path: '', redirectTo: 'fleet', pathMatch: 'full' },
                    ...BusinessRoutingCommonConfig.getRoutesForEnvironment(),
                    { path: 'fleet', loadChildren: () => import('../../fleet/fleet.module').then(m => m.FleetModule) },
                    { path: 'voyages', loadChildren: () => import('../../voyages/voyages.module').then(m => m.VoyagesModule) }
                ]
            }
        ];
    }
}
