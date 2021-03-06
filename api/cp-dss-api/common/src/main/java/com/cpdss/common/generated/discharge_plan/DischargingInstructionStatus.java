/* Licensed at AlphaOri Technologies */
package com.cpdss.common.generated.discharge_plan;

/** Protobuf type {@code DischargingInstructionStatus} */
public final class DischargingInstructionStatus extends com.google.protobuf.GeneratedMessageV3
    implements
    // @@protoc_insertion_point(message_implements:DischargingInstructionStatus)
    DischargingInstructionStatusOrBuilder {
  private static final long serialVersionUID = 0L;
  // Use DischargingInstructionStatus.newBuilder() to construct.
  private DischargingInstructionStatus(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }

  private DischargingInstructionStatus() {
    instruction_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
    return new DischargingInstructionStatus();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }

  private DischargingInstructionStatus(
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
          case 8:
            {
              instructionId_ = input.readInt64();
              break;
            }
          case 16:
            {
              isChecked_ = input.readBool();
              break;
            }
          case 26:
            {
              java.lang.String s = input.readStringRequireUtf8();

              instruction_ = s;
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
        .internal_static_DischargingInstructionStatus_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.cpdss.common.generated.discharge_plan.DischargePlanModels
        .internal_static_DischargingInstructionStatus_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus.class,
            com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus.Builder.class);
  }

  public static final int INSTRUCTIONID_FIELD_NUMBER = 1;
  private long instructionId_;
  /**
   * <code>int64 instructionId = 1;</code>
   *
   * @return The instructionId.
   */
  public long getInstructionId() {
    return instructionId_;
  }

  public static final int ISCHECKED_FIELD_NUMBER = 2;
  private boolean isChecked_;
  /**
   * <code>bool isChecked = 2;</code>
   *
   * @return The isChecked.
   */
  public boolean getIsChecked() {
    return isChecked_;
  }

  public static final int INSTRUCTION_FIELD_NUMBER = 3;
  private volatile java.lang.Object instruction_;
  /**
   * <code>string instruction = 3;</code>
   *
   * @return The instruction.
   */
  public java.lang.String getInstruction() {
    java.lang.Object ref = instruction_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      instruction_ = s;
      return s;
    }
  }
  /**
   * <code>string instruction = 3;</code>
   *
   * @return The bytes for instruction.
   */
  public com.google.protobuf.ByteString getInstructionBytes() {
    java.lang.Object ref = instruction_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
      instruction_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
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
    if (instructionId_ != 0L) {
      output.writeInt64(1, instructionId_);
    }
    if (isChecked_ != false) {
      output.writeBool(2, isChecked_);
    }
    if (!getInstructionBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, instruction_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (instructionId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream.computeInt64Size(1, instructionId_);
    }
    if (isChecked_ != false) {
      size += com.google.protobuf.CodedOutputStream.computeBoolSize(2, isChecked_);
    }
    if (!getInstructionBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, instruction_);
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
    if (!(obj instanceof com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus)) {
      return super.equals(obj);
    }
    com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus other =
        (com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus) obj;

    if (getInstructionId() != other.getInstructionId()) return false;
    if (getIsChecked() != other.getIsChecked()) return false;
    if (!getInstruction().equals(other.getInstruction())) return false;
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
    hash = (37 * hash) + INSTRUCTIONID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getInstructionId());
    hash = (37 * hash) + ISCHECKED_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(getIsChecked());
    hash = (37 * hash) + INSTRUCTION_FIELD_NUMBER;
    hash = (53 * hash) + getInstruction().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus parseFrom(
      java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus parseFrom(
      java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus parseFrom(
      byte[] data) throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus parseFrom(
      byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus parseFrom(
      java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus parseFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus
      parseDelimitedFrom(java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus
      parseDelimitedFrom(
          java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus parseFrom(
      com.google.protobuf.CodedInputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus parseFrom(
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
      com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus prototype) {
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
  /** Protobuf type {@code DischargingInstructionStatus} */
  public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
      implements
      // @@protoc_insertion_point(builder_implements:DischargingInstructionStatus)
      com.cpdss.common.generated.discharge_plan.DischargingInstructionStatusOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanModels
          .internal_static_DischargingInstructionStatus_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanModels
          .internal_static_DischargingInstructionStatus_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus.class,
              com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus.Builder.class);
    }

    // Construct using
    // com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus.newBuilder()
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
      instructionId_ = 0L;

      isChecked_ = false;

      instruction_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanModels
          .internal_static_DischargingInstructionStatus_descriptor;
    }

    @java.lang.Override
    public com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus
        getDefaultInstanceForType() {
      return com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus
          .getDefaultInstance();
    }

    @java.lang.Override
    public com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus build() {
      com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus result =
          buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus buildPartial() {
      com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus result =
          new com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus(this);
      result.instructionId_ = instructionId_;
      result.isChecked_ = isChecked_;
      result.instruction_ = instruction_;
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
      if (other instanceof com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus) {
        return mergeFrom(
            (com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus) other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(
        com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus other) {
      if (other
          == com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus
              .getDefaultInstance()) return this;
      if (other.getInstructionId() != 0L) {
        setInstructionId(other.getInstructionId());
      }
      if (other.getIsChecked() != false) {
        setIsChecked(other.getIsChecked());
      }
      if (!other.getInstruction().isEmpty()) {
        instruction_ = other.instruction_;
        onChanged();
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
      com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage =
            (com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus)
                e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private long instructionId_;
    /**
     * <code>int64 instructionId = 1;</code>
     *
     * @return The instructionId.
     */
    public long getInstructionId() {
      return instructionId_;
    }
    /**
     * <code>int64 instructionId = 1;</code>
     *
     * @param value The instructionId to set.
     * @return This builder for chaining.
     */
    public Builder setInstructionId(long value) {

      instructionId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 instructionId = 1;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearInstructionId() {

      instructionId_ = 0L;
      onChanged();
      return this;
    }

    private boolean isChecked_;
    /**
     * <code>bool isChecked = 2;</code>
     *
     * @return The isChecked.
     */
    public boolean getIsChecked() {
      return isChecked_;
    }
    /**
     * <code>bool isChecked = 2;</code>
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
     * <code>bool isChecked = 2;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearIsChecked() {

      isChecked_ = false;
      onChanged();
      return this;
    }

    private java.lang.Object instruction_ = "";
    /**
     * <code>string instruction = 3;</code>
     *
     * @return The instruction.
     */
    public java.lang.String getInstruction() {
      java.lang.Object ref = instruction_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        instruction_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string instruction = 3;</code>
     *
     * @return The bytes for instruction.
     */
    public com.google.protobuf.ByteString getInstructionBytes() {
      java.lang.Object ref = instruction_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        instruction_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string instruction = 3;</code>
     *
     * @param value The instruction to set.
     * @return This builder for chaining.
     */
    public Builder setInstruction(java.lang.String value) {
      if (value == null) {
        throw new NullPointerException();
      }

      instruction_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string instruction = 3;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearInstruction() {

      instruction_ = getDefaultInstance().getInstruction();
      onChanged();
      return this;
    }
    /**
     * <code>string instruction = 3;</code>
     *
     * @param value The bytes for instruction to set.
     * @return This builder for chaining.
     */
    public Builder setInstructionBytes(com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      checkByteStringIsUtf8(value);

      instruction_ = value;
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

    // @@protoc_insertion_point(builder_scope:DischargingInstructionStatus)
  }

  // @@protoc_insertion_point(class_scope:DischargingInstructionStatus)
  private static final com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus
      DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus();
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus
      getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<DischargingInstructionStatus> PARSER =
      new com.google.protobuf.AbstractParser<DischargingInstructionStatus>() {
        @java.lang.Override
        public DischargingInstructionStatus parsePartialFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
          return new DischargingInstructionStatus(input, extensionRegistry);
        }
      };

  public static com.google.protobuf.Parser<DischargingInstructionStatus> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<DischargingInstructionStatus> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.cpdss.common.generated.discharge_plan.DischargingInstructionStatus
      getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
}
