/* Licensed at AlphaOri Technologies */
package com.cpdss.common.generated.discharge_plan;

/** Protobuf type {@code DischargingInstructionsUpdate} */
public final class DischargingInstructionsUpdate extends com.google.protobuf.GeneratedMessageV3
    implements
    // @@protoc_insertion_point(message_implements:DischargingInstructionsUpdate)
    DischargingInstructionsUpdateOrBuilder {
  private static final long serialVersionUID = 0L;
  // Use DischargingInstructionsUpdate.newBuilder() to construct.
  private DischargingInstructionsUpdate(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }

  private DischargingInstructionsUpdate() {
    instructionList_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
    return new DischargingInstructionsUpdate();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }

  private DischargingInstructionsUpdate(
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
                instructionList_ =
                    new java.util.ArrayList<
                        com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus>();
                mutable_bitField0_ |= 0x00000001;
              }
              instructionList_.add(
                  input.readMessage(
                      com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus
                          .parser(),
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
        instructionList_ = java.util.Collections.unmodifiableList(instructionList_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }

  public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
    return com.cpdss.common.generated.discharge_plan.DischargePlanModels
        .internal_static_DischargingInstructionsUpdate_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.cpdss.common.generated.discharge_plan.DischargePlanModels
        .internal_static_DischargingInstructionsUpdate_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.cpdss.common.generated.discharge_plan.DischargingInstructionsUpdate.class,
            com.cpdss.common.generated.discharge_plan.DischargingInstructionsUpdate.Builder.class);
  }

  public static final int INSTRUCTIONLIST_FIELD_NUMBER = 1;
  private java.util.List<com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus>
      instructionList_;
  /** <code>repeated .DischargingInstructionStatus instructionList = 1;</code> */
  public java.util.List<com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus>
      getInstructionListList() {
    return instructionList_;
  }
  /** <code>repeated .DischargingInstructionStatus instructionList = 1;</code> */
  public java.util.List<
          ? extends com.cpdss.common.generated.discharge_plan.DischargingInstructionStatusOrBuilder>
      getInstructionListOrBuilderList() {
    return instructionList_;
  }
  /** <code>repeated .DischargingInstructionStatus instructionList = 1;</code> */
  public int getInstructionListCount() {
    return instructionList_.size();
  }
  /** <code>repeated .DischargingInstructionStatus instructionList = 1;</code> */
  public com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus getInstructionList(
      int index) {
    return instructionList_.get(index);
  }
  /** <code>repeated .DischargingInstructionStatus instructionList = 1;</code> */
  public com.cpdss.common.generated.discharge_plan.DischargingInstructionStatusOrBuilder
      getInstructionListOrBuilder(int index) {
    return instructionList_.get(index);
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
    for (int i = 0; i < instructionList_.size(); i++) {
      output.writeMessage(1, instructionList_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < instructionList_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream.computeMessageSize(1, instructionList_.get(i));
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
    if (!(obj instanceof com.cpdss.common.generated.discharge_plan.DischargingInstructionsUpdate)) {
      return super.equals(obj);
    }
    com.cpdss.common.generated.discharge_plan.DischargingInstructionsUpdate other =
        (com.cpdss.common.generated.discharge_plan.DischargingInstructionsUpdate) obj;

    if (!getInstructionListList().equals(other.getInstructionListList())) return false;
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
    if (getInstructionListCount() > 0) {
      hash = (37 * hash) + INSTRUCTIONLIST_FIELD_NUMBER;
      hash = (53 * hash) + getInstructionListList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionsUpdate parseFrom(
      java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionsUpdate parseFrom(
      java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionsUpdate parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionsUpdate parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionsUpdate parseFrom(
      byte[] data) throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionsUpdate parseFrom(
      byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionsUpdate parseFrom(
      java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionsUpdate parseFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionsUpdate
      parseDelimitedFrom(java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionsUpdate
      parseDelimitedFrom(
          java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionsUpdate parseFrom(
      com.google.protobuf.CodedInputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionsUpdate parseFrom(
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
      com.cpdss.common.generated.discharge_plan.DischargingInstructionsUpdate prototype) {
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
  /** Protobuf type {@code DischargingInstructionsUpdate} */
  public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
      implements
      // @@protoc_insertion_point(builder_implements:DischargingInstructionsUpdate)
      com.cpdss.common.generated.discharge_plan.DischargingInstructionsUpdateOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanModels
          .internal_static_DischargingInstructionsUpdate_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanModels
          .internal_static_DischargingInstructionsUpdate_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.discharge_plan.DischargingInstructionsUpdate.class,
              com.cpdss.common.generated.discharge_plan.DischargingInstructionsUpdate.Builder
                  .class);
    }

    // Construct using
    // com.cpdss.common.generated.discharge_plan.DischargingInstructionsUpdate.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {
        getInstructionListFieldBuilder();
      }
    }

    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (instructionListBuilder_ == null) {
        instructionList_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        instructionListBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanModels
          .internal_static_DischargingInstructionsUpdate_descriptor;
    }

    @java.lang.Override
    public com.cpdss.common.generated.discharge_plan.DischargingInstructionsUpdate
        getDefaultInstanceForType() {
      return com.cpdss.common.generated.discharge_plan.DischargingInstructionsUpdate
          .getDefaultInstance();
    }

    @java.lang.Override
    public com.cpdss.common.generated.discharge_plan.DischargingInstructionsUpdate build() {
      com.cpdss.common.generated.discharge_plan.DischargingInstructionsUpdate result =
          buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.cpdss.common.generated.discharge_plan.DischargingInstructionsUpdate buildPartial() {
      com.cpdss.common.generated.discharge_plan.DischargingInstructionsUpdate result =
          new com.cpdss.common.generated.discharge_plan.DischargingInstructionsUpdate(this);
      int from_bitField0_ = bitField0_;
      if (instructionListBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          instructionList_ = java.util.Collections.unmodifiableList(instructionList_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.instructionList_ = instructionList_;
      } else {
        result.instructionList_ = instructionListBuilder_.build();
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
          instanceof com.cpdss.common.generated.discharge_plan.DischargingInstructionsUpdate) {
        return mergeFrom(
            (com.cpdss.common.generated.discharge_plan.DischargingInstructionsUpdate) other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(
        com.cpdss.common.generated.discharge_plan.DischargingInstructionsUpdate other) {
      if (other
          == com.cpdss.common.generated.discharge_plan.DischargingInstructionsUpdate
              .getDefaultInstance()) return this;
      if (instructionListBuilder_ == null) {
        if (!other.instructionList_.isEmpty()) {
          if (instructionList_.isEmpty()) {
            instructionList_ = other.instructionList_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureInstructionListIsMutable();
            instructionList_.addAll(other.instructionList_);
          }
          onChanged();
        }
      } else {
        if (!other.instructionList_.isEmpty()) {
          if (instructionListBuilder_.isEmpty()) {
            instructionListBuilder_.dispose();
            instructionListBuilder_ = null;
            instructionList_ = other.instructionList_;
            bitField0_ = (bitField0_ & ~0x00000001);
            instructionListBuilder_ =
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
                    ? getInstructionListFieldBuilder()
                    : null;
          } else {
            instructionListBuilder_.addAllMessages(other.instructionList_);
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
      com.cpdss.common.generated.discharge_plan.DischargingInstructionsUpdate parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage =
            (com.cpdss.common.generated.discharge_plan.DischargingInstructionsUpdate)
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

    private java.util.List<com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus>
        instructionList_ = java.util.Collections.emptyList();

    private void ensureInstructionListIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        instructionList_ =
            new java.util.ArrayList<
                com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus>(
                instructionList_);
        bitField0_ |= 0x00000001;
      }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus,
            com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus.Builder,
            com.cpdss.common.generated.discharge_plan.DischargingInstructionStatusOrBuilder>
        instructionListBuilder_;

    /** <code>repeated .DischargingInstructionStatus instructionList = 1;</code> */
    public java.util.List<com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus>
        getInstructionListList() {
      if (instructionListBuilder_ == null) {
        return java.util.Collections.unmodifiableList(instructionList_);
      } else {
        return instructionListBuilder_.getMessageList();
      }
    }
    /** <code>repeated .DischargingInstructionStatus instructionList = 1;</code> */
    public int getInstructionListCount() {
      if (instructionListBuilder_ == null) {
        return instructionList_.size();
      } else {
        return instructionListBuilder_.getCount();
      }
    }
    /** <code>repeated .DischargingInstructionStatus instructionList = 1;</code> */
    public com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus
        getInstructionList(int index) {
      if (instructionListBuilder_ == null) {
        return instructionList_.get(index);
      } else {
        return instructionListBuilder_.getMessage(index);
      }
    }
    /** <code>repeated .DischargingInstructionStatus instructionList = 1;</code> */
    public Builder setInstructionList(
        int index, com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus value) {
      if (instructionListBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureInstructionListIsMutable();
        instructionList_.set(index, value);
        onChanged();
      } else {
        instructionListBuilder_.setMessage(index, value);
      }
      return this;
    }
    /** <code>repeated .DischargingInstructionStatus instructionList = 1;</code> */
    public Builder setInstructionList(
        int index,
        com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus.Builder
            builderForValue) {
      if (instructionListBuilder_ == null) {
        ensureInstructionListIsMutable();
        instructionList_.set(index, builderForValue.build());
        onChanged();
      } else {
        instructionListBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .DischargingInstructionStatus instructionList = 1;</code> */
    public Builder addInstructionList(
        com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus value) {
      if (instructionListBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureInstructionListIsMutable();
        instructionList_.add(value);
        onChanged();
      } else {
        instructionListBuilder_.addMessage(value);
      }
      return this;
    }
    /** <code>repeated .DischargingInstructionStatus instructionList = 1;</code> */
    public Builder addInstructionList(
        int index, com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus value) {
      if (instructionListBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureInstructionListIsMutable();
        instructionList_.add(index, value);
        onChanged();
      } else {
        instructionListBuilder_.addMessage(index, value);
      }
      return this;
    }
    /** <code>repeated .DischargingInstructionStatus instructionList = 1;</code> */
    public Builder addInstructionList(
        com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus.Builder
            builderForValue) {
      if (instructionListBuilder_ == null) {
        ensureInstructionListIsMutable();
        instructionList_.add(builderForValue.build());
        onChanged();
      } else {
        instructionListBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .DischargingInstructionStatus instructionList = 1;</code> */
    public Builder addInstructionList(
        int index,
        com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus.Builder
            builderForValue) {
      if (instructionListBuilder_ == null) {
        ensureInstructionListIsMutable();
        instructionList_.add(index, builderForValue.build());
        onChanged();
      } else {
        instructionListBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .DischargingInstructionStatus instructionList = 1;</code> */
    public Builder addAllInstructionList(
        java.lang.Iterable<
                ? extends com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus>
            values) {
      if (instructionListBuilder_ == null) {
        ensureInstructionListIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(values, instructionList_);
        onChanged();
      } else {
        instructionListBuilder_.addAllMessages(values);
      }
      return this;
    }
    /** <code>repeated .DischargingInstructionStatus instructionList = 1;</code> */
    public Builder clearInstructionList() {
      if (instructionListBuilder_ == null) {
        instructionList_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        instructionListBuilder_.clear();
      }
      return this;
    }
    /** <code>repeated .DischargingInstructionStatus instructionList = 1;</code> */
    public Builder removeInstructionList(int index) {
      if (instructionListBuilder_ == null) {
        ensureInstructionListIsMutable();
        instructionList_.remove(index);
        onChanged();
      } else {
        instructionListBuilder_.remove(index);
      }
      return this;
    }
    /** <code>repeated .DischargingInstructionStatus instructionList = 1;</code> */
    public com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus.Builder
        getInstructionListBuilder(int index) {
      return getInstructionListFieldBuilder().getBuilder(index);
    }
    /** <code>repeated .DischargingInstructionStatus instructionList = 1;</code> */
    public com.cpdss.common.generated.discharge_plan.DischargingInstructionStatusOrBuilder
        getInstructionListOrBuilder(int index) {
      if (instructionListBuilder_ == null) {
        return instructionList_.get(index);
      } else {
        return instructionListBuilder_.getMessageOrBuilder(index);
      }
    }
    /** <code>repeated .DischargingInstructionStatus instructionList = 1;</code> */
    public java.util.List<
            ? extends
                com.cpdss.common.generated.discharge_plan.DischargingInstructionStatusOrBuilder>
        getInstructionListOrBuilderList() {
      if (instructionListBuilder_ != null) {
        return instructionListBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(instructionList_);
      }
    }
    /** <code>repeated .DischargingInstructionStatus instructionList = 1;</code> */
    public com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus.Builder
        addInstructionListBuilder() {
      return getInstructionListFieldBuilder()
          .addBuilder(
              com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus
                  .getDefaultInstance());
    }
    /** <code>repeated .DischargingInstructionStatus instructionList = 1;</code> */
    public com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus.Builder
        addInstructionListBuilder(int index) {
      return getInstructionListFieldBuilder()
          .addBuilder(
              index,
              com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus
                  .getDefaultInstance());
    }
    /** <code>repeated .DischargingInstructionStatus instructionList = 1;</code> */
    public java.util.List<
            com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus.Builder>
        getInstructionListBuilderList() {
      return getInstructionListFieldBuilder().getBuilderList();
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus,
            com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus.Builder,
            com.cpdss.common.generated.discharge_plan.DischargingInstructionStatusOrBuilder>
        getInstructionListFieldBuilder() {
      if (instructionListBuilder_ == null) {
        instructionListBuilder_ =
            new com.google.protobuf.RepeatedFieldBuilderV3<
                com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus,
                com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus.Builder,
                com.cpdss.common.generated.discharge_plan.DischargingInstructionStatusOrBuilder>(
                instructionList_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        instructionList_ = null;
      }
      return instructionListBuilder_;
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

    // @@protoc_insertion_point(builder_scope:DischargingInstructionsUpdate)
  }

  // @@protoc_insertion_point(class_scope:DischargingInstructionsUpdate)
  private static final com.cpdss.common.generated.discharge_plan.DischargingInstructionsUpdate
      DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE =
        new com.cpdss.common.generated.discharge_plan.DischargingInstructionsUpdate();
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionsUpdate
      getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<DischargingInstructionsUpdate> PARSER =
      new com.google.protobuf.AbstractParser<DischargingInstructionsUpdate>() {
        @java.lang.Override
        public DischargingInstructionsUpdate parsePartialFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
          return new DischargingInstructionsUpdate(input, extensionRegistry);
        }
      };

  public static com.google.protobuf.Parser<DischargingInstructionsUpdate> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<DischargingInstructionsUpdate> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.cpdss.common.generated.discharge_plan.DischargingInstructionsUpdate
      getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
}
