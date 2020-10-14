/* Licensed under Apache-2.0 */
package com.cpdss.common.generated;

public final class LoadableStudy {
  private LoadableStudy() {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistryLite registry) {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions((com.google.protobuf.ExtensionRegistryLite) registry);
  }

  public interface VoyageRequestOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:VoyageRequest)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int64 captainId = 1;</code>
     *
     * @return The captainId.
     */
    long getCaptainId();

    /**
     * <code>int64 chiefOfficerId = 2;</code>
     *
     * @return The chiefOfficerId.
     */
    long getChiefOfficerId();

    /**
     * <code>int64 companyId = 3;</code>
     *
     * @return The companyId.
     */
    long getCompanyId();

    /**
     * <code>int64 vesselId = 4;</code>
     *
     * @return The vesselId.
     */
    long getVesselId();

    /**
     * <code>string voyageNo = 5;</code>
     *
     * @return The voyageNo.
     */
    java.lang.String getVoyageNo();
    /**
     * <code>string voyageNo = 5;</code>
     *
     * @return The bytes for voyageNo.
     */
    com.google.protobuf.ByteString getVoyageNoBytes();
  }
  /** Protobuf type {@code VoyageRequest} */
  public static final class VoyageRequest extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:VoyageRequest)
      VoyageRequestOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use VoyageRequest.newBuilder() to construct.
    private VoyageRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private VoyageRequest() {
      voyageNo_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new VoyageRequest();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private VoyageRequest(
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
                captainId_ = input.readInt64();
                break;
              }
            case 16:
              {
                chiefOfficerId_ = input.readInt64();
                break;
              }
            case 24:
              {
                companyId_ = input.readInt64();
                break;
              }
            case 32:
              {
                vesselId_ = input.readInt64();
                break;
              }
            case 42:
              {
                java.lang.String s = input.readStringRequireUtf8();

                voyageNo_ = s;
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
      return com.cpdss.common.generated.LoadableStudy.internal_static_VoyageRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.LoadableStudy
          .internal_static_VoyageRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.LoadableStudy.VoyageRequest.class,
              com.cpdss.common.generated.LoadableStudy.VoyageRequest.Builder.class);
    }

    public static final int CAPTAINID_FIELD_NUMBER = 1;
    private long captainId_;
    /**
     * <code>int64 captainId = 1;</code>
     *
     * @return The captainId.
     */
    public long getCaptainId() {
      return captainId_;
    }

    public static final int CHIEFOFFICERID_FIELD_NUMBER = 2;
    private long chiefOfficerId_;
    /**
     * <code>int64 chiefOfficerId = 2;</code>
     *
     * @return The chiefOfficerId.
     */
    public long getChiefOfficerId() {
      return chiefOfficerId_;
    }

    public static final int COMPANYID_FIELD_NUMBER = 3;
    private long companyId_;
    /**
     * <code>int64 companyId = 3;</code>
     *
     * @return The companyId.
     */
    public long getCompanyId() {
      return companyId_;
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

    public static final int VOYAGENO_FIELD_NUMBER = 5;
    private volatile java.lang.Object voyageNo_;
    /**
     * <code>string voyageNo = 5;</code>
     *
     * @return The voyageNo.
     */
    public java.lang.String getVoyageNo() {
      java.lang.Object ref = voyageNo_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        voyageNo_ = s;
        return s;
      }
    }
    /**
     * <code>string voyageNo = 5;</code>
     *
     * @return The bytes for voyageNo.
     */
    public com.google.protobuf.ByteString getVoyageNoBytes() {
      java.lang.Object ref = voyageNo_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        voyageNo_ = b;
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
      if (captainId_ != 0L) {
        output.writeInt64(1, captainId_);
      }
      if (chiefOfficerId_ != 0L) {
        output.writeInt64(2, chiefOfficerId_);
      }
      if (companyId_ != 0L) {
        output.writeInt64(3, companyId_);
      }
      if (vesselId_ != 0L) {
        output.writeInt64(4, vesselId_);
      }
      if (!getVoyageNoBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 5, voyageNo_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (captainId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(1, captainId_);
      }
      if (chiefOfficerId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(2, chiefOfficerId_);
      }
      if (companyId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(3, companyId_);
      }
      if (vesselId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(4, vesselId_);
      }
      if (!getVoyageNoBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, voyageNo_);
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
      if (!(obj instanceof com.cpdss.common.generated.LoadableStudy.VoyageRequest)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.LoadableStudy.VoyageRequest other =
          (com.cpdss.common.generated.LoadableStudy.VoyageRequest) obj;

      if (getCaptainId() != other.getCaptainId()) return false;
      if (getChiefOfficerId() != other.getChiefOfficerId()) return false;
      if (getCompanyId() != other.getCompanyId()) return false;
      if (getVesselId() != other.getVesselId()) return false;
      if (!getVoyageNo().equals(other.getVoyageNo())) return false;
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
      hash = (37 * hash) + CAPTAINID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getCaptainId());
      hash = (37 * hash) + CHIEFOFFICERID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getChiefOfficerId());
      hash = (37 * hash) + COMPANYID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getCompanyId());
      hash = (37 * hash) + VESSELID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getVesselId());
      hash = (37 * hash) + VOYAGENO_FIELD_NUMBER;
      hash = (53 * hash) + getVoyageNo().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.LoadableStudy.VoyageRequest parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.VoyageRequest parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.VoyageRequest parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.VoyageRequest parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.VoyageRequest parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.VoyageRequest parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.VoyageRequest parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.VoyageRequest parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.VoyageRequest parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.VoyageRequest parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.VoyageRequest parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.VoyageRequest parseFrom(
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
        com.cpdss.common.generated.LoadableStudy.VoyageRequest prototype) {
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
    /** Protobuf type {@code VoyageRequest} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:VoyageRequest)
        com.cpdss.common.generated.LoadableStudy.VoyageRequestOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.LoadableStudy.internal_static_VoyageRequest_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.LoadableStudy
            .internal_static_VoyageRequest_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.LoadableStudy.VoyageRequest.class,
                com.cpdss.common.generated.LoadableStudy.VoyageRequest.Builder.class);
      }

      // Construct using com.cpdss.common.generated.LoadableStudy.VoyageRequest.newBuilder()
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
        captainId_ = 0L;

        chiefOfficerId_ = 0L;

        companyId_ = 0L;

        vesselId_ = 0L;

        voyageNo_ = "";

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.LoadableStudy.internal_static_VoyageRequest_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.VoyageRequest getDefaultInstanceForType() {
        return com.cpdss.common.generated.LoadableStudy.VoyageRequest.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.VoyageRequest build() {
        com.cpdss.common.generated.LoadableStudy.VoyageRequest result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.VoyageRequest buildPartial() {
        com.cpdss.common.generated.LoadableStudy.VoyageRequest result =
            new com.cpdss.common.generated.LoadableStudy.VoyageRequest(this);
        result.captainId_ = captainId_;
        result.chiefOfficerId_ = chiefOfficerId_;
        result.companyId_ = companyId_;
        result.vesselId_ = vesselId_;
        result.voyageNo_ = voyageNo_;
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
        if (other instanceof com.cpdss.common.generated.LoadableStudy.VoyageRequest) {
          return mergeFrom((com.cpdss.common.generated.LoadableStudy.VoyageRequest) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.cpdss.common.generated.LoadableStudy.VoyageRequest other) {
        if (other == com.cpdss.common.generated.LoadableStudy.VoyageRequest.getDefaultInstance())
          return this;
        if (other.getCaptainId() != 0L) {
          setCaptainId(other.getCaptainId());
        }
        if (other.getChiefOfficerId() != 0L) {
          setChiefOfficerId(other.getChiefOfficerId());
        }
        if (other.getCompanyId() != 0L) {
          setCompanyId(other.getCompanyId());
        }
        if (other.getVesselId() != 0L) {
          setVesselId(other.getVesselId());
        }
        if (!other.getVoyageNo().isEmpty()) {
          voyageNo_ = other.voyageNo_;
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
        com.cpdss.common.generated.LoadableStudy.VoyageRequest parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.LoadableStudy.VoyageRequest) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private long captainId_;
      /**
       * <code>int64 captainId = 1;</code>
       *
       * @return The captainId.
       */
      public long getCaptainId() {
        return captainId_;
      }
      /**
       * <code>int64 captainId = 1;</code>
       *
       * @param value The captainId to set.
       * @return This builder for chaining.
       */
      public Builder setCaptainId(long value) {

        captainId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int64 captainId = 1;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearCaptainId() {

        captainId_ = 0L;
        onChanged();
        return this;
      }

      private long chiefOfficerId_;
      /**
       * <code>int64 chiefOfficerId = 2;</code>
       *
       * @return The chiefOfficerId.
       */
      public long getChiefOfficerId() {
        return chiefOfficerId_;
      }
      /**
       * <code>int64 chiefOfficerId = 2;</code>
       *
       * @param value The chiefOfficerId to set.
       * @return This builder for chaining.
       */
      public Builder setChiefOfficerId(long value) {

        chiefOfficerId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int64 chiefOfficerId = 2;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearChiefOfficerId() {

        chiefOfficerId_ = 0L;
        onChanged();
        return this;
      }

      private long companyId_;
      /**
       * <code>int64 companyId = 3;</code>
       *
       * @return The companyId.
       */
      public long getCompanyId() {
        return companyId_;
      }
      /**
       * <code>int64 companyId = 3;</code>
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
       * <code>int64 companyId = 3;</code>
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

      private java.lang.Object voyageNo_ = "";
      /**
       * <code>string voyageNo = 5;</code>
       *
       * @return The voyageNo.
       */
      public java.lang.String getVoyageNo() {
        java.lang.Object ref = voyageNo_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          voyageNo_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string voyageNo = 5;</code>
       *
       * @return The bytes for voyageNo.
       */
      public com.google.protobuf.ByteString getVoyageNoBytes() {
        java.lang.Object ref = voyageNo_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          voyageNo_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string voyageNo = 5;</code>
       *
       * @param value The voyageNo to set.
       * @return This builder for chaining.
       */
      public Builder setVoyageNo(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        voyageNo_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string voyageNo = 5;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearVoyageNo() {

        voyageNo_ = getDefaultInstance().getVoyageNo();
        onChanged();
        return this;
      }
      /**
       * <code>string voyageNo = 5;</code>
       *
       * @param value The bytes for voyageNo to set.
       * @return This builder for chaining.
       */
      public Builder setVoyageNoBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        voyageNo_ = value;
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

      // @@protoc_insertion_point(builder_scope:VoyageRequest)
    }

    // @@protoc_insertion_point(class_scope:VoyageRequest)
    private static final com.cpdss.common.generated.LoadableStudy.VoyageRequest DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.LoadableStudy.VoyageRequest();
    }

    public static com.cpdss.common.generated.LoadableStudy.VoyageRequest getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<VoyageRequest> PARSER =
        new com.google.protobuf.AbstractParser<VoyageRequest>() {
          @java.lang.Override
          public VoyageRequest parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new VoyageRequest(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<VoyageRequest> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<VoyageRequest> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.LoadableStudy.VoyageRequest getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface VoyageReplyOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:VoyageReply)
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
  }
  /** Protobuf type {@code VoyageReply} */
  public static final class VoyageReply extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:VoyageReply)
      VoyageReplyOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use VoyageReply.newBuilder() to construct.
    private VoyageReply(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private VoyageReply() {
      status_ = "";
      message_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new VoyageReply();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private VoyageReply(
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
      return com.cpdss.common.generated.LoadableStudy.internal_static_VoyageReply_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.LoadableStudy.internal_static_VoyageReply_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.LoadableStudy.VoyageReply.class,
              com.cpdss.common.generated.LoadableStudy.VoyageReply.Builder.class);
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
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
        return true;
      }
      if (!(obj instanceof com.cpdss.common.generated.LoadableStudy.VoyageReply)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.LoadableStudy.VoyageReply other =
          (com.cpdss.common.generated.LoadableStudy.VoyageReply) obj;

      if (!getStatus().equals(other.getStatus())) return false;
      if (!getMessage().equals(other.getMessage())) return false;
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
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.LoadableStudy.VoyageReply parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.VoyageReply parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.VoyageReply parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.VoyageReply parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.VoyageReply parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.VoyageReply parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.VoyageReply parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.VoyageReply parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.VoyageReply parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.VoyageReply parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.VoyageReply parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.VoyageReply parseFrom(
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
        com.cpdss.common.generated.LoadableStudy.VoyageReply prototype) {
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
    /** Protobuf type {@code VoyageReply} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:VoyageReply)
        com.cpdss.common.generated.LoadableStudy.VoyageReplyOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.LoadableStudy.internal_static_VoyageReply_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.LoadableStudy
            .internal_static_VoyageReply_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.LoadableStudy.VoyageReply.class,
                com.cpdss.common.generated.LoadableStudy.VoyageReply.Builder.class);
      }

      // Construct using com.cpdss.common.generated.LoadableStudy.VoyageReply.newBuilder()
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

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.LoadableStudy.internal_static_VoyageReply_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.VoyageReply getDefaultInstanceForType() {
        return com.cpdss.common.generated.LoadableStudy.VoyageReply.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.VoyageReply build() {
        com.cpdss.common.generated.LoadableStudy.VoyageReply result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.VoyageReply buildPartial() {
        com.cpdss.common.generated.LoadableStudy.VoyageReply result =
            new com.cpdss.common.generated.LoadableStudy.VoyageReply(this);
        result.status_ = status_;
        result.message_ = message_;
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
        if (other instanceof com.cpdss.common.generated.LoadableStudy.VoyageReply) {
          return mergeFrom((com.cpdss.common.generated.LoadableStudy.VoyageReply) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.cpdss.common.generated.LoadableStudy.VoyageReply other) {
        if (other == com.cpdss.common.generated.LoadableStudy.VoyageReply.getDefaultInstance())
          return this;
        if (!other.getStatus().isEmpty()) {
          status_ = other.status_;
          onChanged();
        }
        if (!other.getMessage().isEmpty()) {
          message_ = other.message_;
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
        com.cpdss.common.generated.LoadableStudy.VoyageReply parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.LoadableStudy.VoyageReply) e.getUnfinishedMessage();
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

      // @@protoc_insertion_point(builder_scope:VoyageReply)
    }

    // @@protoc_insertion_point(class_scope:VoyageReply)
    private static final com.cpdss.common.generated.LoadableStudy.VoyageReply DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.LoadableStudy.VoyageReply();
    }

    public static com.cpdss.common.generated.LoadableStudy.VoyageReply getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<VoyageReply> PARSER =
        new com.google.protobuf.AbstractParser<VoyageReply>() {
          @java.lang.Override
          public VoyageReply parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new VoyageReply(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<VoyageReply> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<VoyageReply> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.LoadableStudy.VoyageReply getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface StatusReplyOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:StatusReply)
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
  }
  /** Protobuf type {@code StatusReply} */
  public static final class StatusReply extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:StatusReply)
      StatusReplyOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use StatusReply.newBuilder() to construct.
    private StatusReply(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private StatusReply() {
      status_ = "";
      message_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new StatusReply();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private StatusReply(
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
      return com.cpdss.common.generated.LoadableStudy.internal_static_StatusReply_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.LoadableStudy.internal_static_StatusReply_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.LoadableStudy.StatusReply.class,
              com.cpdss.common.generated.LoadableStudy.StatusReply.Builder.class);
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
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
        return true;
      }
      if (!(obj instanceof com.cpdss.common.generated.LoadableStudy.StatusReply)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.LoadableStudy.StatusReply other =
          (com.cpdss.common.generated.LoadableStudy.StatusReply) obj;

      if (!getStatus().equals(other.getStatus())) return false;
      if (!getMessage().equals(other.getMessage())) return false;
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
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.LoadableStudy.StatusReply parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.StatusReply parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.StatusReply parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.StatusReply parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.StatusReply parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.StatusReply parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.StatusReply parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.StatusReply parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.StatusReply parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.StatusReply parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.StatusReply parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.StatusReply parseFrom(
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
        com.cpdss.common.generated.LoadableStudy.StatusReply prototype) {
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
    /** Protobuf type {@code StatusReply} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:StatusReply)
        com.cpdss.common.generated.LoadableStudy.StatusReplyOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.LoadableStudy.internal_static_StatusReply_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.LoadableStudy
            .internal_static_StatusReply_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.LoadableStudy.StatusReply.class,
                com.cpdss.common.generated.LoadableStudy.StatusReply.Builder.class);
      }

      // Construct using com.cpdss.common.generated.LoadableStudy.StatusReply.newBuilder()
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

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.LoadableStudy.internal_static_StatusReply_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.StatusReply getDefaultInstanceForType() {
        return com.cpdss.common.generated.LoadableStudy.StatusReply.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.StatusReply build() {
        com.cpdss.common.generated.LoadableStudy.StatusReply result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.StatusReply buildPartial() {
        com.cpdss.common.generated.LoadableStudy.StatusReply result =
            new com.cpdss.common.generated.LoadableStudy.StatusReply(this);
        result.status_ = status_;
        result.message_ = message_;
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
        if (other instanceof com.cpdss.common.generated.LoadableStudy.StatusReply) {
          return mergeFrom((com.cpdss.common.generated.LoadableStudy.StatusReply) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.cpdss.common.generated.LoadableStudy.StatusReply other) {
        if (other == com.cpdss.common.generated.LoadableStudy.StatusReply.getDefaultInstance())
          return this;
        if (!other.getStatus().isEmpty()) {
          status_ = other.status_;
          onChanged();
        }
        if (!other.getMessage().isEmpty()) {
          message_ = other.message_;
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
        com.cpdss.common.generated.LoadableStudy.StatusReply parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.LoadableStudy.StatusReply) e.getUnfinishedMessage();
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

      // @@protoc_insertion_point(builder_scope:StatusReply)
    }

    // @@protoc_insertion_point(class_scope:StatusReply)
    private static final com.cpdss.common.generated.LoadableStudy.StatusReply DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.LoadableStudy.StatusReply();
    }

    public static com.cpdss.common.generated.LoadableStudy.StatusReply getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<StatusReply> PARSER =
        new com.google.protobuf.AbstractParser<StatusReply>() {
          @java.lang.Override
          public StatusReply parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new StatusReply(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<StatusReply> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<StatusReply> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.LoadableStudy.StatusReply getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface LoadableStudyRequestOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:LoadableStudyRequest)
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
  }
  /** Protobuf type {@code LoadableStudyRequest} */
  public static final class LoadableStudyRequest extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:LoadableStudyRequest)
      LoadableStudyRequestOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use LoadableStudyRequest.newBuilder() to construct.
    private LoadableStudyRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private LoadableStudyRequest() {}

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new LoadableStudyRequest();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private LoadableStudyRequest(
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
      return com.cpdss.common.generated.LoadableStudy
          .internal_static_LoadableStudyRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.LoadableStudy
          .internal_static_LoadableStudyRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.LoadableStudy.LoadableStudyRequest.class,
              com.cpdss.common.generated.LoadableStudy.LoadableStudyRequest.Builder.class);
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
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
        return true;
      }
      if (!(obj instanceof com.cpdss.common.generated.LoadableStudy.LoadableStudyRequest)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.LoadableStudy.LoadableStudyRequest other =
          (com.cpdss.common.generated.LoadableStudy.LoadableStudyRequest) obj;

      if (getCompanyId() != other.getCompanyId()) return false;
      if (getVesselId() != other.getVesselId()) return false;
      if (getVoyageId() != other.getVoyageId()) return false;
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
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableStudyRequest parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableStudyRequest parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableStudyRequest parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableStudyRequest parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableStudyRequest parseFrom(
        byte[] data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableStudyRequest parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableStudyRequest parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableStudyRequest parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableStudyRequest parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableStudyRequest parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableStudyRequest parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableStudyRequest parseFrom(
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
        com.cpdss.common.generated.LoadableStudy.LoadableStudyRequest prototype) {
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
    /** Protobuf type {@code LoadableStudyRequest} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:LoadableStudyRequest)
        com.cpdss.common.generated.LoadableStudy.LoadableStudyRequestOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.LoadableStudy
            .internal_static_LoadableStudyRequest_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.LoadableStudy
            .internal_static_LoadableStudyRequest_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.LoadableStudy.LoadableStudyRequest.class,
                com.cpdss.common.generated.LoadableStudy.LoadableStudyRequest.Builder.class);
      }

      // Construct using com.cpdss.common.generated.LoadableStudy.LoadableStudyRequest.newBuilder()
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

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.LoadableStudy
            .internal_static_LoadableStudyRequest_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.LoadableStudyRequest
          getDefaultInstanceForType() {
        return com.cpdss.common.generated.LoadableStudy.LoadableStudyRequest.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.LoadableStudyRequest build() {
        com.cpdss.common.generated.LoadableStudy.LoadableStudyRequest result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.LoadableStudyRequest buildPartial() {
        com.cpdss.common.generated.LoadableStudy.LoadableStudyRequest result =
            new com.cpdss.common.generated.LoadableStudy.LoadableStudyRequest(this);
        result.companyId_ = companyId_;
        result.vesselId_ = vesselId_;
        result.voyageId_ = voyageId_;
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
        if (other instanceof com.cpdss.common.generated.LoadableStudy.LoadableStudyRequest) {
          return mergeFrom((com.cpdss.common.generated.LoadableStudy.LoadableStudyRequest) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(
          com.cpdss.common.generated.LoadableStudy.LoadableStudyRequest other) {
        if (other
            == com.cpdss.common.generated.LoadableStudy.LoadableStudyRequest.getDefaultInstance())
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
        com.cpdss.common.generated.LoadableStudy.LoadableStudyRequest parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.LoadableStudy.LoadableStudyRequest)
                  e.getUnfinishedMessage();
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

      // @@protoc_insertion_point(builder_scope:LoadableStudyRequest)
    }

    // @@protoc_insertion_point(class_scope:LoadableStudyRequest)
    private static final com.cpdss.common.generated.LoadableStudy.LoadableStudyRequest
        DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.LoadableStudy.LoadableStudyRequest();
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableStudyRequest
        getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<LoadableStudyRequest> PARSER =
        new com.google.protobuf.AbstractParser<LoadableStudyRequest>() {
          @java.lang.Override
          public LoadableStudyRequest parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new LoadableStudyRequest(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<LoadableStudyRequest> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<LoadableStudyRequest> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.LoadableStudy.LoadableStudyRequest
        getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface LoadableStudyDetailOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:LoadableStudyDetail)
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
     * <code>string detail = 3;</code>
     *
     * @return The detail.
     */
    java.lang.String getDetail();
    /**
     * <code>string detail = 3;</code>
     *
     * @return The bytes for detail.
     */
    com.google.protobuf.ByteString getDetailBytes();

    /**
     * <code>string status = 4;</code>
     *
     * @return The status.
     */
    java.lang.String getStatus();
    /**
     * <code>string status = 4;</code>
     *
     * @return The bytes for status.
     */
    com.google.protobuf.ByteString getStatusBytes();

    /**
     * <code>string createdDate = 5;</code>
     *
     * @return The createdDate.
     */
    java.lang.String getCreatedDate();
    /**
     * <code>string createdDate = 5;</code>
     *
     * @return The bytes for createdDate.
     */
    com.google.protobuf.ByteString getCreatedDateBytes();

    /**
     * <code>string charterer = 6;</code>
     *
     * @return The charterer.
     */
    java.lang.String getCharterer();
    /**
     * <code>string charterer = 6;</code>
     *
     * @return The bytes for charterer.
     */
    com.google.protobuf.ByteString getChartererBytes();

    /**
     * <code>string subCharterer = 7;</code>
     *
     * @return The subCharterer.
     */
    java.lang.String getSubCharterer();
    /**
     * <code>string subCharterer = 7;</code>
     *
     * @return The bytes for subCharterer.
     */
    com.google.protobuf.ByteString getSubChartererBytes();

    /**
     * <code>string draftMark = 8;</code>
     *
     * @return The draftMark.
     */
    java.lang.String getDraftMark();
    /**
     * <code>string draftMark = 8;</code>
     *
     * @return The bytes for draftMark.
     */
    com.google.protobuf.ByteString getDraftMarkBytes();

    /**
     * <code>int64 loadLineXId = 9;</code>
     *
     * @return The loadLineXId.
     */
    long getLoadLineXId();

    /**
     * <code>string draftRestriction = 10;</code>
     *
     * @return The draftRestriction.
     */
    java.lang.String getDraftRestriction();
    /**
     * <code>string draftRestriction = 10;</code>
     *
     * @return The bytes for draftRestriction.
     */
    com.google.protobuf.ByteString getDraftRestrictionBytes();

    /**
     * <code>string maxTempExpected = 11;</code>
     *
     * @return The maxTempExpected.
     */
    java.lang.String getMaxTempExpected();
    /**
     * <code>string maxTempExpected = 11;</code>
     *
     * @return The bytes for maxTempExpected.
     */
    com.google.protobuf.ByteString getMaxTempExpectedBytes();
  }
  /** Protobuf type {@code LoadableStudyDetail} */
  public static final class LoadableStudyDetail extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:LoadableStudyDetail)
      LoadableStudyDetailOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use LoadableStudyDetail.newBuilder() to construct.
    private LoadableStudyDetail(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private LoadableStudyDetail() {
      name_ = "";
      detail_ = "";
      status_ = "";
      createdDate_ = "";
      charterer_ = "";
      subCharterer_ = "";
      draftMark_ = "";
      draftRestriction_ = "";
      maxTempExpected_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new LoadableStudyDetail();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private LoadableStudyDetail(
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

                detail_ = s;
                break;
              }
            case 34:
              {
                java.lang.String s = input.readStringRequireUtf8();

                status_ = s;
                break;
              }
            case 42:
              {
                java.lang.String s = input.readStringRequireUtf8();

                createdDate_ = s;
                break;
              }
            case 50:
              {
                java.lang.String s = input.readStringRequireUtf8();

                charterer_ = s;
                break;
              }
            case 58:
              {
                java.lang.String s = input.readStringRequireUtf8();

                subCharterer_ = s;
                break;
              }
            case 66:
              {
                java.lang.String s = input.readStringRequireUtf8();

                draftMark_ = s;
                break;
              }
            case 72:
              {
                loadLineXId_ = input.readInt64();
                break;
              }
            case 82:
              {
                java.lang.String s = input.readStringRequireUtf8();

                draftRestriction_ = s;
                break;
              }
            case 90:
              {
                java.lang.String s = input.readStringRequireUtf8();

                maxTempExpected_ = s;
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
      return com.cpdss.common.generated.LoadableStudy
          .internal_static_LoadableStudyDetail_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.LoadableStudy
          .internal_static_LoadableStudyDetail_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail.class,
              com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail.Builder.class);
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

    public static final int DETAIL_FIELD_NUMBER = 3;
    private volatile java.lang.Object detail_;
    /**
     * <code>string detail = 3;</code>
     *
     * @return The detail.
     */
    public java.lang.String getDetail() {
      java.lang.Object ref = detail_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        detail_ = s;
        return s;
      }
    }
    /**
     * <code>string detail = 3;</code>
     *
     * @return The bytes for detail.
     */
    public com.google.protobuf.ByteString getDetailBytes() {
      java.lang.Object ref = detail_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        detail_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int STATUS_FIELD_NUMBER = 4;
    private volatile java.lang.Object status_;
    /**
     * <code>string status = 4;</code>
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
     * <code>string status = 4;</code>
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

    public static final int CREATEDDATE_FIELD_NUMBER = 5;
    private volatile java.lang.Object createdDate_;
    /**
     * <code>string createdDate = 5;</code>
     *
     * @return The createdDate.
     */
    public java.lang.String getCreatedDate() {
      java.lang.Object ref = createdDate_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        createdDate_ = s;
        return s;
      }
    }
    /**
     * <code>string createdDate = 5;</code>
     *
     * @return The bytes for createdDate.
     */
    public com.google.protobuf.ByteString getCreatedDateBytes() {
      java.lang.Object ref = createdDate_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        createdDate_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int CHARTERER_FIELD_NUMBER = 6;
    private volatile java.lang.Object charterer_;
    /**
     * <code>string charterer = 6;</code>
     *
     * @return The charterer.
     */
    public java.lang.String getCharterer() {
      java.lang.Object ref = charterer_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        charterer_ = s;
        return s;
      }
    }
    /**
     * <code>string charterer = 6;</code>
     *
     * @return The bytes for charterer.
     */
    public com.google.protobuf.ByteString getChartererBytes() {
      java.lang.Object ref = charterer_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        charterer_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int SUBCHARTERER_FIELD_NUMBER = 7;
    private volatile java.lang.Object subCharterer_;
    /**
     * <code>string subCharterer = 7;</code>
     *
     * @return The subCharterer.
     */
    public java.lang.String getSubCharterer() {
      java.lang.Object ref = subCharterer_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        subCharterer_ = s;
        return s;
      }
    }
    /**
     * <code>string subCharterer = 7;</code>
     *
     * @return The bytes for subCharterer.
     */
    public com.google.protobuf.ByteString getSubChartererBytes() {
      java.lang.Object ref = subCharterer_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        subCharterer_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int DRAFTMARK_FIELD_NUMBER = 8;
    private volatile java.lang.Object draftMark_;
    /**
     * <code>string draftMark = 8;</code>
     *
     * @return The draftMark.
     */
    public java.lang.String getDraftMark() {
      java.lang.Object ref = draftMark_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        draftMark_ = s;
        return s;
      }
    }
    /**
     * <code>string draftMark = 8;</code>
     *
     * @return The bytes for draftMark.
     */
    public com.google.protobuf.ByteString getDraftMarkBytes() {
      java.lang.Object ref = draftMark_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        draftMark_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int LOADLINEXID_FIELD_NUMBER = 9;
    private long loadLineXId_;
    /**
     * <code>int64 loadLineXId = 9;</code>
     *
     * @return The loadLineXId.
     */
    public long getLoadLineXId() {
      return loadLineXId_;
    }

    public static final int DRAFTRESTRICTION_FIELD_NUMBER = 10;
    private volatile java.lang.Object draftRestriction_;
    /**
     * <code>string draftRestriction = 10;</code>
     *
     * @return The draftRestriction.
     */
    public java.lang.String getDraftRestriction() {
      java.lang.Object ref = draftRestriction_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        draftRestriction_ = s;
        return s;
      }
    }
    /**
     * <code>string draftRestriction = 10;</code>
     *
     * @return The bytes for draftRestriction.
     */
    public com.google.protobuf.ByteString getDraftRestrictionBytes() {
      java.lang.Object ref = draftRestriction_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        draftRestriction_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int MAXTEMPEXPECTED_FIELD_NUMBER = 11;
    private volatile java.lang.Object maxTempExpected_;
    /**
     * <code>string maxTempExpected = 11;</code>
     *
     * @return The maxTempExpected.
     */
    public java.lang.String getMaxTempExpected() {
      java.lang.Object ref = maxTempExpected_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        maxTempExpected_ = s;
        return s;
      }
    }
    /**
     * <code>string maxTempExpected = 11;</code>
     *
     * @return The bytes for maxTempExpected.
     */
    public com.google.protobuf.ByteString getMaxTempExpectedBytes() {
      java.lang.Object ref = maxTempExpected_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        maxTempExpected_ = b;
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
      if (!getDetailBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, detail_);
      }
      if (!getStatusBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 4, status_);
      }
      if (!getCreatedDateBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 5, createdDate_);
      }
      if (!getChartererBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 6, charterer_);
      }
      if (!getSubChartererBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 7, subCharterer_);
      }
      if (!getDraftMarkBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 8, draftMark_);
      }
      if (loadLineXId_ != 0L) {
        output.writeInt64(9, loadLineXId_);
      }
      if (!getDraftRestrictionBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 10, draftRestriction_);
      }
      if (!getMaxTempExpectedBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 11, maxTempExpected_);
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
      if (!getDetailBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, detail_);
      }
      if (!getStatusBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, status_);
      }
      if (!getCreatedDateBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, createdDate_);
      }
      if (!getChartererBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(6, charterer_);
      }
      if (!getSubChartererBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(7, subCharterer_);
      }
      if (!getDraftMarkBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(8, draftMark_);
      }
      if (loadLineXId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(9, loadLineXId_);
      }
      if (!getDraftRestrictionBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(10, draftRestriction_);
      }
      if (!getMaxTempExpectedBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(11, maxTempExpected_);
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
      if (!(obj instanceof com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail other =
          (com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail) obj;

      if (getId() != other.getId()) return false;
      if (!getName().equals(other.getName())) return false;
      if (!getDetail().equals(other.getDetail())) return false;
      if (!getStatus().equals(other.getStatus())) return false;
      if (!getCreatedDate().equals(other.getCreatedDate())) return false;
      if (!getCharterer().equals(other.getCharterer())) return false;
      if (!getSubCharterer().equals(other.getSubCharterer())) return false;
      if (!getDraftMark().equals(other.getDraftMark())) return false;
      if (getLoadLineXId() != other.getLoadLineXId()) return false;
      if (!getDraftRestriction().equals(other.getDraftRestriction())) return false;
      if (!getMaxTempExpected().equals(other.getMaxTempExpected())) return false;
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
      hash = (37 * hash) + DETAIL_FIELD_NUMBER;
      hash = (53 * hash) + getDetail().hashCode();
      hash = (37 * hash) + STATUS_FIELD_NUMBER;
      hash = (53 * hash) + getStatus().hashCode();
      hash = (37 * hash) + CREATEDDATE_FIELD_NUMBER;
      hash = (53 * hash) + getCreatedDate().hashCode();
      hash = (37 * hash) + CHARTERER_FIELD_NUMBER;
      hash = (53 * hash) + getCharterer().hashCode();
      hash = (37 * hash) + SUBCHARTERER_FIELD_NUMBER;
      hash = (53 * hash) + getSubCharterer().hashCode();
      hash = (37 * hash) + DRAFTMARK_FIELD_NUMBER;
      hash = (53 * hash) + getDraftMark().hashCode();
      hash = (37 * hash) + LOADLINEXID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getLoadLineXId());
      hash = (37 * hash) + DRAFTRESTRICTION_FIELD_NUMBER;
      hash = (53 * hash) + getDraftRestriction().hashCode();
      hash = (37 * hash) + MAXTEMPEXPECTED_FIELD_NUMBER;
      hash = (53 * hash) + getMaxTempExpected().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail parseFrom(
        byte[] data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail parseFrom(
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
        com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail prototype) {
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
    /** Protobuf type {@code LoadableStudyDetail} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:LoadableStudyDetail)
        com.cpdss.common.generated.LoadableStudy.LoadableStudyDetailOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.LoadableStudy
            .internal_static_LoadableStudyDetail_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.LoadableStudy
            .internal_static_LoadableStudyDetail_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail.class,
                com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail.Builder.class);
      }

      // Construct using com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail.newBuilder()
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

        detail_ = "";

        status_ = "";

        createdDate_ = "";

        charterer_ = "";

        subCharterer_ = "";

        draftMark_ = "";

        loadLineXId_ = 0L;

        draftRestriction_ = "";

        maxTempExpected_ = "";

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.LoadableStudy
            .internal_static_LoadableStudyDetail_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail
          getDefaultInstanceForType() {
        return com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail build() {
        com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail buildPartial() {
        com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail result =
            new com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail(this);
        result.id_ = id_;
        result.name_ = name_;
        result.detail_ = detail_;
        result.status_ = status_;
        result.createdDate_ = createdDate_;
        result.charterer_ = charterer_;
        result.subCharterer_ = subCharterer_;
        result.draftMark_ = draftMark_;
        result.loadLineXId_ = loadLineXId_;
        result.draftRestriction_ = draftRestriction_;
        result.maxTempExpected_ = maxTempExpected_;
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
        if (other instanceof com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail) {
          return mergeFrom((com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail other) {
        if (other
            == com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail.getDefaultInstance())
          return this;
        if (other.getId() != 0L) {
          setId(other.getId());
        }
        if (!other.getName().isEmpty()) {
          name_ = other.name_;
          onChanged();
        }
        if (!other.getDetail().isEmpty()) {
          detail_ = other.detail_;
          onChanged();
        }
        if (!other.getStatus().isEmpty()) {
          status_ = other.status_;
          onChanged();
        }
        if (!other.getCreatedDate().isEmpty()) {
          createdDate_ = other.createdDate_;
          onChanged();
        }
        if (!other.getCharterer().isEmpty()) {
          charterer_ = other.charterer_;
          onChanged();
        }
        if (!other.getSubCharterer().isEmpty()) {
          subCharterer_ = other.subCharterer_;
          onChanged();
        }
        if (!other.getDraftMark().isEmpty()) {
          draftMark_ = other.draftMark_;
          onChanged();
        }
        if (other.getLoadLineXId() != 0L) {
          setLoadLineXId(other.getLoadLineXId());
        }
        if (!other.getDraftRestriction().isEmpty()) {
          draftRestriction_ = other.draftRestriction_;
          onChanged();
        }
        if (!other.getMaxTempExpected().isEmpty()) {
          maxTempExpected_ = other.maxTempExpected_;
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
        com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail)
                  e.getUnfinishedMessage();
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

      private java.lang.Object detail_ = "";
      /**
       * <code>string detail = 3;</code>
       *
       * @return The detail.
       */
      public java.lang.String getDetail() {
        java.lang.Object ref = detail_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          detail_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string detail = 3;</code>
       *
       * @return The bytes for detail.
       */
      public com.google.protobuf.ByteString getDetailBytes() {
        java.lang.Object ref = detail_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          detail_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string detail = 3;</code>
       *
       * @param value The detail to set.
       * @return This builder for chaining.
       */
      public Builder setDetail(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        detail_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string detail = 3;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearDetail() {

        detail_ = getDefaultInstance().getDetail();
        onChanged();
        return this;
      }
      /**
       * <code>string detail = 3;</code>
       *
       * @param value The bytes for detail to set.
       * @return This builder for chaining.
       */
      public Builder setDetailBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        detail_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object status_ = "";
      /**
       * <code>string status = 4;</code>
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
       * <code>string status = 4;</code>
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
       * <code>string status = 4;</code>
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
       * <code>string status = 4;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearStatus() {

        status_ = getDefaultInstance().getStatus();
        onChanged();
        return this;
      }
      /**
       * <code>string status = 4;</code>
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

      private java.lang.Object createdDate_ = "";
      /**
       * <code>string createdDate = 5;</code>
       *
       * @return The createdDate.
       */
      public java.lang.String getCreatedDate() {
        java.lang.Object ref = createdDate_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          createdDate_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string createdDate = 5;</code>
       *
       * @return The bytes for createdDate.
       */
      public com.google.protobuf.ByteString getCreatedDateBytes() {
        java.lang.Object ref = createdDate_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          createdDate_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string createdDate = 5;</code>
       *
       * @param value The createdDate to set.
       * @return This builder for chaining.
       */
      public Builder setCreatedDate(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        createdDate_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string createdDate = 5;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearCreatedDate() {

        createdDate_ = getDefaultInstance().getCreatedDate();
        onChanged();
        return this;
      }
      /**
       * <code>string createdDate = 5;</code>
       *
       * @param value The bytes for createdDate to set.
       * @return This builder for chaining.
       */
      public Builder setCreatedDateBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        createdDate_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object charterer_ = "";
      /**
       * <code>string charterer = 6;</code>
       *
       * @return The charterer.
       */
      public java.lang.String getCharterer() {
        java.lang.Object ref = charterer_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          charterer_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string charterer = 6;</code>
       *
       * @return The bytes for charterer.
       */
      public com.google.protobuf.ByteString getChartererBytes() {
        java.lang.Object ref = charterer_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          charterer_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string charterer = 6;</code>
       *
       * @param value The charterer to set.
       * @return This builder for chaining.
       */
      public Builder setCharterer(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        charterer_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string charterer = 6;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearCharterer() {

        charterer_ = getDefaultInstance().getCharterer();
        onChanged();
        return this;
      }
      /**
       * <code>string charterer = 6;</code>
       *
       * @param value The bytes for charterer to set.
       * @return This builder for chaining.
       */
      public Builder setChartererBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        charterer_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object subCharterer_ = "";
      /**
       * <code>string subCharterer = 7;</code>
       *
       * @return The subCharterer.
       */
      public java.lang.String getSubCharterer() {
        java.lang.Object ref = subCharterer_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          subCharterer_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string subCharterer = 7;</code>
       *
       * @return The bytes for subCharterer.
       */
      public com.google.protobuf.ByteString getSubChartererBytes() {
        java.lang.Object ref = subCharterer_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          subCharterer_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string subCharterer = 7;</code>
       *
       * @param value The subCharterer to set.
       * @return This builder for chaining.
       */
      public Builder setSubCharterer(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        subCharterer_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string subCharterer = 7;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearSubCharterer() {

        subCharterer_ = getDefaultInstance().getSubCharterer();
        onChanged();
        return this;
      }
      /**
       * <code>string subCharterer = 7;</code>
       *
       * @param value The bytes for subCharterer to set.
       * @return This builder for chaining.
       */
      public Builder setSubChartererBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        subCharterer_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object draftMark_ = "";
      /**
       * <code>string draftMark = 8;</code>
       *
       * @return The draftMark.
       */
      public java.lang.String getDraftMark() {
        java.lang.Object ref = draftMark_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          draftMark_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string draftMark = 8;</code>
       *
       * @return The bytes for draftMark.
       */
      public com.google.protobuf.ByteString getDraftMarkBytes() {
        java.lang.Object ref = draftMark_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          draftMark_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string draftMark = 8;</code>
       *
       * @param value The draftMark to set.
       * @return This builder for chaining.
       */
      public Builder setDraftMark(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        draftMark_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string draftMark = 8;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearDraftMark() {

        draftMark_ = getDefaultInstance().getDraftMark();
        onChanged();
        return this;
      }
      /**
       * <code>string draftMark = 8;</code>
       *
       * @param value The bytes for draftMark to set.
       * @return This builder for chaining.
       */
      public Builder setDraftMarkBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        draftMark_ = value;
        onChanged();
        return this;
      }

      private long loadLineXId_;
      /**
       * <code>int64 loadLineXId = 9;</code>
       *
       * @return The loadLineXId.
       */
      public long getLoadLineXId() {
        return loadLineXId_;
      }
      /**
       * <code>int64 loadLineXId = 9;</code>
       *
       * @param value The loadLineXId to set.
       * @return This builder for chaining.
       */
      public Builder setLoadLineXId(long value) {

        loadLineXId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int64 loadLineXId = 9;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearLoadLineXId() {

        loadLineXId_ = 0L;
        onChanged();
        return this;
      }

      private java.lang.Object draftRestriction_ = "";
      /**
       * <code>string draftRestriction = 10;</code>
       *
       * @return The draftRestriction.
       */
      public java.lang.String getDraftRestriction() {
        java.lang.Object ref = draftRestriction_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          draftRestriction_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string draftRestriction = 10;</code>
       *
       * @return The bytes for draftRestriction.
       */
      public com.google.protobuf.ByteString getDraftRestrictionBytes() {
        java.lang.Object ref = draftRestriction_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          draftRestriction_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string draftRestriction = 10;</code>
       *
       * @param value The draftRestriction to set.
       * @return This builder for chaining.
       */
      public Builder setDraftRestriction(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        draftRestriction_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string draftRestriction = 10;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearDraftRestriction() {

        draftRestriction_ = getDefaultInstance().getDraftRestriction();
        onChanged();
        return this;
      }
      /**
       * <code>string draftRestriction = 10;</code>
       *
       * @param value The bytes for draftRestriction to set.
       * @return This builder for chaining.
       */
      public Builder setDraftRestrictionBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        draftRestriction_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object maxTempExpected_ = "";
      /**
       * <code>string maxTempExpected = 11;</code>
       *
       * @return The maxTempExpected.
       */
      public java.lang.String getMaxTempExpected() {
        java.lang.Object ref = maxTempExpected_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          maxTempExpected_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string maxTempExpected = 11;</code>
       *
       * @return The bytes for maxTempExpected.
       */
      public com.google.protobuf.ByteString getMaxTempExpectedBytes() {
        java.lang.Object ref = maxTempExpected_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          maxTempExpected_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string maxTempExpected = 11;</code>
       *
       * @param value The maxTempExpected to set.
       * @return This builder for chaining.
       */
      public Builder setMaxTempExpected(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        maxTempExpected_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string maxTempExpected = 11;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearMaxTempExpected() {

        maxTempExpected_ = getDefaultInstance().getMaxTempExpected();
        onChanged();
        return this;
      }
      /**
       * <code>string maxTempExpected = 11;</code>
       *
       * @param value The bytes for maxTempExpected to set.
       * @return This builder for chaining.
       */
      public Builder setMaxTempExpectedBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        maxTempExpected_ = value;
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

      // @@protoc_insertion_point(builder_scope:LoadableStudyDetail)
    }

    // @@protoc_insertion_point(class_scope:LoadableStudyDetail)
    private static final com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail
        DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail();
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail
        getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<LoadableStudyDetail> PARSER =
        new com.google.protobuf.AbstractParser<LoadableStudyDetail>() {
          @java.lang.Override
          public LoadableStudyDetail parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new LoadableStudyDetail(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<LoadableStudyDetail> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<LoadableStudyDetail> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail
        getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface LoadableStudyReplyOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:LoadableStudyReply)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>.StatusReply responseStatus = 1;</code>
     *
     * @return Whether the responseStatus field is set.
     */
    boolean hasResponseStatus();
    /**
     * <code>.StatusReply responseStatus = 1;</code>
     *
     * @return The responseStatus.
     */
    com.cpdss.common.generated.LoadableStudy.StatusReply getResponseStatus();
    /** <code>.StatusReply responseStatus = 1;</code> */
    com.cpdss.common.generated.LoadableStudy.StatusReplyOrBuilder getResponseStatusOrBuilder();

    /** <code>repeated .LoadableStudyDetail loadableStudies = 2;</code> */
    java.util.List<com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail>
        getLoadableStudiesList();
    /** <code>repeated .LoadableStudyDetail loadableStudies = 2;</code> */
    com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail getLoadableStudies(int index);
    /** <code>repeated .LoadableStudyDetail loadableStudies = 2;</code> */
    int getLoadableStudiesCount();
    /** <code>repeated .LoadableStudyDetail loadableStudies = 2;</code> */
    java.util.List<? extends com.cpdss.common.generated.LoadableStudy.LoadableStudyDetailOrBuilder>
        getLoadableStudiesOrBuilderList();
    /** <code>repeated .LoadableStudyDetail loadableStudies = 2;</code> */
    com.cpdss.common.generated.LoadableStudy.LoadableStudyDetailOrBuilder
        getLoadableStudiesOrBuilder(int index);
  }
  /** Protobuf type {@code LoadableStudyReply} */
  public static final class LoadableStudyReply extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:LoadableStudyReply)
      LoadableStudyReplyOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use LoadableStudyReply.newBuilder() to construct.
    private LoadableStudyReply(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private LoadableStudyReply() {
      loadableStudies_ = java.util.Collections.emptyList();
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new LoadableStudyReply();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private LoadableStudyReply(
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
                com.cpdss.common.generated.LoadableStudy.StatusReply.Builder subBuilder = null;
                if (responseStatus_ != null) {
                  subBuilder = responseStatus_.toBuilder();
                }
                responseStatus_ =
                    input.readMessage(
                        com.cpdss.common.generated.LoadableStudy.StatusReply.parser(),
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
                  loadableStudies_ =
                      new java.util.ArrayList<
                          com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail>();
                  mutable_bitField0_ |= 0x00000001;
                }
                loadableStudies_.add(
                    input.readMessage(
                        com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail.parser(),
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
          loadableStudies_ = java.util.Collections.unmodifiableList(loadableStudies_);
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }

    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.cpdss.common.generated.LoadableStudy.internal_static_LoadableStudyReply_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.LoadableStudy
          .internal_static_LoadableStudyReply_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.LoadableStudy.LoadableStudyReply.class,
              com.cpdss.common.generated.LoadableStudy.LoadableStudyReply.Builder.class);
    }

    public static final int RESPONSESTATUS_FIELD_NUMBER = 1;
    private com.cpdss.common.generated.LoadableStudy.StatusReply responseStatus_;
    /**
     * <code>.StatusReply responseStatus = 1;</code>
     *
     * @return Whether the responseStatus field is set.
     */
    public boolean hasResponseStatus() {
      return responseStatus_ != null;
    }
    /**
     * <code>.StatusReply responseStatus = 1;</code>
     *
     * @return The responseStatus.
     */
    public com.cpdss.common.generated.LoadableStudy.StatusReply getResponseStatus() {
      return responseStatus_ == null
          ? com.cpdss.common.generated.LoadableStudy.StatusReply.getDefaultInstance()
          : responseStatus_;
    }
    /** <code>.StatusReply responseStatus = 1;</code> */
    public com.cpdss.common.generated.LoadableStudy.StatusReplyOrBuilder
        getResponseStatusOrBuilder() {
      return getResponseStatus();
    }

    public static final int LOADABLESTUDIES_FIELD_NUMBER = 2;
    private java.util.List<com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail>
        loadableStudies_;
    /** <code>repeated .LoadableStudyDetail loadableStudies = 2;</code> */
    public java.util.List<com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail>
        getLoadableStudiesList() {
      return loadableStudies_;
    }
    /** <code>repeated .LoadableStudyDetail loadableStudies = 2;</code> */
    public java.util.List<
            ? extends com.cpdss.common.generated.LoadableStudy.LoadableStudyDetailOrBuilder>
        getLoadableStudiesOrBuilderList() {
      return loadableStudies_;
    }
    /** <code>repeated .LoadableStudyDetail loadableStudies = 2;</code> */
    public int getLoadableStudiesCount() {
      return loadableStudies_.size();
    }
    /** <code>repeated .LoadableStudyDetail loadableStudies = 2;</code> */
    public com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail getLoadableStudies(
        int index) {
      return loadableStudies_.get(index);
    }
    /** <code>repeated .LoadableStudyDetail loadableStudies = 2;</code> */
    public com.cpdss.common.generated.LoadableStudy.LoadableStudyDetailOrBuilder
        getLoadableStudiesOrBuilder(int index) {
      return loadableStudies_.get(index);
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
      for (int i = 0; i < loadableStudies_.size(); i++) {
        output.writeMessage(2, loadableStudies_.get(i));
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
      for (int i = 0; i < loadableStudies_.size(); i++) {
        size +=
            com.google.protobuf.CodedOutputStream.computeMessageSize(2, loadableStudies_.get(i));
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
      if (!(obj instanceof com.cpdss.common.generated.LoadableStudy.LoadableStudyReply)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.LoadableStudy.LoadableStudyReply other =
          (com.cpdss.common.generated.LoadableStudy.LoadableStudyReply) obj;

      if (hasResponseStatus() != other.hasResponseStatus()) return false;
      if (hasResponseStatus()) {
        if (!getResponseStatus().equals(other.getResponseStatus())) return false;
      }
      if (!getLoadableStudiesList().equals(other.getLoadableStudiesList())) return false;
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
      if (getLoadableStudiesCount() > 0) {
        hash = (37 * hash) + LOADABLESTUDIES_FIELD_NUMBER;
        hash = (53 * hash) + getLoadableStudiesList().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableStudyReply parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableStudyReply parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableStudyReply parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableStudyReply parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableStudyReply parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableStudyReply parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableStudyReply parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableStudyReply parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableStudyReply parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableStudyReply parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableStudyReply parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableStudyReply parseFrom(
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
        com.cpdss.common.generated.LoadableStudy.LoadableStudyReply prototype) {
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
    /** Protobuf type {@code LoadableStudyReply} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:LoadableStudyReply)
        com.cpdss.common.generated.LoadableStudy.LoadableStudyReplyOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.LoadableStudy
            .internal_static_LoadableStudyReply_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.LoadableStudy
            .internal_static_LoadableStudyReply_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.LoadableStudy.LoadableStudyReply.class,
                com.cpdss.common.generated.LoadableStudy.LoadableStudyReply.Builder.class);
      }

      // Construct using com.cpdss.common.generated.LoadableStudy.LoadableStudyReply.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {
          getLoadableStudiesFieldBuilder();
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
        if (loadableStudiesBuilder_ == null) {
          loadableStudies_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          loadableStudiesBuilder_.clear();
        }
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.LoadableStudy
            .internal_static_LoadableStudyReply_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.LoadableStudyReply
          getDefaultInstanceForType() {
        return com.cpdss.common.generated.LoadableStudy.LoadableStudyReply.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.LoadableStudyReply build() {
        com.cpdss.common.generated.LoadableStudy.LoadableStudyReply result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.LoadableStudyReply buildPartial() {
        com.cpdss.common.generated.LoadableStudy.LoadableStudyReply result =
            new com.cpdss.common.generated.LoadableStudy.LoadableStudyReply(this);
        int from_bitField0_ = bitField0_;
        if (responseStatusBuilder_ == null) {
          result.responseStatus_ = responseStatus_;
        } else {
          result.responseStatus_ = responseStatusBuilder_.build();
        }
        if (loadableStudiesBuilder_ == null) {
          if (((bitField0_ & 0x00000001) != 0)) {
            loadableStudies_ = java.util.Collections.unmodifiableList(loadableStudies_);
            bitField0_ = (bitField0_ & ~0x00000001);
          }
          result.loadableStudies_ = loadableStudies_;
        } else {
          result.loadableStudies_ = loadableStudiesBuilder_.build();
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
        if (other instanceof com.cpdss.common.generated.LoadableStudy.LoadableStudyReply) {
          return mergeFrom((com.cpdss.common.generated.LoadableStudy.LoadableStudyReply) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.cpdss.common.generated.LoadableStudy.LoadableStudyReply other) {
        if (other
            == com.cpdss.common.generated.LoadableStudy.LoadableStudyReply.getDefaultInstance())
          return this;
        if (other.hasResponseStatus()) {
          mergeResponseStatus(other.getResponseStatus());
        }
        if (loadableStudiesBuilder_ == null) {
          if (!other.loadableStudies_.isEmpty()) {
            if (loadableStudies_.isEmpty()) {
              loadableStudies_ = other.loadableStudies_;
              bitField0_ = (bitField0_ & ~0x00000001);
            } else {
              ensureLoadableStudiesIsMutable();
              loadableStudies_.addAll(other.loadableStudies_);
            }
            onChanged();
          }
        } else {
          if (!other.loadableStudies_.isEmpty()) {
            if (loadableStudiesBuilder_.isEmpty()) {
              loadableStudiesBuilder_.dispose();
              loadableStudiesBuilder_ = null;
              loadableStudies_ = other.loadableStudies_;
              bitField0_ = (bitField0_ & ~0x00000001);
              loadableStudiesBuilder_ =
                  com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
                      ? getLoadableStudiesFieldBuilder()
                      : null;
            } else {
              loadableStudiesBuilder_.addAllMessages(other.loadableStudies_);
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
        com.cpdss.common.generated.LoadableStudy.LoadableStudyReply parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.LoadableStudy.LoadableStudyReply)
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

      private com.cpdss.common.generated.LoadableStudy.StatusReply responseStatus_;
      private com.google.protobuf.SingleFieldBuilderV3<
              com.cpdss.common.generated.LoadableStudy.StatusReply,
              com.cpdss.common.generated.LoadableStudy.StatusReply.Builder,
              com.cpdss.common.generated.LoadableStudy.StatusReplyOrBuilder>
          responseStatusBuilder_;
      /**
       * <code>.StatusReply responseStatus = 1;</code>
       *
       * @return Whether the responseStatus field is set.
       */
      public boolean hasResponseStatus() {
        return responseStatusBuilder_ != null || responseStatus_ != null;
      }
      /**
       * <code>.StatusReply responseStatus = 1;</code>
       *
       * @return The responseStatus.
       */
      public com.cpdss.common.generated.LoadableStudy.StatusReply getResponseStatus() {
        if (responseStatusBuilder_ == null) {
          return responseStatus_ == null
              ? com.cpdss.common.generated.LoadableStudy.StatusReply.getDefaultInstance()
              : responseStatus_;
        } else {
          return responseStatusBuilder_.getMessage();
        }
      }
      /** <code>.StatusReply responseStatus = 1;</code> */
      public Builder setResponseStatus(com.cpdss.common.generated.LoadableStudy.StatusReply value) {
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
      /** <code>.StatusReply responseStatus = 1;</code> */
      public Builder setResponseStatus(
          com.cpdss.common.generated.LoadableStudy.StatusReply.Builder builderForValue) {
        if (responseStatusBuilder_ == null) {
          responseStatus_ = builderForValue.build();
          onChanged();
        } else {
          responseStatusBuilder_.setMessage(builderForValue.build());
        }

        return this;
      }
      /** <code>.StatusReply responseStatus = 1;</code> */
      public Builder mergeResponseStatus(
          com.cpdss.common.generated.LoadableStudy.StatusReply value) {
        if (responseStatusBuilder_ == null) {
          if (responseStatus_ != null) {
            responseStatus_ =
                com.cpdss.common.generated.LoadableStudy.StatusReply.newBuilder(responseStatus_)
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
      /** <code>.StatusReply responseStatus = 1;</code> */
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
      /** <code>.StatusReply responseStatus = 1;</code> */
      public com.cpdss.common.generated.LoadableStudy.StatusReply.Builder
          getResponseStatusBuilder() {

        onChanged();
        return getResponseStatusFieldBuilder().getBuilder();
      }
      /** <code>.StatusReply responseStatus = 1;</code> */
      public com.cpdss.common.generated.LoadableStudy.StatusReplyOrBuilder
          getResponseStatusOrBuilder() {
        if (responseStatusBuilder_ != null) {
          return responseStatusBuilder_.getMessageOrBuilder();
        } else {
          return responseStatus_ == null
              ? com.cpdss.common.generated.LoadableStudy.StatusReply.getDefaultInstance()
              : responseStatus_;
        }
      }
      /** <code>.StatusReply responseStatus = 1;</code> */
      private com.google.protobuf.SingleFieldBuilderV3<
              com.cpdss.common.generated.LoadableStudy.StatusReply,
              com.cpdss.common.generated.LoadableStudy.StatusReply.Builder,
              com.cpdss.common.generated.LoadableStudy.StatusReplyOrBuilder>
          getResponseStatusFieldBuilder() {
        if (responseStatusBuilder_ == null) {
          responseStatusBuilder_ =
              new com.google.protobuf.SingleFieldBuilderV3<
                  com.cpdss.common.generated.LoadableStudy.StatusReply,
                  com.cpdss.common.generated.LoadableStudy.StatusReply.Builder,
                  com.cpdss.common.generated.LoadableStudy.StatusReplyOrBuilder>(
                  getResponseStatus(), getParentForChildren(), isClean());
          responseStatus_ = null;
        }
        return responseStatusBuilder_;
      }

      private java.util.List<com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail>
          loadableStudies_ = java.util.Collections.emptyList();

      private void ensureLoadableStudiesIsMutable() {
        if (!((bitField0_ & 0x00000001) != 0)) {
          loadableStudies_ =
              new java.util.ArrayList<com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail>(
                  loadableStudies_);
          bitField0_ |= 0x00000001;
        }
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
              com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail,
              com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail.Builder,
              com.cpdss.common.generated.LoadableStudy.LoadableStudyDetailOrBuilder>
          loadableStudiesBuilder_;

      /** <code>repeated .LoadableStudyDetail loadableStudies = 2;</code> */
      public java.util.List<com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail>
          getLoadableStudiesList() {
        if (loadableStudiesBuilder_ == null) {
          return java.util.Collections.unmodifiableList(loadableStudies_);
        } else {
          return loadableStudiesBuilder_.getMessageList();
        }
      }
      /** <code>repeated .LoadableStudyDetail loadableStudies = 2;</code> */
      public int getLoadableStudiesCount() {
        if (loadableStudiesBuilder_ == null) {
          return loadableStudies_.size();
        } else {
          return loadableStudiesBuilder_.getCount();
        }
      }
      /** <code>repeated .LoadableStudyDetail loadableStudies = 2;</code> */
      public com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail getLoadableStudies(
          int index) {
        if (loadableStudiesBuilder_ == null) {
          return loadableStudies_.get(index);
        } else {
          return loadableStudiesBuilder_.getMessage(index);
        }
      }
      /** <code>repeated .LoadableStudyDetail loadableStudies = 2;</code> */
      public Builder setLoadableStudies(
          int index, com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail value) {
        if (loadableStudiesBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureLoadableStudiesIsMutable();
          loadableStudies_.set(index, value);
          onChanged();
        } else {
          loadableStudiesBuilder_.setMessage(index, value);
        }
        return this;
      }
      /** <code>repeated .LoadableStudyDetail loadableStudies = 2;</code> */
      public Builder setLoadableStudies(
          int index,
          com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail.Builder builderForValue) {
        if (loadableStudiesBuilder_ == null) {
          ensureLoadableStudiesIsMutable();
          loadableStudies_.set(index, builderForValue.build());
          onChanged();
        } else {
          loadableStudiesBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .LoadableStudyDetail loadableStudies = 2;</code> */
      public Builder addLoadableStudies(
          com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail value) {
        if (loadableStudiesBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureLoadableStudiesIsMutable();
          loadableStudies_.add(value);
          onChanged();
        } else {
          loadableStudiesBuilder_.addMessage(value);
        }
        return this;
      }
      /** <code>repeated .LoadableStudyDetail loadableStudies = 2;</code> */
      public Builder addLoadableStudies(
          int index, com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail value) {
        if (loadableStudiesBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureLoadableStudiesIsMutable();
          loadableStudies_.add(index, value);
          onChanged();
        } else {
          loadableStudiesBuilder_.addMessage(index, value);
        }
        return this;
      }
      /** <code>repeated .LoadableStudyDetail loadableStudies = 2;</code> */
      public Builder addLoadableStudies(
          com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail.Builder builderForValue) {
        if (loadableStudiesBuilder_ == null) {
          ensureLoadableStudiesIsMutable();
          loadableStudies_.add(builderForValue.build());
          onChanged();
        } else {
          loadableStudiesBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .LoadableStudyDetail loadableStudies = 2;</code> */
      public Builder addLoadableStudies(
          int index,
          com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail.Builder builderForValue) {
        if (loadableStudiesBuilder_ == null) {
          ensureLoadableStudiesIsMutable();
          loadableStudies_.add(index, builderForValue.build());
          onChanged();
        } else {
          loadableStudiesBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .LoadableStudyDetail loadableStudies = 2;</code> */
      public Builder addAllLoadableStudies(
          java.lang.Iterable<? extends com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail>
              values) {
        if (loadableStudiesBuilder_ == null) {
          ensureLoadableStudiesIsMutable();
          com.google.protobuf.AbstractMessageLite.Builder.addAll(values, loadableStudies_);
          onChanged();
        } else {
          loadableStudiesBuilder_.addAllMessages(values);
        }
        return this;
      }
      /** <code>repeated .LoadableStudyDetail loadableStudies = 2;</code> */
      public Builder clearLoadableStudies() {
        if (loadableStudiesBuilder_ == null) {
          loadableStudies_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
          onChanged();
        } else {
          loadableStudiesBuilder_.clear();
        }
        return this;
      }
      /** <code>repeated .LoadableStudyDetail loadableStudies = 2;</code> */
      public Builder removeLoadableStudies(int index) {
        if (loadableStudiesBuilder_ == null) {
          ensureLoadableStudiesIsMutable();
          loadableStudies_.remove(index);
          onChanged();
        } else {
          loadableStudiesBuilder_.remove(index);
        }
        return this;
      }
      /** <code>repeated .LoadableStudyDetail loadableStudies = 2;</code> */
      public com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail.Builder
          getLoadableStudiesBuilder(int index) {
        return getLoadableStudiesFieldBuilder().getBuilder(index);
      }
      /** <code>repeated .LoadableStudyDetail loadableStudies = 2;</code> */
      public com.cpdss.common.generated.LoadableStudy.LoadableStudyDetailOrBuilder
          getLoadableStudiesOrBuilder(int index) {
        if (loadableStudiesBuilder_ == null) {
          return loadableStudies_.get(index);
        } else {
          return loadableStudiesBuilder_.getMessageOrBuilder(index);
        }
      }
      /** <code>repeated .LoadableStudyDetail loadableStudies = 2;</code> */
      public java.util.List<
              ? extends com.cpdss.common.generated.LoadableStudy.LoadableStudyDetailOrBuilder>
          getLoadableStudiesOrBuilderList() {
        if (loadableStudiesBuilder_ != null) {
          return loadableStudiesBuilder_.getMessageOrBuilderList();
        } else {
          return java.util.Collections.unmodifiableList(loadableStudies_);
        }
      }
      /** <code>repeated .LoadableStudyDetail loadableStudies = 2;</code> */
      public com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail.Builder
          addLoadableStudiesBuilder() {
        return getLoadableStudiesFieldBuilder()
            .addBuilder(
                com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail.getDefaultInstance());
      }
      /** <code>repeated .LoadableStudyDetail loadableStudies = 2;</code> */
      public com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail.Builder
          addLoadableStudiesBuilder(int index) {
        return getLoadableStudiesFieldBuilder()
            .addBuilder(
                index,
                com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail.getDefaultInstance());
      }
      /** <code>repeated .LoadableStudyDetail loadableStudies = 2;</code> */
      public java.util.List<com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail.Builder>
          getLoadableStudiesBuilderList() {
        return getLoadableStudiesFieldBuilder().getBuilderList();
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
              com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail,
              com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail.Builder,
              com.cpdss.common.generated.LoadableStudy.LoadableStudyDetailOrBuilder>
          getLoadableStudiesFieldBuilder() {
        if (loadableStudiesBuilder_ == null) {
          loadableStudiesBuilder_ =
              new com.google.protobuf.RepeatedFieldBuilderV3<
                  com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail,
                  com.cpdss.common.generated.LoadableStudy.LoadableStudyDetail.Builder,
                  com.cpdss.common.generated.LoadableStudy.LoadableStudyDetailOrBuilder>(
                  loadableStudies_,
                  ((bitField0_ & 0x00000001) != 0),
                  getParentForChildren(),
                  isClean());
          loadableStudies_ = null;
        }
        return loadableStudiesBuilder_;
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

      // @@protoc_insertion_point(builder_scope:LoadableStudyReply)
    }

    // @@protoc_insertion_point(class_scope:LoadableStudyReply)
    private static final com.cpdss.common.generated.LoadableStudy.LoadableStudyReply
        DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.LoadableStudy.LoadableStudyReply();
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableStudyReply getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<LoadableStudyReply> PARSER =
        new com.google.protobuf.AbstractParser<LoadableStudyReply>() {
          @java.lang.Override
          public LoadableStudyReply parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new LoadableStudyReply(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<LoadableStudyReply> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<LoadableStudyReply> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.LoadableStudy.LoadableStudyReply getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_VoyageRequest_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_VoyageRequest_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_VoyageReply_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_VoyageReply_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_StatusReply_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_StatusReply_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_LoadableStudyRequest_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_LoadableStudyRequest_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_LoadableStudyDetail_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_LoadableStudyDetail_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_LoadableStudyReply_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_LoadableStudyReply_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }

  private static com.google.protobuf.Descriptors.FileDescriptor descriptor;

  static {
    java.lang.String[] descriptorData = {
      "\n\024loadable_study.proto\"q\n\rVoyageRequest\022"
          + "\021\n\tcaptainId\030\001 \001(\003\022\026\n\016chiefOfficerId\030\002 \001"
          + "(\003\022\021\n\tcompanyId\030\003 \001(\003\022\020\n\010vesselId\030\004 \001(\003\022"
          + "\020\n\010voyageNo\030\005 \001(\t\".\n\013VoyageReply\022\016\n\006stat"
          + "us\030\001 \001(\t\022\017\n\007message\030\002 \001(\t\".\n\013StatusReply"
          + "\022\016\n\006status\030\001 \001(\t\022\017\n\007message\030\002 \001(\t\"M\n\024Loa"
          + "dableStudyRequest\022\021\n\tcompanyId\030\001 \001(\003\022\020\n\010"
          + "vesselId\030\002 \001(\003\022\020\n\010voyageId\030\003 \001(\003\"\350\001\n\023Loa"
          + "dableStudyDetail\022\n\n\002id\030\001 \001(\003\022\014\n\004name\030\002 \001"
          + "(\t\022\016\n\006detail\030\003 \001(\t\022\016\n\006status\030\004 \001(\t\022\023\n\013cr"
          + "eatedDate\030\005 \001(\t\022\021\n\tcharterer\030\006 \001(\t\022\024\n\014su"
          + "bCharterer\030\007 \001(\t\022\021\n\tdraftMark\030\010 \001(\t\022\023\n\013l"
          + "oadLineXId\030\t \001(\003\022\030\n\020draftRestriction\030\n \001"
          + "(\t\022\027\n\017maxTempExpected\030\013 \001(\t\"i\n\022LoadableS"
          + "tudyReply\022$\n\016responseStatus\030\001 \001(\0132\014.Stat"
          + "usReply\022-\n\017loadableStudies\030\002 \003(\0132\024.Loada"
          + "bleStudyDetail2\232\001\n\024LoadableStudyService\022"
          + ",\n\nSaveVoyage\022\016.VoyageRequest\032\014.VoyageRe"
          + "ply\"\000\022T\n$FindLoadableStudiesByVesselAndV"
          + "oyage\022\025.LoadableStudyRequest\032\023.LoadableS"
          + "tudyReply\"\000B\036\n\032com.cpdss.common.generate"
          + "dP\000b\006proto3"
    };
    descriptor =
        com.google.protobuf.Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(
            descriptorData, new com.google.protobuf.Descriptors.FileDescriptor[] {});
    internal_static_VoyageRequest_descriptor = getDescriptor().getMessageTypes().get(0);
    internal_static_VoyageRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_VoyageRequest_descriptor,
            new java.lang.String[] {
              "CaptainId", "ChiefOfficerId", "CompanyId", "VesselId", "VoyageNo",
            });
    internal_static_VoyageReply_descriptor = getDescriptor().getMessageTypes().get(1);
    internal_static_VoyageReply_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_VoyageReply_descriptor,
            new java.lang.String[] {
              "Status", "Message",
            });
    internal_static_StatusReply_descriptor = getDescriptor().getMessageTypes().get(2);
    internal_static_StatusReply_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_StatusReply_descriptor,
            new java.lang.String[] {
              "Status", "Message",
            });
    internal_static_LoadableStudyRequest_descriptor = getDescriptor().getMessageTypes().get(3);
    internal_static_LoadableStudyRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_LoadableStudyRequest_descriptor,
            new java.lang.String[] {
              "CompanyId", "VesselId", "VoyageId",
            });
    internal_static_LoadableStudyDetail_descriptor = getDescriptor().getMessageTypes().get(4);
    internal_static_LoadableStudyDetail_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_LoadableStudyDetail_descriptor,
            new java.lang.String[] {
              "Id",
              "Name",
              "Detail",
              "Status",
              "CreatedDate",
              "Charterer",
              "SubCharterer",
              "DraftMark",
              "LoadLineXId",
              "DraftRestriction",
              "MaxTempExpected",
            });
    internal_static_LoadableStudyReply_descriptor = getDescriptor().getMessageTypes().get(5);
    internal_static_LoadableStudyReply_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_LoadableStudyReply_descriptor,
            new java.lang.String[] {
              "ResponseStatus", "LoadableStudies",
            });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
