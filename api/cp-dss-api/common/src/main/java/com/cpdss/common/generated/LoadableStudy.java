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
     * <code>int64 voyageId = 1;</code>
     *
     * @return The voyageId.
     */
    long getVoyageId();

    /**
     * <code>.StatusReply responseStatus = 2;</code>
     *
     * @return Whether the responseStatus field is set.
     */
    boolean hasResponseStatus();
    /**
     * <code>.StatusReply responseStatus = 2;</code>
     *
     * @return The responseStatus.
     */
    com.cpdss.common.generated.LoadableStudy.StatusReply getResponseStatus();
    /** <code>.StatusReply responseStatus = 2;</code> */
    com.cpdss.common.generated.LoadableStudy.StatusReplyOrBuilder getResponseStatusOrBuilder();
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

    private VoyageReply() {}

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
            case 8:
              {
                voyageId_ = input.readInt64();
                break;
              }
            case 18:
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

    public static final int VOYAGEID_FIELD_NUMBER = 1;
    private long voyageId_;
    /**
     * <code>int64 voyageId = 1;</code>
     *
     * @return The voyageId.
     */
    public long getVoyageId() {
      return voyageId_;
    }

    public static final int RESPONSESTATUS_FIELD_NUMBER = 2;
    private com.cpdss.common.generated.LoadableStudy.StatusReply responseStatus_;
    /**
     * <code>.StatusReply responseStatus = 2;</code>
     *
     * @return Whether the responseStatus field is set.
     */
    public boolean hasResponseStatus() {
      return responseStatus_ != null;
    }
    /**
     * <code>.StatusReply responseStatus = 2;</code>
     *
     * @return The responseStatus.
     */
    public com.cpdss.common.generated.LoadableStudy.StatusReply getResponseStatus() {
      return responseStatus_ == null
          ? com.cpdss.common.generated.LoadableStudy.StatusReply.getDefaultInstance()
          : responseStatus_;
    }
    /** <code>.StatusReply responseStatus = 2;</code> */
    public com.cpdss.common.generated.LoadableStudy.StatusReplyOrBuilder
        getResponseStatusOrBuilder() {
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
      if (voyageId_ != 0L) {
        output.writeInt64(1, voyageId_);
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
      if (voyageId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(1, voyageId_);
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
      if (!(obj instanceof com.cpdss.common.generated.LoadableStudy.VoyageReply)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.LoadableStudy.VoyageReply other =
          (com.cpdss.common.generated.LoadableStudy.VoyageReply) obj;

      if (getVoyageId() != other.getVoyageId()) return false;
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
      hash = (37 * hash) + VOYAGEID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getVoyageId());
      if (hasResponseStatus()) {
        hash = (37 * hash) + RESPONSESTATUS_FIELD_NUMBER;
        hash = (53 * hash) + getResponseStatus().hashCode();
      }
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
        voyageId_ = 0L;

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
        result.voyageId_ = voyageId_;
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
        if (other.getVoyageId() != 0L) {
          setVoyageId(other.getVoyageId());
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

      private long voyageId_;
      /**
       * <code>int64 voyageId = 1;</code>
       *
       * @return The voyageId.
       */
      public long getVoyageId() {
        return voyageId_;
      }
      /**
       * <code>int64 voyageId = 1;</code>
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
       * <code>int64 voyageId = 1;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearVoyageId() {

        voyageId_ = 0L;
        onChanged();
        return this;
      }

      private com.cpdss.common.generated.LoadableStudy.StatusReply responseStatus_;
      private com.google.protobuf.SingleFieldBuilderV3<
              com.cpdss.common.generated.LoadableStudy.StatusReply,
              com.cpdss.common.generated.LoadableStudy.StatusReply.Builder,
              com.cpdss.common.generated.LoadableStudy.StatusReplyOrBuilder>
          responseStatusBuilder_;
      /**
       * <code>.StatusReply responseStatus = 2;</code>
       *
       * @return Whether the responseStatus field is set.
       */
      public boolean hasResponseStatus() {
        return responseStatusBuilder_ != null || responseStatus_ != null;
      }
      /**
       * <code>.StatusReply responseStatus = 2;</code>
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
      /** <code>.StatusReply responseStatus = 2;</code> */
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
      /** <code>.StatusReply responseStatus = 2;</code> */
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
      /** <code>.StatusReply responseStatus = 2;</code> */
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
      /** <code>.StatusReply responseStatus = 2;</code> */
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
      /** <code>.StatusReply responseStatus = 2;</code> */
      public com.cpdss.common.generated.LoadableStudy.StatusReply.Builder
          getResponseStatusBuilder() {

        onChanged();
        return getResponseStatusFieldBuilder().getBuilder();
      }
      /** <code>.StatusReply responseStatus = 2;</code> */
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
      /** <code>.StatusReply responseStatus = 2;</code> */
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

  public interface VoyageDetailOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:VoyageDetail)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int64 id = 1;</code>
     *
     * @return The id.
     */
    long getId();

    /**
     * <code>string voyageNumber = 2;</code>
     *
     * @return The voyageNumber.
     */
    java.lang.String getVoyageNumber();
    /**
     * <code>string voyageNumber = 2;</code>
     *
     * @return The bytes for voyageNumber.
     */
    com.google.protobuf.ByteString getVoyageNumberBytes();
  }
  /** Protobuf type {@code VoyageDetail} */
  public static final class VoyageDetail extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:VoyageDetail)
      VoyageDetailOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use VoyageDetail.newBuilder() to construct.
    private VoyageDetail(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private VoyageDetail() {
      voyageNumber_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new VoyageDetail();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private VoyageDetail(
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

                voyageNumber_ = s;
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
      return com.cpdss.common.generated.LoadableStudy.internal_static_VoyageDetail_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.LoadableStudy
          .internal_static_VoyageDetail_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.LoadableStudy.VoyageDetail.class,
              com.cpdss.common.generated.LoadableStudy.VoyageDetail.Builder.class);
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

    public static final int VOYAGENUMBER_FIELD_NUMBER = 2;
    private volatile java.lang.Object voyageNumber_;
    /**
     * <code>string voyageNumber = 2;</code>
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
     * <code>string voyageNumber = 2;</code>
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
      if (!getVoyageNumberBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, voyageNumber_);
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
      if (!getVoyageNumberBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, voyageNumber_);
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
      if (!(obj instanceof com.cpdss.common.generated.LoadableStudy.VoyageDetail)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.LoadableStudy.VoyageDetail other =
          (com.cpdss.common.generated.LoadableStudy.VoyageDetail) obj;

      if (getId() != other.getId()) return false;
      if (!getVoyageNumber().equals(other.getVoyageNumber())) return false;
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
      hash = (37 * hash) + VOYAGENUMBER_FIELD_NUMBER;
      hash = (53 * hash) + getVoyageNumber().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.LoadableStudy.VoyageDetail parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.VoyageDetail parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.VoyageDetail parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.VoyageDetail parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.VoyageDetail parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.VoyageDetail parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.VoyageDetail parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.VoyageDetail parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.VoyageDetail parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.VoyageDetail parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.VoyageDetail parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.VoyageDetail parseFrom(
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
        com.cpdss.common.generated.LoadableStudy.VoyageDetail prototype) {
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
    /** Protobuf type {@code VoyageDetail} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:VoyageDetail)
        com.cpdss.common.generated.LoadableStudy.VoyageDetailOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.LoadableStudy.internal_static_VoyageDetail_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.LoadableStudy
            .internal_static_VoyageDetail_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.LoadableStudy.VoyageDetail.class,
                com.cpdss.common.generated.LoadableStudy.VoyageDetail.Builder.class);
      }

      // Construct using com.cpdss.common.generated.LoadableStudy.VoyageDetail.newBuilder()
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

        voyageNumber_ = "";

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.LoadableStudy.internal_static_VoyageDetail_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.VoyageDetail getDefaultInstanceForType() {
        return com.cpdss.common.generated.LoadableStudy.VoyageDetail.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.VoyageDetail build() {
        com.cpdss.common.generated.LoadableStudy.VoyageDetail result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.VoyageDetail buildPartial() {
        com.cpdss.common.generated.LoadableStudy.VoyageDetail result =
            new com.cpdss.common.generated.LoadableStudy.VoyageDetail(this);
        result.id_ = id_;
        result.voyageNumber_ = voyageNumber_;
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
        if (other instanceof com.cpdss.common.generated.LoadableStudy.VoyageDetail) {
          return mergeFrom((com.cpdss.common.generated.LoadableStudy.VoyageDetail) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.cpdss.common.generated.LoadableStudy.VoyageDetail other) {
        if (other == com.cpdss.common.generated.LoadableStudy.VoyageDetail.getDefaultInstance())
          return this;
        if (other.getId() != 0L) {
          setId(other.getId());
        }
        if (!other.getVoyageNumber().isEmpty()) {
          voyageNumber_ = other.voyageNumber_;
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
        com.cpdss.common.generated.LoadableStudy.VoyageDetail parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.LoadableStudy.VoyageDetail) e.getUnfinishedMessage();
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

      private java.lang.Object voyageNumber_ = "";
      /**
       * <code>string voyageNumber = 2;</code>
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
       * <code>string voyageNumber = 2;</code>
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
       * <code>string voyageNumber = 2;</code>
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
       * <code>string voyageNumber = 2;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearVoyageNumber() {

        voyageNumber_ = getDefaultInstance().getVoyageNumber();
        onChanged();
        return this;
      }
      /**
       * <code>string voyageNumber = 2;</code>
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

      // @@protoc_insertion_point(builder_scope:VoyageDetail)
    }

    // @@protoc_insertion_point(class_scope:VoyageDetail)
    private static final com.cpdss.common.generated.LoadableStudy.VoyageDetail DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.LoadableStudy.VoyageDetail();
    }

    public static com.cpdss.common.generated.LoadableStudy.VoyageDetail getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<VoyageDetail> PARSER =
        new com.google.protobuf.AbstractParser<VoyageDetail>() {
          @java.lang.Override
          public VoyageDetail parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new VoyageDetail(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<VoyageDetail> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<VoyageDetail> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.LoadableStudy.VoyageDetail getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface VoyageListReplyOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:VoyageListReply)
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

    /** <code>repeated .VoyageDetail voyages = 2;</code> */
    java.util.List<com.cpdss.common.generated.LoadableStudy.VoyageDetail> getVoyagesList();
    /** <code>repeated .VoyageDetail voyages = 2;</code> */
    com.cpdss.common.generated.LoadableStudy.VoyageDetail getVoyages(int index);
    /** <code>repeated .VoyageDetail voyages = 2;</code> */
    int getVoyagesCount();
    /** <code>repeated .VoyageDetail voyages = 2;</code> */
    java.util.List<? extends com.cpdss.common.generated.LoadableStudy.VoyageDetailOrBuilder>
        getVoyagesOrBuilderList();
    /** <code>repeated .VoyageDetail voyages = 2;</code> */
    com.cpdss.common.generated.LoadableStudy.VoyageDetailOrBuilder getVoyagesOrBuilder(int index);
  }
  /** Protobuf type {@code VoyageListReply} */
  public static final class VoyageListReply extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:VoyageListReply)
      VoyageListReplyOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use VoyageListReply.newBuilder() to construct.
    private VoyageListReply(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private VoyageListReply() {
      voyages_ = java.util.Collections.emptyList();
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new VoyageListReply();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private VoyageListReply(
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
                  voyages_ =
                      new java.util.ArrayList<
                          com.cpdss.common.generated.LoadableStudy.VoyageDetail>();
                  mutable_bitField0_ |= 0x00000001;
                }
                voyages_.add(
                    input.readMessage(
                        com.cpdss.common.generated.LoadableStudy.VoyageDetail.parser(),
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
          voyages_ = java.util.Collections.unmodifiableList(voyages_);
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }

    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.cpdss.common.generated.LoadableStudy.internal_static_VoyageListReply_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.LoadableStudy
          .internal_static_VoyageListReply_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.LoadableStudy.VoyageListReply.class,
              com.cpdss.common.generated.LoadableStudy.VoyageListReply.Builder.class);
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

    public static final int VOYAGES_FIELD_NUMBER = 2;
    private java.util.List<com.cpdss.common.generated.LoadableStudy.VoyageDetail> voyages_;
    /** <code>repeated .VoyageDetail voyages = 2;</code> */
    public java.util.List<com.cpdss.common.generated.LoadableStudy.VoyageDetail> getVoyagesList() {
      return voyages_;
    }
    /** <code>repeated .VoyageDetail voyages = 2;</code> */
    public java.util.List<? extends com.cpdss.common.generated.LoadableStudy.VoyageDetailOrBuilder>
        getVoyagesOrBuilderList() {
      return voyages_;
    }
    /** <code>repeated .VoyageDetail voyages = 2;</code> */
    public int getVoyagesCount() {
      return voyages_.size();
    }
    /** <code>repeated .VoyageDetail voyages = 2;</code> */
    public com.cpdss.common.generated.LoadableStudy.VoyageDetail getVoyages(int index) {
      return voyages_.get(index);
    }
    /** <code>repeated .VoyageDetail voyages = 2;</code> */
    public com.cpdss.common.generated.LoadableStudy.VoyageDetailOrBuilder getVoyagesOrBuilder(
        int index) {
      return voyages_.get(index);
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
      for (int i = 0; i < voyages_.size(); i++) {
        output.writeMessage(2, voyages_.get(i));
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
      for (int i = 0; i < voyages_.size(); i++) {
        size += com.google.protobuf.CodedOutputStream.computeMessageSize(2, voyages_.get(i));
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
      if (!(obj instanceof com.cpdss.common.generated.LoadableStudy.VoyageListReply)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.LoadableStudy.VoyageListReply other =
          (com.cpdss.common.generated.LoadableStudy.VoyageListReply) obj;

      if (hasResponseStatus() != other.hasResponseStatus()) return false;
      if (hasResponseStatus()) {
        if (!getResponseStatus().equals(other.getResponseStatus())) return false;
      }
      if (!getVoyagesList().equals(other.getVoyagesList())) return false;
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
      if (getVoyagesCount() > 0) {
        hash = (37 * hash) + VOYAGES_FIELD_NUMBER;
        hash = (53 * hash) + getVoyagesList().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.LoadableStudy.VoyageListReply parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.VoyageListReply parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.VoyageListReply parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.VoyageListReply parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.VoyageListReply parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.VoyageListReply parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.VoyageListReply parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.VoyageListReply parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.VoyageListReply parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.VoyageListReply parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.VoyageListReply parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.VoyageListReply parseFrom(
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
        com.cpdss.common.generated.LoadableStudy.VoyageListReply prototype) {
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
    /** Protobuf type {@code VoyageListReply} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:VoyageListReply)
        com.cpdss.common.generated.LoadableStudy.VoyageListReplyOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.LoadableStudy.internal_static_VoyageListReply_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.LoadableStudy
            .internal_static_VoyageListReply_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.LoadableStudy.VoyageListReply.class,
                com.cpdss.common.generated.LoadableStudy.VoyageListReply.Builder.class);
      }

      // Construct using com.cpdss.common.generated.LoadableStudy.VoyageListReply.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {
          getVoyagesFieldBuilder();
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
        if (voyagesBuilder_ == null) {
          voyages_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          voyagesBuilder_.clear();
        }
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.LoadableStudy.internal_static_VoyageListReply_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.VoyageListReply getDefaultInstanceForType() {
        return com.cpdss.common.generated.LoadableStudy.VoyageListReply.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.VoyageListReply build() {
        com.cpdss.common.generated.LoadableStudy.VoyageListReply result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.VoyageListReply buildPartial() {
        com.cpdss.common.generated.LoadableStudy.VoyageListReply result =
            new com.cpdss.common.generated.LoadableStudy.VoyageListReply(this);
        int from_bitField0_ = bitField0_;
        if (responseStatusBuilder_ == null) {
          result.responseStatus_ = responseStatus_;
        } else {
          result.responseStatus_ = responseStatusBuilder_.build();
        }
        if (voyagesBuilder_ == null) {
          if (((bitField0_ & 0x00000001) != 0)) {
            voyages_ = java.util.Collections.unmodifiableList(voyages_);
            bitField0_ = (bitField0_ & ~0x00000001);
          }
          result.voyages_ = voyages_;
        } else {
          result.voyages_ = voyagesBuilder_.build();
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
        if (other instanceof com.cpdss.common.generated.LoadableStudy.VoyageListReply) {
          return mergeFrom((com.cpdss.common.generated.LoadableStudy.VoyageListReply) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.cpdss.common.generated.LoadableStudy.VoyageListReply other) {
        if (other == com.cpdss.common.generated.LoadableStudy.VoyageListReply.getDefaultInstance())
          return this;
        if (other.hasResponseStatus()) {
          mergeResponseStatus(other.getResponseStatus());
        }
        if (voyagesBuilder_ == null) {
          if (!other.voyages_.isEmpty()) {
            if (voyages_.isEmpty()) {
              voyages_ = other.voyages_;
              bitField0_ = (bitField0_ & ~0x00000001);
            } else {
              ensureVoyagesIsMutable();
              voyages_.addAll(other.voyages_);
            }
            onChanged();
          }
        } else {
          if (!other.voyages_.isEmpty()) {
            if (voyagesBuilder_.isEmpty()) {
              voyagesBuilder_.dispose();
              voyagesBuilder_ = null;
              voyages_ = other.voyages_;
              bitField0_ = (bitField0_ & ~0x00000001);
              voyagesBuilder_ =
                  com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
                      ? getVoyagesFieldBuilder()
                      : null;
            } else {
              voyagesBuilder_.addAllMessages(other.voyages_);
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
        com.cpdss.common.generated.LoadableStudy.VoyageListReply parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.LoadableStudy.VoyageListReply) e.getUnfinishedMessage();
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

      private java.util.List<com.cpdss.common.generated.LoadableStudy.VoyageDetail> voyages_ =
          java.util.Collections.emptyList();

      private void ensureVoyagesIsMutable() {
        if (!((bitField0_ & 0x00000001) != 0)) {
          voyages_ =
              new java.util.ArrayList<com.cpdss.common.generated.LoadableStudy.VoyageDetail>(
                  voyages_);
          bitField0_ |= 0x00000001;
        }
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
              com.cpdss.common.generated.LoadableStudy.VoyageDetail,
              com.cpdss.common.generated.LoadableStudy.VoyageDetail.Builder,
              com.cpdss.common.generated.LoadableStudy.VoyageDetailOrBuilder>
          voyagesBuilder_;

      /** <code>repeated .VoyageDetail voyages = 2;</code> */
      public java.util.List<com.cpdss.common.generated.LoadableStudy.VoyageDetail>
          getVoyagesList() {
        if (voyagesBuilder_ == null) {
          return java.util.Collections.unmodifiableList(voyages_);
        } else {
          return voyagesBuilder_.getMessageList();
        }
      }
      /** <code>repeated .VoyageDetail voyages = 2;</code> */
      public int getVoyagesCount() {
        if (voyagesBuilder_ == null) {
          return voyages_.size();
        } else {
          return voyagesBuilder_.getCount();
        }
      }
      /** <code>repeated .VoyageDetail voyages = 2;</code> */
      public com.cpdss.common.generated.LoadableStudy.VoyageDetail getVoyages(int index) {
        if (voyagesBuilder_ == null) {
          return voyages_.get(index);
        } else {
          return voyagesBuilder_.getMessage(index);
        }
      }
      /** <code>repeated .VoyageDetail voyages = 2;</code> */
      public Builder setVoyages(
          int index, com.cpdss.common.generated.LoadableStudy.VoyageDetail value) {
        if (voyagesBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureVoyagesIsMutable();
          voyages_.set(index, value);
          onChanged();
        } else {
          voyagesBuilder_.setMessage(index, value);
        }
        return this;
      }
      /** <code>repeated .VoyageDetail voyages = 2;</code> */
      public Builder setVoyages(
          int index,
          com.cpdss.common.generated.LoadableStudy.VoyageDetail.Builder builderForValue) {
        if (voyagesBuilder_ == null) {
          ensureVoyagesIsMutable();
          voyages_.set(index, builderForValue.build());
          onChanged();
        } else {
          voyagesBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .VoyageDetail voyages = 2;</code> */
      public Builder addVoyages(com.cpdss.common.generated.LoadableStudy.VoyageDetail value) {
        if (voyagesBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureVoyagesIsMutable();
          voyages_.add(value);
          onChanged();
        } else {
          voyagesBuilder_.addMessage(value);
        }
        return this;
      }
      /** <code>repeated .VoyageDetail voyages = 2;</code> */
      public Builder addVoyages(
          int index, com.cpdss.common.generated.LoadableStudy.VoyageDetail value) {
        if (voyagesBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureVoyagesIsMutable();
          voyages_.add(index, value);
          onChanged();
        } else {
          voyagesBuilder_.addMessage(index, value);
        }
        return this;
      }
      /** <code>repeated .VoyageDetail voyages = 2;</code> */
      public Builder addVoyages(
          com.cpdss.common.generated.LoadableStudy.VoyageDetail.Builder builderForValue) {
        if (voyagesBuilder_ == null) {
          ensureVoyagesIsMutable();
          voyages_.add(builderForValue.build());
          onChanged();
        } else {
          voyagesBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .VoyageDetail voyages = 2;</code> */
      public Builder addVoyages(
          int index,
          com.cpdss.common.generated.LoadableStudy.VoyageDetail.Builder builderForValue) {
        if (voyagesBuilder_ == null) {
          ensureVoyagesIsMutable();
          voyages_.add(index, builderForValue.build());
          onChanged();
        } else {
          voyagesBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .VoyageDetail voyages = 2;</code> */
      public Builder addAllVoyages(
          java.lang.Iterable<? extends com.cpdss.common.generated.LoadableStudy.VoyageDetail>
              values) {
        if (voyagesBuilder_ == null) {
          ensureVoyagesIsMutable();
          com.google.protobuf.AbstractMessageLite.Builder.addAll(values, voyages_);
          onChanged();
        } else {
          voyagesBuilder_.addAllMessages(values);
        }
        return this;
      }
      /** <code>repeated .VoyageDetail voyages = 2;</code> */
      public Builder clearVoyages() {
        if (voyagesBuilder_ == null) {
          voyages_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
          onChanged();
        } else {
          voyagesBuilder_.clear();
        }
        return this;
      }
      /** <code>repeated .VoyageDetail voyages = 2;</code> */
      public Builder removeVoyages(int index) {
        if (voyagesBuilder_ == null) {
          ensureVoyagesIsMutable();
          voyages_.remove(index);
          onChanged();
        } else {
          voyagesBuilder_.remove(index);
        }
        return this;
      }
      /** <code>repeated .VoyageDetail voyages = 2;</code> */
      public com.cpdss.common.generated.LoadableStudy.VoyageDetail.Builder getVoyagesBuilder(
          int index) {
        return getVoyagesFieldBuilder().getBuilder(index);
      }
      /** <code>repeated .VoyageDetail voyages = 2;</code> */
      public com.cpdss.common.generated.LoadableStudy.VoyageDetailOrBuilder getVoyagesOrBuilder(
          int index) {
        if (voyagesBuilder_ == null) {
          return voyages_.get(index);
        } else {
          return voyagesBuilder_.getMessageOrBuilder(index);
        }
      }
      /** <code>repeated .VoyageDetail voyages = 2;</code> */
      public java.util.List<
              ? extends com.cpdss.common.generated.LoadableStudy.VoyageDetailOrBuilder>
          getVoyagesOrBuilderList() {
        if (voyagesBuilder_ != null) {
          return voyagesBuilder_.getMessageOrBuilderList();
        } else {
          return java.util.Collections.unmodifiableList(voyages_);
        }
      }
      /** <code>repeated .VoyageDetail voyages = 2;</code> */
      public com.cpdss.common.generated.LoadableStudy.VoyageDetail.Builder addVoyagesBuilder() {
        return getVoyagesFieldBuilder()
            .addBuilder(com.cpdss.common.generated.LoadableStudy.VoyageDetail.getDefaultInstance());
      }
      /** <code>repeated .VoyageDetail voyages = 2;</code> */
      public com.cpdss.common.generated.LoadableStudy.VoyageDetail.Builder addVoyagesBuilder(
          int index) {
        return getVoyagesFieldBuilder()
            .addBuilder(
                index, com.cpdss.common.generated.LoadableStudy.VoyageDetail.getDefaultInstance());
      }
      /** <code>repeated .VoyageDetail voyages = 2;</code> */
      public java.util.List<com.cpdss.common.generated.LoadableStudy.VoyageDetail.Builder>
          getVoyagesBuilderList() {
        return getVoyagesFieldBuilder().getBuilderList();
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
              com.cpdss.common.generated.LoadableStudy.VoyageDetail,
              com.cpdss.common.generated.LoadableStudy.VoyageDetail.Builder,
              com.cpdss.common.generated.LoadableStudy.VoyageDetailOrBuilder>
          getVoyagesFieldBuilder() {
        if (voyagesBuilder_ == null) {
          voyagesBuilder_ =
              new com.google.protobuf.RepeatedFieldBuilderV3<
                  com.cpdss.common.generated.LoadableStudy.VoyageDetail,
                  com.cpdss.common.generated.LoadableStudy.VoyageDetail.Builder,
                  com.cpdss.common.generated.LoadableStudy.VoyageDetailOrBuilder>(
                  voyages_, ((bitField0_ & 0x00000001) != 0), getParentForChildren(), isClean());
          voyages_ = null;
        }
        return voyagesBuilder_;
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

      // @@protoc_insertion_point(builder_scope:VoyageListReply)
    }

    // @@protoc_insertion_point(class_scope:VoyageListReply)
    private static final com.cpdss.common.generated.LoadableStudy.VoyageListReply DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.LoadableStudy.VoyageListReply();
    }

    public static com.cpdss.common.generated.LoadableStudy.VoyageListReply getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<VoyageListReply> PARSER =
        new com.google.protobuf.AbstractParser<VoyageListReply>() {
          @java.lang.Override
          public VoyageListReply parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new VoyageListReply(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<VoyageListReply> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<VoyageListReply> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.LoadableStudy.VoyageListReply getDefaultInstanceForType() {
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
     * <code>string code = 2;</code>
     *
     * @return The code.
     */
    java.lang.String getCode();
    /**
     * <code>string code = 2;</code>
     *
     * @return The bytes for code.
     */
    com.google.protobuf.ByteString getCodeBytes();

    /**
     * <code>string message = 3;</code>
     *
     * @return The message.
     */
    java.lang.String getMessage();
    /**
     * <code>string message = 3;</code>
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
      code_ = "";
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

                code_ = s;
                break;
              }
            case 26:
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

    public static final int CODE_FIELD_NUMBER = 2;
    private volatile java.lang.Object code_;
    /**
     * <code>string code = 2;</code>
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
     * <code>string code = 2;</code>
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

    public static final int MESSAGE_FIELD_NUMBER = 3;
    private volatile java.lang.Object message_;
    /**
     * <code>string message = 3;</code>
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
     * <code>string message = 3;</code>
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
      if (!getCodeBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, code_);
      }
      if (!getMessageBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, message_);
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
      if (!getCodeBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, code_);
      }
      if (!getMessageBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, message_);
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
      if (!getCode().equals(other.getCode())) return false;
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
      hash = (37 * hash) + CODE_FIELD_NUMBER;
      hash = (53 * hash) + getCode().hashCode();
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

        code_ = "";

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
        result.code_ = code_;
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
        if (!other.getCode().isEmpty()) {
          code_ = other.code_;
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

      private java.lang.Object code_ = "";
      /**
       * <code>string code = 2;</code>
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
       * <code>string code = 2;</code>
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
       * <code>string code = 2;</code>
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
       * <code>string code = 2;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearCode() {

        code_ = getDefaultInstance().getCode();
        onChanged();
        return this;
      }
      /**
       * <code>string code = 2;</code>
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

      private java.lang.Object message_ = "";
      /**
       * <code>string message = 3;</code>
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
       * <code>string message = 3;</code>
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
       * <code>string message = 3;</code>
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
       * <code>string message = 3;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearMessage() {

        message_ = getDefaultInstance().getMessage();
        onChanged();
        return this;
      }
      /**
       * <code>string message = 3;</code>
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

  public interface LoadableQuantityRequestOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:LoadableQuantityRequest)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>string limitingDraft = 1;</code>
     *
     * @return The limitingDraft.
     */
    java.lang.String getLimitingDraft();
    /**
     * <code>string limitingDraft = 1;</code>
     *
     * @return The bytes for limitingDraft.
     */
    com.google.protobuf.ByteString getLimitingDraftBytes();

    /**
     * <code>string estSeaDensity = 2;</code>
     *
     * @return The estSeaDensity.
     */
    java.lang.String getEstSeaDensity();
    /**
     * <code>string estSeaDensity = 2;</code>
     *
     * @return The bytes for estSeaDensity.
     */
    com.google.protobuf.ByteString getEstSeaDensityBytes();

    /**
     * <code>string tpc = 3;</code>
     *
     * @return The tpc.
     */
    java.lang.String getTpc();
    /**
     * <code>string tpc = 3;</code>
     *
     * @return The bytes for tpc.
     */
    com.google.protobuf.ByteString getTpcBytes();

    /**
     * <code>string estSagging = 4;</code>
     *
     * @return The estSagging.
     */
    java.lang.String getEstSagging();
    /**
     * <code>string estSagging = 4;</code>
     *
     * @return The bytes for estSagging.
     */
    com.google.protobuf.ByteString getEstSaggingBytes();

    /**
     * <code>string displacmentDraftRestriction = 5;</code>
     *
     * @return The displacmentDraftRestriction.
     */
    java.lang.String getDisplacmentDraftRestriction();
    /**
     * <code>string displacmentDraftRestriction = 5;</code>
     *
     * @return The bytes for displacmentDraftRestriction.
     */
    com.google.protobuf.ByteString getDisplacmentDraftRestrictionBytes();

    /**
     * <code>string vesselLightWeight = 6;</code>
     *
     * @return The vesselLightWeight.
     */
    java.lang.String getVesselLightWeight();
    /**
     * <code>string vesselLightWeight = 6;</code>
     *
     * @return The bytes for vesselLightWeight.
     */
    com.google.protobuf.ByteString getVesselLightWeightBytes();

    /**
     * <code>string dwt = 7;</code>
     *
     * @return The dwt.
     */
    java.lang.String getDwt();
    /**
     * <code>string dwt = 7;</code>
     *
     * @return The bytes for dwt.
     */
    com.google.protobuf.ByteString getDwtBytes();

    /**
     * <code>string sgCorrection = 8;</code>
     *
     * @return The sgCorrection.
     */
    java.lang.String getSgCorrection();
    /**
     * <code>string sgCorrection = 8;</code>
     *
     * @return The bytes for sgCorrection.
     */
    com.google.protobuf.ByteString getSgCorrectionBytes();

    /**
     * <code>string saggingDeduction = 9;</code>
     *
     * @return The saggingDeduction.
     */
    java.lang.String getSaggingDeduction();
    /**
     * <code>string saggingDeduction = 9;</code>
     *
     * @return The bytes for saggingDeduction.
     */
    com.google.protobuf.ByteString getSaggingDeductionBytes();

    /**
     * <code>string estFOOnBoard = 10;</code>
     *
     * @return The estFOOnBoard.
     */
    java.lang.String getEstFOOnBoard();
    /**
     * <code>string estFOOnBoard = 10;</code>
     *
     * @return The bytes for estFOOnBoard.
     */
    com.google.protobuf.ByteString getEstFOOnBoardBytes();

    /**
     * <code>string estDOOnBoard = 11;</code>
     *
     * @return The estDOOnBoard.
     */
    java.lang.String getEstDOOnBoard();
    /**
     * <code>string estDOOnBoard = 11;</code>
     *
     * @return The bytes for estDOOnBoard.
     */
    com.google.protobuf.ByteString getEstDOOnBoardBytes();

    /**
     * <code>string estFreshWaterOnBoard = 12;</code>
     *
     * @return The estFreshWaterOnBoard.
     */
    java.lang.String getEstFreshWaterOnBoard();
    /**
     * <code>string estFreshWaterOnBoard = 12;</code>
     *
     * @return The bytes for estFreshWaterOnBoard.
     */
    com.google.protobuf.ByteString getEstFreshWaterOnBoardBytes();

    /**
     * <code>string constant = 13;</code>
     *
     * @return The constant.
     */
    java.lang.String getConstant();
    /**
     * <code>string constant = 13;</code>
     *
     * @return The bytes for constant.
     */
    com.google.protobuf.ByteString getConstantBytes();

    /**
     * <code>string otherIfAny = 14;</code>
     *
     * @return The otherIfAny.
     */
    java.lang.String getOtherIfAny();
    /**
     * <code>string otherIfAny = 14;</code>
     *
     * @return The bytes for otherIfAny.
     */
    com.google.protobuf.ByteString getOtherIfAnyBytes();

    /**
     * <code>string totalQuantity = 15;</code>
     *
     * @return The totalQuantity.
     */
    java.lang.String getTotalQuantity();
    /**
     * <code>string totalQuantity = 15;</code>
     *
     * @return The bytes for totalQuantity.
     */
    com.google.protobuf.ByteString getTotalQuantityBytes();

    /**
     * <code>string distanceFromLastPort = 16;</code>
     *
     * @return The distanceFromLastPort.
     */
    java.lang.String getDistanceFromLastPort();
    /**
     * <code>string distanceFromLastPort = 16;</code>
     *
     * @return The bytes for distanceFromLastPort.
     */
    com.google.protobuf.ByteString getDistanceFromLastPortBytes();

    /**
     * <code>string vesselAverageSpeed = 17;</code>
     *
     * @return The vesselAverageSpeed.
     */
    java.lang.String getVesselAverageSpeed();
    /**
     * <code>string vesselAverageSpeed = 17;</code>
     *
     * @return The bytes for vesselAverageSpeed.
     */
    com.google.protobuf.ByteString getVesselAverageSpeedBytes();

    /**
     * <code>string foConsumptionPerDay = 18;</code>
     *
     * @return The foConsumptionPerDay.
     */
    java.lang.String getFoConsumptionPerDay();
    /**
     * <code>string foConsumptionPerDay = 18;</code>
     *
     * @return The bytes for foConsumptionPerDay.
     */
    com.google.protobuf.ByteString getFoConsumptionPerDayBytes();

    /**
     * <code>string estTotalFOConsumption = 19;</code>
     *
     * @return The estTotalFOConsumption.
     */
    java.lang.String getEstTotalFOConsumption();
    /**
     * <code>string estTotalFOConsumption = 19;</code>
     *
     * @return The bytes for estTotalFOConsumption.
     */
    com.google.protobuf.ByteString getEstTotalFOConsumptionBytes();

    /**
     * <code>int64 loadableStudyId = 20;</code>
     *
     * @return The loadableStudyId.
     */
    long getLoadableStudyId();

    /**
     * <code>string updateDateAndTime = 21;</code>
     *
     * @return The updateDateAndTime.
     */
    java.lang.String getUpdateDateAndTime();
    /**
     * <code>string updateDateAndTime = 21;</code>
     *
     * @return The bytes for updateDateAndTime.
     */
    com.google.protobuf.ByteString getUpdateDateAndTimeBytes();
  }
  /** Protobuf type {@code LoadableQuantityRequest} */
  public static final class LoadableQuantityRequest extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:LoadableQuantityRequest)
      LoadableQuantityRequestOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use LoadableQuantityRequest.newBuilder() to construct.
    private LoadableQuantityRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private LoadableQuantityRequest() {
      limitingDraft_ = "";
      estSeaDensity_ = "";
      tpc_ = "";
      estSagging_ = "";
      displacmentDraftRestriction_ = "";
      vesselLightWeight_ = "";
      dwt_ = "";
      sgCorrection_ = "";
      saggingDeduction_ = "";
      estFOOnBoard_ = "";
      estDOOnBoard_ = "";
      estFreshWaterOnBoard_ = "";
      constant_ = "";
      otherIfAny_ = "";
      totalQuantity_ = "";
      distanceFromLastPort_ = "";
      vesselAverageSpeed_ = "";
      foConsumptionPerDay_ = "";
      estTotalFOConsumption_ = "";
      updateDateAndTime_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new LoadableQuantityRequest();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private LoadableQuantityRequest(
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

                limitingDraft_ = s;
                break;
              }
            case 18:
              {
                java.lang.String s = input.readStringRequireUtf8();

                estSeaDensity_ = s;
                break;
              }
            case 26:
              {
                java.lang.String s = input.readStringRequireUtf8();

                tpc_ = s;
                break;
              }
            case 34:
              {
                java.lang.String s = input.readStringRequireUtf8();

                estSagging_ = s;
                break;
              }
            case 42:
              {
                java.lang.String s = input.readStringRequireUtf8();

                displacmentDraftRestriction_ = s;
                break;
              }
            case 50:
              {
                java.lang.String s = input.readStringRequireUtf8();

                vesselLightWeight_ = s;
                break;
              }
            case 58:
              {
                java.lang.String s = input.readStringRequireUtf8();

                dwt_ = s;
                break;
              }
            case 66:
              {
                java.lang.String s = input.readStringRequireUtf8();

                sgCorrection_ = s;
                break;
              }
            case 74:
              {
                java.lang.String s = input.readStringRequireUtf8();

                saggingDeduction_ = s;
                break;
              }
            case 82:
              {
                java.lang.String s = input.readStringRequireUtf8();

                estFOOnBoard_ = s;
                break;
              }
            case 90:
              {
                java.lang.String s = input.readStringRequireUtf8();

                estDOOnBoard_ = s;
                break;
              }
            case 98:
              {
                java.lang.String s = input.readStringRequireUtf8();

                estFreshWaterOnBoard_ = s;
                break;
              }
            case 106:
              {
                java.lang.String s = input.readStringRequireUtf8();

                constant_ = s;
                break;
              }
            case 114:
              {
                java.lang.String s = input.readStringRequireUtf8();

                otherIfAny_ = s;
                break;
              }
            case 122:
              {
                java.lang.String s = input.readStringRequireUtf8();

                totalQuantity_ = s;
                break;
              }
            case 130:
              {
                java.lang.String s = input.readStringRequireUtf8();

                distanceFromLastPort_ = s;
                break;
              }
            case 138:
              {
                java.lang.String s = input.readStringRequireUtf8();

                vesselAverageSpeed_ = s;
                break;
              }
            case 146:
              {
                java.lang.String s = input.readStringRequireUtf8();

                foConsumptionPerDay_ = s;
                break;
              }
            case 154:
              {
                java.lang.String s = input.readStringRequireUtf8();

                estTotalFOConsumption_ = s;
                break;
              }
            case 160:
              {
                loadableStudyId_ = input.readInt64();
                break;
              }
            case 170:
              {
                java.lang.String s = input.readStringRequireUtf8();

                updateDateAndTime_ = s;
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
          .internal_static_LoadableQuantityRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.LoadableStudy
          .internal_static_LoadableQuantityRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest.class,
              com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest.Builder.class);
    }

    public static final int LIMITINGDRAFT_FIELD_NUMBER = 1;
    private volatile java.lang.Object limitingDraft_;
    /**
     * <code>string limitingDraft = 1;</code>
     *
     * @return The limitingDraft.
     */
    public java.lang.String getLimitingDraft() {
      java.lang.Object ref = limitingDraft_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        limitingDraft_ = s;
        return s;
      }
    }
    /**
     * <code>string limitingDraft = 1;</code>
     *
     * @return The bytes for limitingDraft.
     */
    public com.google.protobuf.ByteString getLimitingDraftBytes() {
      java.lang.Object ref = limitingDraft_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        limitingDraft_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int ESTSEADENSITY_FIELD_NUMBER = 2;
    private volatile java.lang.Object estSeaDensity_;
    /**
     * <code>string estSeaDensity = 2;</code>
     *
     * @return The estSeaDensity.
     */
    public java.lang.String getEstSeaDensity() {
      java.lang.Object ref = estSeaDensity_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        estSeaDensity_ = s;
        return s;
      }
    }
    /**
     * <code>string estSeaDensity = 2;</code>
     *
     * @return The bytes for estSeaDensity.
     */
    public com.google.protobuf.ByteString getEstSeaDensityBytes() {
      java.lang.Object ref = estSeaDensity_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        estSeaDensity_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int TPC_FIELD_NUMBER = 3;
    private volatile java.lang.Object tpc_;
    /**
     * <code>string tpc = 3;</code>
     *
     * @return The tpc.
     */
    public java.lang.String getTpc() {
      java.lang.Object ref = tpc_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        tpc_ = s;
        return s;
      }
    }
    /**
     * <code>string tpc = 3;</code>
     *
     * @return The bytes for tpc.
     */
    public com.google.protobuf.ByteString getTpcBytes() {
      java.lang.Object ref = tpc_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        tpc_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int ESTSAGGING_FIELD_NUMBER = 4;
    private volatile java.lang.Object estSagging_;
    /**
     * <code>string estSagging = 4;</code>
     *
     * @return The estSagging.
     */
    public java.lang.String getEstSagging() {
      java.lang.Object ref = estSagging_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        estSagging_ = s;
        return s;
      }
    }
    /**
     * <code>string estSagging = 4;</code>
     *
     * @return The bytes for estSagging.
     */
    public com.google.protobuf.ByteString getEstSaggingBytes() {
      java.lang.Object ref = estSagging_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        estSagging_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int DISPLACMENTDRAFTRESTRICTION_FIELD_NUMBER = 5;
    private volatile java.lang.Object displacmentDraftRestriction_;
    /**
     * <code>string displacmentDraftRestriction = 5;</code>
     *
     * @return The displacmentDraftRestriction.
     */
    public java.lang.String getDisplacmentDraftRestriction() {
      java.lang.Object ref = displacmentDraftRestriction_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        displacmentDraftRestriction_ = s;
        return s;
      }
    }
    /**
     * <code>string displacmentDraftRestriction = 5;</code>
     *
     * @return The bytes for displacmentDraftRestriction.
     */
    public com.google.protobuf.ByteString getDisplacmentDraftRestrictionBytes() {
      java.lang.Object ref = displacmentDraftRestriction_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        displacmentDraftRestriction_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int VESSELLIGHTWEIGHT_FIELD_NUMBER = 6;
    private volatile java.lang.Object vesselLightWeight_;
    /**
     * <code>string vesselLightWeight = 6;</code>
     *
     * @return The vesselLightWeight.
     */
    public java.lang.String getVesselLightWeight() {
      java.lang.Object ref = vesselLightWeight_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        vesselLightWeight_ = s;
        return s;
      }
    }
    /**
     * <code>string vesselLightWeight = 6;</code>
     *
     * @return The bytes for vesselLightWeight.
     */
    public com.google.protobuf.ByteString getVesselLightWeightBytes() {
      java.lang.Object ref = vesselLightWeight_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        vesselLightWeight_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int DWT_FIELD_NUMBER = 7;
    private volatile java.lang.Object dwt_;
    /**
     * <code>string dwt = 7;</code>
     *
     * @return The dwt.
     */
    public java.lang.String getDwt() {
      java.lang.Object ref = dwt_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        dwt_ = s;
        return s;
      }
    }
    /**
     * <code>string dwt = 7;</code>
     *
     * @return The bytes for dwt.
     */
    public com.google.protobuf.ByteString getDwtBytes() {
      java.lang.Object ref = dwt_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        dwt_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int SGCORRECTION_FIELD_NUMBER = 8;
    private volatile java.lang.Object sgCorrection_;
    /**
     * <code>string sgCorrection = 8;</code>
     *
     * @return The sgCorrection.
     */
    public java.lang.String getSgCorrection() {
      java.lang.Object ref = sgCorrection_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        sgCorrection_ = s;
        return s;
      }
    }
    /**
     * <code>string sgCorrection = 8;</code>
     *
     * @return The bytes for sgCorrection.
     */
    public com.google.protobuf.ByteString getSgCorrectionBytes() {
      java.lang.Object ref = sgCorrection_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        sgCorrection_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int SAGGINGDEDUCTION_FIELD_NUMBER = 9;
    private volatile java.lang.Object saggingDeduction_;
    /**
     * <code>string saggingDeduction = 9;</code>
     *
     * @return The saggingDeduction.
     */
    public java.lang.String getSaggingDeduction() {
      java.lang.Object ref = saggingDeduction_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        saggingDeduction_ = s;
        return s;
      }
    }
    /**
     * <code>string saggingDeduction = 9;</code>
     *
     * @return The bytes for saggingDeduction.
     */
    public com.google.protobuf.ByteString getSaggingDeductionBytes() {
      java.lang.Object ref = saggingDeduction_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        saggingDeduction_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int ESTFOONBOARD_FIELD_NUMBER = 10;
    private volatile java.lang.Object estFOOnBoard_;
    /**
     * <code>string estFOOnBoard = 10;</code>
     *
     * @return The estFOOnBoard.
     */
    public java.lang.String getEstFOOnBoard() {
      java.lang.Object ref = estFOOnBoard_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        estFOOnBoard_ = s;
        return s;
      }
    }
    /**
     * <code>string estFOOnBoard = 10;</code>
     *
     * @return The bytes for estFOOnBoard.
     */
    public com.google.protobuf.ByteString getEstFOOnBoardBytes() {
      java.lang.Object ref = estFOOnBoard_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        estFOOnBoard_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int ESTDOONBOARD_FIELD_NUMBER = 11;
    private volatile java.lang.Object estDOOnBoard_;
    /**
     * <code>string estDOOnBoard = 11;</code>
     *
     * @return The estDOOnBoard.
     */
    public java.lang.String getEstDOOnBoard() {
      java.lang.Object ref = estDOOnBoard_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        estDOOnBoard_ = s;
        return s;
      }
    }
    /**
     * <code>string estDOOnBoard = 11;</code>
     *
     * @return The bytes for estDOOnBoard.
     */
    public com.google.protobuf.ByteString getEstDOOnBoardBytes() {
      java.lang.Object ref = estDOOnBoard_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        estDOOnBoard_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int ESTFRESHWATERONBOARD_FIELD_NUMBER = 12;
    private volatile java.lang.Object estFreshWaterOnBoard_;
    /**
     * <code>string estFreshWaterOnBoard = 12;</code>
     *
     * @return The estFreshWaterOnBoard.
     */
    public java.lang.String getEstFreshWaterOnBoard() {
      java.lang.Object ref = estFreshWaterOnBoard_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        estFreshWaterOnBoard_ = s;
        return s;
      }
    }
    /**
     * <code>string estFreshWaterOnBoard = 12;</code>
     *
     * @return The bytes for estFreshWaterOnBoard.
     */
    public com.google.protobuf.ByteString getEstFreshWaterOnBoardBytes() {
      java.lang.Object ref = estFreshWaterOnBoard_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        estFreshWaterOnBoard_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int CONSTANT_FIELD_NUMBER = 13;
    private volatile java.lang.Object constant_;
    /**
     * <code>string constant = 13;</code>
     *
     * @return The constant.
     */
    public java.lang.String getConstant() {
      java.lang.Object ref = constant_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        constant_ = s;
        return s;
      }
    }
    /**
     * <code>string constant = 13;</code>
     *
     * @return The bytes for constant.
     */
    public com.google.protobuf.ByteString getConstantBytes() {
      java.lang.Object ref = constant_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        constant_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int OTHERIFANY_FIELD_NUMBER = 14;
    private volatile java.lang.Object otherIfAny_;
    /**
     * <code>string otherIfAny = 14;</code>
     *
     * @return The otherIfAny.
     */
    public java.lang.String getOtherIfAny() {
      java.lang.Object ref = otherIfAny_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        otherIfAny_ = s;
        return s;
      }
    }
    /**
     * <code>string otherIfAny = 14;</code>
     *
     * @return The bytes for otherIfAny.
     */
    public com.google.protobuf.ByteString getOtherIfAnyBytes() {
      java.lang.Object ref = otherIfAny_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        otherIfAny_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int TOTALQUANTITY_FIELD_NUMBER = 15;
    private volatile java.lang.Object totalQuantity_;
    /**
     * <code>string totalQuantity = 15;</code>
     *
     * @return The totalQuantity.
     */
    public java.lang.String getTotalQuantity() {
      java.lang.Object ref = totalQuantity_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        totalQuantity_ = s;
        return s;
      }
    }
    /**
     * <code>string totalQuantity = 15;</code>
     *
     * @return The bytes for totalQuantity.
     */
    public com.google.protobuf.ByteString getTotalQuantityBytes() {
      java.lang.Object ref = totalQuantity_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        totalQuantity_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int DISTANCEFROMLASTPORT_FIELD_NUMBER = 16;
    private volatile java.lang.Object distanceFromLastPort_;
    /**
     * <code>string distanceFromLastPort = 16;</code>
     *
     * @return The distanceFromLastPort.
     */
    public java.lang.String getDistanceFromLastPort() {
      java.lang.Object ref = distanceFromLastPort_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        distanceFromLastPort_ = s;
        return s;
      }
    }
    /**
     * <code>string distanceFromLastPort = 16;</code>
     *
     * @return The bytes for distanceFromLastPort.
     */
    public com.google.protobuf.ByteString getDistanceFromLastPortBytes() {
      java.lang.Object ref = distanceFromLastPort_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        distanceFromLastPort_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int VESSELAVERAGESPEED_FIELD_NUMBER = 17;
    private volatile java.lang.Object vesselAverageSpeed_;
    /**
     * <code>string vesselAverageSpeed = 17;</code>
     *
     * @return The vesselAverageSpeed.
     */
    public java.lang.String getVesselAverageSpeed() {
      java.lang.Object ref = vesselAverageSpeed_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        vesselAverageSpeed_ = s;
        return s;
      }
    }
    /**
     * <code>string vesselAverageSpeed = 17;</code>
     *
     * @return The bytes for vesselAverageSpeed.
     */
    public com.google.protobuf.ByteString getVesselAverageSpeedBytes() {
      java.lang.Object ref = vesselAverageSpeed_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        vesselAverageSpeed_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int FOCONSUMPTIONPERDAY_FIELD_NUMBER = 18;
    private volatile java.lang.Object foConsumptionPerDay_;
    /**
     * <code>string foConsumptionPerDay = 18;</code>
     *
     * @return The foConsumptionPerDay.
     */
    public java.lang.String getFoConsumptionPerDay() {
      java.lang.Object ref = foConsumptionPerDay_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        foConsumptionPerDay_ = s;
        return s;
      }
    }
    /**
     * <code>string foConsumptionPerDay = 18;</code>
     *
     * @return The bytes for foConsumptionPerDay.
     */
    public com.google.protobuf.ByteString getFoConsumptionPerDayBytes() {
      java.lang.Object ref = foConsumptionPerDay_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        foConsumptionPerDay_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int ESTTOTALFOCONSUMPTION_FIELD_NUMBER = 19;
    private volatile java.lang.Object estTotalFOConsumption_;
    /**
     * <code>string estTotalFOConsumption = 19;</code>
     *
     * @return The estTotalFOConsumption.
     */
    public java.lang.String getEstTotalFOConsumption() {
      java.lang.Object ref = estTotalFOConsumption_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        estTotalFOConsumption_ = s;
        return s;
      }
    }
    /**
     * <code>string estTotalFOConsumption = 19;</code>
     *
     * @return The bytes for estTotalFOConsumption.
     */
    public com.google.protobuf.ByteString getEstTotalFOConsumptionBytes() {
      java.lang.Object ref = estTotalFOConsumption_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        estTotalFOConsumption_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int LOADABLESTUDYID_FIELD_NUMBER = 20;
    private long loadableStudyId_;
    /**
     * <code>int64 loadableStudyId = 20;</code>
     *
     * @return The loadableStudyId.
     */
    public long getLoadableStudyId() {
      return loadableStudyId_;
    }

    public static final int UPDATEDATEANDTIME_FIELD_NUMBER = 21;
    private volatile java.lang.Object updateDateAndTime_;
    /**
     * <code>string updateDateAndTime = 21;</code>
     *
     * @return The updateDateAndTime.
     */
    public java.lang.String getUpdateDateAndTime() {
      java.lang.Object ref = updateDateAndTime_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        updateDateAndTime_ = s;
        return s;
      }
    }
    /**
     * <code>string updateDateAndTime = 21;</code>
     *
     * @return The bytes for updateDateAndTime.
     */
    public com.google.protobuf.ByteString getUpdateDateAndTimeBytes() {
      java.lang.Object ref = updateDateAndTime_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        updateDateAndTime_ = b;
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
      if (!getLimitingDraftBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, limitingDraft_);
      }
      if (!getEstSeaDensityBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, estSeaDensity_);
      }
      if (!getTpcBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, tpc_);
      }
      if (!getEstSaggingBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 4, estSagging_);
      }
      if (!getDisplacmentDraftRestrictionBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 5, displacmentDraftRestriction_);
      }
      if (!getVesselLightWeightBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 6, vesselLightWeight_);
      }
      if (!getDwtBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 7, dwt_);
      }
      if (!getSgCorrectionBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 8, sgCorrection_);
      }
      if (!getSaggingDeductionBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 9, saggingDeduction_);
      }
      if (!getEstFOOnBoardBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 10, estFOOnBoard_);
      }
      if (!getEstDOOnBoardBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 11, estDOOnBoard_);
      }
      if (!getEstFreshWaterOnBoardBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 12, estFreshWaterOnBoard_);
      }
      if (!getConstantBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 13, constant_);
      }
      if (!getOtherIfAnyBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 14, otherIfAny_);
      }
      if (!getTotalQuantityBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 15, totalQuantity_);
      }
      if (!getDistanceFromLastPortBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 16, distanceFromLastPort_);
      }
      if (!getVesselAverageSpeedBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 17, vesselAverageSpeed_);
      }
      if (!getFoConsumptionPerDayBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 18, foConsumptionPerDay_);
      }
      if (!getEstTotalFOConsumptionBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 19, estTotalFOConsumption_);
      }
      if (loadableStudyId_ != 0L) {
        output.writeInt64(20, loadableStudyId_);
      }
      if (!getUpdateDateAndTimeBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 21, updateDateAndTime_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getLimitingDraftBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, limitingDraft_);
      }
      if (!getEstSeaDensityBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, estSeaDensity_);
      }
      if (!getTpcBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, tpc_);
      }
      if (!getEstSaggingBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, estSagging_);
      }
      if (!getDisplacmentDraftRestrictionBytes().isEmpty()) {
        size +=
            com.google.protobuf.GeneratedMessageV3.computeStringSize(
                5, displacmentDraftRestriction_);
      }
      if (!getVesselLightWeightBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(6, vesselLightWeight_);
      }
      if (!getDwtBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(7, dwt_);
      }
      if (!getSgCorrectionBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(8, sgCorrection_);
      }
      if (!getSaggingDeductionBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(9, saggingDeduction_);
      }
      if (!getEstFOOnBoardBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(10, estFOOnBoard_);
      }
      if (!getEstDOOnBoardBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(11, estDOOnBoard_);
      }
      if (!getEstFreshWaterOnBoardBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(12, estFreshWaterOnBoard_);
      }
      if (!getConstantBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(13, constant_);
      }
      if (!getOtherIfAnyBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(14, otherIfAny_);
      }
      if (!getTotalQuantityBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(15, totalQuantity_);
      }
      if (!getDistanceFromLastPortBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(16, distanceFromLastPort_);
      }
      if (!getVesselAverageSpeedBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(17, vesselAverageSpeed_);
      }
      if (!getFoConsumptionPerDayBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(18, foConsumptionPerDay_);
      }
      if (!getEstTotalFOConsumptionBytes().isEmpty()) {
        size +=
            com.google.protobuf.GeneratedMessageV3.computeStringSize(19, estTotalFOConsumption_);
      }
      if (loadableStudyId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(20, loadableStudyId_);
      }
      if (!getUpdateDateAndTimeBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(21, updateDateAndTime_);
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
      if (!(obj instanceof com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest other =
          (com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest) obj;

      if (!getLimitingDraft().equals(other.getLimitingDraft())) return false;
      if (!getEstSeaDensity().equals(other.getEstSeaDensity())) return false;
      if (!getTpc().equals(other.getTpc())) return false;
      if (!getEstSagging().equals(other.getEstSagging())) return false;
      if (!getDisplacmentDraftRestriction().equals(other.getDisplacmentDraftRestriction()))
        return false;
      if (!getVesselLightWeight().equals(other.getVesselLightWeight())) return false;
      if (!getDwt().equals(other.getDwt())) return false;
      if (!getSgCorrection().equals(other.getSgCorrection())) return false;
      if (!getSaggingDeduction().equals(other.getSaggingDeduction())) return false;
      if (!getEstFOOnBoard().equals(other.getEstFOOnBoard())) return false;
      if (!getEstDOOnBoard().equals(other.getEstDOOnBoard())) return false;
      if (!getEstFreshWaterOnBoard().equals(other.getEstFreshWaterOnBoard())) return false;
      if (!getConstant().equals(other.getConstant())) return false;
      if (!getOtherIfAny().equals(other.getOtherIfAny())) return false;
      if (!getTotalQuantity().equals(other.getTotalQuantity())) return false;
      if (!getDistanceFromLastPort().equals(other.getDistanceFromLastPort())) return false;
      if (!getVesselAverageSpeed().equals(other.getVesselAverageSpeed())) return false;
      if (!getFoConsumptionPerDay().equals(other.getFoConsumptionPerDay())) return false;
      if (!getEstTotalFOConsumption().equals(other.getEstTotalFOConsumption())) return false;
      if (getLoadableStudyId() != other.getLoadableStudyId()) return false;
      if (!getUpdateDateAndTime().equals(other.getUpdateDateAndTime())) return false;
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
      hash = (37 * hash) + LIMITINGDRAFT_FIELD_NUMBER;
      hash = (53 * hash) + getLimitingDraft().hashCode();
      hash = (37 * hash) + ESTSEADENSITY_FIELD_NUMBER;
      hash = (53 * hash) + getEstSeaDensity().hashCode();
      hash = (37 * hash) + TPC_FIELD_NUMBER;
      hash = (53 * hash) + getTpc().hashCode();
      hash = (37 * hash) + ESTSAGGING_FIELD_NUMBER;
      hash = (53 * hash) + getEstSagging().hashCode();
      hash = (37 * hash) + DISPLACMENTDRAFTRESTRICTION_FIELD_NUMBER;
      hash = (53 * hash) + getDisplacmentDraftRestriction().hashCode();
      hash = (37 * hash) + VESSELLIGHTWEIGHT_FIELD_NUMBER;
      hash = (53 * hash) + getVesselLightWeight().hashCode();
      hash = (37 * hash) + DWT_FIELD_NUMBER;
      hash = (53 * hash) + getDwt().hashCode();
      hash = (37 * hash) + SGCORRECTION_FIELD_NUMBER;
      hash = (53 * hash) + getSgCorrection().hashCode();
      hash = (37 * hash) + SAGGINGDEDUCTION_FIELD_NUMBER;
      hash = (53 * hash) + getSaggingDeduction().hashCode();
      hash = (37 * hash) + ESTFOONBOARD_FIELD_NUMBER;
      hash = (53 * hash) + getEstFOOnBoard().hashCode();
      hash = (37 * hash) + ESTDOONBOARD_FIELD_NUMBER;
      hash = (53 * hash) + getEstDOOnBoard().hashCode();
      hash = (37 * hash) + ESTFRESHWATERONBOARD_FIELD_NUMBER;
      hash = (53 * hash) + getEstFreshWaterOnBoard().hashCode();
      hash = (37 * hash) + CONSTANT_FIELD_NUMBER;
      hash = (53 * hash) + getConstant().hashCode();
      hash = (37 * hash) + OTHERIFANY_FIELD_NUMBER;
      hash = (53 * hash) + getOtherIfAny().hashCode();
      hash = (37 * hash) + TOTALQUANTITY_FIELD_NUMBER;
      hash = (53 * hash) + getTotalQuantity().hashCode();
      hash = (37 * hash) + DISTANCEFROMLASTPORT_FIELD_NUMBER;
      hash = (53 * hash) + getDistanceFromLastPort().hashCode();
      hash = (37 * hash) + VESSELAVERAGESPEED_FIELD_NUMBER;
      hash = (53 * hash) + getVesselAverageSpeed().hashCode();
      hash = (37 * hash) + FOCONSUMPTIONPERDAY_FIELD_NUMBER;
      hash = (53 * hash) + getFoConsumptionPerDay().hashCode();
      hash = (37 * hash) + ESTTOTALFOCONSUMPTION_FIELD_NUMBER;
      hash = (53 * hash) + getEstTotalFOConsumption().hashCode();
      hash = (37 * hash) + LOADABLESTUDYID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getLoadableStudyId());
      hash = (37 * hash) + UPDATEDATEANDTIME_FIELD_NUMBER;
      hash = (53 * hash) + getUpdateDateAndTime().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest parseFrom(
        byte[] data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest
        parseDelimitedFrom(java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest
        parseDelimitedFrom(
            java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest parseFrom(
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
        com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest prototype) {
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
    /** Protobuf type {@code LoadableQuantityRequest} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:LoadableQuantityRequest)
        com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequestOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.LoadableStudy
            .internal_static_LoadableQuantityRequest_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.LoadableStudy
            .internal_static_LoadableQuantityRequest_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest.class,
                com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest.Builder.class);
      }

      // Construct using
      // com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest.newBuilder()
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
        limitingDraft_ = "";

        estSeaDensity_ = "";

        tpc_ = "";

        estSagging_ = "";

        displacmentDraftRestriction_ = "";

        vesselLightWeight_ = "";

        dwt_ = "";

        sgCorrection_ = "";

        saggingDeduction_ = "";

        estFOOnBoard_ = "";

        estDOOnBoard_ = "";

        estFreshWaterOnBoard_ = "";

        constant_ = "";

        otherIfAny_ = "";

        totalQuantity_ = "";

        distanceFromLastPort_ = "";

        vesselAverageSpeed_ = "";

        foConsumptionPerDay_ = "";

        estTotalFOConsumption_ = "";

        loadableStudyId_ = 0L;

        updateDateAndTime_ = "";

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.LoadableStudy
            .internal_static_LoadableQuantityRequest_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest
          getDefaultInstanceForType() {
        return com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest
            .getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest build() {
        com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest buildPartial() {
        com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest result =
            new com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest(this);
        result.limitingDraft_ = limitingDraft_;
        result.estSeaDensity_ = estSeaDensity_;
        result.tpc_ = tpc_;
        result.estSagging_ = estSagging_;
        result.displacmentDraftRestriction_ = displacmentDraftRestriction_;
        result.vesselLightWeight_ = vesselLightWeight_;
        result.dwt_ = dwt_;
        result.sgCorrection_ = sgCorrection_;
        result.saggingDeduction_ = saggingDeduction_;
        result.estFOOnBoard_ = estFOOnBoard_;
        result.estDOOnBoard_ = estDOOnBoard_;
        result.estFreshWaterOnBoard_ = estFreshWaterOnBoard_;
        result.constant_ = constant_;
        result.otherIfAny_ = otherIfAny_;
        result.totalQuantity_ = totalQuantity_;
        result.distanceFromLastPort_ = distanceFromLastPort_;
        result.vesselAverageSpeed_ = vesselAverageSpeed_;
        result.foConsumptionPerDay_ = foConsumptionPerDay_;
        result.estTotalFOConsumption_ = estTotalFOConsumption_;
        result.loadableStudyId_ = loadableStudyId_;
        result.updateDateAndTime_ = updateDateAndTime_;
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
        if (other instanceof com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest) {
          return mergeFrom(
              (com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(
          com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest other) {
        if (other
            == com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest
                .getDefaultInstance()) return this;
        if (!other.getLimitingDraft().isEmpty()) {
          limitingDraft_ = other.limitingDraft_;
          onChanged();
        }
        if (!other.getEstSeaDensity().isEmpty()) {
          estSeaDensity_ = other.estSeaDensity_;
          onChanged();
        }
        if (!other.getTpc().isEmpty()) {
          tpc_ = other.tpc_;
          onChanged();
        }
        if (!other.getEstSagging().isEmpty()) {
          estSagging_ = other.estSagging_;
          onChanged();
        }
        if (!other.getDisplacmentDraftRestriction().isEmpty()) {
          displacmentDraftRestriction_ = other.displacmentDraftRestriction_;
          onChanged();
        }
        if (!other.getVesselLightWeight().isEmpty()) {
          vesselLightWeight_ = other.vesselLightWeight_;
          onChanged();
        }
        if (!other.getDwt().isEmpty()) {
          dwt_ = other.dwt_;
          onChanged();
        }
        if (!other.getSgCorrection().isEmpty()) {
          sgCorrection_ = other.sgCorrection_;
          onChanged();
        }
        if (!other.getSaggingDeduction().isEmpty()) {
          saggingDeduction_ = other.saggingDeduction_;
          onChanged();
        }
        if (!other.getEstFOOnBoard().isEmpty()) {
          estFOOnBoard_ = other.estFOOnBoard_;
          onChanged();
        }
        if (!other.getEstDOOnBoard().isEmpty()) {
          estDOOnBoard_ = other.estDOOnBoard_;
          onChanged();
        }
        if (!other.getEstFreshWaterOnBoard().isEmpty()) {
          estFreshWaterOnBoard_ = other.estFreshWaterOnBoard_;
          onChanged();
        }
        if (!other.getConstant().isEmpty()) {
          constant_ = other.constant_;
          onChanged();
        }
        if (!other.getOtherIfAny().isEmpty()) {
          otherIfAny_ = other.otherIfAny_;
          onChanged();
        }
        if (!other.getTotalQuantity().isEmpty()) {
          totalQuantity_ = other.totalQuantity_;
          onChanged();
        }
        if (!other.getDistanceFromLastPort().isEmpty()) {
          distanceFromLastPort_ = other.distanceFromLastPort_;
          onChanged();
        }
        if (!other.getVesselAverageSpeed().isEmpty()) {
          vesselAverageSpeed_ = other.vesselAverageSpeed_;
          onChanged();
        }
        if (!other.getFoConsumptionPerDay().isEmpty()) {
          foConsumptionPerDay_ = other.foConsumptionPerDay_;
          onChanged();
        }
        if (!other.getEstTotalFOConsumption().isEmpty()) {
          estTotalFOConsumption_ = other.estTotalFOConsumption_;
          onChanged();
        }
        if (other.getLoadableStudyId() != 0L) {
          setLoadableStudyId(other.getLoadableStudyId());
        }
        if (!other.getUpdateDateAndTime().isEmpty()) {
          updateDateAndTime_ = other.updateDateAndTime_;
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
        com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest)
                  e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private java.lang.Object limitingDraft_ = "";
      /**
       * <code>string limitingDraft = 1;</code>
       *
       * @return The limitingDraft.
       */
      public java.lang.String getLimitingDraft() {
        java.lang.Object ref = limitingDraft_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          limitingDraft_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string limitingDraft = 1;</code>
       *
       * @return The bytes for limitingDraft.
       */
      public com.google.protobuf.ByteString getLimitingDraftBytes() {
        java.lang.Object ref = limitingDraft_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          limitingDraft_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string limitingDraft = 1;</code>
       *
       * @param value The limitingDraft to set.
       * @return This builder for chaining.
       */
      public Builder setLimitingDraft(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        limitingDraft_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string limitingDraft = 1;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearLimitingDraft() {

        limitingDraft_ = getDefaultInstance().getLimitingDraft();
        onChanged();
        return this;
      }
      /**
       * <code>string limitingDraft = 1;</code>
       *
       * @param value The bytes for limitingDraft to set.
       * @return This builder for chaining.
       */
      public Builder setLimitingDraftBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        limitingDraft_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object estSeaDensity_ = "";
      /**
       * <code>string estSeaDensity = 2;</code>
       *
       * @return The estSeaDensity.
       */
      public java.lang.String getEstSeaDensity() {
        java.lang.Object ref = estSeaDensity_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          estSeaDensity_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string estSeaDensity = 2;</code>
       *
       * @return The bytes for estSeaDensity.
       */
      public com.google.protobuf.ByteString getEstSeaDensityBytes() {
        java.lang.Object ref = estSeaDensity_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          estSeaDensity_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string estSeaDensity = 2;</code>
       *
       * @param value The estSeaDensity to set.
       * @return This builder for chaining.
       */
      public Builder setEstSeaDensity(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        estSeaDensity_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string estSeaDensity = 2;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearEstSeaDensity() {

        estSeaDensity_ = getDefaultInstance().getEstSeaDensity();
        onChanged();
        return this;
      }
      /**
       * <code>string estSeaDensity = 2;</code>
       *
       * @param value The bytes for estSeaDensity to set.
       * @return This builder for chaining.
       */
      public Builder setEstSeaDensityBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        estSeaDensity_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object tpc_ = "";
      /**
       * <code>string tpc = 3;</code>
       *
       * @return The tpc.
       */
      public java.lang.String getTpc() {
        java.lang.Object ref = tpc_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          tpc_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string tpc = 3;</code>
       *
       * @return The bytes for tpc.
       */
      public com.google.protobuf.ByteString getTpcBytes() {
        java.lang.Object ref = tpc_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          tpc_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string tpc = 3;</code>
       *
       * @param value The tpc to set.
       * @return This builder for chaining.
       */
      public Builder setTpc(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        tpc_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string tpc = 3;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearTpc() {

        tpc_ = getDefaultInstance().getTpc();
        onChanged();
        return this;
      }
      /**
       * <code>string tpc = 3;</code>
       *
       * @param value The bytes for tpc to set.
       * @return This builder for chaining.
       */
      public Builder setTpcBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        tpc_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object estSagging_ = "";
      /**
       * <code>string estSagging = 4;</code>
       *
       * @return The estSagging.
       */
      public java.lang.String getEstSagging() {
        java.lang.Object ref = estSagging_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          estSagging_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string estSagging = 4;</code>
       *
       * @return The bytes for estSagging.
       */
      public com.google.protobuf.ByteString getEstSaggingBytes() {
        java.lang.Object ref = estSagging_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          estSagging_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string estSagging = 4;</code>
       *
       * @param value The estSagging to set.
       * @return This builder for chaining.
       */
      public Builder setEstSagging(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        estSagging_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string estSagging = 4;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearEstSagging() {

        estSagging_ = getDefaultInstance().getEstSagging();
        onChanged();
        return this;
      }
      /**
       * <code>string estSagging = 4;</code>
       *
       * @param value The bytes for estSagging to set.
       * @return This builder for chaining.
       */
      public Builder setEstSaggingBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        estSagging_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object displacmentDraftRestriction_ = "";
      /**
       * <code>string displacmentDraftRestriction = 5;</code>
       *
       * @return The displacmentDraftRestriction.
       */
      public java.lang.String getDisplacmentDraftRestriction() {
        java.lang.Object ref = displacmentDraftRestriction_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          displacmentDraftRestriction_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string displacmentDraftRestriction = 5;</code>
       *
       * @return The bytes for displacmentDraftRestriction.
       */
      public com.google.protobuf.ByteString getDisplacmentDraftRestrictionBytes() {
        java.lang.Object ref = displacmentDraftRestriction_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          displacmentDraftRestriction_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string displacmentDraftRestriction = 5;</code>
       *
       * @param value The displacmentDraftRestriction to set.
       * @return This builder for chaining.
       */
      public Builder setDisplacmentDraftRestriction(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        displacmentDraftRestriction_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string displacmentDraftRestriction = 5;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearDisplacmentDraftRestriction() {

        displacmentDraftRestriction_ = getDefaultInstance().getDisplacmentDraftRestriction();
        onChanged();
        return this;
      }
      /**
       * <code>string displacmentDraftRestriction = 5;</code>
       *
       * @param value The bytes for displacmentDraftRestriction to set.
       * @return This builder for chaining.
       */
      public Builder setDisplacmentDraftRestrictionBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        displacmentDraftRestriction_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object vesselLightWeight_ = "";
      /**
       * <code>string vesselLightWeight = 6;</code>
       *
       * @return The vesselLightWeight.
       */
      public java.lang.String getVesselLightWeight() {
        java.lang.Object ref = vesselLightWeight_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          vesselLightWeight_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string vesselLightWeight = 6;</code>
       *
       * @return The bytes for vesselLightWeight.
       */
      public com.google.protobuf.ByteString getVesselLightWeightBytes() {
        java.lang.Object ref = vesselLightWeight_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          vesselLightWeight_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string vesselLightWeight = 6;</code>
       *
       * @param value The vesselLightWeight to set.
       * @return This builder for chaining.
       */
      public Builder setVesselLightWeight(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        vesselLightWeight_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string vesselLightWeight = 6;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearVesselLightWeight() {

        vesselLightWeight_ = getDefaultInstance().getVesselLightWeight();
        onChanged();
        return this;
      }
      /**
       * <code>string vesselLightWeight = 6;</code>
       *
       * @param value The bytes for vesselLightWeight to set.
       * @return This builder for chaining.
       */
      public Builder setVesselLightWeightBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        vesselLightWeight_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object dwt_ = "";
      /**
       * <code>string dwt = 7;</code>
       *
       * @return The dwt.
       */
      public java.lang.String getDwt() {
        java.lang.Object ref = dwt_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          dwt_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string dwt = 7;</code>
       *
       * @return The bytes for dwt.
       */
      public com.google.protobuf.ByteString getDwtBytes() {
        java.lang.Object ref = dwt_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          dwt_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string dwt = 7;</code>
       *
       * @param value The dwt to set.
       * @return This builder for chaining.
       */
      public Builder setDwt(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        dwt_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string dwt = 7;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearDwt() {

        dwt_ = getDefaultInstance().getDwt();
        onChanged();
        return this;
      }
      /**
       * <code>string dwt = 7;</code>
       *
       * @param value The bytes for dwt to set.
       * @return This builder for chaining.
       */
      public Builder setDwtBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        dwt_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object sgCorrection_ = "";
      /**
       * <code>string sgCorrection = 8;</code>
       *
       * @return The sgCorrection.
       */
      public java.lang.String getSgCorrection() {
        java.lang.Object ref = sgCorrection_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          sgCorrection_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string sgCorrection = 8;</code>
       *
       * @return The bytes for sgCorrection.
       */
      public com.google.protobuf.ByteString getSgCorrectionBytes() {
        java.lang.Object ref = sgCorrection_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          sgCorrection_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string sgCorrection = 8;</code>
       *
       * @param value The sgCorrection to set.
       * @return This builder for chaining.
       */
      public Builder setSgCorrection(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        sgCorrection_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string sgCorrection = 8;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearSgCorrection() {

        sgCorrection_ = getDefaultInstance().getSgCorrection();
        onChanged();
        return this;
      }
      /**
       * <code>string sgCorrection = 8;</code>
       *
       * @param value The bytes for sgCorrection to set.
       * @return This builder for chaining.
       */
      public Builder setSgCorrectionBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        sgCorrection_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object saggingDeduction_ = "";
      /**
       * <code>string saggingDeduction = 9;</code>
       *
       * @return The saggingDeduction.
       */
      public java.lang.String getSaggingDeduction() {
        java.lang.Object ref = saggingDeduction_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          saggingDeduction_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string saggingDeduction = 9;</code>
       *
       * @return The bytes for saggingDeduction.
       */
      public com.google.protobuf.ByteString getSaggingDeductionBytes() {
        java.lang.Object ref = saggingDeduction_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          saggingDeduction_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string saggingDeduction = 9;</code>
       *
       * @param value The saggingDeduction to set.
       * @return This builder for chaining.
       */
      public Builder setSaggingDeduction(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        saggingDeduction_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string saggingDeduction = 9;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearSaggingDeduction() {

        saggingDeduction_ = getDefaultInstance().getSaggingDeduction();
        onChanged();
        return this;
      }
      /**
       * <code>string saggingDeduction = 9;</code>
       *
       * @param value The bytes for saggingDeduction to set.
       * @return This builder for chaining.
       */
      public Builder setSaggingDeductionBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        saggingDeduction_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object estFOOnBoard_ = "";
      /**
       * <code>string estFOOnBoard = 10;</code>
       *
       * @return The estFOOnBoard.
       */
      public java.lang.String getEstFOOnBoard() {
        java.lang.Object ref = estFOOnBoard_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          estFOOnBoard_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string estFOOnBoard = 10;</code>
       *
       * @return The bytes for estFOOnBoard.
       */
      public com.google.protobuf.ByteString getEstFOOnBoardBytes() {
        java.lang.Object ref = estFOOnBoard_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          estFOOnBoard_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string estFOOnBoard = 10;</code>
       *
       * @param value The estFOOnBoard to set.
       * @return This builder for chaining.
       */
      public Builder setEstFOOnBoard(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        estFOOnBoard_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string estFOOnBoard = 10;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearEstFOOnBoard() {

        estFOOnBoard_ = getDefaultInstance().getEstFOOnBoard();
        onChanged();
        return this;
      }
      /**
       * <code>string estFOOnBoard = 10;</code>
       *
       * @param value The bytes for estFOOnBoard to set.
       * @return This builder for chaining.
       */
      public Builder setEstFOOnBoardBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        estFOOnBoard_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object estDOOnBoard_ = "";
      /**
       * <code>string estDOOnBoard = 11;</code>
       *
       * @return The estDOOnBoard.
       */
      public java.lang.String getEstDOOnBoard() {
        java.lang.Object ref = estDOOnBoard_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          estDOOnBoard_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string estDOOnBoard = 11;</code>
       *
       * @return The bytes for estDOOnBoard.
       */
      public com.google.protobuf.ByteString getEstDOOnBoardBytes() {
        java.lang.Object ref = estDOOnBoard_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          estDOOnBoard_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string estDOOnBoard = 11;</code>
       *
       * @param value The estDOOnBoard to set.
       * @return This builder for chaining.
       */
      public Builder setEstDOOnBoard(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        estDOOnBoard_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string estDOOnBoard = 11;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearEstDOOnBoard() {

        estDOOnBoard_ = getDefaultInstance().getEstDOOnBoard();
        onChanged();
        return this;
      }
      /**
       * <code>string estDOOnBoard = 11;</code>
       *
       * @param value The bytes for estDOOnBoard to set.
       * @return This builder for chaining.
       */
      public Builder setEstDOOnBoardBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        estDOOnBoard_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object estFreshWaterOnBoard_ = "";
      /**
       * <code>string estFreshWaterOnBoard = 12;</code>
       *
       * @return The estFreshWaterOnBoard.
       */
      public java.lang.String getEstFreshWaterOnBoard() {
        java.lang.Object ref = estFreshWaterOnBoard_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          estFreshWaterOnBoard_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string estFreshWaterOnBoard = 12;</code>
       *
       * @return The bytes for estFreshWaterOnBoard.
       */
      public com.google.protobuf.ByteString getEstFreshWaterOnBoardBytes() {
        java.lang.Object ref = estFreshWaterOnBoard_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          estFreshWaterOnBoard_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string estFreshWaterOnBoard = 12;</code>
       *
       * @param value The estFreshWaterOnBoard to set.
       * @return This builder for chaining.
       */
      public Builder setEstFreshWaterOnBoard(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        estFreshWaterOnBoard_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string estFreshWaterOnBoard = 12;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearEstFreshWaterOnBoard() {

        estFreshWaterOnBoard_ = getDefaultInstance().getEstFreshWaterOnBoard();
        onChanged();
        return this;
      }
      /**
       * <code>string estFreshWaterOnBoard = 12;</code>
       *
       * @param value The bytes for estFreshWaterOnBoard to set.
       * @return This builder for chaining.
       */
      public Builder setEstFreshWaterOnBoardBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        estFreshWaterOnBoard_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object constant_ = "";
      /**
       * <code>string constant = 13;</code>
       *
       * @return The constant.
       */
      public java.lang.String getConstant() {
        java.lang.Object ref = constant_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          constant_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string constant = 13;</code>
       *
       * @return The bytes for constant.
       */
      public com.google.protobuf.ByteString getConstantBytes() {
        java.lang.Object ref = constant_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          constant_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string constant = 13;</code>
       *
       * @param value The constant to set.
       * @return This builder for chaining.
       */
      public Builder setConstant(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        constant_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string constant = 13;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearConstant() {

        constant_ = getDefaultInstance().getConstant();
        onChanged();
        return this;
      }
      /**
       * <code>string constant = 13;</code>
       *
       * @param value The bytes for constant to set.
       * @return This builder for chaining.
       */
      public Builder setConstantBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        constant_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object otherIfAny_ = "";
      /**
       * <code>string otherIfAny = 14;</code>
       *
       * @return The otherIfAny.
       */
      public java.lang.String getOtherIfAny() {
        java.lang.Object ref = otherIfAny_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          otherIfAny_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string otherIfAny = 14;</code>
       *
       * @return The bytes for otherIfAny.
       */
      public com.google.protobuf.ByteString getOtherIfAnyBytes() {
        java.lang.Object ref = otherIfAny_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          otherIfAny_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string otherIfAny = 14;</code>
       *
       * @param value The otherIfAny to set.
       * @return This builder for chaining.
       */
      public Builder setOtherIfAny(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        otherIfAny_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string otherIfAny = 14;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearOtherIfAny() {

        otherIfAny_ = getDefaultInstance().getOtherIfAny();
        onChanged();
        return this;
      }
      /**
       * <code>string otherIfAny = 14;</code>
       *
       * @param value The bytes for otherIfAny to set.
       * @return This builder for chaining.
       */
      public Builder setOtherIfAnyBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        otherIfAny_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object totalQuantity_ = "";
      /**
       * <code>string totalQuantity = 15;</code>
       *
       * @return The totalQuantity.
       */
      public java.lang.String getTotalQuantity() {
        java.lang.Object ref = totalQuantity_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          totalQuantity_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string totalQuantity = 15;</code>
       *
       * @return The bytes for totalQuantity.
       */
      public com.google.protobuf.ByteString getTotalQuantityBytes() {
        java.lang.Object ref = totalQuantity_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          totalQuantity_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string totalQuantity = 15;</code>
       *
       * @param value The totalQuantity to set.
       * @return This builder for chaining.
       */
      public Builder setTotalQuantity(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        totalQuantity_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string totalQuantity = 15;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearTotalQuantity() {

        totalQuantity_ = getDefaultInstance().getTotalQuantity();
        onChanged();
        return this;
      }
      /**
       * <code>string totalQuantity = 15;</code>
       *
       * @param value The bytes for totalQuantity to set.
       * @return This builder for chaining.
       */
      public Builder setTotalQuantityBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        totalQuantity_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object distanceFromLastPort_ = "";
      /**
       * <code>string distanceFromLastPort = 16;</code>
       *
       * @return The distanceFromLastPort.
       */
      public java.lang.String getDistanceFromLastPort() {
        java.lang.Object ref = distanceFromLastPort_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          distanceFromLastPort_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string distanceFromLastPort = 16;</code>
       *
       * @return The bytes for distanceFromLastPort.
       */
      public com.google.protobuf.ByteString getDistanceFromLastPortBytes() {
        java.lang.Object ref = distanceFromLastPort_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          distanceFromLastPort_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string distanceFromLastPort = 16;</code>
       *
       * @param value The distanceFromLastPort to set.
       * @return This builder for chaining.
       */
      public Builder setDistanceFromLastPort(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        distanceFromLastPort_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string distanceFromLastPort = 16;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearDistanceFromLastPort() {

        distanceFromLastPort_ = getDefaultInstance().getDistanceFromLastPort();
        onChanged();
        return this;
      }
      /**
       * <code>string distanceFromLastPort = 16;</code>
       *
       * @param value The bytes for distanceFromLastPort to set.
       * @return This builder for chaining.
       */
      public Builder setDistanceFromLastPortBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        distanceFromLastPort_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object vesselAverageSpeed_ = "";
      /**
       * <code>string vesselAverageSpeed = 17;</code>
       *
       * @return The vesselAverageSpeed.
       */
      public java.lang.String getVesselAverageSpeed() {
        java.lang.Object ref = vesselAverageSpeed_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          vesselAverageSpeed_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string vesselAverageSpeed = 17;</code>
       *
       * @return The bytes for vesselAverageSpeed.
       */
      public com.google.protobuf.ByteString getVesselAverageSpeedBytes() {
        java.lang.Object ref = vesselAverageSpeed_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          vesselAverageSpeed_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string vesselAverageSpeed = 17;</code>
       *
       * @param value The vesselAverageSpeed to set.
       * @return This builder for chaining.
       */
      public Builder setVesselAverageSpeed(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        vesselAverageSpeed_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string vesselAverageSpeed = 17;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearVesselAverageSpeed() {

        vesselAverageSpeed_ = getDefaultInstance().getVesselAverageSpeed();
        onChanged();
        return this;
      }
      /**
       * <code>string vesselAverageSpeed = 17;</code>
       *
       * @param value The bytes for vesselAverageSpeed to set.
       * @return This builder for chaining.
       */
      public Builder setVesselAverageSpeedBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        vesselAverageSpeed_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object foConsumptionPerDay_ = "";
      /**
       * <code>string foConsumptionPerDay = 18;</code>
       *
       * @return The foConsumptionPerDay.
       */
      public java.lang.String getFoConsumptionPerDay() {
        java.lang.Object ref = foConsumptionPerDay_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          foConsumptionPerDay_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string foConsumptionPerDay = 18;</code>
       *
       * @return The bytes for foConsumptionPerDay.
       */
      public com.google.protobuf.ByteString getFoConsumptionPerDayBytes() {
        java.lang.Object ref = foConsumptionPerDay_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          foConsumptionPerDay_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string foConsumptionPerDay = 18;</code>
       *
       * @param value The foConsumptionPerDay to set.
       * @return This builder for chaining.
       */
      public Builder setFoConsumptionPerDay(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        foConsumptionPerDay_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string foConsumptionPerDay = 18;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearFoConsumptionPerDay() {

        foConsumptionPerDay_ = getDefaultInstance().getFoConsumptionPerDay();
        onChanged();
        return this;
      }
      /**
       * <code>string foConsumptionPerDay = 18;</code>
       *
       * @param value The bytes for foConsumptionPerDay to set.
       * @return This builder for chaining.
       */
      public Builder setFoConsumptionPerDayBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        foConsumptionPerDay_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object estTotalFOConsumption_ = "";
      /**
       * <code>string estTotalFOConsumption = 19;</code>
       *
       * @return The estTotalFOConsumption.
       */
      public java.lang.String getEstTotalFOConsumption() {
        java.lang.Object ref = estTotalFOConsumption_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          estTotalFOConsumption_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string estTotalFOConsumption = 19;</code>
       *
       * @return The bytes for estTotalFOConsumption.
       */
      public com.google.protobuf.ByteString getEstTotalFOConsumptionBytes() {
        java.lang.Object ref = estTotalFOConsumption_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          estTotalFOConsumption_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string estTotalFOConsumption = 19;</code>
       *
       * @param value The estTotalFOConsumption to set.
       * @return This builder for chaining.
       */
      public Builder setEstTotalFOConsumption(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        estTotalFOConsumption_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string estTotalFOConsumption = 19;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearEstTotalFOConsumption() {

        estTotalFOConsumption_ = getDefaultInstance().getEstTotalFOConsumption();
        onChanged();
        return this;
      }
      /**
       * <code>string estTotalFOConsumption = 19;</code>
       *
       * @param value The bytes for estTotalFOConsumption to set.
       * @return This builder for chaining.
       */
      public Builder setEstTotalFOConsumptionBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        estTotalFOConsumption_ = value;
        onChanged();
        return this;
      }

      private long loadableStudyId_;
      /**
       * <code>int64 loadableStudyId = 20;</code>
       *
       * @return The loadableStudyId.
       */
      public long getLoadableStudyId() {
        return loadableStudyId_;
      }
      /**
       * <code>int64 loadableStudyId = 20;</code>
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
       * <code>int64 loadableStudyId = 20;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearLoadableStudyId() {

        loadableStudyId_ = 0L;
        onChanged();
        return this;
      }

      private java.lang.Object updateDateAndTime_ = "";
      /**
       * <code>string updateDateAndTime = 21;</code>
       *
       * @return The updateDateAndTime.
       */
      public java.lang.String getUpdateDateAndTime() {
        java.lang.Object ref = updateDateAndTime_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          updateDateAndTime_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string updateDateAndTime = 21;</code>
       *
       * @return The bytes for updateDateAndTime.
       */
      public com.google.protobuf.ByteString getUpdateDateAndTimeBytes() {
        java.lang.Object ref = updateDateAndTime_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          updateDateAndTime_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string updateDateAndTime = 21;</code>
       *
       * @param value The updateDateAndTime to set.
       * @return This builder for chaining.
       */
      public Builder setUpdateDateAndTime(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        updateDateAndTime_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string updateDateAndTime = 21;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearUpdateDateAndTime() {

        updateDateAndTime_ = getDefaultInstance().getUpdateDateAndTime();
        onChanged();
        return this;
      }
      /**
       * <code>string updateDateAndTime = 21;</code>
       *
       * @param value The bytes for updateDateAndTime to set.
       * @return This builder for chaining.
       */
      public Builder setUpdateDateAndTimeBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        updateDateAndTime_ = value;
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

      // @@protoc_insertion_point(builder_scope:LoadableQuantityRequest)
    }

    // @@protoc_insertion_point(class_scope:LoadableQuantityRequest)
    private static final com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest
        DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest();
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest
        getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<LoadableQuantityRequest> PARSER =
        new com.google.protobuf.AbstractParser<LoadableQuantityRequest>() {
          @java.lang.Override
          public LoadableQuantityRequest parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new LoadableQuantityRequest(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<LoadableQuantityRequest> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<LoadableQuantityRequest> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest
        getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface LoadableQuantityReplyOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:LoadableQuantityReply)
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

    /**
     * <code>int64 loadableQuantityId = 2;</code>
     *
     * @return The loadableQuantityId.
     */
    long getLoadableQuantityId();
  }
  /** Protobuf type {@code LoadableQuantityReply} */
  public static final class LoadableQuantityReply extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:LoadableQuantityReply)
      LoadableQuantityReplyOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use LoadableQuantityReply.newBuilder() to construct.
    private LoadableQuantityReply(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private LoadableQuantityReply() {}

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new LoadableQuantityReply();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private LoadableQuantityReply(
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
            case 16:
              {
                loadableQuantityId_ = input.readInt64();
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
          .internal_static_LoadableQuantityReply_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.LoadableStudy
          .internal_static_LoadableQuantityReply_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.LoadableStudy.LoadableQuantityReply.class,
              com.cpdss.common.generated.LoadableStudy.LoadableQuantityReply.Builder.class);
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

    public static final int LOADABLEQUANTITYID_FIELD_NUMBER = 2;
    private long loadableQuantityId_;
    /**
     * <code>int64 loadableQuantityId = 2;</code>
     *
     * @return The loadableQuantityId.
     */
    public long getLoadableQuantityId() {
      return loadableQuantityId_;
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
      if (loadableQuantityId_ != 0L) {
        output.writeInt64(2, loadableQuantityId_);
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
      if (loadableQuantityId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(2, loadableQuantityId_);
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
      if (!(obj instanceof com.cpdss.common.generated.LoadableStudy.LoadableQuantityReply)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.LoadableStudy.LoadableQuantityReply other =
          (com.cpdss.common.generated.LoadableStudy.LoadableQuantityReply) obj;

      if (hasResponseStatus() != other.hasResponseStatus()) return false;
      if (hasResponseStatus()) {
        if (!getResponseStatus().equals(other.getResponseStatus())) return false;
      }
      if (getLoadableQuantityId() != other.getLoadableQuantityId()) return false;
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
      hash = (37 * hash) + LOADABLEQUANTITYID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getLoadableQuantityId());
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableQuantityReply parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableQuantityReply parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableQuantityReply parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableQuantityReply parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableQuantityReply parseFrom(
        byte[] data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableQuantityReply parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableQuantityReply parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableQuantityReply parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableQuantityReply parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableQuantityReply parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableQuantityReply parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableQuantityReply parseFrom(
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
        com.cpdss.common.generated.LoadableStudy.LoadableQuantityReply prototype) {
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
    /** Protobuf type {@code LoadableQuantityReply} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:LoadableQuantityReply)
        com.cpdss.common.generated.LoadableStudy.LoadableQuantityReplyOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.LoadableStudy
            .internal_static_LoadableQuantityReply_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.LoadableStudy
            .internal_static_LoadableQuantityReply_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.LoadableStudy.LoadableQuantityReply.class,
                com.cpdss.common.generated.LoadableStudy.LoadableQuantityReply.Builder.class);
      }

      // Construct using com.cpdss.common.generated.LoadableStudy.LoadableQuantityReply.newBuilder()
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
        loadableQuantityId_ = 0L;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.LoadableStudy
            .internal_static_LoadableQuantityReply_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.LoadableQuantityReply
          getDefaultInstanceForType() {
        return com.cpdss.common.generated.LoadableStudy.LoadableQuantityReply.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.LoadableQuantityReply build() {
        com.cpdss.common.generated.LoadableStudy.LoadableQuantityReply result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.LoadableQuantityReply buildPartial() {
        com.cpdss.common.generated.LoadableStudy.LoadableQuantityReply result =
            new com.cpdss.common.generated.LoadableStudy.LoadableQuantityReply(this);
        if (responseStatusBuilder_ == null) {
          result.responseStatus_ = responseStatus_;
        } else {
          result.responseStatus_ = responseStatusBuilder_.build();
        }
        result.loadableQuantityId_ = loadableQuantityId_;
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
        if (other instanceof com.cpdss.common.generated.LoadableStudy.LoadableQuantityReply) {
          return mergeFrom((com.cpdss.common.generated.LoadableStudy.LoadableQuantityReply) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(
          com.cpdss.common.generated.LoadableStudy.LoadableQuantityReply other) {
        if (other
            == com.cpdss.common.generated.LoadableStudy.LoadableQuantityReply.getDefaultInstance())
          return this;
        if (other.hasResponseStatus()) {
          mergeResponseStatus(other.getResponseStatus());
        }
        if (other.getLoadableQuantityId() != 0L) {
          setLoadableQuantityId(other.getLoadableQuantityId());
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
        com.cpdss.common.generated.LoadableStudy.LoadableQuantityReply parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.LoadableStudy.LoadableQuantityReply)
                  e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

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

      private long loadableQuantityId_;
      /**
       * <code>int64 loadableQuantityId = 2;</code>
       *
       * @return The loadableQuantityId.
       */
      public long getLoadableQuantityId() {
        return loadableQuantityId_;
      }
      /**
       * <code>int64 loadableQuantityId = 2;</code>
       *
       * @param value The loadableQuantityId to set.
       * @return This builder for chaining.
       */
      public Builder setLoadableQuantityId(long value) {

        loadableQuantityId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int64 loadableQuantityId = 2;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearLoadableQuantityId() {

        loadableQuantityId_ = 0L;
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

      // @@protoc_insertion_point(builder_scope:LoadableQuantityReply)
    }

    // @@protoc_insertion_point(class_scope:LoadableQuantityReply)
    private static final com.cpdss.common.generated.LoadableStudy.LoadableQuantityReply
        DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.LoadableStudy.LoadableQuantityReply();
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableQuantityReply
        getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<LoadableQuantityReply> PARSER =
        new com.google.protobuf.AbstractParser<LoadableQuantityReply>() {
          @java.lang.Override
          public LoadableQuantityReply parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new LoadableQuantityReply(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<LoadableQuantityReply> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<LoadableQuantityReply> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.LoadableStudy.LoadableQuantityReply
        getDefaultInstanceForType() {
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

  public interface LoadableStudyAttachmentOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:LoadableStudyAttachment)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>bytes byteString = 1;</code>
     *
     * @return The byteString.
     */
    com.google.protobuf.ByteString getByteString();

    /**
     * <code>string fileName = 2;</code>
     *
     * @return The fileName.
     */
    java.lang.String getFileName();
    /**
     * <code>string fileName = 2;</code>
     *
     * @return The bytes for fileName.
     */
    com.google.protobuf.ByteString getFileNameBytes();
  }
  /** Protobuf type {@code LoadableStudyAttachment} */
  public static final class LoadableStudyAttachment extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:LoadableStudyAttachment)
      LoadableStudyAttachmentOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use LoadableStudyAttachment.newBuilder() to construct.
    private LoadableStudyAttachment(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private LoadableStudyAttachment() {
      byteString_ = com.google.protobuf.ByteString.EMPTY;
      fileName_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new LoadableStudyAttachment();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private LoadableStudyAttachment(
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
                byteString_ = input.readBytes();
                break;
              }
            case 18:
              {
                java.lang.String s = input.readStringRequireUtf8();

                fileName_ = s;
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
          .internal_static_LoadableStudyAttachment_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.LoadableStudy
          .internal_static_LoadableStudyAttachment_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment.class,
              com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment.Builder.class);
    }

    public static final int BYTESTRING_FIELD_NUMBER = 1;
    private com.google.protobuf.ByteString byteString_;
    /**
     * <code>bytes byteString = 1;</code>
     *
     * @return The byteString.
     */
    public com.google.protobuf.ByteString getByteString() {
      return byteString_;
    }

    public static final int FILENAME_FIELD_NUMBER = 2;
    private volatile java.lang.Object fileName_;
    /**
     * <code>string fileName = 2;</code>
     *
     * @return The fileName.
     */
    public java.lang.String getFileName() {
      java.lang.Object ref = fileName_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        fileName_ = s;
        return s;
      }
    }
    /**
     * <code>string fileName = 2;</code>
     *
     * @return The bytes for fileName.
     */
    public com.google.protobuf.ByteString getFileNameBytes() {
      java.lang.Object ref = fileName_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        fileName_ = b;
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
      if (!byteString_.isEmpty()) {
        output.writeBytes(1, byteString_);
      }
      if (!getFileNameBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, fileName_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!byteString_.isEmpty()) {
        size += com.google.protobuf.CodedOutputStream.computeBytesSize(1, byteString_);
      }
      if (!getFileNameBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, fileName_);
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
      if (!(obj instanceof com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment other =
          (com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment) obj;

      if (!getByteString().equals(other.getByteString())) return false;
      if (!getFileName().equals(other.getFileName())) return false;
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
      hash = (37 * hash) + BYTESTRING_FIELD_NUMBER;
      hash = (53 * hash) + getByteString().hashCode();
      hash = (37 * hash) + FILENAME_FIELD_NUMBER;
      hash = (53 * hash) + getFileName().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment parseFrom(
        byte[] data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment
        parseDelimitedFrom(java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment
        parseDelimitedFrom(
            java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment parseFrom(
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
        com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment prototype) {
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
    /** Protobuf type {@code LoadableStudyAttachment} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:LoadableStudyAttachment)
        com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachmentOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.LoadableStudy
            .internal_static_LoadableStudyAttachment_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.LoadableStudy
            .internal_static_LoadableStudyAttachment_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment.class,
                com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment.Builder.class);
      }

      // Construct using
      // com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment.newBuilder()
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
        byteString_ = com.google.protobuf.ByteString.EMPTY;

        fileName_ = "";

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.LoadableStudy
            .internal_static_LoadableStudyAttachment_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment
          getDefaultInstanceForType() {
        return com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment
            .getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment build() {
        com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment buildPartial() {
        com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment result =
            new com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment(this);
        result.byteString_ = byteString_;
        result.fileName_ = fileName_;
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
        if (other instanceof com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment) {
          return mergeFrom(
              (com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(
          com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment other) {
        if (other
            == com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment
                .getDefaultInstance()) return this;
        if (other.getByteString() != com.google.protobuf.ByteString.EMPTY) {
          setByteString(other.getByteString());
        }
        if (!other.getFileName().isEmpty()) {
          fileName_ = other.fileName_;
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
        com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment)
                  e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private com.google.protobuf.ByteString byteString_ = com.google.protobuf.ByteString.EMPTY;
      /**
       * <code>bytes byteString = 1;</code>
       *
       * @return The byteString.
       */
      public com.google.protobuf.ByteString getByteString() {
        return byteString_;
      }
      /**
       * <code>bytes byteString = 1;</code>
       *
       * @param value The byteString to set.
       * @return This builder for chaining.
       */
      public Builder setByteString(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }

        byteString_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>bytes byteString = 1;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearByteString() {

        byteString_ = getDefaultInstance().getByteString();
        onChanged();
        return this;
      }

      private java.lang.Object fileName_ = "";
      /**
       * <code>string fileName = 2;</code>
       *
       * @return The fileName.
       */
      public java.lang.String getFileName() {
        java.lang.Object ref = fileName_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          fileName_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string fileName = 2;</code>
       *
       * @return The bytes for fileName.
       */
      public com.google.protobuf.ByteString getFileNameBytes() {
        java.lang.Object ref = fileName_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          fileName_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string fileName = 2;</code>
       *
       * @param value The fileName to set.
       * @return This builder for chaining.
       */
      public Builder setFileName(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        fileName_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string fileName = 2;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearFileName() {

        fileName_ = getDefaultInstance().getFileName();
        onChanged();
        return this;
      }
      /**
       * <code>string fileName = 2;</code>
       *
       * @param value The bytes for fileName to set.
       * @return This builder for chaining.
       */
      public Builder setFileNameBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        fileName_ = value;
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

      // @@protoc_insertion_point(builder_scope:LoadableStudyAttachment)
    }

    // @@protoc_insertion_point(class_scope:LoadableStudyAttachment)
    private static final com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment
        DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment();
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment
        getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<LoadableStudyAttachment> PARSER =
        new com.google.protobuf.AbstractParser<LoadableStudyAttachment>() {
          @java.lang.Override
          public LoadableStudyAttachment parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new LoadableStudyAttachment(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<LoadableStudyAttachment> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<LoadableStudyAttachment> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment
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

    /**
     * <code>int64 duplicatedFromId = 12;</code>
     *
     * @return The duplicatedFromId.
     */
    long getDuplicatedFromId();

    /**
     * <code>int64 voyageId = 13;</code>
     *
     * @return The voyageId.
     */
    long getVoyageId();

    /**
     * <code>int64 vesselId = 14;</code>
     *
     * @return The vesselId.
     */
    long getVesselId();

    /** <code>repeated .LoadableStudyAttachment attachments = 15;</code> */
    java.util.List<com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment>
        getAttachmentsList();
    /** <code>repeated .LoadableStudyAttachment attachments = 15;</code> */
    com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment getAttachments(int index);
    /** <code>repeated .LoadableStudyAttachment attachments = 15;</code> */
    int getAttachmentsCount();
    /** <code>repeated .LoadableStudyAttachment attachments = 15;</code> */
    java.util.List<
            ? extends com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachmentOrBuilder>
        getAttachmentsOrBuilderList();
    /** <code>repeated .LoadableStudyAttachment attachments = 15;</code> */
    com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachmentOrBuilder
        getAttachmentsOrBuilder(int index);
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
      attachments_ = java.util.Collections.emptyList();
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
            case 96:
              {
                duplicatedFromId_ = input.readInt64();
                break;
              }
            case 104:
              {
                voyageId_ = input.readInt64();
                break;
              }
            case 112:
              {
                vesselId_ = input.readInt64();
                break;
              }
            case 122:
              {
                if (!((mutable_bitField0_ & 0x00000001) != 0)) {
                  attachments_ =
                      new java.util.ArrayList<
                          com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment>();
                  mutable_bitField0_ |= 0x00000001;
                }
                attachments_.add(
                    input.readMessage(
                        com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment.parser(),
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
          attachments_ = java.util.Collections.unmodifiableList(attachments_);
        }
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

    public static final int DUPLICATEDFROMID_FIELD_NUMBER = 12;
    private long duplicatedFromId_;
    /**
     * <code>int64 duplicatedFromId = 12;</code>
     *
     * @return The duplicatedFromId.
     */
    public long getDuplicatedFromId() {
      return duplicatedFromId_;
    }

    public static final int VOYAGEID_FIELD_NUMBER = 13;
    private long voyageId_;
    /**
     * <code>int64 voyageId = 13;</code>
     *
     * @return The voyageId.
     */
    public long getVoyageId() {
      return voyageId_;
    }

    public static final int VESSELID_FIELD_NUMBER = 14;
    private long vesselId_;
    /**
     * <code>int64 vesselId = 14;</code>
     *
     * @return The vesselId.
     */
    public long getVesselId() {
      return vesselId_;
    }

    public static final int ATTACHMENTS_FIELD_NUMBER = 15;
    private java.util.List<com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment>
        attachments_;
    /** <code>repeated .LoadableStudyAttachment attachments = 15;</code> */
    public java.util.List<com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment>
        getAttachmentsList() {
      return attachments_;
    }
    /** <code>repeated .LoadableStudyAttachment attachments = 15;</code> */
    public java.util.List<
            ? extends com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachmentOrBuilder>
        getAttachmentsOrBuilderList() {
      return attachments_;
    }
    /** <code>repeated .LoadableStudyAttachment attachments = 15;</code> */
    public int getAttachmentsCount() {
      return attachments_.size();
    }
    /** <code>repeated .LoadableStudyAttachment attachments = 15;</code> */
    public com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment getAttachments(
        int index) {
      return attachments_.get(index);
    }
    /** <code>repeated .LoadableStudyAttachment attachments = 15;</code> */
    public com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachmentOrBuilder
        getAttachmentsOrBuilder(int index) {
      return attachments_.get(index);
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
      if (duplicatedFromId_ != 0L) {
        output.writeInt64(12, duplicatedFromId_);
      }
      if (voyageId_ != 0L) {
        output.writeInt64(13, voyageId_);
      }
      if (vesselId_ != 0L) {
        output.writeInt64(14, vesselId_);
      }
      for (int i = 0; i < attachments_.size(); i++) {
        output.writeMessage(15, attachments_.get(i));
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
      if (duplicatedFromId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(12, duplicatedFromId_);
      }
      if (voyageId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(13, voyageId_);
      }
      if (vesselId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(14, vesselId_);
      }
      for (int i = 0; i < attachments_.size(); i++) {
        size += com.google.protobuf.CodedOutputStream.computeMessageSize(15, attachments_.get(i));
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
      if (getDuplicatedFromId() != other.getDuplicatedFromId()) return false;
      if (getVoyageId() != other.getVoyageId()) return false;
      if (getVesselId() != other.getVesselId()) return false;
      if (!getAttachmentsList().equals(other.getAttachmentsList())) return false;
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
      hash = (37 * hash) + DUPLICATEDFROMID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getDuplicatedFromId());
      hash = (37 * hash) + VOYAGEID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getVoyageId());
      hash = (37 * hash) + VESSELID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getVesselId());
      if (getAttachmentsCount() > 0) {
        hash = (37 * hash) + ATTACHMENTS_FIELD_NUMBER;
        hash = (53 * hash) + getAttachmentsList().hashCode();
      }
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
        if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {
          getAttachmentsFieldBuilder();
        }
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

        duplicatedFromId_ = 0L;

        voyageId_ = 0L;

        vesselId_ = 0L;

        if (attachmentsBuilder_ == null) {
          attachments_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          attachmentsBuilder_.clear();
        }
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
        int from_bitField0_ = bitField0_;
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
        result.duplicatedFromId_ = duplicatedFromId_;
        result.voyageId_ = voyageId_;
        result.vesselId_ = vesselId_;
        if (attachmentsBuilder_ == null) {
          if (((bitField0_ & 0x00000001) != 0)) {
            attachments_ = java.util.Collections.unmodifiableList(attachments_);
            bitField0_ = (bitField0_ & ~0x00000001);
          }
          result.attachments_ = attachments_;
        } else {
          result.attachments_ = attachmentsBuilder_.build();
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
        if (other.getDuplicatedFromId() != 0L) {
          setDuplicatedFromId(other.getDuplicatedFromId());
        }
        if (other.getVoyageId() != 0L) {
          setVoyageId(other.getVoyageId());
        }
        if (other.getVesselId() != 0L) {
          setVesselId(other.getVesselId());
        }
        if (attachmentsBuilder_ == null) {
          if (!other.attachments_.isEmpty()) {
            if (attachments_.isEmpty()) {
              attachments_ = other.attachments_;
              bitField0_ = (bitField0_ & ~0x00000001);
            } else {
              ensureAttachmentsIsMutable();
              attachments_.addAll(other.attachments_);
            }
            onChanged();
          }
        } else {
          if (!other.attachments_.isEmpty()) {
            if (attachmentsBuilder_.isEmpty()) {
              attachmentsBuilder_.dispose();
              attachmentsBuilder_ = null;
              attachments_ = other.attachments_;
              bitField0_ = (bitField0_ & ~0x00000001);
              attachmentsBuilder_ =
                  com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
                      ? getAttachmentsFieldBuilder()
                      : null;
            } else {
              attachmentsBuilder_.addAllMessages(other.attachments_);
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

      private long duplicatedFromId_;
      /**
       * <code>int64 duplicatedFromId = 12;</code>
       *
       * @return The duplicatedFromId.
       */
      public long getDuplicatedFromId() {
        return duplicatedFromId_;
      }
      /**
       * <code>int64 duplicatedFromId = 12;</code>
       *
       * @param value The duplicatedFromId to set.
       * @return This builder for chaining.
       */
      public Builder setDuplicatedFromId(long value) {

        duplicatedFromId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int64 duplicatedFromId = 12;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearDuplicatedFromId() {

        duplicatedFromId_ = 0L;
        onChanged();
        return this;
      }

      private long voyageId_;
      /**
       * <code>int64 voyageId = 13;</code>
       *
       * @return The voyageId.
       */
      public long getVoyageId() {
        return voyageId_;
      }
      /**
       * <code>int64 voyageId = 13;</code>
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
       * <code>int64 voyageId = 13;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearVoyageId() {

        voyageId_ = 0L;
        onChanged();
        return this;
      }

      private long vesselId_;
      /**
       * <code>int64 vesselId = 14;</code>
       *
       * @return The vesselId.
       */
      public long getVesselId() {
        return vesselId_;
      }
      /**
       * <code>int64 vesselId = 14;</code>
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
       * <code>int64 vesselId = 14;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearVesselId() {

        vesselId_ = 0L;
        onChanged();
        return this;
      }

      private java.util.List<com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment>
          attachments_ = java.util.Collections.emptyList();

      private void ensureAttachmentsIsMutable() {
        if (!((bitField0_ & 0x00000001) != 0)) {
          attachments_ =
              new java.util.ArrayList<
                  com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment>(attachments_);
          bitField0_ |= 0x00000001;
        }
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
              com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment,
              com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment.Builder,
              com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachmentOrBuilder>
          attachmentsBuilder_;

      /** <code>repeated .LoadableStudyAttachment attachments = 15;</code> */
      public java.util.List<com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment>
          getAttachmentsList() {
        if (attachmentsBuilder_ == null) {
          return java.util.Collections.unmodifiableList(attachments_);
        } else {
          return attachmentsBuilder_.getMessageList();
        }
      }
      /** <code>repeated .LoadableStudyAttachment attachments = 15;</code> */
      public int getAttachmentsCount() {
        if (attachmentsBuilder_ == null) {
          return attachments_.size();
        } else {
          return attachmentsBuilder_.getCount();
        }
      }
      /** <code>repeated .LoadableStudyAttachment attachments = 15;</code> */
      public com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment getAttachments(
          int index) {
        if (attachmentsBuilder_ == null) {
          return attachments_.get(index);
        } else {
          return attachmentsBuilder_.getMessage(index);
        }
      }
      /** <code>repeated .LoadableStudyAttachment attachments = 15;</code> */
      public Builder setAttachments(
          int index, com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment value) {
        if (attachmentsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureAttachmentsIsMutable();
          attachments_.set(index, value);
          onChanged();
        } else {
          attachmentsBuilder_.setMessage(index, value);
        }
        return this;
      }
      /** <code>repeated .LoadableStudyAttachment attachments = 15;</code> */
      public Builder setAttachments(
          int index,
          com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment.Builder
              builderForValue) {
        if (attachmentsBuilder_ == null) {
          ensureAttachmentsIsMutable();
          attachments_.set(index, builderForValue.build());
          onChanged();
        } else {
          attachmentsBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .LoadableStudyAttachment attachments = 15;</code> */
      public Builder addAttachments(
          com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment value) {
        if (attachmentsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureAttachmentsIsMutable();
          attachments_.add(value);
          onChanged();
        } else {
          attachmentsBuilder_.addMessage(value);
        }
        return this;
      }
      /** <code>repeated .LoadableStudyAttachment attachments = 15;</code> */
      public Builder addAttachments(
          int index, com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment value) {
        if (attachmentsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureAttachmentsIsMutable();
          attachments_.add(index, value);
          onChanged();
        } else {
          attachmentsBuilder_.addMessage(index, value);
        }
        return this;
      }
      /** <code>repeated .LoadableStudyAttachment attachments = 15;</code> */
      public Builder addAttachments(
          com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment.Builder
              builderForValue) {
        if (attachmentsBuilder_ == null) {
          ensureAttachmentsIsMutable();
          attachments_.add(builderForValue.build());
          onChanged();
        } else {
          attachmentsBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .LoadableStudyAttachment attachments = 15;</code> */
      public Builder addAttachments(
          int index,
          com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment.Builder
              builderForValue) {
        if (attachmentsBuilder_ == null) {
          ensureAttachmentsIsMutable();
          attachments_.add(index, builderForValue.build());
          onChanged();
        } else {
          attachmentsBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .LoadableStudyAttachment attachments = 15;</code> */
      public Builder addAllAttachments(
          java.lang.Iterable<
                  ? extends com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment>
              values) {
        if (attachmentsBuilder_ == null) {
          ensureAttachmentsIsMutable();
          com.google.protobuf.AbstractMessageLite.Builder.addAll(values, attachments_);
          onChanged();
        } else {
          attachmentsBuilder_.addAllMessages(values);
        }
        return this;
      }
      /** <code>repeated .LoadableStudyAttachment attachments = 15;</code> */
      public Builder clearAttachments() {
        if (attachmentsBuilder_ == null) {
          attachments_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
          onChanged();
        } else {
          attachmentsBuilder_.clear();
        }
        return this;
      }
      /** <code>repeated .LoadableStudyAttachment attachments = 15;</code> */
      public Builder removeAttachments(int index) {
        if (attachmentsBuilder_ == null) {
          ensureAttachmentsIsMutable();
          attachments_.remove(index);
          onChanged();
        } else {
          attachmentsBuilder_.remove(index);
        }
        return this;
      }
      /** <code>repeated .LoadableStudyAttachment attachments = 15;</code> */
      public com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment.Builder
          getAttachmentsBuilder(int index) {
        return getAttachmentsFieldBuilder().getBuilder(index);
      }
      /** <code>repeated .LoadableStudyAttachment attachments = 15;</code> */
      public com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachmentOrBuilder
          getAttachmentsOrBuilder(int index) {
        if (attachmentsBuilder_ == null) {
          return attachments_.get(index);
        } else {
          return attachmentsBuilder_.getMessageOrBuilder(index);
        }
      }
      /** <code>repeated .LoadableStudyAttachment attachments = 15;</code> */
      public java.util.List<
              ? extends com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachmentOrBuilder>
          getAttachmentsOrBuilderList() {
        if (attachmentsBuilder_ != null) {
          return attachmentsBuilder_.getMessageOrBuilderList();
        } else {
          return java.util.Collections.unmodifiableList(attachments_);
        }
      }
      /** <code>repeated .LoadableStudyAttachment attachments = 15;</code> */
      public com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment.Builder
          addAttachmentsBuilder() {
        return getAttachmentsFieldBuilder()
            .addBuilder(
                com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment
                    .getDefaultInstance());
      }
      /** <code>repeated .LoadableStudyAttachment attachments = 15;</code> */
      public com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment.Builder
          addAttachmentsBuilder(int index) {
        return getAttachmentsFieldBuilder()
            .addBuilder(
                index,
                com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment
                    .getDefaultInstance());
      }
      /** <code>repeated .LoadableStudyAttachment attachments = 15;</code> */
      public java.util.List<
              com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment.Builder>
          getAttachmentsBuilderList() {
        return getAttachmentsFieldBuilder().getBuilderList();
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
              com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment,
              com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment.Builder,
              com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachmentOrBuilder>
          getAttachmentsFieldBuilder() {
        if (attachmentsBuilder_ == null) {
          attachmentsBuilder_ =
              new com.google.protobuf.RepeatedFieldBuilderV3<
                  com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment,
                  com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachment.Builder,
                  com.cpdss.common.generated.LoadableStudy.LoadableStudyAttachmentOrBuilder>(
                  attachments_,
                  ((bitField0_ & 0x00000001) != 0),
                  getParentForChildren(),
                  isClean());
          attachments_ = null;
        }
        return attachmentsBuilder_;
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

    /**
     * <code>int64 id = 3;</code>
     *
     * @return The id.
     */
    long getId();
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
      for (int i = 0; i < loadableStudies_.size(); i++) {
        output.writeMessage(2, loadableStudies_.get(i));
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
      for (int i = 0; i < loadableStudies_.size(); i++) {
        size +=
            com.google.protobuf.CodedOutputStream.computeMessageSize(2, loadableStudies_.get(i));
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
      if (getLoadableStudiesCount() > 0) {
        hash = (37 * hash) + LOADABLESTUDIES_FIELD_NUMBER;
        hash = (53 * hash) + getLoadableStudiesList().hashCode();
      }
      hash = (37 * hash) + ID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getId());
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
        id_ = 0L;

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

  public interface LoadingPortDetailOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:LoadingPortDetail)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int64 portId = 1;</code>
     *
     * @return The portId.
     */
    long getPortId();

    /**
     * <code>string quantity = 2;</code>
     *
     * @return The quantity.
     */
    java.lang.String getQuantity();
    /**
     * <code>string quantity = 2;</code>
     *
     * @return The bytes for quantity.
     */
    com.google.protobuf.ByteString getQuantityBytes();
  }
  /** Protobuf type {@code LoadingPortDetail} */
  public static final class LoadingPortDetail extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:LoadingPortDetail)
      LoadingPortDetailOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use LoadingPortDetail.newBuilder() to construct.
    private LoadingPortDetail(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private LoadingPortDetail() {
      quantity_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new LoadingPortDetail();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private LoadingPortDetail(
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
            case 18:
              {
                java.lang.String s = input.readStringRequireUtf8();

                quantity_ = s;
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
      return com.cpdss.common.generated.LoadableStudy.internal_static_LoadingPortDetail_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.LoadableStudy
          .internal_static_LoadingPortDetail_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.LoadableStudy.LoadingPortDetail.class,
              com.cpdss.common.generated.LoadableStudy.LoadingPortDetail.Builder.class);
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

    public static final int QUANTITY_FIELD_NUMBER = 2;
    private volatile java.lang.Object quantity_;
    /**
     * <code>string quantity = 2;</code>
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
     * <code>string quantity = 2;</code>
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
      if (!getQuantityBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, quantity_);
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
      if (!getQuantityBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, quantity_);
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
      if (!(obj instanceof com.cpdss.common.generated.LoadableStudy.LoadingPortDetail)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.LoadableStudy.LoadingPortDetail other =
          (com.cpdss.common.generated.LoadableStudy.LoadingPortDetail) obj;

      if (getPortId() != other.getPortId()) return false;
      if (!getQuantity().equals(other.getQuantity())) return false;
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
      hash = (37 * hash) + QUANTITY_FIELD_NUMBER;
      hash = (53 * hash) + getQuantity().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadingPortDetail parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadingPortDetail parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadingPortDetail parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadingPortDetail parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadingPortDetail parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadingPortDetail parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadingPortDetail parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadingPortDetail parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadingPortDetail parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadingPortDetail parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadingPortDetail parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadingPortDetail parseFrom(
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
        com.cpdss.common.generated.LoadableStudy.LoadingPortDetail prototype) {
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
    /** Protobuf type {@code LoadingPortDetail} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:LoadingPortDetail)
        com.cpdss.common.generated.LoadableStudy.LoadingPortDetailOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.LoadableStudy
            .internal_static_LoadingPortDetail_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.LoadableStudy
            .internal_static_LoadingPortDetail_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.LoadableStudy.LoadingPortDetail.class,
                com.cpdss.common.generated.LoadableStudy.LoadingPortDetail.Builder.class);
      }

      // Construct using com.cpdss.common.generated.LoadableStudy.LoadingPortDetail.newBuilder()
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

        quantity_ = "";

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.LoadableStudy
            .internal_static_LoadingPortDetail_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.LoadingPortDetail
          getDefaultInstanceForType() {
        return com.cpdss.common.generated.LoadableStudy.LoadingPortDetail.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.LoadingPortDetail build() {
        com.cpdss.common.generated.LoadableStudy.LoadingPortDetail result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.LoadingPortDetail buildPartial() {
        com.cpdss.common.generated.LoadableStudy.LoadingPortDetail result =
            new com.cpdss.common.generated.LoadableStudy.LoadingPortDetail(this);
        result.portId_ = portId_;
        result.quantity_ = quantity_;
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
        if (other instanceof com.cpdss.common.generated.LoadableStudy.LoadingPortDetail) {
          return mergeFrom((com.cpdss.common.generated.LoadableStudy.LoadingPortDetail) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.cpdss.common.generated.LoadableStudy.LoadingPortDetail other) {
        if (other
            == com.cpdss.common.generated.LoadableStudy.LoadingPortDetail.getDefaultInstance())
          return this;
        if (other.getPortId() != 0L) {
          setPortId(other.getPortId());
        }
        if (!other.getQuantity().isEmpty()) {
          quantity_ = other.quantity_;
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
        com.cpdss.common.generated.LoadableStudy.LoadingPortDetail parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.LoadableStudy.LoadingPortDetail) e.getUnfinishedMessage();
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

      private java.lang.Object quantity_ = "";
      /**
       * <code>string quantity = 2;</code>
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
       * <code>string quantity = 2;</code>
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
       * <code>string quantity = 2;</code>
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
       * <code>string quantity = 2;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearQuantity() {

        quantity_ = getDefaultInstance().getQuantity();
        onChanged();
        return this;
      }
      /**
       * <code>string quantity = 2;</code>
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

      // @@protoc_insertion_point(builder_scope:LoadingPortDetail)
    }

    // @@protoc_insertion_point(class_scope:LoadingPortDetail)
    private static final com.cpdss.common.generated.LoadableStudy.LoadingPortDetail
        DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.LoadableStudy.LoadingPortDetail();
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadingPortDetail getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<LoadingPortDetail> PARSER =
        new com.google.protobuf.AbstractParser<LoadingPortDetail>() {
          @java.lang.Override
          public LoadingPortDetail parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new LoadingPortDetail(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<LoadingPortDetail> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<LoadingPortDetail> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.LoadableStudy.LoadingPortDetail getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface segregationDetailOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:segregationDetail)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int64 id = 1;</code>
     *
     * @return The id.
     */
    long getId();

    /**
     * <code>string value = 2;</code>
     *
     * @return The value.
     */
    java.lang.String getValue();
    /**
     * <code>string value = 2;</code>
     *
     * @return The bytes for value.
     */
    com.google.protobuf.ByteString getValueBytes();
  }
  /** Protobuf type {@code segregationDetail} */
  public static final class segregationDetail extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:segregationDetail)
      segregationDetailOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use segregationDetail.newBuilder() to construct.
    private segregationDetail(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private segregationDetail() {
      value_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new segregationDetail();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private segregationDetail(
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

                value_ = s;
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
      return com.cpdss.common.generated.LoadableStudy.internal_static_segregationDetail_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.LoadableStudy
          .internal_static_segregationDetail_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.LoadableStudy.segregationDetail.class,
              com.cpdss.common.generated.LoadableStudy.segregationDetail.Builder.class);
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

    public static final int VALUE_FIELD_NUMBER = 2;
    private volatile java.lang.Object value_;
    /**
     * <code>string value = 2;</code>
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
     * <code>string value = 2;</code>
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
      if (!getValueBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, value_);
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
      if (!getValueBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, value_);
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
      if (!(obj instanceof com.cpdss.common.generated.LoadableStudy.segregationDetail)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.LoadableStudy.segregationDetail other =
          (com.cpdss.common.generated.LoadableStudy.segregationDetail) obj;

      if (getId() != other.getId()) return false;
      if (!getValue().equals(other.getValue())) return false;
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
      hash = (37 * hash) + VALUE_FIELD_NUMBER;
      hash = (53 * hash) + getValue().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.LoadableStudy.segregationDetail parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.segregationDetail parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.segregationDetail parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.segregationDetail parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.segregationDetail parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.segregationDetail parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.segregationDetail parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.segregationDetail parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.segregationDetail parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.segregationDetail parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.segregationDetail parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.segregationDetail parseFrom(
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
        com.cpdss.common.generated.LoadableStudy.segregationDetail prototype) {
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
    /** Protobuf type {@code segregationDetail} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:segregationDetail)
        com.cpdss.common.generated.LoadableStudy.segregationDetailOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.LoadableStudy
            .internal_static_segregationDetail_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.LoadableStudy
            .internal_static_segregationDetail_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.LoadableStudy.segregationDetail.class,
                com.cpdss.common.generated.LoadableStudy.segregationDetail.Builder.class);
      }

      // Construct using com.cpdss.common.generated.LoadableStudy.segregationDetail.newBuilder()
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

        value_ = "";

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.LoadableStudy
            .internal_static_segregationDetail_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.segregationDetail
          getDefaultInstanceForType() {
        return com.cpdss.common.generated.LoadableStudy.segregationDetail.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.segregationDetail build() {
        com.cpdss.common.generated.LoadableStudy.segregationDetail result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.segregationDetail buildPartial() {
        com.cpdss.common.generated.LoadableStudy.segregationDetail result =
            new com.cpdss.common.generated.LoadableStudy.segregationDetail(this);
        result.id_ = id_;
        result.value_ = value_;
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
        if (other instanceof com.cpdss.common.generated.LoadableStudy.segregationDetail) {
          return mergeFrom((com.cpdss.common.generated.LoadableStudy.segregationDetail) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.cpdss.common.generated.LoadableStudy.segregationDetail other) {
        if (other
            == com.cpdss.common.generated.LoadableStudy.segregationDetail.getDefaultInstance())
          return this;
        if (other.getId() != 0L) {
          setId(other.getId());
        }
        if (!other.getValue().isEmpty()) {
          value_ = other.value_;
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
        com.cpdss.common.generated.LoadableStudy.segregationDetail parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.LoadableStudy.segregationDetail) e.getUnfinishedMessage();
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

      private java.lang.Object value_ = "";
      /**
       * <code>string value = 2;</code>
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
       * <code>string value = 2;</code>
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
       * <code>string value = 2;</code>
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
       * <code>string value = 2;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearValue() {

        value_ = getDefaultInstance().getValue();
        onChanged();
        return this;
      }
      /**
       * <code>string value = 2;</code>
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

      // @@protoc_insertion_point(builder_scope:segregationDetail)
    }

    // @@protoc_insertion_point(class_scope:segregationDetail)
    private static final com.cpdss.common.generated.LoadableStudy.segregationDetail
        DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.LoadableStudy.segregationDetail();
    }

    public static com.cpdss.common.generated.LoadableStudy.segregationDetail getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<segregationDetail> PARSER =
        new com.google.protobuf.AbstractParser<segregationDetail>() {
          @java.lang.Override
          public segregationDetail parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new segregationDetail(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<segregationDetail> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<segregationDetail> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.LoadableStudy.segregationDetail getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface CargoNominationDetailOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:CargoNominationDetail)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int64 id = 1;</code>
     *
     * @return The id.
     */
    long getId();

    /**
     * <code>int64 loadableStudyId = 2;</code>
     *
     * @return The loadableStudyId.
     */
    long getLoadableStudyId();

    /**
     * <code>int64 priority = 3;</code>
     *
     * @return The priority.
     */
    long getPriority();

    /**
     * <code>string color = 4;</code>
     *
     * @return The color.
     */
    java.lang.String getColor();
    /**
     * <code>string color = 4;</code>
     *
     * @return The bytes for color.
     */
    com.google.protobuf.ByteString getColorBytes();

    /**
     * <code>int64 cargoId = 5;</code>
     *
     * @return The cargoId.
     */
    long getCargoId();

    /**
     * <code>string abbreviation = 6;</code>
     *
     * @return The abbreviation.
     */
    java.lang.String getAbbreviation();
    /**
     * <code>string abbreviation = 6;</code>
     *
     * @return The bytes for abbreviation.
     */
    com.google.protobuf.ByteString getAbbreviationBytes();

    /** <code>repeated .LoadingPortDetail loadingPortDetails = 7;</code> */
    java.util.List<com.cpdss.common.generated.LoadableStudy.LoadingPortDetail>
        getLoadingPortDetailsList();
    /** <code>repeated .LoadingPortDetail loadingPortDetails = 7;</code> */
    com.cpdss.common.generated.LoadableStudy.LoadingPortDetail getLoadingPortDetails(int index);
    /** <code>repeated .LoadingPortDetail loadingPortDetails = 7;</code> */
    int getLoadingPortDetailsCount();
    /** <code>repeated .LoadingPortDetail loadingPortDetails = 7;</code> */
    java.util.List<? extends com.cpdss.common.generated.LoadableStudy.LoadingPortDetailOrBuilder>
        getLoadingPortDetailsOrBuilderList();
    /** <code>repeated .LoadingPortDetail loadingPortDetails = 7;</code> */
    com.cpdss.common.generated.LoadableStudy.LoadingPortDetailOrBuilder
        getLoadingPortDetailsOrBuilder(int index);

    /**
     * <code>string maxTolerance = 8;</code>
     *
     * @return The maxTolerance.
     */
    java.lang.String getMaxTolerance();
    /**
     * <code>string maxTolerance = 8;</code>
     *
     * @return The bytes for maxTolerance.
     */
    com.google.protobuf.ByteString getMaxToleranceBytes();

    /**
     * <code>string minTolerance = 9;</code>
     *
     * @return The minTolerance.
     */
    java.lang.String getMinTolerance();
    /**
     * <code>string minTolerance = 9;</code>
     *
     * @return The bytes for minTolerance.
     */
    com.google.protobuf.ByteString getMinToleranceBytes();

    /**
     * <code>string apiEst = 10;</code>
     *
     * @return The apiEst.
     */
    java.lang.String getApiEst();
    /**
     * <code>string apiEst = 10;</code>
     *
     * @return The bytes for apiEst.
     */
    com.google.protobuf.ByteString getApiEstBytes();

    /**
     * <code>string tempEst = 11;</code>
     *
     * @return The tempEst.
     */
    java.lang.String getTempEst();
    /**
     * <code>string tempEst = 11;</code>
     *
     * @return The bytes for tempEst.
     */
    com.google.protobuf.ByteString getTempEstBytes();

    /**
     * <code>int64 segregationId = 12;</code>
     *
     * @return The segregationId.
     */
    long getSegregationId();
  }
  /** Protobuf type {@code CargoNominationDetail} */
  public static final class CargoNominationDetail extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:CargoNominationDetail)
      CargoNominationDetailOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use CargoNominationDetail.newBuilder() to construct.
    private CargoNominationDetail(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private CargoNominationDetail() {
      color_ = "";
      abbreviation_ = "";
      loadingPortDetails_ = java.util.Collections.emptyList();
      maxTolerance_ = "";
      minTolerance_ = "";
      apiEst_ = "";
      tempEst_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new CargoNominationDetail();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private CargoNominationDetail(
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
                loadableStudyId_ = input.readInt64();
                break;
              }
            case 24:
              {
                priority_ = input.readInt64();
                break;
              }
            case 34:
              {
                java.lang.String s = input.readStringRequireUtf8();

                color_ = s;
                break;
              }
            case 40:
              {
                cargoId_ = input.readInt64();
                break;
              }
            case 50:
              {
                java.lang.String s = input.readStringRequireUtf8();

                abbreviation_ = s;
                break;
              }
            case 58:
              {
                if (!((mutable_bitField0_ & 0x00000001) != 0)) {
                  loadingPortDetails_ =
                      new java.util.ArrayList<
                          com.cpdss.common.generated.LoadableStudy.LoadingPortDetail>();
                  mutable_bitField0_ |= 0x00000001;
                }
                loadingPortDetails_.add(
                    input.readMessage(
                        com.cpdss.common.generated.LoadableStudy.LoadingPortDetail.parser(),
                        extensionRegistry));
                break;
              }
            case 66:
              {
                java.lang.String s = input.readStringRequireUtf8();

                maxTolerance_ = s;
                break;
              }
            case 74:
              {
                java.lang.String s = input.readStringRequireUtf8();

                minTolerance_ = s;
                break;
              }
            case 82:
              {
                java.lang.String s = input.readStringRequireUtf8();

                apiEst_ = s;
                break;
              }
            case 90:
              {
                java.lang.String s = input.readStringRequireUtf8();

                tempEst_ = s;
                break;
              }
            case 96:
              {
                segregationId_ = input.readInt64();
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
          loadingPortDetails_ = java.util.Collections.unmodifiableList(loadingPortDetails_);
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }

    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.cpdss.common.generated.LoadableStudy
          .internal_static_CargoNominationDetail_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.LoadableStudy
          .internal_static_CargoNominationDetail_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.LoadableStudy.CargoNominationDetail.class,
              com.cpdss.common.generated.LoadableStudy.CargoNominationDetail.Builder.class);
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

    public static final int LOADABLESTUDYID_FIELD_NUMBER = 2;
    private long loadableStudyId_;
    /**
     * <code>int64 loadableStudyId = 2;</code>
     *
     * @return The loadableStudyId.
     */
    public long getLoadableStudyId() {
      return loadableStudyId_;
    }

    public static final int PRIORITY_FIELD_NUMBER = 3;
    private long priority_;
    /**
     * <code>int64 priority = 3;</code>
     *
     * @return The priority.
     */
    public long getPriority() {
      return priority_;
    }

    public static final int COLOR_FIELD_NUMBER = 4;
    private volatile java.lang.Object color_;
    /**
     * <code>string color = 4;</code>
     *
     * @return The color.
     */
    public java.lang.String getColor() {
      java.lang.Object ref = color_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        color_ = s;
        return s;
      }
    }
    /**
     * <code>string color = 4;</code>
     *
     * @return The bytes for color.
     */
    public com.google.protobuf.ByteString getColorBytes() {
      java.lang.Object ref = color_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        color_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int CARGOID_FIELD_NUMBER = 5;
    private long cargoId_;
    /**
     * <code>int64 cargoId = 5;</code>
     *
     * @return The cargoId.
     */
    public long getCargoId() {
      return cargoId_;
    }

    public static final int ABBREVIATION_FIELD_NUMBER = 6;
    private volatile java.lang.Object abbreviation_;
    /**
     * <code>string abbreviation = 6;</code>
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
     * <code>string abbreviation = 6;</code>
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

    public static final int LOADINGPORTDETAILS_FIELD_NUMBER = 7;
    private java.util.List<com.cpdss.common.generated.LoadableStudy.LoadingPortDetail>
        loadingPortDetails_;
    /** <code>repeated .LoadingPortDetail loadingPortDetails = 7;</code> */
    public java.util.List<com.cpdss.common.generated.LoadableStudy.LoadingPortDetail>
        getLoadingPortDetailsList() {
      return loadingPortDetails_;
    }
    /** <code>repeated .LoadingPortDetail loadingPortDetails = 7;</code> */
    public java.util.List<
            ? extends com.cpdss.common.generated.LoadableStudy.LoadingPortDetailOrBuilder>
        getLoadingPortDetailsOrBuilderList() {
      return loadingPortDetails_;
    }
    /** <code>repeated .LoadingPortDetail loadingPortDetails = 7;</code> */
    public int getLoadingPortDetailsCount() {
      return loadingPortDetails_.size();
    }
    /** <code>repeated .LoadingPortDetail loadingPortDetails = 7;</code> */
    public com.cpdss.common.generated.LoadableStudy.LoadingPortDetail getLoadingPortDetails(
        int index) {
      return loadingPortDetails_.get(index);
    }
    /** <code>repeated .LoadingPortDetail loadingPortDetails = 7;</code> */
    public com.cpdss.common.generated.LoadableStudy.LoadingPortDetailOrBuilder
        getLoadingPortDetailsOrBuilder(int index) {
      return loadingPortDetails_.get(index);
    }

    public static final int MAXTOLERANCE_FIELD_NUMBER = 8;
    private volatile java.lang.Object maxTolerance_;
    /**
     * <code>string maxTolerance = 8;</code>
     *
     * @return The maxTolerance.
     */
    public java.lang.String getMaxTolerance() {
      java.lang.Object ref = maxTolerance_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        maxTolerance_ = s;
        return s;
      }
    }
    /**
     * <code>string maxTolerance = 8;</code>
     *
     * @return The bytes for maxTolerance.
     */
    public com.google.protobuf.ByteString getMaxToleranceBytes() {
      java.lang.Object ref = maxTolerance_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        maxTolerance_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int MINTOLERANCE_FIELD_NUMBER = 9;
    private volatile java.lang.Object minTolerance_;
    /**
     * <code>string minTolerance = 9;</code>
     *
     * @return The minTolerance.
     */
    public java.lang.String getMinTolerance() {
      java.lang.Object ref = minTolerance_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        minTolerance_ = s;
        return s;
      }
    }
    /**
     * <code>string minTolerance = 9;</code>
     *
     * @return The bytes for minTolerance.
     */
    public com.google.protobuf.ByteString getMinToleranceBytes() {
      java.lang.Object ref = minTolerance_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        minTolerance_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int APIEST_FIELD_NUMBER = 10;
    private volatile java.lang.Object apiEst_;
    /**
     * <code>string apiEst = 10;</code>
     *
     * @return The apiEst.
     */
    public java.lang.String getApiEst() {
      java.lang.Object ref = apiEst_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        apiEst_ = s;
        return s;
      }
    }
    /**
     * <code>string apiEst = 10;</code>
     *
     * @return The bytes for apiEst.
     */
    public com.google.protobuf.ByteString getApiEstBytes() {
      java.lang.Object ref = apiEst_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        apiEst_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int TEMPEST_FIELD_NUMBER = 11;
    private volatile java.lang.Object tempEst_;
    /**
     * <code>string tempEst = 11;</code>
     *
     * @return The tempEst.
     */
    public java.lang.String getTempEst() {
      java.lang.Object ref = tempEst_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        tempEst_ = s;
        return s;
      }
    }
    /**
     * <code>string tempEst = 11;</code>
     *
     * @return The bytes for tempEst.
     */
    public com.google.protobuf.ByteString getTempEstBytes() {
      java.lang.Object ref = tempEst_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        tempEst_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int SEGREGATIONID_FIELD_NUMBER = 12;
    private long segregationId_;
    /**
     * <code>int64 segregationId = 12;</code>
     *
     * @return The segregationId.
     */
    public long getSegregationId() {
      return segregationId_;
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
      if (loadableStudyId_ != 0L) {
        output.writeInt64(2, loadableStudyId_);
      }
      if (priority_ != 0L) {
        output.writeInt64(3, priority_);
      }
      if (!getColorBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 4, color_);
      }
      if (cargoId_ != 0L) {
        output.writeInt64(5, cargoId_);
      }
      if (!getAbbreviationBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 6, abbreviation_);
      }
      for (int i = 0; i < loadingPortDetails_.size(); i++) {
        output.writeMessage(7, loadingPortDetails_.get(i));
      }
      if (!getMaxToleranceBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 8, maxTolerance_);
      }
      if (!getMinToleranceBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 9, minTolerance_);
      }
      if (!getApiEstBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 10, apiEst_);
      }
      if (!getTempEstBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 11, tempEst_);
      }
      if (segregationId_ != 0L) {
        output.writeInt64(12, segregationId_);
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
      if (loadableStudyId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(2, loadableStudyId_);
      }
      if (priority_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(3, priority_);
      }
      if (!getColorBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, color_);
      }
      if (cargoId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(5, cargoId_);
      }
      if (!getAbbreviationBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(6, abbreviation_);
      }
      for (int i = 0; i < loadingPortDetails_.size(); i++) {
        size +=
            com.google.protobuf.CodedOutputStream.computeMessageSize(7, loadingPortDetails_.get(i));
      }
      if (!getMaxToleranceBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(8, maxTolerance_);
      }
      if (!getMinToleranceBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(9, minTolerance_);
      }
      if (!getApiEstBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(10, apiEst_);
      }
      if (!getTempEstBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(11, tempEst_);
      }
      if (segregationId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(12, segregationId_);
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
      if (!(obj instanceof com.cpdss.common.generated.LoadableStudy.CargoNominationDetail)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.LoadableStudy.CargoNominationDetail other =
          (com.cpdss.common.generated.LoadableStudy.CargoNominationDetail) obj;

      if (getId() != other.getId()) return false;
      if (getLoadableStudyId() != other.getLoadableStudyId()) return false;
      if (getPriority() != other.getPriority()) return false;
      if (!getColor().equals(other.getColor())) return false;
      if (getCargoId() != other.getCargoId()) return false;
      if (!getAbbreviation().equals(other.getAbbreviation())) return false;
      if (!getLoadingPortDetailsList().equals(other.getLoadingPortDetailsList())) return false;
      if (!getMaxTolerance().equals(other.getMaxTolerance())) return false;
      if (!getMinTolerance().equals(other.getMinTolerance())) return false;
      if (!getApiEst().equals(other.getApiEst())) return false;
      if (!getTempEst().equals(other.getTempEst())) return false;
      if (getSegregationId() != other.getSegregationId()) return false;
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
      hash = (37 * hash) + LOADABLESTUDYID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getLoadableStudyId());
      hash = (37 * hash) + PRIORITY_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getPriority());
      hash = (37 * hash) + COLOR_FIELD_NUMBER;
      hash = (53 * hash) + getColor().hashCode();
      hash = (37 * hash) + CARGOID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getCargoId());
      hash = (37 * hash) + ABBREVIATION_FIELD_NUMBER;
      hash = (53 * hash) + getAbbreviation().hashCode();
      if (getLoadingPortDetailsCount() > 0) {
        hash = (37 * hash) + LOADINGPORTDETAILS_FIELD_NUMBER;
        hash = (53 * hash) + getLoadingPortDetailsList().hashCode();
      }
      hash = (37 * hash) + MAXTOLERANCE_FIELD_NUMBER;
      hash = (53 * hash) + getMaxTolerance().hashCode();
      hash = (37 * hash) + MINTOLERANCE_FIELD_NUMBER;
      hash = (53 * hash) + getMinTolerance().hashCode();
      hash = (37 * hash) + APIEST_FIELD_NUMBER;
      hash = (53 * hash) + getApiEst().hashCode();
      hash = (37 * hash) + TEMPEST_FIELD_NUMBER;
      hash = (53 * hash) + getTempEst().hashCode();
      hash = (37 * hash) + SEGREGATIONID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getSegregationId());
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.LoadableStudy.CargoNominationDetail parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.CargoNominationDetail parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.CargoNominationDetail parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.CargoNominationDetail parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.CargoNominationDetail parseFrom(
        byte[] data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.CargoNominationDetail parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.CargoNominationDetail parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.CargoNominationDetail parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.CargoNominationDetail parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.CargoNominationDetail parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.CargoNominationDetail parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.CargoNominationDetail parseFrom(
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
        com.cpdss.common.generated.LoadableStudy.CargoNominationDetail prototype) {
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
    /** Protobuf type {@code CargoNominationDetail} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:CargoNominationDetail)
        com.cpdss.common.generated.LoadableStudy.CargoNominationDetailOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.LoadableStudy
            .internal_static_CargoNominationDetail_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.LoadableStudy
            .internal_static_CargoNominationDetail_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.LoadableStudy.CargoNominationDetail.class,
                com.cpdss.common.generated.LoadableStudy.CargoNominationDetail.Builder.class);
      }

      // Construct using com.cpdss.common.generated.LoadableStudy.CargoNominationDetail.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {
          getLoadingPortDetailsFieldBuilder();
        }
      }

      @java.lang.Override
      public Builder clear() {
        super.clear();
        id_ = 0L;

        loadableStudyId_ = 0L;

        priority_ = 0L;

        color_ = "";

        cargoId_ = 0L;

        abbreviation_ = "";

        if (loadingPortDetailsBuilder_ == null) {
          loadingPortDetails_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          loadingPortDetailsBuilder_.clear();
        }
        maxTolerance_ = "";

        minTolerance_ = "";

        apiEst_ = "";

        tempEst_ = "";

        segregationId_ = 0L;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.LoadableStudy
            .internal_static_CargoNominationDetail_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.CargoNominationDetail
          getDefaultInstanceForType() {
        return com.cpdss.common.generated.LoadableStudy.CargoNominationDetail.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.CargoNominationDetail build() {
        com.cpdss.common.generated.LoadableStudy.CargoNominationDetail result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.CargoNominationDetail buildPartial() {
        com.cpdss.common.generated.LoadableStudy.CargoNominationDetail result =
            new com.cpdss.common.generated.LoadableStudy.CargoNominationDetail(this);
        int from_bitField0_ = bitField0_;
        result.id_ = id_;
        result.loadableStudyId_ = loadableStudyId_;
        result.priority_ = priority_;
        result.color_ = color_;
        result.cargoId_ = cargoId_;
        result.abbreviation_ = abbreviation_;
        if (loadingPortDetailsBuilder_ == null) {
          if (((bitField0_ & 0x00000001) != 0)) {
            loadingPortDetails_ = java.util.Collections.unmodifiableList(loadingPortDetails_);
            bitField0_ = (bitField0_ & ~0x00000001);
          }
          result.loadingPortDetails_ = loadingPortDetails_;
        } else {
          result.loadingPortDetails_ = loadingPortDetailsBuilder_.build();
        }
        result.maxTolerance_ = maxTolerance_;
        result.minTolerance_ = minTolerance_;
        result.apiEst_ = apiEst_;
        result.tempEst_ = tempEst_;
        result.segregationId_ = segregationId_;
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
        if (other instanceof com.cpdss.common.generated.LoadableStudy.CargoNominationDetail) {
          return mergeFrom((com.cpdss.common.generated.LoadableStudy.CargoNominationDetail) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(
          com.cpdss.common.generated.LoadableStudy.CargoNominationDetail other) {
        if (other
            == com.cpdss.common.generated.LoadableStudy.CargoNominationDetail.getDefaultInstance())
          return this;
        if (other.getId() != 0L) {
          setId(other.getId());
        }
        if (other.getLoadableStudyId() != 0L) {
          setLoadableStudyId(other.getLoadableStudyId());
        }
        if (other.getPriority() != 0L) {
          setPriority(other.getPriority());
        }
        if (!other.getColor().isEmpty()) {
          color_ = other.color_;
          onChanged();
        }
        if (other.getCargoId() != 0L) {
          setCargoId(other.getCargoId());
        }
        if (!other.getAbbreviation().isEmpty()) {
          abbreviation_ = other.abbreviation_;
          onChanged();
        }
        if (loadingPortDetailsBuilder_ == null) {
          if (!other.loadingPortDetails_.isEmpty()) {
            if (loadingPortDetails_.isEmpty()) {
              loadingPortDetails_ = other.loadingPortDetails_;
              bitField0_ = (bitField0_ & ~0x00000001);
            } else {
              ensureLoadingPortDetailsIsMutable();
              loadingPortDetails_.addAll(other.loadingPortDetails_);
            }
            onChanged();
          }
        } else {
          if (!other.loadingPortDetails_.isEmpty()) {
            if (loadingPortDetailsBuilder_.isEmpty()) {
              loadingPortDetailsBuilder_.dispose();
              loadingPortDetailsBuilder_ = null;
              loadingPortDetails_ = other.loadingPortDetails_;
              bitField0_ = (bitField0_ & ~0x00000001);
              loadingPortDetailsBuilder_ =
                  com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
                      ? getLoadingPortDetailsFieldBuilder()
                      : null;
            } else {
              loadingPortDetailsBuilder_.addAllMessages(other.loadingPortDetails_);
            }
          }
        }
        if (!other.getMaxTolerance().isEmpty()) {
          maxTolerance_ = other.maxTolerance_;
          onChanged();
        }
        if (!other.getMinTolerance().isEmpty()) {
          minTolerance_ = other.minTolerance_;
          onChanged();
        }
        if (!other.getApiEst().isEmpty()) {
          apiEst_ = other.apiEst_;
          onChanged();
        }
        if (!other.getTempEst().isEmpty()) {
          tempEst_ = other.tempEst_;
          onChanged();
        }
        if (other.getSegregationId() != 0L) {
          setSegregationId(other.getSegregationId());
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
        com.cpdss.common.generated.LoadableStudy.CargoNominationDetail parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.LoadableStudy.CargoNominationDetail)
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

      private long loadableStudyId_;
      /**
       * <code>int64 loadableStudyId = 2;</code>
       *
       * @return The loadableStudyId.
       */
      public long getLoadableStudyId() {
        return loadableStudyId_;
      }
      /**
       * <code>int64 loadableStudyId = 2;</code>
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
       * <code>int64 loadableStudyId = 2;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearLoadableStudyId() {

        loadableStudyId_ = 0L;
        onChanged();
        return this;
      }

      private long priority_;
      /**
       * <code>int64 priority = 3;</code>
       *
       * @return The priority.
       */
      public long getPriority() {
        return priority_;
      }
      /**
       * <code>int64 priority = 3;</code>
       *
       * @param value The priority to set.
       * @return This builder for chaining.
       */
      public Builder setPriority(long value) {

        priority_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int64 priority = 3;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearPriority() {

        priority_ = 0L;
        onChanged();
        return this;
      }

      private java.lang.Object color_ = "";
      /**
       * <code>string color = 4;</code>
       *
       * @return The color.
       */
      public java.lang.String getColor() {
        java.lang.Object ref = color_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          color_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string color = 4;</code>
       *
       * @return The bytes for color.
       */
      public com.google.protobuf.ByteString getColorBytes() {
        java.lang.Object ref = color_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          color_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string color = 4;</code>
       *
       * @param value The color to set.
       * @return This builder for chaining.
       */
      public Builder setColor(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        color_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string color = 4;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearColor() {

        color_ = getDefaultInstance().getColor();
        onChanged();
        return this;
      }
      /**
       * <code>string color = 4;</code>
       *
       * @param value The bytes for color to set.
       * @return This builder for chaining.
       */
      public Builder setColorBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        color_ = value;
        onChanged();
        return this;
      }

      private long cargoId_;
      /**
       * <code>int64 cargoId = 5;</code>
       *
       * @return The cargoId.
       */
      public long getCargoId() {
        return cargoId_;
      }
      /**
       * <code>int64 cargoId = 5;</code>
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
       * <code>int64 cargoId = 5;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearCargoId() {

        cargoId_ = 0L;
        onChanged();
        return this;
      }

      private java.lang.Object abbreviation_ = "";
      /**
       * <code>string abbreviation = 6;</code>
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
       * <code>string abbreviation = 6;</code>
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
       * <code>string abbreviation = 6;</code>
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
       * <code>string abbreviation = 6;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearAbbreviation() {

        abbreviation_ = getDefaultInstance().getAbbreviation();
        onChanged();
        return this;
      }
      /**
       * <code>string abbreviation = 6;</code>
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

      private java.util.List<com.cpdss.common.generated.LoadableStudy.LoadingPortDetail>
          loadingPortDetails_ = java.util.Collections.emptyList();

      private void ensureLoadingPortDetailsIsMutable() {
        if (!((bitField0_ & 0x00000001) != 0)) {
          loadingPortDetails_ =
              new java.util.ArrayList<com.cpdss.common.generated.LoadableStudy.LoadingPortDetail>(
                  loadingPortDetails_);
          bitField0_ |= 0x00000001;
        }
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
              com.cpdss.common.generated.LoadableStudy.LoadingPortDetail,
              com.cpdss.common.generated.LoadableStudy.LoadingPortDetail.Builder,
              com.cpdss.common.generated.LoadableStudy.LoadingPortDetailOrBuilder>
          loadingPortDetailsBuilder_;

      /** <code>repeated .LoadingPortDetail loadingPortDetails = 7;</code> */
      public java.util.List<com.cpdss.common.generated.LoadableStudy.LoadingPortDetail>
          getLoadingPortDetailsList() {
        if (loadingPortDetailsBuilder_ == null) {
          return java.util.Collections.unmodifiableList(loadingPortDetails_);
        } else {
          return loadingPortDetailsBuilder_.getMessageList();
        }
      }
      /** <code>repeated .LoadingPortDetail loadingPortDetails = 7;</code> */
      public int getLoadingPortDetailsCount() {
        if (loadingPortDetailsBuilder_ == null) {
          return loadingPortDetails_.size();
        } else {
          return loadingPortDetailsBuilder_.getCount();
        }
      }
      /** <code>repeated .LoadingPortDetail loadingPortDetails = 7;</code> */
      public com.cpdss.common.generated.LoadableStudy.LoadingPortDetail getLoadingPortDetails(
          int index) {
        if (loadingPortDetailsBuilder_ == null) {
          return loadingPortDetails_.get(index);
        } else {
          return loadingPortDetailsBuilder_.getMessage(index);
        }
      }
      /** <code>repeated .LoadingPortDetail loadingPortDetails = 7;</code> */
      public Builder setLoadingPortDetails(
          int index, com.cpdss.common.generated.LoadableStudy.LoadingPortDetail value) {
        if (loadingPortDetailsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureLoadingPortDetailsIsMutable();
          loadingPortDetails_.set(index, value);
          onChanged();
        } else {
          loadingPortDetailsBuilder_.setMessage(index, value);
        }
        return this;
      }
      /** <code>repeated .LoadingPortDetail loadingPortDetails = 7;</code> */
      public Builder setLoadingPortDetails(
          int index,
          com.cpdss.common.generated.LoadableStudy.LoadingPortDetail.Builder builderForValue) {
        if (loadingPortDetailsBuilder_ == null) {
          ensureLoadingPortDetailsIsMutable();
          loadingPortDetails_.set(index, builderForValue.build());
          onChanged();
        } else {
          loadingPortDetailsBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .LoadingPortDetail loadingPortDetails = 7;</code> */
      public Builder addLoadingPortDetails(
          com.cpdss.common.generated.LoadableStudy.LoadingPortDetail value) {
        if (loadingPortDetailsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureLoadingPortDetailsIsMutable();
          loadingPortDetails_.add(value);
          onChanged();
        } else {
          loadingPortDetailsBuilder_.addMessage(value);
        }
        return this;
      }
      /** <code>repeated .LoadingPortDetail loadingPortDetails = 7;</code> */
      public Builder addLoadingPortDetails(
          int index, com.cpdss.common.generated.LoadableStudy.LoadingPortDetail value) {
        if (loadingPortDetailsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureLoadingPortDetailsIsMutable();
          loadingPortDetails_.add(index, value);
          onChanged();
        } else {
          loadingPortDetailsBuilder_.addMessage(index, value);
        }
        return this;
      }
      /** <code>repeated .LoadingPortDetail loadingPortDetails = 7;</code> */
      public Builder addLoadingPortDetails(
          com.cpdss.common.generated.LoadableStudy.LoadingPortDetail.Builder builderForValue) {
        if (loadingPortDetailsBuilder_ == null) {
          ensureLoadingPortDetailsIsMutable();
          loadingPortDetails_.add(builderForValue.build());
          onChanged();
        } else {
          loadingPortDetailsBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .LoadingPortDetail loadingPortDetails = 7;</code> */
      public Builder addLoadingPortDetails(
          int index,
          com.cpdss.common.generated.LoadableStudy.LoadingPortDetail.Builder builderForValue) {
        if (loadingPortDetailsBuilder_ == null) {
          ensureLoadingPortDetailsIsMutable();
          loadingPortDetails_.add(index, builderForValue.build());
          onChanged();
        } else {
          loadingPortDetailsBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .LoadingPortDetail loadingPortDetails = 7;</code> */
      public Builder addAllLoadingPortDetails(
          java.lang.Iterable<? extends com.cpdss.common.generated.LoadableStudy.LoadingPortDetail>
              values) {
        if (loadingPortDetailsBuilder_ == null) {
          ensureLoadingPortDetailsIsMutable();
          com.google.protobuf.AbstractMessageLite.Builder.addAll(values, loadingPortDetails_);
          onChanged();
        } else {
          loadingPortDetailsBuilder_.addAllMessages(values);
        }
        return this;
      }
      /** <code>repeated .LoadingPortDetail loadingPortDetails = 7;</code> */
      public Builder clearLoadingPortDetails() {
        if (loadingPortDetailsBuilder_ == null) {
          loadingPortDetails_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
          onChanged();
        } else {
          loadingPortDetailsBuilder_.clear();
        }
        return this;
      }
      /** <code>repeated .LoadingPortDetail loadingPortDetails = 7;</code> */
      public Builder removeLoadingPortDetails(int index) {
        if (loadingPortDetailsBuilder_ == null) {
          ensureLoadingPortDetailsIsMutable();
          loadingPortDetails_.remove(index);
          onChanged();
        } else {
          loadingPortDetailsBuilder_.remove(index);
        }
        return this;
      }
      /** <code>repeated .LoadingPortDetail loadingPortDetails = 7;</code> */
      public com.cpdss.common.generated.LoadableStudy.LoadingPortDetail.Builder
          getLoadingPortDetailsBuilder(int index) {
        return getLoadingPortDetailsFieldBuilder().getBuilder(index);
      }
      /** <code>repeated .LoadingPortDetail loadingPortDetails = 7;</code> */
      public com.cpdss.common.generated.LoadableStudy.LoadingPortDetailOrBuilder
          getLoadingPortDetailsOrBuilder(int index) {
        if (loadingPortDetailsBuilder_ == null) {
          return loadingPortDetails_.get(index);
        } else {
          return loadingPortDetailsBuilder_.getMessageOrBuilder(index);
        }
      }
      /** <code>repeated .LoadingPortDetail loadingPortDetails = 7;</code> */
      public java.util.List<
              ? extends com.cpdss.common.generated.LoadableStudy.LoadingPortDetailOrBuilder>
          getLoadingPortDetailsOrBuilderList() {
        if (loadingPortDetailsBuilder_ != null) {
          return loadingPortDetailsBuilder_.getMessageOrBuilderList();
        } else {
          return java.util.Collections.unmodifiableList(loadingPortDetails_);
        }
      }
      /** <code>repeated .LoadingPortDetail loadingPortDetails = 7;</code> */
      public com.cpdss.common.generated.LoadableStudy.LoadingPortDetail.Builder
          addLoadingPortDetailsBuilder() {
        return getLoadingPortDetailsFieldBuilder()
            .addBuilder(
                com.cpdss.common.generated.LoadableStudy.LoadingPortDetail.getDefaultInstance());
      }
      /** <code>repeated .LoadingPortDetail loadingPortDetails = 7;</code> */
      public com.cpdss.common.generated.LoadableStudy.LoadingPortDetail.Builder
          addLoadingPortDetailsBuilder(int index) {
        return getLoadingPortDetailsFieldBuilder()
            .addBuilder(
                index,
                com.cpdss.common.generated.LoadableStudy.LoadingPortDetail.getDefaultInstance());
      }
      /** <code>repeated .LoadingPortDetail loadingPortDetails = 7;</code> */
      public java.util.List<com.cpdss.common.generated.LoadableStudy.LoadingPortDetail.Builder>
          getLoadingPortDetailsBuilderList() {
        return getLoadingPortDetailsFieldBuilder().getBuilderList();
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
              com.cpdss.common.generated.LoadableStudy.LoadingPortDetail,
              com.cpdss.common.generated.LoadableStudy.LoadingPortDetail.Builder,
              com.cpdss.common.generated.LoadableStudy.LoadingPortDetailOrBuilder>
          getLoadingPortDetailsFieldBuilder() {
        if (loadingPortDetailsBuilder_ == null) {
          loadingPortDetailsBuilder_ =
              new com.google.protobuf.RepeatedFieldBuilderV3<
                  com.cpdss.common.generated.LoadableStudy.LoadingPortDetail,
                  com.cpdss.common.generated.LoadableStudy.LoadingPortDetail.Builder,
                  com.cpdss.common.generated.LoadableStudy.LoadingPortDetailOrBuilder>(
                  loadingPortDetails_,
                  ((bitField0_ & 0x00000001) != 0),
                  getParentForChildren(),
                  isClean());
          loadingPortDetails_ = null;
        }
        return loadingPortDetailsBuilder_;
      }

      private java.lang.Object maxTolerance_ = "";
      /**
       * <code>string maxTolerance = 8;</code>
       *
       * @return The maxTolerance.
       */
      public java.lang.String getMaxTolerance() {
        java.lang.Object ref = maxTolerance_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          maxTolerance_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string maxTolerance = 8;</code>
       *
       * @return The bytes for maxTolerance.
       */
      public com.google.protobuf.ByteString getMaxToleranceBytes() {
        java.lang.Object ref = maxTolerance_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          maxTolerance_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string maxTolerance = 8;</code>
       *
       * @param value The maxTolerance to set.
       * @return This builder for chaining.
       */
      public Builder setMaxTolerance(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        maxTolerance_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string maxTolerance = 8;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearMaxTolerance() {

        maxTolerance_ = getDefaultInstance().getMaxTolerance();
        onChanged();
        return this;
      }
      /**
       * <code>string maxTolerance = 8;</code>
       *
       * @param value The bytes for maxTolerance to set.
       * @return This builder for chaining.
       */
      public Builder setMaxToleranceBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        maxTolerance_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object minTolerance_ = "";
      /**
       * <code>string minTolerance = 9;</code>
       *
       * @return The minTolerance.
       */
      public java.lang.String getMinTolerance() {
        java.lang.Object ref = minTolerance_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          minTolerance_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string minTolerance = 9;</code>
       *
       * @return The bytes for minTolerance.
       */
      public com.google.protobuf.ByteString getMinToleranceBytes() {
        java.lang.Object ref = minTolerance_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          minTolerance_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string minTolerance = 9;</code>
       *
       * @param value The minTolerance to set.
       * @return This builder for chaining.
       */
      public Builder setMinTolerance(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        minTolerance_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string minTolerance = 9;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearMinTolerance() {

        minTolerance_ = getDefaultInstance().getMinTolerance();
        onChanged();
        return this;
      }
      /**
       * <code>string minTolerance = 9;</code>
       *
       * @param value The bytes for minTolerance to set.
       * @return This builder for chaining.
       */
      public Builder setMinToleranceBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        minTolerance_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object apiEst_ = "";
      /**
       * <code>string apiEst = 10;</code>
       *
       * @return The apiEst.
       */
      public java.lang.String getApiEst() {
        java.lang.Object ref = apiEst_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          apiEst_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string apiEst = 10;</code>
       *
       * @return The bytes for apiEst.
       */
      public com.google.protobuf.ByteString getApiEstBytes() {
        java.lang.Object ref = apiEst_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          apiEst_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string apiEst = 10;</code>
       *
       * @param value The apiEst to set.
       * @return This builder for chaining.
       */
      public Builder setApiEst(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        apiEst_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string apiEst = 10;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearApiEst() {

        apiEst_ = getDefaultInstance().getApiEst();
        onChanged();
        return this;
      }
      /**
       * <code>string apiEst = 10;</code>
       *
       * @param value The bytes for apiEst to set.
       * @return This builder for chaining.
       */
      public Builder setApiEstBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        apiEst_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object tempEst_ = "";
      /**
       * <code>string tempEst = 11;</code>
       *
       * @return The tempEst.
       */
      public java.lang.String getTempEst() {
        java.lang.Object ref = tempEst_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          tempEst_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string tempEst = 11;</code>
       *
       * @return The bytes for tempEst.
       */
      public com.google.protobuf.ByteString getTempEstBytes() {
        java.lang.Object ref = tempEst_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          tempEst_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string tempEst = 11;</code>
       *
       * @param value The tempEst to set.
       * @return This builder for chaining.
       */
      public Builder setTempEst(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        tempEst_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string tempEst = 11;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearTempEst() {

        tempEst_ = getDefaultInstance().getTempEst();
        onChanged();
        return this;
      }
      /**
       * <code>string tempEst = 11;</code>
       *
       * @param value The bytes for tempEst to set.
       * @return This builder for chaining.
       */
      public Builder setTempEstBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        tempEst_ = value;
        onChanged();
        return this;
      }

      private long segregationId_;
      /**
       * <code>int64 segregationId = 12;</code>
       *
       * @return The segregationId.
       */
      public long getSegregationId() {
        return segregationId_;
      }
      /**
       * <code>int64 segregationId = 12;</code>
       *
       * @param value The segregationId to set.
       * @return This builder for chaining.
       */
      public Builder setSegregationId(long value) {

        segregationId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int64 segregationId = 12;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearSegregationId() {

        segregationId_ = 0L;
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

      // @@protoc_insertion_point(builder_scope:CargoNominationDetail)
    }

    // @@protoc_insertion_point(class_scope:CargoNominationDetail)
    private static final com.cpdss.common.generated.LoadableStudy.CargoNominationDetail
        DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.LoadableStudy.CargoNominationDetail();
    }

    public static com.cpdss.common.generated.LoadableStudy.CargoNominationDetail
        getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<CargoNominationDetail> PARSER =
        new com.google.protobuf.AbstractParser<CargoNominationDetail>() {
          @java.lang.Override
          public CargoNominationDetail parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new CargoNominationDetail(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<CargoNominationDetail> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<CargoNominationDetail> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.LoadableStudy.CargoNominationDetail
        getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface CargoNominationRequestOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:CargoNominationRequest)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int64 vesselId = 1;</code>
     *
     * @return The vesselId.
     */
    long getVesselId();

    /**
     * <code>int64 voyageId = 2;</code>
     *
     * @return The voyageId.
     */
    long getVoyageId();

    /**
     * <code>int64 loadableStudyId = 3;</code>
     *
     * @return The loadableStudyId.
     */
    long getLoadableStudyId();

    /**
     * <code>.CargoNominationDetail cargoNominationDetail = 4;</code>
     *
     * @return Whether the cargoNominationDetail field is set.
     */
    boolean hasCargoNominationDetail();
    /**
     * <code>.CargoNominationDetail cargoNominationDetail = 4;</code>
     *
     * @return The cargoNominationDetail.
     */
    com.cpdss.common.generated.LoadableStudy.CargoNominationDetail getCargoNominationDetail();
    /** <code>.CargoNominationDetail cargoNominationDetail = 4;</code> */
    com.cpdss.common.generated.LoadableStudy.CargoNominationDetailOrBuilder
        getCargoNominationDetailOrBuilder();
  }
  /** Protobuf type {@code CargoNominationRequest} */
  public static final class CargoNominationRequest extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:CargoNominationRequest)
      CargoNominationRequestOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use CargoNominationRequest.newBuilder() to construct.
    private CargoNominationRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private CargoNominationRequest() {}

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new CargoNominationRequest();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private CargoNominationRequest(
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
                vesselId_ = input.readInt64();
                break;
              }
            case 16:
              {
                voyageId_ = input.readInt64();
                break;
              }
            case 24:
              {
                loadableStudyId_ = input.readInt64();
                break;
              }
            case 34:
              {
                com.cpdss.common.generated.LoadableStudy.CargoNominationDetail.Builder subBuilder =
                    null;
                if (cargoNominationDetail_ != null) {
                  subBuilder = cargoNominationDetail_.toBuilder();
                }
                cargoNominationDetail_ =
                    input.readMessage(
                        com.cpdss.common.generated.LoadableStudy.CargoNominationDetail.parser(),
                        extensionRegistry);
                if (subBuilder != null) {
                  subBuilder.mergeFrom(cargoNominationDetail_);
                  cargoNominationDetail_ = subBuilder.buildPartial();
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
      return com.cpdss.common.generated.LoadableStudy
          .internal_static_CargoNominationRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.LoadableStudy
          .internal_static_CargoNominationRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.LoadableStudy.CargoNominationRequest.class,
              com.cpdss.common.generated.LoadableStudy.CargoNominationRequest.Builder.class);
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

    public static final int VOYAGEID_FIELD_NUMBER = 2;
    private long voyageId_;
    /**
     * <code>int64 voyageId = 2;</code>
     *
     * @return The voyageId.
     */
    public long getVoyageId() {
      return voyageId_;
    }

    public static final int LOADABLESTUDYID_FIELD_NUMBER = 3;
    private long loadableStudyId_;
    /**
     * <code>int64 loadableStudyId = 3;</code>
     *
     * @return The loadableStudyId.
     */
    public long getLoadableStudyId() {
      return loadableStudyId_;
    }

    public static final int CARGONOMINATIONDETAIL_FIELD_NUMBER = 4;
    private com.cpdss.common.generated.LoadableStudy.CargoNominationDetail cargoNominationDetail_;
    /**
     * <code>.CargoNominationDetail cargoNominationDetail = 4;</code>
     *
     * @return Whether the cargoNominationDetail field is set.
     */
    public boolean hasCargoNominationDetail() {
      return cargoNominationDetail_ != null;
    }
    /**
     * <code>.CargoNominationDetail cargoNominationDetail = 4;</code>
     *
     * @return The cargoNominationDetail.
     */
    public com.cpdss.common.generated.LoadableStudy.CargoNominationDetail
        getCargoNominationDetail() {
      return cargoNominationDetail_ == null
          ? com.cpdss.common.generated.LoadableStudy.CargoNominationDetail.getDefaultInstance()
          : cargoNominationDetail_;
    }
    /** <code>.CargoNominationDetail cargoNominationDetail = 4;</code> */
    public com.cpdss.common.generated.LoadableStudy.CargoNominationDetailOrBuilder
        getCargoNominationDetailOrBuilder() {
      return getCargoNominationDetail();
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
      if (voyageId_ != 0L) {
        output.writeInt64(2, voyageId_);
      }
      if (loadableStudyId_ != 0L) {
        output.writeInt64(3, loadableStudyId_);
      }
      if (cargoNominationDetail_ != null) {
        output.writeMessage(4, getCargoNominationDetail());
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
      if (voyageId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(2, voyageId_);
      }
      if (loadableStudyId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(3, loadableStudyId_);
      }
      if (cargoNominationDetail_ != null) {
        size +=
            com.google.protobuf.CodedOutputStream.computeMessageSize(4, getCargoNominationDetail());
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
      if (!(obj instanceof com.cpdss.common.generated.LoadableStudy.CargoNominationRequest)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.LoadableStudy.CargoNominationRequest other =
          (com.cpdss.common.generated.LoadableStudy.CargoNominationRequest) obj;

      if (getVesselId() != other.getVesselId()) return false;
      if (getVoyageId() != other.getVoyageId()) return false;
      if (getLoadableStudyId() != other.getLoadableStudyId()) return false;
      if (hasCargoNominationDetail() != other.hasCargoNominationDetail()) return false;
      if (hasCargoNominationDetail()) {
        if (!getCargoNominationDetail().equals(other.getCargoNominationDetail())) return false;
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
      hash = (37 * hash) + VESSELID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getVesselId());
      hash = (37 * hash) + VOYAGEID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getVoyageId());
      hash = (37 * hash) + LOADABLESTUDYID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getLoadableStudyId());
      if (hasCargoNominationDetail()) {
        hash = (37 * hash) + CARGONOMINATIONDETAIL_FIELD_NUMBER;
        hash = (53 * hash) + getCargoNominationDetail().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.LoadableStudy.CargoNominationRequest parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.CargoNominationRequest parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.CargoNominationRequest parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.CargoNominationRequest parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.CargoNominationRequest parseFrom(
        byte[] data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.CargoNominationRequest parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.CargoNominationRequest parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.CargoNominationRequest parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.CargoNominationRequest
        parseDelimitedFrom(java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.CargoNominationRequest
        parseDelimitedFrom(
            java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.CargoNominationRequest parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.CargoNominationRequest parseFrom(
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
        com.cpdss.common.generated.LoadableStudy.CargoNominationRequest prototype) {
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
    /** Protobuf type {@code CargoNominationRequest} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:CargoNominationRequest)
        com.cpdss.common.generated.LoadableStudy.CargoNominationRequestOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.LoadableStudy
            .internal_static_CargoNominationRequest_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.LoadableStudy
            .internal_static_CargoNominationRequest_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.LoadableStudy.CargoNominationRequest.class,
                com.cpdss.common.generated.LoadableStudy.CargoNominationRequest.Builder.class);
      }

      // Construct using
      // com.cpdss.common.generated.LoadableStudy.CargoNominationRequest.newBuilder()
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
        vesselId_ = 0L;

        voyageId_ = 0L;

        loadableStudyId_ = 0L;

        if (cargoNominationDetailBuilder_ == null) {
          cargoNominationDetail_ = null;
        } else {
          cargoNominationDetail_ = null;
          cargoNominationDetailBuilder_ = null;
        }
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.LoadableStudy
            .internal_static_CargoNominationRequest_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.CargoNominationRequest
          getDefaultInstanceForType() {
        return com.cpdss.common.generated.LoadableStudy.CargoNominationRequest.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.CargoNominationRequest build() {
        com.cpdss.common.generated.LoadableStudy.CargoNominationRequest result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.CargoNominationRequest buildPartial() {
        com.cpdss.common.generated.LoadableStudy.CargoNominationRequest result =
            new com.cpdss.common.generated.LoadableStudy.CargoNominationRequest(this);
        result.vesselId_ = vesselId_;
        result.voyageId_ = voyageId_;
        result.loadableStudyId_ = loadableStudyId_;
        if (cargoNominationDetailBuilder_ == null) {
          result.cargoNominationDetail_ = cargoNominationDetail_;
        } else {
          result.cargoNominationDetail_ = cargoNominationDetailBuilder_.build();
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
        if (other instanceof com.cpdss.common.generated.LoadableStudy.CargoNominationRequest) {
          return mergeFrom((com.cpdss.common.generated.LoadableStudy.CargoNominationRequest) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(
          com.cpdss.common.generated.LoadableStudy.CargoNominationRequest other) {
        if (other
            == com.cpdss.common.generated.LoadableStudy.CargoNominationRequest.getDefaultInstance())
          return this;
        if (other.getVesselId() != 0L) {
          setVesselId(other.getVesselId());
        }
        if (other.getVoyageId() != 0L) {
          setVoyageId(other.getVoyageId());
        }
        if (other.getLoadableStudyId() != 0L) {
          setLoadableStudyId(other.getLoadableStudyId());
        }
        if (other.hasCargoNominationDetail()) {
          mergeCargoNominationDetail(other.getCargoNominationDetail());
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
        com.cpdss.common.generated.LoadableStudy.CargoNominationRequest parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.LoadableStudy.CargoNominationRequest)
                  e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

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

      private long voyageId_;
      /**
       * <code>int64 voyageId = 2;</code>
       *
       * @return The voyageId.
       */
      public long getVoyageId() {
        return voyageId_;
      }
      /**
       * <code>int64 voyageId = 2;</code>
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
       * <code>int64 voyageId = 2;</code>
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
       * <code>int64 loadableStudyId = 3;</code>
       *
       * @return The loadableStudyId.
       */
      public long getLoadableStudyId() {
        return loadableStudyId_;
      }
      /**
       * <code>int64 loadableStudyId = 3;</code>
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
       * <code>int64 loadableStudyId = 3;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearLoadableStudyId() {

        loadableStudyId_ = 0L;
        onChanged();
        return this;
      }

      private com.cpdss.common.generated.LoadableStudy.CargoNominationDetail cargoNominationDetail_;
      private com.google.protobuf.SingleFieldBuilderV3<
              com.cpdss.common.generated.LoadableStudy.CargoNominationDetail,
              com.cpdss.common.generated.LoadableStudy.CargoNominationDetail.Builder,
              com.cpdss.common.generated.LoadableStudy.CargoNominationDetailOrBuilder>
          cargoNominationDetailBuilder_;
      /**
       * <code>.CargoNominationDetail cargoNominationDetail = 4;</code>
       *
       * @return Whether the cargoNominationDetail field is set.
       */
      public boolean hasCargoNominationDetail() {
        return cargoNominationDetailBuilder_ != null || cargoNominationDetail_ != null;
      }
      /**
       * <code>.CargoNominationDetail cargoNominationDetail = 4;</code>
       *
       * @return The cargoNominationDetail.
       */
      public com.cpdss.common.generated.LoadableStudy.CargoNominationDetail
          getCargoNominationDetail() {
        if (cargoNominationDetailBuilder_ == null) {
          return cargoNominationDetail_ == null
              ? com.cpdss.common.generated.LoadableStudy.CargoNominationDetail.getDefaultInstance()
              : cargoNominationDetail_;
        } else {
          return cargoNominationDetailBuilder_.getMessage();
        }
      }
      /** <code>.CargoNominationDetail cargoNominationDetail = 4;</code> */
      public Builder setCargoNominationDetail(
          com.cpdss.common.generated.LoadableStudy.CargoNominationDetail value) {
        if (cargoNominationDetailBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          cargoNominationDetail_ = value;
          onChanged();
        } else {
          cargoNominationDetailBuilder_.setMessage(value);
        }

        return this;
      }
      /** <code>.CargoNominationDetail cargoNominationDetail = 4;</code> */
      public Builder setCargoNominationDetail(
          com.cpdss.common.generated.LoadableStudy.CargoNominationDetail.Builder builderForValue) {
        if (cargoNominationDetailBuilder_ == null) {
          cargoNominationDetail_ = builderForValue.build();
          onChanged();
        } else {
          cargoNominationDetailBuilder_.setMessage(builderForValue.build());
        }

        return this;
      }
      /** <code>.CargoNominationDetail cargoNominationDetail = 4;</code> */
      public Builder mergeCargoNominationDetail(
          com.cpdss.common.generated.LoadableStudy.CargoNominationDetail value) {
        if (cargoNominationDetailBuilder_ == null) {
          if (cargoNominationDetail_ != null) {
            cargoNominationDetail_ =
                com.cpdss.common.generated.LoadableStudy.CargoNominationDetail.newBuilder(
                        cargoNominationDetail_)
                    .mergeFrom(value)
                    .buildPartial();
          } else {
            cargoNominationDetail_ = value;
          }
          onChanged();
        } else {
          cargoNominationDetailBuilder_.mergeFrom(value);
        }

        return this;
      }
      /** <code>.CargoNominationDetail cargoNominationDetail = 4;</code> */
      public Builder clearCargoNominationDetail() {
        if (cargoNominationDetailBuilder_ == null) {
          cargoNominationDetail_ = null;
          onChanged();
        } else {
          cargoNominationDetail_ = null;
          cargoNominationDetailBuilder_ = null;
        }

        return this;
      }
      /** <code>.CargoNominationDetail cargoNominationDetail = 4;</code> */
      public com.cpdss.common.generated.LoadableStudy.CargoNominationDetail.Builder
          getCargoNominationDetailBuilder() {

        onChanged();
        return getCargoNominationDetailFieldBuilder().getBuilder();
      }
      /** <code>.CargoNominationDetail cargoNominationDetail = 4;</code> */
      public com.cpdss.common.generated.LoadableStudy.CargoNominationDetailOrBuilder
          getCargoNominationDetailOrBuilder() {
        if (cargoNominationDetailBuilder_ != null) {
          return cargoNominationDetailBuilder_.getMessageOrBuilder();
        } else {
          return cargoNominationDetail_ == null
              ? com.cpdss.common.generated.LoadableStudy.CargoNominationDetail.getDefaultInstance()
              : cargoNominationDetail_;
        }
      }
      /** <code>.CargoNominationDetail cargoNominationDetail = 4;</code> */
      private com.google.protobuf.SingleFieldBuilderV3<
              com.cpdss.common.generated.LoadableStudy.CargoNominationDetail,
              com.cpdss.common.generated.LoadableStudy.CargoNominationDetail.Builder,
              com.cpdss.common.generated.LoadableStudy.CargoNominationDetailOrBuilder>
          getCargoNominationDetailFieldBuilder() {
        if (cargoNominationDetailBuilder_ == null) {
          cargoNominationDetailBuilder_ =
              new com.google.protobuf.SingleFieldBuilderV3<
                  com.cpdss.common.generated.LoadableStudy.CargoNominationDetail,
                  com.cpdss.common.generated.LoadableStudy.CargoNominationDetail.Builder,
                  com.cpdss.common.generated.LoadableStudy.CargoNominationDetailOrBuilder>(
                  getCargoNominationDetail(), getParentForChildren(), isClean());
          cargoNominationDetail_ = null;
        }
        return cargoNominationDetailBuilder_;
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

      // @@protoc_insertion_point(builder_scope:CargoNominationRequest)
    }

    // @@protoc_insertion_point(class_scope:CargoNominationRequest)
    private static final com.cpdss.common.generated.LoadableStudy.CargoNominationRequest
        DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.LoadableStudy.CargoNominationRequest();
    }

    public static com.cpdss.common.generated.LoadableStudy.CargoNominationRequest
        getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<CargoNominationRequest> PARSER =
        new com.google.protobuf.AbstractParser<CargoNominationRequest>() {
          @java.lang.Override
          public CargoNominationRequest parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new CargoNominationRequest(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<CargoNominationRequest> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<CargoNominationRequest> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.LoadableStudy.CargoNominationRequest
        getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface CargoNominationReplyOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:CargoNominationReply)
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
     * <code>int64 cargoNominationId = 2;</code>
     *
     * @return The cargoNominationId.
     */
    long getCargoNominationId();

    /** <code>repeated .CargoNominationDetail cargoNominations = 3;</code> */
    java.util.List<com.cpdss.common.generated.LoadableStudy.CargoNominationDetail>
        getCargoNominationsList();
    /** <code>repeated .CargoNominationDetail cargoNominations = 3;</code> */
    com.cpdss.common.generated.LoadableStudy.CargoNominationDetail getCargoNominations(int index);
    /** <code>repeated .CargoNominationDetail cargoNominations = 3;</code> */
    int getCargoNominationsCount();
    /** <code>repeated .CargoNominationDetail cargoNominations = 3;</code> */
    java.util.List<
            ? extends com.cpdss.common.generated.LoadableStudy.CargoNominationDetailOrBuilder>
        getCargoNominationsOrBuilderList();
    /** <code>repeated .CargoNominationDetail cargoNominations = 3;</code> */
    com.cpdss.common.generated.LoadableStudy.CargoNominationDetailOrBuilder
        getCargoNominationsOrBuilder(int index);
  }
  /** Protobuf type {@code CargoNominationReply} */
  public static final class CargoNominationReply extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:CargoNominationReply)
      CargoNominationReplyOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use CargoNominationReply.newBuilder() to construct.
    private CargoNominationReply(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private CargoNominationReply() {
      cargoNominations_ = java.util.Collections.emptyList();
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new CargoNominationReply();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private CargoNominationReply(
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
            case 16:
              {
                cargoNominationId_ = input.readInt64();
                break;
              }
            case 26:
              {
                if (!((mutable_bitField0_ & 0x00000001) != 0)) {
                  cargoNominations_ =
                      new java.util.ArrayList<
                          com.cpdss.common.generated.LoadableStudy.CargoNominationDetail>();
                  mutable_bitField0_ |= 0x00000001;
                }
                cargoNominations_.add(
                    input.readMessage(
                        com.cpdss.common.generated.LoadableStudy.CargoNominationDetail.parser(),
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
          cargoNominations_ = java.util.Collections.unmodifiableList(cargoNominations_);
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }

    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.cpdss.common.generated.LoadableStudy
          .internal_static_CargoNominationReply_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.LoadableStudy
          .internal_static_CargoNominationReply_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.LoadableStudy.CargoNominationReply.class,
              com.cpdss.common.generated.LoadableStudy.CargoNominationReply.Builder.class);
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

    public static final int CARGONOMINATIONID_FIELD_NUMBER = 2;
    private long cargoNominationId_;
    /**
     * <code>int64 cargoNominationId = 2;</code>
     *
     * @return The cargoNominationId.
     */
    public long getCargoNominationId() {
      return cargoNominationId_;
    }

    public static final int CARGONOMINATIONS_FIELD_NUMBER = 3;
    private java.util.List<com.cpdss.common.generated.LoadableStudy.CargoNominationDetail>
        cargoNominations_;
    /** <code>repeated .CargoNominationDetail cargoNominations = 3;</code> */
    public java.util.List<com.cpdss.common.generated.LoadableStudy.CargoNominationDetail>
        getCargoNominationsList() {
      return cargoNominations_;
    }
    /** <code>repeated .CargoNominationDetail cargoNominations = 3;</code> */
    public java.util.List<
            ? extends com.cpdss.common.generated.LoadableStudy.CargoNominationDetailOrBuilder>
        getCargoNominationsOrBuilderList() {
      return cargoNominations_;
    }
    /** <code>repeated .CargoNominationDetail cargoNominations = 3;</code> */
    public int getCargoNominationsCount() {
      return cargoNominations_.size();
    }
    /** <code>repeated .CargoNominationDetail cargoNominations = 3;</code> */
    public com.cpdss.common.generated.LoadableStudy.CargoNominationDetail getCargoNominations(
        int index) {
      return cargoNominations_.get(index);
    }
    /** <code>repeated .CargoNominationDetail cargoNominations = 3;</code> */
    public com.cpdss.common.generated.LoadableStudy.CargoNominationDetailOrBuilder
        getCargoNominationsOrBuilder(int index) {
      return cargoNominations_.get(index);
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
      if (cargoNominationId_ != 0L) {
        output.writeInt64(2, cargoNominationId_);
      }
      for (int i = 0; i < cargoNominations_.size(); i++) {
        output.writeMessage(3, cargoNominations_.get(i));
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
      if (cargoNominationId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(2, cargoNominationId_);
      }
      for (int i = 0; i < cargoNominations_.size(); i++) {
        size +=
            com.google.protobuf.CodedOutputStream.computeMessageSize(3, cargoNominations_.get(i));
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
      if (!(obj instanceof com.cpdss.common.generated.LoadableStudy.CargoNominationReply)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.LoadableStudy.CargoNominationReply other =
          (com.cpdss.common.generated.LoadableStudy.CargoNominationReply) obj;

      if (hasResponseStatus() != other.hasResponseStatus()) return false;
      if (hasResponseStatus()) {
        if (!getResponseStatus().equals(other.getResponseStatus())) return false;
      }
      if (getCargoNominationId() != other.getCargoNominationId()) return false;
      if (!getCargoNominationsList().equals(other.getCargoNominationsList())) return false;
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
      hash = (37 * hash) + CARGONOMINATIONID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getCargoNominationId());
      if (getCargoNominationsCount() > 0) {
        hash = (37 * hash) + CARGONOMINATIONS_FIELD_NUMBER;
        hash = (53 * hash) + getCargoNominationsList().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.LoadableStudy.CargoNominationReply parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.CargoNominationReply parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.CargoNominationReply parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.CargoNominationReply parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.CargoNominationReply parseFrom(
        byte[] data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.CargoNominationReply parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.CargoNominationReply parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.CargoNominationReply parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.CargoNominationReply parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.CargoNominationReply parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.CargoNominationReply parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.CargoNominationReply parseFrom(
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
        com.cpdss.common.generated.LoadableStudy.CargoNominationReply prototype) {
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
    /** Protobuf type {@code CargoNominationReply} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:CargoNominationReply)
        com.cpdss.common.generated.LoadableStudy.CargoNominationReplyOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.LoadableStudy
            .internal_static_CargoNominationReply_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.LoadableStudy
            .internal_static_CargoNominationReply_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.LoadableStudy.CargoNominationReply.class,
                com.cpdss.common.generated.LoadableStudy.CargoNominationReply.Builder.class);
      }

      // Construct using com.cpdss.common.generated.LoadableStudy.CargoNominationReply.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {
          getCargoNominationsFieldBuilder();
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
        cargoNominationId_ = 0L;

        if (cargoNominationsBuilder_ == null) {
          cargoNominations_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          cargoNominationsBuilder_.clear();
        }
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.LoadableStudy
            .internal_static_CargoNominationReply_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.CargoNominationReply
          getDefaultInstanceForType() {
        return com.cpdss.common.generated.LoadableStudy.CargoNominationReply.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.CargoNominationReply build() {
        com.cpdss.common.generated.LoadableStudy.CargoNominationReply result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.CargoNominationReply buildPartial() {
        com.cpdss.common.generated.LoadableStudy.CargoNominationReply result =
            new com.cpdss.common.generated.LoadableStudy.CargoNominationReply(this);
        int from_bitField0_ = bitField0_;
        if (responseStatusBuilder_ == null) {
          result.responseStatus_ = responseStatus_;
        } else {
          result.responseStatus_ = responseStatusBuilder_.build();
        }
        result.cargoNominationId_ = cargoNominationId_;
        if (cargoNominationsBuilder_ == null) {
          if (((bitField0_ & 0x00000001) != 0)) {
            cargoNominations_ = java.util.Collections.unmodifiableList(cargoNominations_);
            bitField0_ = (bitField0_ & ~0x00000001);
          }
          result.cargoNominations_ = cargoNominations_;
        } else {
          result.cargoNominations_ = cargoNominationsBuilder_.build();
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
        if (other instanceof com.cpdss.common.generated.LoadableStudy.CargoNominationReply) {
          return mergeFrom((com.cpdss.common.generated.LoadableStudy.CargoNominationReply) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(
          com.cpdss.common.generated.LoadableStudy.CargoNominationReply other) {
        if (other
            == com.cpdss.common.generated.LoadableStudy.CargoNominationReply.getDefaultInstance())
          return this;
        if (other.hasResponseStatus()) {
          mergeResponseStatus(other.getResponseStatus());
        }
        if (other.getCargoNominationId() != 0L) {
          setCargoNominationId(other.getCargoNominationId());
        }
        if (cargoNominationsBuilder_ == null) {
          if (!other.cargoNominations_.isEmpty()) {
            if (cargoNominations_.isEmpty()) {
              cargoNominations_ = other.cargoNominations_;
              bitField0_ = (bitField0_ & ~0x00000001);
            } else {
              ensureCargoNominationsIsMutable();
              cargoNominations_.addAll(other.cargoNominations_);
            }
            onChanged();
          }
        } else {
          if (!other.cargoNominations_.isEmpty()) {
            if (cargoNominationsBuilder_.isEmpty()) {
              cargoNominationsBuilder_.dispose();
              cargoNominationsBuilder_ = null;
              cargoNominations_ = other.cargoNominations_;
              bitField0_ = (bitField0_ & ~0x00000001);
              cargoNominationsBuilder_ =
                  com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
                      ? getCargoNominationsFieldBuilder()
                      : null;
            } else {
              cargoNominationsBuilder_.addAllMessages(other.cargoNominations_);
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
        com.cpdss.common.generated.LoadableStudy.CargoNominationReply parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.LoadableStudy.CargoNominationReply)
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

      private long cargoNominationId_;
      /**
       * <code>int64 cargoNominationId = 2;</code>
       *
       * @return The cargoNominationId.
       */
      public long getCargoNominationId() {
        return cargoNominationId_;
      }
      /**
       * <code>int64 cargoNominationId = 2;</code>
       *
       * @param value The cargoNominationId to set.
       * @return This builder for chaining.
       */
      public Builder setCargoNominationId(long value) {

        cargoNominationId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int64 cargoNominationId = 2;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearCargoNominationId() {

        cargoNominationId_ = 0L;
        onChanged();
        return this;
      }

      private java.util.List<com.cpdss.common.generated.LoadableStudy.CargoNominationDetail>
          cargoNominations_ = java.util.Collections.emptyList();

      private void ensureCargoNominationsIsMutable() {
        if (!((bitField0_ & 0x00000001) != 0)) {
          cargoNominations_ =
              new java.util.ArrayList<
                  com.cpdss.common.generated.LoadableStudy.CargoNominationDetail>(
                  cargoNominations_);
          bitField0_ |= 0x00000001;
        }
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
              com.cpdss.common.generated.LoadableStudy.CargoNominationDetail,
              com.cpdss.common.generated.LoadableStudy.CargoNominationDetail.Builder,
              com.cpdss.common.generated.LoadableStudy.CargoNominationDetailOrBuilder>
          cargoNominationsBuilder_;

      /** <code>repeated .CargoNominationDetail cargoNominations = 3;</code> */
      public java.util.List<com.cpdss.common.generated.LoadableStudy.CargoNominationDetail>
          getCargoNominationsList() {
        if (cargoNominationsBuilder_ == null) {
          return java.util.Collections.unmodifiableList(cargoNominations_);
        } else {
          return cargoNominationsBuilder_.getMessageList();
        }
      }
      /** <code>repeated .CargoNominationDetail cargoNominations = 3;</code> */
      public int getCargoNominationsCount() {
        if (cargoNominationsBuilder_ == null) {
          return cargoNominations_.size();
        } else {
          return cargoNominationsBuilder_.getCount();
        }
      }
      /** <code>repeated .CargoNominationDetail cargoNominations = 3;</code> */
      public com.cpdss.common.generated.LoadableStudy.CargoNominationDetail getCargoNominations(
          int index) {
        if (cargoNominationsBuilder_ == null) {
          return cargoNominations_.get(index);
        } else {
          return cargoNominationsBuilder_.getMessage(index);
        }
      }
      /** <code>repeated .CargoNominationDetail cargoNominations = 3;</code> */
      public Builder setCargoNominations(
          int index, com.cpdss.common.generated.LoadableStudy.CargoNominationDetail value) {
        if (cargoNominationsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureCargoNominationsIsMutable();
          cargoNominations_.set(index, value);
          onChanged();
        } else {
          cargoNominationsBuilder_.setMessage(index, value);
        }
        return this;
      }
      /** <code>repeated .CargoNominationDetail cargoNominations = 3;</code> */
      public Builder setCargoNominations(
          int index,
          com.cpdss.common.generated.LoadableStudy.CargoNominationDetail.Builder builderForValue) {
        if (cargoNominationsBuilder_ == null) {
          ensureCargoNominationsIsMutable();
          cargoNominations_.set(index, builderForValue.build());
          onChanged();
        } else {
          cargoNominationsBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .CargoNominationDetail cargoNominations = 3;</code> */
      public Builder addCargoNominations(
          com.cpdss.common.generated.LoadableStudy.CargoNominationDetail value) {
        if (cargoNominationsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureCargoNominationsIsMutable();
          cargoNominations_.add(value);
          onChanged();
        } else {
          cargoNominationsBuilder_.addMessage(value);
        }
        return this;
      }
      /** <code>repeated .CargoNominationDetail cargoNominations = 3;</code> */
      public Builder addCargoNominations(
          int index, com.cpdss.common.generated.LoadableStudy.CargoNominationDetail value) {
        if (cargoNominationsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureCargoNominationsIsMutable();
          cargoNominations_.add(index, value);
          onChanged();
        } else {
          cargoNominationsBuilder_.addMessage(index, value);
        }
        return this;
      }
      /** <code>repeated .CargoNominationDetail cargoNominations = 3;</code> */
      public Builder addCargoNominations(
          com.cpdss.common.generated.LoadableStudy.CargoNominationDetail.Builder builderForValue) {
        if (cargoNominationsBuilder_ == null) {
          ensureCargoNominationsIsMutable();
          cargoNominations_.add(builderForValue.build());
          onChanged();
        } else {
          cargoNominationsBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .CargoNominationDetail cargoNominations = 3;</code> */
      public Builder addCargoNominations(
          int index,
          com.cpdss.common.generated.LoadableStudy.CargoNominationDetail.Builder builderForValue) {
        if (cargoNominationsBuilder_ == null) {
          ensureCargoNominationsIsMutable();
          cargoNominations_.add(index, builderForValue.build());
          onChanged();
        } else {
          cargoNominationsBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .CargoNominationDetail cargoNominations = 3;</code> */
      public Builder addAllCargoNominations(
          java.lang.Iterable<
                  ? extends com.cpdss.common.generated.LoadableStudy.CargoNominationDetail>
              values) {
        if (cargoNominationsBuilder_ == null) {
          ensureCargoNominationsIsMutable();
          com.google.protobuf.AbstractMessageLite.Builder.addAll(values, cargoNominations_);
          onChanged();
        } else {
          cargoNominationsBuilder_.addAllMessages(values);
        }
        return this;
      }
      /** <code>repeated .CargoNominationDetail cargoNominations = 3;</code> */
      public Builder clearCargoNominations() {
        if (cargoNominationsBuilder_ == null) {
          cargoNominations_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
          onChanged();
        } else {
          cargoNominationsBuilder_.clear();
        }
        return this;
      }
      /** <code>repeated .CargoNominationDetail cargoNominations = 3;</code> */
      public Builder removeCargoNominations(int index) {
        if (cargoNominationsBuilder_ == null) {
          ensureCargoNominationsIsMutable();
          cargoNominations_.remove(index);
          onChanged();
        } else {
          cargoNominationsBuilder_.remove(index);
        }
        return this;
      }
      /** <code>repeated .CargoNominationDetail cargoNominations = 3;</code> */
      public com.cpdss.common.generated.LoadableStudy.CargoNominationDetail.Builder
          getCargoNominationsBuilder(int index) {
        return getCargoNominationsFieldBuilder().getBuilder(index);
      }
      /** <code>repeated .CargoNominationDetail cargoNominations = 3;</code> */
      public com.cpdss.common.generated.LoadableStudy.CargoNominationDetailOrBuilder
          getCargoNominationsOrBuilder(int index) {
        if (cargoNominationsBuilder_ == null) {
          return cargoNominations_.get(index);
        } else {
          return cargoNominationsBuilder_.getMessageOrBuilder(index);
        }
      }
      /** <code>repeated .CargoNominationDetail cargoNominations = 3;</code> */
      public java.util.List<
              ? extends com.cpdss.common.generated.LoadableStudy.CargoNominationDetailOrBuilder>
          getCargoNominationsOrBuilderList() {
        if (cargoNominationsBuilder_ != null) {
          return cargoNominationsBuilder_.getMessageOrBuilderList();
        } else {
          return java.util.Collections.unmodifiableList(cargoNominations_);
        }
      }
      /** <code>repeated .CargoNominationDetail cargoNominations = 3;</code> */
      public com.cpdss.common.generated.LoadableStudy.CargoNominationDetail.Builder
          addCargoNominationsBuilder() {
        return getCargoNominationsFieldBuilder()
            .addBuilder(
                com.cpdss.common.generated.LoadableStudy.CargoNominationDetail
                    .getDefaultInstance());
      }
      /** <code>repeated .CargoNominationDetail cargoNominations = 3;</code> */
      public com.cpdss.common.generated.LoadableStudy.CargoNominationDetail.Builder
          addCargoNominationsBuilder(int index) {
        return getCargoNominationsFieldBuilder()
            .addBuilder(
                index,
                com.cpdss.common.generated.LoadableStudy.CargoNominationDetail
                    .getDefaultInstance());
      }
      /** <code>repeated .CargoNominationDetail cargoNominations = 3;</code> */
      public java.util.List<com.cpdss.common.generated.LoadableStudy.CargoNominationDetail.Builder>
          getCargoNominationsBuilderList() {
        return getCargoNominationsFieldBuilder().getBuilderList();
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
              com.cpdss.common.generated.LoadableStudy.CargoNominationDetail,
              com.cpdss.common.generated.LoadableStudy.CargoNominationDetail.Builder,
              com.cpdss.common.generated.LoadableStudy.CargoNominationDetailOrBuilder>
          getCargoNominationsFieldBuilder() {
        if (cargoNominationsBuilder_ == null) {
          cargoNominationsBuilder_ =
              new com.google.protobuf.RepeatedFieldBuilderV3<
                  com.cpdss.common.generated.LoadableStudy.CargoNominationDetail,
                  com.cpdss.common.generated.LoadableStudy.CargoNominationDetail.Builder,
                  com.cpdss.common.generated.LoadableStudy.CargoNominationDetailOrBuilder>(
                  cargoNominations_,
                  ((bitField0_ & 0x00000001) != 0),
                  getParentForChildren(),
                  isClean());
          cargoNominations_ = null;
        }
        return cargoNominationsBuilder_;
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

      // @@protoc_insertion_point(builder_scope:CargoNominationReply)
    }

    // @@protoc_insertion_point(class_scope:CargoNominationReply)
    private static final com.cpdss.common.generated.LoadableStudy.CargoNominationReply
        DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.LoadableStudy.CargoNominationReply();
    }

    public static com.cpdss.common.generated.LoadableStudy.CargoNominationReply
        getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<CargoNominationReply> PARSER =
        new com.google.protobuf.AbstractParser<CargoNominationReply>() {
          @java.lang.Override
          public CargoNominationReply parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new CargoNominationReply(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<CargoNominationReply> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<CargoNominationReply> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.LoadableStudy.CargoNominationReply
        getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface PortRotationRequestOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:PortRotationRequest)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int64 loadableStudyId = 1;</code>
     *
     * @return The loadableStudyId.
     */
    long getLoadableStudyId();

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
  /** Protobuf type {@code PortRotationRequest} */
  public static final class PortRotationRequest extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:PortRotationRequest)
      PortRotationRequestOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use PortRotationRequest.newBuilder() to construct.
    private PortRotationRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private PortRotationRequest() {}

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new PortRotationRequest();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private PortRotationRequest(
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
                loadableStudyId_ = input.readInt64();
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
          .internal_static_PortRotationRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.LoadableStudy
          .internal_static_PortRotationRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.LoadableStudy.PortRotationRequest.class,
              com.cpdss.common.generated.LoadableStudy.PortRotationRequest.Builder.class);
    }

    public static final int LOADABLESTUDYID_FIELD_NUMBER = 1;
    private long loadableStudyId_;
    /**
     * <code>int64 loadableStudyId = 1;</code>
     *
     * @return The loadableStudyId.
     */
    public long getLoadableStudyId() {
      return loadableStudyId_;
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
      if (loadableStudyId_ != 0L) {
        output.writeInt64(1, loadableStudyId_);
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
      if (loadableStudyId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(1, loadableStudyId_);
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
      if (!(obj instanceof com.cpdss.common.generated.LoadableStudy.PortRotationRequest)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.LoadableStudy.PortRotationRequest other =
          (com.cpdss.common.generated.LoadableStudy.PortRotationRequest) obj;

      if (getLoadableStudyId() != other.getLoadableStudyId()) return false;
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
      hash = (37 * hash) + LOADABLESTUDYID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getLoadableStudyId());
      hash = (37 * hash) + VESSELID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getVesselId());
      hash = (37 * hash) + VOYAGEID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getVoyageId());
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.LoadableStudy.PortRotationRequest parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.PortRotationRequest parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.PortRotationRequest parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.PortRotationRequest parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.PortRotationRequest parseFrom(
        byte[] data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.PortRotationRequest parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.PortRotationRequest parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.PortRotationRequest parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.PortRotationRequest parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.PortRotationRequest parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.PortRotationRequest parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.PortRotationRequest parseFrom(
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
        com.cpdss.common.generated.LoadableStudy.PortRotationRequest prototype) {
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
    /** Protobuf type {@code PortRotationRequest} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:PortRotationRequest)
        com.cpdss.common.generated.LoadableStudy.PortRotationRequestOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.LoadableStudy
            .internal_static_PortRotationRequest_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.LoadableStudy
            .internal_static_PortRotationRequest_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.LoadableStudy.PortRotationRequest.class,
                com.cpdss.common.generated.LoadableStudy.PortRotationRequest.Builder.class);
      }

      // Construct using com.cpdss.common.generated.LoadableStudy.PortRotationRequest.newBuilder()
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
        loadableStudyId_ = 0L;

        vesselId_ = 0L;

        voyageId_ = 0L;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.LoadableStudy
            .internal_static_PortRotationRequest_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.PortRotationRequest
          getDefaultInstanceForType() {
        return com.cpdss.common.generated.LoadableStudy.PortRotationRequest.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.PortRotationRequest build() {
        com.cpdss.common.generated.LoadableStudy.PortRotationRequest result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.PortRotationRequest buildPartial() {
        com.cpdss.common.generated.LoadableStudy.PortRotationRequest result =
            new com.cpdss.common.generated.LoadableStudy.PortRotationRequest(this);
        result.loadableStudyId_ = loadableStudyId_;
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
        if (other instanceof com.cpdss.common.generated.LoadableStudy.PortRotationRequest) {
          return mergeFrom((com.cpdss.common.generated.LoadableStudy.PortRotationRequest) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.cpdss.common.generated.LoadableStudy.PortRotationRequest other) {
        if (other
            == com.cpdss.common.generated.LoadableStudy.PortRotationRequest.getDefaultInstance())
          return this;
        if (other.getLoadableStudyId() != 0L) {
          setLoadableStudyId(other.getLoadableStudyId());
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
        com.cpdss.common.generated.LoadableStudy.PortRotationRequest parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.LoadableStudy.PortRotationRequest)
                  e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private long loadableStudyId_;
      /**
       * <code>int64 loadableStudyId = 1;</code>
       *
       * @return The loadableStudyId.
       */
      public long getLoadableStudyId() {
        return loadableStudyId_;
      }
      /**
       * <code>int64 loadableStudyId = 1;</code>
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
       * <code>int64 loadableStudyId = 1;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearLoadableStudyId() {

        loadableStudyId_ = 0L;
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

      // @@protoc_insertion_point(builder_scope:PortRotationRequest)
    }

    // @@protoc_insertion_point(class_scope:PortRotationRequest)
    private static final com.cpdss.common.generated.LoadableStudy.PortRotationRequest
        DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.LoadableStudy.PortRotationRequest();
    }

    public static com.cpdss.common.generated.LoadableStudy.PortRotationRequest
        getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<PortRotationRequest> PARSER =
        new com.google.protobuf.AbstractParser<PortRotationRequest>() {
          @java.lang.Override
          public PortRotationRequest parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new PortRotationRequest(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<PortRotationRequest> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<PortRotationRequest> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.LoadableStudy.PortRotationRequest
        getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface PortRotationDetailOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:PortRotationDetail)
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
     * <code>int64 berthId = 3;</code>
     *
     * @return The berthId.
     */
    long getBerthId();

    /**
     * <code>int64 operationId = 4;</code>
     *
     * @return The operationId.
     */
    long getOperationId();

    /**
     * <code>string seaWaterDensity = 5;</code>
     *
     * @return The seaWaterDensity.
     */
    java.lang.String getSeaWaterDensity();
    /**
     * <code>string seaWaterDensity = 5;</code>
     *
     * @return The bytes for seaWaterDensity.
     */
    com.google.protobuf.ByteString getSeaWaterDensityBytes();

    /**
     * <code>string distanceBetweenPorts = 6;</code>
     *
     * @return The distanceBetweenPorts.
     */
    java.lang.String getDistanceBetweenPorts();
    /**
     * <code>string distanceBetweenPorts = 6;</code>
     *
     * @return The bytes for distanceBetweenPorts.
     */
    com.google.protobuf.ByteString getDistanceBetweenPortsBytes();

    /**
     * <code>string timeOfStay = 7;</code>
     *
     * @return The timeOfStay.
     */
    java.lang.String getTimeOfStay();
    /**
     * <code>string timeOfStay = 7;</code>
     *
     * @return The bytes for timeOfStay.
     */
    com.google.protobuf.ByteString getTimeOfStayBytes();

    /**
     * <code>string maxDraft = 8;</code>
     *
     * @return The maxDraft.
     */
    java.lang.String getMaxDraft();
    /**
     * <code>string maxDraft = 8;</code>
     *
     * @return The bytes for maxDraft.
     */
    com.google.protobuf.ByteString getMaxDraftBytes();

    /**
     * <code>string maxAirDraft = 9;</code>
     *
     * @return The maxAirDraft.
     */
    java.lang.String getMaxAirDraft();
    /**
     * <code>string maxAirDraft = 9;</code>
     *
     * @return The bytes for maxAirDraft.
     */
    com.google.protobuf.ByteString getMaxAirDraftBytes();

    /**
     * <code>string eta = 10;</code>
     *
     * @return The eta.
     */
    java.lang.String getEta();
    /**
     * <code>string eta = 10;</code>
     *
     * @return The bytes for eta.
     */
    com.google.protobuf.ByteString getEtaBytes();

    /**
     * <code>string etd = 11;</code>
     *
     * @return The etd.
     */
    java.lang.String getEtd();
    /**
     * <code>string etd = 11;</code>
     *
     * @return The bytes for etd.
     */
    com.google.protobuf.ByteString getEtdBytes();

    /**
     * <code>string layCanFrom = 12;</code>
     *
     * @return The layCanFrom.
     */
    java.lang.String getLayCanFrom();
    /**
     * <code>string layCanFrom = 12;</code>
     *
     * @return The bytes for layCanFrom.
     */
    com.google.protobuf.ByteString getLayCanFromBytes();

    /**
     * <code>string layCanTo = 13;</code>
     *
     * @return The layCanTo.
     */
    java.lang.String getLayCanTo();
    /**
     * <code>string layCanTo = 13;</code>
     *
     * @return The bytes for layCanTo.
     */
    com.google.protobuf.ByteString getLayCanToBytes();

    /**
     * <code>int64 loadableStudyId = 14;</code>
     *
     * @return The loadableStudyId.
     */
    long getLoadableStudyId();
  }
  /** Protobuf type {@code PortRotationDetail} */
  public static final class PortRotationDetail extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:PortRotationDetail)
      PortRotationDetailOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use PortRotationDetail.newBuilder() to construct.
    private PortRotationDetail(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private PortRotationDetail() {
      seaWaterDensity_ = "";
      distanceBetweenPorts_ = "";
      timeOfStay_ = "";
      maxDraft_ = "";
      maxAirDraft_ = "";
      eta_ = "";
      etd_ = "";
      layCanFrom_ = "";
      layCanTo_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new PortRotationDetail();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private PortRotationDetail(
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
                berthId_ = input.readInt64();
                break;
              }
            case 32:
              {
                operationId_ = input.readInt64();
                break;
              }
            case 42:
              {
                java.lang.String s = input.readStringRequireUtf8();

                seaWaterDensity_ = s;
                break;
              }
            case 50:
              {
                java.lang.String s = input.readStringRequireUtf8();

                distanceBetweenPorts_ = s;
                break;
              }
            case 58:
              {
                java.lang.String s = input.readStringRequireUtf8();

                timeOfStay_ = s;
                break;
              }
            case 66:
              {
                java.lang.String s = input.readStringRequireUtf8();

                maxDraft_ = s;
                break;
              }
            case 74:
              {
                java.lang.String s = input.readStringRequireUtf8();

                maxAirDraft_ = s;
                break;
              }
            case 82:
              {
                java.lang.String s = input.readStringRequireUtf8();

                eta_ = s;
                break;
              }
            case 90:
              {
                java.lang.String s = input.readStringRequireUtf8();

                etd_ = s;
                break;
              }
            case 98:
              {
                java.lang.String s = input.readStringRequireUtf8();

                layCanFrom_ = s;
                break;
              }
            case 106:
              {
                java.lang.String s = input.readStringRequireUtf8();

                layCanTo_ = s;
                break;
              }
            case 112:
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
      return com.cpdss.common.generated.LoadableStudy.internal_static_PortRotationDetail_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.LoadableStudy
          .internal_static_PortRotationDetail_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.LoadableStudy.PortRotationDetail.class,
              com.cpdss.common.generated.LoadableStudy.PortRotationDetail.Builder.class);
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

    public static final int BERTHID_FIELD_NUMBER = 3;
    private long berthId_;
    /**
     * <code>int64 berthId = 3;</code>
     *
     * @return The berthId.
     */
    public long getBerthId() {
      return berthId_;
    }

    public static final int OPERATIONID_FIELD_NUMBER = 4;
    private long operationId_;
    /**
     * <code>int64 operationId = 4;</code>
     *
     * @return The operationId.
     */
    public long getOperationId() {
      return operationId_;
    }

    public static final int SEAWATERDENSITY_FIELD_NUMBER = 5;
    private volatile java.lang.Object seaWaterDensity_;
    /**
     * <code>string seaWaterDensity = 5;</code>
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
     * <code>string seaWaterDensity = 5;</code>
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

    public static final int DISTANCEBETWEENPORTS_FIELD_NUMBER = 6;
    private volatile java.lang.Object distanceBetweenPorts_;
    /**
     * <code>string distanceBetweenPorts = 6;</code>
     *
     * @return The distanceBetweenPorts.
     */
    public java.lang.String getDistanceBetweenPorts() {
      java.lang.Object ref = distanceBetweenPorts_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        distanceBetweenPorts_ = s;
        return s;
      }
    }
    /**
     * <code>string distanceBetweenPorts = 6;</code>
     *
     * @return The bytes for distanceBetweenPorts.
     */
    public com.google.protobuf.ByteString getDistanceBetweenPortsBytes() {
      java.lang.Object ref = distanceBetweenPorts_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        distanceBetweenPorts_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int TIMEOFSTAY_FIELD_NUMBER = 7;
    private volatile java.lang.Object timeOfStay_;
    /**
     * <code>string timeOfStay = 7;</code>
     *
     * @return The timeOfStay.
     */
    public java.lang.String getTimeOfStay() {
      java.lang.Object ref = timeOfStay_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        timeOfStay_ = s;
        return s;
      }
    }
    /**
     * <code>string timeOfStay = 7;</code>
     *
     * @return The bytes for timeOfStay.
     */
    public com.google.protobuf.ByteString getTimeOfStayBytes() {
      java.lang.Object ref = timeOfStay_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        timeOfStay_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int MAXDRAFT_FIELD_NUMBER = 8;
    private volatile java.lang.Object maxDraft_;
    /**
     * <code>string maxDraft = 8;</code>
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
     * <code>string maxDraft = 8;</code>
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

    public static final int MAXAIRDRAFT_FIELD_NUMBER = 9;
    private volatile java.lang.Object maxAirDraft_;
    /**
     * <code>string maxAirDraft = 9;</code>
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
     * <code>string maxAirDraft = 9;</code>
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

    public static final int ETA_FIELD_NUMBER = 10;
    private volatile java.lang.Object eta_;
    /**
     * <code>string eta = 10;</code>
     *
     * @return The eta.
     */
    public java.lang.String getEta() {
      java.lang.Object ref = eta_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        eta_ = s;
        return s;
      }
    }
    /**
     * <code>string eta = 10;</code>
     *
     * @return The bytes for eta.
     */
    public com.google.protobuf.ByteString getEtaBytes() {
      java.lang.Object ref = eta_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        eta_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int ETD_FIELD_NUMBER = 11;
    private volatile java.lang.Object etd_;
    /**
     * <code>string etd = 11;</code>
     *
     * @return The etd.
     */
    public java.lang.String getEtd() {
      java.lang.Object ref = etd_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        etd_ = s;
        return s;
      }
    }
    /**
     * <code>string etd = 11;</code>
     *
     * @return The bytes for etd.
     */
    public com.google.protobuf.ByteString getEtdBytes() {
      java.lang.Object ref = etd_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        etd_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int LAYCANFROM_FIELD_NUMBER = 12;
    private volatile java.lang.Object layCanFrom_;
    /**
     * <code>string layCanFrom = 12;</code>
     *
     * @return The layCanFrom.
     */
    public java.lang.String getLayCanFrom() {
      java.lang.Object ref = layCanFrom_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        layCanFrom_ = s;
        return s;
      }
    }
    /**
     * <code>string layCanFrom = 12;</code>
     *
     * @return The bytes for layCanFrom.
     */
    public com.google.protobuf.ByteString getLayCanFromBytes() {
      java.lang.Object ref = layCanFrom_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        layCanFrom_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int LAYCANTO_FIELD_NUMBER = 13;
    private volatile java.lang.Object layCanTo_;
    /**
     * <code>string layCanTo = 13;</code>
     *
     * @return The layCanTo.
     */
    public java.lang.String getLayCanTo() {
      java.lang.Object ref = layCanTo_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        layCanTo_ = s;
        return s;
      }
    }
    /**
     * <code>string layCanTo = 13;</code>
     *
     * @return The bytes for layCanTo.
     */
    public com.google.protobuf.ByteString getLayCanToBytes() {
      java.lang.Object ref = layCanTo_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        layCanTo_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int LOADABLESTUDYID_FIELD_NUMBER = 14;
    private long loadableStudyId_;
    /**
     * <code>int64 loadableStudyId = 14;</code>
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
      if (id_ != 0L) {
        output.writeInt64(1, id_);
      }
      if (portId_ != 0L) {
        output.writeInt64(2, portId_);
      }
      if (berthId_ != 0L) {
        output.writeInt64(3, berthId_);
      }
      if (operationId_ != 0L) {
        output.writeInt64(4, operationId_);
      }
      if (!getSeaWaterDensityBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 5, seaWaterDensity_);
      }
      if (!getDistanceBetweenPortsBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 6, distanceBetweenPorts_);
      }
      if (!getTimeOfStayBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 7, timeOfStay_);
      }
      if (!getMaxDraftBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 8, maxDraft_);
      }
      if (!getMaxAirDraftBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 9, maxAirDraft_);
      }
      if (!getEtaBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 10, eta_);
      }
      if (!getEtdBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 11, etd_);
      }
      if (!getLayCanFromBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 12, layCanFrom_);
      }
      if (!getLayCanToBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 13, layCanTo_);
      }
      if (loadableStudyId_ != 0L) {
        output.writeInt64(14, loadableStudyId_);
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
      if (berthId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(3, berthId_);
      }
      if (operationId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(4, operationId_);
      }
      if (!getSeaWaterDensityBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, seaWaterDensity_);
      }
      if (!getDistanceBetweenPortsBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(6, distanceBetweenPorts_);
      }
      if (!getTimeOfStayBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(7, timeOfStay_);
      }
      if (!getMaxDraftBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(8, maxDraft_);
      }
      if (!getMaxAirDraftBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(9, maxAirDraft_);
      }
      if (!getEtaBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(10, eta_);
      }
      if (!getEtdBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(11, etd_);
      }
      if (!getLayCanFromBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(12, layCanFrom_);
      }
      if (!getLayCanToBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(13, layCanTo_);
      }
      if (loadableStudyId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(14, loadableStudyId_);
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
      if (!(obj instanceof com.cpdss.common.generated.LoadableStudy.PortRotationDetail)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.LoadableStudy.PortRotationDetail other =
          (com.cpdss.common.generated.LoadableStudy.PortRotationDetail) obj;

      if (getId() != other.getId()) return false;
      if (getPortId() != other.getPortId()) return false;
      if (getBerthId() != other.getBerthId()) return false;
      if (getOperationId() != other.getOperationId()) return false;
      if (!getSeaWaterDensity().equals(other.getSeaWaterDensity())) return false;
      if (!getDistanceBetweenPorts().equals(other.getDistanceBetweenPorts())) return false;
      if (!getTimeOfStay().equals(other.getTimeOfStay())) return false;
      if (!getMaxDraft().equals(other.getMaxDraft())) return false;
      if (!getMaxAirDraft().equals(other.getMaxAirDraft())) return false;
      if (!getEta().equals(other.getEta())) return false;
      if (!getEtd().equals(other.getEtd())) return false;
      if (!getLayCanFrom().equals(other.getLayCanFrom())) return false;
      if (!getLayCanTo().equals(other.getLayCanTo())) return false;
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
      hash = (37 * hash) + ID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getId());
      hash = (37 * hash) + PORTID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getPortId());
      hash = (37 * hash) + BERTHID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getBerthId());
      hash = (37 * hash) + OPERATIONID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getOperationId());
      hash = (37 * hash) + SEAWATERDENSITY_FIELD_NUMBER;
      hash = (53 * hash) + getSeaWaterDensity().hashCode();
      hash = (37 * hash) + DISTANCEBETWEENPORTS_FIELD_NUMBER;
      hash = (53 * hash) + getDistanceBetweenPorts().hashCode();
      hash = (37 * hash) + TIMEOFSTAY_FIELD_NUMBER;
      hash = (53 * hash) + getTimeOfStay().hashCode();
      hash = (37 * hash) + MAXDRAFT_FIELD_NUMBER;
      hash = (53 * hash) + getMaxDraft().hashCode();
      hash = (37 * hash) + MAXAIRDRAFT_FIELD_NUMBER;
      hash = (53 * hash) + getMaxAirDraft().hashCode();
      hash = (37 * hash) + ETA_FIELD_NUMBER;
      hash = (53 * hash) + getEta().hashCode();
      hash = (37 * hash) + ETD_FIELD_NUMBER;
      hash = (53 * hash) + getEtd().hashCode();
      hash = (37 * hash) + LAYCANFROM_FIELD_NUMBER;
      hash = (53 * hash) + getLayCanFrom().hashCode();
      hash = (37 * hash) + LAYCANTO_FIELD_NUMBER;
      hash = (53 * hash) + getLayCanTo().hashCode();
      hash = (37 * hash) + LOADABLESTUDYID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getLoadableStudyId());
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.LoadableStudy.PortRotationDetail parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.PortRotationDetail parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.PortRotationDetail parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.PortRotationDetail parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.PortRotationDetail parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.PortRotationDetail parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.PortRotationDetail parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.PortRotationDetail parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.PortRotationDetail parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.PortRotationDetail parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.PortRotationDetail parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.PortRotationDetail parseFrom(
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
        com.cpdss.common.generated.LoadableStudy.PortRotationDetail prototype) {
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
    /** Protobuf type {@code PortRotationDetail} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:PortRotationDetail)
        com.cpdss.common.generated.LoadableStudy.PortRotationDetailOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.LoadableStudy
            .internal_static_PortRotationDetail_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.LoadableStudy
            .internal_static_PortRotationDetail_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.LoadableStudy.PortRotationDetail.class,
                com.cpdss.common.generated.LoadableStudy.PortRotationDetail.Builder.class);
      }

      // Construct using com.cpdss.common.generated.LoadableStudy.PortRotationDetail.newBuilder()
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

        berthId_ = 0L;

        operationId_ = 0L;

        seaWaterDensity_ = "";

        distanceBetweenPorts_ = "";

        timeOfStay_ = "";

        maxDraft_ = "";

        maxAirDraft_ = "";

        eta_ = "";

        etd_ = "";

        layCanFrom_ = "";

        layCanTo_ = "";

        loadableStudyId_ = 0L;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.LoadableStudy
            .internal_static_PortRotationDetail_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.PortRotationDetail
          getDefaultInstanceForType() {
        return com.cpdss.common.generated.LoadableStudy.PortRotationDetail.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.PortRotationDetail build() {
        com.cpdss.common.generated.LoadableStudy.PortRotationDetail result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.PortRotationDetail buildPartial() {
        com.cpdss.common.generated.LoadableStudy.PortRotationDetail result =
            new com.cpdss.common.generated.LoadableStudy.PortRotationDetail(this);
        result.id_ = id_;
        result.portId_ = portId_;
        result.berthId_ = berthId_;
        result.operationId_ = operationId_;
        result.seaWaterDensity_ = seaWaterDensity_;
        result.distanceBetweenPorts_ = distanceBetweenPorts_;
        result.timeOfStay_ = timeOfStay_;
        result.maxDraft_ = maxDraft_;
        result.maxAirDraft_ = maxAirDraft_;
        result.eta_ = eta_;
        result.etd_ = etd_;
        result.layCanFrom_ = layCanFrom_;
        result.layCanTo_ = layCanTo_;
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
        if (other instanceof com.cpdss.common.generated.LoadableStudy.PortRotationDetail) {
          return mergeFrom((com.cpdss.common.generated.LoadableStudy.PortRotationDetail) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.cpdss.common.generated.LoadableStudy.PortRotationDetail other) {
        if (other
            == com.cpdss.common.generated.LoadableStudy.PortRotationDetail.getDefaultInstance())
          return this;
        if (other.getId() != 0L) {
          setId(other.getId());
        }
        if (other.getPortId() != 0L) {
          setPortId(other.getPortId());
        }
        if (other.getBerthId() != 0L) {
          setBerthId(other.getBerthId());
        }
        if (other.getOperationId() != 0L) {
          setOperationId(other.getOperationId());
        }
        if (!other.getSeaWaterDensity().isEmpty()) {
          seaWaterDensity_ = other.seaWaterDensity_;
          onChanged();
        }
        if (!other.getDistanceBetweenPorts().isEmpty()) {
          distanceBetweenPorts_ = other.distanceBetweenPorts_;
          onChanged();
        }
        if (!other.getTimeOfStay().isEmpty()) {
          timeOfStay_ = other.timeOfStay_;
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
        if (!other.getEta().isEmpty()) {
          eta_ = other.eta_;
          onChanged();
        }
        if (!other.getEtd().isEmpty()) {
          etd_ = other.etd_;
          onChanged();
        }
        if (!other.getLayCanFrom().isEmpty()) {
          layCanFrom_ = other.layCanFrom_;
          onChanged();
        }
        if (!other.getLayCanTo().isEmpty()) {
          layCanTo_ = other.layCanTo_;
          onChanged();
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
        com.cpdss.common.generated.LoadableStudy.PortRotationDetail parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.LoadableStudy.PortRotationDetail)
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

      private long berthId_;
      /**
       * <code>int64 berthId = 3;</code>
       *
       * @return The berthId.
       */
      public long getBerthId() {
        return berthId_;
      }
      /**
       * <code>int64 berthId = 3;</code>
       *
       * @param value The berthId to set.
       * @return This builder for chaining.
       */
      public Builder setBerthId(long value) {

        berthId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int64 berthId = 3;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearBerthId() {

        berthId_ = 0L;
        onChanged();
        return this;
      }

      private long operationId_;
      /**
       * <code>int64 operationId = 4;</code>
       *
       * @return The operationId.
       */
      public long getOperationId() {
        return operationId_;
      }
      /**
       * <code>int64 operationId = 4;</code>
       *
       * @param value The operationId to set.
       * @return This builder for chaining.
       */
      public Builder setOperationId(long value) {

        operationId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int64 operationId = 4;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearOperationId() {

        operationId_ = 0L;
        onChanged();
        return this;
      }

      private java.lang.Object seaWaterDensity_ = "";
      /**
       * <code>string seaWaterDensity = 5;</code>
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
       * <code>string seaWaterDensity = 5;</code>
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
       * <code>string seaWaterDensity = 5;</code>
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
       * <code>string seaWaterDensity = 5;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearSeaWaterDensity() {

        seaWaterDensity_ = getDefaultInstance().getSeaWaterDensity();
        onChanged();
        return this;
      }
      /**
       * <code>string seaWaterDensity = 5;</code>
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

      private java.lang.Object distanceBetweenPorts_ = "";
      /**
       * <code>string distanceBetweenPorts = 6;</code>
       *
       * @return The distanceBetweenPorts.
       */
      public java.lang.String getDistanceBetweenPorts() {
        java.lang.Object ref = distanceBetweenPorts_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          distanceBetweenPorts_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string distanceBetweenPorts = 6;</code>
       *
       * @return The bytes for distanceBetweenPorts.
       */
      public com.google.protobuf.ByteString getDistanceBetweenPortsBytes() {
        java.lang.Object ref = distanceBetweenPorts_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          distanceBetweenPorts_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string distanceBetweenPorts = 6;</code>
       *
       * @param value The distanceBetweenPorts to set.
       * @return This builder for chaining.
       */
      public Builder setDistanceBetweenPorts(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        distanceBetweenPorts_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string distanceBetweenPorts = 6;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearDistanceBetweenPorts() {

        distanceBetweenPorts_ = getDefaultInstance().getDistanceBetweenPorts();
        onChanged();
        return this;
      }
      /**
       * <code>string distanceBetweenPorts = 6;</code>
       *
       * @param value The bytes for distanceBetweenPorts to set.
       * @return This builder for chaining.
       */
      public Builder setDistanceBetweenPortsBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        distanceBetweenPorts_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object timeOfStay_ = "";
      /**
       * <code>string timeOfStay = 7;</code>
       *
       * @return The timeOfStay.
       */
      public java.lang.String getTimeOfStay() {
        java.lang.Object ref = timeOfStay_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          timeOfStay_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string timeOfStay = 7;</code>
       *
       * @return The bytes for timeOfStay.
       */
      public com.google.protobuf.ByteString getTimeOfStayBytes() {
        java.lang.Object ref = timeOfStay_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          timeOfStay_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string timeOfStay = 7;</code>
       *
       * @param value The timeOfStay to set.
       * @return This builder for chaining.
       */
      public Builder setTimeOfStay(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        timeOfStay_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string timeOfStay = 7;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearTimeOfStay() {

        timeOfStay_ = getDefaultInstance().getTimeOfStay();
        onChanged();
        return this;
      }
      /**
       * <code>string timeOfStay = 7;</code>
       *
       * @param value The bytes for timeOfStay to set.
       * @return This builder for chaining.
       */
      public Builder setTimeOfStayBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        timeOfStay_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object maxDraft_ = "";
      /**
       * <code>string maxDraft = 8;</code>
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
       * <code>string maxDraft = 8;</code>
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
       * <code>string maxDraft = 8;</code>
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
       * <code>string maxDraft = 8;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearMaxDraft() {

        maxDraft_ = getDefaultInstance().getMaxDraft();
        onChanged();
        return this;
      }
      /**
       * <code>string maxDraft = 8;</code>
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
       * <code>string maxAirDraft = 9;</code>
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
       * <code>string maxAirDraft = 9;</code>
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
       * <code>string maxAirDraft = 9;</code>
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
       * <code>string maxAirDraft = 9;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearMaxAirDraft() {

        maxAirDraft_ = getDefaultInstance().getMaxAirDraft();
        onChanged();
        return this;
      }
      /**
       * <code>string maxAirDraft = 9;</code>
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

      private java.lang.Object eta_ = "";
      /**
       * <code>string eta = 10;</code>
       *
       * @return The eta.
       */
      public java.lang.String getEta() {
        java.lang.Object ref = eta_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          eta_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string eta = 10;</code>
       *
       * @return The bytes for eta.
       */
      public com.google.protobuf.ByteString getEtaBytes() {
        java.lang.Object ref = eta_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          eta_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string eta = 10;</code>
       *
       * @param value The eta to set.
       * @return This builder for chaining.
       */
      public Builder setEta(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        eta_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string eta = 10;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearEta() {

        eta_ = getDefaultInstance().getEta();
        onChanged();
        return this;
      }
      /**
       * <code>string eta = 10;</code>
       *
       * @param value The bytes for eta to set.
       * @return This builder for chaining.
       */
      public Builder setEtaBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        eta_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object etd_ = "";
      /**
       * <code>string etd = 11;</code>
       *
       * @return The etd.
       */
      public java.lang.String getEtd() {
        java.lang.Object ref = etd_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          etd_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string etd = 11;</code>
       *
       * @return The bytes for etd.
       */
      public com.google.protobuf.ByteString getEtdBytes() {
        java.lang.Object ref = etd_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          etd_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string etd = 11;</code>
       *
       * @param value The etd to set.
       * @return This builder for chaining.
       */
      public Builder setEtd(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        etd_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string etd = 11;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearEtd() {

        etd_ = getDefaultInstance().getEtd();
        onChanged();
        return this;
      }
      /**
       * <code>string etd = 11;</code>
       *
       * @param value The bytes for etd to set.
       * @return This builder for chaining.
       */
      public Builder setEtdBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        etd_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object layCanFrom_ = "";
      /**
       * <code>string layCanFrom = 12;</code>
       *
       * @return The layCanFrom.
       */
      public java.lang.String getLayCanFrom() {
        java.lang.Object ref = layCanFrom_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          layCanFrom_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string layCanFrom = 12;</code>
       *
       * @return The bytes for layCanFrom.
       */
      public com.google.protobuf.ByteString getLayCanFromBytes() {
        java.lang.Object ref = layCanFrom_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          layCanFrom_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string layCanFrom = 12;</code>
       *
       * @param value The layCanFrom to set.
       * @return This builder for chaining.
       */
      public Builder setLayCanFrom(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        layCanFrom_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string layCanFrom = 12;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearLayCanFrom() {

        layCanFrom_ = getDefaultInstance().getLayCanFrom();
        onChanged();
        return this;
      }
      /**
       * <code>string layCanFrom = 12;</code>
       *
       * @param value The bytes for layCanFrom to set.
       * @return This builder for chaining.
       */
      public Builder setLayCanFromBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        layCanFrom_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object layCanTo_ = "";
      /**
       * <code>string layCanTo = 13;</code>
       *
       * @return The layCanTo.
       */
      public java.lang.String getLayCanTo() {
        java.lang.Object ref = layCanTo_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          layCanTo_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string layCanTo = 13;</code>
       *
       * @return The bytes for layCanTo.
       */
      public com.google.protobuf.ByteString getLayCanToBytes() {
        java.lang.Object ref = layCanTo_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          layCanTo_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string layCanTo = 13;</code>
       *
       * @param value The layCanTo to set.
       * @return This builder for chaining.
       */
      public Builder setLayCanTo(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        layCanTo_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string layCanTo = 13;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearLayCanTo() {

        layCanTo_ = getDefaultInstance().getLayCanTo();
        onChanged();
        return this;
      }
      /**
       * <code>string layCanTo = 13;</code>
       *
       * @param value The bytes for layCanTo to set.
       * @return This builder for chaining.
       */
      public Builder setLayCanToBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        layCanTo_ = value;
        onChanged();
        return this;
      }

      private long loadableStudyId_;
      /**
       * <code>int64 loadableStudyId = 14;</code>
       *
       * @return The loadableStudyId.
       */
      public long getLoadableStudyId() {
        return loadableStudyId_;
      }
      /**
       * <code>int64 loadableStudyId = 14;</code>
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
       * <code>int64 loadableStudyId = 14;</code>
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

      // @@protoc_insertion_point(builder_scope:PortRotationDetail)
    }

    // @@protoc_insertion_point(class_scope:PortRotationDetail)
    private static final com.cpdss.common.generated.LoadableStudy.PortRotationDetail
        DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.LoadableStudy.PortRotationDetail();
    }

    public static com.cpdss.common.generated.LoadableStudy.PortRotationDetail getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<PortRotationDetail> PARSER =
        new com.google.protobuf.AbstractParser<PortRotationDetail>() {
          @java.lang.Override
          public PortRotationDetail parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new PortRotationDetail(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<PortRotationDetail> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<PortRotationDetail> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.LoadableStudy.PortRotationDetail getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface OperationOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:Operation)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int64 id = 1;</code>
     *
     * @return The id.
     */
    long getId();

    /**
     * <code>string operationName = 2;</code>
     *
     * @return The operationName.
     */
    java.lang.String getOperationName();
    /**
     * <code>string operationName = 2;</code>
     *
     * @return The bytes for operationName.
     */
    com.google.protobuf.ByteString getOperationNameBytes();
  }
  /** Protobuf type {@code Operation} */
  public static final class Operation extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:Operation)
      OperationOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use Operation.newBuilder() to construct.
    private Operation(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private Operation() {
      operationName_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new Operation();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private Operation(
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

                operationName_ = s;
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
      return com.cpdss.common.generated.LoadableStudy.internal_static_Operation_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.LoadableStudy.internal_static_Operation_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.LoadableStudy.Operation.class,
              com.cpdss.common.generated.LoadableStudy.Operation.Builder.class);
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

    public static final int OPERATIONNAME_FIELD_NUMBER = 2;
    private volatile java.lang.Object operationName_;
    /**
     * <code>string operationName = 2;</code>
     *
     * @return The operationName.
     */
    public java.lang.String getOperationName() {
      java.lang.Object ref = operationName_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        operationName_ = s;
        return s;
      }
    }
    /**
     * <code>string operationName = 2;</code>
     *
     * @return The bytes for operationName.
     */
    public com.google.protobuf.ByteString getOperationNameBytes() {
      java.lang.Object ref = operationName_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        operationName_ = b;
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
      if (!getOperationNameBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, operationName_);
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
      if (!getOperationNameBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, operationName_);
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
      if (!(obj instanceof com.cpdss.common.generated.LoadableStudy.Operation)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.LoadableStudy.Operation other =
          (com.cpdss.common.generated.LoadableStudy.Operation) obj;

      if (getId() != other.getId()) return false;
      if (!getOperationName().equals(other.getOperationName())) return false;
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
      hash = (37 * hash) + OPERATIONNAME_FIELD_NUMBER;
      hash = (53 * hash) + getOperationName().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.LoadableStudy.Operation parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.Operation parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.Operation parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.Operation parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.Operation parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.Operation parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.Operation parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.Operation parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.Operation parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.Operation parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.Operation parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.Operation parseFrom(
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

    public static Builder newBuilder(com.cpdss.common.generated.LoadableStudy.Operation prototype) {
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
    /** Protobuf type {@code Operation} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:Operation)
        com.cpdss.common.generated.LoadableStudy.OperationOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.LoadableStudy.internal_static_Operation_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.LoadableStudy.internal_static_Operation_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.LoadableStudy.Operation.class,
                com.cpdss.common.generated.LoadableStudy.Operation.Builder.class);
      }

      // Construct using com.cpdss.common.generated.LoadableStudy.Operation.newBuilder()
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

        operationName_ = "";

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.LoadableStudy.internal_static_Operation_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.Operation getDefaultInstanceForType() {
        return com.cpdss.common.generated.LoadableStudy.Operation.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.Operation build() {
        com.cpdss.common.generated.LoadableStudy.Operation result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.Operation buildPartial() {
        com.cpdss.common.generated.LoadableStudy.Operation result =
            new com.cpdss.common.generated.LoadableStudy.Operation(this);
        result.id_ = id_;
        result.operationName_ = operationName_;
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
        if (other instanceof com.cpdss.common.generated.LoadableStudy.Operation) {
          return mergeFrom((com.cpdss.common.generated.LoadableStudy.Operation) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.cpdss.common.generated.LoadableStudy.Operation other) {
        if (other == com.cpdss.common.generated.LoadableStudy.Operation.getDefaultInstance())
          return this;
        if (other.getId() != 0L) {
          setId(other.getId());
        }
        if (!other.getOperationName().isEmpty()) {
          operationName_ = other.operationName_;
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
        com.cpdss.common.generated.LoadableStudy.Operation parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.LoadableStudy.Operation) e.getUnfinishedMessage();
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

      private java.lang.Object operationName_ = "";
      /**
       * <code>string operationName = 2;</code>
       *
       * @return The operationName.
       */
      public java.lang.String getOperationName() {
        java.lang.Object ref = operationName_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          operationName_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string operationName = 2;</code>
       *
       * @return The bytes for operationName.
       */
      public com.google.protobuf.ByteString getOperationNameBytes() {
        java.lang.Object ref = operationName_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          operationName_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string operationName = 2;</code>
       *
       * @param value The operationName to set.
       * @return This builder for chaining.
       */
      public Builder setOperationName(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        operationName_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string operationName = 2;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearOperationName() {

        operationName_ = getDefaultInstance().getOperationName();
        onChanged();
        return this;
      }
      /**
       * <code>string operationName = 2;</code>
       *
       * @param value The bytes for operationName to set.
       * @return This builder for chaining.
       */
      public Builder setOperationNameBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        operationName_ = value;
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

      // @@protoc_insertion_point(builder_scope:Operation)
    }

    // @@protoc_insertion_point(class_scope:Operation)
    private static final com.cpdss.common.generated.LoadableStudy.Operation DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.LoadableStudy.Operation();
    }

    public static com.cpdss.common.generated.LoadableStudy.Operation getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Operation> PARSER =
        new com.google.protobuf.AbstractParser<Operation>() {
          @java.lang.Override
          public Operation parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new Operation(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<Operation> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<Operation> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.LoadableStudy.Operation getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface PortRotationReplyOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:PortRotationReply)
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

    /** <code>repeated .PortRotationDetail ports = 2;</code> */
    java.util.List<com.cpdss.common.generated.LoadableStudy.PortRotationDetail> getPortsList();
    /** <code>repeated .PortRotationDetail ports = 2;</code> */
    com.cpdss.common.generated.LoadableStudy.PortRotationDetail getPorts(int index);
    /** <code>repeated .PortRotationDetail ports = 2;</code> */
    int getPortsCount();
    /** <code>repeated .PortRotationDetail ports = 2;</code> */
    java.util.List<? extends com.cpdss.common.generated.LoadableStudy.PortRotationDetailOrBuilder>
        getPortsOrBuilderList();
    /** <code>repeated .PortRotationDetail ports = 2;</code> */
    com.cpdss.common.generated.LoadableStudy.PortRotationDetailOrBuilder getPortsOrBuilder(
        int index);

    /** <code>repeated .Operation operations = 3;</code> */
    java.util.List<com.cpdss.common.generated.LoadableStudy.Operation> getOperationsList();
    /** <code>repeated .Operation operations = 3;</code> */
    com.cpdss.common.generated.LoadableStudy.Operation getOperations(int index);
    /** <code>repeated .Operation operations = 3;</code> */
    int getOperationsCount();
    /** <code>repeated .Operation operations = 3;</code> */
    java.util.List<? extends com.cpdss.common.generated.LoadableStudy.OperationOrBuilder>
        getOperationsOrBuilderList();
    /** <code>repeated .Operation operations = 3;</code> */
    com.cpdss.common.generated.LoadableStudy.OperationOrBuilder getOperationsOrBuilder(int index);

    /**
     * <code>int64 portRotationId = 4;</code>
     *
     * @return The portRotationId.
     */
    long getPortRotationId();
  }
  /** Protobuf type {@code PortRotationReply} */
  public static final class PortRotationReply extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:PortRotationReply)
      PortRotationReplyOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use PortRotationReply.newBuilder() to construct.
    private PortRotationReply(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private PortRotationReply() {
      ports_ = java.util.Collections.emptyList();
      operations_ = java.util.Collections.emptyList();
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new PortRotationReply();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private PortRotationReply(
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
                      new java.util.ArrayList<
                          com.cpdss.common.generated.LoadableStudy.PortRotationDetail>();
                  mutable_bitField0_ |= 0x00000001;
                }
                ports_.add(
                    input.readMessage(
                        com.cpdss.common.generated.LoadableStudy.PortRotationDetail.parser(),
                        extensionRegistry));
                break;
              }
            case 26:
              {
                if (!((mutable_bitField0_ & 0x00000002) != 0)) {
                  operations_ =
                      new java.util.ArrayList<com.cpdss.common.generated.LoadableStudy.Operation>();
                  mutable_bitField0_ |= 0x00000002;
                }
                operations_.add(
                    input.readMessage(
                        com.cpdss.common.generated.LoadableStudy.Operation.parser(),
                        extensionRegistry));
                break;
              }
            case 32:
              {
                portRotationId_ = input.readInt64();
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
        if (((mutable_bitField0_ & 0x00000002) != 0)) {
          operations_ = java.util.Collections.unmodifiableList(operations_);
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }

    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.cpdss.common.generated.LoadableStudy.internal_static_PortRotationReply_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.LoadableStudy
          .internal_static_PortRotationReply_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.LoadableStudy.PortRotationReply.class,
              com.cpdss.common.generated.LoadableStudy.PortRotationReply.Builder.class);
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
    private java.util.List<com.cpdss.common.generated.LoadableStudy.PortRotationDetail> ports_;
    /** <code>repeated .PortRotationDetail ports = 2;</code> */
    public java.util.List<com.cpdss.common.generated.LoadableStudy.PortRotationDetail>
        getPortsList() {
      return ports_;
    }
    /** <code>repeated .PortRotationDetail ports = 2;</code> */
    public java.util.List<
            ? extends com.cpdss.common.generated.LoadableStudy.PortRotationDetailOrBuilder>
        getPortsOrBuilderList() {
      return ports_;
    }
    /** <code>repeated .PortRotationDetail ports = 2;</code> */
    public int getPortsCount() {
      return ports_.size();
    }
    /** <code>repeated .PortRotationDetail ports = 2;</code> */
    public com.cpdss.common.generated.LoadableStudy.PortRotationDetail getPorts(int index) {
      return ports_.get(index);
    }
    /** <code>repeated .PortRotationDetail ports = 2;</code> */
    public com.cpdss.common.generated.LoadableStudy.PortRotationDetailOrBuilder getPortsOrBuilder(
        int index) {
      return ports_.get(index);
    }

    public static final int OPERATIONS_FIELD_NUMBER = 3;
    private java.util.List<com.cpdss.common.generated.LoadableStudy.Operation> operations_;
    /** <code>repeated .Operation operations = 3;</code> */
    public java.util.List<com.cpdss.common.generated.LoadableStudy.Operation> getOperationsList() {
      return operations_;
    }
    /** <code>repeated .Operation operations = 3;</code> */
    public java.util.List<? extends com.cpdss.common.generated.LoadableStudy.OperationOrBuilder>
        getOperationsOrBuilderList() {
      return operations_;
    }
    /** <code>repeated .Operation operations = 3;</code> */
    public int getOperationsCount() {
      return operations_.size();
    }
    /** <code>repeated .Operation operations = 3;</code> */
    public com.cpdss.common.generated.LoadableStudy.Operation getOperations(int index) {
      return operations_.get(index);
    }
    /** <code>repeated .Operation operations = 3;</code> */
    public com.cpdss.common.generated.LoadableStudy.OperationOrBuilder getOperationsOrBuilder(
        int index) {
      return operations_.get(index);
    }

    public static final int PORTROTATIONID_FIELD_NUMBER = 4;
    private long portRotationId_;
    /**
     * <code>int64 portRotationId = 4;</code>
     *
     * @return The portRotationId.
     */
    public long getPortRotationId() {
      return portRotationId_;
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
      for (int i = 0; i < operations_.size(); i++) {
        output.writeMessage(3, operations_.get(i));
      }
      if (portRotationId_ != 0L) {
        output.writeInt64(4, portRotationId_);
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
      for (int i = 0; i < operations_.size(); i++) {
        size += com.google.protobuf.CodedOutputStream.computeMessageSize(3, operations_.get(i));
      }
      if (portRotationId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(4, portRotationId_);
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
      if (!(obj instanceof com.cpdss.common.generated.LoadableStudy.PortRotationReply)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.LoadableStudy.PortRotationReply other =
          (com.cpdss.common.generated.LoadableStudy.PortRotationReply) obj;

      if (hasResponseStatus() != other.hasResponseStatus()) return false;
      if (hasResponseStatus()) {
        if (!getResponseStatus().equals(other.getResponseStatus())) return false;
      }
      if (!getPortsList().equals(other.getPortsList())) return false;
      if (!getOperationsList().equals(other.getOperationsList())) return false;
      if (getPortRotationId() != other.getPortRotationId()) return false;
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
      if (getOperationsCount() > 0) {
        hash = (37 * hash) + OPERATIONS_FIELD_NUMBER;
        hash = (53 * hash) + getOperationsList().hashCode();
      }
      hash = (37 * hash) + PORTROTATIONID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getPortRotationId());
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.LoadableStudy.PortRotationReply parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.PortRotationReply parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.PortRotationReply parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.PortRotationReply parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.PortRotationReply parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.PortRotationReply parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.PortRotationReply parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.PortRotationReply parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.PortRotationReply parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.PortRotationReply parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.PortRotationReply parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.PortRotationReply parseFrom(
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
        com.cpdss.common.generated.LoadableStudy.PortRotationReply prototype) {
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
    /** Protobuf type {@code PortRotationReply} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:PortRotationReply)
        com.cpdss.common.generated.LoadableStudy.PortRotationReplyOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.LoadableStudy
            .internal_static_PortRotationReply_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.LoadableStudy
            .internal_static_PortRotationReply_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.LoadableStudy.PortRotationReply.class,
                com.cpdss.common.generated.LoadableStudy.PortRotationReply.Builder.class);
      }

      // Construct using com.cpdss.common.generated.LoadableStudy.PortRotationReply.newBuilder()
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
          getOperationsFieldBuilder();
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
        if (operationsBuilder_ == null) {
          operations_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000002);
        } else {
          operationsBuilder_.clear();
        }
        portRotationId_ = 0L;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.LoadableStudy
            .internal_static_PortRotationReply_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.PortRotationReply
          getDefaultInstanceForType() {
        return com.cpdss.common.generated.LoadableStudy.PortRotationReply.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.PortRotationReply build() {
        com.cpdss.common.generated.LoadableStudy.PortRotationReply result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.PortRotationReply buildPartial() {
        com.cpdss.common.generated.LoadableStudy.PortRotationReply result =
            new com.cpdss.common.generated.LoadableStudy.PortRotationReply(this);
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
        if (operationsBuilder_ == null) {
          if (((bitField0_ & 0x00000002) != 0)) {
            operations_ = java.util.Collections.unmodifiableList(operations_);
            bitField0_ = (bitField0_ & ~0x00000002);
          }
          result.operations_ = operations_;
        } else {
          result.operations_ = operationsBuilder_.build();
        }
        result.portRotationId_ = portRotationId_;
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
        if (other instanceof com.cpdss.common.generated.LoadableStudy.PortRotationReply) {
          return mergeFrom((com.cpdss.common.generated.LoadableStudy.PortRotationReply) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.cpdss.common.generated.LoadableStudy.PortRotationReply other) {
        if (other
            == com.cpdss.common.generated.LoadableStudy.PortRotationReply.getDefaultInstance())
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
        if (operationsBuilder_ == null) {
          if (!other.operations_.isEmpty()) {
            if (operations_.isEmpty()) {
              operations_ = other.operations_;
              bitField0_ = (bitField0_ & ~0x00000002);
            } else {
              ensureOperationsIsMutable();
              operations_.addAll(other.operations_);
            }
            onChanged();
          }
        } else {
          if (!other.operations_.isEmpty()) {
            if (operationsBuilder_.isEmpty()) {
              operationsBuilder_.dispose();
              operationsBuilder_ = null;
              operations_ = other.operations_;
              bitField0_ = (bitField0_ & ~0x00000002);
              operationsBuilder_ =
                  com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
                      ? getOperationsFieldBuilder()
                      : null;
            } else {
              operationsBuilder_.addAllMessages(other.operations_);
            }
          }
        }
        if (other.getPortRotationId() != 0L) {
          setPortRotationId(other.getPortRotationId());
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
        com.cpdss.common.generated.LoadableStudy.PortRotationReply parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.LoadableStudy.PortRotationReply) e.getUnfinishedMessage();
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

      private java.util.List<com.cpdss.common.generated.LoadableStudy.PortRotationDetail> ports_ =
          java.util.Collections.emptyList();

      private void ensurePortsIsMutable() {
        if (!((bitField0_ & 0x00000001) != 0)) {
          ports_ =
              new java.util.ArrayList<com.cpdss.common.generated.LoadableStudy.PortRotationDetail>(
                  ports_);
          bitField0_ |= 0x00000001;
        }
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
              com.cpdss.common.generated.LoadableStudy.PortRotationDetail,
              com.cpdss.common.generated.LoadableStudy.PortRotationDetail.Builder,
              com.cpdss.common.generated.LoadableStudy.PortRotationDetailOrBuilder>
          portsBuilder_;

      /** <code>repeated .PortRotationDetail ports = 2;</code> */
      public java.util.List<com.cpdss.common.generated.LoadableStudy.PortRotationDetail>
          getPortsList() {
        if (portsBuilder_ == null) {
          return java.util.Collections.unmodifiableList(ports_);
        } else {
          return portsBuilder_.getMessageList();
        }
      }
      /** <code>repeated .PortRotationDetail ports = 2;</code> */
      public int getPortsCount() {
        if (portsBuilder_ == null) {
          return ports_.size();
        } else {
          return portsBuilder_.getCount();
        }
      }
      /** <code>repeated .PortRotationDetail ports = 2;</code> */
      public com.cpdss.common.generated.LoadableStudy.PortRotationDetail getPorts(int index) {
        if (portsBuilder_ == null) {
          return ports_.get(index);
        } else {
          return portsBuilder_.getMessage(index);
        }
      }
      /** <code>repeated .PortRotationDetail ports = 2;</code> */
      public Builder setPorts(
          int index, com.cpdss.common.generated.LoadableStudy.PortRotationDetail value) {
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
      /** <code>repeated .PortRotationDetail ports = 2;</code> */
      public Builder setPorts(
          int index,
          com.cpdss.common.generated.LoadableStudy.PortRotationDetail.Builder builderForValue) {
        if (portsBuilder_ == null) {
          ensurePortsIsMutable();
          ports_.set(index, builderForValue.build());
          onChanged();
        } else {
          portsBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .PortRotationDetail ports = 2;</code> */
      public Builder addPorts(com.cpdss.common.generated.LoadableStudy.PortRotationDetail value) {
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
      /** <code>repeated .PortRotationDetail ports = 2;</code> */
      public Builder addPorts(
          int index, com.cpdss.common.generated.LoadableStudy.PortRotationDetail value) {
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
      /** <code>repeated .PortRotationDetail ports = 2;</code> */
      public Builder addPorts(
          com.cpdss.common.generated.LoadableStudy.PortRotationDetail.Builder builderForValue) {
        if (portsBuilder_ == null) {
          ensurePortsIsMutable();
          ports_.add(builderForValue.build());
          onChanged();
        } else {
          portsBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .PortRotationDetail ports = 2;</code> */
      public Builder addPorts(
          int index,
          com.cpdss.common.generated.LoadableStudy.PortRotationDetail.Builder builderForValue) {
        if (portsBuilder_ == null) {
          ensurePortsIsMutable();
          ports_.add(index, builderForValue.build());
          onChanged();
        } else {
          portsBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .PortRotationDetail ports = 2;</code> */
      public Builder addAllPorts(
          java.lang.Iterable<? extends com.cpdss.common.generated.LoadableStudy.PortRotationDetail>
              values) {
        if (portsBuilder_ == null) {
          ensurePortsIsMutable();
          com.google.protobuf.AbstractMessageLite.Builder.addAll(values, ports_);
          onChanged();
        } else {
          portsBuilder_.addAllMessages(values);
        }
        return this;
      }
      /** <code>repeated .PortRotationDetail ports = 2;</code> */
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
      /** <code>repeated .PortRotationDetail ports = 2;</code> */
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
      /** <code>repeated .PortRotationDetail ports = 2;</code> */
      public com.cpdss.common.generated.LoadableStudy.PortRotationDetail.Builder getPortsBuilder(
          int index) {
        return getPortsFieldBuilder().getBuilder(index);
      }
      /** <code>repeated .PortRotationDetail ports = 2;</code> */
      public com.cpdss.common.generated.LoadableStudy.PortRotationDetailOrBuilder getPortsOrBuilder(
          int index) {
        if (portsBuilder_ == null) {
          return ports_.get(index);
        } else {
          return portsBuilder_.getMessageOrBuilder(index);
        }
      }
      /** <code>repeated .PortRotationDetail ports = 2;</code> */
      public java.util.List<
              ? extends com.cpdss.common.generated.LoadableStudy.PortRotationDetailOrBuilder>
          getPortsOrBuilderList() {
        if (portsBuilder_ != null) {
          return portsBuilder_.getMessageOrBuilderList();
        } else {
          return java.util.Collections.unmodifiableList(ports_);
        }
      }
      /** <code>repeated .PortRotationDetail ports = 2;</code> */
      public com.cpdss.common.generated.LoadableStudy.PortRotationDetail.Builder addPortsBuilder() {
        return getPortsFieldBuilder()
            .addBuilder(
                com.cpdss.common.generated.LoadableStudy.PortRotationDetail.getDefaultInstance());
      }
      /** <code>repeated .PortRotationDetail ports = 2;</code> */
      public com.cpdss.common.generated.LoadableStudy.PortRotationDetail.Builder addPortsBuilder(
          int index) {
        return getPortsFieldBuilder()
            .addBuilder(
                index,
                com.cpdss.common.generated.LoadableStudy.PortRotationDetail.getDefaultInstance());
      }
      /** <code>repeated .PortRotationDetail ports = 2;</code> */
      public java.util.List<com.cpdss.common.generated.LoadableStudy.PortRotationDetail.Builder>
          getPortsBuilderList() {
        return getPortsFieldBuilder().getBuilderList();
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
              com.cpdss.common.generated.LoadableStudy.PortRotationDetail,
              com.cpdss.common.generated.LoadableStudy.PortRotationDetail.Builder,
              com.cpdss.common.generated.LoadableStudy.PortRotationDetailOrBuilder>
          getPortsFieldBuilder() {
        if (portsBuilder_ == null) {
          portsBuilder_ =
              new com.google.protobuf.RepeatedFieldBuilderV3<
                  com.cpdss.common.generated.LoadableStudy.PortRotationDetail,
                  com.cpdss.common.generated.LoadableStudy.PortRotationDetail.Builder,
                  com.cpdss.common.generated.LoadableStudy.PortRotationDetailOrBuilder>(
                  ports_, ((bitField0_ & 0x00000001) != 0), getParentForChildren(), isClean());
          ports_ = null;
        }
        return portsBuilder_;
      }

      private java.util.List<com.cpdss.common.generated.LoadableStudy.Operation> operations_ =
          java.util.Collections.emptyList();

      private void ensureOperationsIsMutable() {
        if (!((bitField0_ & 0x00000002) != 0)) {
          operations_ =
              new java.util.ArrayList<com.cpdss.common.generated.LoadableStudy.Operation>(
                  operations_);
          bitField0_ |= 0x00000002;
        }
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
              com.cpdss.common.generated.LoadableStudy.Operation,
              com.cpdss.common.generated.LoadableStudy.Operation.Builder,
              com.cpdss.common.generated.LoadableStudy.OperationOrBuilder>
          operationsBuilder_;

      /** <code>repeated .Operation operations = 3;</code> */
      public java.util.List<com.cpdss.common.generated.LoadableStudy.Operation>
          getOperationsList() {
        if (operationsBuilder_ == null) {
          return java.util.Collections.unmodifiableList(operations_);
        } else {
          return operationsBuilder_.getMessageList();
        }
      }
      /** <code>repeated .Operation operations = 3;</code> */
      public int getOperationsCount() {
        if (operationsBuilder_ == null) {
          return operations_.size();
        } else {
          return operationsBuilder_.getCount();
        }
      }
      /** <code>repeated .Operation operations = 3;</code> */
      public com.cpdss.common.generated.LoadableStudy.Operation getOperations(int index) {
        if (operationsBuilder_ == null) {
          return operations_.get(index);
        } else {
          return operationsBuilder_.getMessage(index);
        }
      }
      /** <code>repeated .Operation operations = 3;</code> */
      public Builder setOperations(
          int index, com.cpdss.common.generated.LoadableStudy.Operation value) {
        if (operationsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureOperationsIsMutable();
          operations_.set(index, value);
          onChanged();
        } else {
          operationsBuilder_.setMessage(index, value);
        }
        return this;
      }
      /** <code>repeated .Operation operations = 3;</code> */
      public Builder setOperations(
          int index, com.cpdss.common.generated.LoadableStudy.Operation.Builder builderForValue) {
        if (operationsBuilder_ == null) {
          ensureOperationsIsMutable();
          operations_.set(index, builderForValue.build());
          onChanged();
        } else {
          operationsBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .Operation operations = 3;</code> */
      public Builder addOperations(com.cpdss.common.generated.LoadableStudy.Operation value) {
        if (operationsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureOperationsIsMutable();
          operations_.add(value);
          onChanged();
        } else {
          operationsBuilder_.addMessage(value);
        }
        return this;
      }
      /** <code>repeated .Operation operations = 3;</code> */
      public Builder addOperations(
          int index, com.cpdss.common.generated.LoadableStudy.Operation value) {
        if (operationsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureOperationsIsMutable();
          operations_.add(index, value);
          onChanged();
        } else {
          operationsBuilder_.addMessage(index, value);
        }
        return this;
      }
      /** <code>repeated .Operation operations = 3;</code> */
      public Builder addOperations(
          com.cpdss.common.generated.LoadableStudy.Operation.Builder builderForValue) {
        if (operationsBuilder_ == null) {
          ensureOperationsIsMutable();
          operations_.add(builderForValue.build());
          onChanged();
        } else {
          operationsBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .Operation operations = 3;</code> */
      public Builder addOperations(
          int index, com.cpdss.common.generated.LoadableStudy.Operation.Builder builderForValue) {
        if (operationsBuilder_ == null) {
          ensureOperationsIsMutable();
          operations_.add(index, builderForValue.build());
          onChanged();
        } else {
          operationsBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .Operation operations = 3;</code> */
      public Builder addAllOperations(
          java.lang.Iterable<? extends com.cpdss.common.generated.LoadableStudy.Operation> values) {
        if (operationsBuilder_ == null) {
          ensureOperationsIsMutable();
          com.google.protobuf.AbstractMessageLite.Builder.addAll(values, operations_);
          onChanged();
        } else {
          operationsBuilder_.addAllMessages(values);
        }
        return this;
      }
      /** <code>repeated .Operation operations = 3;</code> */
      public Builder clearOperations() {
        if (operationsBuilder_ == null) {
          operations_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000002);
          onChanged();
        } else {
          operationsBuilder_.clear();
        }
        return this;
      }
      /** <code>repeated .Operation operations = 3;</code> */
      public Builder removeOperations(int index) {
        if (operationsBuilder_ == null) {
          ensureOperationsIsMutable();
          operations_.remove(index);
          onChanged();
        } else {
          operationsBuilder_.remove(index);
        }
        return this;
      }
      /** <code>repeated .Operation operations = 3;</code> */
      public com.cpdss.common.generated.LoadableStudy.Operation.Builder getOperationsBuilder(
          int index) {
        return getOperationsFieldBuilder().getBuilder(index);
      }
      /** <code>repeated .Operation operations = 3;</code> */
      public com.cpdss.common.generated.LoadableStudy.OperationOrBuilder getOperationsOrBuilder(
          int index) {
        if (operationsBuilder_ == null) {
          return operations_.get(index);
        } else {
          return operationsBuilder_.getMessageOrBuilder(index);
        }
      }
      /** <code>repeated .Operation operations = 3;</code> */
      public java.util.List<? extends com.cpdss.common.generated.LoadableStudy.OperationOrBuilder>
          getOperationsOrBuilderList() {
        if (operationsBuilder_ != null) {
          return operationsBuilder_.getMessageOrBuilderList();
        } else {
          return java.util.Collections.unmodifiableList(operations_);
        }
      }
      /** <code>repeated .Operation operations = 3;</code> */
      public com.cpdss.common.generated.LoadableStudy.Operation.Builder addOperationsBuilder() {
        return getOperationsFieldBuilder()
            .addBuilder(com.cpdss.common.generated.LoadableStudy.Operation.getDefaultInstance());
      }
      /** <code>repeated .Operation operations = 3;</code> */
      public com.cpdss.common.generated.LoadableStudy.Operation.Builder addOperationsBuilder(
          int index) {
        return getOperationsFieldBuilder()
            .addBuilder(
                index, com.cpdss.common.generated.LoadableStudy.Operation.getDefaultInstance());
      }
      /** <code>repeated .Operation operations = 3;</code> */
      public java.util.List<com.cpdss.common.generated.LoadableStudy.Operation.Builder>
          getOperationsBuilderList() {
        return getOperationsFieldBuilder().getBuilderList();
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
              com.cpdss.common.generated.LoadableStudy.Operation,
              com.cpdss.common.generated.LoadableStudy.Operation.Builder,
              com.cpdss.common.generated.LoadableStudy.OperationOrBuilder>
          getOperationsFieldBuilder() {
        if (operationsBuilder_ == null) {
          operationsBuilder_ =
              new com.google.protobuf.RepeatedFieldBuilderV3<
                  com.cpdss.common.generated.LoadableStudy.Operation,
                  com.cpdss.common.generated.LoadableStudy.Operation.Builder,
                  com.cpdss.common.generated.LoadableStudy.OperationOrBuilder>(
                  operations_, ((bitField0_ & 0x00000002) != 0), getParentForChildren(), isClean());
          operations_ = null;
        }
        return operationsBuilder_;
      }

      private long portRotationId_;
      /**
       * <code>int64 portRotationId = 4;</code>
       *
       * @return The portRotationId.
       */
      public long getPortRotationId() {
        return portRotationId_;
      }
      /**
       * <code>int64 portRotationId = 4;</code>
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
       * <code>int64 portRotationId = 4;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearPortRotationId() {

        portRotationId_ = 0L;
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

      // @@protoc_insertion_point(builder_scope:PortRotationReply)
    }

    // @@protoc_insertion_point(class_scope:PortRotationReply)
    private static final com.cpdss.common.generated.LoadableStudy.PortRotationReply
        DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.LoadableStudy.PortRotationReply();
    }

    public static com.cpdss.common.generated.LoadableStudy.PortRotationReply getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<PortRotationReply> PARSER =
        new com.google.protobuf.AbstractParser<PortRotationReply>() {
          @java.lang.Override
          public PortRotationReply parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new PortRotationReply(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<PortRotationReply> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<PortRotationReply> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.LoadableStudy.PortRotationReply getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface LoadableQuantityResponseOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:LoadableQuantityResponse)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>.LoadableQuantityRequest loadableQuantityRequest = 1;</code>
     *
     * @return Whether the loadableQuantityRequest field is set.
     */
    boolean hasLoadableQuantityRequest();
    /**
     * <code>.LoadableQuantityRequest loadableQuantityRequest = 1;</code>
     *
     * @return The loadableQuantityRequest.
     */
    com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest getLoadableQuantityRequest();
    /** <code>.LoadableQuantityRequest loadableQuantityRequest = 1;</code> */
    com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequestOrBuilder
        getLoadableQuantityRequestOrBuilder();

    /**
     * <code>.StatusReply responseStatus = 2;</code>
     *
     * @return Whether the responseStatus field is set.
     */
    boolean hasResponseStatus();
    /**
     * <code>.StatusReply responseStatus = 2;</code>
     *
     * @return The responseStatus.
     */
    com.cpdss.common.generated.LoadableStudy.StatusReply getResponseStatus();
    /** <code>.StatusReply responseStatus = 2;</code> */
    com.cpdss.common.generated.LoadableStudy.StatusReplyOrBuilder getResponseStatusOrBuilder();
  }
  /** Protobuf type {@code LoadableQuantityResponse} */
  public static final class LoadableQuantityResponse extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:LoadableQuantityResponse)
      LoadableQuantityResponseOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use LoadableQuantityResponse.newBuilder() to construct.
    private LoadableQuantityResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private LoadableQuantityResponse() {}

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new LoadableQuantityResponse();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private LoadableQuantityResponse(
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
                com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest.Builder
                    subBuilder = null;
                if (loadableQuantityRequest_ != null) {
                  subBuilder = loadableQuantityRequest_.toBuilder();
                }
                loadableQuantityRequest_ =
                    input.readMessage(
                        com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest.parser(),
                        extensionRegistry);
                if (subBuilder != null) {
                  subBuilder.mergeFrom(loadableQuantityRequest_);
                  loadableQuantityRequest_ = subBuilder.buildPartial();
                }

                break;
              }
            case 18:
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
          .internal_static_LoadableQuantityResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.LoadableStudy
          .internal_static_LoadableQuantityResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.LoadableStudy.LoadableQuantityResponse.class,
              com.cpdss.common.generated.LoadableStudy.LoadableQuantityResponse.Builder.class);
    }

    public static final int LOADABLEQUANTITYREQUEST_FIELD_NUMBER = 1;
    private com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest
        loadableQuantityRequest_;
    /**
     * <code>.LoadableQuantityRequest loadableQuantityRequest = 1;</code>
     *
     * @return Whether the loadableQuantityRequest field is set.
     */
    public boolean hasLoadableQuantityRequest() {
      return loadableQuantityRequest_ != null;
    }
    /**
     * <code>.LoadableQuantityRequest loadableQuantityRequest = 1;</code>
     *
     * @return The loadableQuantityRequest.
     */
    public com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest
        getLoadableQuantityRequest() {
      return loadableQuantityRequest_ == null
          ? com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest.getDefaultInstance()
          : loadableQuantityRequest_;
    }
    /** <code>.LoadableQuantityRequest loadableQuantityRequest = 1;</code> */
    public com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequestOrBuilder
        getLoadableQuantityRequestOrBuilder() {
      return getLoadableQuantityRequest();
    }

    public static final int RESPONSESTATUS_FIELD_NUMBER = 2;
    private com.cpdss.common.generated.LoadableStudy.StatusReply responseStatus_;
    /**
     * <code>.StatusReply responseStatus = 2;</code>
     *
     * @return Whether the responseStatus field is set.
     */
    public boolean hasResponseStatus() {
      return responseStatus_ != null;
    }
    /**
     * <code>.StatusReply responseStatus = 2;</code>
     *
     * @return The responseStatus.
     */
    public com.cpdss.common.generated.LoadableStudy.StatusReply getResponseStatus() {
      return responseStatus_ == null
          ? com.cpdss.common.generated.LoadableStudy.StatusReply.getDefaultInstance()
          : responseStatus_;
    }
    /** <code>.StatusReply responseStatus = 2;</code> */
    public com.cpdss.common.generated.LoadableStudy.StatusReplyOrBuilder
        getResponseStatusOrBuilder() {
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
      if (loadableQuantityRequest_ != null) {
        output.writeMessage(1, getLoadableQuantityRequest());
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
      if (loadableQuantityRequest_ != null) {
        size +=
            com.google.protobuf.CodedOutputStream.computeMessageSize(
                1, getLoadableQuantityRequest());
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
      if (!(obj instanceof com.cpdss.common.generated.LoadableStudy.LoadableQuantityResponse)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.LoadableStudy.LoadableQuantityResponse other =
          (com.cpdss.common.generated.LoadableStudy.LoadableQuantityResponse) obj;

      if (hasLoadableQuantityRequest() != other.hasLoadableQuantityRequest()) return false;
      if (hasLoadableQuantityRequest()) {
        if (!getLoadableQuantityRequest().equals(other.getLoadableQuantityRequest())) return false;
      }
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
      if (hasLoadableQuantityRequest()) {
        hash = (37 * hash) + LOADABLEQUANTITYREQUEST_FIELD_NUMBER;
        hash = (53 * hash) + getLoadableQuantityRequest().hashCode();
      }
      if (hasResponseStatus()) {
        hash = (37 * hash) + RESPONSESTATUS_FIELD_NUMBER;
        hash = (53 * hash) + getResponseStatus().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableQuantityResponse parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableQuantityResponse parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableQuantityResponse parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableQuantityResponse parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableQuantityResponse parseFrom(
        byte[] data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableQuantityResponse parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableQuantityResponse parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableQuantityResponse parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableQuantityResponse
        parseDelimitedFrom(java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableQuantityResponse
        parseDelimitedFrom(
            java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableQuantityResponse parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableQuantityResponse parseFrom(
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
        com.cpdss.common.generated.LoadableStudy.LoadableQuantityResponse prototype) {
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
    /** Protobuf type {@code LoadableQuantityResponse} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:LoadableQuantityResponse)
        com.cpdss.common.generated.LoadableStudy.LoadableQuantityResponseOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.LoadableStudy
            .internal_static_LoadableQuantityResponse_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.LoadableStudy
            .internal_static_LoadableQuantityResponse_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.LoadableStudy.LoadableQuantityResponse.class,
                com.cpdss.common.generated.LoadableStudy.LoadableQuantityResponse.Builder.class);
      }

      // Construct using
      // com.cpdss.common.generated.LoadableStudy.LoadableQuantityResponse.newBuilder()
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
        if (loadableQuantityRequestBuilder_ == null) {
          loadableQuantityRequest_ = null;
        } else {
          loadableQuantityRequest_ = null;
          loadableQuantityRequestBuilder_ = null;
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
        return com.cpdss.common.generated.LoadableStudy
            .internal_static_LoadableQuantityResponse_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.LoadableQuantityResponse
          getDefaultInstanceForType() {
        return com.cpdss.common.generated.LoadableStudy.LoadableQuantityResponse
            .getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.LoadableQuantityResponse build() {
        com.cpdss.common.generated.LoadableStudy.LoadableQuantityResponse result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.LoadableQuantityResponse buildPartial() {
        com.cpdss.common.generated.LoadableStudy.LoadableQuantityResponse result =
            new com.cpdss.common.generated.LoadableStudy.LoadableQuantityResponse(this);
        if (loadableQuantityRequestBuilder_ == null) {
          result.loadableQuantityRequest_ = loadableQuantityRequest_;
        } else {
          result.loadableQuantityRequest_ = loadableQuantityRequestBuilder_.build();
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
        if (other instanceof com.cpdss.common.generated.LoadableStudy.LoadableQuantityResponse) {
          return mergeFrom(
              (com.cpdss.common.generated.LoadableStudy.LoadableQuantityResponse) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(
          com.cpdss.common.generated.LoadableStudy.LoadableQuantityResponse other) {
        if (other
            == com.cpdss.common.generated.LoadableStudy.LoadableQuantityResponse
                .getDefaultInstance()) return this;
        if (other.hasLoadableQuantityRequest()) {
          mergeLoadableQuantityRequest(other.getLoadableQuantityRequest());
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
        com.cpdss.common.generated.LoadableStudy.LoadableQuantityResponse parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.LoadableStudy.LoadableQuantityResponse)
                  e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest
          loadableQuantityRequest_;
      private com.google.protobuf.SingleFieldBuilderV3<
              com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest,
              com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest.Builder,
              com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequestOrBuilder>
          loadableQuantityRequestBuilder_;
      /**
       * <code>.LoadableQuantityRequest loadableQuantityRequest = 1;</code>
       *
       * @return Whether the loadableQuantityRequest field is set.
       */
      public boolean hasLoadableQuantityRequest() {
        return loadableQuantityRequestBuilder_ != null || loadableQuantityRequest_ != null;
      }
      /**
       * <code>.LoadableQuantityRequest loadableQuantityRequest = 1;</code>
       *
       * @return The loadableQuantityRequest.
       */
      public com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest
          getLoadableQuantityRequest() {
        if (loadableQuantityRequestBuilder_ == null) {
          return loadableQuantityRequest_ == null
              ? com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest
                  .getDefaultInstance()
              : loadableQuantityRequest_;
        } else {
          return loadableQuantityRequestBuilder_.getMessage();
        }
      }
      /** <code>.LoadableQuantityRequest loadableQuantityRequest = 1;</code> */
      public Builder setLoadableQuantityRequest(
          com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest value) {
        if (loadableQuantityRequestBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          loadableQuantityRequest_ = value;
          onChanged();
        } else {
          loadableQuantityRequestBuilder_.setMessage(value);
        }

        return this;
      }
      /** <code>.LoadableQuantityRequest loadableQuantityRequest = 1;</code> */
      public Builder setLoadableQuantityRequest(
          com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest.Builder
              builderForValue) {
        if (loadableQuantityRequestBuilder_ == null) {
          loadableQuantityRequest_ = builderForValue.build();
          onChanged();
        } else {
          loadableQuantityRequestBuilder_.setMessage(builderForValue.build());
        }

        return this;
      }
      /** <code>.LoadableQuantityRequest loadableQuantityRequest = 1;</code> */
      public Builder mergeLoadableQuantityRequest(
          com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest value) {
        if (loadableQuantityRequestBuilder_ == null) {
          if (loadableQuantityRequest_ != null) {
            loadableQuantityRequest_ =
                com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest.newBuilder(
                        loadableQuantityRequest_)
                    .mergeFrom(value)
                    .buildPartial();
          } else {
            loadableQuantityRequest_ = value;
          }
          onChanged();
        } else {
          loadableQuantityRequestBuilder_.mergeFrom(value);
        }

        return this;
      }
      /** <code>.LoadableQuantityRequest loadableQuantityRequest = 1;</code> */
      public Builder clearLoadableQuantityRequest() {
        if (loadableQuantityRequestBuilder_ == null) {
          loadableQuantityRequest_ = null;
          onChanged();
        } else {
          loadableQuantityRequest_ = null;
          loadableQuantityRequestBuilder_ = null;
        }

        return this;
      }
      /** <code>.LoadableQuantityRequest loadableQuantityRequest = 1;</code> */
      public com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest.Builder
          getLoadableQuantityRequestBuilder() {

        onChanged();
        return getLoadableQuantityRequestFieldBuilder().getBuilder();
      }
      /** <code>.LoadableQuantityRequest loadableQuantityRequest = 1;</code> */
      public com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequestOrBuilder
          getLoadableQuantityRequestOrBuilder() {
        if (loadableQuantityRequestBuilder_ != null) {
          return loadableQuantityRequestBuilder_.getMessageOrBuilder();
        } else {
          return loadableQuantityRequest_ == null
              ? com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest
                  .getDefaultInstance()
              : loadableQuantityRequest_;
        }
      }
      /** <code>.LoadableQuantityRequest loadableQuantityRequest = 1;</code> */
      private com.google.protobuf.SingleFieldBuilderV3<
              com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest,
              com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest.Builder,
              com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequestOrBuilder>
          getLoadableQuantityRequestFieldBuilder() {
        if (loadableQuantityRequestBuilder_ == null) {
          loadableQuantityRequestBuilder_ =
              new com.google.protobuf.SingleFieldBuilderV3<
                  com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest,
                  com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequest.Builder,
                  com.cpdss.common.generated.LoadableStudy.LoadableQuantityRequestOrBuilder>(
                  getLoadableQuantityRequest(), getParentForChildren(), isClean());
          loadableQuantityRequest_ = null;
        }
        return loadableQuantityRequestBuilder_;
      }

      private com.cpdss.common.generated.LoadableStudy.StatusReply responseStatus_;
      private com.google.protobuf.SingleFieldBuilderV3<
              com.cpdss.common.generated.LoadableStudy.StatusReply,
              com.cpdss.common.generated.LoadableStudy.StatusReply.Builder,
              com.cpdss.common.generated.LoadableStudy.StatusReplyOrBuilder>
          responseStatusBuilder_;
      /**
       * <code>.StatusReply responseStatus = 2;</code>
       *
       * @return Whether the responseStatus field is set.
       */
      public boolean hasResponseStatus() {
        return responseStatusBuilder_ != null || responseStatus_ != null;
      }
      /**
       * <code>.StatusReply responseStatus = 2;</code>
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
      /** <code>.StatusReply responseStatus = 2;</code> */
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
      /** <code>.StatusReply responseStatus = 2;</code> */
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
      /** <code>.StatusReply responseStatus = 2;</code> */
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
      /** <code>.StatusReply responseStatus = 2;</code> */
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
      /** <code>.StatusReply responseStatus = 2;</code> */
      public com.cpdss.common.generated.LoadableStudy.StatusReply.Builder
          getResponseStatusBuilder() {

        onChanged();
        return getResponseStatusFieldBuilder().getBuilder();
      }
      /** <code>.StatusReply responseStatus = 2;</code> */
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
      /** <code>.StatusReply responseStatus = 2;</code> */
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

      // @@protoc_insertion_point(builder_scope:LoadableQuantityResponse)
    }

    // @@protoc_insertion_point(class_scope:LoadableQuantityResponse)
    private static final com.cpdss.common.generated.LoadableStudy.LoadableQuantityResponse
        DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.LoadableStudy.LoadableQuantityResponse();
    }

    public static com.cpdss.common.generated.LoadableStudy.LoadableQuantityResponse
        getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<LoadableQuantityResponse> PARSER =
        new com.google.protobuf.AbstractParser<LoadableQuantityResponse>() {
          @java.lang.Override
          public LoadableQuantityResponse parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new LoadableQuantityResponse(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<LoadableQuantityResponse> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<LoadableQuantityResponse> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.LoadableStudy.LoadableQuantityResponse
        getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface ValveSegregationOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:ValveSegregation)
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
  }
  /** Protobuf type {@code ValveSegregation} */
  public static final class ValveSegregation extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:ValveSegregation)
      ValveSegregationOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use ValveSegregation.newBuilder() to construct.
    private ValveSegregation(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private ValveSegregation() {
      name_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new ValveSegregation();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private ValveSegregation(
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
      return com.cpdss.common.generated.LoadableStudy.internal_static_ValveSegregation_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.LoadableStudy
          .internal_static_ValveSegregation_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.LoadableStudy.ValveSegregation.class,
              com.cpdss.common.generated.LoadableStudy.ValveSegregation.Builder.class);
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
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
        return true;
      }
      if (!(obj instanceof com.cpdss.common.generated.LoadableStudy.ValveSegregation)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.LoadableStudy.ValveSegregation other =
          (com.cpdss.common.generated.LoadableStudy.ValveSegregation) obj;

      if (getId() != other.getId()) return false;
      if (!getName().equals(other.getName())) return false;
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
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.LoadableStudy.ValveSegregation parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.ValveSegregation parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.ValveSegregation parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.ValveSegregation parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.ValveSegregation parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.ValveSegregation parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.ValveSegregation parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.ValveSegregation parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.ValveSegregation parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.ValveSegregation parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.ValveSegregation parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.ValveSegregation parseFrom(
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
        com.cpdss.common.generated.LoadableStudy.ValveSegregation prototype) {
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
    /** Protobuf type {@code ValveSegregation} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:ValveSegregation)
        com.cpdss.common.generated.LoadableStudy.ValveSegregationOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.LoadableStudy.internal_static_ValveSegregation_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.LoadableStudy
            .internal_static_ValveSegregation_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.LoadableStudy.ValveSegregation.class,
                com.cpdss.common.generated.LoadableStudy.ValveSegregation.Builder.class);
      }

      // Construct using com.cpdss.common.generated.LoadableStudy.ValveSegregation.newBuilder()
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

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.LoadableStudy.internal_static_ValveSegregation_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.ValveSegregation getDefaultInstanceForType() {
        return com.cpdss.common.generated.LoadableStudy.ValveSegregation.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.ValveSegregation build() {
        com.cpdss.common.generated.LoadableStudy.ValveSegregation result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.ValveSegregation buildPartial() {
        com.cpdss.common.generated.LoadableStudy.ValveSegregation result =
            new com.cpdss.common.generated.LoadableStudy.ValveSegregation(this);
        result.id_ = id_;
        result.name_ = name_;
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
        if (other instanceof com.cpdss.common.generated.LoadableStudy.ValveSegregation) {
          return mergeFrom((com.cpdss.common.generated.LoadableStudy.ValveSegregation) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.cpdss.common.generated.LoadableStudy.ValveSegregation other) {
        if (other == com.cpdss.common.generated.LoadableStudy.ValveSegregation.getDefaultInstance())
          return this;
        if (other.getId() != 0L) {
          setId(other.getId());
        }
        if (!other.getName().isEmpty()) {
          name_ = other.name_;
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
        com.cpdss.common.generated.LoadableStudy.ValveSegregation parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.LoadableStudy.ValveSegregation) e.getUnfinishedMessage();
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

      // @@protoc_insertion_point(builder_scope:ValveSegregation)
    }

    // @@protoc_insertion_point(class_scope:ValveSegregation)
    private static final com.cpdss.common.generated.LoadableStudy.ValveSegregation DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.LoadableStudy.ValveSegregation();
    }

    public static com.cpdss.common.generated.LoadableStudy.ValveSegregation getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<ValveSegregation> PARSER =
        new com.google.protobuf.AbstractParser<ValveSegregation>() {
          @java.lang.Override
          public ValveSegregation parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new ValveSegregation(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<ValveSegregation> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<ValveSegregation> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.LoadableStudy.ValveSegregation getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface ValveSegregationRequestOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:ValveSegregationRequest)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int64 loadableStudyId = 1;</code>
     *
     * @return The loadableStudyId.
     */
    long getLoadableStudyId();
  }
  /** Protobuf type {@code ValveSegregationRequest} */
  public static final class ValveSegregationRequest extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:ValveSegregationRequest)
      ValveSegregationRequestOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use ValveSegregationRequest.newBuilder() to construct.
    private ValveSegregationRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private ValveSegregationRequest() {}

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new ValveSegregationRequest();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private ValveSegregationRequest(
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
      return com.cpdss.common.generated.LoadableStudy
          .internal_static_ValveSegregationRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.LoadableStudy
          .internal_static_ValveSegregationRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.LoadableStudy.ValveSegregationRequest.class,
              com.cpdss.common.generated.LoadableStudy.ValveSegregationRequest.Builder.class);
    }

    public static final int LOADABLESTUDYID_FIELD_NUMBER = 1;
    private long loadableStudyId_;
    /**
     * <code>int64 loadableStudyId = 1;</code>
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
      if (loadableStudyId_ != 0L) {
        output.writeInt64(1, loadableStudyId_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (loadableStudyId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(1, loadableStudyId_);
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
      if (!(obj instanceof com.cpdss.common.generated.LoadableStudy.ValveSegregationRequest)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.LoadableStudy.ValveSegregationRequest other =
          (com.cpdss.common.generated.LoadableStudy.ValveSegregationRequest) obj;

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
      hash = (37 * hash) + LOADABLESTUDYID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getLoadableStudyId());
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.LoadableStudy.ValveSegregationRequest parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.ValveSegregationRequest parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.ValveSegregationRequest parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.ValveSegregationRequest parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.ValveSegregationRequest parseFrom(
        byte[] data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.ValveSegregationRequest parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.ValveSegregationRequest parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.ValveSegregationRequest parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.ValveSegregationRequest
        parseDelimitedFrom(java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.ValveSegregationRequest
        parseDelimitedFrom(
            java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.ValveSegregationRequest parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.ValveSegregationRequest parseFrom(
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
        com.cpdss.common.generated.LoadableStudy.ValveSegregationRequest prototype) {
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
    /** Protobuf type {@code ValveSegregationRequest} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:ValveSegregationRequest)
        com.cpdss.common.generated.LoadableStudy.ValveSegregationRequestOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.LoadableStudy
            .internal_static_ValveSegregationRequest_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.LoadableStudy
            .internal_static_ValveSegregationRequest_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.LoadableStudy.ValveSegregationRequest.class,
                com.cpdss.common.generated.LoadableStudy.ValveSegregationRequest.Builder.class);
      }

      // Construct using
      // com.cpdss.common.generated.LoadableStudy.ValveSegregationRequest.newBuilder()
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
        loadableStudyId_ = 0L;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.LoadableStudy
            .internal_static_ValveSegregationRequest_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.ValveSegregationRequest
          getDefaultInstanceForType() {
        return com.cpdss.common.generated.LoadableStudy.ValveSegregationRequest
            .getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.ValveSegregationRequest build() {
        com.cpdss.common.generated.LoadableStudy.ValveSegregationRequest result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.ValveSegregationRequest buildPartial() {
        com.cpdss.common.generated.LoadableStudy.ValveSegregationRequest result =
            new com.cpdss.common.generated.LoadableStudy.ValveSegregationRequest(this);
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
        if (other instanceof com.cpdss.common.generated.LoadableStudy.ValveSegregationRequest) {
          return mergeFrom(
              (com.cpdss.common.generated.LoadableStudy.ValveSegregationRequest) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(
          com.cpdss.common.generated.LoadableStudy.ValveSegregationRequest other) {
        if (other
            == com.cpdss.common.generated.LoadableStudy.ValveSegregationRequest
                .getDefaultInstance()) return this;
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
        com.cpdss.common.generated.LoadableStudy.ValveSegregationRequest parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.LoadableStudy.ValveSegregationRequest)
                  e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private long loadableStudyId_;
      /**
       * <code>int64 loadableStudyId = 1;</code>
       *
       * @return The loadableStudyId.
       */
      public long getLoadableStudyId() {
        return loadableStudyId_;
      }
      /**
       * <code>int64 loadableStudyId = 1;</code>
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
       * <code>int64 loadableStudyId = 1;</code>
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

      // @@protoc_insertion_point(builder_scope:ValveSegregationRequest)
    }

    // @@protoc_insertion_point(class_scope:ValveSegregationRequest)
    private static final com.cpdss.common.generated.LoadableStudy.ValveSegregationRequest
        DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.LoadableStudy.ValveSegregationRequest();
    }

    public static com.cpdss.common.generated.LoadableStudy.ValveSegregationRequest
        getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<ValveSegregationRequest> PARSER =
        new com.google.protobuf.AbstractParser<ValveSegregationRequest>() {
          @java.lang.Override
          public ValveSegregationRequest parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new ValveSegregationRequest(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<ValveSegregationRequest> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<ValveSegregationRequest> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.LoadableStudy.ValveSegregationRequest
        getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface ValveSegregationReplyOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:ValveSegregationReply)
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

    /** <code>repeated .ValveSegregation valveSegregation = 2;</code> */
    java.util.List<com.cpdss.common.generated.LoadableStudy.ValveSegregation>
        getValveSegregationList();
    /** <code>repeated .ValveSegregation valveSegregation = 2;</code> */
    com.cpdss.common.generated.LoadableStudy.ValveSegregation getValveSegregation(int index);
    /** <code>repeated .ValveSegregation valveSegregation = 2;</code> */
    int getValveSegregationCount();
    /** <code>repeated .ValveSegregation valveSegregation = 2;</code> */
    java.util.List<? extends com.cpdss.common.generated.LoadableStudy.ValveSegregationOrBuilder>
        getValveSegregationOrBuilderList();
    /** <code>repeated .ValveSegregation valveSegregation = 2;</code> */
    com.cpdss.common.generated.LoadableStudy.ValveSegregationOrBuilder getValveSegregationOrBuilder(
        int index);
  }
  /** Protobuf type {@code ValveSegregationReply} */
  public static final class ValveSegregationReply extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:ValveSegregationReply)
      ValveSegregationReplyOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use ValveSegregationReply.newBuilder() to construct.
    private ValveSegregationReply(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private ValveSegregationReply() {
      valveSegregation_ = java.util.Collections.emptyList();
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new ValveSegregationReply();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private ValveSegregationReply(
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
                  valveSegregation_ =
                      new java.util.ArrayList<
                          com.cpdss.common.generated.LoadableStudy.ValveSegregation>();
                  mutable_bitField0_ |= 0x00000001;
                }
                valveSegregation_.add(
                    input.readMessage(
                        com.cpdss.common.generated.LoadableStudy.ValveSegregation.parser(),
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
          valveSegregation_ = java.util.Collections.unmodifiableList(valveSegregation_);
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }

    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.cpdss.common.generated.LoadableStudy
          .internal_static_ValveSegregationReply_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.LoadableStudy
          .internal_static_ValveSegregationReply_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.LoadableStudy.ValveSegregationReply.class,
              com.cpdss.common.generated.LoadableStudy.ValveSegregationReply.Builder.class);
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

    public static final int VALVESEGREGATION_FIELD_NUMBER = 2;
    private java.util.List<com.cpdss.common.generated.LoadableStudy.ValveSegregation>
        valveSegregation_;
    /** <code>repeated .ValveSegregation valveSegregation = 2;</code> */
    public java.util.List<com.cpdss.common.generated.LoadableStudy.ValveSegregation>
        getValveSegregationList() {
      return valveSegregation_;
    }
    /** <code>repeated .ValveSegregation valveSegregation = 2;</code> */
    public java.util.List<
            ? extends com.cpdss.common.generated.LoadableStudy.ValveSegregationOrBuilder>
        getValveSegregationOrBuilderList() {
      return valveSegregation_;
    }
    /** <code>repeated .ValveSegregation valveSegregation = 2;</code> */
    public int getValveSegregationCount() {
      return valveSegregation_.size();
    }
    /** <code>repeated .ValveSegregation valveSegregation = 2;</code> */
    public com.cpdss.common.generated.LoadableStudy.ValveSegregation getValveSegregation(
        int index) {
      return valveSegregation_.get(index);
    }
    /** <code>repeated .ValveSegregation valveSegregation = 2;</code> */
    public com.cpdss.common.generated.LoadableStudy.ValveSegregationOrBuilder
        getValveSegregationOrBuilder(int index) {
      return valveSegregation_.get(index);
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
      for (int i = 0; i < valveSegregation_.size(); i++) {
        output.writeMessage(2, valveSegregation_.get(i));
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
      for (int i = 0; i < valveSegregation_.size(); i++) {
        size +=
            com.google.protobuf.CodedOutputStream.computeMessageSize(2, valveSegregation_.get(i));
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
      if (!(obj instanceof com.cpdss.common.generated.LoadableStudy.ValveSegregationReply)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.LoadableStudy.ValveSegregationReply other =
          (com.cpdss.common.generated.LoadableStudy.ValveSegregationReply) obj;

      if (hasResponseStatus() != other.hasResponseStatus()) return false;
      if (hasResponseStatus()) {
        if (!getResponseStatus().equals(other.getResponseStatus())) return false;
      }
      if (!getValveSegregationList().equals(other.getValveSegregationList())) return false;
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
      if (getValveSegregationCount() > 0) {
        hash = (37 * hash) + VALVESEGREGATION_FIELD_NUMBER;
        hash = (53 * hash) + getValveSegregationList().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.LoadableStudy.ValveSegregationReply parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.ValveSegregationReply parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.ValveSegregationReply parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.ValveSegregationReply parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.ValveSegregationReply parseFrom(
        byte[] data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.LoadableStudy.ValveSegregationReply parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.ValveSegregationReply parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.ValveSegregationReply parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.ValveSegregationReply parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.ValveSegregationReply parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.LoadableStudy.ValveSegregationReply parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.LoadableStudy.ValveSegregationReply parseFrom(
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
        com.cpdss.common.generated.LoadableStudy.ValveSegregationReply prototype) {
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
    /** Protobuf type {@code ValveSegregationReply} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:ValveSegregationReply)
        com.cpdss.common.generated.LoadableStudy.ValveSegregationReplyOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.LoadableStudy
            .internal_static_ValveSegregationReply_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.LoadableStudy
            .internal_static_ValveSegregationReply_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.LoadableStudy.ValveSegregationReply.class,
                com.cpdss.common.generated.LoadableStudy.ValveSegregationReply.Builder.class);
      }

      // Construct using com.cpdss.common.generated.LoadableStudy.ValveSegregationReply.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {
          getValveSegregationFieldBuilder();
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
        if (valveSegregationBuilder_ == null) {
          valveSegregation_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          valveSegregationBuilder_.clear();
        }
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.LoadableStudy
            .internal_static_ValveSegregationReply_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.ValveSegregationReply
          getDefaultInstanceForType() {
        return com.cpdss.common.generated.LoadableStudy.ValveSegregationReply.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.ValveSegregationReply build() {
        com.cpdss.common.generated.LoadableStudy.ValveSegregationReply result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.LoadableStudy.ValveSegregationReply buildPartial() {
        com.cpdss.common.generated.LoadableStudy.ValveSegregationReply result =
            new com.cpdss.common.generated.LoadableStudy.ValveSegregationReply(this);
        int from_bitField0_ = bitField0_;
        if (responseStatusBuilder_ == null) {
          result.responseStatus_ = responseStatus_;
        } else {
          result.responseStatus_ = responseStatusBuilder_.build();
        }
        if (valveSegregationBuilder_ == null) {
          if (((bitField0_ & 0x00000001) != 0)) {
            valveSegregation_ = java.util.Collections.unmodifiableList(valveSegregation_);
            bitField0_ = (bitField0_ & ~0x00000001);
          }
          result.valveSegregation_ = valveSegregation_;
        } else {
          result.valveSegregation_ = valveSegregationBuilder_.build();
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
        if (other instanceof com.cpdss.common.generated.LoadableStudy.ValveSegregationReply) {
          return mergeFrom((com.cpdss.common.generated.LoadableStudy.ValveSegregationReply) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(
          com.cpdss.common.generated.LoadableStudy.ValveSegregationReply other) {
        if (other
            == com.cpdss.common.generated.LoadableStudy.ValveSegregationReply.getDefaultInstance())
          return this;
        if (other.hasResponseStatus()) {
          mergeResponseStatus(other.getResponseStatus());
        }
        if (valveSegregationBuilder_ == null) {
          if (!other.valveSegregation_.isEmpty()) {
            if (valveSegregation_.isEmpty()) {
              valveSegregation_ = other.valveSegregation_;
              bitField0_ = (bitField0_ & ~0x00000001);
            } else {
              ensureValveSegregationIsMutable();
              valveSegregation_.addAll(other.valveSegregation_);
            }
            onChanged();
          }
        } else {
          if (!other.valveSegregation_.isEmpty()) {
            if (valveSegregationBuilder_.isEmpty()) {
              valveSegregationBuilder_.dispose();
              valveSegregationBuilder_ = null;
              valveSegregation_ = other.valveSegregation_;
              bitField0_ = (bitField0_ & ~0x00000001);
              valveSegregationBuilder_ =
                  com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
                      ? getValveSegregationFieldBuilder()
                      : null;
            } else {
              valveSegregationBuilder_.addAllMessages(other.valveSegregation_);
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
        com.cpdss.common.generated.LoadableStudy.ValveSegregationReply parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.LoadableStudy.ValveSegregationReply)
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

      private java.util.List<com.cpdss.common.generated.LoadableStudy.ValveSegregation>
          valveSegregation_ = java.util.Collections.emptyList();

      private void ensureValveSegregationIsMutable() {
        if (!((bitField0_ & 0x00000001) != 0)) {
          valveSegregation_ =
              new java.util.ArrayList<com.cpdss.common.generated.LoadableStudy.ValveSegregation>(
                  valveSegregation_);
          bitField0_ |= 0x00000001;
        }
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
              com.cpdss.common.generated.LoadableStudy.ValveSegregation,
              com.cpdss.common.generated.LoadableStudy.ValveSegregation.Builder,
              com.cpdss.common.generated.LoadableStudy.ValveSegregationOrBuilder>
          valveSegregationBuilder_;

      /** <code>repeated .ValveSegregation valveSegregation = 2;</code> */
      public java.util.List<com.cpdss.common.generated.LoadableStudy.ValveSegregation>
          getValveSegregationList() {
        if (valveSegregationBuilder_ == null) {
          return java.util.Collections.unmodifiableList(valveSegregation_);
        } else {
          return valveSegregationBuilder_.getMessageList();
        }
      }
      /** <code>repeated .ValveSegregation valveSegregation = 2;</code> */
      public int getValveSegregationCount() {
        if (valveSegregationBuilder_ == null) {
          return valveSegregation_.size();
        } else {
          return valveSegregationBuilder_.getCount();
        }
      }
      /** <code>repeated .ValveSegregation valveSegregation = 2;</code> */
      public com.cpdss.common.generated.LoadableStudy.ValveSegregation getValveSegregation(
          int index) {
        if (valveSegregationBuilder_ == null) {
          return valveSegregation_.get(index);
        } else {
          return valveSegregationBuilder_.getMessage(index);
        }
      }
      /** <code>repeated .ValveSegregation valveSegregation = 2;</code> */
      public Builder setValveSegregation(
          int index, com.cpdss.common.generated.LoadableStudy.ValveSegregation value) {
        if (valveSegregationBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureValveSegregationIsMutable();
          valveSegregation_.set(index, value);
          onChanged();
        } else {
          valveSegregationBuilder_.setMessage(index, value);
        }
        return this;
      }
      /** <code>repeated .ValveSegregation valveSegregation = 2;</code> */
      public Builder setValveSegregation(
          int index,
          com.cpdss.common.generated.LoadableStudy.ValveSegregation.Builder builderForValue) {
        if (valveSegregationBuilder_ == null) {
          ensureValveSegregationIsMutable();
          valveSegregation_.set(index, builderForValue.build());
          onChanged();
        } else {
          valveSegregationBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .ValveSegregation valveSegregation = 2;</code> */
      public Builder addValveSegregation(
          com.cpdss.common.generated.LoadableStudy.ValveSegregation value) {
        if (valveSegregationBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureValveSegregationIsMutable();
          valveSegregation_.add(value);
          onChanged();
        } else {
          valveSegregationBuilder_.addMessage(value);
        }
        return this;
      }
      /** <code>repeated .ValveSegregation valveSegregation = 2;</code> */
      public Builder addValveSegregation(
          int index, com.cpdss.common.generated.LoadableStudy.ValveSegregation value) {
        if (valveSegregationBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureValveSegregationIsMutable();
          valveSegregation_.add(index, value);
          onChanged();
        } else {
          valveSegregationBuilder_.addMessage(index, value);
        }
        return this;
      }
      /** <code>repeated .ValveSegregation valveSegregation = 2;</code> */
      public Builder addValveSegregation(
          com.cpdss.common.generated.LoadableStudy.ValveSegregation.Builder builderForValue) {
        if (valveSegregationBuilder_ == null) {
          ensureValveSegregationIsMutable();
          valveSegregation_.add(builderForValue.build());
          onChanged();
        } else {
          valveSegregationBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .ValveSegregation valveSegregation = 2;</code> */
      public Builder addValveSegregation(
          int index,
          com.cpdss.common.generated.LoadableStudy.ValveSegregation.Builder builderForValue) {
        if (valveSegregationBuilder_ == null) {
          ensureValveSegregationIsMutable();
          valveSegregation_.add(index, builderForValue.build());
          onChanged();
        } else {
          valveSegregationBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .ValveSegregation valveSegregation = 2;</code> */
      public Builder addAllValveSegregation(
          java.lang.Iterable<? extends com.cpdss.common.generated.LoadableStudy.ValveSegregation>
              values) {
        if (valveSegregationBuilder_ == null) {
          ensureValveSegregationIsMutable();
          com.google.protobuf.AbstractMessageLite.Builder.addAll(values, valveSegregation_);
          onChanged();
        } else {
          valveSegregationBuilder_.addAllMessages(values);
        }
        return this;
      }
      /** <code>repeated .ValveSegregation valveSegregation = 2;</code> */
      public Builder clearValveSegregation() {
        if (valveSegregationBuilder_ == null) {
          valveSegregation_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
          onChanged();
        } else {
          valveSegregationBuilder_.clear();
        }
        return this;
      }
      /** <code>repeated .ValveSegregation valveSegregation = 2;</code> */
      public Builder removeValveSegregation(int index) {
        if (valveSegregationBuilder_ == null) {
          ensureValveSegregationIsMutable();
          valveSegregation_.remove(index);
          onChanged();
        } else {
          valveSegregationBuilder_.remove(index);
        }
        return this;
      }
      /** <code>repeated .ValveSegregation valveSegregation = 2;</code> */
      public com.cpdss.common.generated.LoadableStudy.ValveSegregation.Builder
          getValveSegregationBuilder(int index) {
        return getValveSegregationFieldBuilder().getBuilder(index);
      }
      /** <code>repeated .ValveSegregation valveSegregation = 2;</code> */
      public com.cpdss.common.generated.LoadableStudy.ValveSegregationOrBuilder
          getValveSegregationOrBuilder(int index) {
        if (valveSegregationBuilder_ == null) {
          return valveSegregation_.get(index);
        } else {
          return valveSegregationBuilder_.getMessageOrBuilder(index);
        }
      }
      /** <code>repeated .ValveSegregation valveSegregation = 2;</code> */
      public java.util.List<
              ? extends com.cpdss.common.generated.LoadableStudy.ValveSegregationOrBuilder>
          getValveSegregationOrBuilderList() {
        if (valveSegregationBuilder_ != null) {
          return valveSegregationBuilder_.getMessageOrBuilderList();
        } else {
          return java.util.Collections.unmodifiableList(valveSegregation_);
        }
      }
      /** <code>repeated .ValveSegregation valveSegregation = 2;</code> */
      public com.cpdss.common.generated.LoadableStudy.ValveSegregation.Builder
          addValveSegregationBuilder() {
        return getValveSegregationFieldBuilder()
            .addBuilder(
                com.cpdss.common.generated.LoadableStudy.ValveSegregation.getDefaultInstance());
      }
      /** <code>repeated .ValveSegregation valveSegregation = 2;</code> */
      public com.cpdss.common.generated.LoadableStudy.ValveSegregation.Builder
          addValveSegregationBuilder(int index) {
        return getValveSegregationFieldBuilder()
            .addBuilder(
                index,
                com.cpdss.common.generated.LoadableStudy.ValveSegregation.getDefaultInstance());
      }
      /** <code>repeated .ValveSegregation valveSegregation = 2;</code> */
      public java.util.List<com.cpdss.common.generated.LoadableStudy.ValveSegregation.Builder>
          getValveSegregationBuilderList() {
        return getValveSegregationFieldBuilder().getBuilderList();
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
              com.cpdss.common.generated.LoadableStudy.ValveSegregation,
              com.cpdss.common.generated.LoadableStudy.ValveSegregation.Builder,
              com.cpdss.common.generated.LoadableStudy.ValveSegregationOrBuilder>
          getValveSegregationFieldBuilder() {
        if (valveSegregationBuilder_ == null) {
          valveSegregationBuilder_ =
              new com.google.protobuf.RepeatedFieldBuilderV3<
                  com.cpdss.common.generated.LoadableStudy.ValveSegregation,
                  com.cpdss.common.generated.LoadableStudy.ValveSegregation.Builder,
                  com.cpdss.common.generated.LoadableStudy.ValveSegregationOrBuilder>(
                  valveSegregation_,
                  ((bitField0_ & 0x00000001) != 0),
                  getParentForChildren(),
                  isClean());
          valveSegregation_ = null;
        }
        return valveSegregationBuilder_;
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

      // @@protoc_insertion_point(builder_scope:ValveSegregationReply)
    }

    // @@protoc_insertion_point(class_scope:ValveSegregationReply)
    private static final com.cpdss.common.generated.LoadableStudy.ValveSegregationReply
        DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.LoadableStudy.ValveSegregationReply();
    }

    public static com.cpdss.common.generated.LoadableStudy.ValveSegregationReply
        getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<ValveSegregationReply> PARSER =
        new com.google.protobuf.AbstractParser<ValveSegregationReply>() {
          @java.lang.Override
          public ValveSegregationReply parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new ValveSegregationReply(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<ValveSegregationReply> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<ValveSegregationReply> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.LoadableStudy.ValveSegregationReply
        getDefaultInstanceForType() {
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
      internal_static_VoyageDetail_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_VoyageDetail_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_VoyageListReply_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_VoyageListReply_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_StatusReply_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_StatusReply_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_LoadableQuantityRequest_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_LoadableQuantityRequest_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_LoadableQuantityReply_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_LoadableQuantityReply_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_LoadableStudyRequest_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_LoadableStudyRequest_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_LoadableStudyAttachment_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_LoadableStudyAttachment_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_LoadableStudyDetail_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_LoadableStudyDetail_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_LoadableStudyReply_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_LoadableStudyReply_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_LoadingPortDetail_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_LoadingPortDetail_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_segregationDetail_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_segregationDetail_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_CargoNominationDetail_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_CargoNominationDetail_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_CargoNominationRequest_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_CargoNominationRequest_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_CargoNominationReply_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_CargoNominationReply_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_PortRotationRequest_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_PortRotationRequest_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_PortRotationDetail_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_PortRotationDetail_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_Operation_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Operation_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_PortRotationReply_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_PortRotationReply_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_LoadableQuantityResponse_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_LoadableQuantityResponse_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_ValveSegregation_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ValveSegregation_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_ValveSegregationRequest_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ValveSegregationRequest_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_ValveSegregationReply_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ValveSegregationReply_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }

  private static com.google.protobuf.Descriptors.FileDescriptor descriptor;

  static {
    java.lang.String[] descriptorData = {
      "\n\024loadable_study.proto\032\014common.proto\"q\n\r"
          + "VoyageRequest\022\021\n\tcaptainId\030\001 \001(\003\022\026\n\016chie"
          + "fOfficerId\030\002 \001(\003\022\021\n\tcompanyId\030\003 \001(\003\022\020\n\010v"
          + "esselId\030\004 \001(\003\022\020\n\010voyageNo\030\005 \001(\t\"E\n\013Voyag"
          + "eReply\022\020\n\010voyageId\030\001 \001(\003\022$\n\016responseStat"
          + "us\030\002 \001(\0132\014.StatusReply\"0\n\014VoyageDetail\022\n"
          + "\n\002id\030\001 \001(\003\022\024\n\014voyageNumber\030\002 \001(\t\"W\n\017Voya"
          + "geListReply\022$\n\016responseStatus\030\001 \001(\0132\014.St"
          + "atusReply\022\036\n\007voyages\030\002 \003(\0132\r.VoyageDetai"
          + "l\"<\n\013StatusReply\022\016\n\006status\030\001 \001(\t\022\014\n\004code"
          + "\030\002 \001(\t\022\017\n\007message\030\003 \001(\t\"\226\004\n\027LoadableQuan"
          + "tityRequest\022\025\n\rlimitingDraft\030\001 \001(\t\022\025\n\res"
          + "tSeaDensity\030\002 \001(\t\022\013\n\003tpc\030\003 \001(\t\022\022\n\nestSag"
          + "ging\030\004 \001(\t\022#\n\033displacmentDraftRestrictio"
          + "n\030\005 \001(\t\022\031\n\021vesselLightWeight\030\006 \001(\t\022\013\n\003dw"
          + "t\030\007 \001(\t\022\024\n\014sgCorrection\030\010 \001(\t\022\030\n\020sagging"
          + "Deduction\030\t \001(\t\022\024\n\014estFOOnBoard\030\n \001(\t\022\024\n"
          + "\014estDOOnBoard\030\013 \001(\t\022\034\n\024estFreshWaterOnBo"
          + "ard\030\014 \001(\t\022\020\n\010constant\030\r \001(\t\022\022\n\notherIfAn"
          + "y\030\016 \001(\t\022\025\n\rtotalQuantity\030\017 \001(\t\022\034\n\024distan"
          + "ceFromLastPort\030\020 \001(\t\022\032\n\022vesselAverageSpe"
          + "ed\030\021 \001(\t\022\033\n\023foConsumptionPerDay\030\022 \001(\t\022\035\n"
          + "\025estTotalFOConsumption\030\023 \001(\t\022\027\n\017loadable"
          + "StudyId\030\024 \001(\003\022\031\n\021updateDateAndTime\030\025 \001(\t"
          + "\"Y\n\025LoadableQuantityReply\022$\n\016responseSta"
          + "tus\030\001 \001(\0132\014.StatusReply\022\032\n\022loadableQuant"
          + "ityId\030\002 \001(\003\"M\n\024LoadableStudyRequest\022\021\n\tc"
          + "ompanyId\030\001 \001(\003\022\020\n\010vesselId\030\002 \001(\003\022\020\n\010voya"
          + "geId\030\003 \001(\003\"?\n\027LoadableStudyAttachment\022\022\n"
          + "\nbyteString\030\001 \001(\014\022\020\n\010fileName\030\002 \001(\t\"\325\002\n\023"
          + "LoadableStudyDetail\022\n\n\002id\030\001 \001(\003\022\014\n\004name\030"
          + "\002 \001(\t\022\016\n\006detail\030\003 \001(\t\022\016\n\006status\030\004 \001(\t\022\023\n"
          + "\013createdDate\030\005 \001(\t\022\021\n\tcharterer\030\006 \001(\t\022\024\n"
          + "\014subCharterer\030\007 \001(\t\022\021\n\tdraftMark\030\010 \001(\t\022\023"
          + "\n\013loadLineXId\030\t \001(\003\022\030\n\020draftRestriction\030"
          + "\n \001(\t\022\027\n\017maxTempExpected\030\013 \001(\t\022\030\n\020duplic"
          + "atedFromId\030\014 \001(\003\022\020\n\010voyageId\030\r \001(\003\022\020\n\010ve"
          + "sselId\030\016 \001(\003\022-\n\013attachments\030\017 \003(\0132\030.Load"
          + "ableStudyAttachment\"u\n\022LoadableStudyRepl"
          + "y\022$\n\016responseStatus\030\001 \001(\0132\014.StatusReply\022"
          + "-\n\017loadableStudies\030\002 \003(\0132\024.LoadableStudy"
          + "Detail\022\n\n\002id\030\003 \001(\003\"5\n\021LoadingPortDetail\022"
          + "\016\n\006portId\030\001 \001(\003\022\020\n\010quantity\030\002 \001(\t\".\n\021seg"
          + "regationDetail\022\n\n\002id\030\001 \001(\003\022\r\n\005value\030\002 \001("
          + "\t\"\230\002\n\025CargoNominationDetail\022\n\n\002id\030\001 \001(\003\022"
          + "\027\n\017loadableStudyId\030\002 \001(\003\022\020\n\010priority\030\003 \001"
          + "(\003\022\r\n\005color\030\004 \001(\t\022\017\n\007cargoId\030\005 \001(\003\022\024\n\014ab"
          + "breviation\030\006 \001(\t\022.\n\022loadingPortDetails\030\007"
          + " \003(\0132\022.LoadingPortDetail\022\024\n\014maxTolerance"
          + "\030\010 \001(\t\022\024\n\014minTolerance\030\t \001(\t\022\016\n\006apiEst\030\n"
          + " \001(\t\022\017\n\007tempEst\030\013 \001(\t\022\025\n\rsegregationId\030\014"
          + " \001(\003\"\214\001\n\026CargoNominationRequest\022\020\n\010vesse"
          + "lId\030\001 \001(\003\022\020\n\010voyageId\030\002 \001(\003\022\027\n\017loadableS"
          + "tudyId\030\003 \001(\003\0225\n\025cargoNominationDetail\030\004 "
          + "\001(\0132\026.CargoNominationDetail\"\214\001\n\024CargoNom"
          + "inationReply\022\'\n\016responseStatus\030\001 \001(\0132\017.R"
          + "esponseStatus\022\031\n\021cargoNominationId\030\002 \001(\003"
          + "\0220\n\020cargoNominations\030\003 \003(\0132\026.CargoNomina"
          + "tionDetail\"R\n\023PortRotationRequest\022\027\n\017loa"
          + "dableStudyId\030\001 \001(\003\022\020\n\010vesselId\030\002 \001(\003\022\020\n\010"
          + "voyageId\030\003 \001(\003\"\241\002\n\022PortRotationDetail\022\n\n"
          + "\002id\030\001 \001(\003\022\016\n\006portId\030\002 \001(\003\022\017\n\007berthId\030\003 \001"
          + "(\003\022\023\n\013operationId\030\004 \001(\003\022\027\n\017seaWaterDensi"
          + "ty\030\005 \001(\t\022\034\n\024distanceBetweenPorts\030\006 \001(\t\022\022"
          + "\n\ntimeOfStay\030\007 \001(\t\022\020\n\010maxDraft\030\010 \001(\t\022\023\n\013"
          + "maxAirDraft\030\t \001(\t\022\013\n\003eta\030\n \001(\t\022\013\n\003etd\030\013 "
          + "\001(\t\022\022\n\nlayCanFrom\030\014 \001(\t\022\020\n\010layCanTo\030\r \001("
          + "\t\022\027\n\017loadableStudyId\030\016 \001(\003\".\n\tOperation\022"
          + "\n\n\002id\030\001 \001(\003\022\025\n\roperationName\030\002 \001(\t\"\230\001\n\021P"
          + "ortRotationReply\022\'\n\016responseStatus\030\001 \001(\013"
          + "2\017.ResponseStatus\022\"\n\005ports\030\002 \003(\0132\023.PortR"
          + "otationDetail\022\036\n\noperations\030\003 \003(\0132\n.Oper"
          + "ation\022\026\n\016portRotationId\030\004 \001(\003\"{\n\030Loadabl"
          + "eQuantityResponse\0229\n\027loadableQuantityReq"
          + "uest\030\001 \001(\0132\030.LoadableQuantityRequest\022$\n\016"
          + "responseStatus\030\002 \001(\0132\014.StatusReply\",\n\020Va"
          + "lveSegregation\022\n\n\002id\030\001 \001(\003\022\014\n\004name\030\002 \001(\t"
          + "\"2\n\027ValveSegregationRequest\022\027\n\017loadableS"
          + "tudyId\030\001 \001(\003\"m\n\025ValveSegregationReply\022\'\n"
          + "\016responseStatus\030\001 \001(\0132\017.ResponseStatus\022+"
          + "\n\020valveSegregation\030\002 \003(\0132\021.ValveSegregat"
          + "ion2\246\006\n\024LoadableStudyService\022,\n\nSaveVoya"
          + "ge\022\016.VoyageRequest\032\014.VoyageReply\"\000\0228\n\022Ge"
          + "tVoyagesByVessel\022\016.VoyageRequest\032\020.Voyag"
          + "eListReply\"\000\022J\n\024SaveLoadableQuantity\022\030.L"
          + "oadableQuantityRequest\032\026.LoadableQuantit"
          + "yReply\"\000\022T\n$FindLoadableStudiesByVesselA"
          + "ndVoyage\022\025.LoadableStudyRequest\032\023.Loadab"
          + "leStudyReply\"\000\022@\n\021SaveLoadableStudy\022\024.Lo"
          + "adableStudyDetail\032\023.LoadableStudyReply\"\000"
          + "\022G\n\023SaveCargoNomination\022\027.CargoNominatio"
          + "nRequest\032\025.CargoNominationReply\"\000\022J\n\034Get"
          + "LoadableStudyPortRotation\022\024.PortRotation"
          + "Request\032\022.PortRotationReply\"\000\022J\n\026GetCarg"
          + "oNominationById\022\027.CargoNominationRequest"
          + "\032\025.CargoNominationReply\"\000\022I\n\023GetValveSeg"
          + "regation\022\030.ValveSegregationRequest\032\026.Val"
          + "veSegregationReply\"\000\022J\n\023getLoadableQuant"
          + "ity\022\026.LoadableQuantityReply\032\031.LoadableQu"
          + "antityResponse\"\000\022J\n\035SaveLoadableStudyPor"
          + "tRotation\022\023.PortRotationDetail\032\022.PortRot"
          + "ationReply\"\000B\036\n\032com.cpdss.common.generat"
          + "edP\000b\006proto3"
    };
    descriptor =
        com.google.protobuf.Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(
            descriptorData,
            new com.google.protobuf.Descriptors.FileDescriptor[] {
              com.cpdss.common.generated.Common.getDescriptor(),
            });
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
              "VoyageId", "ResponseStatus",
            });
    internal_static_VoyageDetail_descriptor = getDescriptor().getMessageTypes().get(2);
    internal_static_VoyageDetail_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_VoyageDetail_descriptor,
            new java.lang.String[] {
              "Id", "VoyageNumber",
            });
    internal_static_VoyageListReply_descriptor = getDescriptor().getMessageTypes().get(3);
    internal_static_VoyageListReply_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_VoyageListReply_descriptor,
            new java.lang.String[] {
              "ResponseStatus", "Voyages",
            });
    internal_static_StatusReply_descriptor = getDescriptor().getMessageTypes().get(4);
    internal_static_StatusReply_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_StatusReply_descriptor,
            new java.lang.String[] {
              "Status", "Code", "Message",
            });
    internal_static_LoadableQuantityRequest_descriptor = getDescriptor().getMessageTypes().get(5);
    internal_static_LoadableQuantityRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_LoadableQuantityRequest_descriptor,
            new java.lang.String[] {
              "LimitingDraft",
              "EstSeaDensity",
              "Tpc",
              "EstSagging",
              "DisplacmentDraftRestriction",
              "VesselLightWeight",
              "Dwt",
              "SgCorrection",
              "SaggingDeduction",
              "EstFOOnBoard",
              "EstDOOnBoard",
              "EstFreshWaterOnBoard",
              "Constant",
              "OtherIfAny",
              "TotalQuantity",
              "DistanceFromLastPort",
              "VesselAverageSpeed",
              "FoConsumptionPerDay",
              "EstTotalFOConsumption",
              "LoadableStudyId",
              "UpdateDateAndTime",
            });
    internal_static_LoadableQuantityReply_descriptor = getDescriptor().getMessageTypes().get(6);
    internal_static_LoadableQuantityReply_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_LoadableQuantityReply_descriptor,
            new java.lang.String[] {
              "ResponseStatus", "LoadableQuantityId",
            });
    internal_static_LoadableStudyRequest_descriptor = getDescriptor().getMessageTypes().get(7);
    internal_static_LoadableStudyRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_LoadableStudyRequest_descriptor,
            new java.lang.String[] {
              "CompanyId", "VesselId", "VoyageId",
            });
    internal_static_LoadableStudyAttachment_descriptor = getDescriptor().getMessageTypes().get(8);
    internal_static_LoadableStudyAttachment_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_LoadableStudyAttachment_descriptor,
            new java.lang.String[] {
              "ByteString", "FileName",
            });
    internal_static_LoadableStudyDetail_descriptor = getDescriptor().getMessageTypes().get(9);
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
              "DuplicatedFromId",
              "VoyageId",
              "VesselId",
              "Attachments",
            });
    internal_static_LoadableStudyReply_descriptor = getDescriptor().getMessageTypes().get(10);
    internal_static_LoadableStudyReply_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_LoadableStudyReply_descriptor,
            new java.lang.String[] {
              "ResponseStatus", "LoadableStudies", "Id",
            });
    internal_static_LoadingPortDetail_descriptor = getDescriptor().getMessageTypes().get(11);
    internal_static_LoadingPortDetail_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_LoadingPortDetail_descriptor,
            new java.lang.String[] {
              "PortId", "Quantity",
            });
    internal_static_segregationDetail_descriptor = getDescriptor().getMessageTypes().get(12);
    internal_static_segregationDetail_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_segregationDetail_descriptor,
            new java.lang.String[] {
              "Id", "Value",
            });
    internal_static_CargoNominationDetail_descriptor = getDescriptor().getMessageTypes().get(13);
    internal_static_CargoNominationDetail_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_CargoNominationDetail_descriptor,
            new java.lang.String[] {
              "Id",
              "LoadableStudyId",
              "Priority",
              "Color",
              "CargoId",
              "Abbreviation",
              "LoadingPortDetails",
              "MaxTolerance",
              "MinTolerance",
              "ApiEst",
              "TempEst",
              "SegregationId",
            });
    internal_static_CargoNominationRequest_descriptor = getDescriptor().getMessageTypes().get(14);
    internal_static_CargoNominationRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_CargoNominationRequest_descriptor,
            new java.lang.String[] {
              "VesselId", "VoyageId", "LoadableStudyId", "CargoNominationDetail",
            });
    internal_static_CargoNominationReply_descriptor = getDescriptor().getMessageTypes().get(15);
    internal_static_CargoNominationReply_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_CargoNominationReply_descriptor,
            new java.lang.String[] {
              "ResponseStatus", "CargoNominationId", "CargoNominations",
            });
    internal_static_PortRotationRequest_descriptor = getDescriptor().getMessageTypes().get(16);
    internal_static_PortRotationRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_PortRotationRequest_descriptor,
            new java.lang.String[] {
              "LoadableStudyId", "VesselId", "VoyageId",
            });
    internal_static_PortRotationDetail_descriptor = getDescriptor().getMessageTypes().get(17);
    internal_static_PortRotationDetail_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_PortRotationDetail_descriptor,
            new java.lang.String[] {
              "Id",
              "PortId",
              "BerthId",
              "OperationId",
              "SeaWaterDensity",
              "DistanceBetweenPorts",
              "TimeOfStay",
              "MaxDraft",
              "MaxAirDraft",
              "Eta",
              "Etd",
              "LayCanFrom",
              "LayCanTo",
              "LoadableStudyId",
            });
    internal_static_Operation_descriptor = getDescriptor().getMessageTypes().get(18);
    internal_static_Operation_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_Operation_descriptor,
            new java.lang.String[] {
              "Id", "OperationName",
            });
    internal_static_PortRotationReply_descriptor = getDescriptor().getMessageTypes().get(19);
    internal_static_PortRotationReply_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_PortRotationReply_descriptor,
            new java.lang.String[] {
              "ResponseStatus", "Ports", "Operations", "PortRotationId",
            });
    internal_static_LoadableQuantityResponse_descriptor = getDescriptor().getMessageTypes().get(20);
    internal_static_LoadableQuantityResponse_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_LoadableQuantityResponse_descriptor,
            new java.lang.String[] {
              "LoadableQuantityRequest", "ResponseStatus",
            });
    internal_static_ValveSegregation_descriptor = getDescriptor().getMessageTypes().get(21);
    internal_static_ValveSegregation_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_ValveSegregation_descriptor,
            new java.lang.String[] {
              "Id", "Name",
            });
    internal_static_ValveSegregationRequest_descriptor = getDescriptor().getMessageTypes().get(22);
    internal_static_ValveSegregationRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_ValveSegregationRequest_descriptor,
            new java.lang.String[] {
              "LoadableStudyId",
            });
    internal_static_ValveSegregationReply_descriptor = getDescriptor().getMessageTypes().get(23);
    internal_static_ValveSegregationReply_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_ValveSegregationReply_descriptor,
            new java.lang.String[] {
              "ResponseStatus", "ValveSegregation",
            });
    com.cpdss.common.generated.Common.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
