/* Licensed at AlphaOri Technologies */
package com.cpdss.common.generated.discharge_plan;

public interface DischargeDetailsOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:DischargeDetails)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int64 id = 1;</code>
   *
   * @return The id.
   */
  long getId();

  /**
   * <code>string timeOfSunrise = 2;</code>
   *
   * @return The timeOfSunrise.
   */
  java.lang.String getTimeOfSunrise();
  /**
   * <code>string timeOfSunrise = 2;</code>
   *
   * @return The bytes for timeOfSunrise.
   */
  com.google.protobuf.ByteString getTimeOfSunriseBytes();

  /**
   * <code>string timeOfSunset = 3;</code>
   *
   * @return The timeOfSunset.
   */
  java.lang.String getTimeOfSunset();
  /**
   * <code>string timeOfSunset = 3;</code>
   *
   * @return The bytes for timeOfSunset.
   */
  com.google.protobuf.ByteString getTimeOfSunsetBytes();

  /**
   * <code>string startTime = 4;</code>
   *
   * @return The startTime.
   */
  java.lang.String getStartTime();
  /**
   * <code>string startTime = 4;</code>
   *
   * @return The bytes for startTime.
   */
  com.google.protobuf.ByteString getStartTimeBytes();

  /**
   * <code>.TrimAllowed trimAllowed = 5;</code>
   *
   * @return Whether the trimAllowed field is set.
   */
  boolean hasTrimAllowed();
  /**
   * <code>.TrimAllowed trimAllowed = 5;</code>
   *
   * @return The trimAllowed.
   */
  com.cpdss.common.generated.loading_plan.LoadingPlanModels.TrimAllowed getTrimAllowed();
  /** <code>.TrimAllowed trimAllowed = 5;</code> */
  com.cpdss.common.generated.loading_plan.LoadingPlanModels.TrimAllowedOrBuilder
      getTrimAllowedOrBuilder();

  /**
   * <code>int64 voyageId = 6;</code>
   *
   * @return The voyageId.
   */
  long getVoyageId();

  /**
   * <code>string commonDate = 7;</code>
   *
   * @return The commonDate.
   */
  java.lang.String getCommonDate();
  /**
   * <code>string commonDate = 7;</code>
   *
   * @return The bytes for commonDate.
   */
  com.google.protobuf.ByteString getCommonDateBytes();

  /**
   * <code>string slopQuantity = 8;</code>
   *
   * @return The slopQuantity.
   */
  java.lang.String getSlopQuantity();
  /**
   * <code>string slopQuantity = 8;</code>
   *
   * @return The bytes for slopQuantity.
   */
  com.google.protobuf.ByteString getSlopQuantityBytes();
}
