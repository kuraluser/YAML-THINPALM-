/* Licensed at AlphaOri Technologies */
package com.cpdss.common.generated;

public final class EnvoyReader {
  private EnvoyReader() {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistryLite registry) {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions((com.google.protobuf.ExtensionRegistryLite) registry);
  }

  public interface EnvoyReaderResultRequestOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:EnvoyReaderResultRequest)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>string messageType = 1;</code>
     *
     * @return The messageType.
     */
    java.lang.String getMessageType();
    /**
     * <code>string messageType = 1;</code>
     *
     * @return The bytes for messageType.
     */
    com.google.protobuf.ByteString getMessageTypeBytes();

    /**
     * <code>string clientId = 2;</code>
     *
     * @return The clientId.
     */
    java.lang.String getClientId();
    /**
     * <code>string clientId = 2;</code>
     *
     * @return The bytes for clientId.
     */
    com.google.protobuf.ByteString getClientIdBytes();

    /**
     * <code>string shipId = 3;</code>
     *
     * @return The shipId.
     */
    java.lang.String getShipId();
    /**
     * <code>string shipId = 3;</code>
     *
     * @return The bytes for shipId.
     */
    com.google.protobuf.ByteString getShipIdBytes();

    /**
     * <code>int64 vesselId = 4;</code>
     *
     * @return The vesselId.
     */
    long getVesselId();
  }
  /** Protobuf type {@code EnvoyReaderResultRequest} */
  public static final class EnvoyReaderResultRequest extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:EnvoyReaderResultRequest)
      EnvoyReaderResultRequestOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use EnvoyReaderResultRequest.newBuilder() to construct.
    private EnvoyReaderResultRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private EnvoyReaderResultRequest() {
      messageType_ = "";
      clientId_ = "";
      shipId_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new EnvoyReaderResultRequest();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private EnvoyReaderResultRequest(
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

                messageType_ = s;
                break;
              }
            case 18:
              {
                java.lang.String s = input.readStringRequireUtf8();

                clientId_ = s;
                break;
              }
            case 26:
              {
                java.lang.String s = input.readStringRequireUtf8();

                shipId_ = s;
                break;
              }
            case 32:
              {
                vesselId_ = input.readInt64();
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
      return com.cpdss.common.generated.EnvoyReader
          .internal_static_EnvoyReaderResultRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.EnvoyReader
          .internal_static_EnvoyReaderResultRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultRequest.class,
              com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultRequest.Builder.class);
    }

    public static final int MESSAGETYPE_FIELD_NUMBER = 1;
    private volatile java.lang.Object messageType_;
    /**
     * <code>string messageType = 1;</code>
     *
     * @return The messageType.
     */
    public java.lang.String getMessageType() {
      java.lang.Object ref = messageType_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        messageType_ = s;
        return s;
      }
    }
    /**
     * <code>string messageType = 1;</code>
     *
     * @return The bytes for messageType.
     */
    public com.google.protobuf.ByteString getMessageTypeBytes() {
      java.lang.Object ref = messageType_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        messageType_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int CLIENTID_FIELD_NUMBER = 2;
    private volatile java.lang.Object clientId_;
    /**
     * <code>string clientId = 2;</code>
     *
     * @return The clientId.
     */
    public java.lang.String getClientId() {
      java.lang.Object ref = clientId_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        clientId_ = s;
        return s;
      }
    }
    /**
     * <code>string clientId = 2;</code>
     *
     * @return The bytes for clientId.
     */
    public com.google.protobuf.ByteString getClientIdBytes() {
      java.lang.Object ref = clientId_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        clientId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int SHIPID_FIELD_NUMBER = 3;
    private volatile java.lang.Object shipId_;
    /**
     * <code>string shipId = 3;</code>
     *
     * @return The shipId.
     */
    public java.lang.String getShipId() {
      java.lang.Object ref = shipId_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        shipId_ = s;
        return s;
      }
    }
    /**
     * <code>string shipId = 3;</code>
     *
     * @return The bytes for shipId.
     */
    public com.google.protobuf.ByteString getShipIdBytes() {
      java.lang.Object ref = shipId_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        shipId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int VESSELID_FIELD_NUMBER = 4;
    private long vesselId_;
    /**
     * <code>int64 vesselId = 4;</code>
     *
     * @return The vesselId.
     */
    public long getVesselId() {
      return vesselId_;
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
      if (!getMessageTypeBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, messageType_);
      }
      if (!getClientIdBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, clientId_);
      }
      if (!getShipIdBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, shipId_);
      }
      if (vesselId_ != 0L) {
        output.writeInt64(4, vesselId_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getMessageTypeBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, messageType_);
      }
      if (!getClientIdBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, clientId_);
      }
      if (!getShipIdBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, shipId_);
      }
      if (vesselId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(4, vesselId_);
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
      if (!(obj instanceof com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultRequest)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultRequest other =
          (com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultRequest) obj;

      if (!getMessageType().equals(other.getMessageType())) return false;
      if (!getClientId().equals(other.getClientId())) return false;
      if (!getShipId().equals(other.getShipId())) return false;
      if (getVesselId() != other.getVesselId()) return false;
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
      hash = (37 * hash) + MESSAGETYPE_FIELD_NUMBER;
      hash = (53 * hash) + getMessageType().hashCode();
      hash = (37 * hash) + CLIENTID_FIELD_NUMBER;
      hash = (53 * hash) + getClientId().hashCode();
      hash = (37 * hash) + SHIPID_FIELD_NUMBER;
      hash = (53 * hash) + getShipId().hashCode();
      hash = (37 * hash) + VESSELID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getVesselId());
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultRequest parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultRequest parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultRequest parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultRequest parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultRequest parseFrom(
        byte[] data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultRequest parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultRequest parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultRequest parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultRequest
        parseDelimitedFrom(java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultRequest
        parseDelimitedFrom(
            java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultRequest parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultRequest parseFrom(
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
        com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultRequest prototype) {
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
    /** Protobuf type {@code EnvoyReaderResultRequest} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:EnvoyReaderResultRequest)
        com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultRequestOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.EnvoyReader
            .internal_static_EnvoyReaderResultRequest_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.EnvoyReader
            .internal_static_EnvoyReaderResultRequest_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultRequest.class,
                com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultRequest.Builder.class);
      }

      // Construct using
      // com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultRequest.newBuilder()
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
        messageType_ = "";

        clientId_ = "";

        shipId_ = "";

        vesselId_ = 0L;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.EnvoyReader
            .internal_static_EnvoyReaderResultRequest_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultRequest
          getDefaultInstanceForType() {
        return com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultRequest.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultRequest build() {
        com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultRequest result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultRequest buildPartial() {
        com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultRequest result =
            new com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultRequest(this);
        result.messageType_ = messageType_;
        result.clientId_ = clientId_;
        result.shipId_ = shipId_;
        result.vesselId_ = vesselId_;
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
        if (other instanceof com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultRequest) {
          return mergeFrom((com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultRequest) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(
          com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultRequest other) {
        if (other
            == com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultRequest.getDefaultInstance())
          return this;
        if (!other.getMessageType().isEmpty()) {
          messageType_ = other.messageType_;
          onChanged();
        }
        if (!other.getClientId().isEmpty()) {
          clientId_ = other.clientId_;
          onChanged();
        }
        if (!other.getShipId().isEmpty()) {
          shipId_ = other.shipId_;
          onChanged();
        }
        if (other.getVesselId() != 0L) {
          setVesselId(other.getVesselId());
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
        com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultRequest parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultRequest)
                  e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private java.lang.Object messageType_ = "";
      /**
       * <code>string messageType = 1;</code>
       *
       * @return The messageType.
       */
      public java.lang.String getMessageType() {
        java.lang.Object ref = messageType_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          messageType_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string messageType = 1;</code>
       *
       * @return The bytes for messageType.
       */
      public com.google.protobuf.ByteString getMessageTypeBytes() {
        java.lang.Object ref = messageType_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          messageType_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string messageType = 1;</code>
       *
       * @param value The messageType to set.
       * @return This builder for chaining.
       */
      public Builder setMessageType(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        messageType_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string messageType = 1;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearMessageType() {

        messageType_ = getDefaultInstance().getMessageType();
        onChanged();
        return this;
      }
      /**
       * <code>string messageType = 1;</code>
       *
       * @param value The bytes for messageType to set.
       * @return This builder for chaining.
       */
      public Builder setMessageTypeBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        messageType_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object clientId_ = "";
      /**
       * <code>string clientId = 2;</code>
       *
       * @return The clientId.
       */
      public java.lang.String getClientId() {
        java.lang.Object ref = clientId_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          clientId_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string clientId = 2;</code>
       *
       * @return The bytes for clientId.
       */
      public com.google.protobuf.ByteString getClientIdBytes() {
        java.lang.Object ref = clientId_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          clientId_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string clientId = 2;</code>
       *
       * @param value The clientId to set.
       * @return This builder for chaining.
       */
      public Builder setClientId(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        clientId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string clientId = 2;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearClientId() {

        clientId_ = getDefaultInstance().getClientId();
        onChanged();
        return this;
      }
      /**
       * <code>string clientId = 2;</code>
       *
       * @param value The bytes for clientId to set.
       * @return This builder for chaining.
       */
      public Builder setClientIdBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        clientId_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object shipId_ = "";
      /**
       * <code>string shipId = 3;</code>
       *
       * @return The shipId.
       */
      public java.lang.String getShipId() {
        java.lang.Object ref = shipId_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          shipId_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string shipId = 3;</code>
       *
       * @return The bytes for shipId.
       */
      public com.google.protobuf.ByteString getShipIdBytes() {
        java.lang.Object ref = shipId_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          shipId_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string shipId = 3;</code>
       *
       * @param value The shipId to set.
       * @return This builder for chaining.
       */
      public Builder setShipId(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        shipId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string shipId = 3;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearShipId() {

        shipId_ = getDefaultInstance().getShipId();
        onChanged();
        return this;
      }
      /**
       * <code>string shipId = 3;</code>
       *
       * @param value The bytes for shipId to set.
       * @return This builder for chaining.
       */
      public Builder setShipIdBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        shipId_ = value;
        onChanged();
        return this;
      }

      private long vesselId_;
      /**
       * <code>int64 vesselId = 4;</code>
       *
       * @return The vesselId.
       */
      public long getVesselId() {
        return vesselId_;
      }
      /**
       * <code>int64 vesselId = 4;</code>
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
       * <code>int64 vesselId = 4;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearVesselId() {

        vesselId_ = 0L;
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

      // @@protoc_insertion_point(builder_scope:EnvoyReaderResultRequest)
    }

    // @@protoc_insertion_point(class_scope:EnvoyReaderResultRequest)
    private static final com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultRequest
        DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultRequest();
    }

    public static com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultRequest
        getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<EnvoyReaderResultRequest> PARSER =
        new com.google.protobuf.AbstractParser<EnvoyReaderResultRequest>() {
          @java.lang.Override
          public EnvoyReaderResultRequest parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new EnvoyReaderResultRequest(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<EnvoyReaderResultRequest> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<EnvoyReaderResultRequest> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultRequest
        getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface EnvoyReaderResultReplyOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:EnvoyReaderResultReply)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>string patternResultJson = 1;</code>
     *
     * @return The patternResultJson.
     */
    java.lang.String getPatternResultJson();
    /**
     * <code>string patternResultJson = 1;</code>
     *
     * @return The bytes for patternResultJson.
     */
    com.google.protobuf.ByteString getPatternResultJsonBytes();

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

    /**
     * <code>string messageType = 3;</code>
     *
     * @return The messageType.
     */
    java.lang.String getMessageType();
    /**
     * <code>string messageType = 3;</code>
     *
     * @return The bytes for messageType.
     */
    com.google.protobuf.ByteString getMessageTypeBytes();

    /**
     * <code>string clientId = 4;</code>
     *
     * @return The clientId.
     */
    java.lang.String getClientId();
    /**
     * <code>string clientId = 4;</code>
     *
     * @return The bytes for clientId.
     */
    com.google.protobuf.ByteString getClientIdBytes();

    /**
     * <code>string messageId = 5;</code>
     *
     * @return The messageId.
     */
    java.lang.String getMessageId();
    /**
     * <code>string messageId = 5;</code>
     *
     * @return The bytes for messageId.
     */
    com.google.protobuf.ByteString getMessageIdBytes();
  }
  /** Protobuf type {@code EnvoyReaderResultReply} */
  public static final class EnvoyReaderResultReply extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:EnvoyReaderResultReply)
      EnvoyReaderResultReplyOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use EnvoyReaderResultReply.newBuilder() to construct.
    private EnvoyReaderResultReply(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private EnvoyReaderResultReply() {
      patternResultJson_ = "";
      messageType_ = "";
      clientId_ = "";
      messageId_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new EnvoyReaderResultReply();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private EnvoyReaderResultReply(
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

                patternResultJson_ = s;
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
            case 26:
              {
                java.lang.String s = input.readStringRequireUtf8();

                messageType_ = s;
                break;
              }
            case 34:
              {
                java.lang.String s = input.readStringRequireUtf8();

                clientId_ = s;
                break;
              }
            case 42:
              {
                java.lang.String s = input.readStringRequireUtf8();

                messageId_ = s;
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
      return com.cpdss.common.generated.EnvoyReader
          .internal_static_EnvoyReaderResultReply_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.EnvoyReader
          .internal_static_EnvoyReaderResultReply_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultReply.class,
              com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultReply.Builder.class);
    }

    public static final int PATTERNRESULTJSON_FIELD_NUMBER = 1;
    private volatile java.lang.Object patternResultJson_;
    /**
     * <code>string patternResultJson = 1;</code>
     *
     * @return The patternResultJson.
     */
    public java.lang.String getPatternResultJson() {
      java.lang.Object ref = patternResultJson_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        patternResultJson_ = s;
        return s;
      }
    }
    /**
     * <code>string patternResultJson = 1;</code>
     *
     * @return The bytes for patternResultJson.
     */
    public com.google.protobuf.ByteString getPatternResultJsonBytes() {
      java.lang.Object ref = patternResultJson_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        patternResultJson_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
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

    public static final int MESSAGETYPE_FIELD_NUMBER = 3;
    private volatile java.lang.Object messageType_;
    /**
     * <code>string messageType = 3;</code>
     *
     * @return The messageType.
     */
    public java.lang.String getMessageType() {
      java.lang.Object ref = messageType_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        messageType_ = s;
        return s;
      }
    }
    /**
     * <code>string messageType = 3;</code>
     *
     * @return The bytes for messageType.
     */
    public com.google.protobuf.ByteString getMessageTypeBytes() {
      java.lang.Object ref = messageType_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        messageType_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int CLIENTID_FIELD_NUMBER = 4;
    private volatile java.lang.Object clientId_;
    /**
     * <code>string clientId = 4;</code>
     *
     * @return The clientId.
     */
    public java.lang.String getClientId() {
      java.lang.Object ref = clientId_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        clientId_ = s;
        return s;
      }
    }
    /**
     * <code>string clientId = 4;</code>
     *
     * @return The bytes for clientId.
     */
    public com.google.protobuf.ByteString getClientIdBytes() {
      java.lang.Object ref = clientId_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        clientId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int MESSAGEID_FIELD_NUMBER = 5;
    private volatile java.lang.Object messageId_;
    /**
     * <code>string messageId = 5;</code>
     *
     * @return The messageId.
     */
    public java.lang.String getMessageId() {
      java.lang.Object ref = messageId_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        messageId_ = s;
        return s;
      }
    }
    /**
     * <code>string messageId = 5;</code>
     *
     * @return The bytes for messageId.
     */
    public com.google.protobuf.ByteString getMessageIdBytes() {
      java.lang.Object ref = messageId_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        messageId_ = b;
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
      if (!getPatternResultJsonBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, patternResultJson_);
      }
      if (responseStatus_ != null) {
        output.writeMessage(2, getResponseStatus());
      }
      if (!getMessageTypeBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, messageType_);
      }
      if (!getClientIdBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 4, clientId_);
      }
      if (!getMessageIdBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 5, messageId_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getPatternResultJsonBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, patternResultJson_);
      }
      if (responseStatus_ != null) {
        size += com.google.protobuf.CodedOutputStream.computeMessageSize(2, getResponseStatus());
      }
      if (!getMessageTypeBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, messageType_);
      }
      if (!getClientIdBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, clientId_);
      }
      if (!getMessageIdBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, messageId_);
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
      if (!(obj instanceof com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultReply)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultReply other =
          (com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultReply) obj;

      if (!getPatternResultJson().equals(other.getPatternResultJson())) return false;
      if (hasResponseStatus() != other.hasResponseStatus()) return false;
      if (hasResponseStatus()) {
        if (!getResponseStatus().equals(other.getResponseStatus())) return false;
      }
      if (!getMessageType().equals(other.getMessageType())) return false;
      if (!getClientId().equals(other.getClientId())) return false;
      if (!getMessageId().equals(other.getMessageId())) return false;
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
      hash = (37 * hash) + PATTERNRESULTJSON_FIELD_NUMBER;
      hash = (53 * hash) + getPatternResultJson().hashCode();
      if (hasResponseStatus()) {
        hash = (37 * hash) + RESPONSESTATUS_FIELD_NUMBER;
        hash = (53 * hash) + getResponseStatus().hashCode();
      }
      hash = (37 * hash) + MESSAGETYPE_FIELD_NUMBER;
      hash = (53 * hash) + getMessageType().hashCode();
      hash = (37 * hash) + CLIENTID_FIELD_NUMBER;
      hash = (53 * hash) + getClientId().hashCode();
      hash = (37 * hash) + MESSAGEID_FIELD_NUMBER;
      hash = (53 * hash) + getMessageId().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultReply parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultReply parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultReply parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultReply parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultReply parseFrom(
        byte[] data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultReply parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultReply parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultReply parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultReply parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultReply parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultReply parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultReply parseFrom(
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
        com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultReply prototype) {
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
    /** Protobuf type {@code EnvoyReaderResultReply} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:EnvoyReaderResultReply)
        com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultReplyOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.EnvoyReader
            .internal_static_EnvoyReaderResultReply_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.EnvoyReader
            .internal_static_EnvoyReaderResultReply_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultReply.class,
                com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultReply.Builder.class);
      }

      // Construct using com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultReply.newBuilder()
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
        patternResultJson_ = "";

        if (responseStatusBuilder_ == null) {
          responseStatus_ = null;
        } else {
          responseStatus_ = null;
          responseStatusBuilder_ = null;
        }
        messageType_ = "";

        clientId_ = "";

        messageId_ = "";

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.EnvoyReader
            .internal_static_EnvoyReaderResultReply_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultReply
          getDefaultInstanceForType() {
        return com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultReply.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultReply build() {
        com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultReply result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultReply buildPartial() {
        com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultReply result =
            new com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultReply(this);
        result.patternResultJson_ = patternResultJson_;
        if (responseStatusBuilder_ == null) {
          result.responseStatus_ = responseStatus_;
        } else {
          result.responseStatus_ = responseStatusBuilder_.build();
        }
        result.messageType_ = messageType_;
        result.clientId_ = clientId_;
        result.messageId_ = messageId_;
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
        if (other instanceof com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultReply) {
          return mergeFrom((com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultReply) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(
          com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultReply other) {
        if (other
            == com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultReply.getDefaultInstance())
          return this;
        if (!other.getPatternResultJson().isEmpty()) {
          patternResultJson_ = other.patternResultJson_;
          onChanged();
        }
        if (other.hasResponseStatus()) {
          mergeResponseStatus(other.getResponseStatus());
        }
        if (!other.getMessageType().isEmpty()) {
          messageType_ = other.messageType_;
          onChanged();
        }
        if (!other.getClientId().isEmpty()) {
          clientId_ = other.clientId_;
          onChanged();
        }
        if (!other.getMessageId().isEmpty()) {
          messageId_ = other.messageId_;
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
        com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultReply parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultReply)
                  e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private java.lang.Object patternResultJson_ = "";
      /**
       * <code>string patternResultJson = 1;</code>
       *
       * @return The patternResultJson.
       */
      public java.lang.String getPatternResultJson() {
        java.lang.Object ref = patternResultJson_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          patternResultJson_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string patternResultJson = 1;</code>
       *
       * @return The bytes for patternResultJson.
       */
      public com.google.protobuf.ByteString getPatternResultJsonBytes() {
        java.lang.Object ref = patternResultJson_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          patternResultJson_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string patternResultJson = 1;</code>
       *
       * @param value The patternResultJson to set.
       * @return This builder for chaining.
       */
      public Builder setPatternResultJson(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        patternResultJson_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string patternResultJson = 1;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearPatternResultJson() {

        patternResultJson_ = getDefaultInstance().getPatternResultJson();
        onChanged();
        return this;
      }
      /**
       * <code>string patternResultJson = 1;</code>
       *
       * @param value The bytes for patternResultJson to set.
       * @return This builder for chaining.
       */
      public Builder setPatternResultJsonBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        patternResultJson_ = value;
        onChanged();
        return this;
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

      private java.lang.Object messageType_ = "";
      /**
       * <code>string messageType = 3;</code>
       *
       * @return The messageType.
       */
      public java.lang.String getMessageType() {
        java.lang.Object ref = messageType_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          messageType_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string messageType = 3;</code>
       *
       * @return The bytes for messageType.
       */
      public com.google.protobuf.ByteString getMessageTypeBytes() {
        java.lang.Object ref = messageType_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          messageType_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string messageType = 3;</code>
       *
       * @param value The messageType to set.
       * @return This builder for chaining.
       */
      public Builder setMessageType(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        messageType_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string messageType = 3;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearMessageType() {

        messageType_ = getDefaultInstance().getMessageType();
        onChanged();
        return this;
      }
      /**
       * <code>string messageType = 3;</code>
       *
       * @param value The bytes for messageType to set.
       * @return This builder for chaining.
       */
      public Builder setMessageTypeBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        messageType_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object clientId_ = "";
      /**
       * <code>string clientId = 4;</code>
       *
       * @return The clientId.
       */
      public java.lang.String getClientId() {
        java.lang.Object ref = clientId_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          clientId_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string clientId = 4;</code>
       *
       * @return The bytes for clientId.
       */
      public com.google.protobuf.ByteString getClientIdBytes() {
        java.lang.Object ref = clientId_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          clientId_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string clientId = 4;</code>
       *
       * @param value The clientId to set.
       * @return This builder for chaining.
       */
      public Builder setClientId(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        clientId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string clientId = 4;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearClientId() {

        clientId_ = getDefaultInstance().getClientId();
        onChanged();
        return this;
      }
      /**
       * <code>string clientId = 4;</code>
       *
       * @param value The bytes for clientId to set.
       * @return This builder for chaining.
       */
      public Builder setClientIdBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        clientId_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object messageId_ = "";
      /**
       * <code>string messageId = 5;</code>
       *
       * @return The messageId.
       */
      public java.lang.String getMessageId() {
        java.lang.Object ref = messageId_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          messageId_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string messageId = 5;</code>
       *
       * @return The bytes for messageId.
       */
      public com.google.protobuf.ByteString getMessageIdBytes() {
        java.lang.Object ref = messageId_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          messageId_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string messageId = 5;</code>
       *
       * @param value The messageId to set.
       * @return This builder for chaining.
       */
      public Builder setMessageId(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        messageId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string messageId = 5;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearMessageId() {

        messageId_ = getDefaultInstance().getMessageId();
        onChanged();
        return this;
      }
      /**
       * <code>string messageId = 5;</code>
       *
       * @param value The bytes for messageId to set.
       * @return This builder for chaining.
       */
      public Builder setMessageIdBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        messageId_ = value;
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

      // @@protoc_insertion_point(builder_scope:EnvoyReaderResultReply)
    }

    // @@protoc_insertion_point(class_scope:EnvoyReaderResultReply)
    private static final com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultReply
        DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultReply();
    }

    public static com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultReply
        getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<EnvoyReaderResultReply> PARSER =
        new com.google.protobuf.AbstractParser<EnvoyReaderResultReply>() {
          @java.lang.Override
          public EnvoyReaderResultReply parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new EnvoyReaderResultReply(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<EnvoyReaderResultReply> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<EnvoyReaderResultReply> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.EnvoyReader.EnvoyReaderResultReply
        getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface EnvoyReaderStatusReplyOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:EnvoyReaderStatusReply)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>string downloadStatus = 1;</code>
     *
     * @return The downloadStatus.
     */
    java.lang.String getDownloadStatus();
    /**
     * <code>string downloadStatus = 1;</code>
     *
     * @return The bytes for downloadStatus.
     */
    com.google.protobuf.ByteString getDownloadStatusBytes();

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

    /**
     *
     *
     * <pre>
     * imoNumber
     * </pre>
     *
     * <code>string shipId = 3;</code>
     *
     * @return The shipId.
     */
    java.lang.String getShipId();
    /**
     *
     *
     * <pre>
     * imoNumber
     * </pre>
     *
     * <code>string shipId = 3;</code>
     *
     * @return The bytes for shipId.
     */
    com.google.protobuf.ByteString getShipIdBytes();

    /**
     * <code>string clientId = 4;</code>
     *
     * @return The clientId.
     */
    java.lang.String getClientId();
    /**
     * <code>string clientId = 4;</code>
     *
     * @return The bytes for clientId.
     */
    com.google.protobuf.ByteString getClientIdBytes();

    /**
     * <code>string messageType = 5;</code>
     *
     * @return The messageType.
     */
    java.lang.String getMessageType();
    /**
     * <code>string messageType = 5;</code>
     *
     * @return The bytes for messageType.
     */
    com.google.protobuf.ByteString getMessageTypeBytes();

    /**
     * <code>string uuid = 6;</code>
     *
     * @return The uuid.
     */
    java.lang.String getUuid();
    /**
     * <code>string uuid = 6;</code>
     *
     * @return The bytes for uuid.
     */
    com.google.protobuf.ByteString getUuidBytes();
  }
  /** Protobuf type {@code EnvoyReaderStatusReply} */
  public static final class EnvoyReaderStatusReply extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:EnvoyReaderStatusReply)
      EnvoyReaderStatusReplyOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use EnvoyReaderStatusReply.newBuilder() to construct.
    private EnvoyReaderStatusReply(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private EnvoyReaderStatusReply() {
      downloadStatus_ = "";
      shipId_ = "";
      clientId_ = "";
      messageType_ = "";
      uuid_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new EnvoyReaderStatusReply();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private EnvoyReaderStatusReply(
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

                downloadStatus_ = s;
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
            case 26:
              {
                java.lang.String s = input.readStringRequireUtf8();

                shipId_ = s;
                break;
              }
            case 34:
              {
                java.lang.String s = input.readStringRequireUtf8();

                clientId_ = s;
                break;
              }
            case 42:
              {
                java.lang.String s = input.readStringRequireUtf8();

                messageType_ = s;
                break;
              }
            case 50:
              {
                java.lang.String s = input.readStringRequireUtf8();

                uuid_ = s;
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
      return com.cpdss.common.generated.EnvoyReader
          .internal_static_EnvoyReaderStatusReply_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.EnvoyReader
          .internal_static_EnvoyReaderStatusReply_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.EnvoyReader.EnvoyReaderStatusReply.class,
              com.cpdss.common.generated.EnvoyReader.EnvoyReaderStatusReply.Builder.class);
    }

    public static final int DOWNLOADSTATUS_FIELD_NUMBER = 1;
    private volatile java.lang.Object downloadStatus_;
    /**
     * <code>string downloadStatus = 1;</code>
     *
     * @return The downloadStatus.
     */
    public java.lang.String getDownloadStatus() {
      java.lang.Object ref = downloadStatus_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        downloadStatus_ = s;
        return s;
      }
    }
    /**
     * <code>string downloadStatus = 1;</code>
     *
     * @return The bytes for downloadStatus.
     */
    public com.google.protobuf.ByteString getDownloadStatusBytes() {
      java.lang.Object ref = downloadStatus_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        downloadStatus_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
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

    public static final int SHIPID_FIELD_NUMBER = 3;
    private volatile java.lang.Object shipId_;
    /**
     *
     *
     * <pre>
     * imoNumber
     * </pre>
     *
     * <code>string shipId = 3;</code>
     *
     * @return The shipId.
     */
    public java.lang.String getShipId() {
      java.lang.Object ref = shipId_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        shipId_ = s;
        return s;
      }
    }
    /**
     *
     *
     * <pre>
     * imoNumber
     * </pre>
     *
     * <code>string shipId = 3;</code>
     *
     * @return The bytes for shipId.
     */
    public com.google.protobuf.ByteString getShipIdBytes() {
      java.lang.Object ref = shipId_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        shipId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int CLIENTID_FIELD_NUMBER = 4;
    private volatile java.lang.Object clientId_;
    /**
     * <code>string clientId = 4;</code>
     *
     * @return The clientId.
     */
    public java.lang.String getClientId() {
      java.lang.Object ref = clientId_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        clientId_ = s;
        return s;
      }
    }
    /**
     * <code>string clientId = 4;</code>
     *
     * @return The bytes for clientId.
     */
    public com.google.protobuf.ByteString getClientIdBytes() {
      java.lang.Object ref = clientId_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        clientId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int MESSAGETYPE_FIELD_NUMBER = 5;
    private volatile java.lang.Object messageType_;
    /**
     * <code>string messageType = 5;</code>
     *
     * @return The messageType.
     */
    public java.lang.String getMessageType() {
      java.lang.Object ref = messageType_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        messageType_ = s;
        return s;
      }
    }
    /**
     * <code>string messageType = 5;</code>
     *
     * @return The bytes for messageType.
     */
    public com.google.protobuf.ByteString getMessageTypeBytes() {
      java.lang.Object ref = messageType_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        messageType_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int UUID_FIELD_NUMBER = 6;
    private volatile java.lang.Object uuid_;
    /**
     * <code>string uuid = 6;</code>
     *
     * @return The uuid.
     */
    public java.lang.String getUuid() {
      java.lang.Object ref = uuid_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        uuid_ = s;
        return s;
      }
    }
    /**
     * <code>string uuid = 6;</code>
     *
     * @return The bytes for uuid.
     */
    public com.google.protobuf.ByteString getUuidBytes() {
      java.lang.Object ref = uuid_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        uuid_ = b;
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
      if (!getDownloadStatusBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, downloadStatus_);
      }
      if (responseStatus_ != null) {
        output.writeMessage(2, getResponseStatus());
      }
      if (!getShipIdBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, shipId_);
      }
      if (!getClientIdBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 4, clientId_);
      }
      if (!getMessageTypeBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 5, messageType_);
      }
      if (!getUuidBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 6, uuid_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getDownloadStatusBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, downloadStatus_);
      }
      if (responseStatus_ != null) {
        size += com.google.protobuf.CodedOutputStream.computeMessageSize(2, getResponseStatus());
      }
      if (!getShipIdBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, shipId_);
      }
      if (!getClientIdBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, clientId_);
      }
      if (!getMessageTypeBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, messageType_);
      }
      if (!getUuidBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(6, uuid_);
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
      if (!(obj instanceof com.cpdss.common.generated.EnvoyReader.EnvoyReaderStatusReply)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.EnvoyReader.EnvoyReaderStatusReply other =
          (com.cpdss.common.generated.EnvoyReader.EnvoyReaderStatusReply) obj;

      if (!getDownloadStatus().equals(other.getDownloadStatus())) return false;
      if (hasResponseStatus() != other.hasResponseStatus()) return false;
      if (hasResponseStatus()) {
        if (!getResponseStatus().equals(other.getResponseStatus())) return false;
      }
      if (!getShipId().equals(other.getShipId())) return false;
      if (!getClientId().equals(other.getClientId())) return false;
      if (!getMessageType().equals(other.getMessageType())) return false;
      if (!getUuid().equals(other.getUuid())) return false;
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
      hash = (37 * hash) + DOWNLOADSTATUS_FIELD_NUMBER;
      hash = (53 * hash) + getDownloadStatus().hashCode();
      if (hasResponseStatus()) {
        hash = (37 * hash) + RESPONSESTATUS_FIELD_NUMBER;
        hash = (53 * hash) + getResponseStatus().hashCode();
      }
      hash = (37 * hash) + SHIPID_FIELD_NUMBER;
      hash = (53 * hash) + getShipId().hashCode();
      hash = (37 * hash) + CLIENTID_FIELD_NUMBER;
      hash = (53 * hash) + getClientId().hashCode();
      hash = (37 * hash) + MESSAGETYPE_FIELD_NUMBER;
      hash = (53 * hash) + getMessageType().hashCode();
      hash = (37 * hash) + UUID_FIELD_NUMBER;
      hash = (53 * hash) + getUuid().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.EnvoyReader.EnvoyReaderStatusReply parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.EnvoyReader.EnvoyReaderStatusReply parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.EnvoyReader.EnvoyReaderStatusReply parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.EnvoyReader.EnvoyReaderStatusReply parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.EnvoyReader.EnvoyReaderStatusReply parseFrom(
        byte[] data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.EnvoyReader.EnvoyReaderStatusReply parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.EnvoyReader.EnvoyReaderStatusReply parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.EnvoyReader.EnvoyReaderStatusReply parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.EnvoyReader.EnvoyReaderStatusReply parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.EnvoyReader.EnvoyReaderStatusReply parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.EnvoyReader.EnvoyReaderStatusReply parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.EnvoyReader.EnvoyReaderStatusReply parseFrom(
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
        com.cpdss.common.generated.EnvoyReader.EnvoyReaderStatusReply prototype) {
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
    /** Protobuf type {@code EnvoyReaderStatusReply} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:EnvoyReaderStatusReply)
        com.cpdss.common.generated.EnvoyReader.EnvoyReaderStatusReplyOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.EnvoyReader
            .internal_static_EnvoyReaderStatusReply_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.EnvoyReader
            .internal_static_EnvoyReaderStatusReply_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.EnvoyReader.EnvoyReaderStatusReply.class,
                com.cpdss.common.generated.EnvoyReader.EnvoyReaderStatusReply.Builder.class);
      }

      // Construct using com.cpdss.common.generated.EnvoyReader.EnvoyReaderStatusReply.newBuilder()
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
        downloadStatus_ = "";

        if (responseStatusBuilder_ == null) {
          responseStatus_ = null;
        } else {
          responseStatus_ = null;
          responseStatusBuilder_ = null;
        }
        shipId_ = "";

        clientId_ = "";

        messageType_ = "";

        uuid_ = "";

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.EnvoyReader
            .internal_static_EnvoyReaderStatusReply_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.EnvoyReader.EnvoyReaderStatusReply
          getDefaultInstanceForType() {
        return com.cpdss.common.generated.EnvoyReader.EnvoyReaderStatusReply.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.EnvoyReader.EnvoyReaderStatusReply build() {
        com.cpdss.common.generated.EnvoyReader.EnvoyReaderStatusReply result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.EnvoyReader.EnvoyReaderStatusReply buildPartial() {
        com.cpdss.common.generated.EnvoyReader.EnvoyReaderStatusReply result =
            new com.cpdss.common.generated.EnvoyReader.EnvoyReaderStatusReply(this);
        result.downloadStatus_ = downloadStatus_;
        if (responseStatusBuilder_ == null) {
          result.responseStatus_ = responseStatus_;
        } else {
          result.responseStatus_ = responseStatusBuilder_.build();
        }
        result.shipId_ = shipId_;
        result.clientId_ = clientId_;
        result.messageType_ = messageType_;
        result.uuid_ = uuid_;
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
        if (other instanceof com.cpdss.common.generated.EnvoyReader.EnvoyReaderStatusReply) {
          return mergeFrom((com.cpdss.common.generated.EnvoyReader.EnvoyReaderStatusReply) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(
          com.cpdss.common.generated.EnvoyReader.EnvoyReaderStatusReply other) {
        if (other
            == com.cpdss.common.generated.EnvoyReader.EnvoyReaderStatusReply.getDefaultInstance())
          return this;
        if (!other.getDownloadStatus().isEmpty()) {
          downloadStatus_ = other.downloadStatus_;
          onChanged();
        }
        if (other.hasResponseStatus()) {
          mergeResponseStatus(other.getResponseStatus());
        }
        if (!other.getShipId().isEmpty()) {
          shipId_ = other.shipId_;
          onChanged();
        }
        if (!other.getClientId().isEmpty()) {
          clientId_ = other.clientId_;
          onChanged();
        }
        if (!other.getMessageType().isEmpty()) {
          messageType_ = other.messageType_;
          onChanged();
        }
        if (!other.getUuid().isEmpty()) {
          uuid_ = other.uuid_;
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
        com.cpdss.common.generated.EnvoyReader.EnvoyReaderStatusReply parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.EnvoyReader.EnvoyReaderStatusReply)
                  e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private java.lang.Object downloadStatus_ = "";
      /**
       * <code>string downloadStatus = 1;</code>
       *
       * @return The downloadStatus.
       */
      public java.lang.String getDownloadStatus() {
        java.lang.Object ref = downloadStatus_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          downloadStatus_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string downloadStatus = 1;</code>
       *
       * @return The bytes for downloadStatus.
       */
      public com.google.protobuf.ByteString getDownloadStatusBytes() {
        java.lang.Object ref = downloadStatus_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          downloadStatus_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string downloadStatus = 1;</code>
       *
       * @param value The downloadStatus to set.
       * @return This builder for chaining.
       */
      public Builder setDownloadStatus(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        downloadStatus_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string downloadStatus = 1;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearDownloadStatus() {

        downloadStatus_ = getDefaultInstance().getDownloadStatus();
        onChanged();
        return this;
      }
      /**
       * <code>string downloadStatus = 1;</code>
       *
       * @param value The bytes for downloadStatus to set.
       * @return This builder for chaining.
       */
      public Builder setDownloadStatusBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        downloadStatus_ = value;
        onChanged();
        return this;
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

      private java.lang.Object shipId_ = "";
      /**
       *
       *
       * <pre>
       * imoNumber
       * </pre>
       *
       * <code>string shipId = 3;</code>
       *
       * @return The shipId.
       */
      public java.lang.String getShipId() {
        java.lang.Object ref = shipId_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          shipId_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       *
       *
       * <pre>
       * imoNumber
       * </pre>
       *
       * <code>string shipId = 3;</code>
       *
       * @return The bytes for shipId.
       */
      public com.google.protobuf.ByteString getShipIdBytes() {
        java.lang.Object ref = shipId_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          shipId_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       *
       *
       * <pre>
       * imoNumber
       * </pre>
       *
       * <code>string shipId = 3;</code>
       *
       * @param value The shipId to set.
       * @return This builder for chaining.
       */
      public Builder setShipId(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        shipId_ = value;
        onChanged();
        return this;
      }
      /**
       *
       *
       * <pre>
       * imoNumber
       * </pre>
       *
       * <code>string shipId = 3;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearShipId() {

        shipId_ = getDefaultInstance().getShipId();
        onChanged();
        return this;
      }
      /**
       *
       *
       * <pre>
       * imoNumber
       * </pre>
       *
       * <code>string shipId = 3;</code>
       *
       * @param value The bytes for shipId to set.
       * @return This builder for chaining.
       */
      public Builder setShipIdBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        shipId_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object clientId_ = "";
      /**
       * <code>string clientId = 4;</code>
       *
       * @return The clientId.
       */
      public java.lang.String getClientId() {
        java.lang.Object ref = clientId_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          clientId_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string clientId = 4;</code>
       *
       * @return The bytes for clientId.
       */
      public com.google.protobuf.ByteString getClientIdBytes() {
        java.lang.Object ref = clientId_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          clientId_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string clientId = 4;</code>
       *
       * @param value The clientId to set.
       * @return This builder for chaining.
       */
      public Builder setClientId(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        clientId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string clientId = 4;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearClientId() {

        clientId_ = getDefaultInstance().getClientId();
        onChanged();
        return this;
      }
      /**
       * <code>string clientId = 4;</code>
       *
       * @param value The bytes for clientId to set.
       * @return This builder for chaining.
       */
      public Builder setClientIdBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        clientId_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object messageType_ = "";
      /**
       * <code>string messageType = 5;</code>
       *
       * @return The messageType.
       */
      public java.lang.String getMessageType() {
        java.lang.Object ref = messageType_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          messageType_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string messageType = 5;</code>
       *
       * @return The bytes for messageType.
       */
      public com.google.protobuf.ByteString getMessageTypeBytes() {
        java.lang.Object ref = messageType_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          messageType_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string messageType = 5;</code>
       *
       * @param value The messageType to set.
       * @return This builder for chaining.
       */
      public Builder setMessageType(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        messageType_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string messageType = 5;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearMessageType() {

        messageType_ = getDefaultInstance().getMessageType();
        onChanged();
        return this;
      }
      /**
       * <code>string messageType = 5;</code>
       *
       * @param value The bytes for messageType to set.
       * @return This builder for chaining.
       */
      public Builder setMessageTypeBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        messageType_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object uuid_ = "";
      /**
       * <code>string uuid = 6;</code>
       *
       * @return The uuid.
       */
      public java.lang.String getUuid() {
        java.lang.Object ref = uuid_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          uuid_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string uuid = 6;</code>
       *
       * @return The bytes for uuid.
       */
      public com.google.protobuf.ByteString getUuidBytes() {
        java.lang.Object ref = uuid_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          uuid_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string uuid = 6;</code>
       *
       * @param value The uuid to set.
       * @return This builder for chaining.
       */
      public Builder setUuid(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        uuid_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string uuid = 6;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearUuid() {

        uuid_ = getDefaultInstance().getUuid();
        onChanged();
        return this;
      }
      /**
       * <code>string uuid = 6;</code>
       *
       * @param value The bytes for uuid to set.
       * @return This builder for chaining.
       */
      public Builder setUuidBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        uuid_ = value;
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

      // @@protoc_insertion_point(builder_scope:EnvoyReaderStatusReply)
    }

    // @@protoc_insertion_point(class_scope:EnvoyReaderStatusReply)
    private static final com.cpdss.common.generated.EnvoyReader.EnvoyReaderStatusReply
        DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.EnvoyReader.EnvoyReaderStatusReply();
    }

    public static com.cpdss.common.generated.EnvoyReader.EnvoyReaderStatusReply
        getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<EnvoyReaderStatusReply> PARSER =
        new com.google.protobuf.AbstractParser<EnvoyReaderStatusReply>() {
          @java.lang.Override
          public EnvoyReaderStatusReply parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new EnvoyReaderStatusReply(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<EnvoyReaderStatusReply> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<EnvoyReaderStatusReply> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.EnvoyReader.EnvoyReaderStatusReply
        getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_EnvoyReaderResultRequest_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_EnvoyReaderResultRequest_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_EnvoyReaderResultReply_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_EnvoyReaderResultReply_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_EnvoyReaderStatusReply_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_EnvoyReaderStatusReply_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }

  private static com.google.protobuf.Descriptors.FileDescriptor descriptor;

  static {
    java.lang.String[] descriptorData = {
      "\n\022envoy_reader.proto\032\014common.proto\"c\n\030En"
          + "voyReaderResultRequest\022\023\n\013messageType\030\001 "
          + "\001(\t\022\020\n\010clientId\030\002 \001(\t\022\016\n\006shipId\030\003 \001(\t\022\020\n"
          + "\010vesselId\030\004 \001(\003\"\226\001\n\026EnvoyReaderResultRep"
          + "ly\022\031\n\021patternResultJson\030\001 \001(\t\022\'\n\016respons"
          + "eStatus\030\002 \001(\0132\017.ResponseStatus\022\023\n\013messag"
          + "eType\030\003 \001(\t\022\020\n\010clientId\030\004 \001(\t\022\021\n\tmessage"
          + "Id\030\005 \001(\t\"\236\001\n\026EnvoyReaderStatusReply\022\026\n\016d"
          + "ownloadStatus\030\001 \001(\t\022\'\n\016responseStatus\030\002 "
          + "\001(\0132\017.ResponseStatus\022\016\n\006shipId\030\003 \001(\t\022\020\n\010"
          + "clientId\030\004 \001(\t\022\023\n\013messageType\030\005 \001(\t\022\014\n\004u"
          + "uid\030\006 \001(\t2\266\001\n\022EnvoyReaderService\022O\n\027getR"
          + "esultFromCommServer\022\031.EnvoyReaderResultR"
          + "equest\032\027.EnvoyReaderResultReply\"\000\022O\n\027get"
          + "StatusFromCommServer\022\031.EnvoyReaderResult"
          + "Request\032\027.EnvoyReaderResultReply\"\000B\036\n\032co"
          + "m.cpdss.common.generatedP\000b\006proto3"
    };
    descriptor =
        com.google.protobuf.Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(
            descriptorData,
            new com.google.protobuf.Descriptors.FileDescriptor[] {
              com.cpdss.common.generated.Common.getDescriptor(),
            });
    internal_static_EnvoyReaderResultRequest_descriptor = getDescriptor().getMessageTypes().get(0);
    internal_static_EnvoyReaderResultRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_EnvoyReaderResultRequest_descriptor,
            new java.lang.String[] {
              "MessageType", "ClientId", "ShipId", "VesselId",
            });
    internal_static_EnvoyReaderResultReply_descriptor = getDescriptor().getMessageTypes().get(1);
    internal_static_EnvoyReaderResultReply_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_EnvoyReaderResultReply_descriptor,
            new java.lang.String[] {
              "PatternResultJson", "ResponseStatus", "MessageType", "ClientId", "MessageId",
            });
    internal_static_EnvoyReaderStatusReply_descriptor = getDescriptor().getMessageTypes().get(2);
    internal_static_EnvoyReaderStatusReply_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_EnvoyReaderStatusReply_descriptor,
            new java.lang.String[] {
              "DownloadStatus", "ResponseStatus", "ShipId", "ClientId", "MessageType", "Uuid",
            });
    com.cpdss.common.generated.Common.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
