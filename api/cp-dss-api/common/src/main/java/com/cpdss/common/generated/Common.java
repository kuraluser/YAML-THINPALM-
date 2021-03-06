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

  /**
   *
   *
   * <pre>
   * In loading information, machine in use
   * </pre>
   *
   * Protobuf enum {@code MachineType}
   */
  public enum MachineType implements com.google.protobuf.ProtocolMessageEnum {
    /** <code>EMPTY = 0;</code> */
    EMPTY(0),
    /** <code>VESSEL_PUMP = 1;</code> */
    VESSEL_PUMP(1),
    /** <code>MANIFOLD = 2;</code> */
    MANIFOLD(2),
    /** <code>BOTTOM_LINE = 3;</code> */
    BOTTOM_LINE(3),
    UNRECOGNIZED(-1),
    ;

    /** <code>EMPTY = 0;</code> */
    public static final int EMPTY_VALUE = 0;
    /** <code>VESSEL_PUMP = 1;</code> */
    public static final int VESSEL_PUMP_VALUE = 1;
    /** <code>MANIFOLD = 2;</code> */
    public static final int MANIFOLD_VALUE = 2;
    /** <code>BOTTOM_LINE = 3;</code> */
    public static final int BOTTOM_LINE_VALUE = 3;

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
    public static MachineType valueOf(int value) {
      return forNumber(value);
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     */
    public static MachineType forNumber(int value) {
      switch (value) {
        case 0:
          return EMPTY;
        case 1:
          return VESSEL_PUMP;
        case 2:
          return MANIFOLD;
        case 3:
          return BOTTOM_LINE;
        default:
          return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<MachineType> internalGetValueMap() {
      return internalValueMap;
    }

    private static final com.google.protobuf.Internal.EnumLiteMap<MachineType> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<MachineType>() {
          public MachineType findValueByNumber(int number) {
            return MachineType.forNumber(number);
          }
        };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor getValueDescriptor() {
      return getDescriptor().getValues().get(ordinal());
    }

    public final com.google.protobuf.Descriptors.EnumDescriptor getDescriptorForType() {
      return getDescriptor();
    }

    public static final com.google.protobuf.Descriptors.EnumDescriptor getDescriptor() {
      return com.cpdss.common.generated.Common.getDescriptor().getEnumTypes().get(1);
    }

    private static final MachineType[] VALUES = values();

    public static MachineType valueOf(com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException("EnumValueDescriptor is not for this type.");
      }
      if (desc.getIndex() == -1) {
        return UNRECOGNIZED;
      }
      return VALUES[desc.getIndex()];
    }

    private final int value;

    private MachineType(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:MachineType)
  }

  /** Protobuf enum {@code COW_TYPE} */
  public enum COW_TYPE implements com.google.protobuf.ProtocolMessageEnum {
    /** <code>EMPTY_COW_TYPE = 0;</code> */
    EMPTY_COW_TYPE(0),
    /**
     *
     *
     * <pre>
     * Full wash
     * </pre>
     *
     * <code>ALL_COW = 1;</code>
     */
    ALL_COW(1),
    /**
     *
     *
     * <pre>
     * Bottom wash
     * </pre>
     *
     * <code>BOTTOM_COW = 2;</code>
     */
    BOTTOM_COW(2),
    /**
     *
     *
     * <pre>
     * Top wash
     * </pre>
     *
     * <code>TOP_COW = 3;</code>
     */
    TOP_COW(3),
    /** <code>CARGO = 4;</code> */
    CARGO(4),
    UNRECOGNIZED(-1),
    ;

    /** <code>EMPTY_COW_TYPE = 0;</code> */
    public static final int EMPTY_COW_TYPE_VALUE = 0;
    /**
     *
     *
     * <pre>
     * Full wash
     * </pre>
     *
     * <code>ALL_COW = 1;</code>
     */
    public static final int ALL_COW_VALUE = 1;
    /**
     *
     *
     * <pre>
     * Bottom wash
     * </pre>
     *
     * <code>BOTTOM_COW = 2;</code>
     */
    public static final int BOTTOM_COW_VALUE = 2;
    /**
     *
     *
     * <pre>
     * Top wash
     * </pre>
     *
     * <code>TOP_COW = 3;</code>
     */
    public static final int TOP_COW_VALUE = 3;
    /** <code>CARGO = 4;</code> */
    public static final int CARGO_VALUE = 4;

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
    public static COW_TYPE valueOf(int value) {
      return forNumber(value);
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     */
    public static COW_TYPE forNumber(int value) {
      switch (value) {
        case 0:
          return EMPTY_COW_TYPE;
        case 1:
          return ALL_COW;
        case 2:
          return BOTTOM_COW;
        case 3:
          return TOP_COW;
        case 4:
          return CARGO;
        default:
          return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<COW_TYPE> internalGetValueMap() {
      return internalValueMap;
    }

    private static final com.google.protobuf.Internal.EnumLiteMap<COW_TYPE> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<COW_TYPE>() {
          public COW_TYPE findValueByNumber(int number) {
            return COW_TYPE.forNumber(number);
          }
        };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor getValueDescriptor() {
      return getDescriptor().getValues().get(ordinal());
    }

    public final com.google.protobuf.Descriptors.EnumDescriptor getDescriptorForType() {
      return getDescriptor();
    }

    public static final com.google.protobuf.Descriptors.EnumDescriptor getDescriptor() {
      return com.cpdss.common.generated.Common.getDescriptor().getEnumTypes().get(2);
    }

    private static final COW_TYPE[] VALUES = values();

    public static COW_TYPE valueOf(com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException("EnumValueDescriptor is not for this type.");
      }
      if (desc.getIndex() == -1) {
        return UNRECOGNIZED;
      }
      return VALUES[desc.getIndex()];
    }

    private final int value;

    private COW_TYPE(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:COW_TYPE)
  }

  /** Protobuf enum {@code COW_OPTION_TYPE} */
  public enum COW_OPTION_TYPE implements com.google.protobuf.ProtocolMessageEnum {
    /** <code>EMPTY_COW_OPTION_TYPE = 0;</code> */
    EMPTY_COW_OPTION_TYPE(0),
    /** <code>AUTO = 1;</code> */
    AUTO(1),
    /** <code>MANUAL = 2;</code> */
    MANUAL(2),
    UNRECOGNIZED(-1),
    ;

    /** <code>EMPTY_COW_OPTION_TYPE = 0;</code> */
    public static final int EMPTY_COW_OPTION_TYPE_VALUE = 0;
    /** <code>AUTO = 1;</code> */
    public static final int AUTO_VALUE = 1;
    /** <code>MANUAL = 2;</code> */
    public static final int MANUAL_VALUE = 2;

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
    public static COW_OPTION_TYPE valueOf(int value) {
      return forNumber(value);
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     */
    public static COW_OPTION_TYPE forNumber(int value) {
      switch (value) {
        case 0:
          return EMPTY_COW_OPTION_TYPE;
        case 1:
          return AUTO;
        case 2:
          return MANUAL;
        default:
          return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<COW_OPTION_TYPE> internalGetValueMap() {
      return internalValueMap;
    }

    private static final com.google.protobuf.Internal.EnumLiteMap<COW_OPTION_TYPE>
        internalValueMap =
            new com.google.protobuf.Internal.EnumLiteMap<COW_OPTION_TYPE>() {
              public COW_OPTION_TYPE findValueByNumber(int number) {
                return COW_OPTION_TYPE.forNumber(number);
              }
            };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor getValueDescriptor() {
      return getDescriptor().getValues().get(ordinal());
    }

    public final com.google.protobuf.Descriptors.EnumDescriptor getDescriptorForType() {
      return getDescriptor();
    }

    public static final com.google.protobuf.Descriptors.EnumDescriptor getDescriptor() {
      return com.cpdss.common.generated.Common.getDescriptor().getEnumTypes().get(3);
    }

    private static final COW_OPTION_TYPE[] VALUES = values();

    public static COW_OPTION_TYPE valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException("EnumValueDescriptor is not for this type.");
      }
      if (desc.getIndex() == -1) {
        return UNRECOGNIZED;
      }
      return VALUES[desc.getIndex()];
    }

    private final int value;

    private COW_OPTION_TYPE(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:COW_OPTION_TYPE)
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
     * <code>int64 cargoNominationId = 3;</code>
     *
     * @return The cargoNominationId.
     */
    long getCargoNominationId();

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

    /**
     * <code>string cargoColor = 9;</code>
     *
     * @return The cargoColor.
     */
    java.lang.String getCargoColor();
    /**
     * <code>string cargoColor = 9;</code>
     *
     * @return The bytes for cargoColor.
     */
    com.google.protobuf.ByteString getCargoColorBytes();

    /**
     * <code>string cargoName = 10;</code>
     *
     * @return The cargoName.
     */
    java.lang.String getCargoName();
    /**
     * <code>string cargoName = 10;</code>
     *
     * @return The bytes for cargoName.
     */
    com.google.protobuf.ByteString getCargoNameBytes();

    /**
     * <code>string cargoAbbrevation = 11;</code>
     *
     * @return The cargoAbbrevation.
     */
    java.lang.String getCargoAbbrevation();
    /**
     * <code>string cargoAbbrevation = 11;</code>
     *
     * @return The bytes for cargoAbbrevation.
     */
    com.google.protobuf.ByteString getCargoAbbrevationBytes();

    /**
     * <code>repeated int64 loadingPort = 12;</code>
     *
     * @return A list containing the loadingPort.
     */
    java.util.List<java.lang.Long> getLoadingPortList();
    /**
     * <code>repeated int64 loadingPort = 12;</code>
     *
     * @return The count of loadingPort.
     */
    int getLoadingPortCount();
    /**
     * <code>repeated int64 loadingPort = 12;</code>
     *
     * @param index The index of the element to return.
     * @return The loadingPort at the given index.
     */
    long getLoadingPort(int index);

    /**
     * <code>int64 cargoId = 13;</code>
     *
     * @return The cargoId.
     */
    long getCargoId();

    /**
     * <code>string blRefNo = 14;</code>
     *
     * @return The blRefNo.
     */
    java.lang.String getBlRefNo();
    /**
     * <code>string blRefNo = 14;</code>
     *
     * @return The bytes for blRefNo.
     */
    com.google.protobuf.ByteString getBlRefNoBytes();

    /**
     * <code>string quantityLT = 15;</code>
     *
     * @return The quantityLT.
     */
    java.lang.String getQuantityLT();
    /**
     * <code>string quantityLT = 15;</code>
     *
     * @return The bytes for quantityLT.
     */
    com.google.protobuf.ByteString getQuantityLTBytes();

    /**
     * <code>int64 portRotationId = 16;</code>
     *
     * @return The portRotationId.
     */
    long getPortRotationId();

    /**
     * <code>repeated int64 loadingPortRotationIds = 17;</code>
     *
     * @return A list containing the loadingPortRotationIds.
     */
    java.util.List<java.lang.Long> getLoadingPortRotationIdsList();
    /**
     * <code>repeated int64 loadingPortRotationIds = 17;</code>
     *
     * @return The count of loadingPortRotationIds.
     */
    int getLoadingPortRotationIdsCount();
    /**
     * <code>repeated int64 loadingPortRotationIds = 17;</code>
     *
     * @param index The index of the element to return.
     * @return The loadingPortRotationIds at the given index.
     */
    long getLoadingPortRotationIds(int index);
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
      cargoColor_ = "";
      cargoName_ = "";
      cargoAbbrevation_ = "";
      loadingPort_ = emptyLongList();
      blRefNo_ = "";
      quantityLT_ = "";
      loadingPortRotationIds_ = emptyLongList();
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
                portId_ = input.readInt64();
                break;
              }
            case 24:
              {
                cargoNominationId_ = input.readInt64();
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
            case 74:
              {
                java.lang.String s = input.readStringRequireUtf8();

                cargoColor_ = s;
                break;
              }
            case 82:
              {
                java.lang.String s = input.readStringRequireUtf8();

                cargoName_ = s;
                break;
              }
            case 90:
              {
                java.lang.String s = input.readStringRequireUtf8();

                cargoAbbrevation_ = s;
                break;
              }
            case 96:
              {
                if (!((mutable_bitField0_ & 0x00000001) != 0)) {
                  loadingPort_ = newLongList();
                  mutable_bitField0_ |= 0x00000001;
                }
                loadingPort_.addLong(input.readInt64());
                break;
              }
            case 98:
              {
                int length = input.readRawVarint32();
                int limit = input.pushLimit(length);
                if (!((mutable_bitField0_ & 0x00000001) != 0) && input.getBytesUntilLimit() > 0) {
                  loadingPort_ = newLongList();
                  mutable_bitField0_ |= 0x00000001;
                }
                while (input.getBytesUntilLimit() > 0) {
                  loadingPort_.addLong(input.readInt64());
                }
                input.popLimit(limit);
                break;
              }
            case 104:
              {
                cargoId_ = input.readInt64();
                break;
              }
            case 114:
              {
                java.lang.String s = input.readStringRequireUtf8();

                blRefNo_ = s;
                break;
              }
            case 122:
              {
                java.lang.String s = input.readStringRequireUtf8();

                quantityLT_ = s;
                break;
              }
            case 128:
              {
                portRotationId_ = input.readInt64();
                break;
              }
            case 136:
              {
                if (!((mutable_bitField0_ & 0x00000002) != 0)) {
                  loadingPortRotationIds_ = newLongList();
                  mutable_bitField0_ |= 0x00000002;
                }
                loadingPortRotationIds_.addLong(input.readInt64());
                break;
              }
            case 138:
              {
                int length = input.readRawVarint32();
                int limit = input.pushLimit(length);
                if (!((mutable_bitField0_ & 0x00000002) != 0) && input.getBytesUntilLimit() > 0) {
                  loadingPortRotationIds_ = newLongList();
                  mutable_bitField0_ |= 0x00000002;
                }
                while (input.getBytesUntilLimit() > 0) {
                  loadingPortRotationIds_.addLong(input.readInt64());
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
          loadingPort_.makeImmutable(); // C
        }
        if (((mutable_bitField0_ & 0x00000002) != 0)) {
          loadingPortRotationIds_.makeImmutable(); // C
        }
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

    public static final int CARGONOMINATIONID_FIELD_NUMBER = 3;
    private long cargoNominationId_;
    /**
     * <code>int64 cargoNominationId = 3;</code>
     *
     * @return The cargoNominationId.
     */
    public long getCargoNominationId() {
      return cargoNominationId_;
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

    public static final int CARGOCOLOR_FIELD_NUMBER = 9;
    private volatile java.lang.Object cargoColor_;
    /**
     * <code>string cargoColor = 9;</code>
     *
     * @return The cargoColor.
     */
    public java.lang.String getCargoColor() {
      java.lang.Object ref = cargoColor_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        cargoColor_ = s;
        return s;
      }
    }
    /**
     * <code>string cargoColor = 9;</code>
     *
     * @return The bytes for cargoColor.
     */
    public com.google.protobuf.ByteString getCargoColorBytes() {
      java.lang.Object ref = cargoColor_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        cargoColor_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int CARGONAME_FIELD_NUMBER = 10;
    private volatile java.lang.Object cargoName_;
    /**
     * <code>string cargoName = 10;</code>
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
     * <code>string cargoName = 10;</code>
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

    public static final int CARGOABBREVATION_FIELD_NUMBER = 11;
    private volatile java.lang.Object cargoAbbrevation_;
    /**
     * <code>string cargoAbbrevation = 11;</code>
     *
     * @return The cargoAbbrevation.
     */
    public java.lang.String getCargoAbbrevation() {
      java.lang.Object ref = cargoAbbrevation_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        cargoAbbrevation_ = s;
        return s;
      }
    }
    /**
     * <code>string cargoAbbrevation = 11;</code>
     *
     * @return The bytes for cargoAbbrevation.
     */
    public com.google.protobuf.ByteString getCargoAbbrevationBytes() {
      java.lang.Object ref = cargoAbbrevation_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        cargoAbbrevation_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int LOADINGPORT_FIELD_NUMBER = 12;
    private com.google.protobuf.Internal.LongList loadingPort_;
    /**
     * <code>repeated int64 loadingPort = 12;</code>
     *
     * @return A list containing the loadingPort.
     */
    public java.util.List<java.lang.Long> getLoadingPortList() {
      return loadingPort_;
    }
    /**
     * <code>repeated int64 loadingPort = 12;</code>
     *
     * @return The count of loadingPort.
     */
    public int getLoadingPortCount() {
      return loadingPort_.size();
    }
    /**
     * <code>repeated int64 loadingPort = 12;</code>
     *
     * @param index The index of the element to return.
     * @return The loadingPort at the given index.
     */
    public long getLoadingPort(int index) {
      return loadingPort_.getLong(index);
    }

    private int loadingPortMemoizedSerializedSize = -1;

    public static final int CARGOID_FIELD_NUMBER = 13;
    private long cargoId_;
    /**
     * <code>int64 cargoId = 13;</code>
     *
     * @return The cargoId.
     */
    public long getCargoId() {
      return cargoId_;
    }

    public static final int BLREFNO_FIELD_NUMBER = 14;
    private volatile java.lang.Object blRefNo_;
    /**
     * <code>string blRefNo = 14;</code>
     *
     * @return The blRefNo.
     */
    public java.lang.String getBlRefNo() {
      java.lang.Object ref = blRefNo_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        blRefNo_ = s;
        return s;
      }
    }
    /**
     * <code>string blRefNo = 14;</code>
     *
     * @return The bytes for blRefNo.
     */
    public com.google.protobuf.ByteString getBlRefNoBytes() {
      java.lang.Object ref = blRefNo_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        blRefNo_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int QUANTITYLT_FIELD_NUMBER = 15;
    private volatile java.lang.Object quantityLT_;
    /**
     * <code>string quantityLT = 15;</code>
     *
     * @return The quantityLT.
     */
    public java.lang.String getQuantityLT() {
      java.lang.Object ref = quantityLT_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        quantityLT_ = s;
        return s;
      }
    }
    /**
     * <code>string quantityLT = 15;</code>
     *
     * @return The bytes for quantityLT.
     */
    public com.google.protobuf.ByteString getQuantityLTBytes() {
      java.lang.Object ref = quantityLT_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        quantityLT_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int PORTROTATIONID_FIELD_NUMBER = 16;
    private long portRotationId_;
    /**
     * <code>int64 portRotationId = 16;</code>
     *
     * @return The portRotationId.
     */
    public long getPortRotationId() {
      return portRotationId_;
    }

    public static final int LOADINGPORTROTATIONIDS_FIELD_NUMBER = 17;
    private com.google.protobuf.Internal.LongList loadingPortRotationIds_;
    /**
     * <code>repeated int64 loadingPortRotationIds = 17;</code>
     *
     * @return A list containing the loadingPortRotationIds.
     */
    public java.util.List<java.lang.Long> getLoadingPortRotationIdsList() {
      return loadingPortRotationIds_;
    }
    /**
     * <code>repeated int64 loadingPortRotationIds = 17;</code>
     *
     * @return The count of loadingPortRotationIds.
     */
    public int getLoadingPortRotationIdsCount() {
      return loadingPortRotationIds_.size();
    }
    /**
     * <code>repeated int64 loadingPortRotationIds = 17;</code>
     *
     * @param index The index of the element to return.
     * @return The loadingPortRotationIds at the given index.
     */
    public long getLoadingPortRotationIds(int index) {
      return loadingPortRotationIds_.getLong(index);
    }

    private int loadingPortRotationIdsMemoizedSerializedSize = -1;

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
      if (id_ != 0L) {
        output.writeInt64(1, id_);
      }
      if (portId_ != 0L) {
        output.writeInt64(2, portId_);
      }
      if (cargoNominationId_ != 0L) {
        output.writeInt64(3, cargoNominationId_);
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
      if (!getCargoColorBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 9, cargoColor_);
      }
      if (!getCargoNameBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 10, cargoName_);
      }
      if (!getCargoAbbrevationBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 11, cargoAbbrevation_);
      }
      if (getLoadingPortList().size() > 0) {
        output.writeUInt32NoTag(98);
        output.writeUInt32NoTag(loadingPortMemoizedSerializedSize);
      }
      for (int i = 0; i < loadingPort_.size(); i++) {
        output.writeInt64NoTag(loadingPort_.getLong(i));
      }
      if (cargoId_ != 0L) {
        output.writeInt64(13, cargoId_);
      }
      if (!getBlRefNoBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 14, blRefNo_);
      }
      if (!getQuantityLTBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 15, quantityLT_);
      }
      if (portRotationId_ != 0L) {
        output.writeInt64(16, portRotationId_);
      }
      if (getLoadingPortRotationIdsList().size() > 0) {
        output.writeUInt32NoTag(138);
        output.writeUInt32NoTag(loadingPortRotationIdsMemoizedSerializedSize);
      }
      for (int i = 0; i < loadingPortRotationIds_.size(); i++) {
        output.writeInt64NoTag(loadingPortRotationIds_.getLong(i));
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
      if (cargoNominationId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(3, cargoNominationId_);
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
      if (!getCargoColorBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(9, cargoColor_);
      }
      if (!getCargoNameBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(10, cargoName_);
      }
      if (!getCargoAbbrevationBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(11, cargoAbbrevation_);
      }
      {
        int dataSize = 0;
        for (int i = 0; i < loadingPort_.size(); i++) {
          dataSize +=
              com.google.protobuf.CodedOutputStream.computeInt64SizeNoTag(loadingPort_.getLong(i));
        }
        size += dataSize;
        if (!getLoadingPortList().isEmpty()) {
          size += 1;
          size += com.google.protobuf.CodedOutputStream.computeInt32SizeNoTag(dataSize);
        }
        loadingPortMemoizedSerializedSize = dataSize;
      }
      if (cargoId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(13, cargoId_);
      }
      if (!getBlRefNoBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(14, blRefNo_);
      }
      if (!getQuantityLTBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(15, quantityLT_);
      }
      if (portRotationId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(16, portRotationId_);
      }
      {
        int dataSize = 0;
        for (int i = 0; i < loadingPortRotationIds_.size(); i++) {
          dataSize +=
              com.google.protobuf.CodedOutputStream.computeInt64SizeNoTag(
                  loadingPortRotationIds_.getLong(i));
        }
        size += dataSize;
        if (!getLoadingPortRotationIdsList().isEmpty()) {
          size += 2;
          size += com.google.protobuf.CodedOutputStream.computeInt32SizeNoTag(dataSize);
        }
        loadingPortRotationIdsMemoizedSerializedSize = dataSize;
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
      if (getCargoNominationId() != other.getCargoNominationId()) return false;
      if (!getQuantityBbls().equals(other.getQuantityBbls())) return false;
      if (!getQuantityMt().equals(other.getQuantityMt())) return false;
      if (!getQuantityKl().equals(other.getQuantityKl())) return false;
      if (!getApi().equals(other.getApi())) return false;
      if (!getTemperature().equals(other.getTemperature())) return false;
      if (!getCargoColor().equals(other.getCargoColor())) return false;
      if (!getCargoName().equals(other.getCargoName())) return false;
      if (!getCargoAbbrevation().equals(other.getCargoAbbrevation())) return false;
      if (!getLoadingPortList().equals(other.getLoadingPortList())) return false;
      if (getCargoId() != other.getCargoId()) return false;
      if (!getBlRefNo().equals(other.getBlRefNo())) return false;
      if (!getQuantityLT().equals(other.getQuantityLT())) return false;
      if (getPortRotationId() != other.getPortRotationId()) return false;
      if (!getLoadingPortRotationIdsList().equals(other.getLoadingPortRotationIdsList()))
        return false;
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
      hash = (37 * hash) + CARGONOMINATIONID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getCargoNominationId());
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
      hash = (37 * hash) + CARGOCOLOR_FIELD_NUMBER;
      hash = (53 * hash) + getCargoColor().hashCode();
      hash = (37 * hash) + CARGONAME_FIELD_NUMBER;
      hash = (53 * hash) + getCargoName().hashCode();
      hash = (37 * hash) + CARGOABBREVATION_FIELD_NUMBER;
      hash = (53 * hash) + getCargoAbbrevation().hashCode();
      if (getLoadingPortCount() > 0) {
        hash = (37 * hash) + LOADINGPORT_FIELD_NUMBER;
        hash = (53 * hash) + getLoadingPortList().hashCode();
      }
      hash = (37 * hash) + CARGOID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getCargoId());
      hash = (37 * hash) + BLREFNO_FIELD_NUMBER;
      hash = (53 * hash) + getBlRefNo().hashCode();
      hash = (37 * hash) + QUANTITYLT_FIELD_NUMBER;
      hash = (53 * hash) + getQuantityLT().hashCode();
      hash = (37 * hash) + PORTROTATIONID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getPortRotationId());
      if (getLoadingPortRotationIdsCount() > 0) {
        hash = (37 * hash) + LOADINGPORTROTATIONIDS_FIELD_NUMBER;
        hash = (53 * hash) + getLoadingPortRotationIdsList().hashCode();
      }
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

        cargoNominationId_ = 0L;

        quantityBbls_ = "";

        quantityMt_ = "";

        quantityKl_ = "";

        api_ = "";

        temperature_ = "";

        cargoColor_ = "";

        cargoName_ = "";

        cargoAbbrevation_ = "";

        loadingPort_ = emptyLongList();
        bitField0_ = (bitField0_ & ~0x00000001);
        cargoId_ = 0L;

        blRefNo_ = "";

        quantityLT_ = "";

        portRotationId_ = 0L;

        loadingPortRotationIds_ = emptyLongList();
        bitField0_ = (bitField0_ & ~0x00000002);
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
        int from_bitField0_ = bitField0_;
        result.id_ = id_;
        result.portId_ = portId_;
        result.cargoNominationId_ = cargoNominationId_;
        result.quantityBbls_ = quantityBbls_;
        result.quantityMt_ = quantityMt_;
        result.quantityKl_ = quantityKl_;
        result.api_ = api_;
        result.temperature_ = temperature_;
        result.cargoColor_ = cargoColor_;
        result.cargoName_ = cargoName_;
        result.cargoAbbrevation_ = cargoAbbrevation_;
        if (((bitField0_ & 0x00000001) != 0)) {
          loadingPort_.makeImmutable();
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.loadingPort_ = loadingPort_;
        result.cargoId_ = cargoId_;
        result.blRefNo_ = blRefNo_;
        result.quantityLT_ = quantityLT_;
        result.portRotationId_ = portRotationId_;
        if (((bitField0_ & 0x00000002) != 0)) {
          loadingPortRotationIds_.makeImmutable();
          bitField0_ = (bitField0_ & ~0x00000002);
        }
        result.loadingPortRotationIds_ = loadingPortRotationIds_;
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
        if (other.getCargoNominationId() != 0L) {
          setCargoNominationId(other.getCargoNominationId());
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
        if (!other.getCargoColor().isEmpty()) {
          cargoColor_ = other.cargoColor_;
          onChanged();
        }
        if (!other.getCargoName().isEmpty()) {
          cargoName_ = other.cargoName_;
          onChanged();
        }
        if (!other.getCargoAbbrevation().isEmpty()) {
          cargoAbbrevation_ = other.cargoAbbrevation_;
          onChanged();
        }
        if (!other.loadingPort_.isEmpty()) {
          if (loadingPort_.isEmpty()) {
            loadingPort_ = other.loadingPort_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureLoadingPortIsMutable();
            loadingPort_.addAll(other.loadingPort_);
          }
          onChanged();
        }
        if (other.getCargoId() != 0L) {
          setCargoId(other.getCargoId());
        }
        if (!other.getBlRefNo().isEmpty()) {
          blRefNo_ = other.blRefNo_;
          onChanged();
        }
        if (!other.getQuantityLT().isEmpty()) {
          quantityLT_ = other.quantityLT_;
          onChanged();
        }
        if (other.getPortRotationId() != 0L) {
          setPortRotationId(other.getPortRotationId());
        }
        if (!other.loadingPortRotationIds_.isEmpty()) {
          if (loadingPortRotationIds_.isEmpty()) {
            loadingPortRotationIds_ = other.loadingPortRotationIds_;
            bitField0_ = (bitField0_ & ~0x00000002);
          } else {
            ensureLoadingPortRotationIdsIsMutable();
            loadingPortRotationIds_.addAll(other.loadingPortRotationIds_);
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

      private long cargoNominationId_;
      /**
       * <code>int64 cargoNominationId = 3;</code>
       *
       * @return The cargoNominationId.
       */
      public long getCargoNominationId() {
        return cargoNominationId_;
      }
      /**
       * <code>int64 cargoNominationId = 3;</code>
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
       * <code>int64 cargoNominationId = 3;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearCargoNominationId() {

        cargoNominationId_ = 0L;
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

      private java.lang.Object cargoColor_ = "";
      /**
       * <code>string cargoColor = 9;</code>
       *
       * @return The cargoColor.
       */
      public java.lang.String getCargoColor() {
        java.lang.Object ref = cargoColor_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          cargoColor_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string cargoColor = 9;</code>
       *
       * @return The bytes for cargoColor.
       */
      public com.google.protobuf.ByteString getCargoColorBytes() {
        java.lang.Object ref = cargoColor_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          cargoColor_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string cargoColor = 9;</code>
       *
       * @param value The cargoColor to set.
       * @return This builder for chaining.
       */
      public Builder setCargoColor(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        cargoColor_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string cargoColor = 9;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearCargoColor() {

        cargoColor_ = getDefaultInstance().getCargoColor();
        onChanged();
        return this;
      }
      /**
       * <code>string cargoColor = 9;</code>
       *
       * @param value The bytes for cargoColor to set.
       * @return This builder for chaining.
       */
      public Builder setCargoColorBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        cargoColor_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object cargoName_ = "";
      /**
       * <code>string cargoName = 10;</code>
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
       * <code>string cargoName = 10;</code>
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
       * <code>string cargoName = 10;</code>
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
       * <code>string cargoName = 10;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearCargoName() {

        cargoName_ = getDefaultInstance().getCargoName();
        onChanged();
        return this;
      }
      /**
       * <code>string cargoName = 10;</code>
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

      private java.lang.Object cargoAbbrevation_ = "";
      /**
       * <code>string cargoAbbrevation = 11;</code>
       *
       * @return The cargoAbbrevation.
       */
      public java.lang.String getCargoAbbrevation() {
        java.lang.Object ref = cargoAbbrevation_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          cargoAbbrevation_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string cargoAbbrevation = 11;</code>
       *
       * @return The bytes for cargoAbbrevation.
       */
      public com.google.protobuf.ByteString getCargoAbbrevationBytes() {
        java.lang.Object ref = cargoAbbrevation_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          cargoAbbrevation_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string cargoAbbrevation = 11;</code>
       *
       * @param value The cargoAbbrevation to set.
       * @return This builder for chaining.
       */
      public Builder setCargoAbbrevation(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        cargoAbbrevation_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string cargoAbbrevation = 11;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearCargoAbbrevation() {

        cargoAbbrevation_ = getDefaultInstance().getCargoAbbrevation();
        onChanged();
        return this;
      }
      /**
       * <code>string cargoAbbrevation = 11;</code>
       *
       * @param value The bytes for cargoAbbrevation to set.
       * @return This builder for chaining.
       */
      public Builder setCargoAbbrevationBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        cargoAbbrevation_ = value;
        onChanged();
        return this;
      }

      private com.google.protobuf.Internal.LongList loadingPort_ = emptyLongList();

      private void ensureLoadingPortIsMutable() {
        if (!((bitField0_ & 0x00000001) != 0)) {
          loadingPort_ = mutableCopy(loadingPort_);
          bitField0_ |= 0x00000001;
        }
      }
      /**
       * <code>repeated int64 loadingPort = 12;</code>
       *
       * @return A list containing the loadingPort.
       */
      public java.util.List<java.lang.Long> getLoadingPortList() {
        return ((bitField0_ & 0x00000001) != 0)
            ? java.util.Collections.unmodifiableList(loadingPort_)
            : loadingPort_;
      }
      /**
       * <code>repeated int64 loadingPort = 12;</code>
       *
       * @return The count of loadingPort.
       */
      public int getLoadingPortCount() {
        return loadingPort_.size();
      }
      /**
       * <code>repeated int64 loadingPort = 12;</code>
       *
       * @param index The index of the element to return.
       * @return The loadingPort at the given index.
       */
      public long getLoadingPort(int index) {
        return loadingPort_.getLong(index);
      }
      /**
       * <code>repeated int64 loadingPort = 12;</code>
       *
       * @param index The index to set the value at.
       * @param value The loadingPort to set.
       * @return This builder for chaining.
       */
      public Builder setLoadingPort(int index, long value) {
        ensureLoadingPortIsMutable();
        loadingPort_.setLong(index, value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated int64 loadingPort = 12;</code>
       *
       * @param value The loadingPort to add.
       * @return This builder for chaining.
       */
      public Builder addLoadingPort(long value) {
        ensureLoadingPortIsMutable();
        loadingPort_.addLong(value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated int64 loadingPort = 12;</code>
       *
       * @param values The loadingPort to add.
       * @return This builder for chaining.
       */
      public Builder addAllLoadingPort(java.lang.Iterable<? extends java.lang.Long> values) {
        ensureLoadingPortIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(values, loadingPort_);
        onChanged();
        return this;
      }
      /**
       * <code>repeated int64 loadingPort = 12;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearLoadingPort() {
        loadingPort_ = emptyLongList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
        return this;
      }

      private long cargoId_;
      /**
       * <code>int64 cargoId = 13;</code>
       *
       * @return The cargoId.
       */
      public long getCargoId() {
        return cargoId_;
      }
      /**
       * <code>int64 cargoId = 13;</code>
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
       * <code>int64 cargoId = 13;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearCargoId() {

        cargoId_ = 0L;
        onChanged();
        return this;
      }

      private java.lang.Object blRefNo_ = "";
      /**
       * <code>string blRefNo = 14;</code>
       *
       * @return The blRefNo.
       */
      public java.lang.String getBlRefNo() {
        java.lang.Object ref = blRefNo_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          blRefNo_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string blRefNo = 14;</code>
       *
       * @return The bytes for blRefNo.
       */
      public com.google.protobuf.ByteString getBlRefNoBytes() {
        java.lang.Object ref = blRefNo_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          blRefNo_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string blRefNo = 14;</code>
       *
       * @param value The blRefNo to set.
       * @return This builder for chaining.
       */
      public Builder setBlRefNo(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        blRefNo_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string blRefNo = 14;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearBlRefNo() {

        blRefNo_ = getDefaultInstance().getBlRefNo();
        onChanged();
        return this;
      }
      /**
       * <code>string blRefNo = 14;</code>
       *
       * @param value The bytes for blRefNo to set.
       * @return This builder for chaining.
       */
      public Builder setBlRefNoBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        blRefNo_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object quantityLT_ = "";
      /**
       * <code>string quantityLT = 15;</code>
       *
       * @return The quantityLT.
       */
      public java.lang.String getQuantityLT() {
        java.lang.Object ref = quantityLT_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          quantityLT_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string quantityLT = 15;</code>
       *
       * @return The bytes for quantityLT.
       */
      public com.google.protobuf.ByteString getQuantityLTBytes() {
        java.lang.Object ref = quantityLT_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          quantityLT_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string quantityLT = 15;</code>
       *
       * @param value The quantityLT to set.
       * @return This builder for chaining.
       */
      public Builder setQuantityLT(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        quantityLT_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string quantityLT = 15;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearQuantityLT() {

        quantityLT_ = getDefaultInstance().getQuantityLT();
        onChanged();
        return this;
      }
      /**
       * <code>string quantityLT = 15;</code>
       *
       * @param value The bytes for quantityLT to set.
       * @return This builder for chaining.
       */
      public Builder setQuantityLTBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        quantityLT_ = value;
        onChanged();
        return this;
      }

      private long portRotationId_;
      /**
       * <code>int64 portRotationId = 16;</code>
       *
       * @return The portRotationId.
       */
      public long getPortRotationId() {
        return portRotationId_;
      }
      /**
       * <code>int64 portRotationId = 16;</code>
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
       * <code>int64 portRotationId = 16;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearPortRotationId() {

        portRotationId_ = 0L;
        onChanged();
        return this;
      }

      private com.google.protobuf.Internal.LongList loadingPortRotationIds_ = emptyLongList();

      private void ensureLoadingPortRotationIdsIsMutable() {
        if (!((bitField0_ & 0x00000002) != 0)) {
          loadingPortRotationIds_ = mutableCopy(loadingPortRotationIds_);
          bitField0_ |= 0x00000002;
        }
      }
      /**
       * <code>repeated int64 loadingPortRotationIds = 17;</code>
       *
       * @return A list containing the loadingPortRotationIds.
       */
      public java.util.List<java.lang.Long> getLoadingPortRotationIdsList() {
        return ((bitField0_ & 0x00000002) != 0)
            ? java.util.Collections.unmodifiableList(loadingPortRotationIds_)
            : loadingPortRotationIds_;
      }
      /**
       * <code>repeated int64 loadingPortRotationIds = 17;</code>
       *
       * @return The count of loadingPortRotationIds.
       */
      public int getLoadingPortRotationIdsCount() {
        return loadingPortRotationIds_.size();
      }
      /**
       * <code>repeated int64 loadingPortRotationIds = 17;</code>
       *
       * @param index The index of the element to return.
       * @return The loadingPortRotationIds at the given index.
       */
      public long getLoadingPortRotationIds(int index) {
        return loadingPortRotationIds_.getLong(index);
      }
      /**
       * <code>repeated int64 loadingPortRotationIds = 17;</code>
       *
       * @param index The index to set the value at.
       * @param value The loadingPortRotationIds to set.
       * @return This builder for chaining.
       */
      public Builder setLoadingPortRotationIds(int index, long value) {
        ensureLoadingPortRotationIdsIsMutable();
        loadingPortRotationIds_.setLong(index, value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated int64 loadingPortRotationIds = 17;</code>
       *
       * @param value The loadingPortRotationIds to add.
       * @return This builder for chaining.
       */
      public Builder addLoadingPortRotationIds(long value) {
        ensureLoadingPortRotationIdsIsMutable();
        loadingPortRotationIds_.addLong(value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated int64 loadingPortRotationIds = 17;</code>
       *
       * @param values The loadingPortRotationIds to add.
       * @return This builder for chaining.
       */
      public Builder addAllLoadingPortRotationIds(
          java.lang.Iterable<? extends java.lang.Long> values) {
        ensureLoadingPortRotationIdsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(values, loadingPortRotationIds_);
        onChanged();
        return this;
      }
      /**
       * <code>repeated int64 loadingPortRotationIds = 17;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearLoadingPortRotationIds() {
        loadingPortRotationIds_ = emptyLongList();
        bitField0_ = (bitField0_ & ~0x00000002);
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
     * <code>bool displayInSettings = 4;</code>
     *
     * @return The displayInSettings.
     */
    boolean getDisplayInSettings();

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

    /**
     * <code>bool isHardRule = 9;</code>
     *
     * @return The isHardRule.
     */
    boolean getIsHardRule();

    /**
     * <code>int64 numericPrecision = 10;</code>
     *
     * @return The numericPrecision.
     */
    long getNumericPrecision();

    /**
     * <code>int64 numericScale = 11;</code>
     *
     * @return The numericScale.
     */
    long getNumericScale();
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
                displayInSettings_ = input.readBool();
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
            case 72:
              {
                isHardRule_ = input.readBool();
                break;
              }
            case 80:
              {
                numericPrecision_ = input.readInt64();
                break;
              }
            case 88:
              {
                numericScale_ = input.readInt64();
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

    public static final int DISPLAYINSETTINGS_FIELD_NUMBER = 4;
    private boolean displayInSettings_;
    /**
     * <code>bool displayInSettings = 4;</code>
     *
     * @return The displayInSettings.
     */
    public boolean getDisplayInSettings() {
      return displayInSettings_;
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

    public static final int ISHARDRULE_FIELD_NUMBER = 9;
    private boolean isHardRule_;
    /**
     * <code>bool isHardRule = 9;</code>
     *
     * @return The isHardRule.
     */
    public boolean getIsHardRule() {
      return isHardRule_;
    }

    public static final int NUMERICPRECISION_FIELD_NUMBER = 10;
    private long numericPrecision_;
    /**
     * <code>int64 numericPrecision = 10;</code>
     *
     * @return The numericPrecision.
     */
    public long getNumericPrecision() {
      return numericPrecision_;
    }

    public static final int NUMERICSCALE_FIELD_NUMBER = 11;
    private long numericScale_;
    /**
     * <code>int64 numericScale = 11;</code>
     *
     * @return The numericScale.
     */
    public long getNumericScale() {
      return numericScale_;
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
      if (displayInSettings_ != false) {
        output.writeBool(4, displayInSettings_);
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
      if (isHardRule_ != false) {
        output.writeBool(9, isHardRule_);
      }
      if (numericPrecision_ != 0L) {
        output.writeInt64(10, numericPrecision_);
      }
      if (numericScale_ != 0L) {
        output.writeInt64(11, numericScale_);
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
      if (displayInSettings_ != false) {
        size += com.google.protobuf.CodedOutputStream.computeBoolSize(4, displayInSettings_);
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
      if (isHardRule_ != false) {
        size += com.google.protobuf.CodedOutputStream.computeBoolSize(9, isHardRule_);
      }
      if (numericPrecision_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(10, numericPrecision_);
      }
      if (numericScale_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(11, numericScale_);
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
      if (getDisplayInSettings() != other.getDisplayInSettings()) return false;
      if (!getRuleType().equals(other.getRuleType())) return false;
      if (!getInputsList().equals(other.getInputsList())) return false;
      if (!getRuleTemplateId().equals(other.getRuleTemplateId())) return false;
      if (!getVesselRuleXId().equals(other.getVesselRuleXId())) return false;
      if (getIsHardRule() != other.getIsHardRule()) return false;
      if (getNumericPrecision() != other.getNumericPrecision()) return false;
      if (getNumericScale() != other.getNumericScale()) return false;
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
      hash = (37 * hash) + DISPLAYINSETTINGS_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(getDisplayInSettings());
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
      hash = (37 * hash) + ISHARDRULE_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(getIsHardRule());
      hash = (37 * hash) + NUMERICPRECISION_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getNumericPrecision());
      hash = (37 * hash) + NUMERICSCALE_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getNumericScale());
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

        displayInSettings_ = false;

        ruleType_ = "";

        if (inputsBuilder_ == null) {
          inputs_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          inputsBuilder_.clear();
        }
        ruleTemplateId_ = "";

        vesselRuleXId_ = "";

        isHardRule_ = false;

        numericPrecision_ = 0L;

        numericScale_ = 0L;

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
        result.displayInSettings_ = displayInSettings_;
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
        result.isHardRule_ = isHardRule_;
        result.numericPrecision_ = numericPrecision_;
        result.numericScale_ = numericScale_;
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
        if (other.getDisplayInSettings() != false) {
          setDisplayInSettings(other.getDisplayInSettings());
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
        if (other.getIsHardRule() != false) {
          setIsHardRule(other.getIsHardRule());
        }
        if (other.getNumericPrecision() != 0L) {
          setNumericPrecision(other.getNumericPrecision());
        }
        if (other.getNumericScale() != 0L) {
          setNumericScale(other.getNumericScale());
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

      private boolean displayInSettings_;
      /**
       * <code>bool displayInSettings = 4;</code>
       *
       * @return The displayInSettings.
       */
      public boolean getDisplayInSettings() {
        return displayInSettings_;
      }
      /**
       * <code>bool displayInSettings = 4;</code>
       *
       * @param value The displayInSettings to set.
       * @return This builder for chaining.
       */
      public Builder setDisplayInSettings(boolean value) {

        displayInSettings_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>bool displayInSettings = 4;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearDisplayInSettings() {

        displayInSettings_ = false;
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

      private boolean isHardRule_;
      /**
       * <code>bool isHardRule = 9;</code>
       *
       * @return The isHardRule.
       */
      public boolean getIsHardRule() {
        return isHardRule_;
      }
      /**
       * <code>bool isHardRule = 9;</code>
       *
       * @param value The isHardRule to set.
       * @return This builder for chaining.
       */
      public Builder setIsHardRule(boolean value) {

        isHardRule_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>bool isHardRule = 9;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearIsHardRule() {

        isHardRule_ = false;
        onChanged();
        return this;
      }

      private long numericPrecision_;
      /**
       * <code>int64 numericPrecision = 10;</code>
       *
       * @return The numericPrecision.
       */
      public long getNumericPrecision() {
        return numericPrecision_;
      }
      /**
       * <code>int64 numericPrecision = 10;</code>
       *
       * @param value The numericPrecision to set.
       * @return This builder for chaining.
       */
      public Builder setNumericPrecision(long value) {

        numericPrecision_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int64 numericPrecision = 10;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearNumericPrecision() {

        numericPrecision_ = 0L;
        onChanged();
        return this;
      }

      private long numericScale_;
      /**
       * <code>int64 numericScale = 11;</code>
       *
       * @return The numericScale.
       */
      public long getNumericScale() {
        return numericScale_;
      }
      /**
       * <code>int64 numericScale = 11;</code>
       *
       * @param value The numericScale to set.
       * @return This builder for chaining.
       */
      public Builder setNumericScale(long value) {

        numericScale_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int64 numericScale = 11;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearNumericScale() {

        numericScale_ = 0L;
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

    /** <code>repeated .RuleDropDownMaster ruleDropDownMaster = 9;</code> */
    java.util.List<com.cpdss.common.generated.Common.RuleDropDownMaster>
        getRuleDropDownMasterList();
    /** <code>repeated .RuleDropDownMaster ruleDropDownMaster = 9;</code> */
    com.cpdss.common.generated.Common.RuleDropDownMaster getRuleDropDownMaster(int index);
    /** <code>repeated .RuleDropDownMaster ruleDropDownMaster = 9;</code> */
    int getRuleDropDownMasterCount();
    /** <code>repeated .RuleDropDownMaster ruleDropDownMaster = 9;</code> */
    java.util.List<? extends com.cpdss.common.generated.Common.RuleDropDownMasterOrBuilder>
        getRuleDropDownMasterOrBuilderList();
    /** <code>repeated .RuleDropDownMaster ruleDropDownMaster = 9;</code> */
    com.cpdss.common.generated.Common.RuleDropDownMasterOrBuilder getRuleDropDownMasterOrBuilder(
        int index);

    /**
     * <code>bool isMandatory = 10;</code>
     *
     * @return The isMandatory.
     */
    boolean getIsMandatory();
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
      ruleDropDownMaster_ = java.util.Collections.emptyList();
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
            case 74:
              {
                if (!((mutable_bitField0_ & 0x00000001) != 0)) {
                  ruleDropDownMaster_ =
                      new java.util.ArrayList<
                          com.cpdss.common.generated.Common.RuleDropDownMaster>();
                  mutable_bitField0_ |= 0x00000001;
                }
                ruleDropDownMaster_.add(
                    input.readMessage(
                        com.cpdss.common.generated.Common.RuleDropDownMaster.parser(),
                        extensionRegistry));
                break;
              }
            case 80:
              {
                isMandatory_ = input.readBool();
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
          ruleDropDownMaster_ = java.util.Collections.unmodifiableList(ruleDropDownMaster_);
        }
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

    public static final int RULEDROPDOWNMASTER_FIELD_NUMBER = 9;
    private java.util.List<com.cpdss.common.generated.Common.RuleDropDownMaster>
        ruleDropDownMaster_;
    /** <code>repeated .RuleDropDownMaster ruleDropDownMaster = 9;</code> */
    public java.util.List<com.cpdss.common.generated.Common.RuleDropDownMaster>
        getRuleDropDownMasterList() {
      return ruleDropDownMaster_;
    }
    /** <code>repeated .RuleDropDownMaster ruleDropDownMaster = 9;</code> */
    public java.util.List<? extends com.cpdss.common.generated.Common.RuleDropDownMasterOrBuilder>
        getRuleDropDownMasterOrBuilderList() {
      return ruleDropDownMaster_;
    }
    /** <code>repeated .RuleDropDownMaster ruleDropDownMaster = 9;</code> */
    public int getRuleDropDownMasterCount() {
      return ruleDropDownMaster_.size();
    }
    /** <code>repeated .RuleDropDownMaster ruleDropDownMaster = 9;</code> */
    public com.cpdss.common.generated.Common.RuleDropDownMaster getRuleDropDownMaster(int index) {
      return ruleDropDownMaster_.get(index);
    }
    /** <code>repeated .RuleDropDownMaster ruleDropDownMaster = 9;</code> */
    public com.cpdss.common.generated.Common.RuleDropDownMasterOrBuilder
        getRuleDropDownMasterOrBuilder(int index) {
      return ruleDropDownMaster_.get(index);
    }

    public static final int ISMANDATORY_FIELD_NUMBER = 10;
    private boolean isMandatory_;
    /**
     * <code>bool isMandatory = 10;</code>
     *
     * @return The isMandatory.
     */
    public boolean getIsMandatory() {
      return isMandatory_;
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
      for (int i = 0; i < ruleDropDownMaster_.size(); i++) {
        output.writeMessage(9, ruleDropDownMaster_.get(i));
      }
      if (isMandatory_ != false) {
        output.writeBool(10, isMandatory_);
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
      for (int i = 0; i < ruleDropDownMaster_.size(); i++) {
        size +=
            com.google.protobuf.CodedOutputStream.computeMessageSize(9, ruleDropDownMaster_.get(i));
      }
      if (isMandatory_ != false) {
        size += com.google.protobuf.CodedOutputStream.computeBoolSize(10, isMandatory_);
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
      if (!getRuleDropDownMasterList().equals(other.getRuleDropDownMasterList())) return false;
      if (getIsMandatory() != other.getIsMandatory()) return false;
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
      if (getRuleDropDownMasterCount() > 0) {
        hash = (37 * hash) + RULEDROPDOWNMASTER_FIELD_NUMBER;
        hash = (53 * hash) + getRuleDropDownMasterList().hashCode();
      }
      hash = (37 * hash) + ISMANDATORY_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(getIsMandatory());
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
        if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {
          getRuleDropDownMasterFieldBuilder();
        }
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

        if (ruleDropDownMasterBuilder_ == null) {
          ruleDropDownMaster_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          ruleDropDownMasterBuilder_.clear();
        }
        isMandatory_ = false;

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
        int from_bitField0_ = bitField0_;
        result.prefix_ = prefix_;
        result.defaultValue_ = defaultValue_;
        result.type_ = type_;
        result.max_ = max_;
        result.min_ = min_;
        result.value_ = value_;
        result.suffix_ = suffix_;
        result.id_ = id_;
        if (ruleDropDownMasterBuilder_ == null) {
          if (((bitField0_ & 0x00000001) != 0)) {
            ruleDropDownMaster_ = java.util.Collections.unmodifiableList(ruleDropDownMaster_);
            bitField0_ = (bitField0_ & ~0x00000001);
          }
          result.ruleDropDownMaster_ = ruleDropDownMaster_;
        } else {
          result.ruleDropDownMaster_ = ruleDropDownMasterBuilder_.build();
        }
        result.isMandatory_ = isMandatory_;
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
        if (ruleDropDownMasterBuilder_ == null) {
          if (!other.ruleDropDownMaster_.isEmpty()) {
            if (ruleDropDownMaster_.isEmpty()) {
              ruleDropDownMaster_ = other.ruleDropDownMaster_;
              bitField0_ = (bitField0_ & ~0x00000001);
            } else {
              ensureRuleDropDownMasterIsMutable();
              ruleDropDownMaster_.addAll(other.ruleDropDownMaster_);
            }
            onChanged();
          }
        } else {
          if (!other.ruleDropDownMaster_.isEmpty()) {
            if (ruleDropDownMasterBuilder_.isEmpty()) {
              ruleDropDownMasterBuilder_.dispose();
              ruleDropDownMasterBuilder_ = null;
              ruleDropDownMaster_ = other.ruleDropDownMaster_;
              bitField0_ = (bitField0_ & ~0x00000001);
              ruleDropDownMasterBuilder_ =
                  com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
                      ? getRuleDropDownMasterFieldBuilder()
                      : null;
            } else {
              ruleDropDownMasterBuilder_.addAllMessages(other.ruleDropDownMaster_);
            }
          }
        }
        if (other.getIsMandatory() != false) {
          setIsMandatory(other.getIsMandatory());
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

      private int bitField0_;

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

      private java.util.List<com.cpdss.common.generated.Common.RuleDropDownMaster>
          ruleDropDownMaster_ = java.util.Collections.emptyList();

      private void ensureRuleDropDownMasterIsMutable() {
        if (!((bitField0_ & 0x00000001) != 0)) {
          ruleDropDownMaster_ =
              new java.util.ArrayList<com.cpdss.common.generated.Common.RuleDropDownMaster>(
                  ruleDropDownMaster_);
          bitField0_ |= 0x00000001;
        }
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
              com.cpdss.common.generated.Common.RuleDropDownMaster,
              com.cpdss.common.generated.Common.RuleDropDownMaster.Builder,
              com.cpdss.common.generated.Common.RuleDropDownMasterOrBuilder>
          ruleDropDownMasterBuilder_;

      /** <code>repeated .RuleDropDownMaster ruleDropDownMaster = 9;</code> */
      public java.util.List<com.cpdss.common.generated.Common.RuleDropDownMaster>
          getRuleDropDownMasterList() {
        if (ruleDropDownMasterBuilder_ == null) {
          return java.util.Collections.unmodifiableList(ruleDropDownMaster_);
        } else {
          return ruleDropDownMasterBuilder_.getMessageList();
        }
      }
      /** <code>repeated .RuleDropDownMaster ruleDropDownMaster = 9;</code> */
      public int getRuleDropDownMasterCount() {
        if (ruleDropDownMasterBuilder_ == null) {
          return ruleDropDownMaster_.size();
        } else {
          return ruleDropDownMasterBuilder_.getCount();
        }
      }
      /** <code>repeated .RuleDropDownMaster ruleDropDownMaster = 9;</code> */
      public com.cpdss.common.generated.Common.RuleDropDownMaster getRuleDropDownMaster(int index) {
        if (ruleDropDownMasterBuilder_ == null) {
          return ruleDropDownMaster_.get(index);
        } else {
          return ruleDropDownMasterBuilder_.getMessage(index);
        }
      }
      /** <code>repeated .RuleDropDownMaster ruleDropDownMaster = 9;</code> */
      public Builder setRuleDropDownMaster(
          int index, com.cpdss.common.generated.Common.RuleDropDownMaster value) {
        if (ruleDropDownMasterBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureRuleDropDownMasterIsMutable();
          ruleDropDownMaster_.set(index, value);
          onChanged();
        } else {
          ruleDropDownMasterBuilder_.setMessage(index, value);
        }
        return this;
      }
      /** <code>repeated .RuleDropDownMaster ruleDropDownMaster = 9;</code> */
      public Builder setRuleDropDownMaster(
          int index, com.cpdss.common.generated.Common.RuleDropDownMaster.Builder builderForValue) {
        if (ruleDropDownMasterBuilder_ == null) {
          ensureRuleDropDownMasterIsMutable();
          ruleDropDownMaster_.set(index, builderForValue.build());
          onChanged();
        } else {
          ruleDropDownMasterBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .RuleDropDownMaster ruleDropDownMaster = 9;</code> */
      public Builder addRuleDropDownMaster(
          com.cpdss.common.generated.Common.RuleDropDownMaster value) {
        if (ruleDropDownMasterBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureRuleDropDownMasterIsMutable();
          ruleDropDownMaster_.add(value);
          onChanged();
        } else {
          ruleDropDownMasterBuilder_.addMessage(value);
        }
        return this;
      }
      /** <code>repeated .RuleDropDownMaster ruleDropDownMaster = 9;</code> */
      public Builder addRuleDropDownMaster(
          int index, com.cpdss.common.generated.Common.RuleDropDownMaster value) {
        if (ruleDropDownMasterBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureRuleDropDownMasterIsMutable();
          ruleDropDownMaster_.add(index, value);
          onChanged();
        } else {
          ruleDropDownMasterBuilder_.addMessage(index, value);
        }
        return this;
      }
      /** <code>repeated .RuleDropDownMaster ruleDropDownMaster = 9;</code> */
      public Builder addRuleDropDownMaster(
          com.cpdss.common.generated.Common.RuleDropDownMaster.Builder builderForValue) {
        if (ruleDropDownMasterBuilder_ == null) {
          ensureRuleDropDownMasterIsMutable();
          ruleDropDownMaster_.add(builderForValue.build());
          onChanged();
        } else {
          ruleDropDownMasterBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .RuleDropDownMaster ruleDropDownMaster = 9;</code> */
      public Builder addRuleDropDownMaster(
          int index, com.cpdss.common.generated.Common.RuleDropDownMaster.Builder builderForValue) {
        if (ruleDropDownMasterBuilder_ == null) {
          ensureRuleDropDownMasterIsMutable();
          ruleDropDownMaster_.add(index, builderForValue.build());
          onChanged();
        } else {
          ruleDropDownMasterBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .RuleDropDownMaster ruleDropDownMaster = 9;</code> */
      public Builder addAllRuleDropDownMaster(
          java.lang.Iterable<? extends com.cpdss.common.generated.Common.RuleDropDownMaster>
              values) {
        if (ruleDropDownMasterBuilder_ == null) {
          ensureRuleDropDownMasterIsMutable();
          com.google.protobuf.AbstractMessageLite.Builder.addAll(values, ruleDropDownMaster_);
          onChanged();
        } else {
          ruleDropDownMasterBuilder_.addAllMessages(values);
        }
        return this;
      }
      /** <code>repeated .RuleDropDownMaster ruleDropDownMaster = 9;</code> */
      public Builder clearRuleDropDownMaster() {
        if (ruleDropDownMasterBuilder_ == null) {
          ruleDropDownMaster_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
          onChanged();
        } else {
          ruleDropDownMasterBuilder_.clear();
        }
        return this;
      }
      /** <code>repeated .RuleDropDownMaster ruleDropDownMaster = 9;</code> */
      public Builder removeRuleDropDownMaster(int index) {
        if (ruleDropDownMasterBuilder_ == null) {
          ensureRuleDropDownMasterIsMutable();
          ruleDropDownMaster_.remove(index);
          onChanged();
        } else {
          ruleDropDownMasterBuilder_.remove(index);
        }
        return this;
      }
      /** <code>repeated .RuleDropDownMaster ruleDropDownMaster = 9;</code> */
      public com.cpdss.common.generated.Common.RuleDropDownMaster.Builder
          getRuleDropDownMasterBuilder(int index) {
        return getRuleDropDownMasterFieldBuilder().getBuilder(index);
      }
      /** <code>repeated .RuleDropDownMaster ruleDropDownMaster = 9;</code> */
      public com.cpdss.common.generated.Common.RuleDropDownMasterOrBuilder
          getRuleDropDownMasterOrBuilder(int index) {
        if (ruleDropDownMasterBuilder_ == null) {
          return ruleDropDownMaster_.get(index);
        } else {
          return ruleDropDownMasterBuilder_.getMessageOrBuilder(index);
        }
      }
      /** <code>repeated .RuleDropDownMaster ruleDropDownMaster = 9;</code> */
      public java.util.List<? extends com.cpdss.common.generated.Common.RuleDropDownMasterOrBuilder>
          getRuleDropDownMasterOrBuilderList() {
        if (ruleDropDownMasterBuilder_ != null) {
          return ruleDropDownMasterBuilder_.getMessageOrBuilderList();
        } else {
          return java.util.Collections.unmodifiableList(ruleDropDownMaster_);
        }
      }
      /** <code>repeated .RuleDropDownMaster ruleDropDownMaster = 9;</code> */
      public com.cpdss.common.generated.Common.RuleDropDownMaster.Builder
          addRuleDropDownMasterBuilder() {
        return getRuleDropDownMasterFieldBuilder()
            .addBuilder(com.cpdss.common.generated.Common.RuleDropDownMaster.getDefaultInstance());
      }
      /** <code>repeated .RuleDropDownMaster ruleDropDownMaster = 9;</code> */
      public com.cpdss.common.generated.Common.RuleDropDownMaster.Builder
          addRuleDropDownMasterBuilder(int index) {
        return getRuleDropDownMasterFieldBuilder()
            .addBuilder(
                index, com.cpdss.common.generated.Common.RuleDropDownMaster.getDefaultInstance());
      }
      /** <code>repeated .RuleDropDownMaster ruleDropDownMaster = 9;</code> */
      public java.util.List<com.cpdss.common.generated.Common.RuleDropDownMaster.Builder>
          getRuleDropDownMasterBuilderList() {
        return getRuleDropDownMasterFieldBuilder().getBuilderList();
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
              com.cpdss.common.generated.Common.RuleDropDownMaster,
              com.cpdss.common.generated.Common.RuleDropDownMaster.Builder,
              com.cpdss.common.generated.Common.RuleDropDownMasterOrBuilder>
          getRuleDropDownMasterFieldBuilder() {
        if (ruleDropDownMasterBuilder_ == null) {
          ruleDropDownMasterBuilder_ =
              new com.google.protobuf.RepeatedFieldBuilderV3<
                  com.cpdss.common.generated.Common.RuleDropDownMaster,
                  com.cpdss.common.generated.Common.RuleDropDownMaster.Builder,
                  com.cpdss.common.generated.Common.RuleDropDownMasterOrBuilder>(
                  ruleDropDownMaster_,
                  ((bitField0_ & 0x00000001) != 0),
                  getParentForChildren(),
                  isClean());
          ruleDropDownMaster_ = null;
        }
        return ruleDropDownMasterBuilder_;
      }

      private boolean isMandatory_;
      /**
       * <code>bool isMandatory = 10;</code>
       *
       * @return The isMandatory.
       */
      public boolean getIsMandatory() {
        return isMandatory_;
      }
      /**
       * <code>bool isMandatory = 10;</code>
       *
       * @param value The isMandatory to set.
       * @return This builder for chaining.
       */
      public Builder setIsMandatory(boolean value) {

        isMandatory_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>bool isMandatory = 10;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearIsMandatory() {

        isMandatory_ = false;
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

  public interface RuleDropDownMasterOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:RuleDropDownMaster)
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
  /** Protobuf type {@code RuleDropDownMaster} */
  public static final class RuleDropDownMaster extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:RuleDropDownMaster)
      RuleDropDownMasterOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use RuleDropDownMaster.newBuilder() to construct.
    private RuleDropDownMaster(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private RuleDropDownMaster() {
      value_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new RuleDropDownMaster();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private RuleDropDownMaster(
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
      return com.cpdss.common.generated.Common.internal_static_RuleDropDownMaster_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.Common.internal_static_RuleDropDownMaster_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.Common.RuleDropDownMaster.class,
              com.cpdss.common.generated.Common.RuleDropDownMaster.Builder.class);
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
      if (!(obj instanceof com.cpdss.common.generated.Common.RuleDropDownMaster)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.Common.RuleDropDownMaster other =
          (com.cpdss.common.generated.Common.RuleDropDownMaster) obj;

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

    public static com.cpdss.common.generated.Common.RuleDropDownMaster parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Common.RuleDropDownMaster parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.RuleDropDownMaster parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Common.RuleDropDownMaster parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.RuleDropDownMaster parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Common.RuleDropDownMaster parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.RuleDropDownMaster parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Common.RuleDropDownMaster parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.RuleDropDownMaster parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Common.RuleDropDownMaster parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.RuleDropDownMaster parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Common.RuleDropDownMaster parseFrom(
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
        com.cpdss.common.generated.Common.RuleDropDownMaster prototype) {
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
    /** Protobuf type {@code RuleDropDownMaster} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:RuleDropDownMaster)
        com.cpdss.common.generated.Common.RuleDropDownMasterOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.Common.internal_static_RuleDropDownMaster_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.Common
            .internal_static_RuleDropDownMaster_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.Common.RuleDropDownMaster.class,
                com.cpdss.common.generated.Common.RuleDropDownMaster.Builder.class);
      }

      // Construct using com.cpdss.common.generated.Common.RuleDropDownMaster.newBuilder()
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
        return com.cpdss.common.generated.Common.internal_static_RuleDropDownMaster_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.Common.RuleDropDownMaster getDefaultInstanceForType() {
        return com.cpdss.common.generated.Common.RuleDropDownMaster.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.Common.RuleDropDownMaster build() {
        com.cpdss.common.generated.Common.RuleDropDownMaster result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.Common.RuleDropDownMaster buildPartial() {
        com.cpdss.common.generated.Common.RuleDropDownMaster result =
            new com.cpdss.common.generated.Common.RuleDropDownMaster(this);
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
        if (other instanceof com.cpdss.common.generated.Common.RuleDropDownMaster) {
          return mergeFrom((com.cpdss.common.generated.Common.RuleDropDownMaster) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.cpdss.common.generated.Common.RuleDropDownMaster other) {
        if (other == com.cpdss.common.generated.Common.RuleDropDownMaster.getDefaultInstance())
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
        com.cpdss.common.generated.Common.RuleDropDownMaster parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.Common.RuleDropDownMaster) e.getUnfinishedMessage();
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

      // @@protoc_insertion_point(builder_scope:RuleDropDownMaster)
    }

    // @@protoc_insertion_point(class_scope:RuleDropDownMaster)
    private static final com.cpdss.common.generated.Common.RuleDropDownMaster DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.Common.RuleDropDownMaster();
    }

    public static com.cpdss.common.generated.Common.RuleDropDownMaster getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<RuleDropDownMaster> PARSER =
        new com.google.protobuf.AbstractParser<RuleDropDownMaster>() {
          @java.lang.Override
          public RuleDropDownMaster parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new RuleDropDownMaster(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<RuleDropDownMaster> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<RuleDropDownMaster> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.Common.RuleDropDownMaster getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface CargoHistoryOpsRequestOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:CargoHistoryOpsRequest)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int64 voyageId = 1;</code>
     *
     * @return The voyageId.
     */
    long getVoyageId();

    /**
     * <code>int64 vesselId = 2;</code>
     *
     * @return The vesselId.
     */
    long getVesselId();
  }
  /**
   *
   *
   * <pre>
   * On voyage close get tank wise data
   * Ops means - operations modules - port wise data
   * </pre>
   *
   * Protobuf type {@code CargoHistoryOpsRequest}
   */
  public static final class CargoHistoryOpsRequest extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:CargoHistoryOpsRequest)
      CargoHistoryOpsRequestOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use CargoHistoryOpsRequest.newBuilder() to construct.
    private CargoHistoryOpsRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private CargoHistoryOpsRequest() {}

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new CargoHistoryOpsRequest();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private CargoHistoryOpsRequest(
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
            case 16:
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
      return com.cpdss.common.generated.Common.internal_static_CargoHistoryOpsRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.Common
          .internal_static_CargoHistoryOpsRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.Common.CargoHistoryOpsRequest.class,
              com.cpdss.common.generated.Common.CargoHistoryOpsRequest.Builder.class);
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
      if (vesselId_ != 0L) {
        output.writeInt64(2, vesselId_);
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
      if (vesselId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(2, vesselId_);
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
      if (!(obj instanceof com.cpdss.common.generated.Common.CargoHistoryOpsRequest)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.Common.CargoHistoryOpsRequest other =
          (com.cpdss.common.generated.Common.CargoHistoryOpsRequest) obj;

      if (getVoyageId() != other.getVoyageId()) return false;
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
      hash = (37 * hash) + VOYAGEID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getVoyageId());
      hash = (37 * hash) + VESSELID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getVesselId());
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.Common.CargoHistoryOpsRequest parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Common.CargoHistoryOpsRequest parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.CargoHistoryOpsRequest parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Common.CargoHistoryOpsRequest parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.CargoHistoryOpsRequest parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Common.CargoHistoryOpsRequest parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.CargoHistoryOpsRequest parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Common.CargoHistoryOpsRequest parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.CargoHistoryOpsRequest parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Common.CargoHistoryOpsRequest parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.CargoHistoryOpsRequest parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Common.CargoHistoryOpsRequest parseFrom(
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
        com.cpdss.common.generated.Common.CargoHistoryOpsRequest prototype) {
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
    /**
     *
     *
     * <pre>
     * On voyage close get tank wise data
     * Ops means - operations modules - port wise data
     * </pre>
     *
     * Protobuf type {@code CargoHistoryOpsRequest}
     */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:CargoHistoryOpsRequest)
        com.cpdss.common.generated.Common.CargoHistoryOpsRequestOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.Common.internal_static_CargoHistoryOpsRequest_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.Common
            .internal_static_CargoHistoryOpsRequest_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.Common.CargoHistoryOpsRequest.class,
                com.cpdss.common.generated.Common.CargoHistoryOpsRequest.Builder.class);
      }

      // Construct using com.cpdss.common.generated.Common.CargoHistoryOpsRequest.newBuilder()
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

        vesselId_ = 0L;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.Common.internal_static_CargoHistoryOpsRequest_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.Common.CargoHistoryOpsRequest getDefaultInstanceForType() {
        return com.cpdss.common.generated.Common.CargoHistoryOpsRequest.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.Common.CargoHistoryOpsRequest build() {
        com.cpdss.common.generated.Common.CargoHistoryOpsRequest result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.Common.CargoHistoryOpsRequest buildPartial() {
        com.cpdss.common.generated.Common.CargoHistoryOpsRequest result =
            new com.cpdss.common.generated.Common.CargoHistoryOpsRequest(this);
        result.voyageId_ = voyageId_;
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
        if (other instanceof com.cpdss.common.generated.Common.CargoHistoryOpsRequest) {
          return mergeFrom((com.cpdss.common.generated.Common.CargoHistoryOpsRequest) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.cpdss.common.generated.Common.CargoHistoryOpsRequest other) {
        if (other == com.cpdss.common.generated.Common.CargoHistoryOpsRequest.getDefaultInstance())
          return this;
        if (other.getVoyageId() != 0L) {
          setVoyageId(other.getVoyageId());
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
        com.cpdss.common.generated.Common.CargoHistoryOpsRequest parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.Common.CargoHistoryOpsRequest) e.getUnfinishedMessage();
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

      // @@protoc_insertion_point(builder_scope:CargoHistoryOpsRequest)
    }

    // @@protoc_insertion_point(class_scope:CargoHistoryOpsRequest)
    private static final com.cpdss.common.generated.Common.CargoHistoryOpsRequest DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.Common.CargoHistoryOpsRequest();
    }

    public static com.cpdss.common.generated.Common.CargoHistoryOpsRequest getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<CargoHistoryOpsRequest> PARSER =
        new com.google.protobuf.AbstractParser<CargoHistoryOpsRequest>() {
          @java.lang.Override
          public CargoHistoryOpsRequest parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new CargoHistoryOpsRequest(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<CargoHistoryOpsRequest> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<CargoHistoryOpsRequest> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.Common.CargoHistoryOpsRequest getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface CargoHistoryResponseOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:CargoHistoryResponse)
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

    /** <code>repeated .CargoHistoryOps cargoHistory = 2;</code> */
    java.util.List<com.cpdss.common.generated.Common.CargoHistoryOps> getCargoHistoryList();
    /** <code>repeated .CargoHistoryOps cargoHistory = 2;</code> */
    com.cpdss.common.generated.Common.CargoHistoryOps getCargoHistory(int index);
    /** <code>repeated .CargoHistoryOps cargoHistory = 2;</code> */
    int getCargoHistoryCount();
    /** <code>repeated .CargoHistoryOps cargoHistory = 2;</code> */
    java.util.List<? extends com.cpdss.common.generated.Common.CargoHistoryOpsOrBuilder>
        getCargoHistoryOrBuilderList();
    /** <code>repeated .CargoHistoryOps cargoHistory = 2;</code> */
    com.cpdss.common.generated.Common.CargoHistoryOpsOrBuilder getCargoHistoryOrBuilder(int index);
  }
  /** Protobuf type {@code CargoHistoryResponse} */
  public static final class CargoHistoryResponse extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:CargoHistoryResponse)
      CargoHistoryResponseOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use CargoHistoryResponse.newBuilder() to construct.
    private CargoHistoryResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private CargoHistoryResponse() {
      cargoHistory_ = java.util.Collections.emptyList();
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new CargoHistoryResponse();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private CargoHistoryResponse(
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
                  cargoHistory_ =
                      new java.util.ArrayList<com.cpdss.common.generated.Common.CargoHistoryOps>();
                  mutable_bitField0_ |= 0x00000001;
                }
                cargoHistory_.add(
                    input.readMessage(
                        com.cpdss.common.generated.Common.CargoHistoryOps.parser(),
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
          cargoHistory_ = java.util.Collections.unmodifiableList(cargoHistory_);
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }

    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.cpdss.common.generated.Common.internal_static_CargoHistoryResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.Common
          .internal_static_CargoHistoryResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.Common.CargoHistoryResponse.class,
              com.cpdss.common.generated.Common.CargoHistoryResponse.Builder.class);
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

    public static final int CARGOHISTORY_FIELD_NUMBER = 2;
    private java.util.List<com.cpdss.common.generated.Common.CargoHistoryOps> cargoHistory_;
    /** <code>repeated .CargoHistoryOps cargoHistory = 2;</code> */
    public java.util.List<com.cpdss.common.generated.Common.CargoHistoryOps> getCargoHistoryList() {
      return cargoHistory_;
    }
    /** <code>repeated .CargoHistoryOps cargoHistory = 2;</code> */
    public java.util.List<? extends com.cpdss.common.generated.Common.CargoHistoryOpsOrBuilder>
        getCargoHistoryOrBuilderList() {
      return cargoHistory_;
    }
    /** <code>repeated .CargoHistoryOps cargoHistory = 2;</code> */
    public int getCargoHistoryCount() {
      return cargoHistory_.size();
    }
    /** <code>repeated .CargoHistoryOps cargoHistory = 2;</code> */
    public com.cpdss.common.generated.Common.CargoHistoryOps getCargoHistory(int index) {
      return cargoHistory_.get(index);
    }
    /** <code>repeated .CargoHistoryOps cargoHistory = 2;</code> */
    public com.cpdss.common.generated.Common.CargoHistoryOpsOrBuilder getCargoHistoryOrBuilder(
        int index) {
      return cargoHistory_.get(index);
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
      for (int i = 0; i < cargoHistory_.size(); i++) {
        output.writeMessage(2, cargoHistory_.get(i));
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
      for (int i = 0; i < cargoHistory_.size(); i++) {
        size += com.google.protobuf.CodedOutputStream.computeMessageSize(2, cargoHistory_.get(i));
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
      if (!(obj instanceof com.cpdss.common.generated.Common.CargoHistoryResponse)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.Common.CargoHistoryResponse other =
          (com.cpdss.common.generated.Common.CargoHistoryResponse) obj;

      if (hasResponseStatus() != other.hasResponseStatus()) return false;
      if (hasResponseStatus()) {
        if (!getResponseStatus().equals(other.getResponseStatus())) return false;
      }
      if (!getCargoHistoryList().equals(other.getCargoHistoryList())) return false;
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
      if (getCargoHistoryCount() > 0) {
        hash = (37 * hash) + CARGOHISTORY_FIELD_NUMBER;
        hash = (53 * hash) + getCargoHistoryList().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.Common.CargoHistoryResponse parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Common.CargoHistoryResponse parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.CargoHistoryResponse parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Common.CargoHistoryResponse parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.CargoHistoryResponse parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Common.CargoHistoryResponse parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.CargoHistoryResponse parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Common.CargoHistoryResponse parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.CargoHistoryResponse parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Common.CargoHistoryResponse parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.CargoHistoryResponse parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Common.CargoHistoryResponse parseFrom(
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
        com.cpdss.common.generated.Common.CargoHistoryResponse prototype) {
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
    /** Protobuf type {@code CargoHistoryResponse} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:CargoHistoryResponse)
        com.cpdss.common.generated.Common.CargoHistoryResponseOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.Common.internal_static_CargoHistoryResponse_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.Common
            .internal_static_CargoHistoryResponse_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.Common.CargoHistoryResponse.class,
                com.cpdss.common.generated.Common.CargoHistoryResponse.Builder.class);
      }

      // Construct using com.cpdss.common.generated.Common.CargoHistoryResponse.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {
          getCargoHistoryFieldBuilder();
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
        if (cargoHistoryBuilder_ == null) {
          cargoHistory_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          cargoHistoryBuilder_.clear();
        }
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.Common.internal_static_CargoHistoryResponse_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.Common.CargoHistoryResponse getDefaultInstanceForType() {
        return com.cpdss.common.generated.Common.CargoHistoryResponse.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.Common.CargoHistoryResponse build() {
        com.cpdss.common.generated.Common.CargoHistoryResponse result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.Common.CargoHistoryResponse buildPartial() {
        com.cpdss.common.generated.Common.CargoHistoryResponse result =
            new com.cpdss.common.generated.Common.CargoHistoryResponse(this);
        int from_bitField0_ = bitField0_;
        if (responseStatusBuilder_ == null) {
          result.responseStatus_ = responseStatus_;
        } else {
          result.responseStatus_ = responseStatusBuilder_.build();
        }
        if (cargoHistoryBuilder_ == null) {
          if (((bitField0_ & 0x00000001) != 0)) {
            cargoHistory_ = java.util.Collections.unmodifiableList(cargoHistory_);
            bitField0_ = (bitField0_ & ~0x00000001);
          }
          result.cargoHistory_ = cargoHistory_;
        } else {
          result.cargoHistory_ = cargoHistoryBuilder_.build();
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
        if (other instanceof com.cpdss.common.generated.Common.CargoHistoryResponse) {
          return mergeFrom((com.cpdss.common.generated.Common.CargoHistoryResponse) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.cpdss.common.generated.Common.CargoHistoryResponse other) {
        if (other == com.cpdss.common.generated.Common.CargoHistoryResponse.getDefaultInstance())
          return this;
        if (other.hasResponseStatus()) {
          mergeResponseStatus(other.getResponseStatus());
        }
        if (cargoHistoryBuilder_ == null) {
          if (!other.cargoHistory_.isEmpty()) {
            if (cargoHistory_.isEmpty()) {
              cargoHistory_ = other.cargoHistory_;
              bitField0_ = (bitField0_ & ~0x00000001);
            } else {
              ensureCargoHistoryIsMutable();
              cargoHistory_.addAll(other.cargoHistory_);
            }
            onChanged();
          }
        } else {
          if (!other.cargoHistory_.isEmpty()) {
            if (cargoHistoryBuilder_.isEmpty()) {
              cargoHistoryBuilder_.dispose();
              cargoHistoryBuilder_ = null;
              cargoHistory_ = other.cargoHistory_;
              bitField0_ = (bitField0_ & ~0x00000001);
              cargoHistoryBuilder_ =
                  com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
                      ? getCargoHistoryFieldBuilder()
                      : null;
            } else {
              cargoHistoryBuilder_.addAllMessages(other.cargoHistory_);
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
        com.cpdss.common.generated.Common.CargoHistoryResponse parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.Common.CargoHistoryResponse) e.getUnfinishedMessage();
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

      private java.util.List<com.cpdss.common.generated.Common.CargoHistoryOps> cargoHistory_ =
          java.util.Collections.emptyList();

      private void ensureCargoHistoryIsMutable() {
        if (!((bitField0_ & 0x00000001) != 0)) {
          cargoHistory_ =
              new java.util.ArrayList<com.cpdss.common.generated.Common.CargoHistoryOps>(
                  cargoHistory_);
          bitField0_ |= 0x00000001;
        }
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
              com.cpdss.common.generated.Common.CargoHistoryOps,
              com.cpdss.common.generated.Common.CargoHistoryOps.Builder,
              com.cpdss.common.generated.Common.CargoHistoryOpsOrBuilder>
          cargoHistoryBuilder_;

      /** <code>repeated .CargoHistoryOps cargoHistory = 2;</code> */
      public java.util.List<com.cpdss.common.generated.Common.CargoHistoryOps>
          getCargoHistoryList() {
        if (cargoHistoryBuilder_ == null) {
          return java.util.Collections.unmodifiableList(cargoHistory_);
        } else {
          return cargoHistoryBuilder_.getMessageList();
        }
      }
      /** <code>repeated .CargoHistoryOps cargoHistory = 2;</code> */
      public int getCargoHistoryCount() {
        if (cargoHistoryBuilder_ == null) {
          return cargoHistory_.size();
        } else {
          return cargoHistoryBuilder_.getCount();
        }
      }
      /** <code>repeated .CargoHistoryOps cargoHistory = 2;</code> */
      public com.cpdss.common.generated.Common.CargoHistoryOps getCargoHistory(int index) {
        if (cargoHistoryBuilder_ == null) {
          return cargoHistory_.get(index);
        } else {
          return cargoHistoryBuilder_.getMessage(index);
        }
      }
      /** <code>repeated .CargoHistoryOps cargoHistory = 2;</code> */
      public Builder setCargoHistory(
          int index, com.cpdss.common.generated.Common.CargoHistoryOps value) {
        if (cargoHistoryBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureCargoHistoryIsMutable();
          cargoHistory_.set(index, value);
          onChanged();
        } else {
          cargoHistoryBuilder_.setMessage(index, value);
        }
        return this;
      }
      /** <code>repeated .CargoHistoryOps cargoHistory = 2;</code> */
      public Builder setCargoHistory(
          int index, com.cpdss.common.generated.Common.CargoHistoryOps.Builder builderForValue) {
        if (cargoHistoryBuilder_ == null) {
          ensureCargoHistoryIsMutable();
          cargoHistory_.set(index, builderForValue.build());
          onChanged();
        } else {
          cargoHistoryBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .CargoHistoryOps cargoHistory = 2;</code> */
      public Builder addCargoHistory(com.cpdss.common.generated.Common.CargoHistoryOps value) {
        if (cargoHistoryBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureCargoHistoryIsMutable();
          cargoHistory_.add(value);
          onChanged();
        } else {
          cargoHistoryBuilder_.addMessage(value);
        }
        return this;
      }
      /** <code>repeated .CargoHistoryOps cargoHistory = 2;</code> */
      public Builder addCargoHistory(
          int index, com.cpdss.common.generated.Common.CargoHistoryOps value) {
        if (cargoHistoryBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureCargoHistoryIsMutable();
          cargoHistory_.add(index, value);
          onChanged();
        } else {
          cargoHistoryBuilder_.addMessage(index, value);
        }
        return this;
      }
      /** <code>repeated .CargoHistoryOps cargoHistory = 2;</code> */
      public Builder addCargoHistory(
          com.cpdss.common.generated.Common.CargoHistoryOps.Builder builderForValue) {
        if (cargoHistoryBuilder_ == null) {
          ensureCargoHistoryIsMutable();
          cargoHistory_.add(builderForValue.build());
          onChanged();
        } else {
          cargoHistoryBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .CargoHistoryOps cargoHistory = 2;</code> */
      public Builder addCargoHistory(
          int index, com.cpdss.common.generated.Common.CargoHistoryOps.Builder builderForValue) {
        if (cargoHistoryBuilder_ == null) {
          ensureCargoHistoryIsMutable();
          cargoHistory_.add(index, builderForValue.build());
          onChanged();
        } else {
          cargoHistoryBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      /** <code>repeated .CargoHistoryOps cargoHistory = 2;</code> */
      public Builder addAllCargoHistory(
          java.lang.Iterable<? extends com.cpdss.common.generated.Common.CargoHistoryOps> values) {
        if (cargoHistoryBuilder_ == null) {
          ensureCargoHistoryIsMutable();
          com.google.protobuf.AbstractMessageLite.Builder.addAll(values, cargoHistory_);
          onChanged();
        } else {
          cargoHistoryBuilder_.addAllMessages(values);
        }
        return this;
      }
      /** <code>repeated .CargoHistoryOps cargoHistory = 2;</code> */
      public Builder clearCargoHistory() {
        if (cargoHistoryBuilder_ == null) {
          cargoHistory_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
          onChanged();
        } else {
          cargoHistoryBuilder_.clear();
        }
        return this;
      }
      /** <code>repeated .CargoHistoryOps cargoHistory = 2;</code> */
      public Builder removeCargoHistory(int index) {
        if (cargoHistoryBuilder_ == null) {
          ensureCargoHistoryIsMutable();
          cargoHistory_.remove(index);
          onChanged();
        } else {
          cargoHistoryBuilder_.remove(index);
        }
        return this;
      }
      /** <code>repeated .CargoHistoryOps cargoHistory = 2;</code> */
      public com.cpdss.common.generated.Common.CargoHistoryOps.Builder getCargoHistoryBuilder(
          int index) {
        return getCargoHistoryFieldBuilder().getBuilder(index);
      }
      /** <code>repeated .CargoHistoryOps cargoHistory = 2;</code> */
      public com.cpdss.common.generated.Common.CargoHistoryOpsOrBuilder getCargoHistoryOrBuilder(
          int index) {
        if (cargoHistoryBuilder_ == null) {
          return cargoHistory_.get(index);
        } else {
          return cargoHistoryBuilder_.getMessageOrBuilder(index);
        }
      }
      /** <code>repeated .CargoHistoryOps cargoHistory = 2;</code> */
      public java.util.List<? extends com.cpdss.common.generated.Common.CargoHistoryOpsOrBuilder>
          getCargoHistoryOrBuilderList() {
        if (cargoHistoryBuilder_ != null) {
          return cargoHistoryBuilder_.getMessageOrBuilderList();
        } else {
          return java.util.Collections.unmodifiableList(cargoHistory_);
        }
      }
      /** <code>repeated .CargoHistoryOps cargoHistory = 2;</code> */
      public com.cpdss.common.generated.Common.CargoHistoryOps.Builder addCargoHistoryBuilder() {
        return getCargoHistoryFieldBuilder()
            .addBuilder(com.cpdss.common.generated.Common.CargoHistoryOps.getDefaultInstance());
      }
      /** <code>repeated .CargoHistoryOps cargoHistory = 2;</code> */
      public com.cpdss.common.generated.Common.CargoHistoryOps.Builder addCargoHistoryBuilder(
          int index) {
        return getCargoHistoryFieldBuilder()
            .addBuilder(
                index, com.cpdss.common.generated.Common.CargoHistoryOps.getDefaultInstance());
      }
      /** <code>repeated .CargoHistoryOps cargoHistory = 2;</code> */
      public java.util.List<com.cpdss.common.generated.Common.CargoHistoryOps.Builder>
          getCargoHistoryBuilderList() {
        return getCargoHistoryFieldBuilder().getBuilderList();
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
              com.cpdss.common.generated.Common.CargoHistoryOps,
              com.cpdss.common.generated.Common.CargoHistoryOps.Builder,
              com.cpdss.common.generated.Common.CargoHistoryOpsOrBuilder>
          getCargoHistoryFieldBuilder() {
        if (cargoHistoryBuilder_ == null) {
          cargoHistoryBuilder_ =
              new com.google.protobuf.RepeatedFieldBuilderV3<
                  com.cpdss.common.generated.Common.CargoHistoryOps,
                  com.cpdss.common.generated.Common.CargoHistoryOps.Builder,
                  com.cpdss.common.generated.Common.CargoHistoryOpsOrBuilder>(
                  cargoHistory_,
                  ((bitField0_ & 0x00000001) != 0),
                  getParentForChildren(),
                  isClean());
          cargoHistory_ = null;
        }
        return cargoHistoryBuilder_;
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

      // @@protoc_insertion_point(builder_scope:CargoHistoryResponse)
    }

    // @@protoc_insertion_point(class_scope:CargoHistoryResponse)
    private static final com.cpdss.common.generated.Common.CargoHistoryResponse DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.Common.CargoHistoryResponse();
    }

    public static com.cpdss.common.generated.Common.CargoHistoryResponse getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<CargoHistoryResponse> PARSER =
        new com.google.protobuf.AbstractParser<CargoHistoryResponse>() {
          @java.lang.Override
          public CargoHistoryResponse parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new CargoHistoryResponse(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<CargoHistoryResponse> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<CargoHistoryResponse> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.Common.CargoHistoryResponse getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface CargoHistoryOpsOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:CargoHistoryOps)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int64 tankId = 1;</code>
     *
     * @return The tankId.
     */
    long getTankId();

    /**
     * <code>string api = 2;</code>
     *
     * @return The api.
     */
    java.lang.String getApi();
    /**
     * <code>string api = 2;</code>
     *
     * @return The bytes for api.
     */
    com.google.protobuf.ByteString getApiBytes();

    /**
     * <code>string temperature = 3;</code>
     *
     * @return The temperature.
     */
    java.lang.String getTemperature();
    /**
     * <code>string temperature = 3;</code>
     *
     * @return The bytes for temperature.
     */
    com.google.protobuf.ByteString getTemperatureBytes();

    /**
     * <code>int64 cargoNominationId = 4;</code>
     *
     * @return The cargoNominationId.
     */
    long getCargoNominationId();

    /**
     *
     *
     * <pre>
     * nullable
     * </pre>
     *
     * <code>int64 cargoId = 5;</code>
     *
     * @return The cargoId.
     */
    long getCargoId();

    /**
     * <code>int64 portId = 6;</code>
     *
     * @return The portId.
     */
    long getPortId();

    /**
     * <code>string quantity = 7;</code>
     *
     * @return The quantity.
     */
    java.lang.String getQuantity();
    /**
     * <code>string quantity = 7;</code>
     *
     * @return The bytes for quantity.
     */
    com.google.protobuf.ByteString getQuantityBytes();

    /**
     * <code>string updateDate = 8;</code>
     *
     * @return The updateDate.
     */
    java.lang.String getUpdateDate();
    /**
     * <code>string updateDate = 8;</code>
     *
     * @return The bytes for updateDate.
     */
    com.google.protobuf.ByteString getUpdateDateBytes();

    /**
     * <code>int64 portRotationId = 9;</code>
     *
     * @return The portRotationId.
     */
    long getPortRotationId();
  }
  /** Protobuf type {@code CargoHistoryOps} */
  public static final class CargoHistoryOps extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:CargoHistoryOps)
      CargoHistoryOpsOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use CargoHistoryOps.newBuilder() to construct.
    private CargoHistoryOps(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private CargoHistoryOps() {
      api_ = "";
      temperature_ = "";
      quantity_ = "";
      updateDate_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new CargoHistoryOps();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private CargoHistoryOps(
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
                tankId_ = input.readInt64();
                break;
              }
            case 18:
              {
                java.lang.String s = input.readStringRequireUtf8();

                api_ = s;
                break;
              }
            case 26:
              {
                java.lang.String s = input.readStringRequireUtf8();

                temperature_ = s;
                break;
              }
            case 32:
              {
                cargoNominationId_ = input.readInt64();
                break;
              }
            case 40:
              {
                cargoId_ = input.readInt64();
                break;
              }
            case 48:
              {
                portId_ = input.readInt64();
                break;
              }
            case 58:
              {
                java.lang.String s = input.readStringRequireUtf8();

                quantity_ = s;
                break;
              }
            case 66:
              {
                java.lang.String s = input.readStringRequireUtf8();

                updateDate_ = s;
                break;
              }
            case 72:
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
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }

    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.cpdss.common.generated.Common.internal_static_CargoHistoryOps_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.Common.internal_static_CargoHistoryOps_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.Common.CargoHistoryOps.class,
              com.cpdss.common.generated.Common.CargoHistoryOps.Builder.class);
    }

    public static final int TANKID_FIELD_NUMBER = 1;
    private long tankId_;
    /**
     * <code>int64 tankId = 1;</code>
     *
     * @return The tankId.
     */
    public long getTankId() {
      return tankId_;
    }

    public static final int API_FIELD_NUMBER = 2;
    private volatile java.lang.Object api_;
    /**
     * <code>string api = 2;</code>
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
     * <code>string api = 2;</code>
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

    public static final int TEMPERATURE_FIELD_NUMBER = 3;
    private volatile java.lang.Object temperature_;
    /**
     * <code>string temperature = 3;</code>
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
     * <code>string temperature = 3;</code>
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

    public static final int CARGONOMINATIONID_FIELD_NUMBER = 4;
    private long cargoNominationId_;
    /**
     * <code>int64 cargoNominationId = 4;</code>
     *
     * @return The cargoNominationId.
     */
    public long getCargoNominationId() {
      return cargoNominationId_;
    }

    public static final int CARGOID_FIELD_NUMBER = 5;
    private long cargoId_;
    /**
     *
     *
     * <pre>
     * nullable
     * </pre>
     *
     * <code>int64 cargoId = 5;</code>
     *
     * @return The cargoId.
     */
    public long getCargoId() {
      return cargoId_;
    }

    public static final int PORTID_FIELD_NUMBER = 6;
    private long portId_;
    /**
     * <code>int64 portId = 6;</code>
     *
     * @return The portId.
     */
    public long getPortId() {
      return portId_;
    }

    public static final int QUANTITY_FIELD_NUMBER = 7;
    private volatile java.lang.Object quantity_;
    /**
     * <code>string quantity = 7;</code>
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
     * <code>string quantity = 7;</code>
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

    public static final int UPDATEDATE_FIELD_NUMBER = 8;
    private volatile java.lang.Object updateDate_;
    /**
     * <code>string updateDate = 8;</code>
     *
     * @return The updateDate.
     */
    public java.lang.String getUpdateDate() {
      java.lang.Object ref = updateDate_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        updateDate_ = s;
        return s;
      }
    }
    /**
     * <code>string updateDate = 8;</code>
     *
     * @return The bytes for updateDate.
     */
    public com.google.protobuf.ByteString getUpdateDateBytes() {
      java.lang.Object ref = updateDate_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        updateDate_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int PORTROTATIONID_FIELD_NUMBER = 9;
    private long portRotationId_;
    /**
     * <code>int64 portRotationId = 9;</code>
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
      if (tankId_ != 0L) {
        output.writeInt64(1, tankId_);
      }
      if (!getApiBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, api_);
      }
      if (!getTemperatureBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, temperature_);
      }
      if (cargoNominationId_ != 0L) {
        output.writeInt64(4, cargoNominationId_);
      }
      if (cargoId_ != 0L) {
        output.writeInt64(5, cargoId_);
      }
      if (portId_ != 0L) {
        output.writeInt64(6, portId_);
      }
      if (!getQuantityBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 7, quantity_);
      }
      if (!getUpdateDateBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 8, updateDate_);
      }
      if (portRotationId_ != 0L) {
        output.writeInt64(9, portRotationId_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (tankId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(1, tankId_);
      }
      if (!getApiBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, api_);
      }
      if (!getTemperatureBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, temperature_);
      }
      if (cargoNominationId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(4, cargoNominationId_);
      }
      if (cargoId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(5, cargoId_);
      }
      if (portId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(6, portId_);
      }
      if (!getQuantityBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(7, quantity_);
      }
      if (!getUpdateDateBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(8, updateDate_);
      }
      if (portRotationId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(9, portRotationId_);
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
      if (!(obj instanceof com.cpdss.common.generated.Common.CargoHistoryOps)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.Common.CargoHistoryOps other =
          (com.cpdss.common.generated.Common.CargoHistoryOps) obj;

      if (getTankId() != other.getTankId()) return false;
      if (!getApi().equals(other.getApi())) return false;
      if (!getTemperature().equals(other.getTemperature())) return false;
      if (getCargoNominationId() != other.getCargoNominationId()) return false;
      if (getCargoId() != other.getCargoId()) return false;
      if (getPortId() != other.getPortId()) return false;
      if (!getQuantity().equals(other.getQuantity())) return false;
      if (!getUpdateDate().equals(other.getUpdateDate())) return false;
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
      hash = (37 * hash) + TANKID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getTankId());
      hash = (37 * hash) + API_FIELD_NUMBER;
      hash = (53 * hash) + getApi().hashCode();
      hash = (37 * hash) + TEMPERATURE_FIELD_NUMBER;
      hash = (53 * hash) + getTemperature().hashCode();
      hash = (37 * hash) + CARGONOMINATIONID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getCargoNominationId());
      hash = (37 * hash) + CARGOID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getCargoId());
      hash = (37 * hash) + PORTID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getPortId());
      hash = (37 * hash) + QUANTITY_FIELD_NUMBER;
      hash = (53 * hash) + getQuantity().hashCode();
      hash = (37 * hash) + UPDATEDATE_FIELD_NUMBER;
      hash = (53 * hash) + getUpdateDate().hashCode();
      hash = (37 * hash) + PORTROTATIONID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getPortRotationId());
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.Common.CargoHistoryOps parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Common.CargoHistoryOps parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.CargoHistoryOps parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Common.CargoHistoryOps parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.CargoHistoryOps parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Common.CargoHistoryOps parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.CargoHistoryOps parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Common.CargoHistoryOps parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.CargoHistoryOps parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Common.CargoHistoryOps parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.CargoHistoryOps parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Common.CargoHistoryOps parseFrom(
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

    public static Builder newBuilder(com.cpdss.common.generated.Common.CargoHistoryOps prototype) {
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
    /** Protobuf type {@code CargoHistoryOps} */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:CargoHistoryOps)
        com.cpdss.common.generated.Common.CargoHistoryOpsOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.Common.internal_static_CargoHistoryOps_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.Common.internal_static_CargoHistoryOps_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.Common.CargoHistoryOps.class,
                com.cpdss.common.generated.Common.CargoHistoryOps.Builder.class);
      }

      // Construct using com.cpdss.common.generated.Common.CargoHistoryOps.newBuilder()
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
        tankId_ = 0L;

        api_ = "";

        temperature_ = "";

        cargoNominationId_ = 0L;

        cargoId_ = 0L;

        portId_ = 0L;

        quantity_ = "";

        updateDate_ = "";

        portRotationId_ = 0L;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.Common.internal_static_CargoHistoryOps_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.Common.CargoHistoryOps getDefaultInstanceForType() {
        return com.cpdss.common.generated.Common.CargoHistoryOps.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.Common.CargoHistoryOps build() {
        com.cpdss.common.generated.Common.CargoHistoryOps result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.Common.CargoHistoryOps buildPartial() {
        com.cpdss.common.generated.Common.CargoHistoryOps result =
            new com.cpdss.common.generated.Common.CargoHistoryOps(this);
        result.tankId_ = tankId_;
        result.api_ = api_;
        result.temperature_ = temperature_;
        result.cargoNominationId_ = cargoNominationId_;
        result.cargoId_ = cargoId_;
        result.portId_ = portId_;
        result.quantity_ = quantity_;
        result.updateDate_ = updateDate_;
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
        if (other instanceof com.cpdss.common.generated.Common.CargoHistoryOps) {
          return mergeFrom((com.cpdss.common.generated.Common.CargoHistoryOps) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.cpdss.common.generated.Common.CargoHistoryOps other) {
        if (other == com.cpdss.common.generated.Common.CargoHistoryOps.getDefaultInstance())
          return this;
        if (other.getTankId() != 0L) {
          setTankId(other.getTankId());
        }
        if (!other.getApi().isEmpty()) {
          api_ = other.api_;
          onChanged();
        }
        if (!other.getTemperature().isEmpty()) {
          temperature_ = other.temperature_;
          onChanged();
        }
        if (other.getCargoNominationId() != 0L) {
          setCargoNominationId(other.getCargoNominationId());
        }
        if (other.getCargoId() != 0L) {
          setCargoId(other.getCargoId());
        }
        if (other.getPortId() != 0L) {
          setPortId(other.getPortId());
        }
        if (!other.getQuantity().isEmpty()) {
          quantity_ = other.quantity_;
          onChanged();
        }
        if (!other.getUpdateDate().isEmpty()) {
          updateDate_ = other.updateDate_;
          onChanged();
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
        com.cpdss.common.generated.Common.CargoHistoryOps parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.Common.CargoHistoryOps) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private long tankId_;
      /**
       * <code>int64 tankId = 1;</code>
       *
       * @return The tankId.
       */
      public long getTankId() {
        return tankId_;
      }
      /**
       * <code>int64 tankId = 1;</code>
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
       * <code>int64 tankId = 1;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearTankId() {

        tankId_ = 0L;
        onChanged();
        return this;
      }

      private java.lang.Object api_ = "";
      /**
       * <code>string api = 2;</code>
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
       * <code>string api = 2;</code>
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
       * <code>string api = 2;</code>
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
       * <code>string api = 2;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearApi() {

        api_ = getDefaultInstance().getApi();
        onChanged();
        return this;
      }
      /**
       * <code>string api = 2;</code>
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
       * <code>string temperature = 3;</code>
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
       * <code>string temperature = 3;</code>
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
       * <code>string temperature = 3;</code>
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
       * <code>string temperature = 3;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearTemperature() {

        temperature_ = getDefaultInstance().getTemperature();
        onChanged();
        return this;
      }
      /**
       * <code>string temperature = 3;</code>
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

      private long cargoNominationId_;
      /**
       * <code>int64 cargoNominationId = 4;</code>
       *
       * @return The cargoNominationId.
       */
      public long getCargoNominationId() {
        return cargoNominationId_;
      }
      /**
       * <code>int64 cargoNominationId = 4;</code>
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
       * <code>int64 cargoNominationId = 4;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearCargoNominationId() {

        cargoNominationId_ = 0L;
        onChanged();
        return this;
      }

      private long cargoId_;
      /**
       *
       *
       * <pre>
       * nullable
       * </pre>
       *
       * <code>int64 cargoId = 5;</code>
       *
       * @return The cargoId.
       */
      public long getCargoId() {
        return cargoId_;
      }
      /**
       *
       *
       * <pre>
       * nullable
       * </pre>
       *
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
       *
       *
       * <pre>
       * nullable
       * </pre>
       *
       * <code>int64 cargoId = 5;</code>
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
       * <code>int64 portId = 6;</code>
       *
       * @return The portId.
       */
      public long getPortId() {
        return portId_;
      }
      /**
       * <code>int64 portId = 6;</code>
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
       * <code>int64 portId = 6;</code>
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
       * <code>string quantity = 7;</code>
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
       * <code>string quantity = 7;</code>
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
       * <code>string quantity = 7;</code>
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
       * <code>string quantity = 7;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearQuantity() {

        quantity_ = getDefaultInstance().getQuantity();
        onChanged();
        return this;
      }
      /**
       * <code>string quantity = 7;</code>
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

      private java.lang.Object updateDate_ = "";
      /**
       * <code>string updateDate = 8;</code>
       *
       * @return The updateDate.
       */
      public java.lang.String getUpdateDate() {
        java.lang.Object ref = updateDate_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          updateDate_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string updateDate = 8;</code>
       *
       * @return The bytes for updateDate.
       */
      public com.google.protobuf.ByteString getUpdateDateBytes() {
        java.lang.Object ref = updateDate_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          updateDate_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string updateDate = 8;</code>
       *
       * @param value The updateDate to set.
       * @return This builder for chaining.
       */
      public Builder setUpdateDate(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        updateDate_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string updateDate = 8;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearUpdateDate() {

        updateDate_ = getDefaultInstance().getUpdateDate();
        onChanged();
        return this;
      }
      /**
       * <code>string updateDate = 8;</code>
       *
       * @param value The bytes for updateDate to set.
       * @return This builder for chaining.
       */
      public Builder setUpdateDateBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        updateDate_ = value;
        onChanged();
        return this;
      }

      private long portRotationId_;
      /**
       * <code>int64 portRotationId = 9;</code>
       *
       * @return The portRotationId.
       */
      public long getPortRotationId() {
        return portRotationId_;
      }
      /**
       * <code>int64 portRotationId = 9;</code>
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
       * <code>int64 portRotationId = 9;</code>
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

      // @@protoc_insertion_point(builder_scope:CargoHistoryOps)
    }

    // @@protoc_insertion_point(class_scope:CargoHistoryOps)
    private static final com.cpdss.common.generated.Common.CargoHistoryOps DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.Common.CargoHistoryOps();
    }

    public static com.cpdss.common.generated.Common.CargoHistoryOps getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<CargoHistoryOps> PARSER =
        new com.google.protobuf.AbstractParser<CargoHistoryOps>() {
          @java.lang.Override
          public CargoHistoryOps parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new CargoHistoryOps(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<CargoHistoryOps> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<CargoHistoryOps> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.Common.CargoHistoryOps getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface CommunicationDataGetRequestOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:CommunicationDataGetRequest)
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

    /**
     * <code>string tableName = 2;</code>
     *
     * @return The tableName.
     */
    java.lang.String getTableName();
    /**
     * <code>string tableName = 2;</code>
     *
     * @return The bytes for tableName.
     */
    com.google.protobuf.ByteString getTableNameBytes();
  }
  /**
   *
   *
   * <pre>
   * Communication request object for fetching tables
   * </pre>
   *
   * Protobuf type {@code CommunicationDataGetRequest}
   */
  public static final class CommunicationDataGetRequest
      extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:CommunicationDataGetRequest)
      CommunicationDataGetRequestOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use CommunicationDataGetRequest.newBuilder() to construct.
    private CommunicationDataGetRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private CommunicationDataGetRequest() {
      id_ = emptyLongList();
      tableName_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new CommunicationDataGetRequest();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private CommunicationDataGetRequest(
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
            case 18:
              {
                java.lang.String s = input.readStringRequireUtf8();

                tableName_ = s;
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
      return com.cpdss.common.generated.Common
          .internal_static_CommunicationDataGetRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.Common
          .internal_static_CommunicationDataGetRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.Common.CommunicationDataGetRequest.class,
              com.cpdss.common.generated.Common.CommunicationDataGetRequest.Builder.class);
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

    public static final int TABLENAME_FIELD_NUMBER = 2;
    private volatile java.lang.Object tableName_;
    /**
     * <code>string tableName = 2;</code>
     *
     * @return The tableName.
     */
    public java.lang.String getTableName() {
      java.lang.Object ref = tableName_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        tableName_ = s;
        return s;
      }
    }
    /**
     * <code>string tableName = 2;</code>
     *
     * @return The bytes for tableName.
     */
    public com.google.protobuf.ByteString getTableNameBytes() {
      java.lang.Object ref = tableName_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        tableName_ = b;
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
      getSerializedSize();
      if (getIdList().size() > 0) {
        output.writeUInt32NoTag(10);
        output.writeUInt32NoTag(idMemoizedSerializedSize);
      }
      for (int i = 0; i < id_.size(); i++) {
        output.writeInt64NoTag(id_.getLong(i));
      }
      if (!getTableNameBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, tableName_);
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
      if (!getTableNameBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, tableName_);
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
      if (!(obj instanceof com.cpdss.common.generated.Common.CommunicationDataGetRequest)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.Common.CommunicationDataGetRequest other =
          (com.cpdss.common.generated.Common.CommunicationDataGetRequest) obj;

      if (!getIdList().equals(other.getIdList())) return false;
      if (!getTableName().equals(other.getTableName())) return false;
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
      hash = (37 * hash) + TABLENAME_FIELD_NUMBER;
      hash = (53 * hash) + getTableName().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.Common.CommunicationDataGetRequest parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Common.CommunicationDataGetRequest parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.CommunicationDataGetRequest parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Common.CommunicationDataGetRequest parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.CommunicationDataGetRequest parseFrom(
        byte[] data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Common.CommunicationDataGetRequest parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.CommunicationDataGetRequest parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Common.CommunicationDataGetRequest parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.CommunicationDataGetRequest parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Common.CommunicationDataGetRequest parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.CommunicationDataGetRequest parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Common.CommunicationDataGetRequest parseFrom(
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
        com.cpdss.common.generated.Common.CommunicationDataGetRequest prototype) {
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
    /**
     *
     *
     * <pre>
     * Communication request object for fetching tables
     * </pre>
     *
     * Protobuf type {@code CommunicationDataGetRequest}
     */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:CommunicationDataGetRequest)
        com.cpdss.common.generated.Common.CommunicationDataGetRequestOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.Common
            .internal_static_CommunicationDataGetRequest_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.Common
            .internal_static_CommunicationDataGetRequest_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.Common.CommunicationDataGetRequest.class,
                com.cpdss.common.generated.Common.CommunicationDataGetRequest.Builder.class);
      }

      // Construct using com.cpdss.common.generated.Common.CommunicationDataGetRequest.newBuilder()
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
        tableName_ = "";

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.Common
            .internal_static_CommunicationDataGetRequest_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.Common.CommunicationDataGetRequest
          getDefaultInstanceForType() {
        return com.cpdss.common.generated.Common.CommunicationDataGetRequest.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.Common.CommunicationDataGetRequest build() {
        com.cpdss.common.generated.Common.CommunicationDataGetRequest result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.Common.CommunicationDataGetRequest buildPartial() {
        com.cpdss.common.generated.Common.CommunicationDataGetRequest result =
            new com.cpdss.common.generated.Common.CommunicationDataGetRequest(this);
        int from_bitField0_ = bitField0_;
        if (((bitField0_ & 0x00000001) != 0)) {
          id_.makeImmutable();
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.id_ = id_;
        result.tableName_ = tableName_;
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
        if (other instanceof com.cpdss.common.generated.Common.CommunicationDataGetRequest) {
          return mergeFrom((com.cpdss.common.generated.Common.CommunicationDataGetRequest) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(
          com.cpdss.common.generated.Common.CommunicationDataGetRequest other) {
        if (other
            == com.cpdss.common.generated.Common.CommunicationDataGetRequest.getDefaultInstance())
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
        if (!other.getTableName().isEmpty()) {
          tableName_ = other.tableName_;
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
        com.cpdss.common.generated.Common.CommunicationDataGetRequest parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.Common.CommunicationDataGetRequest)
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

      private java.lang.Object tableName_ = "";
      /**
       * <code>string tableName = 2;</code>
       *
       * @return The tableName.
       */
      public java.lang.String getTableName() {
        java.lang.Object ref = tableName_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          tableName_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string tableName = 2;</code>
       *
       * @return The bytes for tableName.
       */
      public com.google.protobuf.ByteString getTableNameBytes() {
        java.lang.Object ref = tableName_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          tableName_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string tableName = 2;</code>
       *
       * @param value The tableName to set.
       * @return This builder for chaining.
       */
      public Builder setTableName(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        tableName_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string tableName = 2;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearTableName() {

        tableName_ = getDefaultInstance().getTableName();
        onChanged();
        return this;
      }
      /**
       * <code>string tableName = 2;</code>
       *
       * @param value The bytes for tableName to set.
       * @return This builder for chaining.
       */
      public Builder setTableNameBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        tableName_ = value;
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

      // @@protoc_insertion_point(builder_scope:CommunicationDataGetRequest)
    }

    // @@protoc_insertion_point(class_scope:CommunicationDataGetRequest)
    private static final com.cpdss.common.generated.Common.CommunicationDataGetRequest
        DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.Common.CommunicationDataGetRequest();
    }

    public static com.cpdss.common.generated.Common.CommunicationDataGetRequest
        getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<CommunicationDataGetRequest> PARSER =
        new com.google.protobuf.AbstractParser<CommunicationDataGetRequest>() {
          @java.lang.Override
          public CommunicationDataGetRequest parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new CommunicationDataGetRequest(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<CommunicationDataGetRequest> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<CommunicationDataGetRequest> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.Common.CommunicationDataGetRequest
        getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface CommunicationDataUpdateRequestOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:CommunicationDataUpdateRequest)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>string dataJson = 1;</code>
     *
     * @return The dataJson.
     */
    java.lang.String getDataJson();
    /**
     * <code>string dataJson = 1;</code>
     *
     * @return The bytes for dataJson.
     */
    com.google.protobuf.ByteString getDataJsonBytes();

    /**
     * <code>string tableName = 2;</code>
     *
     * @return The tableName.
     */
    java.lang.String getTableName();
    /**
     * <code>string tableName = 2;</code>
     *
     * @return The bytes for tableName.
     */
    com.google.protobuf.ByteString getTableNameBytes();
  }
  /**
   *
   *
   * <pre>
   * Communication request object for updating tables
   * </pre>
   *
   * Protobuf type {@code CommunicationDataUpdateRequest}
   */
  public static final class CommunicationDataUpdateRequest
      extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:CommunicationDataUpdateRequest)
      CommunicationDataUpdateRequestOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use CommunicationDataUpdateRequest.newBuilder() to construct.
    private CommunicationDataUpdateRequest(
        com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private CommunicationDataUpdateRequest() {
      dataJson_ = "";
      tableName_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new CommunicationDataUpdateRequest();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private CommunicationDataUpdateRequest(
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

                dataJson_ = s;
                break;
              }
            case 18:
              {
                java.lang.String s = input.readStringRequireUtf8();

                tableName_ = s;
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
      return com.cpdss.common.generated.Common
          .internal_static_CommunicationDataUpdateRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.Common
          .internal_static_CommunicationDataUpdateRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.Common.CommunicationDataUpdateRequest.class,
              com.cpdss.common.generated.Common.CommunicationDataUpdateRequest.Builder.class);
    }

    public static final int DATAJSON_FIELD_NUMBER = 1;
    private volatile java.lang.Object dataJson_;
    /**
     * <code>string dataJson = 1;</code>
     *
     * @return The dataJson.
     */
    public java.lang.String getDataJson() {
      java.lang.Object ref = dataJson_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        dataJson_ = s;
        return s;
      }
    }
    /**
     * <code>string dataJson = 1;</code>
     *
     * @return The bytes for dataJson.
     */
    public com.google.protobuf.ByteString getDataJsonBytes() {
      java.lang.Object ref = dataJson_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        dataJson_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int TABLENAME_FIELD_NUMBER = 2;
    private volatile java.lang.Object tableName_;
    /**
     * <code>string tableName = 2;</code>
     *
     * @return The tableName.
     */
    public java.lang.String getTableName() {
      java.lang.Object ref = tableName_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        tableName_ = s;
        return s;
      }
    }
    /**
     * <code>string tableName = 2;</code>
     *
     * @return The bytes for tableName.
     */
    public com.google.protobuf.ByteString getTableNameBytes() {
      java.lang.Object ref = tableName_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        tableName_ = b;
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
      if (!getDataJsonBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, dataJson_);
      }
      if (!getTableNameBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, tableName_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getDataJsonBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, dataJson_);
      }
      if (!getTableNameBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, tableName_);
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
      if (!(obj instanceof com.cpdss.common.generated.Common.CommunicationDataUpdateRequest)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.Common.CommunicationDataUpdateRequest other =
          (com.cpdss.common.generated.Common.CommunicationDataUpdateRequest) obj;

      if (!getDataJson().equals(other.getDataJson())) return false;
      if (!getTableName().equals(other.getTableName())) return false;
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
      hash = (37 * hash) + DATAJSON_FIELD_NUMBER;
      hash = (53 * hash) + getDataJson().hashCode();
      hash = (37 * hash) + TABLENAME_FIELD_NUMBER;
      hash = (53 * hash) + getTableName().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.Common.CommunicationDataUpdateRequest parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Common.CommunicationDataUpdateRequest parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.CommunicationDataUpdateRequest parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Common.CommunicationDataUpdateRequest parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.CommunicationDataUpdateRequest parseFrom(
        byte[] data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Common.CommunicationDataUpdateRequest parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.CommunicationDataUpdateRequest parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Common.CommunicationDataUpdateRequest parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.CommunicationDataUpdateRequest
        parseDelimitedFrom(java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Common.CommunicationDataUpdateRequest
        parseDelimitedFrom(
            java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.CommunicationDataUpdateRequest parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Common.CommunicationDataUpdateRequest parseFrom(
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
        com.cpdss.common.generated.Common.CommunicationDataUpdateRequest prototype) {
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
    /**
     *
     *
     * <pre>
     * Communication request object for updating tables
     * </pre>
     *
     * Protobuf type {@code CommunicationDataUpdateRequest}
     */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:CommunicationDataUpdateRequest)
        com.cpdss.common.generated.Common.CommunicationDataUpdateRequestOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.Common
            .internal_static_CommunicationDataUpdateRequest_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.Common
            .internal_static_CommunicationDataUpdateRequest_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.Common.CommunicationDataUpdateRequest.class,
                com.cpdss.common.generated.Common.CommunicationDataUpdateRequest.Builder.class);
      }

      // Construct using
      // com.cpdss.common.generated.Common.CommunicationDataUpdateRequest.newBuilder()
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
        dataJson_ = "";

        tableName_ = "";

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.Common
            .internal_static_CommunicationDataUpdateRequest_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.Common.CommunicationDataUpdateRequest
          getDefaultInstanceForType() {
        return com.cpdss.common.generated.Common.CommunicationDataUpdateRequest
            .getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.Common.CommunicationDataUpdateRequest build() {
        com.cpdss.common.generated.Common.CommunicationDataUpdateRequest result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.Common.CommunicationDataUpdateRequest buildPartial() {
        com.cpdss.common.generated.Common.CommunicationDataUpdateRequest result =
            new com.cpdss.common.generated.Common.CommunicationDataUpdateRequest(this);
        result.dataJson_ = dataJson_;
        result.tableName_ = tableName_;
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
        if (other instanceof com.cpdss.common.generated.Common.CommunicationDataUpdateRequest) {
          return mergeFrom(
              (com.cpdss.common.generated.Common.CommunicationDataUpdateRequest) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(
          com.cpdss.common.generated.Common.CommunicationDataUpdateRequest other) {
        if (other
            == com.cpdss.common.generated.Common.CommunicationDataUpdateRequest
                .getDefaultInstance()) return this;
        if (!other.getDataJson().isEmpty()) {
          dataJson_ = other.dataJson_;
          onChanged();
        }
        if (!other.getTableName().isEmpty()) {
          tableName_ = other.tableName_;
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
        com.cpdss.common.generated.Common.CommunicationDataUpdateRequest parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.Common.CommunicationDataUpdateRequest)
                  e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private java.lang.Object dataJson_ = "";
      /**
       * <code>string dataJson = 1;</code>
       *
       * @return The dataJson.
       */
      public java.lang.String getDataJson() {
        java.lang.Object ref = dataJson_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          dataJson_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string dataJson = 1;</code>
       *
       * @return The bytes for dataJson.
       */
      public com.google.protobuf.ByteString getDataJsonBytes() {
        java.lang.Object ref = dataJson_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          dataJson_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string dataJson = 1;</code>
       *
       * @param value The dataJson to set.
       * @return This builder for chaining.
       */
      public Builder setDataJson(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        dataJson_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string dataJson = 1;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearDataJson() {

        dataJson_ = getDefaultInstance().getDataJson();
        onChanged();
        return this;
      }
      /**
       * <code>string dataJson = 1;</code>
       *
       * @param value The bytes for dataJson to set.
       * @return This builder for chaining.
       */
      public Builder setDataJsonBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        dataJson_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object tableName_ = "";
      /**
       * <code>string tableName = 2;</code>
       *
       * @return The tableName.
       */
      public java.lang.String getTableName() {
        java.lang.Object ref = tableName_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          tableName_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string tableName = 2;</code>
       *
       * @return The bytes for tableName.
       */
      public com.google.protobuf.ByteString getTableNameBytes() {
        java.lang.Object ref = tableName_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          tableName_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string tableName = 2;</code>
       *
       * @param value The tableName to set.
       * @return This builder for chaining.
       */
      public Builder setTableName(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        tableName_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string tableName = 2;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearTableName() {

        tableName_ = getDefaultInstance().getTableName();
        onChanged();
        return this;
      }
      /**
       * <code>string tableName = 2;</code>
       *
       * @param value The bytes for tableName to set.
       * @return This builder for chaining.
       */
      public Builder setTableNameBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        tableName_ = value;
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

      // @@protoc_insertion_point(builder_scope:CommunicationDataUpdateRequest)
    }

    // @@protoc_insertion_point(class_scope:CommunicationDataUpdateRequest)
    private static final com.cpdss.common.generated.Common.CommunicationDataUpdateRequest
        DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.Common.CommunicationDataUpdateRequest();
    }

    public static com.cpdss.common.generated.Common.CommunicationDataUpdateRequest
        getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<CommunicationDataUpdateRequest> PARSER =
        new com.google.protobuf.AbstractParser<CommunicationDataUpdateRequest>() {
          @java.lang.Override
          public CommunicationDataUpdateRequest parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new CommunicationDataUpdateRequest(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<CommunicationDataUpdateRequest> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<CommunicationDataUpdateRequest> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.Common.CommunicationDataUpdateRequest
        getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface CommunicationDataResponseOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:CommunicationDataResponse)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>string dataJson = 1;</code>
     *
     * @return The dataJson.
     */
    java.lang.String getDataJson();
    /**
     * <code>string dataJson = 1;</code>
     *
     * @return The bytes for dataJson.
     */
    com.google.protobuf.ByteString getDataJsonBytes();

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
  /**
   *
   *
   * <pre>
   * Communication response object with table data
   * </pre>
   *
   * Protobuf type {@code CommunicationDataResponse}
   */
  public static final class CommunicationDataResponse extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:CommunicationDataResponse)
      CommunicationDataResponseOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use CommunicationDataResponse.newBuilder() to construct.
    private CommunicationDataResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private CommunicationDataResponse() {
      dataJson_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new CommunicationDataResponse();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private CommunicationDataResponse(
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

                dataJson_ = s;
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
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }

    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.cpdss.common.generated.Common.internal_static_CommunicationDataResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.Common
          .internal_static_CommunicationDataResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.Common.CommunicationDataResponse.class,
              com.cpdss.common.generated.Common.CommunicationDataResponse.Builder.class);
    }

    public static final int DATAJSON_FIELD_NUMBER = 1;
    private volatile java.lang.Object dataJson_;
    /**
     * <code>string dataJson = 1;</code>
     *
     * @return The dataJson.
     */
    public java.lang.String getDataJson() {
      java.lang.Object ref = dataJson_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        dataJson_ = s;
        return s;
      }
    }
    /**
     * <code>string dataJson = 1;</code>
     *
     * @return The bytes for dataJson.
     */
    public com.google.protobuf.ByteString getDataJsonBytes() {
      java.lang.Object ref = dataJson_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        dataJson_ = b;
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
      if (!getDataJsonBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, dataJson_);
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
      if (!getDataJsonBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, dataJson_);
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
      if (!(obj instanceof com.cpdss.common.generated.Common.CommunicationDataResponse)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.Common.CommunicationDataResponse other =
          (com.cpdss.common.generated.Common.CommunicationDataResponse) obj;

      if (!getDataJson().equals(other.getDataJson())) return false;
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
      hash = (37 * hash) + DATAJSON_FIELD_NUMBER;
      hash = (53 * hash) + getDataJson().hashCode();
      if (hasResponseStatus()) {
        hash = (37 * hash) + RESPONSESTATUS_FIELD_NUMBER;
        hash = (53 * hash) + getResponseStatus().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.Common.CommunicationDataResponse parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Common.CommunicationDataResponse parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.CommunicationDataResponse parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Common.CommunicationDataResponse parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.CommunicationDataResponse parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Common.CommunicationDataResponse parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.CommunicationDataResponse parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Common.CommunicationDataResponse parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.CommunicationDataResponse parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Common.CommunicationDataResponse parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.CommunicationDataResponse parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Common.CommunicationDataResponse parseFrom(
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
        com.cpdss.common.generated.Common.CommunicationDataResponse prototype) {
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
    /**
     *
     *
     * <pre>
     * Communication response object with table data
     * </pre>
     *
     * Protobuf type {@code CommunicationDataResponse}
     */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:CommunicationDataResponse)
        com.cpdss.common.generated.Common.CommunicationDataResponseOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.Common
            .internal_static_CommunicationDataResponse_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.Common
            .internal_static_CommunicationDataResponse_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.Common.CommunicationDataResponse.class,
                com.cpdss.common.generated.Common.CommunicationDataResponse.Builder.class);
      }

      // Construct using com.cpdss.common.generated.Common.CommunicationDataResponse.newBuilder()
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
        dataJson_ = "";

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
        return com.cpdss.common.generated.Common
            .internal_static_CommunicationDataResponse_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.Common.CommunicationDataResponse
          getDefaultInstanceForType() {
        return com.cpdss.common.generated.Common.CommunicationDataResponse.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.Common.CommunicationDataResponse build() {
        com.cpdss.common.generated.Common.CommunicationDataResponse result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.Common.CommunicationDataResponse buildPartial() {
        com.cpdss.common.generated.Common.CommunicationDataResponse result =
            new com.cpdss.common.generated.Common.CommunicationDataResponse(this);
        result.dataJson_ = dataJson_;
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
        if (other instanceof com.cpdss.common.generated.Common.CommunicationDataResponse) {
          return mergeFrom((com.cpdss.common.generated.Common.CommunicationDataResponse) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.cpdss.common.generated.Common.CommunicationDataResponse other) {
        if (other
            == com.cpdss.common.generated.Common.CommunicationDataResponse.getDefaultInstance())
          return this;
        if (!other.getDataJson().isEmpty()) {
          dataJson_ = other.dataJson_;
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
        com.cpdss.common.generated.Common.CommunicationDataResponse parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.Common.CommunicationDataResponse)
                  e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private java.lang.Object dataJson_ = "";
      /**
       * <code>string dataJson = 1;</code>
       *
       * @return The dataJson.
       */
      public java.lang.String getDataJson() {
        java.lang.Object ref = dataJson_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          dataJson_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string dataJson = 1;</code>
       *
       * @return The bytes for dataJson.
       */
      public com.google.protobuf.ByteString getDataJsonBytes() {
        java.lang.Object ref = dataJson_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          dataJson_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string dataJson = 1;</code>
       *
       * @param value The dataJson to set.
       * @return This builder for chaining.
       */
      public Builder setDataJson(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        dataJson_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string dataJson = 1;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearDataJson() {

        dataJson_ = getDefaultInstance().getDataJson();
        onChanged();
        return this;
      }
      /**
       * <code>string dataJson = 1;</code>
       *
       * @param value The bytes for dataJson to set.
       * @return This builder for chaining.
       */
      public Builder setDataJsonBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        dataJson_ = value;
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

      // @@protoc_insertion_point(builder_scope:CommunicationDataResponse)
    }

    // @@protoc_insertion_point(class_scope:CommunicationDataResponse)
    private static final com.cpdss.common.generated.Common.CommunicationDataResponse
        DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.Common.CommunicationDataResponse();
    }

    public static com.cpdss.common.generated.Common.CommunicationDataResponse getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<CommunicationDataResponse> PARSER =
        new com.google.protobuf.AbstractParser<CommunicationDataResponse>() {
          @java.lang.Override
          public CommunicationDataResponse parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new CommunicationDataResponse(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<CommunicationDataResponse> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<CommunicationDataResponse> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.Common.CommunicationDataResponse getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface DependentProcessCheckRequestCommOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:DependentProcessCheckRequestComm)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>string dependantProcessId = 3;</code>
     *
     * @return The dependantProcessId.
     */
    java.lang.String getDependantProcessId();
    /**
     * <code>string dependantProcessId = 3;</code>
     *
     * @return The bytes for dependantProcessId.
     */
    com.google.protobuf.ByteString getDependantProcessIdBytes();
  }
  /**
   *
   *
   * <pre>
   * Communication dependent process check request
   * </pre>
   *
   * Protobuf type {@code DependentProcessCheckRequestComm}
   */
  public static final class DependentProcessCheckRequestComm
      extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:DependentProcessCheckRequestComm)
      DependentProcessCheckRequestCommOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use DependentProcessCheckRequestComm.newBuilder() to construct.
    private DependentProcessCheckRequestComm(
        com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private DependentProcessCheckRequestComm() {
      dependantProcessId_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new DependentProcessCheckRequestComm();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private DependentProcessCheckRequestComm(
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
            case 26:
              {
                java.lang.String s = input.readStringRequireUtf8();

                dependantProcessId_ = s;
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
      return com.cpdss.common.generated.Common
          .internal_static_DependentProcessCheckRequestComm_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.Common
          .internal_static_DependentProcessCheckRequestComm_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.Common.DependentProcessCheckRequestComm.class,
              com.cpdss.common.generated.Common.DependentProcessCheckRequestComm.Builder.class);
    }

    public static final int DEPENDANTPROCESSID_FIELD_NUMBER = 3;
    private volatile java.lang.Object dependantProcessId_;
    /**
     * <code>string dependantProcessId = 3;</code>
     *
     * @return The dependantProcessId.
     */
    public java.lang.String getDependantProcessId() {
      java.lang.Object ref = dependantProcessId_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        dependantProcessId_ = s;
        return s;
      }
    }
    /**
     * <code>string dependantProcessId = 3;</code>
     *
     * @return The bytes for dependantProcessId.
     */
    public com.google.protobuf.ByteString getDependantProcessIdBytes() {
      java.lang.Object ref = dependantProcessId_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        dependantProcessId_ = b;
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
      if (!getDependantProcessIdBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, dependantProcessId_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getDependantProcessIdBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, dependantProcessId_);
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
      if (!(obj instanceof com.cpdss.common.generated.Common.DependentProcessCheckRequestComm)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.Common.DependentProcessCheckRequestComm other =
          (com.cpdss.common.generated.Common.DependentProcessCheckRequestComm) obj;

      if (!getDependantProcessId().equals(other.getDependantProcessId())) return false;
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
      hash = (37 * hash) + DEPENDANTPROCESSID_FIELD_NUMBER;
      hash = (53 * hash) + getDependantProcessId().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.Common.DependentProcessCheckRequestComm parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Common.DependentProcessCheckRequestComm parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.DependentProcessCheckRequestComm parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Common.DependentProcessCheckRequestComm parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.DependentProcessCheckRequestComm parseFrom(
        byte[] data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Common.DependentProcessCheckRequestComm parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.DependentProcessCheckRequestComm parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Common.DependentProcessCheckRequestComm parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.DependentProcessCheckRequestComm
        parseDelimitedFrom(java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Common.DependentProcessCheckRequestComm
        parseDelimitedFrom(
            java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.DependentProcessCheckRequestComm parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Common.DependentProcessCheckRequestComm parseFrom(
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
        com.cpdss.common.generated.Common.DependentProcessCheckRequestComm prototype) {
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
    /**
     *
     *
     * <pre>
     * Communication dependent process check request
     * </pre>
     *
     * Protobuf type {@code DependentProcessCheckRequestComm}
     */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:DependentProcessCheckRequestComm)
        com.cpdss.common.generated.Common.DependentProcessCheckRequestCommOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.Common
            .internal_static_DependentProcessCheckRequestComm_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.Common
            .internal_static_DependentProcessCheckRequestComm_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.Common.DependentProcessCheckRequestComm.class,
                com.cpdss.common.generated.Common.DependentProcessCheckRequestComm.Builder.class);
      }

      // Construct using
      // com.cpdss.common.generated.Common.DependentProcessCheckRequestComm.newBuilder()
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
        dependantProcessId_ = "";

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.Common
            .internal_static_DependentProcessCheckRequestComm_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.Common.DependentProcessCheckRequestComm
          getDefaultInstanceForType() {
        return com.cpdss.common.generated.Common.DependentProcessCheckRequestComm
            .getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.Common.DependentProcessCheckRequestComm build() {
        com.cpdss.common.generated.Common.DependentProcessCheckRequestComm result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.Common.DependentProcessCheckRequestComm buildPartial() {
        com.cpdss.common.generated.Common.DependentProcessCheckRequestComm result =
            new com.cpdss.common.generated.Common.DependentProcessCheckRequestComm(this);
        result.dependantProcessId_ = dependantProcessId_;
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
        if (other instanceof com.cpdss.common.generated.Common.DependentProcessCheckRequestComm) {
          return mergeFrom(
              (com.cpdss.common.generated.Common.DependentProcessCheckRequestComm) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(
          com.cpdss.common.generated.Common.DependentProcessCheckRequestComm other) {
        if (other
            == com.cpdss.common.generated.Common.DependentProcessCheckRequestComm
                .getDefaultInstance()) return this;
        if (!other.getDependantProcessId().isEmpty()) {
          dependantProcessId_ = other.dependantProcessId_;
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
        com.cpdss.common.generated.Common.DependentProcessCheckRequestComm parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.Common.DependentProcessCheckRequestComm)
                  e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private java.lang.Object dependantProcessId_ = "";
      /**
       * <code>string dependantProcessId = 3;</code>
       *
       * @return The dependantProcessId.
       */
      public java.lang.String getDependantProcessId() {
        java.lang.Object ref = dependantProcessId_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          dependantProcessId_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string dependantProcessId = 3;</code>
       *
       * @return The bytes for dependantProcessId.
       */
      public com.google.protobuf.ByteString getDependantProcessIdBytes() {
        java.lang.Object ref = dependantProcessId_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          dependantProcessId_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string dependantProcessId = 3;</code>
       *
       * @param value The dependantProcessId to set.
       * @return This builder for chaining.
       */
      public Builder setDependantProcessId(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        dependantProcessId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string dependantProcessId = 3;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearDependantProcessId() {

        dependantProcessId_ = getDefaultInstance().getDependantProcessId();
        onChanged();
        return this;
      }
      /**
       * <code>string dependantProcessId = 3;</code>
       *
       * @param value The bytes for dependantProcessId to set.
       * @return This builder for chaining.
       */
      public Builder setDependantProcessIdBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        dependantProcessId_ = value;
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

      // @@protoc_insertion_point(builder_scope:DependentProcessCheckRequestComm)
    }

    // @@protoc_insertion_point(class_scope:DependentProcessCheckRequestComm)
    private static final com.cpdss.common.generated.Common.DependentProcessCheckRequestComm
        DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.Common.DependentProcessCheckRequestComm();
    }

    public static com.cpdss.common.generated.Common.DependentProcessCheckRequestComm
        getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<DependentProcessCheckRequestComm> PARSER =
        new com.google.protobuf.AbstractParser<DependentProcessCheckRequestComm>() {
          @java.lang.Override
          public DependentProcessCheckRequestComm parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new DependentProcessCheckRequestComm(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<DependentProcessCheckRequestComm> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<DependentProcessCheckRequestComm> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.Common.DependentProcessCheckRequestComm
        getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface CommunicationCheckResponseOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:CommunicationCheckResponse)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>bool isCompleted = 1;</code>
     *
     * @return The isCompleted.
     */
    boolean getIsCompleted();

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
  /**
   *
   *
   * <pre>
   * Communication process check response
   * </pre>
   *
   * Protobuf type {@code CommunicationCheckResponse}
   */
  public static final class CommunicationCheckResponse
      extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:CommunicationCheckResponse)
      CommunicationCheckResponseOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use CommunicationCheckResponse.newBuilder() to construct.
    private CommunicationCheckResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private CommunicationCheckResponse() {}

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new CommunicationCheckResponse();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private CommunicationCheckResponse(
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
                isCompleted_ = input.readBool();
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
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }

    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.cpdss.common.generated.Common
          .internal_static_CommunicationCheckResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.Common
          .internal_static_CommunicationCheckResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.Common.CommunicationCheckResponse.class,
              com.cpdss.common.generated.Common.CommunicationCheckResponse.Builder.class);
    }

    public static final int ISCOMPLETED_FIELD_NUMBER = 1;
    private boolean isCompleted_;
    /**
     * <code>bool isCompleted = 1;</code>
     *
     * @return The isCompleted.
     */
    public boolean getIsCompleted() {
      return isCompleted_;
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
      if (isCompleted_ != false) {
        output.writeBool(1, isCompleted_);
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
      if (isCompleted_ != false) {
        size += com.google.protobuf.CodedOutputStream.computeBoolSize(1, isCompleted_);
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
      if (!(obj instanceof com.cpdss.common.generated.Common.CommunicationCheckResponse)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.Common.CommunicationCheckResponse other =
          (com.cpdss.common.generated.Common.CommunicationCheckResponse) obj;

      if (getIsCompleted() != other.getIsCompleted()) return false;
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
      hash = (37 * hash) + ISCOMPLETED_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(getIsCompleted());
      if (hasResponseStatus()) {
        hash = (37 * hash) + RESPONSESTATUS_FIELD_NUMBER;
        hash = (53 * hash) + getResponseStatus().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.Common.CommunicationCheckResponse parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Common.CommunicationCheckResponse parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.CommunicationCheckResponse parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Common.CommunicationCheckResponse parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.CommunicationCheckResponse parseFrom(
        byte[] data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Common.CommunicationCheckResponse parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.CommunicationCheckResponse parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Common.CommunicationCheckResponse parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.CommunicationCheckResponse parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Common.CommunicationCheckResponse parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.CommunicationCheckResponse parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Common.CommunicationCheckResponse parseFrom(
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
        com.cpdss.common.generated.Common.CommunicationCheckResponse prototype) {
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
    /**
     *
     *
     * <pre>
     * Communication process check response
     * </pre>
     *
     * Protobuf type {@code CommunicationCheckResponse}
     */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:CommunicationCheckResponse)
        com.cpdss.common.generated.Common.CommunicationCheckResponseOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.Common
            .internal_static_CommunicationCheckResponse_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.Common
            .internal_static_CommunicationCheckResponse_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.Common.CommunicationCheckResponse.class,
                com.cpdss.common.generated.Common.CommunicationCheckResponse.Builder.class);
      }

      // Construct using com.cpdss.common.generated.Common.CommunicationCheckResponse.newBuilder()
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
        isCompleted_ = false;

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
        return com.cpdss.common.generated.Common
            .internal_static_CommunicationCheckResponse_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.Common.CommunicationCheckResponse
          getDefaultInstanceForType() {
        return com.cpdss.common.generated.Common.CommunicationCheckResponse.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.Common.CommunicationCheckResponse build() {
        com.cpdss.common.generated.Common.CommunicationCheckResponse result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.Common.CommunicationCheckResponse buildPartial() {
        com.cpdss.common.generated.Common.CommunicationCheckResponse result =
            new com.cpdss.common.generated.Common.CommunicationCheckResponse(this);
        result.isCompleted_ = isCompleted_;
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
        if (other instanceof com.cpdss.common.generated.Common.CommunicationCheckResponse) {
          return mergeFrom((com.cpdss.common.generated.Common.CommunicationCheckResponse) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.cpdss.common.generated.Common.CommunicationCheckResponse other) {
        if (other
            == com.cpdss.common.generated.Common.CommunicationCheckResponse.getDefaultInstance())
          return this;
        if (other.getIsCompleted() != false) {
          setIsCompleted(other.getIsCompleted());
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
        com.cpdss.common.generated.Common.CommunicationCheckResponse parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.Common.CommunicationCheckResponse)
                  e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private boolean isCompleted_;
      /**
       * <code>bool isCompleted = 1;</code>
       *
       * @return The isCompleted.
       */
      public boolean getIsCompleted() {
        return isCompleted_;
      }
      /**
       * <code>bool isCompleted = 1;</code>
       *
       * @param value The isCompleted to set.
       * @return This builder for chaining.
       */
      public Builder setIsCompleted(boolean value) {

        isCompleted_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>bool isCompleted = 1;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearIsCompleted() {

        isCompleted_ = false;
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

      // @@protoc_insertion_point(builder_scope:CommunicationCheckResponse)
    }

    // @@protoc_insertion_point(class_scope:CommunicationCheckResponse)
    private static final com.cpdss.common.generated.Common.CommunicationCheckResponse
        DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.Common.CommunicationCheckResponse();
    }

    public static com.cpdss.common.generated.Common.CommunicationCheckResponse
        getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<CommunicationCheckResponse> PARSER =
        new com.google.protobuf.AbstractParser<CommunicationCheckResponse>() {
          @java.lang.Override
          public CommunicationCheckResponse parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new CommunicationCheckResponse(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<CommunicationCheckResponse> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<CommunicationCheckResponse> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.Common.CommunicationCheckResponse
        getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface CommunicationStatusCheckRequestOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:CommunicationStatusCheckRequest)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int64 referenceId = 1;</code>
     *
     * @return The referenceId.
     */
    long getReferenceId();

    /**
     * <code>string reference = 2;</code>
     *
     * @return The reference.
     */
    java.lang.String getReference();
    /**
     * <code>string reference = 2;</code>
     *
     * @return The bytes for reference.
     */
    com.google.protobuf.ByteString getReferenceBytes();
  }
  /**
   *
   *
   * <pre>
   * Communication request object for checking isCommunicated
   * </pre>
   *
   * Protobuf type {@code CommunicationStatusCheckRequest}
   */
  public static final class CommunicationStatusCheckRequest
      extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:CommunicationStatusCheckRequest)
      CommunicationStatusCheckRequestOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use CommunicationStatusCheckRequest.newBuilder() to construct.
    private CommunicationStatusCheckRequest(
        com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private CommunicationStatusCheckRequest() {
      reference_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new CommunicationStatusCheckRequest();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private CommunicationStatusCheckRequest(
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
                referenceId_ = input.readInt64();
                break;
              }
            case 18:
              {
                java.lang.String s = input.readStringRequireUtf8();

                reference_ = s;
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
      return com.cpdss.common.generated.Common
          .internal_static_CommunicationStatusCheckRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.Common
          .internal_static_CommunicationStatusCheckRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.Common.CommunicationStatusCheckRequest.class,
              com.cpdss.common.generated.Common.CommunicationStatusCheckRequest.Builder.class);
    }

    public static final int REFERENCEID_FIELD_NUMBER = 1;
    private long referenceId_;
    /**
     * <code>int64 referenceId = 1;</code>
     *
     * @return The referenceId.
     */
    public long getReferenceId() {
      return referenceId_;
    }

    public static final int REFERENCE_FIELD_NUMBER = 2;
    private volatile java.lang.Object reference_;
    /**
     * <code>string reference = 2;</code>
     *
     * @return The reference.
     */
    public java.lang.String getReference() {
      java.lang.Object ref = reference_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        reference_ = s;
        return s;
      }
    }
    /**
     * <code>string reference = 2;</code>
     *
     * @return The bytes for reference.
     */
    public com.google.protobuf.ByteString getReferenceBytes() {
      java.lang.Object ref = reference_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        reference_ = b;
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
      if (referenceId_ != 0L) {
        output.writeInt64(1, referenceId_);
      }
      if (!getReferenceBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, reference_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (referenceId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(1, referenceId_);
      }
      if (!getReferenceBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, reference_);
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
      if (!(obj instanceof com.cpdss.common.generated.Common.CommunicationStatusCheckRequest)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.Common.CommunicationStatusCheckRequest other =
          (com.cpdss.common.generated.Common.CommunicationStatusCheckRequest) obj;

      if (getReferenceId() != other.getReferenceId()) return false;
      if (!getReference().equals(other.getReference())) return false;
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
      hash = (37 * hash) + REFERENCEID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getReferenceId());
      hash = (37 * hash) + REFERENCE_FIELD_NUMBER;
      hash = (53 * hash) + getReference().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.Common.CommunicationStatusCheckRequest parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Common.CommunicationStatusCheckRequest parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.CommunicationStatusCheckRequest parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Common.CommunicationStatusCheckRequest parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.CommunicationStatusCheckRequest parseFrom(
        byte[] data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Common.CommunicationStatusCheckRequest parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.CommunicationStatusCheckRequest parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Common.CommunicationStatusCheckRequest parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.CommunicationStatusCheckRequest
        parseDelimitedFrom(java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Common.CommunicationStatusCheckRequest
        parseDelimitedFrom(
            java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.CommunicationStatusCheckRequest parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Common.CommunicationStatusCheckRequest parseFrom(
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
        com.cpdss.common.generated.Common.CommunicationStatusCheckRequest prototype) {
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
    /**
     *
     *
     * <pre>
     * Communication request object for checking isCommunicated
     * </pre>
     *
     * Protobuf type {@code CommunicationStatusCheckRequest}
     */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:CommunicationStatusCheckRequest)
        com.cpdss.common.generated.Common.CommunicationStatusCheckRequestOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.Common
            .internal_static_CommunicationStatusCheckRequest_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.Common
            .internal_static_CommunicationStatusCheckRequest_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.Common.CommunicationStatusCheckRequest.class,
                com.cpdss.common.generated.Common.CommunicationStatusCheckRequest.Builder.class);
      }

      // Construct using
      // com.cpdss.common.generated.Common.CommunicationStatusCheckRequest.newBuilder()
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
        referenceId_ = 0L;

        reference_ = "";

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.Common
            .internal_static_CommunicationStatusCheckRequest_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.Common.CommunicationStatusCheckRequest
          getDefaultInstanceForType() {
        return com.cpdss.common.generated.Common.CommunicationStatusCheckRequest
            .getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.Common.CommunicationStatusCheckRequest build() {
        com.cpdss.common.generated.Common.CommunicationStatusCheckRequest result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.Common.CommunicationStatusCheckRequest buildPartial() {
        com.cpdss.common.generated.Common.CommunicationStatusCheckRequest result =
            new com.cpdss.common.generated.Common.CommunicationStatusCheckRequest(this);
        result.referenceId_ = referenceId_;
        result.reference_ = reference_;
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
        if (other instanceof com.cpdss.common.generated.Common.CommunicationStatusCheckRequest) {
          return mergeFrom(
              (com.cpdss.common.generated.Common.CommunicationStatusCheckRequest) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(
          com.cpdss.common.generated.Common.CommunicationStatusCheckRequest other) {
        if (other
            == com.cpdss.common.generated.Common.CommunicationStatusCheckRequest
                .getDefaultInstance()) return this;
        if (other.getReferenceId() != 0L) {
          setReferenceId(other.getReferenceId());
        }
        if (!other.getReference().isEmpty()) {
          reference_ = other.reference_;
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
        com.cpdss.common.generated.Common.CommunicationStatusCheckRequest parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.Common.CommunicationStatusCheckRequest)
                  e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private long referenceId_;
      /**
       * <code>int64 referenceId = 1;</code>
       *
       * @return The referenceId.
       */
      public long getReferenceId() {
        return referenceId_;
      }
      /**
       * <code>int64 referenceId = 1;</code>
       *
       * @param value The referenceId to set.
       * @return This builder for chaining.
       */
      public Builder setReferenceId(long value) {

        referenceId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int64 referenceId = 1;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearReferenceId() {

        referenceId_ = 0L;
        onChanged();
        return this;
      }

      private java.lang.Object reference_ = "";
      /**
       * <code>string reference = 2;</code>
       *
       * @return The reference.
       */
      public java.lang.String getReference() {
        java.lang.Object ref = reference_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          reference_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string reference = 2;</code>
       *
       * @return The bytes for reference.
       */
      public com.google.protobuf.ByteString getReferenceBytes() {
        java.lang.Object ref = reference_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
          reference_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string reference = 2;</code>
       *
       * @param value The reference to set.
       * @return This builder for chaining.
       */
      public Builder setReference(java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        reference_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string reference = 2;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearReference() {

        reference_ = getDefaultInstance().getReference();
        onChanged();
        return this;
      }
      /**
       * <code>string reference = 2;</code>
       *
       * @param value The bytes for reference to set.
       * @return This builder for chaining.
       */
      public Builder setReferenceBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        reference_ = value;
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

      // @@protoc_insertion_point(builder_scope:CommunicationStatusCheckRequest)
    }

    // @@protoc_insertion_point(class_scope:CommunicationStatusCheckRequest)
    private static final com.cpdss.common.generated.Common.CommunicationStatusCheckRequest
        DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.Common.CommunicationStatusCheckRequest();
    }

    public static com.cpdss.common.generated.Common.CommunicationStatusCheckRequest
        getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<CommunicationStatusCheckRequest> PARSER =
        new com.google.protobuf.AbstractParser<CommunicationStatusCheckRequest>() {
          @java.lang.Override
          public CommunicationStatusCheckRequest parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new CommunicationStatusCheckRequest(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<CommunicationStatusCheckRequest> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<CommunicationStatusCheckRequest> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.Common.CommunicationStatusCheckRequest
        getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface CommunicationTriggerRequestOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:CommunicationTriggerRequest)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int64 referenceId = 1;</code>
     *
     * @return The referenceId.
     */
    long getReferenceId();

    /**
     * <code>string messageType = 2;</code>
     *
     * @return The messageType.
     */
    java.lang.String getMessageType();
    /**
     * <code>string messageType = 2;</code>
     *
     * @return The bytes for messageType.
     */
    com.google.protobuf.ByteString getMessageTypeBytes();
  }
  /**
   *
   *
   * <pre>
   * Communication request object for triggering communication
   * </pre>
   *
   * Protobuf type {@code CommunicationTriggerRequest}
   */
  public static final class CommunicationTriggerRequest
      extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:CommunicationTriggerRequest)
      CommunicationTriggerRequestOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use CommunicationTriggerRequest.newBuilder() to construct.
    private CommunicationTriggerRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private CommunicationTriggerRequest() {
      messageType_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new CommunicationTriggerRequest();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private CommunicationTriggerRequest(
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
                referenceId_ = input.readInt64();
                break;
              }
            case 18:
              {
                java.lang.String s = input.readStringRequireUtf8();

                messageType_ = s;
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
      return com.cpdss.common.generated.Common
          .internal_static_CommunicationTriggerRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.Common
          .internal_static_CommunicationTriggerRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.Common.CommunicationTriggerRequest.class,
              com.cpdss.common.generated.Common.CommunicationTriggerRequest.Builder.class);
    }

    public static final int REFERENCEID_FIELD_NUMBER = 1;
    private long referenceId_;
    /**
     * <code>int64 referenceId = 1;</code>
     *
     * @return The referenceId.
     */
    public long getReferenceId() {
      return referenceId_;
    }

    public static final int MESSAGETYPE_FIELD_NUMBER = 2;
    private volatile java.lang.Object messageType_;
    /**
     * <code>string messageType = 2;</code>
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
     * <code>string messageType = 2;</code>
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
      if (referenceId_ != 0L) {
        output.writeInt64(1, referenceId_);
      }
      if (!getMessageTypeBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, messageType_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (referenceId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream.computeInt64Size(1, referenceId_);
      }
      if (!getMessageTypeBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, messageType_);
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
      if (!(obj instanceof com.cpdss.common.generated.Common.CommunicationTriggerRequest)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.Common.CommunicationTriggerRequest other =
          (com.cpdss.common.generated.Common.CommunicationTriggerRequest) obj;

      if (getReferenceId() != other.getReferenceId()) return false;
      if (!getMessageType().equals(other.getMessageType())) return false;
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
      hash = (37 * hash) + REFERENCEID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getReferenceId());
      hash = (37 * hash) + MESSAGETYPE_FIELD_NUMBER;
      hash = (53 * hash) + getMessageType().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.Common.CommunicationTriggerRequest parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Common.CommunicationTriggerRequest parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.CommunicationTriggerRequest parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Common.CommunicationTriggerRequest parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.CommunicationTriggerRequest parseFrom(
        byte[] data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Common.CommunicationTriggerRequest parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.CommunicationTriggerRequest parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Common.CommunicationTriggerRequest parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.CommunicationTriggerRequest parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Common.CommunicationTriggerRequest parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.CommunicationTriggerRequest parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Common.CommunicationTriggerRequest parseFrom(
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
        com.cpdss.common.generated.Common.CommunicationTriggerRequest prototype) {
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
    /**
     *
     *
     * <pre>
     * Communication request object for triggering communication
     * </pre>
     *
     * Protobuf type {@code CommunicationTriggerRequest}
     */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:CommunicationTriggerRequest)
        com.cpdss.common.generated.Common.CommunicationTriggerRequestOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.Common
            .internal_static_CommunicationTriggerRequest_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.Common
            .internal_static_CommunicationTriggerRequest_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.Common.CommunicationTriggerRequest.class,
                com.cpdss.common.generated.Common.CommunicationTriggerRequest.Builder.class);
      }

      // Construct using com.cpdss.common.generated.Common.CommunicationTriggerRequest.newBuilder()
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
        referenceId_ = 0L;

        messageType_ = "";

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return com.cpdss.common.generated.Common
            .internal_static_CommunicationTriggerRequest_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.Common.CommunicationTriggerRequest
          getDefaultInstanceForType() {
        return com.cpdss.common.generated.Common.CommunicationTriggerRequest.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.Common.CommunicationTriggerRequest build() {
        com.cpdss.common.generated.Common.CommunicationTriggerRequest result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.Common.CommunicationTriggerRequest buildPartial() {
        com.cpdss.common.generated.Common.CommunicationTriggerRequest result =
            new com.cpdss.common.generated.Common.CommunicationTriggerRequest(this);
        result.referenceId_ = referenceId_;
        result.messageType_ = messageType_;
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
        if (other instanceof com.cpdss.common.generated.Common.CommunicationTriggerRequest) {
          return mergeFrom((com.cpdss.common.generated.Common.CommunicationTriggerRequest) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(
          com.cpdss.common.generated.Common.CommunicationTriggerRequest other) {
        if (other
            == com.cpdss.common.generated.Common.CommunicationTriggerRequest.getDefaultInstance())
          return this;
        if (other.getReferenceId() != 0L) {
          setReferenceId(other.getReferenceId());
        }
        if (!other.getMessageType().isEmpty()) {
          messageType_ = other.messageType_;
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
        com.cpdss.common.generated.Common.CommunicationTriggerRequest parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.Common.CommunicationTriggerRequest)
                  e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private long referenceId_;
      /**
       * <code>int64 referenceId = 1;</code>
       *
       * @return The referenceId.
       */
      public long getReferenceId() {
        return referenceId_;
      }
      /**
       * <code>int64 referenceId = 1;</code>
       *
       * @param value The referenceId to set.
       * @return This builder for chaining.
       */
      public Builder setReferenceId(long value) {

        referenceId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int64 referenceId = 1;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearReferenceId() {

        referenceId_ = 0L;
        onChanged();
        return this;
      }

      private java.lang.Object messageType_ = "";
      /**
       * <code>string messageType = 2;</code>
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
       * <code>string messageType = 2;</code>
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
       * <code>string messageType = 2;</code>
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
       * <code>string messageType = 2;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearMessageType() {

        messageType_ = getDefaultInstance().getMessageType();
        onChanged();
        return this;
      }
      /**
       * <code>string messageType = 2;</code>
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

      // @@protoc_insertion_point(builder_scope:CommunicationTriggerRequest)
    }

    // @@protoc_insertion_point(class_scope:CommunicationTriggerRequest)
    private static final com.cpdss.common.generated.Common.CommunicationTriggerRequest
        DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.Common.CommunicationTriggerRequest();
    }

    public static com.cpdss.common.generated.Common.CommunicationTriggerRequest
        getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<CommunicationTriggerRequest> PARSER =
        new com.google.protobuf.AbstractParser<CommunicationTriggerRequest>() {
          @java.lang.Override
          public CommunicationTriggerRequest parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new CommunicationTriggerRequest(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<CommunicationTriggerRequest> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<CommunicationTriggerRequest> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.Common.CommunicationTriggerRequest
        getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
  }

  public interface CommunicationTriggerResponseOrBuilder
      extends
      // @@protoc_insertion_point(interface_extends:CommunicationTriggerResponse)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>string processId = 3;</code>
     *
     * @return The processId.
     */
    java.lang.String getProcessId();
    /**
     * <code>string processId = 3;</code>
     *
     * @return The bytes for processId.
     */
    com.google.protobuf.ByteString getProcessIdBytes();

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
  /**
   *
   *
   * <pre>
   * Communication trigger response
   * </pre>
   *
   * Protobuf type {@code CommunicationTriggerResponse}
   */
  public static final class CommunicationTriggerResponse
      extends com.google.protobuf.GeneratedMessageV3
      implements
      // @@protoc_insertion_point(message_implements:CommunicationTriggerResponse)
      CommunicationTriggerResponseOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use CommunicationTriggerResponse.newBuilder() to construct.
    private CommunicationTriggerResponse(
        com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private CommunicationTriggerResponse() {
      processId_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
      return new CommunicationTriggerResponse();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }

    private CommunicationTriggerResponse(
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

                processId_ = s;
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
      return com.cpdss.common.generated.Common
          .internal_static_CommunicationTriggerResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.Common
          .internal_static_CommunicationTriggerResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.Common.CommunicationTriggerResponse.class,
              com.cpdss.common.generated.Common.CommunicationTriggerResponse.Builder.class);
    }

    public static final int PROCESSID_FIELD_NUMBER = 3;
    private volatile java.lang.Object processId_;
    /**
     * <code>string processId = 3;</code>
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
     * <code>string processId = 3;</code>
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
      if (responseStatus_ != null) {
        output.writeMessage(2, getResponseStatus());
      }
      if (!getProcessIdBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, processId_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (responseStatus_ != null) {
        size += com.google.protobuf.CodedOutputStream.computeMessageSize(2, getResponseStatus());
      }
      if (!getProcessIdBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, processId_);
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
      if (!(obj instanceof com.cpdss.common.generated.Common.CommunicationTriggerResponse)) {
        return super.equals(obj);
      }
      com.cpdss.common.generated.Common.CommunicationTriggerResponse other =
          (com.cpdss.common.generated.Common.CommunicationTriggerResponse) obj;

      if (!getProcessId().equals(other.getProcessId())) return false;
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
      hash = (37 * hash) + PROCESSID_FIELD_NUMBER;
      hash = (53 * hash) + getProcessId().hashCode();
      if (hasResponseStatus()) {
        hash = (37 * hash) + RESPONSESTATUS_FIELD_NUMBER;
        hash = (53 * hash) + getResponseStatus().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cpdss.common.generated.Common.CommunicationTriggerResponse parseFrom(
        java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Common.CommunicationTriggerResponse parseFrom(
        java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.CommunicationTriggerResponse parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Common.CommunicationTriggerResponse parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.CommunicationTriggerResponse parseFrom(
        byte[] data) throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.cpdss.common.generated.Common.CommunicationTriggerResponse parseFrom(
        byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.CommunicationTriggerResponse parseFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Common.CommunicationTriggerResponse parseFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.CommunicationTriggerResponse parseDelimitedFrom(
        java.io.InputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Common.CommunicationTriggerResponse parseDelimitedFrom(
        java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
          PARSER, input, extensionRegistry);
    }

    public static com.cpdss.common.generated.Common.CommunicationTriggerResponse parseFrom(
        com.google.protobuf.CodedInputStream input) throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.cpdss.common.generated.Common.CommunicationTriggerResponse parseFrom(
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
        com.cpdss.common.generated.Common.CommunicationTriggerResponse prototype) {
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
    /**
     *
     *
     * <pre>
     * Communication trigger response
     * </pre>
     *
     * Protobuf type {@code CommunicationTriggerResponse}
     */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
        // @@protoc_insertion_point(builder_implements:CommunicationTriggerResponse)
        com.cpdss.common.generated.Common.CommunicationTriggerResponseOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.cpdss.common.generated.Common
            .internal_static_CommunicationTriggerResponse_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cpdss.common.generated.Common
            .internal_static_CommunicationTriggerResponse_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cpdss.common.generated.Common.CommunicationTriggerResponse.class,
                com.cpdss.common.generated.Common.CommunicationTriggerResponse.Builder.class);
      }

      // Construct using com.cpdss.common.generated.Common.CommunicationTriggerResponse.newBuilder()
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
        processId_ = "";

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
        return com.cpdss.common.generated.Common
            .internal_static_CommunicationTriggerResponse_descriptor;
      }

      @java.lang.Override
      public com.cpdss.common.generated.Common.CommunicationTriggerResponse
          getDefaultInstanceForType() {
        return com.cpdss.common.generated.Common.CommunicationTriggerResponse.getDefaultInstance();
      }

      @java.lang.Override
      public com.cpdss.common.generated.Common.CommunicationTriggerResponse build() {
        com.cpdss.common.generated.Common.CommunicationTriggerResponse result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cpdss.common.generated.Common.CommunicationTriggerResponse buildPartial() {
        com.cpdss.common.generated.Common.CommunicationTriggerResponse result =
            new com.cpdss.common.generated.Common.CommunicationTriggerResponse(this);
        result.processId_ = processId_;
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
        if (other instanceof com.cpdss.common.generated.Common.CommunicationTriggerResponse) {
          return mergeFrom((com.cpdss.common.generated.Common.CommunicationTriggerResponse) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(
          com.cpdss.common.generated.Common.CommunicationTriggerResponse other) {
        if (other
            == com.cpdss.common.generated.Common.CommunicationTriggerResponse.getDefaultInstance())
          return this;
        if (!other.getProcessId().isEmpty()) {
          processId_ = other.processId_;
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
        com.cpdss.common.generated.Common.CommunicationTriggerResponse parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage =
              (com.cpdss.common.generated.Common.CommunicationTriggerResponse)
                  e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private java.lang.Object processId_ = "";
      /**
       * <code>string processId = 3;</code>
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
       * <code>string processId = 3;</code>
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
       * <code>string processId = 3;</code>
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
       * <code>string processId = 3;</code>
       *
       * @return This builder for chaining.
       */
      public Builder clearProcessId() {

        processId_ = getDefaultInstance().getProcessId();
        onChanged();
        return this;
      }
      /**
       * <code>string processId = 3;</code>
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

      // @@protoc_insertion_point(builder_scope:CommunicationTriggerResponse)
    }

    // @@protoc_insertion_point(class_scope:CommunicationTriggerResponse)
    private static final com.cpdss.common.generated.Common.CommunicationTriggerResponse
        DEFAULT_INSTANCE;

    static {
      DEFAULT_INSTANCE = new com.cpdss.common.generated.Common.CommunicationTriggerResponse();
    }

    public static com.cpdss.common.generated.Common.CommunicationTriggerResponse
        getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<CommunicationTriggerResponse> PARSER =
        new com.google.protobuf.AbstractParser<CommunicationTriggerResponse>() {
          @java.lang.Override
          public CommunicationTriggerResponse parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return new CommunicationTriggerResponse(input, extensionRegistry);
          }
        };

    public static com.google.protobuf.Parser<CommunicationTriggerResponse> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<CommunicationTriggerResponse> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cpdss.common.generated.Common.CommunicationTriggerResponse
        getDefaultInstanceForType() {
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
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_RuleDropDownMaster_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_RuleDropDownMaster_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_CargoHistoryOpsRequest_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_CargoHistoryOpsRequest_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_CargoHistoryResponse_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_CargoHistoryResponse_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_CargoHistoryOps_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_CargoHistoryOps_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_CommunicationDataGetRequest_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_CommunicationDataGetRequest_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_CommunicationDataUpdateRequest_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_CommunicationDataUpdateRequest_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_CommunicationDataResponse_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_CommunicationDataResponse_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_DependentProcessCheckRequestComm_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_DependentProcessCheckRequestComm_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_CommunicationCheckResponse_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_CommunicationCheckResponse_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_CommunicationStatusCheckRequest_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_CommunicationStatusCheckRequest_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_CommunicationTriggerRequest_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_CommunicationTriggerRequest_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_CommunicationTriggerResponse_descriptor;
  private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_CommunicationTriggerResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }

  private static com.google.protobuf.Descriptors.FileDescriptor descriptor;

  static {
    java.lang.String[] descriptorData = {
      "\n\014common.proto\"W\n\016ResponseStatus\022\016\n\006stat"
          + "us\030\001 \001(\t\022\017\n\007message\030\002 \001(\t\022\014\n\004code\030\003 \001(\t\022"
          + "\026\n\016httpStatusCode\030\004 \001(\005\"\352\002\n\rBillOfLaddin"
          + "g\022\n\n\002id\030\001 \001(\003\022\016\n\006portId\030\002 \001(\003\022\031\n\021cargoNo"
          + "minationId\030\003 \001(\003\022\024\n\014quantityBbls\030\004 \001(\t\022\022"
          + "\n\nquantityMt\030\005 \001(\t\022\022\n\nquantityKl\030\006 \001(\t\022\013"
          + "\n\003api\030\007 \001(\t\022\023\n\013temperature\030\010 \001(\t\022\022\n\ncarg"
          + "oColor\030\t \001(\t\022\021\n\tcargoName\030\n \001(\t\022\030\n\020cargo"
          + "Abbrevation\030\013 \001(\t\022\023\n\013loadingPort\030\014 \003(\003\022\017"
          + "\n\007cargoId\030\r \001(\003\022\017\n\007blRefNo\030\016 \001(\t\022\022\n\nquan"
          + "tityLT\030\017 \001(\t\022\026\n\016portRotationId\030\020 \001(\003\022\036\n\026"
          + "loadingPortRotationIds\030\021 \003(\003\"2\n\tRulePlan"
          + "s\022\016\n\006header\030\001 \001(\t\022\025\n\005rules\030\002 \003(\0132\006.Rules"
          + "\"\362\001\n\005Rules\022\n\n\002id\030\001 \001(\t\022\016\n\006enable\030\002 \001(\010\022\017"
          + "\n\007disable\030\003 \001(\010\022\031\n\021displayInSettings\030\004 \001"
          + "(\010\022\020\n\010ruleType\030\005 \001(\t\022\034\n\006inputs\030\006 \003(\0132\014.R"
          + "ulesInputs\022\026\n\016ruleTemplateId\030\007 \001(\t\022\025\n\rve"
          + "sselRuleXId\030\010 \001(\t\022\022\n\nisHardRule\030\t \001(\010\022\030\n"
          + "\020numericPrecision\030\n \001(\003\022\024\n\014numericScale\030"
          + "\013 \001(\003\"\314\001\n\013RulesInputs\022\016\n\006prefix\030\001 \001(\t\022\024\n"
          + "\014defaultValue\030\002 \001(\t\022\014\n\004type\030\003 \001(\t\022\013\n\003max"
          + "\030\004 \001(\t\022\013\n\003min\030\005 \001(\t\022\r\n\005value\030\006 \001(\t\022\016\n\006su"
          + "ffix\030\007 \001(\t\022\n\n\002id\030\010 \001(\t\022/\n\022ruleDropDownMa"
          + "ster\030\t \003(\0132\023.RuleDropDownMaster\022\023\n\013isMan"
          + "datory\030\n \001(\010\"/\n\022RuleDropDownMaster\022\n\n\002id"
          + "\030\001 \001(\003\022\r\n\005value\030\002 \001(\t\"<\n\026CargoHistoryOps"
          + "Request\022\020\n\010voyageId\030\001 \001(\003\022\020\n\010vesselId\030\002 "
          + "\001(\003\"g\n\024CargoHistoryResponse\022\'\n\016responseS"
          + "tatus\030\001 \001(\0132\017.ResponseStatus\022&\n\014cargoHis"
          + "tory\030\002 \003(\0132\020.CargoHistoryOps\"\275\001\n\017CargoHi"
          + "storyOps\022\016\n\006tankId\030\001 \001(\003\022\013\n\003api\030\002 \001(\t\022\023\n"
          + "\013temperature\030\003 \001(\t\022\031\n\021cargoNominationId\030"
          + "\004 \001(\003\022\017\n\007cargoId\030\005 \001(\003\022\016\n\006portId\030\006 \001(\003\022\020"
          + "\n\010quantity\030\007 \001(\t\022\022\n\nupdateDate\030\010 \001(\t\022\026\n\016"
          + "portRotationId\030\t \001(\003\"<\n\033CommunicationDat"
          + "aGetRequest\022\n\n\002id\030\001 \003(\003\022\021\n\ttableName\030\002 \001"
          + "(\t\"E\n\036CommunicationDataUpdateRequest\022\020\n\010"
          + "dataJson\030\001 \001(\t\022\021\n\ttableName\030\002 \001(\t\"V\n\031Com"
          + "municationDataResponse\022\020\n\010dataJson\030\001 \001(\t"
          + "\022\'\n\016responseStatus\030\002 \001(\0132\017.ResponseStatu"
          + "s\">\n DependentProcessCheckRequestComm\022\032\n"
          + "\022dependantProcessId\030\003 \001(\t\"Z\n\032Communicati"
          + "onCheckResponse\022\023\n\013isCompleted\030\001 \001(\010\022\'\n\016"
          + "responseStatus\030\002 \001(\0132\017.ResponseStatus\"I\n"
          + "\037CommunicationStatusCheckRequest\022\023\n\013refe"
          + "renceId\030\001 \001(\003\022\021\n\treference\030\002 \001(\t\"G\n\033Comm"
          + "unicationTriggerRequest\022\023\n\013referenceId\030\001"
          + " \001(\003\022\023\n\013messageType\030\002 \001(\t\"Z\n\034Communicati"
          + "onTriggerResponse\022\021\n\tprocessId\030\003 \001(\t\022\'\n\016"
          + "responseStatus\030\002 \001(\0132\017.ResponseStatus*E\n"
          + "\rPLANNING_TYPE\022\013\n\007VALUE_A\020\000\022\022\n\016LOADABLE_"
          + "STUDY\020\001\022\023\n\017DISCHARGE_STUDY\020\002*H\n\013MachineT"
          + "ype\022\t\n\005EMPTY\020\000\022\017\n\013VESSEL_PUMP\020\001\022\014\n\010MANIF"
          + "OLD\020\002\022\017\n\013BOTTOM_LINE\020\003*S\n\010COW_TYPE\022\022\n\016EM"
          + "PTY_COW_TYPE\020\000\022\013\n\007ALL_COW\020\001\022\016\n\nBOTTOM_CO"
          + "W\020\002\022\013\n\007TOP_COW\020\003\022\t\n\005CARGO\020\004*B\n\017COW_OPTIO"
          + "N_TYPE\022\031\n\025EMPTY_COW_OPTION_TYPE\020\000\022\010\n\004AUT"
          + "O\020\001\022\n\n\006MANUAL\020\002B\036\n\032com.cpdss.common.gene"
          + "ratedP\000b\006proto3"
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
              "CargoNominationId",
              "QuantityBbls",
              "QuantityMt",
              "QuantityKl",
              "Api",
              "Temperature",
              "CargoColor",
              "CargoName",
              "CargoAbbrevation",
              "LoadingPort",
              "CargoId",
              "BlRefNo",
              "QuantityLT",
              "PortRotationId",
              "LoadingPortRotationIds",
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
              "DisplayInSettings",
              "RuleType",
              "Inputs",
              "RuleTemplateId",
              "VesselRuleXId",
              "IsHardRule",
              "NumericPrecision",
              "NumericScale",
            });
    internal_static_RulesInputs_descriptor = getDescriptor().getMessageTypes().get(4);
    internal_static_RulesInputs_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_RulesInputs_descriptor,
            new java.lang.String[] {
              "Prefix",
              "DefaultValue",
              "Type",
              "Max",
              "Min",
              "Value",
              "Suffix",
              "Id",
              "RuleDropDownMaster",
              "IsMandatory",
            });
    internal_static_RuleDropDownMaster_descriptor = getDescriptor().getMessageTypes().get(5);
    internal_static_RuleDropDownMaster_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_RuleDropDownMaster_descriptor,
            new java.lang.String[] {
              "Id", "Value",
            });
    internal_static_CargoHistoryOpsRequest_descriptor = getDescriptor().getMessageTypes().get(6);
    internal_static_CargoHistoryOpsRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_CargoHistoryOpsRequest_descriptor,
            new java.lang.String[] {
              "VoyageId", "VesselId",
            });
    internal_static_CargoHistoryResponse_descriptor = getDescriptor().getMessageTypes().get(7);
    internal_static_CargoHistoryResponse_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_CargoHistoryResponse_descriptor,
            new java.lang.String[] {
              "ResponseStatus", "CargoHistory",
            });
    internal_static_CargoHistoryOps_descriptor = getDescriptor().getMessageTypes().get(8);
    internal_static_CargoHistoryOps_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_CargoHistoryOps_descriptor,
            new java.lang.String[] {
              "TankId",
              "Api",
              "Temperature",
              "CargoNominationId",
              "CargoId",
              "PortId",
              "Quantity",
              "UpdateDate",
              "PortRotationId",
            });
    internal_static_CommunicationDataGetRequest_descriptor =
        getDescriptor().getMessageTypes().get(9);
    internal_static_CommunicationDataGetRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_CommunicationDataGetRequest_descriptor,
            new java.lang.String[] {
              "Id", "TableName",
            });
    internal_static_CommunicationDataUpdateRequest_descriptor =
        getDescriptor().getMessageTypes().get(10);
    internal_static_CommunicationDataUpdateRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_CommunicationDataUpdateRequest_descriptor,
            new java.lang.String[] {
              "DataJson", "TableName",
            });
    internal_static_CommunicationDataResponse_descriptor =
        getDescriptor().getMessageTypes().get(11);
    internal_static_CommunicationDataResponse_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_CommunicationDataResponse_descriptor,
            new java.lang.String[] {
              "DataJson", "ResponseStatus",
            });
    internal_static_DependentProcessCheckRequestComm_descriptor =
        getDescriptor().getMessageTypes().get(12);
    internal_static_DependentProcessCheckRequestComm_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_DependentProcessCheckRequestComm_descriptor,
            new java.lang.String[] {
              "DependantProcessId",
            });
    internal_static_CommunicationCheckResponse_descriptor =
        getDescriptor().getMessageTypes().get(13);
    internal_static_CommunicationCheckResponse_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_CommunicationCheckResponse_descriptor,
            new java.lang.String[] {
              "IsCompleted", "ResponseStatus",
            });
    internal_static_CommunicationStatusCheckRequest_descriptor =
        getDescriptor().getMessageTypes().get(14);
    internal_static_CommunicationStatusCheckRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_CommunicationStatusCheckRequest_descriptor,
            new java.lang.String[] {
              "ReferenceId", "Reference",
            });
    internal_static_CommunicationTriggerRequest_descriptor =
        getDescriptor().getMessageTypes().get(15);
    internal_static_CommunicationTriggerRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_CommunicationTriggerRequest_descriptor,
            new java.lang.String[] {
              "ReferenceId", "MessageType",
            });
    internal_static_CommunicationTriggerResponse_descriptor =
        getDescriptor().getMessageTypes().get(16);
    internal_static_CommunicationTriggerResponse_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_CommunicationTriggerResponse_descriptor,
            new java.lang.String[] {
              "ProcessId", "ResponseStatus",
            });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
