/* Licensed at AlphaOri Technologies */
package com.cpdss.common.generated.loadableStudy;

public final class LoadableStudyModels {
  private LoadableStudyModels() {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistryLite registry) {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions((com.google.protobuf.ExtensionRegistryLite) registry);
  }

  public interface DischargeStudyRequestOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:DischargeStudyRequest)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int64 dischargeStudyId = 1;</code>
     *
     * @return The dischargeStudyId.
     */
    long getDischargeStudyId();
  }
  /** Protobuf type {@code DischargeStudyRequest} */
  public static final class DischargeStudyRequest extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:DischargeStudyRequest)
      DischargeStudyRequestOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use DischargeStudyRequest.newBuilder() to construct.
    private DischargeStudyRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private DischargeStudyRequest() {}

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new DischargeStudyRequest();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private DischargeStudyRequest(
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
                dischargeStudyId_ = input.readInt64();
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
      return com.cpdss
          .common
          .generated
          .loadableStudy
          .LoadableStudyModels
          .internal_static_DischargeStudyRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.loadableStudy.LoadableStudyModels
          .internal_static_DischargeStudyRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(
          com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyRequest.class,
          com.cpdss
              .common
              .generated
              .loadableStudy
              .LoadableStudyModels
              .DischargeStudyRequest
              .Builder
              .class);
    }

    public static final int DISCHARGESTUDYID_FIELD_NUMBER = 1;
    private long dischargeStudyId_;
    /**
     * <code>int64 dischargeStudyId = 1;</code>
     *
     * @return The dischargeStudyId.
     */
    public long getDischargeStudyId() {
      return dischargeStudyId_;
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
      if (dischargeStudyId_ != 0L) {
        output.writeInt64(1, dischargeStudyId_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (dischargeStudyId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(1, dischargeStudyId_);
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
      if (!(obj
          instanceof
          com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyRequest)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyRequest other =
          (com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyRequest) obj;

      if (getDischargeStudyId() != other.getDischargeStudyId()) return false;
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
      hash = (37 * hash) + DISCHARGESTUDYID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getDischargeStudyId());
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyRequest
        parseFrom(java.nio.ByteBuffer data)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyRequest
        parseFrom(
            java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyRequest
        parseFrom(com.google.protobuf.ByteString data)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyRequest
        parseFrom(
            com.google.protobuf.ByteString data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyRequest
        parseFrom(byte[] data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyRequest
        parseFrom(byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyRequest
        parseFrom(java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyRequest
        parseFrom(
            java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyRequest
        parseDelimitedFrom(java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyRequest
        parseDelimitedFrom(
            java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyRequest
        parseFrom(com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyRequest
        parseFrom(
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
        com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyRequest
            prototype) {
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
    /** Protobuf type {@code DischargeStudyRequest} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:DischargeStudyRequest)
        com.cpdss
            .common
            .generated
            .loadableStudy
            .LoadableStudyModels
            .DischargeStudyRequestOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss
            .common
            .generated
            .loadableStudy
            .LoadableStudyModels
            .internal_static_DischargeStudyRequest_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.loadableStudy.LoadableStudyModels
            .internal_static_DischargeStudyRequest_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss
                    .common
                    .generated
                    .loadableStudy
                    .LoadableStudyModels
                    .DischargeStudyRequest
                    .class,
                com.cpdss
                    .common
                    .generated
                    .loadableStudy
                    .LoadableStudyModels
                    .DischargeStudyRequest
                    .Builder
                    .class);
      }

      // Construct using
      // com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyRequest.newBuilder()
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
        dischargeStudyId_ = 0L;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss
            .common
            .generated
            .loadableStudy
            .LoadableStudyModels
            .internal_static_DischargeStudyRequest_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyRequest
          getDefaultInstanceForType() {
        return com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyRequest
            .getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyRequest
          build() {
        com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyRequest result =
            buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyRequest
          buildPartial() {
        com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyRequest result =
            new com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyRequest(
                this);
        result.dischargeStudyId_ = dischargeStudyId_;
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
        if (other
            instanceof
            com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyRequest) {
          return mergeFrom(
              (com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyRequest)
                  other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(
          com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyRequest
              other) {
        if (other
            == com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyRequest
                .getDefaultInstance()) return this;
        if (other.getDischargeStudyId() != 0L) {
          setDischargeStudyId(other.getDischargeStudyId());
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
        com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyRequest
            parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyRequest)
                  e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private long dischargeStudyId_;
      /**
       * <code>int64 dischargeStudyId = 1;</code>
       *
       * @return The dischargeStudyId.
       */
      public long getDischargeStudyId() {
        return dischargeStudyId_;
      }
      /**
       * <code>int64 dischargeStudyId = 1;</code>
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
       * <code>int64 dischargeStudyId = 1;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearDischargeStudyId() {

        dischargeStudyId_ = 0L;
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

      // @@protoc_insertion_point(builder_scope:DischargeStudyRequest)
    }

    // @@protoc_insertion_point(class_scope:DischargeStudyRequest)
    private static final com.cpdss
            .common
            .generated
            .loadableStudy
            .LoadableStudyModels
            .DischargeStudyRequest
        DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE =
          new com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyRequest();
    }

    public static com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyRequest
        getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<DischargeStudyRequest> PARSER =
        new com.google.protobuf.AbstractParser<DischargeStudyRequest>() {
          @java.lang.Override
          public DischargeStudyRequest parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new DischargeStudyRequest(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<DischargeStudyRequest> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<DischargeStudyRequest> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyRequest
        getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface DischargeStudyDetailOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:DischargeStudyDetail)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>string name = 1;</code>
     *
     * @return The name.
     */
    java.lang.String getName();
    /**
     * <code>string name = 1;</code>
     *
     * @return The bytes for name.
     */
    com.google.protobuf.ByteString getNameBytes();

    /**
     * <code>string enquiryDetails = 2;</code>
     *
     * @return The enquiryDetails.
     */
    java.lang.String getEnquiryDetails();
    /**
     * <code>string enquiryDetails = 2;</code>
     *
     * @return The bytes for enquiryDetails.
     */
    com.google.protobuf.ByteString getEnquiryDetailsBytes();

    /**
     * <code>int64 vesselId = 3;</code>
     *
     * @return The vesselId.
     */
    long getVesselId();

    /**
     * <code>int64 voyageId = 4;</code>
     *
     * @return The voyageId.
     */
    long getVoyageId();

    /**
     * <code>int64 dischargeStudyId = 5;</code>
     *
     * @return The dischargeStudyId.
     */
    long getDischargeStudyId();
  }
  /** Protobuf type {@code DischargeStudyDetail} */
  public static final class DischargeStudyDetail extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:DischargeStudyDetail)
      DischargeStudyDetailOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use DischargeStudyDetail.newBuilder() to construct.
    private DischargeStudyDetail(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private DischargeStudyDetail() {
      name_ = "";
      enquiryDetails_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new DischargeStudyDetail();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private DischargeStudyDetail(
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

                name_ = s;
                break;
              }
            case 18:
              {
                java.lang.String s = input.readStringRequireUtf8();

                enquiryDetails_ = s;
                break;
              }
            case 24:
              {
                vesselId_ = input.readInt64();
                break;
              }
            case 32:
              {
                voyageId_ = input.readInt64();
                break;
              }
            case 40:
              {
                dischargeStudyId_ = input.readInt64();
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
      return com.cpdss
          .common
          .generated
          .loadableStudy
          .LoadableStudyModels
          .internal_static_DischargeStudyDetail_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.loadableStudy.LoadableStudyModels
          .internal_static_DischargeStudyDetail_fieldAccessorTable.ensureFieldAccessorsInitialized(
          com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyDetail.class,
          com.cpdss
              .common
              .generated
              .loadableStudy
              .LoadableStudyModels
              .DischargeStudyDetail
              .Builder
              .class);
    }

    public static final int NAME_FIELD_NUMBER = 1;
    private volatile java.lang.Object name_;
    /**
     * <code>string name = 1;</code>
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
     * <code>string name = 1;</code>
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

    public static final int ENQUIRYDETAILS_FIELD_NUMBER = 2;
    private volatile java.lang.Object enquiryDetails_;
    /**
     * <code>string enquiryDetails = 2;</code>
     *
     * @return The enquiryDetails.
     */
    public java.lang.String getEnquiryDetails() {
      java.lang.Object ref = enquiryDetails_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        enquiryDetails_ = s;
        return s;
      }
    }
    /**
     * <code>string enquiryDetails = 2;</code>
     *
     * @return The bytes for enquiryDetails.
     */
    public com.google.protobuf.ByteString getEnquiryDetailsBytes() {
      java.lang.Object ref = enquiryDetails_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        enquiryDetails_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int VESSELID_FIELD_NUMBER = 3;
    private long vesselId_;
    /**
     * <code>int64 vesselId = 3;</code>
     *
     * @return The vesselId.
     */
    public long getVesselId() {
      return vesselId_;
    }

    public static final int VOYAGEID_FIELD_NUMBER = 4;
    private long voyageId_;
    /**
     * <code>int64 voyageId = 4;</code>
     *
     * @return The voyageId.
     */
    public long getVoyageId() {
      return voyageId_;
    }

    public static final int DISCHARGESTUDYID_FIELD_NUMBER = 5;
    private long dischargeStudyId_;
    /**
     * <code>int64 dischargeStudyId = 5;</code>
     *
     * @return The dischargeStudyId.
     */
    public long getDischargeStudyId() {
      return dischargeStudyId_;
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
      if (!getNameBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, name_);
      }
      if (!getEnquiryDetailsBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, enquiryDetails_);
      }
      if (vesselId_ != 0L) {
        output.writeInt64(3, vesselId_);
      }
      if (voyageId_ != 0L) {
        output.writeInt64(4, voyageId_);
      }
      if (dischargeStudyId_ != 0L) {
        output.writeInt64(5, dischargeStudyId_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getNameBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, name_);
      }
      if (!getEnquiryDetailsBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, enquiryDetails_);
      }
      if (vesselId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(3, vesselId_);
      }
      if (voyageId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(4, voyageId_);
      }
      if (dischargeStudyId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(5, dischargeStudyId_);
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
      if (!(obj
          instanceof
          com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyDetail)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyDetail other =
          (com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyDetail) obj;

      if (!getName().equals(other.getName())) return false;
      if (!getEnquiryDetails().equals(other.getEnquiryDetails())) return false;
      if (getVesselId() != other.getVesselId()) return false;
      if (getVoyageId() != other.getVoyageId()) return false;
      if (getDischargeStudyId() != other.getDischargeStudyId()) return false;
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
      hash = (37 * hash) + NAME_FIELD_NUMBER;
      hash = (53 * hash) + getName().hashCode();
      hash = (37 * hash) + ENQUIRYDETAILS_FIELD_NUMBER;
      hash = (53 * hash) + getEnquiryDetails().hashCode();
      hash = (37 * hash) + VESSELID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getVesselId());
      hash = (37 * hash) + VOYAGEID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getVoyageId());
      hash = (37 * hash) + DISCHARGESTUDYID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getDischargeStudyId());
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyDetail
        parseFrom(java.nio.ByteBuffer data)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyDetail
        parseFrom(
            java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyDetail
        parseFrom(com.google.protobuf.ByteString data)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyDetail
        parseFrom(
            com.google.protobuf.ByteString data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyDetail
        parseFrom(byte[] data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyDetail
        parseFrom(byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyDetail
        parseFrom(java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyDetail
        parseFrom(
            java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyDetail
        parseDelimitedFrom(java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyDetail
        parseDelimitedFrom(
            java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyDetail
        parseFrom(com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyDetail
        parseFrom(
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
        com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyDetail
            prototype) {
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
    /** Protobuf type {@code DischargeStudyDetail} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:DischargeStudyDetail)
        com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyDetailOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss
            .common
            .generated
            .loadableStudy
            .LoadableStudyModels
            .internal_static_DischargeStudyDetail_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.loadableStudy.LoadableStudyModels
            .internal_static_DischargeStudyDetail_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss
                    .common
                    .generated
                    .loadableStudy
                    .LoadableStudyModels
                    .DischargeStudyDetail
                    .class,
                com.cpdss
                    .common
                    .generated
                    .loadableStudy
                    .LoadableStudyModels
                    .DischargeStudyDetail
                    .Builder
                    .class);
      }

      // Construct using
      // com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyDetail.newBuilder()
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
        name_ = "";

        enquiryDetails_ = "";

        vesselId_ = 0L;

        voyageId_ = 0L;

        dischargeStudyId_ = 0L;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss
            .common
            .generated
            .loadableStudy
            .LoadableStudyModels
            .internal_static_DischargeStudyDetail_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyDetail
          getDefaultInstanceForType() {
        return com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyDetail
            .getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyDetail
          build() {
        com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyDetail result =
            buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyDetail
          buildPartial() {
        com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyDetail result =
            new com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyDetail(
                this);
        result.name_ = name_;
        result.enquiryDetails_ = enquiryDetails_;
        result.vesselId_ = vesselId_;
        result.voyageId_ = voyageId_;
        result.dischargeStudyId_ = dischargeStudyId_;
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
        if (other
            instanceof
            com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyDetail) {
          return mergeFrom(
              (com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyDetail)
                  other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(
          com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyDetail other) {
        if (other
            == com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyDetail
                .getDefaultInstance()) return this;
        if (!other.getName().isEmpty()) {
          name_ = other.name_;
          onChanged();
        }
        if (!other.getEnquiryDetails().isEmpty()) {
          enquiryDetails_ = other.enquiryDetails_;
          onChanged();
        }
        if (other.getVesselId() != 0L) {
          setVesselId(other.getVesselId());
        }
        if (other.getVoyageId() != 0L) {
          setVoyageId(other.getVoyageId());
        }
        if (other.getDischargeStudyId() != 0L) {
          setDischargeStudyId(other.getDischargeStudyId());
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
        com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyDetail
            parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyDetail)
                  e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private java.lang.Object name_ = "";
      /**
       * <code>string name = 1;</code>
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
       * <code>string name = 1;</code>
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
       * <code>string name = 1;</code>
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
       * <code>string name = 1;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearName() {

        name_ = getDefaultInstance().getName();
        onChanged();
        return this;
      }
      /**
       * <code>string name = 1;</code>
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

      private java.lang.Object enquiryDetails_ = "";
      /**
       * <code>string enquiryDetails = 2;</code>
       *
       * @return The enquiryDetails.
       */
      public java.lang.String getEnquiryDetails() {
        java.lang.Object ref = enquiryDetails_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          enquiryDetails_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string enquiryDetails = 2;</code>
       *
       * @return The bytes for enquiryDetails.
       */
      public com.google.protobuf.ByteString getEnquiryDetailsBytes() {
        java.lang.Object ref = enquiryDetails_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          enquiryDetails_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string enquiryDetails = 2;</code>
       *
       * @param value The enquiryDetails to set.
       * @return This builder for chaining.
       */
      public Builder setEnquiryDetails(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        enquiryDetails_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string enquiryDetails = 2;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearEnquiryDetails() {

        enquiryDetails_ = getDefaultInstance().getEnquiryDetails();
        onChanged();
        return this;
      }
      /**
       * <code>string enquiryDetails = 2;</code>
       *
       * @param value The bytes for enquiryDetails to set.
       * @return This builder for chaining.
       */
      public Builder setEnquiryDetailsBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        enquiryDetails_ = value;
        onChanged();
        return this;
      }

      private long vesselId_;
      /**
       * <code>int64 vesselId = 3;</code>
       *
       * @return The vesselId.
       */
      public long getVesselId() {
        return vesselId_;
      }
      /**
       * <code>int64 vesselId = 3;</code>
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
       * <code>int64 vesselId = 3;</code>
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
       * <code>int64 voyageId = 4;</code>
       *
       * @return The voyageId.
       */
      public long getVoyageId() {
        return voyageId_;
      }
      /**
       * <code>int64 voyageId = 4;</code>
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
       * <code>int64 voyageId = 4;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearVoyageId() {

        voyageId_ = 0L;
        onChanged();
        return this;
      }

      private long dischargeStudyId_;
      /**
       * <code>int64 dischargeStudyId = 5;</code>
       *
       * @return The dischargeStudyId.
       */
      public long getDischargeStudyId() {
        return dischargeStudyId_;
      }
      /**
       * <code>int64 dischargeStudyId = 5;</code>
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
       * <code>int64 dischargeStudyId = 5;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearDischargeStudyId() {

        dischargeStudyId_ = 0L;
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

      // @@protoc_insertion_point(builder_scope:DischargeStudyDetail)
    }

    // @@protoc_insertion_point(class_scope:DischargeStudyDetail)
    private static final com.cpdss
            .common
            .generated
            .loadableStudy
            .LoadableStudyModels
            .DischargeStudyDetail
        DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE =
          new com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyDetail();
    }

    public static com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyDetail
        getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<DischargeStudyDetail> PARSER =
        new com.google.protobuf.AbstractParser<DischargeStudyDetail>() {
          @java.lang.Override
          public DischargeStudyDetail parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new DischargeStudyDetail(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<DischargeStudyDetail> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<DischargeStudyDetail> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyDetail
        getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface UpdateDischargeStudyReplyOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:UpdateDischargeStudyReply)
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

    /**
     * <code>.UpdateDischargeStudyDetail dischargeStudy = 2;</code>
     *
     * @return Whether the dischargeStudy field is set.
     */
    boolean hasDischargeStudy();
    /**
     * <code>.UpdateDischargeStudyDetail dischargeStudy = 2;</code>
     *
     * @return The dischargeStudy.
     */
    com.cpdss.common.generated.loadableStudy.LoadableStudyModels.UpdateDischargeStudyDetail
        getDischargeStudy();
    /** <code>.UpdateDischargeStudyDetail dischargeStudy = 2;</code> */
    com.cpdss.common.generated.loadableStudy.LoadableStudyModels.UpdateDischargeStudyDetailOrBuilder
        getDischargeStudyOrBuilder();
  }
  /** Protobuf type {@code UpdateDischargeStudyReply} */
  public static final class UpdateDischargeStudyReply extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:UpdateDischargeStudyReply)
      UpdateDischargeStudyReplyOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use UpdateDischargeStudyReply.newBuilder() to construct.
    private UpdateDischargeStudyReply(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private UpdateDischargeStudyReply() {}

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new UpdateDischargeStudyReply();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private UpdateDischargeStudyReply(
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
            case 18:
              {
                com.cpdss
                        .common
                        .generated
                        .loadableStudy
                        .LoadableStudyModels
                        .UpdateDischargeStudyDetail
                        .Builder
                    subBuilder = null;
                if (dischargeStudy_ != null) {
                  subBuilder = dischargeStudy_.toBuilder();
                }
                dischargeStudy_ =
                    input.readMessage(
                        com.cpdss.common.generated.loadableStudy.LoadableStudyModels
                            .UpdateDischargeStudyDetail.parser(),
                        extensionRegistry);
                if (subBuilder != null) {
                  subBuilder.mergeFrom(dischargeStudy_);
                  dischargeStudy_ = subBuilder.buildPartial();
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
      return com.cpdss
          .common
          .generated
          .loadableStudy
          .LoadableStudyModels
          .internal_static_UpdateDischargeStudyReply_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.loadableStudy.LoadableStudyModels
          .internal_static_UpdateDischargeStudyReply_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss
                  .common
                  .generated
                  .loadableStudy
                  .LoadableStudyModels
                  .UpdateDischargeStudyReply
                  .class,
              com.cpdss
                  .common
                  .generated
                  .loadableStudy
                  .LoadableStudyModels
                  .UpdateDischargeStudyReply
                  .Builder
                  .class);
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

    public static final int DISCHARGESTUDY_FIELD_NUMBER = 2;
    private com.cpdss.common.generated.loadableStudy.LoadableStudyModels.UpdateDischargeStudyDetail
        dischargeStudy_;
    /**
     * <code>.UpdateDischargeStudyDetail dischargeStudy = 2;</code>
     *
     * @return Whether the dischargeStudy field is set.
     */
    public boolean hasDischargeStudy() {
      return dischargeStudy_ != null;
    }
    /**
     * <code>.UpdateDischargeStudyDetail dischargeStudy = 2;</code>
     *
     * @return The dischargeStudy.
     */
    public com.cpdss.common.generated.loadableStudy.LoadableStudyModels.UpdateDischargeStudyDetail
        getDischargeStudy() {
      return dischargeStudy_ == null
          ? com.cpdss.common.generated.loadableStudy.LoadableStudyModels.UpdateDischargeStudyDetail
              .getDefaultInstance()
          : dischargeStudy_;
    }
    /** <code>.UpdateDischargeStudyDetail dischargeStudy = 2;</code> */
    public com.cpdss
            .common
            .generated
            .loadableStudy
            .LoadableStudyModels
            .UpdateDischargeStudyDetailOrBuilder
        getDischargeStudyOrBuilder() {
      return getDischargeStudy();
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
      if (dischargeStudy_ != null) {
        output.writeMessage(2, getDischargeStudy());
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
      if (dischargeStudy_ != null) {
        size += com.google.protobuf.CodedOutputStream.computeMessageSize(2, getDischargeStudy());
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
      if (!(obj
          instanceof
          com.cpdss.common.generated.loadableStudy.LoadableStudyModels.UpdateDischargeStudyReply)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.loadableStudy.LoadableStudyModels.UpdateDischargeStudyReply other =
          (com.cpdss.common.generated.loadableStudy.LoadableStudyModels.UpdateDischargeStudyReply)
              obj;

      if (hasResponseStatus() != other.hasResponseStatus()) return false;
      if (hasResponseStatus()) {
        if (!getResponseStatus().equals(other.getResponseStatus())) return false;
      }
      if (hasDischargeStudy() != other.hasDischargeStudy()) return false;
      if (hasDischargeStudy()) {
        if (!getDischargeStudy().equals(other.getDischargeStudy())) return false;
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
      if (hasDischargeStudy()) {
        hash = (37 * hash) + DISCHARGESTUDY_FIELD_NUMBER;
        hash = (53 * hash) + getDischargeStudy().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss
            .common
            .generated
            .loadableStudy
            .LoadableStudyModels
            .UpdateDischargeStudyReply
        parseFrom(java.nio.ByteBuffer data)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss
            .common
            .generated
            .loadableStudy
            .LoadableStudyModels
            .UpdateDischargeStudyReply
        parseFrom(
            java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss
            .common
            .generated
            .loadableStudy
            .LoadableStudyModels
            .UpdateDischargeStudyReply
        parseFrom(com.google.protobuf.ByteString data)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss
            .common
            .generated
            .loadableStudy
            .LoadableStudyModels
            .UpdateDischargeStudyReply
        parseFrom(
            com.google.protobuf.ByteString data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss
            .common
            .generated
            .loadableStudy
            .LoadableStudyModels
            .UpdateDischargeStudyReply
        parseFrom(byte[] data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss
            .common
            .generated
            .loadableStudy
            .LoadableStudyModels
            .UpdateDischargeStudyReply
        parseFrom(byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss
            .common
            .generated
            .loadableStudy
            .LoadableStudyModels
            .UpdateDischargeStudyReply
        parseFrom(java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss
            .common
            .generated
            .loadableStudy
            .LoadableStudyModels
            .UpdateDischargeStudyReply
        parseFrom(
            java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss
            .common
            .generated
            .loadableStudy
            .LoadableStudyModels
            .UpdateDischargeStudyReply
        parseDelimitedFrom(java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss
            .common
            .generated
            .loadableStudy
            .LoadableStudyModels
            .UpdateDischargeStudyReply
        parseDelimitedFrom(
            java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss
            .common
            .generated
            .loadableStudy
            .LoadableStudyModels
            .UpdateDischargeStudyReply
        parseFrom(com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss
            .common
            .generated
            .loadableStudy
            .LoadableStudyModels
            .UpdateDischargeStudyReply
        parseFrom(
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
        com.cpdss.common.generated.loadableStudy.LoadableStudyModels.UpdateDischargeStudyReply
            prototype) {
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
    /** Protobuf type {@code UpdateDischargeStudyReply} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:UpdateDischargeStudyReply)
        com.cpdss
            .common
            .generated
            .loadableStudy
            .LoadableStudyModels
            .UpdateDischargeStudyReplyOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss
            .common
            .generated
            .loadableStudy
            .LoadableStudyModels
            .internal_static_UpdateDischargeStudyReply_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.loadableStudy.LoadableStudyModels
            .internal_static_UpdateDischargeStudyReply_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss
                    .common
                    .generated
                    .loadableStudy
                    .LoadableStudyModels
                    .UpdateDischargeStudyReply
                    .class,
                com.cpdss
                    .common
                    .generated
                    .loadableStudy
                    .LoadableStudyModels
                    .UpdateDischargeStudyReply
                    .Builder
                    .class);
      }

      // Construct using
      // com.cpdss.common.generated.loadableStudy.LoadableStudyModels.UpdateDischargeStudyReply.newBuilder()
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
        if (dischargeStudyBuilder_ == null) {
          dischargeStudy_ = null;
        } else {
          dischargeStudy_ = null;
          dischargeStudyBuilder_ = null;
        }
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss
            .common
            .generated
            .loadableStudy
            .LoadableStudyModels
            .internal_static_UpdateDischargeStudyReply_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.loadableStudy.LoadableStudyModels.UpdateDischargeStudyReply
          getDefaultInstanceForType() {
        return com.cpdss.common.generated.loadableStudy.LoadableStudyModels
            .UpdateDischargeStudyReply.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.loadableStudy.LoadableStudyModels.UpdateDischargeStudyReply
          build() {
        com.cpdss.common.generated.loadableStudy.LoadableStudyModels.UpdateDischargeStudyReply
            result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.loadableStudy.LoadableStudyModels.UpdateDischargeStudyReply
          buildPartial() {
        com.cpdss.common.generated.loadableStudy.LoadableStudyModels.UpdateDischargeStudyReply
            result =
                new com.cpdss
                    .common
                    .generated
                    .loadableStudy
                    .LoadableStudyModels
                    .UpdateDischargeStudyReply(this);
        if (responseStatusBuilder_ == null) {
          result.responseStatus_ = responseStatus_;
        } else {
          result.responseStatus_ = responseStatusBuilder_.build();
        }
        if (dischargeStudyBuilder_ == null) {
          result.dischargeStudy_ = dischargeStudy_;
        } else {
          result.dischargeStudy_ = dischargeStudyBuilder_.build();
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
        if (other
            instanceof
            com.cpdss
                .common
                .generated
                .loadableStudy
                .LoadableStudyModels
                .UpdateDischargeStudyReply) {
          return mergeFrom(
              (com.cpdss
                      .common
                      .generated
                      .loadableStudy
                      .LoadableStudyModels
                      .UpdateDischargeStudyReply)
                  other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(
          com.cpdss.common.generated.loadableStudy.LoadableStudyModels.UpdateDischargeStudyReply
              other) {
        if (other
            == com.cpdss.common.generated.loadableStudy.LoadableStudyModels
                .UpdateDischargeStudyReply.getDefaultInstance()) return this;
        if (other.hasResponseStatus()) {
          mergeResponseStatus(other.getResponseStatus());
        }
        if (other.hasDischargeStudy()) {
          mergeDischargeStudy(other.getDischargeStudy());
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
        com.cpdss.common.generated.loadableStudy.LoadableStudyModels.UpdateDischargeStudyReply
            parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss
                      .common
                      .generated
                      .loadableStudy
                      .LoadableStudyModels
                      .UpdateDischargeStudyReply)
                  e.getUnfinishedMessage();
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

      private com.cpdss
              .common
              .generated
              .loadableStudy
              .LoadableStudyModels
              .UpdateDischargeStudyDetail
          dischargeStudy_;
      private com.google.protobuf.SingleFieldBuilderV3<
              com.cpdss
                  .common
                  .generated
                  .loadableStudy
                  .LoadableStudyModels
                  .UpdateDischargeStudyDetail,
              com.cpdss
                  .common
                  .generated
                  .loadableStudy
                  .LoadableStudyModels
                  .UpdateDischargeStudyDetail
                  .Builder,
              com.cpdss
                  .common
                  .generated
                  .loadableStudy
                  .LoadableStudyModels
                  .UpdateDischargeStudyDetailOrBuilder>
          dischargeStudyBuilder_;
      /**
       * <code>.UpdateDischargeStudyDetail dischargeStudy = 2;</code>
       *
       * @return Whether the dischargeStudy field is set.
       */
      public boolean hasDischargeStudy() {
        return dischargeStudyBuilder_ != null || dischargeStudy_ != null;
      }
      /**
       * <code>.UpdateDischargeStudyDetail dischargeStudy = 2;</code>
       *
       * @return The dischargeStudy.
       */
      public com.cpdss.common.generated.loadableStudy.LoadableStudyModels.UpdateDischargeStudyDetail
          getDischargeStudy() {
        if (dischargeStudyBuilder_ == null) {
          return dischargeStudy_ == null
              ? com.cpdss.common.generated.loadableStudy.LoadableStudyModels
                  .UpdateDischargeStudyDetail.getDefaultInstance()
              : dischargeStudy_;
        } else {
          return dischargeStudyBuilder_.getMessage();
        }
      }
      /** <code>.UpdateDischargeStudyDetail dischargeStudy = 2;</code> */
      public Builder setDischargeStudy(
          com.cpdss.common.generated.loadableStudy.LoadableStudyModels.UpdateDischargeStudyDetail
              value) {
        if (dischargeStudyBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          dischargeStudy_ = value;
          onChanged();
        } else {
          dischargeStudyBuilder_.setMessage(value);
        }

        return this;
      }
      /** <code>.UpdateDischargeStudyDetail dischargeStudy = 2;</code> */
      public Builder setDischargeStudy(
          com.cpdss
                  .common
                  .generated
                  .loadableStudy
                  .LoadableStudyModels
                  .UpdateDischargeStudyDetail
                  .Builder
              builderForValue) {
        if (dischargeStudyBuilder_ == null) {
          dischargeStudy_ = builderForValue.build();
          onChanged();
        } else {
          dischargeStudyBuilder_.setMessage(builderForValue.build());
        }

        return this;
      }
      /** <code>.UpdateDischargeStudyDetail dischargeStudy = 2;</code> */
      public Builder mergeDischargeStudy(
          com.cpdss.common.generated.loadableStudy.LoadableStudyModels.UpdateDischargeStudyDetail
              value) {
        if (dischargeStudyBuilder_ == null) {
          if (dischargeStudy_ != null) {
            dischargeStudy_ =
                com.cpdss
                    .common
                    .generated
                    .loadableStudy
                    .LoadableStudyModels
                    .UpdateDischargeStudyDetail
                    .newBuilder(dischargeStudy_)
                    .mergeFrom(value)
                    .buildPartial();
          } else {
            dischargeStudy_ = value;
          }
          onChanged();
        } else {
          dischargeStudyBuilder_.mergeFrom(value);
        }

        return this;
      }
      /** <code>.UpdateDischargeStudyDetail dischargeStudy = 2;</code> */
      public Builder clearDischargeStudy() {
        if (dischargeStudyBuilder_ == null) {
          dischargeStudy_ = null;
          onChanged();
        } else {
          dischargeStudy_ = null;
          dischargeStudyBuilder_ = null;
        }

        return this;
      }
      /** <code>.UpdateDischargeStudyDetail dischargeStudy = 2;</code> */
      public com.cpdss
              .common
              .generated
              .loadableStudy
              .LoadableStudyModels
              .UpdateDischargeStudyDetail
              .Builder
          getDischargeStudyBuilder() {

        onChanged();
        return getDischargeStudyFieldBuilder().getBuilder();
      }
      /** <code>.UpdateDischargeStudyDetail dischargeStudy = 2;</code> */
      public com.cpdss
              .common
              .generated
              .loadableStudy
              .LoadableStudyModels
              .UpdateDischargeStudyDetailOrBuilder
          getDischargeStudyOrBuilder() {
        if (dischargeStudyBuilder_ != null) {
          return dischargeStudyBuilder_.getMessageOrBuilder();
        } else {
          return dischargeStudy_ == null
              ? com.cpdss.common.generated.loadableStudy.LoadableStudyModels
                  .UpdateDischargeStudyDetail.getDefaultInstance()
              : dischargeStudy_;
        }
      }
      /** <code>.UpdateDischargeStudyDetail dischargeStudy = 2;</code> */
      private com.google.protobuf.SingleFieldBuilderV3<
              com.cpdss
                  .common
                  .generated
                  .loadableStudy
                  .LoadableStudyModels
                  .UpdateDischargeStudyDetail,
              com.cpdss
                  .common
                  .generated
                  .loadableStudy
                  .LoadableStudyModels
                  .UpdateDischargeStudyDetail
                  .Builder,
              com.cpdss
                  .common
                  .generated
                  .loadableStudy
                  .LoadableStudyModels
                  .UpdateDischargeStudyDetailOrBuilder>
          getDischargeStudyFieldBuilder() {
        if (dischargeStudyBuilder_ == null) {
          dischargeStudyBuilder_ =
              new com.google.protobuf.SingleFieldBuilderV3<
                  com.cpdss
                      .common
                      .generated
                      .loadableStudy
                      .LoadableStudyModels
                      .UpdateDischargeStudyDetail,
                  com.cpdss
                      .common
                      .generated
                      .loadableStudy
                      .LoadableStudyModels
                      .UpdateDischargeStudyDetail
                      .Builder,
                  com.cpdss
                      .common
                      .generated
                      .loadableStudy
                      .LoadableStudyModels
                      .UpdateDischargeStudyDetailOrBuilder>(
                  getDischargeStudy(), getParentForChildren(), isClean());
          dischargeStudy_ = null;
        }
        return dischargeStudyBuilder_;
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

      // @@protoc_insertion_point(builder_scope:UpdateDischargeStudyReply)
    }

    // @@protoc_insertion_point(class_scope:UpdateDischargeStudyReply)
    private static final com.cpdss
            .common
            .generated
            .loadableStudy
            .LoadableStudyModels
            .UpdateDischargeStudyReply
        DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE =
          new com.cpdss
              .common
              .generated
              .loadableStudy
              .LoadableStudyModels
              .UpdateDischargeStudyReply();
    }

    public static com.cpdss
            .common
            .generated
            .loadableStudy
            .LoadableStudyModels
            .UpdateDischargeStudyReply
        getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<UpdateDischargeStudyReply> PARSER =
        new com.google.protobuf.AbstractParser<UpdateDischargeStudyReply>() {
          @java.lang.Override
          public UpdateDischargeStudyReply parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new UpdateDischargeStudyReply(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<UpdateDischargeStudyReply> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<UpdateDischargeStudyReply> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.loadableStudy.LoadableStudyModels.UpdateDischargeStudyReply
        getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface UpdateDischargeStudyDetailOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:UpdateDischargeStudyDetail)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>string name = 1;</code>
     *
     * @return The name.
     */
    java.lang.String getName();
    /**
     * <code>string name = 1;</code>
     *
     * @return The bytes for name.
     */
    com.google.protobuf.ByteString getNameBytes();

    /**
     * <code>string enquiryDetails = 2;</code>
     *
     * @return The enquiryDetails.
     */
    java.lang.String getEnquiryDetails();
    /**
     * <code>string enquiryDetails = 2;</code>
     *
     * @return The bytes for enquiryDetails.
     */
    com.google.protobuf.ByteString getEnquiryDetailsBytes();

    /**
     * <code>int64 id = 3;</code>
     *
     * @return The id.
     */
    long getId();
  }
  /** Protobuf type {@code UpdateDischargeStudyDetail} */
  public static final class UpdateDischargeStudyDetail
      extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:UpdateDischargeStudyDetail)
      UpdateDischargeStudyDetailOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use UpdateDischargeStudyDetail.newBuilder() to construct.
    private UpdateDischargeStudyDetail(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private UpdateDischargeStudyDetail() {
      name_ = "";
      enquiryDetails_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new UpdateDischargeStudyDetail();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private UpdateDischargeStudyDetail(
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

                name_ = s;
                break;
              }
            case 18:
              {
                java.lang.String s = input.readStringRequireUtf8();

                enquiryDetails_ = s;
                break;
              }
            case 24:
              {
                id_ = input.readInt64();
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
      return com.cpdss
          .common
          .generated
          .loadableStudy
          .LoadableStudyModels
          .internal_static_UpdateDischargeStudyDetail_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.loadableStudy.LoadableStudyModels
          .internal_static_UpdateDischargeStudyDetail_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss
                  .common
                  .generated
                  .loadableStudy
                  .LoadableStudyModels
                  .UpdateDischargeStudyDetail
                  .class,
              com.cpdss
                  .common
                  .generated
                  .loadableStudy
                  .LoadableStudyModels
                  .UpdateDischargeStudyDetail
                  .Builder
                  .class);
    }

    public static final int NAME_FIELD_NUMBER = 1;
    private volatile java.lang.Object name_;
    /**
     * <code>string name = 1;</code>
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
     * <code>string name = 1;</code>
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

    public static final int ENQUIRYDETAILS_FIELD_NUMBER = 2;
    private volatile java.lang.Object enquiryDetails_;
    /**
     * <code>string enquiryDetails = 2;</code>
     *
     * @return The enquiryDetails.
     */
    public java.lang.String getEnquiryDetails() {
      java.lang.Object ref = enquiryDetails_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        enquiryDetails_ = s;
        return s;
      }
    }
    /**
     * <code>string enquiryDetails = 2;</code>
     *
     * @return The bytes for enquiryDetails.
     */
    public com.google.protobuf.ByteString getEnquiryDetailsBytes() {
      java.lang.Object ref = enquiryDetails_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        enquiryDetails_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int ID_FIELD_NUMBER = 3;
    private long id_;
    /**
     * <code>int64 id = 3;</code>
     *
     * @return The id.
     */
    public long getId() {
      return id_;
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
      if (!getNameBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, name_);
      }
      if (!getEnquiryDetailsBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, enquiryDetails_);
      }
      if (id_ != 0L) {
        output.writeInt64(3, id_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getNameBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, name_);
      }
      if (!getEnquiryDetailsBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, enquiryDetails_);
      }
      if (id_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(3, id_);
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
      if (!(obj
          instanceof
          com.cpdss
              .common
              .generated
              .loadableStudy
              .LoadableStudyModels
              .UpdateDischargeStudyDetail)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.loadableStudy.LoadableStudyModels.UpdateDischargeStudyDetail
          other =
              (com.cpdss
                      .common
                      .generated
                      .loadableStudy
                      .LoadableStudyModels
                      .UpdateDischargeStudyDetail)
                  obj;

      if (!getName().equals(other.getName())) return false;
      if (!getEnquiryDetails().equals(other.getEnquiryDetails())) return false;
      if (getId() != other.getId()) return false;
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
      hash = (37 * hash) + NAME_FIELD_NUMBER;
      hash = (53 * hash) + getName().hashCode();
      hash = (37 * hash) + ENQUIRYDETAILS_FIELD_NUMBER;
      hash = (53 * hash) + getEnquiryDetails().hashCode();
      hash = (37 * hash) + ID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getId());
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss
            .common
            .generated
            .loadableStudy
            .LoadableStudyModels
            .UpdateDischargeStudyDetail
        parseFrom(java.nio.ByteBuffer data)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss
            .common
            .generated
            .loadableStudy
            .LoadableStudyModels
            .UpdateDischargeStudyDetail
        parseFrom(
            java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss
            .common
            .generated
            .loadableStudy
            .LoadableStudyModels
            .UpdateDischargeStudyDetail
        parseFrom(com.google.protobuf.ByteString data)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss
            .common
            .generated
            .loadableStudy
            .LoadableStudyModels
            .UpdateDischargeStudyDetail
        parseFrom(
            com.google.protobuf.ByteString data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss
            .common
            .generated
            .loadableStudy
            .LoadableStudyModels
            .UpdateDischargeStudyDetail
        parseFrom(byte[] data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss
            .common
            .generated
            .loadableStudy
            .LoadableStudyModels
            .UpdateDischargeStudyDetail
        parseFrom(byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss
            .common
            .generated
            .loadableStudy
            .LoadableStudyModels
            .UpdateDischargeStudyDetail
        parseFrom(java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss
            .common
            .generated
            .loadableStudy
            .LoadableStudyModels
            .UpdateDischargeStudyDetail
        parseFrom(
            java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss
            .common
            .generated
            .loadableStudy
            .LoadableStudyModels
            .UpdateDischargeStudyDetail
        parseDelimitedFrom(java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss
            .common
            .generated
            .loadableStudy
            .LoadableStudyModels
            .UpdateDischargeStudyDetail
        parseDelimitedFrom(
            java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss
            .common
            .generated
            .loadableStudy
            .LoadableStudyModels
            .UpdateDischargeStudyDetail
        parseFrom(com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss
            .common
            .generated
            .loadableStudy
            .LoadableStudyModels
            .UpdateDischargeStudyDetail
        parseFrom(
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
        com.cpdss.common.generated.loadableStudy.LoadableStudyModels.UpdateDischargeStudyDetail
            prototype) {
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
    /** Protobuf type {@code UpdateDischargeStudyDetail} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:UpdateDischargeStudyDetail)
        com.cpdss
            .common
            .generated
            .loadableStudy
            .LoadableStudyModels
            .UpdateDischargeStudyDetailOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss
            .common
            .generated
            .loadableStudy
            .LoadableStudyModels
            .internal_static_UpdateDischargeStudyDetail_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.loadableStudy.LoadableStudyModels
            .internal_static_UpdateDischargeStudyDetail_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss
                    .common
                    .generated
                    .loadableStudy
                    .LoadableStudyModels
                    .UpdateDischargeStudyDetail
                    .class,
                com.cpdss
                    .common
                    .generated
                    .loadableStudy
                    .LoadableStudyModels
                    .UpdateDischargeStudyDetail
                    .Builder
                    .class);
      }

      // Construct using
      // com.cpdss.common.generated.loadableStudy.LoadableStudyModels.UpdateDischargeStudyDetail.newBuilder()
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
        name_ = "";

        enquiryDetails_ = "";

        id_ = 0L;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss
            .common
            .generated
            .loadableStudy
            .LoadableStudyModels
            .internal_static_UpdateDischargeStudyDetail_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.loadableStudy.LoadableStudyModels.UpdateDischargeStudyDetail
          getDefaultInstanceForType() {
        return com.cpdss.common.generated.loadableStudy.LoadableStudyModels
            .UpdateDischargeStudyDetail.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.loadableStudy.LoadableStudyModels.UpdateDischargeStudyDetail
          build() {
        com.cpdss.common.generated.loadableStudy.LoadableStudyModels.UpdateDischargeStudyDetail
            result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.loadableStudy.LoadableStudyModels.UpdateDischargeStudyDetail
          buildPartial() {
        com.cpdss.common.generated.loadableStudy.LoadableStudyModels.UpdateDischargeStudyDetail
            result =
                new com.cpdss
                    .common
                    .generated
                    .loadableStudy
                    .LoadableStudyModels
                    .UpdateDischargeStudyDetail(this);
        result.name_ = name_;
        result.enquiryDetails_ = enquiryDetails_;
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
        if (other
            instanceof
            com.cpdss
                .common
                .generated
                .loadableStudy
                .LoadableStudyModels
                .UpdateDischargeStudyDetail) {
          return mergeFrom(
              (com.cpdss
                      .common
                      .generated
                      .loadableStudy
                      .LoadableStudyModels
                      .UpdateDischargeStudyDetail)
                  other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(
          com.cpdss.common.generated.loadableStudy.LoadableStudyModels.UpdateDischargeStudyDetail
              other) {
        if (other
            == com.cpdss.common.generated.loadableStudy.LoadableStudyModels
                .UpdateDischargeStudyDetail.getDefaultInstance()) return this;
        if (!other.getName().isEmpty()) {
          name_ = other.name_;
          onChanged();
        }
        if (!other.getEnquiryDetails().isEmpty()) {
          enquiryDetails_ = other.enquiryDetails_;
          onChanged();
        }
        if (other.getId() != 0L) {
          setId(other.getId());
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
        com.cpdss.common.generated.loadableStudy.LoadableStudyModels.UpdateDischargeStudyDetail
            parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss
                      .common
                      .generated
                      .loadableStudy
                      .LoadableStudyModels
                      .UpdateDischargeStudyDetail)
                  e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private java.lang.Object name_ = "";
      /**
       * <code>string name = 1;</code>
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
       * <code>string name = 1;</code>
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
       * <code>string name = 1;</code>
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
       * <code>string name = 1;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearName() {

        name_ = getDefaultInstance().getName();
        onChanged();
        return this;
      }
      /**
       * <code>string name = 1;</code>
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

      private java.lang.Object enquiryDetails_ = "";
      /**
       * <code>string enquiryDetails = 2;</code>
       *
       * @return The enquiryDetails.
       */
      public java.lang.String getEnquiryDetails() {
        java.lang.Object ref = enquiryDetails_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          enquiryDetails_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string enquiryDetails = 2;</code>
       *
       * @return The bytes for enquiryDetails.
       */
      public com.google.protobuf.ByteString getEnquiryDetailsBytes() {
        java.lang.Object ref = enquiryDetails_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          enquiryDetails_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string enquiryDetails = 2;</code>
       *
       * @param value The enquiryDetails to set.
       * @return This builder for chaining.
       */
      public Builder setEnquiryDetails(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        enquiryDetails_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string enquiryDetails = 2;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearEnquiryDetails() {

        enquiryDetails_ = getDefaultInstance().getEnquiryDetails();
        onChanged();
        return this;
      }
      /**
       * <code>string enquiryDetails = 2;</code>
       *
       * @param value The bytes for enquiryDetails to set.
       * @return This builder for chaining.
       */
      public Builder setEnquiryDetailsBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        enquiryDetails_ = value;
        onChanged();
        return this;
      }

      private long id_;
      /**
       * <code>int64 id = 3;</code>
       *
       * @return The id.
       */
      public long getId() {
        return id_;
      }
      /**
       * <code>int64 id = 3;</code>
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
       * <code>int64 id = 3;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearId() {

        id_ = 0L;
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

      // @@protoc_insertion_point(builder_scope:UpdateDischargeStudyDetail)
    }

    // @@protoc_insertion_point(class_scope:UpdateDischargeStudyDetail)
    private static final com.cpdss
            .common
            .generated
            .loadableStudy
            .LoadableStudyModels
            .UpdateDischargeStudyDetail
        DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE =
          new com.cpdss
              .common
              .generated
              .loadableStudy
              .LoadableStudyModels
              .UpdateDischargeStudyDetail();
    }

    public static com.cpdss
            .common
            .generated
            .loadableStudy
            .LoadableStudyModels
            .UpdateDischargeStudyDetail
        getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<UpdateDischargeStudyDetail> PARSER =
        new com.google.protobuf.AbstractParser<UpdateDischargeStudyDetail>() {
          @java.lang.Override
          public UpdateDischargeStudyDetail parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new UpdateDischargeStudyDetail(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<UpdateDischargeStudyDetail> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<UpdateDischargeStudyDetail> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.loadableStudy.LoadableStudyModels.UpdateDischargeStudyDetail
        getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface DischargeStudyReplyOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:DischargeStudyReply)
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

    /**
     * <code>.DischargeStudyDetail dischargeStudy = 2;</code>
     *
     * @return Whether the dischargeStudy field is set.
     */
    boolean hasDischargeStudy();
    /**
     * <code>.DischargeStudyDetail dischargeStudy = 2;</code>
     *
     * @return The dischargeStudy.
     */
    com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyDetail
        getDischargeStudy();
    /** <code>.DischargeStudyDetail dischargeStudy = 2;</code> */
    com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyDetailOrBuilder
        getDischargeStudyOrBuilder();

    /**
     * <code>int64 id = 3;</code>
     *
     * @return The id.
     */
    long getId();
  }
  /** Protobuf type {@code DischargeStudyReply} */
  public static final class DischargeStudyReply extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:DischargeStudyReply)
      DischargeStudyReplyOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use DischargeStudyReply.newBuilder() to construct.
    private DischargeStudyReply(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private DischargeStudyReply() {}

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new DischargeStudyReply();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private DischargeStudyReply(
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
            case 18:
              {
                com.cpdss
                        .common
                        .generated
                        .loadableStudy
                        .LoadableStudyModels
                        .DischargeStudyDetail
                        .Builder
                    subBuilder = null;
                if (dischargeStudy_ != null) {
                  subBuilder = dischargeStudy_.toBuilder();
                }
                dischargeStudy_ =
                    input.readMessage(
                        com.cpdss.common.generated.loadableStudy.LoadableStudyModels
                            .DischargeStudyDetail.parser(),
                        extensionRegistry);
                if (subBuilder != null) {
                  subBuilder.mergeFrom(dischargeStudy_);
                  dischargeStudy_ = subBuilder.buildPartial();
                }

                break;
              }
            case 24:
              {
                id_ = input.readInt64();
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
      return com.cpdss
          .common
          .generated
          .loadableStudy
          .LoadableStudyModels
          .internal_static_DischargeStudyReply_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.loadableStudy.LoadableStudyModels
          .internal_static_DischargeStudyReply_fieldAccessorTable.ensureFieldAccessorsInitialized(
          com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyReply.class,
          com.cpdss
              .common
              .generated
              .loadableStudy
              .LoadableStudyModels
              .DischargeStudyReply
              .Builder
              .class);
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

    public static final int DISCHARGESTUDY_FIELD_NUMBER = 2;
    private com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyDetail
        dischargeStudy_;
    /**
     * <code>.DischargeStudyDetail dischargeStudy = 2;</code>
     *
     * @return Whether the dischargeStudy field is set.
     */
    public boolean hasDischargeStudy() {
      return dischargeStudy_ != null;
    }
    /**
     * <code>.DischargeStudyDetail dischargeStudy = 2;</code>
     *
     * @return The dischargeStudy.
     */
    public com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyDetail
        getDischargeStudy() {
      return dischargeStudy_ == null
          ? com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyDetail
              .getDefaultInstance()
          : dischargeStudy_;
    }
    /** <code>.DischargeStudyDetail dischargeStudy = 2;</code> */
    public com.cpdss
            .common
            .generated
            .loadableStudy
            .LoadableStudyModels
            .DischargeStudyDetailOrBuilder
        getDischargeStudyOrBuilder() {
      return getDischargeStudy();
    }

    public static final int ID_FIELD_NUMBER = 3;
    private long id_;
    /**
     * <code>int64 id = 3;</code>
     *
     * @return The id.
     */
    public long getId() {
      return id_;
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
      if (dischargeStudy_ != null) {
        output.writeMessage(2, getDischargeStudy());
      }
      if (id_ != 0L) {
        output.writeInt64(3, id_);
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
      if (dischargeStudy_ != null) {
        size += com.google.protobuf.CodedOutputStream.computeMessageSize(2, getDischargeStudy());
      }
      if (id_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(3, id_);
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
      if (!(obj
          instanceof
          com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyReply)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyReply other =
          (com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyReply) obj;

      if (hasResponseStatus() != other.hasResponseStatus()) return false;
      if (hasResponseStatus()) {
        if (!getResponseStatus().equals(other.getResponseStatus())) return false;
      }
      if (hasDischargeStudy() != other.hasDischargeStudy()) return false;
      if (hasDischargeStudy()) {
        if (!getDischargeStudy().equals(other.getDischargeStudy())) return false;
      }
      if (getId() != other.getId()) return false;
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
      if (hasDischargeStudy()) {
        hash = (37 * hash) + DISCHARGESTUDY_FIELD_NUMBER;
        hash = (53 * hash) + getDischargeStudy().hashCode();
      }
      hash = (37 * hash) + ID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getId());
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyReply
        parseFrom(java.nio.ByteBuffer data)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyReply
        parseFrom(
            java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyReply
        parseFrom(com.google.protobuf.ByteString data)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyReply
        parseFrom(
            com.google.protobuf.ByteString data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyReply
        parseFrom(byte[] data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyReply
        parseFrom(byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyReply
        parseFrom(java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyReply
        parseFrom(
            java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyReply
        parseDelimitedFrom(java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyReply
        parseDelimitedFrom(
            java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyReply
        parseFrom(com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyReply
        parseFrom(
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
        com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyReply
            prototype) {
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
    /** Protobuf type {@code DischargeStudyReply} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:DischargeStudyReply)
        com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyReplyOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss
            .common
            .generated
            .loadableStudy
            .LoadableStudyModels
            .internal_static_DischargeStudyReply_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.loadableStudy.LoadableStudyModels
            .internal_static_DischargeStudyReply_fieldAccessorTable.ensureFieldAccessorsInitialized(
            com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyReply.class,
            com.cpdss
                .common
                .generated
                .loadableStudy
                .LoadableStudyModels
                .DischargeStudyReply
                .Builder
                .class);
      }

      // Construct using
      // com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyReply.newBuilder()
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
        if (dischargeStudyBuilder_ == null) {
          dischargeStudy_ = null;
        } else {
          dischargeStudy_ = null;
          dischargeStudyBuilder_ = null;
        }
        id_ = 0L;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss
            .common
            .generated
            .loadableStudy
            .LoadableStudyModels
            .internal_static_DischargeStudyReply_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyReply
          getDefaultInstanceForType() {
        return com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyReply
            .getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyReply
          build() {
        com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyReply result =
            buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyReply
          buildPartial() {
        com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyReply result =
            new com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyReply(
                this);
        if (responseStatusBuilder_ == null) {
          result.responseStatus_ = responseStatus_;
        } else {
          result.responseStatus_ = responseStatusBuilder_.build();
        }
        if (dischargeStudyBuilder_ == null) {
          result.dischargeStudy_ = dischargeStudy_;
        } else {
          result.dischargeStudy_ = dischargeStudyBuilder_.build();
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
        if (other
            instanceof
            com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyReply) {
          return mergeFrom(
              (com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyReply)
                  other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(
          com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyReply other) {
        if (other
            == com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyReply
                .getDefaultInstance()) return this;
        if (other.hasResponseStatus()) {
          mergeResponseStatus(other.getResponseStatus());
        }
        if (other.hasDischargeStudy()) {
          mergeDischargeStudy(other.getDischargeStudy());
        }
        if (other.getId() != 0L) {
          setId(other.getId());
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
        com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyReply
            parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyReply)
                  e.getUnfinishedMessage();
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

      private com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyDetail
          dischargeStudy_;
      private com.google.protobuf.SingleFieldBuilderV3<
              com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyDetail,
              com.cpdss
                  .common
                  .generated
                  .loadableStudy
                  .LoadableStudyModels
                  .DischargeStudyDetail
                  .Builder,
              com.cpdss
                  .common
                  .generated
                  .loadableStudy
                  .LoadableStudyModels
                  .DischargeStudyDetailOrBuilder>
          dischargeStudyBuilder_;
      /**
       * <code>.DischargeStudyDetail dischargeStudy = 2;</code>
       *
       * @return Whether the dischargeStudy field is set.
       */
      public boolean hasDischargeStudy() {
        return dischargeStudyBuilder_ != null || dischargeStudy_ != null;
      }
      /**
       * <code>.DischargeStudyDetail dischargeStudy = 2;</code>
       *
       * @return The dischargeStudy.
       */
      public com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyDetail
          getDischargeStudy() {
        if (dischargeStudyBuilder_ == null) {
          return dischargeStudy_ == null
              ? com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyDetail
                  .getDefaultInstance()
              : dischargeStudy_;
        } else {
          return dischargeStudyBuilder_.getMessage();
        }
      }
      /** <code>.DischargeStudyDetail dischargeStudy = 2;</code> */
      public Builder setDischargeStudy(
          com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyDetail value) {
        if (dischargeStudyBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          dischargeStudy_ = value;
          onChanged();
        } else {
          dischargeStudyBuilder_.setMessage(value);
        }

        return this;
      }
      /** <code>.DischargeStudyDetail dischargeStudy = 2;</code> */
      public Builder setDischargeStudy(
          com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyDetail.Builder
              builderForValue) {
        if (dischargeStudyBuilder_ == null) {
          dischargeStudy_ = builderForValue.build();
          onChanged();
        } else {
          dischargeStudyBuilder_.setMessage(builderForValue.build());
        }

        return this;
      }
      /** <code>.DischargeStudyDetail dischargeStudy = 2;</code> */
      public Builder mergeDischargeStudy(
          com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyDetail value) {
        if (dischargeStudyBuilder_ == null) {
          if (dischargeStudy_ != null) {
            dischargeStudy_ =
                com.cpdss
                    .common
                    .generated
                    .loadableStudy
                    .LoadableStudyModels
                    .DischargeStudyDetail
                    .newBuilder(dischargeStudy_)
                    .mergeFrom(value)
                    .buildPartial();
          } else {
            dischargeStudy_ = value;
          }
          onChanged();
        } else {
          dischargeStudyBuilder_.mergeFrom(value);
        }

        return this;
      }
      /** <code>.DischargeStudyDetail dischargeStudy = 2;</code> */
      public Builder clearDischargeStudy() {
        if (dischargeStudyBuilder_ == null) {
          dischargeStudy_ = null;
          onChanged();
        } else {
          dischargeStudy_ = null;
          dischargeStudyBuilder_ = null;
        }

        return this;
      }
      /** <code>.DischargeStudyDetail dischargeStudy = 2;</code> */
      public com.cpdss
              .common
              .generated
              .loadableStudy
              .LoadableStudyModels
              .DischargeStudyDetail
              .Builder
          getDischargeStudyBuilder() {

        onChanged();
        return getDischargeStudyFieldBuilder().getBuilder();
      }
      /** <code>.DischargeStudyDetail dischargeStudy = 2;</code> */
      public com.cpdss
              .common
              .generated
              .loadableStudy
              .LoadableStudyModels
              .DischargeStudyDetailOrBuilder
          getDischargeStudyOrBuilder() {
        if (dischargeStudyBuilder_ != null) {
          return dischargeStudyBuilder_.getMessageOrBuilder();
        } else {
          return dischargeStudy_ == null
              ? com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyDetail
                  .getDefaultInstance()
              : dischargeStudy_;
        }
      }
      /** <code>.DischargeStudyDetail dischargeStudy = 2;</code> */
      private com.google.protobuf.SingleFieldBuilderV3<
              com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyDetail,
              com.cpdss
                  .common
                  .generated
                  .loadableStudy
                  .LoadableStudyModels
                  .DischargeStudyDetail
                  .Builder,
              com.cpdss
                  .common
                  .generated
                  .loadableStudy
                  .LoadableStudyModels
                  .DischargeStudyDetailOrBuilder>
          getDischargeStudyFieldBuilder() {
        if (dischargeStudyBuilder_ == null) {
          dischargeStudyBuilder_ =
              new com.google.protobuf.SingleFieldBuilderV3<
                  com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyDetail,
                  com.cpdss
                      .common
                      .generated
                      .loadableStudy
                      .LoadableStudyModels
                      .DischargeStudyDetail
                      .Builder,
                  com.cpdss
                      .common
                      .generated
                      .loadableStudy
                      .LoadableStudyModels
                      .DischargeStudyDetailOrBuilder>(
                  getDischargeStudy(), getParentForChildren(), isClean());
          dischargeStudy_ = null;
        }
        return dischargeStudyBuilder_;
      }

      private long id_;
      /**
       * <code>int64 id = 3;</code>
       *
       * @return The id.
       */
      public long getId() {
        return id_;
      }
      /**
       * <code>int64 id = 3;</code>
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
       * <code>int64 id = 3;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearId() {

        id_ = 0L;
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

      // @@protoc_insertion_point(builder_scope:DischargeStudyReply)
    }

    // @@protoc_insertion_point(class_scope:DischargeStudyReply)
    private static final com.cpdss
            .common
            .generated
            .loadableStudy
            .LoadableStudyModels
            .DischargeStudyReply
        DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE =
          new com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyReply();
    }

    public static com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyReply
        getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<DischargeStudyReply> PARSER =
        new com.google.protobuf.AbstractParser<DischargeStudyReply>() {
          @java.lang.Override
          public DischargeStudyReply parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new DischargeStudyReply(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<DischargeStudyReply> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<DischargeStudyReply> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.loadableStudy.LoadableStudyModels.DischargeStudyReply
        getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_DischargeStudyRequest_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_DischargeStudyRequest_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_DischargeStudyDetail_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_DischargeStudyDetail_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_UpdateDischargeStudyReply_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_UpdateDischargeStudyReply_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_UpdateDischargeStudyDetail_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_UpdateDischargeStudyDetail_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_DischargeStudyReply_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_DischargeStudyReply_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }

  private static com.google.protobuf.Descriptors.FileDescriptor descriptor;

  static {
    java.lang.String[] descriptorData = {
      "\n*loadable_study/loadable_study_models.p"
          + "roto\032\014common.proto\"1\n\025DischargeStudyRequ"
          + "est\022\030\n\020dischargeStudyId\030\001 \001(\003\"z\n\024Dischar"
          + "geStudyDetail\022\014\n\004name\030\001 \001(\t\022\026\n\016enquiryDe"
          + "tails\030\002 \001(\t\022\020\n\010vesselId\030\003 \001(\003\022\020\n\010voyageI"
          + "d\030\004 \001(\003\022\030\n\020dischargeStudyId\030\005 \001(\003\"y\n\031Upd"
          + "ateDischargeStudyReply\022\'\n\016responseStatus"
          + "\030\001 \001(\0132\017.ResponseStatus\0223\n\016dischargeStud"
          + "y\030\002 \001(\0132\033.UpdateDischargeStudyDetail\"N\n\032"
          + "UpdateDischargeStudyDetail\022\014\n\004name\030\001 \001(\t"
          + "\022\026\n\016enquiryDetails\030\002 \001(\t\022\n\n\002id\030\003 \001(\003\"y\n\023"
          + "DischargeStudyReply\022\'\n\016responseStatus\030\001 "
          + "\001(\0132\017.ResponseStatus\022-\n\016dischargeStudy\030\002"
          + " \001(\0132\025.DischargeStudyDetail\022\n\n\002id\030\003 \001(\003B"
          + ",\n(com.cpdss.common.generated.loadableSt"
          + "udyP\000b\006proto3"
    };
    descriptor =
        com.google.protobuf.Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(
            descriptorData,
            new com.google.protobuf.Descriptors.FileDescriptor[] {
              com.cpdss.common.generated.Common.getDescriptor(),
            });
    internal_static_DischargeStudyRequest_descriptor = getDescriptor().getMessageTypes().get(0);
    internal_static_DischargeStudyRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_DischargeStudyRequest_descriptor,
            new java.lang.String[] {
              "DischargeStudyId",
            });
    internal_static_DischargeStudyDetail_descriptor = getDescriptor().getMessageTypes().get(1);
    internal_static_DischargeStudyDetail_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_DischargeStudyDetail_descriptor,
            new java.lang.String[] {
              "Name", "EnquiryDetails", "VesselId", "VoyageId", "DischargeStudyId",
            });
    internal_static_UpdateDischargeStudyReply_descriptor = getDescriptor().getMessageTypes().get(2);
    internal_static_UpdateDischargeStudyReply_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_UpdateDischargeStudyReply_descriptor,
            new java.lang.String[] {
              "ResponseStatus", "DischargeStudy",
            });
    internal_static_UpdateDischargeStudyDetail_descriptor =
        getDescriptor().getMessageTypes().get(3);
    internal_static_UpdateDischargeStudyDetail_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_UpdateDischargeStudyDetail_descriptor,
            new java.lang.String[] {
              "Name", "EnquiryDetails", "Id",
            });
    internal_static_DischargeStudyReply_descriptor = getDescriptor().getMessageTypes().get(4);
    internal_static_DischargeStudyReply_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_DischargeStudyReply_descriptor,
            new java.lang.String[] {
              "ResponseStatus", "DischargeStudy", "Id",
            });
    com.cpdss.common.generated.Common.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
