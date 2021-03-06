/* Licensed at AlphaOri Technologies */
package com.cpdss.common.generated;

public final class TaskManager {
  private TaskManager() {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistryLite registry) {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions((com.google.protobuf.ExtensionRegistryLite) registry);
  }

  public interface SchedulededTaskRequestOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:SchedulededTaskRequest)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>string jobGroup = 1;</code>
     *
     * @return The jobGroup.
     */
    java.lang.String getJobGroup();
    /**
     * <code>string jobGroup = 1;</code>
     *
     * @return The bytes for jobGroup.
     */
    com.google.protobuf.ByteString getJobGroupBytes();
  }
  /** Protobuf type {@code SchedulededTaskRequest} */
  public static final class SchedulededTaskRequest extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:SchedulededTaskRequest)
      SchedulededTaskRequestOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use SchedulededTaskRequest.newBuilder() to construct.
    private SchedulededTaskRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private SchedulededTaskRequest() {
      jobGroup_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new SchedulededTaskRequest();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private SchedulededTaskRequest(
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

                jobGroup_ = s;
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
      return com.cpdss.common.generated.TaskManager
          .internal_static_SchedulededTaskRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.TaskManager
          .internal_static_SchedulededTaskRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.TaskManager.SchedulededTaskRequest.class,
              com.cpdss.common.generated.TaskManager.SchedulededTaskRequest.Builder.class);
    }

    public static final int JOBGROUP_FIELD_NUMBER = 1;
    private volatile java.lang.Object jobGroup_;
    /**
     * <code>string jobGroup = 1;</code>
     *
     * @return The jobGroup.
     */
    public java.lang.String getJobGroup() {
      java.lang.Object ref = jobGroup_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        jobGroup_ = s;
        return s;
      }
    }
    /**
     * <code>string jobGroup = 1;</code>
     *
     * @return The bytes for jobGroup.
     */
    public com.google.protobuf.ByteString getJobGroupBytes() {
      java.lang.Object ref = jobGroup_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        jobGroup_ = b;
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
      if (!getJobGroupBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, jobGroup_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getJobGroupBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, jobGroup_);
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
      if (!(obj instanceof com.cpdss.common.generated.TaskManager.SchedulededTaskRequest)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.TaskManager.SchedulededTaskRequest other =
          (com.cpdss.common.generated.TaskManager.SchedulededTaskRequest) obj;

      if (!getJobGroup().equals(other.getJobGroup())) return false;
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
      hash = (37 * hash) + JOBGROUP_FIELD_NUMBER;
      hash = (53 * hash) + getJobGroup().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.TaskManager.SchedulededTaskRequest parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.TaskManager.SchedulededTaskRequest parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.TaskManager.SchedulededTaskRequest parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.TaskManager.SchedulededTaskRequest parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.TaskManager.SchedulededTaskRequest parseFrom(
        byte[] data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.TaskManager.SchedulededTaskRequest parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.TaskManager.SchedulededTaskRequest parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.TaskManager.SchedulededTaskRequest parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.TaskManager.SchedulededTaskRequest parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.TaskManager.SchedulededTaskRequest parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.TaskManager.SchedulededTaskRequest parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.TaskManager.SchedulededTaskRequest parseFrom(
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
        com.cpdss.common.generated.TaskManager.SchedulededTaskRequest prototype) {
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
    /** Protobuf type {@code SchedulededTaskRequest} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:SchedulededTaskRequest)
        com.cpdss.common.generated.TaskManager.SchedulededTaskRequestOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.TaskManager
            .internal_static_SchedulededTaskRequest_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.TaskManager
            .internal_static_SchedulededTaskRequest_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.TaskManager.SchedulededTaskRequest.class,
                com.cpdss.common.generated.TaskManager.SchedulededTaskRequest.Builder.class);
      }

      // Construct using com.cpdss.common.generated.TaskManager.SchedulededTaskRequest.newBuilder()
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
        jobGroup_ = "";

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.TaskManager
            .internal_static_SchedulededTaskRequest_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.TaskManager.SchedulededTaskRequest
          getDefaultInstanceForType() {
        return com.cpdss.common.generated.TaskManager.SchedulededTaskRequest.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.TaskManager.SchedulededTaskRequest build() {
        com.cpdss.common.generated.TaskManager.SchedulededTaskRequest result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.TaskManager.SchedulededTaskRequest buildPartial() {
        com.cpdss.common.generated.TaskManager.SchedulededTaskRequest result =
            new com.cpdss.common.generated.TaskManager.SchedulededTaskRequest(this);
        result.jobGroup_ = jobGroup_;
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
        if (other instanceof com.cpdss.common.generated.TaskManager.SchedulededTaskRequest) {
          return mergeFrom((com.cpdss.common.generated.TaskManager.SchedulededTaskRequest) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(
          com.cpdss.common.generated.TaskManager.SchedulededTaskRequest other) {
        if (other
            == com.cpdss.common.generated.TaskManager.SchedulededTaskRequest.getDefaultInstance())
          return this;
        if (!other.getJobGroup().isEmpty()) {
          jobGroup_ = other.jobGroup_;
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
        com.cpdss.common.generated.TaskManager.SchedulededTaskRequest parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.TaskManager.SchedulededTaskRequest)
                  e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private java.lang.Object jobGroup_ = "";
      /**
       * <code>string jobGroup = 1;</code>
       *
       * @return The jobGroup.
       */
      public java.lang.String getJobGroup() {
        java.lang.Object ref = jobGroup_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          jobGroup_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string jobGroup = 1;</code>
       *
       * @return The bytes for jobGroup.
       */
      public com.google.protobuf.ByteString getJobGroupBytes() {
        java.lang.Object ref = jobGroup_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          jobGroup_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string jobGroup = 1;</code>
       *
       * @param value The jobGroup to set.
       * @return This builder for chaining.
       */
      public Builder setJobGroup(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        jobGroup_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string jobGroup = 1;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearJobGroup() {

        jobGroup_ = getDefaultInstance().getJobGroup();
        onChanged();
        return this;
      }
      /**
       * <code>string jobGroup = 1;</code>
       *
       * @param value The bytes for jobGroup to set.
       * @return This builder for chaining.
       */
      public Builder setJobGroupBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        jobGroup_ = value;
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

      // @@protoc_insertion_point(builder_scope:SchedulededTaskRequest)
    }

    // @@protoc_insertion_point(class_scope:SchedulededTaskRequest)
    private static final com.cpdss.common.generated.TaskManager.SchedulededTaskRequest
        DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.TaskManager.SchedulededTaskRequest();
    }

    public static com.cpdss.common.generated.TaskManager.SchedulededTaskRequest
        getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<SchedulededTaskRequest> PARSER =
        new com.google.protobuf.AbstractParser<SchedulededTaskRequest>() {
          @java.lang.Override
          public SchedulededTaskRequest parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new SchedulededTaskRequest(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<SchedulededTaskRequest> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<SchedulededTaskRequest> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.TaskManager.SchedulededTaskRequest
        getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface SchedulededTaskReplyOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:SchedulededTaskReply)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>repeated string taskName = 1;</code>
     *
     * @return A list containing the taskName.
     */
    java.util.List<java.lang.String> getTaskNameList();
    /**
     * <code>repeated string taskName = 1;</code>
     *
     * @return The count of taskName.
     */
    int getTaskNameCount();
    /**
     * <code>repeated string taskName = 1;</code>
     *
     * @param index The index of the element to return.
     * @return The taskName at the given index.
     */
    java.lang.String getTaskName(int index);
    /**
     * <code>repeated string taskName = 1;</code>
     *
     * @param index The index of the value to return.
     * @return The bytes of the taskName at the given index.
     */
    com.google.protobuf.ByteString getTaskNameBytes(int index);

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
  /** Protobuf type {@code SchedulededTaskReply} */
  public static final class SchedulededTaskReply extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:SchedulededTaskReply)
      SchedulededTaskReplyOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use SchedulededTaskReply.newBuilder() to construct.
    private SchedulededTaskReply(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private SchedulededTaskReply() {
      taskName_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new SchedulededTaskReply();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private SchedulededTaskReply(
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
                if (!((mutable_bitField0_ & 0x00000001) != 0)) {
                  taskName_ = new com.google.protobuf.LazyStringArrayList();
                  mutable_bitField0_ |= 0x00000001;
                }
                taskName_.add(s);
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
          taskName_ = taskName_.getUnmodifiableView();
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }

    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.cpdss.common.generated.TaskManager.internal_static_SchedulededTaskReply_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.TaskManager
          .internal_static_SchedulededTaskReply_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.TaskManager.SchedulededTaskReply.class,
              com.cpdss.common.generated.TaskManager.SchedulededTaskReply.Builder.class);
    }

    public static final int TASKNAME_FIELD_NUMBER = 1;
    private com.google.protobuf.LazyStringList taskName_;
    /**
     * <code>repeated string taskName = 1;</code>
     *
     * @return A list containing the taskName.
     */
    public com.google.protobuf.ProtocolStringList getTaskNameList() {
      return taskName_;
    }
    /**
     * <code>repeated string taskName = 1;</code>
     *
     * @return The count of taskName.
     */
    public int getTaskNameCount() {
      return taskName_.size();
    }
    /**
     * <code>repeated string taskName = 1;</code>
     *
     * @param index The index of the element to return.
     * @return The taskName at the given index.
     */
    public java.lang.String getTaskName(int index) {
      return taskName_.get(index);
    }
    /**
     * <code>repeated string taskName = 1;</code>
     *
     * @param index The index of the value to return.
     * @return The bytes of the taskName at the given index.
     */
    public com.google.protobuf.ByteString getTaskNameBytes(int index) {
      return taskName_.getByteString(index);
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
      for (int i = 0; i < taskName_.size(); i++) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, taskName_.getRaw(i));
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
      {
        int dataSize = 0;
        for (int i = 0; i < taskName_.size(); i++) {
          dataSize += computeStringSizeNoTag(taskName_.getRaw(i));
        }
        size += dataSize;
        size += 1 * getTaskNameList().size();
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
      if (!(obj instanceof com.cpdss.common.generated.TaskManager.SchedulededTaskReply)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.TaskManager.SchedulededTaskReply other =
          (com.cpdss.common.generated.TaskManager.SchedulededTaskReply) obj;

      if (!getTaskNameList().equals(other.getTaskNameList())) return false;
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
      if (getTaskNameCount() > 0) {
        hash = (37 * hash) + TASKNAME_FIELD_NUMBER;
        hash = (53 * hash) + getTaskNameList().hashCode();
      }
      if (hasResponseStatus()) {
        hash = (37 * hash) + RESPONSESTATUS_FIELD_NUMBER;
        hash = (53 * hash) + getResponseStatus().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.TaskManager.SchedulededTaskReply parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.TaskManager.SchedulededTaskReply parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.TaskManager.SchedulededTaskReply parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.TaskManager.SchedulededTaskReply parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.TaskManager.SchedulededTaskReply parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.TaskManager.SchedulededTaskReply parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.TaskManager.SchedulededTaskReply parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.TaskManager.SchedulededTaskReply parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.TaskManager.SchedulededTaskReply parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.TaskManager.SchedulededTaskReply parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.TaskManager.SchedulededTaskReply parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.TaskManager.SchedulededTaskReply parseFrom(
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
        com.cpdss.common.generated.TaskManager.SchedulededTaskReply prototype) {
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
    /** Protobuf type {@code SchedulededTaskReply} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:SchedulededTaskReply)
        com.cpdss.common.generated.TaskManager.SchedulededTaskReplyOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.TaskManager
            .internal_static_SchedulededTaskReply_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.TaskManager
            .internal_static_SchedulededTaskReply_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.TaskManager.SchedulededTaskReply.class,
                com.cpdss.common.generated.TaskManager.SchedulededTaskReply.Builder.class);
      }

      // Construct using com.cpdss.common.generated.TaskManager.SchedulededTaskReply.newBuilder()
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
        taskName_ = com.google.protobuf.LazyStringArrayList.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000001);
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
        return com.cpdss.common.generated.TaskManager
            .internal_static_SchedulededTaskReply_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.TaskManager.SchedulededTaskReply
          getDefaultInstanceForType() {
        return com.cpdss.common.generated.TaskManager.SchedulededTaskReply.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.TaskManager.SchedulededTaskReply build() {
        com.cpdss.common.generated.TaskManager.SchedulededTaskReply result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.TaskManager.SchedulededTaskReply buildPartial() {
        com.cpdss.common.generated.TaskManager.SchedulededTaskReply result =
            new com.cpdss.common.generated.TaskManager.SchedulededTaskReply(this);
        int from_bitField0_ = bitField0_;
        if (((bitField0_ & 0x00000001) != 0)) {
          taskName_ = taskName_.getUnmodifiableView();
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.taskName_ = taskName_;
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
        if (other instanceof com.cpdss.common.generated.TaskManager.SchedulededTaskReply) {
          return mergeFrom((com.cpdss.common.generated.TaskManager.SchedulededTaskReply) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.cpdss.common.generated.TaskManager.SchedulededTaskReply other) {
        if (other
            == com.cpdss.common.generated.TaskManager.SchedulededTaskReply.getDefaultInstance())
          return this;
        if (!other.taskName_.isEmpty()) {
          if (taskName_.isEmpty()) {
            taskName_ = other.taskName_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureTaskNameIsMutable();
            taskName_.addAll(other.taskName_);
          }
          onChanged();
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
        com.cpdss.common.generated.TaskManager.SchedulededTaskReply parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.TaskManager.SchedulededTaskReply)
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

      private com.google.protobuf.LazyStringList taskName_ =
          com.google.protobuf.LazyStringArrayList.EMPTY;

      private void ensureTaskNameIsMutable() {
        if (!((bitField0_ & 0x00000001) != 0)) {
          taskName_ = new com.google.protobuf.LazyStringArrayList(taskName_);
          bitField0_ |= 0x00000001;
        }
      }
      /**
       * <code>repeated string taskName = 1;</code>
       *
       * @return A list containing the taskName.
       */
      public com.google.protobuf.ProtocolStringList getTaskNameList() {
        return taskName_.getUnmodifiableView();
      }
      /**
       * <code>repeated string taskName = 1;</code>
       *
       * @return The count of taskName.
       */
      public int getTaskNameCount() {
        return taskName_.size();
      }
      /**
       * <code>repeated string taskName = 1;</code>
       *
       * @param index The index of the element to return.
       * @return The taskName at the given index.
       */
      public java.lang.String getTaskName(int index) {
        return taskName_.get(index);
      }
      /**
       * <code>repeated string taskName = 1;</code>
       *
       * @param index The index of the value to return.
       * @return The bytes of the taskName at the given index.
       */
      public com.google.protobuf.ByteString getTaskNameBytes(int index) {
        return taskName_.getByteString(index);
      }
      /**
       * <code>repeated string taskName = 1;</code>
       *
       * @param index The index to set the value at.
       * @param value The taskName to set.
       * @return This builder for chaining.
       */
      public Builder setTaskName(int index, java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureTaskNameIsMutable();
        taskName_.set(index, value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated string taskName = 1;</code>
       *
       * @param value The taskName to add.
       * @return This builder for chaining.
       */
      public Builder addTaskName(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureTaskNameIsMutable();
        taskName_.add(value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated string taskName = 1;</code>
       *
       * @param values The taskName to add.
       * @return This builder for chaining.
       */
      public Builder addAllTaskName(java.lang.Iterable<java.lang.String> values) {
        ensureTaskNameIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(values, taskName_);
        onChanged();
        return this;
      }
      /**
       * <code>repeated string taskName = 1;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearTaskName() {
        taskName_ = com.google.protobuf.LazyStringArrayList.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
        return this;
      }
      /**
       * <code>repeated string taskName = 1;</code>
       *
       * @param value The bytes of the taskName to add.
       * @return This builder for chaining.
       */
      public Builder addTaskNameBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);
        ensureTaskNameIsMutable();
        taskName_.add(value);
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

      // @@protoc_insertion_point(builder_scope:SchedulededTaskReply)
    }

    // @@protoc_insertion_point(class_scope:SchedulededTaskReply)
    private static final com.cpdss.common.generated.TaskManager.SchedulededTaskReply
        DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.TaskManager.SchedulededTaskReply();
    }

    public static com.cpdss.common.generated.TaskManager.SchedulededTaskReply getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<SchedulededTaskReply> PARSER =
        new com.google.protobuf.AbstractParser<SchedulededTaskReply>() {
          @java.lang.Override
          public SchedulededTaskReply parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new SchedulededTaskReply(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<SchedulededTaskReply> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<SchedulededTaskReply> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.TaskManager.SchedulededTaskReply getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface ScheduleTaskRequestOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:ScheduleTaskRequest)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>string taskName = 1;</code>
     *
     * @return The taskName.
     */
    java.lang.String getTaskName();
    /**
     * <code>string taskName = 1;</code>
     *
     * @return The bytes for taskName.
     */
    com.google.protobuf.ByteString getTaskNameBytes();

    /**
     * <code>string taskURI = 2;</code>
     *
     * @return The taskURI.
     */
    java.lang.String getTaskURI();
    /**
     * <code>string taskURI = 2;</code>
     *
     * @return The bytes for taskURI.
     */
    com.google.protobuf.ByteString getTaskURIBytes();

    /**
     * <code>.google.protobuf.Timestamp taskStartDateTime = 3;</code>
     *
     * @return Whether the taskStartDateTime field is set.
     */
    boolean hasTaskStartDateTime();
    /**
     * <code>.google.protobuf.Timestamp taskStartDateTime = 3;</code>
     *
     * @return The taskStartDateTime.
     */
    com.google.protobuf.Timestamp getTaskStartDateTime();
    /** <code>.google.protobuf.Timestamp taskStartDateTime = 3;</code> */
    com.google.protobuf.TimestampOrBuilder getTaskStartDateTimeOrBuilder();

    /**
     * <code>.google.protobuf.Timestamp taskEndDateTime = 4;</code>
     *
     * @return Whether the taskEndDateTime field is set.
     */
    boolean hasTaskEndDateTime();
    /**
     * <code>.google.protobuf.Timestamp taskEndDateTime = 4;</code>
     *
     * @return The taskEndDateTime.
     */
    com.google.protobuf.Timestamp getTaskEndDateTime();
    /** <code>.google.protobuf.Timestamp taskEndDateTime = 4;</code> */
    com.google.protobuf.TimestampOrBuilder getTaskEndDateTimeOrBuilder();

    /**
     * <code>string taskType = 5;</code>
     *
     * @return The taskType.
     */
    java.lang.String getTaskType();
    /**
     * <code>string taskType = 5;</code>
     *
     * @return The bytes for taskType.
     */
    com.google.protobuf.ByteString getTaskTypeBytes();

    /**
     * <code>string cronExpression = 6;</code>
     *
     * @return The cronExpression.
     */
    java.lang.String getCronExpression();
    /**
     * <code>string cronExpression = 6;</code>
     *
     * @return The bytes for cronExpression.
     */
    com.google.protobuf.ByteString getCronExpressionBytes();

    /**
     * <code>int32 taskFrequency = 7;</code>
     *
     * @return The taskFrequency.
     */
    int getTaskFrequency();

    /** <code>map&lt;string, string&gt; taskReqParam = 8;</code> */
    int getTaskReqParamCount();
    /** <code>map&lt;string, string&gt; taskReqParam = 8;</code> */
    boolean containsTaskReqParam(java.lang.String key);
    /** Use {@link #getTaskReqParamMap()} instead. */
    @java.lang.Deprecated
    java.util.Map<java.lang.String, java.lang.String> getTaskReqParam();
    /** <code>map&lt;string, string&gt; taskReqParam = 8;</code> */
    java.util.Map<java.lang.String, java.lang.String> getTaskReqParamMap();
    /** <code>map&lt;string, string&gt; taskReqParam = 8;</code> */
    java.lang.String getTaskReqParamOrDefault(java.lang.String key, java.lang.String defaultValue);
    /** <code>map&lt;string, string&gt; taskReqParam = 8;</code> */
    java.lang.String getTaskReqParamOrThrow(java.lang.String key);

    public com.cpdss.common.generated.TaskManager.ScheduleTaskRequest.TaskIntervalCase
        getTaskIntervalCase();
  }
  /** Protobuf type {@code ScheduleTaskRequest} */
  public static final class ScheduleTaskRequest extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:ScheduleTaskRequest)
      ScheduleTaskRequestOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use ScheduleTaskRequest.newBuilder() to construct.
    private ScheduleTaskRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private ScheduleTaskRequest() {
      taskName_ = "";
      taskURI_ = "";
      taskType_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new ScheduleTaskRequest();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private ScheduleTaskRequest(
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

                taskName_ = s;
                break;
              }
            case 18:
              {
                java.lang.String s = input.readStringRequireUtf8();

                taskURI_ = s;
                break;
              }
            case 26:
              {
                com.google.protobuf.Timestamp.Builder subBuilder = null;
                if (taskStartDateTime_ != null) {
                  subBuilder = taskStartDateTime_.toBuilder();
                }
                taskStartDateTime_ =
                    input.readMessage(com.google.protobuf.Timestamp.parser(), extensionRegistry);
                if (subBuilder != null) {
                  subBuilder.mergeFrom(taskStartDateTime_);
                  taskStartDateTime_ = subBuilder.buildPartial();
                }

                break;
              }
            case 34:
              {
                com.google.protobuf.Timestamp.Builder subBuilder = null;
                if (taskEndDateTime_ != null) {
                  subBuilder = taskEndDateTime_.toBuilder();
                }
                taskEndDateTime_ =
                    input.readMessage(com.google.protobuf.Timestamp.parser(), extensionRegistry);
                if (subBuilder != null) {
                  subBuilder.mergeFrom(taskEndDateTime_);
                  taskEndDateTime_ = subBuilder.buildPartial();
                }

                break;
              }
            case 42:
              {
                java.lang.String s = input.readStringRequireUtf8();

                taskType_ = s;
                break;
              }
            case 50:
              {
                java.lang.String s = input.readStringRequireUtf8();
                taskIntervalCase_ = 6;
                taskInterval_ = s;
                break;
              }
            case 56:
              {
                taskIntervalCase_ = 7;
                taskInterval_ = input.readInt32();
                break;
              }
            case 66:
              {
                if (!((mutable_bitField0_ & 0x00000001) != 0)) {
                  taskReqParam_ =
                      com.google.protobuf.MapField.newMapField(
                          TaskReqParamDefaultEntryHolder.defaultEntry);
                  mutable_bitField0_ |= 0x00000001;
                }
                com.google.protobuf.MapEntry<java.lang.String, java.lang.String> taskReqParam__ =
                    input.readMessage(
                        TaskReqParamDefaultEntryHolder.defaultEntry.getParserForType(),
                        extensionRegistry);
                taskReqParam_
                    .getMutableMap()
                    .put(taskReqParam__.getKey(), taskReqParam__.getValue());
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
      return com.cpdss.common.generated.TaskManager.internal_static_ScheduleTaskRequest_descriptor;
    }

    @SuppressWarnings({"rawtypes"})
    @java.lang.Override
    protected com.google.protobuf.MapField internalGetMapField(int number) {
      switch (number) {
        case 8:
          return internalGetTaskReqParam();
        default:
          throw new RuntimeException("Invalid map field number: " + number);
      }
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.TaskManager
          .internal_static_ScheduleTaskRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.TaskManager.ScheduleTaskRequest.class,
              com.cpdss.common.generated.TaskManager.ScheduleTaskRequest.Builder.class);
    }

    private int taskIntervalCase_ = 0;
    private java.lang.Object taskInterval_;

    public enum TaskIntervalCase
        implements
            com.google.protobuf.Internal.EnumLite,
            com.google.protobuf.AbstractMessage.InternalOneOfEnum {
      CRONEXPRESSION(6),
      TASKFREQUENCY(7),
      TASKINTERVAL_NOT_SET(0);
      private final int value;

      private TaskIntervalCase(int value) {
        this.value = value;
      }
      /**
       * @param value The number of the enum to look for.
       * @return The enum associated with the given number.
       * @deprecated Use {@link #forNumber(int)} instead.
       */
      @java.lang.Deprecated
      public static TaskIntervalCase valueOf(int value) {
        return forNumber(value);
      }

      public static TaskIntervalCase forNumber(int value) {
        switch (value) {
          case 6:
            return CRONEXPRESSION;
          case 7:
            return TASKFREQUENCY;
          case 0:
            return TASKINTERVAL_NOT_SET;
          default:
            return null;
        }
      }

      public int getNumber() {
        return this.value;
      }
    };

    public TaskIntervalCase getTaskIntervalCase() {
      return TaskIntervalCase.forNumber(taskIntervalCase_);
    }

    public static final int TASKNAME_FIELD_NUMBER = 1;
    private volatile java.lang.Object taskName_;
    /**
     * <code>string taskName = 1;</code>
     *
     * @return The taskName.
     */
    public java.lang.String getTaskName() {
      java.lang.Object ref = taskName_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        taskName_ = s;
        return s;
      }
    }
    /**
     * <code>string taskName = 1;</code>
     *
     * @return The bytes for taskName.
     */
    public com.google.protobuf.ByteString getTaskNameBytes() {
      java.lang.Object ref = taskName_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        taskName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int TASKURI_FIELD_NUMBER = 2;
    private volatile java.lang.Object taskURI_;
    /**
     * <code>string taskURI = 2;</code>
     *
     * @return The taskURI.
     */
    public java.lang.String getTaskURI() {
      java.lang.Object ref = taskURI_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        taskURI_ = s;
        return s;
      }
    }
    /**
     * <code>string taskURI = 2;</code>
     *
     * @return The bytes for taskURI.
     */
    public com.google.protobuf.ByteString getTaskURIBytes() {
      java.lang.Object ref = taskURI_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        taskURI_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int TASKSTARTDATETIME_FIELD_NUMBER = 3;
    private com.google.protobuf.Timestamp taskStartDateTime_;
    /**
     * <code>.google.protobuf.Timestamp taskStartDateTime = 3;</code>
     *
     * @return Whether the taskStartDateTime field is set.
     */
    public boolean hasTaskStartDateTime() {
      return taskStartDateTime_ != null;
    }
    /**
     * <code>.google.protobuf.Timestamp taskStartDateTime = 3;</code>
     *
     * @return The taskStartDateTime.
     */
    public com.google.protobuf.Timestamp getTaskStartDateTime() {
      return taskStartDateTime_ == null
          ? com.google.protobuf.Timestamp.getDefaultInstance()
          : taskStartDateTime_;
    }
    /** <code>.google.protobuf.Timestamp taskStartDateTime = 3;</code> */
    public com.google.protobuf.TimestampOrBuilder getTaskStartDateTimeOrBuilder() {
      return getTaskStartDateTime();
    }

    public static final int TASKENDDATETIME_FIELD_NUMBER = 4;
    private com.google.protobuf.Timestamp taskEndDateTime_;
    /**
     * <code>.google.protobuf.Timestamp taskEndDateTime = 4;</code>
     *
     * @return Whether the taskEndDateTime field is set.
     */
    public boolean hasTaskEndDateTime() {
      return taskEndDateTime_ != null;
    }
    /**
     * <code>.google.protobuf.Timestamp taskEndDateTime = 4;</code>
     *
     * @return The taskEndDateTime.
     */
    public com.google.protobuf.Timestamp getTaskEndDateTime() {
      return taskEndDateTime_ == null
          ? com.google.protobuf.Timestamp.getDefaultInstance()
          : taskEndDateTime_;
    }
    /** <code>.google.protobuf.Timestamp taskEndDateTime = 4;</code> */
    public com.google.protobuf.TimestampOrBuilder getTaskEndDateTimeOrBuilder() {
      return getTaskEndDateTime();
    }

    public static final int TASKTYPE_FIELD_NUMBER = 5;
    private volatile java.lang.Object taskType_;
    /**
     * <code>string taskType = 5;</code>
     *
     * @return The taskType.
     */
    public java.lang.String getTaskType() {
      java.lang.Object ref = taskType_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        taskType_ = s;
        return s;
      }
    }
    /**
     * <code>string taskType = 5;</code>
     *
     * @return The bytes for taskType.
     */
    public com.google.protobuf.ByteString getTaskTypeBytes() {
      java.lang.Object ref = taskType_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        taskType_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int CRONEXPRESSION_FIELD_NUMBER = 6;
    /**
     * <code>string cronExpression = 6;</code>
     *
     * @return The cronExpression.
     */
    public java.lang.String getCronExpression() {
      java.lang.Object ref = "";
      if (taskIntervalCase_ == 6) {
        ref = taskInterval_;
      }
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (taskIntervalCase_ == 6) {
          taskInterval_ = s;
        }
        return s;
      }
    }
    /**
     * <code>string cronExpression = 6;</code>
     *
     * @return The bytes for cronExpression.
     */
    public com.google.protobuf.ByteString getCronExpressionBytes() {
      java.lang.Object ref = "";
      if (taskIntervalCase_ == 6) {
        ref = taskInterval_;
      }
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        if (taskIntervalCase_ == 6) {
          taskInterval_ = b;
        }
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int TASKFREQUENCY_FIELD_NUMBER = 7;
    /**
     * <code>int32 taskFrequency = 7;</code>
     *
     * @return The taskFrequency.
     */
    public int getTaskFrequency() {
      if (taskIntervalCase_ == 7) {
        return (java.lang.Integer) taskInterval_;
      }
      return 0;
    }

    public static final int TASKREQPARAM_FIELD_NUMBER = 8;

    private static final class TaskReqParamDefaultEntryHolder {
      static final com.google.protobuf.MapEntry<java.lang.String, java.lang.String> defaultEntry =
          com.google.protobuf.MapEntry.<java.lang.String, java.lang.String>newDefaultInstance(
              com.cpdss.common.generated.TaskManager
                  .internal_static_ScheduleTaskRequest_TaskReqParamEntry_descriptor,
              com.google.protobuf.WireFormat.FieldType.STRING,
              "",
              com.google.protobuf.WireFormat.FieldType.STRING,
              "");
    }

    private com.google.protobuf.MapField<java.lang.String, java.lang.String> taskReqParam_;

    private com.google.protobuf.MapField<java.lang.String, java.lang.String>
        internalGetTaskReqParam() {
      if (taskReqParam_ == null) {
        return com.google.protobuf.MapField.emptyMapField(
            TaskReqParamDefaultEntryHolder.defaultEntry);
      }
      return taskReqParam_;
    }

    public int getTaskReqParamCount() {
      return internalGetTaskReqParam().getMap().size();
    }
    /** <code>map&lt;string, string&gt; taskReqParam = 8;</code> */
    public boolean containsTaskReqParam(java.lang.String key) {
      if (key == null) {
        throw new java.lang.NullPointerException();
      }
      return internalGetTaskReqParam().getMap().containsKey(key);
    }
    /** Use {@link #getTaskReqParamMap()} instead. */
    @java.lang.Deprecated
    public java.util.Map<java.lang.String, java.lang.String> getTaskReqParam() {
      return getTaskReqParamMap();
    }
    /** <code>map&lt;string, string&gt; taskReqParam = 8;</code> */
    public java.util.Map<java.lang.String, java.lang.String> getTaskReqParamMap() {
      return internalGetTaskReqParam().getMap();
    }
    /** <code>map&lt;string, string&gt; taskReqParam = 8;</code> */
    public java.lang.String getTaskReqParamOrDefault(
        java.lang.String key, java.lang.String defaultValue) {
      if (key == null) {
        throw new java.lang.NullPointerException();
      }
      java.util.Map<java.lang.String, java.lang.String> map = internalGetTaskReqParam().getMap();
      return map.containsKey(key) ? map.get(key) : defaultValue;
    }
    /** <code>map&lt;string, string&gt; taskReqParam = 8;</code> */
    public java.lang.String getTaskReqParamOrThrow(java.lang.String key) {
      if (key == null) {
        throw new java.lang.NullPointerException();
      }
      java.util.Map<java.lang.String, java.lang.String> map = internalGetTaskReqParam().getMap();
      if (!map.containsKey(key)) {
        throw new java.lang.IllegalArgumentException();
      }
      return map.get(key);
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
      if (!getTaskNameBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, taskName_);
      }
      if (!getTaskURIBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, taskURI_);
      }
      if (taskStartDateTime_ != null) {
        output.writeMessage(3, getTaskStartDateTime());
      }
      if (taskEndDateTime_ != null) {
        output.writeMessage(4, getTaskEndDateTime());
      }
      if (!getTaskTypeBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 5, taskType_);
      }
      if (taskIntervalCase_ == 6) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 6, taskInterval_);
      }
      if (taskIntervalCase_ == 7) {
        output.writeInt32(7, (int) ((java.lang.Integer) taskInterval_));
      }
      com.google.protobuf.GeneratedMessageV3.serializeStringMapTo(
          output, internalGetTaskReqParam(), TaskReqParamDefaultEntryHolder.defaultEntry, 8);
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getTaskNameBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, taskName_);
      }
      if (!getTaskURIBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, taskURI_);
      }
      if (taskStartDateTime_ != null) {
        size += com.google.protobuf.CodedOutputStream.computeMessageSize(3, getTaskStartDateTime());
      }
      if (taskEndDateTime_ != null) {
        size += com.google.protobuf.CodedOutputStream.computeMessageSize(4, getTaskEndDateTime());
      }
      if (!getTaskTypeBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, taskType_);
      }
      if (taskIntervalCase_ == 6) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(6, taskInterval_);
      }
      if (taskIntervalCase_ == 7) {
        size +=
            com.google.protobuf.CodedOutputStream.computeInt32Size(
                7, (int) ((java.lang.Integer) taskInterval_));
      }
      for (java.util.Map.Entry<java.lang.String, java.lang.String> entry :
          internalGetTaskReqParam().getMap().entrySet()) {
        com.google.protobuf.MapEntry<java.lang.String, java.lang.String> taskReqParam__ =
            TaskReqParamDefaultEntryHolder.defaultEntry
                .newBuilderForType()
                .setKey(entry.getKey())
                .setValue(entry.getValue())
                .build();
        size += com.google.protobuf.CodedOutputStream.computeMessageSize(8, taskReqParam__);
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
      if (!(obj instanceof com.cpdss.common.generated.TaskManager.ScheduleTaskRequest)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.TaskManager.ScheduleTaskRequest other =
          (com.cpdss.common.generated.TaskManager.ScheduleTaskRequest) obj;

      if (!getTaskName().equals(other.getTaskName())) return false;
      if (!getTaskURI().equals(other.getTaskURI())) return false;
      if (hasTaskStartDateTime() != other.hasTaskStartDateTime()) return false;
      if (hasTaskStartDateTime()) {
        if (!getTaskStartDateTime().equals(other.getTaskStartDateTime())) return false;
      }
      if (hasTaskEndDateTime() != other.hasTaskEndDateTime()) return false;
      if (hasTaskEndDateTime()) {
        if (!getTaskEndDateTime().equals(other.getTaskEndDateTime())) return false;
      }
      if (!getTaskType().equals(other.getTaskType())) return false;
      if (!internalGetTaskReqParam().equals(other.internalGetTaskReqParam())) return false;
      if (!getTaskIntervalCase().equals(other.getTaskIntervalCase())) return false;
      switch (taskIntervalCase_) {
        case 6:
          if (!getCronExpression().equals(other.getCronExpression())) return false;
          break;
        case 7:
          if (getTaskFrequency() != other.getTaskFrequency()) return false;
          break;
        case 0:
        default:
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
      hash = (37 * hash) + TASKNAME_FIELD_NUMBER;
      hash = (53 * hash) + getTaskName().hashCode();
      hash = (37 * hash) + TASKURI_FIELD_NUMBER;
      hash = (53 * hash) + getTaskURI().hashCode();
      if (hasTaskStartDateTime()) {
        hash = (37 * hash) + TASKSTARTDATETIME_FIELD_NUMBER;
        hash = (53 * hash) + getTaskStartDateTime().hashCode();
      }
      if (hasTaskEndDateTime()) {
        hash = (37 * hash) + TASKENDDATETIME_FIELD_NUMBER;
        hash = (53 * hash) + getTaskEndDateTime().hashCode();
      }
      hash = (37 * hash) + TASKTYPE_FIELD_NUMBER;
      hash = (53 * hash) + getTaskType().hashCode();
      if (!internalGetTaskReqParam().getMap().isEmpty()) {
        hash = (37 * hash) + TASKREQPARAM_FIELD_NUMBER;
        hash = (53 * hash) + internalGetTaskReqParam().hashCode();
      }
      switch (taskIntervalCase_) {
        case 6:
          hash = (37 * hash) + CRONEXPRESSION_FIELD_NUMBER;
          hash = (53 * hash) + getCronExpression().hashCode();
          break;
        case 7:
          hash = (37 * hash) + TASKFREQUENCY_FIELD_NUMBER;
          hash = (53 * hash) + getTaskFrequency();
          break;
        case 0:
        default:
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.TaskManager.ScheduleTaskRequest parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.TaskManager.ScheduleTaskRequest parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.TaskManager.ScheduleTaskRequest parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.TaskManager.ScheduleTaskRequest parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.TaskManager.ScheduleTaskRequest parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.TaskManager.ScheduleTaskRequest parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.TaskManager.ScheduleTaskRequest parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.TaskManager.ScheduleTaskRequest parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.TaskManager.ScheduleTaskRequest parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.TaskManager.ScheduleTaskRequest parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.TaskManager.ScheduleTaskRequest parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.TaskManager.ScheduleTaskRequest parseFrom(
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
        com.cpdss.common.generated.TaskManager.ScheduleTaskRequest prototype) {
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
    /** Protobuf type {@code ScheduleTaskRequest} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:ScheduleTaskRequest)
        com.cpdss.common.generated.TaskManager.ScheduleTaskRequestOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.TaskManager
            .internal_static_ScheduleTaskRequest_descriptor;
      }

      @SuppressWarnings({"rawtypes"})
      protected com.google.protobuf.MapField internalGetMapField(int number) {
        switch (number) {
          case 8:
            return internalGetTaskReqParam();
          default:
            throw new RuntimeException("Invalid map field number: " + number);
        }
      }

      @SuppressWarnings({"rawtypes"})
      protected com.google.protobuf.MapField internalGetMutableMapField(int number) {
        switch (number) {
          case 8:
            return internalGetMutableTaskReqParam();
          default:
            throw new RuntimeException("Invalid map field number: " + number);
        }
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.TaskManager
            .internal_static_ScheduleTaskRequest_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.TaskManager.ScheduleTaskRequest.class,
                com.cpdss.common.generated.TaskManager.ScheduleTaskRequest.Builder.class);
      }

      // Construct using com.cpdss.common.generated.TaskManager.ScheduleTaskRequest.newBuilder()
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
        taskName_ = "";

        taskURI_ = "";

        if (taskStartDateTimeBuilder_ == null) {
          taskStartDateTime_ = null;
        } else {
          taskStartDateTime_ = null;
          taskStartDateTimeBuilder_ = null;
        }
        if (taskEndDateTimeBuilder_ == null) {
          taskEndDateTime_ = null;
        } else {
          taskEndDateTime_ = null;
          taskEndDateTimeBuilder_ = null;
        }
        taskType_ = "";

        internalGetMutableTaskReqParam().clear();
        taskIntervalCase_ = 0;
        taskInterval_ = null;
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.TaskManager
            .internal_static_ScheduleTaskRequest_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.TaskManager.ScheduleTaskRequest
          getDefaultInstanceForType() {
        return com.cpdss.common.generated.TaskManager.ScheduleTaskRequest.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.TaskManager.ScheduleTaskRequest build() {
        com.cpdss.common.generated.TaskManager.ScheduleTaskRequest result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.TaskManager.ScheduleTaskRequest buildPartial() {
        com.cpdss.common.generated.TaskManager.ScheduleTaskRequest result =
            new com.cpdss.common.generated.TaskManager.ScheduleTaskRequest(this);
        int from_bitField0_ = bitField0_;
        result.taskName_ = taskName_;
        result.taskURI_ = taskURI_;
        if (taskStartDateTimeBuilder_ == null) {
          result.taskStartDateTime_ = taskStartDateTime_;
        } else {
          result.taskStartDateTime_ = taskStartDateTimeBuilder_.build();
        }
        if (taskEndDateTimeBuilder_ == null) {
          result.taskEndDateTime_ = taskEndDateTime_;
        } else {
          result.taskEndDateTime_ = taskEndDateTimeBuilder_.build();
        }
        result.taskType_ = taskType_;
        if (taskIntervalCase_ == 6) {
          result.taskInterval_ = taskInterval_;
        }
        if (taskIntervalCase_ == 7) {
          result.taskInterval_ = taskInterval_;
        }
        result.taskReqParam_ = internalGetTaskReqParam();
        result.taskReqParam_.makeImmutable();
        result.taskIntervalCase_ = taskIntervalCase_;
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
        if (other instanceof com.cpdss.common.generated.TaskManager.ScheduleTaskRequest) {
          return mergeFrom((com.cpdss.common.generated.TaskManager.ScheduleTaskRequest) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.cpdss.common.generated.TaskManager.ScheduleTaskRequest other) {
        if (other
            == com.cpdss.common.generated.TaskManager.ScheduleTaskRequest.getDefaultInstance())
          return this;
        if (!other.getTaskName().isEmpty()) {
          taskName_ = other.taskName_;
          onChanged();
        }
        if (!other.getTaskURI().isEmpty()) {
          taskURI_ = other.taskURI_;
          onChanged();
        }
        if (other.hasTaskStartDateTime()) {
          mergeTaskStartDateTime(other.getTaskStartDateTime());
        }
        if (other.hasTaskEndDateTime()) {
          mergeTaskEndDateTime(other.getTaskEndDateTime());
        }
        if (!other.getTaskType().isEmpty()) {
          taskType_ = other.taskType_;
          onChanged();
        }
        internalGetMutableTaskReqParam().mergeFrom(other.internalGetTaskReqParam());
        switch (other.getTaskIntervalCase()) {
          case CRONEXPRESSION:
            {
              taskIntervalCase_ = 6;
              taskInterval_ = other.taskInterval_;
              onChanged();
              break;
            }
          case TASKFREQUENCY:
            {
              setTaskFrequency(other.getTaskFrequency());
              break;
            }
          case TASKINTERVAL_NOT_SET:
            {
              break;
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
        com.cpdss.common.generated.TaskManager.ScheduleTaskRequest parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.TaskManager.ScheduleTaskRequest) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private int taskIntervalCase_ = 0;
      private java.lang.Object taskInterval_;

      public TaskIntervalCase getTaskIntervalCase() {
        return TaskIntervalCase.forNumber(taskIntervalCase_);
      }

      public Builder clearTaskInterval() {
        taskIntervalCase_ = 0;
        taskInterval_ = null;
        onChanged();
        return this;
      }

      private int bitField0_;

      private java.lang.Object taskName_ = "";
      /**
       * <code>string taskName = 1;</code>
       *
       * @return The taskName.
       */
      public java.lang.String getTaskName() {
        java.lang.Object ref = taskName_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          taskName_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string taskName = 1;</code>
       *
       * @return The bytes for taskName.
       */
      public com.google.protobuf.ByteString getTaskNameBytes() {
        java.lang.Object ref = taskName_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          taskName_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string taskName = 1;</code>
       *
       * @param value The taskName to set.
       * @return This builder for chaining.
       */
      public Builder setTaskName(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        taskName_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string taskName = 1;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearTaskName() {

        taskName_ = getDefaultInstance().getTaskName();
        onChanged();
        return this;
      }
      /**
       * <code>string taskName = 1;</code>
       *
       * @param value The bytes for taskName to set.
       * @return This builder for chaining.
       */
      public Builder setTaskNameBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        taskName_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object taskURI_ = "";
      /**
       * <code>string taskURI = 2;</code>
       *
       * @return The taskURI.
       */
      public java.lang.String getTaskURI() {
        java.lang.Object ref = taskURI_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          taskURI_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string taskURI = 2;</code>
       *
       * @return The bytes for taskURI.
       */
      public com.google.protobuf.ByteString getTaskURIBytes() {
        java.lang.Object ref = taskURI_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          taskURI_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string taskURI = 2;</code>
       *
       * @param value The taskURI to set.
       * @return This builder for chaining.
       */
      public Builder setTaskURI(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        taskURI_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string taskURI = 2;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearTaskURI() {

        taskURI_ = getDefaultInstance().getTaskURI();
        onChanged();
        return this;
      }
      /**
       * <code>string taskURI = 2;</code>
       *
       * @param value The bytes for taskURI to set.
       * @return This builder for chaining.
       */
      public Builder setTaskURIBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        taskURI_ = value;
        onChanged();
        return this;
      }

      private com.google.protobuf.Timestamp taskStartDateTime_;
      private com.google.protobuf.SingleFieldBuilderV3<
              com.google.protobuf.Timestamp,
              com.google.protobuf.Timestamp.Builder,
              com.google.protobuf.TimestampOrBuilder>
          taskStartDateTimeBuilder_;
      /**
       * <code>.google.protobuf.Timestamp taskStartDateTime = 3;</code>
       *
       * @return Whether the taskStartDateTime field is set.
       */
      public boolean hasTaskStartDateTime() {
        return taskStartDateTimeBuilder_ != null || taskStartDateTime_ != null;
      }
      /**
       * <code>.google.protobuf.Timestamp taskStartDateTime = 3;</code>
       *
       * @return The taskStartDateTime.
       */
      public com.google.protobuf.Timestamp getTaskStartDateTime() {
        if (taskStartDateTimeBuilder_ == null) {
          return taskStartDateTime_ == null
              ? com.google.protobuf.Timestamp.getDefaultInstance()
              : taskStartDateTime_;
        } else {
          return taskStartDateTimeBuilder_.getMessage();
        }
      }
      /** <code>.google.protobuf.Timestamp taskStartDateTime = 3;</code> */
      public Builder setTaskStartDateTime(com.google.protobuf.Timestamp value) {
        if (taskStartDateTimeBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          taskStartDateTime_ = value;
          onChanged();
        } else {
          taskStartDateTimeBuilder_.setMessage(value);
        }

        return this;
      }
      /** <code>.google.protobuf.Timestamp taskStartDateTime = 3;</code> */
      public Builder setTaskStartDateTime(com.google.protobuf.Timestamp.Builder builderForValue) {
        if (taskStartDateTimeBuilder_ == null) {
          taskStartDateTime_ = builderForValue.build();
          onChanged();
        } else {
          taskStartDateTimeBuilder_.setMessage(builderForValue.build());
        }

        return this;
      }
      /** <code>.google.protobuf.Timestamp taskStartDateTime = 3;</code> */
      public Builder mergeTaskStartDateTime(com.google.protobuf.Timestamp value) {
        if (taskStartDateTimeBuilder_ == null) {
          if (taskStartDateTime_ != null) {
            taskStartDateTime_ =
                com.google.protobuf.Timestamp.newBuilder(taskStartDateTime_)
                    .mergeFrom(value)
                    .buildPartial();
          } else {
            taskStartDateTime_ = value;
          }
          onChanged();
        } else {
          taskStartDateTimeBuilder_.mergeFrom(value);
        }

        return this;
      }
      /** <code>.google.protobuf.Timestamp taskStartDateTime = 3;</code> */
      public Builder clearTaskStartDateTime() {
        if (taskStartDateTimeBuilder_ == null) {
          taskStartDateTime_ = null;
          onChanged();
        } else {
          taskStartDateTime_ = null;
          taskStartDateTimeBuilder_ = null;
        }

        return this;
      }
      /** <code>.google.protobuf.Timestamp taskStartDateTime = 3;</code> */
      public com.google.protobuf.Timestamp.Builder getTaskStartDateTimeBuilder() {

        onChanged();
        return getTaskStartDateTimeFieldBuilder().getBuilder();
      }
      /** <code>.google.protobuf.Timestamp taskStartDateTime = 3;</code> */
      public com.google.protobuf.TimestampOrBuilder getTaskStartDateTimeOrBuilder() {
        if (taskStartDateTimeBuilder_ != null) {
          return taskStartDateTimeBuilder_.getMessageOrBuilder();
        } else {
          return taskStartDateTime_ == null
              ? com.google.protobuf.Timestamp.getDefaultInstance()
              : taskStartDateTime_;
        }
      }
      /** <code>.google.protobuf.Timestamp taskStartDateTime = 3;</code> */
      private com.google.protobuf.SingleFieldBuilderV3<
              com.google.protobuf.Timestamp,
              com.google.protobuf.Timestamp.Builder,
              com.google.protobuf.TimestampOrBuilder>
          getTaskStartDateTimeFieldBuilder() {
        if (taskStartDateTimeBuilder_ == null) {
          taskStartDateTimeBuilder_ =
              new com.google.protobuf.SingleFieldBuilderV3<
                  com.google.protobuf.Timestamp,
                  com.google.protobuf.Timestamp.Builder,
                  com.google.protobuf.TimestampOrBuilder>(
                  getTaskStartDateTime(), getParentForChildren(), isClean());
          taskStartDateTime_ = null;
        }
        return taskStartDateTimeBuilder_;
      }

      private com.google.protobuf.Timestamp taskEndDateTime_;
      private com.google.protobuf.SingleFieldBuilderV3<
              com.google.protobuf.Timestamp,
              com.google.protobuf.Timestamp.Builder,
              com.google.protobuf.TimestampOrBuilder>
          taskEndDateTimeBuilder_;
      /**
       * <code>.google.protobuf.Timestamp taskEndDateTime = 4;</code>
       *
       * @return Whether the taskEndDateTime field is set.
       */
      public boolean hasTaskEndDateTime() {
        return taskEndDateTimeBuilder_ != null || taskEndDateTime_ != null;
      }
      /**
       * <code>.google.protobuf.Timestamp taskEndDateTime = 4;</code>
       *
       * @return The taskEndDateTime.
       */
      public com.google.protobuf.Timestamp getTaskEndDateTime() {
        if (taskEndDateTimeBuilder_ == null) {
          return taskEndDateTime_ == null
              ? com.google.protobuf.Timestamp.getDefaultInstance()
              : taskEndDateTime_;
        } else {
          return taskEndDateTimeBuilder_.getMessage();
        }
      }
      /** <code>.google.protobuf.Timestamp taskEndDateTime = 4;</code> */
      public Builder setTaskEndDateTime(com.google.protobuf.Timestamp value) {
        if (taskEndDateTimeBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          taskEndDateTime_ = value;
          onChanged();
        } else {
          taskEndDateTimeBuilder_.setMessage(value);
        }

        return this;
      }
      /** <code>.google.protobuf.Timestamp taskEndDateTime = 4;</code> */
      public Builder setTaskEndDateTime(com.google.protobuf.Timestamp.Builder builderForValue) {
        if (taskEndDateTimeBuilder_ == null) {
          taskEndDateTime_ = builderForValue.build();
          onChanged();
        } else {
          taskEndDateTimeBuilder_.setMessage(builderForValue.build());
        }

        return this;
      }
      /** <code>.google.protobuf.Timestamp taskEndDateTime = 4;</code> */
      public Builder mergeTaskEndDateTime(com.google.protobuf.Timestamp value) {
        if (taskEndDateTimeBuilder_ == null) {
          if (taskEndDateTime_ != null) {
            taskEndDateTime_ =
                com.google.protobuf.Timestamp.newBuilder(taskEndDateTime_)
                    .mergeFrom(value)
                    .buildPartial();
          } else {
            taskEndDateTime_ = value;
          }
          onChanged();
        } else {
          taskEndDateTimeBuilder_.mergeFrom(value);
        }

        return this;
      }
      /** <code>.google.protobuf.Timestamp taskEndDateTime = 4;</code> */
      public Builder clearTaskEndDateTime() {
        if (taskEndDateTimeBuilder_ == null) {
          taskEndDateTime_ = null;
          onChanged();
        } else {
          taskEndDateTime_ = null;
          taskEndDateTimeBuilder_ = null;
        }

        return this;
      }
      /** <code>.google.protobuf.Timestamp taskEndDateTime = 4;</code> */
      public com.google.protobuf.Timestamp.Builder getTaskEndDateTimeBuilder() {

        onChanged();
        return getTaskEndDateTimeFieldBuilder().getBuilder();
      }
      /** <code>.google.protobuf.Timestamp taskEndDateTime = 4;</code> */
      public com.google.protobuf.TimestampOrBuilder getTaskEndDateTimeOrBuilder() {
        if (taskEndDateTimeBuilder_ != null) {
          return taskEndDateTimeBuilder_.getMessageOrBuilder();
        } else {
          return taskEndDateTime_ == null
              ? com.google.protobuf.Timestamp.getDefaultInstance()
              : taskEndDateTime_;
        }
      }
      /** <code>.google.protobuf.Timestamp taskEndDateTime = 4;</code> */
      private com.google.protobuf.SingleFieldBuilderV3<
              com.google.protobuf.Timestamp,
              com.google.protobuf.Timestamp.Builder,
              com.google.protobuf.TimestampOrBuilder>
          getTaskEndDateTimeFieldBuilder() {
        if (taskEndDateTimeBuilder_ == null) {
          taskEndDateTimeBuilder_ =
              new com.google.protobuf.SingleFieldBuilderV3<
                  com.google.protobuf.Timestamp,
                  com.google.protobuf.Timestamp.Builder,
                  com.google.protobuf.TimestampOrBuilder>(
                  getTaskEndDateTime(), getParentForChildren(), isClean());
          taskEndDateTime_ = null;
        }
        return taskEndDateTimeBuilder_;
      }

      private java.lang.Object taskType_ = "";
      /**
       * <code>string taskType = 5;</code>
       *
       * @return The taskType.
       */
      public java.lang.String getTaskType() {
        java.lang.Object ref = taskType_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          taskType_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string taskType = 5;</code>
       *
       * @return The bytes for taskType.
       */
      public com.google.protobuf.ByteString getTaskTypeBytes() {
        java.lang.Object ref = taskType_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          taskType_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string taskType = 5;</code>
       *
       * @param value The taskType to set.
       * @return This builder for chaining.
       */
      public Builder setTaskType(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        taskType_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string taskType = 5;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearTaskType() {

        taskType_ = getDefaultInstance().getTaskType();
        onChanged();
        return this;
      }
      /**
       * <code>string taskType = 5;</code>
       *
       * @param value The bytes for taskType to set.
       * @return This builder for chaining.
       */
      public Builder setTaskTypeBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        taskType_ = value;
        onChanged();
        return this;
      }

      /**
       * <code>string cronExpression = 6;</code>
       *
       * @return The cronExpression.
       */
      public java.lang.String getCronExpression() {
        java.lang.Object ref = "";
        if (taskIntervalCase_ == 6) {
          ref = taskInterval_;
        }
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          if (taskIntervalCase_ == 6) {
            taskInterval_ = s;
          }
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string cronExpression = 6;</code>
       *
       * @return The bytes for cronExpression.
       */
      public com.google.protobuf.ByteString getCronExpressionBytes() {
        java.lang.Object ref = "";
        if (taskIntervalCase_ == 6) {
          ref = taskInterval_;
        }
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          if (taskIntervalCase_ == 6) {
            taskInterval_ = b;
          }
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string cronExpression = 6;</code>
       *
       * @param value The cronExpression to set.
       * @return This builder for chaining.
       */
      public Builder setCronExpression(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }
        taskIntervalCase_ = 6;
        taskInterval_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string cronExpression = 6;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearCronExpression() {
        if (taskIntervalCase_ == 6) {
          taskIntervalCase_ = 0;
          taskInterval_ = null;
          onChanged();
        }
        return this;
      }
      /**
       * <code>string cronExpression = 6;</code>
       *
       * @param value The bytes for cronExpression to set.
       * @return This builder for chaining.
       */
      public Builder setCronExpressionBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);
        taskIntervalCase_ = 6;
        taskInterval_ = value;
        onChanged();
        return this;
      }

      /**
       * <code>int32 taskFrequency = 7;</code>
       *
       * @return The taskFrequency.
       */
      public int getTaskFrequency() {
        if (taskIntervalCase_ == 7) {
          return (java.lang.Integer) taskInterval_;
        }
        return 0;
      }
      /**
       * <code>int32 taskFrequency = 7;</code>
       *
       * @param value The taskFrequency to set.
       * @return This builder for chaining.
       */
      public Builder setTaskFrequency(int value) {
        taskIntervalCase_ = 7;
        taskInterval_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 taskFrequency = 7;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearTaskFrequency() {
        if (taskIntervalCase_ == 7) {
          taskIntervalCase_ = 0;
          taskInterval_ = null;
          onChanged();
        }
        return this;
      }

      private com.google.protobuf.MapField<java.lang.String, java.lang.String> taskReqParam_;

      private com.google.protobuf.MapField<java.lang.String, java.lang.String>
          internalGetTaskReqParam() {
        if (taskReqParam_ == null) {
          return com.google.protobuf.MapField.emptyMapField(
              TaskReqParamDefaultEntryHolder.defaultEntry);
        }
        return taskReqParam_;
      }

      private com.google.protobuf.MapField<java.lang.String, java.lang.String>
          internalGetMutableTaskReqParam() {
        onChanged();
        ;
        if (taskReqParam_ == null) {
          taskReqParam_ =
              com.google.protobuf.MapField.newMapField(TaskReqParamDefaultEntryHolder.defaultEntry);
        }
        if (!taskReqParam_.isMutable()) {
          taskReqParam_ = taskReqParam_.copy();
        }
        return taskReqParam_;
      }

      public int getTaskReqParamCount() {
        return internalGetTaskReqParam().getMap().size();
      }
      /** <code>map&lt;string, string&gt; taskReqParam = 8;</code> */
      public boolean containsTaskReqParam(java.lang.String key) {
        if (key == null) {
          throw new java.lang.NullPointerException();
        }
        return internalGetTaskReqParam().getMap().containsKey(key);
      }
      /** Use {@link #getTaskReqParamMap()} instead. */
      @java.lang.Deprecated
      public java.util.Map<java.lang.String, java.lang.String> getTaskReqParam() {
        return getTaskReqParamMap();
      }
      /** <code>map&lt;string, string&gt; taskReqParam = 8;</code> */
      public java.util.Map<java.lang.String, java.lang.String> getTaskReqParamMap() {
        return internalGetTaskReqParam().getMap();
      }
      /** <code>map&lt;string, string&gt; taskReqParam = 8;</code> */
      public java.lang.String getTaskReqParamOrDefault(
          java.lang.String key, java.lang.String defaultValue) {
        if (key == null) {
          throw new java.lang.NullPointerException();
        }
        java.util.Map<java.lang.String, java.lang.String> map = internalGetTaskReqParam().getMap();
        return map.containsKey(key) ? map.get(key) : defaultValue;
      }
      /** <code>map&lt;string, string&gt; taskReqParam = 8;</code> */
      public java.lang.String getTaskReqParamOrThrow(java.lang.String key) {
        if (key == null) {
          throw new java.lang.NullPointerException();
        }
        java.util.Map<java.lang.String, java.lang.String> map = internalGetTaskReqParam().getMap();
        if (!map.containsKey(key)) {
          throw new java.lang.IllegalArgumentException();
        }
        return map.get(key);
      }

      public Builder clearTaskReqParam() {
        internalGetMutableTaskReqParam().getMutableMap().clear();
        return this;
      }
      /** <code>map&lt;string, string&gt; taskReqParam = 8;</code> */
      public Builder removeTaskReqParam(java.lang.String key) {
        if (key == null) {
          throw new java.lang.NullPointerException();
        }
        internalGetMutableTaskReqParam().getMutableMap().remove(key);
        return this;
      }
      /** Use alternate mutation accessors instead. */
      @java.lang.Deprecated
      public java.util.Map<java.lang.String, java.lang.String> getMutableTaskReqParam() {
        return internalGetMutableTaskReqParam().getMutableMap();
      }
      /** <code>map&lt;string, string&gt; taskReqParam = 8;</code> */
      public Builder putTaskReqParam(java.lang.String key, java.lang.String value) {
        if (key == null) {
          throw new java.lang.NullPointerException();
        }
        if (value == null) {
          throw new java.lang.NullPointerException();
        }
        internalGetMutableTaskReqParam().getMutableMap().put(key, value);
        return this;
      }
      /** <code>map&lt;string, string&gt; taskReqParam = 8;</code> */
      public Builder putAllTaskReqParam(java.util.Map<java.lang.String, java.lang.String> values) {
        internalGetMutableTaskReqParam().getMutableMap().putAll(values);
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

      // @@protoc_insertion_point(builder_scope:ScheduleTaskRequest)
    }

    // @@protoc_insertion_point(class_scope:ScheduleTaskRequest)
    private static final com.cpdss.common.generated.TaskManager.ScheduleTaskRequest
        DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.TaskManager.ScheduleTaskRequest();
    }

    public static com.cpdss.common.generated.TaskManager.ScheduleTaskRequest getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<ScheduleTaskRequest> PARSER =
        new com.google.protobuf.AbstractParser<ScheduleTaskRequest>() {
          @java.lang.Override
          public ScheduleTaskRequest parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new ScheduleTaskRequest(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<ScheduleTaskRequest> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<ScheduleTaskRequest> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.TaskManager.ScheduleTaskRequest getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface ScheduleTaskDeleteRequestOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:ScheduleTaskDeleteRequest)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>string taskName = 1;</code>
     *
     * @return The taskName.
     */
    java.lang.String getTaskName();
    /**
     * <code>string taskName = 1;</code>
     *
     * @return The bytes for taskName.
     */
    com.google.protobuf.ByteString getTaskNameBytes();
  }
  /** Protobuf type {@code ScheduleTaskDeleteRequest} */
  public static final class ScheduleTaskDeleteRequest extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:ScheduleTaskDeleteRequest)
      ScheduleTaskDeleteRequestOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use ScheduleTaskDeleteRequest.newBuilder() to construct.
    private ScheduleTaskDeleteRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private ScheduleTaskDeleteRequest() {
      taskName_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new ScheduleTaskDeleteRequest();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private ScheduleTaskDeleteRequest(
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

                taskName_ = s;
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
      return com.cpdss.common.generated.TaskManager
          .internal_static_ScheduleTaskDeleteRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.TaskManager
          .internal_static_ScheduleTaskDeleteRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.TaskManager.ScheduleTaskDeleteRequest.class,
              com.cpdss.common.generated.TaskManager.ScheduleTaskDeleteRequest.Builder.class);
    }

    public static final int TASKNAME_FIELD_NUMBER = 1;
    private volatile java.lang.Object taskName_;
    /**
     * <code>string taskName = 1;</code>
     *
     * @return The taskName.
     */
    public java.lang.String getTaskName() {
      java.lang.Object ref = taskName_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        taskName_ = s;
        return s;
      }
    }
    /**
     * <code>string taskName = 1;</code>
     *
     * @return The bytes for taskName.
     */
    public com.google.protobuf.ByteString getTaskNameBytes() {
      java.lang.Object ref = taskName_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        taskName_ = b;
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
      if (!getTaskNameBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, taskName_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getTaskNameBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, taskName_);
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
      if (!(obj instanceof com.cpdss.common.generated.TaskManager.ScheduleTaskDeleteRequest)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.TaskManager.ScheduleTaskDeleteRequest other =
          (com.cpdss.common.generated.TaskManager.ScheduleTaskDeleteRequest) obj;

      if (!getTaskName().equals(other.getTaskName())) return false;
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
      hash = (37 * hash) + TASKNAME_FIELD_NUMBER;
      hash = (53 * hash) + getTaskName().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.TaskManager.ScheduleTaskDeleteRequest parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.TaskManager.ScheduleTaskDeleteRequest parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.TaskManager.ScheduleTaskDeleteRequest parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.TaskManager.ScheduleTaskDeleteRequest parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.TaskManager.ScheduleTaskDeleteRequest parseFrom(
        byte[] data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.TaskManager.ScheduleTaskDeleteRequest parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.TaskManager.ScheduleTaskDeleteRequest parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.TaskManager.ScheduleTaskDeleteRequest parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.TaskManager.ScheduleTaskDeleteRequest
        parseDelimitedFrom(java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.TaskManager.ScheduleTaskDeleteRequest
        parseDelimitedFrom(
            java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.TaskManager.ScheduleTaskDeleteRequest parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.TaskManager.ScheduleTaskDeleteRequest parseFrom(
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
        com.cpdss.common.generated.TaskManager.ScheduleTaskDeleteRequest prototype) {
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
    /** Protobuf type {@code ScheduleTaskDeleteRequest} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:ScheduleTaskDeleteRequest)
        com.cpdss.common.generated.TaskManager.ScheduleTaskDeleteRequestOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.TaskManager
            .internal_static_ScheduleTaskDeleteRequest_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.TaskManager
            .internal_static_ScheduleTaskDeleteRequest_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.TaskManager.ScheduleTaskDeleteRequest.class,
                com.cpdss.common.generated.TaskManager.ScheduleTaskDeleteRequest.Builder.class);
      }

      // Construct using
      // com.cpdss.common.generated.TaskManager.ScheduleTaskDeleteRequest.newBuilder()
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
        taskName_ = "";

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.TaskManager
            .internal_static_ScheduleTaskDeleteRequest_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.TaskManager.ScheduleTaskDeleteRequest
          getDefaultInstanceForType() {
        return com.cpdss.common.generated.TaskManager.ScheduleTaskDeleteRequest
            .getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.TaskManager.ScheduleTaskDeleteRequest build() {
        com.cpdss.common.generated.TaskManager.ScheduleTaskDeleteRequest result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.TaskManager.ScheduleTaskDeleteRequest buildPartial() {
        com.cpdss.common.generated.TaskManager.ScheduleTaskDeleteRequest result =
            new com.cpdss.common.generated.TaskManager.ScheduleTaskDeleteRequest(this);
        result.taskName_ = taskName_;
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
        if (other instanceof com.cpdss.common.generated.TaskManager.ScheduleTaskDeleteRequest) {
          return mergeFrom(
              (com.cpdss.common.generated.TaskManager.ScheduleTaskDeleteRequest) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(
          com.cpdss.common.generated.TaskManager.ScheduleTaskDeleteRequest other) {
        if (other
            == com.cpdss.common.generated.TaskManager.ScheduleTaskDeleteRequest
                .getDefaultInstance()) return this;
        if (!other.getTaskName().isEmpty()) {
          taskName_ = other.taskName_;
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
        com.cpdss.common.generated.TaskManager.ScheduleTaskDeleteRequest parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.TaskManager.ScheduleTaskDeleteRequest)
                  e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private java.lang.Object taskName_ = "";
      /**
       * <code>string taskName = 1;</code>
       *
       * @return The taskName.
       */
      public java.lang.String getTaskName() {
        java.lang.Object ref = taskName_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          taskName_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string taskName = 1;</code>
       *
       * @return The bytes for taskName.
       */
      public com.google.protobuf.ByteString getTaskNameBytes() {
        java.lang.Object ref = taskName_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          taskName_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string taskName = 1;</code>
       *
       * @param value The taskName to set.
       * @return This builder for chaining.
       */
      public Builder setTaskName(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        taskName_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string taskName = 1;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearTaskName() {

        taskName_ = getDefaultInstance().getTaskName();
        onChanged();
        return this;
      }
      /**
       * <code>string taskName = 1;</code>
       *
       * @param value The bytes for taskName to set.
       * @return This builder for chaining.
       */
      public Builder setTaskNameBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        taskName_ = value;
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

      // @@protoc_insertion_point(builder_scope:ScheduleTaskDeleteRequest)
    }

    // @@protoc_insertion_point(class_scope:ScheduleTaskDeleteRequest)
    private static final com.cpdss.common.generated.TaskManager.ScheduleTaskDeleteRequest
        DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.TaskManager.ScheduleTaskDeleteRequest();
    }

    public static com.cpdss.common.generated.TaskManager.ScheduleTaskDeleteRequest
        getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<ScheduleTaskDeleteRequest> PARSER =
        new com.google.protobuf.AbstractParser<ScheduleTaskDeleteRequest>() {
          @java.lang.Override
          public ScheduleTaskDeleteRequest parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new ScheduleTaskDeleteRequest(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<ScheduleTaskDeleteRequest> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<ScheduleTaskDeleteRequest> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.TaskManager.ScheduleTaskDeleteRequest
        getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface TaskManagerReplyOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:TaskManagerReply)
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
  /** Protobuf type {@code TaskManagerReply} */
  public static final class TaskManagerReply extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:TaskManagerReply)
      TaskManagerReplyOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use TaskManagerReply.newBuilder() to construct.
    private TaskManagerReply(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private TaskManagerReply() {}

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new TaskManagerReply();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private TaskManagerReply(
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
      return com.cpdss.common.generated.TaskManager.internal_static_TaskManagerReply_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.TaskManager
          .internal_static_TaskManagerReply_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.TaskManager.TaskManagerReply.class,
              com.cpdss.common.generated.TaskManager.TaskManagerReply.Builder.class);
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
      if (!(obj instanceof com.cpdss.common.generated.TaskManager.TaskManagerReply)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.TaskManager.TaskManagerReply other =
          (com.cpdss.common.generated.TaskManager.TaskManagerReply) obj;

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

    public static com.cpdss.common.generated.TaskManager.TaskManagerReply parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.TaskManager.TaskManagerReply parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.TaskManager.TaskManagerReply parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.TaskManager.TaskManagerReply parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.TaskManager.TaskManagerReply parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.TaskManager.TaskManagerReply parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.TaskManager.TaskManagerReply parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.TaskManager.TaskManagerReply parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.TaskManager.TaskManagerReply parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.TaskManager.TaskManagerReply parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.TaskManager.TaskManagerReply parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.TaskManager.TaskManagerReply parseFrom(
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
        com.cpdss.common.generated.TaskManager.TaskManagerReply prototype) {
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
    /** Protobuf type {@code TaskManagerReply} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:TaskManagerReply)
        com.cpdss.common.generated.TaskManager.TaskManagerReplyOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.TaskManager.internal_static_TaskManagerReply_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.TaskManager
            .internal_static_TaskManagerReply_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.TaskManager.TaskManagerReply.class,
                com.cpdss.common.generated.TaskManager.TaskManagerReply.Builder.class);
      }

      // Construct using com.cpdss.common.generated.TaskManager.TaskManagerReply.newBuilder()
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
        return com.cpdss.common.generated.TaskManager.internal_static_TaskManagerReply_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.TaskManager.TaskManagerReply getDefaultInstanceForType() {
        return com.cpdss.common.generated.TaskManager.TaskManagerReply.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.TaskManager.TaskManagerReply build() {
        com.cpdss.common.generated.TaskManager.TaskManagerReply result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.TaskManager.TaskManagerReply buildPartial() {
        com.cpdss.common.generated.TaskManager.TaskManagerReply result =
            new com.cpdss.common.generated.TaskManager.TaskManagerReply(this);
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
        if (other instanceof com.cpdss.common.generated.TaskManager.TaskManagerReply) {
          return mergeFrom((com.cpdss.common.generated.TaskManager.TaskManagerReply) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.cpdss.common.generated.TaskManager.TaskManagerReply other) {
        if (other == com.cpdss.common.generated.TaskManager.TaskManagerReply.getDefaultInstance())
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
        com.cpdss.common.generated.TaskManager.TaskManagerReply parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.TaskManager.TaskManagerReply) e.getUnfinishedMessage();
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

      // @@protoc_insertion_point(builder_scope:TaskManagerReply)
    }

    // @@protoc_insertion_point(class_scope:TaskManagerReply)
    private static final com.cpdss.common.generated.TaskManager.TaskManagerReply DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.TaskManager.TaskManagerReply();
    }

    public static com.cpdss.common.generated.TaskManager.TaskManagerReply getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<TaskManagerReply> PARSER =
        new com.google.protobuf.AbstractParser<TaskManagerReply>() {
          @java.lang.Override
          public TaskManagerReply parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new TaskManagerReply(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<TaskManagerReply> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<TaskManagerReply> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.TaskManager.TaskManagerReply getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface ExecuteTaskRequestOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:ExecuteTaskRequest)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>string taskName = 1;</code>
     *
     * @return The taskName.
     */
    java.lang.String getTaskName();
    /**
     * <code>string taskName = 1;</code>
     *
     * @return The bytes for taskName.
     */
    com.google.protobuf.ByteString getTaskNameBytes();

    /** <code>map&lt;string, string&gt; taskReqParam = 2;</code> */
    int getTaskReqParamCount();
    /** <code>map&lt;string, string&gt; taskReqParam = 2;</code> */
    boolean containsTaskReqParam(java.lang.String key);
    /** Use {@link #getTaskReqParamMap()} instead. */
    @java.lang.Deprecated
    java.util.Map<java.lang.String, java.lang.String> getTaskReqParam();
    /** <code>map&lt;string, string&gt; taskReqParam = 2;</code> */
    java.util.Map<java.lang.String, java.lang.String> getTaskReqParamMap();
    /** <code>map&lt;string, string&gt; taskReqParam = 2;</code> */
    java.lang.String getTaskReqParamOrDefault(java.lang.String key, java.lang.String defaultValue);
    /** <code>map&lt;string, string&gt; taskReqParam = 2;</code> */
    java.lang.String getTaskReqParamOrThrow(java.lang.String key);
  }
  /** Protobuf type {@code ExecuteTaskRequest} */
  public static final class ExecuteTaskRequest extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:ExecuteTaskRequest)
      ExecuteTaskRequestOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use ExecuteTaskRequest.newBuilder() to construct.
    private ExecuteTaskRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private ExecuteTaskRequest() {
      taskName_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new ExecuteTaskRequest();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private ExecuteTaskRequest(
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

                taskName_ = s;
                break;
              }
            case 18:
              {
                if (!((mutable_bitField0_ & 0x00000001) != 0)) {
                  taskReqParam_ =
                      com.google.protobuf.MapField.newMapField(
                          TaskReqParamDefaultEntryHolder.defaultEntry);
                  mutable_bitField0_ |= 0x00000001;
                }
                com.google.protobuf.MapEntry<java.lang.String, java.lang.String> taskReqParam__ =
                    input.readMessage(
                        TaskReqParamDefaultEntryHolder.defaultEntry.getParserForType(),
                        extensionRegistry);
                taskReqParam_
                    .getMutableMap()
                    .put(taskReqParam__.getKey(), taskReqParam__.getValue());
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
      return com.cpdss.common.generated.TaskManager.internal_static_ExecuteTaskRequest_descriptor;
    }

    @SuppressWarnings({"rawtypes"})
    @java.lang.Override
    protected com.google.protobuf.MapField internalGetMapField(int number) {
      switch (number) {
        case 2:
          return internalGetTaskReqParam();
        default:
          throw new RuntimeException("Invalid map field number: " + number);
      }
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.TaskManager
          .internal_static_ExecuteTaskRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.TaskManager.ExecuteTaskRequest.class,
              com.cpdss.common.generated.TaskManager.ExecuteTaskRequest.Builder.class);
    }

    public static final int TASKNAME_FIELD_NUMBER = 1;
    private volatile java.lang.Object taskName_;
    /**
     * <code>string taskName = 1;</code>
     *
     * @return The taskName.
     */
    public java.lang.String getTaskName() {
      java.lang.Object ref = taskName_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        taskName_ = s;
        return s;
      }
    }
    /**
     * <code>string taskName = 1;</code>
     *
     * @return The bytes for taskName.
     */
    public com.google.protobuf.ByteString getTaskNameBytes() {
      java.lang.Object ref = taskName_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        taskName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int TASKREQPARAM_FIELD_NUMBER = 2;

    private static final class TaskReqParamDefaultEntryHolder {
      static final com.google.protobuf.MapEntry<java.lang.String, java.lang.String> defaultEntry =
          com.google.protobuf.MapEntry.<java.lang.String, java.lang.String>newDefaultInstance(
              com.cpdss.common.generated.TaskManager
                  .internal_static_ExecuteTaskRequest_TaskReqParamEntry_descriptor,
              com.google.protobuf.WireFormat.FieldType.STRING,
              "",
              com.google.protobuf.WireFormat.FieldType.STRING,
              "");
    }

    private com.google.protobuf.MapField<java.lang.String, java.lang.String> taskReqParam_;

    private com.google.protobuf.MapField<java.lang.String, java.lang.String>
        internalGetTaskReqParam() {
      if (taskReqParam_ == null) {
        return com.google.protobuf.MapField.emptyMapField(
            TaskReqParamDefaultEntryHolder.defaultEntry);
      }
      return taskReqParam_;
    }

    public int getTaskReqParamCount() {
      return internalGetTaskReqParam().getMap().size();
    }
    /** <code>map&lt;string, string&gt; taskReqParam = 2;</code> */
    public boolean containsTaskReqParam(java.lang.String key) {
      if (key == null) {
        throw new java.lang.NullPointerException();
      }
      return internalGetTaskReqParam().getMap().containsKey(key);
    }
    /** Use {@link #getTaskReqParamMap()} instead. */
    @java.lang.Deprecated
    public java.util.Map<java.lang.String, java.lang.String> getTaskReqParam() {
      return getTaskReqParamMap();
    }
    /** <code>map&lt;string, string&gt; taskReqParam = 2;</code> */
    public java.util.Map<java.lang.String, java.lang.String> getTaskReqParamMap() {
      return internalGetTaskReqParam().getMap();
    }
    /** <code>map&lt;string, string&gt; taskReqParam = 2;</code> */
    public java.lang.String getTaskReqParamOrDefault(
        java.lang.String key, java.lang.String defaultValue) {
      if (key == null) {
        throw new java.lang.NullPointerException();
      }
      java.util.Map<java.lang.String, java.lang.String> map = internalGetTaskReqParam().getMap();
      return map.containsKey(key) ? map.get(key) : defaultValue;
    }
    /** <code>map&lt;string, string&gt; taskReqParam = 2;</code> */
    public java.lang.String getTaskReqParamOrThrow(java.lang.String key) {
      if (key == null) {
        throw new java.lang.NullPointerException();
      }
      java.util.Map<java.lang.String, java.lang.String> map = internalGetTaskReqParam().getMap();
      if (!map.containsKey(key)) {
        throw new java.lang.IllegalArgumentException();
      }
      return map.get(key);
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
      if (!getTaskNameBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, taskName_);
      }
      com.google.protobuf.GeneratedMessageV3.serializeStringMapTo(
          output, internalGetTaskReqParam(), TaskReqParamDefaultEntryHolder.defaultEntry, 2);
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getTaskNameBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, taskName_);
      }
      for (java.util.Map.Entry<java.lang.String, java.lang.String> entry :
          internalGetTaskReqParam().getMap().entrySet()) {
        com.google.protobuf.MapEntry<java.lang.String, java.lang.String> taskReqParam__ =
            TaskReqParamDefaultEntryHolder.defaultEntry
                .newBuilderForType()
                .setKey(entry.getKey())
                .setValue(entry.getValue())
                .build();
        size += com.google.protobuf.CodedOutputStream.computeMessageSize(2, taskReqParam__);
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
      if (!(obj instanceof com.cpdss.common.generated.TaskManager.ExecuteTaskRequest)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.TaskManager.ExecuteTaskRequest other =
          (com.cpdss.common.generated.TaskManager.ExecuteTaskRequest) obj;

      if (!getTaskName().equals(other.getTaskName())) return false;
      if (!internalGetTaskReqParam().equals(other.internalGetTaskReqParam())) return false;
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
      hash = (37 * hash) + TASKNAME_FIELD_NUMBER;
      hash = (53 * hash) + getTaskName().hashCode();
      if (!internalGetTaskReqParam().getMap().isEmpty()) {
        hash = (37 * hash) + TASKREQPARAM_FIELD_NUMBER;
        hash = (53 * hash) + internalGetTaskReqParam().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.TaskManager.ExecuteTaskRequest parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.TaskManager.ExecuteTaskRequest parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.TaskManager.ExecuteTaskRequest parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.TaskManager.ExecuteTaskRequest parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.TaskManager.ExecuteTaskRequest parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.TaskManager.ExecuteTaskRequest parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.TaskManager.ExecuteTaskRequest parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.TaskManager.ExecuteTaskRequest parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.TaskManager.ExecuteTaskRequest parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.TaskManager.ExecuteTaskRequest parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.TaskManager.ExecuteTaskRequest parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.TaskManager.ExecuteTaskRequest parseFrom(
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
        com.cpdss.common.generated.TaskManager.ExecuteTaskRequest prototype) {
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
    /** Protobuf type {@code ExecuteTaskRequest} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:ExecuteTaskRequest)
        com.cpdss.common.generated.TaskManager.ExecuteTaskRequestOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.TaskManager.internal_static_ExecuteTaskRequest_descriptor;
      }

      @SuppressWarnings({"rawtypes"})
      protected com.google.protobuf.MapField internalGetMapField(int number) {
        switch (number) {
          case 2:
            return internalGetTaskReqParam();
          default:
            throw new RuntimeException("Invalid map field number: " + number);
        }
      }

      @SuppressWarnings({"rawtypes"})
      protected com.google.protobuf.MapField internalGetMutableMapField(int number) {
        switch (number) {
          case 2:
            return internalGetMutableTaskReqParam();
          default:
            throw new RuntimeException("Invalid map field number: " + number);
        }
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.TaskManager
            .internal_static_ExecuteTaskRequest_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.TaskManager.ExecuteTaskRequest.class,
                com.cpdss.common.generated.TaskManager.ExecuteTaskRequest.Builder.class);
      }

      // Construct using com.cpdss.common.generated.TaskManager.ExecuteTaskRequest.newBuilder()
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
        taskName_ = "";

        internalGetMutableTaskReqParam().clear();
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.TaskManager.internal_static_ExecuteTaskRequest_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.TaskManager.ExecuteTaskRequest getDefaultInstanceForType() {
        return com.cpdss.common.generated.TaskManager.ExecuteTaskRequest.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.TaskManager.ExecuteTaskRequest build() {
        com.cpdss.common.generated.TaskManager.ExecuteTaskRequest result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.TaskManager.ExecuteTaskRequest buildPartial() {
        com.cpdss.common.generated.TaskManager.ExecuteTaskRequest result =
            new com.cpdss.common.generated.TaskManager.ExecuteTaskRequest(this);
        int from_bitField0_ = bitField0_;
        result.taskName_ = taskName_;
        result.taskReqParam_ = internalGetTaskReqParam();
        result.taskReqParam_.makeImmutable();
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
        if (other instanceof com.cpdss.common.generated.TaskManager.ExecuteTaskRequest) {
          return mergeFrom((com.cpdss.common.generated.TaskManager.ExecuteTaskRequest) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.cpdss.common.generated.TaskManager.ExecuteTaskRequest other) {
        if (other == com.cpdss.common.generated.TaskManager.ExecuteTaskRequest.getDefaultInstance())
          return this;
        if (!other.getTaskName().isEmpty()) {
          taskName_ = other.taskName_;
          onChanged();
        }
        internalGetMutableTaskReqParam().mergeFrom(other.internalGetTaskReqParam());
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
        com.cpdss.common.generated.TaskManager.ExecuteTaskRequest parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.TaskManager.ExecuteTaskRequest) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private int bitField0_;

      private java.lang.Object taskName_ = "";
      /**
       * <code>string taskName = 1;</code>
       *
       * @return The taskName.
       */
      public java.lang.String getTaskName() {
        java.lang.Object ref = taskName_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          taskName_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string taskName = 1;</code>
       *
       * @return The bytes for taskName.
       */
      public com.google.protobuf.ByteString getTaskNameBytes() {
        java.lang.Object ref = taskName_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          taskName_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string taskName = 1;</code>
       *
       * @param value The taskName to set.
       * @return This builder for chaining.
       */
      public Builder setTaskName(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        taskName_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string taskName = 1;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearTaskName() {

        taskName_ = getDefaultInstance().getTaskName();
        onChanged();
        return this;
      }
      /**
       * <code>string taskName = 1;</code>
       *
       * @param value The bytes for taskName to set.
       * @return This builder for chaining.
       */
      public Builder setTaskNameBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        taskName_ = value;
        onChanged();
        return this;
      }

      private com.google.protobuf.MapField<java.lang.String, java.lang.String> taskReqParam_;

      private com.google.protobuf.MapField<java.lang.String, java.lang.String>
          internalGetTaskReqParam() {
        if (taskReqParam_ == null) {
          return com.google.protobuf.MapField.emptyMapField(
              TaskReqParamDefaultEntryHolder.defaultEntry);
        }
        return taskReqParam_;
      }

      private com.google.protobuf.MapField<java.lang.String, java.lang.String>
          internalGetMutableTaskReqParam() {
        onChanged();
        ;
        if (taskReqParam_ == null) {
          taskReqParam_ =
              com.google.protobuf.MapField.newMapField(TaskReqParamDefaultEntryHolder.defaultEntry);
        }
        if (!taskReqParam_.isMutable()) {
          taskReqParam_ = taskReqParam_.copy();
        }
        return taskReqParam_;
      }

      public int getTaskReqParamCount() {
        return internalGetTaskReqParam().getMap().size();
      }
      /** <code>map&lt;string, string&gt; taskReqParam = 2;</code> */
      public boolean containsTaskReqParam(java.lang.String key) {
        if (key == null) {
          throw new java.lang.NullPointerException();
        }
        return internalGetTaskReqParam().getMap().containsKey(key);
      }
      /** Use {@link #getTaskReqParamMap()} instead. */
      @java.lang.Deprecated
      public java.util.Map<java.lang.String, java.lang.String> getTaskReqParam() {
        return getTaskReqParamMap();
      }
      /** <code>map&lt;string, string&gt; taskReqParam = 2;</code> */
      public java.util.Map<java.lang.String, java.lang.String> getTaskReqParamMap() {
        return internalGetTaskReqParam().getMap();
      }
      /** <code>map&lt;string, string&gt; taskReqParam = 2;</code> */
      public java.lang.String getTaskReqParamOrDefault(
          java.lang.String key, java.lang.String defaultValue) {
        if (key == null) {
          throw new java.lang.NullPointerException();
        }
        java.util.Map<java.lang.String, java.lang.String> map = internalGetTaskReqParam().getMap();
        return map.containsKey(key) ? map.get(key) : defaultValue;
      }
      /** <code>map&lt;string, string&gt; taskReqParam = 2;</code> */
      public java.lang.String getTaskReqParamOrThrow(java.lang.String key) {
        if (key == null) {
          throw new java.lang.NullPointerException();
        }
        java.util.Map<java.lang.String, java.lang.String> map = internalGetTaskReqParam().getMap();
        if (!map.containsKey(key)) {
          throw new java.lang.IllegalArgumentException();
        }
        return map.get(key);
      }

      public Builder clearTaskReqParam() {
        internalGetMutableTaskReqParam().getMutableMap().clear();
        return this;
      }
      /** <code>map&lt;string, string&gt; taskReqParam = 2;</code> */
      public Builder removeTaskReqParam(java.lang.String key) {
        if (key == null) {
          throw new java.lang.NullPointerException();
        }
        internalGetMutableTaskReqParam().getMutableMap().remove(key);
        return this;
      }
      /** Use alternate mutation accessors instead. */
      @java.lang.Deprecated
      public java.util.Map<java.lang.String, java.lang.String> getMutableTaskReqParam() {
        return internalGetMutableTaskReqParam().getMutableMap();
      }
      /** <code>map&lt;string, string&gt; taskReqParam = 2;</code> */
      public Builder putTaskReqParam(java.lang.String key, java.lang.String value) {
        if (key == null) {
          throw new java.lang.NullPointerException();
        }
        if (value == null) {
          throw new java.lang.NullPointerException();
        }
        internalGetMutableTaskReqParam().getMutableMap().put(key, value);
        return this;
      }
      /** <code>map&lt;string, string&gt; taskReqParam = 2;</code> */
      public Builder putAllTaskReqParam(java.util.Map<java.lang.String, java.lang.String> values) {
        internalGetMutableTaskReqParam().getMutableMap().putAll(values);
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

      // @@protoc_insertion_point(builder_scope:ExecuteTaskRequest)
    }

    // @@protoc_insertion_point(class_scope:ExecuteTaskRequest)
    private static final com.cpdss.common.generated.TaskManager.ExecuteTaskRequest DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.TaskManager.ExecuteTaskRequest();
    }

    public static com.cpdss.common.generated.TaskManager.ExecuteTaskRequest getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<ExecuteTaskRequest> PARSER =
        new com.google.protobuf.AbstractParser<ExecuteTaskRequest>() {
          @java.lang.Override
          public ExecuteTaskRequest parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new ExecuteTaskRequest(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<ExecuteTaskRequest> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<ExecuteTaskRequest> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.TaskManager.ExecuteTaskRequest getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface ExecuteTaskReplyOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:ExecuteTaskReply)
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
  /** Protobuf type {@code ExecuteTaskReply} */
  public static final class ExecuteTaskReply extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:ExecuteTaskReply)
      ExecuteTaskReplyOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use ExecuteTaskReply.newBuilder() to construct.
    private ExecuteTaskReply(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private ExecuteTaskReply() {}

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new ExecuteTaskReply();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private ExecuteTaskReply(
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
      return com.cpdss.common.generated.TaskManager.internal_static_ExecuteTaskReply_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.TaskManager
          .internal_static_ExecuteTaskReply_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.TaskManager.ExecuteTaskReply.class,
              com.cpdss.common.generated.TaskManager.ExecuteTaskReply.Builder.class);
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
      if (!(obj instanceof com.cpdss.common.generated.TaskManager.ExecuteTaskReply)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.TaskManager.ExecuteTaskReply other =
          (com.cpdss.common.generated.TaskManager.ExecuteTaskReply) obj;

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

    public static com.cpdss.common.generated.TaskManager.ExecuteTaskReply parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.TaskManager.ExecuteTaskReply parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.TaskManager.ExecuteTaskReply parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.TaskManager.ExecuteTaskReply parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.TaskManager.ExecuteTaskReply parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.TaskManager.ExecuteTaskReply parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.TaskManager.ExecuteTaskReply parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.TaskManager.ExecuteTaskReply parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.TaskManager.ExecuteTaskReply parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.TaskManager.ExecuteTaskReply parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.TaskManager.ExecuteTaskReply parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.TaskManager.ExecuteTaskReply parseFrom(
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
        com.cpdss.common.generated.TaskManager.ExecuteTaskReply prototype) {
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
    /** Protobuf type {@code ExecuteTaskReply} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:ExecuteTaskReply)
        com.cpdss.common.generated.TaskManager.ExecuteTaskReplyOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.TaskManager.internal_static_ExecuteTaskReply_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.TaskManager
            .internal_static_ExecuteTaskReply_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.TaskManager.ExecuteTaskReply.class,
                com.cpdss.common.generated.TaskManager.ExecuteTaskReply.Builder.class);
      }

      // Construct using com.cpdss.common.generated.TaskManager.ExecuteTaskReply.newBuilder()
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
        return com.cpdss.common.generated.TaskManager.internal_static_ExecuteTaskReply_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.TaskManager.ExecuteTaskReply getDefaultInstanceForType() {
        return com.cpdss.common.generated.TaskManager.ExecuteTaskReply.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.TaskManager.ExecuteTaskReply build() {
        com.cpdss.common.generated.TaskManager.ExecuteTaskReply result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.TaskManager.ExecuteTaskReply buildPartial() {
        com.cpdss.common.generated.TaskManager.ExecuteTaskReply result =
            new com.cpdss.common.generated.TaskManager.ExecuteTaskReply(this);
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
        if (other instanceof com.cpdss.common.generated.TaskManager.ExecuteTaskReply) {
          return mergeFrom((com.cpdss.common.generated.TaskManager.ExecuteTaskReply) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.cpdss.common.generated.TaskManager.ExecuteTaskReply other) {
        if (other == com.cpdss.common.generated.TaskManager.ExecuteTaskReply.getDefaultInstance())
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
        com.cpdss.common.generated.TaskManager.ExecuteTaskReply parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.TaskManager.ExecuteTaskReply) e.getUnfinishedMessage();
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

      // @@protoc_insertion_point(builder_scope:ExecuteTaskReply)
    }

    // @@protoc_insertion_point(class_scope:ExecuteTaskReply)
    private static final com.cpdss.common.generated.TaskManager.ExecuteTaskReply DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.TaskManager.ExecuteTaskReply();
    }

    public static com.cpdss.common.generated.TaskManager.ExecuteTaskReply getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<ExecuteTaskReply> PARSER =
        new com.google.protobuf.AbstractParser<ExecuteTaskReply>() {
          @java.lang.Override
          public ExecuteTaskReply parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new ExecuteTaskReply(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<ExecuteTaskReply> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<ExecuteTaskReply> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.TaskManager.ExecuteTaskReply getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_SchedulededTaskRequest_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_SchedulededTaskRequest_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_SchedulededTaskReply_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_SchedulededTaskReply_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_ScheduleTaskRequest_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ScheduleTaskRequest_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_ScheduleTaskRequest_TaskReqParamEntry_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ScheduleTaskRequest_TaskReqParamEntry_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_ScheduleTaskDeleteRequest_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ScheduleTaskDeleteRequest_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_TaskManagerReply_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_TaskManagerReply_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_ExecuteTaskRequest_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ExecuteTaskRequest_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_ExecuteTaskRequest_TaskReqParamEntry_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ExecuteTaskRequest_TaskReqParamEntry_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_ExecuteTaskReply_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ExecuteTaskReply_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }

  private static com.google.protobuf.Descriptors.FileDescriptor descriptor;

  static {
    java.lang.String[] descriptorData = {
      "\n\022task_manager.proto\032\037google/protobuf/ti"
          + "mestamp.proto\032\014common.proto\"*\n\026Scheduled"
          + "edTaskRequest\022\020\n\010jobGroup\030\001 \001(\t\"Q\n\024Sched"
          + "ulededTaskReply\022\020\n\010taskName\030\001 \003(\t\022\'\n\016res"
          + "ponseStatus\030\002 \001(\0132\017.ResponseStatus\"\354\002\n\023S"
          + "cheduleTaskRequest\022\020\n\010taskName\030\001 \001(\t\022\017\n\007"
          + "taskURI\030\002 \001(\t\0225\n\021taskStartDateTime\030\003 \001(\013"
          + "2\032.google.protobuf.Timestamp\0223\n\017taskEndD"
          + "ateTime\030\004 \001(\0132\032.google.protobuf.Timestam"
          + "p\022\020\n\010taskType\030\005 \001(\t\022\030\n\016cronExpression\030\006 "
          + "\001(\tH\000\022\027\n\rtaskFrequency\030\007 \001(\005H\000\022<\n\014taskRe"
          + "qParam\030\010 \003(\0132&.ScheduleTaskRequest.TaskR"
          + "eqParamEntry\0323\n\021TaskReqParamEntry\022\013\n\003key"
          + "\030\001 \001(\t\022\r\n\005value\030\002 \001(\t:\0028\001B\016\n\014taskInterva"
          + "l\"-\n\031ScheduleTaskDeleteRequest\022\020\n\010taskNa"
          + "me\030\001 \001(\t\";\n\020TaskManagerReply\022\'\n\016response"
          + "Status\030\001 \001(\0132\017.ResponseStatus\"\230\001\n\022Execut"
          + "eTaskRequest\022\020\n\010taskName\030\001 \001(\t\022;\n\014taskRe"
          + "qParam\030\002 \003(\0132%.ExecuteTaskRequest.TaskRe"
          + "qParamEntry\0323\n\021TaskReqParamEntry\022\013\n\003key\030"
          + "\001 \001(\t\022\r\n\005value\030\002 \001(\t:\0028\001\";\n\020ExecuteTaskR"
          + "eply\022\'\n\016responseStatus\030\001 \001(\0132\017.ResponseS"
          + "tatus2\226\002\n\022TaskManagerService\0229\n\014Schedule"
          + "Task\022\024.ScheduleTaskRequest\032\021.TaskManager"
          + "Reply\"\000\022E\n\022DeleteScheduleTask\022\032.Schedule"
          + "TaskDeleteRequest\032\021.TaskManagerReply\"\000\0227"
          + "\n\013ExecuteTask\022\023.ExecuteTaskRequest\032\021.Exe"
          + "cuteTaskReply\"\000\022E\n\021getScheduledTasks\022\027.S"
          + "chedulededTaskRequest\032\025.SchedulededTaskR"
          + "eply\"\000B\036\n\032com.cpdss.common.generatedP\000b\006"
          + "proto3"
    };
    descriptor =
        com.google.protobuf.Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(
            descriptorData,
            new com.google.protobuf.Descriptors.FileDescriptor[] {
              com.google.protobuf.TimestampProto.getDescriptor(),
              com.cpdss.common.generated.Common.getDescriptor(),
            });
    internal_static_SchedulededTaskRequest_descriptor = getDescriptor().getMessageTypes().get(0);
    internal_static_SchedulededTaskRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_SchedulededTaskRequest_descriptor,
            new java.lang.String[] {
              "JobGroup",
            });
    internal_static_SchedulededTaskReply_descriptor = getDescriptor().getMessageTypes().get(1);
    internal_static_SchedulededTaskReply_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_SchedulededTaskReply_descriptor,
            new java.lang.String[] {
              "TaskName", "ResponseStatus",
            });
    internal_static_ScheduleTaskRequest_descriptor = getDescriptor().getMessageTypes().get(2);
    internal_static_ScheduleTaskRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_ScheduleTaskRequest_descriptor,
            new java.lang.String[] {
              "TaskName",
              "TaskURI",
              "TaskStartDateTime",
              "TaskEndDateTime",
              "TaskType",
              "CronExpression",
              "TaskFrequency",
              "TaskReqParam",
              "TaskInterval",
            });
    internal_static_ScheduleTaskRequest_TaskReqParamEntry_descriptor =
        internal_static_ScheduleTaskRequest_descriptor.getNestedTypes().get(0);
    internal_static_ScheduleTaskRequest_TaskReqParamEntry_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_ScheduleTaskRequest_TaskReqParamEntry_descriptor,
            new java.lang.String[] {
              "Key", "Value",
            });
    internal_static_ScheduleTaskDeleteRequest_descriptor = getDescriptor().getMessageTypes().get(3);
    internal_static_ScheduleTaskDeleteRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_ScheduleTaskDeleteRequest_descriptor,
            new java.lang.String[] {
              "TaskName",
            });
    internal_static_TaskManagerReply_descriptor = getDescriptor().getMessageTypes().get(4);
    internal_static_TaskManagerReply_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_TaskManagerReply_descriptor,
            new java.lang.String[] {
              "ResponseStatus",
            });
    internal_static_ExecuteTaskRequest_descriptor = getDescriptor().getMessageTypes().get(5);
    internal_static_ExecuteTaskRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_ExecuteTaskRequest_descriptor,
            new java.lang.String[] {
              "TaskName", "TaskReqParam",
            });
    internal_static_ExecuteTaskRequest_TaskReqParamEntry_descriptor =
        internal_static_ExecuteTaskRequest_descriptor.getNestedTypes().get(0);
    internal_static_ExecuteTaskRequest_TaskReqParamEntry_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_ExecuteTaskRequest_TaskReqParamEntry_descriptor,
            new java.lang.String[] {
              "Key", "Value",
            });
    internal_static_ExecuteTaskReply_descriptor = getDescriptor().getMessageTypes().get(6);
    internal_static_ExecuteTaskReply_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_ExecuteTaskReply_descriptor,
            new java.lang.String[] {
              "ResponseStatus",
            });
    com.google.protobuf.TimestampProto.getDescriptor();
    com.cpdss.common.generated.Common.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
