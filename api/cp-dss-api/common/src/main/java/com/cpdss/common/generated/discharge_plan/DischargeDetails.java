/* Licensed at AlphaOri Technologies */
package com.cpdss.common.generated.discharge_plan;

/** Protobuf type {@code DischargeDetails} */
public final class DischargeDetails extends com.google.protobuf.GeneratedMessageV3
    implements
    // @@protoc_insertion_point(message_implements:DischargeDetails)
    DischargeDetailsOrBuilder {
  private static final long serialVersionUID = 0L;
  // Use DischargeDetails.newBuilder() to construct.
  private DischargeDetails(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }

  private DischargeDetails() {
    timeOfSunrise_ = "";
    timeOfSunset_ = "";
    startTime_ = "";
    commonDate_ = "";
    slopQuantity_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
    return new DischargeDetails();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }

  private DischargeDetails(
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
              id_ = input.readInt64();
              break;
            }
          case 18:
            {
              java.lang.String s = input.readStringRequireUtf8();

              timeOfSunrise_ = s;
              break;
            }
          case 26:
            {
              java.lang.String s = input.readStringRequireUtf8();

              timeOfSunset_ = s;
              break;
            }
          case 34:
            {
              java.lang.String s = input.readStringRequireUtf8();

              startTime_ = s;
              break;
            }
          case 42:
            {
              com.cpdss.common.generated.loading_plan.LoadingPlanModels.TrimAllowed.Builder
                  subBuilder = null;
              if (trimAllowed_ != null) {
                subBuilder = trimAllowed_.toBuilder();
              }
              trimAllowed_ =
                  input.readMessage(
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels.TrimAllowed
                          .parser(),
                      extensionRegistry);
              if (subBuilder != null) {
                subBuilder.mergeFrom(trimAllowed_);
                trimAllowed_ = subBuilder.buildPartial();
              }

              break;
            }
          case 48:
            {
              voyageId_ = input.readInt64();
              break;
            }
          case 58:
            {
              java.lang.String s = input.readStringRequireUtf8();

              commonDate_ = s;
              break;
            }
          case 66:
            {
              java.lang.String s = input.readStringRequireUtf8();

              slopQuantity_ = s;
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
        .internal_static_DischargeDetails_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.cpdss.common.generated.discharge_plan.DischargePlanModels
        .internal_static_DischargeDetails_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.cpdss.common.generated.discharge_plan.DischargeDetails.class,
            com.cpdss.common.generated.discharge_plan.DischargeDetails.Builder.class);
  }

  public static final int ID_FIELD_NUMBER = 1;
  private long id_;
  /**
   * <code>int64 id = 1;</code>
   *
   * @return The id.
   */
  public long getId() {
    return id_;
  }

  public static final int TIMEOFSUNRISE_FIELD_NUMBER = 2;
  private volatile java.lang.Object timeOfSunrise_;
  /**
   * <code>string timeOfSunrise = 2;</code>
   *
   * @return The timeOfSunrise.
   */
  public java.lang.String getTimeOfSunrise() {
    java.lang.Object ref = timeOfSunrise_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      timeOfSunrise_ = s;
      return s;
    }
  }
  /**
   * <code>string timeOfSunrise = 2;</code>
   *
   * @return The bytes for timeOfSunrise.
   */
  public com.google.protobuf.ByteString getTimeOfSunriseBytes() {
    java.lang.Object ref = timeOfSunrise_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
      timeOfSunrise_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int TIMEOFSUNSET_FIELD_NUMBER = 3;
  private volatile java.lang.Object timeOfSunset_;
  /**
   * <code>string timeOfSunset = 3;</code>
   *
   * @return The timeOfSunset.
   */
  public java.lang.String getTimeOfSunset() {
    java.lang.Object ref = timeOfSunset_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      timeOfSunset_ = s;
      return s;
    }
  }
  /**
   * <code>string timeOfSunset = 3;</code>
   *
   * @return The bytes for timeOfSunset.
   */
  public com.google.protobuf.ByteString getTimeOfSunsetBytes() {
    java.lang.Object ref = timeOfSunset_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
      timeOfSunset_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int STARTTIME_FIELD_NUMBER = 4;
  private volatile java.lang.Object startTime_;
  /**
   * <code>string startTime = 4;</code>
   *
   * @return The startTime.
   */
  public java.lang.String getStartTime() {
    java.lang.Object ref = startTime_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      startTime_ = s;
      return s;
    }
  }
  /**
   * <code>string startTime = 4;</code>
   *
   * @return The bytes for startTime.
   */
  public com.google.protobuf.ByteString getStartTimeBytes() {
    java.lang.Object ref = startTime_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
      startTime_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int TRIMALLOWED_FIELD_NUMBER = 5;
  private com.cpdss.common.generated.loading_plan.LoadingPlanModels.TrimAllowed trimAllowed_;
  /**
   * <code>.TrimAllowed trimAllowed = 5;</code>
   *
   * @return Whether the trimAllowed field is set.
   */
  public boolean hasTrimAllowed() {
    return trimAllowed_ != null;
  }
  /**
   * <code>.TrimAllowed trimAllowed = 5;</code>
   *
   * @return The trimAllowed.
   */
  public com.cpdss.common.generated.loading_plan.LoadingPlanModels.TrimAllowed getTrimAllowed() {
    return trimAllowed_ == null
        ? com.cpdss.common.generated.loading_plan.LoadingPlanModels.TrimAllowed.getDefaultInstance()
        : trimAllowed_;
  }
  /** <code>.TrimAllowed trimAllowed = 5;</code> */
  public com.cpdss.common.generated.loading_plan.LoadingPlanModels.TrimAllowedOrBuilder
      getTrimAllowedOrBuilder() {
    return getTrimAllowed();
  }

  public static final int VOYAGEID_FIELD_NUMBER = 6;
  private long voyageId_;
  /**
   * <code>int64 voyageId = 6;</code>
   *
   * @return The voyageId.
   */
  public long getVoyageId() {
    return voyageId_;
  }

  public static final int COMMONDATE_FIELD_NUMBER = 7;
  private volatile java.lang.Object commonDate_;
  /**
   * <code>string commonDate = 7;</code>
   *
   * @return The commonDate.
   */
  public java.lang.String getCommonDate() {
    java.lang.Object ref = commonDate_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      commonDate_ = s;
      return s;
    }
  }
  /**
   * <code>string commonDate = 7;</code>
   *
   * @return The bytes for commonDate.
   */
  public com.google.protobuf.ByteString getCommonDateBytes() {
    java.lang.Object ref = commonDate_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
      commonDate_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int SLOPQUANTITY_FIELD_NUMBER = 8;
  private volatile java.lang.Object slopQuantity_;
  /**
   * <code>string slopQuantity = 8;</code>
   *
   * @return The slopQuantity.
   */
  public java.lang.String getSlopQuantity() {
    java.lang.Object ref = slopQuantity_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      slopQuantity_ = s;
      return s;
    }
  }
  /**
   * <code>string slopQuantity = 8;</code>
   *
   * @return The bytes for slopQuantity.
   */
  public com.google.protobuf.ByteString getSlopQuantityBytes() {
    java.lang.Object ref = slopQuantity_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
      slopQuantity_ = b;
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
    if (id_ != 0L) {
      output.writeInt64(1, id_);
    }
    if (!getTimeOfSunriseBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, timeOfSunrise_);
    }
    if (!getTimeOfSunsetBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, timeOfSunset_);
    }
    if (!getStartTimeBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, startTime_);
    }
    if (trimAllowed_ != null) {
      output.writeMessage(5, getTrimAllowed());
    }
    if (voyageId_ != 0L) {
      output.writeInt64(6, voyageId_);
    }
    if (!getCommonDateBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 7, commonDate_);
    }
    if (!getSlopQuantityBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 8, slopQuantity_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (id_ != 0L) {
      size += com.google.protobuf.CodedOutputStream.computeInt64Size(1, id_);
    }
    if (!getTimeOfSunriseBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, timeOfSunrise_);
    }
    if (!getTimeOfSunsetBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, timeOfSunset_);
    }
    if (!getStartTimeBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, startTime_);
    }
    if (trimAllowed_ != null) {
      size += com.google.protobuf.CodedOutputStream.computeMessageSize(5, getTrimAllowed());
    }
    if (voyageId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream.computeInt64Size(6, voyageId_);
    }
    if (!getCommonDateBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(7, commonDate_);
    }
    if (!getSlopQuantityBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(8, slopQuantity_);
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
    if (!(obj instanceof com.cpdss.common.generated.discharge_plan.DischargeDetails)) {
      return super.equals(obj);
    }
    com.cpdss.common.generated.discharge_plan.DischargeDetails other =
        (com.cpdss.common.generated.discharge_plan.DischargeDetails) obj;

    if (getId() != other.getId()) return false;
    if (!getTimeOfSunrise().equals(other.getTimeOfSunrise())) return false;
    if (!getTimeOfSunset().equals(other.getTimeOfSunset())) return false;
    if (!getStartTime().equals(other.getStartTime())) return false;
    if (hasTrimAllowed() != other.hasTrimAllowed()) return false;
    if (hasTrimAllowed()) {
      if (!getTrimAllowed().equals(other.getTrimAllowed())) return false;
    }
    if (getVoyageId() != other.getVoyageId()) return false;
    if (!getCommonDate().equals(other.getCommonDate())) return false;
    if (!getSlopQuantity().equals(other.getSlopQuantity())) return false;
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
    hash = (37 * hash) + ID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getId());
    hash = (37 * hash) + TIMEOFSUNRISE_FIELD_NUMBER;
    hash = (53 * hash) + getTimeOfSunrise().hashCode();
    hash = (37 * hash) + TIMEOFSUNSET_FIELD_NUMBER;
    hash = (53 * hash) + getTimeOfSunset().hashCode();
    hash = (37 * hash) + STARTTIME_FIELD_NUMBER;
    hash = (53 * hash) + getStartTime().hashCode();
    if (hasTrimAllowed()) {
      hash = (37 * hash) + TRIMALLOWED_FIELD_NUMBER;
      hash = (53 * hash) + getTrimAllowed().hashCode();
    }
    hash = (37 * hash) + VOYAGEID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getVoyageId());
    hash = (37 * hash) + COMMONDATE_FIELD_NUMBER;
    hash = (53 * hash) + getCommonDate().hashCode();
    hash = (37 * hash) + SLOPQUANTITY_FIELD_NUMBER;
    hash = (53 * hash) + getSlopQuantity().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.cpdss.common.generated.discharge_plan.DischargeDetails parseFrom(
      java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargeDetails parseFrom(
      java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargeDetails parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargeDetails parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargeDetails parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargeDetails parseFrom(
      byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargeDetails parseFrom(
      java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargeDetails parseFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargeDetails parseDelimitedFrom(
      java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargeDetails parseDelimitedFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargeDetails parseFrom(
      com.google.protobuf.CodedInputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargeDetails parseFrom(
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
      com.cpdss.common.generated.discharge_plan.DischargeDetails prototype) {
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
  /** Protobuf type {@code DischargeDetails} */
  public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
      implements
      // @@protoc_insertion_point(builder_implements:DischargeDetails)
      com.cpdss.common.generated.discharge_plan.DischargeDetailsOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanModels
          .internal_static_DischargeDetails_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanModels
          .internal_static_DischargeDetails_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.discharge_plan.DischargeDetails.class,
              com.cpdss.common.generated.discharge_plan.DischargeDetails.Builder.class);
    }

    // Construct using com.cpdss.common.generated.discharge_plan.DischargeDetails.newBuilder()
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
      id_ = 0L;

      timeOfSunrise_ = "";

      timeOfSunset_ = "";

      startTime_ = "";

      if (trimAllowedBuilder_ == null) {
        trimAllowed_ = null;
      } else {
        trimAllowed_ = null;
        trimAllowedBuilder_ = null;
      }
      voyageId_ = 0L;

      commonDate_ = "";

      slopQuantity_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanModels
          .internal_static_DischargeDetails_descriptor;
    }

    @java.lang.Override
    public com.cpdss.common.generated.discharge_plan.DischargeDetails getDefaultInstanceForType() {
      return com.cpdss.common.generated.discharge_plan.DischargeDetails.getDefaultInstance();
    }

    @java.lang.Override
    public com.cpdss.common.generated.discharge_plan.DischargeDetails build() {
      com.cpdss.common.generated.discharge_plan.DischargeDetails result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.cpdss.common.generated.discharge_plan.DischargeDetails buildPartial() {
      com.cpdss.common.generated.discharge_plan.DischargeDetails result =
          new com.cpdss.common.generated.discharge_plan.DischargeDetails(this);
      result.id_ = id_;
      result.timeOfSunrise_ = timeOfSunrise_;
      result.timeOfSunset_ = timeOfSunset_;
      result.startTime_ = startTime_;
      if (trimAllowedBuilder_ == null) {
        result.trimAllowed_ = trimAllowed_;
      } else {
        result.trimAllowed_ = trimAllowedBuilder_.build();
      }
      result.voyageId_ = voyageId_;
      result.commonDate_ = commonDate_;
      result.slopQuantity_ = slopQuantity_;
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
      if (other instanceof com.cpdss.common.generated.discharge_plan.DischargeDetails) {
        return mergeFrom((com.cpdss.common.generated.discharge_plan.DischargeDetails) other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.cpdss.common.generated.discharge_plan.DischargeDetails other) {
      if (other == com.cpdss.common.generated.discharge_plan.DischargeDetails.getDefaultInstance())
        return this;
      if (other.getId() != 0L) {
        setId(other.getId());
      }
      if (!other.getTimeOfSunrise().isEmpty()) {
        timeOfSunrise_ = other.timeOfSunrise_;
        onChanged();
      }
      if (!other.getTimeOfSunset().isEmpty()) {
        timeOfSunset_ = other.timeOfSunset_;
        onChanged();
      }
      if (!other.getStartTime().isEmpty()) {
        startTime_ = other.startTime_;
        onChanged();
      }
      if (other.hasTrimAllowed()) {
        mergeTrimAllowed(other.getTrimAllowed());
      }
      if (other.getVoyageId() != 0L) {
        setVoyageId(other.getVoyageId());
      }
      if (!other.getCommonDate().isEmpty()) {
        commonDate_ = other.commonDate_;
        onChanged();
      }
      if (!other.getSlopQuantity().isEmpty()) {
        slopQuantity_ = other.slopQuantity_;
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
      com.cpdss.common.generated.discharge_plan.DischargeDetails parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage =
            (com.cpdss.common.generated.discharge_plan.DischargeDetails) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private long id_;
    /**
     * <code>int64 id = 1;</code>
     *
     * @return The id.
     */
    public long getId() {
      return id_;
    }
    /**
     * <code>int64 id = 1;</code>
     *
     * @param value The id to set.
     * @return This builder for chaining.
     */
    public Builder setId(long value) {

      id_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 id = 1;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearId() {

      id_ = 0L;
      onChanged();
      return this;
    }

    private java.lang.Object timeOfSunrise_ = "";
    /**
     * <code>string timeOfSunrise = 2;</code>
     *
     * @return The timeOfSunrise.
     */
    public java.lang.String getTimeOfSunrise() {
      java.lang.Object ref = timeOfSunrise_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        timeOfSunrise_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string timeOfSunrise = 2;</code>
     *
     * @return The bytes for timeOfSunrise.
     */
    public com.google.protobuf.ByteString getTimeOfSunriseBytes() {
      java.lang.Object ref = timeOfSunrise_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        timeOfSunrise_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string timeOfSunrise = 2;</code>
     *
     * @param value The timeOfSunrise to set.
     * @return This builder for chaining.
     */
    public Builder setTimeOfSunrise(java.lang.String value) {
      if (value == null) {
        throw new NullPointerException();
      }

      timeOfSunrise_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string timeOfSunrise = 2;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearTimeOfSunrise() {

      timeOfSunrise_ = getDefaultInstance().getTimeOfSunrise();
      onChanged();
      return this;
    }
    /**
     * <code>string timeOfSunrise = 2;</code>
     *
     * @param value The bytes for timeOfSunrise to set.
     * @return This builder for chaining.
     */
    public Builder setTimeOfSunriseBytes(com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      checkByteStringIsUtf8(value);

      timeOfSunrise_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object timeOfSunset_ = "";
    /**
     * <code>string timeOfSunset = 3;</code>
     *
     * @return The timeOfSunset.
     */
    public java.lang.String getTimeOfSunset() {
      java.lang.Object ref = timeOfSunset_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        timeOfSunset_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string timeOfSunset = 3;</code>
     *
     * @return The bytes for timeOfSunset.
     */
    public com.google.protobuf.ByteString getTimeOfSunsetBytes() {
      java.lang.Object ref = timeOfSunset_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        timeOfSunset_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string timeOfSunset = 3;</code>
     *
     * @param value The timeOfSunset to set.
     * @return This builder for chaining.
     */
    public Builder setTimeOfSunset(java.lang.String value) {
      if (value == null) {
        throw new NullPointerException();
      }

      timeOfSunset_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string timeOfSunset = 3;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearTimeOfSunset() {

      timeOfSunset_ = getDefaultInstance().getTimeOfSunset();
      onChanged();
      return this;
    }
    /**
     * <code>string timeOfSunset = 3;</code>
     *
     * @param value The bytes for timeOfSunset to set.
     * @return This builder for chaining.
     */
    public Builder setTimeOfSunsetBytes(com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      checkByteStringIsUtf8(value);

      timeOfSunset_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object startTime_ = "";
    /**
     * <code>string startTime = 4;</code>
     *
     * @return The startTime.
     */
    public java.lang.String getStartTime() {
      java.lang.Object ref = startTime_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        startTime_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string startTime = 4;</code>
     *
     * @return The bytes for startTime.
     */
    public com.google.protobuf.ByteString getStartTimeBytes() {
      java.lang.Object ref = startTime_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        startTime_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string startTime = 4;</code>
     *
     * @param value The startTime to set.
     * @return This builder for chaining.
     */
    public Builder setStartTime(java.lang.String value) {
      if (value == null) {
        throw new NullPointerException();
      }

      startTime_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string startTime = 4;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearStartTime() {

      startTime_ = getDefaultInstance().getStartTime();
      onChanged();
      return this;
    }
    /**
     * <code>string startTime = 4;</code>
     *
     * @param value The bytes for startTime to set.
     * @return This builder for chaining.
     */
    public Builder setStartTimeBytes(com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      checkByteStringIsUtf8(value);

      startTime_ = value;
      onChanged();
      return this;
    }

    private com.cpdss.common.generated.loading_plan.LoadingPlanModels.TrimAllowed trimAllowed_;
    private com.google.protobuf.SingleFieldBuilderV3<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.TrimAllowed,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.TrimAllowed.Builder,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.TrimAllowedOrBuilder>
        trimAllowedBuilder_;
    /**
     * <code>.TrimAllowed trimAllowed = 5;</code>
     *
     * @return Whether the trimAllowed field is set.
     */
    public boolean hasTrimAllowed() {
      return trimAllowedBuilder_ != null || trimAllowed_ != null;
    }
    /**
     * <code>.TrimAllowed trimAllowed = 5;</code>
     *
     * @return The trimAllowed.
     */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.TrimAllowed getTrimAllowed() {
      if (trimAllowedBuilder_ == null) {
        return trimAllowed_ == null
            ? com.cpdss.common.generated.loading_plan.LoadingPlanModels.TrimAllowed
                .getDefaultInstance()
            : trimAllowed_;
      } else {
        return trimAllowedBuilder_.getMessage();
      }
    }
    /** <code>.TrimAllowed trimAllowed = 5;</code> */
    public Builder setTrimAllowed(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.TrimAllowed value) {
      if (trimAllowedBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        trimAllowed_ = value;
        onChanged();
      } else {
        trimAllowedBuilder_.setMessage(value);
      }

      return this;
    }
    /** <code>.TrimAllowed trimAllowed = 5;</code> */
    public Builder setTrimAllowed(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.TrimAllowed.Builder
            builderForValue) {
      if (trimAllowedBuilder_ == null) {
        trimAllowed_ = builderForValue.build();
        onChanged();
      } else {
        trimAllowedBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /** <code>.TrimAllowed trimAllowed = 5;</code> */
    public Builder mergeTrimAllowed(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.TrimAllowed value) {
      if (trimAllowedBuilder_ == null) {
        if (trimAllowed_ != null) {
          trimAllowed_ =
              com.cpdss.common.generated.loading_plan.LoadingPlanModels.TrimAllowed.newBuilder(
                      trimAllowed_)
                  .mergeFrom(value)
                  .buildPartial();
        } else {
          trimAllowed_ = value;
        }
        onChanged();
      } else {
        trimAllowedBuilder_.mergeFrom(value);
      }

      return this;
    }
    /** <code>.TrimAllowed trimAllowed = 5;</code> */
    public Builder clearTrimAllowed() {
      if (trimAllowedBuilder_ == null) {
        trimAllowed_ = null;
        onChanged();
      } else {
        trimAllowed_ = null;
        trimAllowedBuilder_ = null;
      }

      return this;
    }
    /** <code>.TrimAllowed trimAllowed = 5;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.TrimAllowed.Builder
        getTrimAllowedBuilder() {

      onChanged();
      return getTrimAllowedFieldBuilder().getBuilder();
    }
    /** <code>.TrimAllowed trimAllowed = 5;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.TrimAllowedOrBuilder
        getTrimAllowedOrBuilder() {
      if (trimAllowedBuilder_ != null) {
        return trimAllowedBuilder_.getMessageOrBuilder();
      } else {
        return trimAllowed_ == null
            ? com.cpdss.common.generated.loading_plan.LoadingPlanModels.TrimAllowed
                .getDefaultInstance()
            : trimAllowed_;
      }
    }
    /** <code>.TrimAllowed trimAllowed = 5;</code> */
    private com.google.protobuf.SingleFieldBuilderV3<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.TrimAllowed,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.TrimAllowed.Builder,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.TrimAllowedOrBuilder>
        getTrimAllowedFieldBuilder() {
      if (trimAllowedBuilder_ == null) {
        trimAllowedBuilder_ =
            new com.google.protobuf.SingleFieldBuilderV3<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.TrimAllowed,
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.TrimAllowed.Builder,
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.TrimAllowedOrBuilder>(
                getTrimAllowed(), getParentForChildren(), isClean());
        trimAllowed_ = null;
      }
      return trimAllowedBuilder_;
    }

    private long voyageId_;
    /**
     * <code>int64 voyageId = 6;</code>
     *
     * @return The voyageId.
     */
    public long getVoyageId() {
      return voyageId_;
    }
    /**
     * <code>int64 voyageId = 6;</code>
     *
     * @param value The voyageId to set.
     * @return This builder for chaining.
     */
    public Builder setVoyageId(long value) {

      voyageId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 voyageId = 6;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearVoyageId() {

      voyageId_ = 0L;
      onChanged();
      return this;
    }

    private java.lang.Object commonDate_ = "";
    /**
     * <code>string commonDate = 7;</code>
     *
     * @return The commonDate.
     */
    public java.lang.String getCommonDate() {
      java.lang.Object ref = commonDate_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        commonDate_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string commonDate = 7;</code>
     *
     * @return The bytes for commonDate.
     */
    public com.google.protobuf.ByteString getCommonDateBytes() {
      java.lang.Object ref = commonDate_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        commonDate_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string commonDate = 7;</code>
     *
     * @param value The commonDate to set.
     * @return This builder for chaining.
     */
    public Builder setCommonDate(java.lang.String value) {
      if (value == null) {
        throw new NullPointerException();
      }

      commonDate_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string commonDate = 7;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearCommonDate() {

      commonDate_ = getDefaultInstance().getCommonDate();
      onChanged();
      return this;
    }
    /**
     * <code>string commonDate = 7;</code>
     *
     * @param value The bytes for commonDate to set.
     * @return This builder for chaining.
     */
    public Builder setCommonDateBytes(com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      checkByteStringIsUtf8(value);

      commonDate_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object slopQuantity_ = "";
    /**
     * <code>string slopQuantity = 8;</code>
     *
     * @return The slopQuantity.
     */
    public java.lang.String getSlopQuantity() {
      java.lang.Object ref = slopQuantity_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        slopQuantity_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string slopQuantity = 8;</code>
     *
     * @return The bytes for slopQuantity.
     */
    public com.google.protobuf.ByteString getSlopQuantityBytes() {
      java.lang.Object ref = slopQuantity_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        slopQuantity_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string slopQuantity = 8;</code>
     *
     * @param value The slopQuantity to set.
     * @return This builder for chaining.
     */
    public Builder setSlopQuantity(java.lang.String value) {
      if (value == null) {
        throw new NullPointerException();
      }

      slopQuantity_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string slopQuantity = 8;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearSlopQuantity() {

      slopQuantity_ = getDefaultInstance().getSlopQuantity();
      onChanged();
      return this;
    }
    /**
     * <code>string slopQuantity = 8;</code>
     *
     * @param value The bytes for slopQuantity to set.
     * @return This builder for chaining.
     */
    public Builder setSlopQuantityBytes(com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      checkByteStringIsUtf8(value);

      slopQuantity_ = value;
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

    // @@protoc_insertion_point(builder_scope:DischargeDetails)
  }

  // @@protoc_insertion_point(class_scope:DischargeDetails)
  private static final com.cpdss.common.generated.discharge_plan.DischargeDetails DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new com.cpdss.common.generated.discharge_plan.DischargeDetails();
  }

  public static com.cpdss.common.generated.discharge_plan.DischargeDetails getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<DischargeDetails> PARSER =
      new com.google.protobuf.AbstractParser<DischargeDetails>() {
        @java.lang.Override
        public DischargeDetails parsePartialFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
          return new DischargeDetails(input, extensionRegistry);
        }
      };

  public static com.google.protobuf.Parser<DischargeDetails> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<DischargeDetails> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.cpdss.common.generated.discharge_plan.DischargeDetails getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
}
