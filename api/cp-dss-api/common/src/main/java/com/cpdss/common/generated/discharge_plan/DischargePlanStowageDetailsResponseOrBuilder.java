/* Licensed at AlphaOri Technologies */
package com.cpdss.common.generated.discharge_plan;

public interface DischargePlanStowageDetailsResponseOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:DischargePlanStowageDetailsResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.ResponseStatus responseStatus = 1;</code>
   *
   * @return Whether the responseStatus field is set.
   */
  boolean hasResponseStatus();
  /**
   * <code>.ResponseStatus responseStatus = 1;</code>
   *
   * @return The responseStatus.
   */
  com.cpdss.common.generated.Common.ResponseStatus getResponseStatus();
  /** <code>.ResponseStatus responseStatus = 1;</code> */
  com.cpdss.common.generated.Common.ResponseStatusOrBuilder getResponseStatusOrBuilder();

  /** <code>repeated .LoadingPlanTankDetails dischargingPlanTankDetails = 2;</code> */
  java.util.List<com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails>
      getDischargingPlanTankDetailsList();
  /** <code>repeated .LoadingPlanTankDetails dischargingPlanTankDetails = 2;</code> */
  com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
      getDischargingPlanTankDetails(int index);
  /** <code>repeated .LoadingPlanTankDetails dischargingPlanTankDetails = 2;</code> */
  int getDischargingPlanTankDetailsCount();
  /** <code>repeated .LoadingPlanTankDetails dischargingPlanTankDetails = 2;</code> */
  java.util.List<
          ? extends
              com.cpdss.common.generated.loading_plan.LoadingPlanModels
                  .LoadingPlanTankDetailsOrBuilder>
      getDischargingPlanTankDetailsOrBuilderList();
  /** <code>repeated .LoadingPlanTankDetails dischargingPlanTankDetails = 2;</code> */
  com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetailsOrBuilder
      getDischargingPlanTankDetailsOrBuilder(int index);
}
