/* Licensed at AlphaOri Technologies */
package com.cpdss.common.generated;

public final class PortInfo {
  private PortInfo() {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistryLite registry) {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions((com.google.protobuf.ExtensionRegistryLite) registry);
  }

  public interface CargoInfosOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:CargoInfos)
      com.google.protobuf.MessageOrBuilder {

    /** <code>repeated .CargoPortMapping cargoPorts = 1;</code> */
    java.util.List<com.cpdss.common.generated.PortInfo.CargoPortMapping> getCargoPortsList();
    /** <code>repeated .CargoPortMapping cargoPorts = 1;</code> */
    com.cpdss.common.generated.PortInfo.CargoPortMapping getCargoPorts(int index);
    /** <code>repeated .CargoPortMapping cargoPorts = 1;</code> */
    int getCargoPortsCount();
    /** <code>repeated .CargoPortMapping cargoPorts = 1;</code> */
    java.util.List<? extends com.cpdss.common.generated.PortInfo.CargoPortMappingOrBuilder>
        getCargoPortsOrBuilderList();
    /** <code>repeated .CargoPortMapping cargoPorts = 1;</code> */
    com.cpdss.common.generated.PortInfo.CargoPortMappingOrBuilder getCargoPortsOrBuilder(int index);

    /**
     * <code>.ResponseStatus responseStatus = 2;</code>
     *
     * @return Whether the responseStatus field is set.
     */
    boolean hasResponseStatus();
    /**
     * <code>.ResponseStatus responseStatus = 2;</code>
     *
     * @return The responseStatus.
     */
    com.cpdss.common.generated.Common.ResponseStatus getResponseStatus();
    /** <code>.ResponseStatus responseStatus = 2;</code> */
    com.cpdss.common.generated.Common.ResponseStatusOrBuilder getResponseStatusOrBuilder();
  }
  /** Protobuf type {@code CargoInfos} */
  public static final class CargoInfos extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:CargoInfos)
      CargoInfosOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use CargoInfos.newBuilder() to construct.
    private CargoInfos(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private CargoInfos() {
      cargoPorts_ = java.util.Collections.emptyList();
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new CargoInfos();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private CargoInfos(
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
                  cargoPorts_ =
                      new java.util.ArrayList<
                          com.cpdss.common.generated.PortInfo.CargoPortMapping>();
                  mutable_bitField0_ |= 0x00000001;
                }
                cargoPorts_.add(
                    input.readMessage(
                        com.cpdss.common.generated.PortInfo.CargoPortMapping.parser(),
                        extensionRegistry));
                break;
              }
            case 18:
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
        if (((mutable_bitField0_ & 0x00000001) != 0)) {
          cargoPorts_ = java.util.Collections.unmodifiableList(cargoPorts_);
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }

    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.cpdss.common.generated.PortInfo.internal_static_CargoInfos_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.PortInfo.internal_static_CargoInfos_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.PortInfo.CargoInfos.class,
              com.cpdss.common.generated.PortInfo.CargoInfos.Builder.class);
    }

    public static final int CARGOPORTS_FIELD_NUMBER = 1;
    private java.util.List<com.cpdss.common.generated.PortInfo.CargoPortMapping> cargoPorts_;
    /** <code>repeated .CargoPortMapping cargoPorts = 1;</code> */
    public java.util.List<com.cpdss.common.generated.PortInfo.CargoPortMapping>
        getCargoPortsList() {
      return cargoPorts_;
    }
    /** <code>repeated .CargoPortMapping cargoPorts = 1;</code> */
    public java.util.List<? extends com.cpdss.common.generated.PortInfo.CargoPortMappingOrBuilder>
        getCargoPortsOrBuilderList() {
      return cargoPorts_;
    }
    /** <code>repeated .CargoPortMapping cargoPorts = 1;</code> */
    public int getCargoPortsCount() {
      return cargoPorts_.size();
    }
    /** <code>repeated .CargoPortMapping cargoPorts = 1;</code> */
    public com.cpdss.common.generated.PortInfo.CargoPortMapping getCargoPorts(int index) {
      return cargoPorts_.get(index);
    }
    /** <code>repeated .CargoPortMapping cargoPorts = 1;</code> */
    public com.cpdss.common.generated.PortInfo.CargoPortMappingOrBuilder getCargoPortsOrBuilder(
        int index) {
      return cargoPorts_.get(index);
    }

    public static final int RESPONSESTATUS_FIELD_NUMBER = 2;
    private com.cpdss.common.generated.Common.ResponseStatus responseStatus_;
    /**
     * <code>.ResponseStatus responseStatus = 2;</code>
     *
     * @return Whether the responseStatus field is set.
     */
    public boolean hasResponseStatus() {
      return responseStatus_ != null;
    }
    /**
     * <code>.ResponseStatus responseStatus = 2;</code>
     *
     * @return The responseStatus.
     */
    public com.cpdss.common.generated.Common.ResponseStatus getResponseStatus() {
      return responseStatus_ == null
          ? com.cpdss.common.generated.Common.ResponseStatus.getDefaultInstance()
          : responseStatus_;
    }
    /** <code>.ResponseStatus responseStatus = 2;</code> */
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
      for (int i = 0; i < cargoPorts_.size(); i++) {
        output.writeMessage(1, cargoPorts_.get(i));
      }
      if (responseStatus_ != null) {
        output.writeMessage(2, getResponseStatus());
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      for (int i = 0; i < cargoPorts_.size(); i++) {
        size += com.google.protobuf.CodedOutputStream.computeMessageSize(1, cargoPorts_.get(i));
      }
      if (responseStatus_ != null) {
        size += com.google.protobuf.CodedOutputStream.computeMessageSize(2, getResponseStatus());
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
      if (!(obj instanceof com.cpdss.common.generated.PortInfo.CargoInfos)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.PortInfo.CargoInfos other =
          (com.cpdss.common.generated.PortInfo.CargoInfos) obj;

      if (!getCargoPortsList().equals(other.getCargoPortsList())) return false;
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
      if (getCargoPortsCount() > 0) {
        hash = (37 * hash) + CARGOPORTS_FIELD_NUMBER;
        hash = (53 * hash) + getCargoPortsList().hashCode();
      }
      if (hasResponseStatus()) {
        hash = (37 * hash) + RESPONSESTATUS_FIELD_NUMBER;
        hash = (53 * hash) + getResponseStatus().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.PortInfo.CargoInfos parseFrom(java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.PortInfo.CargoInfos parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.CargoInfos parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.PortInfo.CargoInfos parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.CargoInfos parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.PortInfo.CargoInfos parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.CargoInfos parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.PortInfo.CargoInfos parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.CargoInfos parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.PortInfo.CargoInfos parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.CargoInfos parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.PortInfo.CargoInfos parseFrom(
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

    public static Builder newBuilder(com.cpdss.common.generated.PortInfo.CargoInfos prototype) {
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
    /** Protobuf type {@code CargoInfos} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:CargoInfos)
        com.cpdss.common.generated.PortInfo.CargoInfosOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.PortInfo.internal_static_CargoInfos_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.PortInfo.internal_static_CargoInfos_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.PortInfo.CargoInfos.class,
                com.cpdss.common.generated.PortInfo.CargoInfos.Builder.class);
      }

      // Construct using com.cpdss.common.generated.PortInfo.CargoInfos.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {
          getCargoPortsFieldBuilder();
        }
      }

      @java.lang.Override
      public Builder clear() {
        super.clear();
        if (cargoPortsBuilder_ == null) {
          cargoPorts_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          cargoPortsBuilder_.clear();
        }
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
        return com.cpdss.common.generated.PortInfo.internal_static_CargoInfos_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.PortInfo.CargoInfos getDefaultInstanceForType() {
        return com.cpdss.common.generated.PortInfo.CargoInfos.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.PortInfo.CargoInfos build() {
        com.cpdss.common.generated.PortInfo.CargoInfos result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.PortInfo.CargoInfos buildPartial() {
        com.cpdss.common.generated.PortInfo.CargoInfos result =
            new com.cpdss.common.generated.PortInfo.CargoInfos(this);
        int from_bitField0_ = bitField0_;
        if (cargoPortsBuilder_ == null) {
          if (((bitField0_ & 0x00000001) != 0)) {
            cargoPorts_ = java.util.Collections.unmodifiableList(cargoPorts_);
            bitField0_ = (bitField0_ & ~0x00000001);
          }
          result.cargoPorts_ = cargoPorts_;
        } else {
          result.cargoPorts_ = cargoPortsBuilder_.build();
        }
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
        if (other instanceof com.cpdss.common.generated.PortInfo.CargoInfos) {
          return mergeFrom((com.cpdss.common.generated.PortInfo.CargoInfos) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.cpdss.common.generated.PortInfo.CargoInfos other) {
        if (other == com.cpdss.common.generated.PortInfo.CargoInfos.getDefaultInstance())
          return this;
        if (cargoPortsBuilder_ == null) {
          if (!other.cargoPorts_.isEmpty()) {
            if (cargoPorts_.isEmpty()) {
              cargoPorts_ = other.cargoPorts_;
              bitField0_ = (bitField0_ & ~0x00000001);
            } else {
              ensureCargoPortsIsMutable();
              cargoPorts_.addAll(other.cargoPorts_);
            }
            onChanged();
          }
        } else {
          if (!other.cargoPorts_.isEmpty()) {
            if (cargoPortsBuilder_.isEmpty()) {
              cargoPortsBuilder_.dispose();
              cargoPortsBuilder_ = null;
              cargoPorts_ = other.cargoPorts_;
              bitField0_ = (bitField0_ & ~0x00000001);
              cargoPortsBuilder_ =
                  com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
                      ? getCargoPortsFieldBuilder()
                      : null;
            } else {
              cargoPortsBuilder_.addAllMessages(other.cargoPorts_);
            }
          }
        }
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
        com.cpdss.common.generated.PortInfo.CargoInfos parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.cpdss.common.generated.PortInfo.CargoInfos) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private int bitField0_;

      private java.util.List<com.cpdss.common.generated.PortInfo.CargoPortMapping> cargoPorts_ =
          java.util.Collections.emptyList();

      private void ensureCargoPortsIsMutable() {
        if (!((bitField0_ & 0x00000001) != 0)) {
          cargoPorts_ =
              new java.util.ArrayList<com.cpdss.common.generated.PortInfo.CargoPortMapping>(
                  cargoPorts_);
          bitField0_ |= 0x00000001;
        }
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
              com.cpdss.common.generated.PortInfo.CargoPortMapping,
              com.cpdss.common.generated.PortInfo.CargoPortMapping.Builder,
              com.cpdss.common.generated.PortInfo.CargoPortMappingOrBuilder>
          cargoPortsBuilder_;

      /** <code>repeated .CargoPortMapping cargoPorts = 1;</code> */
      public java.util.List<com.cpdss.common.generated.PortInfo.CargoPortMapping>
          getCargoPortsList() {
        if (cargoPortsBuilder_ == null) {
          return java.util.Collections.unmodifiableList(cargoPorts_);
        } else {
          return cargoPortsBuilder_.getMessageList();
        }
      }
      /** <code>repeated .CargoPortMapping cargoPorts = 1;</code> */
      public int getCargoPortsCount() {
        if (cargoPortsBuilder_ == null) {
          return cargoPorts_.size();
        } else {
          return cargoPortsBuilder_.getCount();
        }
      }
      /** <code>repeated .CargoPortMapping cargoPorts = 1;</code> */
      public com.cpdss.common.generated.PortInfo.CargoPortMapping getCargoPorts(int index) {
        if (cargoPortsBuilder_ == null) {
          return cargoPorts_.get(index);
        } else {
          return cargoPortsBuilder_.getMessage(index);
        }
      }
      /** <code>repeated .CargoPortMapping cargoPorts = 1;</code> */
      public Builder setCargoPorts(
          int index, com.cpdss.common.generated.PortInfo.CargoPortMapping value) {
        if (cargoPortsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureCargoPortsIsMutable();
          cargoPorts_.set(index, value);
          onChanged();
        } else {
          cargoPortsBuilder_.setMessage(index, value);
        }
        return this;
      }
      /** <code>repeated .CargoPortMapping cargoPorts = 1;</code> */
      public Builder setCargoPorts(
          int index, com.cpdss.common.generated.PortInfo.CargoPortMapping.Builder builderForValue) {
        if (cargoPortsBuilder_ == null) {
          ensureCargoPortsIsMutable();
          cargoPorts_.set(index, builderForValue.build());
          onChanged();
        } else {
          cargoPortsBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .CargoPortMapping cargoPorts = 1;</code> */
      public Builder addCargoPorts(com.cpdss.common.generated.PortInfo.CargoPortMapping value) {
        if (cargoPortsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureCargoPortsIsMutable();
          cargoPorts_.add(value);
          onChanged();
        } else {
          cargoPortsBuilder_.addMessage(value);
        }
        return this;
      }
      /** <code>repeated .CargoPortMapping cargoPorts = 1;</code> */
      public Builder addCargoPorts(
          int index, com.cpdss.common.generated.PortInfo.CargoPortMapping value) {
        if (cargoPortsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureCargoPortsIsMutable();
          cargoPorts_.add(index, value);
          onChanged();
        } else {
          cargoPortsBuilder_.addMessage(index, value);
        }
        return this;
      }
      /** <code>repeated .CargoPortMapping cargoPorts = 1;</code> */
      public Builder addCargoPorts(
          com.cpdss.common.generated.PortInfo.CargoPortMapping.Builder builderForValue) {
        if (cargoPortsBuilder_ == null) {
          ensureCargoPortsIsMutable();
          cargoPorts_.add(builderForValue.build());
          onChanged();
        } else {
          cargoPortsBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .CargoPortMapping cargoPorts = 1;</code> */
      public Builder addCargoPorts(
          int index, com.cpdss.common.generated.PortInfo.CargoPortMapping.Builder builderForValue) {
        if (cargoPortsBuilder_ == null) {
          ensureCargoPortsIsMutable();
          cargoPorts_.add(index, builderForValue.build());
          onChanged();
        } else {
          cargoPortsBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .CargoPortMapping cargoPorts = 1;</code> */
      public Builder addAllCargoPorts(
          java.lang.Iterable<? extends com.cpdss.common.generated.PortInfo.CargoPortMapping>
              values) {
        if (cargoPortsBuilder_ == null) {
          ensureCargoPortsIsMutable();
          com.google.protobuf.AbstractMessageLite.Builder.addAll(values, cargoPorts_);
          onChanged();
        } else {
          cargoPortsBuilder_.addAllMessages(values);
        }
        return this;
      }
      /** <code>repeated .CargoPortMapping cargoPorts = 1;</code> */
      public Builder clearCargoPorts() {
        if (cargoPortsBuilder_ == null) {
          cargoPorts_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
          onChanged();
        } else {
          cargoPortsBuilder_.clear();
        }
        return this;
      }
      /** <code>repeated .CargoPortMapping cargoPorts = 1;</code> */
      public Builder removeCargoPorts(int index) {
        if (cargoPortsBuilder_ == null) {
          ensureCargoPortsIsMutable();
          cargoPorts_.remove(index);
          onChanged();
        } else {
          cargoPortsBuilder_.remove(index);
        }
        return this;
      }
      /** <code>repeated .CargoPortMapping cargoPorts = 1;</code> */
      public com.cpdss.common.generated.PortInfo.CargoPortMapping.Builder getCargoPortsBuilder(
          int index) {
        return getCargoPortsFieldBuilder().getBuilder(index);
      }
      /** <code>repeated .CargoPortMapping cargoPorts = 1;</code> */
      public com.cpdss.common.generated.PortInfo.CargoPortMappingOrBuilder getCargoPortsOrBuilder(
          int index) {
        if (cargoPortsBuilder_ == null) {
          return cargoPorts_.get(index);
        } else {
          return cargoPortsBuilder_.getMessageOrBuilder(index);
        }
      }
      /** <code>repeated .CargoPortMapping cargoPorts = 1;</code> */
      public java.util.List<? extends com.cpdss.common.generated.PortInfo.CargoPortMappingOrBuilder>
          getCargoPortsOrBuilderList() {
        if (cargoPortsBuilder_ != null) {
          return cargoPortsBuilder_.getMessageOrBuilderList();
        } else {
          return java.util.Collections.unmodifiableList(cargoPorts_);
        }
      }
      /** <code>repeated .CargoPortMapping cargoPorts = 1;</code> */
      public com.cpdss.common.generated.PortInfo.CargoPortMapping.Builder addCargoPortsBuilder() {
        return getCargoPortsFieldBuilder()
            .addBuilder(com.cpdss.common.generated.PortInfo.CargoPortMapping.getDefaultInstance());
      }
      /** <code>repeated .CargoPortMapping cargoPorts = 1;</code> */
      public com.cpdss.common.generated.PortInfo.CargoPortMapping.Builder addCargoPortsBuilder(
          int index) {
        return getCargoPortsFieldBuilder()
            .addBuilder(
                index, com.cpdss.common.generated.PortInfo.CargoPortMapping.getDefaultInstance());
      }
      /** <code>repeated .CargoPortMapping cargoPorts = 1;</code> */
      public java.util.List<com.cpdss.common.generated.PortInfo.CargoPortMapping.Builder>
          getCargoPortsBuilderList() {
        return getCargoPortsFieldBuilder().getBuilderList();
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
              com.cpdss.common.generated.PortInfo.CargoPortMapping,
              com.cpdss.common.generated.PortInfo.CargoPortMapping.Builder,
              com.cpdss.common.generated.PortInfo.CargoPortMappingOrBuilder>
          getCargoPortsFieldBuilder() {
        if (cargoPortsBuilder_ == null) {
          cargoPortsBuilder_ =
              new com.google.protobuf.RepeatedFieldBuilderV3<
                  com.cpdss.common.generated.PortInfo.CargoPortMapping,
                  com.cpdss.common.generated.PortInfo.CargoPortMapping.Builder,
                  com.cpdss.common.generated.PortInfo.CargoPortMappingOrBuilder>(
                  cargoPorts_, ((bitField0_ & 0x00000001) != 0), getParentForChildren(), isClean());
          cargoPorts_ = null;
        }
        return cargoPortsBuilder_;
      }

      private com.cpdss.common.generated.Common.ResponseStatus responseStatus_;
      private com.google.protobuf.SingleFieldBuilderV3<
              com.cpdss.common.generated.Common.ResponseStatus,
              com.cpdss.common.generated.Common.ResponseStatus.Builder,
              com.cpdss.common.generated.Common.ResponseStatusOrBuilder>
          responseStatusBuilder_;
      /**
       * <code>.ResponseStatus responseStatus = 2;</code>
       *
       * @return Whether the responseStatus field is set.
       */
      public boolean hasResponseStatus() {
        return responseStatusBuilder_ != null || responseStatus_ != null;
      }
      /**
       * <code>.ResponseStatus responseStatus = 2;</code>
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
      /** <code>.ResponseStatus responseStatus = 2;</code> */
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
      /** <code>.ResponseStatus responseStatus = 2;</code> */
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
      /** <code>.ResponseStatus responseStatus = 2;</code> */
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
      /** <code>.ResponseStatus responseStatus = 2;</code> */
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
      /** <code>.ResponseStatus responseStatus = 2;</code> */
      public com.cpdss.common.generated.Common.ResponseStatus.Builder getResponseStatusBuilder() {

        onChanged();
        return getResponseStatusFieldBuilder().getBuilder();
      }
      /** <code>.ResponseStatus responseStatus = 2;</code> */
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
      /** <code>.ResponseStatus responseStatus = 2;</code> */
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

      // @@protoc_insertion_point(builder_scope:CargoInfos)
    }

    // @@protoc_insertion_point(class_scope:CargoInfos)
    private static final com.cpdss.common.generated.PortInfo.CargoInfos DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.PortInfo.CargoInfos();
    }

    public static com.cpdss.common.generated.PortInfo.CargoInfos getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<CargoInfos> PARSER =
        new com.google.protobuf.AbstractParser<CargoInfos>() {
          @java.lang.Override
          public CargoInfos parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new CargoInfos(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<CargoInfos> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<CargoInfos> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.PortInfo.CargoInfos getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface CargoPortMappingOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:CargoPortMapping)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int64 cargoId = 1;</code>
     *
     * @return The cargoId.
     */
    long getCargoId();

    /**
     * <code>int64 portId = 2;</code>
     *
     * @return The portId.
     */
    long getPortId();
  }
  /** Protobuf type {@code CargoPortMapping} */
  public static final class CargoPortMapping extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:CargoPortMapping)
      CargoPortMappingOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use CargoPortMapping.newBuilder() to construct.
    private CargoPortMapping(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private CargoPortMapping() {}

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new CargoPortMapping();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private CargoPortMapping(
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
                cargoId_ = input.readInt64();
                break;
              }
            case 16:
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
      return com.cpdss.common.generated.PortInfo.internal_static_CargoPortMapping_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.PortInfo.internal_static_CargoPortMapping_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.PortInfo.CargoPortMapping.class,
              com.cpdss.common.generated.PortInfo.CargoPortMapping.Builder.class);
    }

    public static final int CARGOID_FIELD_NUMBER = 1;
    private long cargoId_;
    /**
     * <code>int64 cargoId = 1;</code>
     *
     * @return The cargoId.
     */
    public long getCargoId() {
      return cargoId_;
    }

    public static final int PORTID_FIELD_NUMBER = 2;
    private long portId_;
    /**
     * <code>int64 portId = 2;</code>
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
      if (cargoId_ != 0L) {
        output.writeInt64(1, cargoId_);
      }
      if (portId_ != 0L) {
        output.writeInt64(2, portId_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (cargoId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(1, cargoId_);
      }
      if (portId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(2, portId_);
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
      if (!(obj instanceof com.cpdss.common.generated.PortInfo.CargoPortMapping)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.PortInfo.CargoPortMapping other =
          (com.cpdss.common.generated.PortInfo.CargoPortMapping) obj;

      if (getCargoId() != other.getCargoId()) return false;
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
      hash = (37 * hash) + CARGOID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getCargoId());
      hash = (37 * hash) + PORTID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getPortId());
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.PortInfo.CargoPortMapping parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.PortInfo.CargoPortMapping parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.CargoPortMapping parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.PortInfo.CargoPortMapping parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.CargoPortMapping parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.PortInfo.CargoPortMapping parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.CargoPortMapping parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.PortInfo.CargoPortMapping parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.CargoPortMapping parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.PortInfo.CargoPortMapping parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.CargoPortMapping parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.PortInfo.CargoPortMapping parseFrom(
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
        com.cpdss.common.generated.PortInfo.CargoPortMapping prototype) {
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
    /** Protobuf type {@code CargoPortMapping} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:CargoPortMapping)
        com.cpdss.common.generated.PortInfo.CargoPortMappingOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.PortInfo.internal_static_CargoPortMapping_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.PortInfo
            .internal_static_CargoPortMapping_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.PortInfo.CargoPortMapping.class,
                com.cpdss.common.generated.PortInfo.CargoPortMapping.Builder.class);
      }

      // Construct using com.cpdss.common.generated.PortInfo.CargoPortMapping.newBuilder()
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
        cargoId_ = 0L;

        portId_ = 0L;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.PortInfo.internal_static_CargoPortMapping_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.PortInfo.CargoPortMapping getDefaultInstanceForType() {
        return com.cpdss.common.generated.PortInfo.CargoPortMapping.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.PortInfo.CargoPortMapping build() {
        com.cpdss.common.generated.PortInfo.CargoPortMapping result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.PortInfo.CargoPortMapping buildPartial() {
        com.cpdss.common.generated.PortInfo.CargoPortMapping result =
            new com.cpdss.common.generated.PortInfo.CargoPortMapping(this);
        result.cargoId_ = cargoId_;
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
        if (other instanceof com.cpdss.common.generated.PortInfo.CargoPortMapping) {
          return mergeFrom((com.cpdss.common.generated.PortInfo.CargoPortMapping) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.cpdss.common.generated.PortInfo.CargoPortMapping other) {
        if (other == com.cpdss.common.generated.PortInfo.CargoPortMapping.getDefaultInstance())
          return this;
        if (other.getCargoId() != 0L) {
          setCargoId(other.getCargoId());
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
        com.cpdss.common.generated.PortInfo.CargoPortMapping parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.PortInfo.CargoPortMapping) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private long cargoId_;
      /**
       * <code>int64 cargoId = 1;</code>
       *
       * @return The cargoId.
       */
      public long getCargoId() {
        return cargoId_;
      }
      /**
       * <code>int64 cargoId = 1;</code>
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
       * <code>int64 cargoId = 1;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearCargoId() {

        cargoId_ = 0L;
        onChanged();
        return this;
      }

      private long portId_;
      /**
       * <code>int64 portId = 2;</code>
       *
       * @return The portId.
       */
      public long getPortId() {
        return portId_;
      }
      /**
       * <code>int64 portId = 2;</code>
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
       * <code>int64 portId = 2;</code>
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

      // @@protoc_insertion_point(builder_scope:CargoPortMapping)
    }

    // @@protoc_insertion_point(class_scope:CargoPortMapping)
    private static final com.cpdss.common.generated.PortInfo.CargoPortMapping DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.PortInfo.CargoPortMapping();
    }

    public static com.cpdss.common.generated.PortInfo.CargoPortMapping getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<CargoPortMapping> PARSER =
        new com.google.protobuf.AbstractParser<CargoPortMapping>() {
          @java.lang.Override
          public CargoPortMapping parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new CargoPortMapping(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<CargoPortMapping> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<CargoPortMapping> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.PortInfo.CargoPortMapping getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface GetPortInfoByPortIdsRequestOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:GetPortInfoByPortIdsRequest)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>repeated int64 id = 1;</code>
     *
     * @return A list containing the id.
     */
    java.util.List<java.lang.Long> getIdList();
    /**
     * <code>repeated int64 id = 1;</code>
     *
     * @return The count of id.
     */
    int getIdCount();
    /**
     * <code>repeated int64 id = 1;</code>
     *
     * @param index The index of the element to return.
     * @return The id at the given index.
     */
    long getId(int index);
  }
  /** Protobuf type {@code GetPortInfoByPortIdsRequest} */
  public static final class GetPortInfoByPortIdsRequest
      extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:GetPortInfoByPortIdsRequest)
      GetPortInfoByPortIdsRequestOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use GetPortInfoByPortIdsRequest.newBuilder() to construct.
    private GetPortInfoByPortIdsRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private GetPortInfoByPortIdsRequest() {
      id_ = emptyLongList();
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new GetPortInfoByPortIdsRequest();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private GetPortInfoByPortIdsRequest(
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
                if (!((mutable_bitField0_ & 0x00000001) != 0)) {
                  id_ = newLongList();
                  mutable_bitField0_ |= 0x00000001;
                }
                id_.addLong(input.readInt64());
                break;
              }
            case 10:
              {
                int length = input.readRawVarint32();
                int limit = input.pushLimit(length);
                if (!((mutable_bitField0_ & 0x00000001) != 0) && input.getBytesUntilLimit() > 0) {
                  id_ = newLongList();
                  mutable_bitField0_ |= 0x00000001;
                }
                while (input.getBytesUntilLimit() > 0) {
                  id_.addLong(input.readInt64());
                }
                input.popLimit(limit);
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
          id_.makeImmutable(); // C
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }

    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.cpdss.common.generated.PortInfo
          .internal_static_GetPortInfoByPortIdsRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.PortInfo
          .internal_static_GetPortInfoByPortIdsRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.PortInfo.GetPortInfoByPortIdsRequest.class,
              com.cpdss.common.generated.PortInfo.GetPortInfoByPortIdsRequest.Builder.class);
    }

    public static final int ID_FIELD_NUMBER = 1;
    private com.google.protobuf.Internal.LongList id_;
    /**
     * <code>repeated int64 id = 1;</code>
     *
     * @return A list containing the id.
     */
    public java.util.List<java.lang.Long> getIdList() {
      return id_;
    }
    /**
     * <code>repeated int64 id = 1;</code>
     *
     * @return The count of id.
     */
    public int getIdCount() {
      return id_.size();
    }
    /**
     * <code>repeated int64 id = 1;</code>
     *
     * @param index The index of the element to return.
     * @return The id at the given index.
     */
    public long getId(int index) {
      return id_.getLong(index);
    }

    private int idMemoizedSerializedSize = -1;

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
      if (getIdList().size() > 0) {
        output.writeUInt32NoTag(10);
        output.writeUInt32NoTag(idMemoizedSerializedSize);
      }
      for (int i = 0; i < id_.size(); i++) {
        output.writeInt64NoTag(id_.getLong(i));
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      {
        int dataSize = 0;
        for (int i = 0; i < id_.size(); i++) {
          dataSize += com.google.protobuf.CodedOutputStream.computeInt64SizeNoTag(id_.getLong(i));
        }
        size += dataSize;
        if (!getIdList().isEmpty()) {
          size += 1;
          size += com.google.protobuf.CodedOutputStream.computeInt32SizeNoTag(dataSize);
        }
        idMemoizedSerializedSize = dataSize;
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
      if (!(obj instanceof com.cpdss.common.generated.PortInfo.GetPortInfoByPortIdsRequest)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.PortInfo.GetPortInfoByPortIdsRequest other =
          (com.cpdss.common.generated.PortInfo.GetPortInfoByPortIdsRequest) obj;

      if (!getIdList().equals(other.getIdList())) return false;
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
      if (getIdCount() > 0) {
        hash = (37 * hash) + ID_FIELD_NUMBER;
        hash = (53 * hash) + getIdList().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.PortInfo.GetPortInfoByPortIdsRequest parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.PortInfo.GetPortInfoByPortIdsRequest parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.GetPortInfoByPortIdsRequest parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.PortInfo.GetPortInfoByPortIdsRequest parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.GetPortInfoByPortIdsRequest parseFrom(
        byte[] data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.PortInfo.GetPortInfoByPortIdsRequest parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.GetPortInfoByPortIdsRequest parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.PortInfo.GetPortInfoByPortIdsRequest parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.GetPortInfoByPortIdsRequest
        parseDelimitedFrom(java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.PortInfo.GetPortInfoByPortIdsRequest
        parseDelimitedFrom(
            java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.GetPortInfoByPortIdsRequest parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.PortInfo.GetPortInfoByPortIdsRequest parseFrom(
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
        com.cpdss.common.generated.PortInfo.GetPortInfoByPortIdsRequest prototype) {
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
    /** Protobuf type {@code GetPortInfoByPortIdsRequest} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:GetPortInfoByPortIdsRequest)
        com.cpdss.common.generated.PortInfo.GetPortInfoByPortIdsRequestOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.PortInfo
            .internal_static_GetPortInfoByPortIdsRequest_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.PortInfo
            .internal_static_GetPortInfoByPortIdsRequest_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.PortInfo.GetPortInfoByPortIdsRequest.class,
                com.cpdss.common.generated.PortInfo.GetPortInfoByPortIdsRequest.Builder.class);
      }

      // Construct using
      // com.cpdss.common.generated.PortInfo.GetPortInfoByPortIdsRequest.newBuilder()
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
        id_ = emptyLongList();
        bitField0_ = (bitField0_ & ~0x00000001);
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.PortInfo
            .internal_static_GetPortInfoByPortIdsRequest_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.PortInfo.GetPortInfoByPortIdsRequest
          getDefaultInstanceForType() {
        return com.cpdss.common.generated.PortInfo.GetPortInfoByPortIdsRequest.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.PortInfo.GetPortInfoByPortIdsRequest build() {
        com.cpdss.common.generated.PortInfo.GetPortInfoByPortIdsRequest result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.PortInfo.GetPortInfoByPortIdsRequest buildPartial() {
        com.cpdss.common.generated.PortInfo.GetPortInfoByPortIdsRequest result =
            new com.cpdss.common.generated.PortInfo.GetPortInfoByPortIdsRequest(this);
        int from_bitField0_ = bitField0_;
        if (((bitField0_ & 0x00000001) != 0)) {
          id_.makeImmutable();
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.id_ = id_;
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
        if (other instanceof com.cpdss.common.generated.PortInfo.GetPortInfoByPortIdsRequest) {
          return mergeFrom((com.cpdss.common.generated.PortInfo.GetPortInfoByPortIdsRequest) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(
          com.cpdss.common.generated.PortInfo.GetPortInfoByPortIdsRequest other) {
        if (other
            == com.cpdss.common.generated.PortInfo.GetPortInfoByPortIdsRequest.getDefaultInstance())
          return this;
        if (!other.id_.isEmpty()) {
          if (id_.isEmpty()) {
            id_ = other.id_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureIdIsMutable();
            id_.addAll(other.id_);
          }
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
        com.cpdss.common.generated.PortInfo.GetPortInfoByPortIdsRequest parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.PortInfo.GetPortInfoByPortIdsRequest)
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

      private com.google.protobuf.Internal.LongList id_ = emptyLongList();

      private void ensureIdIsMutable() {
        if (!((bitField0_ & 0x00000001) != 0)) {
          id_ = mutableCopy(id_);
          bitField0_ |= 0x00000001;
        }
      }
      /**
       * <code>repeated int64 id = 1;</code>
       *
       * @return A list containing the id.
       */
      public java.util.List<java.lang.Long> getIdList() {
        return ((bitField0_ & 0x00000001) != 0) ? java.util.Collections.unmodifiableList(id_) : id_;
      }
      /**
       * <code>repeated int64 id = 1;</code>
       *
       * @return The count of id.
       */
      public int getIdCount() {
        return id_.size();
      }
      /**
       * <code>repeated int64 id = 1;</code>
       *
       * @param index The index of the element to return.
       * @return The id at the given index.
       */
      public long getId(int index) {
        return id_.getLong(index);
      }
      /**
       * <code>repeated int64 id = 1;</code>
       *
       * @param index The index to set the value at.
       * @param value The id to set.
       * @return This builder for chaining.
       */
      public Builder setId(int index, long value) {
        ensureIdIsMutable();
        id_.setLong(index, value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated int64 id = 1;</code>
       *
       * @param value The id to add.
       * @return This builder for chaining.
       */
      public Builder addId(long value) {
        ensureIdIsMutable();
        id_.addLong(value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated int64 id = 1;</code>
       *
       * @param values The id to add.
       * @return This builder for chaining.
       */
      public Builder addAllId(java.lang.Iterable<? extends java.lang.Long> values) {
        ensureIdIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(values, id_);
        onChanged();
        return this;
      }
      /**
       * <code>repeated int64 id = 1;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearId() {
        id_ = emptyLongList();
        bitField0_ = (bitField0_ & ~0x00000001);
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

      // @@protoc_insertion_point(builder_scope:GetPortInfoByPortIdsRequest)
    }

    // @@protoc_insertion_point(class_scope:GetPortInfoByPortIdsRequest)
    private static final com.cpdss.common.generated.PortInfo.GetPortInfoByPortIdsRequest
        DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.PortInfo.GetPortInfoByPortIdsRequest();
    }

    public static com.cpdss.common.generated.PortInfo.GetPortInfoByPortIdsRequest
        getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<GetPortInfoByPortIdsRequest> PARSER =
        new com.google.protobuf.AbstractParser<GetPortInfoByPortIdsRequest>() {
          @java.lang.Override
          public GetPortInfoByPortIdsRequest parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new GetPortInfoByPortIdsRequest(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<GetPortInfoByPortIdsRequest> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<GetPortInfoByPortIdsRequest> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.PortInfo.GetPortInfoByPortIdsRequest
        getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface PortRequestOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:PortRequest)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int64 companyId = 1;</code>
     *
     * @return The companyId.
     */
    long getCompanyId();

    /**
     * <code>int64 vesselId = 2;</code>
     *
     * @return The vesselId.
     */
    long getVesselId();

    /**
     * <code>int64 voyageId = 3;</code>
     *
     * @return The voyageId.
     */
    long getVoyageId();

    /**
     * <code>int64 loadableStudyId = 4;</code>
     *
     * @return The loadableStudyId.
     */
    long getLoadableStudyId();
  }
  /** Protobuf type {@code PortRequest} */
  public static final class PortRequest extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:PortRequest)
      PortRequestOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use PortRequest.newBuilder() to construct.
    private PortRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private PortRequest() {}

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new PortRequest();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private PortRequest(
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
                companyId_ = input.readInt64();
                break;
              }
            case 16:
              {
                vesselId_ = input.readInt64();
                break;
              }
            case 24:
              {
                voyageId_ = input.readInt64();
                break;
              }
            case 32:
              {
                loadableStudyId_ = input.readInt64();
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
      return com.cpdss.common.generated.PortInfo.internal_static_PortRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.PortInfo.internal_static_PortRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.PortInfo.PortRequest.class,
              com.cpdss.common.generated.PortInfo.PortRequest.Builder.class);
    }

    public static final int COMPANYID_FIELD_NUMBER = 1;
    private long companyId_;
    /**
     * <code>int64 companyId = 1;</code>
     *
     * @return The companyId.
     */
    public long getCompanyId() {
      return companyId_;
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

    public static final int VOYAGEID_FIELD_NUMBER = 3;
    private long voyageId_;
    /**
     * <code>int64 voyageId = 3;</code>
     *
     * @return The voyageId.
     */
    public long getVoyageId() {
      return voyageId_;
    }

    public static final int LOADABLESTUDYID_FIELD_NUMBER = 4;
    private long loadableStudyId_;
    /**
     * <code>int64 loadableStudyId = 4;</code>
     *
     * @return The loadableStudyId.
     */
    public long getLoadableStudyId() {
      return loadableStudyId_;
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
      if (companyId_ != 0L) {
        output.writeInt64(1, companyId_);
      }
      if (vesselId_ != 0L) {
        output.writeInt64(2, vesselId_);
      }
      if (voyageId_ != 0L) {
        output.writeInt64(3, voyageId_);
      }
      if (loadableStudyId_ != 0L) {
        output.writeInt64(4, loadableStudyId_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (companyId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(1, companyId_);
      }
      if (vesselId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(2, vesselId_);
      }
      if (voyageId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(3, voyageId_);
      }
      if (loadableStudyId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(4, loadableStudyId_);
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
      if (!(obj instanceof com.cpdss.common.generated.PortInfo.PortRequest)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.PortInfo.PortRequest other =
          (com.cpdss.common.generated.PortInfo.PortRequest) obj;

      if (getCompanyId() != other.getCompanyId()) return false;
      if (getVesselId() != other.getVesselId()) return false;
      if (getVoyageId() != other.getVoyageId()) return false;
      if (getLoadableStudyId() != other.getLoadableStudyId()) return false;
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
      hash = (37 * hash) + COMPANYID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getCompanyId());
      hash = (37 * hash) + VESSELID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getVesselId());
      hash = (37 * hash) + VOYAGEID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getVoyageId());
      hash = (37 * hash) + LOADABLESTUDYID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getLoadableStudyId());
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.PortInfo.PortRequest parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.PortInfo.PortRequest parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.PortRequest parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.PortInfo.PortRequest parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.PortRequest parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.PortInfo.PortRequest parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.PortRequest parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.PortInfo.PortRequest parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.PortRequest parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.PortInfo.PortRequest parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.PortRequest parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.PortInfo.PortRequest parseFrom(
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

    public static Builder newBuilder(com.cpdss.common.generated.PortInfo.PortRequest prototype) {
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
    /** Protobuf type {@code PortRequest} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:PortRequest)
        com.cpdss.common.generated.PortInfo.PortRequestOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.PortInfo.internal_static_PortRequest_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.PortInfo.internal_static_PortRequest_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.PortInfo.PortRequest.class,
                com.cpdss.common.generated.PortInfo.PortRequest.Builder.class);
      }

      // Construct using com.cpdss.common.generated.PortInfo.PortRequest.newBuilder()
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
        companyId_ = 0L;

        vesselId_ = 0L;

        voyageId_ = 0L;

        loadableStudyId_ = 0L;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.PortInfo.internal_static_PortRequest_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.PortInfo.PortRequest getDefaultInstanceForType() {
        return com.cpdss.common.generated.PortInfo.PortRequest.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.PortInfo.PortRequest build() {
        com.cpdss.common.generated.PortInfo.PortRequest result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.PortInfo.PortRequest buildPartial() {
        com.cpdss.common.generated.PortInfo.PortRequest result =
            new com.cpdss.common.generated.PortInfo.PortRequest(this);
        result.companyId_ = companyId_;
        result.vesselId_ = vesselId_;
        result.voyageId_ = voyageId_;
        result.loadableStudyId_ = loadableStudyId_;
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
        if (other instanceof com.cpdss.common.generated.PortInfo.PortRequest) {
          return mergeFrom((com.cpdss.common.generated.PortInfo.PortRequest) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.cpdss.common.generated.PortInfo.PortRequest other) {
        if (other == com.cpdss.common.generated.PortInfo.PortRequest.getDefaultInstance())
          return this;
        if (other.getCompanyId() != 0L) {
          setCompanyId(other.getCompanyId());
        }
        if (other.getVesselId() != 0L) {
          setVesselId(other.getVesselId());
        }
        if (other.getVoyageId() != 0L) {
          setVoyageId(other.getVoyageId());
        }
        if (other.getLoadableStudyId() != 0L) {
          setLoadableStudyId(other.getLoadableStudyId());
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
        com.cpdss.common.generated.PortInfo.PortRequest parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.PortInfo.PortRequest) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private long companyId_;
      /**
       * <code>int64 companyId = 1;</code>
       *
       * @return The companyId.
       */
      public long getCompanyId() {
        return companyId_;
      }
      /**
       * <code>int64 companyId = 1;</code>
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
       * <code>int64 companyId = 1;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearCompanyId() {

        companyId_ = 0L;
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

      private long voyageId_;
      /**
       * <code>int64 voyageId = 3;</code>
       *
       * @return The voyageId.
       */
      public long getVoyageId() {
        return voyageId_;
      }
      /**
       * <code>int64 voyageId = 3;</code>
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
       * <code>int64 voyageId = 3;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearVoyageId() {

        voyageId_ = 0L;
        onChanged();
        return this;
      }

      private long loadableStudyId_;
      /**
       * <code>int64 loadableStudyId = 4;</code>
       *
       * @return The loadableStudyId.
       */
      public long getLoadableStudyId() {
        return loadableStudyId_;
      }
      /**
       * <code>int64 loadableStudyId = 4;</code>
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
       * <code>int64 loadableStudyId = 4;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearLoadableStudyId() {

        loadableStudyId_ = 0L;
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

      // @@protoc_insertion_point(builder_scope:PortRequest)
    }

    // @@protoc_insertion_point(class_scope:PortRequest)
    private static final com.cpdss.common.generated.PortInfo.PortRequest DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.PortInfo.PortRequest();
    }

    public static com.cpdss.common.generated.PortInfo.PortRequest getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<PortRequest> PARSER =
        new com.google.protobuf.AbstractParser<PortRequest>() {
          @java.lang.Override
          public PortRequest parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new PortRequest(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<PortRequest> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<PortRequest> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.PortInfo.PortRequest getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface PortRequestWithPagingOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:PortRequestWithPaging)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int64 offset = 1;</code>
     *
     * @return The offset.
     */
    long getOffset();

    /**
     * <code>int64 limit = 2;</code>
     *
     * @return The limit.
     */
    long getLimit();
  }
  /** Protobuf type {@code PortRequestWithPaging} */
  public static final class PortRequestWithPaging extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:PortRequestWithPaging)
      PortRequestWithPagingOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use PortRequestWithPaging.newBuilder() to construct.
    private PortRequestWithPaging(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private PortRequestWithPaging() {}

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new PortRequestWithPaging();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private PortRequestWithPaging(
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
                offset_ = input.readInt64();
                break;
              }
            case 16:
              {
                limit_ = input.readInt64();
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
      return com.cpdss.common.generated.PortInfo.internal_static_PortRequestWithPaging_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.PortInfo
          .internal_static_PortRequestWithPaging_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.PortInfo.PortRequestWithPaging.class,
              com.cpdss.common.generated.PortInfo.PortRequestWithPaging.Builder.class);
    }

    public static final int OFFSET_FIELD_NUMBER = 1;
    private long offset_;
    /**
     * <code>int64 offset = 1;</code>
     *
     * @return The offset.
     */
    public long getOffset() {
      return offset_;
    }

    public static final int LIMIT_FIELD_NUMBER = 2;
    private long limit_;
    /**
     * <code>int64 limit = 2;</code>
     *
     * @return The limit.
     */
    public long getLimit() {
      return limit_;
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
      if (offset_ != 0L) {
        output.writeInt64(1, offset_);
      }
      if (limit_ != 0L) {
        output.writeInt64(2, limit_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (offset_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(1, offset_);
      }
      if (limit_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(2, limit_);
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
      if (!(obj instanceof com.cpdss.common.generated.PortInfo.PortRequestWithPaging)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.PortInfo.PortRequestWithPaging other =
          (com.cpdss.common.generated.PortInfo.PortRequestWithPaging) obj;

      if (getOffset() != other.getOffset()) return false;
      if (getLimit() != other.getLimit()) return false;
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
      hash = (37 * hash) + OFFSET_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getOffset());
      hash = (37 * hash) + LIMIT_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getLimit());
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.PortInfo.PortRequestWithPaging parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.PortInfo.PortRequestWithPaging parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.PortRequestWithPaging parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.PortInfo.PortRequestWithPaging parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.PortRequestWithPaging parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.PortInfo.PortRequestWithPaging parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.PortRequestWithPaging parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.PortInfo.PortRequestWithPaging parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.PortRequestWithPaging parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.PortInfo.PortRequestWithPaging parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.PortRequestWithPaging parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.PortInfo.PortRequestWithPaging parseFrom(
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
        com.cpdss.common.generated.PortInfo.PortRequestWithPaging prototype) {
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
    /** Protobuf type {@code PortRequestWithPaging} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:PortRequestWithPaging)
        com.cpdss.common.generated.PortInfo.PortRequestWithPagingOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.PortInfo.internal_static_PortRequestWithPaging_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.PortInfo
            .internal_static_PortRequestWithPaging_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.PortInfo.PortRequestWithPaging.class,
                com.cpdss.common.generated.PortInfo.PortRequestWithPaging.Builder.class);
      }

      // Construct using com.cpdss.common.generated.PortInfo.PortRequestWithPaging.newBuilder()
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
        offset_ = 0L;

        limit_ = 0L;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.PortInfo.internal_static_PortRequestWithPaging_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.PortInfo.PortRequestWithPaging getDefaultInstanceForType() {
        return com.cpdss.common.generated.PortInfo.PortRequestWithPaging.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.PortInfo.PortRequestWithPaging build() {
        com.cpdss.common.generated.PortInfo.PortRequestWithPaging result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.PortInfo.PortRequestWithPaging buildPartial() {
        com.cpdss.common.generated.PortInfo.PortRequestWithPaging result =
            new com.cpdss.common.generated.PortInfo.PortRequestWithPaging(this);
        result.offset_ = offset_;
        result.limit_ = limit_;
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
        if (other instanceof com.cpdss.common.generated.PortInfo.PortRequestWithPaging) {
          return mergeFrom((com.cpdss.common.generated.PortInfo.PortRequestWithPaging) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.cpdss.common.generated.PortInfo.PortRequestWithPaging other) {
        if (other == com.cpdss.common.generated.PortInfo.PortRequestWithPaging.getDefaultInstance())
          return this;
        if (other.getOffset() != 0L) {
          setOffset(other.getOffset());
        }
        if (other.getLimit() != 0L) {
          setLimit(other.getLimit());
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
        com.cpdss.common.generated.PortInfo.PortRequestWithPaging parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.PortInfo.PortRequestWithPaging) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private long offset_;
      /**
       * <code>int64 offset = 1;</code>
       *
       * @return The offset.
       */
      public long getOffset() {
        return offset_;
      }
      /**
       * <code>int64 offset = 1;</code>
       *
       * @param value The offset to set.
       * @return This builder for chaining.
       */
      public Builder setOffset(long value) {

        offset_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int64 offset = 1;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearOffset() {

        offset_ = 0L;
        onChanged();
        return this;
      }

      private long limit_;
      /**
       * <code>int64 limit = 2;</code>
       *
       * @return The limit.
       */
      public long getLimit() {
        return limit_;
      }
      /**
       * <code>int64 limit = 2;</code>
       *
       * @param value The limit to set.
       * @return This builder for chaining.
       */
      public Builder setLimit(long value) {

        limit_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int64 limit = 2;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearLimit() {

        limit_ = 0L;
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

      // @@protoc_insertion_point(builder_scope:PortRequestWithPaging)
    }

    // @@protoc_insertion_point(class_scope:PortRequestWithPaging)
    private static final com.cpdss.common.generated.PortInfo.PortRequestWithPaging DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.PortInfo.PortRequestWithPaging();
    }

    public static com.cpdss.common.generated.PortInfo.PortRequestWithPaging getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<PortRequestWithPaging> PARSER =
        new com.google.protobuf.AbstractParser<PortRequestWithPaging>() {
          @java.lang.Override
          public PortRequestWithPaging parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new PortRequestWithPaging(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<PortRequestWithPaging> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<PortRequestWithPaging> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.PortInfo.PortRequestWithPaging getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface PortDetailOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:PortDetail)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int64 id = 1;</code>
     *
     * @return The id.
     */
    long getId();

    /**
     * <code>string name = 2;</code>
     *
     * @return The name.
     */
    java.lang.String getName();
    /**
     * <code>string name = 2;</code>
     *
     * @return The bytes for name.
     */
    com.google.protobuf.ByteString getNameBytes();

    /**
     * <code>string code = 3;</code>
     *
     * @return The code.
     */
    java.lang.String getCode();
    /**
     * <code>string code = 3;</code>
     *
     * @return The bytes for code.
     */
    com.google.protobuf.ByteString getCodeBytes();

    /**
     * <code>string waterDensity = 4;</code>
     *
     * @return The waterDensity.
     */
    java.lang.String getWaterDensity();
    /**
     * <code>string waterDensity = 4;</code>
     *
     * @return The bytes for waterDensity.
     */
    com.google.protobuf.ByteString getWaterDensityBytes();

    /**
     * <code>string maxDraft = 5;</code>
     *
     * @return The maxDraft.
     */
    java.lang.String getMaxDraft();
    /**
     * <code>string maxDraft = 5;</code>
     *
     * @return The bytes for maxDraft.
     */
    com.google.protobuf.ByteString getMaxDraftBytes();

    /**
     * <code>string maxAirDraft = 6;</code>
     *
     * @return The maxAirDraft.
     */
    java.lang.String getMaxAirDraft();
    /**
     * <code>string maxAirDraft = 6;</code>
     *
     * @return The bytes for maxAirDraft.
     */
    com.google.protobuf.ByteString getMaxAirDraftBytes();

    /**
     * <code>string averageTideHeight = 7;</code>
     *
     * @return The averageTideHeight.
     */
    java.lang.String getAverageTideHeight();
    /**
     * <code>string averageTideHeight = 7;</code>
     *
     * @return The bytes for averageTideHeight.
     */
    com.google.protobuf.ByteString getAverageTideHeightBytes();

    /**
     * <code>string tideHeight = 8;</code>
     *
     * @return The tideHeight.
     */
    java.lang.String getTideHeight();
    /**
     * <code>string tideHeight = 8;</code>
     *
     * @return The bytes for tideHeight.
     */
    com.google.protobuf.ByteString getTideHeightBytes();

    /**
     * <code>string hwTideFrom = 9;</code>
     *
     * @return The hwTideFrom.
     */
    java.lang.String getHwTideFrom();
    /**
     * <code>string hwTideFrom = 9;</code>
     *
     * @return The bytes for hwTideFrom.
     */
    com.google.protobuf.ByteString getHwTideFromBytes();

    /**
     * <code>string hwTideTo = 10;</code>
     *
     * @return The hwTideTo.
     */
    java.lang.String getHwTideTo();
    /**
     * <code>string hwTideTo = 10;</code>
     *
     * @return The bytes for hwTideTo.
     */
    com.google.protobuf.ByteString getHwTideToBytes();

    /**
     * <code>string lwTideFrom = 11;</code>
     *
     * @return The lwTideFrom.
     */
    java.lang.String getLwTideFrom();
    /**
     * <code>string lwTideFrom = 11;</code>
     *
     * @return The bytes for lwTideFrom.
     */
    com.google.protobuf.ByteString getLwTideFromBytes();

    /**
     * <code>string lwTideTo = 12;</code>
     *
     * @return The lwTideTo.
     */
    java.lang.String getLwTideTo();
    /**
     * <code>string lwTideTo = 12;</code>
     *
     * @return The bytes for lwTideTo.
     */
    com.google.protobuf.ByteString getLwTideToBytes();

    /**
     * <code>string hwTideTimeFrom = 13;</code>
     *
     * @return The hwTideTimeFrom.
     */
    java.lang.String getHwTideTimeFrom();
    /**
     * <code>string hwTideTimeFrom = 13;</code>
     *
     * @return The bytes for hwTideTimeFrom.
     */
    com.google.protobuf.ByteString getHwTideTimeFromBytes();

    /**
     * <code>string hwTideTimeTo = 14;</code>
     *
     * @return The hwTideTimeTo.
     */
    java.lang.String getHwTideTimeTo();
    /**
     * <code>string hwTideTimeTo = 14;</code>
     *
     * @return The bytes for hwTideTimeTo.
     */
    com.google.protobuf.ByteString getHwTideTimeToBytes();

    /**
     * <code>string lwTideTimeFrom = 15;</code>
     *
     * @return The lwTideTimeFrom.
     */
    java.lang.String getLwTideTimeFrom();
    /**
     * <code>string lwTideTimeFrom = 15;</code>
     *
     * @return The bytes for lwTideTimeFrom.
     */
    com.google.protobuf.ByteString getLwTideTimeFromBytes();

    /**
     * <code>string lwTideTimeTo = 16;</code>
     *
     * @return The lwTideTimeTo.
     */
    java.lang.String getLwTideTimeTo();
    /**
     * <code>string lwTideTimeTo = 16;</code>
     *
     * @return The bytes for lwTideTimeTo.
     */
    com.google.protobuf.ByteString getLwTideTimeToBytes();

    /**
     * <code>string sunriseTime = 17;</code>
     *
     * @return The sunriseTime.
     */
    java.lang.String getSunriseTime();
    /**
     * <code>string sunriseTime = 17;</code>
     *
     * @return The bytes for sunriseTime.
     */
    com.google.protobuf.ByteString getSunriseTimeBytes();

    /**
     * <code>string sunsetTime = 18;</code>
     *
     * @return The sunsetTime.
     */
    java.lang.String getSunsetTime();
    /**
     * <code>string sunsetTime = 18;</code>
     *
     * @return The bytes for sunsetTime.
     */
    com.google.protobuf.ByteString getSunsetTimeBytes();

    /**
     * <code>string timezone = 19;</code>
     *
     * @return The timezone.
     */
    java.lang.String getTimezone();
    /**
     * <code>string timezone = 19;</code>
     *
     * @return The bytes for timezone.
     */
    com.google.protobuf.ByteString getTimezoneBytes();

    /**
     * <code>string timezoneOffsetVal = 20;</code>
     *
     * @return The timezoneOffsetVal.
     */
    java.lang.String getTimezoneOffsetVal();
    /**
     * <code>string timezoneOffsetVal = 20;</code>
     *
     * @return The bytes for timezoneOffsetVal.
     */
    com.google.protobuf.ByteString getTimezoneOffsetValBytes();

    /**
     * <code>int64 timezoneId = 21;</code>
     *
     * @return The timezoneId.
     */
    long getTimezoneId();

    /**
     * <code>string timezoneAbbreviation = 22;</code>
     *
     * @return The timezoneAbbreviation.
     */
    java.lang.String getTimezoneAbbreviation();
    /**
     * <code>string timezoneAbbreviation = 22;</code>
     *
     * @return The bytes for timezoneAbbreviation.
     */
    com.google.protobuf.ByteString getTimezoneAbbreviationBytes();

    /**
     * <code>string countryName = 23;</code>
     *
     * @return The countryName.
     */
    java.lang.String getCountryName();
    /**
     * <code>string countryName = 23;</code>
     *
     * @return The bytes for countryName.
     */
    com.google.protobuf.ByteString getCountryNameBytes();
  }
  /** Protobuf type {@code PortDetail} */
  public static final class PortDetail extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:PortDetail)
      PortDetailOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use PortDetail.newBuilder() to construct.
    private PortDetail(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private PortDetail() {
      name_ = "";
      code_ = "";
      waterDensity_ = "";
      maxDraft_ = "";
      maxAirDraft_ = "";
      averageTideHeight_ = "";
      tideHeight_ = "";
      hwTideFrom_ = "";
      hwTideTo_ = "";
      lwTideFrom_ = "";
      lwTideTo_ = "";
      hwTideTimeFrom_ = "";
      hwTideTimeTo_ = "";
      lwTideTimeFrom_ = "";
      lwTideTimeTo_ = "";
      sunriseTime_ = "";
      sunsetTime_ = "";
      timezone_ = "";
      timezoneOffsetVal_ = "";
      timezoneAbbreviation_ = "";
      countryName_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new PortDetail();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private PortDetail(
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

                name_ = s;
                break;
              }
            case 26:
              {
                java.lang.String s = input.readStringRequireUtf8();

                code_ = s;
                break;
              }
            case 34:
              {
                java.lang.String s = input.readStringRequireUtf8();

                waterDensity_ = s;
                break;
              }
            case 42:
              {
                java.lang.String s = input.readStringRequireUtf8();

                maxDraft_ = s;
                break;
              }
            case 50:
              {
                java.lang.String s = input.readStringRequireUtf8();

                maxAirDraft_ = s;
                break;
              }
            case 58:
              {
                java.lang.String s = input.readStringRequireUtf8();

                averageTideHeight_ = s;
                break;
              }
            case 66:
              {
                java.lang.String s = input.readStringRequireUtf8();

                tideHeight_ = s;
                break;
              }
            case 74:
              {
                java.lang.String s = input.readStringRequireUtf8();

                hwTideFrom_ = s;
                break;
              }
            case 82:
              {
                java.lang.String s = input.readStringRequireUtf8();

                hwTideTo_ = s;
                break;
              }
            case 90:
              {
                java.lang.String s = input.readStringRequireUtf8();

                lwTideFrom_ = s;
                break;
              }
            case 98:
              {
                java.lang.String s = input.readStringRequireUtf8();

                lwTideTo_ = s;
                break;
              }
            case 106:
              {
                java.lang.String s = input.readStringRequireUtf8();

                hwTideTimeFrom_ = s;
                break;
              }
            case 114:
              {
                java.lang.String s = input.readStringRequireUtf8();

                hwTideTimeTo_ = s;
                break;
              }
            case 122:
              {
                java.lang.String s = input.readStringRequireUtf8();

                lwTideTimeFrom_ = s;
                break;
              }
            case 130:
              {
                java.lang.String s = input.readStringRequireUtf8();

                lwTideTimeTo_ = s;
                break;
              }
            case 138:
              {
                java.lang.String s = input.readStringRequireUtf8();

                sunriseTime_ = s;
                break;
              }
            case 146:
              {
                java.lang.String s = input.readStringRequireUtf8();

                sunsetTime_ = s;
                break;
              }
            case 154:
              {
                java.lang.String s = input.readStringRequireUtf8();

                timezone_ = s;
                break;
              }
            case 162:
              {
                java.lang.String s = input.readStringRequireUtf8();

                timezoneOffsetVal_ = s;
                break;
              }
            case 168:
              {
                timezoneId_ = input.readInt64();
                break;
              }
            case 178:
              {
                java.lang.String s = input.readStringRequireUtf8();

                timezoneAbbreviation_ = s;
                break;
              }
            case 186:
              {
                java.lang.String s = input.readStringRequireUtf8();

                countryName_ = s;
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
      return com.cpdss.common.generated.PortInfo.internal_static_PortDetail_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.PortInfo.internal_static_PortDetail_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.PortInfo.PortDetail.class,
              com.cpdss.common.generated.PortInfo.PortDetail.Builder.class);
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

    public static final int NAME_FIELD_NUMBER = 2;
    private volatile java.lang.Object name_;
    /**
     * <code>string name = 2;</code>
     *
     * @return The name.
     */
    public java.lang.String getName() {
      java.lang.Object ref = name_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        name_ = s;
        return s;
      }
    }
    /**
     * <code>string name = 2;</code>
     *
     * @return The bytes for name.
     */
    public com.google.protobuf.ByteString getNameBytes() {
      java.lang.Object ref = name_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        name_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int CODE_FIELD_NUMBER = 3;
    private volatile java.lang.Object code_;
    /**
     * <code>string code = 3;</code>
     *
     * @return The code.
     */
    public java.lang.String getCode() {
      java.lang.Object ref = code_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        code_ = s;
        return s;
      }
    }
    /**
     * <code>string code = 3;</code>
     *
     * @return The bytes for code.
     */
    public com.google.protobuf.ByteString getCodeBytes() {
      java.lang.Object ref = code_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        code_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int WATERDENSITY_FIELD_NUMBER = 4;
    private volatile java.lang.Object waterDensity_;
    /**
     * <code>string waterDensity = 4;</code>
     *
     * @return The waterDensity.
     */
    public java.lang.String getWaterDensity() {
      java.lang.Object ref = waterDensity_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        waterDensity_ = s;
        return s;
      }
    }
    /**
     * <code>string waterDensity = 4;</code>
     *
     * @return The bytes for waterDensity.
     */
    public com.google.protobuf.ByteString getWaterDensityBytes() {
      java.lang.Object ref = waterDensity_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        waterDensity_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int MAXDRAFT_FIELD_NUMBER = 5;
    private volatile java.lang.Object maxDraft_;
    /**
     * <code>string maxDraft = 5;</code>
     *
     * @return The maxDraft.
     */
    public java.lang.String getMaxDraft() {
      java.lang.Object ref = maxDraft_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        maxDraft_ = s;
        return s;
      }
    }
    /**
     * <code>string maxDraft = 5;</code>
     *
     * @return The bytes for maxDraft.
     */
    public com.google.protobuf.ByteString getMaxDraftBytes() {
      java.lang.Object ref = maxDraft_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        maxDraft_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int MAXAIRDRAFT_FIELD_NUMBER = 6;
    private volatile java.lang.Object maxAirDraft_;
    /**
     * <code>string maxAirDraft = 6;</code>
     *
     * @return The maxAirDraft.
     */
    public java.lang.String getMaxAirDraft() {
      java.lang.Object ref = maxAirDraft_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        maxAirDraft_ = s;
        return s;
      }
    }
    /**
     * <code>string maxAirDraft = 6;</code>
     *
     * @return The bytes for maxAirDraft.
     */
    public com.google.protobuf.ByteString getMaxAirDraftBytes() {
      java.lang.Object ref = maxAirDraft_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        maxAirDraft_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int AVERAGETIDEHEIGHT_FIELD_NUMBER = 7;
    private volatile java.lang.Object averageTideHeight_;
    /**
     * <code>string averageTideHeight = 7;</code>
     *
     * @return The averageTideHeight.
     */
    public java.lang.String getAverageTideHeight() {
      java.lang.Object ref = averageTideHeight_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        averageTideHeight_ = s;
        return s;
      }
    }
    /**
     * <code>string averageTideHeight = 7;</code>
     *
     * @return The bytes for averageTideHeight.
     */
    public com.google.protobuf.ByteString getAverageTideHeightBytes() {
      java.lang.Object ref = averageTideHeight_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        averageTideHeight_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int TIDEHEIGHT_FIELD_NUMBER = 8;
    private volatile java.lang.Object tideHeight_;
    /**
     * <code>string tideHeight = 8;</code>
     *
     * @return The tideHeight.
     */
    public java.lang.String getTideHeight() {
      java.lang.Object ref = tideHeight_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        tideHeight_ = s;
        return s;
      }
    }
    /**
     * <code>string tideHeight = 8;</code>
     *
     * @return The bytes for tideHeight.
     */
    public com.google.protobuf.ByteString getTideHeightBytes() {
      java.lang.Object ref = tideHeight_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        tideHeight_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int HWTIDEFROM_FIELD_NUMBER = 9;
    private volatile java.lang.Object hwTideFrom_;
    /**
     * <code>string hwTideFrom = 9;</code>
     *
     * @return The hwTideFrom.
     */
    public java.lang.String getHwTideFrom() {
      java.lang.Object ref = hwTideFrom_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        hwTideFrom_ = s;
        return s;
      }
    }
    /**
     * <code>string hwTideFrom = 9;</code>
     *
     * @return The bytes for hwTideFrom.
     */
    public com.google.protobuf.ByteString getHwTideFromBytes() {
      java.lang.Object ref = hwTideFrom_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        hwTideFrom_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int HWTIDETO_FIELD_NUMBER = 10;
    private volatile java.lang.Object hwTideTo_;
    /**
     * <code>string hwTideTo = 10;</code>
     *
     * @return The hwTideTo.
     */
    public java.lang.String getHwTideTo() {
      java.lang.Object ref = hwTideTo_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        hwTideTo_ = s;
        return s;
      }
    }
    /**
     * <code>string hwTideTo = 10;</code>
     *
     * @return The bytes for hwTideTo.
     */
    public com.google.protobuf.ByteString getHwTideToBytes() {
      java.lang.Object ref = hwTideTo_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        hwTideTo_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int LWTIDEFROM_FIELD_NUMBER = 11;
    private volatile java.lang.Object lwTideFrom_;
    /**
     * <code>string lwTideFrom = 11;</code>
     *
     * @return The lwTideFrom.
     */
    public java.lang.String getLwTideFrom() {
      java.lang.Object ref = lwTideFrom_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        lwTideFrom_ = s;
        return s;
      }
    }
    /**
     * <code>string lwTideFrom = 11;</code>
     *
     * @return The bytes for lwTideFrom.
     */
    public com.google.protobuf.ByteString getLwTideFromBytes() {
      java.lang.Object ref = lwTideFrom_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        lwTideFrom_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int LWTIDETO_FIELD_NUMBER = 12;
    private volatile java.lang.Object lwTideTo_;
    /**
     * <code>string lwTideTo = 12;</code>
     *
     * @return The lwTideTo.
     */
    public java.lang.String getLwTideTo() {
      java.lang.Object ref = lwTideTo_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        lwTideTo_ = s;
        return s;
      }
    }
    /**
     * <code>string lwTideTo = 12;</code>
     *
     * @return The bytes for lwTideTo.
     */
    public com.google.protobuf.ByteString getLwTideToBytes() {
      java.lang.Object ref = lwTideTo_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        lwTideTo_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int HWTIDETIMEFROM_FIELD_NUMBER = 13;
    private volatile java.lang.Object hwTideTimeFrom_;
    /**
     * <code>string hwTideTimeFrom = 13;</code>
     *
     * @return The hwTideTimeFrom.
     */
    public java.lang.String getHwTideTimeFrom() {
      java.lang.Object ref = hwTideTimeFrom_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        hwTideTimeFrom_ = s;
        return s;
      }
    }
    /**
     * <code>string hwTideTimeFrom = 13;</code>
     *
     * @return The bytes for hwTideTimeFrom.
     */
    public com.google.protobuf.ByteString getHwTideTimeFromBytes() {
      java.lang.Object ref = hwTideTimeFrom_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        hwTideTimeFrom_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int HWTIDETIMETO_FIELD_NUMBER = 14;
    private volatile java.lang.Object hwTideTimeTo_;
    /**
     * <code>string hwTideTimeTo = 14;</code>
     *
     * @return The hwTideTimeTo.
     */
    public java.lang.String getHwTideTimeTo() {
      java.lang.Object ref = hwTideTimeTo_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        hwTideTimeTo_ = s;
        return s;
      }
    }
    /**
     * <code>string hwTideTimeTo = 14;</code>
     *
     * @return The bytes for hwTideTimeTo.
     */
    public com.google.protobuf.ByteString getHwTideTimeToBytes() {
      java.lang.Object ref = hwTideTimeTo_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        hwTideTimeTo_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int LWTIDETIMEFROM_FIELD_NUMBER = 15;
    private volatile java.lang.Object lwTideTimeFrom_;
    /**
     * <code>string lwTideTimeFrom = 15;</code>
     *
     * @return The lwTideTimeFrom.
     */
    public java.lang.String getLwTideTimeFrom() {
      java.lang.Object ref = lwTideTimeFrom_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        lwTideTimeFrom_ = s;
        return s;
      }
    }
    /**
     * <code>string lwTideTimeFrom = 15;</code>
     *
     * @return The bytes for lwTideTimeFrom.
     */
    public com.google.protobuf.ByteString getLwTideTimeFromBytes() {
      java.lang.Object ref = lwTideTimeFrom_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        lwTideTimeFrom_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int LWTIDETIMETO_FIELD_NUMBER = 16;
    private volatile java.lang.Object lwTideTimeTo_;
    /**
     * <code>string lwTideTimeTo = 16;</code>
     *
     * @return The lwTideTimeTo.
     */
    public java.lang.String getLwTideTimeTo() {
      java.lang.Object ref = lwTideTimeTo_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        lwTideTimeTo_ = s;
        return s;
      }
    }
    /**
     * <code>string lwTideTimeTo = 16;</code>
     *
     * @return The bytes for lwTideTimeTo.
     */
    public com.google.protobuf.ByteString getLwTideTimeToBytes() {
      java.lang.Object ref = lwTideTimeTo_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        lwTideTimeTo_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int SUNRISETIME_FIELD_NUMBER = 17;
    private volatile java.lang.Object sunriseTime_;
    /**
     * <code>string sunriseTime = 17;</code>
     *
     * @return The sunriseTime.
     */
    public java.lang.String getSunriseTime() {
      java.lang.Object ref = sunriseTime_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        sunriseTime_ = s;
        return s;
      }
    }
    /**
     * <code>string sunriseTime = 17;</code>
     *
     * @return The bytes for sunriseTime.
     */
    public com.google.protobuf.ByteString getSunriseTimeBytes() {
      java.lang.Object ref = sunriseTime_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        sunriseTime_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int SUNSETTIME_FIELD_NUMBER = 18;
    private volatile java.lang.Object sunsetTime_;
    /**
     * <code>string sunsetTime = 18;</code>
     *
     * @return The sunsetTime.
     */
    public java.lang.String getSunsetTime() {
      java.lang.Object ref = sunsetTime_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        sunsetTime_ = s;
        return s;
      }
    }
    /**
     * <code>string sunsetTime = 18;</code>
     *
     * @return The bytes for sunsetTime.
     */
    public com.google.protobuf.ByteString getSunsetTimeBytes() {
      java.lang.Object ref = sunsetTime_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        sunsetTime_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int TIMEZONE_FIELD_NUMBER = 19;
    private volatile java.lang.Object timezone_;
    /**
     * <code>string timezone = 19;</code>
     *
     * @return The timezone.
     */
    public java.lang.String getTimezone() {
      java.lang.Object ref = timezone_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        timezone_ = s;
        return s;
      }
    }
    /**
     * <code>string timezone = 19;</code>
     *
     * @return The bytes for timezone.
     */
    public com.google.protobuf.ByteString getTimezoneBytes() {
      java.lang.Object ref = timezone_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        timezone_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int TIMEZONEOFFSETVAL_FIELD_NUMBER = 20;
    private volatile java.lang.Object timezoneOffsetVal_;
    /**
     * <code>string timezoneOffsetVal = 20;</code>
     *
     * @return The timezoneOffsetVal.
     */
    public java.lang.String getTimezoneOffsetVal() {
      java.lang.Object ref = timezoneOffsetVal_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        timezoneOffsetVal_ = s;
        return s;
      }
    }
    /**
     * <code>string timezoneOffsetVal = 20;</code>
     *
     * @return The bytes for timezoneOffsetVal.
     */
    public com.google.protobuf.ByteString getTimezoneOffsetValBytes() {
      java.lang.Object ref = timezoneOffsetVal_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        timezoneOffsetVal_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int TIMEZONEID_FIELD_NUMBER = 21;
    private long timezoneId_;
    /**
     * <code>int64 timezoneId = 21;</code>
     *
     * @return The timezoneId.
     */
    public long getTimezoneId() {
      return timezoneId_;
    }

    public static final int TIMEZONEABBREVIATION_FIELD_NUMBER = 22;
    private volatile java.lang.Object timezoneAbbreviation_;
    /**
     * <code>string timezoneAbbreviation = 22;</code>
     *
     * @return The timezoneAbbreviation.
     */
    public java.lang.String getTimezoneAbbreviation() {
      java.lang.Object ref = timezoneAbbreviation_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        timezoneAbbreviation_ = s;
        return s;
      }
    }
    /**
     * <code>string timezoneAbbreviation = 22;</code>
     *
     * @return The bytes for timezoneAbbreviation.
     */
    public com.google.protobuf.ByteString getTimezoneAbbreviationBytes() {
      java.lang.Object ref = timezoneAbbreviation_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        timezoneAbbreviation_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int COUNTRYNAME_FIELD_NUMBER = 23;
    private volatile java.lang.Object countryName_;
    /**
     * <code>string countryName = 23;</code>
     *
     * @return The countryName.
     */
    public java.lang.String getCountryName() {
      java.lang.Object ref = countryName_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        countryName_ = s;
        return s;
      }
    }
    /**
     * <code>string countryName = 23;</code>
     *
     * @return The bytes for countryName.
     */
    public com.google.protobuf.ByteString getCountryNameBytes() {
      java.lang.Object ref = countryName_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        countryName_ = b;
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
      if (!getNameBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, name_);
      }
      if (!getCodeBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, code_);
      }
      if (!getWaterDensityBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 4, waterDensity_);
      }
      if (!getMaxDraftBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 5, maxDraft_);
      }
      if (!getMaxAirDraftBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 6, maxAirDraft_);
      }
      if (!getAverageTideHeightBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 7, averageTideHeight_);
      }
      if (!getTideHeightBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 8, tideHeight_);
      }
      if (!getHwTideFromBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 9, hwTideFrom_);
      }
      if (!getHwTideToBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 10, hwTideTo_);
      }
      if (!getLwTideFromBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 11, lwTideFrom_);
      }
      if (!getLwTideToBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 12, lwTideTo_);
      }
      if (!getHwTideTimeFromBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 13, hwTideTimeFrom_);
      }
      if (!getHwTideTimeToBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 14, hwTideTimeTo_);
      }
      if (!getLwTideTimeFromBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 15, lwTideTimeFrom_);
      }
      if (!getLwTideTimeToBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 16, lwTideTimeTo_);
      }
      if (!getSunriseTimeBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 17, sunriseTime_);
      }
      if (!getSunsetTimeBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 18, sunsetTime_);
      }
      if (!getTimezoneBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 19, timezone_);
      }
      if (!getTimezoneOffsetValBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 20, timezoneOffsetVal_);
      }
      if (timezoneId_ != 0L) {
        output.writeInt64(21, timezoneId_);
      }
      if (!getTimezoneAbbreviationBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 22, timezoneAbbreviation_);
      }
      if (!getCountryNameBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 23, countryName_);
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
      if (!getNameBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, name_);
      }
      if (!getCodeBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, code_);
      }
      if (!getWaterDensityBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, waterDensity_);
      }
      if (!getMaxDraftBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, maxDraft_);
      }
      if (!getMaxAirDraftBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(6, maxAirDraft_);
      }
      if (!getAverageTideHeightBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(7, averageTideHeight_);
      }
      if (!getTideHeightBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(8, tideHeight_);
      }
      if (!getHwTideFromBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(9, hwTideFrom_);
      }
      if (!getHwTideToBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(10, hwTideTo_);
      }
      if (!getLwTideFromBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(11, lwTideFrom_);
      }
      if (!getLwTideToBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(12, lwTideTo_);
      }
      if (!getHwTideTimeFromBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(13, hwTideTimeFrom_);
      }
      if (!getHwTideTimeToBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(14, hwTideTimeTo_);
      }
      if (!getLwTideTimeFromBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(15, lwTideTimeFrom_);
      }
      if (!getLwTideTimeToBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(16, lwTideTimeTo_);
      }
      if (!getSunriseTimeBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(17, sunriseTime_);
      }
      if (!getSunsetTimeBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(18, sunsetTime_);
      }
      if (!getTimezoneBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(19, timezone_);
      }
      if (!getTimezoneOffsetValBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(20, timezoneOffsetVal_);
      }
      if (timezoneId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(21, timezoneId_);
      }
      if (!getTimezoneAbbreviationBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(22, timezoneAbbreviation_);
      }
      if (!getCountryNameBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(23, countryName_);
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
      if (!(obj instanceof com.cpdss.common.generated.PortInfo.PortDetail)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.PortInfo.PortDetail other =
          (com.cpdss.common.generated.PortInfo.PortDetail) obj;

      if (getId() != other.getId()) return false;
      if (!getName().equals(other.getName())) return false;
      if (!getCode().equals(other.getCode())) return false;
      if (!getWaterDensity().equals(other.getWaterDensity())) return false;
      if (!getMaxDraft().equals(other.getMaxDraft())) return false;
      if (!getMaxAirDraft().equals(other.getMaxAirDraft())) return false;
      if (!getAverageTideHeight().equals(other.getAverageTideHeight())) return false;
      if (!getTideHeight().equals(other.getTideHeight())) return false;
      if (!getHwTideFrom().equals(other.getHwTideFrom())) return false;
      if (!getHwTideTo().equals(other.getHwTideTo())) return false;
      if (!getLwTideFrom().equals(other.getLwTideFrom())) return false;
      if (!getLwTideTo().equals(other.getLwTideTo())) return false;
      if (!getHwTideTimeFrom().equals(other.getHwTideTimeFrom())) return false;
      if (!getHwTideTimeTo().equals(other.getHwTideTimeTo())) return false;
      if (!getLwTideTimeFrom().equals(other.getLwTideTimeFrom())) return false;
      if (!getLwTideTimeTo().equals(other.getLwTideTimeTo())) return false;
      if (!getSunriseTime().equals(other.getSunriseTime())) return false;
      if (!getSunsetTime().equals(other.getSunsetTime())) return false;
      if (!getTimezone().equals(other.getTimezone())) return false;
      if (!getTimezoneOffsetVal().equals(other.getTimezoneOffsetVal())) return false;
      if (getTimezoneId() != other.getTimezoneId()) return false;
      if (!getTimezoneAbbreviation().equals(other.getTimezoneAbbreviation())) return false;
      if (!getCountryName().equals(other.getCountryName())) return false;
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
      hash = (37 * hash) + NAME_FIELD_NUMBER;
      hash = (53 * hash) + getName().hashCode();
      hash = (37 * hash) + CODE_FIELD_NUMBER;
      hash = (53 * hash) + getCode().hashCode();
      hash = (37 * hash) + WATERDENSITY_FIELD_NUMBER;
      hash = (53 * hash) + getWaterDensity().hashCode();
      hash = (37 * hash) + MAXDRAFT_FIELD_NUMBER;
      hash = (53 * hash) + getMaxDraft().hashCode();
      hash = (37 * hash) + MAXAIRDRAFT_FIELD_NUMBER;
      hash = (53 * hash) + getMaxAirDraft().hashCode();
      hash = (37 * hash) + AVERAGETIDEHEIGHT_FIELD_NUMBER;
      hash = (53 * hash) + getAverageTideHeight().hashCode();
      hash = (37 * hash) + TIDEHEIGHT_FIELD_NUMBER;
      hash = (53 * hash) + getTideHeight().hashCode();
      hash = (37 * hash) + HWTIDEFROM_FIELD_NUMBER;
      hash = (53 * hash) + getHwTideFrom().hashCode();
      hash = (37 * hash) + HWTIDETO_FIELD_NUMBER;
      hash = (53 * hash) + getHwTideTo().hashCode();
      hash = (37 * hash) + LWTIDEFROM_FIELD_NUMBER;
      hash = (53 * hash) + getLwTideFrom().hashCode();
      hash = (37 * hash) + LWTIDETO_FIELD_NUMBER;
      hash = (53 * hash) + getLwTideTo().hashCode();
      hash = (37 * hash) + HWTIDETIMEFROM_FIELD_NUMBER;
      hash = (53 * hash) + getHwTideTimeFrom().hashCode();
      hash = (37 * hash) + HWTIDETIMETO_FIELD_NUMBER;
      hash = (53 * hash) + getHwTideTimeTo().hashCode();
      hash = (37 * hash) + LWTIDETIMEFROM_FIELD_NUMBER;
      hash = (53 * hash) + getLwTideTimeFrom().hashCode();
      hash = (37 * hash) + LWTIDETIMETO_FIELD_NUMBER;
      hash = (53 * hash) + getLwTideTimeTo().hashCode();
      hash = (37 * hash) + SUNRISETIME_FIELD_NUMBER;
      hash = (53 * hash) + getSunriseTime().hashCode();
      hash = (37 * hash) + SUNSETTIME_FIELD_NUMBER;
      hash = (53 * hash) + getSunsetTime().hashCode();
      hash = (37 * hash) + TIMEZONE_FIELD_NUMBER;
      hash = (53 * hash) + getTimezone().hashCode();
      hash = (37 * hash) + TIMEZONEOFFSETVAL_FIELD_NUMBER;
      hash = (53 * hash) + getTimezoneOffsetVal().hashCode();
      hash = (37 * hash) + TIMEZONEID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getTimezoneId());
      hash = (37 * hash) + TIMEZONEABBREVIATION_FIELD_NUMBER;
      hash = (53 * hash) + getTimezoneAbbreviation().hashCode();
      hash = (37 * hash) + COUNTRYNAME_FIELD_NUMBER;
      hash = (53 * hash) + getCountryName().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.PortInfo.PortDetail parseFrom(java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.PortInfo.PortDetail parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.PortDetail parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.PortInfo.PortDetail parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.PortDetail parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.PortInfo.PortDetail parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.PortDetail parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.PortInfo.PortDetail parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.PortDetail parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.PortInfo.PortDetail parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.PortDetail parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.PortInfo.PortDetail parseFrom(
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

    public static Builder newBuilder(com.cpdss.common.generated.PortInfo.PortDetail prototype) {
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
    /** Protobuf type {@code PortDetail} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:PortDetail)
        com.cpdss.common.generated.PortInfo.PortDetailOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.PortInfo.internal_static_PortDetail_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.PortInfo.internal_static_PortDetail_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.PortInfo.PortDetail.class,
                com.cpdss.common.generated.PortInfo.PortDetail.Builder.class);
      }

      // Construct using com.cpdss.common.generated.PortInfo.PortDetail.newBuilder()
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

        name_ = "";

        code_ = "";

        waterDensity_ = "";

        maxDraft_ = "";

        maxAirDraft_ = "";

        averageTideHeight_ = "";

        tideHeight_ = "";

        hwTideFrom_ = "";

        hwTideTo_ = "";

        lwTideFrom_ = "";

        lwTideTo_ = "";

        hwTideTimeFrom_ = "";

        hwTideTimeTo_ = "";

        lwTideTimeFrom_ = "";

        lwTideTimeTo_ = "";

        sunriseTime_ = "";

        sunsetTime_ = "";

        timezone_ = "";

        timezoneOffsetVal_ = "";

        timezoneId_ = 0L;

        timezoneAbbreviation_ = "";

        countryName_ = "";

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.PortInfo.internal_static_PortDetail_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.PortInfo.PortDetail getDefaultInstanceForType() {
        return com.cpdss.common.generated.PortInfo.PortDetail.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.PortInfo.PortDetail build() {
        com.cpdss.common.generated.PortInfo.PortDetail result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.PortInfo.PortDetail buildPartial() {
        com.cpdss.common.generated.PortInfo.PortDetail result =
            new com.cpdss.common.generated.PortInfo.PortDetail(this);
        result.id_ = id_;
        result.name_ = name_;
        result.code_ = code_;
        result.waterDensity_ = waterDensity_;
        result.maxDraft_ = maxDraft_;
        result.maxAirDraft_ = maxAirDraft_;
        result.averageTideHeight_ = averageTideHeight_;
        result.tideHeight_ = tideHeight_;
        result.hwTideFrom_ = hwTideFrom_;
        result.hwTideTo_ = hwTideTo_;
        result.lwTideFrom_ = lwTideFrom_;
        result.lwTideTo_ = lwTideTo_;
        result.hwTideTimeFrom_ = hwTideTimeFrom_;
        result.hwTideTimeTo_ = hwTideTimeTo_;
        result.lwTideTimeFrom_ = lwTideTimeFrom_;
        result.lwTideTimeTo_ = lwTideTimeTo_;
        result.sunriseTime_ = sunriseTime_;
        result.sunsetTime_ = sunsetTime_;
        result.timezone_ = timezone_;
        result.timezoneOffsetVal_ = timezoneOffsetVal_;
        result.timezoneId_ = timezoneId_;
        result.timezoneAbbreviation_ = timezoneAbbreviation_;
        result.countryName_ = countryName_;
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
        if (other instanceof com.cpdss.common.generated.PortInfo.PortDetail) {
          return mergeFrom((com.cpdss.common.generated.PortInfo.PortDetail) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.cpdss.common.generated.PortInfo.PortDetail other) {
        if (other == com.cpdss.common.generated.PortInfo.PortDetail.getDefaultInstance())
          return this;
        if (other.getId() != 0L) {
          setId(other.getId());
        }
        if (!other.getName().isEmpty()) {
          name_ = other.name_;
          onChanged();
        }
        if (!other.getCode().isEmpty()) {
          code_ = other.code_;
          onChanged();
        }
        if (!other.getWaterDensity().isEmpty()) {
          waterDensity_ = other.waterDensity_;
          onChanged();
        }
        if (!other.getMaxDraft().isEmpty()) {
          maxDraft_ = other.maxDraft_;
          onChanged();
        }
        if (!other.getMaxAirDraft().isEmpty()) {
          maxAirDraft_ = other.maxAirDraft_;
          onChanged();
        }
        if (!other.getAverageTideHeight().isEmpty()) {
          averageTideHeight_ = other.averageTideHeight_;
          onChanged();
        }
        if (!other.getTideHeight().isEmpty()) {
          tideHeight_ = other.tideHeight_;
          onChanged();
        }
        if (!other.getHwTideFrom().isEmpty()) {
          hwTideFrom_ = other.hwTideFrom_;
          onChanged();
        }
        if (!other.getHwTideTo().isEmpty()) {
          hwTideTo_ = other.hwTideTo_;
          onChanged();
        }
        if (!other.getLwTideFrom().isEmpty()) {
          lwTideFrom_ = other.lwTideFrom_;
          onChanged();
        }
        if (!other.getLwTideTo().isEmpty()) {
          lwTideTo_ = other.lwTideTo_;
          onChanged();
        }
        if (!other.getHwTideTimeFrom().isEmpty()) {
          hwTideTimeFrom_ = other.hwTideTimeFrom_;
          onChanged();
        }
        if (!other.getHwTideTimeTo().isEmpty()) {
          hwTideTimeTo_ = other.hwTideTimeTo_;
          onChanged();
        }
        if (!other.getLwTideTimeFrom().isEmpty()) {
          lwTideTimeFrom_ = other.lwTideTimeFrom_;
          onChanged();
        }
        if (!other.getLwTideTimeTo().isEmpty()) {
          lwTideTimeTo_ = other.lwTideTimeTo_;
          onChanged();
        }
        if (!other.getSunriseTime().isEmpty()) {
          sunriseTime_ = other.sunriseTime_;
          onChanged();
        }
        if (!other.getSunsetTime().isEmpty()) {
          sunsetTime_ = other.sunsetTime_;
          onChanged();
        }
        if (!other.getTimezone().isEmpty()) {
          timezone_ = other.timezone_;
          onChanged();
        }
        if (!other.getTimezoneOffsetVal().isEmpty()) {
          timezoneOffsetVal_ = other.timezoneOffsetVal_;
          onChanged();
        }
        if (other.getTimezoneId() != 0L) {
          setTimezoneId(other.getTimezoneId());
        }
        if (!other.getTimezoneAbbreviation().isEmpty()) {
          timezoneAbbreviation_ = other.timezoneAbbreviation_;
          onChanged();
        }
        if (!other.getCountryName().isEmpty()) {
          countryName_ = other.countryName_;
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
        com.cpdss.common.generated.PortInfo.PortDetail parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.cpdss.common.generated.PortInfo.PortDetail) e.getUnfinishedMessage();
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

      private java.lang.Object name_ = "";
      /**
       * <code>string name = 2;</code>
       *
       * @return The name.
       */
      public java.lang.String getName() {
        java.lang.Object ref = name_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          name_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string name = 2;</code>
       *
       * @return The bytes for name.
       */
      public com.google.protobuf.ByteString getNameBytes() {
        java.lang.Object ref = name_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          name_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string name = 2;</code>
       *
       * @param value The name to set.
       * @return This builder for chaining.
       */
      public Builder setName(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        name_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string name = 2;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearName() {

        name_ = getDefaultInstance().getName();
        onChanged();
        return this;
      }
      /**
       * <code>string name = 2;</code>
       *
       * @param value The bytes for name to set.
       * @return This builder for chaining.
       */
      public Builder setNameBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        name_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object code_ = "";
      /**
       * <code>string code = 3;</code>
       *
       * @return The code.
       */
      public java.lang.String getCode() {
        java.lang.Object ref = code_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          code_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string code = 3;</code>
       *
       * @return The bytes for code.
       */
      public com.google.protobuf.ByteString getCodeBytes() {
        java.lang.Object ref = code_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          code_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string code = 3;</code>
       *
       * @param value The code to set.
       * @return This builder for chaining.
       */
      public Builder setCode(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        code_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string code = 3;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearCode() {

        code_ = getDefaultInstance().getCode();
        onChanged();
        return this;
      }
      /**
       * <code>string code = 3;</code>
       *
       * @param value The bytes for code to set.
       * @return This builder for chaining.
       */
      public Builder setCodeBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        code_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object waterDensity_ = "";
      /**
       * <code>string waterDensity = 4;</code>
       *
       * @return The waterDensity.
       */
      public java.lang.String getWaterDensity() {
        java.lang.Object ref = waterDensity_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          waterDensity_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string waterDensity = 4;</code>
       *
       * @return The bytes for waterDensity.
       */
      public com.google.protobuf.ByteString getWaterDensityBytes() {
        java.lang.Object ref = waterDensity_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          waterDensity_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string waterDensity = 4;</code>
       *
       * @param value The waterDensity to set.
       * @return This builder for chaining.
       */
      public Builder setWaterDensity(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        waterDensity_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string waterDensity = 4;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearWaterDensity() {

        waterDensity_ = getDefaultInstance().getWaterDensity();
        onChanged();
        return this;
      }
      /**
       * <code>string waterDensity = 4;</code>
       *
       * @param value The bytes for waterDensity to set.
       * @return This builder for chaining.
       */
      public Builder setWaterDensityBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        waterDensity_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object maxDraft_ = "";
      /**
       * <code>string maxDraft = 5;</code>
       *
       * @return The maxDraft.
       */
      public java.lang.String getMaxDraft() {
        java.lang.Object ref = maxDraft_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          maxDraft_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string maxDraft = 5;</code>
       *
       * @return The bytes for maxDraft.
       */
      public com.google.protobuf.ByteString getMaxDraftBytes() {
        java.lang.Object ref = maxDraft_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          maxDraft_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string maxDraft = 5;</code>
       *
       * @param value The maxDraft to set.
       * @return This builder for chaining.
       */
      public Builder setMaxDraft(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        maxDraft_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string maxDraft = 5;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearMaxDraft() {

        maxDraft_ = getDefaultInstance().getMaxDraft();
        onChanged();
        return this;
      }
      /**
       * <code>string maxDraft = 5;</code>
       *
       * @param value The bytes for maxDraft to set.
       * @return This builder for chaining.
       */
      public Builder setMaxDraftBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        maxDraft_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object maxAirDraft_ = "";
      /**
       * <code>string maxAirDraft = 6;</code>
       *
       * @return The maxAirDraft.
       */
      public java.lang.String getMaxAirDraft() {
        java.lang.Object ref = maxAirDraft_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          maxAirDraft_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string maxAirDraft = 6;</code>
       *
       * @return The bytes for maxAirDraft.
       */
      public com.google.protobuf.ByteString getMaxAirDraftBytes() {
        java.lang.Object ref = maxAirDraft_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          maxAirDraft_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string maxAirDraft = 6;</code>
       *
       * @param value The maxAirDraft to set.
       * @return This builder for chaining.
       */
      public Builder setMaxAirDraft(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        maxAirDraft_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string maxAirDraft = 6;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearMaxAirDraft() {

        maxAirDraft_ = getDefaultInstance().getMaxAirDraft();
        onChanged();
        return this;
      }
      /**
       * <code>string maxAirDraft = 6;</code>
       *
       * @param value The bytes for maxAirDraft to set.
       * @return This builder for chaining.
       */
      public Builder setMaxAirDraftBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        maxAirDraft_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object averageTideHeight_ = "";
      /**
       * <code>string averageTideHeight = 7;</code>
       *
       * @return The averageTideHeight.
       */
      public java.lang.String getAverageTideHeight() {
        java.lang.Object ref = averageTideHeight_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          averageTideHeight_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string averageTideHeight = 7;</code>
       *
       * @return The bytes for averageTideHeight.
       */
      public com.google.protobuf.ByteString getAverageTideHeightBytes() {
        java.lang.Object ref = averageTideHeight_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          averageTideHeight_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string averageTideHeight = 7;</code>
       *
       * @param value The averageTideHeight to set.
       * @return This builder for chaining.
       */
      public Builder setAverageTideHeight(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        averageTideHeight_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string averageTideHeight = 7;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearAverageTideHeight() {

        averageTideHeight_ = getDefaultInstance().getAverageTideHeight();
        onChanged();
        return this;
      }
      /**
       * <code>string averageTideHeight = 7;</code>
       *
       * @param value The bytes for averageTideHeight to set.
       * @return This builder for chaining.
       */
      public Builder setAverageTideHeightBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        averageTideHeight_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object tideHeight_ = "";
      /**
       * <code>string tideHeight = 8;</code>
       *
       * @return The tideHeight.
       */
      public java.lang.String getTideHeight() {
        java.lang.Object ref = tideHeight_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          tideHeight_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string tideHeight = 8;</code>
       *
       * @return The bytes for tideHeight.
       */
      public com.google.protobuf.ByteString getTideHeightBytes() {
        java.lang.Object ref = tideHeight_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          tideHeight_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string tideHeight = 8;</code>
       *
       * @param value The tideHeight to set.
       * @return This builder for chaining.
       */
      public Builder setTideHeight(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        tideHeight_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string tideHeight = 8;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearTideHeight() {

        tideHeight_ = getDefaultInstance().getTideHeight();
        onChanged();
        return this;
      }
      /**
       * <code>string tideHeight = 8;</code>
       *
       * @param value The bytes for tideHeight to set.
       * @return This builder for chaining.
       */
      public Builder setTideHeightBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        tideHeight_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object hwTideFrom_ = "";
      /**
       * <code>string hwTideFrom = 9;</code>
       *
       * @return The hwTideFrom.
       */
      public java.lang.String getHwTideFrom() {
        java.lang.Object ref = hwTideFrom_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          hwTideFrom_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string hwTideFrom = 9;</code>
       *
       * @return The bytes for hwTideFrom.
       */
      public com.google.protobuf.ByteString getHwTideFromBytes() {
        java.lang.Object ref = hwTideFrom_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          hwTideFrom_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string hwTideFrom = 9;</code>
       *
       * @param value The hwTideFrom to set.
       * @return This builder for chaining.
       */
      public Builder setHwTideFrom(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        hwTideFrom_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string hwTideFrom = 9;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearHwTideFrom() {

        hwTideFrom_ = getDefaultInstance().getHwTideFrom();
        onChanged();
        return this;
      }
      /**
       * <code>string hwTideFrom = 9;</code>
       *
       * @param value The bytes for hwTideFrom to set.
       * @return This builder for chaining.
       */
      public Builder setHwTideFromBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        hwTideFrom_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object hwTideTo_ = "";
      /**
       * <code>string hwTideTo = 10;</code>
       *
       * @return The hwTideTo.
       */
      public java.lang.String getHwTideTo() {
        java.lang.Object ref = hwTideTo_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          hwTideTo_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string hwTideTo = 10;</code>
       *
       * @return The bytes for hwTideTo.
       */
      public com.google.protobuf.ByteString getHwTideToBytes() {
        java.lang.Object ref = hwTideTo_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          hwTideTo_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string hwTideTo = 10;</code>
       *
       * @param value The hwTideTo to set.
       * @return This builder for chaining.
       */
      public Builder setHwTideTo(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        hwTideTo_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string hwTideTo = 10;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearHwTideTo() {

        hwTideTo_ = getDefaultInstance().getHwTideTo();
        onChanged();
        return this;
      }
      /**
       * <code>string hwTideTo = 10;</code>
       *
       * @param value The bytes for hwTideTo to set.
       * @return This builder for chaining.
       */
      public Builder setHwTideToBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        hwTideTo_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object lwTideFrom_ = "";
      /**
       * <code>string lwTideFrom = 11;</code>
       *
       * @return The lwTideFrom.
       */
      public java.lang.String getLwTideFrom() {
        java.lang.Object ref = lwTideFrom_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          lwTideFrom_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string lwTideFrom = 11;</code>
       *
       * @return The bytes for lwTideFrom.
       */
      public com.google.protobuf.ByteString getLwTideFromBytes() {
        java.lang.Object ref = lwTideFrom_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          lwTideFrom_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string lwTideFrom = 11;</code>
       *
       * @param value The lwTideFrom to set.
       * @return This builder for chaining.
       */
      public Builder setLwTideFrom(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        lwTideFrom_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string lwTideFrom = 11;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearLwTideFrom() {

        lwTideFrom_ = getDefaultInstance().getLwTideFrom();
        onChanged();
        return this;
      }
      /**
       * <code>string lwTideFrom = 11;</code>
       *
       * @param value The bytes for lwTideFrom to set.
       * @return This builder for chaining.
       */
      public Builder setLwTideFromBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        lwTideFrom_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object lwTideTo_ = "";
      /**
       * <code>string lwTideTo = 12;</code>
       *
       * @return The lwTideTo.
       */
      public java.lang.String getLwTideTo() {
        java.lang.Object ref = lwTideTo_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          lwTideTo_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string lwTideTo = 12;</code>
       *
       * @return The bytes for lwTideTo.
       */
      public com.google.protobuf.ByteString getLwTideToBytes() {
        java.lang.Object ref = lwTideTo_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          lwTideTo_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string lwTideTo = 12;</code>
       *
       * @param value The lwTideTo to set.
       * @return This builder for chaining.
       */
      public Builder setLwTideTo(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        lwTideTo_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string lwTideTo = 12;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearLwTideTo() {

        lwTideTo_ = getDefaultInstance().getLwTideTo();
        onChanged();
        return this;
      }
      /**
       * <code>string lwTideTo = 12;</code>
       *
       * @param value The bytes for lwTideTo to set.
       * @return This builder for chaining.
       */
      public Builder setLwTideToBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        lwTideTo_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object hwTideTimeFrom_ = "";
      /**
       * <code>string hwTideTimeFrom = 13;</code>
       *
       * @return The hwTideTimeFrom.
       */
      public java.lang.String getHwTideTimeFrom() {
        java.lang.Object ref = hwTideTimeFrom_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          hwTideTimeFrom_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string hwTideTimeFrom = 13;</code>
       *
       * @return The bytes for hwTideTimeFrom.
       */
      public com.google.protobuf.ByteString getHwTideTimeFromBytes() {
        java.lang.Object ref = hwTideTimeFrom_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          hwTideTimeFrom_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string hwTideTimeFrom = 13;</code>
       *
       * @param value The hwTideTimeFrom to set.
       * @return This builder for chaining.
       */
      public Builder setHwTideTimeFrom(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        hwTideTimeFrom_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string hwTideTimeFrom = 13;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearHwTideTimeFrom() {

        hwTideTimeFrom_ = getDefaultInstance().getHwTideTimeFrom();
        onChanged();
        return this;
      }
      /**
       * <code>string hwTideTimeFrom = 13;</code>
       *
       * @param value The bytes for hwTideTimeFrom to set.
       * @return This builder for chaining.
       */
      public Builder setHwTideTimeFromBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        hwTideTimeFrom_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object hwTideTimeTo_ = "";
      /**
       * <code>string hwTideTimeTo = 14;</code>
       *
       * @return The hwTideTimeTo.
       */
      public java.lang.String getHwTideTimeTo() {
        java.lang.Object ref = hwTideTimeTo_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          hwTideTimeTo_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string hwTideTimeTo = 14;</code>
       *
       * @return The bytes for hwTideTimeTo.
       */
      public com.google.protobuf.ByteString getHwTideTimeToBytes() {
        java.lang.Object ref = hwTideTimeTo_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          hwTideTimeTo_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string hwTideTimeTo = 14;</code>
       *
       * @param value The hwTideTimeTo to set.
       * @return This builder for chaining.
       */
      public Builder setHwTideTimeTo(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        hwTideTimeTo_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string hwTideTimeTo = 14;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearHwTideTimeTo() {

        hwTideTimeTo_ = getDefaultInstance().getHwTideTimeTo();
        onChanged();
        return this;
      }
      /**
       * <code>string hwTideTimeTo = 14;</code>
       *
       * @param value The bytes for hwTideTimeTo to set.
       * @return This builder for chaining.
       */
      public Builder setHwTideTimeToBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        hwTideTimeTo_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object lwTideTimeFrom_ = "";
      /**
       * <code>string lwTideTimeFrom = 15;</code>
       *
       * @return The lwTideTimeFrom.
       */
      public java.lang.String getLwTideTimeFrom() {
        java.lang.Object ref = lwTideTimeFrom_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          lwTideTimeFrom_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string lwTideTimeFrom = 15;</code>
       *
       * @return The bytes for lwTideTimeFrom.
       */
      public com.google.protobuf.ByteString getLwTideTimeFromBytes() {
        java.lang.Object ref = lwTideTimeFrom_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          lwTideTimeFrom_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string lwTideTimeFrom = 15;</code>
       *
       * @param value The lwTideTimeFrom to set.
       * @return This builder for chaining.
       */
      public Builder setLwTideTimeFrom(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        lwTideTimeFrom_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string lwTideTimeFrom = 15;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearLwTideTimeFrom() {

        lwTideTimeFrom_ = getDefaultInstance().getLwTideTimeFrom();
        onChanged();
        return this;
      }
      /**
       * <code>string lwTideTimeFrom = 15;</code>
       *
       * @param value The bytes for lwTideTimeFrom to set.
       * @return This builder for chaining.
       */
      public Builder setLwTideTimeFromBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        lwTideTimeFrom_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object lwTideTimeTo_ = "";
      /**
       * <code>string lwTideTimeTo = 16;</code>
       *
       * @return The lwTideTimeTo.
       */
      public java.lang.String getLwTideTimeTo() {
        java.lang.Object ref = lwTideTimeTo_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          lwTideTimeTo_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string lwTideTimeTo = 16;</code>
       *
       * @return The bytes for lwTideTimeTo.
       */
      public com.google.protobuf.ByteString getLwTideTimeToBytes() {
        java.lang.Object ref = lwTideTimeTo_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          lwTideTimeTo_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string lwTideTimeTo = 16;</code>
       *
       * @param value The lwTideTimeTo to set.
       * @return This builder for chaining.
       */
      public Builder setLwTideTimeTo(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        lwTideTimeTo_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string lwTideTimeTo = 16;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearLwTideTimeTo() {

        lwTideTimeTo_ = getDefaultInstance().getLwTideTimeTo();
        onChanged();
        return this;
      }
      /**
       * <code>string lwTideTimeTo = 16;</code>
       *
       * @param value The bytes for lwTideTimeTo to set.
       * @return This builder for chaining.
       */
      public Builder setLwTideTimeToBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        lwTideTimeTo_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object sunriseTime_ = "";
      /**
       * <code>string sunriseTime = 17;</code>
       *
       * @return The sunriseTime.
       */
      public java.lang.String getSunriseTime() {
        java.lang.Object ref = sunriseTime_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          sunriseTime_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string sunriseTime = 17;</code>
       *
       * @return The bytes for sunriseTime.
       */
      public com.google.protobuf.ByteString getSunriseTimeBytes() {
        java.lang.Object ref = sunriseTime_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          sunriseTime_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string sunriseTime = 17;</code>
       *
       * @param value The sunriseTime to set.
       * @return This builder for chaining.
       */
      public Builder setSunriseTime(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        sunriseTime_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string sunriseTime = 17;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearSunriseTime() {

        sunriseTime_ = getDefaultInstance().getSunriseTime();
        onChanged();
        return this;
      }
      /**
       * <code>string sunriseTime = 17;</code>
       *
       * @param value The bytes for sunriseTime to set.
       * @return This builder for chaining.
       */
      public Builder setSunriseTimeBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        sunriseTime_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object sunsetTime_ = "";
      /**
       * <code>string sunsetTime = 18;</code>
       *
       * @return The sunsetTime.
       */
      public java.lang.String getSunsetTime() {
        java.lang.Object ref = sunsetTime_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          sunsetTime_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string sunsetTime = 18;</code>
       *
       * @return The bytes for sunsetTime.
       */
      public com.google.protobuf.ByteString getSunsetTimeBytes() {
        java.lang.Object ref = sunsetTime_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          sunsetTime_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string sunsetTime = 18;</code>
       *
       * @param value The sunsetTime to set.
       * @return This builder for chaining.
       */
      public Builder setSunsetTime(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        sunsetTime_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string sunsetTime = 18;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearSunsetTime() {

        sunsetTime_ = getDefaultInstance().getSunsetTime();
        onChanged();
        return this;
      }
      /**
       * <code>string sunsetTime = 18;</code>
       *
       * @param value The bytes for sunsetTime to set.
       * @return This builder for chaining.
       */
      public Builder setSunsetTimeBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        sunsetTime_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object timezone_ = "";
      /**
       * <code>string timezone = 19;</code>
       *
       * @return The timezone.
       */
      public java.lang.String getTimezone() {
        java.lang.Object ref = timezone_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          timezone_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string timezone = 19;</code>
       *
       * @return The bytes for timezone.
       */
      public com.google.protobuf.ByteString getTimezoneBytes() {
        java.lang.Object ref = timezone_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          timezone_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string timezone = 19;</code>
       *
       * @param value The timezone to set.
       * @return This builder for chaining.
       */
      public Builder setTimezone(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        timezone_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string timezone = 19;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearTimezone() {

        timezone_ = getDefaultInstance().getTimezone();
        onChanged();
        return this;
      }
      /**
       * <code>string timezone = 19;</code>
       *
       * @param value The bytes for timezone to set.
       * @return This builder for chaining.
       */
      public Builder setTimezoneBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        timezone_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object timezoneOffsetVal_ = "";
      /**
       * <code>string timezoneOffsetVal = 20;</code>
       *
       * @return The timezoneOffsetVal.
       */
      public java.lang.String getTimezoneOffsetVal() {
        java.lang.Object ref = timezoneOffsetVal_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          timezoneOffsetVal_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string timezoneOffsetVal = 20;</code>
       *
       * @return The bytes for timezoneOffsetVal.
       */
      public com.google.protobuf.ByteString getTimezoneOffsetValBytes() {
        java.lang.Object ref = timezoneOffsetVal_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          timezoneOffsetVal_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string timezoneOffsetVal = 20;</code>
       *
       * @param value The timezoneOffsetVal to set.
       * @return This builder for chaining.
       */
      public Builder setTimezoneOffsetVal(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        timezoneOffsetVal_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string timezoneOffsetVal = 20;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearTimezoneOffsetVal() {

        timezoneOffsetVal_ = getDefaultInstance().getTimezoneOffsetVal();
        onChanged();
        return this;
      }
      /**
       * <code>string timezoneOffsetVal = 20;</code>
       *
       * @param value The bytes for timezoneOffsetVal to set.
       * @return This builder for chaining.
       */
      public Builder setTimezoneOffsetValBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        timezoneOffsetVal_ = value;
        onChanged();
        return this;
      }

      private long timezoneId_;
      /**
       * <code>int64 timezoneId = 21;</code>
       *
       * @return The timezoneId.
       */
      public long getTimezoneId() {
        return timezoneId_;
      }
      /**
       * <code>int64 timezoneId = 21;</code>
       *
       * @param value The timezoneId to set.
       * @return This builder for chaining.
       */
      public Builder setTimezoneId(long value) {

        timezoneId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int64 timezoneId = 21;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearTimezoneId() {

        timezoneId_ = 0L;
        onChanged();
        return this;
      }

      private java.lang.Object timezoneAbbreviation_ = "";
      /**
       * <code>string timezoneAbbreviation = 22;</code>
       *
       * @return The timezoneAbbreviation.
       */
      public java.lang.String getTimezoneAbbreviation() {
        java.lang.Object ref = timezoneAbbreviation_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          timezoneAbbreviation_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string timezoneAbbreviation = 22;</code>
       *
       * @return The bytes for timezoneAbbreviation.
       */
      public com.google.protobuf.ByteString getTimezoneAbbreviationBytes() {
        java.lang.Object ref = timezoneAbbreviation_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          timezoneAbbreviation_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string timezoneAbbreviation = 22;</code>
       *
       * @param value The timezoneAbbreviation to set.
       * @return This builder for chaining.
       */
      public Builder setTimezoneAbbreviation(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        timezoneAbbreviation_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string timezoneAbbreviation = 22;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearTimezoneAbbreviation() {

        timezoneAbbreviation_ = getDefaultInstance().getTimezoneAbbreviation();
        onChanged();
        return this;
      }
      /**
       * <code>string timezoneAbbreviation = 22;</code>
       *
       * @param value The bytes for timezoneAbbreviation to set.
       * @return This builder for chaining.
       */
      public Builder setTimezoneAbbreviationBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        timezoneAbbreviation_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object countryName_ = "";
      /**
       * <code>string countryName = 23;</code>
       *
       * @return The countryName.
       */
      public java.lang.String getCountryName() {
        java.lang.Object ref = countryName_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          countryName_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string countryName = 23;</code>
       *
       * @return The bytes for countryName.
       */
      public com.google.protobuf.ByteString getCountryNameBytes() {
        java.lang.Object ref = countryName_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          countryName_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string countryName = 23;</code>
       *
       * @param value The countryName to set.
       * @return This builder for chaining.
       */
      public Builder setCountryName(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        countryName_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string countryName = 23;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearCountryName() {

        countryName_ = getDefaultInstance().getCountryName();
        onChanged();
        return this;
      }
      /**
       * <code>string countryName = 23;</code>
       *
       * @param value The bytes for countryName to set.
       * @return This builder for chaining.
       */
      public Builder setCountryNameBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        countryName_ = value;
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

      // @@protoc_insertion_point(builder_scope:PortDetail)
    }

    // @@protoc_insertion_point(class_scope:PortDetail)
    private static final com.cpdss.common.generated.PortInfo.PortDetail DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.PortInfo.PortDetail();
    }

    public static com.cpdss.common.generated.PortInfo.PortDetail getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<PortDetail> PARSER =
        new com.google.protobuf.AbstractParser<PortDetail>() {
          @java.lang.Override
          public PortDetail parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new PortDetail(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<PortDetail> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<PortDetail> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.PortInfo.PortDetail getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface PortReplyOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:PortReply)
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

    /** <code>repeated .PortDetail ports = 2;</code> */
    java.util.List<com.cpdss.common.generated.PortInfo.PortDetail> getPortsList();
    /** <code>repeated .PortDetail ports = 2;</code> */
    com.cpdss.common.generated.PortInfo.PortDetail getPorts(int index);
    /** <code>repeated .PortDetail ports = 2;</code> */
    int getPortsCount();
    /** <code>repeated .PortDetail ports = 2;</code> */
    java.util.List<? extends com.cpdss.common.generated.PortInfo.PortDetailOrBuilder>
        getPortsOrBuilderList();
    /** <code>repeated .PortDetail ports = 2;</code> */
    com.cpdss.common.generated.PortInfo.PortDetailOrBuilder getPortsOrBuilder(int index);
  }
  /** Protobuf type {@code PortReply} */
  public static final class PortReply extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:PortReply)
      PortReplyOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use PortReply.newBuilder() to construct.
    private PortReply(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private PortReply() {
      ports_ = java.util.Collections.emptyList();
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new PortReply();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private PortReply(
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
            case 18:
              {
                if (!((mutable_bitField0_ & 0x00000001) != 0)) {
                  ports_ =
                      new java.util.ArrayList<com.cpdss.common.generated.PortInfo.PortDetail>();
                  mutable_bitField0_ |= 0x00000001;
                }
                ports_.add(
                    input.readMessage(
                        com.cpdss.common.generated.PortInfo.PortDetail.parser(),
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
          ports_ = java.util.Collections.unmodifiableList(ports_);
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }

    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.cpdss.common.generated.PortInfo.internal_static_PortReply_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.PortInfo.internal_static_PortReply_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.PortInfo.PortReply.class,
              com.cpdss.common.generated.PortInfo.PortReply.Builder.class);
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

    public static final int PORTS_FIELD_NUMBER = 2;
    private java.util.List<com.cpdss.common.generated.PortInfo.PortDetail> ports_;
    /** <code>repeated .PortDetail ports = 2;</code> */
    public java.util.List<com.cpdss.common.generated.PortInfo.PortDetail> getPortsList() {
      return ports_;
    }
    /** <code>repeated .PortDetail ports = 2;</code> */
    public java.util.List<? extends com.cpdss.common.generated.PortInfo.PortDetailOrBuilder>
        getPortsOrBuilderList() {
      return ports_;
    }
    /** <code>repeated .PortDetail ports = 2;</code> */
    public int getPortsCount() {
      return ports_.size();
    }
    /** <code>repeated .PortDetail ports = 2;</code> */
    public com.cpdss.common.generated.PortInfo.PortDetail getPorts(int index) {
      return ports_.get(index);
    }
    /** <code>repeated .PortDetail ports = 2;</code> */
    public com.cpdss.common.generated.PortInfo.PortDetailOrBuilder getPortsOrBuilder(int index) {
      return ports_.get(index);
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
      for (int i = 0; i < ports_.size(); i++) {
        output.writeMessage(2, ports_.get(i));
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
      for (int i = 0; i < ports_.size(); i++) {
        size += com.google.protobuf.CodedOutputStream.computeMessageSize(2, ports_.get(i));
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
      if (!(obj instanceof com.cpdss.common.generated.PortInfo.PortReply)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.PortInfo.PortReply other =
          (com.cpdss.common.generated.PortInfo.PortReply) obj;

      if (hasResponseStatus() != other.hasResponseStatus()) return false;
      if (hasResponseStatus()) {
        if (!getResponseStatus().equals(other.getResponseStatus())) return false;
      }
      if (!getPortsList().equals(other.getPortsList())) return false;
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
      if (getPortsCount() > 0) {
        hash = (37 * hash) + PORTS_FIELD_NUMBER;
        hash = (53 * hash) + getPortsList().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.PortInfo.PortReply parseFrom(java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.PortInfo.PortReply parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.PortReply parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.PortInfo.PortReply parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.PortReply parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.PortInfo.PortReply parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.PortReply parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.PortInfo.PortReply parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.PortReply parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.PortInfo.PortReply parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.PortReply parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.PortInfo.PortReply parseFrom(
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

    public static Builder newBuilder(com.cpdss.common.generated.PortInfo.PortReply prototype) {
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
    /** Protobuf type {@code PortReply} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:PortReply)
        com.cpdss.common.generated.PortInfo.PortReplyOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.PortInfo.internal_static_PortReply_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.PortInfo.internal_static_PortReply_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.PortInfo.PortReply.class,
                com.cpdss.common.generated.PortInfo.PortReply.Builder.class);
      }

      // Construct using com.cpdss.common.generated.PortInfo.PortReply.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {
          getPortsFieldBuilder();
        }
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
        if (portsBuilder_ == null) {
          ports_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          portsBuilder_.clear();
        }
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.PortInfo.internal_static_PortReply_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.PortInfo.PortReply getDefaultInstanceForType() {
        return com.cpdss.common.generated.PortInfo.PortReply.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.PortInfo.PortReply build() {
        com.cpdss.common.generated.PortInfo.PortReply result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.PortInfo.PortReply buildPartial() {
        com.cpdss.common.generated.PortInfo.PortReply result =
            new com.cpdss.common.generated.PortInfo.PortReply(this);
        int from_bitField0_ = bitField0_;
        if (responseStatusBuilder_ == null) {
          result.responseStatus_ = responseStatus_;
        } else {
          result.responseStatus_ = responseStatusBuilder_.build();
        }
        if (portsBuilder_ == null) {
          if (((bitField0_ & 0x00000001) != 0)) {
            ports_ = java.util.Collections.unmodifiableList(ports_);
            bitField0_ = (bitField0_ & ~0x00000001);
          }
          result.ports_ = ports_;
        } else {
          result.ports_ = portsBuilder_.build();
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
        if (other instanceof com.cpdss.common.generated.PortInfo.PortReply) {
          return mergeFrom((com.cpdss.common.generated.PortInfo.PortReply) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.cpdss.common.generated.PortInfo.PortReply other) {
        if (other == com.cpdss.common.generated.PortInfo.PortReply.getDefaultInstance())
          return this;
        if (other.hasResponseStatus()) {
          mergeResponseStatus(other.getResponseStatus());
        }
        if (portsBuilder_ == null) {
          if (!other.ports_.isEmpty()) {
            if (ports_.isEmpty()) {
              ports_ = other.ports_;
              bitField0_ = (bitField0_ & ~0x00000001);
            } else {
              ensurePortsIsMutable();
              ports_.addAll(other.ports_);
            }
            onChanged();
          }
        } else {
          if (!other.ports_.isEmpty()) {
            if (portsBuilder_.isEmpty()) {
              portsBuilder_.dispose();
              portsBuilder_ = null;
              ports_ = other.ports_;
              bitField0_ = (bitField0_ & ~0x00000001);
              portsBuilder_ =
                  com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
                      ? getPortsFieldBuilder()
                      : null;
            } else {
              portsBuilder_.addAllMessages(other.ports_);
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
        com.cpdss.common.generated.PortInfo.PortReply parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.cpdss.common.generated.PortInfo.PortReply) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private int bitField0_;

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

      private java.util.List<com.cpdss.common.generated.PortInfo.PortDetail> ports_ =
          java.util.Collections.emptyList();

      private void ensurePortsIsMutable() {
        if (!((bitField0_ & 0x00000001) != 0)) {
          ports_ = new java.util.ArrayList<com.cpdss.common.generated.PortInfo.PortDetail>(ports_);
          bitField0_ |= 0x00000001;
        }
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
              com.cpdss.common.generated.PortInfo.PortDetail,
              com.cpdss.common.generated.PortInfo.PortDetail.Builder,
              com.cpdss.common.generated.PortInfo.PortDetailOrBuilder>
          portsBuilder_;

      /** <code>repeated .PortDetail ports = 2;</code> */
      public java.util.List<com.cpdss.common.generated.PortInfo.PortDetail> getPortsList() {
        if (portsBuilder_ == null) {
          return java.util.Collections.unmodifiableList(ports_);
        } else {
          return portsBuilder_.getMessageList();
        }
      }
      /** <code>repeated .PortDetail ports = 2;</code> */
      public int getPortsCount() {
        if (portsBuilder_ == null) {
          return ports_.size();
        } else {
          return portsBuilder_.getCount();
        }
      }
      /** <code>repeated .PortDetail ports = 2;</code> */
      public com.cpdss.common.generated.PortInfo.PortDetail getPorts(int index) {
        if (portsBuilder_ == null) {
          return ports_.get(index);
        } else {
          return portsBuilder_.getMessage(index);
        }
      }
      /** <code>repeated .PortDetail ports = 2;</code> */
      public Builder setPorts(int index, com.cpdss.common.generated.PortInfo.PortDetail value) {
        if (portsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensurePortsIsMutable();
          ports_.set(index, value);
          onChanged();
        } else {
          portsBuilder_.setMessage(index, value);
        }
        return this;
      }
      /** <code>repeated .PortDetail ports = 2;</code> */
      public Builder setPorts(
          int index, com.cpdss.common.generated.PortInfo.PortDetail.Builder builderForValue) {
        if (portsBuilder_ == null) {
          ensurePortsIsMutable();
          ports_.set(index, builderForValue.build());
          onChanged();
        } else {
          portsBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .PortDetail ports = 2;</code> */
      public Builder addPorts(com.cpdss.common.generated.PortInfo.PortDetail value) {
        if (portsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensurePortsIsMutable();
          ports_.add(value);
          onChanged();
        } else {
          portsBuilder_.addMessage(value);
        }
        return this;
      }
      /** <code>repeated .PortDetail ports = 2;</code> */
      public Builder addPorts(int index, com.cpdss.common.generated.PortInfo.PortDetail value) {
        if (portsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensurePortsIsMutable();
          ports_.add(index, value);
          onChanged();
        } else {
          portsBuilder_.addMessage(index, value);
        }
        return this;
      }
      /** <code>repeated .PortDetail ports = 2;</code> */
      public Builder addPorts(
          com.cpdss.common.generated.PortInfo.PortDetail.Builder builderForValue) {
        if (portsBuilder_ == null) {
          ensurePortsIsMutable();
          ports_.add(builderForValue.build());
          onChanged();
        } else {
          portsBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .PortDetail ports = 2;</code> */
      public Builder addPorts(
          int index, com.cpdss.common.generated.PortInfo.PortDetail.Builder builderForValue) {
        if (portsBuilder_ == null) {
          ensurePortsIsMutable();
          ports_.add(index, builderForValue.build());
          onChanged();
        } else {
          portsBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .PortDetail ports = 2;</code> */
      public Builder addAllPorts(
          java.lang.Iterable<? extends com.cpdss.common.generated.PortInfo.PortDetail> values) {
        if (portsBuilder_ == null) {
          ensurePortsIsMutable();
          com.google.protobuf.AbstractMessageLite.Builder.addAll(values, ports_);
          onChanged();
        } else {
          portsBuilder_.addAllMessages(values);
        }
        return this;
      }
      /** <code>repeated .PortDetail ports = 2;</code> */
      public Builder clearPorts() {
        if (portsBuilder_ == null) {
          ports_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
          onChanged();
        } else {
          portsBuilder_.clear();
        }
        return this;
      }
      /** <code>repeated .PortDetail ports = 2;</code> */
      public Builder removePorts(int index) {
        if (portsBuilder_ == null) {
          ensurePortsIsMutable();
          ports_.remove(index);
          onChanged();
        } else {
          portsBuilder_.remove(index);
        }
        return this;
      }
      /** <code>repeated .PortDetail ports = 2;</code> */
      public com.cpdss.common.generated.PortInfo.PortDetail.Builder getPortsBuilder(int index) {
        return getPortsFieldBuilder().getBuilder(index);
      }
      /** <code>repeated .PortDetail ports = 2;</code> */
      public com.cpdss.common.generated.PortInfo.PortDetailOrBuilder getPortsOrBuilder(int index) {
        if (portsBuilder_ == null) {
          return ports_.get(index);
        } else {
          return portsBuilder_.getMessageOrBuilder(index);
        }
      }
      /** <code>repeated .PortDetail ports = 2;</code> */
      public java.util.List<? extends com.cpdss.common.generated.PortInfo.PortDetailOrBuilder>
          getPortsOrBuilderList() {
        if (portsBuilder_ != null) {
          return portsBuilder_.getMessageOrBuilderList();
        } else {
          return java.util.Collections.unmodifiableList(ports_);
        }
      }
      /** <code>repeated .PortDetail ports = 2;</code> */
      public com.cpdss.common.generated.PortInfo.PortDetail.Builder addPortsBuilder() {
        return getPortsFieldBuilder()
            .addBuilder(com.cpdss.common.generated.PortInfo.PortDetail.getDefaultInstance());
      }
      /** <code>repeated .PortDetail ports = 2;</code> */
      public com.cpdss.common.generated.PortInfo.PortDetail.Builder addPortsBuilder(int index) {
        return getPortsFieldBuilder()
            .addBuilder(index, com.cpdss.common.generated.PortInfo.PortDetail.getDefaultInstance());
      }
      /** <code>repeated .PortDetail ports = 2;</code> */
      public java.util.List<com.cpdss.common.generated.PortInfo.PortDetail.Builder>
          getPortsBuilderList() {
        return getPortsFieldBuilder().getBuilderList();
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
              com.cpdss.common.generated.PortInfo.PortDetail,
              com.cpdss.common.generated.PortInfo.PortDetail.Builder,
              com.cpdss.common.generated.PortInfo.PortDetailOrBuilder>
          getPortsFieldBuilder() {
        if (portsBuilder_ == null) {
          portsBuilder_ =
              new com.google.protobuf.RepeatedFieldBuilderV3<
                  com.cpdss.common.generated.PortInfo.PortDetail,
                  com.cpdss.common.generated.PortInfo.PortDetail.Builder,
                  com.cpdss.common.generated.PortInfo.PortDetailOrBuilder>(
                  ports_, ((bitField0_ & 0x00000001) != 0), getParentForChildren(), isClean());
          ports_ = null;
        }
        return portsBuilder_;
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

      // @@protoc_insertion_point(builder_scope:PortReply)
    }

    // @@protoc_insertion_point(class_scope:PortReply)
    private static final com.cpdss.common.generated.PortInfo.PortReply DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.PortInfo.PortReply();
    }

    public static com.cpdss.common.generated.PortInfo.PortReply getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<PortReply> PARSER =
        new com.google.protobuf.AbstractParser<PortReply>() {
          @java.lang.Override
          public PortReply parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new PortReply(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<PortReply> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<PortReply> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.PortInfo.PortReply getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface GetPortInfoByCargoIdRequestOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:GetPortInfoByCargoIdRequest)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int64 cargoId = 1;</code>
     *
     * @return The cargoId.
     */
    long getCargoId();
  }
  /** Protobuf type {@code GetPortInfoByCargoIdRequest} */
  public static final class GetPortInfoByCargoIdRequest
      extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:GetPortInfoByCargoIdRequest)
      GetPortInfoByCargoIdRequestOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use GetPortInfoByCargoIdRequest.newBuilder() to construct.
    private GetPortInfoByCargoIdRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private GetPortInfoByCargoIdRequest() {}

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new GetPortInfoByCargoIdRequest();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private GetPortInfoByCargoIdRequest(
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
                cargoId_ = input.readInt64();
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
      return com.cpdss.common.generated.PortInfo
          .internal_static_GetPortInfoByCargoIdRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.PortInfo
          .internal_static_GetPortInfoByCargoIdRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdRequest.class,
              com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdRequest.Builder.class);
    }

    public static final int CARGOID_FIELD_NUMBER = 1;
    private long cargoId_;
    /**
     * <code>int64 cargoId = 1;</code>
     *
     * @return The cargoId.
     */
    public long getCargoId() {
      return cargoId_;
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
      if (cargoId_ != 0L) {
        output.writeInt64(1, cargoId_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (cargoId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(1, cargoId_);
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
      if (!(obj instanceof com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdRequest)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdRequest other =
          (com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdRequest) obj;

      if (getCargoId() != other.getCargoId()) return false;
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
      hash = (37 * hash) + CARGOID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getCargoId());
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdRequest parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdRequest parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdRequest parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdRequest parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdRequest parseFrom(
        byte[] data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdRequest parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdRequest parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdRequest parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdRequest
        parseDelimitedFrom(java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdRequest
        parseDelimitedFrom(
            java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdRequest parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdRequest parseFrom(
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
        com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdRequest prototype) {
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
    /** Protobuf type {@code GetPortInfoByCargoIdRequest} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:GetPortInfoByCargoIdRequest)
        com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdRequestOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.PortInfo
            .internal_static_GetPortInfoByCargoIdRequest_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.PortInfo
            .internal_static_GetPortInfoByCargoIdRequest_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdRequest.class,
                com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdRequest.Builder.class);
      }

      // Construct using
      // com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdRequest.newBuilder()
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
        cargoId_ = 0L;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.PortInfo
            .internal_static_GetPortInfoByCargoIdRequest_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdRequest
          getDefaultInstanceForType() {
        return com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdRequest.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdRequest build() {
        com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdRequest result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdRequest buildPartial() {
        com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdRequest result =
            new com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdRequest(this);
        result.cargoId_ = cargoId_;
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
        if (other instanceof com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdRequest) {
          return mergeFrom((com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdRequest) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(
          com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdRequest other) {
        if (other
            == com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdRequest.getDefaultInstance())
          return this;
        if (other.getCargoId() != 0L) {
          setCargoId(other.getCargoId());
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
        com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdRequest parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdRequest)
                  e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private long cargoId_;
      /**
       * <code>int64 cargoId = 1;</code>
       *
       * @return The cargoId.
       */
      public long getCargoId() {
        return cargoId_;
      }
      /**
       * <code>int64 cargoId = 1;</code>
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
       * <code>int64 cargoId = 1;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearCargoId() {

        cargoId_ = 0L;
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

      // @@protoc_insertion_point(builder_scope:GetPortInfoByCargoIdRequest)
    }

    // @@protoc_insertion_point(class_scope:GetPortInfoByCargoIdRequest)
    private static final com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdRequest
        DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdRequest();
    }

    public static com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdRequest
        getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<GetPortInfoByCargoIdRequest> PARSER =
        new com.google.protobuf.AbstractParser<GetPortInfoByCargoIdRequest>() {
          @java.lang.Override
          public GetPortInfoByCargoIdRequest parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new GetPortInfoByCargoIdRequest(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<GetPortInfoByCargoIdRequest> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<GetPortInfoByCargoIdRequest> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdRequest
        getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface GetPortInfoByCargoIdReplyOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:GetPortInfoByCargoIdReply)
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

    /** <code>repeated .PortDetail ports = 2;</code> */
    java.util.List<com.cpdss.common.generated.PortInfo.PortDetail> getPortsList();
    /** <code>repeated .PortDetail ports = 2;</code> */
    com.cpdss.common.generated.PortInfo.PortDetail getPorts(int index);
    /** <code>repeated .PortDetail ports = 2;</code> */
    int getPortsCount();
    /** <code>repeated .PortDetail ports = 2;</code> */
    java.util.List<? extends com.cpdss.common.generated.PortInfo.PortDetailOrBuilder>
        getPortsOrBuilderList();
    /** <code>repeated .PortDetail ports = 2;</code> */
    com.cpdss.common.generated.PortInfo.PortDetailOrBuilder getPortsOrBuilder(int index);
  }
  /** Protobuf type {@code GetPortInfoByCargoIdReply} */
  public static final class GetPortInfoByCargoIdReply extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:GetPortInfoByCargoIdReply)
      GetPortInfoByCargoIdReplyOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use GetPortInfoByCargoIdReply.newBuilder() to construct.
    private GetPortInfoByCargoIdReply(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private GetPortInfoByCargoIdReply() {
      ports_ = java.util.Collections.emptyList();
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new GetPortInfoByCargoIdReply();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private GetPortInfoByCargoIdReply(
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
            case 18:
              {
                if (!((mutable_bitField0_ & 0x00000001) != 0)) {
                  ports_ =
                      new java.util.ArrayList<com.cpdss.common.generated.PortInfo.PortDetail>();
                  mutable_bitField0_ |= 0x00000001;
                }
                ports_.add(
                    input.readMessage(
                        com.cpdss.common.generated.PortInfo.PortDetail.parser(),
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
          ports_ = java.util.Collections.unmodifiableList(ports_);
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }

    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.cpdss.common.generated.PortInfo
          .internal_static_GetPortInfoByCargoIdReply_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.PortInfo
          .internal_static_GetPortInfoByCargoIdReply_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdReply.class,
              com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdReply.Builder.class);
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

    public static final int PORTS_FIELD_NUMBER = 2;
    private java.util.List<com.cpdss.common.generated.PortInfo.PortDetail> ports_;
    /** <code>repeated .PortDetail ports = 2;</code> */
    public java.util.List<com.cpdss.common.generated.PortInfo.PortDetail> getPortsList() {
      return ports_;
    }
    /** <code>repeated .PortDetail ports = 2;</code> */
    public java.util.List<? extends com.cpdss.common.generated.PortInfo.PortDetailOrBuilder>
        getPortsOrBuilderList() {
      return ports_;
    }
    /** <code>repeated .PortDetail ports = 2;</code> */
    public int getPortsCount() {
      return ports_.size();
    }
    /** <code>repeated .PortDetail ports = 2;</code> */
    public com.cpdss.common.generated.PortInfo.PortDetail getPorts(int index) {
      return ports_.get(index);
    }
    /** <code>repeated .PortDetail ports = 2;</code> */
    public com.cpdss.common.generated.PortInfo.PortDetailOrBuilder getPortsOrBuilder(int index) {
      return ports_.get(index);
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
      for (int i = 0; i < ports_.size(); i++) {
        output.writeMessage(2, ports_.get(i));
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
      for (int i = 0; i < ports_.size(); i++) {
        size += com.google.protobuf.CodedOutputStream.computeMessageSize(2, ports_.get(i));
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
      if (!(obj instanceof com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdReply)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdReply other =
          (com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdReply) obj;

      if (hasResponseStatus() != other.hasResponseStatus()) return false;
      if (hasResponseStatus()) {
        if (!getResponseStatus().equals(other.getResponseStatus())) return false;
      }
      if (!getPortsList().equals(other.getPortsList())) return false;
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
      if (getPortsCount() > 0) {
        hash = (37 * hash) + PORTS_FIELD_NUMBER;
        hash = (53 * hash) + getPortsList().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdReply parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdReply parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdReply parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdReply parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdReply parseFrom(
        byte[] data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdReply parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdReply parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdReply parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdReply parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdReply parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdReply parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdReply parseFrom(
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
        com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdReply prototype) {
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
    /** Protobuf type {@code GetPortInfoByCargoIdReply} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:GetPortInfoByCargoIdReply)
        com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdReplyOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.PortInfo
            .internal_static_GetPortInfoByCargoIdReply_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.PortInfo
            .internal_static_GetPortInfoByCargoIdReply_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdReply.class,
                com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdReply.Builder.class);
      }

      // Construct using com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdReply.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {
          getPortsFieldBuilder();
        }
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
        if (portsBuilder_ == null) {
          ports_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          portsBuilder_.clear();
        }
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.PortInfo
            .internal_static_GetPortInfoByCargoIdReply_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdReply
          getDefaultInstanceForType() {
        return com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdReply.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdReply build() {
        com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdReply result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdReply buildPartial() {
        com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdReply result =
            new com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdReply(this);
        int from_bitField0_ = bitField0_;
        if (responseStatusBuilder_ == null) {
          result.responseStatus_ = responseStatus_;
        } else {
          result.responseStatus_ = responseStatusBuilder_.build();
        }
        if (portsBuilder_ == null) {
          if (((bitField0_ & 0x00000001) != 0)) {
            ports_ = java.util.Collections.unmodifiableList(ports_);
            bitField0_ = (bitField0_ & ~0x00000001);
          }
          result.ports_ = ports_;
        } else {
          result.ports_ = portsBuilder_.build();
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
        if (other instanceof com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdReply) {
          return mergeFrom((com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdReply) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(
          com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdReply other) {
        if (other
            == com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdReply.getDefaultInstance())
          return this;
        if (other.hasResponseStatus()) {
          mergeResponseStatus(other.getResponseStatus());
        }
        if (portsBuilder_ == null) {
          if (!other.ports_.isEmpty()) {
            if (ports_.isEmpty()) {
              ports_ = other.ports_;
              bitField0_ = (bitField0_ & ~0x00000001);
            } else {
              ensurePortsIsMutable();
              ports_.addAll(other.ports_);
            }
            onChanged();
          }
        } else {
          if (!other.ports_.isEmpty()) {
            if (portsBuilder_.isEmpty()) {
              portsBuilder_.dispose();
              portsBuilder_ = null;
              ports_ = other.ports_;
              bitField0_ = (bitField0_ & ~0x00000001);
              portsBuilder_ =
                  com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
                      ? getPortsFieldBuilder()
                      : null;
            } else {
              portsBuilder_.addAllMessages(other.ports_);
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
        com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdReply parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdReply)
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

      private java.util.List<com.cpdss.common.generated.PortInfo.PortDetail> ports_ =
          java.util.Collections.emptyList();

      private void ensurePortsIsMutable() {
        if (!((bitField0_ & 0x00000001) != 0)) {
          ports_ = new java.util.ArrayList<com.cpdss.common.generated.PortInfo.PortDetail>(ports_);
          bitField0_ |= 0x00000001;
        }
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
              com.cpdss.common.generated.PortInfo.PortDetail,
              com.cpdss.common.generated.PortInfo.PortDetail.Builder,
              com.cpdss.common.generated.PortInfo.PortDetailOrBuilder>
          portsBuilder_;

      /** <code>repeated .PortDetail ports = 2;</code> */
      public java.util.List<com.cpdss.common.generated.PortInfo.PortDetail> getPortsList() {
        if (portsBuilder_ == null) {
          return java.util.Collections.unmodifiableList(ports_);
        } else {
          return portsBuilder_.getMessageList();
        }
      }
      /** <code>repeated .PortDetail ports = 2;</code> */
      public int getPortsCount() {
        if (portsBuilder_ == null) {
          return ports_.size();
        } else {
          return portsBuilder_.getCount();
        }
      }
      /** <code>repeated .PortDetail ports = 2;</code> */
      public com.cpdss.common.generated.PortInfo.PortDetail getPorts(int index) {
        if (portsBuilder_ == null) {
          return ports_.get(index);
        } else {
          return portsBuilder_.getMessage(index);
        }
      }
      /** <code>repeated .PortDetail ports = 2;</code> */
      public Builder setPorts(int index, com.cpdss.common.generated.PortInfo.PortDetail value) {
        if (portsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensurePortsIsMutable();
          ports_.set(index, value);
          onChanged();
        } else {
          portsBuilder_.setMessage(index, value);
        }
        return this;
      }
      /** <code>repeated .PortDetail ports = 2;</code> */
      public Builder setPorts(
          int index, com.cpdss.common.generated.PortInfo.PortDetail.Builder builderForValue) {
        if (portsBuilder_ == null) {
          ensurePortsIsMutable();
          ports_.set(index, builderForValue.build());
          onChanged();
        } else {
          portsBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .PortDetail ports = 2;</code> */
      public Builder addPorts(com.cpdss.common.generated.PortInfo.PortDetail value) {
        if (portsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensurePortsIsMutable();
          ports_.add(value);
          onChanged();
        } else {
          portsBuilder_.addMessage(value);
        }
        return this;
      }
      /** <code>repeated .PortDetail ports = 2;</code> */
      public Builder addPorts(int index, com.cpdss.common.generated.PortInfo.PortDetail value) {
        if (portsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensurePortsIsMutable();
          ports_.add(index, value);
          onChanged();
        } else {
          portsBuilder_.addMessage(index, value);
        }
        return this;
      }
      /** <code>repeated .PortDetail ports = 2;</code> */
      public Builder addPorts(
          com.cpdss.common.generated.PortInfo.PortDetail.Builder builderForValue) {
        if (portsBuilder_ == null) {
          ensurePortsIsMutable();
          ports_.add(builderForValue.build());
          onChanged();
        } else {
          portsBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .PortDetail ports = 2;</code> */
      public Builder addPorts(
          int index, com.cpdss.common.generated.PortInfo.PortDetail.Builder builderForValue) {
        if (portsBuilder_ == null) {
          ensurePortsIsMutable();
          ports_.add(index, builderForValue.build());
          onChanged();
        } else {
          portsBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .PortDetail ports = 2;</code> */
      public Builder addAllPorts(
          java.lang.Iterable<? extends com.cpdss.common.generated.PortInfo.PortDetail> values) {
        if (portsBuilder_ == null) {
          ensurePortsIsMutable();
          com.google.protobuf.AbstractMessageLite.Builder.addAll(values, ports_);
          onChanged();
        } else {
          portsBuilder_.addAllMessages(values);
        }
        return this;
      }
      /** <code>repeated .PortDetail ports = 2;</code> */
      public Builder clearPorts() {
        if (portsBuilder_ == null) {
          ports_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
          onChanged();
        } else {
          portsBuilder_.clear();
        }
        return this;
      }
      /** <code>repeated .PortDetail ports = 2;</code> */
      public Builder removePorts(int index) {
        if (portsBuilder_ == null) {
          ensurePortsIsMutable();
          ports_.remove(index);
          onChanged();
        } else {
          portsBuilder_.remove(index);
        }
        return this;
      }
      /** <code>repeated .PortDetail ports = 2;</code> */
      public com.cpdss.common.generated.PortInfo.PortDetail.Builder getPortsBuilder(int index) {
        return getPortsFieldBuilder().getBuilder(index);
      }
      /** <code>repeated .PortDetail ports = 2;</code> */
      public com.cpdss.common.generated.PortInfo.PortDetailOrBuilder getPortsOrBuilder(int index) {
        if (portsBuilder_ == null) {
          return ports_.get(index);
        } else {
          return portsBuilder_.getMessageOrBuilder(index);
        }
      }
      /** <code>repeated .PortDetail ports = 2;</code> */
      public java.util.List<? extends com.cpdss.common.generated.PortInfo.PortDetailOrBuilder>
          getPortsOrBuilderList() {
        if (portsBuilder_ != null) {
          return portsBuilder_.getMessageOrBuilderList();
        } else {
          return java.util.Collections.unmodifiableList(ports_);
        }
      }
      /** <code>repeated .PortDetail ports = 2;</code> */
      public com.cpdss.common.generated.PortInfo.PortDetail.Builder addPortsBuilder() {
        return getPortsFieldBuilder()
            .addBuilder(com.cpdss.common.generated.PortInfo.PortDetail.getDefaultInstance());
      }
      /** <code>repeated .PortDetail ports = 2;</code> */
      public com.cpdss.common.generated.PortInfo.PortDetail.Builder addPortsBuilder(int index) {
        return getPortsFieldBuilder()
            .addBuilder(index, com.cpdss.common.generated.PortInfo.PortDetail.getDefaultInstance());
      }
      /** <code>repeated .PortDetail ports = 2;</code> */
      public java.util.List<com.cpdss.common.generated.PortInfo.PortDetail.Builder>
          getPortsBuilderList() {
        return getPortsFieldBuilder().getBuilderList();
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
              com.cpdss.common.generated.PortInfo.PortDetail,
              com.cpdss.common.generated.PortInfo.PortDetail.Builder,
              com.cpdss.common.generated.PortInfo.PortDetailOrBuilder>
          getPortsFieldBuilder() {
        if (portsBuilder_ == null) {
          portsBuilder_ =
              new com.google.protobuf.RepeatedFieldBuilderV3<
                  com.cpdss.common.generated.PortInfo.PortDetail,
                  com.cpdss.common.generated.PortInfo.PortDetail.Builder,
                  com.cpdss.common.generated.PortInfo.PortDetailOrBuilder>(
                  ports_, ((bitField0_ & 0x00000001) != 0), getParentForChildren(), isClean());
          ports_ = null;
        }
        return portsBuilder_;
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

      // @@protoc_insertion_point(builder_scope:GetPortInfoByCargoIdReply)
    }

    // @@protoc_insertion_point(class_scope:GetPortInfoByCargoIdReply)
    private static final com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdReply
        DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdReply();
    }

    public static com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdReply
        getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<GetPortInfoByCargoIdReply> PARSER =
        new com.google.protobuf.AbstractParser<GetPortInfoByCargoIdReply>() {
          @java.lang.Override
          public GetPortInfoByCargoIdReply parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new GetPortInfoByCargoIdReply(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<GetPortInfoByCargoIdReply> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<GetPortInfoByCargoIdReply> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.PortInfo.GetPortInfoByCargoIdReply
        getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface PortEmptyRequestOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:PortEmptyRequest)
      com.google.protobuf.MessageOrBuilder {}
  /** Protobuf type {@code PortEmptyRequest} */
  public static final class PortEmptyRequest extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:PortEmptyRequest)
      PortEmptyRequestOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use PortEmptyRequest.newBuilder() to construct.
    private PortEmptyRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private PortEmptyRequest() {}

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new PortEmptyRequest();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private PortEmptyRequest(
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
      return com.cpdss.common.generated.PortInfo.internal_static_PortEmptyRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.PortInfo.internal_static_PortEmptyRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.PortInfo.PortEmptyRequest.class,
              com.cpdss.common.generated.PortInfo.PortEmptyRequest.Builder.class);
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
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
        return true;
      }
      if (!(obj instanceof com.cpdss.common.generated.PortInfo.PortEmptyRequest)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.PortInfo.PortEmptyRequest other =
          (com.cpdss.common.generated.PortInfo.PortEmptyRequest) obj;

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
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.PortInfo.PortEmptyRequest parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.PortInfo.PortEmptyRequest parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.PortEmptyRequest parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.PortInfo.PortEmptyRequest parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.PortEmptyRequest parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.PortInfo.PortEmptyRequest parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.PortEmptyRequest parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.PortInfo.PortEmptyRequest parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.PortEmptyRequest parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.PortInfo.PortEmptyRequest parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.PortEmptyRequest parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.PortInfo.PortEmptyRequest parseFrom(
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
        com.cpdss.common.generated.PortInfo.PortEmptyRequest prototype) {
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
    /** Protobuf type {@code PortEmptyRequest} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:PortEmptyRequest)
        com.cpdss.common.generated.PortInfo.PortEmptyRequestOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.PortInfo.internal_static_PortEmptyRequest_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.PortInfo
            .internal_static_PortEmptyRequest_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.PortInfo.PortEmptyRequest.class,
                com.cpdss.common.generated.PortInfo.PortEmptyRequest.Builder.class);
      }

      // Construct using com.cpdss.common.generated.PortInfo.PortEmptyRequest.newBuilder()
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
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.PortInfo.internal_static_PortEmptyRequest_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.PortInfo.PortEmptyRequest getDefaultInstanceForType() {
        return com.cpdss.common.generated.PortInfo.PortEmptyRequest.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.PortInfo.PortEmptyRequest build() {
        com.cpdss.common.generated.PortInfo.PortEmptyRequest result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.PortInfo.PortEmptyRequest buildPartial() {
        com.cpdss.common.generated.PortInfo.PortEmptyRequest result =
            new com.cpdss.common.generated.PortInfo.PortEmptyRequest(this);
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
        if (other instanceof com.cpdss.common.generated.PortInfo.PortEmptyRequest) {
          return mergeFrom((com.cpdss.common.generated.PortInfo.PortEmptyRequest) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.cpdss.common.generated.PortInfo.PortEmptyRequest other) {
        if (other == com.cpdss.common.generated.PortInfo.PortEmptyRequest.getDefaultInstance())
          return this;
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
        com.cpdss.common.generated.PortInfo.PortEmptyRequest parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.PortInfo.PortEmptyRequest) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
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

      // @@protoc_insertion_point(builder_scope:PortEmptyRequest)
    }

    // @@protoc_insertion_point(class_scope:PortEmptyRequest)
    private static final com.cpdss.common.generated.PortInfo.PortEmptyRequest DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.PortInfo.PortEmptyRequest();
    }

    public static com.cpdss.common.generated.PortInfo.PortEmptyRequest getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<PortEmptyRequest> PARSER =
        new com.google.protobuf.AbstractParser<PortEmptyRequest>() {
          @java.lang.Override
          public PortEmptyRequest parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new PortEmptyRequest(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<PortEmptyRequest> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<PortEmptyRequest> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.PortInfo.PortEmptyRequest getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface TimezoneOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:Timezone)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int64 id = 1;</code>
     *
     * @return The id.
     */
    long getId();

    /**
     * <code>string timezone = 2;</code>
     *
     * @return The timezone.
     */
    java.lang.String getTimezone();
    /**
     * <code>string timezone = 2;</code>
     *
     * @return The bytes for timezone.
     */
    com.google.protobuf.ByteString getTimezoneBytes();

    /**
     * <code>string offsetValue = 3;</code>
     *
     * @return The offsetValue.
     */
    java.lang.String getOffsetValue();
    /**
     * <code>string offsetValue = 3;</code>
     *
     * @return The bytes for offsetValue.
     */
    com.google.protobuf.ByteString getOffsetValueBytes();

    /**
     * <code>string abbreviation = 4;</code>
     *
     * @return The abbreviation.
     */
    java.lang.String getAbbreviation();
    /**
     * <code>string abbreviation = 4;</code>
     *
     * @return The bytes for abbreviation.
     */
    com.google.protobuf.ByteString getAbbreviationBytes();
  }
  /** Protobuf type {@code Timezone} */
  public static final class Timezone extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:Timezone)
      TimezoneOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use Timezone.newBuilder() to construct.
    private Timezone(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private Timezone() {
      timezone_ = "";
      offsetValue_ = "";
      abbreviation_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new Timezone();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private Timezone(
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

                timezone_ = s;
                break;
              }
            case 26:
              {
                java.lang.String s = input.readStringRequireUtf8();

                offsetValue_ = s;
                break;
              }
            case 34:
              {
                java.lang.String s = input.readStringRequireUtf8();

                abbreviation_ = s;
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
      return com.cpdss.common.generated.PortInfo.internal_static_Timezone_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.PortInfo.internal_static_Timezone_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.PortInfo.Timezone.class,
              com.cpdss.common.generated.PortInfo.Timezone.Builder.class);
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

    public static final int TIMEZONE_FIELD_NUMBER = 2;
    private volatile java.lang.Object timezone_;
    /**
     * <code>string timezone = 2;</code>
     *
     * @return The timezone.
     */
    public java.lang.String getTimezone() {
      java.lang.Object ref = timezone_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        timezone_ = s;
        return s;
      }
    }
    /**
     * <code>string timezone = 2;</code>
     *
     * @return The bytes for timezone.
     */
    public com.google.protobuf.ByteString getTimezoneBytes() {
      java.lang.Object ref = timezone_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        timezone_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int OFFSETVALUE_FIELD_NUMBER = 3;
    private volatile java.lang.Object offsetValue_;
    /**
     * <code>string offsetValue = 3;</code>
     *
     * @return The offsetValue.
     */
    public java.lang.String getOffsetValue() {
      java.lang.Object ref = offsetValue_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        offsetValue_ = s;
        return s;
      }
    }
    /**
     * <code>string offsetValue = 3;</code>
     *
     * @return The bytes for offsetValue.
     */
    public com.google.protobuf.ByteString getOffsetValueBytes() {
      java.lang.Object ref = offsetValue_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        offsetValue_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int ABBREVIATION_FIELD_NUMBER = 4;
    private volatile java.lang.Object abbreviation_;
    /**
     * <code>string abbreviation = 4;</code>
     *
     * @return The abbreviation.
     */
    public java.lang.String getAbbreviation() {
      java.lang.Object ref = abbreviation_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        abbreviation_ = s;
        return s;
      }
    }
    /**
     * <code>string abbreviation = 4;</code>
     *
     * @return The bytes for abbreviation.
     */
    public com.google.protobuf.ByteString getAbbreviationBytes() {
      java.lang.Object ref = abbreviation_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        abbreviation_ = b;
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
      if (!getTimezoneBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, timezone_);
      }
      if (!getOffsetValueBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, offsetValue_);
      }
      if (!getAbbreviationBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 4, abbreviation_);
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
      if (!getTimezoneBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, timezone_);
      }
      if (!getOffsetValueBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, offsetValue_);
      }
      if (!getAbbreviationBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, abbreviation_);
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
      if (!(obj instanceof com.cpdss.common.generated.PortInfo.Timezone)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.PortInfo.Timezone other =
          (com.cpdss.common.generated.PortInfo.Timezone) obj;

      if (getId() != other.getId()) return false;
      if (!getTimezone().equals(other.getTimezone())) return false;
      if (!getOffsetValue().equals(other.getOffsetValue())) return false;
      if (!getAbbreviation().equals(other.getAbbreviation())) return false;
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
      hash = (37 * hash) + TIMEZONE_FIELD_NUMBER;
      hash = (53 * hash) + getTimezone().hashCode();
      hash = (37 * hash) + OFFSETVALUE_FIELD_NUMBER;
      hash = (53 * hash) + getOffsetValue().hashCode();
      hash = (37 * hash) + ABBREVIATION_FIELD_NUMBER;
      hash = (53 * hash) + getAbbreviation().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.PortInfo.Timezone parseFrom(java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.PortInfo.Timezone parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.Timezone parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.PortInfo.Timezone parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.Timezone parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.PortInfo.Timezone parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.Timezone parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.PortInfo.Timezone parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.Timezone parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.PortInfo.Timezone parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.Timezone parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.PortInfo.Timezone parseFrom(
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

    public static Builder newBuilder(com.cpdss.common.generated.PortInfo.Timezone prototype) {
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
    /** Protobuf type {@code Timezone} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:Timezone)
        com.cpdss.common.generated.PortInfo.TimezoneOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.PortInfo.internal_static_Timezone_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.PortInfo.internal_static_Timezone_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.PortInfo.Timezone.class,
                com.cpdss.common.generated.PortInfo.Timezone.Builder.class);
      }

      // Construct using com.cpdss.common.generated.PortInfo.Timezone.newBuilder()
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

        timezone_ = "";

        offsetValue_ = "";

        abbreviation_ = "";

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.PortInfo.internal_static_Timezone_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.PortInfo.Timezone getDefaultInstanceForType() {
        return com.cpdss.common.generated.PortInfo.Timezone.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.PortInfo.Timezone build() {
        com.cpdss.common.generated.PortInfo.Timezone result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.PortInfo.Timezone buildPartial() {
        com.cpdss.common.generated.PortInfo.Timezone result =
            new com.cpdss.common.generated.PortInfo.Timezone(this);
        result.id_ = id_;
        result.timezone_ = timezone_;
        result.offsetValue_ = offsetValue_;
        result.abbreviation_ = abbreviation_;
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
        if (other instanceof com.cpdss.common.generated.PortInfo.Timezone) {
          return mergeFrom((com.cpdss.common.generated.PortInfo.Timezone) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.cpdss.common.generated.PortInfo.Timezone other) {
        if (other == com.cpdss.common.generated.PortInfo.Timezone.getDefaultInstance()) return this;
        if (other.getId() != 0L) {
          setId(other.getId());
        }
        if (!other.getTimezone().isEmpty()) {
          timezone_ = other.timezone_;
          onChanged();
        }
        if (!other.getOffsetValue().isEmpty()) {
          offsetValue_ = other.offsetValue_;
          onChanged();
        }
        if (!other.getAbbreviation().isEmpty()) {
          abbreviation_ = other.abbreviation_;
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
        com.cpdss.common.generated.PortInfo.Timezone parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.cpdss.common.generated.PortInfo.Timezone) e.getUnfinishedMessage();
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

      private java.lang.Object timezone_ = "";
      /**
       * <code>string timezone = 2;</code>
       *
       * @return The timezone.
       */
      public java.lang.String getTimezone() {
        java.lang.Object ref = timezone_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          timezone_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string timezone = 2;</code>
       *
       * @return The bytes for timezone.
       */
      public com.google.protobuf.ByteString getTimezoneBytes() {
        java.lang.Object ref = timezone_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          timezone_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string timezone = 2;</code>
       *
       * @param value The timezone to set.
       * @return This builder for chaining.
       */
      public Builder setTimezone(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        timezone_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string timezone = 2;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearTimezone() {

        timezone_ = getDefaultInstance().getTimezone();
        onChanged();
        return this;
      }
      /**
       * <code>string timezone = 2;</code>
       *
       * @param value The bytes for timezone to set.
       * @return This builder for chaining.
       */
      public Builder setTimezoneBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        timezone_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object offsetValue_ = "";
      /**
       * <code>string offsetValue = 3;</code>
       *
       * @return The offsetValue.
       */
      public java.lang.String getOffsetValue() {
        java.lang.Object ref = offsetValue_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          offsetValue_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string offsetValue = 3;</code>
       *
       * @return The bytes for offsetValue.
       */
      public com.google.protobuf.ByteString getOffsetValueBytes() {
        java.lang.Object ref = offsetValue_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          offsetValue_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string offsetValue = 3;</code>
       *
       * @param value The offsetValue to set.
       * @return This builder for chaining.
       */
      public Builder setOffsetValue(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        offsetValue_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string offsetValue = 3;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearOffsetValue() {

        offsetValue_ = getDefaultInstance().getOffsetValue();
        onChanged();
        return this;
      }
      /**
       * <code>string offsetValue = 3;</code>
       *
       * @param value The bytes for offsetValue to set.
       * @return This builder for chaining.
       */
      public Builder setOffsetValueBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        offsetValue_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object abbreviation_ = "";
      /**
       * <code>string abbreviation = 4;</code>
       *
       * @return The abbreviation.
       */
      public java.lang.String getAbbreviation() {
        java.lang.Object ref = abbreviation_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          abbreviation_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string abbreviation = 4;</code>
       *
       * @return The bytes for abbreviation.
       */
      public com.google.protobuf.ByteString getAbbreviationBytes() {
        java.lang.Object ref = abbreviation_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          abbreviation_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string abbreviation = 4;</code>
       *
       * @param value The abbreviation to set.
       * @return This builder for chaining.
       */
      public Builder setAbbreviation(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        abbreviation_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string abbreviation = 4;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearAbbreviation() {

        abbreviation_ = getDefaultInstance().getAbbreviation();
        onChanged();
        return this;
      }
      /**
       * <code>string abbreviation = 4;</code>
       *
       * @param value The bytes for abbreviation to set.
       * @return This builder for chaining.
       */
      public Builder setAbbreviationBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        abbreviation_ = value;
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

      // @@protoc_insertion_point(builder_scope:Timezone)
    }

    // @@protoc_insertion_point(class_scope:Timezone)
    private static final com.cpdss.common.generated.PortInfo.Timezone DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.PortInfo.Timezone();
    }

    public static com.cpdss.common.generated.PortInfo.Timezone getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Timezone> PARSER =
        new com.google.protobuf.AbstractParser<Timezone>() {
          @java.lang.Override
          public Timezone parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new Timezone(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<Timezone> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<Timezone> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.PortInfo.Timezone getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface TimezoneResponseOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:TimezoneResponse)
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

    /** <code>repeated .Timezone timezones = 2;</code> */
    java.util.List<com.cpdss.common.generated.PortInfo.Timezone> getTimezonesList();
    /** <code>repeated .Timezone timezones = 2;</code> */
    com.cpdss.common.generated.PortInfo.Timezone getTimezones(int index);
    /** <code>repeated .Timezone timezones = 2;</code> */
    int getTimezonesCount();
    /** <code>repeated .Timezone timezones = 2;</code> */
    java.util.List<? extends com.cpdss.common.generated.PortInfo.TimezoneOrBuilder>
        getTimezonesOrBuilderList();
    /** <code>repeated .Timezone timezones = 2;</code> */
    com.cpdss.common.generated.PortInfo.TimezoneOrBuilder getTimezonesOrBuilder(int index);
  }
  /** Protobuf type {@code TimezoneResponse} */
  public static final class TimezoneResponse extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:TimezoneResponse)
      TimezoneResponseOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use TimezoneResponse.newBuilder() to construct.
    private TimezoneResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private TimezoneResponse() {
      timezones_ = java.util.Collections.emptyList();
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new TimezoneResponse();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private TimezoneResponse(
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
            case 18:
              {
                if (!((mutable_bitField0_ & 0x00000001) != 0)) {
                  timezones_ =
                      new java.util.ArrayList<com.cpdss.common.generated.PortInfo.Timezone>();
                  mutable_bitField0_ |= 0x00000001;
                }
                timezones_.add(
                    input.readMessage(
                        com.cpdss.common.generated.PortInfo.Timezone.parser(), extensionRegistry));
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
          timezones_ = java.util.Collections.unmodifiableList(timezones_);
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }

    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.cpdss.common.generated.PortInfo.internal_static_TimezoneResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.PortInfo.internal_static_TimezoneResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.PortInfo.TimezoneResponse.class,
              com.cpdss.common.generated.PortInfo.TimezoneResponse.Builder.class);
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

    public static final int TIMEZONES_FIELD_NUMBER = 2;
    private java.util.List<com.cpdss.common.generated.PortInfo.Timezone> timezones_;
    /** <code>repeated .Timezone timezones = 2;</code> */
    public java.util.List<com.cpdss.common.generated.PortInfo.Timezone> getTimezonesList() {
      return timezones_;
    }
    /** <code>repeated .Timezone timezones = 2;</code> */
    public java.util.List<? extends com.cpdss.common.generated.PortInfo.TimezoneOrBuilder>
        getTimezonesOrBuilderList() {
      return timezones_;
    }
    /** <code>repeated .Timezone timezones = 2;</code> */
    public int getTimezonesCount() {
      return timezones_.size();
    }
    /** <code>repeated .Timezone timezones = 2;</code> */
    public com.cpdss.common.generated.PortInfo.Timezone getTimezones(int index) {
      return timezones_.get(index);
    }
    /** <code>repeated .Timezone timezones = 2;</code> */
    public com.cpdss.common.generated.PortInfo.TimezoneOrBuilder getTimezonesOrBuilder(int index) {
      return timezones_.get(index);
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
      for (int i = 0; i < timezones_.size(); i++) {
        output.writeMessage(2, timezones_.get(i));
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
      for (int i = 0; i < timezones_.size(); i++) {
        size += com.google.protobuf.CodedOutputStream.computeMessageSize(2, timezones_.get(i));
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
      if (!(obj instanceof com.cpdss.common.generated.PortInfo.TimezoneResponse)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.PortInfo.TimezoneResponse other =
          (com.cpdss.common.generated.PortInfo.TimezoneResponse) obj;

      if (hasResponseStatus() != other.hasResponseStatus()) return false;
      if (hasResponseStatus()) {
        if (!getResponseStatus().equals(other.getResponseStatus())) return false;
      }
      if (!getTimezonesList().equals(other.getTimezonesList())) return false;
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
      if (getTimezonesCount() > 0) {
        hash = (37 * hash) + TIMEZONES_FIELD_NUMBER;
        hash = (53 * hash) + getTimezonesList().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.PortInfo.TimezoneResponse parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.PortInfo.TimezoneResponse parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.TimezoneResponse parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.PortInfo.TimezoneResponse parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.TimezoneResponse parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.PortInfo.TimezoneResponse parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.TimezoneResponse parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.PortInfo.TimezoneResponse parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.TimezoneResponse parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.PortInfo.TimezoneResponse parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.TimezoneResponse parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.PortInfo.TimezoneResponse parseFrom(
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
        com.cpdss.common.generated.PortInfo.TimezoneResponse prototype) {
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
    /** Protobuf type {@code TimezoneResponse} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:TimezoneResponse)
        com.cpdss.common.generated.PortInfo.TimezoneResponseOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.PortInfo.internal_static_TimezoneResponse_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.PortInfo
            .internal_static_TimezoneResponse_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.PortInfo.TimezoneResponse.class,
                com.cpdss.common.generated.PortInfo.TimezoneResponse.Builder.class);
      }

      // Construct using com.cpdss.common.generated.PortInfo.TimezoneResponse.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {
          getTimezonesFieldBuilder();
        }
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
        if (timezonesBuilder_ == null) {
          timezones_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          timezonesBuilder_.clear();
        }
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.PortInfo.internal_static_TimezoneResponse_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.PortInfo.TimezoneResponse getDefaultInstanceForType() {
        return com.cpdss.common.generated.PortInfo.TimezoneResponse.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.PortInfo.TimezoneResponse build() {
        com.cpdss.common.generated.PortInfo.TimezoneResponse result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.PortInfo.TimezoneResponse buildPartial() {
        com.cpdss.common.generated.PortInfo.TimezoneResponse result =
            new com.cpdss.common.generated.PortInfo.TimezoneResponse(this);
        int from_bitField0_ = bitField0_;
        if (responseStatusBuilder_ == null) {
          result.responseStatus_ = responseStatus_;
        } else {
          result.responseStatus_ = responseStatusBuilder_.build();
        }
        if (timezonesBuilder_ == null) {
          if (((bitField0_ & 0x00000001) != 0)) {
            timezones_ = java.util.Collections.unmodifiableList(timezones_);
            bitField0_ = (bitField0_ & ~0x00000001);
          }
          result.timezones_ = timezones_;
        } else {
          result.timezones_ = timezonesBuilder_.build();
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
        if (other instanceof com.cpdss.common.generated.PortInfo.TimezoneResponse) {
          return mergeFrom((com.cpdss.common.generated.PortInfo.TimezoneResponse) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.cpdss.common.generated.PortInfo.TimezoneResponse other) {
        if (other == com.cpdss.common.generated.PortInfo.TimezoneResponse.getDefaultInstance())
          return this;
        if (other.hasResponseStatus()) {
          mergeResponseStatus(other.getResponseStatus());
        }
        if (timezonesBuilder_ == null) {
          if (!other.timezones_.isEmpty()) {
            if (timezones_.isEmpty()) {
              timezones_ = other.timezones_;
              bitField0_ = (bitField0_ & ~0x00000001);
            } else {
              ensureTimezonesIsMutable();
              timezones_.addAll(other.timezones_);
            }
            onChanged();
          }
        } else {
          if (!other.timezones_.isEmpty()) {
            if (timezonesBuilder_.isEmpty()) {
              timezonesBuilder_.dispose();
              timezonesBuilder_ = null;
              timezones_ = other.timezones_;
              bitField0_ = (bitField0_ & ~0x00000001);
              timezonesBuilder_ =
                  com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
                      ? getTimezonesFieldBuilder()
                      : null;
            } else {
              timezonesBuilder_.addAllMessages(other.timezones_);
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
        com.cpdss.common.generated.PortInfo.TimezoneResponse parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.PortInfo.TimezoneResponse) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private int bitField0_;

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

      private java.util.List<com.cpdss.common.generated.PortInfo.Timezone> timezones_ =
          java.util.Collections.emptyList();

      private void ensureTimezonesIsMutable() {
        if (!((bitField0_ & 0x00000001) != 0)) {
          timezones_ =
              new java.util.ArrayList<com.cpdss.common.generated.PortInfo.Timezone>(timezones_);
          bitField0_ |= 0x00000001;
        }
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
              com.cpdss.common.generated.PortInfo.Timezone,
              com.cpdss.common.generated.PortInfo.Timezone.Builder,
              com.cpdss.common.generated.PortInfo.TimezoneOrBuilder>
          timezonesBuilder_;

      /** <code>repeated .Timezone timezones = 2;</code> */
      public java.util.List<com.cpdss.common.generated.PortInfo.Timezone> getTimezonesList() {
        if (timezonesBuilder_ == null) {
          return java.util.Collections.unmodifiableList(timezones_);
        } else {
          return timezonesBuilder_.getMessageList();
        }
      }
      /** <code>repeated .Timezone timezones = 2;</code> */
      public int getTimezonesCount() {
        if (timezonesBuilder_ == null) {
          return timezones_.size();
        } else {
          return timezonesBuilder_.getCount();
        }
      }
      /** <code>repeated .Timezone timezones = 2;</code> */
      public com.cpdss.common.generated.PortInfo.Timezone getTimezones(int index) {
        if (timezonesBuilder_ == null) {
          return timezones_.get(index);
        } else {
          return timezonesBuilder_.getMessage(index);
        }
      }
      /** <code>repeated .Timezone timezones = 2;</code> */
      public Builder setTimezones(int index, com.cpdss.common.generated.PortInfo.Timezone value) {
        if (timezonesBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureTimezonesIsMutable();
          timezones_.set(index, value);
          onChanged();
        } else {
          timezonesBuilder_.setMessage(index, value);
        }
        return this;
      }
      /** <code>repeated .Timezone timezones = 2;</code> */
      public Builder setTimezones(
          int index, com.cpdss.common.generated.PortInfo.Timezone.Builder builderForValue) {
        if (timezonesBuilder_ == null) {
          ensureTimezonesIsMutable();
          timezones_.set(index, builderForValue.build());
          onChanged();
        } else {
          timezonesBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .Timezone timezones = 2;</code> */
      public Builder addTimezones(com.cpdss.common.generated.PortInfo.Timezone value) {
        if (timezonesBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureTimezonesIsMutable();
          timezones_.add(value);
          onChanged();
        } else {
          timezonesBuilder_.addMessage(value);
        }
        return this;
      }
      /** <code>repeated .Timezone timezones = 2;</code> */
      public Builder addTimezones(int index, com.cpdss.common.generated.PortInfo.Timezone value) {
        if (timezonesBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureTimezonesIsMutable();
          timezones_.add(index, value);
          onChanged();
        } else {
          timezonesBuilder_.addMessage(index, value);
        }
        return this;
      }
      /** <code>repeated .Timezone timezones = 2;</code> */
      public Builder addTimezones(
          com.cpdss.common.generated.PortInfo.Timezone.Builder builderForValue) {
        if (timezonesBuilder_ == null) {
          ensureTimezonesIsMutable();
          timezones_.add(builderForValue.build());
          onChanged();
        } else {
          timezonesBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .Timezone timezones = 2;</code> */
      public Builder addTimezones(
          int index, com.cpdss.common.generated.PortInfo.Timezone.Builder builderForValue) {
        if (timezonesBuilder_ == null) {
          ensureTimezonesIsMutable();
          timezones_.add(index, builderForValue.build());
          onChanged();
        } else {
          timezonesBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .Timezone timezones = 2;</code> */
      public Builder addAllTimezones(
          java.lang.Iterable<? extends com.cpdss.common.generated.PortInfo.Timezone> values) {
        if (timezonesBuilder_ == null) {
          ensureTimezonesIsMutable();
          com.google.protobuf.AbstractMessageLite.Builder.addAll(values, timezones_);
          onChanged();
        } else {
          timezonesBuilder_.addAllMessages(values);
        }
        return this;
      }
      /** <code>repeated .Timezone timezones = 2;</code> */
      public Builder clearTimezones() {
        if (timezonesBuilder_ == null) {
          timezones_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
          onChanged();
        } else {
          timezonesBuilder_.clear();
        }
        return this;
      }
      /** <code>repeated .Timezone timezones = 2;</code> */
      public Builder removeTimezones(int index) {
        if (timezonesBuilder_ == null) {
          ensureTimezonesIsMutable();
          timezones_.remove(index);
          onChanged();
        } else {
          timezonesBuilder_.remove(index);
        }
        return this;
      }
      /** <code>repeated .Timezone timezones = 2;</code> */
      public com.cpdss.common.generated.PortInfo.Timezone.Builder getTimezonesBuilder(int index) {
        return getTimezonesFieldBuilder().getBuilder(index);
      }
      /** <code>repeated .Timezone timezones = 2;</code> */
      public com.cpdss.common.generated.PortInfo.TimezoneOrBuilder getTimezonesOrBuilder(
          int index) {
        if (timezonesBuilder_ == null) {
          return timezones_.get(index);
        } else {
          return timezonesBuilder_.getMessageOrBuilder(index);
        }
      }
      /** <code>repeated .Timezone timezones = 2;</code> */
      public java.util.List<? extends com.cpdss.common.generated.PortInfo.TimezoneOrBuilder>
          getTimezonesOrBuilderList() {
        if (timezonesBuilder_ != null) {
          return timezonesBuilder_.getMessageOrBuilderList();
        } else {
          return java.util.Collections.unmodifiableList(timezones_);
        }
      }
      /** <code>repeated .Timezone timezones = 2;</code> */
      public com.cpdss.common.generated.PortInfo.Timezone.Builder addTimezonesBuilder() {
        return getTimezonesFieldBuilder()
            .addBuilder(com.cpdss.common.generated.PortInfo.Timezone.getDefaultInstance());
      }
      /** <code>repeated .Timezone timezones = 2;</code> */
      public com.cpdss.common.generated.PortInfo.Timezone.Builder addTimezonesBuilder(int index) {
        return getTimezonesFieldBuilder()
            .addBuilder(index, com.cpdss.common.generated.PortInfo.Timezone.getDefaultInstance());
      }
      /** <code>repeated .Timezone timezones = 2;</code> */
      public java.util.List<com.cpdss.common.generated.PortInfo.Timezone.Builder>
          getTimezonesBuilderList() {
        return getTimezonesFieldBuilder().getBuilderList();
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
              com.cpdss.common.generated.PortInfo.Timezone,
              com.cpdss.common.generated.PortInfo.Timezone.Builder,
              com.cpdss.common.generated.PortInfo.TimezoneOrBuilder>
          getTimezonesFieldBuilder() {
        if (timezonesBuilder_ == null) {
          timezonesBuilder_ =
              new com.google.protobuf.RepeatedFieldBuilderV3<
                  com.cpdss.common.generated.PortInfo.Timezone,
                  com.cpdss.common.generated.PortInfo.Timezone.Builder,
                  com.cpdss.common.generated.PortInfo.TimezoneOrBuilder>(
                  timezones_, ((bitField0_ & 0x00000001) != 0), getParentForChildren(), isClean());
          timezones_ = null;
        }
        return timezonesBuilder_;
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

      // @@protoc_insertion_point(builder_scope:TimezoneResponse)
    }

    // @@protoc_insertion_point(class_scope:TimezoneResponse)
    private static final com.cpdss.common.generated.PortInfo.TimezoneResponse DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.PortInfo.TimezoneResponse();
    }

    public static com.cpdss.common.generated.PortInfo.TimezoneResponse getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<TimezoneResponse> PARSER =
        new com.google.protobuf.AbstractParser<TimezoneResponse>() {
          @java.lang.Override
          public TimezoneResponse parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new TimezoneResponse(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<TimezoneResponse> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<TimezoneResponse> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.PortInfo.TimezoneResponse getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface PortIdRequestOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:PortIdRequest)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int64 portId = 1;</code>
     *
     * @return The portId.
     */
    long getPortId();
  }
  /** Protobuf type {@code PortIdRequest} */
  public static final class PortIdRequest extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:PortIdRequest)
      PortIdRequestOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use PortIdRequest.newBuilder() to construct.
    private PortIdRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private PortIdRequest() {}

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new PortIdRequest();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private PortIdRequest(
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
      return com.cpdss.common.generated.PortInfo.internal_static_PortIdRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.PortInfo.internal_static_PortIdRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.PortInfo.PortIdRequest.class,
              com.cpdss.common.generated.PortInfo.PortIdRequest.Builder.class);
    }

    public static final int PORTID_FIELD_NUMBER = 1;
    private long portId_;
    /**
     * <code>int64 portId = 1;</code>
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
      if (portId_ != 0L) {
        output.writeInt64(1, portId_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (portId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(1, portId_);
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
      if (!(obj instanceof com.cpdss.common.generated.PortInfo.PortIdRequest)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.PortInfo.PortIdRequest other =
          (com.cpdss.common.generated.PortInfo.PortIdRequest) obj;

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
      hash = (37 * hash) + PORTID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getPortId());
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.PortInfo.PortIdRequest parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.PortInfo.PortIdRequest parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.PortIdRequest parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.PortInfo.PortIdRequest parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.PortIdRequest parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.PortInfo.PortIdRequest parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.PortIdRequest parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.PortInfo.PortIdRequest parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.PortIdRequest parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.PortInfo.PortIdRequest parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.PortIdRequest parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.PortInfo.PortIdRequest parseFrom(
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

    public static Builder newBuilder(com.cpdss.common.generated.PortInfo.PortIdRequest prototype) {
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
    /** Protobuf type {@code PortIdRequest} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:PortIdRequest)
        com.cpdss.common.generated.PortInfo.PortIdRequestOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.PortInfo.internal_static_PortIdRequest_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.PortInfo.internal_static_PortIdRequest_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.PortInfo.PortIdRequest.class,
                com.cpdss.common.generated.PortInfo.PortIdRequest.Builder.class);
      }

      // Construct using com.cpdss.common.generated.PortInfo.PortIdRequest.newBuilder()
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
        portId_ = 0L;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.PortInfo.internal_static_PortIdRequest_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.PortInfo.PortIdRequest getDefaultInstanceForType() {
        return com.cpdss.common.generated.PortInfo.PortIdRequest.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.PortInfo.PortIdRequest build() {
        com.cpdss.common.generated.PortInfo.PortIdRequest result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.PortInfo.PortIdRequest buildPartial() {
        com.cpdss.common.generated.PortInfo.PortIdRequest result =
            new com.cpdss.common.generated.PortInfo.PortIdRequest(this);
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
        if (other instanceof com.cpdss.common.generated.PortInfo.PortIdRequest) {
          return mergeFrom((com.cpdss.common.generated.PortInfo.PortIdRequest) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.cpdss.common.generated.PortInfo.PortIdRequest other) {
        if (other == com.cpdss.common.generated.PortInfo.PortIdRequest.getDefaultInstance())
          return this;
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
        com.cpdss.common.generated.PortInfo.PortIdRequest parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.PortInfo.PortIdRequest) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private long portId_;
      /**
       * <code>int64 portId = 1;</code>
       *
       * @return The portId.
       */
      public long getPortId() {
        return portId_;
      }
      /**
       * <code>int64 portId = 1;</code>
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
       * <code>int64 portId = 1;</code>
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

      // @@protoc_insertion_point(builder_scope:PortIdRequest)
    }

    // @@protoc_insertion_point(class_scope:PortIdRequest)
    private static final com.cpdss.common.generated.PortInfo.PortIdRequest DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.PortInfo.PortIdRequest();
    }

    public static com.cpdss.common.generated.PortInfo.PortIdRequest getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<PortIdRequest> PARSER =
        new com.google.protobuf.AbstractParser<PortIdRequest>() {
          @java.lang.Override
          public PortIdRequest parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new PortIdRequest(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<PortIdRequest> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<PortIdRequest> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.PortInfo.PortIdRequest getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface BerthInfoResponseOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:BerthInfoResponse)
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

    /** <code>repeated .BerthDetail berths = 2;</code> */
    java.util.List<com.cpdss.common.generated.PortInfo.BerthDetail> getBerthsList();
    /** <code>repeated .BerthDetail berths = 2;</code> */
    com.cpdss.common.generated.PortInfo.BerthDetail getBerths(int index);
    /** <code>repeated .BerthDetail berths = 2;</code> */
    int getBerthsCount();
    /** <code>repeated .BerthDetail berths = 2;</code> */
    java.util.List<? extends com.cpdss.common.generated.PortInfo.BerthDetailOrBuilder>
        getBerthsOrBuilderList();
    /** <code>repeated .BerthDetail berths = 2;</code> */
    com.cpdss.common.generated.PortInfo.BerthDetailOrBuilder getBerthsOrBuilder(int index);
  }
  /** Protobuf type {@code BerthInfoResponse} */
  public static final class BerthInfoResponse extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:BerthInfoResponse)
      BerthInfoResponseOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use BerthInfoResponse.newBuilder() to construct.
    private BerthInfoResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private BerthInfoResponse() {
      berths_ = java.util.Collections.emptyList();
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new BerthInfoResponse();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private BerthInfoResponse(
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
            case 18:
              {
                if (!((mutable_bitField0_ & 0x00000001) != 0)) {
                  berths_ =
                      new java.util.ArrayList<com.cpdss.common.generated.PortInfo.BerthDetail>();
                  mutable_bitField0_ |= 0x00000001;
                }
                berths_.add(
                    input.readMessage(
                        com.cpdss.common.generated.PortInfo.BerthDetail.parser(),
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
          berths_ = java.util.Collections.unmodifiableList(berths_);
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }

    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.cpdss.common.generated.PortInfo.internal_static_BerthInfoResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.PortInfo
          .internal_static_BerthInfoResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.PortInfo.BerthInfoResponse.class,
              com.cpdss.common.generated.PortInfo.BerthInfoResponse.Builder.class);
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

    public static final int BERTHS_FIELD_NUMBER = 2;
    private java.util.List<com.cpdss.common.generated.PortInfo.BerthDetail> berths_;
    /** <code>repeated .BerthDetail berths = 2;</code> */
    public java.util.List<com.cpdss.common.generated.PortInfo.BerthDetail> getBerthsList() {
      return berths_;
    }
    /** <code>repeated .BerthDetail berths = 2;</code> */
    public java.util.List<? extends com.cpdss.common.generated.PortInfo.BerthDetailOrBuilder>
        getBerthsOrBuilderList() {
      return berths_;
    }
    /** <code>repeated .BerthDetail berths = 2;</code> */
    public int getBerthsCount() {
      return berths_.size();
    }
    /** <code>repeated .BerthDetail berths = 2;</code> */
    public com.cpdss.common.generated.PortInfo.BerthDetail getBerths(int index) {
      return berths_.get(index);
    }
    /** <code>repeated .BerthDetail berths = 2;</code> */
    public com.cpdss.common.generated.PortInfo.BerthDetailOrBuilder getBerthsOrBuilder(int index) {
      return berths_.get(index);
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
      for (int i = 0; i < berths_.size(); i++) {
        output.writeMessage(2, berths_.get(i));
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
      for (int i = 0; i < berths_.size(); i++) {
        size += com.google.protobuf.CodedOutputStream.computeMessageSize(2, berths_.get(i));
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
      if (!(obj instanceof com.cpdss.common.generated.PortInfo.BerthInfoResponse)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.PortInfo.BerthInfoResponse other =
          (com.cpdss.common.generated.PortInfo.BerthInfoResponse) obj;

      if (hasResponseStatus() != other.hasResponseStatus()) return false;
      if (hasResponseStatus()) {
        if (!getResponseStatus().equals(other.getResponseStatus())) return false;
      }
      if (!getBerthsList().equals(other.getBerthsList())) return false;
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
      if (getBerthsCount() > 0) {
        hash = (37 * hash) + BERTHS_FIELD_NUMBER;
        hash = (53 * hash) + getBerthsList().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.PortInfo.BerthInfoResponse parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.PortInfo.BerthInfoResponse parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.BerthInfoResponse parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.PortInfo.BerthInfoResponse parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.BerthInfoResponse parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.PortInfo.BerthInfoResponse parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.BerthInfoResponse parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.PortInfo.BerthInfoResponse parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.BerthInfoResponse parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.PortInfo.BerthInfoResponse parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.BerthInfoResponse parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.PortInfo.BerthInfoResponse parseFrom(
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
        com.cpdss.common.generated.PortInfo.BerthInfoResponse prototype) {
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
    /** Protobuf type {@code BerthInfoResponse} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:BerthInfoResponse)
        com.cpdss.common.generated.PortInfo.BerthInfoResponseOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.PortInfo.internal_static_BerthInfoResponse_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.PortInfo
            .internal_static_BerthInfoResponse_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.PortInfo.BerthInfoResponse.class,
                com.cpdss.common.generated.PortInfo.BerthInfoResponse.Builder.class);
      }

      // Construct using com.cpdss.common.generated.PortInfo.BerthInfoResponse.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {
          getBerthsFieldBuilder();
        }
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
        if (berthsBuilder_ == null) {
          berths_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          berthsBuilder_.clear();
        }
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.PortInfo.internal_static_BerthInfoResponse_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.PortInfo.BerthInfoResponse getDefaultInstanceForType() {
        return com.cpdss.common.generated.PortInfo.BerthInfoResponse.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.PortInfo.BerthInfoResponse build() {
        com.cpdss.common.generated.PortInfo.BerthInfoResponse result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.PortInfo.BerthInfoResponse buildPartial() {
        com.cpdss.common.generated.PortInfo.BerthInfoResponse result =
            new com.cpdss.common.generated.PortInfo.BerthInfoResponse(this);
        int from_bitField0_ = bitField0_;
        if (responseStatusBuilder_ == null) {
          result.responseStatus_ = responseStatus_;
        } else {
          result.responseStatus_ = responseStatusBuilder_.build();
        }
        if (berthsBuilder_ == null) {
          if (((bitField0_ & 0x00000001) != 0)) {
            berths_ = java.util.Collections.unmodifiableList(berths_);
            bitField0_ = (bitField0_ & ~0x00000001);
          }
          result.berths_ = berths_;
        } else {
          result.berths_ = berthsBuilder_.build();
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
        if (other instanceof com.cpdss.common.generated.PortInfo.BerthInfoResponse) {
          return mergeFrom((com.cpdss.common.generated.PortInfo.BerthInfoResponse) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.cpdss.common.generated.PortInfo.BerthInfoResponse other) {
        if (other == com.cpdss.common.generated.PortInfo.BerthInfoResponse.getDefaultInstance())
          return this;
        if (other.hasResponseStatus()) {
          mergeResponseStatus(other.getResponseStatus());
        }
        if (berthsBuilder_ == null) {
          if (!other.berths_.isEmpty()) {
            if (berths_.isEmpty()) {
              berths_ = other.berths_;
              bitField0_ = (bitField0_ & ~0x00000001);
            } else {
              ensureBerthsIsMutable();
              berths_.addAll(other.berths_);
            }
            onChanged();
          }
        } else {
          if (!other.berths_.isEmpty()) {
            if (berthsBuilder_.isEmpty()) {
              berthsBuilder_.dispose();
              berthsBuilder_ = null;
              berths_ = other.berths_;
              bitField0_ = (bitField0_ & ~0x00000001);
              berthsBuilder_ =
                  com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
                      ? getBerthsFieldBuilder()
                      : null;
            } else {
              berthsBuilder_.addAllMessages(other.berths_);
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
        com.cpdss.common.generated.PortInfo.BerthInfoResponse parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.PortInfo.BerthInfoResponse) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private int bitField0_;

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

      private java.util.List<com.cpdss.common.generated.PortInfo.BerthDetail> berths_ =
          java.util.Collections.emptyList();

      private void ensureBerthsIsMutable() {
        if (!((bitField0_ & 0x00000001) != 0)) {
          berths_ =
              new java.util.ArrayList<com.cpdss.common.generated.PortInfo.BerthDetail>(berths_);
          bitField0_ |= 0x00000001;
        }
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
              com.cpdss.common.generated.PortInfo.BerthDetail,
              com.cpdss.common.generated.PortInfo.BerthDetail.Builder,
              com.cpdss.common.generated.PortInfo.BerthDetailOrBuilder>
          berthsBuilder_;

      /** <code>repeated .BerthDetail berths = 2;</code> */
      public java.util.List<com.cpdss.common.generated.PortInfo.BerthDetail> getBerthsList() {
        if (berthsBuilder_ == null) {
          return java.util.Collections.unmodifiableList(berths_);
        } else {
          return berthsBuilder_.getMessageList();
        }
      }
      /** <code>repeated .BerthDetail berths = 2;</code> */
      public int getBerthsCount() {
        if (berthsBuilder_ == null) {
          return berths_.size();
        } else {
          return berthsBuilder_.getCount();
        }
      }
      /** <code>repeated .BerthDetail berths = 2;</code> */
      public com.cpdss.common.generated.PortInfo.BerthDetail getBerths(int index) {
        if (berthsBuilder_ == null) {
          return berths_.get(index);
        } else {
          return berthsBuilder_.getMessage(index);
        }
      }
      /** <code>repeated .BerthDetail berths = 2;</code> */
      public Builder setBerths(int index, com.cpdss.common.generated.PortInfo.BerthDetail value) {
        if (berthsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureBerthsIsMutable();
          berths_.set(index, value);
          onChanged();
        } else {
          berthsBuilder_.setMessage(index, value);
        }
        return this;
      }
      /** <code>repeated .BerthDetail berths = 2;</code> */
      public Builder setBerths(
          int index, com.cpdss.common.generated.PortInfo.BerthDetail.Builder builderForValue) {
        if (berthsBuilder_ == null) {
          ensureBerthsIsMutable();
          berths_.set(index, builderForValue.build());
          onChanged();
        } else {
          berthsBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .BerthDetail berths = 2;</code> */
      public Builder addBerths(com.cpdss.common.generated.PortInfo.BerthDetail value) {
        if (berthsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureBerthsIsMutable();
          berths_.add(value);
          onChanged();
        } else {
          berthsBuilder_.addMessage(value);
        }
        return this;
      }
      /** <code>repeated .BerthDetail berths = 2;</code> */
      public Builder addBerths(int index, com.cpdss.common.generated.PortInfo.BerthDetail value) {
        if (berthsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureBerthsIsMutable();
          berths_.add(index, value);
          onChanged();
        } else {
          berthsBuilder_.addMessage(index, value);
        }
        return this;
      }
      /** <code>repeated .BerthDetail berths = 2;</code> */
      public Builder addBerths(
          com.cpdss.common.generated.PortInfo.BerthDetail.Builder builderForValue) {
        if (berthsBuilder_ == null) {
          ensureBerthsIsMutable();
          berths_.add(builderForValue.build());
          onChanged();
        } else {
          berthsBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .BerthDetail berths = 2;</code> */
      public Builder addBerths(
          int index, com.cpdss.common.generated.PortInfo.BerthDetail.Builder builderForValue) {
        if (berthsBuilder_ == null) {
          ensureBerthsIsMutable();
          berths_.add(index, builderForValue.build());
          onChanged();
        } else {
          berthsBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .BerthDetail berths = 2;</code> */
      public Builder addAllBerths(
          java.lang.Iterable<? extends com.cpdss.common.generated.PortInfo.BerthDetail> values) {
        if (berthsBuilder_ == null) {
          ensureBerthsIsMutable();
          com.google.protobuf.AbstractMessageLite.Builder.addAll(values, berths_);
          onChanged();
        } else {
          berthsBuilder_.addAllMessages(values);
        }
        return this;
      }
      /** <code>repeated .BerthDetail berths = 2;</code> */
      public Builder clearBerths() {
        if (berthsBuilder_ == null) {
          berths_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
          onChanged();
        } else {
          berthsBuilder_.clear();
        }
        return this;
      }
      /** <code>repeated .BerthDetail berths = 2;</code> */
      public Builder removeBerths(int index) {
        if (berthsBuilder_ == null) {
          ensureBerthsIsMutable();
          berths_.remove(index);
          onChanged();
        } else {
          berthsBuilder_.remove(index);
        }
        return this;
      }
      /** <code>repeated .BerthDetail berths = 2;</code> */
      public com.cpdss.common.generated.PortInfo.BerthDetail.Builder getBerthsBuilder(int index) {
        return getBerthsFieldBuilder().getBuilder(index);
      }
      /** <code>repeated .BerthDetail berths = 2;</code> */
      public com.cpdss.common.generated.PortInfo.BerthDetailOrBuilder getBerthsOrBuilder(
          int index) {
        if (berthsBuilder_ == null) {
          return berths_.get(index);
        } else {
          return berthsBuilder_.getMessageOrBuilder(index);
        }
      }
      /** <code>repeated .BerthDetail berths = 2;</code> */
      public java.util.List<? extends com.cpdss.common.generated.PortInfo.BerthDetailOrBuilder>
          getBerthsOrBuilderList() {
        if (berthsBuilder_ != null) {
          return berthsBuilder_.getMessageOrBuilderList();
        } else {
          return java.util.Collections.unmodifiableList(berths_);
        }
      }
      /** <code>repeated .BerthDetail berths = 2;</code> */
      public com.cpdss.common.generated.PortInfo.BerthDetail.Builder addBerthsBuilder() {
        return getBerthsFieldBuilder()
            .addBuilder(com.cpdss.common.generated.PortInfo.BerthDetail.getDefaultInstance());
      }
      /** <code>repeated .BerthDetail berths = 2;</code> */
      public com.cpdss.common.generated.PortInfo.BerthDetail.Builder addBerthsBuilder(int index) {
        return getBerthsFieldBuilder()
            .addBuilder(
                index, com.cpdss.common.generated.PortInfo.BerthDetail.getDefaultInstance());
      }
      /** <code>repeated .BerthDetail berths = 2;</code> */
      public java.util.List<com.cpdss.common.generated.PortInfo.BerthDetail.Builder>
          getBerthsBuilderList() {
        return getBerthsFieldBuilder().getBuilderList();
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
              com.cpdss.common.generated.PortInfo.BerthDetail,
              com.cpdss.common.generated.PortInfo.BerthDetail.Builder,
              com.cpdss.common.generated.PortInfo.BerthDetailOrBuilder>
          getBerthsFieldBuilder() {
        if (berthsBuilder_ == null) {
          berthsBuilder_ =
              new com.google.protobuf.RepeatedFieldBuilderV3<
                  com.cpdss.common.generated.PortInfo.BerthDetail,
                  com.cpdss.common.generated.PortInfo.BerthDetail.Builder,
                  com.cpdss.common.generated.PortInfo.BerthDetailOrBuilder>(
                  berths_, ((bitField0_ & 0x00000001) != 0), getParentForChildren(), isClean());
          berths_ = null;
        }
        return berthsBuilder_;
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

      // @@protoc_insertion_point(builder_scope:BerthInfoResponse)
    }

    // @@protoc_insertion_point(class_scope:BerthInfoResponse)
    private static final com.cpdss.common.generated.PortInfo.BerthInfoResponse DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.PortInfo.BerthInfoResponse();
    }

    public static com.cpdss.common.generated.PortInfo.BerthInfoResponse getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<BerthInfoResponse> PARSER =
        new com.google.protobuf.AbstractParser<BerthInfoResponse>() {
          @java.lang.Override
          public BerthInfoResponse parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new BerthInfoResponse(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<BerthInfoResponse> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<BerthInfoResponse> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.PortInfo.BerthInfoResponse getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface BerthDetailOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:BerthDetail)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int64 id = 1;</code>
     *
     * @return The id.
     */
    long getId();

    /**
     * <code>int64 portId = 2;</code>
     *
     * @return The portId.
     */
    long getPortId();

    /**
     * <code>int64 loadingInfoId = 12;</code>
     *
     * @return The loadingInfoId.
     */
    long getLoadingInfoId();

    /**
     * <code>string maxShipChannel = 3;</code>
     *
     * @return The maxShipChannel.
     */
    java.lang.String getMaxShipChannel();
    /**
     * <code>string maxShipChannel = 3;</code>
     *
     * @return The bytes for maxShipChannel.
     */
    com.google.protobuf.ByteString getMaxShipChannelBytes();

    /**
     * <code>string berthName = 4;</code>
     *
     * @return The berthName.
     */
    java.lang.String getBerthName();
    /**
     * <code>string berthName = 4;</code>
     *
     * @return The bytes for berthName.
     */
    com.google.protobuf.ByteString getBerthNameBytes();

    /**
     * <code>string maxShipDepth = 5;</code>
     *
     * @return The maxShipDepth.
     */
    java.lang.String getMaxShipDepth();
    /**
     * <code>string maxShipDepth = 5;</code>
     *
     * @return The bytes for maxShipDepth.
     */
    com.google.protobuf.ByteString getMaxShipDepthBytes();

    /**
     * <code>string seaDraftLimitation = 6;</code>
     *
     * @return The seaDraftLimitation.
     */
    java.lang.String getSeaDraftLimitation();
    /**
     * <code>string seaDraftLimitation = 6;</code>
     *
     * @return The bytes for seaDraftLimitation.
     */
    com.google.protobuf.ByteString getSeaDraftLimitationBytes();

    /**
     * <code>string airDraftLimitation = 7;</code>
     *
     * @return The airDraftLimitation.
     */
    java.lang.String getAirDraftLimitation();
    /**
     * <code>string airDraftLimitation = 7;</code>
     *
     * @return The bytes for airDraftLimitation.
     */
    com.google.protobuf.ByteString getAirDraftLimitationBytes();

    /**
     * <code>string maxManifoldHeight = 8;</code>
     *
     * @return The maxManifoldHeight.
     */
    java.lang.String getMaxManifoldHeight();
    /**
     * <code>string maxManifoldHeight = 8;</code>
     *
     * @return The bytes for maxManifoldHeight.
     */
    com.google.protobuf.ByteString getMaxManifoldHeightBytes();

    /**
     * <code>string regulationAndRestriction = 9;</code>
     *
     * @return The regulationAndRestriction.
     */
    java.lang.String getRegulationAndRestriction();
    /**
     * <code>string regulationAndRestriction = 9;</code>
     *
     * @return The bytes for regulationAndRestriction.
     */
    com.google.protobuf.ByteString getRegulationAndRestrictionBytes();

    /**
     * <code>string maxLoa = 10;</code>
     *
     * @return The maxLoa.
     */
    java.lang.String getMaxLoa();
    /**
     * <code>string maxLoa = 10;</code>
     *
     * @return The bytes for maxLoa.
     */
    com.google.protobuf.ByteString getMaxLoaBytes();

    /**
     * <code>string maxDraft = 11;</code>
     *
     * @return The maxDraft.
     */
    java.lang.String getMaxDraft();
    /**
     * <code>string maxDraft = 11;</code>
     *
     * @return The bytes for maxDraft.
     */
    com.google.protobuf.ByteString getMaxDraftBytes();

    /**
     * <code>string lineDisplacement = 13;</code>
     *
     * @return The lineDisplacement.
     */
    java.lang.String getLineDisplacement();
    /**
     * <code>string lineDisplacement = 13;</code>
     *
     * @return The bytes for lineDisplacement.
     */
    com.google.protobuf.ByteString getLineDisplacementBytes();
  }
  /** Protobuf type {@code BerthDetail} */
  public static final class BerthDetail extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:BerthDetail)
      BerthDetailOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use BerthDetail.newBuilder() to construct.
    private BerthDetail(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private BerthDetail() {
      maxShipChannel_ = "";
      berthName_ = "";
      maxShipDepth_ = "";
      seaDraftLimitation_ = "";
      airDraftLimitation_ = "";
      maxManifoldHeight_ = "";
      regulationAndRestriction_ = "";
      maxLoa_ = "";
      maxDraft_ = "";
      lineDisplacement_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new BerthDetail();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private BerthDetail(
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
            case 16:
              {
                portId_ = input.readInt64();
                break;
              }
            case 26:
              {
                java.lang.String s = input.readStringRequireUtf8();

                maxShipChannel_ = s;
                break;
              }
            case 34:
              {
                java.lang.String s = input.readStringRequireUtf8();

                berthName_ = s;
                break;
              }
            case 42:
              {
                java.lang.String s = input.readStringRequireUtf8();

                maxShipDepth_ = s;
                break;
              }
            case 50:
              {
                java.lang.String s = input.readStringRequireUtf8();

                seaDraftLimitation_ = s;
                break;
              }
            case 58:
              {
                java.lang.String s = input.readStringRequireUtf8();

                airDraftLimitation_ = s;
                break;
              }
            case 66:
              {
                java.lang.String s = input.readStringRequireUtf8();

                maxManifoldHeight_ = s;
                break;
              }
            case 74:
              {
                java.lang.String s = input.readStringRequireUtf8();

                regulationAndRestriction_ = s;
                break;
              }
            case 82:
              {
                java.lang.String s = input.readStringRequireUtf8();

                maxLoa_ = s;
                break;
              }
            case 90:
              {
                java.lang.String s = input.readStringRequireUtf8();

                maxDraft_ = s;
                break;
              }
            case 96:
              {
                loadingInfoId_ = input.readInt64();
                break;
              }
            case 106:
              {
                java.lang.String s = input.readStringRequireUtf8();

                lineDisplacement_ = s;
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
      return com.cpdss.common.generated.PortInfo.internal_static_BerthDetail_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.PortInfo.internal_static_BerthDetail_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.PortInfo.BerthDetail.class,
              com.cpdss.common.generated.PortInfo.BerthDetail.Builder.class);
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

    public static final int PORTID_FIELD_NUMBER = 2;
    private long portId_;
    /**
     * <code>int64 portId = 2;</code>
     *
     * @return The portId.
     */
    public long getPortId() {
      return portId_;
    }

    public static final int LOADINGINFOID_FIELD_NUMBER = 12;
    private long loadingInfoId_;
    /**
     * <code>int64 loadingInfoId = 12;</code>
     *
     * @return The loadingInfoId.
     */
    public long getLoadingInfoId() {
      return loadingInfoId_;
    }

    public static final int MAXSHIPCHANNEL_FIELD_NUMBER = 3;
    private volatile java.lang.Object maxShipChannel_;
    /**
     * <code>string maxShipChannel = 3;</code>
     *
     * @return The maxShipChannel.
     */
    public java.lang.String getMaxShipChannel() {
      java.lang.Object ref = maxShipChannel_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        maxShipChannel_ = s;
        return s;
      }
    }
    /**
     * <code>string maxShipChannel = 3;</code>
     *
     * @return The bytes for maxShipChannel.
     */
    public com.google.protobuf.ByteString getMaxShipChannelBytes() {
      java.lang.Object ref = maxShipChannel_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        maxShipChannel_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int BERTHNAME_FIELD_NUMBER = 4;
    private volatile java.lang.Object berthName_;
    /**
     * <code>string berthName = 4;</code>
     *
     * @return The berthName.
     */
    public java.lang.String getBerthName() {
      java.lang.Object ref = berthName_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        berthName_ = s;
        return s;
      }
    }
    /**
     * <code>string berthName = 4;</code>
     *
     * @return The bytes for berthName.
     */
    public com.google.protobuf.ByteString getBerthNameBytes() {
      java.lang.Object ref = berthName_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        berthName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int MAXSHIPDEPTH_FIELD_NUMBER = 5;
    private volatile java.lang.Object maxShipDepth_;
    /**
     * <code>string maxShipDepth = 5;</code>
     *
     * @return The maxShipDepth.
     */
    public java.lang.String getMaxShipDepth() {
      java.lang.Object ref = maxShipDepth_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        maxShipDepth_ = s;
        return s;
      }
    }
    /**
     * <code>string maxShipDepth = 5;</code>
     *
     * @return The bytes for maxShipDepth.
     */
    public com.google.protobuf.ByteString getMaxShipDepthBytes() {
      java.lang.Object ref = maxShipDepth_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        maxShipDepth_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int SEADRAFTLIMITATION_FIELD_NUMBER = 6;
    private volatile java.lang.Object seaDraftLimitation_;
    /**
     * <code>string seaDraftLimitation = 6;</code>
     *
     * @return The seaDraftLimitation.
     */
    public java.lang.String getSeaDraftLimitation() {
      java.lang.Object ref = seaDraftLimitation_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        seaDraftLimitation_ = s;
        return s;
      }
    }
    /**
     * <code>string seaDraftLimitation = 6;</code>
     *
     * @return The bytes for seaDraftLimitation.
     */
    public com.google.protobuf.ByteString getSeaDraftLimitationBytes() {
      java.lang.Object ref = seaDraftLimitation_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        seaDraftLimitation_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int AIRDRAFTLIMITATION_FIELD_NUMBER = 7;
    private volatile java.lang.Object airDraftLimitation_;
    /**
     * <code>string airDraftLimitation = 7;</code>
     *
     * @return The airDraftLimitation.
     */
    public java.lang.String getAirDraftLimitation() {
      java.lang.Object ref = airDraftLimitation_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        airDraftLimitation_ = s;
        return s;
      }
    }
    /**
     * <code>string airDraftLimitation = 7;</code>
     *
     * @return The bytes for airDraftLimitation.
     */
    public com.google.protobuf.ByteString getAirDraftLimitationBytes() {
      java.lang.Object ref = airDraftLimitation_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        airDraftLimitation_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int MAXMANIFOLDHEIGHT_FIELD_NUMBER = 8;
    private volatile java.lang.Object maxManifoldHeight_;
    /**
     * <code>string maxManifoldHeight = 8;</code>
     *
     * @return The maxManifoldHeight.
     */
    public java.lang.String getMaxManifoldHeight() {
      java.lang.Object ref = maxManifoldHeight_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        maxManifoldHeight_ = s;
        return s;
      }
    }
    /**
     * <code>string maxManifoldHeight = 8;</code>
     *
     * @return The bytes for maxManifoldHeight.
     */
    public com.google.protobuf.ByteString getMaxManifoldHeightBytes() {
      java.lang.Object ref = maxManifoldHeight_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        maxManifoldHeight_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int REGULATIONANDRESTRICTION_FIELD_NUMBER = 9;
    private volatile java.lang.Object regulationAndRestriction_;
    /**
     * <code>string regulationAndRestriction = 9;</code>
     *
     * @return The regulationAndRestriction.
     */
    public java.lang.String getRegulationAndRestriction() {
      java.lang.Object ref = regulationAndRestriction_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        regulationAndRestriction_ = s;
        return s;
      }
    }
    /**
     * <code>string regulationAndRestriction = 9;</code>
     *
     * @return The bytes for regulationAndRestriction.
     */
    public com.google.protobuf.ByteString getRegulationAndRestrictionBytes() {
      java.lang.Object ref = regulationAndRestriction_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        regulationAndRestriction_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int MAXLOA_FIELD_NUMBER = 10;
    private volatile java.lang.Object maxLoa_;
    /**
     * <code>string maxLoa = 10;</code>
     *
     * @return The maxLoa.
     */
    public java.lang.String getMaxLoa() {
      java.lang.Object ref = maxLoa_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        maxLoa_ = s;
        return s;
      }
    }
    /**
     * <code>string maxLoa = 10;</code>
     *
     * @return The bytes for maxLoa.
     */
    public com.google.protobuf.ByteString getMaxLoaBytes() {
      java.lang.Object ref = maxLoa_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        maxLoa_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int MAXDRAFT_FIELD_NUMBER = 11;
    private volatile java.lang.Object maxDraft_;
    /**
     * <code>string maxDraft = 11;</code>
     *
     * @return The maxDraft.
     */
    public java.lang.String getMaxDraft() {
      java.lang.Object ref = maxDraft_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        maxDraft_ = s;
        return s;
      }
    }
    /**
     * <code>string maxDraft = 11;</code>
     *
     * @return The bytes for maxDraft.
     */
    public com.google.protobuf.ByteString getMaxDraftBytes() {
      java.lang.Object ref = maxDraft_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        maxDraft_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int LINEDISPLACEMENT_FIELD_NUMBER = 13;
    private volatile java.lang.Object lineDisplacement_;
    /**
     * <code>string lineDisplacement = 13;</code>
     *
     * @return The lineDisplacement.
     */
    public java.lang.String getLineDisplacement() {
      java.lang.Object ref = lineDisplacement_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        lineDisplacement_ = s;
        return s;
      }
    }
    /**
     * <code>string lineDisplacement = 13;</code>
     *
     * @return The bytes for lineDisplacement.
     */
    public com.google.protobuf.ByteString getLineDisplacementBytes() {
      java.lang.Object ref = lineDisplacement_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        lineDisplacement_ = b;
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
      if (portId_ != 0L) {
        output.writeInt64(2, portId_);
      }
      if (!getMaxShipChannelBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, maxShipChannel_);
      }
      if (!getBerthNameBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 4, berthName_);
      }
      if (!getMaxShipDepthBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 5, maxShipDepth_);
      }
      if (!getSeaDraftLimitationBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 6, seaDraftLimitation_);
      }
      if (!getAirDraftLimitationBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 7, airDraftLimitation_);
      }
      if (!getMaxManifoldHeightBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 8, maxManifoldHeight_);
      }
      if (!getRegulationAndRestrictionBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 9, regulationAndRestriction_);
      }
      if (!getMaxLoaBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 10, maxLoa_);
      }
      if (!getMaxDraftBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 11, maxDraft_);
      }
      if (loadingInfoId_ != 0L) {
        output.writeInt64(12, loadingInfoId_);
      }
      if (!getLineDisplacementBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 13, lineDisplacement_);
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
      if (portId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(2, portId_);
      }
      if (!getMaxShipChannelBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, maxShipChannel_);
      }
      if (!getBerthNameBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, berthName_);
      }
      if (!getMaxShipDepthBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, maxShipDepth_);
      }
      if (!getSeaDraftLimitationBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(6, seaDraftLimitation_);
      }
      if (!getAirDraftLimitationBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(7, airDraftLimitation_);
      }
      if (!getMaxManifoldHeightBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(8, maxManifoldHeight_);
      }
      if (!getRegulationAndRestrictionBytes().isEmpty()) {
        size +=
            com.google.protobuf.GeneratedMessageV3.computeStringSize(9, regulationAndRestriction_);
      }
      if (!getMaxLoaBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(10, maxLoa_);
      }
      if (!getMaxDraftBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(11, maxDraft_);
      }
      if (loadingInfoId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(12, loadingInfoId_);
      }
      if (!getLineDisplacementBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(13, lineDisplacement_);
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
      if (!(obj instanceof com.cpdss.common.generated.PortInfo.BerthDetail)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.PortInfo.BerthDetail other =
          (com.cpdss.common.generated.PortInfo.BerthDetail) obj;

      if (getId() != other.getId()) return false;
      if (getPortId() != other.getPortId()) return false;
      if (getLoadingInfoId() != other.getLoadingInfoId()) return false;
      if (!getMaxShipChannel().equals(other.getMaxShipChannel())) return false;
      if (!getBerthName().equals(other.getBerthName())) return false;
      if (!getMaxShipDepth().equals(other.getMaxShipDepth())) return false;
      if (!getSeaDraftLimitation().equals(other.getSeaDraftLimitation())) return false;
      if (!getAirDraftLimitation().equals(other.getAirDraftLimitation())) return false;
      if (!getMaxManifoldHeight().equals(other.getMaxManifoldHeight())) return false;
      if (!getRegulationAndRestriction().equals(other.getRegulationAndRestriction())) return false;
      if (!getMaxLoa().equals(other.getMaxLoa())) return false;
      if (!getMaxDraft().equals(other.getMaxDraft())) return false;
      if (!getLineDisplacement().equals(other.getLineDisplacement())) return false;
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
      hash = (37 * hash) + PORTID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getPortId());
      hash = (37 * hash) + LOADINGINFOID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getLoadingInfoId());
      hash = (37 * hash) + MAXSHIPCHANNEL_FIELD_NUMBER;
      hash = (53 * hash) + getMaxShipChannel().hashCode();
      hash = (37 * hash) + BERTHNAME_FIELD_NUMBER;
      hash = (53 * hash) + getBerthName().hashCode();
      hash = (37 * hash) + MAXSHIPDEPTH_FIELD_NUMBER;
      hash = (53 * hash) + getMaxShipDepth().hashCode();
      hash = (37 * hash) + SEADRAFTLIMITATION_FIELD_NUMBER;
      hash = (53 * hash) + getSeaDraftLimitation().hashCode();
      hash = (37 * hash) + AIRDRAFTLIMITATION_FIELD_NUMBER;
      hash = (53 * hash) + getAirDraftLimitation().hashCode();
      hash = (37 * hash) + MAXMANIFOLDHEIGHT_FIELD_NUMBER;
      hash = (53 * hash) + getMaxManifoldHeight().hashCode();
      hash = (37 * hash) + REGULATIONANDRESTRICTION_FIELD_NUMBER;
      hash = (53 * hash) + getRegulationAndRestriction().hashCode();
      hash = (37 * hash) + MAXLOA_FIELD_NUMBER;
      hash = (53 * hash) + getMaxLoa().hashCode();
      hash = (37 * hash) + MAXDRAFT_FIELD_NUMBER;
      hash = (53 * hash) + getMaxDraft().hashCode();
      hash = (37 * hash) + LINEDISPLACEMENT_FIELD_NUMBER;
      hash = (53 * hash) + getLineDisplacement().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.PortInfo.BerthDetail parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.PortInfo.BerthDetail parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.BerthDetail parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.PortInfo.BerthDetail parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.BerthDetail parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.PortInfo.BerthDetail parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.BerthDetail parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.PortInfo.BerthDetail parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.BerthDetail parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.PortInfo.BerthDetail parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.PortInfo.BerthDetail parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.PortInfo.BerthDetail parseFrom(
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

    public static Builder newBuilder(com.cpdss.common.generated.PortInfo.BerthDetail prototype) {
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
    /** Protobuf type {@code BerthDetail} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:BerthDetail)
        com.cpdss.common.generated.PortInfo.BerthDetailOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.PortInfo.internal_static_BerthDetail_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.PortInfo.internal_static_BerthDetail_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.PortInfo.BerthDetail.class,
                com.cpdss.common.generated.PortInfo.BerthDetail.Builder.class);
      }

      // Construct using com.cpdss.common.generated.PortInfo.BerthDetail.newBuilder()
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

        portId_ = 0L;

        loadingInfoId_ = 0L;

        maxShipChannel_ = "";

        berthName_ = "";

        maxShipDepth_ = "";

        seaDraftLimitation_ = "";

        airDraftLimitation_ = "";

        maxManifoldHeight_ = "";

        regulationAndRestriction_ = "";

        maxLoa_ = "";

        maxDraft_ = "";

        lineDisplacement_ = "";

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.PortInfo.internal_static_BerthDetail_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.PortInfo.BerthDetail getDefaultInstanceForType() {
        return com.cpdss.common.generated.PortInfo.BerthDetail.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.PortInfo.BerthDetail build() {
        com.cpdss.common.generated.PortInfo.BerthDetail result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.PortInfo.BerthDetail buildPartial() {
        com.cpdss.common.generated.PortInfo.BerthDetail result =
            new com.cpdss.common.generated.PortInfo.BerthDetail(this);
        result.id_ = id_;
        result.portId_ = portId_;
        result.loadingInfoId_ = loadingInfoId_;
        result.maxShipChannel_ = maxShipChannel_;
        result.berthName_ = berthName_;
        result.maxShipDepth_ = maxShipDepth_;
        result.seaDraftLimitation_ = seaDraftLimitation_;
        result.airDraftLimitation_ = airDraftLimitation_;
        result.maxManifoldHeight_ = maxManifoldHeight_;
        result.regulationAndRestriction_ = regulationAndRestriction_;
        result.maxLoa_ = maxLoa_;
        result.maxDraft_ = maxDraft_;
        result.lineDisplacement_ = lineDisplacement_;
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
        if (other instanceof com.cpdss.common.generated.PortInfo.BerthDetail) {
          return mergeFrom((com.cpdss.common.generated.PortInfo.BerthDetail) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.cpdss.common.generated.PortInfo.BerthDetail other) {
        if (other == com.cpdss.common.generated.PortInfo.BerthDetail.getDefaultInstance())
          return this;
        if (other.getId() != 0L) {
          setId(other.getId());
        }
        if (other.getPortId() != 0L) {
          setPortId(other.getPortId());
        }
        if (other.getLoadingInfoId() != 0L) {
          setLoadingInfoId(other.getLoadingInfoId());
        }
        if (!other.getMaxShipChannel().isEmpty()) {
          maxShipChannel_ = other.maxShipChannel_;
          onChanged();
        }
        if (!other.getBerthName().isEmpty()) {
          berthName_ = other.berthName_;
          onChanged();
        }
        if (!other.getMaxShipDepth().isEmpty()) {
          maxShipDepth_ = other.maxShipDepth_;
          onChanged();
        }
        if (!other.getSeaDraftLimitation().isEmpty()) {
          seaDraftLimitation_ = other.seaDraftLimitation_;
          onChanged();
        }
        if (!other.getAirDraftLimitation().isEmpty()) {
          airDraftLimitation_ = other.airDraftLimitation_;
          onChanged();
        }
        if (!other.getMaxManifoldHeight().isEmpty()) {
          maxManifoldHeight_ = other.maxManifoldHeight_;
          onChanged();
        }
        if (!other.getRegulationAndRestriction().isEmpty()) {
          regulationAndRestriction_ = other.regulationAndRestriction_;
          onChanged();
        }
        if (!other.getMaxLoa().isEmpty()) {
          maxLoa_ = other.maxLoa_;
          onChanged();
        }
        if (!other.getMaxDraft().isEmpty()) {
          maxDraft_ = other.maxDraft_;
          onChanged();
        }
        if (!other.getLineDisplacement().isEmpty()) {
          lineDisplacement_ = other.lineDisplacement_;
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
        com.cpdss.common.generated.PortInfo.BerthDetail parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.PortInfo.BerthDetail) e.getUnfinishedMessage();
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

      private long portId_;
      /**
       * <code>int64 portId = 2;</code>
       *
       * @return The portId.
       */
      public long getPortId() {
        return portId_;
      }
      /**
       * <code>int64 portId = 2;</code>
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
       * <code>int64 portId = 2;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearPortId() {

        portId_ = 0L;
        onChanged();
        return this;
      }

      private long loadingInfoId_;
      /**
       * <code>int64 loadingInfoId = 12;</code>
       *
       * @return The loadingInfoId.
       */
      public long getLoadingInfoId() {
        return loadingInfoId_;
      }
      /**
       * <code>int64 loadingInfoId = 12;</code>
       *
       * @param value The loadingInfoId to set.
       * @return This builder for chaining.
       */
      public Builder setLoadingInfoId(long value) {

        loadingInfoId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int64 loadingInfoId = 12;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearLoadingInfoId() {

        loadingInfoId_ = 0L;
        onChanged();
        return this;
      }

      private java.lang.Object maxShipChannel_ = "";
      /**
       * <code>string maxShipChannel = 3;</code>
       *
       * @return The maxShipChannel.
       */
      public java.lang.String getMaxShipChannel() {
        java.lang.Object ref = maxShipChannel_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          maxShipChannel_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string maxShipChannel = 3;</code>
       *
       * @return The bytes for maxShipChannel.
       */
      public com.google.protobuf.ByteString getMaxShipChannelBytes() {
        java.lang.Object ref = maxShipChannel_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          maxShipChannel_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string maxShipChannel = 3;</code>
       *
       * @param value The maxShipChannel to set.
       * @return This builder for chaining.
       */
      public Builder setMaxShipChannel(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        maxShipChannel_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string maxShipChannel = 3;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearMaxShipChannel() {

        maxShipChannel_ = getDefaultInstance().getMaxShipChannel();
        onChanged();
        return this;
      }
      /**
       * <code>string maxShipChannel = 3;</code>
       *
       * @param value The bytes for maxShipChannel to set.
       * @return This builder for chaining.
       */
      public Builder setMaxShipChannelBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        maxShipChannel_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object berthName_ = "";
      /**
       * <code>string berthName = 4;</code>
       *
       * @return The berthName.
       */
      public java.lang.String getBerthName() {
        java.lang.Object ref = berthName_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          berthName_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string berthName = 4;</code>
       *
       * @return The bytes for berthName.
       */
      public com.google.protobuf.ByteString getBerthNameBytes() {
        java.lang.Object ref = berthName_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          berthName_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string berthName = 4;</code>
       *
       * @param value The berthName to set.
       * @return This builder for chaining.
       */
      public Builder setBerthName(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        berthName_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string berthName = 4;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearBerthName() {

        berthName_ = getDefaultInstance().getBerthName();
        onChanged();
        return this;
      }
      /**
       * <code>string berthName = 4;</code>
       *
       * @param value The bytes for berthName to set.
       * @return This builder for chaining.
       */
      public Builder setBerthNameBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        berthName_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object maxShipDepth_ = "";
      /**
       * <code>string maxShipDepth = 5;</code>
       *
       * @return The maxShipDepth.
       */
      public java.lang.String getMaxShipDepth() {
        java.lang.Object ref = maxShipDepth_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          maxShipDepth_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string maxShipDepth = 5;</code>
       *
       * @return The bytes for maxShipDepth.
       */
      public com.google.protobuf.ByteString getMaxShipDepthBytes() {
        java.lang.Object ref = maxShipDepth_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          maxShipDepth_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string maxShipDepth = 5;</code>
       *
       * @param value The maxShipDepth to set.
       * @return This builder for chaining.
       */
      public Builder setMaxShipDepth(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        maxShipDepth_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string maxShipDepth = 5;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearMaxShipDepth() {

        maxShipDepth_ = getDefaultInstance().getMaxShipDepth();
        onChanged();
        return this;
      }
      /**
       * <code>string maxShipDepth = 5;</code>
       *
       * @param value The bytes for maxShipDepth to set.
       * @return This builder for chaining.
       */
      public Builder setMaxShipDepthBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        maxShipDepth_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object seaDraftLimitation_ = "";
      /**
       * <code>string seaDraftLimitation = 6;</code>
       *
       * @return The seaDraftLimitation.
       */
      public java.lang.String getSeaDraftLimitation() {
        java.lang.Object ref = seaDraftLimitation_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          seaDraftLimitation_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string seaDraftLimitation = 6;</code>
       *
       * @return The bytes for seaDraftLimitation.
       */
      public com.google.protobuf.ByteString getSeaDraftLimitationBytes() {
        java.lang.Object ref = seaDraftLimitation_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          seaDraftLimitation_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string seaDraftLimitation = 6;</code>
       *
       * @param value The seaDraftLimitation to set.
       * @return This builder for chaining.
       */
      public Builder setSeaDraftLimitation(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        seaDraftLimitation_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string seaDraftLimitation = 6;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearSeaDraftLimitation() {

        seaDraftLimitation_ = getDefaultInstance().getSeaDraftLimitation();
        onChanged();
        return this;
      }
      /**
       * <code>string seaDraftLimitation = 6;</code>
       *
       * @param value The bytes for seaDraftLimitation to set.
       * @return This builder for chaining.
       */
      public Builder setSeaDraftLimitationBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        seaDraftLimitation_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object airDraftLimitation_ = "";
      /**
       * <code>string airDraftLimitation = 7;</code>
       *
       * @return The airDraftLimitation.
       */
      public java.lang.String getAirDraftLimitation() {
        java.lang.Object ref = airDraftLimitation_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          airDraftLimitation_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string airDraftLimitation = 7;</code>
       *
       * @return The bytes for airDraftLimitation.
       */
      public com.google.protobuf.ByteString getAirDraftLimitationBytes() {
        java.lang.Object ref = airDraftLimitation_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          airDraftLimitation_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string airDraftLimitation = 7;</code>
       *
       * @param value The airDraftLimitation to set.
       * @return This builder for chaining.
       */
      public Builder setAirDraftLimitation(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        airDraftLimitation_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string airDraftLimitation = 7;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearAirDraftLimitation() {

        airDraftLimitation_ = getDefaultInstance().getAirDraftLimitation();
        onChanged();
        return this;
      }
      /**
       * <code>string airDraftLimitation = 7;</code>
       *
       * @param value The bytes for airDraftLimitation to set.
       * @return This builder for chaining.
       */
      public Builder setAirDraftLimitationBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        airDraftLimitation_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object maxManifoldHeight_ = "";
      /**
       * <code>string maxManifoldHeight = 8;</code>
       *
       * @return The maxManifoldHeight.
       */
      public java.lang.String getMaxManifoldHeight() {
        java.lang.Object ref = maxManifoldHeight_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          maxManifoldHeight_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string maxManifoldHeight = 8;</code>
       *
       * @return The bytes for maxManifoldHeight.
       */
      public com.google.protobuf.ByteString getMaxManifoldHeightBytes() {
        java.lang.Object ref = maxManifoldHeight_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          maxManifoldHeight_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string maxManifoldHeight = 8;</code>
       *
       * @param value The maxManifoldHeight to set.
       * @return This builder for chaining.
       */
      public Builder setMaxManifoldHeight(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        maxManifoldHeight_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string maxManifoldHeight = 8;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearMaxManifoldHeight() {

        maxManifoldHeight_ = getDefaultInstance().getMaxManifoldHeight();
        onChanged();
        return this;
      }
      /**
       * <code>string maxManifoldHeight = 8;</code>
       *
       * @param value The bytes for maxManifoldHeight to set.
       * @return This builder for chaining.
       */
      public Builder setMaxManifoldHeightBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        maxManifoldHeight_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object regulationAndRestriction_ = "";
      /**
       * <code>string regulationAndRestriction = 9;</code>
       *
       * @return The regulationAndRestriction.
       */
      public java.lang.String getRegulationAndRestriction() {
        java.lang.Object ref = regulationAndRestriction_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          regulationAndRestriction_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string regulationAndRestriction = 9;</code>
       *
       * @return The bytes for regulationAndRestriction.
       */
      public com.google.protobuf.ByteString getRegulationAndRestrictionBytes() {
        java.lang.Object ref = regulationAndRestriction_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          regulationAndRestriction_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string regulationAndRestriction = 9;</code>
       *
       * @param value The regulationAndRestriction to set.
       * @return This builder for chaining.
       */
      public Builder setRegulationAndRestriction(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        regulationAndRestriction_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string regulationAndRestriction = 9;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearRegulationAndRestriction() {

        regulationAndRestriction_ = getDefaultInstance().getRegulationAndRestriction();
        onChanged();
        return this;
      }
      /**
       * <code>string regulationAndRestriction = 9;</code>
       *
       * @param value The bytes for regulationAndRestriction to set.
       * @return This builder for chaining.
       */
      public Builder setRegulationAndRestrictionBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        regulationAndRestriction_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object maxLoa_ = "";
      /**
       * <code>string maxLoa = 10;</code>
       *
       * @return The maxLoa.
       */
      public java.lang.String getMaxLoa() {
        java.lang.Object ref = maxLoa_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          maxLoa_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string maxLoa = 10;</code>
       *
       * @return The bytes for maxLoa.
       */
      public com.google.protobuf.ByteString getMaxLoaBytes() {
        java.lang.Object ref = maxLoa_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          maxLoa_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string maxLoa = 10;</code>
       *
       * @param value The maxLoa to set.
       * @return This builder for chaining.
       */
      public Builder setMaxLoa(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        maxLoa_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string maxLoa = 10;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearMaxLoa() {

        maxLoa_ = getDefaultInstance().getMaxLoa();
        onChanged();
        return this;
      }
      /**
       * <code>string maxLoa = 10;</code>
       *
       * @param value The bytes for maxLoa to set.
       * @return This builder for chaining.
       */
      public Builder setMaxLoaBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        maxLoa_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object maxDraft_ = "";
      /**
       * <code>string maxDraft = 11;</code>
       *
       * @return The maxDraft.
       */
      public java.lang.String getMaxDraft() {
        java.lang.Object ref = maxDraft_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          maxDraft_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string maxDraft = 11;</code>
       *
       * @return The bytes for maxDraft.
       */
      public com.google.protobuf.ByteString getMaxDraftBytes() {
        java.lang.Object ref = maxDraft_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          maxDraft_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string maxDraft = 11;</code>
       *
       * @param value The maxDraft to set.
       * @return This builder for chaining.
       */
      public Builder setMaxDraft(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        maxDraft_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string maxDraft = 11;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearMaxDraft() {

        maxDraft_ = getDefaultInstance().getMaxDraft();
        onChanged();
        return this;
      }
      /**
       * <code>string maxDraft = 11;</code>
       *
       * @param value The bytes for maxDraft to set.
       * @return This builder for chaining.
       */
      public Builder setMaxDraftBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        maxDraft_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object lineDisplacement_ = "";
      /**
       * <code>string lineDisplacement = 13;</code>
       *
       * @return The lineDisplacement.
       */
      public java.lang.String getLineDisplacement() {
        java.lang.Object ref = lineDisplacement_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          lineDisplacement_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string lineDisplacement = 13;</code>
       *
       * @return The bytes for lineDisplacement.
       */
      public com.google.protobuf.ByteString getLineDisplacementBytes() {
        java.lang.Object ref = lineDisplacement_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          lineDisplacement_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string lineDisplacement = 13;</code>
       *
       * @param value The lineDisplacement to set.
       * @return This builder for chaining.
       */
      public Builder setLineDisplacement(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        lineDisplacement_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string lineDisplacement = 13;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearLineDisplacement() {

        lineDisplacement_ = getDefaultInstance().getLineDisplacement();
        onChanged();
        return this;
      }
      /**
       * <code>string lineDisplacement = 13;</code>
       *
       * @param value The bytes for lineDisplacement to set.
       * @return This builder for chaining.
       */
      public Builder setLineDisplacementBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        lineDisplacement_ = value;
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

      // @@protoc_insertion_point(builder_scope:BerthDetail)
    }

    // @@protoc_insertion_point(class_scope:BerthDetail)
    private static final com.cpdss.common.generated.PortInfo.BerthDetail DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.PortInfo.BerthDetail();
    }

    public static com.cpdss.common.generated.PortInfo.BerthDetail getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<BerthDetail> PARSER =
        new com.google.protobuf.AbstractParser<BerthDetail>() {
          @java.lang.Override
          public BerthDetail parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new BerthDetail(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<BerthDetail> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<BerthDetail> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.PortInfo.BerthDetail getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_CargoInfos_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_CargoInfos_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_CargoPortMapping_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_CargoPortMapping_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_GetPortInfoByPortIdsRequest_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_GetPortInfoByPortIdsRequest_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_PortRequest_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_PortRequest_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_PortRequestWithPaging_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_PortRequestWithPaging_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_PortDetail_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_PortDetail_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_PortReply_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_PortReply_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_GetPortInfoByCargoIdRequest_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_GetPortInfoByCargoIdRequest_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_GetPortInfoByCargoIdReply_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_GetPortInfoByCargoIdReply_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_PortEmptyRequest_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_PortEmptyRequest_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_Timezone_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Timezone_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_TimezoneResponse_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_TimezoneResponse_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_PortIdRequest_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_PortIdRequest_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_BerthInfoResponse_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_BerthInfoResponse_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_BerthDetail_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_BerthDetail_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }

  private static com.google.protobuf.Descriptors.FileDescriptor descriptor;

  static {
    java.lang.String[] descriptorData = {
      "\n\017port_info.proto\032\014common.proto\"\\\n\nCargo"
          + "Infos\022%\n\ncargoPorts\030\001 \003(\0132\021.CargoPortMap"
          + "ping\022\'\n\016responseStatus\030\002 \001(\0132\017.ResponseS"
          + "tatus\"3\n\020CargoPortMapping\022\017\n\007cargoId\030\001 \001"
          + "(\003\022\016\n\006portId\030\002 \001(\003\")\n\033GetPortInfoByPortI"
          + "dsRequest\022\n\n\002id\030\001 \003(\003\"]\n\013PortRequest\022\021\n\t"
          + "companyId\030\001 \001(\003\022\020\n\010vesselId\030\002 \001(\003\022\020\n\010voy"
          + "ageId\030\003 \001(\003\022\027\n\017loadableStudyId\030\004 \001(\003\"6\n\025"
          + "PortRequestWithPaging\022\016\n\006offset\030\001 \001(\003\022\r\n"
          + "\005limit\030\002 \001(\003\"\345\003\n\nPortDetail\022\n\n\002id\030\001 \001(\003\022"
          + "\014\n\004name\030\002 \001(\t\022\014\n\004code\030\003 \001(\t\022\024\n\014waterDens"
          + "ity\030\004 \001(\t\022\020\n\010maxDraft\030\005 \001(\t\022\023\n\013maxAirDra"
          + "ft\030\006 \001(\t\022\031\n\021averageTideHeight\030\007 \001(\t\022\022\n\nt"
          + "ideHeight\030\010 \001(\t\022\022\n\nhwTideFrom\030\t \001(\t\022\020\n\010h"
          + "wTideTo\030\n \001(\t\022\022\n\nlwTideFrom\030\013 \001(\t\022\020\n\010lwT"
          + "ideTo\030\014 \001(\t\022\026\n\016hwTideTimeFrom\030\r \001(\t\022\024\n\014h"
          + "wTideTimeTo\030\016 \001(\t\022\026\n\016lwTideTimeFrom\030\017 \001("
          + "\t\022\024\n\014lwTideTimeTo\030\020 \001(\t\022\023\n\013sunriseTime\030\021"
          + " \001(\t\022\022\n\nsunsetTime\030\022 \001(\t\022\020\n\010timezone\030\023 \001"
          + "(\t\022\031\n\021timezoneOffsetVal\030\024 \001(\t\022\022\n\ntimezon"
          + "eId\030\025 \001(\003\022\034\n\024timezoneAbbreviation\030\026 \001(\t\022"
          + "\023\n\013countryName\030\027 \001(\t\"P\n\tPortReply\022\'\n\016res"
          + "ponseStatus\030\001 \001(\0132\017.ResponseStatus\022\032\n\005po"
          + "rts\030\002 \003(\0132\013.PortDetail\".\n\033GetPortInfoByC"
          + "argoIdRequest\022\017\n\007cargoId\030\001 \001(\003\"`\n\031GetPor"
          + "tInfoByCargoIdReply\022\'\n\016responseStatus\030\001 "
          + "\001(\0132\017.ResponseStatus\022\032\n\005ports\030\002 \003(\0132\013.Po"
          + "rtDetail\"\022\n\020PortEmptyRequest\"S\n\010Timezone"
          + "\022\n\n\002id\030\001 \001(\003\022\020\n\010timezone\030\002 \001(\t\022\023\n\013offset"
          + "Value\030\003 \001(\t\022\024\n\014abbreviation\030\004 \001(\t\"Y\n\020Tim"
          + "ezoneResponse\022\'\n\016responseStatus\030\001 \001(\0132\017."
          + "ResponseStatus\022\034\n\ttimezones\030\002 \003(\0132\t.Time"
          + "zone\"\037\n\rPortIdRequest\022\016\n\006portId\030\001 \001(\003\"Z\n"
          + "\021BerthInfoResponse\022\'\n\016responseStatus\030\001 \001"
          + "(\0132\017.ResponseStatus\022\034\n\006berths\030\002 \003(\0132\014.Be"
          + "rthDetail\"\262\002\n\013BerthDetail\022\n\n\002id\030\001 \001(\003\022\016\n"
          + "\006portId\030\002 \001(\003\022\025\n\rloadingInfoId\030\014 \001(\003\022\026\n\016"
          + "maxShipChannel\030\003 \001(\t\022\021\n\tberthName\030\004 \001(\t\022"
          + "\024\n\014maxShipDepth\030\005 \001(\t\022\032\n\022seaDraftLimitat"
          + "ion\030\006 \001(\t\022\032\n\022airDraftLimitation\030\007 \001(\t\022\031\n"
          + "\021maxManifoldHeight\030\010 \001(\t\022 \n\030regulationAn"
          + "dRestriction\030\t \001(\t\022\016\n\006maxLoa\030\n \001(\t\022\020\n\010ma"
          + "xDraft\030\013 \001(\t\022\030\n\020lineDisplacement\030\r \001(\t2\230"
          + "\004\n\017PortInfoService\022)\n\013GetPortInfo\022\014.Port"
          + "Request\032\n.PortReply\"\000\022R\n\024GetPortInfoByCa"
          + "rgoId\022\034.GetPortInfoByCargoIdRequest\032\032.Ge"
          + "tPortInfoByCargoIdReply\"\000\022B\n\024GetPortInfo"
          + "ByPortIds\022\034.GetPortInfoByPortIdsRequest\032"
          + "\n.PortReply\"\000\022G\n\031GetPortInfoDetailsForAl"
          + "go\022\034.GetPortInfoByPortIdsRequest\032\n.PortR"
          + "eply\"\000\0225\n\013GetTimezone\022\021.PortEmptyRequest"
          + "\032\021.TimezoneResponse\"\000\022;\n\023GetPortInfoByPa"
          + "ging\022\026.PortRequestWithPaging\032\n.PortReply"
          + "\"\000\022?\n\027GetBerthDetailsByPortId\022\016.PortIdRe"
          + "quest\032\022.BerthInfoResponse\"\000\022D\n\025GetCargoI"
          + "nfoByPortIds\022\034.GetPortInfoByPortIdsReque"
          + "st\032\013.CargoInfos\"\000B\036\n\032com.cpdss.common.ge"
          + "neratedP\000b\006proto3"
    };
    descriptor =
        com.google.protobuf.Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(
            descriptorData,
            new com.google.protobuf.Descriptors.FileDescriptor[] {
              com.cpdss.common.generated.Common.getDescriptor(),
            });
    internal_static_CargoInfos_descriptor = getDescriptor().getMessageTypes().get(0);
    internal_static_CargoInfos_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_CargoInfos_descriptor,
            new java.lang.String[] {
              "CargoPorts", "ResponseStatus",
            });
    internal_static_CargoPortMapping_descriptor = getDescriptor().getMessageTypes().get(1);
    internal_static_CargoPortMapping_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_CargoPortMapping_descriptor,
            new java.lang.String[] {
              "CargoId", "PortId",
            });
    internal_static_GetPortInfoByPortIdsRequest_descriptor =
        getDescriptor().getMessageTypes().get(2);
    internal_static_GetPortInfoByPortIdsRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_GetPortInfoByPortIdsRequest_descriptor,
            new java.lang.String[] {
              "Id",
            });
    internal_static_PortRequest_descriptor = getDescriptor().getMessageTypes().get(3);
    internal_static_PortRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_PortRequest_descriptor,
            new java.lang.String[] {
              "CompanyId", "VesselId", "VoyageId", "LoadableStudyId",
            });
    internal_static_PortRequestWithPaging_descriptor = getDescriptor().getMessageTypes().get(4);
    internal_static_PortRequestWithPaging_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_PortRequestWithPaging_descriptor,
            new java.lang.String[] {
              "Offset", "Limit",
            });
    internal_static_PortDetail_descriptor = getDescriptor().getMessageTypes().get(5);
    internal_static_PortDetail_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_PortDetail_descriptor,
            new java.lang.String[] {
              "Id",
              "Name",
              "Code",
              "WaterDensity",
              "MaxDraft",
              "MaxAirDraft",
              "AverageTideHeight",
              "TideHeight",
              "HwTideFrom",
              "HwTideTo",
              "LwTideFrom",
              "LwTideTo",
              "HwTideTimeFrom",
              "HwTideTimeTo",
              "LwTideTimeFrom",
              "LwTideTimeTo",
              "SunriseTime",
              "SunsetTime",
              "Timezone",
              "TimezoneOffsetVal",
              "TimezoneId",
              "TimezoneAbbreviation",
              "CountryName",
            });
    internal_static_PortReply_descriptor = getDescriptor().getMessageTypes().get(6);
    internal_static_PortReply_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_PortReply_descriptor,
            new java.lang.String[] {
              "ResponseStatus", "Ports",
            });
    internal_static_GetPortInfoByCargoIdRequest_descriptor =
        getDescriptor().getMessageTypes().get(7);
    internal_static_GetPortInfoByCargoIdRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_GetPortInfoByCargoIdRequest_descriptor,
            new java.lang.String[] {
              "CargoId",
            });
    internal_static_GetPortInfoByCargoIdReply_descriptor = getDescriptor().getMessageTypes().get(8);
    internal_static_GetPortInfoByCargoIdReply_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_GetPortInfoByCargoIdReply_descriptor,
            new java.lang.String[] {
              "ResponseStatus", "Ports",
            });
    internal_static_PortEmptyRequest_descriptor = getDescriptor().getMessageTypes().get(9);
    internal_static_PortEmptyRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_PortEmptyRequest_descriptor, new java.lang.String[] {});
    internal_static_Timezone_descriptor = getDescriptor().getMessageTypes().get(10);
    internal_static_Timezone_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_Timezone_descriptor,
            new java.lang.String[] {
              "Id", "Timezone", "OffsetValue", "Abbreviation",
            });
    internal_static_TimezoneResponse_descriptor = getDescriptor().getMessageTypes().get(11);
    internal_static_TimezoneResponse_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_TimezoneResponse_descriptor,
            new java.lang.String[] {
              "ResponseStatus", "Timezones",
            });
    internal_static_PortIdRequest_descriptor = getDescriptor().getMessageTypes().get(12);
    internal_static_PortIdRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_PortIdRequest_descriptor,
            new java.lang.String[] {
              "PortId",
            });
    internal_static_BerthInfoResponse_descriptor = getDescriptor().getMessageTypes().get(13);
    internal_static_BerthInfoResponse_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_BerthInfoResponse_descriptor,
            new java.lang.String[] {
              "ResponseStatus", "Berths",
            });
    internal_static_BerthDetail_descriptor = getDescriptor().getMessageTypes().get(14);
    internal_static_BerthDetail_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_BerthDetail_descriptor,
            new java.lang.String[] {
              "Id",
              "PortId",
              "LoadingInfoId",
              "MaxShipChannel",
              "BerthName",
              "MaxShipDepth",
              "SeaDraftLimitation",
              "AirDraftLimitation",
              "MaxManifoldHeight",
              "RegulationAndRestriction",
              "MaxLoa",
              "MaxDraft",
              "LineDisplacement",
            });
    com.cpdss.common.generated.Common.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
