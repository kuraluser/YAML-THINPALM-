/* Licensed at AlphaOri Technologies */
package com.cpdss.common.generated.discharge_plan;

/** Protobuf type {@code DischargingInstructionsSave} */
public final class DischargingInstructionsSave extends com.google.protobuf.GeneratedMessageV3
    implements
    // @@protoc_insertion_point(message_implements:DischargingInstructionsSave)
    DischargingInstructionsSaveOrBuilder {
  private static final long serialVersionUID = 0L;
  // Use DischargingInstructionsSave.newBuilder() to construct.
  private DischargingInstructionsSave(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }

  private DischargingInstructionsSave() {
    instruction_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
    return new DischargingInstructionsSave();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }

  private DischargingInstructionsSave(
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
              headerId_ = input.readInt64();
              break;
            }
          case 16:
            {
              instructionTypeId_ = input.readInt64();
              break;
            }
          case 24:
            {
              isChecked_ = input.readBool();
              break;
            }
          case 32:
            {
              isSingleHeader_ = input.readBool();
              break;
            }
          case 40:
            {
              subHeaderId_ = input.readInt64();
              break;
            }
          case 50:
            {
              java.lang.String s = input.readStringRequireUtf8();

              instruction_ = s;
              break;
            }
          case 56:
            {
              isSubHeader_ = input.readBool();
              break;
            }
          case 64:
            {
              dischargingInfoId_ = input.readInt64();
              break;
            }
          case 72:
            {
              vesselId_ = input.readInt64();
              break;
            }
          case 80:
            {
              portRotationId_ = input.readInt64();
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
        .internal_static_DischargingInstructionsSave_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.cpdss.common.generated.discharge_plan.DischargePlanModels
        .internal_static_DischargingInstructionsSave_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.cpdss.common.generated.discharge_plan.DischargingInstructionsSave.class,
            com.cpdss.common.generated.discharge_plan.DischargingInstructionsSave.Builder.class);
  }

  public static final int HEADERID_FIELD_NUMBER = 1;
  private long headerId_;
  /**
   * <code>int64 headerId = 1;</code>
   *
   * @return The headerId.
   */
  public long getHeaderId() {
    return headerId_;
  }

  public static final int INSTRUCTIONTYPEID_FIELD_NUMBER = 2;
  private long instructionTypeId_;
  /**
   * <code>int64 instructionTypeId = 2;</code>
   *
   * @return The instructionTypeId.
   */
  public long getInstructionTypeId() {
    return instructionTypeId_;
  }

  public static final int ISCHECKED_FIELD_NUMBER = 3;
  private boolean isChecked_;
  /**
   * <code>bool isChecked = 3;</code>
   *
   * @return The isChecked.
   */
  public boolean getIsChecked() {
    return isChecked_;
  }

  public static final int ISSINGLEHEADER_FIELD_NUMBER = 4;
  private boolean isSingleHeader_;
  /**
   * <code>bool isSingleHeader = 4;</code>
   *
   * @return The isSingleHeader.
   */
  public boolean getIsSingleHeader() {
    return isSingleHeader_;
  }

  public static final int SUBHEADERID_FIELD_NUMBER = 5;
  private long subHeaderId_;
  /**
   * <code>int64 subHeaderId = 5;</code>
   *
   * @return The subHeaderId.
   */
  public long getSubHeaderId() {
    return subHeaderId_;
  }

  public static final int INSTRUCTION_FIELD_NUMBER = 6;
  private volatile java.lang.Object instruction_;
  /**
   * <code>string instruction = 6;</code>
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
   * <code>string instruction = 6;</code>
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

  public static final int ISSUBHEADER_FIELD_NUMBER = 7;
  private boolean isSubHeader_;
  /**
   * <code>bool isSubHeader = 7;</code>
   *
   * @return The isSubHeader.
   */
  public boolean getIsSubHeader() {
    return isSubHeader_;
  }

  public static final int DISCHARGINGINFOID_FIELD_NUMBER = 8;
  private long dischargingInfoId_;
  /**
   * <code>int64 dischargingInfoId = 8;</code>
   *
   * @return The dischargingInfoId.
   */
  public long getDischargingInfoId() {
    return dischargingInfoId_;
  }

  public static final int VESSELID_FIELD_NUMBER = 9;
  private long vesselId_;
  /**
   * <code>int64 vesselId = 9;</code>
   *
   * @return The vesselId.
   */
  public long getVesselId() {
    return vesselId_;
  }

  public static final int PORTROTATIONID_FIELD_NUMBER = 10;
  private long portRotationId_;
  /**
   * <code>int64 portRotationId = 10;</code>
   *
   * @return The portRotationId.
   */
  public long getPortRotationId() {
    return portRotationId_;
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
    if (headerId_ != 0L) {
      output.writeInt64(1, headerId_);
    }
    if (instructionTypeId_ != 0L) {
      output.writeInt64(2, instructionTypeId_);
    }
    if (isChecked_ != false) {
      output.writeBool(3, isChecked_);
    }
    if (isSingleHeader_ != false) {
      output.writeBool(4, isSingleHeader_);
    }
    if (subHeaderId_ != 0L) {
      output.writeInt64(5, subHeaderId_);
    }
    if (!getInstructionBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 6, instruction_);
    }
    if (isSubHeader_ != false) {
      output.writeBool(7, isSubHeader_);
    }
    if (dischargingInfoId_ != 0L) {
      output.writeInt64(8, dischargingInfoId_);
    }
    if (vesselId_ != 0L) {
      output.writeInt64(9, vesselId_);
    }
    if (portRotationId_ != 0L) {
      output.writeInt64(10, portRotationId_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (headerId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream.computeInt64Size(1, headerId_);
    }
    if (instructionTypeId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream.computeInt64Size(2, instructionTypeId_);
    }
    if (isChecked_ != false) {
      size += com.google.protobuf.CodedOutputStream.computeBoolSize(3, isChecked_);
    }
    if (isSingleHeader_ != false) {
      size += com.google.protobuf.CodedOutputStream.computeBoolSize(4, isSingleHeader_);
    }
    if (subHeaderId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream.computeInt64Size(5, subHeaderId_);
    }
    if (!getInstructionBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(6, instruction_);
    }
    if (isSubHeader_ != false) {
      size += com.google.protobuf.CodedOutputStream.computeBoolSize(7, isSubHeader_);
    }
    if (dischargingInfoId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream.computeInt64Size(8, dischargingInfoId_);
    }
    if (vesselId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream.computeInt64Size(9, vesselId_);
    }
    if (portRotationId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream.computeInt64Size(10, portRotationId_);
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
    if (!(obj instanceof com.cpdss.common.generated.discharge_plan.DischargingInstructionsSave)) {
      return super.equals(obj);
    }
    com.cpdss.common.generated.discharge_plan.DischargingInstructionsSave other =
        (com.cpdss.common.generated.discharge_plan.DischargingInstructionsSave) obj;

    if (getHeaderId() != other.getHeaderId()) return false;
    if (getInstructionTypeId() != other.getInstructionTypeId()) return false;
    if (getIsChecked() != other.getIsChecked()) return false;
    if (getIsSingleHeader() != other.getIsSingleHeader()) return false;
    if (getSubHeaderId() != other.getSubHeaderId()) return false;
    if (!getInstruction().equals(other.getInstruction())) return false;
    if (getIsSubHeader() != other.getIsSubHeader()) return false;
    if (getDischargingInfoId() != other.getDischargingInfoId()) return false;
    if (getVesselId() != other.getVesselId()) return false;
    if (getPortRotationId() != other.getPortRotationId()) return false;
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
    hash = (37 * hash) + HEADERID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getHeaderId());
    hash = (37 * hash) + INSTRUCTIONTYPEID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getInstructionTypeId());
    hash = (37 * hash) + ISCHECKED_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(getIsChecked());
    hash = (37 * hash) + ISSINGLEHEADER_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(getIsSingleHeader());
    hash = (37 * hash) + SUBHEADERID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getSubHeaderId());
    hash = (37 * hash) + INSTRUCTION_FIELD_NUMBER;
    hash = (53 * hash) + getInstruction().hashCode();
    hash = (37 * hash) + ISSUBHEADER_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(getIsSubHeader());
    hash = (37 * hash) + DISCHARGINGINFOID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getDischargingInfoId());
    hash = (37 * hash) + VESSELID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getVesselId());
    hash = (37 * hash) + PORTROTATIONID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getPortRotationId());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionsSave parseFrom(
      java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionsSave parseFrom(
      java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionsSave parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionsSave parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionsSave parseFrom(
      byte[] data) throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionsSave parseFrom(
      byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionsSave parseFrom(
      java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionsSave parseFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionsSave
      parseDelimitedFrom(java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionsSave
      parseDelimitedFrom(
          java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionsSave parseFrom(
      com.google.protobuf.CodedInputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionsSave parseFrom(
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
      com.cpdss.common.generated.discharge_plan.DischargingInstructionsSave prototype) {
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
  /** Protobuf type {@code DischargingInstructionsSave} */
  public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
      implements
      // @@protoc_insertion_point(builder_implements:DischargingInstructionsSave)
      com.cpdss.common.generated.discharge_plan.DischargingInstructionsSaveOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanModels
          .internal_static_DischargingInstructionsSave_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanModels
          .internal_static_DischargingInstructionsSave_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.discharge_plan.DischargingInstructionsSave.class,
              com.cpdss.common.generated.discharge_plan.DischargingInstructionsSave.Builder.class);
    }

    // Construct using
    // com.cpdss.common.generated.discharge_plan.DischargingInstructionsSave.newBuilder()
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
      headerId_ = 0L;

      instructionTypeId_ = 0L;

      isChecked_ = false;

      isSingleHeader_ = false;

      subHeaderId_ = 0L;

      instruction_ = "";

      isSubHeader_ = false;

      dischargingInfoId_ = 0L;

      vesselId_ = 0L;

      portRotationId_ = 0L;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanModels
          .internal_static_DischargingInstructionsSave_descriptor;
    }

    @java.lang.Override
    public com.cpdss.common.generated.discharge_plan.DischargingInstructionsSave
        getDefaultInstanceForType() {
      return com.cpdss.common.generated.discharge_plan.DischargingInstructionsSave
          .getDefaultInstance();
    }

    @java.lang.Override
    public com.cpdss.common.generated.discharge_plan.DischargingInstructionsSave build() {
      com.cpdss.common.generated.discharge_plan.DischargingInstructionsSave result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.cpdss.common.generated.discharge_plan.DischargingInstructionsSave buildPartial() {
      com.cpdss.common.generated.discharge_plan.DischargingInstructionsSave result =
          new com.cpdss.common.generated.discharge_plan.DischargingInstructionsSave(this);
      result.headerId_ = headerId_;
      result.instructionTypeId_ = instructionTypeId_;
      result.isChecked_ = isChecked_;
      result.isSingleHeader_ = isSingleHeader_;
      result.subHeaderId_ = subHeaderId_;
      result.instruction_ = instruction_;
      result.isSubHeader_ = isSubHeader_;
      result.dischargingInfoId_ = dischargingInfoId_;
      result.vesselId_ = vesselId_;
      result.portRotationId_ = portRotationId_;
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
      if (other instanceof com.cpdss.common.generated.discharge_plan.DischargingInstructionsSave) {
        return mergeFrom(
            (com.cpdss.common.generated.discharge_plan.DischargingInstructionsSave) other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(
        com.cpdss.common.generated.discharge_plan.DischargingInstructionsSave other) {
      if (other
          == com.cpdss.common.generated.discharge_plan.DischargingInstructionsSave
              .getDefaultInstance()) return this;
      if (other.getHeaderId() != 0L) {
        setHeaderId(other.getHeaderId());
      }
      if (other.getInstructionTypeId() != 0L) {
        setInstructionTypeId(other.getInstructionTypeId());
      }
      if (other.getIsChecked() != false) {
        setIsChecked(other.getIsChecked());
      }
      if (other.getIsSingleHeader() != false) {
        setIsSingleHeader(other.getIsSingleHeader());
      }
      if (other.getSubHeaderId() != 0L) {
        setSubHeaderId(other.getSubHeaderId());
      }
      if (!other.getInstruction().isEmpty()) {
        instruction_ = other.instruction_;
        onChanged();
      }
      if (other.getIsSubHeader() != false) {
        setIsSubHeader(other.getIsSubHeader());
      }
      if (other.getDischargingInfoId() != 0L) {
        setDischargingInfoId(other.getDischargingInfoId());
      }
      if (other.getVesselId() != 0L) {
        setVesselId(other.getVesselId());
      }
      if (other.getPortRotationId() != 0L) {
        setPortRotationId(other.getPortRotationId());
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
      com.cpdss.common.generated.discharge_plan.DischargingInstructionsSave parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage =
            (com.cpdss.common.generated.discharge_plan.DischargingInstructionsSave)
                e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private long headerId_;
    /**
     * <code>int64 headerId = 1;</code>
     *
     * @return The headerId.
     */
    public long getHeaderId() {
      return headerId_;
    }
    /**
     * <code>int64 headerId = 1;</code>
     *
     * @param value The headerId to set.
     * @return This builder for chaining.
     */
    public Builder setHeaderId(long value) {

      headerId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 headerId = 1;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearHeaderId() {

      headerId_ = 0L;
      onChanged();
      return this;
    }

    private long instructionTypeId_;
    /**
     * <code>int64 instructionTypeId = 2;</code>
     *
     * @return The instructionTypeId.
     */
    public long getInstructionTypeId() {
      return instructionTypeId_;
    }
    /**
     * <code>int64 instructionTypeId = 2;</code>
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
     * <code>int64 instructionTypeId = 2;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearInstructionTypeId() {

      instructionTypeId_ = 0L;
      onChanged();
      return this;
    }

    private boolean isChecked_;
    /**
     * <code>bool isChecked = 3;</code>
     *
     * @return The isChecked.
     */
    public boolean getIsChecked() {
      return isChecked_;
    }
    /**
     * <code>bool isChecked = 3;</code>
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
     * <code>bool isChecked = 3;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearIsChecked() {

      isChecked_ = false;
      onChanged();
      return this;
    }

    private boolean isSingleHeader_;
    /**
     * <code>bool isSingleHeader = 4;</code>
     *
     * @return The isSingleHeader.
     */
    public boolean getIsSingleHeader() {
      return isSingleHeader_;
    }
    /**
     * <code>bool isSingleHeader = 4;</code>
     *
     * @param value The isSingleHeader to set.
     * @return This builder for chaining.
     */
    public Builder setIsSingleHeader(boolean value) {

      isSingleHeader_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool isSingleHeader = 4;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearIsSingleHeader() {

      isSingleHeader_ = false;
      onChanged();
      return this;
    }

    private long subHeaderId_;
    /**
     * <code>int64 subHeaderId = 5;</code>
     *
     * @return The subHeaderId.
     */
    public long getSubHeaderId() {
      return subHeaderId_;
    }
    /**
     * <code>int64 subHeaderId = 5;</code>
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
     * <code>int64 subHeaderId = 5;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearSubHeaderId() {

      subHeaderId_ = 0L;
      onChanged();
      return this;
    }

    private java.lang.Object instruction_ = "";
    /**
     * <code>string instruction = 6;</code>
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
     * <code>string instruction = 6;</code>
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
     * <code>string instruction = 6;</code>
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
     * <code>string instruction = 6;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearInstruction() {

      instruction_ = getDefaultInstance().getInstruction();
      onChanged();
      return this;
    }
    /**
     * <code>string instruction = 6;</code>
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

    private boolean isSubHeader_;
    /**
     * <code>bool isSubHeader = 7;</code>
     *
     * @return The isSubHeader.
     */
    public boolean getIsSubHeader() {
      return isSubHeader_;
    }
    /**
     * <code>bool isSubHeader = 7;</code>
     *
     * @param value The isSubHeader to set.
     * @return This builder for chaining.
     */
    public Builder setIsSubHeader(boolean value) {

      isSubHeader_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool isSubHeader = 7;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearIsSubHeader() {

      isSubHeader_ = false;
      onChanged();
      return this;
    }

    private long dischargingInfoId_;
    /**
     * <code>int64 dischargingInfoId = 8;</code>
     *
     * @return The dischargingInfoId.
     */
    public long getDischargingInfoId() {
      return dischargingInfoId_;
    }
    /**
     * <code>int64 dischargingInfoId = 8;</code>
     *
     * @param value The dischargingInfoId to set.
     * @return This builder for chaining.
     */
    public Builder setDischargingInfoId(long value) {

      dischargingInfoId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 dischargingInfoId = 8;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearDischargingInfoId() {

      dischargingInfoId_ = 0L;
      onChanged();
      return this;
    }

    private long vesselId_;
    /**
     * <code>int64 vesselId = 9;</code>
     *
     * @return The vesselId.
     */
    public long getVesselId() {
      return vesselId_;
    }
    /**
     * <code>int64 vesselId = 9;</code>
     *
     * @param value The vesselId to set.
     * @return This builder for chaining.
     */
    public Builder setVesselId(long value) {

      vesselId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 vesselId = 9;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearVesselId() {

      vesselId_ = 0L;
      onChanged();
      return this;
    }

    private long portRotationId_;
    /**
     * <code>int64 portRotationId = 10;</code>
     *
     * @return The portRotationId.
     */
    public long getPortRotationId() {
      return portRotationId_;
    }
    /**
     * <code>int64 portRotationId = 10;</code>
     *
     * @param value The portRotationId to set.
     * @return This builder for chaining.
     */
    public Builder setPortRotationId(long value) {

      portRotationId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 portRotationId = 10;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearPortRotationId() {

      portRotationId_ = 0L;
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

    // @@protoc_insertion_point(builder_scope:DischargingInstructionsSave)
  }

  // @@protoc_insertion_point(class_scope:DischargingInstructionsSave)
  private static final com.cpdss.common.generated.discharge_plan.DischargingInstructionsSave
      DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new com.cpdss.common.generated.discharge_plan.DischargingInstructionsSave();
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingInstructionsSave
      getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<DischargingInstructionsSave> PARSER =
      new com.google.protobuf.AbstractParser<DischargingInstructionsSave>() {
        @java.lang.Override
        public DischargingInstructionsSave parsePartialFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
          return new DischargingInstructionsSave(input, extensionRegistry);
        }
      };

  public static com.google.protobuf.Parser<DischargingInstructionsSave> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<DischargingInstructionsSave> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.cpdss.common.generated.discharge_plan.DischargingInstructionsSave
      getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
}
