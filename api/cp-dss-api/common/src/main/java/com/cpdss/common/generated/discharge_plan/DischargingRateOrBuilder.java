/* Licensed at AlphaOri Technologies */
package com.cpdss.common.generated.discharge_plan;

public interface DischargingRateOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:DischargingRate)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string dischargingRate = 1;</code>
   *
   * @return The dischargingRate.
   */
  java.lang.String getDischargingRate();
  /**
   * <code>string dischargingRate = 1;</code>
   *
   * @return The bytes for dischargingRate.
   */
  com.google.protobuf.ByteString getDischargingRateBytes();

  /**
   * <code>int64 tankId = 2;</code>
   *
   * @return The tankId.
   */
  long getTankId();

  /**
   * <code>int32 startTime = 3;</code>
   *
   * @return The startTime.
   */
  int getStartTime();

  /**
   * <code>int32 endTime = 4;</code>
   *
   * @return The endTime.
   */
  int getEndTime();
}
