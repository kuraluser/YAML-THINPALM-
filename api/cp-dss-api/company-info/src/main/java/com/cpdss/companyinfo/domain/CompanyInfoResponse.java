/* Licensed at AlphaOri Technologies */
package com.cpdss.companyinfo.domain;

import java.util.List;
import lombok.Data;

/**
 * DTO for company related public data
 *
 * @author suhail.k
 */
@Data
public class CompanyInfoResponse {

  private String realm;

  private List<String> providers;

  private List<String> carousals;

  private String logo;

  private String favicon;

  private String documentationSiteUrl;

  private String simulatorSiteUrl;
}
