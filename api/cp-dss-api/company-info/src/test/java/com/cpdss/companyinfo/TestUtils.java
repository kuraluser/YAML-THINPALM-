/* Licensed at AlphaOri Technologies */
package com.cpdss.companyinfo;

import com.cpdss.companyinfo.domain.CompanyInfoResponse;
import com.cpdss.companyinfo.entity.Carousals;
import com.cpdss.companyinfo.entity.Company;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/** Common constants and method for unit tests */
public final class TestUtils {

  public static final String TEST_DOMAIN = "company.host.com";
  public static final String TEST_REALM = "company";
  public static final String TEST_KEYCLOAK_IDP = "idp1,idp2";

  public static final String REALM = "realm";
  public static final String IDP = "idp";

  public static final String TEST_FILE_NAME = "test.png";

  public static final String INVALID_ERROR_CODE = "Invalid error code";
  public static final String INVALID_HTTP_STATUS = "Invalid http status";

  /**
   * Create Company entity with test data
   *
   * @return {@link Company}
   */
  public static Company prepareCompanyEntity() {
    Company entity = new Company();
    entity.setDomain(TEST_DOMAIN);
    entity.setKeycloakIdp(TEST_KEYCLOAK_IDP);
    entity.setRealm(TEST_REALM);
    Set<Carousals> carousals = new HashSet<>();
    Carousals ca = new Carousals();
    ca.setCompany(entity);
    ca.setFilePath(TEST_FILE_NAME);
    carousals.add(ca);
    entity.setCarousals(carousals);
    return entity;
  }

  /**
   * Create CompanyInfoResponse with test data
   *
   * @return {@link CompanyInfoResponse}
   */
  public static CompanyInfoResponse prepareCompanyInfoResponse() {
    CompanyInfoResponse response = new CompanyInfoResponse();
    response.setRealm(TEST_REALM);
    response.setProviders(Arrays.asList(TEST_KEYCLOAK_IDP.split(",")));
    return response;
  }
}
