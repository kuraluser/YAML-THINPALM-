/* Licensed at AlphaOri Technologies */
package com.cpdss.common.generated;

public final class CargoInfo {
  private CargoInfo() {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistryLite registry) {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions((com.google.protobuf.ExtensionRegistryLite) registry);
  }

  public interface CargoRequestOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:CargoRequest)
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
  /** Protobuf type {@code CargoRequest} */
  public static final class CargoRequest extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:CargoRequest)
      CargoRequestOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use CargoRequest.newBuilder() to construct.
    private CargoRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private CargoRequest() {}

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new CargoRequest();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private CargoRequest(
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
      return com.cpdss.common.generated.CargoInfo.internal_static_CargoRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.CargoInfo.internal_static_CargoRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.CargoInfo.CargoRequest.class,
              com.cpdss.common.generated.CargoInfo.CargoRequest.Builder.class);
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
      if (!(obj instanceof com.cpdss.common.generated.CargoInfo.CargoRequest)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.CargoInfo.CargoRequest other =
          (com.cpdss.common.generated.CargoInfo.CargoRequest) obj;

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

    public static com.cpdss.common.generated.CargoInfo.CargoRequest parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.CargoInfo.CargoRequest parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.CargoInfo.CargoRequest parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.CargoInfo.CargoRequest parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.CargoInfo.CargoRequest parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.CargoInfo.CargoRequest parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.CargoInfo.CargoRequest parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.CargoInfo.CargoRequest parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.CargoInfo.CargoRequest parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.CargoInfo.CargoRequest parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.CargoInfo.CargoRequest parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.CargoInfo.CargoRequest parseFrom(
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

    public static Builder newBuilder(com.cpdss.common.generated.CargoInfo.CargoRequest prototype) {
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
    /** Protobuf type {@code CargoRequest} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:CargoRequest)
        com.cpdss.common.generated.CargoInfo.CargoRequestOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.CargoInfo.internal_static_CargoRequest_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.CargoInfo.internal_static_CargoRequest_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.CargoInfo.CargoRequest.class,
                com.cpdss.common.generated.CargoInfo.CargoRequest.Builder.class);
      }

      // Construct using com.cpdss.common.generated.CargoInfo.CargoRequest.newBuilder()
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
        return com.cpdss.common.generated.CargoInfo.internal_static_CargoRequest_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.CargoInfo.CargoRequest getDefaultInstanceForType() {
        return com.cpdss.common.generated.CargoInfo.CargoRequest.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.CargoInfo.CargoRequest build() {
        com.cpdss.common.generated.CargoInfo.CargoRequest result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.CargoInfo.CargoRequest buildPartial() {
        com.cpdss.common.generated.CargoInfo.CargoRequest result =
            new com.cpdss.common.generated.CargoInfo.CargoRequest(this);
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
        if (other instanceof com.cpdss.common.generated.CargoInfo.CargoRequest) {
          return mergeFrom((com.cpdss.common.generated.CargoInfo.CargoRequest) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.cpdss.common.generated.CargoInfo.CargoRequest other) {
        if (other == com.cpdss.common.generated.CargoInfo.CargoRequest.getDefaultInstance())
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
        com.cpdss.common.generated.CargoInfo.CargoRequest parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.CargoInfo.CargoRequest) e.getUnfinishedMessage();
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

      // @@protoc_insertion_point(builder_scope:CargoRequest)
    }

    // @@protoc_insertion_point(class_scope:CargoRequest)
    private static final com.cpdss.common.generated.CargoInfo.CargoRequest DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.CargoInfo.CargoRequest();
    }

    public static com.cpdss.common.generated.CargoInfo.CargoRequest getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<CargoRequest> PARSER =
        new com.google.protobuf.AbstractParser<CargoRequest>() {
          @java.lang.Override
          public CargoRequest parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new CargoRequest(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<CargoRequest> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<CargoRequest> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.CargoInfo.CargoRequest getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface CargoRequestWithPagingOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:CargoRequestWithPaging)
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
  /** Protobuf type {@code CargoRequestWithPaging} */
  public static final class CargoRequestWithPaging extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:CargoRequestWithPaging)
      CargoRequestWithPagingOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use CargoRequestWithPaging.newBuilder() to construct.
    private CargoRequestWithPaging(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private CargoRequestWithPaging() {}

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new CargoRequestWithPaging();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private CargoRequestWithPaging(
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
      return com.cpdss.common.generated.CargoInfo.internal_static_CargoRequestWithPaging_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.CargoInfo
          .internal_static_CargoRequestWithPaging_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.CargoInfo.CargoRequestWithPaging.class,
              com.cpdss.common.generated.CargoInfo.CargoRequestWithPaging.Builder.class);
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
      if (!(obj instanceof com.cpdss.common.generated.CargoInfo.CargoRequestWithPaging)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.CargoInfo.CargoRequestWithPaging other =
          (com.cpdss.common.generated.CargoInfo.CargoRequestWithPaging) obj;

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

    public static com.cpdss.common.generated.CargoInfo.CargoRequestWithPaging parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.CargoInfo.CargoRequestWithPaging parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.CargoInfo.CargoRequestWithPaging parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.CargoInfo.CargoRequestWithPaging parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.CargoInfo.CargoRequestWithPaging parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.CargoInfo.CargoRequestWithPaging parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.CargoInfo.CargoRequestWithPaging parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.CargoInfo.CargoRequestWithPaging parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.CargoInfo.CargoRequestWithPaging parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.CargoInfo.CargoRequestWithPaging parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.CargoInfo.CargoRequestWithPaging parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.CargoInfo.CargoRequestWithPaging parseFrom(
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
        com.cpdss.common.generated.CargoInfo.CargoRequestWithPaging prototype) {
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
    /** Protobuf type {@code CargoRequestWithPaging} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:CargoRequestWithPaging)
        com.cpdss.common.generated.CargoInfo.CargoRequestWithPagingOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.CargoInfo
            .internal_static_CargoRequestWithPaging_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.CargoInfo
            .internal_static_CargoRequestWithPaging_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.CargoInfo.CargoRequestWithPaging.class,
                com.cpdss.common.generated.CargoInfo.CargoRequestWithPaging.Builder.class);
      }

      // Construct using com.cpdss.common.generated.CargoInfo.CargoRequestWithPaging.newBuilder()
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
        return com.cpdss.common.generated.CargoInfo
            .internal_static_CargoRequestWithPaging_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.CargoInfo.CargoRequestWithPaging
          getDefaultInstanceForType() {
        return com.cpdss.common.generated.CargoInfo.CargoRequestWithPaging.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.CargoInfo.CargoRequestWithPaging build() {
        com.cpdss.common.generated.CargoInfo.CargoRequestWithPaging result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.CargoInfo.CargoRequestWithPaging buildPartial() {
        com.cpdss.common.generated.CargoInfo.CargoRequestWithPaging result =
            new com.cpdss.common.generated.CargoInfo.CargoRequestWithPaging(this);
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
        if (other instanceof com.cpdss.common.generated.CargoInfo.CargoRequestWithPaging) {
          return mergeFrom((com.cpdss.common.generated.CargoInfo.CargoRequestWithPaging) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.cpdss.common.generated.CargoInfo.CargoRequestWithPaging other) {
        if (other
            == com.cpdss.common.generated.CargoInfo.CargoRequestWithPaging.getDefaultInstance())
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
        com.cpdss.common.generated.CargoInfo.CargoRequestWithPaging parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.CargoInfo.CargoRequestWithPaging)
                  e.getUnfinishedMessage();
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

      // @@protoc_insertion_point(builder_scope:CargoRequestWithPaging)
    }

    // @@protoc_insertion_point(class_scope:CargoRequestWithPaging)
    private static final com.cpdss.common.generated.CargoInfo.CargoRequestWithPaging
        DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.CargoInfo.CargoRequestWithPaging();
    }

    public static com.cpdss.common.generated.CargoInfo.CargoRequestWithPaging getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<CargoRequestWithPaging> PARSER =
        new com.google.protobuf.AbstractParser<CargoRequestWithPaging>() {
          @java.lang.Override
          public CargoRequestWithPaging parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new CargoRequestWithPaging(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<CargoRequestWithPaging> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<CargoRequestWithPaging> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.CargoInfo.CargoRequestWithPaging getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface CargoDetailOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:CargoDetail)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int64 id = 1;</code>
     *
     * @return The id.
     */
    long getId();

    /**
     * <code>string crudeType = 2;</code>
     *
     * @return The crudeType.
     */
    java.lang.String getCrudeType();
    /**
     * <code>string crudeType = 2;</code>
     *
     * @return The bytes for crudeType.
     */
    com.google.protobuf.ByteString getCrudeTypeBytes();

    /**
     * <code>string abbreviation = 3;</code>
     *
     * @return The abbreviation.
     */
    java.lang.String getAbbreviation();
    /**
     * <code>string abbreviation = 3;</code>
     *
     * @return The bytes for abbreviation.
     */
    com.google.protobuf.ByteString getAbbreviationBytes();

    /**
     * <code>string api = 4;</code>
     *
     * @return The api.
     */
    java.lang.String getApi();
    /**
     * <code>string api = 4;</code>
     *
     * @return The bytes for api.
     */
    com.google.protobuf.ByteString getApiBytes();
  }
  /** Protobuf type {@code CargoDetail} */
  public static final class CargoDetail extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:CargoDetail)
      CargoDetailOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use CargoDetail.newBuilder() to construct.
    private CargoDetail(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private CargoDetail() {
      crudeType_ = "";
      abbreviation_ = "";
      api_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new CargoDetail();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private CargoDetail(
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

                crudeType_ = s;
                break;
              }
            case 26:
              {
                java.lang.String s = input.readStringRequireUtf8();

                abbreviation_ = s;
                break;
              }
            case 34:
              {
                java.lang.String s = input.readStringRequireUtf8();

                api_ = s;
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
      return com.cpdss.common.generated.CargoInfo.internal_static_CargoDetail_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.CargoInfo.internal_static_CargoDetail_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.CargoInfo.CargoDetail.class,
              com.cpdss.common.generated.CargoInfo.CargoDetail.Builder.class);
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

    public static final int CRUDETYPE_FIELD_NUMBER = 2;
    private volatile java.lang.Object crudeType_;
    /**
     * <code>string crudeType = 2;</code>
     *
     * @return The crudeType.
     */
    public java.lang.String getCrudeType() {
      java.lang.Object ref = crudeType_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        crudeType_ = s;
        return s;
      }
    }
    /**
     * <code>string crudeType = 2;</code>
     *
     * @return The bytes for crudeType.
     */
    public com.google.protobuf.ByteString getCrudeTypeBytes() {
      java.lang.Object ref = crudeType_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        crudeType_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int ABBREVIATION_FIELD_NUMBER = 3;
    private volatile java.lang.Object abbreviation_;
    /**
     * <code>string abbreviation = 3;</code>
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
     * <code>string abbreviation = 3;</code>
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

    public static final int API_FIELD_NUMBER = 4;
    private volatile java.lang.Object api_;
    /**
     * <code>string api = 4;</code>
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
     * <code>string api = 4;</code>
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
      if (!getCrudeTypeBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, crudeType_);
      }
      if (!getAbbreviationBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, abbreviation_);
      }
      if (!getApiBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 4, api_);
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
      if (!getCrudeTypeBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, crudeType_);
      }
      if (!getAbbreviationBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, abbreviation_);
      }
      if (!getApiBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, api_);
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
      if (!(obj instanceof com.cpdss.common.generated.CargoInfo.CargoDetail)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.CargoInfo.CargoDetail other =
          (com.cpdss.common.generated.CargoInfo.CargoDetail) obj;

      if (getId() != other.getId()) return false;
      if (!getCrudeType().equals(other.getCrudeType())) return false;
      if (!getAbbreviation().equals(other.getAbbreviation())) return false;
      if (!getApi().equals(other.getApi())) return false;
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
      hash = (37 * hash) + CRUDETYPE_FIELD_NUMBER;
      hash = (53 * hash) + getCrudeType().hashCode();
      hash = (37 * hash) + ABBREVIATION_FIELD_NUMBER;
      hash = (53 * hash) + getAbbreviation().hashCode();
      hash = (37 * hash) + API_FIELD_NUMBER;
      hash = (53 * hash) + getApi().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.CargoInfo.CargoDetail parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.CargoInfo.CargoDetail parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.CargoInfo.CargoDetail parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.CargoInfo.CargoDetail parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.CargoInfo.CargoDetail parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.CargoInfo.CargoDetail parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.CargoInfo.CargoDetail parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.CargoInfo.CargoDetail parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.CargoInfo.CargoDetail parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.CargoInfo.CargoDetail parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.CargoInfo.CargoDetail parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.CargoInfo.CargoDetail parseFrom(
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

    public static Builder newBuilder(com.cpdss.common.generated.CargoInfo.CargoDetail prototype) {
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
    /** Protobuf type {@code CargoDetail} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:CargoDetail)
        com.cpdss.common.generated.CargoInfo.CargoDetailOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.CargoInfo.internal_static_CargoDetail_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.CargoInfo.internal_static_CargoDetail_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.CargoInfo.CargoDetail.class,
                com.cpdss.common.generated.CargoInfo.CargoDetail.Builder.class);
      }

      // Construct using com.cpdss.common.generated.CargoInfo.CargoDetail.newBuilder()
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

        crudeType_ = "";

        abbreviation_ = "";

        api_ = "";

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.CargoInfo.internal_static_CargoDetail_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.CargoInfo.CargoDetail getDefaultInstanceForType() {
        return com.cpdss.common.generated.CargoInfo.CargoDetail.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.CargoInfo.CargoDetail build() {
        com.cpdss.common.generated.CargoInfo.CargoDetail result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.CargoInfo.CargoDetail buildPartial() {
        com.cpdss.common.generated.CargoInfo.CargoDetail result =
            new com.cpdss.common.generated.CargoInfo.CargoDetail(this);
        result.id_ = id_;
        result.crudeType_ = crudeType_;
        result.abbreviation_ = abbreviation_;
        result.api_ = api_;
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
        if (other instanceof com.cpdss.common.generated.CargoInfo.CargoDetail) {
          return mergeFrom((com.cpdss.common.generated.CargoInfo.CargoDetail) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.cpdss.common.generated.CargoInfo.CargoDetail other) {
        if (other == com.cpdss.common.generated.CargoInfo.CargoDetail.getDefaultInstance())
          return this;
        if (other.getId() != 0L) {
          setId(other.getId());
        }
        if (!other.getCrudeType().isEmpty()) {
          crudeType_ = other.crudeType_;
          onChanged();
        }
        if (!other.getAbbreviation().isEmpty()) {
          abbreviation_ = other.abbreviation_;
          onChanged();
        }
        if (!other.getApi().isEmpty()) {
          api_ = other.api_;
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
        com.cpdss.common.generated.CargoInfo.CargoDetail parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.CargoInfo.CargoDetail) e.getUnfinishedMessage();
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

      private java.lang.Object crudeType_ = "";
      /**
       * <code>string crudeType = 2;</code>
       *
       * @return The crudeType.
       */
      public java.lang.String getCrudeType() {
        java.lang.Object ref = crudeType_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          crudeType_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string crudeType = 2;</code>
       *
       * @return The bytes for crudeType.
       */
      public com.google.protobuf.ByteString getCrudeTypeBytes() {
        java.lang.Object ref = crudeType_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          crudeType_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string crudeType = 2;</code>
       *
       * @param value The crudeType to set.
       * @return This builder for chaining.
       */
      public Builder setCrudeType(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        crudeType_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string crudeType = 2;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearCrudeType() {

        crudeType_ = getDefaultInstance().getCrudeType();
        onChanged();
        return this;
      }
      /**
       * <code>string crudeType = 2;</code>
       *
       * @param value The bytes for crudeType to set.
       * @return This builder for chaining.
       */
      public Builder setCrudeTypeBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        crudeType_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object abbreviation_ = "";
      /**
       * <code>string abbreviation = 3;</code>
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
       * <code>string abbreviation = 3;</code>
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
       * <code>string abbreviation = 3;</code>
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
       * <code>string abbreviation = 3;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearAbbreviation() {

        abbreviation_ = getDefaultInstance().getAbbreviation();
        onChanged();
        return this;
      }
      /**
       * <code>string abbreviation = 3;</code>
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

      private java.lang.Object api_ = "";
      /**
       * <code>string api = 4;</code>
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
       * <code>string api = 4;</code>
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
       * <code>string api = 4;</code>
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
       * <code>string api = 4;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearApi() {

        api_ = getDefaultInstance().getApi();
        onChanged();
        return this;
      }
      /**
       * <code>string api = 4;</code>
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

      // @@protoc_insertion_point(builder_scope:CargoDetail)
    }

    // @@protoc_insertion_point(class_scope:CargoDetail)
    private static final com.cpdss.common.generated.CargoInfo.CargoDetail DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.CargoInfo.CargoDetail();
    }

    public static com.cpdss.common.generated.CargoInfo.CargoDetail getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<CargoDetail> PARSER =
        new com.google.protobuf.AbstractParser<CargoDetail>() {
          @java.lang.Override
          public CargoDetail parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new CargoDetail(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<CargoDetail> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<CargoDetail> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.CargoInfo.CargoDetail getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface CargoReplyOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:CargoReply)
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

    /** <code>repeated .CargoDetail cargos = 2;</code> */
    java.util.List<com.cpdss.common.generated.CargoInfo.CargoDetail> getCargosList();
    /** <code>repeated .CargoDetail cargos = 2;</code> */
    com.cpdss.common.generated.CargoInfo.CargoDetail getCargos(int index);
    /** <code>repeated .CargoDetail cargos = 2;</code> */
    int getCargosCount();
    /** <code>repeated .CargoDetail cargos = 2;</code> */
    java.util.List<? extends com.cpdss.common.generated.CargoInfo.CargoDetailOrBuilder>
        getCargosOrBuilderList();
    /** <code>repeated .CargoDetail cargos = 2;</code> */
    com.cpdss.common.generated.CargoInfo.CargoDetailOrBuilder getCargosOrBuilder(int index);
  }
  /** Protobuf type {@code CargoReply} */
  public static final class CargoReply extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:CargoReply)
      CargoReplyOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use CargoReply.newBuilder() to construct.
    private CargoReply(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private CargoReply() {
      cargos_ = java.util.Collections.emptyList();
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new CargoReply();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private CargoReply(
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
                  cargos_ =
                      new java.util.ArrayList<com.cpdss.common.generated.CargoInfo.CargoDetail>();
                  mutable_bitField0_ |= 0x00000001;
                }
                cargos_.add(
                    input.readMessage(
                        com.cpdss.common.generated.CargoInfo.CargoDetail.parser(),
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
          cargos_ = java.util.Collections.unmodifiableList(cargos_);
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }

    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.cpdss.common.generated.CargoInfo.internal_static_CargoReply_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.CargoInfo.internal_static_CargoReply_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.CargoInfo.CargoReply.class,
              com.cpdss.common.generated.CargoInfo.CargoReply.Builder.class);
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

    public static final int CARGOS_FIELD_NUMBER = 2;
    private java.util.List<com.cpdss.common.generated.CargoInfo.CargoDetail> cargos_;
    /** <code>repeated .CargoDetail cargos = 2;</code> */
    public java.util.List<com.cpdss.common.generated.CargoInfo.CargoDetail> getCargosList() {
      return cargos_;
    }
    /** <code>repeated .CargoDetail cargos = 2;</code> */
    public java.util.List<? extends com.cpdss.common.generated.CargoInfo.CargoDetailOrBuilder>
        getCargosOrBuilderList() {
      return cargos_;
    }
    /** <code>repeated .CargoDetail cargos = 2;</code> */
    public int getCargosCount() {
      return cargos_.size();
    }
    /** <code>repeated .CargoDetail cargos = 2;</code> */
    public com.cpdss.common.generated.CargoInfo.CargoDetail getCargos(int index) {
      return cargos_.get(index);
    }
    /** <code>repeated .CargoDetail cargos = 2;</code> */
    public com.cpdss.common.generated.CargoInfo.CargoDetailOrBuilder getCargosOrBuilder(int index) {
      return cargos_.get(index);
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
      for (int i = 0; i < cargos_.size(); i++) {
        output.writeMessage(2, cargos_.get(i));
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
      for (int i = 0; i < cargos_.size(); i++) {
        size += com.google.protobuf.CodedOutputStream.computeMessageSize(2, cargos_.get(i));
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
      if (!(obj instanceof com.cpdss.common.generated.CargoInfo.CargoReply)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.CargoInfo.CargoReply other =
          (com.cpdss.common.generated.CargoInfo.CargoReply) obj;

      if (hasResponseStatus() != other.hasResponseStatus()) return false;
      if (hasResponseStatus()) {
        if (!getResponseStatus().equals(other.getResponseStatus())) return false;
      }
      if (!getCargosList().equals(other.getCargosList())) return false;
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
      if (getCargosCount() > 0) {
        hash = (37 * hash) + CARGOS_FIELD_NUMBER;
        hash = (53 * hash) + getCargosList().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.CargoInfo.CargoReply parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.CargoInfo.CargoReply parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.CargoInfo.CargoReply parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.CargoInfo.CargoReply parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.CargoInfo.CargoReply parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.CargoInfo.CargoReply parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.CargoInfo.CargoReply parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.CargoInfo.CargoReply parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.CargoInfo.CargoReply parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.CargoInfo.CargoReply parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.CargoInfo.CargoReply parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.CargoInfo.CargoReply parseFrom(
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

    public static Builder newBuilder(com.cpdss.common.generated.CargoInfo.CargoReply prototype) {
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
    /** Protobuf type {@code CargoReply} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:CargoReply)
        com.cpdss.common.generated.CargoInfo.CargoReplyOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.CargoInfo.internal_static_CargoReply_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.CargoInfo.internal_static_CargoReply_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.CargoInfo.CargoReply.class,
                com.cpdss.common.generated.CargoInfo.CargoReply.Builder.class);
      }

      // Construct using com.cpdss.common.generated.CargoInfo.CargoReply.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {
          getCargosFieldBuilder();
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
        if (cargosBuilder_ == null) {
          cargos_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          cargosBuilder_.clear();
        }
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.CargoInfo.internal_static_CargoReply_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.CargoInfo.CargoReply getDefaultInstanceForType() {
        return com.cpdss.common.generated.CargoInfo.CargoReply.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.CargoInfo.CargoReply build() {
        com.cpdss.common.generated.CargoInfo.CargoReply result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.CargoInfo.CargoReply buildPartial() {
        com.cpdss.common.generated.CargoInfo.CargoReply result =
            new com.cpdss.common.generated.CargoInfo.CargoReply(this);
        int from_bitField0_ = bitField0_;
        if (responseStatusBuilder_ == null) {
          result.responseStatus_ = responseStatus_;
        } else {
          result.responseStatus_ = responseStatusBuilder_.build();
        }
        if (cargosBuilder_ == null) {
          if (((bitField0_ & 0x00000001) != 0)) {
            cargos_ = java.util.Collections.unmodifiableList(cargos_);
            bitField0_ = (bitField0_ & ~0x00000001);
          }
          result.cargos_ = cargos_;
        } else {
          result.cargos_ = cargosBuilder_.build();
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
        if (other instanceof com.cpdss.common.generated.CargoInfo.CargoReply) {
          return mergeFrom((com.cpdss.common.generated.CargoInfo.CargoReply) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.cpdss.common.generated.CargoInfo.CargoReply other) {
        if (other == com.cpdss.common.generated.CargoInfo.CargoReply.getDefaultInstance())
          return this;
        if (other.hasResponseStatus()) {
          mergeResponseStatus(other.getResponseStatus());
        }
        if (cargosBuilder_ == null) {
          if (!other.cargos_.isEmpty()) {
            if (cargos_.isEmpty()) {
              cargos_ = other.cargos_;
              bitField0_ = (bitField0_ & ~0x00000001);
            } else {
              ensureCargosIsMutable();
              cargos_.addAll(other.cargos_);
            }
            onChanged();
          }
        } else {
          if (!other.cargos_.isEmpty()) {
            if (cargosBuilder_.isEmpty()) {
              cargosBuilder_.dispose();
              cargosBuilder_ = null;
              cargos_ = other.cargos_;
              bitField0_ = (bitField0_ & ~0x00000001);
              cargosBuilder_ =
                  com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
                      ? getCargosFieldBuilder()
                      : null;
            } else {
              cargosBuilder_.addAllMessages(other.cargos_);
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
        com.cpdss.common.generated.CargoInfo.CargoReply parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.CargoInfo.CargoReply) e.getUnfinishedMessage();
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

      private java.util.List<com.cpdss.common.generated.CargoInfo.CargoDetail> cargos_ =
          java.util.Collections.emptyList();

      private void ensureCargosIsMutable() {
        if (!((bitField0_ & 0x00000001) != 0)) {
          cargos_ =
              new java.util.ArrayList<com.cpdss.common.generated.CargoInfo.CargoDetail>(cargos_);
          bitField0_ |= 0x00000001;
        }
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
              com.cpdss.common.generated.CargoInfo.CargoDetail,
              com.cpdss.common.generated.CargoInfo.CargoDetail.Builder,
              com.cpdss.common.generated.CargoInfo.CargoDetailOrBuilder>
          cargosBuilder_;

      /** <code>repeated .CargoDetail cargos = 2;</code> */
      public java.util.List<com.cpdss.common.generated.CargoInfo.CargoDetail> getCargosList() {
        if (cargosBuilder_ == null) {
          return java.util.Collections.unmodifiableList(cargos_);
        } else {
          return cargosBuilder_.getMessageList();
        }
      }
      /** <code>repeated .CargoDetail cargos = 2;</code> */
      public int getCargosCount() {
        if (cargosBuilder_ == null) {
          return cargos_.size();
        } else {
          return cargosBuilder_.getCount();
        }
      }
      /** <code>repeated .CargoDetail cargos = 2;</code> */
      public com.cpdss.common.generated.CargoInfo.CargoDetail getCargos(int index) {
        if (cargosBuilder_ == null) {
          return cargos_.get(index);
        } else {
          return cargosBuilder_.getMessage(index);
        }
      }
      /** <code>repeated .CargoDetail cargos = 2;</code> */
      public Builder setCargos(int index, com.cpdss.common.generated.CargoInfo.CargoDetail value) {
        if (cargosBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureCargosIsMutable();
          cargos_.set(index, value);
          onChanged();
        } else {
          cargosBuilder_.setMessage(index, value);
        }
        return this;
      }
      /** <code>repeated .CargoDetail cargos = 2;</code> */
      public Builder setCargos(
          int index, com.cpdss.common.generated.CargoInfo.CargoDetail.Builder builderForValue) {
        if (cargosBuilder_ == null) {
          ensureCargosIsMutable();
          cargos_.set(index, builderForValue.build());
          onChanged();
        } else {
          cargosBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .CargoDetail cargos = 2;</code> */
      public Builder addCargos(com.cpdss.common.generated.CargoInfo.CargoDetail value) {
        if (cargosBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureCargosIsMutable();
          cargos_.add(value);
          onChanged();
        } else {
          cargosBuilder_.addMessage(value);
        }
        return this;
      }
      /** <code>repeated .CargoDetail cargos = 2;</code> */
      public Builder addCargos(int index, com.cpdss.common.generated.CargoInfo.CargoDetail value) {
        if (cargosBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureCargosIsMutable();
          cargos_.add(index, value);
          onChanged();
        } else {
          cargosBuilder_.addMessage(index, value);
        }
        return this;
      }
      /** <code>repeated .CargoDetail cargos = 2;</code> */
      public Builder addCargos(
          com.cpdss.common.generated.CargoInfo.CargoDetail.Builder builderForValue) {
        if (cargosBuilder_ == null) {
          ensureCargosIsMutable();
          cargos_.add(builderForValue.build());
          onChanged();
        } else {
          cargosBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .CargoDetail cargos = 2;</code> */
      public Builder addCargos(
          int index, com.cpdss.common.generated.CargoInfo.CargoDetail.Builder builderForValue) {
        if (cargosBuilder_ == null) {
          ensureCargosIsMutable();
          cargos_.add(index, builderForValue.build());
          onChanged();
        } else {
          cargosBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .CargoDetail cargos = 2;</code> */
      public Builder addAllCargos(
          java.lang.Iterable<? extends com.cpdss.common.generated.CargoInfo.CargoDetail> values) {
        if (cargosBuilder_ == null) {
          ensureCargosIsMutable();
          com.google.protobuf.AbstractMessageLite.Builder.addAll(values, cargos_);
          onChanged();
        } else {
          cargosBuilder_.addAllMessages(values);
        }
        return this;
      }
      /** <code>repeated .CargoDetail cargos = 2;</code> */
      public Builder clearCargos() {
        if (cargosBuilder_ == null) {
          cargos_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
          onChanged();
        } else {
          cargosBuilder_.clear();
        }
        return this;
      }
      /** <code>repeated .CargoDetail cargos = 2;</code> */
      public Builder removeCargos(int index) {
        if (cargosBuilder_ == null) {
          ensureCargosIsMutable();
          cargos_.remove(index);
          onChanged();
        } else {
          cargosBuilder_.remove(index);
        }
        return this;
      }
      /** <code>repeated .CargoDetail cargos = 2;</code> */
      public com.cpdss.common.generated.CargoInfo.CargoDetail.Builder getCargosBuilder(int index) {
        return getCargosFieldBuilder().getBuilder(index);
      }
      /** <code>repeated .CargoDetail cargos = 2;</code> */
      public com.cpdss.common.generated.CargoInfo.CargoDetailOrBuilder getCargosOrBuilder(
          int index) {
        if (cargosBuilder_ == null) {
          return cargos_.get(index);
        } else {
          return cargosBuilder_.getMessageOrBuilder(index);
        }
      }
      /** <code>repeated .CargoDetail cargos = 2;</code> */
      public java.util.List<? extends com.cpdss.common.generated.CargoInfo.CargoDetailOrBuilder>
          getCargosOrBuilderList() {
        if (cargosBuilder_ != null) {
          return cargosBuilder_.getMessageOrBuilderList();
        } else {
          return java.util.Collections.unmodifiableList(cargos_);
        }
      }
      /** <code>repeated .CargoDetail cargos = 2;</code> */
      public com.cpdss.common.generated.CargoInfo.CargoDetail.Builder addCargosBuilder() {
        return getCargosFieldBuilder()
            .addBuilder(com.cpdss.common.generated.CargoInfo.CargoDetail.getDefaultInstance());
      }
      /** <code>repeated .CargoDetail cargos = 2;</code> */
      public com.cpdss.common.generated.CargoInfo.CargoDetail.Builder addCargosBuilder(int index) {
        return getCargosFieldBuilder()
            .addBuilder(
                index, com.cpdss.common.generated.CargoInfo.CargoDetail.getDefaultInstance());
      }
      /** <code>repeated .CargoDetail cargos = 2;</code> */
      public java.util.List<com.cpdss.common.generated.CargoInfo.CargoDetail.Builder>
          getCargosBuilderList() {
        return getCargosFieldBuilder().getBuilderList();
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
              com.cpdss.common.generated.CargoInfo.CargoDetail,
              com.cpdss.common.generated.CargoInfo.CargoDetail.Builder,
              com.cpdss.common.generated.CargoInfo.CargoDetailOrBuilder>
          getCargosFieldBuilder() {
        if (cargosBuilder_ == null) {
          cargosBuilder_ =
              new com.google.protobuf.RepeatedFieldBuilderV3<
                  com.cpdss.common.generated.CargoInfo.CargoDetail,
                  com.cpdss.common.generated.CargoInfo.CargoDetail.Builder,
                  com.cpdss.common.generated.CargoInfo.CargoDetailOrBuilder>(
                  cargos_, ((bitField0_ & 0x00000001) != 0), getParentForChildren(), isClean());
          cargos_ = null;
        }
        return cargosBuilder_;
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

      // @@protoc_insertion_point(builder_scope:CargoReply)
    }

    // @@protoc_insertion_point(class_scope:CargoReply)
    private static final com.cpdss.common.generated.CargoInfo.CargoReply DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.CargoInfo.CargoReply();
    }

    public static com.cpdss.common.generated.CargoInfo.CargoReply getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<CargoReply> PARSER =
        new com.google.protobuf.AbstractParser<CargoReply>() {
          @java.lang.Override
          public CargoReply parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new CargoReply(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<CargoReply> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<CargoReply> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.CargoInfo.CargoReply getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_CargoRequest_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_CargoRequest_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_CargoRequestWithPaging_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_CargoRequestWithPaging_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_CargoDetail_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_CargoDetail_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_CargoReply_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_CargoReply_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }

  private static com.google.protobuf.Descriptors.FileDescriptor descriptor;

  static {
    java.lang.String[] descriptorData = {
      "\n\020cargo_info.proto\032\014common.proto\"^\n\014Carg"
          + "oRequest\022\021\n\tcompanyId\030\001 \001(\003\022\020\n\010vesselId\030"
          + "\002 \001(\003\022\020\n\010voyageId\030\003 \001(\003\022\027\n\017loadableStudy"
          + "Id\030\004 \001(\003\"7\n\026CargoRequestWithPaging\022\016\n\006of"
          + "fset\030\001 \001(\003\022\r\n\005limit\030\002 \001(\003\"O\n\013CargoDetail"
          + "\022\n\n\002id\030\001 \001(\003\022\021\n\tcrudeType\030\002 \001(\t\022\024\n\014abbre"
          + "viation\030\003 \001(\t\022\013\n\003api\030\004 \001(\t\"S\n\nCargoReply"
          + "\022\'\n\016responseStatus\030\001 \001(\0132\017.ResponseStatu"
          + "s\022\034\n\006cargos\030\002 \003(\0132\014.CargoDetail2\200\001\n\020Carg"
          + "oInfoService\022,\n\014GetCargoInfo\022\r.CargoRequ"
          + "est\032\013.CargoReply\"\000\022>\n\024GetCargoInfoByPagi"
          + "ng\022\027.CargoRequestWithPaging\032\013.CargoReply"
          + "\"\000B\036\n\032com.cpdss.common.generatedP\000b\006prot"
          + "o3"
    };
    descriptor =
        com.google.protobuf.Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(
            descriptorData,
            new com.google.protobuf.Descriptors.FileDescriptor[] {
              com.cpdss.common.generated.Common.getDescriptor(),
            });
    internal_static_CargoRequest_descriptor = getDescriptor().getMessageTypes().get(0);
    internal_static_CargoRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_CargoRequest_descriptor,
            new java.lang.String[] {
              "CompanyId", "VesselId", "VoyageId", "LoadableStudyId",
            });
    internal_static_CargoRequestWithPaging_descriptor = getDescriptor().getMessageTypes().get(1);
    internal_static_CargoRequestWithPaging_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_CargoRequestWithPaging_descriptor,
            new java.lang.String[] {
              "Offset", "Limit",
            });
    internal_static_CargoDetail_descriptor = getDescriptor().getMessageTypes().get(2);
    internal_static_CargoDetail_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_CargoDetail_descriptor,
            new java.lang.String[] {
              "Id", "CrudeType", "Abbreviation", "Api",
            });
    internal_static_CargoReply_descriptor = getDescriptor().getMessageTypes().get(3);
    internal_static_CargoReply_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_CargoReply_descriptor,
            new java.lang.String[] {
              "ResponseStatus", "Cargos",
            });
    com.cpdss.common.generated.Common.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}