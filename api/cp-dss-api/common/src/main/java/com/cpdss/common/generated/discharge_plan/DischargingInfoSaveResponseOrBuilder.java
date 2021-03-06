/* Licensed at AlphaOri Technologies */
package com.cpdss.common.generated.discharge_plan;

public interface DischargingInfoSaveResponseOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:DischargingInfoSaveResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int64 dischargingInfoId = 1;</code>
   *
   * @return The dischargingInfoId.
   */
  long getDischargingInfoId();

  /**
   * <code>int64 vesselId = 2;</code>
   *
   * @return The vesselId.
   */
  long getVesselId();

  /**
   * <code>int64 portRotationId = 3;</code>
   *
   * @return The portRotationId.
   */
  long getPortRotationId();

  /**
   * <code>int64 synopticalTableId = 4;</code>
   *
   * @return The synopticalTableId.
   */
  long getSynopticalTableId();

  /**
   * <code>int64 voyageId = 5;</code>
   *
   * @return The voyageId.
   */
  long getVoyageId();

  /**
   * <code>.ResponseStatus responseStatus = 6;</code>
   *
   * @return Whether the responseStatus field is set.
   */
  boolean hasResponseStatus();
  /**
   * <code>.ResponseStatus responseStatus = 6;</code>
   *
   * @return The responseStatus.
   */
  com.cpdss.common.generated.Common.ResponseStatus getResponseStatus();
  /** <code>.ResponseStatus responseStatus = 6;</code> */
  com.cpdss.common.generated.Common.ResponseStatusOrBuilder getResponseStatusOrBuilder();
}
