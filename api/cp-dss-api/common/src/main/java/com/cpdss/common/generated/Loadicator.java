/* Licensed at AlphaOri Technologies */
package com.cpdss.common.generated;

public final class Loadicator {
  private Loadicator() {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistryLite registry) {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions((com.google.protobuf.ExtensionRegistryLite) registry);
  }

  public interface LoadicatorRequestOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:LoadicatorRequest)
      com.google.protobuf.MessageOrBuilder {

    /** <code>repeated .StowagePlan stowagePlanDetails = 1;</code> */
    java.util.List<com.cpdss.common.generated.Loadicator.StowagePlan> getStowagePlanDetailsList();
    /** <code>repeated .StowagePlan stowagePlanDetails = 1;</code> */
    com.cpdss.common.generated.Loadicator.StowagePlan getStowagePlanDetails(int index);
    /** <code>repeated .StowagePlan stowagePlanDetails = 1;</code> */
    int getStowagePlanDetailsCount();
    /** <code>repeated .StowagePlan stowagePlanDetails = 1;</code> */
    java.util.List<? extends com.cpdss.common.generated.Loadicator.StowagePlanOrBuilder>
        getStowagePlanDetailsOrBuilderList();
    /** <code>repeated .StowagePlan stowagePlanDetails = 1;</code> */
    com.cpdss.common.generated.Loadicator.StowagePlanOrBuilder getStowagePlanDetailsOrBuilder(
        int index);

    /**
     * <code>bool isPattern = 2;</code>
     *
     * @return The isPattern.
     */
    boolean getIsPattern();

    /**
     * <code>int64 typeId = 3;</code>
     *
     * @return The typeId.
     */
    long getTypeId();

    /**
     * <code>bool isUllageUpdate = 4;</code>
     *
     * @return The isUllageUpdate.
     */
    boolean getIsUllageUpdate();

    /**
     * <code>int32 conditionType = 5;</code>
     *
     * @return The conditionType.
     */
    int getConditionType();
  }
  /** Protobuf type {@code LoadicatorRequest} */
  public static final class LoadicatorRequest extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:LoadicatorRequest)
      LoadicatorRequestOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use LoadicatorRequest.newBuilder() to construct.
    private LoadicatorRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private LoadicatorRequest() {
      stowagePlanDetails_ = java.util.Collections.emptyList();
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new LoadicatorRequest();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private LoadicatorRequest(
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
                  stowagePlanDetails_ =
                      new java.util.ArrayList<com.cpdss.common.generated.Loadicator.StowagePlan>();
                  mutable_bitField0_ |= 0x00000001;
                }
                stowagePlanDetails_.add(
                    input.readMessage(
                        com.cpdss.common.generated.Loadicator.StowagePlan.parser(),
                        extensionRegistry));
                break;
              }
            case 16:
              {
                isPattern_ = input.readBool();
                break;
              }
            case 24:
              {
                typeId_ = input.readInt64();
                break;
              }
            case 32:
              {
                isUllageUpdate_ = input.readBool();
                break;
              }
            case 40:
              {
                conditionType_ = input.readInt32();
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
          stowagePlanDetails_ = java.util.Collections.unmodifiableList(stowagePlanDetails_);
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }

    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.cpdss.common.generated.Loadicator.internal_static_LoadicatorRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.Loadicator
          .internal_static_LoadicatorRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.Loadicator.LoadicatorRequest.class,
              com.cpdss.common.generated.Loadicator.LoadicatorRequest.Builder.class);
    }

    public static final int STOWAGEPLANDETAILS_FIELD_NUMBER = 1;
    private java.util.List<com.cpdss.common.generated.Loadicator.StowagePlan> stowagePlanDetails_;
    /** <code>repeated .StowagePlan stowagePlanDetails = 1;</code> */
    public java.util.List<com.cpdss.common.generated.Loadicator.StowagePlan>
        getStowagePlanDetailsList() {
      return stowagePlanDetails_;
    }
    /** <code>repeated .StowagePlan stowagePlanDetails = 1;</code> */
    public java.util.List<? extends com.cpdss.common.generated.Loadicator.StowagePlanOrBuilder>
        getStowagePlanDetailsOrBuilderList() {
      return stowagePlanDetails_;
    }
    /** <code>repeated .StowagePlan stowagePlanDetails = 1;</code> */
    public int getStowagePlanDetailsCount() {
      return stowagePlanDetails_.size();
    }
    /** <code>repeated .StowagePlan stowagePlanDetails = 1;</code> */
    public com.cpdss.common.generated.Loadicator.StowagePlan getStowagePlanDetails(int index) {
      return stowagePlanDetails_.get(index);
    }
    /** <code>repeated .StowagePlan stowagePlanDetails = 1;</code> */
    public com.cpdss.common.generated.Loadicator.StowagePlanOrBuilder
        getStowagePlanDetailsOrBuilder(int index) {
      return stowagePlanDetails_.get(index);
    }

    public static final int ISPATTERN_FIELD_NUMBER = 2;
    private boolean isPattern_;
    /**
     * <code>bool isPattern = 2;</code>
     *
     * @return The isPattern.
     */
    public boolean getIsPattern() {
      return isPattern_;
    }

    public static final int TYPEID_FIELD_NUMBER = 3;
    private long typeId_;
    /**
     * <code>int64 typeId = 3;</code>
     *
     * @return The typeId.
     */
    public long getTypeId() {
      return typeId_;
    }

    public static final int ISULLAGEUPDATE_FIELD_NUMBER = 4;
    private boolean isUllageUpdate_;
    /**
     * <code>bool isUllageUpdate = 4;</code>
     *
     * @return The isUllageUpdate.
     */
    public boolean getIsUllageUpdate() {
      return isUllageUpdate_;
    }

    public static final int CONDITIONTYPE_FIELD_NUMBER = 5;
    private int conditionType_;
    /**
     * <code>int32 conditionType = 5;</code>
     *
     * @return The conditionType.
     */
    public int getConditionType() {
      return conditionType_;
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
      for (int i = 0; i < stowagePlanDetails_.size(); i++) {
        output.writeMessage(1, stowagePlanDetails_.get(i));
      }
      if (isPattern_ != false) {
        output.writeBool(2, isPattern_);
      }
      if (typeId_ != 0L) {
        output.writeInt64(3, typeId_);
      }
      if (isUllageUpdate_ != false) {
        output.writeBool(4, isUllageUpdate_);
      }
      if (conditionType_ != 0) {
        output.writeInt32(5, conditionType_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      for (int i = 0; i < stowagePlanDetails_.size(); i++) {
        size +=
            com.google.protobuf.CodedOutputStream.computeMessageSize(1, stowagePlanDetails_.get(i));
      }
      if (isPattern_ != false) {
        size += com.google.protobuf.CodedOutputStream.computeBoolSize(2, isPattern_);
      }
      if (typeId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(3, typeId_);
      }
      if (isUllageUpdate_ != false) {
        size += com.google.protobuf.CodedOutputStream.computeBoolSize(4, isUllageUpdate_);
      }
      if (conditionType_ != 0) {
        size += com.google.protobuf.CodedOutputStream.computeInt32Size(5, conditionType_);
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
      if (!(obj instanceof com.cpdss.common.generated.Loadicator.LoadicatorRequest)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.Loadicator.LoadicatorRequest other =
          (com.cpdss.common.generated.Loadicator.LoadicatorRequest) obj;

      if (!getStowagePlanDetailsList().equals(other.getStowagePlanDetailsList())) return false;
      if (getIsPattern() != other.getIsPattern()) return false;
      if (getTypeId() != other.getTypeId()) return false;
      if (getIsUllageUpdate() != other.getIsUllageUpdate()) return false;
      if (getConditionType() != other.getConditionType()) return false;
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
      if (getStowagePlanDetailsCount() > 0) {
        hash = (37 * hash) + STOWAGEPLANDETAILS_FIELD_NUMBER;
        hash = (53 * hash) + getStowagePlanDetailsList().hashCode();
      }
      hash = (37 * hash) + ISPATTERN_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(getIsPattern());
      hash = (37 * hash) + TYPEID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getTypeId());
      hash = (37 * hash) + ISULLAGEUPDATE_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(getIsUllageUpdate());
      hash = (37 * hash) + CONDITIONTYPE_FIELD_NUMBER;
      hash = (53 * hash) + getConditionType();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.Loadicator.LoadicatorRequest parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Loadicator.LoadicatorRequest parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Loadicator.LoadicatorRequest parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Loadicator.LoadicatorRequest parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Loadicator.LoadicatorRequest parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Loadicator.LoadicatorRequest parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Loadicator.LoadicatorRequest parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Loadicator.LoadicatorRequest parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.Loadicator.LoadicatorRequest parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Loadicator.LoadicatorRequest parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.Loadicator.LoadicatorRequest parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Loadicator.LoadicatorRequest parseFrom(
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
        com.cpdss.common.generated.Loadicator.LoadicatorRequest prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }

    @java.lang.Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /** Protobuf type {@code LoadicatorRequest} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:LoadicatorRequest)
        com.cpdss.common.generated.Loadicator.LoadicatorRequestOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.Loadicator.internal_static_LoadicatorRequest_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.Loadicator
            .internal_static_LoadicatorRequest_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.Loadicator.LoadicatorRequest.class,
                com.cpdss.common.generated.Loadicator.LoadicatorRequest.Builder.class);
      }

      // Construct using com.cpdss.common.generated.Loadicator.LoadicatorRequest.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {
          getStowagePlanDetailsFieldBuilder();
        }
      }

      @java.lang.Override
      public Builder clear() {
        super.clear();
        if (stowagePlanDetailsBuilder_ == null) {
          stowagePlanDetails_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          stowagePlanDetailsBuilder_.clear();
        }
        isPattern_ = false;

        typeId_ = 0L;

        isUllageUpdate_ = false;

        conditionType_ = 0;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.Loadicator.internal_static_LoadicatorRequest_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.Loadicator.LoadicatorRequest getDefaultInstanceForType() {
        return com.cpdss.common.generated.Loadicator.LoadicatorRequest.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.Loadicator.LoadicatorRequest build() {
        com.cpdss.common.generated.Loadicator.LoadicatorRequest result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.Loadicator.LoadicatorRequest buildPartial() {
        com.cpdss.common.generated.Loadicator.LoadicatorRequest result =
            new com.cpdss.common.generated.Loadicator.LoadicatorRequest(this);
        int from_bitField0_ = bitField0_;
        if (stowagePlanDetailsBuilder_ == null) {
          if (((bitField0_ & 0x00000001) != 0)) {
            stowagePlanDetails_ = java.util.Collections.unmodifiableList(stowagePlanDetails_);
            bitField0_ = (bitField0_ & ~0x00000001);
          }
          result.stowagePlanDetails_ = stowagePlanDetails_;
        } else {
          result.stowagePlanDetails_ = stowagePlanDetailsBuilder_.build();
        }
        result.isPattern_ = isPattern_;
        result.typeId_ = typeId_;
        result.isUllageUpdate_ = isUllageUpdate_;
        result.conditionType_ = conditionType_;
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
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index,
          java.lang.Object value) {
        return super.setRepeatedField(field, index, value);
      }

      @java.lang.Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field, java.lang.Object value) {
        return super.addRepeatedField(field, value);
      }

      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.cpdss.common.generated.Loadicator.LoadicatorRequest) {
          return mergeFrom((com.cpdss.common.generated.Loadicator.LoadicatorRequest) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.cpdss.common.generated.Loadicator.LoadicatorRequest other) {
        if (other == com.cpdss.common.generated.Loadicator.LoadicatorRequest.getDefaultInstance())
          return this;
        if (stowagePlanDetailsBuilder_ == null) {
          if (!other.stowagePlanDetails_.isEmpty()) {
            if (stowagePlanDetails_.isEmpty()) {
              stowagePlanDetails_ = other.stowagePlanDetails_;
              bitField0_ = (bitField0_ & ~0x00000001);
            } else {
              ensureStowagePlanDetailsIsMutable();
              stowagePlanDetails_.addAll(other.stowagePlanDetails_);
            }
            onChanged();
          }
        } else {
          if (!other.stowagePlanDetails_.isEmpty()) {
            if (stowagePlanDetailsBuilder_.isEmpty()) {
              stowagePlanDetailsBuilder_.dispose();
              stowagePlanDetailsBuilder_ = null;
              stowagePlanDetails_ = other.stowagePlanDetails_;
              bitField0_ = (bitField0_ & ~0x00000001);
              stowagePlanDetailsBuilder_ =
                  com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
                      ? getStowagePlanDetailsFieldBuilder()
                      : null;
            } else {
              stowagePlanDetailsBuilder_.addAllMessages(other.stowagePlanDetails_);
            }
          }
        }
        if (other.getIsPattern() != false) {
          setIsPattern(other.getIsPattern());
        }
        if (other.getTypeId() != 0L) {
          setTypeId(other.getTypeId());
        }
        if (other.getIsUllageUpdate() != false) {
          setIsUllageUpdate(other.getIsUllageUpdate());
        }
        if (other.getConditionType() != 0) {
          setConditionType(other.getConditionType());
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
        com.cpdss.common.generated.Loadicator.LoadicatorRequest parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.Loadicator.LoadicatorRequest) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private int bitField0_;

      private java.util.List<com.cpdss.common.generated.Loadicator.StowagePlan>
          stowagePlanDetails_ = java.util.Collections.emptyList();

      private void ensureStowagePlanDetailsIsMutable() {
        if (!((bitField0_ & 0x00000001) != 0)) {
          stowagePlanDetails_ =
              new java.util.ArrayList<com.cpdss.common.generated.Loadicator.StowagePlan>(
                  stowagePlanDetails_);
          bitField0_ |= 0x00000001;
        }
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
              com.cpdss.common.generated.Loadicator.StowagePlan,
              com.cpdss.common.generated.Loadicator.StowagePlan.Builder,
              com.cpdss.common.generated.Loadicator.StowagePlanOrBuilder>
          stowagePlanDetailsBuilder_;

      /** <code>repeated .StowagePlan stowagePlanDetails = 1;</code> */
      public java.util.List<com.cpdss.common.generated.Loadicator.StowagePlan>
          getStowagePlanDetailsList() {
        if (stowagePlanDetailsBuilder_ == null) {
          return java.util.Collections.unmodifiableList(stowagePlanDetails_);
        } else {
          return stowagePlanDetailsBuilder_.getMessageList();
        }
      }
      /** <code>repeated .StowagePlan stowagePlanDetails = 1;</code> */
      public int getStowagePlanDetailsCount() {
        if (stowagePlanDetailsBuilder_ == null) {
          return stowagePlanDetails_.size();
        } else {
          return stowagePlanDetailsBuilder_.getCount();
        }
      }
      /** <code>repeated .StowagePlan stowagePlanDetails = 1;</code> */
      public com.cpdss.common.generated.Loadicator.StowagePlan getStowagePlanDetails(int index) {
        if (stowagePlanDetailsBuilder_ == null) {
          return stowagePlanDetails_.get(index);
        } else {
          return stowagePlanDetailsBuilder_.getMessage(index);
        }
      }
      /** <code>repeated .StowagePlan stowagePlanDetails = 1;</code> */
      public Builder setStowagePlanDetails(
          int index, com.cpdss.common.generated.Loadicator.StowagePlan value) {
        if (stowagePlanDetailsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureStowagePlanDetailsIsMutable();
          stowagePlanDetails_.set(index, value);
          onChanged();
        } else {
          stowagePlanDetailsBuilder_.setMessage(index, value);
        }
        return this;
      }
      /** <code>repeated .StowagePlan stowagePlanDetails = 1;</code> */
      public Builder setStowagePlanDetails(
          int index, com.cpdss.common.generated.Loadicator.StowagePlan.Builder builderForValue) {
        if (stowagePlanDetailsBuilder_ == null) {
          ensureStowagePlanDetailsIsMutable();
          stowagePlanDetails_.set(index, builderForValue.build());
          onChanged();
        } else {
          stowagePlanDetailsBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .StowagePlan stowagePlanDetails = 1;</code> */
      public Builder addStowagePlanDetails(
          com.cpdss.common.generated.Loadicator.StowagePlan value) {
        if (stowagePlanDetailsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureStowagePlanDetailsIsMutable();
          stowagePlanDetails_.add(value);
          onChanged();
        } else {
          stowagePlanDetailsBuilder_.addMessage(value);
        }
        return this;
      }
      /** <code>repeated .StowagePlan stowagePlanDetails = 1;</code> */
      public Builder addStowagePlanDetails(
          int index, com.cpdss.common.generated.Loadicator.StowagePlan value) {
        if (stowagePlanDetailsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureStowagePlanDetailsIsMutable();
          stowagePlanDetails_.add(index, value);
          onChanged();
        } else {
          stowagePlanDetailsBuilder_.addMessage(index, value);
        }
        return this;
      }
      /** <code>repeated .StowagePlan stowagePlanDetails = 1;</code> */
      public Builder addStowagePlanDetails(
          com.cpdss.common.generated.Loadicator.StowagePlan.Builder builderForValue) {
        if (stowagePlanDetailsBuilder_ == null) {
          ensureStowagePlanDetailsIsMutable();
          stowagePlanDetails_.add(builderForValue.build());
          onChanged();
        } else {
          stowagePlanDetailsBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .StowagePlan stowagePlanDetails = 1;</code> */
      public Builder addStowagePlanDetails(
          int index, com.cpdss.common.generated.Loadicator.StowagePlan.Builder builderForValue) {
        if (stowagePlanDetailsBuilder_ == null) {
          ensureStowagePlanDetailsIsMutable();
          stowagePlanDetails_.add(index, builderForValue.build());
          onChanged();
        } else {
          stowagePlanDetailsBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .StowagePlan stowagePlanDetails = 1;</code> */
      public Builder addAllStowagePlanDetails(
          java.lang.Iterable<? extends com.cpdss.common.generated.Loadicator.StowagePlan> values) {
        if (stowagePlanDetailsBuilder_ == null) {
          ensureStowagePlanDetailsIsMutable();
          com.google.protobuf.AbstractMessageLite.Builder.addAll(values, stowagePlanDetails_);
          onChanged();
        } else {
          stowagePlanDetailsBuilder_.addAllMessages(values);
        }
        return this;
      }
      /** <code>repeated .StowagePlan stowagePlanDetails = 1;</code> */
      public Builder clearStowagePlanDetails() {
        if (stowagePlanDetailsBuilder_ == null) {
          stowagePlanDetails_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
          onChanged();
        } else {
          stowagePlanDetailsBuilder_.clear();
        }
        return this;
      }
      /** <code>repeated .StowagePlan stowagePlanDetails = 1;</code> */
      public Builder removeStowagePlanDetails(int index) {
        if (stowagePlanDetailsBuilder_ == null) {
          ensureStowagePlanDetailsIsMutable();
          stowagePlanDetails_.remove(index);
          onChanged();
        } else {
          stowagePlanDetailsBuilder_.remove(index);
        }
        return this;
      }
      /** <code>repeated .StowagePlan stowagePlanDetails = 1;</code> */
      public com.cpdss.common.generated.Loadicator.StowagePlan.Builder getStowagePlanDetailsBuilder(
          int index) {
        return getStowagePlanDetailsFieldBuilder().getBuilder(index);
      }
      /** <code>repeated .StowagePlan stowagePlanDetails = 1;</code> */
      public com.cpdss.common.generated.Loadicator.StowagePlanOrBuilder
          getStowagePlanDetailsOrBuilder(int index) {
        if (stowagePlanDetailsBuilder_ == null) {
          return stowagePlanDetails_.get(index);
        } else {
          return stowagePlanDetailsBuilder_.getMessageOrBuilder(index);
        }
      }
      /** <code>repeated .StowagePlan stowagePlanDetails = 1;</code> */
      public java.util.List<? extends com.cpdss.common.generated.Loadicator.StowagePlanOrBuilder>
          getStowagePlanDetailsOrBuilderList() {
        if (stowagePlanDetailsBuilder_ != null) {
          return stowagePlanDetailsBuilder_.getMessageOrBuilderList();
        } else {
          return java.util.Collections.unmodifiableList(stowagePlanDetails_);
        }
      }
      /** <code>repeated .StowagePlan stowagePlanDetails = 1;</code> */
      public com.cpdss.common.generated.Loadicator.StowagePlan.Builder
          addStowagePlanDetailsBuilder() {
        return getStowagePlanDetailsFieldBuilder()
            .addBuilder(com.cpdss.common.generated.Loadicator.StowagePlan.getDefaultInstance());
      }
      /** <code>repeated .StowagePlan stowagePlanDetails = 1;</code> */
      public com.cpdss.common.generated.Loadicator.StowagePlan.Builder addStowagePlanDetailsBuilder(
          int index) {
        return getStowagePlanDetailsFieldBuilder()
            .addBuilder(
                index, com.cpdss.common.generated.Loadicator.StowagePlan.getDefaultInstance());
      }
      /** <code>repeated .StowagePlan stowagePlanDetails = 1;</code> */
      public java.util.List<com.cpdss.common.generated.Loadicator.StowagePlan.Builder>
          getStowagePlanDetailsBuilderList() {
        return getStowagePlanDetailsFieldBuilder().getBuilderList();
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
              com.cpdss.common.generated.Loadicator.StowagePlan,
              com.cpdss.common.generated.Loadicator.StowagePlan.Builder,
              com.cpdss.common.generated.Loadicator.StowagePlanOrBuilder>
          getStowagePlanDetailsFieldBuilder() {
        if (stowagePlanDetailsBuilder_ == null) {
          stowagePlanDetailsBuilder_ =
              new com.google.protobuf.RepeatedFieldBuilderV3<
                  com.cpdss.common.generated.Loadicator.StowagePlan,
                  com.cpdss.common.generated.Loadicator.StowagePlan.Builder,
                  com.cpdss.common.generated.Loadicator.StowagePlanOrBuilder>(
                  stowagePlanDetails_,
                  ((bitField0_ & 0x00000001) != 0),
                  getParentForChildren(),
                  isClean());
          stowagePlanDetails_ = null;
        }
        return stowagePlanDetailsBuilder_;
      }

      private boolean isPattern_;
      /**
       * <code>bool isPattern = 2;</code>
       *
       * @return The isPattern.
       */
      public boolean getIsPattern() {
        return isPattern_;
      }
      /**
       * <code>bool isPattern = 2;</code>
       *
       * @param value The isPattern to set.
       * @return This builder for chaining.
       */
      public Builder setIsPattern(boolean value) {

        isPattern_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>bool isPattern = 2;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearIsPattern() {

        isPattern_ = false;
        onChanged();
        return this;
      }

      private long typeId_;
      /**
       * <code>int64 typeId = 3;</code>
       *
       * @return The typeId.
       */
      public long getTypeId() {
        return typeId_;
      }
      /**
       * <code>int64 typeId = 3;</code>
       *
       * @param value The typeId to set.
       * @return This builder for chaining.
       */
      public Builder setTypeId(long value) {

        typeId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int64 typeId = 3;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearTypeId() {

        typeId_ = 0L;
        onChanged();
        return this;
      }

      private boolean isUllageUpdate_;
      /**
       * <code>bool isUllageUpdate = 4;</code>
       *
       * @return The isUllageUpdate.
       */
      public boolean getIsUllageUpdate() {
        return isUllageUpdate_;
      }
      /**
       * <code>bool isUllageUpdate = 4;</code>
       *
       * @param value The isUllageUpdate to set.
       * @return This builder for chaining.
       */
      public Builder setIsUllageUpdate(boolean value) {

        isUllageUpdate_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>bool isUllageUpdate = 4;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearIsUllageUpdate() {

        isUllageUpdate_ = false;
        onChanged();
        return this;
      }

      private int conditionType_;
      /**
       * <code>int32 conditionType = 5;</code>
       *
       * @return The conditionType.
       */
      public int getConditionType() {
        return conditionType_;
      }
      /**
       * <code>int32 conditionType = 5;</code>
       *
       * @param value The conditionType to set.
       * @return This builder for chaining.
       */
      public Builder setConditionType(int value) {

        conditionType_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 conditionType = 5;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearConditionType() {

        conditionType_ = 0;
        onChanged();
        return this;
      }

      @java.lang.Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }

      // @@protoc_insertion_point(builder_scope:LoadicatorRequest)
    }

    // @@protoc_insertion_point(class_scope:LoadicatorRequest)
    private static final com.cpdss.common.generated.Loadicator.LoadicatorRequest DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.Loadicator.LoadicatorRequest();
    }

    public static com.cpdss.common.generated.Loadicator.LoadicatorRequest getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<LoadicatorRequest> PARSER =
        new com.google.protobuf.AbstractParser<LoadicatorRequest>() {
          @java.lang.Override
          public LoadicatorRequest parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new LoadicatorRequest(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<LoadicatorRequest> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<LoadicatorRequest> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.Loadicator.LoadicatorRequest getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface StowagePlanOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:StowagePlan)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int64 id = 1;</code>
     *
     * @return The id.
     */
    long getId();

    /**
     * <code>int64 vesselId = 2;</code>
     *
     * @return The vesselId.
     */
    long getVesselId();

    /**
     * <code>string imoNumber = 3;</code>
     *
     * @return The imoNumber.
     */
    java.lang.String getImoNumber();
    /**
     * <code>string imoNumber = 3;</code>
     *
     * @return The bytes for imoNumber.
     */
    com.google.protobuf.ByteString getImoNumberBytes();

    /**
     * <code>int64 companyId = 4;</code>
     *
     * @return The companyId.
     */
    long getCompanyId();

    /**
     * <code>string shipType = 5;</code>
     *
     * @return The shipType.
     */
    java.lang.String getShipType();
    /**
     * <code>string shipType = 5;</code>
     *
     * @return The bytes for shipType.
     */
    com.google.protobuf.ByteString getShipTypeBytes();

    /**
     * <code>string vesselCode = 6;</code>
     *
     * @return The vesselCode.
     */
    java.lang.String getVesselCode();
    /**
     * <code>string vesselCode = 6;</code>
     *
     * @return The bytes for vesselCode.
     */
    com.google.protobuf.ByteString getVesselCodeBytes();

    /**
     * <code>int64 bookingListId = 7;</code>
     *
     * @return The bookingListId.
     */
    long getBookingListId();

    /**
     * <code>int64 stowageId = 8;</code>
     *
     * @return The stowageId.
     */
    long getStowageId();

    /**
     * <code>int64 portId = 9;</code>
     *
     * @return The portId.
     */
    long getPortId();

    /**
     * <code>string portCode = 10;</code>
     *
     * @return The portCode.
     */
    java.lang.String getPortCode();
    /**
     * <code>string portCode = 10;</code>
     *
     * @return The bytes for portCode.
     */
    com.google.protobuf.ByteString getPortCodeBytes();

    /**
     * <code>int64 status = 11;</code>
     *
     * @return The status.
     */
    long getStatus();

    /**
     * <code>string deadweightConstant = 12;</code>
     *
     * @return The deadweightConstant.
     */
    java.lang.String getDeadweightConstant();
    /**
     * <code>string deadweightConstant = 12;</code>
     *
     * @return The bytes for deadweightConstant.
     */
    com.google.protobuf.ByteString getDeadweightConstantBytes();

    /**
     * <code>string provisionalConstant = 13;</code>
     *
     * @return The provisionalConstant.
     */
    java.lang.String getProvisionalConstant();
    /**
     * <code>string provisionalConstant = 13;</code>
     *
     * @return The bytes for provisionalConstant.
     */
    com.google.protobuf.ByteString getProvisionalConstantBytes();

    /**
     * <code>int64 calCount = 14;</code>
     *
     * @return The calCount.
     */
    long getCalCount();

    /**
     * <code>string saveStatus = 15;</code>
     *
     * @return The saveStatus.
     */
    java.lang.String getSaveStatus();
    /**
     * <code>string saveStatus = 15;</code>
     *
     * @return The bytes for saveStatus.
     */
    com.google.protobuf.ByteString getSaveStatusBytes();

    /**
     * <code>string saveMessage = 16;</code>
     *
     * @return The saveMessage.
     */
    java.lang.String getSaveMessage();
    /**
     * <code>string saveMessage = 16;</code>
     *
     * @return The bytes for saveMessage.
     */
    com.google.protobuf.ByteString getSaveMessageBytes();

    /**
     * <code>bool damageCal = 17;</code>
     *
     * @return The damageCal.
     */
    boolean getDamageCal();

    /**
     * <code>bool dataSave = 18;</code>
     *
     * @return The dataSave.
     */
    boolean getDataSave();

    /**
     * <code>string processId = 19;</code>
     *
     * @return The processId.
     */
    java.lang.String getProcessId();
    /**
     * <code>string processId = 19;</code>
     *
     * @return The bytes for processId.
     */
    com.google.protobuf.ByteString getProcessIdBytes();

    /**
     * <code>int64 synopticalId = 20;</code>
     *
     * @return The synopticalId.
     */
    long getSynopticalId();

    /** <code>repeated .StowageDetails stowageDetails = 21;</code> */
    java.util.List<com.cpdss.common.generated.Loadicator.StowageDetails> getStowageDetailsList();
    /** <code>repeated .StowageDetails stowageDetails = 21;</code> */
    com.cpdss.common.generated.Loadicator.StowageDetails getStowageDetails(int index);
    /** <code>repeated .StowageDetails stowageDetails = 21;</code> */
    int getStowageDetailsCount();
    /** <code>repeated .StowageDetails stowageDetails = 21;</code> */
    java.util.List<? extends com.cpdss.common.generated.Loadicator.StowageDetailsOrBuilder>
        getStowageDetailsOrBuilderList();
    /** <code>repeated .StowageDetails stowageDetails = 21;</code> */
    com.cpdss.common.generated.Loadicator.StowageDetailsOrBuilder getStowageDetailsOrBuilder(
        int index);

    /** <code>repeated .CargoInfo cargoInfo = 22;</code> */
    java.util.List<com.cpdss.common.generated.Loadicator.CargoInfo> getCargoInfoList();
    /** <code>repeated .CargoInfo cargoInfo = 22;</code> */
    com.cpdss.common.generated.Loadicator.CargoInfo getCargoInfo(int index);
    /** <code>repeated .CargoInfo cargoInfo = 22;</code> */
    int getCargoInfoCount();
    /** <code>repeated .CargoInfo cargoInfo = 22;</code> */
    java.util.List<? extends com.cpdss.common.generated.Loadicator.CargoInfoOrBuilder>
        getCargoInfoOrBuilderList();
    /** <code>repeated .CargoInfo cargoInfo = 22;</code> */
    com.cpdss.common.generated.Loadicator.CargoInfoOrBuilder getCargoInfoOrBuilder(int index);

    /** <code>repeated .OtherTankInfo otherTankInfo = 23;</code> */
    java.util.List<com.cpdss.common.generated.Loadicator.OtherTankInfo> getOtherTankInfoList();
    /** <code>repeated .OtherTankInfo otherTankInfo = 23;</code> */
    com.cpdss.common.generated.Loadicator.OtherTankInfo getOtherTankInfo(int index);
    /** <code>repeated .OtherTankInfo otherTankInfo = 23;</code> */
    int getOtherTankInfoCount();
    /** <code>repeated .OtherTankInfo otherTankInfo = 23;</code> */
    java.util.List<? extends com.cpdss.common.generated.Loadicator.OtherTankInfoOrBuilder>
        getOtherTankInfoOrBuilderList();
    /** <code>repeated .OtherTankInfo otherTankInfo = 23;</code> */
    com.cpdss.common.generated.Loadicator.OtherTankInfoOrBuilder getOtherTankInfoOrBuilder(
        int index);

    /** <code>repeated .BallastInfo ballastInfo = 24;</code> */
    java.util.List<com.cpdss.common.generated.Loadicator.BallastInfo> getBallastInfoList();
    /** <code>repeated .BallastInfo ballastInfo = 24;</code> */
    com.cpdss.common.generated.Loadicator.BallastInfo getBallastInfo(int index);
    /** <code>repeated .BallastInfo ballastInfo = 24;</code> */
    int getBallastInfoCount();
    /** <code>repeated .BallastInfo ballastInfo = 24;</code> */
    java.util.List<? extends com.cpdss.common.generated.Loadicator.BallastInfoOrBuilder>
        getBallastInfoOrBuilderList();
    /** <code>repeated .BallastInfo ballastInfo = 24;</code> */
    com.cpdss.common.generated.Loadicator.BallastInfoOrBuilder getBallastInfoOrBuilder(int index);

    /**
     * <code>string seaWaterDensity = 25;</code>
     *
     * @return The seaWaterDensity.
     */
    java.lang.String getSeaWaterDensity();
    /**
     * <code>string seaWaterDensity = 25;</code>
     *
     * @return The bytes for seaWaterDensity.
     */
    com.google.protobuf.ByteString getSeaWaterDensityBytes();

    /**
     * <code>int64 portRotationId = 26;</code>
     *
     * @return The portRotationId.
     */
    long getPortRotationId();

    /**
     * <code>string saveFolder = 27;</code>
     *
     * @return The saveFolder.
     */
    java.lang.String getSaveFolder();
    /**
     * <code>string saveFolder = 27;</code>
     *
     * @return The bytes for saveFolder.
     */
    com.google.protobuf.ByteString getSaveFolderBytes();

    /**
     * <code>string vesselName = 28;</code>
     *
     * @return The vesselName.
     */
    java.lang.String getVesselName();
    /**
     * <code>string vesselName = 28;</code>
     *
     * @return The bytes for vesselName.
     */
    com.google.protobuf.ByteString getVesselNameBytes();

    /**
     * <code>string voyageNumber = 29;</code>
     *
     * @return The voyageNumber.
     */
    java.lang.String getVoyageNumber();
    /**
     * <code>string voyageNumber = 29;</code>
     *
     * @return The bytes for voyageNumber.
     */
    com.google.protobuf.ByteString getVoyageNumberBytes();

    /**
     * <code>string condition = 30;</code>
     *
     * @return The condition.
     */
    java.lang.String getCondition();
    /**
     * <code>string condition = 30;</code>
     *
     * @return The bytes for condition.
     */
    com.google.protobuf.ByteString getConditionBytes();
  }
  /** Protobuf type {@code StowagePlan} */
  public static final class StowagePlan extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:StowagePlan)
      StowagePlanOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use StowagePlan.newBuilder() to construct.
    private StowagePlan(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private StowagePlan() {
      imoNumber_ = "";
      shipType_ = "";
      vesselCode_ = "";
      portCode_ = "";
      deadweightConstant_ = "";
      provisionalConstant_ = "";
      saveStatus_ = "";
      saveMessage_ = "";
      processId_ = "";
      stowageDetails_ = java.util.Collections.emptyList();
      cargoInfo_ = java.util.Collections.emptyList();
      otherTankInfo_ = java.util.Collections.emptyList();
      ballastInfo_ = java.util.Collections.emptyList();
      seaWaterDensity_ = "";
      saveFolder_ = "";
      vesselName_ = "";
      voyageNumber_ = "";
      condition_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new StowagePlan();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private StowagePlan(
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
                id_ = input.readInt64();
                break;
              }
            case 16:
              {
                vesselId_ = input.readInt64();
                break;
              }
            case 26:
              {
                java.lang.String s = input.readStringRequireUtf8();

                imoNumber_ = s;
                break;
              }
            case 32:
              {
                companyId_ = input.readInt64();
                break;
              }
            case 42:
              {
                java.lang.String s = input.readStringRequireUtf8();

                shipType_ = s;
                break;
              }
            case 50:
              {
                java.lang.String s = input.readStringRequireUtf8();

                vesselCode_ = s;
                break;
              }
            case 56:
              {
                bookingListId_ = input.readInt64();
                break;
              }
            case 64:
              {
                stowageId_ = input.readInt64();
                break;
              }
            case 72:
              {
                portId_ = input.readInt64();
                break;
              }
            case 82:
              {
                java.lang.String s = input.readStringRequireUtf8();

                portCode_ = s;
                break;
              }
            case 88:
              {
                status_ = input.readInt64();
                break;
              }
            case 98:
              {
                java.lang.String s = input.readStringRequireUtf8();

                deadweightConstant_ = s;
                break;
              }
            case 106:
              {
                java.lang.String s = input.readStringRequireUtf8();

                provisionalConstant_ = s;
                break;
              }
            case 112:
              {
                calCount_ = input.readInt64();
                break;
              }
            case 122:
              {
                java.lang.String s = input.readStringRequireUtf8();

                saveStatus_ = s;
                break;
              }
            case 130:
              {
                java.lang.String s = input.readStringRequireUtf8();

                saveMessage_ = s;
                break;
              }
            case 136:
              {
                damageCal_ = input.readBool();
                break;
              }
            case 144:
              {
                dataSave_ = input.readBool();
                break;
              }
            case 154:
              {
                java.lang.String s = input.readStringRequireUtf8();

                processId_ = s;
                break;
              }
            case 160:
              {
                synopticalId_ = input.readInt64();
                break;
              }
            case 170:
              {
                if (!((mutable_bitField0_ & 0x00000001) != 0)) {
                  stowageDetails_ =
                      new java.util.ArrayList<
                          com.cpdss.common.generated.Loadicator.StowageDetails>();
                  mutable_bitField0_ |= 0x00000001;
                }
                stowageDetails_.add(
                    input.readMessage(
                        com.cpdss.common.generated.Loadicator.StowageDetails.parser(),
                        extensionRegistry));
                break;
              }
            case 178:
              {
                if (!((mutable_bitField0_ & 0x00000002) != 0)) {
                  cargoInfo_ =
                      new java.util.ArrayList<com.cpdss.common.generated.Loadicator.CargoInfo>();
                  mutable_bitField0_ |= 0x00000002;
                }
                cargoInfo_.add(
                    input.readMessage(
                        com.cpdss.common.generated.Loadicator.CargoInfo.parser(),
                        extensionRegistry));
                break;
              }
            case 186:
              {
                if (!((mutable_bitField0_ & 0x00000004) != 0)) {
                  otherTankInfo_ =
                      new java.util.ArrayList<
                          com.cpdss.common.generated.Loadicator.OtherTankInfo>();
                  mutable_bitField0_ |= 0x00000004;
                }
                otherTankInfo_.add(
                    input.readMessage(
                        com.cpdss.common.generated.Loadicator.OtherTankInfo.parser(),
                        extensionRegistry));
                break;
              }
            case 194:
              {
                if (!((mutable_bitField0_ & 0x00000008) != 0)) {
                  ballastInfo_ =
                      new java.util.ArrayList<com.cpdss.common.generated.Loadicator.BallastInfo>();
                  mutable_bitField0_ |= 0x00000008;
                }
                ballastInfo_.add(
                    input.readMessage(
                        com.cpdss.common.generated.Loadicator.BallastInfo.parser(),
                        extensionRegistry));
                break;
              }
            case 202:
              {
                java.lang.String s = input.readStringRequireUtf8();

                seaWaterDensity_ = s;
                break;
              }
            case 208:
              {
                portRotationId_ = input.readInt64();
                break;
              }
            case 218:
              {
                java.lang.String s = input.readStringRequireUtf8();

                saveFolder_ = s;
                break;
              }
            case 226:
              {
                java.lang.String s = input.readStringRequireUtf8();

                vesselName_ = s;
                break;
              }
            case 234:
              {
                java.lang.String s = input.readStringRequireUtf8();

                voyageNumber_ = s;
                break;
              }
            case 242:
              {
                java.lang.String s = input.readStringRequireUtf8();

                condition_ = s;
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
          stowageDetails_ = java.util.Collections.unmodifiableList(stowageDetails_);
        }
        if (((mutable_bitField0_ & 0x00000002) != 0)) {
          cargoInfo_ = java.util.Collections.unmodifiableList(cargoInfo_);
        }
        if (((mutable_bitField0_ & 0x00000004) != 0)) {
          otherTankInfo_ = java.util.Collections.unmodifiableList(otherTankInfo_);
        }
        if (((mutable_bitField0_ & 0x00000008) != 0)) {
          ballastInfo_ = java.util.Collections.unmodifiableList(ballastInfo_);
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }

    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.cpdss.common.generated.Loadicator.internal_static_StowagePlan_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.Loadicator.internal_static_StowagePlan_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.Loadicator.StowagePlan.class,
              com.cpdss.common.generated.Loadicator.StowagePlan.Builder.class);
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

    public static final int VESSELID_FIELD_NUMBER = 2;
    private long vesselId_;
    /**
     * <code>int64 vesselId = 2;</code>
     *
     * @return The vesselId.
     */
    public long getVesselId() {
      return vesselId_;
    }

    public static final int IMONUMBER_FIELD_NUMBER = 3;
    private volatile java.lang.Object imoNumber_;
    /**
     * <code>string imoNumber = 3;</code>
     *
     * @return The imoNumber.
     */
    public java.lang.String getImoNumber() {
      java.lang.Object ref = imoNumber_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        imoNumber_ = s;
        return s;
      }
    }
    /**
     * <code>string imoNumber = 3;</code>
     *
     * @return The bytes for imoNumber.
     */
    public com.google.protobuf.ByteString getImoNumberBytes() {
      java.lang.Object ref = imoNumber_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        imoNumber_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int COMPANYID_FIELD_NUMBER = 4;
    private long companyId_;
    /**
     * <code>int64 companyId = 4;</code>
     *
     * @return The companyId.
     */
    public long getCompanyId() {
      return companyId_;
    }

    public static final int SHIPTYPE_FIELD_NUMBER = 5;
    private volatile java.lang.Object shipType_;
    /**
     * <code>string shipType = 5;</code>
     *
     * @return The shipType.
     */
    public java.lang.String getShipType() {
      java.lang.Object ref = shipType_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        shipType_ = s;
        return s;
      }
    }
    /**
     * <code>string shipType = 5;</code>
     *
     * @return The bytes for shipType.
     */
    public com.google.protobuf.ByteString getShipTypeBytes() {
      java.lang.Object ref = shipType_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        shipType_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int VESSELCODE_FIELD_NUMBER = 6;
    private volatile java.lang.Object vesselCode_;
    /**
     * <code>string vesselCode = 6;</code>
     *
     * @return The vesselCode.
     */
    public java.lang.String getVesselCode() {
      java.lang.Object ref = vesselCode_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        vesselCode_ = s;
        return s;
      }
    }
    /**
     * <code>string vesselCode = 6;</code>
     *
     * @return The bytes for vesselCode.
     */
    public com.google.protobuf.ByteString getVesselCodeBytes() {
      java.lang.Object ref = vesselCode_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        vesselCode_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int BOOKINGLISTID_FIELD_NUMBER = 7;
    private long bookingListId_;
    /**
     * <code>int64 bookingListId = 7;</code>
     *
     * @return The bookingListId.
     */
    public long getBookingListId() {
      return bookingListId_;
    }

    public static final int STOWAGEID_FIELD_NUMBER = 8;
    private long stowageId_;
    /**
     * <code>int64 stowageId = 8;</code>
     *
     * @return The stowageId.
     */
    public long getStowageId() {
      return stowageId_;
    }

    public static final int PORTID_FIELD_NUMBER = 9;
    private long portId_;
    /**
     * <code>int64 portId = 9;</code>
     *
     * @return The portId.
     */
    public long getPortId() {
      return portId_;
    }

    public static final int PORTCODE_FIELD_NUMBER = 10;
    private volatile java.lang.Object portCode_;
    /**
     * <code>string portCode = 10;</code>
     *
     * @return The portCode.
     */
    public java.lang.String getPortCode() {
      java.lang.Object ref = portCode_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        portCode_ = s;
        return s;
      }
    }
    /**
     * <code>string portCode = 10;</code>
     *
     * @return The bytes for portCode.
     */
    public com.google.protobuf.ByteString getPortCodeBytes() {
      java.lang.Object ref = portCode_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        portCode_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int STATUS_FIELD_NUMBER = 11;
    private long status_;
    /**
     * <code>int64 status = 11;</code>
     *
     * @return The status.
     */
    public long getStatus() {
      return status_;
    }

    public static final int DEADWEIGHTCONSTANT_FIELD_NUMBER = 12;
    private volatile java.lang.Object deadweightConstant_;
    /**
     * <code>string deadweightConstant = 12;</code>
     *
     * @return The deadweightConstant.
     */
    public java.lang.String getDeadweightConstant() {
      java.lang.Object ref = deadweightConstant_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        deadweightConstant_ = s;
        return s;
      }
    }
    /**
     * <code>string deadweightConstant = 12;</code>
     *
     * @return The bytes for deadweightConstant.
     */
    public com.google.protobuf.ByteString getDeadweightConstantBytes() {
      java.lang.Object ref = deadweightConstant_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        deadweightConstant_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int PROVISIONALCONSTANT_FIELD_NUMBER = 13;
    private volatile java.lang.Object provisionalConstant_;
    /**
     * <code>string provisionalConstant = 13;</code>
     *
     * @return The provisionalConstant.
     */
    public java.lang.String getProvisionalConstant() {
      java.lang.Object ref = provisionalConstant_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        provisionalConstant_ = s;
        return s;
      }
    }
    /**
     * <code>string provisionalConstant = 13;</code>
     *
     * @return The bytes for provisionalConstant.
     */
    public com.google.protobuf.ByteString getProvisionalConstantBytes() {
      java.lang.Object ref = provisionalConstant_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        provisionalConstant_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int CALCOUNT_FIELD_NUMBER = 14;
    private long calCount_;
    /**
     * <code>int64 calCount = 14;</code>
     *
     * @return The calCount.
     */
    public long getCalCount() {
      return calCount_;
    }

    public static final int SAVESTATUS_FIELD_NUMBER = 15;
    private volatile java.lang.Object saveStatus_;
    /**
     * <code>string saveStatus = 15;</code>
     *
     * @return The saveStatus.
     */
    public java.lang.String getSaveStatus() {
      java.lang.Object ref = saveStatus_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        saveStatus_ = s;
        return s;
      }
    }
    /**
     * <code>string saveStatus = 15;</code>
     *
     * @return The bytes for saveStatus.
     */
    public com.google.protobuf.ByteString getSaveStatusBytes() {
      java.lang.Object ref = saveStatus_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        saveStatus_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int SAVEMESSAGE_FIELD_NUMBER = 16;
    private volatile java.lang.Object saveMessage_;
    /**
     * <code>string saveMessage = 16;</code>
     *
     * @return The saveMessage.
     */
    public java.lang.String getSaveMessage() {
      java.lang.Object ref = saveMessage_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        saveMessage_ = s;
        return s;
      }
    }
    /**
     * <code>string saveMessage = 16;</code>
     *
     * @return The bytes for saveMessage.
     */
    public com.google.protobuf.ByteString getSaveMessageBytes() {
      java.lang.Object ref = saveMessage_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        saveMessage_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int DAMAGECAL_FIELD_NUMBER = 17;
    private boolean damageCal_;
    /**
     * <code>bool damageCal = 17;</code>
     *
     * @return The damageCal.
     */
    public boolean getDamageCal() {
      return damageCal_;
    }

    public static final int DATASAVE_FIELD_NUMBER = 18;
    private boolean dataSave_;
    /**
     * <code>bool dataSave = 18;</code>
     *
     * @return The dataSave.
     */
    public boolean getDataSave() {
      return dataSave_;
    }

    public static final int PROCESSID_FIELD_NUMBER = 19;
    private volatile java.lang.Object processId_;
    /**
     * <code>string processId = 19;</code>
     *
     * @return The processId.
     */
    public java.lang.String getProcessId() {
      java.lang.Object ref = processId_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        processId_ = s;
        return s;
      }
    }
    /**
     * <code>string processId = 19;</code>
     *
     * @return The bytes for processId.
     */
    public com.google.protobuf.ByteString getProcessIdBytes() {
      java.lang.Object ref = processId_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        processId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int SYNOPTICALID_FIELD_NUMBER = 20;
    private long synopticalId_;
    /**
     * <code>int64 synopticalId = 20;</code>
     *
     * @return The synopticalId.
     */
    public long getSynopticalId() {
      return synopticalId_;
    }

    public static final int STOWAGEDETAILS_FIELD_NUMBER = 21;
    private java.util.List<com.cpdss.common.generated.Loadicator.StowageDetails> stowageDetails_;
    /** <code>repeated .StowageDetails stowageDetails = 21;</code> */
    public java.util.List<com.cpdss.common.generated.Loadicator.StowageDetails>
        getStowageDetailsList() {
      return stowageDetails_;
    }
    /** <code>repeated .StowageDetails stowageDetails = 21;</code> */
    public java.util.List<? extends com.cpdss.common.generated.Loadicator.StowageDetailsOrBuilder>
        getStowageDetailsOrBuilderList() {
      return stowageDetails_;
    }
    /** <code>repeated .StowageDetails stowageDetails = 21;</code> */
    public int getStowageDetailsCount() {
      return stowageDetails_.size();
    }
    /** <code>repeated .StowageDetails stowageDetails = 21;</code> */
    public com.cpdss.common.generated.Loadicator.StowageDetails getStowageDetails(int index) {
      return stowageDetails_.get(index);
    }
    /** <code>repeated .StowageDetails stowageDetails = 21;</code> */
    public com.cpdss.common.generated.Loadicator.StowageDetailsOrBuilder getStowageDetailsOrBuilder(
        int index) {
      return stowageDetails_.get(index);
    }

    public static final int CARGOINFO_FIELD_NUMBER = 22;
    private java.util.List<com.cpdss.common.generated.Loadicator.CargoInfo> cargoInfo_;
    /** <code>repeated .CargoInfo cargoInfo = 22;</code> */
    public java.util.List<com.cpdss.common.generated.Loadicator.CargoInfo> getCargoInfoList() {
      return cargoInfo_;
    }
    /** <code>repeated .CargoInfo cargoInfo = 22;</code> */
    public java.util.List<? extends com.cpdss.common.generated.Loadicator.CargoInfoOrBuilder>
        getCargoInfoOrBuilderList() {
      return cargoInfo_;
    }
    /** <code>repeated .CargoInfo cargoInfo = 22;</code> */
    public int getCargoInfoCount() {
      return cargoInfo_.size();
    }
    /** <code>repeated .CargoInfo cargoInfo = 22;</code> */
    public com.cpdss.common.generated.Loadicator.CargoInfo getCargoInfo(int index) {
      return cargoInfo_.get(index);
    }
    /** <code>repeated .CargoInfo cargoInfo = 22;</code> */
    public com.cpdss.common.generated.Loadicator.CargoInfoOrBuilder getCargoInfoOrBuilder(
        int index) {
      return cargoInfo_.get(index);
    }

    public static final int OTHERTANKINFO_FIELD_NUMBER = 23;
    private java.util.List<com.cpdss.common.generated.Loadicator.OtherTankInfo> otherTankInfo_;
    /** <code>repeated .OtherTankInfo otherTankInfo = 23;</code> */
    public java.util.List<com.cpdss.common.generated.Loadicator.OtherTankInfo>
        getOtherTankInfoList() {
      return otherTankInfo_;
    }
    /** <code>repeated .OtherTankInfo otherTankInfo = 23;</code> */
    public java.util.List<? extends com.cpdss.common.generated.Loadicator.OtherTankInfoOrBuilder>
        getOtherTankInfoOrBuilderList() {
      return otherTankInfo_;
    }
    /** <code>repeated .OtherTankInfo otherTankInfo = 23;</code> */
    public int getOtherTankInfoCount() {
      return otherTankInfo_.size();
    }
    /** <code>repeated .OtherTankInfo otherTankInfo = 23;</code> */
    public com.cpdss.common.generated.Loadicator.OtherTankInfo getOtherTankInfo(int index) {
      return otherTankInfo_.get(index);
    }
    /** <code>repeated .OtherTankInfo otherTankInfo = 23;</code> */
    public com.cpdss.common.generated.Loadicator.OtherTankInfoOrBuilder getOtherTankInfoOrBuilder(
        int index) {
      return otherTankInfo_.get(index);
    }

    public static final int BALLASTINFO_FIELD_NUMBER = 24;
    private java.util.List<com.cpdss.common.generated.Loadicator.BallastInfo> ballastInfo_;
    /** <code>repeated .BallastInfo ballastInfo = 24;</code> */
    public java.util.List<com.cpdss.common.generated.Loadicator.BallastInfo> getBallastInfoList() {
      return ballastInfo_;
    }
    /** <code>repeated .BallastInfo ballastInfo = 24;</code> */
    public java.util.List<? extends com.cpdss.common.generated.Loadicator.BallastInfoOrBuilder>
        getBallastInfoOrBuilderList() {
      return ballastInfo_;
    }
    /** <code>repeated .BallastInfo ballastInfo = 24;</code> */
    public int getBallastInfoCount() {
      return ballastInfo_.size();
    }
    /** <code>repeated .BallastInfo ballastInfo = 24;</code> */
    public com.cpdss.common.generated.Loadicator.BallastInfo getBallastInfo(int index) {
      return ballastInfo_.get(index);
    }
    /** <code>repeated .BallastInfo ballastInfo = 24;</code> */
    public com.cpdss.common.generated.Loadicator.BallastInfoOrBuilder getBallastInfoOrBuilder(
        int index) {
      return ballastInfo_.get(index);
    }

    public static final int SEAWATERDENSITY_FIELD_NUMBER = 25;
    private volatile java.lang.Object seaWaterDensity_;
    /**
     * <code>string seaWaterDensity = 25;</code>
     *
     * @return The seaWaterDensity.
     */
    public java.lang.String getSeaWaterDensity() {
      java.lang.Object ref = seaWaterDensity_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        seaWaterDensity_ = s;
        return s;
      }
    }
    /**
     * <code>string seaWaterDensity = 25;</code>
     *
     * @return The bytes for seaWaterDensity.
     */
    public com.google.protobuf.ByteString getSeaWaterDensityBytes() {
      java.lang.Object ref = seaWaterDensity_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        seaWaterDensity_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int PORTROTATIONID_FIELD_NUMBER = 26;
    private long portRotationId_;
    /**
     * <code>int64 portRotationId = 26;</code>
     *
     * @return The portRotationId.
     */
    public long getPortRotationId() {
      return portRotationId_;
    }

    public static final int SAVEFOLDER_FIELD_NUMBER = 27;
    private volatile java.lang.Object saveFolder_;
    /**
     * <code>string saveFolder = 27;</code>
     *
     * @return The saveFolder.
     */
    public java.lang.String getSaveFolder() {
      java.lang.Object ref = saveFolder_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        saveFolder_ = s;
        return s;
      }
    }
    /**
     * <code>string saveFolder = 27;</code>
     *
     * @return The bytes for saveFolder.
     */
    public com.google.protobuf.ByteString getSaveFolderBytes() {
      java.lang.Object ref = saveFolder_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        saveFolder_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int VESSELNAME_FIELD_NUMBER = 28;
    private volatile java.lang.Object vesselName_;
    /**
     * <code>string vesselName = 28;</code>
     *
     * @return The vesselName.
     */
    public java.lang.String getVesselName() {
      java.lang.Object ref = vesselName_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        vesselName_ = s;
        return s;
      }
    }
    /**
     * <code>string vesselName = 28;</code>
     *
     * @return The bytes for vesselName.
     */
    public com.google.protobuf.ByteString getVesselNameBytes() {
      java.lang.Object ref = vesselName_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        vesselName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int VOYAGENUMBER_FIELD_NUMBER = 29;
    private volatile java.lang.Object voyageNumber_;
    /**
     * <code>string voyageNumber = 29;</code>
     *
     * @return The voyageNumber.
     */
    public java.lang.String getVoyageNumber() {
      java.lang.Object ref = voyageNumber_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        voyageNumber_ = s;
        return s;
      }
    }
    /**
     * <code>string voyageNumber = 29;</code>
     *
     * @return The bytes for voyageNumber.
     */
    public com.google.protobuf.ByteString getVoyageNumberBytes() {
      java.lang.Object ref = voyageNumber_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        voyageNumber_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int CONDITION_FIELD_NUMBER = 30;
    private volatile java.lang.Object condition_;
    /**
     * <code>string condition = 30;</code>
     *
     * @return The condition.
     */
    public java.lang.String getCondition() {
      java.lang.Object ref = condition_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        condition_ = s;
        return s;
      }
    }
    /**
     * <code>string condition = 30;</code>
     *
     * @return The bytes for condition.
     */
    public com.google.protobuf.ByteString getConditionBytes() {
      java.lang.Object ref = condition_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        condition_ = b;
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
      if (vesselId_ != 0L) {
        output.writeInt64(2, vesselId_);
      }
      if (!getImoNumberBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, imoNumber_);
      }
      if (companyId_ != 0L) {
        output.writeInt64(4, companyId_);
      }
      if (!getShipTypeBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 5, shipType_);
      }
      if (!getVesselCodeBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 6, vesselCode_);
      }
      if (bookingListId_ != 0L) {
        output.writeInt64(7, bookingListId_);
      }
      if (stowageId_ != 0L) {
        output.writeInt64(8, stowageId_);
      }
      if (portId_ != 0L) {
        output.writeInt64(9, portId_);
      }
      if (!getPortCodeBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 10, portCode_);
      }
      if (status_ != 0L) {
        output.writeInt64(11, status_);
      }
      if (!getDeadweightConstantBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 12, deadweightConstant_);
      }
      if (!getProvisionalConstantBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 13, provisionalConstant_);
      }
      if (calCount_ != 0L) {
        output.writeInt64(14, calCount_);
      }
      if (!getSaveStatusBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 15, saveStatus_);
      }
      if (!getSaveMessageBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 16, saveMessage_);
      }
      if (damageCal_ != false) {
        output.writeBool(17, damageCal_);
      }
      if (dataSave_ != false) {
        output.writeBool(18, dataSave_);
      }
      if (!getProcessIdBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 19, processId_);
      }
      if (synopticalId_ != 0L) {
        output.writeInt64(20, synopticalId_);
      }
      for (int i = 0; i < stowageDetails_.size(); i++) {
        output.writeMessage(21, stowageDetails_.get(i));
      }
      for (int i = 0; i < cargoInfo_.size(); i++) {
        output.writeMessage(22, cargoInfo_.get(i));
      }
      for (int i = 0; i < otherTankInfo_.size(); i++) {
        output.writeMessage(23, otherTankInfo_.get(i));
      }
      for (int i = 0; i < ballastInfo_.size(); i++) {
        output.writeMessage(24, ballastInfo_.get(i));
      }
      if (!getSeaWaterDensityBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 25, seaWaterDensity_);
      }
      if (portRotationId_ != 0L) {
        output.writeInt64(26, portRotationId_);
      }
      if (!getSaveFolderBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 27, saveFolder_);
      }
      if (!getVesselNameBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 28, vesselName_);
      }
      if (!getVoyageNumberBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 29, voyageNumber_);
      }
      if (!getConditionBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 30, condition_);
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
      if (vesselId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(2, vesselId_);
      }
      if (!getImoNumberBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, imoNumber_);
      }
      if (companyId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(4, companyId_);
      }
      if (!getShipTypeBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, shipType_);
      }
      if (!getVesselCodeBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(6, vesselCode_);
      }
      if (bookingListId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(7, bookingListId_);
      }
      if (stowageId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(8, stowageId_);
      }
      if (portId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(9, portId_);
      }
      if (!getPortCodeBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(10, portCode_);
      }
      if (status_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(11, status_);
      }
      if (!getDeadweightConstantBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(12, deadweightConstant_);
      }
      if (!getProvisionalConstantBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(13, provisionalConstant_);
      }
      if (calCount_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(14, calCount_);
      }
      if (!getSaveStatusBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(15, saveStatus_);
      }
      if (!getSaveMessageBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(16, saveMessage_);
      }
      if (damageCal_ != false) {
        size += com.google.protobuf.CodedOutputStream.computeBoolSize(17, damageCal_);
      }
      if (dataSave_ != false) {
        size += com.google.protobuf.CodedOutputStream.computeBoolSize(18, dataSave_);
      }
      if (!getProcessIdBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(19, processId_);
      }
      if (synopticalId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(20, synopticalId_);
      }
      for (int i = 0; i < stowageDetails_.size(); i++) {
        size +=
            com.google.protobuf.CodedOutputStream.computeMessageSize(21, stowageDetails_.get(i));
      }
      for (int i = 0; i < cargoInfo_.size(); i++) {
        size += com.google.protobuf.CodedOutputStream.computeMessageSize(22, cargoInfo_.get(i));
      }
      for (int i = 0; i < otherTankInfo_.size(); i++) {
        size += com.google.protobuf.CodedOutputStream.computeMessageSize(23, otherTankInfo_.get(i));
      }
      for (int i = 0; i < ballastInfo_.size(); i++) {
        size += com.google.protobuf.CodedOutputStream.computeMessageSize(24, ballastInfo_.get(i));
      }
      if (!getSeaWaterDensityBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(25, seaWaterDensity_);
      }
      if (portRotationId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(26, portRotationId_);
      }
      if (!getSaveFolderBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(27, saveFolder_);
      }
      if (!getVesselNameBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(28, vesselName_);
      }
      if (!getVoyageNumberBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(29, voyageNumber_);
      }
      if (!getConditionBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(30, condition_);
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
      if (!(obj instanceof com.cpdss.common.generated.Loadicator.StowagePlan)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.Loadicator.StowagePlan other =
          (com.cpdss.common.generated.Loadicator.StowagePlan) obj;

      if (getId() != other.getId()) return false;
      if (getVesselId() != other.getVesselId()) return false;
      if (!getImoNumber().equals(other.getImoNumber())) return false;
      if (getCompanyId() != other.getCompanyId()) return false;
      if (!getShipType().equals(other.getShipType())) return false;
      if (!getVesselCode().equals(other.getVesselCode())) return false;
      if (getBookingListId() != other.getBookingListId()) return false;
      if (getStowageId() != other.getStowageId()) return false;
      if (getPortId() != other.getPortId()) return false;
      if (!getPortCode().equals(other.getPortCode())) return false;
      if (getStatus() != other.getStatus()) return false;
      if (!getDeadweightConstant().equals(other.getDeadweightConstant())) return false;
      if (!getProvisionalConstant().equals(other.getProvisionalConstant())) return false;
      if (getCalCount() != other.getCalCount()) return false;
      if (!getSaveStatus().equals(other.getSaveStatus())) return false;
      if (!getSaveMessage().equals(other.getSaveMessage())) return false;
      if (getDamageCal() != other.getDamageCal()) return false;
      if (getDataSave() != other.getDataSave()) return false;
      if (!getProcessId().equals(other.getProcessId())) return false;
      if (getSynopticalId() != other.getSynopticalId()) return false;
      if (!getStowageDetailsList().equals(other.getStowageDetailsList())) return false;
      if (!getCargoInfoList().equals(other.getCargoInfoList())) return false;
      if (!getOtherTankInfoList().equals(other.getOtherTankInfoList())) return false;
      if (!getBallastInfoList().equals(other.getBallastInfoList())) return false;
      if (!getSeaWaterDensity().equals(other.getSeaWaterDensity())) return false;
      if (getPortRotationId() != other.getPortRotationId()) return false;
      if (!getSaveFolder().equals(other.getSaveFolder())) return false;
      if (!getVesselName().equals(other.getVesselName())) return false;
      if (!getVoyageNumber().equals(other.getVoyageNumber())) return false;
      if (!getCondition().equals(other.getCondition())) return false;
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
      hash = (37 * hash) + VESSELID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getVesselId());
      hash = (37 * hash) + IMONUMBER_FIELD_NUMBER;
      hash = (53 * hash) + getImoNumber().hashCode();
      hash = (37 * hash) + COMPANYID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getCompanyId());
      hash = (37 * hash) + SHIPTYPE_FIELD_NUMBER;
      hash = (53 * hash) + getShipType().hashCode();
      hash = (37 * hash) + VESSELCODE_FIELD_NUMBER;
      hash = (53 * hash) + getVesselCode().hashCode();
      hash = (37 * hash) + BOOKINGLISTID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getBookingListId());
      hash = (37 * hash) + STOWAGEID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getStowageId());
      hash = (37 * hash) + PORTID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getPortId());
      hash = (37 * hash) + PORTCODE_FIELD_NUMBER;
      hash = (53 * hash) + getPortCode().hashCode();
      hash = (37 * hash) + STATUS_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getStatus());
      hash = (37 * hash) + DEADWEIGHTCONSTANT_FIELD_NUMBER;
      hash = (53 * hash) + getDeadweightConstant().hashCode();
      hash = (37 * hash) + PROVISIONALCONSTANT_FIELD_NUMBER;
      hash = (53 * hash) + getProvisionalConstant().hashCode();
      hash = (37 * hash) + CALCOUNT_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getCalCount());
      hash = (37 * hash) + SAVESTATUS_FIELD_NUMBER;
      hash = (53 * hash) + getSaveStatus().hashCode();
      hash = (37 * hash) + SAVEMESSAGE_FIELD_NUMBER;
      hash = (53 * hash) + getSaveMessage().hashCode();
      hash = (37 * hash) + DAMAGECAL_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(getDamageCal());
      hash = (37 * hash) + DATASAVE_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(getDataSave());
      hash = (37 * hash) + PROCESSID_FIELD_NUMBER;
      hash = (53 * hash) + getProcessId().hashCode();
      hash = (37 * hash) + SYNOPTICALID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getSynopticalId());
      if (getStowageDetailsCount() > 0) {
        hash = (37 * hash) + STOWAGEDETAILS_FIELD_NUMBER;
        hash = (53 * hash) + getStowageDetailsList().hashCode();
      }
      if (getCargoInfoCount() > 0) {
        hash = (37 * hash) + CARGOINFO_FIELD_NUMBER;
        hash = (53 * hash) + getCargoInfoList().hashCode();
      }
      if (getOtherTankInfoCount() > 0) {
        hash = (37 * hash) + OTHERTANKINFO_FIELD_NUMBER;
        hash = (53 * hash) + getOtherTankInfoList().hashCode();
      }
      if (getBallastInfoCount() > 0) {
        hash = (37 * hash) + BALLASTINFO_FIELD_NUMBER;
        hash = (53 * hash) + getBallastInfoList().hashCode();
      }
      hash = (37 * hash) + SEAWATERDENSITY_FIELD_NUMBER;
      hash = (53 * hash) + getSeaWaterDensity().hashCode();
      hash = (37 * hash) + PORTROTATIONID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getPortRotationId());
      hash = (37 * hash) + SAVEFOLDER_FIELD_NUMBER;
      hash = (53 * hash) + getSaveFolder().hashCode();
      hash = (37 * hash) + VESSELNAME_FIELD_NUMBER;
      hash = (53 * hash) + getVesselName().hashCode();
      hash = (37 * hash) + VOYAGENUMBER_FIELD_NUMBER;
      hash = (53 * hash) + getVoyageNumber().hashCode();
      hash = (37 * hash) + CONDITION_FIELD_NUMBER;
      hash = (53 * hash) + getCondition().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.Loadicator.StowagePlan parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Loadicator.StowagePlan parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Loadicator.StowagePlan parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Loadicator.StowagePlan parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Loadicator.StowagePlan parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Loadicator.StowagePlan parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Loadicator.StowagePlan parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Loadicator.StowagePlan parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.Loadicator.StowagePlan parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Loadicator.StowagePlan parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.Loadicator.StowagePlan parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Loadicator.StowagePlan parseFrom(
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

    public static Builder newBuilder(com.cpdss.common.generated.Loadicator.StowagePlan prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }

    @java.lang.Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /** Protobuf type {@code StowagePlan} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:StowagePlan)
        com.cpdss.common.generated.Loadicator.StowagePlanOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.Loadicator.internal_static_StowagePlan_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.Loadicator.internal_static_StowagePlan_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.Loadicator.StowagePlan.class,
                com.cpdss.common.generated.Loadicator.StowagePlan.Builder.class);
      }

      // Construct using com.cpdss.common.generated.Loadicator.StowagePlan.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {
          getStowageDetailsFieldBuilder();
          getCargoInfoFieldBuilder();
          getOtherTankInfoFieldBuilder();
          getBallastInfoFieldBuilder();
        }
      }

      @java.lang.Override
      public Builder clear() {
        super.clear();
        id_ = 0L;

        vesselId_ = 0L;

        imoNumber_ = "";

        companyId_ = 0L;

        shipType_ = "";

        vesselCode_ = "";

        bookingListId_ = 0L;

        stowageId_ = 0L;

        portId_ = 0L;

        portCode_ = "";

        status_ = 0L;

        deadweightConstant_ = "";

        provisionalConstant_ = "";

        calCount_ = 0L;

        saveStatus_ = "";

        saveMessage_ = "";

        damageCal_ = false;

        dataSave_ = false;

        processId_ = "";

        synopticalId_ = 0L;

        if (stowageDetailsBuilder_ == null) {
          stowageDetails_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          stowageDetailsBuilder_.clear();
        }
        if (cargoInfoBuilder_ == null) {
          cargoInfo_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000002);
        } else {
          cargoInfoBuilder_.clear();
        }
        if (otherTankInfoBuilder_ == null) {
          otherTankInfo_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000004);
        } else {
          otherTankInfoBuilder_.clear();
        }
        if (ballastInfoBuilder_ == null) {
          ballastInfo_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000008);
        } else {
          ballastInfoBuilder_.clear();
        }
        seaWaterDensity_ = "";

        portRotationId_ = 0L;

        saveFolder_ = "";

        vesselName_ = "";

        voyageNumber_ = "";

        condition_ = "";

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.Loadicator.internal_static_StowagePlan_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.Loadicator.StowagePlan getDefaultInstanceForType() {
        return com.cpdss.common.generated.Loadicator.StowagePlan.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.Loadicator.StowagePlan build() {
        com.cpdss.common.generated.Loadicator.StowagePlan result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.Loadicator.StowagePlan buildPartial() {
        com.cpdss.common.generated.Loadicator.StowagePlan result =
            new com.cpdss.common.generated.Loadicator.StowagePlan(this);
        int from_bitField0_ = bitField0_;
        result.id_ = id_;
        result.vesselId_ = vesselId_;
        result.imoNumber_ = imoNumber_;
        result.companyId_ = companyId_;
        result.shipType_ = shipType_;
        result.vesselCode_ = vesselCode_;
        result.bookingListId_ = bookingListId_;
        result.stowageId_ = stowageId_;
        result.portId_ = portId_;
        result.portCode_ = portCode_;
        result.status_ = status_;
        result.deadweightConstant_ = deadweightConstant_;
        result.provisionalConstant_ = provisionalConstant_;
        result.calCount_ = calCount_;
        result.saveStatus_ = saveStatus_;
        result.saveMessage_ = saveMessage_;
        result.damageCal_ = damageCal_;
        result.dataSave_ = dataSave_;
        result.processId_ = processId_;
        result.synopticalId_ = synopticalId_;
        if (stowageDetailsBuilder_ == null) {
          if (((bitField0_ & 0x00000001) != 0)) {
            stowageDetails_ = java.util.Collections.unmodifiableList(stowageDetails_);
            bitField0_ = (bitField0_ & ~0x00000001);
          }
          result.stowageDetails_ = stowageDetails_;
        } else {
          result.stowageDetails_ = stowageDetailsBuilder_.build();
        }
        if (cargoInfoBuilder_ == null) {
          if (((bitField0_ & 0x00000002) != 0)) {
            cargoInfo_ = java.util.Collections.unmodifiableList(cargoInfo_);
            bitField0_ = (bitField0_ & ~0x00000002);
          }
          result.cargoInfo_ = cargoInfo_;
        } else {
          result.cargoInfo_ = cargoInfoBuilder_.build();
        }
        if (otherTankInfoBuilder_ == null) {
          if (((bitField0_ & 0x00000004) != 0)) {
            otherTankInfo_ = java.util.Collections.unmodifiableList(otherTankInfo_);
            bitField0_ = (bitField0_ & ~0x00000004);
          }
          result.otherTankInfo_ = otherTankInfo_;
        } else {
          result.otherTankInfo_ = otherTankInfoBuilder_.build();
        }
        if (ballastInfoBuilder_ == null) {
          if (((bitField0_ & 0x00000008) != 0)) {
            ballastInfo_ = java.util.Collections.unmodifiableList(ballastInfo_);
            bitField0_ = (bitField0_ & ~0x00000008);
          }
          result.ballastInfo_ = ballastInfo_;
        } else {
          result.ballastInfo_ = ballastInfoBuilder_.build();
        }
        result.seaWaterDensity_ = seaWaterDensity_;
        result.portRotationId_ = portRotationId_;
        result.saveFolder_ = saveFolder_;
        result.vesselName_ = vesselName_;
        result.voyageNumber_ = voyageNumber_;
        result.condition_ = condition_;
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
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index,
          java.lang.Object value) {
        return super.setRepeatedField(field, index, value);
      }

      @java.lang.Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field, java.lang.Object value) {
        return super.addRepeatedField(field, value);
      }

      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.cpdss.common.generated.Loadicator.StowagePlan) {
          return mergeFrom((com.cpdss.common.generated.Loadicator.StowagePlan) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.cpdss.common.generated.Loadicator.StowagePlan other) {
        if (other == com.cpdss.common.generated.Loadicator.StowagePlan.getDefaultInstance())
          return this;
        if (other.getId() != 0L) {
          setId(other.getId());
        }
        if (other.getVesselId() != 0L) {
          setVesselId(other.getVesselId());
        }
        if (!other.getImoNumber().isEmpty()) {
          imoNumber_ = other.imoNumber_;
          onChanged();
        }
        if (other.getCompanyId() != 0L) {
          setCompanyId(other.getCompanyId());
        }
        if (!other.getShipType().isEmpty()) {
          shipType_ = other.shipType_;
          onChanged();
        }
        if (!other.getVesselCode().isEmpty()) {
          vesselCode_ = other.vesselCode_;
          onChanged();
        }
        if (other.getBookingListId() != 0L) {
          setBookingListId(other.getBookingListId());
        }
        if (other.getStowageId() != 0L) {
          setStowageId(other.getStowageId());
        }
        if (other.getPortId() != 0L) {
          setPortId(other.getPortId());
        }
        if (!other.getPortCode().isEmpty()) {
          portCode_ = other.portCode_;
          onChanged();
        }
        if (other.getStatus() != 0L) {
          setStatus(other.getStatus());
        }
        if (!other.getDeadweightConstant().isEmpty()) {
          deadweightConstant_ = other.deadweightConstant_;
          onChanged();
        }
        if (!other.getProvisionalConstant().isEmpty()) {
          provisionalConstant_ = other.provisionalConstant_;
          onChanged();
        }
        if (other.getCalCount() != 0L) {
          setCalCount(other.getCalCount());
        }
        if (!other.getSaveStatus().isEmpty()) {
          saveStatus_ = other.saveStatus_;
          onChanged();
        }
        if (!other.getSaveMessage().isEmpty()) {
          saveMessage_ = other.saveMessage_;
          onChanged();
        }
        if (other.getDamageCal() != false) {
          setDamageCal(other.getDamageCal());
        }
        if (other.getDataSave() != false) {
          setDataSave(other.getDataSave());
        }
        if (!other.getProcessId().isEmpty()) {
          processId_ = other.processId_;
          onChanged();
        }
        if (other.getSynopticalId() != 0L) {
          setSynopticalId(other.getSynopticalId());
        }
        if (stowageDetailsBuilder_ == null) {
          if (!other.stowageDetails_.isEmpty()) {
            if (stowageDetails_.isEmpty()) {
              stowageDetails_ = other.stowageDetails_;
              bitField0_ = (bitField0_ & ~0x00000001);
            } else {
              ensureStowageDetailsIsMutable();
              stowageDetails_.addAll(other.stowageDetails_);
            }
            onChanged();
          }
        } else {
          if (!other.stowageDetails_.isEmpty()) {
            if (stowageDetailsBuilder_.isEmpty()) {
              stowageDetailsBuilder_.dispose();
              stowageDetailsBuilder_ = null;
              stowageDetails_ = other.stowageDetails_;
              bitField0_ = (bitField0_ & ~0x00000001);
              stowageDetailsBuilder_ =
                  com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
                      ? getStowageDetailsFieldBuilder()
                      : null;
            } else {
              stowageDetailsBuilder_.addAllMessages(other.stowageDetails_);
            }
          }
        }
        if (cargoInfoBuilder_ == null) {
          if (!other.cargoInfo_.isEmpty()) {
            if (cargoInfo_.isEmpty()) {
              cargoInfo_ = other.cargoInfo_;
              bitField0_ = (bitField0_ & ~0x00000002);
            } else {
              ensureCargoInfoIsMutable();
              cargoInfo_.addAll(other.cargoInfo_);
            }
            onChanged();
          }
        } else {
          if (!other.cargoInfo_.isEmpty()) {
            if (cargoInfoBuilder_.isEmpty()) {
              cargoInfoBuilder_.dispose();
              cargoInfoBuilder_ = null;
              cargoInfo_ = other.cargoInfo_;
              bitField0_ = (bitField0_ & ~0x00000002);
              cargoInfoBuilder_ =
                  com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
                      ? getCargoInfoFieldBuilder()
                      : null;
            } else {
              cargoInfoBuilder_.addAllMessages(other.cargoInfo_);
            }
          }
        }
        if (otherTankInfoBuilder_ == null) {
          if (!other.otherTankInfo_.isEmpty()) {
            if (otherTankInfo_.isEmpty()) {
              otherTankInfo_ = other.otherTankInfo_;
              bitField0_ = (bitField0_ & ~0x00000004);
            } else {
              ensureOtherTankInfoIsMutable();
              otherTankInfo_.addAll(other.otherTankInfo_);
            }
            onChanged();
          }
        } else {
          if (!other.otherTankInfo_.isEmpty()) {
            if (otherTankInfoBuilder_.isEmpty()) {
              otherTankInfoBuilder_.dispose();
              otherTankInfoBuilder_ = null;
              otherTankInfo_ = other.otherTankInfo_;
              bitField0_ = (bitField0_ & ~0x00000004);
              otherTankInfoBuilder_ =
                  com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
                      ? getOtherTankInfoFieldBuilder()
                      : null;
            } else {
              otherTankInfoBuilder_.addAllMessages(other.otherTankInfo_);
            }
          }
        }
        if (ballastInfoBuilder_ == null) {
          if (!other.ballastInfo_.isEmpty()) {
            if (ballastInfo_.isEmpty()) {
              ballastInfo_ = other.ballastInfo_;
              bitField0_ = (bitField0_ & ~0x00000008);
            } else {
              ensureBallastInfoIsMutable();
              ballastInfo_.addAll(other.ballastInfo_);
            }
            onChanged();
          }
        } else {
          if (!other.ballastInfo_.isEmpty()) {
            if (ballastInfoBuilder_.isEmpty()) {
              ballastInfoBuilder_.dispose();
              ballastInfoBuilder_ = null;
              ballastInfo_ = other.ballastInfo_;
              bitField0_ = (bitField0_ & ~0x00000008);
              ballastInfoBuilder_ =
                  com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
                      ? getBallastInfoFieldBuilder()
                      : null;
            } else {
              ballastInfoBuilder_.addAllMessages(other.ballastInfo_);
            }
          }
        }
        if (!other.getSeaWaterDensity().isEmpty()) {
          seaWaterDensity_ = other.seaWaterDensity_;
          onChanged();
        }
        if (other.getPortRotationId() != 0L) {
          setPortRotationId(other.getPortRotationId());
        }
        if (!other.getSaveFolder().isEmpty()) {
          saveFolder_ = other.saveFolder_;
          onChanged();
        }
        if (!other.getVesselName().isEmpty()) {
          vesselName_ = other.vesselName_;
          onChanged();
        }
        if (!other.getVoyageNumber().isEmpty()) {
          voyageNumber_ = other.voyageNumber_;
          onChanged();
        }
        if (!other.getCondition().isEmpty()) {
          condition_ = other.condition_;
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
        com.cpdss.common.generated.Loadicator.StowagePlan parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.Loadicator.StowagePlan) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private int bitField0_;

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

      private long vesselId_;
      /**
       * <code>int64 vesselId = 2;</code>
       *
       * @return The vesselId.
       */
      public long getVesselId() {
        return vesselId_;
      }
      /**
       * <code>int64 vesselId = 2;</code>
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
       * <code>int64 vesselId = 2;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearVesselId() {

        vesselId_ = 0L;
        onChanged();
        return this;
      }

      private java.lang.Object imoNumber_ = "";
      /**
       * <code>string imoNumber = 3;</code>
       *
       * @return The imoNumber.
       */
      public java.lang.String getImoNumber() {
        java.lang.Object ref = imoNumber_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          imoNumber_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string imoNumber = 3;</code>
       *
       * @return The bytes for imoNumber.
       */
      public com.google.protobuf.ByteString getImoNumberBytes() {
        java.lang.Object ref = imoNumber_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          imoNumber_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string imoNumber = 3;</code>
       *
       * @param value The imoNumber to set.
       * @return This builder for chaining.
       */
      public Builder setImoNumber(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        imoNumber_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string imoNumber = 3;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearImoNumber() {

        imoNumber_ = getDefaultInstance().getImoNumber();
        onChanged();
        return this;
      }
      /**
       * <code>string imoNumber = 3;</code>
       *
       * @param value The bytes for imoNumber to set.
       * @return This builder for chaining.
       */
      public Builder setImoNumberBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        imoNumber_ = value;
        onChanged();
        return this;
      }

      private long companyId_;
      /**
       * <code>int64 companyId = 4;</code>
       *
       * @return The companyId.
       */
      public long getCompanyId() {
        return companyId_;
      }
      /**
       * <code>int64 companyId = 4;</code>
       *
       * @param value The companyId to set.
       * @return This builder for chaining.
       */
      public Builder setCompanyId(long value) {

        companyId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int64 companyId = 4;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearCompanyId() {

        companyId_ = 0L;
        onChanged();
        return this;
      }

      private java.lang.Object shipType_ = "";
      /**
       * <code>string shipType = 5;</code>
       *
       * @return The shipType.
       */
      public java.lang.String getShipType() {
        java.lang.Object ref = shipType_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          shipType_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string shipType = 5;</code>
       *
       * @return The bytes for shipType.
       */
      public com.google.protobuf.ByteString getShipTypeBytes() {
        java.lang.Object ref = shipType_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          shipType_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string shipType = 5;</code>
       *
       * @param value The shipType to set.
       * @return This builder for chaining.
       */
      public Builder setShipType(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        shipType_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string shipType = 5;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearShipType() {

        shipType_ = getDefaultInstance().getShipType();
        onChanged();
        return this;
      }
      /**
       * <code>string shipType = 5;</code>
       *
       * @param value The bytes for shipType to set.
       * @return This builder for chaining.
       */
      public Builder setShipTypeBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        shipType_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object vesselCode_ = "";
      /**
       * <code>string vesselCode = 6;</code>
       *
       * @return The vesselCode.
       */
      public java.lang.String getVesselCode() {
        java.lang.Object ref = vesselCode_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          vesselCode_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string vesselCode = 6;</code>
       *
       * @return The bytes for vesselCode.
       */
      public com.google.protobuf.ByteString getVesselCodeBytes() {
        java.lang.Object ref = vesselCode_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          vesselCode_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string vesselCode = 6;</code>
       *
       * @param value The vesselCode to set.
       * @return This builder for chaining.
       */
      public Builder setVesselCode(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        vesselCode_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string vesselCode = 6;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearVesselCode() {

        vesselCode_ = getDefaultInstance().getVesselCode();
        onChanged();
        return this;
      }
      /**
       * <code>string vesselCode = 6;</code>
       *
       * @param value The bytes for vesselCode to set.
       * @return This builder for chaining.
       */
      public Builder setVesselCodeBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        vesselCode_ = value;
        onChanged();
        return this;
      }

      private long bookingListId_;
      /**
       * <code>int64 bookingListId = 7;</code>
       *
       * @return The bookingListId.
       */
      public long getBookingListId() {
        return bookingListId_;
      }
      /**
       * <code>int64 bookingListId = 7;</code>
       *
       * @param value The bookingListId to set.
       * @return This builder for chaining.
       */
      public Builder setBookingListId(long value) {

        bookingListId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int64 bookingListId = 7;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearBookingListId() {

        bookingListId_ = 0L;
        onChanged();
        return this;
      }

      private long stowageId_;
      /**
       * <code>int64 stowageId = 8;</code>
       *
       * @return The stowageId.
       */
      public long getStowageId() {
        return stowageId_;
      }
      /**
       * <code>int64 stowageId = 8;</code>
       *
       * @param value The stowageId to set.
       * @return This builder for chaining.
       */
      public Builder setStowageId(long value) {

        stowageId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int64 stowageId = 8;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearStowageId() {

        stowageId_ = 0L;
        onChanged();
        return this;
      }

      private long portId_;
      /**
       * <code>int64 portId = 9;</code>
       *
       * @return The portId.
       */
      public long getPortId() {
        return portId_;
      }
      /**
       * <code>int64 portId = 9;</code>
       *
       * @param value The portId to set.
       * @return This builder for chaining.
       */
      public Builder setPortId(long value) {

        portId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int64 portId = 9;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearPortId() {

        portId_ = 0L;
        onChanged();
        return this;
      }

      private java.lang.Object portCode_ = "";
      /**
       * <code>string portCode = 10;</code>
       *
       * @return The portCode.
       */
      public java.lang.String getPortCode() {
        java.lang.Object ref = portCode_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          portCode_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string portCode = 10;</code>
       *
       * @return The bytes for portCode.
       */
      public com.google.protobuf.ByteString getPortCodeBytes() {
        java.lang.Object ref = portCode_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          portCode_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string portCode = 10;</code>
       *
       * @param value The portCode to set.
       * @return This builder for chaining.
       */
      public Builder setPortCode(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        portCode_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string portCode = 10;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearPortCode() {

        portCode_ = getDefaultInstance().getPortCode();
        onChanged();
        return this;
      }
      /**
       * <code>string portCode = 10;</code>
       *
       * @param value The bytes for portCode to set.
       * @return This builder for chaining.
       */
      public Builder setPortCodeBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        portCode_ = value;
        onChanged();
        return this;
      }

      private long status_;
      /**
       * <code>int64 status = 11;</code>
       *
       * @return The status.
       */
      public long getStatus() {
        return status_;
      }
      /**
       * <code>int64 status = 11;</code>
       *
       * @param value The status to set.
       * @return This builder for chaining.
       */
      public Builder setStatus(long value) {

        status_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int64 status = 11;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearStatus() {

        status_ = 0L;
        onChanged();
        return this;
      }

      private java.lang.Object deadweightConstant_ = "";
      /**
       * <code>string deadweightConstant = 12;</code>
       *
       * @return The deadweightConstant.
       */
      public java.lang.String getDeadweightConstant() {
        java.lang.Object ref = deadweightConstant_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          deadweightConstant_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string deadweightConstant = 12;</code>
       *
       * @return The bytes for deadweightConstant.
       */
      public com.google.protobuf.ByteString getDeadweightConstantBytes() {
        java.lang.Object ref = deadweightConstant_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          deadweightConstant_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string deadweightConstant = 12;</code>
       *
       * @param value The deadweightConstant to set.
       * @return This builder for chaining.
       */
      public Builder setDeadweightConstant(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        deadweightConstant_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string deadweightConstant = 12;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearDeadweightConstant() {

        deadweightConstant_ = getDefaultInstance().getDeadweightConstant();
        onChanged();
        return this;
      }
      /**
       * <code>string deadweightConstant = 12;</code>
       *
       * @param value The bytes for deadweightConstant to set.
       * @return This builder for chaining.
       */
      public Builder setDeadweightConstantBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        deadweightConstant_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object provisionalConstant_ = "";
      /**
       * <code>string provisionalConstant = 13;</code>
       *
       * @return The provisionalConstant.
       */
      public java.lang.String getProvisionalConstant() {
        java.lang.Object ref = provisionalConstant_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          provisionalConstant_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string provisionalConstant = 13;</code>
       *
       * @return The bytes for provisionalConstant.
       */
      public com.google.protobuf.ByteString getProvisionalConstantBytes() {
        java.lang.Object ref = provisionalConstant_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          provisionalConstant_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string provisionalConstant = 13;</code>
       *
       * @param value The provisionalConstant to set.
       * @return This builder for chaining.
       */
      public Builder setProvisionalConstant(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        provisionalConstant_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string provisionalConstant = 13;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearProvisionalConstant() {

        provisionalConstant_ = getDefaultInstance().getProvisionalConstant();
        onChanged();
        return this;
      }
      /**
       * <code>string provisionalConstant = 13;</code>
       *
       * @param value The bytes for provisionalConstant to set.
       * @return This builder for chaining.
       */
      public Builder setProvisionalConstantBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        provisionalConstant_ = value;
        onChanged();
        return this;
      }

      private long calCount_;
      /**
       * <code>int64 calCount = 14;</code>
       *
       * @return The calCount.
       */
      public long getCalCount() {
        return calCount_;
      }
      /**
       * <code>int64 calCount = 14;</code>
       *
       * @param value The calCount to set.
       * @return This builder for chaining.
       */
      public Builder setCalCount(long value) {

        calCount_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int64 calCount = 14;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearCalCount() {

        calCount_ = 0L;
        onChanged();
        return this;
      }

      private java.lang.Object saveStatus_ = "";
      /**
       * <code>string saveStatus = 15;</code>
       *
       * @return The saveStatus.
       */
      public java.lang.String getSaveStatus() {
        java.lang.Object ref = saveStatus_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          saveStatus_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string saveStatus = 15;</code>
       *
       * @return The bytes for saveStatus.
       */
      public com.google.protobuf.ByteString getSaveStatusBytes() {
        java.lang.Object ref = saveStatus_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          saveStatus_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string saveStatus = 15;</code>
       *
       * @param value The saveStatus to set.
       * @return This builder for chaining.
       */
      public Builder setSaveStatus(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        saveStatus_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string saveStatus = 15;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearSaveStatus() {

        saveStatus_ = getDefaultInstance().getSaveStatus();
        onChanged();
        return this;
      }
      /**
       * <code>string saveStatus = 15;</code>
       *
       * @param value The bytes for saveStatus to set.
       * @return This builder for chaining.
       */
      public Builder setSaveStatusBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        saveStatus_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object saveMessage_ = "";
      /**
       * <code>string saveMessage = 16;</code>
       *
       * @return The saveMessage.
       */
      public java.lang.String getSaveMessage() {
        java.lang.Object ref = saveMessage_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          saveMessage_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string saveMessage = 16;</code>
       *
       * @return The bytes for saveMessage.
       */
      public com.google.protobuf.ByteString getSaveMessageBytes() {
        java.lang.Object ref = saveMessage_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          saveMessage_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string saveMessage = 16;</code>
       *
       * @param value The saveMessage to set.
       * @return This builder for chaining.
       */
      public Builder setSaveMessage(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        saveMessage_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string saveMessage = 16;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearSaveMessage() {

        saveMessage_ = getDefaultInstance().getSaveMessage();
        onChanged();
        return this;
      }
      /**
       * <code>string saveMessage = 16;</code>
       *
       * @param value The bytes for saveMessage to set.
       * @return This builder for chaining.
       */
      public Builder setSaveMessageBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        saveMessage_ = value;
        onChanged();
        return this;
      }

      private boolean damageCal_;
      /**
       * <code>bool damageCal = 17;</code>
       *
       * @return The damageCal.
       */
      public boolean getDamageCal() {
        return damageCal_;
      }
      /**
       * <code>bool damageCal = 17;</code>
       *
       * @param value The damageCal to set.
       * @return This builder for chaining.
       */
      public Builder setDamageCal(boolean value) {

        damageCal_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>bool damageCal = 17;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearDamageCal() {

        damageCal_ = false;
        onChanged();
        return this;
      }

      private boolean dataSave_;
      /**
       * <code>bool dataSave = 18;</code>
       *
       * @return The dataSave.
       */
      public boolean getDataSave() {
        return dataSave_;
      }
      /**
       * <code>bool dataSave = 18;</code>
       *
       * @param value The dataSave to set.
       * @return This builder for chaining.
       */
      public Builder setDataSave(boolean value) {

        dataSave_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>bool dataSave = 18;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearDataSave() {

        dataSave_ = false;
        onChanged();
        return this;
      }

      private java.lang.Object processId_ = "";
      /**
       * <code>string processId = 19;</code>
       *
       * @return The processId.
       */
      public java.lang.String getProcessId() {
        java.lang.Object ref = processId_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          processId_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string processId = 19;</code>
       *
       * @return The bytes for processId.
       */
      public com.google.protobuf.ByteString getProcessIdBytes() {
        java.lang.Object ref = processId_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          processId_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string processId = 19;</code>
       *
       * @param value The processId to set.
       * @return This builder for chaining.
       */
      public Builder setProcessId(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        processId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string processId = 19;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearProcessId() {

        processId_ = getDefaultInstance().getProcessId();
        onChanged();
        return this;
      }
      /**
       * <code>string processId = 19;</code>
       *
       * @param value The bytes for processId to set.
       * @return This builder for chaining.
       */
      public Builder setProcessIdBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        processId_ = value;
        onChanged();
        return this;
      }

      private long synopticalId_;
      /**
       * <code>int64 synopticalId = 20;</code>
       *
       * @return The synopticalId.
       */
      public long getSynopticalId() {
        return synopticalId_;
      }
      /**
       * <code>int64 synopticalId = 20;</code>
       *
       * @param value The synopticalId to set.
       * @return This builder for chaining.
       */
      public Builder setSynopticalId(long value) {

        synopticalId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int64 synopticalId = 20;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearSynopticalId() {

        synopticalId_ = 0L;
        onChanged();
        return this;
      }

      private java.util.List<com.cpdss.common.generated.Loadicator.StowageDetails> stowageDetails_ =
          java.util.Collections.emptyList();

      private void ensureStowageDetailsIsMutable() {
        if (!((bitField0_ & 0x00000001) != 0)) {
          stowageDetails_ =
              new java.util.ArrayList<com.cpdss.common.generated.Loadicator.StowageDetails>(
                  stowageDetails_);
          bitField0_ |= 0x00000001;
        }
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
              com.cpdss.common.generated.Loadicator.StowageDetails,
              com.cpdss.common.generated.Loadicator.StowageDetails.Builder,
              com.cpdss.common.generated.Loadicator.StowageDetailsOrBuilder>
          stowageDetailsBuilder_;

      /** <code>repeated .StowageDetails stowageDetails = 21;</code> */
      public java.util.List<com.cpdss.common.generated.Loadicator.StowageDetails>
          getStowageDetailsList() {
        if (stowageDetailsBuilder_ == null) {
          return java.util.Collections.unmodifiableList(stowageDetails_);
        } else {
          return stowageDetailsBuilder_.getMessageList();
        }
      }
      /** <code>repeated .StowageDetails stowageDetails = 21;</code> */
      public int getStowageDetailsCount() {
        if (stowageDetailsBuilder_ == null) {
          return stowageDetails_.size();
        } else {
          return stowageDetailsBuilder_.getCount();
        }
      }
      /** <code>repeated .StowageDetails stowageDetails = 21;</code> */
      public com.cpdss.common.generated.Loadicator.StowageDetails getStowageDetails(int index) {
        if (stowageDetailsBuilder_ == null) {
          return stowageDetails_.get(index);
        } else {
          return stowageDetailsBuilder_.getMessage(index);
        }
      }
      /** <code>repeated .StowageDetails stowageDetails = 21;</code> */
      public Builder setStowageDetails(
          int index, com.cpdss.common.generated.Loadicator.StowageDetails value) {
        if (stowageDetailsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureStowageDetailsIsMutable();
          stowageDetails_.set(index, value);
          onChanged();
        } else {
          stowageDetailsBuilder_.setMessage(index, value);
        }
        return this;
      }
      /** <code>repeated .StowageDetails stowageDetails = 21;</code> */
      public Builder setStowageDetails(
          int index, com.cpdss.common.generated.Loadicator.StowageDetails.Builder builderForValue) {
        if (stowageDetailsBuilder_ == null) {
          ensureStowageDetailsIsMutable();
          stowageDetails_.set(index, builderForValue.build());
          onChanged();
        } else {
          stowageDetailsBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .StowageDetails stowageDetails = 21;</code> */
      public Builder addStowageDetails(com.cpdss.common.generated.Loadicator.StowageDetails value) {
        if (stowageDetailsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureStowageDetailsIsMutable();
          stowageDetails_.add(value);
          onChanged();
        } else {
          stowageDetailsBuilder_.addMessage(value);
        }
        return this;
      }
      /** <code>repeated .StowageDetails stowageDetails = 21;</code> */
      public Builder addStowageDetails(
          int index, com.cpdss.common.generated.Loadicator.StowageDetails value) {
        if (stowageDetailsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureStowageDetailsIsMutable();
          stowageDetails_.add(index, value);
          onChanged();
        } else {
          stowageDetailsBuilder_.addMessage(index, value);
        }
        return this;
      }
      /** <code>repeated .StowageDetails stowageDetails = 21;</code> */
      public Builder addStowageDetails(
          com.cpdss.common.generated.Loadicator.StowageDetails.Builder builderForValue) {
        if (stowageDetailsBuilder_ == null) {
          ensureStowageDetailsIsMutable();
          stowageDetails_.add(builderForValue.build());
          onChanged();
        } else {
          stowageDetailsBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .StowageDetails stowageDetails = 21;</code> */
      public Builder addStowageDetails(
          int index, com.cpdss.common.generated.Loadicator.StowageDetails.Builder builderForValue) {
        if (stowageDetailsBuilder_ == null) {
          ensureStowageDetailsIsMutable();
          stowageDetails_.add(index, builderForValue.build());
          onChanged();
        } else {
          stowageDetailsBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .StowageDetails stowageDetails = 21;</code> */
      public Builder addAllStowageDetails(
          java.lang.Iterable<? extends com.cpdss.common.generated.Loadicator.StowageDetails>
              values) {
        if (stowageDetailsBuilder_ == null) {
          ensureStowageDetailsIsMutable();
          com.google.protobuf.AbstractMessageLite.Builder.addAll(values, stowageDetails_);
          onChanged();
        } else {
          stowageDetailsBuilder_.addAllMessages(values);
        }
        return this;
      }
      /** <code>repeated .StowageDetails stowageDetails = 21;</code> */
      public Builder clearStowageDetails() {
        if (stowageDetailsBuilder_ == null) {
          stowageDetails_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
          onChanged();
        } else {
          stowageDetailsBuilder_.clear();
        }
        return this;
      }
      /** <code>repeated .StowageDetails stowageDetails = 21;</code> */
      public Builder removeStowageDetails(int index) {
        if (stowageDetailsBuilder_ == null) {
          ensureStowageDetailsIsMutable();
          stowageDetails_.remove(index);
          onChanged();
        } else {
          stowageDetailsBuilder_.remove(index);
        }
        return this;
      }
      /** <code>repeated .StowageDetails stowageDetails = 21;</code> */
      public com.cpdss.common.generated.Loadicator.StowageDetails.Builder getStowageDetailsBuilder(
          int index) {
        return getStowageDetailsFieldBuilder().getBuilder(index);
      }
      /** <code>repeated .StowageDetails stowageDetails = 21;</code> */
      public com.cpdss.common.generated.Loadicator.StowageDetailsOrBuilder
          getStowageDetailsOrBuilder(int index) {
        if (stowageDetailsBuilder_ == null) {
          return stowageDetails_.get(index);
        } else {
          return stowageDetailsBuilder_.getMessageOrBuilder(index);
        }
      }
      /** <code>repeated .StowageDetails stowageDetails = 21;</code> */
      public java.util.List<? extends com.cpdss.common.generated.Loadicator.StowageDetailsOrBuilder>
          getStowageDetailsOrBuilderList() {
        if (stowageDetailsBuilder_ != null) {
          return stowageDetailsBuilder_.getMessageOrBuilderList();
        } else {
          return java.util.Collections.unmodifiableList(stowageDetails_);
        }
      }
      /** <code>repeated .StowageDetails stowageDetails = 21;</code> */
      public com.cpdss.common.generated.Loadicator.StowageDetails.Builder
          addStowageDetailsBuilder() {
        return getStowageDetailsFieldBuilder()
            .addBuilder(com.cpdss.common.generated.Loadicator.StowageDetails.getDefaultInstance());
      }
      /** <code>repeated .StowageDetails stowageDetails = 21;</code> */
      public com.cpdss.common.generated.Loadicator.StowageDetails.Builder addStowageDetailsBuilder(
          int index) {
        return getStowageDetailsFieldBuilder()
            .addBuilder(
                index, com.cpdss.common.generated.Loadicator.StowageDetails.getDefaultInstance());
      }
      /** <code>repeated .StowageDetails stowageDetails = 21;</code> */
      public java.util.List<com.cpdss.common.generated.Loadicator.StowageDetails.Builder>
          getStowageDetailsBuilderList() {
        return getStowageDetailsFieldBuilder().getBuilderList();
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
              com.cpdss.common.generated.Loadicator.StowageDetails,
              com.cpdss.common.generated.Loadicator.StowageDetails.Builder,
              com.cpdss.common.generated.Loadicator.StowageDetailsOrBuilder>
          getStowageDetailsFieldBuilder() {
        if (stowageDetailsBuilder_ == null) {
          stowageDetailsBuilder_ =
              new com.google.protobuf.RepeatedFieldBuilderV3<
                  com.cpdss.common.generated.Loadicator.StowageDetails,
                  com.cpdss.common.generated.Loadicator.StowageDetails.Builder,
                  com.cpdss.common.generated.Loadicator.StowageDetailsOrBuilder>(
                  stowageDetails_,
                  ((bitField0_ & 0x00000001) != 0),
                  getParentForChildren(),
                  isClean());
          stowageDetails_ = null;
        }
        return stowageDetailsBuilder_;
      }

      private java.util.List<com.cpdss.common.generated.Loadicator.CargoInfo> cargoInfo_ =
          java.util.Collections.emptyList();

      private void ensureCargoInfoIsMutable() {
        if (!((bitField0_ & 0x00000002) != 0)) {
          cargoInfo_ =
              new java.util.ArrayList<com.cpdss.common.generated.Loadicator.CargoInfo>(cargoInfo_);
          bitField0_ |= 0x00000002;
        }
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
              com.cpdss.common.generated.Loadicator.CargoInfo,
              com.cpdss.common.generated.Loadicator.CargoInfo.Builder,
              com.cpdss.common.generated.Loadicator.CargoInfoOrBuilder>
          cargoInfoBuilder_;

      /** <code>repeated .CargoInfo cargoInfo = 22;</code> */
      public java.util.List<com.cpdss.common.generated.Loadicator.CargoInfo> getCargoInfoList() {
        if (cargoInfoBuilder_ == null) {
          return java.util.Collections.unmodifiableList(cargoInfo_);
        } else {
          return cargoInfoBuilder_.getMessageList();
        }
      }
      /** <code>repeated .CargoInfo cargoInfo = 22;</code> */
      public int getCargoInfoCount() {
        if (cargoInfoBuilder_ == null) {
          return cargoInfo_.size();
        } else {
          return cargoInfoBuilder_.getCount();
        }
      }
      /** <code>repeated .CargoInfo cargoInfo = 22;</code> */
      public com.cpdss.common.generated.Loadicator.CargoInfo getCargoInfo(int index) {
        if (cargoInfoBuilder_ == null) {
          return cargoInfo_.get(index);
        } else {
          return cargoInfoBuilder_.getMessage(index);
        }
      }
      /** <code>repeated .CargoInfo cargoInfo = 22;</code> */
      public Builder setCargoInfo(
          int index, com.cpdss.common.generated.Loadicator.CargoInfo value) {
        if (cargoInfoBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureCargoInfoIsMutable();
          cargoInfo_.set(index, value);
          onChanged();
        } else {
          cargoInfoBuilder_.setMessage(index, value);
        }
        return this;
      }
      /** <code>repeated .CargoInfo cargoInfo = 22;</code> */
      public Builder setCargoInfo(
          int index, com.cpdss.common.generated.Loadicator.CargoInfo.Builder builderForValue) {
        if (cargoInfoBuilder_ == null) {
          ensureCargoInfoIsMutable();
          cargoInfo_.set(index, builderForValue.build());
          onChanged();
        } else {
          cargoInfoBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .CargoInfo cargoInfo = 22;</code> */
      public Builder addCargoInfo(com.cpdss.common.generated.Loadicator.CargoInfo value) {
        if (cargoInfoBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureCargoInfoIsMutable();
          cargoInfo_.add(value);
          onChanged();
        } else {
          cargoInfoBuilder_.addMessage(value);
        }
        return this;
      }
      /** <code>repeated .CargoInfo cargoInfo = 22;</code> */
      public Builder addCargoInfo(
          int index, com.cpdss.common.generated.Loadicator.CargoInfo value) {
        if (cargoInfoBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureCargoInfoIsMutable();
          cargoInfo_.add(index, value);
          onChanged();
        } else {
          cargoInfoBuilder_.addMessage(index, value);
        }
        return this;
      }
      /** <code>repeated .CargoInfo cargoInfo = 22;</code> */
      public Builder addCargoInfo(
          com.cpdss.common.generated.Loadicator.CargoInfo.Builder builderForValue) {
        if (cargoInfoBuilder_ == null) {
          ensureCargoInfoIsMutable();
          cargoInfo_.add(builderForValue.build());
          onChanged();
        } else {
          cargoInfoBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .CargoInfo cargoInfo = 22;</code> */
      public Builder addCargoInfo(
          int index, com.cpdss.common.generated.Loadicator.CargoInfo.Builder builderForValue) {
        if (cargoInfoBuilder_ == null) {
          ensureCargoInfoIsMutable();
          cargoInfo_.add(index, builderForValue.build());
          onChanged();
        } else {
          cargoInfoBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .CargoInfo cargoInfo = 22;</code> */
      public Builder addAllCargoInfo(
          java.lang.Iterable<? extends com.cpdss.common.generated.Loadicator.CargoInfo> values) {
        if (cargoInfoBuilder_ == null) {
          ensureCargoInfoIsMutable();
          com.google.protobuf.AbstractMessageLite.Builder.addAll(values, cargoInfo_);
          onChanged();
        } else {
          cargoInfoBuilder_.addAllMessages(values);
        }
        return this;
      }
      /** <code>repeated .CargoInfo cargoInfo = 22;</code> */
      public Builder clearCargoInfo() {
        if (cargoInfoBuilder_ == null) {
          cargoInfo_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000002);
          onChanged();
        } else {
          cargoInfoBuilder_.clear();
        }
        return this;
      }
      /** <code>repeated .CargoInfo cargoInfo = 22;</code> */
      public Builder removeCargoInfo(int index) {
        if (cargoInfoBuilder_ == null) {
          ensureCargoInfoIsMutable();
          cargoInfo_.remove(index);
          onChanged();
        } else {
          cargoInfoBuilder_.remove(index);
        }
        return this;
      }
      /** <code>repeated .CargoInfo cargoInfo = 22;</code> */
      public com.cpdss.common.generated.Loadicator.CargoInfo.Builder getCargoInfoBuilder(
          int index) {
        return getCargoInfoFieldBuilder().getBuilder(index);
      }
      /** <code>repeated .CargoInfo cargoInfo = 22;</code> */
      public com.cpdss.common.generated.Loadicator.CargoInfoOrBuilder getCargoInfoOrBuilder(
          int index) {
        if (cargoInfoBuilder_ == null) {
          return cargoInfo_.get(index);
        } else {
          return cargoInfoBuilder_.getMessageOrBuilder(index);
        }
      }
      /** <code>repeated .CargoInfo cargoInfo = 22;</code> */
      public java.util.List<? extends com.cpdss.common.generated.Loadicator.CargoInfoOrBuilder>
          getCargoInfoOrBuilderList() {
        if (cargoInfoBuilder_ != null) {
          return cargoInfoBuilder_.getMessageOrBuilderList();
        } else {
          return java.util.Collections.unmodifiableList(cargoInfo_);
        }
      }
      /** <code>repeated .CargoInfo cargoInfo = 22;</code> */
      public com.cpdss.common.generated.Loadicator.CargoInfo.Builder addCargoInfoBuilder() {
        return getCargoInfoFieldBuilder()
            .addBuilder(com.cpdss.common.generated.Loadicator.CargoInfo.getDefaultInstance());
      }
      /** <code>repeated .CargoInfo cargoInfo = 22;</code> */
      public com.cpdss.common.generated.Loadicator.CargoInfo.Builder addCargoInfoBuilder(
          int index) {
        return getCargoInfoFieldBuilder()
            .addBuilder(
                index, com.cpdss.common.generated.Loadicator.CargoInfo.getDefaultInstance());
      }
      /** <code>repeated .CargoInfo cargoInfo = 22;</code> */
      public java.util.List<com.cpdss.common.generated.Loadicator.CargoInfo.Builder>
          getCargoInfoBuilderList() {
        return getCargoInfoFieldBuilder().getBuilderList();
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
              com.cpdss.common.generated.Loadicator.CargoInfo,
              com.cpdss.common.generated.Loadicator.CargoInfo.Builder,
              com.cpdss.common.generated.Loadicator.CargoInfoOrBuilder>
          getCargoInfoFieldBuilder() {
        if (cargoInfoBuilder_ == null) {
          cargoInfoBuilder_ =
              new com.google.protobuf.RepeatedFieldBuilderV3<
                  com.cpdss.common.generated.Loadicator.CargoInfo,
                  com.cpdss.common.generated.Loadicator.CargoInfo.Builder,
                  com.cpdss.common.generated.Loadicator.CargoInfoOrBuilder>(
                  cargoInfo_, ((bitField0_ & 0x00000002) != 0), getParentForChildren(), isClean());
          cargoInfo_ = null;
        }
        return cargoInfoBuilder_;
      }

      private java.util.List<com.cpdss.common.generated.Loadicator.OtherTankInfo> otherTankInfo_ =
          java.util.Collections.emptyList();

      private void ensureOtherTankInfoIsMutable() {
        if (!((bitField0_ & 0x00000004) != 0)) {
          otherTankInfo_ =
              new java.util.ArrayList<com.cpdss.common.generated.Loadicator.OtherTankInfo>(
                  otherTankInfo_);
          bitField0_ |= 0x00000004;
        }
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
              com.cpdss.common.generated.Loadicator.OtherTankInfo,
              com.cpdss.common.generated.Loadicator.OtherTankInfo.Builder,
              com.cpdss.common.generated.Loadicator.OtherTankInfoOrBuilder>
          otherTankInfoBuilder_;

      /** <code>repeated .OtherTankInfo otherTankInfo = 23;</code> */
      public java.util.List<com.cpdss.common.generated.Loadicator.OtherTankInfo>
          getOtherTankInfoList() {
        if (otherTankInfoBuilder_ == null) {
          return java.util.Collections.unmodifiableList(otherTankInfo_);
        } else {
          return otherTankInfoBuilder_.getMessageList();
        }
      }
      /** <code>repeated .OtherTankInfo otherTankInfo = 23;</code> */
      public int getOtherTankInfoCount() {
        if (otherTankInfoBuilder_ == null) {
          return otherTankInfo_.size();
        } else {
          return otherTankInfoBuilder_.getCount();
        }
      }
      /** <code>repeated .OtherTankInfo otherTankInfo = 23;</code> */
      public com.cpdss.common.generated.Loadicator.OtherTankInfo getOtherTankInfo(int index) {
        if (otherTankInfoBuilder_ == null) {
          return otherTankInfo_.get(index);
        } else {
          return otherTankInfoBuilder_.getMessage(index);
        }
      }
      /** <code>repeated .OtherTankInfo otherTankInfo = 23;</code> */
      public Builder setOtherTankInfo(
          int index, com.cpdss.common.generated.Loadicator.OtherTankInfo value) {
        if (otherTankInfoBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureOtherTankInfoIsMutable();
          otherTankInfo_.set(index, value);
          onChanged();
        } else {
          otherTankInfoBuilder_.setMessage(index, value);
        }
        return this;
      }
      /** <code>repeated .OtherTankInfo otherTankInfo = 23;</code> */
      public Builder setOtherTankInfo(
          int index, com.cpdss.common.generated.Loadicator.OtherTankInfo.Builder builderForValue) {
        if (otherTankInfoBuilder_ == null) {
          ensureOtherTankInfoIsMutable();
          otherTankInfo_.set(index, builderForValue.build());
          onChanged();
        } else {
          otherTankInfoBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .OtherTankInfo otherTankInfo = 23;</code> */
      public Builder addOtherTankInfo(com.cpdss.common.generated.Loadicator.OtherTankInfo value) {
        if (otherTankInfoBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureOtherTankInfoIsMutable();
          otherTankInfo_.add(value);
          onChanged();
        } else {
          otherTankInfoBuilder_.addMessage(value);
        }
        return this;
      }
      /** <code>repeated .OtherTankInfo otherTankInfo = 23;</code> */
      public Builder addOtherTankInfo(
          int index, com.cpdss.common.generated.Loadicator.OtherTankInfo value) {
        if (otherTankInfoBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureOtherTankInfoIsMutable();
          otherTankInfo_.add(index, value);
          onChanged();
        } else {
          otherTankInfoBuilder_.addMessage(index, value);
        }
        return this;
      }
      /** <code>repeated .OtherTankInfo otherTankInfo = 23;</code> */
      public Builder addOtherTankInfo(
          com.cpdss.common.generated.Loadicator.OtherTankInfo.Builder builderForValue) {
        if (otherTankInfoBuilder_ == null) {
          ensureOtherTankInfoIsMutable();
          otherTankInfo_.add(builderForValue.build());
          onChanged();
        } else {
          otherTankInfoBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .OtherTankInfo otherTankInfo = 23;</code> */
      public Builder addOtherTankInfo(
          int index, com.cpdss.common.generated.Loadicator.OtherTankInfo.Builder builderForValue) {
        if (otherTankInfoBuilder_ == null) {
          ensureOtherTankInfoIsMutable();
          otherTankInfo_.add(index, builderForValue.build());
          onChanged();
        } else {
          otherTankInfoBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .OtherTankInfo otherTankInfo = 23;</code> */
      public Builder addAllOtherTankInfo(
          java.lang.Iterable<? extends com.cpdss.common.generated.Loadicator.OtherTankInfo>
              values) {
        if (otherTankInfoBuilder_ == null) {
          ensureOtherTankInfoIsMutable();
          com.google.protobuf.AbstractMessageLite.Builder.addAll(values, otherTankInfo_);
          onChanged();
        } else {
          otherTankInfoBuilder_.addAllMessages(values);
        }
        return this;
      }
      /** <code>repeated .OtherTankInfo otherTankInfo = 23;</code> */
      public Builder clearOtherTankInfo() {
        if (otherTankInfoBuilder_ == null) {
          otherTankInfo_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000004);
          onChanged();
        } else {
          otherTankInfoBuilder_.clear();
        }
        return this;
      }
      /** <code>repeated .OtherTankInfo otherTankInfo = 23;</code> */
      public Builder removeOtherTankInfo(int index) {
        if (otherTankInfoBuilder_ == null) {
          ensureOtherTankInfoIsMutable();
          otherTankInfo_.remove(index);
          onChanged();
        } else {
          otherTankInfoBuilder_.remove(index);
        }
        return this;
      }
      /** <code>repeated .OtherTankInfo otherTankInfo = 23;</code> */
      public com.cpdss.common.generated.Loadicator.OtherTankInfo.Builder getOtherTankInfoBuilder(
          int index) {
        return getOtherTankInfoFieldBuilder().getBuilder(index);
      }
      /** <code>repeated .OtherTankInfo otherTankInfo = 23;</code> */
      public com.cpdss.common.generated.Loadicator.OtherTankInfoOrBuilder getOtherTankInfoOrBuilder(
          int index) {
        if (otherTankInfoBuilder_ == null) {
          return otherTankInfo_.get(index);
        } else {
          return otherTankInfoBuilder_.getMessageOrBuilder(index);
        }
      }
      /** <code>repeated .OtherTankInfo otherTankInfo = 23;</code> */
      public java.util.List<? extends com.cpdss.common.generated.Loadicator.OtherTankInfoOrBuilder>
          getOtherTankInfoOrBuilderList() {
        if (otherTankInfoBuilder_ != null) {
          return otherTankInfoBuilder_.getMessageOrBuilderList();
        } else {
          return java.util.Collections.unmodifiableList(otherTankInfo_);
        }
      }
      /** <code>repeated .OtherTankInfo otherTankInfo = 23;</code> */
      public com.cpdss.common.generated.Loadicator.OtherTankInfo.Builder addOtherTankInfoBuilder() {
        return getOtherTankInfoFieldBuilder()
            .addBuilder(com.cpdss.common.generated.Loadicator.OtherTankInfo.getDefaultInstance());
      }
      /** <code>repeated .OtherTankInfo otherTankInfo = 23;</code> */
      public com.cpdss.common.generated.Loadicator.OtherTankInfo.Builder addOtherTankInfoBuilder(
          int index) {
        return getOtherTankInfoFieldBuilder()
            .addBuilder(
                index, com.cpdss.common.generated.Loadicator.OtherTankInfo.getDefaultInstance());
      }
      /** <code>repeated .OtherTankInfo otherTankInfo = 23;</code> */
      public java.util.List<com.cpdss.common.generated.Loadicator.OtherTankInfo.Builder>
          getOtherTankInfoBuilderList() {
        return getOtherTankInfoFieldBuilder().getBuilderList();
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
              com.cpdss.common.generated.Loadicator.OtherTankInfo,
              com.cpdss.common.generated.Loadicator.OtherTankInfo.Builder,
              com.cpdss.common.generated.Loadicator.OtherTankInfoOrBuilder>
          getOtherTankInfoFieldBuilder() {
        if (otherTankInfoBuilder_ == null) {
          otherTankInfoBuilder_ =
              new com.google.protobuf.RepeatedFieldBuilderV3<
                  com.cpdss.common.generated.Loadicator.OtherTankInfo,
                  com.cpdss.common.generated.Loadicator.OtherTankInfo.Builder,
                  com.cpdss.common.generated.Loadicator.OtherTankInfoOrBuilder>(
                  otherTankInfo_,
                  ((bitField0_ & 0x00000004) != 0),
                  getParentForChildren(),
                  isClean());
          otherTankInfo_ = null;
        }
        return otherTankInfoBuilder_;
      }

      private java.util.List<com.cpdss.common.generated.Loadicator.BallastInfo> ballastInfo_ =
          java.util.Collections.emptyList();

      private void ensureBallastInfoIsMutable() {
        if (!((bitField0_ & 0x00000008) != 0)) {
          ballastInfo_ =
              new java.util.ArrayList<com.cpdss.common.generated.Loadicator.BallastInfo>(
                  ballastInfo_);
          bitField0_ |= 0x00000008;
        }
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
              com.cpdss.common.generated.Loadicator.BallastInfo,
              com.cpdss.common.generated.Loadicator.BallastInfo.Builder,
              com.cpdss.common.generated.Loadicator.BallastInfoOrBuilder>
          ballastInfoBuilder_;

      /** <code>repeated .BallastInfo ballastInfo = 24;</code> */
      public java.util.List<com.cpdss.common.generated.Loadicator.BallastInfo>
          getBallastInfoList() {
        if (ballastInfoBuilder_ == null) {
          return java.util.Collections.unmodifiableList(ballastInfo_);
        } else {
          return ballastInfoBuilder_.getMessageList();
        }
      }
      /** <code>repeated .BallastInfo ballastInfo = 24;</code> */
      public int getBallastInfoCount() {
        if (ballastInfoBuilder_ == null) {
          return ballastInfo_.size();
        } else {
          return ballastInfoBuilder_.getCount();
        }
      }
      /** <code>repeated .BallastInfo ballastInfo = 24;</code> */
      public com.cpdss.common.generated.Loadicator.BallastInfo getBallastInfo(int index) {
        if (ballastInfoBuilder_ == null) {
          return ballastInfo_.get(index);
        } else {
          return ballastInfoBuilder_.getMessage(index);
        }
      }
      /** <code>repeated .BallastInfo ballastInfo = 24;</code> */
      public Builder setBallastInfo(
          int index, com.cpdss.common.generated.Loadicator.BallastInfo value) {
        if (ballastInfoBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureBallastInfoIsMutable();
          ballastInfo_.set(index, value);
          onChanged();
        } else {
          ballastInfoBuilder_.setMessage(index, value);
        }
        return this;
      }
      /** <code>repeated .BallastInfo ballastInfo = 24;</code> */
      public Builder setBallastInfo(
          int index, com.cpdss.common.generated.Loadicator.BallastInfo.Builder builderForValue) {
        if (ballastInfoBuilder_ == null) {
          ensureBallastInfoIsMutable();
          ballastInfo_.set(index, builderForValue.build());
          onChanged();
        } else {
          ballastInfoBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .BallastInfo ballastInfo = 24;</code> */
      public Builder addBallastInfo(com.cpdss.common.generated.Loadicator.BallastInfo value) {
        if (ballastInfoBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureBallastInfoIsMutable();
          ballastInfo_.add(value);
          onChanged();
        } else {
          ballastInfoBuilder_.addMessage(value);
        }
        return this;
      }
      /** <code>repeated .BallastInfo ballastInfo = 24;</code> */
      public Builder addBallastInfo(
          int index, com.cpdss.common.generated.Loadicator.BallastInfo value) {
        if (ballastInfoBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureBallastInfoIsMutable();
          ballastInfo_.add(index, value);
          onChanged();
        } else {
          ballastInfoBuilder_.addMessage(index, value);
        }
        return this;
      }
      /** <code>repeated .BallastInfo ballastInfo = 24;</code> */
      public Builder addBallastInfo(
          com.cpdss.common.generated.Loadicator.BallastInfo.Builder builderForValue) {
        if (ballastInfoBuilder_ == null) {
          ensureBallastInfoIsMutable();
          ballastInfo_.add(builderForValue.build());
          onChanged();
        } else {
          ballastInfoBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .BallastInfo ballastInfo = 24;</code> */
      public Builder addBallastInfo(
          int index, com.cpdss.common.generated.Loadicator.BallastInfo.Builder builderForValue) {
        if (ballastInfoBuilder_ == null) {
          ensureBallastInfoIsMutable();
          ballastInfo_.add(index, builderForValue.build());
          onChanged();
        } else {
          ballastInfoBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .BallastInfo ballastInfo = 24;</code> */
      public Builder addAllBallastInfo(
          java.lang.Iterable<? extends com.cpdss.common.generated.Loadicator.BallastInfo> values) {
        if (ballastInfoBuilder_ == null) {
          ensureBallastInfoIsMutable();
          com.google.protobuf.AbstractMessageLite.Builder.addAll(values, ballastInfo_);
          onChanged();
        } else {
          ballastInfoBuilder_.addAllMessages(values);
        }
        return this;
      }
      /** <code>repeated .BallastInfo ballastInfo = 24;</code> */
      public Builder clearBallastInfo() {
        if (ballastInfoBuilder_ == null) {
          ballastInfo_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000008);
          onChanged();
        } else {
          ballastInfoBuilder_.clear();
        }
        return this;
      }
      /** <code>repeated .BallastInfo ballastInfo = 24;</code> */
      public Builder removeBallastInfo(int index) {
        if (ballastInfoBuilder_ == null) {
          ensureBallastInfoIsMutable();
          ballastInfo_.remove(index);
          onChanged();
        } else {
          ballastInfoBuilder_.remove(index);
        }
        return this;
      }
      /** <code>repeated .BallastInfo ballastInfo = 24;</code> */
      public com.cpdss.common.generated.Loadicator.BallastInfo.Builder getBallastInfoBuilder(
          int index) {
        return getBallastInfoFieldBuilder().getBuilder(index);
      }
      /** <code>repeated .BallastInfo ballastInfo = 24;</code> */
      public com.cpdss.common.generated.Loadicator.BallastInfoOrBuilder getBallastInfoOrBuilder(
          int index) {
        if (ballastInfoBuilder_ == null) {
          return ballastInfo_.get(index);
        } else {
          return ballastInfoBuilder_.getMessageOrBuilder(index);
        }
      }
      /** <code>repeated .BallastInfo ballastInfo = 24;</code> */
      public java.util.List<? extends com.cpdss.common.generated.Loadicator.BallastInfoOrBuilder>
          getBallastInfoOrBuilderList() {
        if (ballastInfoBuilder_ != null) {
          return ballastInfoBuilder_.getMessageOrBuilderList();
        } else {
          return java.util.Collections.unmodifiableList(ballastInfo_);
        }
      }
      /** <code>repeated .BallastInfo ballastInfo = 24;</code> */
      public com.cpdss.common.generated.Loadicator.BallastInfo.Builder addBallastInfoBuilder() {
        return getBallastInfoFieldBuilder()
            .addBuilder(com.cpdss.common.generated.Loadicator.BallastInfo.getDefaultInstance());
      }
      /** <code>repeated .BallastInfo ballastInfo = 24;</code> */
      public com.cpdss.common.generated.Loadicator.BallastInfo.Builder addBallastInfoBuilder(
          int index) {
        return getBallastInfoFieldBuilder()
            .addBuilder(
                index, com.cpdss.common.generated.Loadicator.BallastInfo.getDefaultInstance());
      }
      /** <code>repeated .BallastInfo ballastInfo = 24;</code> */
      public java.util.List<com.cpdss.common.generated.Loadicator.BallastInfo.Builder>
          getBallastInfoBuilderList() {
        return getBallastInfoFieldBuilder().getBuilderList();
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
              com.cpdss.common.generated.Loadicator.BallastInfo,
              com.cpdss.common.generated.Loadicator.BallastInfo.Builder,
              com.cpdss.common.generated.Loadicator.BallastInfoOrBuilder>
          getBallastInfoFieldBuilder() {
        if (ballastInfoBuilder_ == null) {
          ballastInfoBuilder_ =
              new com.google.protobuf.RepeatedFieldBuilderV3<
                  com.cpdss.common.generated.Loadicator.BallastInfo,
                  com.cpdss.common.generated.Loadicator.BallastInfo.Builder,
                  com.cpdss.common.generated.Loadicator.BallastInfoOrBuilder>(
                  ballastInfo_,
                  ((bitField0_ & 0x00000008) != 0),
                  getParentForChildren(),
                  isClean());
          ballastInfo_ = null;
        }
        return ballastInfoBuilder_;
      }

      private java.lang.Object seaWaterDensity_ = "";
      /**
       * <code>string seaWaterDensity = 25;</code>
       *
       * @return The seaWaterDensity.
       */
      public java.lang.String getSeaWaterDensity() {
        java.lang.Object ref = seaWaterDensity_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          seaWaterDensity_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string seaWaterDensity = 25;</code>
       *
       * @return The bytes for seaWaterDensity.
       */
      public com.google.protobuf.ByteString getSeaWaterDensityBytes() {
        java.lang.Object ref = seaWaterDensity_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          seaWaterDensity_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string seaWaterDensity = 25;</code>
       *
       * @param value The seaWaterDensity to set.
       * @return This builder for chaining.
       */
      public Builder setSeaWaterDensity(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        seaWaterDensity_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string seaWaterDensity = 25;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearSeaWaterDensity() {

        seaWaterDensity_ = getDefaultInstance().getSeaWaterDensity();
        onChanged();
        return this;
      }
      /**
       * <code>string seaWaterDensity = 25;</code>
       *
       * @param value The bytes for seaWaterDensity to set.
       * @return This builder for chaining.
       */
      public Builder setSeaWaterDensityBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        seaWaterDensity_ = value;
        onChanged();
        return this;
      }

      private long portRotationId_;
      /**
       * <code>int64 portRotationId = 26;</code>
       *
       * @return The portRotationId.
       */
      public long getPortRotationId() {
        return portRotationId_;
      }
      /**
       * <code>int64 portRotationId = 26;</code>
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
       * <code>int64 portRotationId = 26;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearPortRotationId() {

        portRotationId_ = 0L;
        onChanged();
        return this;
      }

      private java.lang.Object saveFolder_ = "";
      /**
       * <code>string saveFolder = 27;</code>
       *
       * @return The saveFolder.
       */
      public java.lang.String getSaveFolder() {
        java.lang.Object ref = saveFolder_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          saveFolder_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string saveFolder = 27;</code>
       *
       * @return The bytes for saveFolder.
       */
      public com.google.protobuf.ByteString getSaveFolderBytes() {
        java.lang.Object ref = saveFolder_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          saveFolder_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string saveFolder = 27;</code>
       *
       * @param value The saveFolder to set.
       * @return This builder for chaining.
       */
      public Builder setSaveFolder(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        saveFolder_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string saveFolder = 27;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearSaveFolder() {

        saveFolder_ = getDefaultInstance().getSaveFolder();
        onChanged();
        return this;
      }
      /**
       * <code>string saveFolder = 27;</code>
       *
       * @param value The bytes for saveFolder to set.
       * @return This builder for chaining.
       */
      public Builder setSaveFolderBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        saveFolder_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object vesselName_ = "";
      /**
       * <code>string vesselName = 28;</code>
       *
       * @return The vesselName.
       */
      public java.lang.String getVesselName() {
        java.lang.Object ref = vesselName_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          vesselName_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string vesselName = 28;</code>
       *
       * @return The bytes for vesselName.
       */
      public com.google.protobuf.ByteString getVesselNameBytes() {
        java.lang.Object ref = vesselName_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          vesselName_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string vesselName = 28;</code>
       *
       * @param value The vesselName to set.
       * @return This builder for chaining.
       */
      public Builder setVesselName(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        vesselName_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string vesselName = 28;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearVesselName() {

        vesselName_ = getDefaultInstance().getVesselName();
        onChanged();
        return this;
      }
      /**
       * <code>string vesselName = 28;</code>
       *
       * @param value The bytes for vesselName to set.
       * @return This builder for chaining.
       */
      public Builder setVesselNameBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        vesselName_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object voyageNumber_ = "";
      /**
       * <code>string voyageNumber = 29;</code>
       *
       * @return The voyageNumber.
       */
      public java.lang.String getVoyageNumber() {
        java.lang.Object ref = voyageNumber_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          voyageNumber_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string voyageNumber = 29;</code>
       *
       * @return The bytes for voyageNumber.
       */
      public com.google.protobuf.ByteString getVoyageNumberBytes() {
        java.lang.Object ref = voyageNumber_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          voyageNumber_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string voyageNumber = 29;</code>
       *
       * @param value The voyageNumber to set.
       * @return This builder for chaining.
       */
      public Builder setVoyageNumber(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        voyageNumber_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string voyageNumber = 29;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearVoyageNumber() {

        voyageNumber_ = getDefaultInstance().getVoyageNumber();
        onChanged();
        return this;
      }
      /**
       * <code>string voyageNumber = 29;</code>
       *
       * @param value The bytes for voyageNumber to set.
       * @return This builder for chaining.
       */
      public Builder setVoyageNumberBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        voyageNumber_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object condition_ = "";
      /**
       * <code>string condition = 30;</code>
       *
       * @return The condition.
       */
      public java.lang.String getCondition() {
        java.lang.Object ref = condition_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          condition_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string condition = 30;</code>
       *
       * @return The bytes for condition.
       */
      public com.google.protobuf.ByteString getConditionBytes() {
        java.lang.Object ref = condition_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          condition_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string condition = 30;</code>
       *
       * @param value The condition to set.
       * @return This builder for chaining.
       */
      public Builder setCondition(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        condition_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string condition = 30;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearCondition() {

        condition_ = getDefaultInstance().getCondition();
        onChanged();
        return this;
      }
      /**
       * <code>string condition = 30;</code>
       *
       * @param value The bytes for condition to set.
       * @return This builder for chaining.
       */
      public Builder setConditionBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        condition_ = value;
        onChanged();
        return this;
      }

      @java.lang.Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }

      // @@protoc_insertion_point(builder_scope:StowagePlan)
    }

    // @@protoc_insertion_point(class_scope:StowagePlan)
    private static final com.cpdss.common.generated.Loadicator.StowagePlan DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.Loadicator.StowagePlan();
    }

    public static com.cpdss.common.generated.Loadicator.StowagePlan getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<StowagePlan> PARSER =
        new com.google.protobuf.AbstractParser<StowagePlan>() {
          @java.lang.Override
          public StowagePlan parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new StowagePlan(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<StowagePlan> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<StowagePlan> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.Loadicator.StowagePlan getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface StowageDetailsOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:StowageDetails)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int64 stowagePlanId = 1;</code>
     *
     * @return The stowagePlanId.
     */
    long getStowagePlanId();

    /**
     * <code>int64 cargoId = 2;</code>
     *
     * @return The cargoId.
     */
    long getCargoId();

    /**
     * <code>int64 cargoBookId = 3;</code>
     *
     * @return The cargoBookId.
     */
    long getCargoBookId();

    /**
     * <code>string cargoName = 4;</code>
     *
     * @return The cargoName.
     */
    java.lang.String getCargoName();
    /**
     * <code>string cargoName = 4;</code>
     *
     * @return The bytes for cargoName.
     */
    com.google.protobuf.ByteString getCargoNameBytes();

    /**
     * <code>string specificGravity = 5;</code>
     *
     * @return The specificGravity.
     */
    java.lang.String getSpecificGravity();
    /**
     * <code>string specificGravity = 5;</code>
     *
     * @return The bytes for specificGravity.
     */
    com.google.protobuf.ByteString getSpecificGravityBytes();

    /**
     * <code>string quantity = 6;</code>
     *
     * @return The quantity.
     */
    java.lang.String getQuantity();
    /**
     * <code>string quantity = 6;</code>
     *
     * @return The bytes for quantity.
     */
    com.google.protobuf.ByteString getQuantityBytes();

    /**
     * <code>int64 tankId = 7;</code>
     *
     * @return The tankId.
     */
    long getTankId();

    /**
     * <code>string shortName = 8;</code>
     *
     * @return The shortName.
     */
    java.lang.String getShortName();
    /**
     * <code>string shortName = 8;</code>
     *
     * @return The bytes for shortName.
     */
    com.google.protobuf.ByteString getShortNameBytes();

    /**
     * <code>string tankName = 9;</code>
     *
     * @return The tankName.
     */
    java.lang.String getTankName();
    /**
     * <code>string tankName = 9;</code>
     *
     * @return The bytes for tankName.
     */
    com.google.protobuf.ByteString getTankNameBytes();

    /**
     * <code>int64 stowageId = 10;</code>
     *
     * @return The stowageId.
     */
    long getStowageId();

    /**
     * <code>int64 portId = 11;</code>
     *
     * @return The portId.
     */
    long getPortId();
  }
  /** Protobuf type {@code StowageDetails} */
  public static final class StowageDetails extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:StowageDetails)
      StowageDetailsOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use StowageDetails.newBuilder() to construct.
    private StowageDetails(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private StowageDetails() {
      cargoName_ = "";
      specificGravity_ = "";
      quantity_ = "";
      shortName_ = "";
      tankName_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new StowageDetails();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private StowageDetails(
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
                stowagePlanId_ = input.readInt64();
                break;
              }
            case 16:
              {
                cargoId_ = input.readInt64();
                break;
              }
            case 24:
              {
                cargoBookId_ = input.readInt64();
                break;
              }
            case 34:
              {
                java.lang.String s = input.readStringRequireUtf8();

                cargoName_ = s;
                break;
              }
            case 42:
              {
                java.lang.String s = input.readStringRequireUtf8();

                specificGravity_ = s;
                break;
              }
            case 50:
              {
                java.lang.String s = input.readStringRequireUtf8();

                quantity_ = s;
                break;
              }
            case 56:
              {
                tankId_ = input.readInt64();
                break;
              }
            case 66:
              {
                java.lang.String s = input.readStringRequireUtf8();

                shortName_ = s;
                break;
              }
            case 74:
              {
                java.lang.String s = input.readStringRequireUtf8();

                tankName_ = s;
                break;
              }
            case 80:
              {
                stowageId_ = input.readInt64();
                break;
              }
            case 88:
              {
                portId_ = input.readInt64();
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
      return com.cpdss.common.generated.Loadicator.internal_static_StowageDetails_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.Loadicator.internal_static_StowageDetails_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.Loadicator.StowageDetails.class,
              com.cpdss.common.generated.Loadicator.StowageDetails.Builder.class);
    }

    public static final int STOWAGEPLANID_FIELD_NUMBER = 1;
    private long stowagePlanId_;
    /**
     * <code>int64 stowagePlanId = 1;</code>
     *
     * @return The stowagePlanId.
     */
    public long getStowagePlanId() {
      return stowagePlanId_;
    }

    public static final int CARGOID_FIELD_NUMBER = 2;
    private long cargoId_;
    /**
     * <code>int64 cargoId = 2;</code>
     *
     * @return The cargoId.
     */
    public long getCargoId() {
      return cargoId_;
    }

    public static final int CARGOBOOKID_FIELD_NUMBER = 3;
    private long cargoBookId_;
    /**
     * <code>int64 cargoBookId = 3;</code>
     *
     * @return The cargoBookId.
     */
    public long getCargoBookId() {
      return cargoBookId_;
    }

    public static final int CARGONAME_FIELD_NUMBER = 4;
    private volatile java.lang.Object cargoName_;
    /**
     * <code>string cargoName = 4;</code>
     *
     * @return The cargoName.
     */
    public java.lang.String getCargoName() {
      java.lang.Object ref = cargoName_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        cargoName_ = s;
        return s;
      }
    }
    /**
     * <code>string cargoName = 4;</code>
     *
     * @return The bytes for cargoName.
     */
    public com.google.protobuf.ByteString getCargoNameBytes() {
      java.lang.Object ref = cargoName_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        cargoName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int SPECIFICGRAVITY_FIELD_NUMBER = 5;
    private volatile java.lang.Object specificGravity_;
    /**
     * <code>string specificGravity = 5;</code>
     *
     * @return The specificGravity.
     */
    public java.lang.String getSpecificGravity() {
      java.lang.Object ref = specificGravity_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        specificGravity_ = s;
        return s;
      }
    }
    /**
     * <code>string specificGravity = 5;</code>
     *
     * @return The bytes for specificGravity.
     */
    public com.google.protobuf.ByteString getSpecificGravityBytes() {
      java.lang.Object ref = specificGravity_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        specificGravity_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int QUANTITY_FIELD_NUMBER = 6;
    private volatile java.lang.Object quantity_;
    /**
     * <code>string quantity = 6;</code>
     *
     * @return The quantity.
     */
    public java.lang.String getQuantity() {
      java.lang.Object ref = quantity_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        quantity_ = s;
        return s;
      }
    }
    /**
     * <code>string quantity = 6;</code>
     *
     * @return The bytes for quantity.
     */
    public com.google.protobuf.ByteString getQuantityBytes() {
      java.lang.Object ref = quantity_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        quantity_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int TANKID_FIELD_NUMBER = 7;
    private long tankId_;
    /**
     * <code>int64 tankId = 7;</code>
     *
     * @return The tankId.
     */
    public long getTankId() {
      return tankId_;
    }

    public static final int SHORTNAME_FIELD_NUMBER = 8;
    private volatile java.lang.Object shortName_;
    /**
     * <code>string shortName = 8;</code>
     *
     * @return The shortName.
     */
    public java.lang.String getShortName() {
      java.lang.Object ref = shortName_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        shortName_ = s;
        return s;
      }
    }
    /**
     * <code>string shortName = 8;</code>
     *
     * @return The bytes for shortName.
     */
    public com.google.protobuf.ByteString getShortNameBytes() {
      java.lang.Object ref = shortName_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        shortName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int TANKNAME_FIELD_NUMBER = 9;
    private volatile java.lang.Object tankName_;
    /**
     * <code>string tankName = 9;</code>
     *
     * @return The tankName.
     */
    public java.lang.String getTankName() {
      java.lang.Object ref = tankName_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        tankName_ = s;
        return s;
      }
    }
    /**
     * <code>string tankName = 9;</code>
     *
     * @return The bytes for tankName.
     */
    public com.google.protobuf.ByteString getTankNameBytes() {
      java.lang.Object ref = tankName_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        tankName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int STOWAGEID_FIELD_NUMBER = 10;
    private long stowageId_;
    /**
     * <code>int64 stowageId = 10;</code>
     *
     * @return The stowageId.
     */
    public long getStowageId() {
      return stowageId_;
    }

    public static final int PORTID_FIELD_NUMBER = 11;
    private long portId_;
    /**
     * <code>int64 portId = 11;</code>
     *
     * @return The portId.
     */
    public long getPortId() {
      return portId_;
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
      if (stowagePlanId_ != 0L) {
        output.writeInt64(1, stowagePlanId_);
      }
      if (cargoId_ != 0L) {
        output.writeInt64(2, cargoId_);
      }
      if (cargoBookId_ != 0L) {
        output.writeInt64(3, cargoBookId_);
      }
      if (!getCargoNameBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 4, cargoName_);
      }
      if (!getSpecificGravityBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 5, specificGravity_);
      }
      if (!getQuantityBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 6, quantity_);
      }
      if (tankId_ != 0L) {
        output.writeInt64(7, tankId_);
      }
      if (!getShortNameBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 8, shortName_);
      }
      if (!getTankNameBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 9, tankName_);
      }
      if (stowageId_ != 0L) {
        output.writeInt64(10, stowageId_);
      }
      if (portId_ != 0L) {
        output.writeInt64(11, portId_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (stowagePlanId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(1, stowagePlanId_);
      }
      if (cargoId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(2, cargoId_);
      }
      if (cargoBookId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(3, cargoBookId_);
      }
      if (!getCargoNameBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, cargoName_);
      }
      if (!getSpecificGravityBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, specificGravity_);
      }
      if (!getQuantityBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(6, quantity_);
      }
      if (tankId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(7, tankId_);
      }
      if (!getShortNameBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(8, shortName_);
      }
      if (!getTankNameBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(9, tankName_);
      }
      if (stowageId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(10, stowageId_);
      }
      if (portId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(11, portId_);
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
      if (!(obj instanceof com.cpdss.common.generated.Loadicator.StowageDetails)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.Loadicator.StowageDetails other =
          (com.cpdss.common.generated.Loadicator.StowageDetails) obj;

      if (getStowagePlanId() != other.getStowagePlanId()) return false;
      if (getCargoId() != other.getCargoId()) return false;
      if (getCargoBookId() != other.getCargoBookId()) return false;
      if (!getCargoName().equals(other.getCargoName())) return false;
      if (!getSpecificGravity().equals(other.getSpecificGravity())) return false;
      if (!getQuantity().equals(other.getQuantity())) return false;
      if (getTankId() != other.getTankId()) return false;
      if (!getShortName().equals(other.getShortName())) return false;
      if (!getTankName().equals(other.getTankName())) return false;
      if (getStowageId() != other.getStowageId()) return false;
      if (getPortId() != other.getPortId()) return false;
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
      hash = (37 * hash) + STOWAGEPLANID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getStowagePlanId());
      hash = (37 * hash) + CARGOID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getCargoId());
      hash = (37 * hash) + CARGOBOOKID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getCargoBookId());
      hash = (37 * hash) + CARGONAME_FIELD_NUMBER;
      hash = (53 * hash) + getCargoName().hashCode();
      hash = (37 * hash) + SPECIFICGRAVITY_FIELD_NUMBER;
      hash = (53 * hash) + getSpecificGravity().hashCode();
      hash = (37 * hash) + QUANTITY_FIELD_NUMBER;
      hash = (53 * hash) + getQuantity().hashCode();
      hash = (37 * hash) + TANKID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getTankId());
      hash = (37 * hash) + SHORTNAME_FIELD_NUMBER;
      hash = (53 * hash) + getShortName().hashCode();
      hash = (37 * hash) + TANKNAME_FIELD_NUMBER;
      hash = (53 * hash) + getTankName().hashCode();
      hash = (37 * hash) + STOWAGEID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getStowageId());
      hash = (37 * hash) + PORTID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getPortId());
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.Loadicator.StowageDetails parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Loadicator.StowageDetails parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Loadicator.StowageDetails parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Loadicator.StowageDetails parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Loadicator.StowageDetails parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Loadicator.StowageDetails parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Loadicator.StowageDetails parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Loadicator.StowageDetails parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.Loadicator.StowageDetails parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Loadicator.StowageDetails parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.Loadicator.StowageDetails parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Loadicator.StowageDetails parseFrom(
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
        com.cpdss.common.generated.Loadicator.StowageDetails prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }

    @java.lang.Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /** Protobuf type {@code StowageDetails} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:StowageDetails)
        com.cpdss.common.generated.Loadicator.StowageDetailsOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.Loadicator.internal_static_StowageDetails_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.Loadicator
            .internal_static_StowageDetails_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.Loadicator.StowageDetails.class,
                com.cpdss.common.generated.Loadicator.StowageDetails.Builder.class);
      }

      // Construct using com.cpdss.common.generated.Loadicator.StowageDetails.newBuilder()
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
        stowagePlanId_ = 0L;

        cargoId_ = 0L;

        cargoBookId_ = 0L;

        cargoName_ = "";

        specificGravity_ = "";

        quantity_ = "";

        tankId_ = 0L;

        shortName_ = "";

        tankName_ = "";

        stowageId_ = 0L;

        portId_ = 0L;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.Loadicator.internal_static_StowageDetails_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.Loadicator.StowageDetails getDefaultInstanceForType() {
        return com.cpdss.common.generated.Loadicator.StowageDetails.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.Loadicator.StowageDetails build() {
        com.cpdss.common.generated.Loadicator.StowageDetails result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.Loadicator.StowageDetails buildPartial() {
        com.cpdss.common.generated.Loadicator.StowageDetails result =
            new com.cpdss.common.generated.Loadicator.StowageDetails(this);
        result.stowagePlanId_ = stowagePlanId_;
        result.cargoId_ = cargoId_;
        result.cargoBookId_ = cargoBookId_;
        result.cargoName_ = cargoName_;
        result.specificGravity_ = specificGravity_;
        result.quantity_ = quantity_;
        result.tankId_ = tankId_;
        result.shortName_ = shortName_;
        result.tankName_ = tankName_;
        result.stowageId_ = stowageId_;
        result.portId_ = portId_;
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
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index,
          java.lang.Object value) {
        return super.setRepeatedField(field, index, value);
      }

      @java.lang.Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field, java.lang.Object value) {
        return super.addRepeatedField(field, value);
      }

      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.cpdss.common.generated.Loadicator.StowageDetails) {
          return mergeFrom((com.cpdss.common.generated.Loadicator.StowageDetails) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.cpdss.common.generated.Loadicator.StowageDetails other) {
        if (other == com.cpdss.common.generated.Loadicator.StowageDetails.getDefaultInstance())
          return this;
        if (other.getStowagePlanId() != 0L) {
          setStowagePlanId(other.getStowagePlanId());
        }
        if (other.getCargoId() != 0L) {
          setCargoId(other.getCargoId());
        }
        if (other.getCargoBookId() != 0L) {
          setCargoBookId(other.getCargoBookId());
        }
        if (!other.getCargoName().isEmpty()) {
          cargoName_ = other.cargoName_;
          onChanged();
        }
        if (!other.getSpecificGravity().isEmpty()) {
          specificGravity_ = other.specificGravity_;
          onChanged();
        }
        if (!other.getQuantity().isEmpty()) {
          quantity_ = other.quantity_;
          onChanged();
        }
        if (other.getTankId() != 0L) {
          setTankId(other.getTankId());
        }
        if (!other.getShortName().isEmpty()) {
          shortName_ = other.shortName_;
          onChanged();
        }
        if (!other.getTankName().isEmpty()) {
          tankName_ = other.tankName_;
          onChanged();
        }
        if (other.getStowageId() != 0L) {
          setStowageId(other.getStowageId());
        }
        if (other.getPortId() != 0L) {
          setPortId(other.getPortId());
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
        com.cpdss.common.generated.Loadicator.StowageDetails parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.Loadicator.StowageDetails) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private long stowagePlanId_;
      /**
       * <code>int64 stowagePlanId = 1;</code>
       *
       * @return The stowagePlanId.
       */
      public long getStowagePlanId() {
        return stowagePlanId_;
      }
      /**
       * <code>int64 stowagePlanId = 1;</code>
       *
       * @param value The stowagePlanId to set.
       * @return This builder for chaining.
       */
      public Builder setStowagePlanId(long value) {

        stowagePlanId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int64 stowagePlanId = 1;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearStowagePlanId() {

        stowagePlanId_ = 0L;
        onChanged();
        return this;
      }

      private long cargoId_;
      /**
       * <code>int64 cargoId = 2;</code>
       *
       * @return The cargoId.
       */
      public long getCargoId() {
        return cargoId_;
      }
      /**
       * <code>int64 cargoId = 2;</code>
       *
       * @param value The cargoId to set.
       * @return This builder for chaining.
       */
      public Builder setCargoId(long value) {

        cargoId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int64 cargoId = 2;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearCargoId() {

        cargoId_ = 0L;
        onChanged();
        return this;
      }

      private long cargoBookId_;
      /**
       * <code>int64 cargoBookId = 3;</code>
       *
       * @return The cargoBookId.
       */
      public long getCargoBookId() {
        return cargoBookId_;
      }
      /**
       * <code>int64 cargoBookId = 3;</code>
       *
       * @param value The cargoBookId to set.
       * @return This builder for chaining.
       */
      public Builder setCargoBookId(long value) {

        cargoBookId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int64 cargoBookId = 3;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearCargoBookId() {

        cargoBookId_ = 0L;
        onChanged();
        return this;
      }

      private java.lang.Object cargoName_ = "";
      /**
       * <code>string cargoName = 4;</code>
       *
       * @return The cargoName.
       */
      public java.lang.String getCargoName() {
        java.lang.Object ref = cargoName_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          cargoName_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string cargoName = 4;</code>
       *
       * @return The bytes for cargoName.
       */
      public com.google.protobuf.ByteString getCargoNameBytes() {
        java.lang.Object ref = cargoName_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          cargoName_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string cargoName = 4;</code>
       *
       * @param value The cargoName to set.
       * @return This builder for chaining.
       */
      public Builder setCargoName(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        cargoName_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string cargoName = 4;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearCargoName() {

        cargoName_ = getDefaultInstance().getCargoName();
        onChanged();
        return this;
      }
      /**
       * <code>string cargoName = 4;</code>
       *
       * @param value The bytes for cargoName to set.
       * @return This builder for chaining.
       */
      public Builder setCargoNameBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        cargoName_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object specificGravity_ = "";
      /**
       * <code>string specificGravity = 5;</code>
       *
       * @return The specificGravity.
       */
      public java.lang.String getSpecificGravity() {
        java.lang.Object ref = specificGravity_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          specificGravity_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string specificGravity = 5;</code>
       *
       * @return The bytes for specificGravity.
       */
      public com.google.protobuf.ByteString getSpecificGravityBytes() {
        java.lang.Object ref = specificGravity_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          specificGravity_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string specificGravity = 5;</code>
       *
       * @param value The specificGravity to set.
       * @return This builder for chaining.
       */
      public Builder setSpecificGravity(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        specificGravity_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string specificGravity = 5;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearSpecificGravity() {

        specificGravity_ = getDefaultInstance().getSpecificGravity();
        onChanged();
        return this;
      }
      /**
       * <code>string specificGravity = 5;</code>
       *
       * @param value The bytes for specificGravity to set.
       * @return This builder for chaining.
       */
      public Builder setSpecificGravityBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        specificGravity_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object quantity_ = "";
      /**
       * <code>string quantity = 6;</code>
       *
       * @return The quantity.
       */
      public java.lang.String getQuantity() {
        java.lang.Object ref = quantity_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          quantity_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string quantity = 6;</code>
       *
       * @return The bytes for quantity.
       */
      public com.google.protobuf.ByteString getQuantityBytes() {
        java.lang.Object ref = quantity_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          quantity_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string quantity = 6;</code>
       *
       * @param value The quantity to set.
       * @return This builder for chaining.
       */
      public Builder setQuantity(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        quantity_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string quantity = 6;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearQuantity() {

        quantity_ = getDefaultInstance().getQuantity();
        onChanged();
        return this;
      }
      /**
       * <code>string quantity = 6;</code>
       *
       * @param value The bytes for quantity to set.
       * @return This builder for chaining.
       */
      public Builder setQuantityBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        quantity_ = value;
        onChanged();
        return this;
      }

      private long tankId_;
      /**
       * <code>int64 tankId = 7;</code>
       *
       * @return The tankId.
       */
      public long getTankId() {
        return tankId_;
      }
      /**
       * <code>int64 tankId = 7;</code>
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
       * <code>int64 tankId = 7;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearTankId() {

        tankId_ = 0L;
        onChanged();
        return this;
      }

      private java.lang.Object shortName_ = "";
      /**
       * <code>string shortName = 8;</code>
       *
       * @return The shortName.
       */
      public java.lang.String getShortName() {
        java.lang.Object ref = shortName_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          shortName_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string shortName = 8;</code>
       *
       * @return The bytes for shortName.
       */
      public com.google.protobuf.ByteString getShortNameBytes() {
        java.lang.Object ref = shortName_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          shortName_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string shortName = 8;</code>
       *
       * @param value The shortName to set.
       * @return This builder for chaining.
       */
      public Builder setShortName(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        shortName_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string shortName = 8;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearShortName() {

        shortName_ = getDefaultInstance().getShortName();
        onChanged();
        return this;
      }
      /**
       * <code>string shortName = 8;</code>
       *
       * @param value The bytes for shortName to set.
       * @return This builder for chaining.
       */
      public Builder setShortNameBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        shortName_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object tankName_ = "";
      /**
       * <code>string tankName = 9;</code>
       *
       * @return The tankName.
       */
      public java.lang.String getTankName() {
        java.lang.Object ref = tankName_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          tankName_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string tankName = 9;</code>
       *
       * @return The bytes for tankName.
       */
      public com.google.protobuf.ByteString getTankNameBytes() {
        java.lang.Object ref = tankName_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          tankName_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string tankName = 9;</code>
       *
       * @param value The tankName to set.
       * @return This builder for chaining.
       */
      public Builder setTankName(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        tankName_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string tankName = 9;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearTankName() {

        tankName_ = getDefaultInstance().getTankName();
        onChanged();
        return this;
      }
      /**
       * <code>string tankName = 9;</code>
       *
       * @param value The bytes for tankName to set.
       * @return This builder for chaining.
       */
      public Builder setTankNameBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        tankName_ = value;
        onChanged();
        return this;
      }

      private long stowageId_;
      /**
       * <code>int64 stowageId = 10;</code>
       *
       * @return The stowageId.
       */
      public long getStowageId() {
        return stowageId_;
      }
      /**
       * <code>int64 stowageId = 10;</code>
       *
       * @param value The stowageId to set.
       * @return This builder for chaining.
       */
      public Builder setStowageId(long value) {

        stowageId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int64 stowageId = 10;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearStowageId() {

        stowageId_ = 0L;
        onChanged();
        return this;
      }

      private long portId_;
      /**
       * <code>int64 portId = 11;</code>
       *
       * @return The portId.
       */
      public long getPortId() {
        return portId_;
      }
      /**
       * <code>int64 portId = 11;</code>
       *
       * @param value The portId to set.
       * @return This builder for chaining.
       */
      public Builder setPortId(long value) {

        portId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int64 portId = 11;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearPortId() {

        portId_ = 0L;
        onChanged();
        return this;
      }

      @java.lang.Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }

      // @@protoc_insertion_point(builder_scope:StowageDetails)
    }

    // @@protoc_insertion_point(class_scope:StowageDetails)
    private static final com.cpdss.common.generated.Loadicator.StowageDetails DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.Loadicator.StowageDetails();
    }

    public static com.cpdss.common.generated.Loadicator.StowageDetails getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<StowageDetails> PARSER =
        new com.google.protobuf.AbstractParser<StowageDetails>() {
          @java.lang.Override
          public StowageDetails parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new StowageDetails(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<StowageDetails> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<StowageDetails> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.Loadicator.StowageDetails getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface CargoInfoOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:CargoInfo)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int64 stowagePlanId = 1;</code>
     *
     * @return The stowagePlanId.
     */
    long getStowagePlanId();

    /**
     * <code>int64 cargoId = 2;</code>
     *
     * @return The cargoId.
     */
    long getCargoId();

    /**
     * <code>string cargoName = 3;</code>
     *
     * @return The cargoName.
     */
    java.lang.String getCargoName();
    /**
     * <code>string cargoName = 3;</code>
     *
     * @return The bytes for cargoName.
     */
    com.google.protobuf.ByteString getCargoNameBytes();

    /**
     * <code>string cargoAbbrev = 4;</code>
     *
     * @return The cargoAbbrev.
     */
    java.lang.String getCargoAbbrev();
    /**
     * <code>string cargoAbbrev = 4;</code>
     *
     * @return The bytes for cargoAbbrev.
     */
    com.google.protobuf.ByteString getCargoAbbrevBytes();

    /**
     * <code>string standardTemp = 5;</code>
     *
     * @return The standardTemp.
     */
    java.lang.String getStandardTemp();
    /**
     * <code>string standardTemp = 5;</code>
     *
     * @return The bytes for standardTemp.
     */
    com.google.protobuf.ByteString getStandardTempBytes();

    /**
     * <code>string grade = 6;</code>
     *
     * @return The grade.
     */
    java.lang.String getGrade();
    /**
     * <code>string grade = 6;</code>
     *
     * @return The bytes for grade.
     */
    com.google.protobuf.ByteString getGradeBytes();

    /**
     * <code>string density = 7;</code>
     *
     * @return The density.
     */
    java.lang.String getDensity();
    /**
     * <code>string density = 7;</code>
     *
     * @return The bytes for density.
     */
    com.google.protobuf.ByteString getDensityBytes();

    /**
     * <code>string api = 8;</code>
     *
     * @return The api.
     */
    java.lang.String getApi();
    /**
     * <code>string api = 8;</code>
     *
     * @return The bytes for api.
     */
    com.google.protobuf.ByteString getApiBytes();

    /**
     * <code>string degf = 9;</code>
     *
     * @return The degf.
     */
    java.lang.String getDegf();
    /**
     * <code>string degf = 9;</code>
     *
     * @return The bytes for degf.
     */
    com.google.protobuf.ByteString getDegfBytes();

    /**
     * <code>string degc = 10;</code>
     *
     * @return The degc.
     */
    java.lang.String getDegc();
    /**
     * <code>string degc = 10;</code>
     *
     * @return The bytes for degc.
     */
    com.google.protobuf.ByteString getDegcBytes();

    /**
     * <code>int64 stowageId = 11;</code>
     *
     * @return The stowageId.
     */
    long getStowageId();

    /**
     * <code>int64 portId = 12;</code>
     *
     * @return The portId.
     */
    long getPortId();
  }
  /** Protobuf type {@code CargoInfo} */
  public static final class CargoInfo extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:CargoInfo)
      CargoInfoOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use CargoInfo.newBuilder() to construct.
    private CargoInfo(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private CargoInfo() {
      cargoName_ = "";
      cargoAbbrev_ = "";
      standardTemp_ = "";
      grade_ = "";
      density_ = "";
      api_ = "";
      degf_ = "";
      degc_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new CargoInfo();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private CargoInfo(
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
                stowagePlanId_ = input.readInt64();
                break;
              }
            case 16:
              {
                cargoId_ = input.readInt64();
                break;
              }
            case 26:
              {
                java.lang.String s = input.readStringRequireUtf8();

                cargoName_ = s;
                break;
              }
            case 34:
              {
                java.lang.String s = input.readStringRequireUtf8();

                cargoAbbrev_ = s;
                break;
              }
            case 42:
              {
                java.lang.String s = input.readStringRequireUtf8();

                standardTemp_ = s;
                break;
              }
            case 50:
              {
                java.lang.String s = input.readStringRequireUtf8();

                grade_ = s;
                break;
              }
            case 58:
              {
                java.lang.String s = input.readStringRequireUtf8();

                density_ = s;
                break;
              }
            case 66:
              {
                java.lang.String s = input.readStringRequireUtf8();

                api_ = s;
                break;
              }
            case 74:
              {
                java.lang.String s = input.readStringRequireUtf8();

                degf_ = s;
                break;
              }
            case 82:
              {
                java.lang.String s = input.readStringRequireUtf8();

                degc_ = s;
                break;
              }
            case 88:
              {
                stowageId_ = input.readInt64();
                break;
              }
            case 96:
              {
                portId_ = input.readInt64();
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
      return com.cpdss.common.generated.Loadicator.internal_static_CargoInfo_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.Loadicator.internal_static_CargoInfo_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.Loadicator.CargoInfo.class,
              com.cpdss.common.generated.Loadicator.CargoInfo.Builder.class);
    }

    public static final int STOWAGEPLANID_FIELD_NUMBER = 1;
    private long stowagePlanId_;
    /**
     * <code>int64 stowagePlanId = 1;</code>
     *
     * @return The stowagePlanId.
     */
    public long getStowagePlanId() {
      return stowagePlanId_;
    }

    public static final int CARGOID_FIELD_NUMBER = 2;
    private long cargoId_;
    /**
     * <code>int64 cargoId = 2;</code>
     *
     * @return The cargoId.
     */
    public long getCargoId() {
      return cargoId_;
    }

    public static final int CARGONAME_FIELD_NUMBER = 3;
    private volatile java.lang.Object cargoName_;
    /**
     * <code>string cargoName = 3;</code>
     *
     * @return The cargoName.
     */
    public java.lang.String getCargoName() {
      java.lang.Object ref = cargoName_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        cargoName_ = s;
        return s;
      }
    }
    /**
     * <code>string cargoName = 3;</code>
     *
     * @return The bytes for cargoName.
     */
    public com.google.protobuf.ByteString getCargoNameBytes() {
      java.lang.Object ref = cargoName_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        cargoName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int CARGOABBREV_FIELD_NUMBER = 4;
    private volatile java.lang.Object cargoAbbrev_;
    /**
     * <code>string cargoAbbrev = 4;</code>
     *
     * @return The cargoAbbrev.
     */
    public java.lang.String getCargoAbbrev() {
      java.lang.Object ref = cargoAbbrev_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        cargoAbbrev_ = s;
        return s;
      }
    }
    /**
     * <code>string cargoAbbrev = 4;</code>
     *
     * @return The bytes for cargoAbbrev.
     */
    public com.google.protobuf.ByteString getCargoAbbrevBytes() {
      java.lang.Object ref = cargoAbbrev_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        cargoAbbrev_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int STANDARDTEMP_FIELD_NUMBER = 5;
    private volatile java.lang.Object standardTemp_;
    /**
     * <code>string standardTemp = 5;</code>
     *
     * @return The standardTemp.
     */
    public java.lang.String getStandardTemp() {
      java.lang.Object ref = standardTemp_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        standardTemp_ = s;
        return s;
      }
    }
    /**
     * <code>string standardTemp = 5;</code>
     *
     * @return The bytes for standardTemp.
     */
    public com.google.protobuf.ByteString getStandardTempBytes() {
      java.lang.Object ref = standardTemp_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        standardTemp_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int GRADE_FIELD_NUMBER = 6;
    private volatile java.lang.Object grade_;
    /**
     * <code>string grade = 6;</code>
     *
     * @return The grade.
     */
    public java.lang.String getGrade() {
      java.lang.Object ref = grade_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        grade_ = s;
        return s;
      }
    }
    /**
     * <code>string grade = 6;</code>
     *
     * @return The bytes for grade.
     */
    public com.google.protobuf.ByteString getGradeBytes() {
      java.lang.Object ref = grade_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        grade_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int DENSITY_FIELD_NUMBER = 7;
    private volatile java.lang.Object density_;
    /**
     * <code>string density = 7;</code>
     *
     * @return The density.
     */
    public java.lang.String getDensity() {
      java.lang.Object ref = density_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        density_ = s;
        return s;
      }
    }
    /**
     * <code>string density = 7;</code>
     *
     * @return The bytes for density.
     */
    public com.google.protobuf.ByteString getDensityBytes() {
      java.lang.Object ref = density_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        density_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int API_FIELD_NUMBER = 8;
    private volatile java.lang.Object api_;
    /**
     * <code>string api = 8;</code>
     *
     * @return The api.
     */
    public java.lang.String getApi() {
      java.lang.Object ref = api_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        api_ = s;
        return s;
      }
    }
    /**
     * <code>string api = 8;</code>
     *
     * @return The bytes for api.
     */
    public com.google.protobuf.ByteString getApiBytes() {
      java.lang.Object ref = api_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        api_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int DEGF_FIELD_NUMBER = 9;
    private volatile java.lang.Object degf_;
    /**
     * <code>string degf = 9;</code>
     *
     * @return The degf.
     */
    public java.lang.String getDegf() {
      java.lang.Object ref = degf_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        degf_ = s;
        return s;
      }
    }
    /**
     * <code>string degf = 9;</code>
     *
     * @return The bytes for degf.
     */
    public com.google.protobuf.ByteString getDegfBytes() {
      java.lang.Object ref = degf_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        degf_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int DEGC_FIELD_NUMBER = 10;
    private volatile java.lang.Object degc_;
    /**
     * <code>string degc = 10;</code>
     *
     * @return The degc.
     */
    public java.lang.String getDegc() {
      java.lang.Object ref = degc_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        degc_ = s;
        return s;
      }
    }
    /**
     * <code>string degc = 10;</code>
     *
     * @return The bytes for degc.
     */
    public com.google.protobuf.ByteString getDegcBytes() {
      java.lang.Object ref = degc_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        degc_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int STOWAGEID_FIELD_NUMBER = 11;
    private long stowageId_;
    /**
     * <code>int64 stowageId = 11;</code>
     *
     * @return The stowageId.
     */
    public long getStowageId() {
      return stowageId_;
    }

    public static final int PORTID_FIELD_NUMBER = 12;
    private long portId_;
    /**
     * <code>int64 portId = 12;</code>
     *
     * @return The portId.
     */
    public long getPortId() {
      return portId_;
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
      if (stowagePlanId_ != 0L) {
        output.writeInt64(1, stowagePlanId_);
      }
      if (cargoId_ != 0L) {
        output.writeInt64(2, cargoId_);
      }
      if (!getCargoNameBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, cargoName_);
      }
      if (!getCargoAbbrevBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 4, cargoAbbrev_);
      }
      if (!getStandardTempBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 5, standardTemp_);
      }
      if (!getGradeBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 6, grade_);
      }
      if (!getDensityBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 7, density_);
      }
      if (!getApiBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 8, api_);
      }
      if (!getDegfBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 9, degf_);
      }
      if (!getDegcBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 10, degc_);
      }
      if (stowageId_ != 0L) {
        output.writeInt64(11, stowageId_);
      }
      if (portId_ != 0L) {
        output.writeInt64(12, portId_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (stowagePlanId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(1, stowagePlanId_);
      }
      if (cargoId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(2, cargoId_);
      }
      if (!getCargoNameBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, cargoName_);
      }
      if (!getCargoAbbrevBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, cargoAbbrev_);
      }
      if (!getStandardTempBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, standardTemp_);
      }
      if (!getGradeBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(6, grade_);
      }
      if (!getDensityBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(7, density_);
      }
      if (!getApiBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(8, api_);
      }
      if (!getDegfBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(9, degf_);
      }
      if (!getDegcBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(10, degc_);
      }
      if (stowageId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(11, stowageId_);
      }
      if (portId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(12, portId_);
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
      if (!(obj instanceof com.cpdss.common.generated.Loadicator.CargoInfo)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.Loadicator.CargoInfo other =
          (com.cpdss.common.generated.Loadicator.CargoInfo) obj;

      if (getStowagePlanId() != other.getStowagePlanId()) return false;
      if (getCargoId() != other.getCargoId()) return false;
      if (!getCargoName().equals(other.getCargoName())) return false;
      if (!getCargoAbbrev().equals(other.getCargoAbbrev())) return false;
      if (!getStandardTemp().equals(other.getStandardTemp())) return false;
      if (!getGrade().equals(other.getGrade())) return false;
      if (!getDensity().equals(other.getDensity())) return false;
      if (!getApi().equals(other.getApi())) return false;
      if (!getDegf().equals(other.getDegf())) return false;
      if (!getDegc().equals(other.getDegc())) return false;
      if (getStowageId() != other.getStowageId()) return false;
      if (getPortId() != other.getPortId()) return false;
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
      hash = (37 * hash) + STOWAGEPLANID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getStowagePlanId());
      hash = (37 * hash) + CARGOID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getCargoId());
      hash = (37 * hash) + CARGONAME_FIELD_NUMBER;
      hash = (53 * hash) + getCargoName().hashCode();
      hash = (37 * hash) + CARGOABBREV_FIELD_NUMBER;
      hash = (53 * hash) + getCargoAbbrev().hashCode();
      hash = (37 * hash) + STANDARDTEMP_FIELD_NUMBER;
      hash = (53 * hash) + getStandardTemp().hashCode();
      hash = (37 * hash) + GRADE_FIELD_NUMBER;
      hash = (53 * hash) + getGrade().hashCode();
      hash = (37 * hash) + DENSITY_FIELD_NUMBER;
      hash = (53 * hash) + getDensity().hashCode();
      hash = (37 * hash) + API_FIELD_NUMBER;
      hash = (53 * hash) + getApi().hashCode();
      hash = (37 * hash) + DEGF_FIELD_NUMBER;
      hash = (53 * hash) + getDegf().hashCode();
      hash = (37 * hash) + DEGC_FIELD_NUMBER;
      hash = (53 * hash) + getDegc().hashCode();
      hash = (37 * hash) + STOWAGEID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getStowageId());
      hash = (37 * hash) + PORTID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getPortId());
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.Loadicator.CargoInfo parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Loadicator.CargoInfo parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Loadicator.CargoInfo parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Loadicator.CargoInfo parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Loadicator.CargoInfo parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Loadicator.CargoInfo parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Loadicator.CargoInfo parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Loadicator.CargoInfo parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.Loadicator.CargoInfo parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Loadicator.CargoInfo parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.Loadicator.CargoInfo parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Loadicator.CargoInfo parseFrom(
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

    public static Builder newBuilder(com.cpdss.common.generated.Loadicator.CargoInfo prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }

    @java.lang.Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /** Protobuf type {@code CargoInfo} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:CargoInfo)
        com.cpdss.common.generated.Loadicator.CargoInfoOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.Loadicator.internal_static_CargoInfo_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.Loadicator.internal_static_CargoInfo_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.Loadicator.CargoInfo.class,
                com.cpdss.common.generated.Loadicator.CargoInfo.Builder.class);
      }

      // Construct using com.cpdss.common.generated.Loadicator.CargoInfo.newBuilder()
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
        stowagePlanId_ = 0L;

        cargoId_ = 0L;

        cargoName_ = "";

        cargoAbbrev_ = "";

        standardTemp_ = "";

        grade_ = "";

        density_ = "";

        api_ = "";

        degf_ = "";

        degc_ = "";

        stowageId_ = 0L;

        portId_ = 0L;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.Loadicator.internal_static_CargoInfo_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.Loadicator.CargoInfo getDefaultInstanceForType() {
        return com.cpdss.common.generated.Loadicator.CargoInfo.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.Loadicator.CargoInfo build() {
        com.cpdss.common.generated.Loadicator.CargoInfo result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.Loadicator.CargoInfo buildPartial() {
        com.cpdss.common.generated.Loadicator.CargoInfo result =
            new com.cpdss.common.generated.Loadicator.CargoInfo(this);
        result.stowagePlanId_ = stowagePlanId_;
        result.cargoId_ = cargoId_;
        result.cargoName_ = cargoName_;
        result.cargoAbbrev_ = cargoAbbrev_;
        result.standardTemp_ = standardTemp_;
        result.grade_ = grade_;
        result.density_ = density_;
        result.api_ = api_;
        result.degf_ = degf_;
        result.degc_ = degc_;
        result.stowageId_ = stowageId_;
        result.portId_ = portId_;
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
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index,
          java.lang.Object value) {
        return super.setRepeatedField(field, index, value);
      }

      @java.lang.Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field, java.lang.Object value) {
        return super.addRepeatedField(field, value);
      }

      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.cpdss.common.generated.Loadicator.CargoInfo) {
          return mergeFrom((com.cpdss.common.generated.Loadicator.CargoInfo) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.cpdss.common.generated.Loadicator.CargoInfo other) {
        if (other == com.cpdss.common.generated.Loadicator.CargoInfo.getDefaultInstance())
          return this;
        if (other.getStowagePlanId() != 0L) {
          setStowagePlanId(other.getStowagePlanId());
        }
        if (other.getCargoId() != 0L) {
          setCargoId(other.getCargoId());
        }
        if (!other.getCargoName().isEmpty()) {
          cargoName_ = other.cargoName_;
          onChanged();
        }
        if (!other.getCargoAbbrev().isEmpty()) {
          cargoAbbrev_ = other.cargoAbbrev_;
          onChanged();
        }
        if (!other.getStandardTemp().isEmpty()) {
          standardTemp_ = other.standardTemp_;
          onChanged();
        }
        if (!other.getGrade().isEmpty()) {
          grade_ = other.grade_;
          onChanged();
        }
        if (!other.getDensity().isEmpty()) {
          density_ = other.density_;
          onChanged();
        }
        if (!other.getApi().isEmpty()) {
          api_ = other.api_;
          onChanged();
        }
        if (!other.getDegf().isEmpty()) {
          degf_ = other.degf_;
          onChanged();
        }
        if (!other.getDegc().isEmpty()) {
          degc_ = other.degc_;
          onChanged();
        }
        if (other.getStowageId() != 0L) {
          setStowageId(other.getStowageId());
        }
        if (other.getPortId() != 0L) {
          setPortId(other.getPortId());
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
        com.cpdss.common.generated.Loadicator.CargoInfo parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.Loadicator.CargoInfo) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private long stowagePlanId_;
      /**
       * <code>int64 stowagePlanId = 1;</code>
       *
       * @return The stowagePlanId.
       */
      public long getStowagePlanId() {
        return stowagePlanId_;
      }
      /**
       * <code>int64 stowagePlanId = 1;</code>
       *
       * @param value The stowagePlanId to set.
       * @return This builder for chaining.
       */
      public Builder setStowagePlanId(long value) {

        stowagePlanId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int64 stowagePlanId = 1;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearStowagePlanId() {

        stowagePlanId_ = 0L;
        onChanged();
        return this;
      }

      private long cargoId_;
      /**
       * <code>int64 cargoId = 2;</code>
       *
       * @return The cargoId.
       */
      public long getCargoId() {
        return cargoId_;
      }
      /**
       * <code>int64 cargoId = 2;</code>
       *
       * @param value The cargoId to set.
       * @return This builder for chaining.
       */
      public Builder setCargoId(long value) {

        cargoId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int64 cargoId = 2;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearCargoId() {

        cargoId_ = 0L;
        onChanged();
        return this;
      }

      private java.lang.Object cargoName_ = "";
      /**
       * <code>string cargoName = 3;</code>
       *
       * @return The cargoName.
       */
      public java.lang.String getCargoName() {
        java.lang.Object ref = cargoName_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          cargoName_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string cargoName = 3;</code>
       *
       * @return The bytes for cargoName.
       */
      public com.google.protobuf.ByteString getCargoNameBytes() {
        java.lang.Object ref = cargoName_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          cargoName_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string cargoName = 3;</code>
       *
       * @param value The cargoName to set.
       * @return This builder for chaining.
       */
      public Builder setCargoName(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        cargoName_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string cargoName = 3;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearCargoName() {

        cargoName_ = getDefaultInstance().getCargoName();
        onChanged();
        return this;
      }
      /**
       * <code>string cargoName = 3;</code>
       *
       * @param value The bytes for cargoName to set.
       * @return This builder for chaining.
       */
      public Builder setCargoNameBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        cargoName_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object cargoAbbrev_ = "";
      /**
       * <code>string cargoAbbrev = 4;</code>
       *
       * @return The cargoAbbrev.
       */
      public java.lang.String getCargoAbbrev() {
        java.lang.Object ref = cargoAbbrev_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          cargoAbbrev_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string cargoAbbrev = 4;</code>
       *
       * @return The bytes for cargoAbbrev.
       */
      public com.google.protobuf.ByteString getCargoAbbrevBytes() {
        java.lang.Object ref = cargoAbbrev_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          cargoAbbrev_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string cargoAbbrev = 4;</code>
       *
       * @param value The cargoAbbrev to set.
       * @return This builder for chaining.
       */
      public Builder setCargoAbbrev(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        cargoAbbrev_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string cargoAbbrev = 4;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearCargoAbbrev() {

        cargoAbbrev_ = getDefaultInstance().getCargoAbbrev();
        onChanged();
        return this;
      }
      /**
       * <code>string cargoAbbrev = 4;</code>
       *
       * @param value The bytes for cargoAbbrev to set.
       * @return This builder for chaining.
       */
      public Builder setCargoAbbrevBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        cargoAbbrev_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object standardTemp_ = "";
      /**
       * <code>string standardTemp = 5;</code>
       *
       * @return The standardTemp.
       */
      public java.lang.String getStandardTemp() {
        java.lang.Object ref = standardTemp_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          standardTemp_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string standardTemp = 5;</code>
       *
       * @return The bytes for standardTemp.
       */
      public com.google.protobuf.ByteString getStandardTempBytes() {
        java.lang.Object ref = standardTemp_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          standardTemp_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string standardTemp = 5;</code>
       *
       * @param value The standardTemp to set.
       * @return This builder for chaining.
       */
      public Builder setStandardTemp(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        standardTemp_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string standardTemp = 5;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearStandardTemp() {

        standardTemp_ = getDefaultInstance().getStandardTemp();
        onChanged();
        return this;
      }
      /**
       * <code>string standardTemp = 5;</code>
       *
       * @param value The bytes for standardTemp to set.
       * @return This builder for chaining.
       */
      public Builder setStandardTempBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        standardTemp_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object grade_ = "";
      /**
       * <code>string grade = 6;</code>
       *
       * @return The grade.
       */
      public java.lang.String getGrade() {
        java.lang.Object ref = grade_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          grade_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string grade = 6;</code>
       *
       * @return The bytes for grade.
       */
      public com.google.protobuf.ByteString getGradeBytes() {
        java.lang.Object ref = grade_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          grade_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string grade = 6;</code>
       *
       * @param value The grade to set.
       * @return This builder for chaining.
       */
      public Builder setGrade(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        grade_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string grade = 6;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearGrade() {

        grade_ = getDefaultInstance().getGrade();
        onChanged();
        return this;
      }
      /**
       * <code>string grade = 6;</code>
       *
       * @param value The bytes for grade to set.
       * @return This builder for chaining.
       */
      public Builder setGradeBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        grade_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object density_ = "";
      /**
       * <code>string density = 7;</code>
       *
       * @return The density.
       */
      public java.lang.String getDensity() {
        java.lang.Object ref = density_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          density_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string density = 7;</code>
       *
       * @return The bytes for density.
       */
      public com.google.protobuf.ByteString getDensityBytes() {
        java.lang.Object ref = density_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          density_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string density = 7;</code>
       *
       * @param value The density to set.
       * @return This builder for chaining.
       */
      public Builder setDensity(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        density_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string density = 7;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearDensity() {

        density_ = getDefaultInstance().getDensity();
        onChanged();
        return this;
      }
      /**
       * <code>string density = 7;</code>
       *
       * @param value The bytes for density to set.
       * @return This builder for chaining.
       */
      public Builder setDensityBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        density_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object api_ = "";
      /**
       * <code>string api = 8;</code>
       *
       * @return The api.
       */
      public java.lang.String getApi() {
        java.lang.Object ref = api_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          api_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string api = 8;</code>
       *
       * @return The bytes for api.
       */
      public com.google.protobuf.ByteString getApiBytes() {
        java.lang.Object ref = api_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          api_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string api = 8;</code>
       *
       * @param value The api to set.
       * @return This builder for chaining.
       */
      public Builder setApi(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        api_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string api = 8;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearApi() {

        api_ = getDefaultInstance().getApi();
        onChanged();
        return this;
      }
      /**
       * <code>string api = 8;</code>
       *
       * @param value The bytes for api to set.
       * @return This builder for chaining.
       */
      public Builder setApiBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        api_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object degf_ = "";
      /**
       * <code>string degf = 9;</code>
       *
       * @return The degf.
       */
      public java.lang.String getDegf() {
        java.lang.Object ref = degf_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          degf_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string degf = 9;</code>
       *
       * @return The bytes for degf.
       */
      public com.google.protobuf.ByteString getDegfBytes() {
        java.lang.Object ref = degf_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          degf_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string degf = 9;</code>
       *
       * @param value The degf to set.
       * @return This builder for chaining.
       */
      public Builder setDegf(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        degf_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string degf = 9;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearDegf() {

        degf_ = getDefaultInstance().getDegf();
        onChanged();
        return this;
      }
      /**
       * <code>string degf = 9;</code>
       *
       * @param value The bytes for degf to set.
       * @return This builder for chaining.
       */
      public Builder setDegfBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        degf_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object degc_ = "";
      /**
       * <code>string degc = 10;</code>
       *
       * @return The degc.
       */
      public java.lang.String getDegc() {
        java.lang.Object ref = degc_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          degc_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string degc = 10;</code>
       *
       * @return The bytes for degc.
       */
      public com.google.protobuf.ByteString getDegcBytes() {
        java.lang.Object ref = degc_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          degc_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string degc = 10;</code>
       *
       * @param value The degc to set.
       * @return This builder for chaining.
       */
      public Builder setDegc(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        degc_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string degc = 10;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearDegc() {

        degc_ = getDefaultInstance().getDegc();
        onChanged();
        return this;
      }
      /**
       * <code>string degc = 10;</code>
       *
       * @param value The bytes for degc to set.
       * @return This builder for chaining.
       */
      public Builder setDegcBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        degc_ = value;
        onChanged();
        return this;
      }

      private long stowageId_;
      /**
       * <code>int64 stowageId = 11;</code>
       *
       * @return The stowageId.
       */
      public long getStowageId() {
        return stowageId_;
      }
      /**
       * <code>int64 stowageId = 11;</code>
       *
       * @param value The stowageId to set.
       * @return This builder for chaining.
       */
      public Builder setStowageId(long value) {

        stowageId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int64 stowageId = 11;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearStowageId() {

        stowageId_ = 0L;
        onChanged();
        return this;
      }

      private long portId_;
      /**
       * <code>int64 portId = 12;</code>
       *
       * @return The portId.
       */
      public long getPortId() {
        return portId_;
      }
      /**
       * <code>int64 portId = 12;</code>
       *
       * @param value The portId to set.
       * @return This builder for chaining.
       */
      public Builder setPortId(long value) {

        portId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int64 portId = 12;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearPortId() {

        portId_ = 0L;
        onChanged();
        return this;
      }

      @java.lang.Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }

      // @@protoc_insertion_point(builder_scope:CargoInfo)
    }

    // @@protoc_insertion_point(class_scope:CargoInfo)
    private static final com.cpdss.common.generated.Loadicator.CargoInfo DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.Loadicator.CargoInfo();
    }

    public static com.cpdss.common.generated.Loadicator.CargoInfo getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<CargoInfo> PARSER =
        new com.google.protobuf.AbstractParser<CargoInfo>() {
          @java.lang.Override
          public CargoInfo parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new CargoInfo(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<CargoInfo> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<CargoInfo> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.Loadicator.CargoInfo getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface OtherTankInfoOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:OtherTankInfo)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int64 stowagePlanId = 1;</code>
     *
     * @return The stowagePlanId.
     */
    long getStowagePlanId();

    /**
     * <code>int64 tankId = 2;</code>
     *
     * @return The tankId.
     */
    long getTankId();

    /**
     * <code>string tankName = 3;</code>
     *
     * @return The tankName.
     */
    java.lang.String getTankName();
    /**
     * <code>string tankName = 3;</code>
     *
     * @return The bytes for tankName.
     */
    com.google.protobuf.ByteString getTankNameBytes();

    /**
     * <code>string quantity = 4;</code>
     *
     * @return The quantity.
     */
    java.lang.String getQuantity();
    /**
     * <code>string quantity = 4;</code>
     *
     * @return The bytes for quantity.
     */
    com.google.protobuf.ByteString getQuantityBytes();

    /**
     * <code>string shortName = 5;</code>
     *
     * @return The shortName.
     */
    java.lang.String getShortName();
    /**
     * <code>string shortName = 5;</code>
     *
     * @return The bytes for shortName.
     */
    com.google.protobuf.ByteString getShortNameBytes();

    /**
     * <code>int64 loadableStudyId = 6;</code>
     *
     * @return The loadableStudyId.
     */
    long getLoadableStudyId();

    /**
     * <code>int64 stowageId = 7;</code>
     *
     * @return The stowageId.
     */
    long getStowageId();

    /**
     * <code>int64 portId = 8;</code>
     *
     * @return The portId.
     */
    long getPortId();
  }
  /** Protobuf type {@code OtherTankInfo} */
  public static final class OtherTankInfo extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:OtherTankInfo)
      OtherTankInfoOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use OtherTankInfo.newBuilder() to construct.
    private OtherTankInfo(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private OtherTankInfo() {
      tankName_ = "";
      quantity_ = "";
      shortName_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new OtherTankInfo();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private OtherTankInfo(
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
                stowagePlanId_ = input.readInt64();
                break;
              }
            case 16:
              {
                tankId_ = input.readInt64();
                break;
              }
            case 26:
              {
                java.lang.String s = input.readStringRequireUtf8();

                tankName_ = s;
                break;
              }
            case 34:
              {
                java.lang.String s = input.readStringRequireUtf8();

                quantity_ = s;
                break;
              }
            case 42:
              {
                java.lang.String s = input.readStringRequireUtf8();

                shortName_ = s;
                break;
              }
            case 48:
              {
                loadableStudyId_ = input.readInt64();
                break;
              }
            case 56:
              {
                stowageId_ = input.readInt64();
                break;
              }
            case 64:
              {
                portId_ = input.readInt64();
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
      return com.cpdss.common.generated.Loadicator.internal_static_OtherTankInfo_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.Loadicator.internal_static_OtherTankInfo_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.Loadicator.OtherTankInfo.class,
              com.cpdss.common.generated.Loadicator.OtherTankInfo.Builder.class);
    }

    public static final int STOWAGEPLANID_FIELD_NUMBER = 1;
    private long stowagePlanId_;
    /**
     * <code>int64 stowagePlanId = 1;</code>
     *
     * @return The stowagePlanId.
     */
    public long getStowagePlanId() {
      return stowagePlanId_;
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

    public static final int TANKNAME_FIELD_NUMBER = 3;
    private volatile java.lang.Object tankName_;
    /**
     * <code>string tankName = 3;</code>
     *
     * @return The tankName.
     */
    public java.lang.String getTankName() {
      java.lang.Object ref = tankName_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        tankName_ = s;
        return s;
      }
    }
    /**
     * <code>string tankName = 3;</code>
     *
     * @return The bytes for tankName.
     */
    public com.google.protobuf.ByteString getTankNameBytes() {
      java.lang.Object ref = tankName_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        tankName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int QUANTITY_FIELD_NUMBER = 4;
    private volatile java.lang.Object quantity_;
    /**
     * <code>string quantity = 4;</code>
     *
     * @return The quantity.
     */
    public java.lang.String getQuantity() {
      java.lang.Object ref = quantity_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        quantity_ = s;
        return s;
      }
    }
    /**
     * <code>string quantity = 4;</code>
     *
     * @return The bytes for quantity.
     */
    public com.google.protobuf.ByteString getQuantityBytes() {
      java.lang.Object ref = quantity_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        quantity_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int SHORTNAME_FIELD_NUMBER = 5;
    private volatile java.lang.Object shortName_;
    /**
     * <code>string shortName = 5;</code>
     *
     * @return The shortName.
     */
    public java.lang.String getShortName() {
      java.lang.Object ref = shortName_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        shortName_ = s;
        return s;
      }
    }
    /**
     * <code>string shortName = 5;</code>
     *
     * @return The bytes for shortName.
     */
    public com.google.protobuf.ByteString getShortNameBytes() {
      java.lang.Object ref = shortName_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        shortName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int LOADABLESTUDYID_FIELD_NUMBER = 6;
    private long loadableStudyId_;
    /**
     * <code>int64 loadableStudyId = 6;</code>
     *
     * @return The loadableStudyId.
     */
    public long getLoadableStudyId() {
      return loadableStudyId_;
    }

    public static final int STOWAGEID_FIELD_NUMBER = 7;
    private long stowageId_;
    /**
     * <code>int64 stowageId = 7;</code>
     *
     * @return The stowageId.
     */
    public long getStowageId() {
      return stowageId_;
    }

    public static final int PORTID_FIELD_NUMBER = 8;
    private long portId_;
    /**
     * <code>int64 portId = 8;</code>
     *
     * @return The portId.
     */
    public long getPortId() {
      return portId_;
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
      if (stowagePlanId_ != 0L) {
        output.writeInt64(1, stowagePlanId_);
      }
      if (tankId_ != 0L) {
        output.writeInt64(2, tankId_);
      }
      if (!getTankNameBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, tankName_);
      }
      if (!getQuantityBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 4, quantity_);
      }
      if (!getShortNameBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 5, shortName_);
      }
      if (loadableStudyId_ != 0L) {
        output.writeInt64(6, loadableStudyId_);
      }
      if (stowageId_ != 0L) {
        output.writeInt64(7, stowageId_);
      }
      if (portId_ != 0L) {
        output.writeInt64(8, portId_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (stowagePlanId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(1, stowagePlanId_);
      }
      if (tankId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(2, tankId_);
      }
      if (!getTankNameBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, tankName_);
      }
      if (!getQuantityBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, quantity_);
      }
      if (!getShortNameBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, shortName_);
      }
      if (loadableStudyId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(6, loadableStudyId_);
      }
      if (stowageId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(7, stowageId_);
      }
      if (portId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(8, portId_);
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
      if (!(obj instanceof com.cpdss.common.generated.Loadicator.OtherTankInfo)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.Loadicator.OtherTankInfo other =
          (com.cpdss.common.generated.Loadicator.OtherTankInfo) obj;

      if (getStowagePlanId() != other.getStowagePlanId()) return false;
      if (getTankId() != other.getTankId()) return false;
      if (!getTankName().equals(other.getTankName())) return false;
      if (!getQuantity().equals(other.getQuantity())) return false;
      if (!getShortName().equals(other.getShortName())) return false;
      if (getLoadableStudyId() != other.getLoadableStudyId()) return false;
      if (getStowageId() != other.getStowageId()) return false;
      if (getPortId() != other.getPortId()) return false;
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
      hash = (37 * hash) + STOWAGEPLANID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getStowagePlanId());
      hash = (37 * hash) + TANKID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getTankId());
      hash = (37 * hash) + TANKNAME_FIELD_NUMBER;
      hash = (53 * hash) + getTankName().hashCode();
      hash = (37 * hash) + QUANTITY_FIELD_NUMBER;
      hash = (53 * hash) + getQuantity().hashCode();
      hash = (37 * hash) + SHORTNAME_FIELD_NUMBER;
      hash = (53 * hash) + getShortName().hashCode();
      hash = (37 * hash) + LOADABLESTUDYID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getLoadableStudyId());
      hash = (37 * hash) + STOWAGEID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getStowageId());
      hash = (37 * hash) + PORTID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getPortId());
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.Loadicator.OtherTankInfo parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Loadicator.OtherTankInfo parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Loadicator.OtherTankInfo parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Loadicator.OtherTankInfo parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Loadicator.OtherTankInfo parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Loadicator.OtherTankInfo parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Loadicator.OtherTankInfo parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Loadicator.OtherTankInfo parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.Loadicator.OtherTankInfo parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Loadicator.OtherTankInfo parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.Loadicator.OtherTankInfo parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Loadicator.OtherTankInfo parseFrom(
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
        com.cpdss.common.generated.Loadicator.OtherTankInfo prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }

    @java.lang.Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /** Protobuf type {@code OtherTankInfo} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:OtherTankInfo)
        com.cpdss.common.generated.Loadicator.OtherTankInfoOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.Loadicator.internal_static_OtherTankInfo_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.Loadicator
            .internal_static_OtherTankInfo_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.Loadicator.OtherTankInfo.class,
                com.cpdss.common.generated.Loadicator.OtherTankInfo.Builder.class);
      }

      // Construct using com.cpdss.common.generated.Loadicator.OtherTankInfo.newBuilder()
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
        stowagePlanId_ = 0L;

        tankId_ = 0L;

        tankName_ = "";

        quantity_ = "";

        shortName_ = "";

        loadableStudyId_ = 0L;

        stowageId_ = 0L;

        portId_ = 0L;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.Loadicator.internal_static_OtherTankInfo_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.Loadicator.OtherTankInfo getDefaultInstanceForType() {
        return com.cpdss.common.generated.Loadicator.OtherTankInfo.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.Loadicator.OtherTankInfo build() {
        com.cpdss.common.generated.Loadicator.OtherTankInfo result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.Loadicator.OtherTankInfo buildPartial() {
        com.cpdss.common.generated.Loadicator.OtherTankInfo result =
            new com.cpdss.common.generated.Loadicator.OtherTankInfo(this);
        result.stowagePlanId_ = stowagePlanId_;
        result.tankId_ = tankId_;
        result.tankName_ = tankName_;
        result.quantity_ = quantity_;
        result.shortName_ = shortName_;
        result.loadableStudyId_ = loadableStudyId_;
        result.stowageId_ = stowageId_;
        result.portId_ = portId_;
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
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index,
          java.lang.Object value) {
        return super.setRepeatedField(field, index, value);
      }

      @java.lang.Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field, java.lang.Object value) {
        return super.addRepeatedField(field, value);
      }

      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.cpdss.common.generated.Loadicator.OtherTankInfo) {
          return mergeFrom((com.cpdss.common.generated.Loadicator.OtherTankInfo) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.cpdss.common.generated.Loadicator.OtherTankInfo other) {
        if (other == com.cpdss.common.generated.Loadicator.OtherTankInfo.getDefaultInstance())
          return this;
        if (other.getStowagePlanId() != 0L) {
          setStowagePlanId(other.getStowagePlanId());
        }
        if (other.getTankId() != 0L) {
          setTankId(other.getTankId());
        }
        if (!other.getTankName().isEmpty()) {
          tankName_ = other.tankName_;
          onChanged();
        }
        if (!other.getQuantity().isEmpty()) {
          quantity_ = other.quantity_;
          onChanged();
        }
        if (!other.getShortName().isEmpty()) {
          shortName_ = other.shortName_;
          onChanged();
        }
        if (other.getLoadableStudyId() != 0L) {
          setLoadableStudyId(other.getLoadableStudyId());
        }
        if (other.getStowageId() != 0L) {
          setStowageId(other.getStowageId());
        }
        if (other.getPortId() != 0L) {
          setPortId(other.getPortId());
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
        com.cpdss.common.generated.Loadicator.OtherTankInfo parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.Loadicator.OtherTankInfo) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private long stowagePlanId_;
      /**
       * <code>int64 stowagePlanId = 1;</code>
       *
       * @return The stowagePlanId.
       */
      public long getStowagePlanId() {
        return stowagePlanId_;
      }
      /**
       * <code>int64 stowagePlanId = 1;</code>
       *
       * @param value The stowagePlanId to set.
       * @return This builder for chaining.
       */
      public Builder setStowagePlanId(long value) {

        stowagePlanId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int64 stowagePlanId = 1;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearStowagePlanId() {

        stowagePlanId_ = 0L;
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

      private java.lang.Object tankName_ = "";
      /**
       * <code>string tankName = 3;</code>
       *
       * @return The tankName.
       */
      public java.lang.String getTankName() {
        java.lang.Object ref = tankName_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          tankName_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string tankName = 3;</code>
       *
       * @return The bytes for tankName.
       */
      public com.google.protobuf.ByteString getTankNameBytes() {
        java.lang.Object ref = tankName_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          tankName_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string tankName = 3;</code>
       *
       * @param value The tankName to set.
       * @return This builder for chaining.
       */
      public Builder setTankName(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        tankName_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string tankName = 3;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearTankName() {

        tankName_ = getDefaultInstance().getTankName();
        onChanged();
        return this;
      }
      /**
       * <code>string tankName = 3;</code>
       *
       * @param value The bytes for tankName to set.
       * @return This builder for chaining.
       */
      public Builder setTankNameBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        tankName_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object quantity_ = "";
      /**
       * <code>string quantity = 4;</code>
       *
       * @return The quantity.
       */
      public java.lang.String getQuantity() {
        java.lang.Object ref = quantity_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          quantity_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string quantity = 4;</code>
       *
       * @return The bytes for quantity.
       */
      public com.google.protobuf.ByteString getQuantityBytes() {
        java.lang.Object ref = quantity_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          quantity_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string quantity = 4;</code>
       *
       * @param value The quantity to set.
       * @return This builder for chaining.
       */
      public Builder setQuantity(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        quantity_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string quantity = 4;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearQuantity() {

        quantity_ = getDefaultInstance().getQuantity();
        onChanged();
        return this;
      }
      /**
       * <code>string quantity = 4;</code>
       *
       * @param value The bytes for quantity to set.
       * @return This builder for chaining.
       */
      public Builder setQuantityBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        quantity_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object shortName_ = "";
      /**
       * <code>string shortName = 5;</code>
       *
       * @return The shortName.
       */
      public java.lang.String getShortName() {
        java.lang.Object ref = shortName_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          shortName_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string shortName = 5;</code>
       *
       * @return The bytes for shortName.
       */
      public com.google.protobuf.ByteString getShortNameBytes() {
        java.lang.Object ref = shortName_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          shortName_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string shortName = 5;</code>
       *
       * @param value The shortName to set.
       * @return This builder for chaining.
       */
      public Builder setShortName(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        shortName_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string shortName = 5;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearShortName() {

        shortName_ = getDefaultInstance().getShortName();
        onChanged();
        return this;
      }
      /**
       * <code>string shortName = 5;</code>
       *
       * @param value The bytes for shortName to set.
       * @return This builder for chaining.
       */
      public Builder setShortNameBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        shortName_ = value;
        onChanged();
        return this;
      }

      private long loadableStudyId_;
      /**
       * <code>int64 loadableStudyId = 6;</code>
       *
       * @return The loadableStudyId.
       */
      public long getLoadableStudyId() {
        return loadableStudyId_;
      }
      /**
       * <code>int64 loadableStudyId = 6;</code>
       *
       * @param value The loadableStudyId to set.
       * @return This builder for chaining.
       */
      public Builder setLoadableStudyId(long value) {

        loadableStudyId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int64 loadableStudyId = 6;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearLoadableStudyId() {

        loadableStudyId_ = 0L;
        onChanged();
        return this;
      }

      private long stowageId_;
      /**
       * <code>int64 stowageId = 7;</code>
       *
       * @return The stowageId.
       */
      public long getStowageId() {
        return stowageId_;
      }
      /**
       * <code>int64 stowageId = 7;</code>
       *
       * @param value The stowageId to set.
       * @return This builder for chaining.
       */
      public Builder setStowageId(long value) {

        stowageId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int64 stowageId = 7;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearStowageId() {

        stowageId_ = 0L;
        onChanged();
        return this;
      }

      private long portId_;
      /**
       * <code>int64 portId = 8;</code>
       *
       * @return The portId.
       */
      public long getPortId() {
        return portId_;
      }
      /**
       * <code>int64 portId = 8;</code>
       *
       * @param value The portId to set.
       * @return This builder for chaining.
       */
      public Builder setPortId(long value) {

        portId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int64 portId = 8;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearPortId() {

        portId_ = 0L;
        onChanged();
        return this;
      }

      @java.lang.Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }

      // @@protoc_insertion_point(builder_scope:OtherTankInfo)
    }

    // @@protoc_insertion_point(class_scope:OtherTankInfo)
    private static final com.cpdss.common.generated.Loadicator.OtherTankInfo DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.Loadicator.OtherTankInfo();
    }

    public static com.cpdss.common.generated.Loadicator.OtherTankInfo getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<OtherTankInfo> PARSER =
        new com.google.protobuf.AbstractParser<OtherTankInfo>() {
          @java.lang.Override
          public OtherTankInfo parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new OtherTankInfo(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<OtherTankInfo> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<OtherTankInfo> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.Loadicator.OtherTankInfo getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface LoadicatorReplyOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:LoadicatorReply)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>.ResponseStatus responseStatus = 1;</code>
     *
     * @return Whether the responseStatus field is set.
     */
    boolean hasResponseStatus();
    /**
     * <code>.ResponseStatus responseStatus = 1;</code>
     *
     * @return The responseStatus.
     */
    com.cpdss.common.generated.Common.ResponseStatus getResponseStatus();
    /** <code>.ResponseStatus responseStatus = 1;</code> */
    com.cpdss.common.generated.Common.ResponseStatusOrBuilder getResponseStatusOrBuilder();
  }
  /** Protobuf type {@code LoadicatorReply} */
  public static final class LoadicatorReply extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:LoadicatorReply)
      LoadicatorReplyOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use LoadicatorReply.newBuilder() to construct.
    private LoadicatorReply(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private LoadicatorReply() {}

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new LoadicatorReply();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private LoadicatorReply(
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
                com.cpdss.common.generated.Common.ResponseStatus.Builder subBuilder = null;
                if (responseStatus_ != null) {
                  subBuilder = responseStatus_.toBuilder();
                }
                responseStatus_ =
                    input.readMessage(
                        com.cpdss.common.generated.Common.ResponseStatus.parser(),
                        extensionRegistry);
                if (subBuilder != null) {
                  subBuilder.mergeFrom(responseStatus_);
                  responseStatus_ = subBuilder.buildPartial();
                }

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
      return com.cpdss.common.generated.Loadicator.internal_static_LoadicatorReply_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.Loadicator
          .internal_static_LoadicatorReply_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.Loadicator.LoadicatorReply.class,
              com.cpdss.common.generated.Loadicator.LoadicatorReply.Builder.class);
    }

    public static final int RESPONSESTATUS_FIELD_NUMBER = 1;
    private com.cpdss.common.generated.Common.ResponseStatus responseStatus_;
    /**
     * <code>.ResponseStatus responseStatus = 1;</code>
     *
     * @return Whether the responseStatus field is set.
     */
    public boolean hasResponseStatus() {
      return responseStatus_ != null;
    }
    /**
     * <code>.ResponseStatus responseStatus = 1;</code>
     *
     * @return The responseStatus.
     */
    public com.cpdss.common.generated.Common.ResponseStatus getResponseStatus() {
      return responseStatus_ == null
          ? com.cpdss.common.generated.Common.ResponseStatus.getDefaultInstance()
          : responseStatus_;
    }
    /** <code>.ResponseStatus responseStatus = 1;</code> */
    public com.cpdss.common.generated.Common.ResponseStatusOrBuilder getResponseStatusOrBuilder() {
      return getResponseStatus();
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
      if (responseStatus_ != null) {
        output.writeMessage(1, getResponseStatus());
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (responseStatus_ != null) {
        size += com.google.protobuf.CodedOutputStream.computeMessageSize(1, getResponseStatus());
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
      if (!(obj instanceof com.cpdss.common.generated.Loadicator.LoadicatorReply)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.Loadicator.LoadicatorReply other =
          (com.cpdss.common.generated.Loadicator.LoadicatorReply) obj;

      if (hasResponseStatus() != other.hasResponseStatus()) return false;
      if (hasResponseStatus()) {
        if (!getResponseStatus().equals(other.getResponseStatus())) return false;
      }
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
      if (hasResponseStatus()) {
        hash = (37 * hash) + RESPONSESTATUS_FIELD_NUMBER;
        hash = (53 * hash) + getResponseStatus().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.Loadicator.LoadicatorReply parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Loadicator.LoadicatorReply parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Loadicator.LoadicatorReply parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Loadicator.LoadicatorReply parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Loadicator.LoadicatorReply parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Loadicator.LoadicatorReply parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Loadicator.LoadicatorReply parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Loadicator.LoadicatorReply parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.Loadicator.LoadicatorReply parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Loadicator.LoadicatorReply parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.Loadicator.LoadicatorReply parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Loadicator.LoadicatorReply parseFrom(
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
        com.cpdss.common.generated.Loadicator.LoadicatorReply prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }

    @java.lang.Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /** Protobuf type {@code LoadicatorReply} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:LoadicatorReply)
        com.cpdss.common.generated.Loadicator.LoadicatorReplyOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.Loadicator.internal_static_LoadicatorReply_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.Loadicator
            .internal_static_LoadicatorReply_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.Loadicator.LoadicatorReply.class,
                com.cpdss.common.generated.Loadicator.LoadicatorReply.Builder.class);
      }

      // Construct using com.cpdss.common.generated.Loadicator.LoadicatorReply.newBuilder()
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
        if (responseStatusBuilder_ == null) {
          responseStatus_ = null;
        } else {
          responseStatus_ = null;
          responseStatusBuilder_ = null;
        }
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.Loadicator.internal_static_LoadicatorReply_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.Loadicator.LoadicatorReply getDefaultInstanceForType() {
        return com.cpdss.common.generated.Loadicator.LoadicatorReply.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.Loadicator.LoadicatorReply build() {
        com.cpdss.common.generated.Loadicator.LoadicatorReply result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.Loadicator.LoadicatorReply buildPartial() {
        com.cpdss.common.generated.Loadicator.LoadicatorReply result =
            new com.cpdss.common.generated.Loadicator.LoadicatorReply(this);
        if (responseStatusBuilder_ == null) {
          result.responseStatus_ = responseStatus_;
        } else {
          result.responseStatus_ = responseStatusBuilder_.build();
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
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index,
          java.lang.Object value) {
        return super.setRepeatedField(field, index, value);
      }

      @java.lang.Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field, java.lang.Object value) {
        return super.addRepeatedField(field, value);
      }

      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.cpdss.common.generated.Loadicator.LoadicatorReply) {
          return mergeFrom((com.cpdss.common.generated.Loadicator.LoadicatorReply) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.cpdss.common.generated.Loadicator.LoadicatorReply other) {
        if (other == com.cpdss.common.generated.Loadicator.LoadicatorReply.getDefaultInstance())
          return this;
        if (other.hasResponseStatus()) {
          mergeResponseStatus(other.getResponseStatus());
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
        com.cpdss.common.generated.Loadicator.LoadicatorReply parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.Loadicator.LoadicatorReply) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private com.cpdss.common.generated.Common.ResponseStatus responseStatus_;
      private com.google.protobuf.SingleFieldBuilderV3<
              com.cpdss.common.generated.Common.ResponseStatus,
              com.cpdss.common.generated.Common.ResponseStatus.Builder,
              com.cpdss.common.generated.Common.ResponseStatusOrBuilder>
          responseStatusBuilder_;
      /**
       * <code>.ResponseStatus responseStatus = 1;</code>
       *
       * @return Whether the responseStatus field is set.
       */
      public boolean hasResponseStatus() {
        return responseStatusBuilder_ != null || responseStatus_ != null;
      }
      /**
       * <code>.ResponseStatus responseStatus = 1;</code>
       *
       * @return The responseStatus.
       */
      public com.cpdss.common.generated.Common.ResponseStatus getResponseStatus() {
        if (responseStatusBuilder_ == null) {
          return responseStatus_ == null
              ? com.cpdss.common.generated.Common.ResponseStatus.getDefaultInstance()
              : responseStatus_;
        } else {
          return responseStatusBuilder_.getMessage();
        }
      }
      /** <code>.ResponseStatus responseStatus = 1;</code> */
      public Builder setResponseStatus(com.cpdss.common.generated.Common.ResponseStatus value) {
        if (responseStatusBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          responseStatus_ = value;
          onChanged();
        } else {
          responseStatusBuilder_.setMessage(value);
        }

        return this;
      }
      /** <code>.ResponseStatus responseStatus = 1;</code> */
      public Builder setResponseStatus(
          com.cpdss.common.generated.Common.ResponseStatus.Builder builderForValue) {
        if (responseStatusBuilder_ == null) {
          responseStatus_ = builderForValue.build();
          onChanged();
        } else {
          responseStatusBuilder_.setMessage(builderForValue.build());
        }

        return this;
      }
      /** <code>.ResponseStatus responseStatus = 1;</code> */
      public Builder mergeResponseStatus(com.cpdss.common.generated.Common.ResponseStatus value) {
        if (responseStatusBuilder_ == null) {
          if (responseStatus_ != null) {
            responseStatus_ =
                com.cpdss.common.generated.Common.ResponseStatus.newBuilder(responseStatus_)
                    .mergeFrom(value)
                    .buildPartial();
          } else {
            responseStatus_ = value;
          }
          onChanged();
        } else {
          responseStatusBuilder_.mergeFrom(value);
        }

        return this;
      }
      /** <code>.ResponseStatus responseStatus = 1;</code> */
      public Builder clearResponseStatus() {
        if (responseStatusBuilder_ == null) {
          responseStatus_ = null;
          onChanged();
        } else {
          responseStatus_ = null;
          responseStatusBuilder_ = null;
        }

        return this;
      }
      /** <code>.ResponseStatus responseStatus = 1;</code> */
      public com.cpdss.common.generated.Common.ResponseStatus.Builder getResponseStatusBuilder() {

        onChanged();
        return getResponseStatusFieldBuilder().getBuilder();
      }
      /** <code>.ResponseStatus responseStatus = 1;</code> */
      public com.cpdss.common.generated.Common.ResponseStatusOrBuilder
          getResponseStatusOrBuilder() {
        if (responseStatusBuilder_ != null) {
          return responseStatusBuilder_.getMessageOrBuilder();
        } else {
          return responseStatus_ == null
              ? com.cpdss.common.generated.Common.ResponseStatus.getDefaultInstance()
              : responseStatus_;
        }
      }
      /** <code>.ResponseStatus responseStatus = 1;</code> */
      private com.google.protobuf.SingleFieldBuilderV3<
              com.cpdss.common.generated.Common.ResponseStatus,
              com.cpdss.common.generated.Common.ResponseStatus.Builder,
              com.cpdss.common.generated.Common.ResponseStatusOrBuilder>
          getResponseStatusFieldBuilder() {
        if (responseStatusBuilder_ == null) {
          responseStatusBuilder_ =
              new com.google.protobuf.SingleFieldBuilderV3<
                  com.cpdss.common.generated.Common.ResponseStatus,
                  com.cpdss.common.generated.Common.ResponseStatus.Builder,
                  com.cpdss.common.generated.Common.ResponseStatusOrBuilder>(
                  getResponseStatus(), getParentForChildren(), isClean());
          responseStatus_ = null;
        }
        return responseStatusBuilder_;
      }

      @java.lang.Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }

      // @@protoc_insertion_point(builder_scope:LoadicatorReply)
    }

    // @@protoc_insertion_point(class_scope:LoadicatorReply)
    private static final com.cpdss.common.generated.Loadicator.LoadicatorReply DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.Loadicator.LoadicatorReply();
    }

    public static com.cpdss.common.generated.Loadicator.LoadicatorReply getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<LoadicatorReply> PARSER =
        new com.google.protobuf.AbstractParser<LoadicatorReply>() {
          @java.lang.Override
          public LoadicatorReply parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new LoadicatorReply(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<LoadicatorReply> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<LoadicatorReply> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.Loadicator.LoadicatorReply getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface BallastInfoOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:BallastInfo)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int64 stowagePlanId = 1;</code>
     *
     * @return The stowagePlanId.
     */
    long getStowagePlanId();

    /**
     * <code>int64 tankId = 2;</code>
     *
     * @return The tankId.
     */
    long getTankId();

    /**
     * <code>string tankName = 3;</code>
     *
     * @return The tankName.
     */
    java.lang.String getTankName();
    /**
     * <code>string tankName = 3;</code>
     *
     * @return The bytes for tankName.
     */
    com.google.protobuf.ByteString getTankNameBytes();

    /**
     * <code>string quantity = 4;</code>
     *
     * @return The quantity.
     */
    java.lang.String getQuantity();
    /**
     * <code>string quantity = 4;</code>
     *
     * @return The bytes for quantity.
     */
    com.google.protobuf.ByteString getQuantityBytes();

    /**
     * <code>string shortName = 5;</code>
     *
     * @return The shortName.
     */
    java.lang.String getShortName();
    /**
     * <code>string shortName = 5;</code>
     *
     * @return The bytes for shortName.
     */
    com.google.protobuf.ByteString getShortNameBytes();

    /**
     * <code>int64 stowageId = 6;</code>
     *
     * @return The stowageId.
     */
    long getStowageId();

    /**
     * <code>int64 portId = 7;</code>
     *
     * @return The portId.
     */
    long getPortId();
  }
  /** Protobuf type {@code BallastInfo} */
  public static final class BallastInfo extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:BallastInfo)
      BallastInfoOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use BallastInfo.newBuilder() to construct.
    private BallastInfo(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private BallastInfo() {
      tankName_ = "";
      quantity_ = "";
      shortName_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new BallastInfo();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private BallastInfo(
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
                stowagePlanId_ = input.readInt64();
                break;
              }
            case 16:
              {
                tankId_ = input.readInt64();
                break;
              }
            case 26:
              {
                java.lang.String s = input.readStringRequireUtf8();

                tankName_ = s;
                break;
              }
            case 34:
              {
                java.lang.String s = input.readStringRequireUtf8();

                quantity_ = s;
                break;
              }
            case 42:
              {
                java.lang.String s = input.readStringRequireUtf8();

                shortName_ = s;
                break;
              }
            case 48:
              {
                stowageId_ = input.readInt64();
                break;
              }
            case 56:
              {
                portId_ = input.readInt64();
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
      return com.cpdss.common.generated.Loadicator.internal_static_BallastInfo_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.Loadicator.internal_static_BallastInfo_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.Loadicator.BallastInfo.class,
              com.cpdss.common.generated.Loadicator.BallastInfo.Builder.class);
    }

    public static final int STOWAGEPLANID_FIELD_NUMBER = 1;
    private long stowagePlanId_;
    /**
     * <code>int64 stowagePlanId = 1;</code>
     *
     * @return The stowagePlanId.
     */
    public long getStowagePlanId() {
      return stowagePlanId_;
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

    public static final int TANKNAME_FIELD_NUMBER = 3;
    private volatile java.lang.Object tankName_;
    /**
     * <code>string tankName = 3;</code>
     *
     * @return The tankName.
     */
    public java.lang.String getTankName() {
      java.lang.Object ref = tankName_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        tankName_ = s;
        return s;
      }
    }
    /**
     * <code>string tankName = 3;</code>
     *
     * @return The bytes for tankName.
     */
    public com.google.protobuf.ByteString getTankNameBytes() {
      java.lang.Object ref = tankName_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        tankName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int QUANTITY_FIELD_NUMBER = 4;
    private volatile java.lang.Object quantity_;
    /**
     * <code>string quantity = 4;</code>
     *
     * @return The quantity.
     */
    public java.lang.String getQuantity() {
      java.lang.Object ref = quantity_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        quantity_ = s;
        return s;
      }
    }
    /**
     * <code>string quantity = 4;</code>
     *
     * @return The bytes for quantity.
     */
    public com.google.protobuf.ByteString getQuantityBytes() {
      java.lang.Object ref = quantity_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        quantity_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int SHORTNAME_FIELD_NUMBER = 5;
    private volatile java.lang.Object shortName_;
    /**
     * <code>string shortName = 5;</code>
     *
     * @return The shortName.
     */
    public java.lang.String getShortName() {
      java.lang.Object ref = shortName_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        shortName_ = s;
        return s;
      }
    }
    /**
     * <code>string shortName = 5;</code>
     *
     * @return The bytes for shortName.
     */
    public com.google.protobuf.ByteString getShortNameBytes() {
      java.lang.Object ref = shortName_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        shortName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int STOWAGEID_FIELD_NUMBER = 6;
    private long stowageId_;
    /**
     * <code>int64 stowageId = 6;</code>
     *
     * @return The stowageId.
     */
    public long getStowageId() {
      return stowageId_;
    }

    public static final int PORTID_FIELD_NUMBER = 7;
    private long portId_;
    /**
     * <code>int64 portId = 7;</code>
     *
     * @return The portId.
     */
    public long getPortId() {
      return portId_;
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
      if (stowagePlanId_ != 0L) {
        output.writeInt64(1, stowagePlanId_);
      }
      if (tankId_ != 0L) {
        output.writeInt64(2, tankId_);
      }
      if (!getTankNameBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, tankName_);
      }
      if (!getQuantityBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 4, quantity_);
      }
      if (!getShortNameBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 5, shortName_);
      }
      if (stowageId_ != 0L) {
        output.writeInt64(6, stowageId_);
      }
      if (portId_ != 0L) {
        output.writeInt64(7, portId_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (stowagePlanId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(1, stowagePlanId_);
      }
      if (tankId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(2, tankId_);
      }
      if (!getTankNameBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, tankName_);
      }
      if (!getQuantityBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, quantity_);
      }
      if (!getShortNameBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, shortName_);
      }
      if (stowageId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(6, stowageId_);
      }
      if (portId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(7, portId_);
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
      if (!(obj instanceof com.cpdss.common.generated.Loadicator.BallastInfo)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.Loadicator.BallastInfo other =
          (com.cpdss.common.generated.Loadicator.BallastInfo) obj;

      if (getStowagePlanId() != other.getStowagePlanId()) return false;
      if (getTankId() != other.getTankId()) return false;
      if (!getTankName().equals(other.getTankName())) return false;
      if (!getQuantity().equals(other.getQuantity())) return false;
      if (!getShortName().equals(other.getShortName())) return false;
      if (getStowageId() != other.getStowageId()) return false;
      if (getPortId() != other.getPortId()) return false;
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
      hash = (37 * hash) + STOWAGEPLANID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getStowagePlanId());
      hash = (37 * hash) + TANKID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getTankId());
      hash = (37 * hash) + TANKNAME_FIELD_NUMBER;
      hash = (53 * hash) + getTankName().hashCode();
      hash = (37 * hash) + QUANTITY_FIELD_NUMBER;
      hash = (53 * hash) + getQuantity().hashCode();
      hash = (37 * hash) + SHORTNAME_FIELD_NUMBER;
      hash = (53 * hash) + getShortName().hashCode();
      hash = (37 * hash) + STOWAGEID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getStowageId());
      hash = (37 * hash) + PORTID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getPortId());
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.Loadicator.BallastInfo parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Loadicator.BallastInfo parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Loadicator.BallastInfo parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Loadicator.BallastInfo parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Loadicator.BallastInfo parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Loadicator.BallastInfo parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Loadicator.BallastInfo parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Loadicator.BallastInfo parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.Loadicator.BallastInfo parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Loadicator.BallastInfo parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.Loadicator.BallastInfo parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Loadicator.BallastInfo parseFrom(
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

    public static Builder newBuilder(com.cpdss.common.generated.Loadicator.BallastInfo prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }

    @java.lang.Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /** Protobuf type {@code BallastInfo} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:BallastInfo)
        com.cpdss.common.generated.Loadicator.BallastInfoOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.Loadicator.internal_static_BallastInfo_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.Loadicator.internal_static_BallastInfo_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.Loadicator.BallastInfo.class,
                com.cpdss.common.generated.Loadicator.BallastInfo.Builder.class);
      }

      // Construct using com.cpdss.common.generated.Loadicator.BallastInfo.newBuilder()
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
        stowagePlanId_ = 0L;

        tankId_ = 0L;

        tankName_ = "";

        quantity_ = "";

        shortName_ = "";

        stowageId_ = 0L;

        portId_ = 0L;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.Loadicator.internal_static_BallastInfo_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.Loadicator.BallastInfo getDefaultInstanceForType() {
        return com.cpdss.common.generated.Loadicator.BallastInfo.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.Loadicator.BallastInfo build() {
        com.cpdss.common.generated.Loadicator.BallastInfo result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.Loadicator.BallastInfo buildPartial() {
        com.cpdss.common.generated.Loadicator.BallastInfo result =
            new com.cpdss.common.generated.Loadicator.BallastInfo(this);
        result.stowagePlanId_ = stowagePlanId_;
        result.tankId_ = tankId_;
        result.tankName_ = tankName_;
        result.quantity_ = quantity_;
        result.shortName_ = shortName_;
        result.stowageId_ = stowageId_;
        result.portId_ = portId_;
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
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index,
          java.lang.Object value) {
        return super.setRepeatedField(field, index, value);
      }

      @java.lang.Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field, java.lang.Object value) {
        return super.addRepeatedField(field, value);
      }

      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.cpdss.common.generated.Loadicator.BallastInfo) {
          return mergeFrom((com.cpdss.common.generated.Loadicator.BallastInfo) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.cpdss.common.generated.Loadicator.BallastInfo other) {
        if (other == com.cpdss.common.generated.Loadicator.BallastInfo.getDefaultInstance())
          return this;
        if (other.getStowagePlanId() != 0L) {
          setStowagePlanId(other.getStowagePlanId());
        }
        if (other.getTankId() != 0L) {
          setTankId(other.getTankId());
        }
        if (!other.getTankName().isEmpty()) {
          tankName_ = other.tankName_;
          onChanged();
        }
        if (!other.getQuantity().isEmpty()) {
          quantity_ = other.quantity_;
          onChanged();
        }
        if (!other.getShortName().isEmpty()) {
          shortName_ = other.shortName_;
          onChanged();
        }
        if (other.getStowageId() != 0L) {
          setStowageId(other.getStowageId());
        }
        if (other.getPortId() != 0L) {
          setPortId(other.getPortId());
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
        com.cpdss.common.generated.Loadicator.BallastInfo parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.Loadicator.BallastInfo) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private long stowagePlanId_;
      /**
       * <code>int64 stowagePlanId = 1;</code>
       *
       * @return The stowagePlanId.
       */
      public long getStowagePlanId() {
        return stowagePlanId_;
      }
      /**
       * <code>int64 stowagePlanId = 1;</code>
       *
       * @param value The stowagePlanId to set.
       * @return This builder for chaining.
       */
      public Builder setStowagePlanId(long value) {

        stowagePlanId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int64 stowagePlanId = 1;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearStowagePlanId() {

        stowagePlanId_ = 0L;
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

      private java.lang.Object tankName_ = "";
      /**
       * <code>string tankName = 3;</code>
       *
       * @return The tankName.
       */
      public java.lang.String getTankName() {
        java.lang.Object ref = tankName_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          tankName_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string tankName = 3;</code>
       *
       * @return The bytes for tankName.
       */
      public com.google.protobuf.ByteString getTankNameBytes() {
        java.lang.Object ref = tankName_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          tankName_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string tankName = 3;</code>
       *
       * @param value The tankName to set.
       * @return This builder for chaining.
       */
      public Builder setTankName(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        tankName_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string tankName = 3;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearTankName() {

        tankName_ = getDefaultInstance().getTankName();
        onChanged();
        return this;
      }
      /**
       * <code>string tankName = 3;</code>
       *
       * @param value The bytes for tankName to set.
       * @return This builder for chaining.
       */
      public Builder setTankNameBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        tankName_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object quantity_ = "";
      /**
       * <code>string quantity = 4;</code>
       *
       * @return The quantity.
       */
      public java.lang.String getQuantity() {
        java.lang.Object ref = quantity_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          quantity_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string quantity = 4;</code>
       *
       * @return The bytes for quantity.
       */
      public com.google.protobuf.ByteString getQuantityBytes() {
        java.lang.Object ref = quantity_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          quantity_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string quantity = 4;</code>
       *
       * @param value The quantity to set.
       * @return This builder for chaining.
       */
      public Builder setQuantity(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        quantity_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string quantity = 4;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearQuantity() {

        quantity_ = getDefaultInstance().getQuantity();
        onChanged();
        return this;
      }
      /**
       * <code>string quantity = 4;</code>
       *
       * @param value The bytes for quantity to set.
       * @return This builder for chaining.
       */
      public Builder setQuantityBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        quantity_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object shortName_ = "";
      /**
       * <code>string shortName = 5;</code>
       *
       * @return The shortName.
       */
      public java.lang.String getShortName() {
        java.lang.Object ref = shortName_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          shortName_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string shortName = 5;</code>
       *
       * @return The bytes for shortName.
       */
      public com.google.protobuf.ByteString getShortNameBytes() {
        java.lang.Object ref = shortName_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          shortName_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string shortName = 5;</code>
       *
       * @param value The shortName to set.
       * @return This builder for chaining.
       */
      public Builder setShortName(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        shortName_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string shortName = 5;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearShortName() {

        shortName_ = getDefaultInstance().getShortName();
        onChanged();
        return this;
      }
      /**
       * <code>string shortName = 5;</code>
       *
       * @param value The bytes for shortName to set.
       * @return This builder for chaining.
       */
      public Builder setShortNameBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        shortName_ = value;
        onChanged();
        return this;
      }

      private long stowageId_;
      /**
       * <code>int64 stowageId = 6;</code>
       *
       * @return The stowageId.
       */
      public long getStowageId() {
        return stowageId_;
      }
      /**
       * <code>int64 stowageId = 6;</code>
       *
       * @param value The stowageId to set.
       * @return This builder for chaining.
       */
      public Builder setStowageId(long value) {

        stowageId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int64 stowageId = 6;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearStowageId() {

        stowageId_ = 0L;
        onChanged();
        return this;
      }

      private long portId_;
      /**
       * <code>int64 portId = 7;</code>
       *
       * @return The portId.
       */
      public long getPortId() {
        return portId_;
      }
      /**
       * <code>int64 portId = 7;</code>
       *
       * @param value The portId to set.
       * @return This builder for chaining.
       */
      public Builder setPortId(long value) {

        portId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int64 portId = 7;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearPortId() {

        portId_ = 0L;
        onChanged();
        return this;
      }

      @java.lang.Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }

      // @@protoc_insertion_point(builder_scope:BallastInfo)
    }

    // @@protoc_insertion_point(class_scope:BallastInfo)
    private static final com.cpdss.common.generated.Loadicator.BallastInfo DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.Loadicator.BallastInfo();
    }

    public static com.cpdss.common.generated.Loadicator.BallastInfo getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<BallastInfo> PARSER =
        new com.google.protobuf.AbstractParser<BallastInfo>() {
          @java.lang.Override
          public BallastInfo parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new BallastInfo(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<BallastInfo> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<BallastInfo> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.Loadicator.BallastInfo getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_LoadicatorRequest_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_LoadicatorRequest_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_StowagePlan_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_StowagePlan_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_StowageDetails_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_StowageDetails_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_CargoInfo_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_CargoInfo_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_OtherTankInfo_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_OtherTankInfo_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_LoadicatorReply_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_LoadicatorReply_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_BallastInfo_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_BallastInfo_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }

  private static com.google.protobuf.Descriptors.FileDescriptor descriptor;

  static {
    java.lang.String[] descriptorData = {
      "\n\020loadicator.proto\032\014common.proto\032\024loadab"
          + "le_study.proto\"\217\001\n\021LoadicatorRequest\022(\n\022"
          + "stowagePlanDetails\030\001 \003(\0132\014.StowagePlan\022\021"
          + "\n\tisPattern\030\002 \001(\010\022\016\n\006typeId\030\003 \001(\003\022\026\n\016isU"
          + "llageUpdate\030\004 \001(\010\022\025\n\rconditionType\030\005 \001(\005"
          + "\"\251\005\n\013StowagePlan\022\n\n\002id\030\001 \001(\003\022\020\n\010vesselId"
          + "\030\002 \001(\003\022\021\n\timoNumber\030\003 \001(\t\022\021\n\tcompanyId\030\004"
          + " \001(\003\022\020\n\010shipType\030\005 \001(\t\022\022\n\nvesselCode\030\006 \001"
          + "(\t\022\025\n\rbookingListId\030\007 \001(\003\022\021\n\tstowageId\030\010"
          + " \001(\003\022\016\n\006portId\030\t \001(\003\022\020\n\010portCode\030\n \001(\t\022\016"
          + "\n\006status\030\013 \001(\003\022\032\n\022deadweightConstant\030\014 \001"
          + "(\t\022\033\n\023provisionalConstant\030\r \001(\t\022\020\n\010calCo"
          + "unt\030\016 \001(\003\022\022\n\nsaveStatus\030\017 \001(\t\022\023\n\013saveMes"
          + "sage\030\020 \001(\t\022\021\n\tdamageCal\030\021 \001(\010\022\020\n\010dataSav"
          + "e\030\022 \001(\010\022\021\n\tprocessId\030\023 \001(\t\022\024\n\014synoptical"
          + "Id\030\024 \001(\003\022\'\n\016stowageDetails\030\025 \003(\0132\017.Stowa"
          + "geDetails\022\035\n\tcargoInfo\030\026 \003(\0132\n.CargoInfo"
          + "\022%\n\rotherTankInfo\030\027 \003(\0132\016.OtherTankInfo\022"
          + "!\n\013ballastInfo\030\030 \003(\0132\014.BallastInfo\022\027\n\017se"
          + "aWaterDensity\030\031 \001(\t\022\026\n\016portRotationId\030\032 "
          + "\001(\003\022\022\n\nsaveFolder\030\033 \001(\t\022\022\n\nvesselName\030\034 "
          + "\001(\t\022\024\n\014voyageNumber\030\035 \001(\t\022\021\n\tcondition\030\036"
          + " \001(\t\"\343\001\n\016StowageDetails\022\025\n\rstowagePlanId"
          + "\030\001 \001(\003\022\017\n\007cargoId\030\002 \001(\003\022\023\n\013cargoBookId\030\003"
          + " \001(\003\022\021\n\tcargoName\030\004 \001(\t\022\027\n\017specificGravi"
          + "ty\030\005 \001(\t\022\020\n\010quantity\030\006 \001(\t\022\016\n\006tankId\030\007 \001"
          + "(\003\022\021\n\tshortName\030\010 \001(\t\022\020\n\010tankName\030\t \001(\t\022"
          + "\021\n\tstowageId\030\n \001(\003\022\016\n\006portId\030\013 \001(\003\"\335\001\n\tC"
          + "argoInfo\022\025\n\rstowagePlanId\030\001 \001(\003\022\017\n\007cargo"
          + "Id\030\002 \001(\003\022\021\n\tcargoName\030\003 \001(\t\022\023\n\013cargoAbbr"
          + "ev\030\004 \001(\t\022\024\n\014standardTemp\030\005 \001(\t\022\r\n\005grade\030"
          + "\006 \001(\t\022\017\n\007density\030\007 \001(\t\022\013\n\003api\030\010 \001(\t\022\014\n\004d"
          + "egf\030\t \001(\t\022\014\n\004degc\030\n \001(\t\022\021\n\tstowageId\030\013 \001"
          + "(\003\022\016\n\006portId\030\014 \001(\003\"\251\001\n\rOtherTankInfo\022\025\n\r"
          + "stowagePlanId\030\001 \001(\003\022\016\n\006tankId\030\002 \001(\003\022\020\n\010t"
          + "ankName\030\003 \001(\t\022\020\n\010quantity\030\004 \001(\t\022\021\n\tshort"
          + "Name\030\005 \001(\t\022\027\n\017loadableStudyId\030\006 \001(\003\022\021\n\ts"
          + "towageId\030\007 \001(\003\022\016\n\006portId\030\010 \001(\003\":\n\017Loadic"
          + "atorReply\022\'\n\016responseStatus\030\001 \001(\0132\017.Resp"
          + "onseStatus\"\216\001\n\013BallastInfo\022\025\n\rstowagePla"
          + "nId\030\001 \001(\003\022\016\n\006tankId\030\002 \001(\003\022\020\n\010tankName\030\003 "
          + "\001(\t\022\020\n\010quantity\030\004 \001(\t\022\021\n\tshortName\030\005 \001(\t"
          + "\022\021\n\tstowageId\030\006 \001(\003\022\016\n\006portId\030\007 \001(\0032\235\001\n\021"
          + "LoadicatorService\022<\n\022saveLoadicatorInfo\022"
          + "\022.LoadicatorRequest\032\020.LoadicatorReply\"\000\022"
          + "J\n\020GetZipOfDatFiles\022\032.LoadablePlanReport"
          + "Request\032\030.LoadablePlanReportReply\"\000B\036\n\032c"
          + "om.cpdss.common.generatedP\000b\006proto3"
    };
    descriptor =
        com.google.protobuf.Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(
            descriptorData,
            new com.google.protobuf.Descriptors.FileDescriptor[] {
              com.cpdss.common.generated.Common.getDescriptor(),
              com.cpdss.common.generated.LoadableStudy.getDescriptor(),
            });
    internal_static_LoadicatorRequest_descriptor = getDescriptor().getMessageTypes().get(0);
    internal_static_LoadicatorRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_LoadicatorRequest_descriptor,
            new java.lang.String[] {
              "StowagePlanDetails", "IsPattern", "TypeId", "IsUllageUpdate", "ConditionType",
            });
    internal_static_StowagePlan_descriptor = getDescriptor().getMessageTypes().get(1);
    internal_static_StowagePlan_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_StowagePlan_descriptor,
            new java.lang.String[] {
              "Id",
              "VesselId",
              "ImoNumber",
              "CompanyId",
              "ShipType",
              "VesselCode",
              "BookingListId",
              "StowageId",
              "PortId",
              "PortCode",
              "Status",
              "DeadweightConstant",
              "ProvisionalConstant",
              "CalCount",
              "SaveStatus",
              "SaveMessage",
              "DamageCal",
              "DataSave",
              "ProcessId",
              "SynopticalId",
              "StowageDetails",
              "CargoInfo",
              "OtherTankInfo",
              "BallastInfo",
              "SeaWaterDensity",
              "PortRotationId",
              "SaveFolder",
              "VesselName",
              "VoyageNumber",
              "Condition",
            });
    internal_static_StowageDetails_descriptor = getDescriptor().getMessageTypes().get(2);
    internal_static_StowageDetails_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_StowageDetails_descriptor,
            new java.lang.String[] {
              "StowagePlanId",
              "CargoId",
              "CargoBookId",
              "CargoName",
              "SpecificGravity",
              "Quantity",
              "TankId",
              "ShortName",
              "TankName",
              "StowageId",
              "PortId",
            });
    internal_static_CargoInfo_descriptor = getDescriptor().getMessageTypes().get(3);
    internal_static_CargoInfo_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_CargoInfo_descriptor,
            new java.lang.String[] {
              "StowagePlanId",
              "CargoId",
              "CargoName",
              "CargoAbbrev",
              "StandardTemp",
              "Grade",
              "Density",
              "Api",
              "Degf",
              "Degc",
              "StowageId",
              "PortId",
            });
    internal_static_OtherTankInfo_descriptor = getDescriptor().getMessageTypes().get(4);
    internal_static_OtherTankInfo_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_OtherTankInfo_descriptor,
            new java.lang.String[] {
              "StowagePlanId",
              "TankId",
              "TankName",
              "Quantity",
              "ShortName",
              "LoadableStudyId",
              "StowageId",
              "PortId",
            });
    internal_static_LoadicatorReply_descriptor = getDescriptor().getMessageTypes().get(5);
    internal_static_LoadicatorReply_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_LoadicatorReply_descriptor,
            new java.lang.String[] {
              "ResponseStatus",
            });
    internal_static_BallastInfo_descriptor = getDescriptor().getMessageTypes().get(6);
    internal_static_BallastInfo_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_BallastInfo_descriptor,
            new java.lang.String[] {
              "StowagePlanId", "TankId", "TankName", "Quantity", "ShortName", "StowageId", "PortId",
            });
    com.cpdss.common.generated.Common.getDescriptor();
    com.cpdss.common.generated.LoadableStudy.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
