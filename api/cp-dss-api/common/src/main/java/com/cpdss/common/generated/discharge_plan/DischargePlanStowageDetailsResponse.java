/* Licensed at AlphaOri Technologies */
package com.cpdss.common.generated.discharge_plan;

/** Protobuf type {@code DischargePlanStowageDetailsResponse} */
public final class DischargePlanStowageDetailsResponse
    extends com.google.protobuf.GeneratedMessageV3
    implements
    // @@protoc_insertion_point(message_implements:DischargePlanStowageDetailsResponse)
    DischargePlanStowageDetailsResponseOrBuilder {
  private static final long serialVersionUID = 0L;
  // Use DischargePlanStowageDetailsResponse.newBuilder() to construct.
  private DischargePlanStowageDetailsResponse(
      com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }

  private DischargePlanStowageDetailsResponse() {
    dischargingPlanTankDetails_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
    return new DischargePlanStowageDetailsResponse();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }

  private DischargePlanStowageDetailsResponse(
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
          case 18:
            {
              if (!((mutable_bitField0_ & 0x00000001) != 0)) {
                dischargingPlanTankDetails_ =
                    new java.util.ArrayList<
                        com.cpdss.common.generated.loading_plan.LoadingPlanModels
                            .LoadingPlanTankDetails>();
                mutable_bitField0_ |= 0x00000001;
              }
              dischargingPlanTankDetails_.add(
                  input.readMessage(
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels
                          .LoadingPlanTankDetails.parser(),
                      extensionRegistry));
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
        dischargingPlanTankDetails_ =
            java.util.Collections.unmodifiableList(dischargingPlanTankDetails_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }

  public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
    return com.cpdss.common.generated.discharge_plan.DischargePlanModels
        .internal_static_DischargePlanStowageDetailsResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.cpdss.common.generated.discharge_plan.DischargePlanModels
        .internal_static_DischargePlanStowageDetailsResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.cpdss.common.generated.discharge_plan.DischargePlanStowageDetailsResponse.class,
            com.cpdss.common.generated.discharge_plan.DischargePlanStowageDetailsResponse.Builder
                .class);
  }

  public static final int RESPONSESTATUS_FIELD_NUMBER = 1;
  private com.cpdss.common.generated.Common.ResponseStatus responseStatus_;
  /**
   * <code>.ResponseStatus responseStatus = 1;</code>
   *
   * @return Whether the responseStatus field is set.
   */
  public boolean hasResponseStatus() {
    return responseStatus_ != null;
  }
  /**
   * <code>.ResponseStatus responseStatus = 1;</code>
   *
   * @return The responseStatus.
   */
  public com.cpdss.common.generated.Common.ResponseStatus getResponseStatus() {
    return responseStatus_ == null
        ? com.cpdss.common.generated.Common.ResponseStatus.getDefaultInstance()
        : responseStatus_;
  }
  /** <code>.ResponseStatus responseStatus = 1;</code> */
  public com.cpdss.common.generated.Common.ResponseStatusOrBuilder getResponseStatusOrBuilder() {
    return getResponseStatus();
  }

  public static final int DISCHARGINGPLANTANKDETAILS_FIELD_NUMBER = 2;
  private java.util.List<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails>
      dischargingPlanTankDetails_;
  /** <code>repeated .LoadingPlanTankDetails dischargingPlanTankDetails = 2;</code> */
  public java.util.List<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails>
      getDischargingPlanTankDetailsList() {
    return dischargingPlanTankDetails_;
  }
  /** <code>repeated .LoadingPlanTankDetails dischargingPlanTankDetails = 2;</code> */
  public java.util.List<
          ? extends
              com.cpdss.common.generated.loading_plan.LoadingPlanModels
                  .LoadingPlanTankDetailsOrBuilder>
      getDischargingPlanTankDetailsOrBuilderList() {
    return dischargingPlanTankDetails_;
  }
  /** <code>repeated .LoadingPlanTankDetails dischargingPlanTankDetails = 2;</code> */
  public int getDischargingPlanTankDetailsCount() {
    return dischargingPlanTankDetails_.size();
  }
  /** <code>repeated .LoadingPlanTankDetails dischargingPlanTankDetails = 2;</code> */
  public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
      getDischargingPlanTankDetails(int index) {
    return dischargingPlanTankDetails_.get(index);
  }
  /** <code>repeated .LoadingPlanTankDetails dischargingPlanTankDetails = 2;</code> */
  public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetailsOrBuilder
      getDischargingPlanTankDetailsOrBuilder(int index) {
    return dischargingPlanTankDetails_.get(index);
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
    if (responseStatus_ != null) {
      output.writeMessage(1, getResponseStatus());
    }
    for (int i = 0; i < dischargingPlanTankDetails_.size(); i++) {
      output.writeMessage(2, dischargingPlanTankDetails_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (responseStatus_ != null) {
      size += com.google.protobuf.CodedOutputStream.computeMessageSize(1, getResponseStatus());
    }
    for (int i = 0; i < dischargingPlanTankDetails_.size(); i++) {
      size +=
          com.google.protobuf.CodedOutputStream.computeMessageSize(
              2, dischargingPlanTankDetails_.get(i));
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
        instanceof com.cpdss.common.generated.discharge_plan.DischargePlanStowageDetailsResponse)) {
      return super.equals(obj);
    }
    com.cpdss.common.generated.discharge_plan.DischargePlanStowageDetailsResponse other =
        (com.cpdss.common.generated.discharge_plan.DischargePlanStowageDetailsResponse) obj;

    if (hasResponseStatus() != other.hasResponseStatus()) return false;
    if (hasResponseStatus()) {
      if (!getResponseStatus().equals(other.getResponseStatus())) return false;
    }
    if (!getDischargingPlanTankDetailsList().equals(other.getDischargingPlanTankDetailsList()))
      return false;
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
    if (hasResponseStatus()) {
      hash = (37 * hash) + RESPONSESTATUS_FIELD_NUMBER;
      hash = (53 * hash) + getResponseStatus().hashCode();
    }
    if (getDischargingPlanTankDetailsCount() > 0) {
      hash = (37 * hash) + DISCHARGINGPLANTANKDETAILS_FIELD_NUMBER;
      hash = (53 * hash) + getDischargingPlanTankDetailsList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.cpdss.common.generated.discharge_plan.DischargePlanStowageDetailsResponse
      parseFrom(java.nio.ByteBuffer data)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargePlanStowageDetailsResponse
      parseFrom(
          java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargePlanStowageDetailsResponse
      parseFrom(com.google.protobuf.ByteString data)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargePlanStowageDetailsResponse
      parseFrom(
          com.google.protobuf.ByteString data,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargePlanStowageDetailsResponse
      parseFrom(byte[] data) throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargePlanStowageDetailsResponse
      parseFrom(byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargePlanStowageDetailsResponse
      parseFrom(java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargePlanStowageDetailsResponse
      parseFrom(
          java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargePlanStowageDetailsResponse
      parseDelimitedFrom(java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargePlanStowageDetailsResponse
      parseDelimitedFrom(
          java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargePlanStowageDetailsResponse
      parseFrom(com.google.protobuf.CodedInputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargePlanStowageDetailsResponse
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
      com.cpdss.common.generated.discharge_plan.DischargePlanStowageDetailsResponse prototype) {
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
  /** Protobuf type {@code DischargePlanStowageDetailsResponse} */
  public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
      implements
      // @@protoc_insertion_point(builder_implements:DischargePlanStowageDetailsResponse)
      com.cpdss.common.generated.discharge_plan.DischargePlanStowageDetailsResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanModels
          .internal_static_DischargePlanStowageDetailsResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanModels
          .internal_static_DischargePlanStowageDetailsResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.discharge_plan.DischargePlanStowageDetailsResponse.class,
              com.cpdss.common.generated.discharge_plan.DischargePlanStowageDetailsResponse.Builder
                  .class);
    }

    // Construct using
    // com.cpdss.common.generated.discharge_plan.DischargePlanStowageDetailsResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {
        getDischargingPlanTankDetailsFieldBuilder();
      }
    }

    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (responseStatusBuilder_ == null) {
        responseStatus_ = null;
      } else {
        responseStatus_ = null;
        responseStatusBuilder_ = null;
      }
      if (dischargingPlanTankDetailsBuilder_ == null) {
        dischargingPlanTankDetails_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        dischargingPlanTankDetailsBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanModels
          .internal_static_DischargePlanStowageDetailsResponse_descriptor;
    }

    @java.lang.Override
    public com.cpdss.common.generated.discharge_plan.DischargePlanStowageDetailsResponse
        getDefaultInstanceForType() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanStowageDetailsResponse
          .getDefaultInstance();
    }

    @java.lang.Override
    public com.cpdss.common.generated.discharge_plan.DischargePlanStowageDetailsResponse build() {
      com.cpdss.common.generated.discharge_plan.DischargePlanStowageDetailsResponse result =
          buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.cpdss.common.generated.discharge_plan.DischargePlanStowageDetailsResponse
        buildPartial() {
      com.cpdss.common.generated.discharge_plan.DischargePlanStowageDetailsResponse result =
          new com.cpdss.common.generated.discharge_plan.DischargePlanStowageDetailsResponse(this);
      int from_bitField0_ = bitField0_;
      if (responseStatusBuilder_ == null) {
        result.responseStatus_ = responseStatus_;
      } else {
        result.responseStatus_ = responseStatusBuilder_.build();
      }
      if (dischargingPlanTankDetailsBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          dischargingPlanTankDetails_ =
              java.util.Collections.unmodifiableList(dischargingPlanTankDetails_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.dischargingPlanTankDetails_ = dischargingPlanTankDetails_;
      } else {
        result.dischargingPlanTankDetails_ = dischargingPlanTankDetailsBuilder_.build();
      }
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
          com.cpdss.common.generated.discharge_plan.DischargePlanStowageDetailsResponse) {
        return mergeFrom(
            (com.cpdss.common.generated.discharge_plan.DischargePlanStowageDetailsResponse) other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(
        com.cpdss.common.generated.discharge_plan.DischargePlanStowageDetailsResponse other) {
      if (other
          == com.cpdss.common.generated.discharge_plan.DischargePlanStowageDetailsResponse
              .getDefaultInstance()) return this;
      if (other.hasResponseStatus()) {
        mergeResponseStatus(other.getResponseStatus());
      }
      if (dischargingPlanTankDetailsBuilder_ == null) {
        if (!other.dischargingPlanTankDetails_.isEmpty()) {
          if (dischargingPlanTankDetails_.isEmpty()) {
            dischargingPlanTankDetails_ = other.dischargingPlanTankDetails_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureDischargingPlanTankDetailsIsMutable();
            dischargingPlanTankDetails_.addAll(other.dischargingPlanTankDetails_);
          }
          onChanged();
        }
      } else {
        if (!other.dischargingPlanTankDetails_.isEmpty()) {
          if (dischargingPlanTankDetailsBuilder_.isEmpty()) {
            dischargingPlanTankDetailsBuilder_.dispose();
            dischargingPlanTankDetailsBuilder_ = null;
            dischargingPlanTankDetails_ = other.dischargingPlanTankDetails_;
            bitField0_ = (bitField0_ & ~0x00000001);
            dischargingPlanTankDetailsBuilder_ =
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
                    ? getDischargingPlanTankDetailsFieldBuilder()
                    : null;
          } else {
            dischargingPlanTankDetailsBuilder_.addAllMessages(other.dischargingPlanTankDetails_);
          }
        }
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
      com.cpdss.common.generated.discharge_plan.DischargePlanStowageDetailsResponse parsedMessage =
          null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage =
            (com.cpdss.common.generated.discharge_plan.DischargePlanStowageDetailsResponse)
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

    private com.cpdss.common.generated.Common.ResponseStatus responseStatus_;
    private com.google.protobuf.SingleFieldBuilderV3<
            com.cpdss.common.generated.Common.ResponseStatus,
            com.cpdss.common.generated.Common.ResponseStatus.Builder,
            com.cpdss.common.generated.Common.ResponseStatusOrBuilder>
        responseStatusBuilder_;
    /**
     * <code>.ResponseStatus responseStatus = 1;</code>
     *
     * @return Whether the responseStatus field is set.
     */
    public boolean hasResponseStatus() {
      return responseStatusBuilder_ != null || responseStatus_ != null;
    }
    /**
     * <code>.ResponseStatus responseStatus = 1;</code>
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
    /** <code>.ResponseStatus responseStatus = 1;</code> */
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
    /** <code>.ResponseStatus responseStatus = 1;</code> */
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
    /** <code>.ResponseStatus responseStatus = 1;</code> */
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
    /** <code>.ResponseStatus responseStatus = 1;</code> */
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
    /** <code>.ResponseStatus responseStatus = 1;</code> */
    public com.cpdss.common.generated.Common.ResponseStatus.Builder getResponseStatusBuilder() {

      onChanged();
      return getResponseStatusFieldBuilder().getBuilder();
    }
    /** <code>.ResponseStatus responseStatus = 1;</code> */
    public com.cpdss.common.generated.Common.ResponseStatusOrBuilder getResponseStatusOrBuilder() {
      if (responseStatusBuilder_ != null) {
        return responseStatusBuilder_.getMessageOrBuilder();
      } else {
        return responseStatus_ == null
            ? com.cpdss.common.generated.Common.ResponseStatus.getDefaultInstance()
            : responseStatus_;
      }
    }
    /** <code>.ResponseStatus responseStatus = 1;</code> */
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

    private java.util.List<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails>
        dischargingPlanTankDetails_ = java.util.Collections.emptyList();

    private void ensureDischargingPlanTankDetailsIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        dischargingPlanTankDetails_ =
            new java.util.ArrayList<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails>(
                dischargingPlanTankDetails_);
        bitField0_ |= 0x00000001;
      }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
                .Builder,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels
                .LoadingPlanTankDetailsOrBuilder>
        dischargingPlanTankDetailsBuilder_;

    /** <code>repeated .LoadingPlanTankDetails dischargingPlanTankDetails = 2;</code> */
    public java.util.List<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails>
        getDischargingPlanTankDetailsList() {
      if (dischargingPlanTankDetailsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(dischargingPlanTankDetails_);
      } else {
        return dischargingPlanTankDetailsBuilder_.getMessageList();
      }
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanTankDetails = 2;</code> */
    public int getDischargingPlanTankDetailsCount() {
      if (dischargingPlanTankDetailsBuilder_ == null) {
        return dischargingPlanTankDetails_.size();
      } else {
        return dischargingPlanTankDetailsBuilder_.getCount();
      }
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanTankDetails = 2;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
        getDischargingPlanTankDetails(int index) {
      if (dischargingPlanTankDetailsBuilder_ == null) {
        return dischargingPlanTankDetails_.get(index);
      } else {
        return dischargingPlanTankDetailsBuilder_.getMessage(index);
      }
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanTankDetails = 2;</code> */
    public Builder setDischargingPlanTankDetails(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails value) {
      if (dischargingPlanTankDetailsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDischargingPlanTankDetailsIsMutable();
        dischargingPlanTankDetails_.set(index, value);
        onChanged();
      } else {
        dischargingPlanTankDetailsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanTankDetails = 2;</code> */
    public Builder setDischargingPlanTankDetails(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails.Builder
            builderForValue) {
      if (dischargingPlanTankDetailsBuilder_ == null) {
        ensureDischargingPlanTankDetailsIsMutable();
        dischargingPlanTankDetails_.set(index, builderForValue.build());
        onChanged();
      } else {
        dischargingPlanTankDetailsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanTankDetails = 2;</code> */
    public Builder addDischargingPlanTankDetails(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails value) {
      if (dischargingPlanTankDetailsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDischargingPlanTankDetailsIsMutable();
        dischargingPlanTankDetails_.add(value);
        onChanged();
      } else {
        dischargingPlanTankDetailsBuilder_.addMessage(value);
      }
      return this;
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanTankDetails = 2;</code> */
    public Builder addDischargingPlanTankDetails(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails value) {
      if (dischargingPlanTankDetailsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDischargingPlanTankDetailsIsMutable();
        dischargingPlanTankDetails_.add(index, value);
        onChanged();
      } else {
        dischargingPlanTankDetailsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanTankDetails = 2;</code> */
    public Builder addDischargingPlanTankDetails(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails.Builder
            builderForValue) {
      if (dischargingPlanTankDetailsBuilder_ == null) {
        ensureDischargingPlanTankDetailsIsMutable();
        dischargingPlanTankDetails_.add(builderForValue.build());
        onChanged();
      } else {
        dischargingPlanTankDetailsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanTankDetails = 2;</code> */
    public Builder addDischargingPlanTankDetails(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails.Builder
            builderForValue) {
      if (dischargingPlanTankDetailsBuilder_ == null) {
        ensureDischargingPlanTankDetailsIsMutable();
        dischargingPlanTankDetails_.add(index, builderForValue.build());
        onChanged();
      } else {
        dischargingPlanTankDetailsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanTankDetails = 2;</code> */
    public Builder addAllDischargingPlanTankDetails(
        java.lang.Iterable<
                ? extends
                    com.cpdss.common.generated.loading_plan.LoadingPlanModels
                        .LoadingPlanTankDetails>
            values) {
      if (dischargingPlanTankDetailsBuilder_ == null) {
        ensureDischargingPlanTankDetailsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(values, dischargingPlanTankDetails_);
        onChanged();
      } else {
        dischargingPlanTankDetailsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanTankDetails = 2;</code> */
    public Builder clearDischargingPlanTankDetails() {
      if (dischargingPlanTankDetailsBuilder_ == null) {
        dischargingPlanTankDetails_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        dischargingPlanTankDetailsBuilder_.clear();
      }
      return this;
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanTankDetails = 2;</code> */
    public Builder removeDischargingPlanTankDetails(int index) {
      if (dischargingPlanTankDetailsBuilder_ == null) {
        ensureDischargingPlanTankDetailsIsMutable();
        dischargingPlanTankDetails_.remove(index);
        onChanged();
      } else {
        dischargingPlanTankDetailsBuilder_.remove(index);
      }
      return this;
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanTankDetails = 2;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails.Builder
        getDischargingPlanTankDetailsBuilder(int index) {
      return getDischargingPlanTankDetailsFieldBuilder().getBuilder(index);
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanTankDetails = 2;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetailsOrBuilder
        getDischargingPlanTankDetailsOrBuilder(int index) {
      if (dischargingPlanTankDetailsBuilder_ == null) {
        return dischargingPlanTankDetails_.get(index);
      } else {
        return dischargingPlanTankDetailsBuilder_.getMessageOrBuilder(index);
      }
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanTankDetails = 2;</code> */
    public java.util.List<
            ? extends
                com.cpdss.common.generated.loading_plan.LoadingPlanModels
                    .LoadingPlanTankDetailsOrBuilder>
        getDischargingPlanTankDetailsOrBuilderList() {
      if (dischargingPlanTankDetailsBuilder_ != null) {
        return dischargingPlanTankDetailsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(dischargingPlanTankDetails_);
      }
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanTankDetails = 2;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails.Builder
        addDischargingPlanTankDetailsBuilder() {
      return getDischargingPlanTankDetailsFieldBuilder()
          .addBuilder(
              com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
                  .getDefaultInstance());
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanTankDetails = 2;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails.Builder
        addDischargingPlanTankDetailsBuilder(int index) {
      return getDischargingPlanTankDetailsFieldBuilder()
          .addBuilder(
              index,
              com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
                  .getDefaultInstance());
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanTankDetails = 2;</code> */
    public java.util.List<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
                .Builder>
        getDischargingPlanTankDetailsBuilderList() {
      return getDischargingPlanTankDetailsFieldBuilder().getBuilderList();
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
                .Builder,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels
                .LoadingPlanTankDetailsOrBuilder>
        getDischargingPlanTankDetailsFieldBuilder() {
      if (dischargingPlanTankDetailsBuilder_ == null) {
        dischargingPlanTankDetailsBuilder_ =
            new com.google.protobuf.RepeatedFieldBuilderV3<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails,
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
                    .Builder,
                com.cpdss.common.generated.loading_plan.LoadingPlanModels
                    .LoadingPlanTankDetailsOrBuilder>(
                dischargingPlanTankDetails_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        dischargingPlanTankDetails_ = null;
      }
      return dischargingPlanTankDetailsBuilder_;
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

    // @@protoc_insertion_point(builder_scope:DischargePlanStowageDetailsResponse)
  }

  // @@protoc_insertion_point(class_scope:DischargePlanStowageDetailsResponse)
  private static final com.cpdss.common.generated.discharge_plan.DischargePlanStowageDetailsResponse
      DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE =
        new com.cpdss.common.generated.discharge_plan.DischargePlanStowageDetailsResponse();
  }

  public static com.cpdss.common.generated.discharge_plan.DischargePlanStowageDetailsResponse
      getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<DischargePlanStowageDetailsResponse> PARSER =
      new com.google.protobuf.AbstractParser<DischargePlanStowageDetailsResponse>() {
        @java.lang.Override
        public DischargePlanStowageDetailsResponse parsePartialFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
          return new DischargePlanStowageDetailsResponse(input, extensionRegistry);
        }
      };

  public static com.google.protobuf.Parser<DischargePlanStowageDetailsResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<DischargePlanStowageDetailsResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.cpdss.common.generated.discharge_plan.DischargePlanStowageDetailsResponse
      getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
}
