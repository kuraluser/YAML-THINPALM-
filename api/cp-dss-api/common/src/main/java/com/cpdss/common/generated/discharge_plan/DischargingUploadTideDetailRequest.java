/* Licensed at AlphaOri Technologies */
package com.cpdss.common.generated.discharge_plan;

/** Protobuf type {@code DischargingUploadTideDetailRequest} */
public final class DischargingUploadTideDetailRequest extends com.google.protobuf.GeneratedMessageV3
    implements
    // @@protoc_insertion_point(message_implements:DischargingUploadTideDetailRequest)
    DischargingUploadTideDetailRequestOrBuilder {
  private static final long serialVersionUID = 0L;
  // Use DischargingUploadTideDetailRequest.newBuilder() to construct.
  private DischargingUploadTideDetailRequest(
      com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }

  private DischargingUploadTideDetailRequest() {
    tideDetaildata_ = com.google.protobuf.ByteString.EMPTY;
    portName_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
    return new DischargingUploadTideDetailRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }

  private DischargingUploadTideDetailRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10:
            {
              tideDetaildata_ = input.readBytes();
              break;
            }
          case 18:
            {
              com.cpdss.common.generated.Common.ResponseStatus.Builder subBuilder = null;
              if (responseStatus_ != null) {
                subBuilder = responseStatus_.toBuilder();
              }
              responseStatus_ =
                  input.readMessage(
                      com.cpdss.common.generated.Common.ResponseStatus.parser(), extensionRegistry);
              if (subBuilder != null) {
                subBuilder.mergeFrom(responseStatus_);
                responseStatus_ = subBuilder.buildPartial();
              }

              break;
            }
          case 24:
            {
              loadingId_ = input.readInt64();
              break;
            }
          case 34:
            {
              java.lang.String s = input.readStringRequireUtf8();

              portName_ = s;
              break;
            }
          case 40:
            {
              portId_ = input.readInt64();
              break;
            }
          default:
            {
              if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }

  public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
    return com.cpdss.common.generated.discharge_plan.DischargePlanModels
        .internal_static_DischargingUploadTideDetailRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.cpdss.common.generated.discharge_plan.DischargePlanModels
        .internal_static_DischargingUploadTideDetailRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.cpdss.common.generated.discharge_plan.DischargingUploadTideDetailRequest.class,
            com.cpdss.common.generated.discharge_plan.DischargingUploadTideDetailRequest.Builder
                .class);
  }

  public static final int TIDEDETAILDATA_FIELD_NUMBER = 1;
  private com.google.protobuf.ByteString tideDetaildata_;
  /**
   * <code>bytes tideDetaildata = 1;</code>
   *
   * @return The tideDetaildata.
   */
  public com.google.protobuf.ByteString getTideDetaildata() {
    return tideDetaildata_;
  }

  public static final int RESPONSESTATUS_FIELD_NUMBER = 2;
  private com.cpdss.common.generated.Common.ResponseStatus responseStatus_;
  /**
   * <code>.ResponseStatus responseStatus = 2;</code>
   *
   * @return Whether the responseStatus field is set.
   */
  public boolean hasResponseStatus() {
    return responseStatus_ != null;
  }
  /**
   * <code>.ResponseStatus responseStatus = 2;</code>
   *
   * @return The responseStatus.
   */
  public com.cpdss.common.generated.Common.ResponseStatus getResponseStatus() {
    return responseStatus_ == null
        ? com.cpdss.common.generated.Common.ResponseStatus.getDefaultInstance()
        : responseStatus_;
  }
  /** <code>.ResponseStatus responseStatus = 2;</code> */
  public com.cpdss.common.generated.Common.ResponseStatusOrBuilder getResponseStatusOrBuilder() {
    return getResponseStatus();
  }

  public static final int LOADINGID_FIELD_NUMBER = 3;
  private long loadingId_;
  /**
   * <code>int64 loadingId = 3;</code>
   *
   * @return The loadingId.
   */
  public long getLoadingId() {
    return loadingId_;
  }

  public static final int PORTNAME_FIELD_NUMBER = 4;
  private volatile java.lang.Object portName_;
  /**
   * <code>string portName = 4;</code>
   *
   * @return The portName.
   */
  public java.lang.String getPortName() {
    java.lang.Object ref = portName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      portName_ = s;
      return s;
    }
  }
  /**
   * <code>string portName = 4;</code>
   *
   * @return The bytes for portName.
   */
  public com.google.protobuf.ByteString getPortNameBytes() {
    java.lang.Object ref = portName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
      portName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int PORTID_FIELD_NUMBER = 5;
  private long portId_;
  /**
   * <code>int64 portId = 5;</code>
   *
   * @return The portId.
   */
  public long getPortId() {
    return portId_;
  }

  private byte memoizedIsInitialized = -1;

  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output) throws java.io.IOException {
    if (!tideDetaildata_.isEmpty()) {
      output.writeBytes(1, tideDetaildata_);
    }
    if (responseStatus_ != null) {
      output.writeMessage(2, getResponseStatus());
    }
    if (loadingId_ != 0L) {
      output.writeInt64(3, loadingId_);
    }
    if (!getPortNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, portName_);
    }
    if (portId_ != 0L) {
      output.writeInt64(5, portId_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!tideDetaildata_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream.computeBytesSize(1, tideDetaildata_);
    }
    if (responseStatus_ != null) {
      size += com.google.protobuf.CodedOutputStream.computeMessageSize(2, getResponseStatus());
    }
    if (loadingId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream.computeInt64Size(3, loadingId_);
    }
    if (!getPortNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, portName_);
    }
    if (portId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream.computeInt64Size(5, portId_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj
        instanceof com.cpdss.common.generated.discharge_plan.DischargingUploadTideDetailRequest)) {
      return super.equals(obj);
    }
    com.cpdss.common.generated.discharge_plan.DischargingUploadTideDetailRequest other =
        (com.cpdss.common.generated.discharge_plan.DischargingUploadTideDetailRequest) obj;

    if (!getTideDetaildata().equals(other.getTideDetaildata())) return false;
    if (hasResponseStatus() != other.hasResponseStatus()) return false;
    if (hasResponseStatus()) {
      if (!getResponseStatus().equals(other.getResponseStatus())) return false;
    }
    if (getLoadingId() != other.getLoadingId()) return false;
    if (!getPortName().equals(other.getPortName())) return false;
    if (getPortId() != other.getPortId()) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + TIDEDETAILDATA_FIELD_NUMBER;
    hash = (53 * hash) + getTideDetaildata().hashCode();
    if (hasResponseStatus()) {
      hash = (37 * hash) + RESPONSESTATUS_FIELD_NUMBER;
      hash = (53 * hash) + getResponseStatus().hashCode();
    }
    hash = (37 * hash) + LOADINGID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getLoadingId());
    hash = (37 * hash) + PORTNAME_FIELD_NUMBER;
    hash = (53 * hash) + getPortName().hashCode();
    hash = (37 * hash) + PORTID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getPortId());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingUploadTideDetailRequest
      parseFrom(java.nio.ByteBuffer data)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingUploadTideDetailRequest
      parseFrom(
          java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingUploadTideDetailRequest
      parseFrom(com.google.protobuf.ByteString data)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingUploadTideDetailRequest
      parseFrom(
          com.google.protobuf.ByteString data,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingUploadTideDetailRequest
      parseFrom(byte[] data) throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingUploadTideDetailRequest
      parseFrom(byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingUploadTideDetailRequest
      parseFrom(java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingUploadTideDetailRequest
      parseFrom(
          java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingUploadTideDetailRequest
      parseDelimitedFrom(java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingUploadTideDetailRequest
      parseDelimitedFrom(
          java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingUploadTideDetailRequest
      parseFrom(com.google.protobuf.CodedInputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingUploadTideDetailRequest
      parseFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() {
    return newBuilder();
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(
      com.cpdss.common.generated.discharge_plan.DischargingUploadTideDetailRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /** Protobuf type {@code DischargingUploadTideDetailRequest} */
  public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
      implements
      // @@protoc_insertion_point(builder_implements:DischargingUploadTideDetailRequest)
      com.cpdss.common.generated.discharge_plan.DischargingUploadTideDetailRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanModels
          .internal_static_DischargingUploadTideDetailRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanModels
          .internal_static_DischargingUploadTideDetailRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.discharge_plan.DischargingUploadTideDetailRequest.class,
              com.cpdss.common.generated.discharge_plan.DischargingUploadTideDetailRequest.Builder
                  .class);
    }

    // Construct using
    // com.cpdss.common.generated.discharge_plan.DischargingUploadTideDetailRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {}
    }

    @java.lang.Override
    public Builder clear() {
      super.clear();
      tideDetaildata_ = com.google.protobuf.ByteString.EMPTY;

      if (responseStatusBuilder_ == null) {
        responseStatus_ = null;
      } else {
        responseStatus_ = null;
        responseStatusBuilder_ = null;
      }
      loadingId_ = 0L;

      portName_ = "";

      portId_ = 0L;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanModels
          .internal_static_DischargingUploadTideDetailRequest_descriptor;
    }

    @java.lang.Override
    public com.cpdss.common.generated.discharge_plan.DischargingUploadTideDetailRequest
        getDefaultInstanceForType() {
      return com.cpdss.common.generated.discharge_plan.DischargingUploadTideDetailRequest
          .getDefaultInstance();
    }

    @java.lang.Override
    public com.cpdss.common.generated.discharge_plan.DischargingUploadTideDetailRequest build() {
      com.cpdss.common.generated.discharge_plan.DischargingUploadTideDetailRequest result =
          buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.cpdss.common.generated.discharge_plan.DischargingUploadTideDetailRequest
        buildPartial() {
      com.cpdss.common.generated.discharge_plan.DischargingUploadTideDetailRequest result =
          new com.cpdss.common.generated.discharge_plan.DischargingUploadTideDetailRequest(this);
      result.tideDetaildata_ = tideDetaildata_;
      if (responseStatusBuilder_ == null) {
        result.responseStatus_ = responseStatus_;
      } else {
        result.responseStatus_ = responseStatusBuilder_.build();
      }
      result.loadingId_ = loadingId_;
      result.portName_ = portName_;
      result.portId_ = portId_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }

    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field, java.lang.Object value) {
      return super.setField(field, value);
    }

    @java.lang.Override
    public Builder clearField(com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }

    @java.lang.Override
    public Builder clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }

    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field, int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }

    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field, java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other
          instanceof com.cpdss.common.generated.discharge_plan.DischargingUploadTideDetailRequest) {
        return mergeFrom(
            (com.cpdss.common.generated.discharge_plan.DischargingUploadTideDetailRequest) other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(
        com.cpdss.common.generated.discharge_plan.DischargingUploadTideDetailRequest other) {
      if (other
          == com.cpdss.common.generated.discharge_plan.DischargingUploadTideDetailRequest
              .getDefaultInstance()) return this;
      if (other.getTideDetaildata() != com.google.protobuf.ByteString.EMPTY) {
        setTideDetaildata(other.getTideDetaildata());
      }
      if (other.hasResponseStatus()) {
        mergeResponseStatus(other.getResponseStatus());
      }
      if (other.getLoadingId() != 0L) {
        setLoadingId(other.getLoadingId());
      }
      if (!other.getPortName().isEmpty()) {
        portName_ = other.portName_;
        onChanged();
      }
      if (other.getPortId() != 0L) {
        setPortId(other.getPortId());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.cpdss.common.generated.discharge_plan.DischargingUploadTideDetailRequest parsedMessage =
          null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage =
            (com.cpdss.common.generated.discharge_plan.DischargingUploadTideDetailRequest)
                e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private com.google.protobuf.ByteString tideDetaildata_ = com.google.protobuf.ByteString.EMPTY;
    /**
     * <code>bytes tideDetaildata = 1;</code>
     *
     * @return The tideDetaildata.
     */
    public com.google.protobuf.ByteString getTideDetaildata() {
      return tideDetaildata_;
    }
    /**
     * <code>bytes tideDetaildata = 1;</code>
     *
     * @param value The tideDetaildata to set.
     * @return This builder for chaining.
     */
    public Builder setTideDetaildata(com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }

      tideDetaildata_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bytes tideDetaildata = 1;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearTideDetaildata() {

      tideDetaildata_ = getDefaultInstance().getTideDetaildata();
      onChanged();
      return this;
    }

    private com.cpdss.common.generated.Common.ResponseStatus responseStatus_;
    private com.google.protobuf.SingleFieldBuilderV3<
            com.cpdss.common.generated.Common.ResponseStatus,
            com.cpdss.common.generated.Common.ResponseStatus.Builder,
            com.cpdss.common.generated.Common.ResponseStatusOrBuilder>
        responseStatusBuilder_;
    /**
     * <code>.ResponseStatus responseStatus = 2;</code>
     *
     * @return Whether the responseStatus field is set.
     */
    public boolean hasResponseStatus() {
      return responseStatusBuilder_ != null || responseStatus_ != null;
    }
    /**
     * <code>.ResponseStatus responseStatus = 2;</code>
     *
     * @return The responseStatus.
     */
    public com.cpdss.common.generated.Common.ResponseStatus getResponseStatus() {
      if (responseStatusBuilder_ == null) {
        return responseStatus_ == null
            ? com.cpdss.common.generated.Common.ResponseStatus.getDefaultInstance()
            : responseStatus_;
      } else {
        return responseStatusBuilder_.getMessage();
      }
    }
    /** <code>.ResponseStatus responseStatus = 2;</code> */
    public Builder setResponseStatus(com.cpdss.common.generated.Common.ResponseStatus value) {
      if (responseStatusBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        responseStatus_ = value;
        onChanged();
      } else {
        responseStatusBuilder_.setMessage(value);
      }

      return this;
    }
    /** <code>.ResponseStatus responseStatus = 2;</code> */
    public Builder setResponseStatus(
        com.cpdss.common.generated.Common.ResponseStatus.Builder builderForValue) {
      if (responseStatusBuilder_ == null) {
        responseStatus_ = builderForValue.build();
        onChanged();
      } else {
        responseStatusBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /** <code>.ResponseStatus responseStatus = 2;</code> */
    public Builder mergeResponseStatus(com.cpdss.common.generated.Common.ResponseStatus value) {
      if (responseStatusBuilder_ == null) {
        if (responseStatus_ != null) {
          responseStatus_ =
              com.cpdss.common.generated.Common.ResponseStatus.newBuilder(responseStatus_)
                  .mergeFrom(value)
                  .buildPartial();
        } else {
          responseStatus_ = value;
        }
        onChanged();
      } else {
        responseStatusBuilder_.mergeFrom(value);
      }

      return this;
    }
    /** <code>.ResponseStatus responseStatus = 2;</code> */
    public Builder clearResponseStatus() {
      if (responseStatusBuilder_ == null) {
        responseStatus_ = null;
        onChanged();
      } else {
        responseStatus_ = null;
        responseStatusBuilder_ = null;
      }

      return this;
    }
    /** <code>.ResponseStatus responseStatus = 2;</code> */
    public com.cpdss.common.generated.Common.ResponseStatus.Builder getResponseStatusBuilder() {

      onChanged();
      return getResponseStatusFieldBuilder().getBuilder();
    }
    /** <code>.ResponseStatus responseStatus = 2;</code> */
    public com.cpdss.common.generated.Common.ResponseStatusOrBuilder getResponseStatusOrBuilder() {
      if (responseStatusBuilder_ != null) {
        return responseStatusBuilder_.getMessageOrBuilder();
      } else {
        return responseStatus_ == null
            ? com.cpdss.common.generated.Common.ResponseStatus.getDefaultInstance()
            : responseStatus_;
      }
    }
    /** <code>.ResponseStatus responseStatus = 2;</code> */
    private com.google.protobuf.SingleFieldBuilderV3<
            com.cpdss.common.generated.Common.ResponseStatus,
            com.cpdss.common.generated.Common.ResponseStatus.Builder,
            com.cpdss.common.generated.Common.ResponseStatusOrBuilder>
        getResponseStatusFieldBuilder() {
      if (responseStatusBuilder_ == null) {
        responseStatusBuilder_ =
            new com.google.protobuf.SingleFieldBuilderV3<
                com.cpdss.common.generated.Common.ResponseStatus,
                com.cpdss.common.generated.Common.ResponseStatus.Builder,
                com.cpdss.common.generated.Common.ResponseStatusOrBuilder>(
                getResponseStatus(), getParentForChildren(), isClean());
        responseStatus_ = null;
      }
      return responseStatusBuilder_;
    }

    private long loadingId_;
    /**
     * <code>int64 loadingId = 3;</code>
     *
     * @return The loadingId.
     */
    public long getLoadingId() {
      return loadingId_;
    }
    /**
     * <code>int64 loadingId = 3;</code>
     *
     * @param value The loadingId to set.
     * @return This builder for chaining.
     */
    public Builder setLoadingId(long value) {

      loadingId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 loadingId = 3;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearLoadingId() {

      loadingId_ = 0L;
      onChanged();
      return this;
    }

    private java.lang.Object portName_ = "";
    /**
     * <code>string portName = 4;</code>
     *
     * @return The portName.
     */
    public java.lang.String getPortName() {
      java.lang.Object ref = portName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        portName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string portName = 4;</code>
     *
     * @return The bytes for portName.
     */
    public com.google.protobuf.ByteString getPortNameBytes() {
      java.lang.Object ref = portName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        portName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string portName = 4;</code>
     *
     * @param value The portName to set.
     * @return This builder for chaining.
     */
    public Builder setPortName(java.lang.String value) {
      if (value == null) {
        throw new NullPointerException();
      }

      portName_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string portName = 4;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearPortName() {

      portName_ = getDefaultInstance().getPortName();
      onChanged();
      return this;
    }
    /**
     * <code>string portName = 4;</code>
     *
     * @param value The bytes for portName to set.
     * @return This builder for chaining.
     */
    public Builder setPortNameBytes(com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      checkByteStringIsUtf8(value);

      portName_ = value;
      onChanged();
      return this;
    }

    private long portId_;
    /**
     * <code>int64 portId = 5;</code>
     *
     * @return The portId.
     */
    public long getPortId() {
      return portId_;
    }
    /**
     * <code>int64 portId = 5;</code>
     *
     * @param value The portId to set.
     * @return This builder for chaining.
     */
    public Builder setPortId(long value) {

      portId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 portId = 5;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearPortId() {

      portId_ = 0L;
      onChanged();
      return this;
    }

    @java.lang.Override
    public final Builder setUnknownFields(final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }

    // @@protoc_insertion_point(builder_scope:DischargingUploadTideDetailRequest)
  }

  // @@protoc_insertion_point(class_scope:DischargingUploadTideDetailRequest)
  private static final com.cpdss.common.generated.discharge_plan.DischargingUploadTideDetailRequest
      DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE =
        new com.cpdss.common.generated.discharge_plan.DischargingUploadTideDetailRequest();
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingUploadTideDetailRequest
      getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<DischargingUploadTideDetailRequest> PARSER =
      new com.google.protobuf.AbstractParser<DischargingUploadTideDetailRequest>() {
        @java.lang.Override
        public DischargingUploadTideDetailRequest parsePartialFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
          return new DischargingUploadTideDetailRequest(input, extensionRegistry);
        }
      };

  public static com.google.protobuf.Parser<DischargingUploadTideDetailRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<DischargingUploadTideDetailRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.cpdss.common.generated.discharge_plan.DischargingUploadTideDetailRequest
      getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
}
