/* Licensed at AlphaOri Technologies */
package com.cpdss.gateway.domain;

import java.math.BigDecimal;
import java.util.List;
import lombok.Data;

@Data
public class PortDetails {

  private Long portId;
  private String portName;
  private String portCode;
  private BigDecimal maxPermissibleDraft;
  private Long timezoneId;
  private String timezone;
  private String timezoneOffsetVal;
  private String timezoneAbbreviation;
  private BigDecimal tideHeightHigh;
  private BigDecimal tideHeightLow;
  private BigDecimal densityOfWater;
  private Long countryId;
  private String countryName;
  private BigDecimal ambientTemperature;
  private String latitude;
  private String longitude;
  private List<PortBerthInfoResponse> berthInfo;
}
