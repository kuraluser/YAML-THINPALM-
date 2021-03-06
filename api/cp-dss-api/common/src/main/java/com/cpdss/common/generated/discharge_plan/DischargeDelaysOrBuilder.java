/* Licensed at AlphaOri Technologies */
package com.cpdss.common.generated.discharge_plan;

public interface DischargeDelaysOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:DischargeDelays)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * primary key
   * </pre>
   *
   * <code>int64 id = 1;</code>
   *
   * @return The id.
   */
  long getId();

  /**
   * <code>int64 dischargeInfoId = 2;</code>
   *
   * @return The dischargeInfoId.
   */
  long getDischargeInfoId();

  /**
   * <code>repeated int64 reasonForDelayIds = 3;</code>
   *
   * @return A list containing the reasonForDelayIds.
   */
  java.util.List<java.lang.Long> getReasonForDelayIdsList();
  /**
   * <code>repeated int64 reasonForDelayIds = 3;</code>
   *
   * @return The count of reasonForDelayIds.
   */
  int getReasonForDelayIdsCount();
  /**
   * <code>repeated int64 reasonForDelayIds = 3;</code>
   *
   * @param index The index of the element to return.
   * @return The reasonForDelayIds at the given index.
   */
  long getReasonForDelayIds(int index);

  /**
   * <code>string duration = 4;</code>
   *
   * @return The duration.
   */
  java.lang.String getDuration();
  /**
   * <code>string duration = 4;</code>
   *
   * @return The bytes for duration.
   */
  com.google.protobuf.ByteString getDurationBytes();

  /**
   * <code>int64 cargoId = 5;</code>
   *
   * @return The cargoId.
   */
  long getCargoId();

  /**
   * <code>string quantity = 6;</code>
   *
   * @return The quantity.
   */
  java.lang.String getQuantity();
  /**
   * <code>string quantity = 6;</code>
   *
   * @return The bytes for quantity.
   */
  com.google.protobuf.ByteString getQuantityBytes();

  /**
   * <code>int64 cargoNominationId = 7;</code>
   *
   * @return The cargoNominationId.
   */
  long getCargoNominationId();

  /**
   * <code>int64 sequenceNo = 8;</code>
   *
   * @return The sequenceNo.
   */
  long getSequenceNo();

  /**
   * <code>string dischargingRate = 9;</code>
   *
   * @return The dischargingRate.
   */
  java.lang.String getDischargingRate();
  /**
   * <code>string dischargingRate = 9;</code>
   *
   * @return The bytes for dischargingRate.
   */
  com.google.protobuf.ByteString getDischargingRateBytes();
}
