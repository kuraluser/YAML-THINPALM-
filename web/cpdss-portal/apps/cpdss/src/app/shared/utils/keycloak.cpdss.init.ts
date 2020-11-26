import { KeycloakService } from 'keycloak-angular';
import { KeycloakConfig } from 'keycloak-js';
import { HttpClient } from '@angular/common/http';
import { IAppConfiguration } from '../services/app-configuration/app-configuration.model';
import { AppConfigurationService } from '../services/app-configuration/app-configuration.service';

/**
 *  keycloak initializer function for main shore application
 */

let keycloakConfig: KeycloakConfig = { url: '', realm: '', clientId: '' }

export function keycloakCPDSSInitializer(keycloak: KeycloakService, http: HttpClient, appConfig: AppConfigurationService): () => Promise<any> {
    return async (): Promise<any> => {
        const appSettings: IAppConfiguration = await appConfig.load();
        return new Promise(async (resolve, reject) => {
            try {
                const imageIndex = window.location.search.indexOf('imgurl');
                let imgUri = window.location.search.substring(imageIndex + 7);
                if (localStorage.getItem('companyLogo') !== undefined && localStorage.getItem('companyLogo') !== 'undefined' && localStorage.getItem('companyLogo') !== '' && localStorage.getItem('companyLogo') !== null) {
                    imgUri = localStorage.getItem('companyLogo');
                }
                else {
                    localStorage.setItem('companyLogo', imgUri);
                }

                let realm;
                if (localStorage.getItem('realm') !== undefined && localStorage.getItem('realm') !== 'undefined' && localStorage.getItem('realm') !== '' && localStorage.getItem('realm') !== null) {
                    realm = localStorage.getItem('realm');
                }
                else {
                    realm = window.location.search.split('&')[0].split('=')[1];
                    if (realm) {
                        localStorage.setItem('realm', realm);
                    }
                }


                keycloakConfig = {
                    url: appSettings.keycloakUrl,
                    realm: realm,
                    clientId: appSettings.clientId
                }
                
                const isLoggedIn = await keycloak.init({
                    config: keycloakConfig,
                    initOptions: {
                        onLoad: 'login-required',
                        silentCheckSsoRedirectUri: window.location.origin + '/assets/keycloak/silent-check-sso.html',
                        checkLoginIframe: false
                    },
                    bearerExcludedUrls: ['/assets']
                });

                // If not logged in redirect to login app
                if (!isLoggedIn) {
                    window.location.href = window.location.protocol + '//' + window.location.hostname + ':' + appSettings.redirectPort;
                }

                resolve();
            } catch (error) {
                // If error redirect to login app
                window.location.href = window.location.protocol + '//' + window.location.hostname + ':' + appSettings.redirectPort;
                reject(error);
            }
        });
    };
}
