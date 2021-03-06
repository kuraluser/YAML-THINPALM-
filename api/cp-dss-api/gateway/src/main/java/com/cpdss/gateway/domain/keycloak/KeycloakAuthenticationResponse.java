/* Licensed at AlphaOri Technologies */
package com.cpdss.gateway.domain.keycloak;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for Keycloak authentication response
 *
 * @author sreekumar.k
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class KeycloakAuthenticationResponse implements Serializable {
  private static final long serialVersionUID = 4131867740556486718L;

  private String access_token;
  private int expires_in;
  private int refresh_expires_in;
  private String refresh_token;
  private String token_type;
  private String scope;
}
