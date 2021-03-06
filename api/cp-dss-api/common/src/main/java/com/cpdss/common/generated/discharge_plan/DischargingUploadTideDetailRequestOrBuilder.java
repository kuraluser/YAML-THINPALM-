/* Licensed at AlphaOri Technologies */
package com.cpdss.common.generated.discharge_plan;

public interface DischargingUploadTideDetailRequestOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:DischargingUploadTideDetailRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>bytes tideDetaildata = 1;</code>
   *
   * @return The tideDetaildata.
   */
  com.google.protobuf.ByteString getTideDetaildata();

  /**
   * <code>.ResponseStatus responseStatus = 2;</code>
   *
   * @return Whether the responseStatus field is set.
   */
  boolean hasResponseStatus();
  /**
   * <code>.ResponseStatus responseStatus = 2;</code>
   *
   * @return The responseStatus.
   */
  com.cpdss.common.generated.Common.ResponseStatus getResponseStatus();
  /** <code>.ResponseStatus responseStatus = 2;</code> */
  com.cpdss.common.generated.Common.ResponseStatusOrBuilder getResponseStatusOrBuilder();

  /**
   * <code>int64 loadingId = 3;</code>
   *
   * @return The loadingId.
   */
  long getLoadingId();

  /**
   * <code>string portName = 4;</code>
   *
   * @return The portName.
   */
  java.lang.String getPortName();
  /**
   * <code>string portName = 4;</code>
   *
   * @return The bytes for portName.
   */
  com.google.protobuf.ByteString getPortNameBytes();

  /**
   * <code>int64 portId = 5;</code>
   *
   * @return The portId.
   */
  long getPortId();
}
