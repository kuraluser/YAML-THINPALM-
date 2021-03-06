/* Licensed at AlphaOri Technologies */
package com.cpdss.common.generated.discharge_plan;

/** Protobuf type {@code DischargingRate} */
public final class DischargingRate extends com.google.protobuf.GeneratedMessageV3
    implements
    // @@protoc_insertion_point(message_implements:DischargingRate)
    DischargingRateOrBuilder {
  private static final long serialVersionUID = 0L;
  // Use DischargingRate.newBuilder() to construct.
  private DischargingRate(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }

  private DischargingRate() {
    dischargingRate_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
    return new DischargingRate();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }

  private DischargingRate(
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

              dischargingRate_ = s;
              break;
            }
          case 16:
            {
              tankId_ = input.readInt64();
              break;
            }
          case 24:
            {
              startTime_ = input.readInt32();
              break;
            }
          case 32:
            {
              endTime_ = input.readInt32();
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
        .internal_static_DischargingRate_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.cpdss.common.generated.discharge_plan.DischargePlanModels
        .internal_static_DischargingRate_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.cpdss.common.generated.discharge_plan.DischargingRate.class,
            com.cpdss.common.generated.discharge_plan.DischargingRate.Builder.class);
  }

  public static final int DISCHARGINGRATE_FIELD_NUMBER = 1;
  private volatile java.lang.Object dischargingRate_;
  /**
   * <code>string dischargingRate = 1;</code>
   *
   * @return The dischargingRate.
   */
  public java.lang.String getDischargingRate() {
    java.lang.Object ref = dischargingRate_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      dischargingRate_ = s;
      return s;
    }
  }
  /**
   * <code>string dischargingRate = 1;</code>
   *
   * @return The bytes for dischargingRate.
   */
  public com.google.protobuf.ByteString getDischargingRateBytes() {
    java.lang.Object ref = dischargingRate_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
      dischargingRate_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int TANKID_FIELD_NUMBER = 2;
  private long tankId_;
  /**
   * <code>int64 tankId = 2;</code>
   *
   * @return The tankId.
   */
  public long getTankId() {
    return tankId_;
  }

  public static final int STARTTIME_FIELD_NUMBER = 3;
  private int startTime_;
  /**
   * <code>int32 startTime = 3;</code>
   *
   * @return The startTime.
   */
  public int getStartTime() {
    return startTime_;
  }

  public static final int ENDTIME_FIELD_NUMBER = 4;
  private int endTime_;
  /**
   * <code>int32 endTime = 4;</code>
   *
   * @return The endTime.
   */
  public int getEndTime() {
    return endTime_;
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
    if (!getDischargingRateBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, dischargingRate_);
    }
    if (tankId_ != 0L) {
      output.writeInt64(2, tankId_);
    }
    if (startTime_ != 0) {
      output.writeInt32(3, startTime_);
    }
    if (endTime_ != 0) {
      output.writeInt32(4, endTime_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getDischargingRateBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, dischargingRate_);
    }
    if (tankId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream.computeInt64Size(2, tankId_);
    }
    if (startTime_ != 0) {
      size += com.google.protobuf.CodedOutputStream.computeInt32Size(3, startTime_);
    }
    if (endTime_ != 0) {
      size += com.google.protobuf.CodedOutputStream.computeInt32Size(4, endTime_);
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
    if (!(obj instanceof com.cpdss.common.generated.discharge_plan.DischargingRate)) {
      return super.equals(obj);
    }
    com.cpdss.common.generated.discharge_plan.DischargingRate other =
        (com.cpdss.common.generated.discharge_plan.DischargingRate) obj;

    if (!getDischargingRate().equals(other.getDischargingRate())) return false;
    if (getTankId() != other.getTankId()) return false;
    if (getStartTime() != other.getStartTime()) return false;
    if (getEndTime() != other.getEndTime()) return false;
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
    hash = (37 * hash) + DISCHARGINGRATE_FIELD_NUMBER;
    hash = (53 * hash) + getDischargingRate().hashCode();
    hash = (37 * hash) + TANKID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getTankId());
    hash = (37 * hash) + STARTTIME_FIELD_NUMBER;
    hash = (53 * hash) + getStartTime();
    hash = (37 * hash) + ENDTIME_FIELD_NUMBER;
    hash = (53 * hash) + getEndTime();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingRate parseFrom(
      java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingRate parseFrom(
      java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingRate parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingRate parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingRate parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingRate parseFrom(
      byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingRate parseFrom(
      java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingRate parseFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingRate parseDelimitedFrom(
      java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingRate parseDelimitedFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingRate parseFrom(
      com.google.protobuf.CodedInputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingRate parseFrom(
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
      com.cpdss.common.generated.discharge_plan.DischargingRate prototype) {
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
  /** Protobuf type {@code DischargingRate} */
  public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
      implements
      // @@protoc_insertion_point(builder_implements:DischargingRate)
      com.cpdss.common.generated.discharge_plan.DischargingRateOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanModels
          .internal_static_DischargingRate_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanModels
          .internal_static_DischargingRate_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.discharge_plan.DischargingRate.class,
              com.cpdss.common.generated.discharge_plan.DischargingRate.Builder.class);
    }

    // Construct using com.cpdss.common.generated.discharge_plan.DischargingRate.newBuilder()
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
      dischargingRate_ = "";

      tankId_ = 0L;

      startTime_ = 0;

      endTime_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanModels
          .internal_static_DischargingRate_descriptor;
    }

    @java.lang.Override
    public com.cpdss.common.generated.discharge_plan.DischargingRate getDefaultInstanceForType() {
      return com.cpdss.common.generated.discharge_plan.DischargingRate.getDefaultInstance();
    }

    @java.lang.Override
    public com.cpdss.common.generated.discharge_plan.DischargingRate build() {
      com.cpdss.common.generated.discharge_plan.DischargingRate result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.cpdss.common.generated.discharge_plan.DischargingRate buildPartial() {
      com.cpdss.common.generated.discharge_plan.DischargingRate result =
          new com.cpdss.common.generated.discharge_plan.DischargingRate(this);
      result.dischargingRate_ = dischargingRate_;
      result.tankId_ = tankId_;
      result.startTime_ = startTime_;
      result.endTime_ = endTime_;
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
      if (other instanceof com.cpdss.common.generated.discharge_plan.DischargingRate) {
        return mergeFrom((com.cpdss.common.generated.discharge_plan.DischargingRate) other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.cpdss.common.generated.discharge_plan.DischargingRate other) {
      if (other == com.cpdss.common.generated.discharge_plan.DischargingRate.getDefaultInstance())
        return this;
      if (!other.getDischargingRate().isEmpty()) {
        dischargingRate_ = other.dischargingRate_;
        onChanged();
      }
      if (other.getTankId() != 0L) {
        setTankId(other.getTankId());
      }
      if (other.getStartTime() != 0) {
        setStartTime(other.getStartTime());
      }
      if (other.getEndTime() != 0) {
        setEndTime(other.getEndTime());
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
      com.cpdss.common.generated.discharge_plan.DischargingRate parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage =
            (com.cpdss.common.generated.discharge_plan.DischargingRate) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object dischargingRate_ = "";
    /**
     * <code>string dischargingRate = 1;</code>
     *
     * @return The dischargingRate.
     */
    public java.lang.String getDischargingRate() {
      java.lang.Object ref = dischargingRate_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        dischargingRate_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string dischargingRate = 1;</code>
     *
     * @return The bytes for dischargingRate.
     */
    public com.google.protobuf.ByteString getDischargingRateBytes() {
      java.lang.Object ref = dischargingRate_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        dischargingRate_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string dischargingRate = 1;</code>
     *
     * @param value The dischargingRate to set.
     * @return This builder for chaining.
     */
    public Builder setDischargingRate(java.lang.String value) {
      if (value == null) {
        throw new NullPointerException();
      }

      dischargingRate_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string dischargingRate = 1;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearDischargingRate() {

      dischargingRate_ = getDefaultInstance().getDischargingRate();
      onChanged();
      return this;
    }
    /**
     * <code>string dischargingRate = 1;</code>
     *
     * @param value The bytes for dischargingRate to set.
     * @return This builder for chaining.
     */
    public Builder setDischargingRateBytes(com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      checkByteStringIsUtf8(value);

      dischargingRate_ = value;
      onChanged();
      return this;
    }

    private long tankId_;
    /**
     * <code>int64 tankId = 2;</code>
     *
     * @return The tankId.
     */
    public long getTankId() {
      return tankId_;
    }
    /**
     * <code>int64 tankId = 2;</code>
     *
     * @param value The tankId to set.
     * @return This builder for chaining.
     */
    public Builder setTankId(long value) {

      tankId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 tankId = 2;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearTankId() {

      tankId_ = 0L;
      onChanged();
      return this;
    }

    private int startTime_;
    /**
     * <code>int32 startTime = 3;</code>
     *
     * @return The startTime.
     */
    public int getStartTime() {
      return startTime_;
    }
    /**
     * <code>int32 startTime = 3;</code>
     *
     * @param value The startTime to set.
     * @return This builder for chaining.
     */
    public Builder setStartTime(int value) {

      startTime_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 startTime = 3;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearStartTime() {

      startTime_ = 0;
      onChanged();
      return this;
    }

    private int endTime_;
    /**
     * <code>int32 endTime = 4;</code>
     *
     * @return The endTime.
     */
    public int getEndTime() {
      return endTime_;
    }
    /**
     * <code>int32 endTime = 4;</code>
     *
     * @param value The endTime to set.
     * @return This builder for chaining.
     */
    public Builder setEndTime(int value) {

      endTime_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 endTime = 4;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearEndTime() {

      endTime_ = 0;
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

    // @@protoc_insertion_point(builder_scope:DischargingRate)
  }

  // @@protoc_insertion_point(class_scope:DischargingRate)
  private static final com.cpdss.common.generated.discharge_plan.DischargingRate DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new com.cpdss.common.generated.discharge_plan.DischargingRate();
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingRate getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<DischargingRate> PARSER =
      new com.google.protobuf.AbstractParser<DischargingRate>() {
        @java.lang.Override
        public DischargingRate parsePartialFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
          return new DischargingRate(input, extensionRegistry);
        }
      };

  public static com.google.protobuf.Parser<DischargingRate> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<DischargingRate> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.cpdss.common.generated.discharge_plan.DischargingRate getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
}
