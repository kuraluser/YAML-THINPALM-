/* Licensed at AlphaOri Technologies */
package com.cpdss.common.generated.discharge_plan;

public interface DischargePlanAlgoRequestOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:DischargePlanAlgoRequest)
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
   * <code>string requestAsJsonString = 2;</code>
   *
   * @return The requestAsJsonString.
   */
  java.lang.String getRequestAsJsonString();
  /**
   * <code>string requestAsJsonString = 2;</code>
   *
   * @return The bytes for requestAsJsonString.
   */
  com.google.protobuf.ByteString getRequestAsJsonStringBytes();

  /**
   * <code>string processId = 3;</code>
   *
   * @return The processId.
   */
  java.lang.String getProcessId();
  /**
   * <code>string processId = 3;</code>
   *
   * @return The bytes for processId.
   */
  com.google.protobuf.ByteString getProcessIdBytes();
}
