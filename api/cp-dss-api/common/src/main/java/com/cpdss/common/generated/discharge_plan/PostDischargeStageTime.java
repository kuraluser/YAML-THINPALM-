/* Licensed at AlphaOri Technologies */
package com.cpdss.common.generated.discharge_plan;

/** Protobuf type {@code PostDischargeStageTime} */
public final class PostDischargeStageTime extends com.google.protobuf.GeneratedMessageV3
    implements
    // @@protoc_insertion_point(message_implements:PostDischargeStageTime)
    PostDischargeStageTimeOrBuilder {
  private static final long serialVersionUID = 0L;
  // Use PostDischargeStageTime.newBuilder() to construct.
  private PostDischargeStageTime(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }

  private PostDischargeStageTime() {
    timeForDryCheck_ = "";
    slopDischarging_ = "";
    finalStripping_ = "";
    freshOilWashing_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
    return new PostDischargeStageTime();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }

  private PostDischargeStageTime(
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
              java.lang.String s = input.readStringRequireUtf8();

              timeForDryCheck_ = s;
              break;
            }
          case 18:
            {
              java.lang.String s = input.readStringRequireUtf8();

              slopDischarging_ = s;
              break;
            }
          case 26:
            {
              java.lang.String s = input.readStringRequireUtf8();

              finalStripping_ = s;
              break;
            }
          case 34:
            {
              java.lang.String s = input.readStringRequireUtf8();

              freshOilWashing_ = s;
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
        .internal_static_PostDischargeStageTime_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.cpdss.common.generated.discharge_plan.DischargePlanModels
        .internal_static_PostDischargeStageTime_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.cpdss.common.generated.discharge_plan.PostDischargeStageTime.class,
            com.cpdss.common.generated.discharge_plan.PostDischargeStageTime.Builder.class);
  }

  public static final int TIMEFORDRYCHECK_FIELD_NUMBER = 1;
  private volatile java.lang.Object timeForDryCheck_;
  /**
   * <code>string timeForDryCheck = 1;</code>
   *
   * @return The timeForDryCheck.
   */
  public java.lang.String getTimeForDryCheck() {
    java.lang.Object ref = timeForDryCheck_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      timeForDryCheck_ = s;
      return s;
    }
  }
  /**
   * <code>string timeForDryCheck = 1;</code>
   *
   * @return The bytes for timeForDryCheck.
   */
  public com.google.protobuf.ByteString getTimeForDryCheckBytes() {
    java.lang.Object ref = timeForDryCheck_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
      timeForDryCheck_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int SLOPDISCHARGING_FIELD_NUMBER = 2;
  private volatile java.lang.Object slopDischarging_;
  /**
   * <code>string slopDischarging = 2;</code>
   *
   * @return The slopDischarging.
   */
  public java.lang.String getSlopDischarging() {
    java.lang.Object ref = slopDischarging_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      slopDischarging_ = s;
      return s;
    }
  }
  /**
   * <code>string slopDischarging = 2;</code>
   *
   * @return The bytes for slopDischarging.
   */
  public com.google.protobuf.ByteString getSlopDischargingBytes() {
    java.lang.Object ref = slopDischarging_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
      slopDischarging_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int FINALSTRIPPING_FIELD_NUMBER = 3;
  private volatile java.lang.Object finalStripping_;
  /**
   * <code>string finalStripping = 3;</code>
   *
   * @return The finalStripping.
   */
  public java.lang.String getFinalStripping() {
    java.lang.Object ref = finalStripping_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      finalStripping_ = s;
      return s;
    }
  }
  /**
   * <code>string finalStripping = 3;</code>
   *
   * @return The bytes for finalStripping.
   */
  public com.google.protobuf.ByteString getFinalStrippingBytes() {
    java.lang.Object ref = finalStripping_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
      finalStripping_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int FRESHOILWASHING_FIELD_NUMBER = 4;
  private volatile java.lang.Object freshOilWashing_;
  /**
   * <code>string freshOilWashing = 4;</code>
   *
   * @return The freshOilWashing.
   */
  public java.lang.String getFreshOilWashing() {
    java.lang.Object ref = freshOilWashing_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      freshOilWashing_ = s;
      return s;
    }
  }
  /**
   * <code>string freshOilWashing = 4;</code>
   *
   * @return The bytes for freshOilWashing.
   */
  public com.google.protobuf.ByteString getFreshOilWashingBytes() {
    java.lang.Object ref = freshOilWashing_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
      freshOilWashing_ = b;
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
    if (!getTimeForDryCheckBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, timeForDryCheck_);
    }
    if (!getSlopDischargingBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, slopDischarging_);
    }
    if (!getFinalStrippingBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, finalStripping_);
    }
    if (!getFreshOilWashingBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, freshOilWashing_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getTimeForDryCheckBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, timeForDryCheck_);
    }
    if (!getSlopDischargingBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, slopDischarging_);
    }
    if (!getFinalStrippingBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, finalStripping_);
    }
    if (!getFreshOilWashingBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, freshOilWashing_);
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
    if (!(obj instanceof com.cpdss.common.generated.discharge_plan.PostDischargeStageTime)) {
      return super.equals(obj);
    }
    com.cpdss.common.generated.discharge_plan.PostDischargeStageTime other =
        (com.cpdss.common.generated.discharge_plan.PostDischargeStageTime) obj;

    if (!getTimeForDryCheck().equals(other.getTimeForDryCheck())) return false;
    if (!getSlopDischarging().equals(other.getSlopDischarging())) return false;
    if (!getFinalStripping().equals(other.getFinalStripping())) return false;
    if (!getFreshOilWashing().equals(other.getFreshOilWashing())) return false;
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
    hash = (37 * hash) + TIMEFORDRYCHECK_FIELD_NUMBER;
    hash = (53 * hash) + getTimeForDryCheck().hashCode();
    hash = (37 * hash) + SLOPDISCHARGING_FIELD_NUMBER;
    hash = (53 * hash) + getSlopDischarging().hashCode();
    hash = (37 * hash) + FINALSTRIPPING_FIELD_NUMBER;
    hash = (53 * hash) + getFinalStripping().hashCode();
    hash = (37 * hash) + FRESHOILWASHING_FIELD_NUMBER;
    hash = (53 * hash) + getFreshOilWashing().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.cpdss.common.generated.discharge_plan.PostDischargeStageTime parseFrom(
      java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.cpdss.common.generated.discharge_plan.PostDischargeStageTime parseFrom(
      java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.PostDischargeStageTime parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.cpdss.common.generated.discharge_plan.PostDischargeStageTime parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.PostDischargeStageTime parseFrom(
      byte[] data) throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.cpdss.common.generated.discharge_plan.PostDischargeStageTime parseFrom(
      byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.PostDischargeStageTime parseFrom(
      java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.cpdss.common.generated.discharge_plan.PostDischargeStageTime parseFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.PostDischargeStageTime parseDelimitedFrom(
      java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
  }

  public static com.cpdss.common.generated.discharge_plan.PostDischargeStageTime parseDelimitedFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.PostDischargeStageTime parseFrom(
      com.google.protobuf.CodedInputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.cpdss.common.generated.discharge_plan.PostDischargeStageTime parseFrom(
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
      com.cpdss.common.generated.discharge_plan.PostDischargeStageTime prototype) {
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
  /** Protobuf type {@code PostDischargeStageTime} */
  public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
      implements
      // @@protoc_insertion_point(builder_implements:PostDischargeStageTime)
      com.cpdss.common.generated.discharge_plan.PostDischargeStageTimeOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanModels
          .internal_static_PostDischargeStageTime_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanModels
          .internal_static_PostDischargeStageTime_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.discharge_plan.PostDischargeStageTime.class,
              com.cpdss.common.generated.discharge_plan.PostDischargeStageTime.Builder.class);
    }

    // Construct using com.cpdss.common.generated.discharge_plan.PostDischargeStageTime.newBuilder()
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
      timeForDryCheck_ = "";

      slopDischarging_ = "";

      finalStripping_ = "";

      freshOilWashing_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanModels
          .internal_static_PostDischargeStageTime_descriptor;
    }

    @java.lang.Override
    public com.cpdss.common.generated.discharge_plan.PostDischargeStageTime
        getDefaultInstanceForType() {
      return com.cpdss.common.generated.discharge_plan.PostDischargeStageTime.getDefaultInstance();
    }

    @java.lang.Override
    public com.cpdss.common.generated.discharge_plan.PostDischargeStageTime build() {
      com.cpdss.common.generated.discharge_plan.PostDischargeStageTime result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.cpdss.common.generated.discharge_plan.PostDischargeStageTime buildPartial() {
      com.cpdss.common.generated.discharge_plan.PostDischargeStageTime result =
          new com.cpdss.common.generated.discharge_plan.PostDischargeStageTime(this);
      result.timeForDryCheck_ = timeForDryCheck_;
      result.slopDischarging_ = slopDischarging_;
      result.finalStripping_ = finalStripping_;
      result.freshOilWashing_ = freshOilWashing_;
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
      if (other instanceof com.cpdss.common.generated.discharge_plan.PostDischargeStageTime) {
        return mergeFrom((com.cpdss.common.generated.discharge_plan.PostDischargeStageTime) other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(
        com.cpdss.common.generated.discharge_plan.PostDischargeStageTime other) {
      if (other
          == com.cpdss.common.generated.discharge_plan.PostDischargeStageTime.getDefaultInstance())
        return this;
      if (!other.getTimeForDryCheck().isEmpty()) {
        timeForDryCheck_ = other.timeForDryCheck_;
        onChanged();
      }
      if (!other.getSlopDischarging().isEmpty()) {
        slopDischarging_ = other.slopDischarging_;
        onChanged();
      }
      if (!other.getFinalStripping().isEmpty()) {
        finalStripping_ = other.finalStripping_;
        onChanged();
      }
      if (!other.getFreshOilWashing().isEmpty()) {
        freshOilWashing_ = other.freshOilWashing_;
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
      com.cpdss.common.generated.discharge_plan.PostDischargeStageTime parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage =
            (com.cpdss.common.generated.discharge_plan.PostDischargeStageTime)
                e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object timeForDryCheck_ = "";
    /**
     * <code>string timeForDryCheck = 1;</code>
     *
     * @return The timeForDryCheck.
     */
    public java.lang.String getTimeForDryCheck() {
      java.lang.Object ref = timeForDryCheck_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        timeForDryCheck_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string timeForDryCheck = 1;</code>
     *
     * @return The bytes for timeForDryCheck.
     */
    public com.google.protobuf.ByteString getTimeForDryCheckBytes() {
      java.lang.Object ref = timeForDryCheck_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        timeForDryCheck_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string timeForDryCheck = 1;</code>
     *
     * @param value The timeForDryCheck to set.
     * @return This builder for chaining.
     */
    public Builder setTimeForDryCheck(java.lang.String value) {
      if (value == null) {
        throw new NullPointerException();
      }

      timeForDryCheck_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string timeForDryCheck = 1;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearTimeForDryCheck() {

      timeForDryCheck_ = getDefaultInstance().getTimeForDryCheck();
      onChanged();
      return this;
    }
    /**
     * <code>string timeForDryCheck = 1;</code>
     *
     * @param value The bytes for timeForDryCheck to set.
     * @return This builder for chaining.
     */
    public Builder setTimeForDryCheckBytes(com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      checkByteStringIsUtf8(value);

      timeForDryCheck_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object slopDischarging_ = "";
    /**
     * <code>string slopDischarging = 2;</code>
     *
     * @return The slopDischarging.
     */
    public java.lang.String getSlopDischarging() {
      java.lang.Object ref = slopDischarging_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        slopDischarging_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string slopDischarging = 2;</code>
     *
     * @return The bytes for slopDischarging.
     */
    public com.google.protobuf.ByteString getSlopDischargingBytes() {
      java.lang.Object ref = slopDischarging_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        slopDischarging_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string slopDischarging = 2;</code>
     *
     * @param value The slopDischarging to set.
     * @return This builder for chaining.
     */
    public Builder setSlopDischarging(java.lang.String value) {
      if (value == null) {
        throw new NullPointerException();
      }

      slopDischarging_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string slopDischarging = 2;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearSlopDischarging() {

      slopDischarging_ = getDefaultInstance().getSlopDischarging();
      onChanged();
      return this;
    }
    /**
     * <code>string slopDischarging = 2;</code>
     *
     * @param value The bytes for slopDischarging to set.
     * @return This builder for chaining.
     */
    public Builder setSlopDischargingBytes(com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      checkByteStringIsUtf8(value);

      slopDischarging_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object finalStripping_ = "";
    /**
     * <code>string finalStripping = 3;</code>
     *
     * @return The finalStripping.
     */
    public java.lang.String getFinalStripping() {
      java.lang.Object ref = finalStripping_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        finalStripping_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string finalStripping = 3;</code>
     *
     * @return The bytes for finalStripping.
     */
    public com.google.protobuf.ByteString getFinalStrippingBytes() {
      java.lang.Object ref = finalStripping_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        finalStripping_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string finalStripping = 3;</code>
     *
     * @param value The finalStripping to set.
     * @return This builder for chaining.
     */
    public Builder setFinalStripping(java.lang.String value) {
      if (value == null) {
        throw new NullPointerException();
      }

      finalStripping_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string finalStripping = 3;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearFinalStripping() {

      finalStripping_ = getDefaultInstance().getFinalStripping();
      onChanged();
      return this;
    }
    /**
     * <code>string finalStripping = 3;</code>
     *
     * @param value The bytes for finalStripping to set.
     * @return This builder for chaining.
     */
    public Builder setFinalStrippingBytes(com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      checkByteStringIsUtf8(value);

      finalStripping_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object freshOilWashing_ = "";
    /**
     * <code>string freshOilWashing = 4;</code>
     *
     * @return The freshOilWashing.
     */
    public java.lang.String getFreshOilWashing() {
      java.lang.Object ref = freshOilWashing_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        freshOilWashing_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string freshOilWashing = 4;</code>
     *
     * @return The bytes for freshOilWashing.
     */
    public com.google.protobuf.ByteString getFreshOilWashingBytes() {
      java.lang.Object ref = freshOilWashing_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        freshOilWashing_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string freshOilWashing = 4;</code>
     *
     * @param value The freshOilWashing to set.
     * @return This builder for chaining.
     */
    public Builder setFreshOilWashing(java.lang.String value) {
      if (value == null) {
        throw new NullPointerException();
      }

      freshOilWashing_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string freshOilWashing = 4;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearFreshOilWashing() {

      freshOilWashing_ = getDefaultInstance().getFreshOilWashing();
      onChanged();
      return this;
    }
    /**
     * <code>string freshOilWashing = 4;</code>
     *
     * @param value The bytes for freshOilWashing to set.
     * @return This builder for chaining.
     */
    public Builder setFreshOilWashingBytes(com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      checkByteStringIsUtf8(value);

      freshOilWashing_ = value;
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

    // @@protoc_insertion_point(builder_scope:PostDischargeStageTime)
  }

  // @@protoc_insertion_point(class_scope:PostDischargeStageTime)
  private static final com.cpdss.common.generated.discharge_plan.PostDischargeStageTime
      DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new com.cpdss.common.generated.discharge_plan.PostDischargeStageTime();
  }

  public static com.cpdss.common.generated.discharge_plan.PostDischargeStageTime
      getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<PostDischargeStageTime> PARSER =
      new com.google.protobuf.AbstractParser<PostDischargeStageTime>() {
        @java.lang.Override
        public PostDischargeStageTime parsePartialFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
          return new PostDischargeStageTime(input, extensionRegistry);
        }
      };

  public static com.google.protobuf.Parser<PostDischargeStageTime> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<PostDischargeStageTime> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.cpdss.common.generated.discharge_plan.PostDischargeStageTime
      getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
}
