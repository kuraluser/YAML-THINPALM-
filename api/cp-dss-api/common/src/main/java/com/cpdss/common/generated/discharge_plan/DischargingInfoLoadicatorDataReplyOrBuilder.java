/* Licensed at AlphaOri Technologies */
package com.cpdss.common.generated.discharge_plan;

public interface DischargingInfoLoadicatorDataReplyOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:DischargingInfoLoadicatorDataReply)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string processId = 1;</code>
   *
   * @return The processId.
   */
  java.lang.String getProcessId();
  /**
   * <code>string processId = 1;</code>
   *
   * @return The bytes for processId.
   */
  com.google.protobuf.ByteString getProcessIdBytes();

  /**
   * <code>int64 loadableStudyId = 2;</code>
   *
   * @return The loadableStudyId.
   */
  long getLoadableStudyId();

  /**
   * <code>.ResponseStatus responseStatus = 3;</code>
   *
   * @return Whether the responseStatus field is set.
   */
  boolean hasResponseStatus();
  /**
   * <code>.ResponseStatus responseStatus = 3;</code>
   *
   * @return The responseStatus.
   */
  com.cpdss.common.generated.Common.ResponseStatus getResponseStatus();
  /** <code>.ResponseStatus responseStatus = 3;</code> */
  com.cpdss.common.generated.Common.ResponseStatusOrBuilder getResponseStatusOrBuilder();
}
