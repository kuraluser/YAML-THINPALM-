/* Licensed at AlphaOri Technologies */
package com.cpdss.common.generated.discharge_plan;

public interface DischargingPlanTankDetailsOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:DischargingPlanTankDetails)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string api = 1;</code>
   *
   * @return The api.
   */
  java.lang.String getApi();
  /**
   * <code>string api = 1;</code>
   *
   * @return The bytes for api.
   */
  com.google.protobuf.ByteString getApiBytes();

  /**
   * <code>int64 cargoNominationId = 2;</code>
   *
   * @return The cargoNominationId.
   */
  long getCargoNominationId();

  /**
   * <code>string quantity = 3;</code>
   *
   * @return The quantity.
   */
  java.lang.String getQuantity();
  /**
   * <code>string quantity = 3;</code>
   *
   * @return The bytes for quantity.
   */
  com.google.protobuf.ByteString getQuantityBytes();

  /**
   * <code>int64 tankId = 4;</code>
   *
   * @return The tankId.
   */
  long getTankId();

  /**
   * <code>string temperature = 5;</code>
   *
   * @return The temperature.
   */
  java.lang.String getTemperature();
  /**
   * <code>string temperature = 5;</code>
   *
   * @return The bytes for temperature.
   */
  com.google.protobuf.ByteString getTemperatureBytes();

  /**
   * <code>string ullage = 6;</code>
   *
   * @return The ullage.
   */
  java.lang.String getUllage();
  /**
   * <code>string ullage = 6;</code>
   *
   * @return The bytes for ullage.
   */
  com.google.protobuf.ByteString getUllageBytes();

  /**
   * <code>string quantityM3 = 7;</code>
   *
   * @return The quantityM3.
   */
  java.lang.String getQuantityM3();
  /**
   * <code>string quantityM3 = 7;</code>
   *
   * @return The bytes for quantityM3.
   */
  com.google.protobuf.ByteString getQuantityM3Bytes();

  /**
   * <code>string sounding = 8;</code>
   *
   * @return The sounding.
   */
  java.lang.String getSounding();
  /**
   * <code>string sounding = 8;</code>
   *
   * @return The bytes for sounding.
   */
  com.google.protobuf.ByteString getSoundingBytes();

  /**
   * <code>int32 conditionType = 9;</code>
   *
   * @return The conditionType.
   */
  int getConditionType();

  /**
   * <code>int32 valueType = 10;</code>
   *
   * @return The valueType.
   */
  int getValueType();

  /**
   * <code>int64 id = 11;</code>
   *
   * @return The id.
   */
  long getId();
}
