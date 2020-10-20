import { Component, OnInit } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';
import { environment } from '../../environments/environment';
import { IAppConfiguration } from '../shared/services/app-configuration/app-configuration.model';
import { AppConfigurationService } from '../shared/services/app-configuration/app-configuration.service';

// Login component for shore-module

@Component({
  selector: 'app-login-shore',
  templateUrl: './login-shore.component.html',
  styleUrls: ['./login-shore.component.scss']
})
export class LoginShoreComponent implements OnInit {

  idpList = [];
  settings: IAppConfiguration;
  realm: string = '';

  constructor(private kcService: KeycloakService, private appConfig: AppConfigurationService) { }

  ngOnInit(): void {
    this.settings = AppConfigurationService.settings;
    this.createIdpInput();
  }

  // to bind input buttons dynamically from api response with identity-provider enabled
  createIdpInput() {
    let idpConfig = localStorage.getItem('keycloakIdpConfig').split(',');
    this.realm = localStorage.getItem('realm');
    for (let i = 0; i < idpConfig.length; i++) {
      this.idpList.push(idpConfig[i]);
    }
  }

  // common login function for all identity-providers
  login(idp) {
    let imageUrl = localStorage.getItem('logoUrl');
    this.kcService.login({
      redirectUri: window.location.protocol + '//' + window.location.hostname + ':' + this.settings.targetPort + '/?realm=' + this.realm + '&imgurl=' + imageUrl,
      idpHint: idp
    });
  }

}
