/* Licensed at AlphaOri Technologies */
package com.cpdss.common.generated.discharge_plan;

/** Protobuf type {@code CowTankDetails} */
public final class CowTankDetails extends com.google.protobuf.GeneratedMessageV3
    implements
    // @@protoc_insertion_point(message_implements:CowTankDetails)
    CowTankDetailsOrBuilder {
  private static final long serialVersionUID = 0L;
  // Use CowTankDetails.newBuilder() to construct.
  private CowTankDetails(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }

  private CowTankDetails() {
    cowType_ = 0;
    tankIds_ = emptyLongList();
    cargoForCow_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
    return new CowTankDetails();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }

  private CowTankDetails(
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
              int rawValue = input.readEnum();

              cowType_ = rawValue;
              break;
            }
          case 16:
            {
              if (!((mutable_bitField0_ & 0x00000001) != 0)) {
                tankIds_ = newLongList();
                mutable_bitField0_ |= 0x00000001;
              }
              tankIds_.addLong(input.readInt64());
              break;
            }
          case 18:
            {
              int length = input.readRawVarint32();
              int limit = input.pushLimit(length);
              if (!((mutable_bitField0_ & 0x00000001) != 0) && input.getBytesUntilLimit() > 0) {
                tankIds_ = newLongList();
                mutable_bitField0_ |= 0x00000001;
              }
              while (input.getBytesUntilLimit() > 0) {
                tankIds_.addLong(input.readInt64());
              }
              input.popLimit(limit);
              break;
            }
          case 26:
            {
              if (!((mutable_bitField0_ & 0x00000002) != 0)) {
                cargoForCow_ =
                    new java.util.ArrayList<
                        com.cpdss.common.generated.discharge_plan.CargoForCow>();
                mutable_bitField0_ |= 0x00000002;
              }
              cargoForCow_.add(
                  input.readMessage(
                      com.cpdss.common.generated.discharge_plan.CargoForCow.parser(),
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
        tankIds_.makeImmutable(); // C
      }
      if (((mutable_bitField0_ & 0x00000002) != 0)) {
        cargoForCow_ = java.util.Collections.unmodifiableList(cargoForCow_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }

  public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
    return com.cpdss.common.generated.discharge_plan.DischargePlanModels
        .internal_static_CowTankDetails_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.cpdss.common.generated.discharge_plan.DischargePlanModels
        .internal_static_CowTankDetails_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.cpdss.common.generated.discharge_plan.CowTankDetails.class,
            com.cpdss.common.generated.discharge_plan.CowTankDetails.Builder.class);
  }

  public static final int COWTYPE_FIELD_NUMBER = 1;
  private int cowType_;
  /**
   * <code>.COW_TYPE cowType = 1;</code>
   *
   * @return The enum numeric value on the wire for cowType.
   */
  public int getCowTypeValue() {
    return cowType_;
  }
  /**
   * <code>.COW_TYPE cowType = 1;</code>
   *
   * @return The cowType.
   */
  public com.cpdss.common.generated.Common.COW_TYPE getCowType() {
    @SuppressWarnings("deprecation")
    com.cpdss.common.generated.Common.COW_TYPE result =
        com.cpdss.common.generated.Common.COW_TYPE.valueOf(cowType_);
    return result == null ? com.cpdss.common.generated.Common.COW_TYPE.UNRECOGNIZED : result;
  }

  public static final int TANKIDS_FIELD_NUMBER = 2;
  private com.google.protobuf.Internal.LongList tankIds_;
  /**
   * <code>repeated int64 tankIds = 2;</code>
   *
   * @return A list containing the tankIds.
   */
  public java.util.List<java.lang.Long> getTankIdsList() {
    return tankIds_;
  }
  /**
   * <code>repeated int64 tankIds = 2;</code>
   *
   * @return The count of tankIds.
   */
  public int getTankIdsCount() {
    return tankIds_.size();
  }
  /**
   * <code>repeated int64 tankIds = 2;</code>
   *
   * @param index The index of the element to return.
   * @return The tankIds at the given index.
   */
  public long getTankIds(int index) {
    return tankIds_.getLong(index);
  }

  private int tankIdsMemoizedSerializedSize = -1;

  public static final int CARGOFORCOW_FIELD_NUMBER = 3;
  private java.util.List<com.cpdss.common.generated.discharge_plan.CargoForCow> cargoForCow_;
  /** <code>repeated .CargoForCow cargoForCow = 3;</code> */
  public java.util.List<com.cpdss.common.generated.discharge_plan.CargoForCow>
      getCargoForCowList() {
    return cargoForCow_;
  }
  /** <code>repeated .CargoForCow cargoForCow = 3;</code> */
  public java.util.List<? extends com.cpdss.common.generated.discharge_plan.CargoForCowOrBuilder>
      getCargoForCowOrBuilderList() {
    return cargoForCow_;
  }
  /** <code>repeated .CargoForCow cargoForCow = 3;</code> */
  public int getCargoForCowCount() {
    return cargoForCow_.size();
  }
  /** <code>repeated .CargoForCow cargoForCow = 3;</code> */
  public com.cpdss.common.generated.discharge_plan.CargoForCow getCargoForCow(int index) {
    return cargoForCow_.get(index);
  }
  /** <code>repeated .CargoForCow cargoForCow = 3;</code> */
  public com.cpdss.common.generated.discharge_plan.CargoForCowOrBuilder getCargoForCowOrBuilder(
      int index) {
    return cargoForCow_.get(index);
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
    getSerializedSize();
    if (cowType_ != com.cpdss.common.generated.Common.COW_TYPE.EMPTY_COW_TYPE.getNumber()) {
      output.writeEnum(1, cowType_);
    }
    if (getTankIdsList().size() > 0) {
      output.writeUInt32NoTag(18);
      output.writeUInt32NoTag(tankIdsMemoizedSerializedSize);
    }
    for (int i = 0; i < tankIds_.size(); i++) {
      output.writeInt64NoTag(tankIds_.getLong(i));
    }
    for (int i = 0; i < cargoForCow_.size(); i++) {
      output.writeMessage(3, cargoForCow_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (cowType_ != com.cpdss.common.generated.Common.COW_TYPE.EMPTY_COW_TYPE.getNumber()) {
      size += com.google.protobuf.CodedOutputStream.computeEnumSize(1, cowType_);
    }
    {
      int dataSize = 0;
      for (int i = 0; i < tankIds_.size(); i++) {
        dataSize +=
            com.google.protobuf.CodedOutputStream.computeInt64SizeNoTag(tankIds_.getLong(i));
      }
      size += dataSize;
      if (!getTankIdsList().isEmpty()) {
        size += 1;
        size += com.google.protobuf.CodedOutputStream.computeInt32SizeNoTag(dataSize);
      }
      tankIdsMemoizedSerializedSize = dataSize;
    }
    for (int i = 0; i < cargoForCow_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream.computeMessageSize(3, cargoForCow_.get(i));
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
    if (!(obj instanceof com.cpdss.common.generated.discharge_plan.CowTankDetails)) {
      return super.equals(obj);
    }
    com.cpdss.common.generated.discharge_plan.CowTankDetails other =
        (com.cpdss.common.generated.discharge_plan.CowTankDetails) obj;

    if (cowType_ != other.cowType_) return false;
    if (!getTankIdsList().equals(other.getTankIdsList())) return false;
    if (!getCargoForCowList().equals(other.getCargoForCowList())) return false;
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
    hash = (37 * hash) + COWTYPE_FIELD_NUMBER;
    hash = (53 * hash) + cowType_;
    if (getTankIdsCount() > 0) {
      hash = (37 * hash) + TANKIDS_FIELD_NUMBER;
      hash = (53 * hash) + getTankIdsList().hashCode();
    }
    if (getCargoForCowCount() > 0) {
      hash = (37 * hash) + CARGOFORCOW_FIELD_NUMBER;
      hash = (53 * hash) + getCargoForCowList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.cpdss.common.generated.discharge_plan.CowTankDetails parseFrom(
      java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.cpdss.common.generated.discharge_plan.CowTankDetails parseFrom(
      java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.CowTankDetails parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.cpdss.common.generated.discharge_plan.CowTankDetails parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.CowTankDetails parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.cpdss.common.generated.discharge_plan.CowTankDetails parseFrom(
      byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.CowTankDetails parseFrom(
      java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.cpdss.common.generated.discharge_plan.CowTankDetails parseFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.CowTankDetails parseDelimitedFrom(
      java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
  }

  public static com.cpdss.common.generated.discharge_plan.CowTankDetails parseDelimitedFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.CowTankDetails parseFrom(
      com.google.protobuf.CodedInputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.cpdss.common.generated.discharge_plan.CowTankDetails parseFrom(
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
      com.cpdss.common.generated.discharge_plan.CowTankDetails prototype) {
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
  /** Protobuf type {@code CowTankDetails} */
  public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
      implements
      // @@protoc_insertion_point(builder_implements:CowTankDetails)
      com.cpdss.common.generated.discharge_plan.CowTankDetailsOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanModels
          .internal_static_CowTankDetails_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanModels
          .internal_static_CowTankDetails_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.discharge_plan.CowTankDetails.class,
              com.cpdss.common.generated.discharge_plan.CowTankDetails.Builder.class);
    }

    // Construct using com.cpdss.common.generated.discharge_plan.CowTankDetails.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {
        getCargoForCowFieldBuilder();
      }
    }

    @java.lang.Override
    public Builder clear() {
      super.clear();
      cowType_ = 0;

      tankIds_ = emptyLongList();
      bitField0_ = (bitField0_ & ~0x00000001);
      if (cargoForCowBuilder_ == null) {
        cargoForCow_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000002);
      } else {
        cargoForCowBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanModels
          .internal_static_CowTankDetails_descriptor;
    }

    @java.lang.Override
    public com.cpdss.common.generated.discharge_plan.CowTankDetails getDefaultInstanceForType() {
      return com.cpdss.common.generated.discharge_plan.CowTankDetails.getDefaultInstance();
    }

    @java.lang.Override
    public com.cpdss.common.generated.discharge_plan.CowTankDetails build() {
      com.cpdss.common.generated.discharge_plan.CowTankDetails result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.cpdss.common.generated.discharge_plan.CowTankDetails buildPartial() {
      com.cpdss.common.generated.discharge_plan.CowTankDetails result =
          new com.cpdss.common.generated.discharge_plan.CowTankDetails(this);
      int from_bitField0_ = bitField0_;
      result.cowType_ = cowType_;
      if (((bitField0_ & 0x00000001) != 0)) {
        tankIds_.makeImmutable();
        bitField0_ = (bitField0_ & ~0x00000001);
      }
      result.tankIds_ = tankIds_;
      if (cargoForCowBuilder_ == null) {
        if (((bitField0_ & 0x00000002) != 0)) {
          cargoForCow_ = java.util.Collections.unmodifiableList(cargoForCow_);
          bitField0_ = (bitField0_ & ~0x00000002);
        }
        result.cargoForCow_ = cargoForCow_;
      } else {
        result.cargoForCow_ = cargoForCowBuilder_.build();
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
      if (other instanceof com.cpdss.common.generated.discharge_plan.CowTankDetails) {
        return mergeFrom((com.cpdss.common.generated.discharge_plan.CowTankDetails) other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.cpdss.common.generated.discharge_plan.CowTankDetails other) {
      if (other == com.cpdss.common.generated.discharge_plan.CowTankDetails.getDefaultInstance())
        return this;
      if (other.cowType_ != 0) {
        setCowTypeValue(other.getCowTypeValue());
      }
      if (!other.tankIds_.isEmpty()) {
        if (tankIds_.isEmpty()) {
          tankIds_ = other.tankIds_;
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          ensureTankIdsIsMutable();
          tankIds_.addAll(other.tankIds_);
        }
        onChanged();
      }
      if (cargoForCowBuilder_ == null) {
        if (!other.cargoForCow_.isEmpty()) {
          if (cargoForCow_.isEmpty()) {
            cargoForCow_ = other.cargoForCow_;
            bitField0_ = (bitField0_ & ~0x00000002);
          } else {
            ensureCargoForCowIsMutable();
            cargoForCow_.addAll(other.cargoForCow_);
          }
          onChanged();
        }
      } else {
        if (!other.cargoForCow_.isEmpty()) {
          if (cargoForCowBuilder_.isEmpty()) {
            cargoForCowBuilder_.dispose();
            cargoForCowBuilder_ = null;
            cargoForCow_ = other.cargoForCow_;
            bitField0_ = (bitField0_ & ~0x00000002);
            cargoForCowBuilder_ =
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
                    ? getCargoForCowFieldBuilder()
                    : null;
          } else {
            cargoForCowBuilder_.addAllMessages(other.cargoForCow_);
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
      com.cpdss.common.generated.discharge_plan.CowTankDetails parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage =
            (com.cpdss.common.generated.discharge_plan.CowTankDetails) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int bitField0_;

    private int cowType_ = 0;
    /**
     * <code>.COW_TYPE cowType = 1;</code>
     *
     * @return The enum numeric value on the wire for cowType.
     */
    public int getCowTypeValue() {
      return cowType_;
    }
    /**
     * <code>.COW_TYPE cowType = 1;</code>
     *
     * @param value The enum numeric value on the wire for cowType to set.
     * @return This builder for chaining.
     */
    public Builder setCowTypeValue(int value) {
      cowType_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>.COW_TYPE cowType = 1;</code>
     *
     * @return The cowType.
     */
    public com.cpdss.common.generated.Common.COW_TYPE getCowType() {
      @SuppressWarnings("deprecation")
      com.cpdss.common.generated.Common.COW_TYPE result =
          com.cpdss.common.generated.Common.COW_TYPE.valueOf(cowType_);
      return result == null ? com.cpdss.common.generated.Common.COW_TYPE.UNRECOGNIZED : result;
    }
    /**
     * <code>.COW_TYPE cowType = 1;</code>
     *
     * @param value The cowType to set.
     * @return This builder for chaining.
     */
    public Builder setCowType(com.cpdss.common.generated.Common.COW_TYPE value) {
      if (value == null) {
        throw new NullPointerException();
      }

      cowType_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.COW_TYPE cowType = 1;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearCowType() {

      cowType_ = 0;
      onChanged();
      return this;
    }

    private com.google.protobuf.Internal.LongList tankIds_ = emptyLongList();

    private void ensureTankIdsIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        tankIds_ = mutableCopy(tankIds_);
        bitField0_ |= 0x00000001;
      }
    }
    /**
     * <code>repeated int64 tankIds = 2;</code>
     *
     * @return A list containing the tankIds.
     */
    public java.util.List<java.lang.Long> getTankIdsList() {
      return ((bitField0_ & 0x00000001) != 0)
          ? java.util.Collections.unmodifiableList(tankIds_)
          : tankIds_;
    }
    /**
     * <code>repeated int64 tankIds = 2;</code>
     *
     * @return The count of tankIds.
     */
    public int getTankIdsCount() {
      return tankIds_.size();
    }
    /**
     * <code>repeated int64 tankIds = 2;</code>
     *
     * @param index The index of the element to return.
     * @return The tankIds at the given index.
     */
    public long getTankIds(int index) {
      return tankIds_.getLong(index);
    }
    /**
     * <code>repeated int64 tankIds = 2;</code>
     *
     * @param index The index to set the value at.
     * @param value The tankIds to set.
     * @return This builder for chaining.
     */
    public Builder setTankIds(int index, long value) {
      ensureTankIdsIsMutable();
      tankIds_.setLong(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated int64 tankIds = 2;</code>
     *
     * @param value The tankIds to add.
     * @return This builder for chaining.
     */
    public Builder addTankIds(long value) {
      ensureTankIdsIsMutable();
      tankIds_.addLong(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated int64 tankIds = 2;</code>
     *
     * @param values The tankIds to add.
     * @return This builder for chaining.
     */
    public Builder addAllTankIds(java.lang.Iterable<? extends java.lang.Long> values) {
      ensureTankIdsIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(values, tankIds_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated int64 tankIds = 2;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearTankIds() {
      tankIds_ = emptyLongList();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }

    private java.util.List<com.cpdss.common.generated.discharge_plan.CargoForCow> cargoForCow_ =
        java.util.Collections.emptyList();

    private void ensureCargoForCowIsMutable() {
      if (!((bitField0_ & 0x00000002) != 0)) {
        cargoForCow_ =
            new java.util.ArrayList<com.cpdss.common.generated.discharge_plan.CargoForCow>(
                cargoForCow_);
        bitField0_ |= 0x00000002;
      }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.discharge_plan.CargoForCow,
            com.cpdss.common.generated.discharge_plan.CargoForCow.Builder,
            com.cpdss.common.generated.discharge_plan.CargoForCowOrBuilder>
        cargoForCowBuilder_;

    /** <code>repeated .CargoForCow cargoForCow = 3;</code> */
    public java.util.List<com.cpdss.common.generated.discharge_plan.CargoForCow>
        getCargoForCowList() {
      if (cargoForCowBuilder_ == null) {
        return java.util.Collections.unmodifiableList(cargoForCow_);
      } else {
        return cargoForCowBuilder_.getMessageList();
      }
    }
    /** <code>repeated .CargoForCow cargoForCow = 3;</code> */
    public int getCargoForCowCount() {
      if (cargoForCowBuilder_ == null) {
        return cargoForCow_.size();
      } else {
        return cargoForCowBuilder_.getCount();
      }
    }
    /** <code>repeated .CargoForCow cargoForCow = 3;</code> */
    public com.cpdss.common.generated.discharge_plan.CargoForCow getCargoForCow(int index) {
      if (cargoForCowBuilder_ == null) {
        return cargoForCow_.get(index);
      } else {
        return cargoForCowBuilder_.getMessage(index);
      }
    }
    /** <code>repeated .CargoForCow cargoForCow = 3;</code> */
    public Builder setCargoForCow(
        int index, com.cpdss.common.generated.discharge_plan.CargoForCow value) {
      if (cargoForCowBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureCargoForCowIsMutable();
        cargoForCow_.set(index, value);
        onChanged();
      } else {
        cargoForCowBuilder_.setMessage(index, value);
      }
      return this;
    }
    /** <code>repeated .CargoForCow cargoForCow = 3;</code> */
    public Builder setCargoForCow(
        int index, com.cpdss.common.generated.discharge_plan.CargoForCow.Builder builderForValue) {
      if (cargoForCowBuilder_ == null) {
        ensureCargoForCowIsMutable();
        cargoForCow_.set(index, builderForValue.build());
        onChanged();
      } else {
        cargoForCowBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .CargoForCow cargoForCow = 3;</code> */
    public Builder addCargoForCow(com.cpdss.common.generated.discharge_plan.CargoForCow value) {
      if (cargoForCowBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureCargoForCowIsMutable();
        cargoForCow_.add(value);
        onChanged();
      } else {
        cargoForCowBuilder_.addMessage(value);
      }
      return this;
    }
    /** <code>repeated .CargoForCow cargoForCow = 3;</code> */
    public Builder addCargoForCow(
        int index, com.cpdss.common.generated.discharge_plan.CargoForCow value) {
      if (cargoForCowBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureCargoForCowIsMutable();
        cargoForCow_.add(index, value);
        onChanged();
      } else {
        cargoForCowBuilder_.addMessage(index, value);
      }
      return this;
    }
    /** <code>repeated .CargoForCow cargoForCow = 3;</code> */
    public Builder addCargoForCow(
        com.cpdss.common.generated.discharge_plan.CargoForCow.Builder builderForValue) {
      if (cargoForCowBuilder_ == null) {
        ensureCargoForCowIsMutable();
        cargoForCow_.add(builderForValue.build());
        onChanged();
      } else {
        cargoForCowBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .CargoForCow cargoForCow = 3;</code> */
    public Builder addCargoForCow(
        int index, com.cpdss.common.generated.discharge_plan.CargoForCow.Builder builderForValue) {
      if (cargoForCowBuilder_ == null) {
        ensureCargoForCowIsMutable();
        cargoForCow_.add(index, builderForValue.build());
        onChanged();
      } else {
        cargoForCowBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .CargoForCow cargoForCow = 3;</code> */
    public Builder addAllCargoForCow(
        java.lang.Iterable<? extends com.cpdss.common.generated.discharge_plan.CargoForCow>
            values) {
      if (cargoForCowBuilder_ == null) {
        ensureCargoForCowIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(values, cargoForCow_);
        onChanged();
      } else {
        cargoForCowBuilder_.addAllMessages(values);
      }
      return this;
    }
    /** <code>repeated .CargoForCow cargoForCow = 3;</code> */
    public Builder clearCargoForCow() {
      if (cargoForCowBuilder_ == null) {
        cargoForCow_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000002);
        onChanged();
      } else {
        cargoForCowBuilder_.clear();
      }
      return this;
    }
    /** <code>repeated .CargoForCow cargoForCow = 3;</code> */
    public Builder removeCargoForCow(int index) {
      if (cargoForCowBuilder_ == null) {
        ensureCargoForCowIsMutable();
        cargoForCow_.remove(index);
        onChanged();
      } else {
        cargoForCowBuilder_.remove(index);
      }
      return this;
    }
    /** <code>repeated .CargoForCow cargoForCow = 3;</code> */
    public com.cpdss.common.generated.discharge_plan.CargoForCow.Builder getCargoForCowBuilder(
        int index) {
      return getCargoForCowFieldBuilder().getBuilder(index);
    }
    /** <code>repeated .CargoForCow cargoForCow = 3;</code> */
    public com.cpdss.common.generated.discharge_plan.CargoForCowOrBuilder getCargoForCowOrBuilder(
        int index) {
      if (cargoForCowBuilder_ == null) {
        return cargoForCow_.get(index);
      } else {
        return cargoForCowBuilder_.getMessageOrBuilder(index);
      }
    }
    /** <code>repeated .CargoForCow cargoForCow = 3;</code> */
    public java.util.List<? extends com.cpdss.common.generated.discharge_plan.CargoForCowOrBuilder>
        getCargoForCowOrBuilderList() {
      if (cargoForCowBuilder_ != null) {
        return cargoForCowBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(cargoForCow_);
      }
    }
    /** <code>repeated .CargoForCow cargoForCow = 3;</code> */
    public com.cpdss.common.generated.discharge_plan.CargoForCow.Builder addCargoForCowBuilder() {
      return getCargoForCowFieldBuilder()
          .addBuilder(com.cpdss.common.generated.discharge_plan.CargoForCow.getDefaultInstance());
    }
    /** <code>repeated .CargoForCow cargoForCow = 3;</code> */
    public com.cpdss.common.generated.discharge_plan.CargoForCow.Builder addCargoForCowBuilder(
        int index) {
      return getCargoForCowFieldBuilder()
          .addBuilder(
              index, com.cpdss.common.generated.discharge_plan.CargoForCow.getDefaultInstance());
    }
    /** <code>repeated .CargoForCow cargoForCow = 3;</code> */
    public java.util.List<com.cpdss.common.generated.discharge_plan.CargoForCow.Builder>
        getCargoForCowBuilderList() {
      return getCargoForCowFieldBuilder().getBuilderList();
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.discharge_plan.CargoForCow,
            com.cpdss.common.generated.discharge_plan.CargoForCow.Builder,
            com.cpdss.common.generated.discharge_plan.CargoForCowOrBuilder>
        getCargoForCowFieldBuilder() {
      if (cargoForCowBuilder_ == null) {
        cargoForCowBuilder_ =
            new com.google.protobuf.RepeatedFieldBuilderV3<
                com.cpdss.common.generated.discharge_plan.CargoForCow,
                com.cpdss.common.generated.discharge_plan.CargoForCow.Builder,
                com.cpdss.common.generated.discharge_plan.CargoForCowOrBuilder>(
                cargoForCow_, ((bitField0_ & 0x00000002) != 0), getParentForChildren(), isClean());
        cargoForCow_ = null;
      }
      return cargoForCowBuilder_;
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

    // @@protoc_insertion_point(builder_scope:CowTankDetails)
  }

  // @@protoc_insertion_point(class_scope:CowTankDetails)
  private static final com.cpdss.common.generated.discharge_plan.CowTankDetails DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new com.cpdss.common.generated.discharge_plan.CowTankDetails();
  }

  public static com.cpdss.common.generated.discharge_plan.CowTankDetails getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<CowTankDetails> PARSER =
      new com.google.protobuf.AbstractParser<CowTankDetails>() {
        @java.lang.Override
        public CowTankDetails parsePartialFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
          return new CowTankDetails(input, extensionRegistry);
        }
      };

  public static com.google.protobuf.Parser<CowTankDetails> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<CowTankDetails> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.cpdss.common.generated.discharge_plan.CowTankDetails getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
}
