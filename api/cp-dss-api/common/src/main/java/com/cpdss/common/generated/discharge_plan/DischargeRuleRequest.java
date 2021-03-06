/* Licensed at AlphaOri Technologies */
package com.cpdss.common.generated.discharge_plan;

/** Protobuf type {@code DischargeRuleRequest} */
public final class DischargeRuleRequest extends com.google.protobuf.GeneratedMessageV3
    implements
    // @@protoc_insertion_point(message_implements:DischargeRuleRequest)
    DischargeRuleRequestOrBuilder {
  private static final long serialVersionUID = 0L;
  // Use DischargeRuleRequest.newBuilder() to construct.
  private DischargeRuleRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }

  private DischargeRuleRequest() {
    rulePlan_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
    return new DischargeRuleRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }

  private DischargeRuleRequest(
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
              vesselId_ = input.readInt64();
              break;
            }
          case 16:
            {
              sectionId_ = input.readInt64();
              break;
            }
          case 26:
            {
              if (!((mutable_bitField0_ & 0x00000001) != 0)) {
                rulePlan_ = new java.util.ArrayList<com.cpdss.common.generated.Common.RulePlans>();
                mutable_bitField0_ |= 0x00000001;
              }
              rulePlan_.add(
                  input.readMessage(
                      com.cpdss.common.generated.Common.RulePlans.parser(), extensionRegistry));
              break;
            }
          case 32:
            {
              dischargeInfoId_ = input.readInt64();
              break;
            }
          case 40:
            {
              isNoDefaultRule_ = input.readBool();
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
        rulePlan_ = java.util.Collections.unmodifiableList(rulePlan_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }

  public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
    return com.cpdss.common.generated.discharge_plan.DischargePlanModels
        .internal_static_DischargeRuleRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.cpdss.common.generated.discharge_plan.DischargePlanModels
        .internal_static_DischargeRuleRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.cpdss.common.generated.discharge_plan.DischargeRuleRequest.class,
            com.cpdss.common.generated.discharge_plan.DischargeRuleRequest.Builder.class);
  }

  public static final int VESSELID_FIELD_NUMBER = 1;
  private long vesselId_;
  /**
   * <code>int64 vesselId = 1;</code>
   *
   * @return The vesselId.
   */
  public long getVesselId() {
    return vesselId_;
  }

  public static final int SECTIONID_FIELD_NUMBER = 2;
  private long sectionId_;
  /**
   * <code>int64 sectionId = 2;</code>
   *
   * @return The sectionId.
   */
  public long getSectionId() {
    return sectionId_;
  }

  public static final int RULEPLAN_FIELD_NUMBER = 3;
  private java.util.List<com.cpdss.common.generated.Common.RulePlans> rulePlan_;
  /** <code>repeated .RulePlans rulePlan = 3;</code> */
  public java.util.List<com.cpdss.common.generated.Common.RulePlans> getRulePlanList() {
    return rulePlan_;
  }
  /** <code>repeated .RulePlans rulePlan = 3;</code> */
  public java.util.List<? extends com.cpdss.common.generated.Common.RulePlansOrBuilder>
      getRulePlanOrBuilderList() {
    return rulePlan_;
  }
  /** <code>repeated .RulePlans rulePlan = 3;</code> */
  public int getRulePlanCount() {
    return rulePlan_.size();
  }
  /** <code>repeated .RulePlans rulePlan = 3;</code> */
  public com.cpdss.common.generated.Common.RulePlans getRulePlan(int index) {
    return rulePlan_.get(index);
  }
  /** <code>repeated .RulePlans rulePlan = 3;</code> */
  public com.cpdss.common.generated.Common.RulePlansOrBuilder getRulePlanOrBuilder(int index) {
    return rulePlan_.get(index);
  }

  public static final int DISCHARGEINFOID_FIELD_NUMBER = 4;
  private long dischargeInfoId_;
  /**
   * <code>int64 dischargeInfoId = 4;</code>
   *
   * @return The dischargeInfoId.
   */
  public long getDischargeInfoId() {
    return dischargeInfoId_;
  }

  public static final int ISNODEFAULTRULE_FIELD_NUMBER = 5;
  private boolean isNoDefaultRule_;
  /**
   * <code>bool isNoDefaultRule = 5;</code>
   *
   * @return The isNoDefaultRule.
   */
  public boolean getIsNoDefaultRule() {
    return isNoDefaultRule_;
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
    if (vesselId_ != 0L) {
      output.writeInt64(1, vesselId_);
    }
    if (sectionId_ != 0L) {
      output.writeInt64(2, sectionId_);
    }
    for (int i = 0; i < rulePlan_.size(); i++) {
      output.writeMessage(3, rulePlan_.get(i));
    }
    if (dischargeInfoId_ != 0L) {
      output.writeInt64(4, dischargeInfoId_);
    }
    if (isNoDefaultRule_ != false) {
      output.writeBool(5, isNoDefaultRule_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (vesselId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream.computeInt64Size(1, vesselId_);
    }
    if (sectionId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream.computeInt64Size(2, sectionId_);
    }
    for (int i = 0; i < rulePlan_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream.computeMessageSize(3, rulePlan_.get(i));
    }
    if (dischargeInfoId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream.computeInt64Size(4, dischargeInfoId_);
    }
    if (isNoDefaultRule_ != false) {
      size += com.google.protobuf.CodedOutputStream.computeBoolSize(5, isNoDefaultRule_);
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
    if (!(obj instanceof com.cpdss.common.generated.discharge_plan.DischargeRuleRequest)) {
      return super.equals(obj);
    }
    com.cpdss.common.generated.discharge_plan.DischargeRuleRequest other =
        (com.cpdss.common.generated.discharge_plan.DischargeRuleRequest) obj;

    if (getVesselId() != other.getVesselId()) return false;
    if (getSectionId() != other.getSectionId()) return false;
    if (!getRulePlanList().equals(other.getRulePlanList())) return false;
    if (getDischargeInfoId() != other.getDischargeInfoId()) return false;
    if (getIsNoDefaultRule() != other.getIsNoDefaultRule()) return false;
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
    hash = (37 * hash) + VESSELID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getVesselId());
    hash = (37 * hash) + SECTIONID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getSectionId());
    if (getRulePlanCount() > 0) {
      hash = (37 * hash) + RULEPLAN_FIELD_NUMBER;
      hash = (53 * hash) + getRulePlanList().hashCode();
    }
    hash = (37 * hash) + DISCHARGEINFOID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getDischargeInfoId());
    hash = (37 * hash) + ISNODEFAULTRULE_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(getIsNoDefaultRule());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.cpdss.common.generated.discharge_plan.DischargeRuleRequest parseFrom(
      java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargeRuleRequest parseFrom(
      java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargeRuleRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargeRuleRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargeRuleRequest parseFrom(
      byte[] data) throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargeRuleRequest parseFrom(
      byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargeRuleRequest parseFrom(
      java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargeRuleRequest parseFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargeRuleRequest parseDelimitedFrom(
      java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargeRuleRequest parseDelimitedFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargeRuleRequest parseFrom(
      com.google.protobuf.CodedInputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargeRuleRequest parseFrom(
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
      com.cpdss.common.generated.discharge_plan.DischargeRuleRequest prototype) {
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
  /** Protobuf type {@code DischargeRuleRequest} */
  public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
      implements
      // @@protoc_insertion_point(builder_implements:DischargeRuleRequest)
      com.cpdss.common.generated.discharge_plan.DischargeRuleRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanModels
          .internal_static_DischargeRuleRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanModels
          .internal_static_DischargeRuleRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.discharge_plan.DischargeRuleRequest.class,
              com.cpdss.common.generated.discharge_plan.DischargeRuleRequest.Builder.class);
    }

    // Construct using com.cpdss.common.generated.discharge_plan.DischargeRuleRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {
        getRulePlanFieldBuilder();
      }
    }

    @java.lang.Override
    public Builder clear() {
      super.clear();
      vesselId_ = 0L;

      sectionId_ = 0L;

      if (rulePlanBuilder_ == null) {
        rulePlan_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        rulePlanBuilder_.clear();
      }
      dischargeInfoId_ = 0L;

      isNoDefaultRule_ = false;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanModels
          .internal_static_DischargeRuleRequest_descriptor;
    }

    @java.lang.Override
    public com.cpdss.common.generated.discharge_plan.DischargeRuleRequest
        getDefaultInstanceForType() {
      return com.cpdss.common.generated.discharge_plan.DischargeRuleRequest.getDefaultInstance();
    }

    @java.lang.Override
    public com.cpdss.common.generated.discharge_plan.DischargeRuleRequest build() {
      com.cpdss.common.generated.discharge_plan.DischargeRuleRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.cpdss.common.generated.discharge_plan.DischargeRuleRequest buildPartial() {
      com.cpdss.common.generated.discharge_plan.DischargeRuleRequest result =
          new com.cpdss.common.generated.discharge_plan.DischargeRuleRequest(this);
      int from_bitField0_ = bitField0_;
      result.vesselId_ = vesselId_;
      result.sectionId_ = sectionId_;
      if (rulePlanBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          rulePlan_ = java.util.Collections.unmodifiableList(rulePlan_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.rulePlan_ = rulePlan_;
      } else {
        result.rulePlan_ = rulePlanBuilder_.build();
      }
      result.dischargeInfoId_ = dischargeInfoId_;
      result.isNoDefaultRule_ = isNoDefaultRule_;
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
      if (other instanceof com.cpdss.common.generated.discharge_plan.DischargeRuleRequest) {
        return mergeFrom((com.cpdss.common.generated.discharge_plan.DischargeRuleRequest) other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.cpdss.common.generated.discharge_plan.DischargeRuleRequest other) {
      if (other
          == com.cpdss.common.generated.discharge_plan.DischargeRuleRequest.getDefaultInstance())
        return this;
      if (other.getVesselId() != 0L) {
        setVesselId(other.getVesselId());
      }
      if (other.getSectionId() != 0L) {
        setSectionId(other.getSectionId());
      }
      if (rulePlanBuilder_ == null) {
        if (!other.rulePlan_.isEmpty()) {
          if (rulePlan_.isEmpty()) {
            rulePlan_ = other.rulePlan_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureRulePlanIsMutable();
            rulePlan_.addAll(other.rulePlan_);
          }
          onChanged();
        }
      } else {
        if (!other.rulePlan_.isEmpty()) {
          if (rulePlanBuilder_.isEmpty()) {
            rulePlanBuilder_.dispose();
            rulePlanBuilder_ = null;
            rulePlan_ = other.rulePlan_;
            bitField0_ = (bitField0_ & ~0x00000001);
            rulePlanBuilder_ =
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
                    ? getRulePlanFieldBuilder()
                    : null;
          } else {
            rulePlanBuilder_.addAllMessages(other.rulePlan_);
          }
        }
      }
      if (other.getDischargeInfoId() != 0L) {
        setDischargeInfoId(other.getDischargeInfoId());
      }
      if (other.getIsNoDefaultRule() != false) {
        setIsNoDefaultRule(other.getIsNoDefaultRule());
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
      com.cpdss.common.generated.discharge_plan.DischargeRuleRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage =
            (com.cpdss.common.generated.discharge_plan.DischargeRuleRequest)
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

    private long vesselId_;
    /**
     * <code>int64 vesselId = 1;</code>
     *
     * @return The vesselId.
     */
    public long getVesselId() {
      return vesselId_;
    }
    /**
     * <code>int64 vesselId = 1;</code>
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
     * <code>int64 vesselId = 1;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearVesselId() {

      vesselId_ = 0L;
      onChanged();
      return this;
    }

    private long sectionId_;
    /**
     * <code>int64 sectionId = 2;</code>
     *
     * @return The sectionId.
     */
    public long getSectionId() {
      return sectionId_;
    }
    /**
     * <code>int64 sectionId = 2;</code>
     *
     * @param value The sectionId to set.
     * @return This builder for chaining.
     */
    public Builder setSectionId(long value) {

      sectionId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 sectionId = 2;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearSectionId() {

      sectionId_ = 0L;
      onChanged();
      return this;
    }

    private java.util.List<com.cpdss.common.generated.Common.RulePlans> rulePlan_ =
        java.util.Collections.emptyList();

    private void ensureRulePlanIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        rulePlan_ = new java.util.ArrayList<com.cpdss.common.generated.Common.RulePlans>(rulePlan_);
        bitField0_ |= 0x00000001;
      }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.Common.RulePlans,
            com.cpdss.common.generated.Common.RulePlans.Builder,
            com.cpdss.common.generated.Common.RulePlansOrBuilder>
        rulePlanBuilder_;

    /** <code>repeated .RulePlans rulePlan = 3;</code> */
    public java.util.List<com.cpdss.common.generated.Common.RulePlans> getRulePlanList() {
      if (rulePlanBuilder_ == null) {
        return java.util.Collections.unmodifiableList(rulePlan_);
      } else {
        return rulePlanBuilder_.getMessageList();
      }
    }
    /** <code>repeated .RulePlans rulePlan = 3;</code> */
    public int getRulePlanCount() {
      if (rulePlanBuilder_ == null) {
        return rulePlan_.size();
      } else {
        return rulePlanBuilder_.getCount();
      }
    }
    /** <code>repeated .RulePlans rulePlan = 3;</code> */
    public com.cpdss.common.generated.Common.RulePlans getRulePlan(int index) {
      if (rulePlanBuilder_ == null) {
        return rulePlan_.get(index);
      } else {
        return rulePlanBuilder_.getMessage(index);
      }
    }
    /** <code>repeated .RulePlans rulePlan = 3;</code> */
    public Builder setRulePlan(int index, com.cpdss.common.generated.Common.RulePlans value) {
      if (rulePlanBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureRulePlanIsMutable();
        rulePlan_.set(index, value);
        onChanged();
      } else {
        rulePlanBuilder_.setMessage(index, value);
      }
      return this;
    }
    /** <code>repeated .RulePlans rulePlan = 3;</code> */
    public Builder setRulePlan(
        int index, com.cpdss.common.generated.Common.RulePlans.Builder builderForValue) {
      if (rulePlanBuilder_ == null) {
        ensureRulePlanIsMutable();
        rulePlan_.set(index, builderForValue.build());
        onChanged();
      } else {
        rulePlanBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .RulePlans rulePlan = 3;</code> */
    public Builder addRulePlan(com.cpdss.common.generated.Common.RulePlans value) {
      if (rulePlanBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureRulePlanIsMutable();
        rulePlan_.add(value);
        onChanged();
      } else {
        rulePlanBuilder_.addMessage(value);
      }
      return this;
    }
    /** <code>repeated .RulePlans rulePlan = 3;</code> */
    public Builder addRulePlan(int index, com.cpdss.common.generated.Common.RulePlans value) {
      if (rulePlanBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureRulePlanIsMutable();
        rulePlan_.add(index, value);
        onChanged();
      } else {
        rulePlanBuilder_.addMessage(index, value);
      }
      return this;
    }
    /** <code>repeated .RulePlans rulePlan = 3;</code> */
    public Builder addRulePlan(
        com.cpdss.common.generated.Common.RulePlans.Builder builderForValue) {
      if (rulePlanBuilder_ == null) {
        ensureRulePlanIsMutable();
        rulePlan_.add(builderForValue.build());
        onChanged();
      } else {
        rulePlanBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .RulePlans rulePlan = 3;</code> */
    public Builder addRulePlan(
        int index, com.cpdss.common.generated.Common.RulePlans.Builder builderForValue) {
      if (rulePlanBuilder_ == null) {
        ensureRulePlanIsMutable();
        rulePlan_.add(index, builderForValue.build());
        onChanged();
      } else {
        rulePlanBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .RulePlans rulePlan = 3;</code> */
    public Builder addAllRulePlan(
        java.lang.Iterable<? extends com.cpdss.common.generated.Common.RulePlans> values) {
      if (rulePlanBuilder_ == null) {
        ensureRulePlanIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(values, rulePlan_);
        onChanged();
      } else {
        rulePlanBuilder_.addAllMessages(values);
      }
      return this;
    }
    /** <code>repeated .RulePlans rulePlan = 3;</code> */
    public Builder clearRulePlan() {
      if (rulePlanBuilder_ == null) {
        rulePlan_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        rulePlanBuilder_.clear();
      }
      return this;
    }
    /** <code>repeated .RulePlans rulePlan = 3;</code> */
    public Builder removeRulePlan(int index) {
      if (rulePlanBuilder_ == null) {
        ensureRulePlanIsMutable();
        rulePlan_.remove(index);
        onChanged();
      } else {
        rulePlanBuilder_.remove(index);
      }
      return this;
    }
    /** <code>repeated .RulePlans rulePlan = 3;</code> */
    public com.cpdss.common.generated.Common.RulePlans.Builder getRulePlanBuilder(int index) {
      return getRulePlanFieldBuilder().getBuilder(index);
    }
    /** <code>repeated .RulePlans rulePlan = 3;</code> */
    public com.cpdss.common.generated.Common.RulePlansOrBuilder getRulePlanOrBuilder(int index) {
      if (rulePlanBuilder_ == null) {
        return rulePlan_.get(index);
      } else {
        return rulePlanBuilder_.getMessageOrBuilder(index);
      }
    }
    /** <code>repeated .RulePlans rulePlan = 3;</code> */
    public java.util.List<? extends com.cpdss.common.generated.Common.RulePlansOrBuilder>
        getRulePlanOrBuilderList() {
      if (rulePlanBuilder_ != null) {
        return rulePlanBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(rulePlan_);
      }
    }
    /** <code>repeated .RulePlans rulePlan = 3;</code> */
    public com.cpdss.common.generated.Common.RulePlans.Builder addRulePlanBuilder() {
      return getRulePlanFieldBuilder()
          .addBuilder(com.cpdss.common.generated.Common.RulePlans.getDefaultInstance());
    }
    /** <code>repeated .RulePlans rulePlan = 3;</code> */
    public com.cpdss.common.generated.Common.RulePlans.Builder addRulePlanBuilder(int index) {
      return getRulePlanFieldBuilder()
          .addBuilder(index, com.cpdss.common.generated.Common.RulePlans.getDefaultInstance());
    }
    /** <code>repeated .RulePlans rulePlan = 3;</code> */
    public java.util.List<com.cpdss.common.generated.Common.RulePlans.Builder>
        getRulePlanBuilderList() {
      return getRulePlanFieldBuilder().getBuilderList();
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.Common.RulePlans,
            com.cpdss.common.generated.Common.RulePlans.Builder,
            com.cpdss.common.generated.Common.RulePlansOrBuilder>
        getRulePlanFieldBuilder() {
      if (rulePlanBuilder_ == null) {
        rulePlanBuilder_ =
            new com.google.protobuf.RepeatedFieldBuilderV3<
                com.cpdss.common.generated.Common.RulePlans,
                com.cpdss.common.generated.Common.RulePlans.Builder,
                com.cpdss.common.generated.Common.RulePlansOrBuilder>(
                rulePlan_, ((bitField0_ & 0x00000001) != 0), getParentForChildren(), isClean());
        rulePlan_ = null;
      }
      return rulePlanBuilder_;
    }

    private long dischargeInfoId_;
    /**
     * <code>int64 dischargeInfoId = 4;</code>
     *
     * @return The dischargeInfoId.
     */
    public long getDischargeInfoId() {
      return dischargeInfoId_;
    }
    /**
     * <code>int64 dischargeInfoId = 4;</code>
     *
     * @param value The dischargeInfoId to set.
     * @return This builder for chaining.
     */
    public Builder setDischargeInfoId(long value) {

      dischargeInfoId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 dischargeInfoId = 4;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearDischargeInfoId() {

      dischargeInfoId_ = 0L;
      onChanged();
      return this;
    }

    private boolean isNoDefaultRule_;
    /**
     * <code>bool isNoDefaultRule = 5;</code>
     *
     * @return The isNoDefaultRule.
     */
    public boolean getIsNoDefaultRule() {
      return isNoDefaultRule_;
    }
    /**
     * <code>bool isNoDefaultRule = 5;</code>
     *
     * @param value The isNoDefaultRule to set.
     * @return This builder for chaining.
     */
    public Builder setIsNoDefaultRule(boolean value) {

      isNoDefaultRule_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool isNoDefaultRule = 5;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearIsNoDefaultRule() {

      isNoDefaultRule_ = false;
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

    // @@protoc_insertion_point(builder_scope:DischargeRuleRequest)
  }

  // @@protoc_insertion_point(class_scope:DischargeRuleRequest)
  private static final com.cpdss.common.generated.discharge_plan.DischargeRuleRequest
      DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new com.cpdss.common.generated.discharge_plan.DischargeRuleRequest();
  }

  public static com.cpdss.common.generated.discharge_plan.DischargeRuleRequest
      getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<DischargeRuleRequest> PARSER =
      new com.google.protobuf.AbstractParser<DischargeRuleRequest>() {
        @java.lang.Override
        public DischargeRuleRequest parsePartialFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
          return new DischargeRuleRequest(input, extensionRegistry);
        }
      };

  public static com.google.protobuf.Parser<DischargeRuleRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<DischargeRuleRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.cpdss.common.generated.discharge_plan.DischargeRuleRequest
      getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
}
