/* Licensed at AlphaOri Technologies */
package com.cpdss.common.generated.discharge_plan;

/** Protobuf type {@code DischargingInfoLoadicatorDataRequest} */
public final class DischargingInfoLoadicatorDataRequest
    extends com.google.protobuf.GeneratedMessageV3
    implements
    // @@protoc_insertion_point(message_implements:DischargingInfoLoadicatorDataRequest)
    DischargingInfoLoadicatorDataRequestOrBuilder {
  private static final long serialVersionUID = 0L;
  // Use DischargingInfoLoadicatorDataRequest.newBuilder() to construct.
  private DischargingInfoLoadicatorDataRequest(
      com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }

  private DischargingInfoLoadicatorDataRequest() {
    processId_ = "";
    loadingInfoLoadicatorDetails_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
    return new DischargingInfoLoadicatorDataRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }

  private DischargingInfoLoadicatorDataRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
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
              java.lang.String s = input.readStringRequireUtf8();

              processId_ = s;
              break;
            }
          case 16:
            {
              dischargingInformationId_ = input.readInt64();
              break;
            }
          case 26:
            {
              if (!((mutable_bitField0_ & 0x00000001) != 0)) {
                loadingInfoLoadicatorDetails_ =
                    new java.util.ArrayList<
                        com.cpdss.common.generated.loading_plan.LoadingPlanModels
                            .LoadingInfoLoadicatorDetail>();
                mutable_bitField0_ |= 0x00000001;
              }
              loadingInfoLoadicatorDetails_.add(
                  input.readMessage(
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels
                          .LoadingInfoLoadicatorDetail.parser(),
                      extensionRegistry));
              break;
            }
          case 32:
            {
              isUllageUpdate_ = input.readBool();
              break;
            }
          case 40:
            {
              conditionType_ = input.readInt32();
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
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        loadingInfoLoadicatorDetails_ =
            java.util.Collections.unmodifiableList(loadingInfoLoadicatorDetails_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }

  public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
    return com.cpdss.common.generated.discharge_plan.DischargePlanModels
        .internal_static_DischargingInfoLoadicatorDataRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.cpdss.common.generated.discharge_plan.DischargePlanModels
        .internal_static_DischargingInfoLoadicatorDataRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.cpdss.common.generated.discharge_plan.DischargingInfoLoadicatorDataRequest.class,
            com.cpdss.common.generated.discharge_plan.DischargingInfoLoadicatorDataRequest.Builder
                .class);
  }

  public static final int PROCESSID_FIELD_NUMBER = 1;
  private volatile java.lang.Object processId_;
  /**
   * <code>string processId = 1;</code>
   *
   * @return The processId.
   */
  public java.lang.String getProcessId() {
    java.lang.Object ref = processId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      processId_ = s;
      return s;
    }
  }
  /**
   * <code>string processId = 1;</code>
   *
   * @return The bytes for processId.
   */
  public com.google.protobuf.ByteString getProcessIdBytes() {
    java.lang.Object ref = processId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
      processId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int DISCHARGINGINFORMATIONID_FIELD_NUMBER = 2;
  private long dischargingInformationId_;
  /**
   * <code>int64 dischargingInformationId = 2;</code>
   *
   * @return The dischargingInformationId.
   */
  public long getDischargingInformationId() {
    return dischargingInformationId_;
  }

  public static final int LOADINGINFOLOADICATORDETAILS_FIELD_NUMBER = 3;
  private java.util.List<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoLoadicatorDetail>
      loadingInfoLoadicatorDetails_;
  /** <code>repeated .LoadingInfoLoadicatorDetail loadingInfoLoadicatorDetails = 3;</code> */
  public java.util.List<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoLoadicatorDetail>
      getLoadingInfoLoadicatorDetailsList() {
    return loadingInfoLoadicatorDetails_;
  }
  /** <code>repeated .LoadingInfoLoadicatorDetail loadingInfoLoadicatorDetails = 3;</code> */
  public java.util.List<
          ? extends
              com.cpdss.common.generated.loading_plan.LoadingPlanModels
                  .LoadingInfoLoadicatorDetailOrBuilder>
      getLoadingInfoLoadicatorDetailsOrBuilderList() {
    return loadingInfoLoadicatorDetails_;
  }
  /** <code>repeated .LoadingInfoLoadicatorDetail loadingInfoLoadicatorDetails = 3;</code> */
  public int getLoadingInfoLoadicatorDetailsCount() {
    return loadingInfoLoadicatorDetails_.size();
  }
  /** <code>repeated .LoadingInfoLoadicatorDetail loadingInfoLoadicatorDetails = 3;</code> */
  public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoLoadicatorDetail
      getLoadingInfoLoadicatorDetails(int index) {
    return loadingInfoLoadicatorDetails_.get(index);
  }
  /** <code>repeated .LoadingInfoLoadicatorDetail loadingInfoLoadicatorDetails = 3;</code> */
  public com.cpdss.common.generated.loading_plan.LoadingPlanModels
          .LoadingInfoLoadicatorDetailOrBuilder
      getLoadingInfoLoadicatorDetailsOrBuilder(int index) {
    return loadingInfoLoadicatorDetails_.get(index);
  }

  public static final int ISULLAGEUPDATE_FIELD_NUMBER = 4;
  private boolean isUllageUpdate_;
  /**
   * <code>bool isUllageUpdate = 4;</code>
   *
   * @return The isUllageUpdate.
   */
  public boolean getIsUllageUpdate() {
    return isUllageUpdate_;
  }

  public static final int CONDITIONTYPE_FIELD_NUMBER = 5;
  private int conditionType_;
  /**
   * <code>int32 conditionType = 5;</code>
   *
   * @return The conditionType.
   */
  public int getConditionType() {
    return conditionType_;
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
    if (!getProcessIdBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, processId_);
    }
    if (dischargingInformationId_ != 0L) {
      output.writeInt64(2, dischargingInformationId_);
    }
    for (int i = 0; i < loadingInfoLoadicatorDetails_.size(); i++) {
      output.writeMessage(3, loadingInfoLoadicatorDetails_.get(i));
    }
    if (isUllageUpdate_ != false) {
      output.writeBool(4, isUllageUpdate_);
    }
    if (conditionType_ != 0) {
      output.writeInt32(5, conditionType_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getProcessIdBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, processId_);
    }
    if (dischargingInformationId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream.computeInt64Size(2, dischargingInformationId_);
    }
    for (int i = 0; i < loadingInfoLoadicatorDetails_.size(); i++) {
      size +=
          com.google.protobuf.CodedOutputStream.computeMessageSize(
              3, loadingInfoLoadicatorDetails_.get(i));
    }
    if (isUllageUpdate_ != false) {
      size += com.google.protobuf.CodedOutputStream.computeBoolSize(4, isUllageUpdate_);
    }
    if (conditionType_ != 0) {
      size += com.google.protobuf.CodedOutputStream.computeInt32Size(5, conditionType_);
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
        instanceof
        com.cpdss.common.generated.discharge_plan.DischargingInfoLoadicatorDataRequest)) {
      return super.equals(obj);
    }
    com.cpdss.common.generated.discharge_plan.DischargingInfoLoadicatorDataRequest other =
        (com.cpdss.common.generated.discharge_plan.DischargingInfoLoadicatorDataRequest) obj;

    if (!getProcessId().equals(other.getProcessId())) return false;
    if (getDischargingInformationId() != other.getDischargingInformationId()) return false;
    if (!getLoadingInfoLoadicatorDetailsList().equals(other.getLoadingInfoLoadicatorDetailsList()))
      return false;
    if (getIsUllageUpdate() != other.getIsUllageUpdate()) return false;
    if (getConditionType() != other.getConditionType()) return false;
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
    hash = (37 * hash) + PROCESSID_FIELD_NUMBER;
    hash = (53 * hash) + getProcessId().hashCode();
    hash = (37 * hash) + DISCHARGINGINFORMATIONID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getDischargingInformationId());
    if (getLoadingInfoLoadicatorDetailsCount() > 0) {
      hash = (37 * hash) + LOADINGINFOLOADICATORDETAILS_FIELD_NUMBER;
      hash = (53 * hash) + getLoadingInfoLoadicatorDetailsList().hashCode();
    }
    hash = (37 * hash) + ISULLAGEUPDATE_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(getIsUllageUpdate());
    hash = (37 * hash) + CONDITIONTYPE_FIELD_NUMBER;
    hash = (53 * hash) + getConditionType();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInfoLoadicatorDataRequest
      parseFrom(java.nio.ByteBuffer data)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInfoLoadicatorDataRequest
      parseFrom(
          java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInfoLoadicatorDataRequest
      parseFrom(com.google.protobuf.ByteString data)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInfoLoadicatorDataRequest
      parseFrom(
          com.google.protobuf.ByteString data,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInfoLoadicatorDataRequest
      parseFrom(byte[] data) throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInfoLoadicatorDataRequest
      parseFrom(byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInfoLoadicatorDataRequest
      parseFrom(java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInfoLoadicatorDataRequest
      parseFrom(
          java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInfoLoadicatorDataRequest
      parseDelimitedFrom(java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInfoLoadicatorDataRequest
      parseDelimitedFrom(
          java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInfoLoadicatorDataRequest
      parseFrom(com.google.protobuf.CodedInputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInfoLoadicatorDataRequest
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
      com.cpdss.common.generated.discharge_plan.DischargingInfoLoadicatorDataRequest prototype) {
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
  /** Protobuf type {@code DischargingInfoLoadicatorDataRequest} */
  public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
      implements
      // @@protoc_insertion_point(builder_implements:DischargingInfoLoadicatorDataRequest)
      com.cpdss.common.generated.discharge_plan.DischargingInfoLoadicatorDataRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanModels
          .internal_static_DischargingInfoLoadicatorDataRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanModels
          .internal_static_DischargingInfoLoadicatorDataRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.discharge_plan.DischargingInfoLoadicatorDataRequest.class,
              com.cpdss.common.generated.discharge_plan.DischargingInfoLoadicatorDataRequest.Builder
                  .class);
    }

    // Construct using
    // com.cpdss.common.generated.discharge_plan.DischargingInfoLoadicatorDataRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {
        getLoadingInfoLoadicatorDetailsFieldBuilder();
      }
    }

    @java.lang.Override
    public Builder clear() {
      super.clear();
      processId_ = "";

      dischargingInformationId_ = 0L;

      if (loadingInfoLoadicatorDetailsBuilder_ == null) {
        loadingInfoLoadicatorDetails_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        loadingInfoLoadicatorDetailsBuilder_.clear();
      }
      isUllageUpdate_ = false;

      conditionType_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanModels
          .internal_static_DischargingInfoLoadicatorDataRequest_descriptor;
    }

    @java.lang.Override
    public com.cpdss.common.generated.discharge_plan.DischargingInfoLoadicatorDataRequest
        getDefaultInstanceForType() {
      return com.cpdss.common.generated.discharge_plan.DischargingInfoLoadicatorDataRequest
          .getDefaultInstance();
    }

    @java.lang.Override
    public com.cpdss.common.generated.discharge_plan.DischargingInfoLoadicatorDataRequest build() {
      com.cpdss.common.generated.discharge_plan.DischargingInfoLoadicatorDataRequest result =
          buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.cpdss.common.generated.discharge_plan.DischargingInfoLoadicatorDataRequest
        buildPartial() {
      com.cpdss.common.generated.discharge_plan.DischargingInfoLoadicatorDataRequest result =
          new com.cpdss.common.generated.discharge_plan.DischargingInfoLoadicatorDataRequest(this);
      int from_bitField0_ = bitField0_;
      result.processId_ = processId_;
      result.dischargingInformationId_ = dischargingInformationId_;
      if (loadingInfoLoadicatorDetailsBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          loadingInfoLoadicatorDetails_ =
              java.util.Collections.unmodifiableList(loadingInfoLoadicatorDetails_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.loadingInfoLoadicatorDetails_ = loadingInfoLoadicatorDetails_;
      } else {
        result.loadingInfoLoadicatorDetails_ = loadingInfoLoadicatorDetailsBuilder_.build();
      }
      result.isUllageUpdate_ = isUllageUpdate_;
      result.conditionType_ = conditionType_;
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
          instanceof
          com.cpdss.common.generated.discharge_plan.DischargingInfoLoadicatorDataRequest) {
        return mergeFrom(
            (com.cpdss.common.generated.discharge_plan.DischargingInfoLoadicatorDataRequest) other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(
        com.cpdss.common.generated.discharge_plan.DischargingInfoLoadicatorDataRequest other) {
      if (other
          == com.cpdss.common.generated.discharge_plan.DischargingInfoLoadicatorDataRequest
              .getDefaultInstance()) return this;
      if (!other.getProcessId().isEmpty()) {
        processId_ = other.processId_;
        onChanged();
      }
      if (other.getDischargingInformationId() != 0L) {
        setDischargingInformationId(other.getDischargingInformationId());
      }
      if (loadingInfoLoadicatorDetailsBuilder_ == null) {
        if (!other.loadingInfoLoadicatorDetails_.isEmpty()) {
          if (loadingInfoLoadicatorDetails_.isEmpty()) {
            loadingInfoLoadicatorDetails_ = other.loadingInfoLoadicatorDetails_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureLoadingInfoLoadicatorDetailsIsMutable();
            loadingInfoLoadicatorDetails_.addAll(other.loadingInfoLoadicatorDetails_);
          }
          onChanged();
        }
      } else {
        if (!other.loadingInfoLoadicatorDetails_.isEmpty()) {
          if (loadingInfoLoadicatorDetailsBuilder_.isEmpty()) {
            loadingInfoLoadicatorDetailsBuilder_.dispose();
            loadingInfoLoadicatorDetailsBuilder_ = null;
            loadingInfoLoadicatorDetails_ = other.loadingInfoLoadicatorDetails_;
            bitField0_ = (bitField0_ & ~0x00000001);
            loadingInfoLoadicatorDetailsBuilder_ =
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
                    ? getLoadingInfoLoadicatorDetailsFieldBuilder()
                    : null;
          } else {
            loadingInfoLoadicatorDetailsBuilder_.addAllMessages(
                other.loadingInfoLoadicatorDetails_);
          }
        }
      }
      if (other.getIsUllageUpdate() != false) {
        setIsUllageUpdate(other.getIsUllageUpdate());
      }
      if (other.getConditionType() != 0) {
        setConditionType(other.getConditionType());
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
      com.cpdss.common.generated.discharge_plan.DischargingInfoLoadicatorDataRequest parsedMessage =
          null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage =
            (com.cpdss.common.generated.discharge_plan.DischargingInfoLoadicatorDataRequest)
                e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int bitField0_;

    private java.lang.Object processId_ = "";
    /**
     * <code>string processId = 1;</code>
     *
     * @return The processId.
     */
    public java.lang.String getProcessId() {
      java.lang.Object ref = processId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        processId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string processId = 1;</code>
     *
     * @return The bytes for processId.
     */
    public com.google.protobuf.ByteString getProcessIdBytes() {
      java.lang.Object ref = processId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        processId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string processId = 1;</code>
     *
     * @param value The processId to set.
     * @return This builder for chaining.
     */
    public Builder setProcessId(java.lang.String value) {
      if (value == null) {
        throw new NullPointerException();
      }

      processId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string processId = 1;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearProcessId() {

      processId_ = getDefaultInstance().getProcessId();
      onChanged();
      return this;
    }
    /**
     * <code>string processId = 1;</code>
     *
     * @param value The bytes for processId to set.
     * @return This builder for chaining.
     */
    public Builder setProcessIdBytes(com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      checkByteStringIsUtf8(value);

      processId_ = value;
      onChanged();
      return this;
    }

    private long dischargingInformationId_;
    /**
     * <code>int64 dischargingInformationId = 2;</code>
     *
     * @return The dischargingInformationId.
     */
    public long getDischargingInformationId() {
      return dischargingInformationId_;
    }
    /**
     * <code>int64 dischargingInformationId = 2;</code>
     *
     * @param value The dischargingInformationId to set.
     * @return This builder for chaining.
     */
    public Builder setDischargingInformationId(long value) {

      dischargingInformationId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 dischargingInformationId = 2;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearDischargingInformationId() {

      dischargingInformationId_ = 0L;
      onChanged();
      return this;
    }

    private java.util.List<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoLoadicatorDetail>
        loadingInfoLoadicatorDetails_ = java.util.Collections.emptyList();

    private void ensureLoadingInfoLoadicatorDetailsIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        loadingInfoLoadicatorDetails_ =
            new java.util.ArrayList<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels
                    .LoadingInfoLoadicatorDetail>(loadingInfoLoadicatorDetails_);
        bitField0_ |= 0x00000001;
      }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoLoadicatorDetail,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoLoadicatorDetail
                .Builder,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels
                .LoadingInfoLoadicatorDetailOrBuilder>
        loadingInfoLoadicatorDetailsBuilder_;

    /** <code>repeated .LoadingInfoLoadicatorDetail loadingInfoLoadicatorDetails = 3;</code> */
    public java.util.List<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoLoadicatorDetail>
        getLoadingInfoLoadicatorDetailsList() {
      if (loadingInfoLoadicatorDetailsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(loadingInfoLoadicatorDetails_);
      } else {
        return loadingInfoLoadicatorDetailsBuilder_.getMessageList();
      }
    }
    /** <code>repeated .LoadingInfoLoadicatorDetail loadingInfoLoadicatorDetails = 3;</code> */
    public int getLoadingInfoLoadicatorDetailsCount() {
      if (loadingInfoLoadicatorDetailsBuilder_ == null) {
        return loadingInfoLoadicatorDetails_.size();
      } else {
        return loadingInfoLoadicatorDetailsBuilder_.getCount();
      }
    }
    /** <code>repeated .LoadingInfoLoadicatorDetail loadingInfoLoadicatorDetails = 3;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoLoadicatorDetail
        getLoadingInfoLoadicatorDetails(int index) {
      if (loadingInfoLoadicatorDetailsBuilder_ == null) {
        return loadingInfoLoadicatorDetails_.get(index);
      } else {
        return loadingInfoLoadicatorDetailsBuilder_.getMessage(index);
      }
    }
    /** <code>repeated .LoadingInfoLoadicatorDetail loadingInfoLoadicatorDetails = 3;</code> */
    public Builder setLoadingInfoLoadicatorDetails(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoLoadicatorDetail
            value) {
      if (loadingInfoLoadicatorDetailsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureLoadingInfoLoadicatorDetailsIsMutable();
        loadingInfoLoadicatorDetails_.set(index, value);
        onChanged();
      } else {
        loadingInfoLoadicatorDetailsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /** <code>repeated .LoadingInfoLoadicatorDetail loadingInfoLoadicatorDetails = 3;</code> */
    public Builder setLoadingInfoLoadicatorDetails(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoLoadicatorDetail
                .Builder
            builderForValue) {
      if (loadingInfoLoadicatorDetailsBuilder_ == null) {
        ensureLoadingInfoLoadicatorDetailsIsMutable();
        loadingInfoLoadicatorDetails_.set(index, builderForValue.build());
        onChanged();
      } else {
        loadingInfoLoadicatorDetailsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .LoadingInfoLoadicatorDetail loadingInfoLoadicatorDetails = 3;</code> */
    public Builder addLoadingInfoLoadicatorDetails(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoLoadicatorDetail
            value) {
      if (loadingInfoLoadicatorDetailsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureLoadingInfoLoadicatorDetailsIsMutable();
        loadingInfoLoadicatorDetails_.add(value);
        onChanged();
      } else {
        loadingInfoLoadicatorDetailsBuilder_.addMessage(value);
      }
      return this;
    }
    /** <code>repeated .LoadingInfoLoadicatorDetail loadingInfoLoadicatorDetails = 3;</code> */
    public Builder addLoadingInfoLoadicatorDetails(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoLoadicatorDetail
            value) {
      if (loadingInfoLoadicatorDetailsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureLoadingInfoLoadicatorDetailsIsMutable();
        loadingInfoLoadicatorDetails_.add(index, value);
        onChanged();
      } else {
        loadingInfoLoadicatorDetailsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /** <code>repeated .LoadingInfoLoadicatorDetail loadingInfoLoadicatorDetails = 3;</code> */
    public Builder addLoadingInfoLoadicatorDetails(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoLoadicatorDetail
                .Builder
            builderForValue) {
      if (loadingInfoLoadicatorDetailsBuilder_ == null) {
        ensureLoadingInfoLoadicatorDetailsIsMutable();
        loadingInfoLoadicatorDetails_.add(builderForValue.build());
        onChanged();
      } else {
        loadingInfoLoadicatorDetailsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .LoadingInfoLoadicatorDetail loadingInfoLoadicatorDetails = 3;</code> */
    public Builder addLoadingInfoLoadicatorDetails(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoLoadicatorDetail
                .Builder
            builderForValue) {
      if (loadingInfoLoadicatorDetailsBuilder_ == null) {
        ensureLoadingInfoLoadicatorDetailsIsMutable();
        loadingInfoLoadicatorDetails_.add(index, builderForValue.build());
        onChanged();
      } else {
        loadingInfoLoadicatorDetailsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .LoadingInfoLoadicatorDetail loadingInfoLoadicatorDetails = 3;</code> */
    public Builder addAllLoadingInfoLoadicatorDetails(
        java.lang.Iterable<
                ? extends
                    com.cpdss.common.generated.loading_plan.LoadingPlanModels
                        .LoadingInfoLoadicatorDetail>
            values) {
      if (loadingInfoLoadicatorDetailsBuilder_ == null) {
        ensureLoadingInfoLoadicatorDetailsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, loadingInfoLoadicatorDetails_);
        onChanged();
      } else {
        loadingInfoLoadicatorDetailsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /** <code>repeated .LoadingInfoLoadicatorDetail loadingInfoLoadicatorDetails = 3;</code> */
    public Builder clearLoadingInfoLoadicatorDetails() {
      if (loadingInfoLoadicatorDetailsBuilder_ == null) {
        loadingInfoLoadicatorDetails_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        loadingInfoLoadicatorDetailsBuilder_.clear();
      }
      return this;
    }
    /** <code>repeated .LoadingInfoLoadicatorDetail loadingInfoLoadicatorDetails = 3;</code> */
    public Builder removeLoadingInfoLoadicatorDetails(int index) {
      if (loadingInfoLoadicatorDetailsBuilder_ == null) {
        ensureLoadingInfoLoadicatorDetailsIsMutable();
        loadingInfoLoadicatorDetails_.remove(index);
        onChanged();
      } else {
        loadingInfoLoadicatorDetailsBuilder_.remove(index);
      }
      return this;
    }
    /** <code>repeated .LoadingInfoLoadicatorDetail loadingInfoLoadicatorDetails = 3;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoLoadicatorDetail
            .Builder
        getLoadingInfoLoadicatorDetailsBuilder(int index) {
      return getLoadingInfoLoadicatorDetailsFieldBuilder().getBuilder(index);
    }
    /** <code>repeated .LoadingInfoLoadicatorDetail loadingInfoLoadicatorDetails = 3;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels
            .LoadingInfoLoadicatorDetailOrBuilder
        getLoadingInfoLoadicatorDetailsOrBuilder(int index) {
      if (loadingInfoLoadicatorDetailsBuilder_ == null) {
        return loadingInfoLoadicatorDetails_.get(index);
      } else {
        return loadingInfoLoadicatorDetailsBuilder_.getMessageOrBuilder(index);
      }
    }
    /** <code>repeated .LoadingInfoLoadicatorDetail loadingInfoLoadicatorDetails = 3;</code> */
    public java.util.List<
            ? extends
                com.cpdss.common.generated.loading_plan.LoadingPlanModels
                    .LoadingInfoLoadicatorDetailOrBuilder>
        getLoadingInfoLoadicatorDetailsOrBuilderList() {
      if (loadingInfoLoadicatorDetailsBuilder_ != null) {
        return loadingInfoLoadicatorDetailsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(loadingInfoLoadicatorDetails_);
      }
    }
    /** <code>repeated .LoadingInfoLoadicatorDetail loadingInfoLoadicatorDetails = 3;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoLoadicatorDetail
            .Builder
        addLoadingInfoLoadicatorDetailsBuilder() {
      return getLoadingInfoLoadicatorDetailsFieldBuilder()
          .addBuilder(
              com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoLoadicatorDetail
                  .getDefaultInstance());
    }
    /** <code>repeated .LoadingInfoLoadicatorDetail loadingInfoLoadicatorDetails = 3;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoLoadicatorDetail
            .Builder
        addLoadingInfoLoadicatorDetailsBuilder(int index) {
      return getLoadingInfoLoadicatorDetailsFieldBuilder()
          .addBuilder(
              index,
              com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoLoadicatorDetail
                  .getDefaultInstance());
    }
    /** <code>repeated .LoadingInfoLoadicatorDetail loadingInfoLoadicatorDetails = 3;</code> */
    public java.util.List<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoLoadicatorDetail
                .Builder>
        getLoadingInfoLoadicatorDetailsBuilderList() {
      return getLoadingInfoLoadicatorDetailsFieldBuilder().getBuilderList();
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoLoadicatorDetail,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingInfoLoadicatorDetail
                .Builder,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels
                .LoadingInfoLoadicatorDetailOrBuilder>
        getLoadingInfoLoadicatorDetailsFieldBuilder() {
      if (loadingInfoLoadicatorDetailsBuilder_ == null) {
        loadingInfoLoadicatorDetailsBuilder_ =
            new com.google.protobuf.RepeatedFieldBuilderV3<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels
                    .LoadingInfoLoadicatorDetail,
                com.cpdss.common.generated.loading_plan.LoadingPlanModels
                    .LoadingInfoLoadicatorDetail.Builder,
                com.cpdss.common.generated.loading_plan.LoadingPlanModels
                    .LoadingInfoLoadicatorDetailOrBuilder>(
                loadingInfoLoadicatorDetails_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        loadingInfoLoadicatorDetails_ = null;
      }
      return loadingInfoLoadicatorDetailsBuilder_;
    }

    private boolean isUllageUpdate_;
    /**
     * <code>bool isUllageUpdate = 4;</code>
     *
     * @return The isUllageUpdate.
     */
    public boolean getIsUllageUpdate() {
      return isUllageUpdate_;
    }
    /**
     * <code>bool isUllageUpdate = 4;</code>
     *
     * @param value The isUllageUpdate to set.
     * @return This builder for chaining.
     */
    public Builder setIsUllageUpdate(boolean value) {

      isUllageUpdate_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool isUllageUpdate = 4;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearIsUllageUpdate() {

      isUllageUpdate_ = false;
      onChanged();
      return this;
    }

    private int conditionType_;
    /**
     * <code>int32 conditionType = 5;</code>
     *
     * @return The conditionType.
     */
    public int getConditionType() {
      return conditionType_;
    }
    /**
     * <code>int32 conditionType = 5;</code>
     *
     * @param value The conditionType to set.
     * @return This builder for chaining.
     */
    public Builder setConditionType(int value) {

      conditionType_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 conditionType = 5;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearConditionType() {

      conditionType_ = 0;
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

    // @@protoc_insertion_point(builder_scope:DischargingInfoLoadicatorDataRequest)
  }

  // @@protoc_insertion_point(class_scope:DischargingInfoLoadicatorDataRequest)
  private static final com.cpdss.common.generated.discharge_plan
          .DischargingInfoLoadicatorDataRequest
      DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE =
        new com.cpdss.common.generated.discharge_plan.DischargingInfoLoadicatorDataRequest();
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInfoLoadicatorDataRequest
      getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<DischargingInfoLoadicatorDataRequest> PARSER =
      new com.google.protobuf.AbstractParser<DischargingInfoLoadicatorDataRequest>() {
        @java.lang.Override
        public DischargingInfoLoadicatorDataRequest parsePartialFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
          return new DischargingInfoLoadicatorDataRequest(input, extensionRegistry);
        }
      };

  public static com.google.protobuf.Parser<DischargingInfoLoadicatorDataRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<DischargingInfoLoadicatorDataRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.cpdss.common.generated.discharge_plan.DischargingInfoLoadicatorDataRequest
      getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
}
