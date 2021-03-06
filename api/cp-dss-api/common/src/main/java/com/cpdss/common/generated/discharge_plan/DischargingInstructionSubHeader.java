/* Licensed at AlphaOri Technologies */
package com.cpdss.common.generated.discharge_plan;

/** Protobuf type {@code DischargingInstructionSubHeader} */
public final class DischargingInstructionSubHeader extends com.google.protobuf.GeneratedMessageV3
    implements
    // @@protoc_insertion_point(message_implements:DischargingInstructionSubHeader)
    DischargingInstructionSubHeaderOrBuilder {
  private static final long serialVersionUID = 0L;
  // Use DischargingInstructionSubHeader.newBuilder() to construct.
  private DischargingInstructionSubHeader(
      com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }

  private DischargingInstructionSubHeader() {
    subHeaderName_ = "";
    dischargingInstructionsList_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
    return new DischargingInstructionSubHeader();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }

  private DischargingInstructionSubHeader(
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
          case 8:
            {
              instructionTypeId_ = input.readInt64();
              break;
            }
          case 16:
            {
              instructionHeaderId_ = input.readInt64();
              break;
            }
          case 24:
            {
              subHeaderId_ = input.readInt64();
              break;
            }
          case 34:
            {
              java.lang.String s = input.readStringRequireUtf8();

              subHeaderName_ = s;
              break;
            }
          case 40:
            {
              isChecked_ = input.readBool();
              break;
            }
          case 50:
            {
              if (!((mutable_bitField0_ & 0x00000001) != 0)) {
                dischargingInstructionsList_ =
                    new java.util.ArrayList<
                        com.cpdss.common.generated.discharge_plan.DischargingInstructions>();
                mutable_bitField0_ |= 0x00000001;
              }
              dischargingInstructionsList_.add(
                  input.readMessage(
                      com.cpdss.common.generated.discharge_plan.DischargingInstructions.parser(),
                      extensionRegistry));
              break;
            }
          case 56:
            {
              isEditable_ = input.readBool();
              break;
            }
          case 64:
            {
              isHeaderInstruction_ = input.readBool();
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
        dischargingInstructionsList_ =
            java.util.Collections.unmodifiableList(dischargingInstructionsList_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }

  public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
    return com.cpdss.common.generated.discharge_plan.DischargePlanModels
        .internal_static_DischargingInstructionSubHeader_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.cpdss.common.generated.discharge_plan.DischargePlanModels
        .internal_static_DischargingInstructionSubHeader_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader.class,
            com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader.Builder
                .class);
  }

  public static final int INSTRUCTIONTYPEID_FIELD_NUMBER = 1;
  private long instructionTypeId_;
  /**
   * <code>int64 instructionTypeId = 1;</code>
   *
   * @return The instructionTypeId.
   */
  public long getInstructionTypeId() {
    return instructionTypeId_;
  }

  public static final int INSTRUCTIONHEADERID_FIELD_NUMBER = 2;
  private long instructionHeaderId_;
  /**
   * <code>int64 instructionHeaderId = 2;</code>
   *
   * @return The instructionHeaderId.
   */
  public long getInstructionHeaderId() {
    return instructionHeaderId_;
  }

  public static final int SUBHEADERID_FIELD_NUMBER = 3;
  private long subHeaderId_;
  /**
   * <code>int64 subHeaderId = 3;</code>
   *
   * @return The subHeaderId.
   */
  public long getSubHeaderId() {
    return subHeaderId_;
  }

  public static final int SUBHEADERNAME_FIELD_NUMBER = 4;
  private volatile java.lang.Object subHeaderName_;
  /**
   * <code>string subHeaderName = 4;</code>
   *
   * @return The subHeaderName.
   */
  public java.lang.String getSubHeaderName() {
    java.lang.Object ref = subHeaderName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      subHeaderName_ = s;
      return s;
    }
  }
  /**
   * <code>string subHeaderName = 4;</code>
   *
   * @return The bytes for subHeaderName.
   */
  public com.google.protobuf.ByteString getSubHeaderNameBytes() {
    java.lang.Object ref = subHeaderName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
      subHeaderName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int ISCHECKED_FIELD_NUMBER = 5;
  private boolean isChecked_;
  /**
   * <code>bool isChecked = 5;</code>
   *
   * @return The isChecked.
   */
  public boolean getIsChecked() {
    return isChecked_;
  }

  public static final int DISCHARGINGINSTRUCTIONSLIST_FIELD_NUMBER = 6;
  private java.util.List<com.cpdss.common.generated.discharge_plan.DischargingInstructions>
      dischargingInstructionsList_;
  /** <code>repeated .DischargingInstructions dischargingInstructionsList = 6;</code> */
  public java.util.List<com.cpdss.common.generated.discharge_plan.DischargingInstructions>
      getDischargingInstructionsListList() {
    return dischargingInstructionsList_;
  }
  /** <code>repeated .DischargingInstructions dischargingInstructionsList = 6;</code> */
  public java.util.List<
          ? extends com.cpdss.common.generated.discharge_plan.DischargingInstructionsOrBuilder>
      getDischargingInstructionsListOrBuilderList() {
    return dischargingInstructionsList_;
  }
  /** <code>repeated .DischargingInstructions dischargingInstructionsList = 6;</code> */
  public int getDischargingInstructionsListCount() {
    return dischargingInstructionsList_.size();
  }
  /** <code>repeated .DischargingInstructions dischargingInstructionsList = 6;</code> */
  public com.cpdss.common.generated.discharge_plan.DischargingInstructions
      getDischargingInstructionsList(int index) {
    return dischargingInstructionsList_.get(index);
  }
  /** <code>repeated .DischargingInstructions dischargingInstructionsList = 6;</code> */
  public com.cpdss.common.generated.discharge_plan.DischargingInstructionsOrBuilder
      getDischargingInstructionsListOrBuilder(int index) {
    return dischargingInstructionsList_.get(index);
  }

  public static final int ISEDITABLE_FIELD_NUMBER = 7;
  private boolean isEditable_;
  /**
   * <code>bool isEditable = 7;</code>
   *
   * @return The isEditable.
   */
  public boolean getIsEditable() {
    return isEditable_;
  }

  public static final int ISHEADERINSTRUCTION_FIELD_NUMBER = 8;
  private boolean isHeaderInstruction_;
  /**
   * <code>bool IsHeaderInstruction = 8;</code>
   *
   * @return The isHeaderInstruction.
   */
  public boolean getIsHeaderInstruction() {
    return isHeaderInstruction_;
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
    if (instructionTypeId_ != 0L) {
      output.writeInt64(1, instructionTypeId_);
    }
    if (instructionHeaderId_ != 0L) {
      output.writeInt64(2, instructionHeaderId_);
    }
    if (subHeaderId_ != 0L) {
      output.writeInt64(3, subHeaderId_);
    }
    if (!getSubHeaderNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, subHeaderName_);
    }
    if (isChecked_ != false) {
      output.writeBool(5, isChecked_);
    }
    for (int i = 0; i < dischargingInstructionsList_.size(); i++) {
      output.writeMessage(6, dischargingInstructionsList_.get(i));
    }
    if (isEditable_ != false) {
      output.writeBool(7, isEditable_);
    }
    if (isHeaderInstruction_ != false) {
      output.writeBool(8, isHeaderInstruction_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (instructionTypeId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream.computeInt64Size(1, instructionTypeId_);
    }
    if (instructionHeaderId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream.computeInt64Size(2, instructionHeaderId_);
    }
    if (subHeaderId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream.computeInt64Size(3, subHeaderId_);
    }
    if (!getSubHeaderNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, subHeaderName_);
    }
    if (isChecked_ != false) {
      size += com.google.protobuf.CodedOutputStream.computeBoolSize(5, isChecked_);
    }
    for (int i = 0; i < dischargingInstructionsList_.size(); i++) {
      size +=
          com.google.protobuf.CodedOutputStream.computeMessageSize(
              6, dischargingInstructionsList_.get(i));
    }
    if (isEditable_ != false) {
      size += com.google.protobuf.CodedOutputStream.computeBoolSize(7, isEditable_);
    }
    if (isHeaderInstruction_ != false) {
      size += com.google.protobuf.CodedOutputStream.computeBoolSize(8, isHeaderInstruction_);
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
        instanceof com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader)) {
      return super.equals(obj);
    }
    com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader other =
        (com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader) obj;

    if (getInstructionTypeId() != other.getInstructionTypeId()) return false;
    if (getInstructionHeaderId() != other.getInstructionHeaderId()) return false;
    if (getSubHeaderId() != other.getSubHeaderId()) return false;
    if (!getSubHeaderName().equals(other.getSubHeaderName())) return false;
    if (getIsChecked() != other.getIsChecked()) return false;
    if (!getDischargingInstructionsListList().equals(other.getDischargingInstructionsListList()))
      return false;
    if (getIsEditable() != other.getIsEditable()) return false;
    if (getIsHeaderInstruction() != other.getIsHeaderInstruction()) return false;
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
    hash = (37 * hash) + INSTRUCTIONTYPEID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getInstructionTypeId());
    hash = (37 * hash) + INSTRUCTIONHEADERID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getInstructionHeaderId());
    hash = (37 * hash) + SUBHEADERID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getSubHeaderId());
    hash = (37 * hash) + SUBHEADERNAME_FIELD_NUMBER;
    hash = (53 * hash) + getSubHeaderName().hashCode();
    hash = (37 * hash) + ISCHECKED_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(getIsChecked());
    if (getDischargingInstructionsListCount() > 0) {
      hash = (37 * hash) + DISCHARGINGINSTRUCTIONSLIST_FIELD_NUMBER;
      hash = (53 * hash) + getDischargingInstructionsListList().hashCode();
    }
    hash = (37 * hash) + ISEDITABLE_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(getIsEditable());
    hash = (37 * hash) + ISHEADERINSTRUCTION_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(getIsHeaderInstruction());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader parseFrom(
      java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader parseFrom(
      java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader parseFrom(
      byte[] data) throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader parseFrom(
      byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader parseFrom(
      java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader parseFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader
      parseDelimitedFrom(java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader
      parseDelimitedFrom(
          java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader parseFrom(
      com.google.protobuf.CodedInputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader parseFrom(
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
      com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader prototype) {
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
  /** Protobuf type {@code DischargingInstructionSubHeader} */
  public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
      implements
      // @@protoc_insertion_point(builder_implements:DischargingInstructionSubHeader)
      com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeaderOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanModels
          .internal_static_DischargingInstructionSubHeader_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanModels
          .internal_static_DischargingInstructionSubHeader_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader.class,
              com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader.Builder
                  .class);
    }

    // Construct using
    // com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {
        getDischargingInstructionsListFieldBuilder();
      }
    }

    @java.lang.Override
    public Builder clear() {
      super.clear();
      instructionTypeId_ = 0L;

      instructionHeaderId_ = 0L;

      subHeaderId_ = 0L;

      subHeaderName_ = "";

      isChecked_ = false;

      if (dischargingInstructionsListBuilder_ == null) {
        dischargingInstructionsList_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        dischargingInstructionsListBuilder_.clear();
      }
      isEditable_ = false;

      isHeaderInstruction_ = false;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanModels
          .internal_static_DischargingInstructionSubHeader_descriptor;
    }

    @java.lang.Override
    public com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader
        getDefaultInstanceForType() {
      return com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader
          .getDefaultInstance();
    }

    @java.lang.Override
    public com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader build() {
      com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader result =
          buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader
        buildPartial() {
      com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader result =
          new com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader(this);
      int from_bitField0_ = bitField0_;
      result.instructionTypeId_ = instructionTypeId_;
      result.instructionHeaderId_ = instructionHeaderId_;
      result.subHeaderId_ = subHeaderId_;
      result.subHeaderName_ = subHeaderName_;
      result.isChecked_ = isChecked_;
      if (dischargingInstructionsListBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          dischargingInstructionsList_ =
              java.util.Collections.unmodifiableList(dischargingInstructionsList_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.dischargingInstructionsList_ = dischargingInstructionsList_;
      } else {
        result.dischargingInstructionsList_ = dischargingInstructionsListBuilder_.build();
      }
      result.isEditable_ = isEditable_;
      result.isHeaderInstruction_ = isHeaderInstruction_;
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
          instanceof com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader) {
        return mergeFrom(
            (com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader) other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(
        com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader other) {
      if (other
          == com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader
              .getDefaultInstance()) return this;
      if (other.getInstructionTypeId() != 0L) {
        setInstructionTypeId(other.getInstructionTypeId());
      }
      if (other.getInstructionHeaderId() != 0L) {
        setInstructionHeaderId(other.getInstructionHeaderId());
      }
      if (other.getSubHeaderId() != 0L) {
        setSubHeaderId(other.getSubHeaderId());
      }
      if (!other.getSubHeaderName().isEmpty()) {
        subHeaderName_ = other.subHeaderName_;
        onChanged();
      }
      if (other.getIsChecked() != false) {
        setIsChecked(other.getIsChecked());
      }
      if (dischargingInstructionsListBuilder_ == null) {
        if (!other.dischargingInstructionsList_.isEmpty()) {
          if (dischargingInstructionsList_.isEmpty()) {
            dischargingInstructionsList_ = other.dischargingInstructionsList_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureDischargingInstructionsListIsMutable();
            dischargingInstructionsList_.addAll(other.dischargingInstructionsList_);
          }
          onChanged();
        }
      } else {
        if (!other.dischargingInstructionsList_.isEmpty()) {
          if (dischargingInstructionsListBuilder_.isEmpty()) {
            dischargingInstructionsListBuilder_.dispose();
            dischargingInstructionsListBuilder_ = null;
            dischargingInstructionsList_ = other.dischargingInstructionsList_;
            bitField0_ = (bitField0_ & ~0x00000001);
            dischargingInstructionsListBuilder_ =
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
                    ? getDischargingInstructionsListFieldBuilder()
                    : null;
          } else {
            dischargingInstructionsListBuilder_.addAllMessages(other.dischargingInstructionsList_);
          }
        }
      }
      if (other.getIsEditable() != false) {
        setIsEditable(other.getIsEditable());
      }
      if (other.getIsHeaderInstruction() != false) {
        setIsHeaderInstruction(other.getIsHeaderInstruction());
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
      com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader parsedMessage =
          null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage =
            (com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader)
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

    private long instructionTypeId_;
    /**
     * <code>int64 instructionTypeId = 1;</code>
     *
     * @return The instructionTypeId.
     */
    public long getInstructionTypeId() {
      return instructionTypeId_;
    }
    /**
     * <code>int64 instructionTypeId = 1;</code>
     *
     * @param value The instructionTypeId to set.
     * @return This builder for chaining.
     */
    public Builder setInstructionTypeId(long value) {

      instructionTypeId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 instructionTypeId = 1;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearInstructionTypeId() {

      instructionTypeId_ = 0L;
      onChanged();
      return this;
    }

    private long instructionHeaderId_;
    /**
     * <code>int64 instructionHeaderId = 2;</code>
     *
     * @return The instructionHeaderId.
     */
    public long getInstructionHeaderId() {
      return instructionHeaderId_;
    }
    /**
     * <code>int64 instructionHeaderId = 2;</code>
     *
     * @param value The instructionHeaderId to set.
     * @return This builder for chaining.
     */
    public Builder setInstructionHeaderId(long value) {

      instructionHeaderId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 instructionHeaderId = 2;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearInstructionHeaderId() {

      instructionHeaderId_ = 0L;
      onChanged();
      return this;
    }

    private long subHeaderId_;
    /**
     * <code>int64 subHeaderId = 3;</code>
     *
     * @return The subHeaderId.
     */
    public long getSubHeaderId() {
      return subHeaderId_;
    }
    /**
     * <code>int64 subHeaderId = 3;</code>
     *
     * @param value The subHeaderId to set.
     * @return This builder for chaining.
     */
    public Builder setSubHeaderId(long value) {

      subHeaderId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 subHeaderId = 3;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearSubHeaderId() {

      subHeaderId_ = 0L;
      onChanged();
      return this;
    }

    private java.lang.Object subHeaderName_ = "";
    /**
     * <code>string subHeaderName = 4;</code>
     *
     * @return The subHeaderName.
     */
    public java.lang.String getSubHeaderName() {
      java.lang.Object ref = subHeaderName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        subHeaderName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string subHeaderName = 4;</code>
     *
     * @return The bytes for subHeaderName.
     */
    public com.google.protobuf.ByteString getSubHeaderNameBytes() {
      java.lang.Object ref = subHeaderName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        subHeaderName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string subHeaderName = 4;</code>
     *
     * @param value The subHeaderName to set.
     * @return This builder for chaining.
     */
    public Builder setSubHeaderName(java.lang.String value) {
      if (value == null) {
        throw new NullPointerException();
      }

      subHeaderName_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string subHeaderName = 4;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearSubHeaderName() {

      subHeaderName_ = getDefaultInstance().getSubHeaderName();
      onChanged();
      return this;
    }
    /**
     * <code>string subHeaderName = 4;</code>
     *
     * @param value The bytes for subHeaderName to set.
     * @return This builder for chaining.
     */
    public Builder setSubHeaderNameBytes(com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      checkByteStringIsUtf8(value);

      subHeaderName_ = value;
      onChanged();
      return this;
    }

    private boolean isChecked_;
    /**
     * <code>bool isChecked = 5;</code>
     *
     * @return The isChecked.
     */
    public boolean getIsChecked() {
      return isChecked_;
    }
    /**
     * <code>bool isChecked = 5;</code>
     *
     * @param value The isChecked to set.
     * @return This builder for chaining.
     */
    public Builder setIsChecked(boolean value) {

      isChecked_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool isChecked = 5;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearIsChecked() {

      isChecked_ = false;
      onChanged();
      return this;
    }

    private java.util.List<com.cpdss.common.generated.discharge_plan.DischargingInstructions>
        dischargingInstructionsList_ = java.util.Collections.emptyList();

    private void ensureDischargingInstructionsListIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        dischargingInstructionsList_ =
            new java.util.ArrayList<
                com.cpdss.common.generated.discharge_plan.DischargingInstructions>(
                dischargingInstructionsList_);
        bitField0_ |= 0x00000001;
      }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.discharge_plan.DischargingInstructions,
            com.cpdss.common.generated.discharge_plan.DischargingInstructions.Builder,
            com.cpdss.common.generated.discharge_plan.DischargingInstructionsOrBuilder>
        dischargingInstructionsListBuilder_;

    /** <code>repeated .DischargingInstructions dischargingInstructionsList = 6;</code> */
    public java.util.List<com.cpdss.common.generated.discharge_plan.DischargingInstructions>
        getDischargingInstructionsListList() {
      if (dischargingInstructionsListBuilder_ == null) {
        return java.util.Collections.unmodifiableList(dischargingInstructionsList_);
      } else {
        return dischargingInstructionsListBuilder_.getMessageList();
      }
    }
    /** <code>repeated .DischargingInstructions dischargingInstructionsList = 6;</code> */
    public int getDischargingInstructionsListCount() {
      if (dischargingInstructionsListBuilder_ == null) {
        return dischargingInstructionsList_.size();
      } else {
        return dischargingInstructionsListBuilder_.getCount();
      }
    }
    /** <code>repeated .DischargingInstructions dischargingInstructionsList = 6;</code> */
    public com.cpdss.common.generated.discharge_plan.DischargingInstructions
        getDischargingInstructionsList(int index) {
      if (dischargingInstructionsListBuilder_ == null) {
        return dischargingInstructionsList_.get(index);
      } else {
        return dischargingInstructionsListBuilder_.getMessage(index);
      }
    }
    /** <code>repeated .DischargingInstructions dischargingInstructionsList = 6;</code> */
    public Builder setDischargingInstructionsList(
        int index, com.cpdss.common.generated.discharge_plan.DischargingInstructions value) {
      if (dischargingInstructionsListBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDischargingInstructionsListIsMutable();
        dischargingInstructionsList_.set(index, value);
        onChanged();
      } else {
        dischargingInstructionsListBuilder_.setMessage(index, value);
      }
      return this;
    }
    /** <code>repeated .DischargingInstructions dischargingInstructionsList = 6;</code> */
    public Builder setDischargingInstructionsList(
        int index,
        com.cpdss.common.generated.discharge_plan.DischargingInstructions.Builder builderForValue) {
      if (dischargingInstructionsListBuilder_ == null) {
        ensureDischargingInstructionsListIsMutable();
        dischargingInstructionsList_.set(index, builderForValue.build());
        onChanged();
      } else {
        dischargingInstructionsListBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .DischargingInstructions dischargingInstructionsList = 6;</code> */
    public Builder addDischargingInstructionsList(
        com.cpdss.common.generated.discharge_plan.DischargingInstructions value) {
      if (dischargingInstructionsListBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDischargingInstructionsListIsMutable();
        dischargingInstructionsList_.add(value);
        onChanged();
      } else {
        dischargingInstructionsListBuilder_.addMessage(value);
      }
      return this;
    }
    /** <code>repeated .DischargingInstructions dischargingInstructionsList = 6;</code> */
    public Builder addDischargingInstructionsList(
        int index, com.cpdss.common.generated.discharge_plan.DischargingInstructions value) {
      if (dischargingInstructionsListBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDischargingInstructionsListIsMutable();
        dischargingInstructionsList_.add(index, value);
        onChanged();
      } else {
        dischargingInstructionsListBuilder_.addMessage(index, value);
      }
      return this;
    }
    /** <code>repeated .DischargingInstructions dischargingInstructionsList = 6;</code> */
    public Builder addDischargingInstructionsList(
        com.cpdss.common.generated.discharge_plan.DischargingInstructions.Builder builderForValue) {
      if (dischargingInstructionsListBuilder_ == null) {
        ensureDischargingInstructionsListIsMutable();
        dischargingInstructionsList_.add(builderForValue.build());
        onChanged();
      } else {
        dischargingInstructionsListBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .DischargingInstructions dischargingInstructionsList = 6;</code> */
    public Builder addDischargingInstructionsList(
        int index,
        com.cpdss.common.generated.discharge_plan.DischargingInstructions.Builder builderForValue) {
      if (dischargingInstructionsListBuilder_ == null) {
        ensureDischargingInstructionsListIsMutable();
        dischargingInstructionsList_.add(index, builderForValue.build());
        onChanged();
      } else {
        dischargingInstructionsListBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .DischargingInstructions dischargingInstructionsList = 6;</code> */
    public Builder addAllDischargingInstructionsList(
        java.lang.Iterable<
                ? extends com.cpdss.common.generated.discharge_plan.DischargingInstructions>
            values) {
      if (dischargingInstructionsListBuilder_ == null) {
        ensureDischargingInstructionsListIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, dischargingInstructionsList_);
        onChanged();
      } else {
        dischargingInstructionsListBuilder_.addAllMessages(values);
      }
      return this;
    }
    /** <code>repeated .DischargingInstructions dischargingInstructionsList = 6;</code> */
    public Builder clearDischargingInstructionsList() {
      if (dischargingInstructionsListBuilder_ == null) {
        dischargingInstructionsList_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        dischargingInstructionsListBuilder_.clear();
      }
      return this;
    }
    /** <code>repeated .DischargingInstructions dischargingInstructionsList = 6;</code> */
    public Builder removeDischargingInstructionsList(int index) {
      if (dischargingInstructionsListBuilder_ == null) {
        ensureDischargingInstructionsListIsMutable();
        dischargingInstructionsList_.remove(index);
        onChanged();
      } else {
        dischargingInstructionsListBuilder_.remove(index);
      }
      return this;
    }
    /** <code>repeated .DischargingInstructions dischargingInstructionsList = 6;</code> */
    public com.cpdss.common.generated.discharge_plan.DischargingInstructions.Builder
        getDischargingInstructionsListBuilder(int index) {
      return getDischargingInstructionsListFieldBuilder().getBuilder(index);
    }
    /** <code>repeated .DischargingInstructions dischargingInstructionsList = 6;</code> */
    public com.cpdss.common.generated.discharge_plan.DischargingInstructionsOrBuilder
        getDischargingInstructionsListOrBuilder(int index) {
      if (dischargingInstructionsListBuilder_ == null) {
        return dischargingInstructionsList_.get(index);
      } else {
        return dischargingInstructionsListBuilder_.getMessageOrBuilder(index);
      }
    }
    /** <code>repeated .DischargingInstructions dischargingInstructionsList = 6;</code> */
    public java.util.List<
            ? extends com.cpdss.common.generated.discharge_plan.DischargingInstructionsOrBuilder>
        getDischargingInstructionsListOrBuilderList() {
      if (dischargingInstructionsListBuilder_ != null) {
        return dischargingInstructionsListBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(dischargingInstructionsList_);
      }
    }
    /** <code>repeated .DischargingInstructions dischargingInstructionsList = 6;</code> */
    public com.cpdss.common.generated.discharge_plan.DischargingInstructions.Builder
        addDischargingInstructionsListBuilder() {
      return getDischargingInstructionsListFieldBuilder()
          .addBuilder(
              com.cpdss.common.generated.discharge_plan.DischargingInstructions
                  .getDefaultInstance());
    }
    /** <code>repeated .DischargingInstructions dischargingInstructionsList = 6;</code> */
    public com.cpdss.common.generated.discharge_plan.DischargingInstructions.Builder
        addDischargingInstructionsListBuilder(int index) {
      return getDischargingInstructionsListFieldBuilder()
          .addBuilder(
              index,
              com.cpdss.common.generated.discharge_plan.DischargingInstructions
                  .getDefaultInstance());
    }
    /** <code>repeated .DischargingInstructions dischargingInstructionsList = 6;</code> */
    public java.util.List<com.cpdss.common.generated.discharge_plan.DischargingInstructions.Builder>
        getDischargingInstructionsListBuilderList() {
      return getDischargingInstructionsListFieldBuilder().getBuilderList();
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.discharge_plan.DischargingInstructions,
            com.cpdss.common.generated.discharge_plan.DischargingInstructions.Builder,
            com.cpdss.common.generated.discharge_plan.DischargingInstructionsOrBuilder>
        getDischargingInstructionsListFieldBuilder() {
      if (dischargingInstructionsListBuilder_ == null) {
        dischargingInstructionsListBuilder_ =
            new com.google.protobuf.RepeatedFieldBuilderV3<
                com.cpdss.common.generated.discharge_plan.DischargingInstructions,
                com.cpdss.common.generated.discharge_plan.DischargingInstructions.Builder,
                com.cpdss.common.generated.discharge_plan.DischargingInstructionsOrBuilder>(
                dischargingInstructionsList_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        dischargingInstructionsList_ = null;
      }
      return dischargingInstructionsListBuilder_;
    }

    private boolean isEditable_;
    /**
     * <code>bool isEditable = 7;</code>
     *
     * @return The isEditable.
     */
    public boolean getIsEditable() {
      return isEditable_;
    }
    /**
     * <code>bool isEditable = 7;</code>
     *
     * @param value The isEditable to set.
     * @return This builder for chaining.
     */
    public Builder setIsEditable(boolean value) {

      isEditable_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool isEditable = 7;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearIsEditable() {

      isEditable_ = false;
      onChanged();
      return this;
    }

    private boolean isHeaderInstruction_;
    /**
     * <code>bool IsHeaderInstruction = 8;</code>
     *
     * @return The isHeaderInstruction.
     */
    public boolean getIsHeaderInstruction() {
      return isHeaderInstruction_;
    }
    /**
     * <code>bool IsHeaderInstruction = 8;</code>
     *
     * @param value The isHeaderInstruction to set.
     * @return This builder for chaining.
     */
    public Builder setIsHeaderInstruction(boolean value) {

      isHeaderInstruction_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool IsHeaderInstruction = 8;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearIsHeaderInstruction() {

      isHeaderInstruction_ = false;
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

    // @@protoc_insertion_point(builder_scope:DischargingInstructionSubHeader)
  }

  // @@protoc_insertion_point(class_scope:DischargingInstructionSubHeader)
  private static final com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader
      DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE =
        new com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader();
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader
      getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<DischargingInstructionSubHeader> PARSER =
      new com.google.protobuf.AbstractParser<DischargingInstructionSubHeader>() {
        @java.lang.Override
        public DischargingInstructionSubHeader parsePartialFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
          return new DischargingInstructionSubHeader(input, extensionRegistry);
        }
      };

  public static com.google.protobuf.Parser<DischargingInstructionSubHeader> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<DischargingInstructionSubHeader> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.cpdss.common.generated.discharge_plan.DischargingInstructionSubHeader
      getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
}
