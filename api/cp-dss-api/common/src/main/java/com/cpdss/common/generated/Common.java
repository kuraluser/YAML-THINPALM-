/* Licensed at AlphaOri Technologies */
package com.cpdss.common.generated;

public final class Common {
  private Common() {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistryLite registry) {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions((com.google.protobuf.ExtensionRegistryLite) registry);
  }
  /** Protobuf enum {@code PLANNING_TYPE} */
  public enum PLANNING_TYPE implements com.google.protobuf.ProtocolMessageEnum {
    /** <code>VALUE_A = 0;</code> */
    VALUE_A(0),
    /** <code>LOADABLE_STUDY = 1;</code> */
    LOADABLE_STUDY(1),
    /** <code>DISCHARGE_STUDY = 2;</code> */
    DISCHARGE_STUDY(2),
    UNRECOGNIZED(-1),
    ;

    /** <code>VALUE_A = 0;</code> */
    public static final int VALUE_A_VALUE = 0;
    /** <code>LOADABLE_STUDY = 1;</code> */
    public static final int LOADABLE_STUDY_VALUE = 1;
    /** <code>DISCHARGE_STUDY = 2;</code> */
    public static final int DISCHARGE_STUDY_VALUE = 2;

    public final int getNumber() {
      if (this == UNRECOGNIZED) {
        throw new java.lang.IllegalArgumentException(
            "Can't get the number of an unknown enum value.");
      }
      return value;
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static PLANNING_TYPE valueOf(int value) {
      return forNumber(value);
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     */
    public static PLANNING_TYPE forNumber(int value) {
      switch (value) {
        case 0:
          return VALUE_A;
        case 1:
          return LOADABLE_STUDY;
        case 2:
          return DISCHARGE_STUDY;
        default:
          return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<PLANNING_TYPE> internalGetValueMap() {
      return internalValueMap;
    }

    private static final com.google.protobuf.Internal.EnumLiteMap<PLANNING_TYPE> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<PLANNING_TYPE>() {
          public PLANNING_TYPE findValueByNumber(int number) {
            return PLANNING_TYPE.forNumber(number);
          }
        };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor getValueDescriptor() {
      return getDescriptor().getValues().get(ordinal());
    }

    public final com.google.protobuf.Descriptors.EnumDescriptor getDescriptorForType() {
      return getDescriptor();
    }

    public static final com.google.protobuf.Descriptors.EnumDescriptor getDescriptor() {
      return com.cpdss.common.generated.Common.getDescriptor().getEnumTypes().get(0);
    }

    private static final PLANNING_TYPE[] VALUES = values();

    public static PLANNING_TYPE valueOf(com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException("EnumValueDescriptor is not for this type.");
      }
      if (desc.getIndex() == -1) {
        return UNRECOGNIZED;
      }
      return VALUES[desc.getIndex()];
    }

    private final int value;

    private PLANNING_TYPE(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:PLANNING_TYPE)
  }

  public interface ResponseStatusOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:ResponseStatus)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>string status = 1;</code>
     *
     * @return The status.
     */
    java.lang.String getStatus();
    /**
     * <code>string status = 1;</code>
     *
     * @return The bytes for status.
     */
    com.google.protobuf.ByteString getStatusBytes();

    /**
     * <code>string message = 2;</code>
     *
     * @return The message.
     */
    java.lang.String getMessage();
    /**
     * <code>string message = 2;</code>
     *
     * @return The bytes for message.
     */
    com.google.protobuf.ByteString getMessageBytes();

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
     * <code>int32 httpStatusCode = 4;</code>
     *
     * @return The httpStatusCode.
     */
    int getHttpStatusCode();
  }
  /** Protobuf type {@code ResponseStatus} */
  public static final class ResponseStatus extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:ResponseStatus)
      ResponseStatusOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use ResponseStatus.newBuilder() to construct.
    private ResponseStatus(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private ResponseStatus() {
      status_ = "";
      message_ = "";
      code_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new ResponseStatus();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private ResponseStatus(
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

                status_ = s;
                break;
              }
            case 18:
              {
                java.lang.String s = input.readStringRequireUtf8();

                message_ = s;
                break;
              }
            case 26:
              {
                java.lang.String s = input.readStringRequireUtf8();

                code_ = s;
                break;
              }
            case 32:
              {
                httpStatusCode_ = input.readInt32();
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
      return com.cpdss.common.generated.Common.internal_static_ResponseStatus_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.Common.internal_static_ResponseStatus_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.Common.ResponseStatus.class,
              com.cpdss.common.generated.Common.ResponseStatus.Builder.class);
    }

    public static final int STATUS_FIELD_NUMBER = 1;
    private volatile java.lang.Object status_;
    /**
     * <code>string status = 1;</code>
     *
     * @return The status.
     */
    public java.lang.String getStatus() {
      java.lang.Object ref = status_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        status_ = s;
        return s;
      }
    }
    /**
     * <code>string status = 1;</code>
     *
     * @return The bytes for status.
     */
    public com.google.protobuf.ByteString getStatusBytes() {
      java.lang.Object ref = status_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        status_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int MESSAGE_FIELD_NUMBER = 2;
    private volatile java.lang.Object message_;
    /**
     * <code>string message = 2;</code>
     *
     * @return The message.
     */
    public java.lang.String getMessage() {
      java.lang.Object ref = message_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        message_ = s;
        return s;
      }
    }
    /**
     * <code>string message = 2;</code>
     *
     * @return The bytes for message.
     */
    public com.google.protobuf.ByteString getMessageBytes() {
      java.lang.Object ref = message_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        message_ = b;
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

    public static final int HTTPSTATUSCODE_FIELD_NUMBER = 4;
    private int httpStatusCode_;
    /**
     * <code>int32 httpStatusCode = 4;</code>
     *
     * @return The httpStatusCode.
     */
    public int getHttpStatusCode() {
      return httpStatusCode_;
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
      if (!getStatusBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, status_);
      }
      if (!getMessageBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, message_);
      }
      if (!getCodeBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, code_);
      }
      if (httpStatusCode_ != 0) {
        output.writeInt32(4, httpStatusCode_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getStatusBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, status_);
      }
      if (!getMessageBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, message_);
      }
      if (!getCodeBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, code_);
      }
      if (httpStatusCode_ != 0) {
        size += com.google.protobuf.CodedOutputStream.computeInt32Size(4, httpStatusCode_);
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
      if (!(obj instanceof com.cpdss.common.generated.Common.ResponseStatus)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.Common.ResponseStatus other =
          (com.cpdss.common.generated.Common.ResponseStatus) obj;

      if (!getStatus().equals(other.getStatus())) return false;
      if (!getMessage().equals(other.getMessage())) return false;
      if (!getCode().equals(other.getCode())) return false;
      if (getHttpStatusCode() != other.getHttpStatusCode()) return false;
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
      hash = (37 * hash) + STATUS_FIELD_NUMBER;
      hash = (53 * hash) + getStatus().hashCode();
      hash = (37 * hash) + MESSAGE_FIELD_NUMBER;
      hash = (53 * hash) + getMessage().hashCode();
      hash = (37 * hash) + CODE_FIELD_NUMBER;
      hash = (53 * hash) + getCode().hashCode();
      hash = (37 * hash) + HTTPSTATUSCODE_FIELD_NUMBER;
      hash = (53 * hash) + getHttpStatusCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.Common.ResponseStatus parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Common.ResponseStatus parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.ResponseStatus parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Common.ResponseStatus parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.ResponseStatus parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Common.ResponseStatus parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.ResponseStatus parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Common.ResponseStatus parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.ResponseStatus parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Common.ResponseStatus parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.ResponseStatus parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Common.ResponseStatus parseFrom(
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

    public static Builder newBuilder(com.cpdss.common.generated.Common.ResponseStatus prototype) {
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
    /** Protobuf type {@code ResponseStatus} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:ResponseStatus)
        com.cpdss.common.generated.Common.ResponseStatusOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.Common.internal_static_ResponseStatus_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.Common.internal_static_ResponseStatus_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.Common.ResponseStatus.class,
                com.cpdss.common.generated.Common.ResponseStatus.Builder.class);
      }

      // Construct using com.cpdss.common.generated.Common.ResponseStatus.newBuilder()
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
        status_ = "";

        message_ = "";

        code_ = "";

        httpStatusCode_ = 0;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.Common.internal_static_ResponseStatus_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.Common.ResponseStatus getDefaultInstanceForType() {
        return com.cpdss.common.generated.Common.ResponseStatus.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.Common.ResponseStatus build() {
        com.cpdss.common.generated.Common.ResponseStatus result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.Common.ResponseStatus buildPartial() {
        com.cpdss.common.generated.Common.ResponseStatus result =
            new com.cpdss.common.generated.Common.ResponseStatus(this);
        result.status_ = status_;
        result.message_ = message_;
        result.code_ = code_;
        result.httpStatusCode_ = httpStatusCode_;
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
        if (other instanceof com.cpdss.common.generated.Common.ResponseStatus) {
          return mergeFrom((com.cpdss.common.generated.Common.ResponseStatus) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.cpdss.common.generated.Common.ResponseStatus other) {
        if (other == com.cpdss.common.generated.Common.ResponseStatus.getDefaultInstance())
          return this;
        if (!other.getStatus().isEmpty()) {
          status_ = other.status_;
          onChanged();
        }
        if (!other.getMessage().isEmpty()) {
          message_ = other.message_;
          onChanged();
        }
        if (!other.getCode().isEmpty()) {
          code_ = other.code_;
          onChanged();
        }
        if (other.getHttpStatusCode() != 0) {
          setHttpStatusCode(other.getHttpStatusCode());
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
        com.cpdss.common.generated.Common.ResponseStatus parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.Common.ResponseStatus) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private java.lang.Object status_ = "";
      /**
       * <code>string status = 1;</code>
       *
       * @return The status.
       */
      public java.lang.String getStatus() {
        java.lang.Object ref = status_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          status_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string status = 1;</code>
       *
       * @return The bytes for status.
       */
      public com.google.protobuf.ByteString getStatusBytes() {
        java.lang.Object ref = status_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          status_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string status = 1;</code>
       *
       * @param value The status to set.
       * @return This builder for chaining.
       */
      public Builder setStatus(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        status_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string status = 1;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearStatus() {

        status_ = getDefaultInstance().getStatus();
        onChanged();
        return this;
      }
      /**
       * <code>string status = 1;</code>
       *
       * @param value The bytes for status to set.
       * @return This builder for chaining.
       */
      public Builder setStatusBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        status_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object message_ = "";
      /**
       * <code>string message = 2;</code>
       *
       * @return The message.
       */
      public java.lang.String getMessage() {
        java.lang.Object ref = message_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          message_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string message = 2;</code>
       *
       * @return The bytes for message.
       */
      public com.google.protobuf.ByteString getMessageBytes() {
        java.lang.Object ref = message_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          message_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string message = 2;</code>
       *
       * @param value The message to set.
       * @return This builder for chaining.
       */
      public Builder setMessage(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        message_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string message = 2;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearMessage() {

        message_ = getDefaultInstance().getMessage();
        onChanged();
        return this;
      }
      /**
       * <code>string message = 2;</code>
       *
       * @param value The bytes for message to set.
       * @return This builder for chaining.
       */
      public Builder setMessageBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        message_ = value;
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

      private int httpStatusCode_;
      /**
       * <code>int32 httpStatusCode = 4;</code>
       *
       * @return The httpStatusCode.
       */
      public int getHttpStatusCode() {
        return httpStatusCode_;
      }
      /**
       * <code>int32 httpStatusCode = 4;</code>
       *
       * @param value The httpStatusCode to set.
       * @return This builder for chaining.
       */
      public Builder setHttpStatusCode(int value) {

        httpStatusCode_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 httpStatusCode = 4;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearHttpStatusCode() {

        httpStatusCode_ = 0;
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

      // @@protoc_insertion_point(builder_scope:ResponseStatus)
    }

    // @@protoc_insertion_point(class_scope:ResponseStatus)
    private static final com.cpdss.common.generated.Common.ResponseStatus DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.Common.ResponseStatus();
    }

    public static com.cpdss.common.generated.Common.ResponseStatus getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<ResponseStatus> PARSER =
        new com.google.protobuf.AbstractParser<ResponseStatus>() {
          @java.lang.Override
          public ResponseStatus parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new ResponseStatus(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<ResponseStatus> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<ResponseStatus> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.Common.ResponseStatus getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface BillOfLaddingOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:BillOfLadding)
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
     * <code>int64 cargoId = 3;</code>
     *
     * @return The cargoId.
     */
    long getCargoId();

    /**
     * <code>string quantityBbls = 4;</code>
     *
     * @return The quantityBbls.
     */
    java.lang.String getQuantityBbls();
    /**
     * <code>string quantityBbls = 4;</code>
     *
     * @return The bytes for quantityBbls.
     */
    com.google.protobuf.ByteString getQuantityBblsBytes();

    /**
     * <code>string quantityMt = 5;</code>
     *
     * @return The quantityMt.
     */
    java.lang.String getQuantityMt();
    /**
     * <code>string quantityMt = 5;</code>
     *
     * @return The bytes for quantityMt.
     */
    com.google.protobuf.ByteString getQuantityMtBytes();

    /**
     * <code>string quantityKl = 6;</code>
     *
     * @return The quantityKl.
     */
    java.lang.String getQuantityKl();
    /**
     * <code>string quantityKl = 6;</code>
     *
     * @return The bytes for quantityKl.
     */
    com.google.protobuf.ByteString getQuantityKlBytes();

    /**
     * <code>string api = 7;</code>
     *
     * @return The api.
     */
    java.lang.String getApi();
    /**
     * <code>string api = 7;</code>
     *
     * @return The bytes for api.
     */
    com.google.protobuf.ByteString getApiBytes();

    /**
     * <code>string temperature = 8;</code>
     *
     * @return The temperature.
     */
    java.lang.String getTemperature();
    /**
     * <code>string temperature = 8;</code>
     *
     * @return The bytes for temperature.
     */
    com.google.protobuf.ByteString getTemperatureBytes();
  }
  /** Protobuf type {@code BillOfLadding} */
  public static final class BillOfLadding extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:BillOfLadding)
      BillOfLaddingOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use BillOfLadding.newBuilder() to construct.
    private BillOfLadding(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private BillOfLadding() {
      quantityBbls_ = "";
      quantityMt_ = "";
      quantityKl_ = "";
      api_ = "";
      temperature_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new BillOfLadding();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private BillOfLadding(
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
            case 24:
              {
                cargoId_ = input.readInt64();
                break;
              }
            case 34:
              {
                java.lang.String s = input.readStringRequireUtf8();

                quantityBbls_ = s;
                break;
              }
            case 42:
              {
                java.lang.String s = input.readStringRequireUtf8();

                quantityMt_ = s;
                break;
              }
            case 50:
              {
                java.lang.String s = input.readStringRequireUtf8();

                quantityKl_ = s;
                break;
              }
            case 58:
              {
                java.lang.String s = input.readStringRequireUtf8();

                api_ = s;
                break;
              }
            case 66:
              {
                java.lang.String s = input.readStringRequireUtf8();

                temperature_ = s;
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
      return com.cpdss.common.generated.Common.internal_static_BillOfLadding_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.Common.internal_static_BillOfLadding_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.Common.BillOfLadding.class,
              com.cpdss.common.generated.Common.BillOfLadding.Builder.class);
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

    public static final int CARGOID_FIELD_NUMBER = 3;
    private long cargoId_;
    /**
     * <code>int64 cargoId = 3;</code>
     *
     * @return The cargoId.
     */
    public long getCargoId() {
      return cargoId_;
    }

    public static final int QUANTITYBBLS_FIELD_NUMBER = 4;
    private volatile java.lang.Object quantityBbls_;
    /**
     * <code>string quantityBbls = 4;</code>
     *
     * @return The quantityBbls.
     */
    public java.lang.String getQuantityBbls() {
      java.lang.Object ref = quantityBbls_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        quantityBbls_ = s;
        return s;
      }
    }
    /**
     * <code>string quantityBbls = 4;</code>
     *
     * @return The bytes for quantityBbls.
     */
    public com.google.protobuf.ByteString getQuantityBblsBytes() {
      java.lang.Object ref = quantityBbls_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        quantityBbls_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int QUANTITYMT_FIELD_NUMBER = 5;
    private volatile java.lang.Object quantityMt_;
    /**
     * <code>string quantityMt = 5;</code>
     *
     * @return The quantityMt.
     */
    public java.lang.String getQuantityMt() {
      java.lang.Object ref = quantityMt_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        quantityMt_ = s;
        return s;
      }
    }
    /**
     * <code>string quantityMt = 5;</code>
     *
     * @return The bytes for quantityMt.
     */
    public com.google.protobuf.ByteString getQuantityMtBytes() {
      java.lang.Object ref = quantityMt_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        quantityMt_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int QUANTITYKL_FIELD_NUMBER = 6;
    private volatile java.lang.Object quantityKl_;
    /**
     * <code>string quantityKl = 6;</code>
     *
     * @return The quantityKl.
     */
    public java.lang.String getQuantityKl() {
      java.lang.Object ref = quantityKl_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        quantityKl_ = s;
        return s;
      }
    }
    /**
     * <code>string quantityKl = 6;</code>
     *
     * @return The bytes for quantityKl.
     */
    public com.google.protobuf.ByteString getQuantityKlBytes() {
      java.lang.Object ref = quantityKl_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        quantityKl_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int API_FIELD_NUMBER = 7;
    private volatile java.lang.Object api_;
    /**
     * <code>string api = 7;</code>
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
     * <code>string api = 7;</code>
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

    public static final int TEMPERATURE_FIELD_NUMBER = 8;
    private volatile java.lang.Object temperature_;
    /**
     * <code>string temperature = 8;</code>
     *
     * @return The temperature.
     */
    public java.lang.String getTemperature() {
      java.lang.Object ref = temperature_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        temperature_ = s;
        return s;
      }
    }
    /**
     * <code>string temperature = 8;</code>
     *
     * @return The bytes for temperature.
     */
    public com.google.protobuf.ByteString getTemperatureBytes() {
      java.lang.Object ref = temperature_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        temperature_ = b;
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
      if (cargoId_ != 0L) {
        output.writeInt64(3, cargoId_);
      }
      if (!getQuantityBblsBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 4, quantityBbls_);
      }
      if (!getQuantityMtBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 5, quantityMt_);
      }
      if (!getQuantityKlBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 6, quantityKl_);
      }
      if (!getApiBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 7, api_);
      }
      if (!getTemperatureBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 8, temperature_);
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
      if (cargoId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(3, cargoId_);
      }
      if (!getQuantityBblsBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, quantityBbls_);
      }
      if (!getQuantityMtBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, quantityMt_);
      }
      if (!getQuantityKlBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(6, quantityKl_);
      }
      if (!getApiBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(7, api_);
      }
      if (!getTemperatureBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(8, temperature_);
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
      if (!(obj instanceof com.cpdss.common.generated.Common.BillOfLadding)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.Common.BillOfLadding other =
          (com.cpdss.common.generated.Common.BillOfLadding) obj;

      if (getId() != other.getId()) return false;
      if (getPortId() != other.getPortId()) return false;
      if (getCargoId() != other.getCargoId()) return false;
      if (!getQuantityBbls().equals(other.getQuantityBbls())) return false;
      if (!getQuantityMt().equals(other.getQuantityMt())) return false;
      if (!getQuantityKl().equals(other.getQuantityKl())) return false;
      if (!getApi().equals(other.getApi())) return false;
      if (!getTemperature().equals(other.getTemperature())) return false;
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
      hash = (37 * hash) + CARGOID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getCargoId());
      hash = (37 * hash) + QUANTITYBBLS_FIELD_NUMBER;
      hash = (53 * hash) + getQuantityBbls().hashCode();
      hash = (37 * hash) + QUANTITYMT_FIELD_NUMBER;
      hash = (53 * hash) + getQuantityMt().hashCode();
      hash = (37 * hash) + QUANTITYKL_FIELD_NUMBER;
      hash = (53 * hash) + getQuantityKl().hashCode();
      hash = (37 * hash) + API_FIELD_NUMBER;
      hash = (53 * hash) + getApi().hashCode();
      hash = (37 * hash) + TEMPERATURE_FIELD_NUMBER;
      hash = (53 * hash) + getTemperature().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.Common.BillOfLadding parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Common.BillOfLadding parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.BillOfLadding parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Common.BillOfLadding parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.BillOfLadding parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Common.BillOfLadding parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.BillOfLadding parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Common.BillOfLadding parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.BillOfLadding parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Common.BillOfLadding parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.BillOfLadding parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Common.BillOfLadding parseFrom(
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

    public static Builder newBuilder(com.cpdss.common.generated.Common.BillOfLadding prototype) {
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
    /** Protobuf type {@code BillOfLadding} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:BillOfLadding)
        com.cpdss.common.generated.Common.BillOfLaddingOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.Common.internal_static_BillOfLadding_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.Common.internal_static_BillOfLadding_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.Common.BillOfLadding.class,
                com.cpdss.common.generated.Common.BillOfLadding.Builder.class);
      }

      // Construct using com.cpdss.common.generated.Common.BillOfLadding.newBuilder()
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

        cargoId_ = 0L;

        quantityBbls_ = "";

        quantityMt_ = "";

        quantityKl_ = "";

        api_ = "";

        temperature_ = "";

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.Common.internal_static_BillOfLadding_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.Common.BillOfLadding getDefaultInstanceForType() {
        return com.cpdss.common.generated.Common.BillOfLadding.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.Common.BillOfLadding build() {
        com.cpdss.common.generated.Common.BillOfLadding result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.Common.BillOfLadding buildPartial() {
        com.cpdss.common.generated.Common.BillOfLadding result =
            new com.cpdss.common.generated.Common.BillOfLadding(this);
        result.id_ = id_;
        result.portId_ = portId_;
        result.cargoId_ = cargoId_;
        result.quantityBbls_ = quantityBbls_;
        result.quantityMt_ = quantityMt_;
        result.quantityKl_ = quantityKl_;
        result.api_ = api_;
        result.temperature_ = temperature_;
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
        if (other instanceof com.cpdss.common.generated.Common.BillOfLadding) {
          return mergeFrom((com.cpdss.common.generated.Common.BillOfLadding) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.cpdss.common.generated.Common.BillOfLadding other) {
        if (other == com.cpdss.common.generated.Common.BillOfLadding.getDefaultInstance())
          return this;
        if (other.getId() != 0L) {
          setId(other.getId());
        }
        if (other.getPortId() != 0L) {
          setPortId(other.getPortId());
        }
        if (other.getCargoId() != 0L) {
          setCargoId(other.getCargoId());
        }
        if (!other.getQuantityBbls().isEmpty()) {
          quantityBbls_ = other.quantityBbls_;
          onChanged();
        }
        if (!other.getQuantityMt().isEmpty()) {
          quantityMt_ = other.quantityMt_;
          onChanged();
        }
        if (!other.getQuantityKl().isEmpty()) {
          quantityKl_ = other.quantityKl_;
          onChanged();
        }
        if (!other.getApi().isEmpty()) {
          api_ = other.api_;
          onChanged();
        }
        if (!other.getTemperature().isEmpty()) {
          temperature_ = other.temperature_;
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
        com.cpdss.common.generated.Common.BillOfLadding parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.Common.BillOfLadding) e.getUnfinishedMessage();
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

      private long cargoId_;
      /**
       * <code>int64 cargoId = 3;</code>
       *
       * @return The cargoId.
       */
      public long getCargoId() {
        return cargoId_;
      }
      /**
       * <code>int64 cargoId = 3;</code>
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
       * <code>int64 cargoId = 3;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearCargoId() {

        cargoId_ = 0L;
        onChanged();
        return this;
      }

      private java.lang.Object quantityBbls_ = "";
      /**
       * <code>string quantityBbls = 4;</code>
       *
       * @return The quantityBbls.
       */
      public java.lang.String getQuantityBbls() {
        java.lang.Object ref = quantityBbls_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          quantityBbls_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string quantityBbls = 4;</code>
       *
       * @return The bytes for quantityBbls.
       */
      public com.google.protobuf.ByteString getQuantityBblsBytes() {
        java.lang.Object ref = quantityBbls_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          quantityBbls_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string quantityBbls = 4;</code>
       *
       * @param value The quantityBbls to set.
       * @return This builder for chaining.
       */
      public Builder setQuantityBbls(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        quantityBbls_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string quantityBbls = 4;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearQuantityBbls() {

        quantityBbls_ = getDefaultInstance().getQuantityBbls();
        onChanged();
        return this;
      }
      /**
       * <code>string quantityBbls = 4;</code>
       *
       * @param value The bytes for quantityBbls to set.
       * @return This builder for chaining.
       */
      public Builder setQuantityBblsBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        quantityBbls_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object quantityMt_ = "";
      /**
       * <code>string quantityMt = 5;</code>
       *
       * @return The quantityMt.
       */
      public java.lang.String getQuantityMt() {
        java.lang.Object ref = quantityMt_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          quantityMt_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string quantityMt = 5;</code>
       *
       * @return The bytes for quantityMt.
       */
      public com.google.protobuf.ByteString getQuantityMtBytes() {
        java.lang.Object ref = quantityMt_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          quantityMt_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string quantityMt = 5;</code>
       *
       * @param value The quantityMt to set.
       * @return This builder for chaining.
       */
      public Builder setQuantityMt(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        quantityMt_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string quantityMt = 5;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearQuantityMt() {

        quantityMt_ = getDefaultInstance().getQuantityMt();
        onChanged();
        return this;
      }
      /**
       * <code>string quantityMt = 5;</code>
       *
       * @param value The bytes for quantityMt to set.
       * @return This builder for chaining.
       */
      public Builder setQuantityMtBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        quantityMt_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object quantityKl_ = "";
      /**
       * <code>string quantityKl = 6;</code>
       *
       * @return The quantityKl.
       */
      public java.lang.String getQuantityKl() {
        java.lang.Object ref = quantityKl_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          quantityKl_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string quantityKl = 6;</code>
       *
       * @return The bytes for quantityKl.
       */
      public com.google.protobuf.ByteString getQuantityKlBytes() {
        java.lang.Object ref = quantityKl_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          quantityKl_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string quantityKl = 6;</code>
       *
       * @param value The quantityKl to set.
       * @return This builder for chaining.
       */
      public Builder setQuantityKl(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        quantityKl_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string quantityKl = 6;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearQuantityKl() {

        quantityKl_ = getDefaultInstance().getQuantityKl();
        onChanged();
        return this;
      }
      /**
       * <code>string quantityKl = 6;</code>
       *
       * @param value The bytes for quantityKl to set.
       * @return This builder for chaining.
       */
      public Builder setQuantityKlBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        quantityKl_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object api_ = "";
      /**
       * <code>string api = 7;</code>
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
       * <code>string api = 7;</code>
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
       * <code>string api = 7;</code>
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
       * <code>string api = 7;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearApi() {

        api_ = getDefaultInstance().getApi();
        onChanged();
        return this;
      }
      /**
       * <code>string api = 7;</code>
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

      private java.lang.Object temperature_ = "";
      /**
       * <code>string temperature = 8;</code>
       *
       * @return The temperature.
       */
      public java.lang.String getTemperature() {
        java.lang.Object ref = temperature_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          temperature_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string temperature = 8;</code>
       *
       * @return The bytes for temperature.
       */
      public com.google.protobuf.ByteString getTemperatureBytes() {
        java.lang.Object ref = temperature_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          temperature_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string temperature = 8;</code>
       *
       * @param value The temperature to set.
       * @return This builder for chaining.
       */
      public Builder setTemperature(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        temperature_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string temperature = 8;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearTemperature() {

        temperature_ = getDefaultInstance().getTemperature();
        onChanged();
        return this;
      }
      /**
       * <code>string temperature = 8;</code>
       *
       * @param value The bytes for temperature to set.
       * @return This builder for chaining.
       */
      public Builder setTemperatureBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        temperature_ = value;
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

      // @@protoc_insertion_point(builder_scope:BillOfLadding)
    }

    // @@protoc_insertion_point(class_scope:BillOfLadding)
    private static final com.cpdss.common.generated.Common.BillOfLadding DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.Common.BillOfLadding();
    }

    public static com.cpdss.common.generated.Common.BillOfLadding getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<BillOfLadding> PARSER =
        new com.google.protobuf.AbstractParser<BillOfLadding>() {
          @java.lang.Override
          public BillOfLadding parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new BillOfLadding(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<BillOfLadding> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<BillOfLadding> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.Common.BillOfLadding getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface RulePlansOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:RulePlans)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>string header = 1;</code>
     *
     * @return The header.
     */
    java.lang.String getHeader();
    /**
     * <code>string header = 1;</code>
     *
     * @return The bytes for header.
     */
    com.google.protobuf.ByteString getHeaderBytes();

    /** <code>repeated .Rules rules = 2;</code> */
    java.util.List<com.cpdss.common.generated.Common.Rules> getRulesList();
    /** <code>repeated .Rules rules = 2;</code> */
    com.cpdss.common.generated.Common.Rules getRules(int index);
    /** <code>repeated .Rules rules = 2;</code> */
    int getRulesCount();
    /** <code>repeated .Rules rules = 2;</code> */
    java.util.List<? extends com.cpdss.common.generated.Common.RulesOrBuilder>
        getRulesOrBuilderList();
    /** <code>repeated .Rules rules = 2;</code> */
    com.cpdss.common.generated.Common.RulesOrBuilder getRulesOrBuilder(int index);
  }
  /** Protobuf type {@code RulePlans} */
  public static final class RulePlans extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:RulePlans)
      RulePlansOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use RulePlans.newBuilder() to construct.
    private RulePlans(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private RulePlans() {
      header_ = "";
      rules_ = java.util.Collections.emptyList();
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new RulePlans();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private RulePlans(
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
                java.lang.String s = input.readStringRequireUtf8();

                header_ = s;
                break;
              }
            case 18:
              {
                if (!((mutable_bitField0_ & 0x00000001) != 0)) {
                  rules_ = new java.util.ArrayList<com.cpdss.common.generated.Common.Rules>();
                  mutable_bitField0_ |= 0x00000001;
                }
                rules_.add(
                    input.readMessage(
                        com.cpdss.common.generated.Common.Rules.parser(), extensionRegistry));
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
          rules_ = java.util.Collections.unmodifiableList(rules_);
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }

    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.cpdss.common.generated.Common.internal_static_RulePlans_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.Common.internal_static_RulePlans_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.Common.RulePlans.class,
              com.cpdss.common.generated.Common.RulePlans.Builder.class);
    }

    public static final int HEADER_FIELD_NUMBER = 1;
    private volatile java.lang.Object header_;
    /**
     * <code>string header = 1;</code>
     *
     * @return The header.
     */
    public java.lang.String getHeader() {
      java.lang.Object ref = header_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        header_ = s;
        return s;
      }
    }
    /**
     * <code>string header = 1;</code>
     *
     * @return The bytes for header.
     */
    public com.google.protobuf.ByteString getHeaderBytes() {
      java.lang.Object ref = header_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        header_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int RULES_FIELD_NUMBER = 2;
    private java.util.List<com.cpdss.common.generated.Common.Rules> rules_;
    /** <code>repeated .Rules rules = 2;</code> */
    public java.util.List<com.cpdss.common.generated.Common.Rules> getRulesList() {
      return rules_;
    }
    /** <code>repeated .Rules rules = 2;</code> */
    public java.util.List<? extends com.cpdss.common.generated.Common.RulesOrBuilder>
        getRulesOrBuilderList() {
      return rules_;
    }
    /** <code>repeated .Rules rules = 2;</code> */
    public int getRulesCount() {
      return rules_.size();
    }
    /** <code>repeated .Rules rules = 2;</code> */
    public com.cpdss.common.generated.Common.Rules getRules(int index) {
      return rules_.get(index);
    }
    /** <code>repeated .Rules rules = 2;</code> */
    public com.cpdss.common.generated.Common.RulesOrBuilder getRulesOrBuilder(int index) {
      return rules_.get(index);
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
      if (!getHeaderBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, header_);
      }
      for (int i = 0; i < rules_.size(); i++) {
        output.writeMessage(2, rules_.get(i));
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getHeaderBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, header_);
      }
      for (int i = 0; i < rules_.size(); i++) {
        size += com.google.protobuf.CodedOutputStream.computeMessageSize(2, rules_.get(i));
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
      if (!(obj instanceof com.cpdss.common.generated.Common.RulePlans)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.Common.RulePlans other =
          (com.cpdss.common.generated.Common.RulePlans) obj;

      if (!getHeader().equals(other.getHeader())) return false;
      if (!getRulesList().equals(other.getRulesList())) return false;
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
      hash = (37 * hash) + HEADER_FIELD_NUMBER;
      hash = (53 * hash) + getHeader().hashCode();
      if (getRulesCount() > 0) {
        hash = (37 * hash) + RULES_FIELD_NUMBER;
        hash = (53 * hash) + getRulesList().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.Common.RulePlans parseFrom(java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Common.RulePlans parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.RulePlans parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Common.RulePlans parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.RulePlans parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Common.RulePlans parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.RulePlans parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Common.RulePlans parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.RulePlans parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Common.RulePlans parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.RulePlans parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Common.RulePlans parseFrom(
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

    public static Builder newBuilder(com.cpdss.common.generated.Common.RulePlans prototype) {
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
    /** Protobuf type {@code RulePlans} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:RulePlans)
        com.cpdss.common.generated.Common.RulePlansOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.Common.internal_static_RulePlans_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.Common.internal_static_RulePlans_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.Common.RulePlans.class,
                com.cpdss.common.generated.Common.RulePlans.Builder.class);
      }

      // Construct using com.cpdss.common.generated.Common.RulePlans.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {
          getRulesFieldBuilder();
        }
      }

      @java.lang.Override
      public Builder clear() {
        super.clear();
        header_ = "";

        if (rulesBuilder_ == null) {
          rules_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          rulesBuilder_.clear();
        }
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.Common.internal_static_RulePlans_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.Common.RulePlans getDefaultInstanceForType() {
        return com.cpdss.common.generated.Common.RulePlans.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.Common.RulePlans build() {
        com.cpdss.common.generated.Common.RulePlans result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.Common.RulePlans buildPartial() {
        com.cpdss.common.generated.Common.RulePlans result =
            new com.cpdss.common.generated.Common.RulePlans(this);
        int from_bitField0_ = bitField0_;
        result.header_ = header_;
        if (rulesBuilder_ == null) {
          if (((bitField0_ & 0x00000001) != 0)) {
            rules_ = java.util.Collections.unmodifiableList(rules_);
            bitField0_ = (bitField0_ & ~0x00000001);
          }
          result.rules_ = rules_;
        } else {
          result.rules_ = rulesBuilder_.build();
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
        if (other instanceof com.cpdss.common.generated.Common.RulePlans) {
          return mergeFrom((com.cpdss.common.generated.Common.RulePlans) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.cpdss.common.generated.Common.RulePlans other) {
        if (other == com.cpdss.common.generated.Common.RulePlans.getDefaultInstance()) return this;
        if (!other.getHeader().isEmpty()) {
          header_ = other.header_;
          onChanged();
        }
        if (rulesBuilder_ == null) {
          if (!other.rules_.isEmpty()) {
            if (rules_.isEmpty()) {
              rules_ = other.rules_;
              bitField0_ = (bitField0_ & ~0x00000001);
            } else {
              ensureRulesIsMutable();
              rules_.addAll(other.rules_);
            }
            onChanged();
          }
        } else {
          if (!other.rules_.isEmpty()) {
            if (rulesBuilder_.isEmpty()) {
              rulesBuilder_.dispose();
              rulesBuilder_ = null;
              rules_ = other.rules_;
              bitField0_ = (bitField0_ & ~0x00000001);
              rulesBuilder_ =
                  com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
                      ? getRulesFieldBuilder()
                      : null;
            } else {
              rulesBuilder_.addAllMessages(other.rules_);
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
        com.cpdss.common.generated.Common.RulePlans parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.cpdss.common.generated.Common.RulePlans) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private int bitField0_;

      private java.lang.Object header_ = "";
      /**
       * <code>string header = 1;</code>
       *
       * @return The header.
       */
      public java.lang.String getHeader() {
        java.lang.Object ref = header_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          header_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string header = 1;</code>
       *
       * @return The bytes for header.
       */
      public com.google.protobuf.ByteString getHeaderBytes() {
        java.lang.Object ref = header_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          header_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string header = 1;</code>
       *
       * @param value The header to set.
       * @return This builder for chaining.
       */
      public Builder setHeader(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        header_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string header = 1;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearHeader() {

        header_ = getDefaultInstance().getHeader();
        onChanged();
        return this;
      }
      /**
       * <code>string header = 1;</code>
       *
       * @param value The bytes for header to set.
       * @return This builder for chaining.
       */
      public Builder setHeaderBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        header_ = value;
        onChanged();
        return this;
      }

      private java.util.List<com.cpdss.common.generated.Common.Rules> rules_ =
          java.util.Collections.emptyList();

      private void ensureRulesIsMutable() {
        if (!((bitField0_ & 0x00000001) != 0)) {
          rules_ = new java.util.ArrayList<com.cpdss.common.generated.Common.Rules>(rules_);
          bitField0_ |= 0x00000001;
        }
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
              com.cpdss.common.generated.Common.Rules,
              com.cpdss.common.generated.Common.Rules.Builder,
              com.cpdss.common.generated.Common.RulesOrBuilder>
          rulesBuilder_;

      /** <code>repeated .Rules rules = 2;</code> */
      public java.util.List<com.cpdss.common.generated.Common.Rules> getRulesList() {
        if (rulesBuilder_ == null) {
          return java.util.Collections.unmodifiableList(rules_);
        } else {
          return rulesBuilder_.getMessageList();
        }
      }
      /** <code>repeated .Rules rules = 2;</code> */
      public int getRulesCount() {
        if (rulesBuilder_ == null) {
          return rules_.size();
        } else {
          return rulesBuilder_.getCount();
        }
      }
      /** <code>repeated .Rules rules = 2;</code> */
      public com.cpdss.common.generated.Common.Rules getRules(int index) {
        if (rulesBuilder_ == null) {
          return rules_.get(index);
        } else {
          return rulesBuilder_.getMessage(index);
        }
      }
      /** <code>repeated .Rules rules = 2;</code> */
      public Builder setRules(int index, com.cpdss.common.generated.Common.Rules value) {
        if (rulesBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureRulesIsMutable();
          rules_.set(index, value);
          onChanged();
        } else {
          rulesBuilder_.setMessage(index, value);
        }
        return this;
      }
      /** <code>repeated .Rules rules = 2;</code> */
      public Builder setRules(
          int index, com.cpdss.common.generated.Common.Rules.Builder builderForValue) {
        if (rulesBuilder_ == null) {
          ensureRulesIsMutable();
          rules_.set(index, builderForValue.build());
          onChanged();
        } else {
          rulesBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .Rules rules = 2;</code> */
      public Builder addRules(com.cpdss.common.generated.Common.Rules value) {
        if (rulesBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureRulesIsMutable();
          rules_.add(value);
          onChanged();
        } else {
          rulesBuilder_.addMessage(value);
        }
        return this;
      }
      /** <code>repeated .Rules rules = 2;</code> */
      public Builder addRules(int index, com.cpdss.common.generated.Common.Rules value) {
        if (rulesBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureRulesIsMutable();
          rules_.add(index, value);
          onChanged();
        } else {
          rulesBuilder_.addMessage(index, value);
        }
        return this;
      }
      /** <code>repeated .Rules rules = 2;</code> */
      public Builder addRules(com.cpdss.common.generated.Common.Rules.Builder builderForValue) {
        if (rulesBuilder_ == null) {
          ensureRulesIsMutable();
          rules_.add(builderForValue.build());
          onChanged();
        } else {
          rulesBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .Rules rules = 2;</code> */
      public Builder addRules(
          int index, com.cpdss.common.generated.Common.Rules.Builder builderForValue) {
        if (rulesBuilder_ == null) {
          ensureRulesIsMutable();
          rules_.add(index, builderForValue.build());
          onChanged();
        } else {
          rulesBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .Rules rules = 2;</code> */
      public Builder addAllRules(
          java.lang.Iterable<? extends com.cpdss.common.generated.Common.Rules> values) {
        if (rulesBuilder_ == null) {
          ensureRulesIsMutable();
          com.google.protobuf.AbstractMessageLite.Builder.addAll(values, rules_);
          onChanged();
        } else {
          rulesBuilder_.addAllMessages(values);
        }
        return this;
      }
      /** <code>repeated .Rules rules = 2;</code> */
      public Builder clearRules() {
        if (rulesBuilder_ == null) {
          rules_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
          onChanged();
        } else {
          rulesBuilder_.clear();
        }
        return this;
      }
      /** <code>repeated .Rules rules = 2;</code> */
      public Builder removeRules(int index) {
        if (rulesBuilder_ == null) {
          ensureRulesIsMutable();
          rules_.remove(index);
          onChanged();
        } else {
          rulesBuilder_.remove(index);
        }
        return this;
      }
      /** <code>repeated .Rules rules = 2;</code> */
      public com.cpdss.common.generated.Common.Rules.Builder getRulesBuilder(int index) {
        return getRulesFieldBuilder().getBuilder(index);
      }
      /** <code>repeated .Rules rules = 2;</code> */
      public com.cpdss.common.generated.Common.RulesOrBuilder getRulesOrBuilder(int index) {
        if (rulesBuilder_ == null) {
          return rules_.get(index);
        } else {
          return rulesBuilder_.getMessageOrBuilder(index);
        }
      }
      /** <code>repeated .Rules rules = 2;</code> */
      public java.util.List<? extends com.cpdss.common.generated.Common.RulesOrBuilder>
          getRulesOrBuilderList() {
        if (rulesBuilder_ != null) {
          return rulesBuilder_.getMessageOrBuilderList();
        } else {
          return java.util.Collections.unmodifiableList(rules_);
        }
      }
      /** <code>repeated .Rules rules = 2;</code> */
      public com.cpdss.common.generated.Common.Rules.Builder addRulesBuilder() {
        return getRulesFieldBuilder()
            .addBuilder(com.cpdss.common.generated.Common.Rules.getDefaultInstance());
      }
      /** <code>repeated .Rules rules = 2;</code> */
      public com.cpdss.common.generated.Common.Rules.Builder addRulesBuilder(int index) {
        return getRulesFieldBuilder()
            .addBuilder(index, com.cpdss.common.generated.Common.Rules.getDefaultInstance());
      }
      /** <code>repeated .Rules rules = 2;</code> */
      public java.util.List<com.cpdss.common.generated.Common.Rules.Builder> getRulesBuilderList() {
        return getRulesFieldBuilder().getBuilderList();
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
              com.cpdss.common.generated.Common.Rules,
              com.cpdss.common.generated.Common.Rules.Builder,
              com.cpdss.common.generated.Common.RulesOrBuilder>
          getRulesFieldBuilder() {
        if (rulesBuilder_ == null) {
          rulesBuilder_ =
              new com.google.protobuf.RepeatedFieldBuilderV3<
                  com.cpdss.common.generated.Common.Rules,
                  com.cpdss.common.generated.Common.Rules.Builder,
                  com.cpdss.common.generated.Common.RulesOrBuilder>(
                  rules_, ((bitField0_ & 0x00000001) != 0), getParentForChildren(), isClean());
          rules_ = null;
        }
        return rulesBuilder_;
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

      // @@protoc_insertion_point(builder_scope:RulePlans)
    }

    // @@protoc_insertion_point(class_scope:RulePlans)
    private static final com.cpdss.common.generated.Common.RulePlans DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.Common.RulePlans();
    }

    public static com.cpdss.common.generated.Common.RulePlans getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<RulePlans> PARSER =
        new com.google.protobuf.AbstractParser<RulePlans>() {
          @java.lang.Override
          public RulePlans parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new RulePlans(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<RulePlans> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<RulePlans> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.Common.RulePlans getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface RulesOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:Rules)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>string id = 1;</code>
     *
     * @return The id.
     */
    java.lang.String getId();
    /**
     * <code>string id = 1;</code>
     *
     * @return The bytes for id.
     */
    com.google.protobuf.ByteString getIdBytes();

    /**
     * <code>bool enable = 2;</code>
     *
     * @return The enable.
     */
    boolean getEnable();

    /**
     * <code>bool disable = 3;</code>
     *
     * @return The disable.
     */
    boolean getDisable();

    /**
     * <code>bool disableInSettigs = 4;</code>
     *
     * @return The disableInSettigs.
     */
    boolean getDisableInSettigs();

    /**
     * <code>string ruleType = 5;</code>
     *
     * @return The ruleType.
     */
    java.lang.String getRuleType();
    /**
     * <code>string ruleType = 5;</code>
     *
     * @return The bytes for ruleType.
     */
    com.google.protobuf.ByteString getRuleTypeBytes();

    /** <code>repeated .RulesInputs inputs = 6;</code> */
    java.util.List<com.cpdss.common.generated.Common.RulesInputs> getInputsList();
    /** <code>repeated .RulesInputs inputs = 6;</code> */
    com.cpdss.common.generated.Common.RulesInputs getInputs(int index);
    /** <code>repeated .RulesInputs inputs = 6;</code> */
    int getInputsCount();
    /** <code>repeated .RulesInputs inputs = 6;</code> */
    java.util.List<? extends com.cpdss.common.generated.Common.RulesInputsOrBuilder>
        getInputsOrBuilderList();
    /** <code>repeated .RulesInputs inputs = 6;</code> */
    com.cpdss.common.generated.Common.RulesInputsOrBuilder getInputsOrBuilder(int index);

    /**
     * <code>string ruleTemplateId = 7;</code>
     *
     * @return The ruleTemplateId.
     */
    java.lang.String getRuleTemplateId();
    /**
     * <code>string ruleTemplateId = 7;</code>
     *
     * @return The bytes for ruleTemplateId.
     */
    com.google.protobuf.ByteString getRuleTemplateIdBytes();

    /**
     * <code>string vesselRuleXId = 8;</code>
     *
     * @return The vesselRuleXId.
     */
    java.lang.String getVesselRuleXId();
    /**
     * <code>string vesselRuleXId = 8;</code>
     *
     * @return The bytes for vesselRuleXId.
     */
    com.google.protobuf.ByteString getVesselRuleXIdBytes();
  }
  /** Protobuf type {@code Rules} */
  public static final class Rules extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:Rules)
      RulesOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use Rules.newBuilder() to construct.
    private Rules(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private Rules() {
      id_ = "";
      ruleType_ = "";
      inputs_ = java.util.Collections.emptyList();
      ruleTemplateId_ = "";
      vesselRuleXId_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new Rules();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private Rules(
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
                java.lang.String s = input.readStringRequireUtf8();

                id_ = s;
                break;
              }
            case 16:
              {
                enable_ = input.readBool();
                break;
              }
            case 24:
              {
                disable_ = input.readBool();
                break;
              }
            case 32:
              {
                disableInSettigs_ = input.readBool();
                break;
              }
            case 42:
              {
                java.lang.String s = input.readStringRequireUtf8();

                ruleType_ = s;
                break;
              }
            case 50:
              {
                if (!((mutable_bitField0_ & 0x00000001) != 0)) {
                  inputs_ =
                      new java.util.ArrayList<com.cpdss.common.generated.Common.RulesInputs>();
                  mutable_bitField0_ |= 0x00000001;
                }
                inputs_.add(
                    input.readMessage(
                        com.cpdss.common.generated.Common.RulesInputs.parser(), extensionRegistry));
                break;
              }
            case 58:
              {
                java.lang.String s = input.readStringRequireUtf8();

                ruleTemplateId_ = s;
                break;
              }
            case 66:
              {
                java.lang.String s = input.readStringRequireUtf8();

                vesselRuleXId_ = s;
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
          inputs_ = java.util.Collections.unmodifiableList(inputs_);
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }

    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.cpdss.common.generated.Common.internal_static_Rules_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.Common.internal_static_Rules_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.Common.Rules.class,
              com.cpdss.common.generated.Common.Rules.Builder.class);
    }

    public static final int ID_FIELD_NUMBER = 1;
    private volatile java.lang.Object id_;
    /**
     * <code>string id = 1;</code>
     *
     * @return The id.
     */
    public java.lang.String getId() {
      java.lang.Object ref = id_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        id_ = s;
        return s;
      }
    }
    /**
     * <code>string id = 1;</code>
     *
     * @return The bytes for id.
     */
    public com.google.protobuf.ByteString getIdBytes() {
      java.lang.Object ref = id_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        id_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int ENABLE_FIELD_NUMBER = 2;
    private boolean enable_;
    /**
     * <code>bool enable = 2;</code>
     *
     * @return The enable.
     */
    public boolean getEnable() {
      return enable_;
    }

    public static final int DISABLE_FIELD_NUMBER = 3;
    private boolean disable_;
    /**
     * <code>bool disable = 3;</code>
     *
     * @return The disable.
     */
    public boolean getDisable() {
      return disable_;
    }

    public static final int DISABLEINSETTIGS_FIELD_NUMBER = 4;
    private boolean disableInSettigs_;
    /**
     * <code>bool disableInSettigs = 4;</code>
     *
     * @return The disableInSettigs.
     */
    public boolean getDisableInSettigs() {
      return disableInSettigs_;
    }

    public static final int RULETYPE_FIELD_NUMBER = 5;
    private volatile java.lang.Object ruleType_;
    /**
     * <code>string ruleType = 5;</code>
     *
     * @return The ruleType.
     */
    public java.lang.String getRuleType() {
      java.lang.Object ref = ruleType_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        ruleType_ = s;
        return s;
      }
    }
    /**
     * <code>string ruleType = 5;</code>
     *
     * @return The bytes for ruleType.
     */
    public com.google.protobuf.ByteString getRuleTypeBytes() {
      java.lang.Object ref = ruleType_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        ruleType_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int INPUTS_FIELD_NUMBER = 6;
    private java.util.List<com.cpdss.common.generated.Common.RulesInputs> inputs_;
    /** <code>repeated .RulesInputs inputs = 6;</code> */
    public java.util.List<com.cpdss.common.generated.Common.RulesInputs> getInputsList() {
      return inputs_;
    }
    /** <code>repeated .RulesInputs inputs = 6;</code> */
    public java.util.List<? extends com.cpdss.common.generated.Common.RulesInputsOrBuilder>
        getInputsOrBuilderList() {
      return inputs_;
    }
    /** <code>repeated .RulesInputs inputs = 6;</code> */
    public int getInputsCount() {
      return inputs_.size();
    }
    /** <code>repeated .RulesInputs inputs = 6;</code> */
    public com.cpdss.common.generated.Common.RulesInputs getInputs(int index) {
      return inputs_.get(index);
    }
    /** <code>repeated .RulesInputs inputs = 6;</code> */
    public com.cpdss.common.generated.Common.RulesInputsOrBuilder getInputsOrBuilder(int index) {
      return inputs_.get(index);
    }

    public static final int RULETEMPLATEID_FIELD_NUMBER = 7;
    private volatile java.lang.Object ruleTemplateId_;
    /**
     * <code>string ruleTemplateId = 7;</code>
     *
     * @return The ruleTemplateId.
     */
    public java.lang.String getRuleTemplateId() {
      java.lang.Object ref = ruleTemplateId_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        ruleTemplateId_ = s;
        return s;
      }
    }
    /**
     * <code>string ruleTemplateId = 7;</code>
     *
     * @return The bytes for ruleTemplateId.
     */
    public com.google.protobuf.ByteString getRuleTemplateIdBytes() {
      java.lang.Object ref = ruleTemplateId_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        ruleTemplateId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int VESSELRULEXID_FIELD_NUMBER = 8;
    private volatile java.lang.Object vesselRuleXId_;
    /**
     * <code>string vesselRuleXId = 8;</code>
     *
     * @return The vesselRuleXId.
     */
    public java.lang.String getVesselRuleXId() {
      java.lang.Object ref = vesselRuleXId_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        vesselRuleXId_ = s;
        return s;
      }
    }
    /**
     * <code>string vesselRuleXId = 8;</code>
     *
     * @return The bytes for vesselRuleXId.
     */
    public com.google.protobuf.ByteString getVesselRuleXIdBytes() {
      java.lang.Object ref = vesselRuleXId_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        vesselRuleXId_ = b;
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
      if (!getIdBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, id_);
      }
      if (enable_ != false) {
        output.writeBool(2, enable_);
      }
      if (disable_ != false) {
        output.writeBool(3, disable_);
      }
      if (disableInSettigs_ != false) {
        output.writeBool(4, disableInSettigs_);
      }
      if (!getRuleTypeBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 5, ruleType_);
      }
      for (int i = 0; i < inputs_.size(); i++) {
        output.writeMessage(6, inputs_.get(i));
      }
      if (!getRuleTemplateIdBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 7, ruleTemplateId_);
      }
      if (!getVesselRuleXIdBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 8, vesselRuleXId_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getIdBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, id_);
      }
      if (enable_ != false) {
        size += com.google.protobuf.CodedOutputStream.computeBoolSize(2, enable_);
      }
      if (disable_ != false) {
        size += com.google.protobuf.CodedOutputStream.computeBoolSize(3, disable_);
      }
      if (disableInSettigs_ != false) {
        size += com.google.protobuf.CodedOutputStream.computeBoolSize(4, disableInSettigs_);
      }
      if (!getRuleTypeBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, ruleType_);
      }
      for (int i = 0; i < inputs_.size(); i++) {
        size += com.google.protobuf.CodedOutputStream.computeMessageSize(6, inputs_.get(i));
      }
      if (!getRuleTemplateIdBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(7, ruleTemplateId_);
      }
      if (!getVesselRuleXIdBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(8, vesselRuleXId_);
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
      if (!(obj instanceof com.cpdss.common.generated.Common.Rules)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.Common.Rules other = (com.cpdss.common.generated.Common.Rules) obj;

      if (!getId().equals(other.getId())) return false;
      if (getEnable() != other.getEnable()) return false;
      if (getDisable() != other.getDisable()) return false;
      if (getDisableInSettigs() != other.getDisableInSettigs()) return false;
      if (!getRuleType().equals(other.getRuleType())) return false;
      if (!getInputsList().equals(other.getInputsList())) return false;
      if (!getRuleTemplateId().equals(other.getRuleTemplateId())) return false;
      if (!getVesselRuleXId().equals(other.getVesselRuleXId())) return false;
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
      hash = (53 * hash) + getId().hashCode();
      hash = (37 * hash) + ENABLE_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(getEnable());
      hash = (37 * hash) + DISABLE_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(getDisable());
      hash = (37 * hash) + DISABLEINSETTIGS_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(getDisableInSettigs());
      hash = (37 * hash) + RULETYPE_FIELD_NUMBER;
      hash = (53 * hash) + getRuleType().hashCode();
      if (getInputsCount() > 0) {
        hash = (37 * hash) + INPUTS_FIELD_NUMBER;
        hash = (53 * hash) + getInputsList().hashCode();
      }
      hash = (37 * hash) + RULETEMPLATEID_FIELD_NUMBER;
      hash = (53 * hash) + getRuleTemplateId().hashCode();
      hash = (37 * hash) + VESSELRULEXID_FIELD_NUMBER;
      hash = (53 * hash) + getVesselRuleXId().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.Common.Rules parseFrom(java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Common.Rules parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.Rules parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Common.Rules parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.Rules parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Common.Rules parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.Rules parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Common.Rules parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.Rules parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Common.Rules parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.Rules parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Common.Rules parseFrom(
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

    public static Builder newBuilder(com.cpdss.common.generated.Common.Rules prototype) {
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
    /** Protobuf type {@code Rules} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:Rules)
        com.cpdss.common.generated.Common.RulesOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.Common.internal_static_Rules_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.Common.internal_static_Rules_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.Common.Rules.class,
                com.cpdss.common.generated.Common.Rules.Builder.class);
      }

      // Construct using com.cpdss.common.generated.Common.Rules.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {
          getInputsFieldBuilder();
        }
      }

      @java.lang.Override
      public Builder clear() {
        super.clear();
        id_ = "";

        enable_ = false;

        disable_ = false;

        disableInSettigs_ = false;

        ruleType_ = "";

        if (inputsBuilder_ == null) {
          inputs_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          inputsBuilder_.clear();
        }
        ruleTemplateId_ = "";

        vesselRuleXId_ = "";

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.Common.internal_static_Rules_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.Common.Rules getDefaultInstanceForType() {
        return com.cpdss.common.generated.Common.Rules.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.Common.Rules build() {
        com.cpdss.common.generated.Common.Rules result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.Common.Rules buildPartial() {
        com.cpdss.common.generated.Common.Rules result =
            new com.cpdss.common.generated.Common.Rules(this);
        int from_bitField0_ = bitField0_;
        result.id_ = id_;
        result.enable_ = enable_;
        result.disable_ = disable_;
        result.disableInSettigs_ = disableInSettigs_;
        result.ruleType_ = ruleType_;
        if (inputsBuilder_ == null) {
          if (((bitField0_ & 0x00000001) != 0)) {
            inputs_ = java.util.Collections.unmodifiableList(inputs_);
            bitField0_ = (bitField0_ & ~0x00000001);
          }
          result.inputs_ = inputs_;
        } else {
          result.inputs_ = inputsBuilder_.build();
        }
        result.ruleTemplateId_ = ruleTemplateId_;
        result.vesselRuleXId_ = vesselRuleXId_;
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
        if (other instanceof com.cpdss.common.generated.Common.Rules) {
          return mergeFrom((com.cpdss.common.generated.Common.Rules) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.cpdss.common.generated.Common.Rules other) {
        if (other == com.cpdss.common.generated.Common.Rules.getDefaultInstance()) return this;
        if (!other.getId().isEmpty()) {
          id_ = other.id_;
          onChanged();
        }
        if (other.getEnable() != false) {
          setEnable(other.getEnable());
        }
        if (other.getDisable() != false) {
          setDisable(other.getDisable());
        }
        if (other.getDisableInSettigs() != false) {
          setDisableInSettigs(other.getDisableInSettigs());
        }
        if (!other.getRuleType().isEmpty()) {
          ruleType_ = other.ruleType_;
          onChanged();
        }
        if (inputsBuilder_ == null) {
          if (!other.inputs_.isEmpty()) {
            if (inputs_.isEmpty()) {
              inputs_ = other.inputs_;
              bitField0_ = (bitField0_ & ~0x00000001);
            } else {
              ensureInputsIsMutable();
              inputs_.addAll(other.inputs_);
            }
            onChanged();
          }
        } else {
          if (!other.inputs_.isEmpty()) {
            if (inputsBuilder_.isEmpty()) {
              inputsBuilder_.dispose();
              inputsBuilder_ = null;
              inputs_ = other.inputs_;
              bitField0_ = (bitField0_ & ~0x00000001);
              inputsBuilder_ =
                  com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
                      ? getInputsFieldBuilder()
                      : null;
            } else {
              inputsBuilder_.addAllMessages(other.inputs_);
            }
          }
        }
        if (!other.getRuleTemplateId().isEmpty()) {
          ruleTemplateId_ = other.ruleTemplateId_;
          onChanged();
        }
        if (!other.getVesselRuleXId().isEmpty()) {
          vesselRuleXId_ = other.vesselRuleXId_;
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
        com.cpdss.common.generated.Common.Rules parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.cpdss.common.generated.Common.Rules) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private int bitField0_;

      private java.lang.Object id_ = "";
      /**
       * <code>string id = 1;</code>
       *
       * @return The id.
       */
      public java.lang.String getId() {
        java.lang.Object ref = id_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          id_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string id = 1;</code>
       *
       * @return The bytes for id.
       */
      public com.google.protobuf.ByteString getIdBytes() {
        java.lang.Object ref = id_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          id_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string id = 1;</code>
       *
       * @param value The id to set.
       * @return This builder for chaining.
       */
      public Builder setId(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        id_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string id = 1;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearId() {

        id_ = getDefaultInstance().getId();
        onChanged();
        return this;
      }
      /**
       * <code>string id = 1;</code>
       *
       * @param value The bytes for id to set.
       * @return This builder for chaining.
       */
      public Builder setIdBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        id_ = value;
        onChanged();
        return this;
      }

      private boolean enable_;
      /**
       * <code>bool enable = 2;</code>
       *
       * @return The enable.
       */
      public boolean getEnable() {
        return enable_;
      }
      /**
       * <code>bool enable = 2;</code>
       *
       * @param value The enable to set.
       * @return This builder for chaining.
       */
      public Builder setEnable(boolean value) {

        enable_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>bool enable = 2;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearEnable() {

        enable_ = false;
        onChanged();
        return this;
      }

      private boolean disable_;
      /**
       * <code>bool disable = 3;</code>
       *
       * @return The disable.
       */
      public boolean getDisable() {
        return disable_;
      }
      /**
       * <code>bool disable = 3;</code>
       *
       * @param value The disable to set.
       * @return This builder for chaining.
       */
      public Builder setDisable(boolean value) {

        disable_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>bool disable = 3;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearDisable() {

        disable_ = false;
        onChanged();
        return this;
      }

      private boolean disableInSettigs_;
      /**
       * <code>bool disableInSettigs = 4;</code>
       *
       * @return The disableInSettigs.
       */
      public boolean getDisableInSettigs() {
        return disableInSettigs_;
      }
      /**
       * <code>bool disableInSettigs = 4;</code>
       *
       * @param value The disableInSettigs to set.
       * @return This builder for chaining.
       */
      public Builder setDisableInSettigs(boolean value) {

        disableInSettigs_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>bool disableInSettigs = 4;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearDisableInSettigs() {

        disableInSettigs_ = false;
        onChanged();
        return this;
      }

      private java.lang.Object ruleType_ = "";
      /**
       * <code>string ruleType = 5;</code>
       *
       * @return The ruleType.
       */
      public java.lang.String getRuleType() {
        java.lang.Object ref = ruleType_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          ruleType_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string ruleType = 5;</code>
       *
       * @return The bytes for ruleType.
       */
      public com.google.protobuf.ByteString getRuleTypeBytes() {
        java.lang.Object ref = ruleType_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          ruleType_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string ruleType = 5;</code>
       *
       * @param value The ruleType to set.
       * @return This builder for chaining.
       */
      public Builder setRuleType(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        ruleType_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string ruleType = 5;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearRuleType() {

        ruleType_ = getDefaultInstance().getRuleType();
        onChanged();
        return this;
      }
      /**
       * <code>string ruleType = 5;</code>
       *
       * @param value The bytes for ruleType to set.
       * @return This builder for chaining.
       */
      public Builder setRuleTypeBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        ruleType_ = value;
        onChanged();
        return this;
      }

      private java.util.List<com.cpdss.common.generated.Common.RulesInputs> inputs_ =
          java.util.Collections.emptyList();

      private void ensureInputsIsMutable() {
        if (!((bitField0_ & 0x00000001) != 0)) {
          inputs_ = new java.util.ArrayList<com.cpdss.common.generated.Common.RulesInputs>(inputs_);
          bitField0_ |= 0x00000001;
        }
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
              com.cpdss.common.generated.Common.RulesInputs,
              com.cpdss.common.generated.Common.RulesInputs.Builder,
              com.cpdss.common.generated.Common.RulesInputsOrBuilder>
          inputsBuilder_;

      /** <code>repeated .RulesInputs inputs = 6;</code> */
      public java.util.List<com.cpdss.common.generated.Common.RulesInputs> getInputsList() {
        if (inputsBuilder_ == null) {
          return java.util.Collections.unmodifiableList(inputs_);
        } else {
          return inputsBuilder_.getMessageList();
        }
      }
      /** <code>repeated .RulesInputs inputs = 6;</code> */
      public int getInputsCount() {
        if (inputsBuilder_ == null) {
          return inputs_.size();
        } else {
          return inputsBuilder_.getCount();
        }
      }
      /** <code>repeated .RulesInputs inputs = 6;</code> */
      public com.cpdss.common.generated.Common.RulesInputs getInputs(int index) {
        if (inputsBuilder_ == null) {
          return inputs_.get(index);
        } else {
          return inputsBuilder_.getMessage(index);
        }
      }
      /** <code>repeated .RulesInputs inputs = 6;</code> */
      public Builder setInputs(int index, com.cpdss.common.generated.Common.RulesInputs value) {
        if (inputsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureInputsIsMutable();
          inputs_.set(index, value);
          onChanged();
        } else {
          inputsBuilder_.setMessage(index, value);
        }
        return this;
      }
      /** <code>repeated .RulesInputs inputs = 6;</code> */
      public Builder setInputs(
          int index, com.cpdss.common.generated.Common.RulesInputs.Builder builderForValue) {
        if (inputsBuilder_ == null) {
          ensureInputsIsMutable();
          inputs_.set(index, builderForValue.build());
          onChanged();
        } else {
          inputsBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .RulesInputs inputs = 6;</code> */
      public Builder addInputs(com.cpdss.common.generated.Common.RulesInputs value) {
        if (inputsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureInputsIsMutable();
          inputs_.add(value);
          onChanged();
        } else {
          inputsBuilder_.addMessage(value);
        }
        return this;
      }
      /** <code>repeated .RulesInputs inputs = 6;</code> */
      public Builder addInputs(int index, com.cpdss.common.generated.Common.RulesInputs value) {
        if (inputsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureInputsIsMutable();
          inputs_.add(index, value);
          onChanged();
        } else {
          inputsBuilder_.addMessage(index, value);
        }
        return this;
      }
      /** <code>repeated .RulesInputs inputs = 6;</code> */
      public Builder addInputs(
          com.cpdss.common.generated.Common.RulesInputs.Builder builderForValue) {
        if (inputsBuilder_ == null) {
          ensureInputsIsMutable();
          inputs_.add(builderForValue.build());
          onChanged();
        } else {
          inputsBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .RulesInputs inputs = 6;</code> */
      public Builder addInputs(
          int index, com.cpdss.common.generated.Common.RulesInputs.Builder builderForValue) {
        if (inputsBuilder_ == null) {
          ensureInputsIsMutable();
          inputs_.add(index, builderForValue.build());
          onChanged();
        } else {
          inputsBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .RulesInputs inputs = 6;</code> */
      public Builder addAllInputs(
          java.lang.Iterable<? extends com.cpdss.common.generated.Common.RulesInputs> values) {
        if (inputsBuilder_ == null) {
          ensureInputsIsMutable();
          com.google.protobuf.AbstractMessageLite.Builder.addAll(values, inputs_);
          onChanged();
        } else {
          inputsBuilder_.addAllMessages(values);
        }
        return this;
      }
      /** <code>repeated .RulesInputs inputs = 6;</code> */
      public Builder clearInputs() {
        if (inputsBuilder_ == null) {
          inputs_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
          onChanged();
        } else {
          inputsBuilder_.clear();
        }
        return this;
      }
      /** <code>repeated .RulesInputs inputs = 6;</code> */
      public Builder removeInputs(int index) {
        if (inputsBuilder_ == null) {
          ensureInputsIsMutable();
          inputs_.remove(index);
          onChanged();
        } else {
          inputsBuilder_.remove(index);
        }
        return this;
      }
      /** <code>repeated .RulesInputs inputs = 6;</code> */
      public com.cpdss.common.generated.Common.RulesInputs.Builder getInputsBuilder(int index) {
        return getInputsFieldBuilder().getBuilder(index);
      }
      /** <code>repeated .RulesInputs inputs = 6;</code> */
      public com.cpdss.common.generated.Common.RulesInputsOrBuilder getInputsOrBuilder(int index) {
        if (inputsBuilder_ == null) {
          return inputs_.get(index);
        } else {
          return inputsBuilder_.getMessageOrBuilder(index);
        }
      }
      /** <code>repeated .RulesInputs inputs = 6;</code> */
      public java.util.List<? extends com.cpdss.common.generated.Common.RulesInputsOrBuilder>
          getInputsOrBuilderList() {
        if (inputsBuilder_ != null) {
          return inputsBuilder_.getMessageOrBuilderList();
        } else {
          return java.util.Collections.unmodifiableList(inputs_);
        }
      }
      /** <code>repeated .RulesInputs inputs = 6;</code> */
      public com.cpdss.common.generated.Common.RulesInputs.Builder addInputsBuilder() {
        return getInputsFieldBuilder()
            .addBuilder(com.cpdss.common.generated.Common.RulesInputs.getDefaultInstance());
      }
      /** <code>repeated .RulesInputs inputs = 6;</code> */
      public com.cpdss.common.generated.Common.RulesInputs.Builder addInputsBuilder(int index) {
        return getInputsFieldBuilder()
            .addBuilder(index, com.cpdss.common.generated.Common.RulesInputs.getDefaultInstance());
      }
      /** <code>repeated .RulesInputs inputs = 6;</code> */
      public java.util.List<com.cpdss.common.generated.Common.RulesInputs.Builder>
          getInputsBuilderList() {
        return getInputsFieldBuilder().getBuilderList();
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
              com.cpdss.common.generated.Common.RulesInputs,
              com.cpdss.common.generated.Common.RulesInputs.Builder,
              com.cpdss.common.generated.Common.RulesInputsOrBuilder>
          getInputsFieldBuilder() {
        if (inputsBuilder_ == null) {
          inputsBuilder_ =
              new com.google.protobuf.RepeatedFieldBuilderV3<
                  com.cpdss.common.generated.Common.RulesInputs,
                  com.cpdss.common.generated.Common.RulesInputs.Builder,
                  com.cpdss.common.generated.Common.RulesInputsOrBuilder>(
                  inputs_, ((bitField0_ & 0x00000001) != 0), getParentForChildren(), isClean());
          inputs_ = null;
        }
        return inputsBuilder_;
      }

      private java.lang.Object ruleTemplateId_ = "";
      /**
       * <code>string ruleTemplateId = 7;</code>
       *
       * @return The ruleTemplateId.
       */
      public java.lang.String getRuleTemplateId() {
        java.lang.Object ref = ruleTemplateId_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          ruleTemplateId_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string ruleTemplateId = 7;</code>
       *
       * @return The bytes for ruleTemplateId.
       */
      public com.google.protobuf.ByteString getRuleTemplateIdBytes() {
        java.lang.Object ref = ruleTemplateId_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          ruleTemplateId_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string ruleTemplateId = 7;</code>
       *
       * @param value The ruleTemplateId to set.
       * @return This builder for chaining.
       */
      public Builder setRuleTemplateId(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        ruleTemplateId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string ruleTemplateId = 7;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearRuleTemplateId() {

        ruleTemplateId_ = getDefaultInstance().getRuleTemplateId();
        onChanged();
        return this;
      }
      /**
       * <code>string ruleTemplateId = 7;</code>
       *
       * @param value The bytes for ruleTemplateId to set.
       * @return This builder for chaining.
       */
      public Builder setRuleTemplateIdBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        ruleTemplateId_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object vesselRuleXId_ = "";
      /**
       * <code>string vesselRuleXId = 8;</code>
       *
       * @return The vesselRuleXId.
       */
      public java.lang.String getVesselRuleXId() {
        java.lang.Object ref = vesselRuleXId_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          vesselRuleXId_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string vesselRuleXId = 8;</code>
       *
       * @return The bytes for vesselRuleXId.
       */
      public com.google.protobuf.ByteString getVesselRuleXIdBytes() {
        java.lang.Object ref = vesselRuleXId_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          vesselRuleXId_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string vesselRuleXId = 8;</code>
       *
       * @param value The vesselRuleXId to set.
       * @return This builder for chaining.
       */
      public Builder setVesselRuleXId(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        vesselRuleXId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string vesselRuleXId = 8;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearVesselRuleXId() {

        vesselRuleXId_ = getDefaultInstance().getVesselRuleXId();
        onChanged();
        return this;
      }
      /**
       * <code>string vesselRuleXId = 8;</code>
       *
       * @param value The bytes for vesselRuleXId to set.
       * @return This builder for chaining.
       */
      public Builder setVesselRuleXIdBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        vesselRuleXId_ = value;
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

      // @@protoc_insertion_point(builder_scope:Rules)
    }

    // @@protoc_insertion_point(class_scope:Rules)
    private static final com.cpdss.common.generated.Common.Rules DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.Common.Rules();
    }

    public static com.cpdss.common.generated.Common.Rules getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Rules> PARSER =
        new com.google.protobuf.AbstractParser<Rules>() {
          @java.lang.Override
          public Rules parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new Rules(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<Rules> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<Rules> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.Common.Rules getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface RulesInputsOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:RulesInputs)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>string prefix = 1;</code>
     *
     * @return The prefix.
     */
    java.lang.String getPrefix();
    /**
     * <code>string prefix = 1;</code>
     *
     * @return The bytes for prefix.
     */
    com.google.protobuf.ByteString getPrefixBytes();

    /**
     * <code>string defaultValue = 2;</code>
     *
     * @return The defaultValue.
     */
    java.lang.String getDefaultValue();
    /**
     * <code>string defaultValue = 2;</code>
     *
     * @return The bytes for defaultValue.
     */
    com.google.protobuf.ByteString getDefaultValueBytes();

    /**
     * <code>string type = 3;</code>
     *
     * @return The type.
     */
    java.lang.String getType();
    /**
     * <code>string type = 3;</code>
     *
     * @return The bytes for type.
     */
    com.google.protobuf.ByteString getTypeBytes();

    /**
     * <code>string max = 4;</code>
     *
     * @return The max.
     */
    java.lang.String getMax();
    /**
     * <code>string max = 4;</code>
     *
     * @return The bytes for max.
     */
    com.google.protobuf.ByteString getMaxBytes();

    /**
     * <code>string min = 5;</code>
     *
     * @return The min.
     */
    java.lang.String getMin();
    /**
     * <code>string min = 5;</code>
     *
     * @return The bytes for min.
     */
    com.google.protobuf.ByteString getMinBytes();

    /**
     * <code>string value = 6;</code>
     *
     * @return The value.
     */
    java.lang.String getValue();
    /**
     * <code>string value = 6;</code>
     *
     * @return The bytes for value.
     */
    com.google.protobuf.ByteString getValueBytes();

    /**
     * <code>string suffix = 7;</code>
     *
     * @return The suffix.
     */
    java.lang.String getSuffix();
    /**
     * <code>string suffix = 7;</code>
     *
     * @return The bytes for suffix.
     */
    com.google.protobuf.ByteString getSuffixBytes();

    /**
     * <code>string id = 8;</code>
     *
     * @return The id.
     */
    java.lang.String getId();
    /**
     * <code>string id = 8;</code>
     *
     * @return The bytes for id.
     */
    com.google.protobuf.ByteString getIdBytes();
  }
  /** Protobuf type {@code RulesInputs} */
  public static final class RulesInputs extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:RulesInputs)
      RulesInputsOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use RulesInputs.newBuilder() to construct.
    private RulesInputs(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private RulesInputs() {
      prefix_ = "";
      defaultValue_ = "";
      type_ = "";
      max_ = "";
      min_ = "";
      value_ = "";
      suffix_ = "";
      id_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new RulesInputs();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private RulesInputs(
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

                prefix_ = s;
                break;
              }
            case 18:
              {
                java.lang.String s = input.readStringRequireUtf8();

                defaultValue_ = s;
                break;
              }
            case 26:
              {
                java.lang.String s = input.readStringRequireUtf8();

                type_ = s;
                break;
              }
            case 34:
              {
                java.lang.String s = input.readStringRequireUtf8();

                max_ = s;
                break;
              }
            case 42:
              {
                java.lang.String s = input.readStringRequireUtf8();

                min_ = s;
                break;
              }
            case 50:
              {
                java.lang.String s = input.readStringRequireUtf8();

                value_ = s;
                break;
              }
            case 58:
              {
                java.lang.String s = input.readStringRequireUtf8();

                suffix_ = s;
                break;
              }
            case 66:
              {
                java.lang.String s = input.readStringRequireUtf8();

                id_ = s;
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
      return com.cpdss.common.generated.Common.internal_static_RulesInputs_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.Common.internal_static_RulesInputs_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.Common.RulesInputs.class,
              com.cpdss.common.generated.Common.RulesInputs.Builder.class);
    }

    public static final int PREFIX_FIELD_NUMBER = 1;
    private volatile java.lang.Object prefix_;
    /**
     * <code>string prefix = 1;</code>
     *
     * @return The prefix.
     */
    public java.lang.String getPrefix() {
      java.lang.Object ref = prefix_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        prefix_ = s;
        return s;
      }
    }
    /**
     * <code>string prefix = 1;</code>
     *
     * @return The bytes for prefix.
     */
    public com.google.protobuf.ByteString getPrefixBytes() {
      java.lang.Object ref = prefix_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        prefix_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int DEFAULTVALUE_FIELD_NUMBER = 2;
    private volatile java.lang.Object defaultValue_;
    /**
     * <code>string defaultValue = 2;</code>
     *
     * @return The defaultValue.
     */
    public java.lang.String getDefaultValue() {
      java.lang.Object ref = defaultValue_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        defaultValue_ = s;
        return s;
      }
    }
    /**
     * <code>string defaultValue = 2;</code>
     *
     * @return The bytes for defaultValue.
     */
    public com.google.protobuf.ByteString getDefaultValueBytes() {
      java.lang.Object ref = defaultValue_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        defaultValue_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int TYPE_FIELD_NUMBER = 3;
    private volatile java.lang.Object type_;
    /**
     * <code>string type = 3;</code>
     *
     * @return The type.
     */
    public java.lang.String getType() {
      java.lang.Object ref = type_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        type_ = s;
        return s;
      }
    }
    /**
     * <code>string type = 3;</code>
     *
     * @return The bytes for type.
     */
    public com.google.protobuf.ByteString getTypeBytes() {
      java.lang.Object ref = type_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        type_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int MAX_FIELD_NUMBER = 4;
    private volatile java.lang.Object max_;
    /**
     * <code>string max = 4;</code>
     *
     * @return The max.
     */
    public java.lang.String getMax() {
      java.lang.Object ref = max_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        max_ = s;
        return s;
      }
    }
    /**
     * <code>string max = 4;</code>
     *
     * @return The bytes for max.
     */
    public com.google.protobuf.ByteString getMaxBytes() {
      java.lang.Object ref = max_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        max_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int MIN_FIELD_NUMBER = 5;
    private volatile java.lang.Object min_;
    /**
     * <code>string min = 5;</code>
     *
     * @return The min.
     */
    public java.lang.String getMin() {
      java.lang.Object ref = min_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        min_ = s;
        return s;
      }
    }
    /**
     * <code>string min = 5;</code>
     *
     * @return The bytes for min.
     */
    public com.google.protobuf.ByteString getMinBytes() {
      java.lang.Object ref = min_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        min_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int VALUE_FIELD_NUMBER = 6;
    private volatile java.lang.Object value_;
    /**
     * <code>string value = 6;</code>
     *
     * @return The value.
     */
    public java.lang.String getValue() {
      java.lang.Object ref = value_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        value_ = s;
        return s;
      }
    }
    /**
     * <code>string value = 6;</code>
     *
     * @return The bytes for value.
     */
    public com.google.protobuf.ByteString getValueBytes() {
      java.lang.Object ref = value_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        value_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int SUFFIX_FIELD_NUMBER = 7;
    private volatile java.lang.Object suffix_;
    /**
     * <code>string suffix = 7;</code>
     *
     * @return The suffix.
     */
    public java.lang.String getSuffix() {
      java.lang.Object ref = suffix_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        suffix_ = s;
        return s;
      }
    }
    /**
     * <code>string suffix = 7;</code>
     *
     * @return The bytes for suffix.
     */
    public com.google.protobuf.ByteString getSuffixBytes() {
      java.lang.Object ref = suffix_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        suffix_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int ID_FIELD_NUMBER = 8;
    private volatile java.lang.Object id_;
    /**
     * <code>string id = 8;</code>
     *
     * @return The id.
     */
    public java.lang.String getId() {
      java.lang.Object ref = id_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        id_ = s;
        return s;
      }
    }
    /**
     * <code>string id = 8;</code>
     *
     * @return The bytes for id.
     */
    public com.google.protobuf.ByteString getIdBytes() {
      java.lang.Object ref = id_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        id_ = b;
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
      if (!getPrefixBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, prefix_);
      }
      if (!getDefaultValueBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, defaultValue_);
      }
      if (!getTypeBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, type_);
      }
      if (!getMaxBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 4, max_);
      }
      if (!getMinBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 5, min_);
      }
      if (!getValueBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 6, value_);
      }
      if (!getSuffixBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 7, suffix_);
      }
      if (!getIdBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 8, id_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getPrefixBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, prefix_);
      }
      if (!getDefaultValueBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, defaultValue_);
      }
      if (!getTypeBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, type_);
      }
      if (!getMaxBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, max_);
      }
      if (!getMinBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, min_);
      }
      if (!getValueBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(6, value_);
      }
      if (!getSuffixBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(7, suffix_);
      }
      if (!getIdBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(8, id_);
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
      if (!(obj instanceof com.cpdss.common.generated.Common.RulesInputs)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.Common.RulesInputs other =
          (com.cpdss.common.generated.Common.RulesInputs) obj;

      if (!getPrefix().equals(other.getPrefix())) return false;
      if (!getDefaultValue().equals(other.getDefaultValue())) return false;
      if (!getType().equals(other.getType())) return false;
      if (!getMax().equals(other.getMax())) return false;
      if (!getMin().equals(other.getMin())) return false;
      if (!getValue().equals(other.getValue())) return false;
      if (!getSuffix().equals(other.getSuffix())) return false;
      if (!getId().equals(other.getId())) return false;
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
      hash = (37 * hash) + PREFIX_FIELD_NUMBER;
      hash = (53 * hash) + getPrefix().hashCode();
      hash = (37 * hash) + DEFAULTVALUE_FIELD_NUMBER;
      hash = (53 * hash) + getDefaultValue().hashCode();
      hash = (37 * hash) + TYPE_FIELD_NUMBER;
      hash = (53 * hash) + getType().hashCode();
      hash = (37 * hash) + MAX_FIELD_NUMBER;
      hash = (53 * hash) + getMax().hashCode();
      hash = (37 * hash) + MIN_FIELD_NUMBER;
      hash = (53 * hash) + getMin().hashCode();
      hash = (37 * hash) + VALUE_FIELD_NUMBER;
      hash = (53 * hash) + getValue().hashCode();
      hash = (37 * hash) + SUFFIX_FIELD_NUMBER;
      hash = (53 * hash) + getSuffix().hashCode();
      hash = (37 * hash) + ID_FIELD_NUMBER;
      hash = (53 * hash) + getId().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.Common.RulesInputs parseFrom(java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Common.RulesInputs parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.RulesInputs parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Common.RulesInputs parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.RulesInputs parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Common.RulesInputs parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.RulesInputs parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Common.RulesInputs parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.RulesInputs parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Common.RulesInputs parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.RulesInputs parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Common.RulesInputs parseFrom(
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

    public static Builder newBuilder(com.cpdss.common.generated.Common.RulesInputs prototype) {
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
    /** Protobuf type {@code RulesInputs} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:RulesInputs)
        com.cpdss.common.generated.Common.RulesInputsOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.Common.internal_static_RulesInputs_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.Common.internal_static_RulesInputs_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.Common.RulesInputs.class,
                com.cpdss.common.generated.Common.RulesInputs.Builder.class);
      }

      // Construct using com.cpdss.common.generated.Common.RulesInputs.newBuilder()
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
        prefix_ = "";

        defaultValue_ = "";

        type_ = "";

        max_ = "";

        min_ = "";

        value_ = "";

        suffix_ = "";

        id_ = "";

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.Common.internal_static_RulesInputs_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.Common.RulesInputs getDefaultInstanceForType() {
        return com.cpdss.common.generated.Common.RulesInputs.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.Common.RulesInputs build() {
        com.cpdss.common.generated.Common.RulesInputs result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.Common.RulesInputs buildPartial() {
        com.cpdss.common.generated.Common.RulesInputs result =
            new com.cpdss.common.generated.Common.RulesInputs(this);
        result.prefix_ = prefix_;
        result.defaultValue_ = defaultValue_;
        result.type_ = type_;
        result.max_ = max_;
        result.min_ = min_;
        result.value_ = value_;
        result.suffix_ = suffix_;
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
        if (other instanceof com.cpdss.common.generated.Common.RulesInputs) {
          return mergeFrom((com.cpdss.common.generated.Common.RulesInputs) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.cpdss.common.generated.Common.RulesInputs other) {
        if (other == com.cpdss.common.generated.Common.RulesInputs.getDefaultInstance())
          return this;
        if (!other.getPrefix().isEmpty()) {
          prefix_ = other.prefix_;
          onChanged();
        }
        if (!other.getDefaultValue().isEmpty()) {
          defaultValue_ = other.defaultValue_;
          onChanged();
        }
        if (!other.getType().isEmpty()) {
          type_ = other.type_;
          onChanged();
        }
        if (!other.getMax().isEmpty()) {
          max_ = other.max_;
          onChanged();
        }
        if (!other.getMin().isEmpty()) {
          min_ = other.min_;
          onChanged();
        }
        if (!other.getValue().isEmpty()) {
          value_ = other.value_;
          onChanged();
        }
        if (!other.getSuffix().isEmpty()) {
          suffix_ = other.suffix_;
          onChanged();
        }
        if (!other.getId().isEmpty()) {
          id_ = other.id_;
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
        com.cpdss.common.generated.Common.RulesInputs parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.cpdss.common.generated.Common.RulesInputs) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private java.lang.Object prefix_ = "";
      /**
       * <code>string prefix = 1;</code>
       *
       * @return The prefix.
       */
      public java.lang.String getPrefix() {
        java.lang.Object ref = prefix_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          prefix_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string prefix = 1;</code>
       *
       * @return The bytes for prefix.
       */
      public com.google.protobuf.ByteString getPrefixBytes() {
        java.lang.Object ref = prefix_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          prefix_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string prefix = 1;</code>
       *
       * @param value The prefix to set.
       * @return This builder for chaining.
       */
      public Builder setPrefix(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        prefix_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string prefix = 1;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearPrefix() {

        prefix_ = getDefaultInstance().getPrefix();
        onChanged();
        return this;
      }
      /**
       * <code>string prefix = 1;</code>
       *
       * @param value The bytes for prefix to set.
       * @return This builder for chaining.
       */
      public Builder setPrefixBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        prefix_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object defaultValue_ = "";
      /**
       * <code>string defaultValue = 2;</code>
       *
       * @return The defaultValue.
       */
      public java.lang.String getDefaultValue() {
        java.lang.Object ref = defaultValue_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          defaultValue_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string defaultValue = 2;</code>
       *
       * @return The bytes for defaultValue.
       */
      public com.google.protobuf.ByteString getDefaultValueBytes() {
        java.lang.Object ref = defaultValue_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          defaultValue_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string defaultValue = 2;</code>
       *
       * @param value The defaultValue to set.
       * @return This builder for chaining.
       */
      public Builder setDefaultValue(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        defaultValue_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string defaultValue = 2;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearDefaultValue() {

        defaultValue_ = getDefaultInstance().getDefaultValue();
        onChanged();
        return this;
      }
      /**
       * <code>string defaultValue = 2;</code>
       *
       * @param value The bytes for defaultValue to set.
       * @return This builder for chaining.
       */
      public Builder setDefaultValueBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        defaultValue_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object type_ = "";
      /**
       * <code>string type = 3;</code>
       *
       * @return The type.
       */
      public java.lang.String getType() {
        java.lang.Object ref = type_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          type_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string type = 3;</code>
       *
       * @return The bytes for type.
       */
      public com.google.protobuf.ByteString getTypeBytes() {
        java.lang.Object ref = type_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          type_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string type = 3;</code>
       *
       * @param value The type to set.
       * @return This builder for chaining.
       */
      public Builder setType(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        type_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string type = 3;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearType() {

        type_ = getDefaultInstance().getType();
        onChanged();
        return this;
      }
      /**
       * <code>string type = 3;</code>
       *
       * @param value The bytes for type to set.
       * @return This builder for chaining.
       */
      public Builder setTypeBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        type_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object max_ = "";
      /**
       * <code>string max = 4;</code>
       *
       * @return The max.
       */
      public java.lang.String getMax() {
        java.lang.Object ref = max_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          max_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string max = 4;</code>
       *
       * @return The bytes for max.
       */
      public com.google.protobuf.ByteString getMaxBytes() {
        java.lang.Object ref = max_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          max_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string max = 4;</code>
       *
       * @param value The max to set.
       * @return This builder for chaining.
       */
      public Builder setMax(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        max_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string max = 4;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearMax() {

        max_ = getDefaultInstance().getMax();
        onChanged();
        return this;
      }
      /**
       * <code>string max = 4;</code>
       *
       * @param value The bytes for max to set.
       * @return This builder for chaining.
       */
      public Builder setMaxBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        max_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object min_ = "";
      /**
       * <code>string min = 5;</code>
       *
       * @return The min.
       */
      public java.lang.String getMin() {
        java.lang.Object ref = min_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          min_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string min = 5;</code>
       *
       * @return The bytes for min.
       */
      public com.google.protobuf.ByteString getMinBytes() {
        java.lang.Object ref = min_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          min_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string min = 5;</code>
       *
       * @param value The min to set.
       * @return This builder for chaining.
       */
      public Builder setMin(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        min_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string min = 5;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearMin() {

        min_ = getDefaultInstance().getMin();
        onChanged();
        return this;
      }
      /**
       * <code>string min = 5;</code>
       *
       * @param value The bytes for min to set.
       * @return This builder for chaining.
       */
      public Builder setMinBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        min_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object value_ = "";
      /**
       * <code>string value = 6;</code>
       *
       * @return The value.
       */
      public java.lang.String getValue() {
        java.lang.Object ref = value_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          value_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string value = 6;</code>
       *
       * @return The bytes for value.
       */
      public com.google.protobuf.ByteString getValueBytes() {
        java.lang.Object ref = value_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          value_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string value = 6;</code>
       *
       * @param value The value to set.
       * @return This builder for chaining.
       */
      public Builder setValue(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        value_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string value = 6;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearValue() {

        value_ = getDefaultInstance().getValue();
        onChanged();
        return this;
      }
      /**
       * <code>string value = 6;</code>
       *
       * @param value The bytes for value to set.
       * @return This builder for chaining.
       */
      public Builder setValueBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        value_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object suffix_ = "";
      /**
       * <code>string suffix = 7;</code>
       *
       * @return The suffix.
       */
      public java.lang.String getSuffix() {
        java.lang.Object ref = suffix_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          suffix_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string suffix = 7;</code>
       *
       * @return The bytes for suffix.
       */
      public com.google.protobuf.ByteString getSuffixBytes() {
        java.lang.Object ref = suffix_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          suffix_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string suffix = 7;</code>
       *
       * @param value The suffix to set.
       * @return This builder for chaining.
       */
      public Builder setSuffix(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        suffix_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string suffix = 7;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearSuffix() {

        suffix_ = getDefaultInstance().getSuffix();
        onChanged();
        return this;
      }
      /**
       * <code>string suffix = 7;</code>
       *
       * @param value The bytes for suffix to set.
       * @return This builder for chaining.
       */
      public Builder setSuffixBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        suffix_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object id_ = "";
      /**
       * <code>string id = 8;</code>
       *
       * @return The id.
       */
      public java.lang.String getId() {
        java.lang.Object ref = id_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          id_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string id = 8;</code>
       *
       * @return The bytes for id.
       */
      public com.google.protobuf.ByteString getIdBytes() {
        java.lang.Object ref = id_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          id_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string id = 8;</code>
       *
       * @param value The id to set.
       * @return This builder for chaining.
       */
      public Builder setId(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        id_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string id = 8;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearId() {

        id_ = getDefaultInstance().getId();
        onChanged();
        return this;
      }
      /**
       * <code>string id = 8;</code>
       *
       * @param value The bytes for id to set.
       * @return This builder for chaining.
       */
      public Builder setIdBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        id_ = value;
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

      // @@protoc_insertion_point(builder_scope:RulesInputs)
    }

    // @@protoc_insertion_point(class_scope:RulesInputs)
    private static final com.cpdss.common.generated.Common.RulesInputs DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.Common.RulesInputs();
    }

    public static com.cpdss.common.generated.Common.RulesInputs getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<RulesInputs> PARSER =
        new com.google.protobuf.AbstractParser<RulesInputs>() {
          @java.lang.Override
          public RulesInputs parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new RulesInputs(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<RulesInputs> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<RulesInputs> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.Common.RulesInputs getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_ResponseStatus_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ResponseStatus_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_BillOfLadding_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_BillOfLadding_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_RulePlans_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_RulePlans_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor internal_static_Rules_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Rules_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_RulesInputs_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_RulesInputs_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }

  private static com.google.protobuf.Descriptors.FileDescriptor descriptor;

  static {
    java.lang.String[] descriptorData = {
      "\n\014common.proto\"W\n\016ResponseStatus\022\016\n\006stat"
          + "us\030\001 \001(\t\022\017\n\007message\030\002 \001(\t\022\014\n\004code\030\003 \001(\t\022"
          + "\026\n\016httpStatusCode\030\004 \001(\005\"\234\001\n\rBillOfLaddin"
          + "g\022\n\n\002id\030\001 \001(\003\022\016\n\006portId\030\002 \001(\003\022\017\n\007cargoId"
          + "\030\003 \001(\003\022\024\n\014quantityBbls\030\004 \001(\t\022\022\n\nquantity"
          + "Mt\030\005 \001(\t\022\022\n\nquantityKl\030\006 \001(\t\022\013\n\003api\030\007 \001("
          + "\t\022\023\n\013temperature\030\010 \001(\t\"2\n\tRulePlans\022\016\n\006h"
          + "eader\030\001 \001(\t\022\025\n\005rules\030\002 \003(\0132\006.Rules\"\255\001\n\005R"
          + "ules\022\n\n\002id\030\001 \001(\t\022\016\n\006enable\030\002 \001(\010\022\017\n\007disa"
          + "ble\030\003 \001(\010\022\030\n\020disableInSettigs\030\004 \001(\010\022\020\n\010r"
          + "uleType\030\005 \001(\t\022\034\n\006inputs\030\006 \003(\0132\014.RulesInp"
          + "uts\022\026\n\016ruleTemplateId\030\007 \001(\t\022\025\n\rvesselRul"
          + "eXId\030\010 \001(\t\"\206\001\n\013RulesInputs\022\016\n\006prefix\030\001 \001"
          + "(\t\022\024\n\014defaultValue\030\002 \001(\t\022\014\n\004type\030\003 \001(\t\022\013"
          + "\n\003max\030\004 \001(\t\022\013\n\003min\030\005 \001(\t\022\r\n\005value\030\006 \001(\t\022"
          + "\016\n\006suffix\030\007 \001(\t\022\n\n\002id\030\010 \001(\t*E\n\rPLANNING_"
          + "TYPE\022\013\n\007VALUE_A\020\000\022\022\n\016LOADABLE_STUDY\020\001\022\023\n"
          + "\017DISCHARGE_STUDY\020\002B\036\n\032com.cpdss.common.g"
          + "eneratedP\000b\006proto3"
    };
    descriptor =
        com.google.protobuf.Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(
            descriptorData, new com.google.protobuf.Descriptors.FileDescriptor[] {});
    internal_static_ResponseStatus_descriptor = getDescriptor().getMessageTypes().get(0);
    internal_static_ResponseStatus_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_ResponseStatus_descriptor,
            new java.lang.String[] {
              "Status", "Message", "Code", "HttpStatusCode",
            });
    internal_static_BillOfLadding_descriptor = getDescriptor().getMessageTypes().get(1);
    internal_static_BillOfLadding_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_BillOfLadding_descriptor,
            new java.lang.String[] {
              "Id",
              "PortId",
              "CargoId",
              "QuantityBbls",
              "QuantityMt",
              "QuantityKl",
              "Api",
              "Temperature",
            });
    internal_static_RulePlans_descriptor = getDescriptor().getMessageTypes().get(2);
    internal_static_RulePlans_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_RulePlans_descriptor,
            new java.lang.String[] {
              "Header", "Rules",
            });
    internal_static_Rules_descriptor = getDescriptor().getMessageTypes().get(3);
    internal_static_Rules_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_Rules_descriptor,
            new java.lang.String[] {
              "Id",
              "Enable",
              "Disable",
              "DisableInSettigs",
              "RuleType",
              "Inputs",
              "RuleTemplateId",
              "VesselRuleXId",
            });
    internal_static_RulesInputs_descriptor = getDescriptor().getMessageTypes().get(4);
    internal_static_RulesInputs_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_RulesInputs_descriptor,
            new java.lang.String[] {
              "Prefix", "DefaultValue", "Type", "Max", "Min", "Value", "Suffix", "Id",
            });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
