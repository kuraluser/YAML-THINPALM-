/* Licensed at AlphaOri Technologies */
package com.cpdss.common.generated.discharge_plan;

/** Protobuf type {@code DSCowDetails} */
public final class DSCowDetails extends com.google.protobuf.GeneratedMessageV3
    implements
    // @@protoc_insertion_point(message_implements:DSCowDetails)
    DSCowDetailsOrBuilder {
  private static final long serialVersionUID = 0L;
  // Use DSCowDetails.newBuilder() to construct.
  private DSCowDetails(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }

  private DSCowDetails() {
    cowOptionType_ = 0;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
    return new DSCowDetails();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }

  private DSCowDetails(
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
              com.cpdss.common.generated.discharge_plan.CowTankDetails.Builder subBuilder = null;
              if (cowTankDetails_ != null) {
                subBuilder = cowTankDetails_.toBuilder();
              }
              cowTankDetails_ =
                  input.readMessage(
                      com.cpdss.common.generated.discharge_plan.CowTankDetails.parser(),
                      extensionRegistry);
              if (subBuilder != null) {
                subBuilder.mergeFrom(cowTankDetails_);
                cowTankDetails_ = subBuilder.buildPartial();
              }

              break;
            }
          case 16:
            {
              dischargeStudyId_ = input.readInt64();
              break;
            }
          case 37:
            {
              percent_ = input.readFloat();
              break;
            }
          case 40:
            {
              int rawValue = input.readEnum();

              cowOptionType_ = rawValue;
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
        .internal_static_DSCowDetails_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.cpdss.common.generated.discharge_plan.DischargePlanModels
        .internal_static_DSCowDetails_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.cpdss.common.generated.discharge_plan.DSCowDetails.class,
            com.cpdss.common.generated.discharge_plan.DSCowDetails.Builder.class);
  }

  public static final int COWTANKDETAILS_FIELD_NUMBER = 1;
  private com.cpdss.common.generated.discharge_plan.CowTankDetails cowTankDetails_;
  /**
   * <code>.CowTankDetails cowTankDetails = 1;</code>
   *
   * @return Whether the cowTankDetails field is set.
   */
  public boolean hasCowTankDetails() {
    return cowTankDetails_ != null;
  }
  /**
   * <code>.CowTankDetails cowTankDetails = 1;</code>
   *
   * @return The cowTankDetails.
   */
  public com.cpdss.common.generated.discharge_plan.CowTankDetails getCowTankDetails() {
    return cowTankDetails_ == null
        ? com.cpdss.common.generated.discharge_plan.CowTankDetails.getDefaultInstance()
        : cowTankDetails_;
  }
  /** <code>.CowTankDetails cowTankDetails = 1;</code> */
  public com.cpdss.common.generated.discharge_plan.CowTankDetailsOrBuilder
      getCowTankDetailsOrBuilder() {
    return getCowTankDetails();
  }

  public static final int DISCHARGESTUDYID_FIELD_NUMBER = 2;
  private long dischargeStudyId_;
  /**
   * <code>int64 dischargeStudyId = 2;</code>
   *
   * @return The dischargeStudyId.
   */
  public long getDischargeStudyId() {
    return dischargeStudyId_;
  }

  public static final int PERCENT_FIELD_NUMBER = 4;
  private float percent_;
  /**
   * <code>float percent = 4;</code>
   *
   * @return The percent.
   */
  public float getPercent() {
    return percent_;
  }

  public static final int COWOPTIONTYPE_FIELD_NUMBER = 5;
  private int cowOptionType_;
  /**
   * <code>.COW_OPTION_TYPE cowOptionType = 5;</code>
   *
   * @return The enum numeric value on the wire for cowOptionType.
   */
  public int getCowOptionTypeValue() {
    return cowOptionType_;
  }
  /**
   * <code>.COW_OPTION_TYPE cowOptionType = 5;</code>
   *
   * @return The cowOptionType.
   */
  public com.cpdss.common.generated.Common.COW_OPTION_TYPE getCowOptionType() {
    @SuppressWarnings("deprecation")
    com.cpdss.common.generated.Common.COW_OPTION_TYPE result =
        com.cpdss.common.generated.Common.COW_OPTION_TYPE.valueOf(cowOptionType_);
    return result == null ? com.cpdss.common.generated.Common.COW_OPTION_TYPE.UNRECOGNIZED : result;
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
    if (cowTankDetails_ != null) {
      output.writeMessage(1, getCowTankDetails());
    }
    if (dischargeStudyId_ != 0L) {
      output.writeInt64(2, dischargeStudyId_);
    }
    if (percent_ != 0F) {
      output.writeFloat(4, percent_);
    }
    if (cowOptionType_
        != com.cpdss.common.generated.Common.COW_OPTION_TYPE.EMPTY_COW_OPTION_TYPE.getNumber()) {
      output.writeEnum(5, cowOptionType_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (cowTankDetails_ != null) {
      size += com.google.protobuf.CodedOutputStream.computeMessageSize(1, getCowTankDetails());
    }
    if (dischargeStudyId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream.computeInt64Size(2, dischargeStudyId_);
    }
    if (percent_ != 0F) {
      size += com.google.protobuf.CodedOutputStream.computeFloatSize(4, percent_);
    }
    if (cowOptionType_
        != com.cpdss.common.generated.Common.COW_OPTION_TYPE.EMPTY_COW_OPTION_TYPE.getNumber()) {
      size += com.google.protobuf.CodedOutputStream.computeEnumSize(5, cowOptionType_);
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
    if (!(obj instanceof com.cpdss.common.generated.discharge_plan.DSCowDetails)) {
      return super.equals(obj);
    }
    com.cpdss.common.generated.discharge_plan.DSCowDetails other =
        (com.cpdss.common.generated.discharge_plan.DSCowDetails) obj;

    if (hasCowTankDetails() != other.hasCowTankDetails()) return false;
    if (hasCowTankDetails()) {
      if (!getCowTankDetails().equals(other.getCowTankDetails())) return false;
    }
    if (getDischargeStudyId() != other.getDischargeStudyId()) return false;
    if (java.lang.Float.floatToIntBits(getPercent())
        != java.lang.Float.floatToIntBits(other.getPercent())) return false;
    if (cowOptionType_ != other.cowOptionType_) return false;
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
    if (hasCowTankDetails()) {
      hash = (37 * hash) + COWTANKDETAILS_FIELD_NUMBER;
      hash = (53 * hash) + getCowTankDetails().hashCode();
    }
    hash = (37 * hash) + DISCHARGESTUDYID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getDischargeStudyId());
    hash = (37 * hash) + PERCENT_FIELD_NUMBER;
    hash = (53 * hash) + java.lang.Float.floatToIntBits(getPercent());
    hash = (37 * hash) + COWOPTIONTYPE_FIELD_NUMBER;
    hash = (53 * hash) + cowOptionType_;
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.cpdss.common.generated.discharge_plan.DSCowDetails parseFrom(
      java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.cpdss.common.generated.discharge_plan.DSCowDetails parseFrom(
      java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DSCowDetails parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.cpdss.common.generated.discharge_plan.DSCowDetails parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DSCowDetails parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.cpdss.common.generated.discharge_plan.DSCowDetails parseFrom(
      byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DSCowDetails parseFrom(
      java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.cpdss.common.generated.discharge_plan.DSCowDetails parseFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DSCowDetails parseDelimitedFrom(
      java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
  }

  public static com.cpdss.common.generated.discharge_plan.DSCowDetails parseDelimitedFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DSCowDetails parseFrom(
      com.google.protobuf.CodedInputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.cpdss.common.generated.discharge_plan.DSCowDetails parseFrom(
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
      com.cpdss.common.generated.discharge_plan.DSCowDetails prototype) {
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
  /** Protobuf type {@code DSCowDetails} */
  public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
      implements
      // @@protoc_insertion_point(builder_implements:DSCowDetails)
      com.cpdss.common.generated.discharge_plan.DSCowDetailsOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanModels
          .internal_static_DSCowDetails_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanModels
          .internal_static_DSCowDetails_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.discharge_plan.DSCowDetails.class,
              com.cpdss.common.generated.discharge_plan.DSCowDetails.Builder.class);
    }

    // Construct using com.cpdss.common.generated.discharge_plan.DSCowDetails.newBuilder()
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
      if (cowTankDetailsBuilder_ == null) {
        cowTankDetails_ = null;
      } else {
        cowTankDetails_ = null;
        cowTankDetailsBuilder_ = null;
      }
      dischargeStudyId_ = 0L;

      percent_ = 0F;

      cowOptionType_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanModels
          .internal_static_DSCowDetails_descriptor;
    }

    @java.lang.Override
    public com.cpdss.common.generated.discharge_plan.DSCowDetails getDefaultInstanceForType() {
      return com.cpdss.common.generated.discharge_plan.DSCowDetails.getDefaultInstance();
    }

    @java.lang.Override
    public com.cpdss.common.generated.discharge_plan.DSCowDetails build() {
      com.cpdss.common.generated.discharge_plan.DSCowDetails result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.cpdss.common.generated.discharge_plan.DSCowDetails buildPartial() {
      com.cpdss.common.generated.discharge_plan.DSCowDetails result =
          new com.cpdss.common.generated.discharge_plan.DSCowDetails(this);
      if (cowTankDetailsBuilder_ == null) {
        result.cowTankDetails_ = cowTankDetails_;
      } else {
        result.cowTankDetails_ = cowTankDetailsBuilder_.build();
      }
      result.dischargeStudyId_ = dischargeStudyId_;
      result.percent_ = percent_;
      result.cowOptionType_ = cowOptionType_;
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
      if (other instanceof com.cpdss.common.generated.discharge_plan.DSCowDetails) {
        return mergeFrom((com.cpdss.common.generated.discharge_plan.DSCowDetails) other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.cpdss.common.generated.discharge_plan.DSCowDetails other) {
      if (other == com.cpdss.common.generated.discharge_plan.DSCowDetails.getDefaultInstance())
        return this;
      if (other.hasCowTankDetails()) {
        mergeCowTankDetails(other.getCowTankDetails());
      }
      if (other.getDischargeStudyId() != 0L) {
        setDischargeStudyId(other.getDischargeStudyId());
      }
      if (other.getPercent() != 0F) {
        setPercent(other.getPercent());
      }
      if (other.cowOptionType_ != 0) {
        setCowOptionTypeValue(other.getCowOptionTypeValue());
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
      com.cpdss.common.generated.discharge_plan.DSCowDetails parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage =
            (com.cpdss.common.generated.discharge_plan.DSCowDetails) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private com.cpdss.common.generated.discharge_plan.CowTankDetails cowTankDetails_;
    private com.google.protobuf.SingleFieldBuilderV3<
            com.cpdss.common.generated.discharge_plan.CowTankDetails,
            com.cpdss.common.generated.discharge_plan.CowTankDetails.Builder,
            com.cpdss.common.generated.discharge_plan.CowTankDetailsOrBuilder>
        cowTankDetailsBuilder_;
    /**
     * <code>.CowTankDetails cowTankDetails = 1;</code>
     *
     * @return Whether the cowTankDetails field is set.
     */
    public boolean hasCowTankDetails() {
      return cowTankDetailsBuilder_ != null || cowTankDetails_ != null;
    }
    /**
     * <code>.CowTankDetails cowTankDetails = 1;</code>
     *
     * @return The cowTankDetails.
     */
    public com.cpdss.common.generated.discharge_plan.CowTankDetails getCowTankDetails() {
      if (cowTankDetailsBuilder_ == null) {
        return cowTankDetails_ == null
            ? com.cpdss.common.generated.discharge_plan.CowTankDetails.getDefaultInstance()
            : cowTankDetails_;
      } else {
        return cowTankDetailsBuilder_.getMessage();
      }
    }
    /** <code>.CowTankDetails cowTankDetails = 1;</code> */
    public Builder setCowTankDetails(
        com.cpdss.common.generated.discharge_plan.CowTankDetails value) {
      if (cowTankDetailsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        cowTankDetails_ = value;
        onChanged();
      } else {
        cowTankDetailsBuilder_.setMessage(value);
      }

      return this;
    }
    /** <code>.CowTankDetails cowTankDetails = 1;</code> */
    public Builder setCowTankDetails(
        com.cpdss.common.generated.discharge_plan.CowTankDetails.Builder builderForValue) {
      if (cowTankDetailsBuilder_ == null) {
        cowTankDetails_ = builderForValue.build();
        onChanged();
      } else {
        cowTankDetailsBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /** <code>.CowTankDetails cowTankDetails = 1;</code> */
    public Builder mergeCowTankDetails(
        com.cpdss.common.generated.discharge_plan.CowTankDetails value) {
      if (cowTankDetailsBuilder_ == null) {
        if (cowTankDetails_ != null) {
          cowTankDetails_ =
              com.cpdss.common.generated.discharge_plan.CowTankDetails.newBuilder(cowTankDetails_)
                  .mergeFrom(value)
                  .buildPartial();
        } else {
          cowTankDetails_ = value;
        }
        onChanged();
      } else {
        cowTankDetailsBuilder_.mergeFrom(value);
      }

      return this;
    }
    /** <code>.CowTankDetails cowTankDetails = 1;</code> */
    public Builder clearCowTankDetails() {
      if (cowTankDetailsBuilder_ == null) {
        cowTankDetails_ = null;
        onChanged();
      } else {
        cowTankDetails_ = null;
        cowTankDetailsBuilder_ = null;
      }

      return this;
    }
    /** <code>.CowTankDetails cowTankDetails = 1;</code> */
    public com.cpdss.common.generated.discharge_plan.CowTankDetails.Builder
        getCowTankDetailsBuilder() {

      onChanged();
      return getCowTankDetailsFieldBuilder().getBuilder();
    }
    /** <code>.CowTankDetails cowTankDetails = 1;</code> */
    public com.cpdss.common.generated.discharge_plan.CowTankDetailsOrBuilder
        getCowTankDetailsOrBuilder() {
      if (cowTankDetailsBuilder_ != null) {
        return cowTankDetailsBuilder_.getMessageOrBuilder();
      } else {
        return cowTankDetails_ == null
            ? com.cpdss.common.generated.discharge_plan.CowTankDetails.getDefaultInstance()
            : cowTankDetails_;
      }
    }
    /** <code>.CowTankDetails cowTankDetails = 1;</code> */
    private com.google.protobuf.SingleFieldBuilderV3<
            com.cpdss.common.generated.discharge_plan.CowTankDetails,
            com.cpdss.common.generated.discharge_plan.CowTankDetails.Builder,
            com.cpdss.common.generated.discharge_plan.CowTankDetailsOrBuilder>
        getCowTankDetailsFieldBuilder() {
      if (cowTankDetailsBuilder_ == null) {
        cowTankDetailsBuilder_ =
            new com.google.protobuf.SingleFieldBuilderV3<
                com.cpdss.common.generated.discharge_plan.CowTankDetails,
                com.cpdss.common.generated.discharge_plan.CowTankDetails.Builder,
                com.cpdss.common.generated.discharge_plan.CowTankDetailsOrBuilder>(
                getCowTankDetails(), getParentForChildren(), isClean());
        cowTankDetails_ = null;
      }
      return cowTankDetailsBuilder_;
    }

    private long dischargeStudyId_;
    /**
     * <code>int64 dischargeStudyId = 2;</code>
     *
     * @return The dischargeStudyId.
     */
    public long getDischargeStudyId() {
      return dischargeStudyId_;
    }
    /**
     * <code>int64 dischargeStudyId = 2;</code>
     *
     * @param value The dischargeStudyId to set.
     * @return This builder for chaining.
     */
    public Builder setDischargeStudyId(long value) {

      dischargeStudyId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 dischargeStudyId = 2;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearDischargeStudyId() {

      dischargeStudyId_ = 0L;
      onChanged();
      return this;
    }

    private float percent_;
    /**
     * <code>float percent = 4;</code>
     *
     * @return The percent.
     */
    public float getPercent() {
      return percent_;
    }
    /**
     * <code>float percent = 4;</code>
     *
     * @param value The percent to set.
     * @return This builder for chaining.
     */
    public Builder setPercent(float value) {

      percent_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>float percent = 4;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearPercent() {

      percent_ = 0F;
      onChanged();
      return this;
    }

    private int cowOptionType_ = 0;
    /**
     * <code>.COW_OPTION_TYPE cowOptionType = 5;</code>
     *
     * @return The enum numeric value on the wire for cowOptionType.
     */
    public int getCowOptionTypeValue() {
      return cowOptionType_;
    }
    /**
     * <code>.COW_OPTION_TYPE cowOptionType = 5;</code>
     *
     * @param value The enum numeric value on the wire for cowOptionType to set.
     * @return This builder for chaining.
     */
    public Builder setCowOptionTypeValue(int value) {
      cowOptionType_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>.COW_OPTION_TYPE cowOptionType = 5;</code>
     *
     * @return The cowOptionType.
     */
    public com.cpdss.common.generated.Common.COW_OPTION_TYPE getCowOptionType() {
      @SuppressWarnings("deprecation")
      com.cpdss.common.generated.Common.COW_OPTION_TYPE result =
          com.cpdss.common.generated.Common.COW_OPTION_TYPE.valueOf(cowOptionType_);
      return result == null
          ? com.cpdss.common.generated.Common.COW_OPTION_TYPE.UNRECOGNIZED
          : result;
    }
    /**
     * <code>.COW_OPTION_TYPE cowOptionType = 5;</code>
     *
     * @param value The cowOptionType to set.
     * @return This builder for chaining.
     */
    public Builder setCowOptionType(com.cpdss.common.generated.Common.COW_OPTION_TYPE value) {
      if (value == null) {
        throw new NullPointerException();
      }

      cowOptionType_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.COW_OPTION_TYPE cowOptionType = 5;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearCowOptionType() {

      cowOptionType_ = 0;
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

    // @@protoc_insertion_point(builder_scope:DSCowDetails)
  }

  // @@protoc_insertion_point(class_scope:DSCowDetails)
  private static final com.cpdss.common.generated.discharge_plan.DSCowDetails DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new com.cpdss.common.generated.discharge_plan.DSCowDetails();
  }

  public static com.cpdss.common.generated.discharge_plan.DSCowDetails getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<DSCowDetails> PARSER =
      new com.google.protobuf.AbstractParser<DSCowDetails>() {
        @java.lang.Override
        public DSCowDetails parsePartialFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
          return new DSCowDetails(input, extensionRegistry);
        }
      };

  public static com.google.protobuf.Parser<DSCowDetails> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<DSCowDetails> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.cpdss.common.generated.discharge_plan.DSCowDetails getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
}
