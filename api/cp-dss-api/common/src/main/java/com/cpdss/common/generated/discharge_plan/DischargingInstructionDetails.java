/* Licensed at AlphaOri Technologies */
package com.cpdss.common.generated.discharge_plan;

/** Protobuf type {@code DischargingInstructionDetails} */
public final class DischargingInstructionDetails extends com.google.protobuf.GeneratedMessageV3
    implements
    // @@protoc_insertion_point(message_implements:DischargingInstructionDetails)
    DischargingInstructionDetailsOrBuilder {
  private static final long serialVersionUID = 0L;
  // Use DischargingInstructionDetails.newBuilder() to construct.
  private DischargingInstructionDetails(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }

  private DischargingInstructionDetails() {
    dischargingInstructionSubHeader_ = java.util.Collections.emptyList();
    dischargingInstructionGroupList_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
    return new DischargingInstructionDetails();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }

  private DischargingInstructionDetails(
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
              if (!((mutable_bitField0_ & 0x00000001) != 0)) {
                dischargingInstructionSubHeader_ =
                    new java.util.ArrayList<
                        com.cpdss.common.generated.discharge_plan
                            .DischargingInstructionSubHeader>();
                mutable_bitField0_ |= 0x00000001;
              }
              dischargingInstructionSubHeader_.add(
                  input.readMessage(
                      com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader
                          .parser(),
                      extensionRegistry));
              break;
            }
          case 18:
            {
              if (!((mutable_bitField0_ & 0x00000002) != 0)) {
                dischargingInstructionGroupList_ =
                    new java.util.ArrayList<
                        com.cpdss.common.generated.discharge_plan.DischargingInstructionGroup>();
                mutable_bitField0_ |= 0x00000002;
              }
              dischargingInstructionGroupList_.add(
                  input.readMessage(
                      com.cpdss.common.generated.discharge_plan.DischargingInstructionGroup
                          .parser(),
                      extensionRegistry));
              break;
            }
          case 26:
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
        dischargingInstructionSubHeader_ =
            java.util.Collections.unmodifiableList(dischargingInstructionSubHeader_);
      }
      if (((mutable_bitField0_ & 0x00000002) != 0)) {
        dischargingInstructionGroupList_ =
            java.util.Collections.unmodifiableList(dischargingInstructionGroupList_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }

  public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
    return com.cpdss.common.generated.discharge_plan.DischargePlanModels
        .internal_static_DischargingInstructionDetails_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.cpdss.common.generated.discharge_plan.DischargePlanModels
        .internal_static_DischargingInstructionDetails_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.cpdss.common.generated.discharge_plan.DischargingInstructionDetails.class,
            com.cpdss.common.generated.discharge_plan.DischargingInstructionDetails.Builder.class);
  }

  public static final int DISCHARGINGINSTRUCTIONSUBHEADER_FIELD_NUMBER = 1;
  private java.util.List<com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader>
      dischargingInstructionSubHeader_;
  /** <code>repeated .DischargingInstructionSubHeader dischargingInstructionSubHeader = 1;</code> */
  public java.util.List<com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader>
      getDischargingInstructionSubHeaderList() {
    return dischargingInstructionSubHeader_;
  }
  /** <code>repeated .DischargingInstructionSubHeader dischargingInstructionSubHeader = 1;</code> */
  public java.util.List<
          ? extends
              com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeaderOrBuilder>
      getDischargingInstructionSubHeaderOrBuilderList() {
    return dischargingInstructionSubHeader_;
  }
  /** <code>repeated .DischargingInstructionSubHeader dischargingInstructionSubHeader = 1;</code> */
  public int getDischargingInstructionSubHeaderCount() {
    return dischargingInstructionSubHeader_.size();
  }
  /** <code>repeated .DischargingInstructionSubHeader dischargingInstructionSubHeader = 1;</code> */
  public com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader
      getDischargingInstructionSubHeader(int index) {
    return dischargingInstructionSubHeader_.get(index);
  }
  /** <code>repeated .DischargingInstructionSubHeader dischargingInstructionSubHeader = 1;</code> */
  public com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeaderOrBuilder
      getDischargingInstructionSubHeaderOrBuilder(int index) {
    return dischargingInstructionSubHeader_.get(index);
  }

  public static final int DISCHARGINGINSTRUCTIONGROUPLIST_FIELD_NUMBER = 2;
  private java.util.List<com.cpdss.common.generated.discharge_plan.DischargingInstructionGroup>
      dischargingInstructionGroupList_;
  /** <code>repeated .DischargingInstructionGroup dischargingInstructionGroupList = 2;</code> */
  public java.util.List<com.cpdss.common.generated.discharge_plan.DischargingInstructionGroup>
      getDischargingInstructionGroupListList() {
    return dischargingInstructionGroupList_;
  }
  /** <code>repeated .DischargingInstructionGroup dischargingInstructionGroupList = 2;</code> */
  public java.util.List<
          ? extends com.cpdss.common.generated.discharge_plan.DischargingInstructionGroupOrBuilder>
      getDischargingInstructionGroupListOrBuilderList() {
    return dischargingInstructionGroupList_;
  }
  /** <code>repeated .DischargingInstructionGroup dischargingInstructionGroupList = 2;</code> */
  public int getDischargingInstructionGroupListCount() {
    return dischargingInstructionGroupList_.size();
  }
  /** <code>repeated .DischargingInstructionGroup dischargingInstructionGroupList = 2;</code> */
  public com.cpdss.common.generated.discharge_plan.DischargingInstructionGroup
      getDischargingInstructionGroupList(int index) {
    return dischargingInstructionGroupList_.get(index);
  }
  /** <code>repeated .DischargingInstructionGroup dischargingInstructionGroupList = 2;</code> */
  public com.cpdss.common.generated.discharge_plan.DischargingInstructionGroupOrBuilder
      getDischargingInstructionGroupListOrBuilder(int index) {
    return dischargingInstructionGroupList_.get(index);
  }

  public static final int RESPONSESTATUS_FIELD_NUMBER = 3;
  private com.cpdss.common.generated.Common.ResponseStatus responseStatus_;
  /**
   * <code>.ResponseStatus responseStatus = 3;</code>
   *
   * @return Whether the responseStatus field is set.
   */
  public boolean hasResponseStatus() {
    return responseStatus_ != null;
  }
  /**
   * <code>.ResponseStatus responseStatus = 3;</code>
   *
   * @return The responseStatus.
   */
  public com.cpdss.common.generated.Common.ResponseStatus getResponseStatus() {
    return responseStatus_ == null
        ? com.cpdss.common.generated.Common.ResponseStatus.getDefaultInstance()
        : responseStatus_;
  }
  /** <code>.ResponseStatus responseStatus = 3;</code> */
  public com.cpdss.common.generated.Common.ResponseStatusOrBuilder getResponseStatusOrBuilder() {
    return getResponseStatus();
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
    for (int i = 0; i < dischargingInstructionSubHeader_.size(); i++) {
      output.writeMessage(1, dischargingInstructionSubHeader_.get(i));
    }
    for (int i = 0; i < dischargingInstructionGroupList_.size(); i++) {
      output.writeMessage(2, dischargingInstructionGroupList_.get(i));
    }
    if (responseStatus_ != null) {
      output.writeMessage(3, getResponseStatus());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < dischargingInstructionSubHeader_.size(); i++) {
      size +=
          com.google.protobuf.CodedOutputStream.computeMessageSize(
              1, dischargingInstructionSubHeader_.get(i));
    }
    for (int i = 0; i < dischargingInstructionGroupList_.size(); i++) {
      size +=
          com.google.protobuf.CodedOutputStream.computeMessageSize(
              2, dischargingInstructionGroupList_.get(i));
    }
    if (responseStatus_ != null) {
      size += com.google.protobuf.CodedOutputStream.computeMessageSize(3, getResponseStatus());
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
    if (!(obj instanceof com.cpdss.common.generated.discharge_plan.DischargingInstructionDetails)) {
      return super.equals(obj);
    }
    com.cpdss.common.generated.discharge_plan.DischargingInstructionDetails other =
        (com.cpdss.common.generated.discharge_plan.DischargingInstructionDetails) obj;

    if (!getDischargingInstructionSubHeaderList()
        .equals(other.getDischargingInstructionSubHeaderList())) return false;
    if (!getDischargingInstructionGroupListList()
        .equals(other.getDischargingInstructionGroupListList())) return false;
    if (hasResponseStatus() != other.hasResponseStatus()) return false;
    if (hasResponseStatus()) {
      if (!getResponseStatus().equals(other.getResponseStatus())) return false;
    }
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
    if (getDischargingInstructionSubHeaderCount() > 0) {
      hash = (37 * hash) + DISCHARGINGINSTRUCTIONSUBHEADER_FIELD_NUMBER;
      hash = (53 * hash) + getDischargingInstructionSubHeaderList().hashCode();
    }
    if (getDischargingInstructionGroupListCount() > 0) {
      hash = (37 * hash) + DISCHARGINGINSTRUCTIONGROUPLIST_FIELD_NUMBER;
      hash = (53 * hash) + getDischargingInstructionGroupListList().hashCode();
    }
    if (hasResponseStatus()) {
      hash = (37 * hash) + RESPONSESTATUS_FIELD_NUMBER;
      hash = (53 * hash) + getResponseStatus().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionDetails parseFrom(
      java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionDetails parseFrom(
      java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionDetails parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionDetails parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionDetails parseFrom(
      byte[] data) throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionDetails parseFrom(
      byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionDetails parseFrom(
      java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionDetails parseFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionDetails
      parseDelimitedFrom(java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionDetails
      parseDelimitedFrom(
          java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionDetails parseFrom(
      com.google.protobuf.CodedInputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionDetails parseFrom(
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
      com.cpdss.common.generated.discharge_plan.DischargingInstructionDetails prototype) {
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
  /** Protobuf type {@code DischargingInstructionDetails} */
  public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
      implements
      // @@protoc_insertion_point(builder_implements:DischargingInstructionDetails)
      com.cpdss.common.generated.discharge_plan.DischargingInstructionDetailsOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanModels
          .internal_static_DischargingInstructionDetails_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanModels
          .internal_static_DischargingInstructionDetails_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.discharge_plan.DischargingInstructionDetails.class,
              com.cpdss.common.generated.discharge_plan.DischargingInstructionDetails.Builder
                  .class);
    }

    // Construct using
    // com.cpdss.common.generated.discharge_plan.DischargingInstructionDetails.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {
        getDischargingInstructionSubHeaderFieldBuilder();
        getDischargingInstructionGroupListFieldBuilder();
      }
    }

    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (dischargingInstructionSubHeaderBuilder_ == null) {
        dischargingInstructionSubHeader_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        dischargingInstructionSubHeaderBuilder_.clear();
      }
      if (dischargingInstructionGroupListBuilder_ == null) {
        dischargingInstructionGroupList_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000002);
      } else {
        dischargingInstructionGroupListBuilder_.clear();
      }
      if (responseStatusBuilder_ == null) {
        responseStatus_ = null;
      } else {
        responseStatus_ = null;
        responseStatusBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanModels
          .internal_static_DischargingInstructionDetails_descriptor;
    }

    @java.lang.Override
    public com.cpdss.common.generated.discharge_plan.DischargingInstructionDetails
        getDefaultInstanceForType() {
      return com.cpdss.common.generated.discharge_plan.DischargingInstructionDetails
          .getDefaultInstance();
    }

    @java.lang.Override
    public com.cpdss.common.generated.discharge_plan.DischargingInstructionDetails build() {
      com.cpdss.common.generated.discharge_plan.DischargingInstructionDetails result =
          buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.cpdss.common.generated.discharge_plan.DischargingInstructionDetails buildPartial() {
      com.cpdss.common.generated.discharge_plan.DischargingInstructionDetails result =
          new com.cpdss.common.generated.discharge_plan.DischargingInstructionDetails(this);
      int from_bitField0_ = bitField0_;
      if (dischargingInstructionSubHeaderBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          dischargingInstructionSubHeader_ =
              java.util.Collections.unmodifiableList(dischargingInstructionSubHeader_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.dischargingInstructionSubHeader_ = dischargingInstructionSubHeader_;
      } else {
        result.dischargingInstructionSubHeader_ = dischargingInstructionSubHeaderBuilder_.build();
      }
      if (dischargingInstructionGroupListBuilder_ == null) {
        if (((bitField0_ & 0x00000002) != 0)) {
          dischargingInstructionGroupList_ =
              java.util.Collections.unmodifiableList(dischargingInstructionGroupList_);
          bitField0_ = (bitField0_ & ~0x00000002);
        }
        result.dischargingInstructionGroupList_ = dischargingInstructionGroupList_;
      } else {
        result.dischargingInstructionGroupList_ = dischargingInstructionGroupListBuilder_.build();
      }
      if (responseStatusBuilder_ == null) {
        result.responseStatus_ = responseStatus_;
      } else {
        result.responseStatus_ = responseStatusBuilder_.build();
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
          instanceof com.cpdss.common.generated.discharge_plan.DischargingInstructionDetails) {
        return mergeFrom(
            (com.cpdss.common.generated.discharge_plan.DischargingInstructionDetails) other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(
        com.cpdss.common.generated.discharge_plan.DischargingInstructionDetails other) {
      if (other
          == com.cpdss.common.generated.discharge_plan.DischargingInstructionDetails
              .getDefaultInstance()) return this;
      if (dischargingInstructionSubHeaderBuilder_ == null) {
        if (!other.dischargingInstructionSubHeader_.isEmpty()) {
          if (dischargingInstructionSubHeader_.isEmpty()) {
            dischargingInstructionSubHeader_ = other.dischargingInstructionSubHeader_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureDischargingInstructionSubHeaderIsMutable();
            dischargingInstructionSubHeader_.addAll(other.dischargingInstructionSubHeader_);
          }
          onChanged();
        }
      } else {
        if (!other.dischargingInstructionSubHeader_.isEmpty()) {
          if (dischargingInstructionSubHeaderBuilder_.isEmpty()) {
            dischargingInstructionSubHeaderBuilder_.dispose();
            dischargingInstructionSubHeaderBuilder_ = null;
            dischargingInstructionSubHeader_ = other.dischargingInstructionSubHeader_;
            bitField0_ = (bitField0_ & ~0x00000001);
            dischargingInstructionSubHeaderBuilder_ =
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
                    ? getDischargingInstructionSubHeaderFieldBuilder()
                    : null;
          } else {
            dischargingInstructionSubHeaderBuilder_.addAllMessages(
                other.dischargingInstructionSubHeader_);
          }
        }
      }
      if (dischargingInstructionGroupListBuilder_ == null) {
        if (!other.dischargingInstructionGroupList_.isEmpty()) {
          if (dischargingInstructionGroupList_.isEmpty()) {
            dischargingInstructionGroupList_ = other.dischargingInstructionGroupList_;
            bitField0_ = (bitField0_ & ~0x00000002);
          } else {
            ensureDischargingInstructionGroupListIsMutable();
            dischargingInstructionGroupList_.addAll(other.dischargingInstructionGroupList_);
          }
          onChanged();
        }
      } else {
        if (!other.dischargingInstructionGroupList_.isEmpty()) {
          if (dischargingInstructionGroupListBuilder_.isEmpty()) {
            dischargingInstructionGroupListBuilder_.dispose();
            dischargingInstructionGroupListBuilder_ = null;
            dischargingInstructionGroupList_ = other.dischargingInstructionGroupList_;
            bitField0_ = (bitField0_ & ~0x00000002);
            dischargingInstructionGroupListBuilder_ =
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
                    ? getDischargingInstructionGroupListFieldBuilder()
                    : null;
          } else {
            dischargingInstructionGroupListBuilder_.addAllMessages(
                other.dischargingInstructionGroupList_);
          }
        }
      }
      if (other.hasResponseStatus()) {
        mergeResponseStatus(other.getResponseStatus());
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
      com.cpdss.common.generated.discharge_plan.DischargingInstructionDetails parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage =
            (com.cpdss.common.generated.discharge_plan.DischargingInstructionDetails)
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

    private java.util.List<
            com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader>
        dischargingInstructionSubHeader_ = java.util.Collections.emptyList();

    private void ensureDischargingInstructionSubHeaderIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        dischargingInstructionSubHeader_ =
            new java.util.ArrayList<
                com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader>(
                dischargingInstructionSubHeader_);
        bitField0_ |= 0x00000001;
      }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader,
            com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader.Builder,
            com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeaderOrBuilder>
        dischargingInstructionSubHeaderBuilder_;

    /**
     * <code>repeated .DischargingInstructionSubHeader dischargingInstructionSubHeader = 1;</code>
     */
    public java.util.List<com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader>
        getDischargingInstructionSubHeaderList() {
      if (dischargingInstructionSubHeaderBuilder_ == null) {
        return java.util.Collections.unmodifiableList(dischargingInstructionSubHeader_);
      } else {
        return dischargingInstructionSubHeaderBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .DischargingInstructionSubHeader dischargingInstructionSubHeader = 1;</code>
     */
    public int getDischargingInstructionSubHeaderCount() {
      if (dischargingInstructionSubHeaderBuilder_ == null) {
        return dischargingInstructionSubHeader_.size();
      } else {
        return dischargingInstructionSubHeaderBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .DischargingInstructionSubHeader dischargingInstructionSubHeader = 1;</code>
     */
    public com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader
        getDischargingInstructionSubHeader(int index) {
      if (dischargingInstructionSubHeaderBuilder_ == null) {
        return dischargingInstructionSubHeader_.get(index);
      } else {
        return dischargingInstructionSubHeaderBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .DischargingInstructionSubHeader dischargingInstructionSubHeader = 1;</code>
     */
    public Builder setDischargingInstructionSubHeader(
        int index,
        com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader value) {
      if (dischargingInstructionSubHeaderBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDischargingInstructionSubHeaderIsMutable();
        dischargingInstructionSubHeader_.set(index, value);
        onChanged();
      } else {
        dischargingInstructionSubHeaderBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .DischargingInstructionSubHeader dischargingInstructionSubHeader = 1;</code>
     */
    public Builder setDischargingInstructionSubHeader(
        int index,
        com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader.Builder
            builderForValue) {
      if (dischargingInstructionSubHeaderBuilder_ == null) {
        ensureDischargingInstructionSubHeaderIsMutable();
        dischargingInstructionSubHeader_.set(index, builderForValue.build());
        onChanged();
      } else {
        dischargingInstructionSubHeaderBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .DischargingInstructionSubHeader dischargingInstructionSubHeader = 1;</code>
     */
    public Builder addDischargingInstructionSubHeader(
        com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader value) {
      if (dischargingInstructionSubHeaderBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDischargingInstructionSubHeaderIsMutable();
        dischargingInstructionSubHeader_.add(value);
        onChanged();
      } else {
        dischargingInstructionSubHeaderBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .DischargingInstructionSubHeader dischargingInstructionSubHeader = 1;</code>
     */
    public Builder addDischargingInstructionSubHeader(
        int index,
        com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader value) {
      if (dischargingInstructionSubHeaderBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDischargingInstructionSubHeaderIsMutable();
        dischargingInstructionSubHeader_.add(index, value);
        onChanged();
      } else {
        dischargingInstructionSubHeaderBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .DischargingInstructionSubHeader dischargingInstructionSubHeader = 1;</code>
     */
    public Builder addDischargingInstructionSubHeader(
        com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader.Builder
            builderForValue) {
      if (dischargingInstructionSubHeaderBuilder_ == null) {
        ensureDischargingInstructionSubHeaderIsMutable();
        dischargingInstructionSubHeader_.add(builderForValue.build());
        onChanged();
      } else {
        dischargingInstructionSubHeaderBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .DischargingInstructionSubHeader dischargingInstructionSubHeader = 1;</code>
     */
    public Builder addDischargingInstructionSubHeader(
        int index,
        com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader.Builder
            builderForValue) {
      if (dischargingInstructionSubHeaderBuilder_ == null) {
        ensureDischargingInstructionSubHeaderIsMutable();
        dischargingInstructionSubHeader_.add(index, builderForValue.build());
        onChanged();
      } else {
        dischargingInstructionSubHeaderBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .DischargingInstructionSubHeader dischargingInstructionSubHeader = 1;</code>
     */
    public Builder addAllDischargingInstructionSubHeader(
        java.lang.Iterable<
                ? extends com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader>
            values) {
      if (dischargingInstructionSubHeaderBuilder_ == null) {
        ensureDischargingInstructionSubHeaderIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, dischargingInstructionSubHeader_);
        onChanged();
      } else {
        dischargingInstructionSubHeaderBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .DischargingInstructionSubHeader dischargingInstructionSubHeader = 1;</code>
     */
    public Builder clearDischargingInstructionSubHeader() {
      if (dischargingInstructionSubHeaderBuilder_ == null) {
        dischargingInstructionSubHeader_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        dischargingInstructionSubHeaderBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .DischargingInstructionSubHeader dischargingInstructionSubHeader = 1;</code>
     */
    public Builder removeDischargingInstructionSubHeader(int index) {
      if (dischargingInstructionSubHeaderBuilder_ == null) {
        ensureDischargingInstructionSubHeaderIsMutable();
        dischargingInstructionSubHeader_.remove(index);
        onChanged();
      } else {
        dischargingInstructionSubHeaderBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .DischargingInstructionSubHeader dischargingInstructionSubHeader = 1;</code>
     */
    public com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader.Builder
        getDischargingInstructionSubHeaderBuilder(int index) {
      return getDischargingInstructionSubHeaderFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .DischargingInstructionSubHeader dischargingInstructionSubHeader = 1;</code>
     */
    public com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeaderOrBuilder
        getDischargingInstructionSubHeaderOrBuilder(int index) {
      if (dischargingInstructionSubHeaderBuilder_ == null) {
        return dischargingInstructionSubHeader_.get(index);
      } else {
        return dischargingInstructionSubHeaderBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .DischargingInstructionSubHeader dischargingInstructionSubHeader = 1;</code>
     */
    public java.util.List<
            ? extends
                com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeaderOrBuilder>
        getDischargingInstructionSubHeaderOrBuilderList() {
      if (dischargingInstructionSubHeaderBuilder_ != null) {
        return dischargingInstructionSubHeaderBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(dischargingInstructionSubHeader_);
      }
    }
    /**
     * <code>repeated .DischargingInstructionSubHeader dischargingInstructionSubHeader = 1;</code>
     */
    public com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader.Builder
        addDischargingInstructionSubHeaderBuilder() {
      return getDischargingInstructionSubHeaderFieldBuilder()
          .addBuilder(
              com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader
                  .getDefaultInstance());
    }
    /**
     * <code>repeated .DischargingInstructionSubHeader dischargingInstructionSubHeader = 1;</code>
     */
    public com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader.Builder
        addDischargingInstructionSubHeaderBuilder(int index) {
      return getDischargingInstructionSubHeaderFieldBuilder()
          .addBuilder(
              index,
              com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader
                  .getDefaultInstance());
    }
    /**
     * <code>repeated .DischargingInstructionSubHeader dischargingInstructionSubHeader = 1;</code>
     */
    public java.util.List<
            com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader.Builder>
        getDischargingInstructionSubHeaderBuilderList() {
      return getDischargingInstructionSubHeaderFieldBuilder().getBuilderList();
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader,
            com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader.Builder,
            com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeaderOrBuilder>
        getDischargingInstructionSubHeaderFieldBuilder() {
      if (dischargingInstructionSubHeaderBuilder_ == null) {
        dischargingInstructionSubHeaderBuilder_ =
            new com.google.protobuf.RepeatedFieldBuilderV3<
                com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader,
                com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader.Builder,
                com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeaderOrBuilder>(
                dischargingInstructionSubHeader_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        dischargingInstructionSubHeader_ = null;
      }
      return dischargingInstructionSubHeaderBuilder_;
    }

    private java.util.List<com.cpdss.common.generated.discharge_plan.DischargingInstructionGroup>
        dischargingInstructionGroupList_ = java.util.Collections.emptyList();

    private void ensureDischargingInstructionGroupListIsMutable() {
      if (!((bitField0_ & 0x00000002) != 0)) {
        dischargingInstructionGroupList_ =
            new java.util.ArrayList<
                com.cpdss.common.generated.discharge_plan.DischargingInstructionGroup>(
                dischargingInstructionGroupList_);
        bitField0_ |= 0x00000002;
      }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.discharge_plan.DischargingInstructionGroup,
            com.cpdss.common.generated.discharge_plan.DischargingInstructionGroup.Builder,
            com.cpdss.common.generated.discharge_plan.DischargingInstructionGroupOrBuilder>
        dischargingInstructionGroupListBuilder_;

    /** <code>repeated .DischargingInstructionGroup dischargingInstructionGroupList = 2;</code> */
    public java.util.List<com.cpdss.common.generated.discharge_plan.DischargingInstructionGroup>
        getDischargingInstructionGroupListList() {
      if (dischargingInstructionGroupListBuilder_ == null) {
        return java.util.Collections.unmodifiableList(dischargingInstructionGroupList_);
      } else {
        return dischargingInstructionGroupListBuilder_.getMessageList();
      }
    }
    /** <code>repeated .DischargingInstructionGroup dischargingInstructionGroupList = 2;</code> */
    public int getDischargingInstructionGroupListCount() {
      if (dischargingInstructionGroupListBuilder_ == null) {
        return dischargingInstructionGroupList_.size();
      } else {
        return dischargingInstructionGroupListBuilder_.getCount();
      }
    }
    /** <code>repeated .DischargingInstructionGroup dischargingInstructionGroupList = 2;</code> */
    public com.cpdss.common.generated.discharge_plan.DischargingInstructionGroup
        getDischargingInstructionGroupList(int index) {
      if (dischargingInstructionGroupListBuilder_ == null) {
        return dischargingInstructionGroupList_.get(index);
      } else {
        return dischargingInstructionGroupListBuilder_.getMessage(index);
      }
    }
    /** <code>repeated .DischargingInstructionGroup dischargingInstructionGroupList = 2;</code> */
    public Builder setDischargingInstructionGroupList(
        int index, com.cpdss.common.generated.discharge_plan.DischargingInstructionGroup value) {
      if (dischargingInstructionGroupListBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDischargingInstructionGroupListIsMutable();
        dischargingInstructionGroupList_.set(index, value);
        onChanged();
      } else {
        dischargingInstructionGroupListBuilder_.setMessage(index, value);
      }
      return this;
    }
    /** <code>repeated .DischargingInstructionGroup dischargingInstructionGroupList = 2;</code> */
    public Builder setDischargingInstructionGroupList(
        int index,
        com.cpdss.common.generated.discharge_plan.DischargingInstructionGroup.Builder
            builderForValue) {
      if (dischargingInstructionGroupListBuilder_ == null) {
        ensureDischargingInstructionGroupListIsMutable();
        dischargingInstructionGroupList_.set(index, builderForValue.build());
        onChanged();
      } else {
        dischargingInstructionGroupListBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .DischargingInstructionGroup dischargingInstructionGroupList = 2;</code> */
    public Builder addDischargingInstructionGroupList(
        com.cpdss.common.generated.discharge_plan.DischargingInstructionGroup value) {
      if (dischargingInstructionGroupListBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDischargingInstructionGroupListIsMutable();
        dischargingInstructionGroupList_.add(value);
        onChanged();
      } else {
        dischargingInstructionGroupListBuilder_.addMessage(value);
      }
      return this;
    }
    /** <code>repeated .DischargingInstructionGroup dischargingInstructionGroupList = 2;</code> */
    public Builder addDischargingInstructionGroupList(
        int index, com.cpdss.common.generated.discharge_plan.DischargingInstructionGroup value) {
      if (dischargingInstructionGroupListBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDischargingInstructionGroupListIsMutable();
        dischargingInstructionGroupList_.add(index, value);
        onChanged();
      } else {
        dischargingInstructionGroupListBuilder_.addMessage(index, value);
      }
      return this;
    }
    /** <code>repeated .DischargingInstructionGroup dischargingInstructionGroupList = 2;</code> */
    public Builder addDischargingInstructionGroupList(
        com.cpdss.common.generated.discharge_plan.DischargingInstructionGroup.Builder
            builderForValue) {
      if (dischargingInstructionGroupListBuilder_ == null) {
        ensureDischargingInstructionGroupListIsMutable();
        dischargingInstructionGroupList_.add(builderForValue.build());
        onChanged();
      } else {
        dischargingInstructionGroupListBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .DischargingInstructionGroup dischargingInstructionGroupList = 2;</code> */
    public Builder addDischargingInstructionGroupList(
        int index,
        com.cpdss.common.generated.discharge_plan.DischargingInstructionGroup.Builder
            builderForValue) {
      if (dischargingInstructionGroupListBuilder_ == null) {
        ensureDischargingInstructionGroupListIsMutable();
        dischargingInstructionGroupList_.add(index, builderForValue.build());
        onChanged();
      } else {
        dischargingInstructionGroupListBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .DischargingInstructionGroup dischargingInstructionGroupList = 2;</code> */
    public Builder addAllDischargingInstructionGroupList(
        java.lang.Iterable<
                ? extends com.cpdss.common.generated.discharge_plan.DischargingInstructionGroup>
            values) {
      if (dischargingInstructionGroupListBuilder_ == null) {
        ensureDischargingInstructionGroupListIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, dischargingInstructionGroupList_);
        onChanged();
      } else {
        dischargingInstructionGroupListBuilder_.addAllMessages(values);
      }
      return this;
    }
    /** <code>repeated .DischargingInstructionGroup dischargingInstructionGroupList = 2;</code> */
    public Builder clearDischargingInstructionGroupList() {
      if (dischargingInstructionGroupListBuilder_ == null) {
        dischargingInstructionGroupList_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000002);
        onChanged();
      } else {
        dischargingInstructionGroupListBuilder_.clear();
      }
      return this;
    }
    /** <code>repeated .DischargingInstructionGroup dischargingInstructionGroupList = 2;</code> */
    public Builder removeDischargingInstructionGroupList(int index) {
      if (dischargingInstructionGroupListBuilder_ == null) {
        ensureDischargingInstructionGroupListIsMutable();
        dischargingInstructionGroupList_.remove(index);
        onChanged();
      } else {
        dischargingInstructionGroupListBuilder_.remove(index);
      }
      return this;
    }
    /** <code>repeated .DischargingInstructionGroup dischargingInstructionGroupList = 2;</code> */
    public com.cpdss.common.generated.discharge_plan.DischargingInstructionGroup.Builder
        getDischargingInstructionGroupListBuilder(int index) {
      return getDischargingInstructionGroupListFieldBuilder().getBuilder(index);
    }
    /** <code>repeated .DischargingInstructionGroup dischargingInstructionGroupList = 2;</code> */
    public com.cpdss.common.generated.discharge_plan.DischargingInstructionGroupOrBuilder
        getDischargingInstructionGroupListOrBuilder(int index) {
      if (dischargingInstructionGroupListBuilder_ == null) {
        return dischargingInstructionGroupList_.get(index);
      } else {
        return dischargingInstructionGroupListBuilder_.getMessageOrBuilder(index);
      }
    }
    /** <code>repeated .DischargingInstructionGroup dischargingInstructionGroupList = 2;</code> */
    public java.util.List<
            ? extends
                com.cpdss.common.generated.discharge_plan.DischargingInstructionGroupOrBuilder>
        getDischargingInstructionGroupListOrBuilderList() {
      if (dischargingInstructionGroupListBuilder_ != null) {
        return dischargingInstructionGroupListBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(dischargingInstructionGroupList_);
      }
    }
    /** <code>repeated .DischargingInstructionGroup dischargingInstructionGroupList = 2;</code> */
    public com.cpdss.common.generated.discharge_plan.DischargingInstructionGroup.Builder
        addDischargingInstructionGroupListBuilder() {
      return getDischargingInstructionGroupListFieldBuilder()
          .addBuilder(
              com.cpdss.common.generated.discharge_plan.DischargingInstructionGroup
                  .getDefaultInstance());
    }
    /** <code>repeated .DischargingInstructionGroup dischargingInstructionGroupList = 2;</code> */
    public com.cpdss.common.generated.discharge_plan.DischargingInstructionGroup.Builder
        addDischargingInstructionGroupListBuilder(int index) {
      return getDischargingInstructionGroupListFieldBuilder()
          .addBuilder(
              index,
              com.cpdss.common.generated.discharge_plan.DischargingInstructionGroup
                  .getDefaultInstance());
    }
    /** <code>repeated .DischargingInstructionGroup dischargingInstructionGroupList = 2;</code> */
    public java.util.List<
            com.cpdss.common.generated.discharge_plan.DischargingInstructionGroup.Builder>
        getDischargingInstructionGroupListBuilderList() {
      return getDischargingInstructionGroupListFieldBuilder().getBuilderList();
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.discharge_plan.DischargingInstructionGroup,
            com.cpdss.common.generated.discharge_plan.DischargingInstructionGroup.Builder,
            com.cpdss.common.generated.discharge_plan.DischargingInstructionGroupOrBuilder>
        getDischargingInstructionGroupListFieldBuilder() {
      if (dischargingInstructionGroupListBuilder_ == null) {
        dischargingInstructionGroupListBuilder_ =
            new com.google.protobuf.RepeatedFieldBuilderV3<
                com.cpdss.common.generated.discharge_plan.DischargingInstructionGroup,
                com.cpdss.common.generated.discharge_plan.DischargingInstructionGroup.Builder,
                com.cpdss.common.generated.discharge_plan.DischargingInstructionGroupOrBuilder>(
                dischargingInstructionGroupList_,
                ((bitField0_ & 0x00000002) != 0),
                getParentForChildren(),
                isClean());
        dischargingInstructionGroupList_ = null;
      }
      return dischargingInstructionGroupListBuilder_;
    }

    private com.cpdss.common.generated.Common.ResponseStatus responseStatus_;
    private com.google.protobuf.SingleFieldBuilderV3<
            com.cpdss.common.generated.Common.ResponseStatus,
            com.cpdss.common.generated.Common.ResponseStatus.Builder,
            com.cpdss.common.generated.Common.ResponseStatusOrBuilder>
        responseStatusBuilder_;
    /**
     * <code>.ResponseStatus responseStatus = 3;</code>
     *
     * @return Whether the responseStatus field is set.
     */
    public boolean hasResponseStatus() {
      return responseStatusBuilder_ != null || responseStatus_ != null;
    }
    /**
     * <code>.ResponseStatus responseStatus = 3;</code>
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
    /** <code>.ResponseStatus responseStatus = 3;</code> */
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
    /** <code>.ResponseStatus responseStatus = 3;</code> */
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
    /** <code>.ResponseStatus responseStatus = 3;</code> */
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
    /** <code>.ResponseStatus responseStatus = 3;</code> */
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
    /** <code>.ResponseStatus responseStatus = 3;</code> */
    public com.cpdss.common.generated.Common.ResponseStatus.Builder getResponseStatusBuilder() {

      onChanged();
      return getResponseStatusFieldBuilder().getBuilder();
    }
    /** <code>.ResponseStatus responseStatus = 3;</code> */
    public com.cpdss.common.generated.Common.ResponseStatusOrBuilder getResponseStatusOrBuilder() {
      if (responseStatusBuilder_ != null) {
        return responseStatusBuilder_.getMessageOrBuilder();
      } else {
        return responseStatus_ == null
            ? com.cpdss.common.generated.Common.ResponseStatus.getDefaultInstance()
            : responseStatus_;
      }
    }
    /** <code>.ResponseStatus responseStatus = 3;</code> */
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

    @java.lang.Override
    public final Builder setUnknownFields(final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }

    // @@protoc_insertion_point(builder_scope:DischargingInstructionDetails)
  }

  // @@protoc_insertion_point(class_scope:DischargingInstructionDetails)
  private static final com.cpdss.common.generated.discharge_plan.DischargingInstructionDetails
      DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE =
        new com.cpdss.common.generated.discharge_plan.DischargingInstructionDetails();
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionDetails
      getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<DischargingInstructionDetails> PARSER =
      new com.google.protobuf.AbstractParser<DischargingInstructionDetails>() {
        @java.lang.Override
        public DischargingInstructionDetails parsePartialFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
          return new DischargingInstructionDetails(input, extensionRegistry);
        }
      };

  public static com.google.protobuf.Parser<DischargingInstructionDetails> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<DischargingInstructionDetails> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.cpdss.common.generated.discharge_plan.DischargingInstructionDetails
      getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
}
