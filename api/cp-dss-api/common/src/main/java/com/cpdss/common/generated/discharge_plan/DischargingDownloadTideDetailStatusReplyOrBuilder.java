/* Licensed at AlphaOri Technologies */
package com.cpdss.common.generated.discharge_plan;

public interface DischargingDownloadTideDetailStatusReplyOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:DischargingDownloadTideDetailStatusReply)
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

  /**
   * <code>bytes data = 2;</code>
   *
   * @return The data.
   */
  com.google.protobuf.ByteString getData();

  /**
   * <code>int32 size = 3;</code>
   *
   * @return The size.
   */
  int getSize();
}
