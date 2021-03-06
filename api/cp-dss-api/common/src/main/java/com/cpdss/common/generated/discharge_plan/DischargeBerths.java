/* Licensed at AlphaOri Technologies */
package com.cpdss.common.generated.discharge_plan;

/** Protobuf type {@code DischargeBerths} */
public final class DischargeBerths extends com.google.protobuf.GeneratedMessageV3
    implements
    // @@protoc_insertion_point(message_implements:DischargeBerths)
    DischargeBerthsOrBuilder {
  private static final long serialVersionUID = 0L;
  // Use DischargeBerths.newBuilder() to construct.
  private DischargeBerths(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }

  private DischargeBerths() {
    depth_ = "";
    maxManifoldHeight_ = "";
    maxManifoldPressure_ = "";
    hoseConnections_ = "";
    seaDraftLimitation_ = "";
    airDraftLimitation_ = "";
    lineDisplacement_ = "";
    specialRegulationRestriction_ = "";
    itemsToBeAgreedWith_ = "";
    displacement_ = "";
    freshCrudeOilQuantity_ = "";
    freshCrudeOilTime_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
    return new DischargeBerths();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }

  private DischargeBerths(
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
              dischargeInfoId_ = input.readInt64();
              break;
            }
          case 24:
            {
              berthId_ = input.readInt64();
              break;
            }
          case 34:
            {
              java.lang.String s = input.readStringRequireUtf8();

              depth_ = s;
              break;
            }
          case 42:
            {
              java.lang.String s = input.readStringRequireUtf8();

              maxManifoldHeight_ = s;
              break;
            }
          case 50:
            {
              java.lang.String s = input.readStringRequireUtf8();

              maxManifoldPressure_ = s;
              break;
            }
          case 58:
            {
              java.lang.String s = input.readStringRequireUtf8();

              hoseConnections_ = s;
              break;
            }
          case 66:
            {
              java.lang.String s = input.readStringRequireUtf8();

              seaDraftLimitation_ = s;
              break;
            }
          case 74:
            {
              java.lang.String s = input.readStringRequireUtf8();

              airDraftLimitation_ = s;
              break;
            }
          case 80:
            {
              airPurge_ = input.readBool();
              break;
            }
          case 88:
            {
              cargoCirculation_ = input.readBool();
              break;
            }
          case 98:
            {
              java.lang.String s = input.readStringRequireUtf8();

              lineDisplacement_ = s;
              break;
            }
          case 106:
            {
              java.lang.String s = input.readStringRequireUtf8();

              specialRegulationRestriction_ = s;
              break;
            }
          case 114:
            {
              java.lang.String s = input.readStringRequireUtf8();

              itemsToBeAgreedWith_ = s;
              break;
            }
          case 122:
            {
              java.lang.String s = input.readStringRequireUtf8();

              displacement_ = s;
              break;
            }
          case 128:
            {
              needFlushingOilAndCrudeStorage_ = input.readBool();
              break;
            }
          case 136:
            {
              enableDayLightRestriction_ = input.readBool();
              break;
            }
          case 146:
            {
              java.lang.String s = input.readStringRequireUtf8();

              freshCrudeOilQuantity_ = s;
              break;
            }
          case 154:
            {
              java.lang.String s = input.readStringRequireUtf8();

              freshCrudeOilTime_ = s;
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
    return com.cpdss.common.generated.discharge_plan.DischargePlanModels
        .internal_static_DischargeBerths_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.cpdss.common.generated.discharge_plan.DischargePlanModels
        .internal_static_DischargeBerths_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.cpdss.common.generated.discharge_plan.DischargeBerths.class,
            com.cpdss.common.generated.discharge_plan.DischargeBerths.Builder.class);
  }

  public static final int ID_FIELD_NUMBER = 1;
  private long id_;
  /**
   *
   *
   * <pre>
   * primary key
   * </pre>
   *
   * <code>int64 id = 1;</code>
   *
   * @return The id.
   */
  public long getId() {
    return id_;
  }

  public static final int DISCHARGEINFOID_FIELD_NUMBER = 2;
  private long dischargeInfoId_;
  /**
   * <code>int64 dischargeInfoId = 2;</code>
   *
   * @return The dischargeInfoId.
   */
  public long getDischargeInfoId() {
    return dischargeInfoId_;
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

  public static final int DEPTH_FIELD_NUMBER = 4;
  private volatile java.lang.Object depth_;
  /**
   * <code>string depth = 4;</code>
   *
   * @return The depth.
   */
  public java.lang.String getDepth() {
    java.lang.Object ref = depth_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      depth_ = s;
      return s;
    }
  }
  /**
   * <code>string depth = 4;</code>
   *
   * @return The bytes for depth.
   */
  public com.google.protobuf.ByteString getDepthBytes() {
    java.lang.Object ref = depth_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
      depth_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int MAXMANIFOLDHEIGHT_FIELD_NUMBER = 5;
  private volatile java.lang.Object maxManifoldHeight_;
  /**
   * <code>string maxManifoldHeight = 5;</code>
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
   * <code>string maxManifoldHeight = 5;</code>
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

  public static final int MAXMANIFOLDPRESSURE_FIELD_NUMBER = 6;
  private volatile java.lang.Object maxManifoldPressure_;
  /**
   * <code>string maxManifoldPressure = 6;</code>
   *
   * @return The maxManifoldPressure.
   */
  public java.lang.String getMaxManifoldPressure() {
    java.lang.Object ref = maxManifoldPressure_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      maxManifoldPressure_ = s;
      return s;
    }
  }
  /**
   * <code>string maxManifoldPressure = 6;</code>
   *
   * @return The bytes for maxManifoldPressure.
   */
  public com.google.protobuf.ByteString getMaxManifoldPressureBytes() {
    java.lang.Object ref = maxManifoldPressure_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
      maxManifoldPressure_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int HOSECONNECTIONS_FIELD_NUMBER = 7;
  private volatile java.lang.Object hoseConnections_;
  /**
   * <code>string hoseConnections = 7;</code>
   *
   * @return The hoseConnections.
   */
  public java.lang.String getHoseConnections() {
    java.lang.Object ref = hoseConnections_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      hoseConnections_ = s;
      return s;
    }
  }
  /**
   * <code>string hoseConnections = 7;</code>
   *
   * @return The bytes for hoseConnections.
   */
  public com.google.protobuf.ByteString getHoseConnectionsBytes() {
    java.lang.Object ref = hoseConnections_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
      hoseConnections_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int SEADRAFTLIMITATION_FIELD_NUMBER = 8;
  private volatile java.lang.Object seaDraftLimitation_;
  /**
   * <code>string seaDraftLimitation = 8;</code>
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
   * <code>string seaDraftLimitation = 8;</code>
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

  public static final int AIRDRAFTLIMITATION_FIELD_NUMBER = 9;
  private volatile java.lang.Object airDraftLimitation_;
  /**
   * <code>string airDraftLimitation = 9;</code>
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
   * <code>string airDraftLimitation = 9;</code>
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

  public static final int AIRPURGE_FIELD_NUMBER = 10;
  private boolean airPurge_;
  /**
   * <code>bool airPurge = 10;</code>
   *
   * @return The airPurge.
   */
  public boolean getAirPurge() {
    return airPurge_;
  }

  public static final int CARGOCIRCULATION_FIELD_NUMBER = 11;
  private boolean cargoCirculation_;
  /**
   * <code>bool cargoCirculation = 11;</code>
   *
   * @return The cargoCirculation.
   */
  public boolean getCargoCirculation() {
    return cargoCirculation_;
  }

  public static final int LINEDISPLACEMENT_FIELD_NUMBER = 12;
  private volatile java.lang.Object lineDisplacement_;
  /**
   * <code>string lineDisplacement = 12;</code>
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
   * <code>string lineDisplacement = 12;</code>
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

  public static final int SPECIALREGULATIONRESTRICTION_FIELD_NUMBER = 13;
  private volatile java.lang.Object specialRegulationRestriction_;
  /**
   * <code>string specialRegulationRestriction = 13;</code>
   *
   * @return The specialRegulationRestriction.
   */
  public java.lang.String getSpecialRegulationRestriction() {
    java.lang.Object ref = specialRegulationRestriction_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      specialRegulationRestriction_ = s;
      return s;
    }
  }
  /**
   * <code>string specialRegulationRestriction = 13;</code>
   *
   * @return The bytes for specialRegulationRestriction.
   */
  public com.google.protobuf.ByteString getSpecialRegulationRestrictionBytes() {
    java.lang.Object ref = specialRegulationRestriction_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
      specialRegulationRestriction_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int ITEMSTOBEAGREEDWITH_FIELD_NUMBER = 14;
  private volatile java.lang.Object itemsToBeAgreedWith_;
  /**
   * <code>string itemsToBeAgreedWith = 14;</code>
   *
   * @return The itemsToBeAgreedWith.
   */
  public java.lang.String getItemsToBeAgreedWith() {
    java.lang.Object ref = itemsToBeAgreedWith_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      itemsToBeAgreedWith_ = s;
      return s;
    }
  }
  /**
   * <code>string itemsToBeAgreedWith = 14;</code>
   *
   * @return The bytes for itemsToBeAgreedWith.
   */
  public com.google.protobuf.ByteString getItemsToBeAgreedWithBytes() {
    java.lang.Object ref = itemsToBeAgreedWith_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
      itemsToBeAgreedWith_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int DISPLACEMENT_FIELD_NUMBER = 15;
  private volatile java.lang.Object displacement_;
  /**
   * <code>string displacement = 15;</code>
   *
   * @return The displacement.
   */
  public java.lang.String getDisplacement() {
    java.lang.Object ref = displacement_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      displacement_ = s;
      return s;
    }
  }
  /**
   * <code>string displacement = 15;</code>
   *
   * @return The bytes for displacement.
   */
  public com.google.protobuf.ByteString getDisplacementBytes() {
    java.lang.Object ref = displacement_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
      displacement_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int NEEDFLUSHINGOILANDCRUDESTORAGE_FIELD_NUMBER = 16;
  private boolean needFlushingOilAndCrudeStorage_;
  /**
   * <code>bool needFlushingOilAndCrudeStorage = 16;</code>
   *
   * @return The needFlushingOilAndCrudeStorage.
   */
  public boolean getNeedFlushingOilAndCrudeStorage() {
    return needFlushingOilAndCrudeStorage_;
  }

  public static final int ENABLEDAYLIGHTRESTRICTION_FIELD_NUMBER = 17;
  private boolean enableDayLightRestriction_;
  /**
   * <code>bool enableDayLightRestriction = 17;</code>
   *
   * @return The enableDayLightRestriction.
   */
  public boolean getEnableDayLightRestriction() {
    return enableDayLightRestriction_;
  }

  public static final int FRESHCRUDEOILQUANTITY_FIELD_NUMBER = 18;
  private volatile java.lang.Object freshCrudeOilQuantity_;
  /**
   * <code>string freshCrudeOilQuantity = 18;</code>
   *
   * @return The freshCrudeOilQuantity.
   */
  public java.lang.String getFreshCrudeOilQuantity() {
    java.lang.Object ref = freshCrudeOilQuantity_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      freshCrudeOilQuantity_ = s;
      return s;
    }
  }
  /**
   * <code>string freshCrudeOilQuantity = 18;</code>
   *
   * @return The bytes for freshCrudeOilQuantity.
   */
  public com.google.protobuf.ByteString getFreshCrudeOilQuantityBytes() {
    java.lang.Object ref = freshCrudeOilQuantity_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
      freshCrudeOilQuantity_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int FRESHCRUDEOILTIME_FIELD_NUMBER = 19;
  private volatile java.lang.Object freshCrudeOilTime_;
  /**
   * <code>string freshCrudeOilTime = 19;</code>
   *
   * @return The freshCrudeOilTime.
   */
  public java.lang.String getFreshCrudeOilTime() {
    java.lang.Object ref = freshCrudeOilTime_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      freshCrudeOilTime_ = s;
      return s;
    }
  }
  /**
   * <code>string freshCrudeOilTime = 19;</code>
   *
   * @return The bytes for freshCrudeOilTime.
   */
  public com.google.protobuf.ByteString getFreshCrudeOilTimeBytes() {
    java.lang.Object ref = freshCrudeOilTime_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
      freshCrudeOilTime_ = b;
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
    if (dischargeInfoId_ != 0L) {
      output.writeInt64(2, dischargeInfoId_);
    }
    if (berthId_ != 0L) {
      output.writeInt64(3, berthId_);
    }
    if (!getDepthBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, depth_);
    }
    if (!getMaxManifoldHeightBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 5, maxManifoldHeight_);
    }
    if (!getMaxManifoldPressureBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 6, maxManifoldPressure_);
    }
    if (!getHoseConnectionsBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 7, hoseConnections_);
    }
    if (!getSeaDraftLimitationBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 8, seaDraftLimitation_);
    }
    if (!getAirDraftLimitationBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 9, airDraftLimitation_);
    }
    if (airPurge_ != false) {
      output.writeBool(10, airPurge_);
    }
    if (cargoCirculation_ != false) {
      output.writeBool(11, cargoCirculation_);
    }
    if (!getLineDisplacementBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 12, lineDisplacement_);
    }
    if (!getSpecialRegulationRestrictionBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 13, specialRegulationRestriction_);
    }
    if (!getItemsToBeAgreedWithBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 14, itemsToBeAgreedWith_);
    }
    if (!getDisplacementBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 15, displacement_);
    }
    if (needFlushingOilAndCrudeStorage_ != false) {
      output.writeBool(16, needFlushingOilAndCrudeStorage_);
    }
    if (enableDayLightRestriction_ != false) {
      output.writeBool(17, enableDayLightRestriction_);
    }
    if (!getFreshCrudeOilQuantityBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 18, freshCrudeOilQuantity_);
    }
    if (!getFreshCrudeOilTimeBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 19, freshCrudeOilTime_);
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
    if (dischargeInfoId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream.computeInt64Size(2, dischargeInfoId_);
    }
    if (berthId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream.computeInt64Size(3, berthId_);
    }
    if (!getDepthBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, depth_);
    }
    if (!getMaxManifoldHeightBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, maxManifoldHeight_);
    }
    if (!getMaxManifoldPressureBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(6, maxManifoldPressure_);
    }
    if (!getHoseConnectionsBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(7, hoseConnections_);
    }
    if (!getSeaDraftLimitationBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(8, seaDraftLimitation_);
    }
    if (!getAirDraftLimitationBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(9, airDraftLimitation_);
    }
    if (airPurge_ != false) {
      size += com.google.protobuf.CodedOutputStream.computeBoolSize(10, airPurge_);
    }
    if (cargoCirculation_ != false) {
      size += com.google.protobuf.CodedOutputStream.computeBoolSize(11, cargoCirculation_);
    }
    if (!getLineDisplacementBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(12, lineDisplacement_);
    }
    if (!getSpecialRegulationRestrictionBytes().isEmpty()) {
      size +=
          com.google.protobuf.GeneratedMessageV3.computeStringSize(
              13, specialRegulationRestriction_);
    }
    if (!getItemsToBeAgreedWithBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(14, itemsToBeAgreedWith_);
    }
    if (!getDisplacementBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(15, displacement_);
    }
    if (needFlushingOilAndCrudeStorage_ != false) {
      size +=
          com.google.protobuf.CodedOutputStream.computeBoolSize(
              16, needFlushingOilAndCrudeStorage_);
    }
    if (enableDayLightRestriction_ != false) {
      size += com.google.protobuf.CodedOutputStream.computeBoolSize(17, enableDayLightRestriction_);
    }
    if (!getFreshCrudeOilQuantityBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(18, freshCrudeOilQuantity_);
    }
    if (!getFreshCrudeOilTimeBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(19, freshCrudeOilTime_);
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
    if (!(obj instanceof com.cpdss.common.generated.discharge_plan.DischargeBerths)) {
      return super.equals(obj);
    }
    com.cpdss.common.generated.discharge_plan.DischargeBerths other =
        (com.cpdss.common.generated.discharge_plan.DischargeBerths) obj;

    if (getId() != other.getId()) return false;
    if (getDischargeInfoId() != other.getDischargeInfoId()) return false;
    if (getBerthId() != other.getBerthId()) return false;
    if (!getDepth().equals(other.getDepth())) return false;
    if (!getMaxManifoldHeight().equals(other.getMaxManifoldHeight())) return false;
    if (!getMaxManifoldPressure().equals(other.getMaxManifoldPressure())) return false;
    if (!getHoseConnections().equals(other.getHoseConnections())) return false;
    if (!getSeaDraftLimitation().equals(other.getSeaDraftLimitation())) return false;
    if (!getAirDraftLimitation().equals(other.getAirDraftLimitation())) return false;
    if (getAirPurge() != other.getAirPurge()) return false;
    if (getCargoCirculation() != other.getCargoCirculation()) return false;
    if (!getLineDisplacement().equals(other.getLineDisplacement())) return false;
    if (!getSpecialRegulationRestriction().equals(other.getSpecialRegulationRestriction()))
      return false;
    if (!getItemsToBeAgreedWith().equals(other.getItemsToBeAgreedWith())) return false;
    if (!getDisplacement().equals(other.getDisplacement())) return false;
    if (getNeedFlushingOilAndCrudeStorage() != other.getNeedFlushingOilAndCrudeStorage())
      return false;
    if (getEnableDayLightRestriction() != other.getEnableDayLightRestriction()) return false;
    if (!getFreshCrudeOilQuantity().equals(other.getFreshCrudeOilQuantity())) return false;
    if (!getFreshCrudeOilTime().equals(other.getFreshCrudeOilTime())) return false;
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
    hash = (37 * hash) + DISCHARGEINFOID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getDischargeInfoId());
    hash = (37 * hash) + BERTHID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getBerthId());
    hash = (37 * hash) + DEPTH_FIELD_NUMBER;
    hash = (53 * hash) + getDepth().hashCode();
    hash = (37 * hash) + MAXMANIFOLDHEIGHT_FIELD_NUMBER;
    hash = (53 * hash) + getMaxManifoldHeight().hashCode();
    hash = (37 * hash) + MAXMANIFOLDPRESSURE_FIELD_NUMBER;
    hash = (53 * hash) + getMaxManifoldPressure().hashCode();
    hash = (37 * hash) + HOSECONNECTIONS_FIELD_NUMBER;
    hash = (53 * hash) + getHoseConnections().hashCode();
    hash = (37 * hash) + SEADRAFTLIMITATION_FIELD_NUMBER;
    hash = (53 * hash) + getSeaDraftLimitation().hashCode();
    hash = (37 * hash) + AIRDRAFTLIMITATION_FIELD_NUMBER;
    hash = (53 * hash) + getAirDraftLimitation().hashCode();
    hash = (37 * hash) + AIRPURGE_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(getAirPurge());
    hash = (37 * hash) + CARGOCIRCULATION_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(getCargoCirculation());
    hash = (37 * hash) + LINEDISPLACEMENT_FIELD_NUMBER;
    hash = (53 * hash) + getLineDisplacement().hashCode();
    hash = (37 * hash) + SPECIALREGULATIONRESTRICTION_FIELD_NUMBER;
    hash = (53 * hash) + getSpecialRegulationRestriction().hashCode();
    hash = (37 * hash) + ITEMSTOBEAGREEDWITH_FIELD_NUMBER;
    hash = (53 * hash) + getItemsToBeAgreedWith().hashCode();
    hash = (37 * hash) + DISPLACEMENT_FIELD_NUMBER;
    hash = (53 * hash) + getDisplacement().hashCode();
    hash = (37 * hash) + NEEDFLUSHINGOILANDCRUDESTORAGE_FIELD_NUMBER;
    hash =
        (53 * hash) + com.google.protobuf.Internal.hashBoolean(getNeedFlushingOilAndCrudeStorage());
    hash = (37 * hash) + ENABLEDAYLIGHTRESTRICTION_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(getEnableDayLightRestriction());
    hash = (37 * hash) + FRESHCRUDEOILQUANTITY_FIELD_NUMBER;
    hash = (53 * hash) + getFreshCrudeOilQuantity().hashCode();
    hash = (37 * hash) + FRESHCRUDEOILTIME_FIELD_NUMBER;
    hash = (53 * hash) + getFreshCrudeOilTime().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.cpdss.common.generated.discharge_plan.DischargeBerths parseFrom(
      java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargeBerths parseFrom(
      java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargeBerths parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargeBerths parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargeBerths parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargeBerths parseFrom(
      byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargeBerths parseFrom(
      java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargeBerths parseFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargeBerths parseDelimitedFrom(
      java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargeBerths parseDelimitedFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargeBerths parseFrom(
      com.google.protobuf.CodedInputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargeBerths parseFrom(
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
      com.cpdss.common.generated.discharge_plan.DischargeBerths prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /** Protobuf type {@code DischargeBerths} */
  public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
      implements
      // @@protoc_insertion_point(builder_implements:DischargeBerths)
      com.cpdss.common.generated.discharge_plan.DischargeBerthsOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanModels
          .internal_static_DischargeBerths_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanModels
          .internal_static_DischargeBerths_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.discharge_plan.DischargeBerths.class,
              com.cpdss.common.generated.discharge_plan.DischargeBerths.Builder.class);
    }

    // Construct using com.cpdss.common.generated.discharge_plan.DischargeBerths.newBuilder()
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

      dischargeInfoId_ = 0L;

      berthId_ = 0L;

      depth_ = "";

      maxManifoldHeight_ = "";

      maxManifoldPressure_ = "";

      hoseConnections_ = "";

      seaDraftLimitation_ = "";

      airDraftLimitation_ = "";

      airPurge_ = false;

      cargoCirculation_ = false;

      lineDisplacement_ = "";

      specialRegulationRestriction_ = "";

      itemsToBeAgreedWith_ = "";

      displacement_ = "";

      needFlushingOilAndCrudeStorage_ = false;

      enableDayLightRestriction_ = false;

      freshCrudeOilQuantity_ = "";

      freshCrudeOilTime_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanModels
          .internal_static_DischargeBerths_descriptor;
    }

    @java.lang.Override
    public com.cpdss.common.generated.discharge_plan.DischargeBerths getDefaultInstanceForType() {
      return com.cpdss.common.generated.discharge_plan.DischargeBerths.getDefaultInstance();
    }

    @java.lang.Override
    public com.cpdss.common.generated.discharge_plan.DischargeBerths build() {
      com.cpdss.common.generated.discharge_plan.DischargeBerths result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.cpdss.common.generated.discharge_plan.DischargeBerths buildPartial() {
      com.cpdss.common.generated.discharge_plan.DischargeBerths result =
          new com.cpdss.common.generated.discharge_plan.DischargeBerths(this);
      result.id_ = id_;
      result.dischargeInfoId_ = dischargeInfoId_;
      result.berthId_ = berthId_;
      result.depth_ = depth_;
      result.maxManifoldHeight_ = maxManifoldHeight_;
      result.maxManifoldPressure_ = maxManifoldPressure_;
      result.hoseConnections_ = hoseConnections_;
      result.seaDraftLimitation_ = seaDraftLimitation_;
      result.airDraftLimitation_ = airDraftLimitation_;
      result.airPurge_ = airPurge_;
      result.cargoCirculation_ = cargoCirculation_;
      result.lineDisplacement_ = lineDisplacement_;
      result.specialRegulationRestriction_ = specialRegulationRestriction_;
      result.itemsToBeAgreedWith_ = itemsToBeAgreedWith_;
      result.displacement_ = displacement_;
      result.needFlushingOilAndCrudeStorage_ = needFlushingOilAndCrudeStorage_;
      result.enableDayLightRestriction_ = enableDayLightRestriction_;
      result.freshCrudeOilQuantity_ = freshCrudeOilQuantity_;
      result.freshCrudeOilTime_ = freshCrudeOilTime_;
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
        com.google.protobuf.Descriptors.FieldDescriptor field, int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }

    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field, java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.cpdss.common.generated.discharge_plan.DischargeBerths) {
        return mergeFrom((com.cpdss.common.generated.discharge_plan.DischargeBerths) other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.cpdss.common.generated.discharge_plan.DischargeBerths other) {
      if (other == com.cpdss.common.generated.discharge_plan.DischargeBerths.getDefaultInstance())
        return this;
      if (other.getId() != 0L) {
        setId(other.getId());
      }
      if (other.getDischargeInfoId() != 0L) {
        setDischargeInfoId(other.getDischargeInfoId());
      }
      if (other.getBerthId() != 0L) {
        setBerthId(other.getBerthId());
      }
      if (!other.getDepth().isEmpty()) {
        depth_ = other.depth_;
        onChanged();
      }
      if (!other.getMaxManifoldHeight().isEmpty()) {
        maxManifoldHeight_ = other.maxManifoldHeight_;
        onChanged();
      }
      if (!other.getMaxManifoldPressure().isEmpty()) {
        maxManifoldPressure_ = other.maxManifoldPressure_;
        onChanged();
      }
      if (!other.getHoseConnections().isEmpty()) {
        hoseConnections_ = other.hoseConnections_;
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
      if (other.getAirPurge() != false) {
        setAirPurge(other.getAirPurge());
      }
      if (other.getCargoCirculation() != false) {
        setCargoCirculation(other.getCargoCirculation());
      }
      if (!other.getLineDisplacement().isEmpty()) {
        lineDisplacement_ = other.lineDisplacement_;
        onChanged();
      }
      if (!other.getSpecialRegulationRestriction().isEmpty()) {
        specialRegulationRestriction_ = other.specialRegulationRestriction_;
        onChanged();
      }
      if (!other.getItemsToBeAgreedWith().isEmpty()) {
        itemsToBeAgreedWith_ = other.itemsToBeAgreedWith_;
        onChanged();
      }
      if (!other.getDisplacement().isEmpty()) {
        displacement_ = other.displacement_;
        onChanged();
      }
      if (other.getNeedFlushingOilAndCrudeStorage() != false) {
        setNeedFlushingOilAndCrudeStorage(other.getNeedFlushingOilAndCrudeStorage());
      }
      if (other.getEnableDayLightRestriction() != false) {
        setEnableDayLightRestriction(other.getEnableDayLightRestriction());
      }
      if (!other.getFreshCrudeOilQuantity().isEmpty()) {
        freshCrudeOilQuantity_ = other.freshCrudeOilQuantity_;
        onChanged();
      }
      if (!other.getFreshCrudeOilTime().isEmpty()) {
        freshCrudeOilTime_ = other.freshCrudeOilTime_;
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
      com.cpdss.common.generated.discharge_plan.DischargeBerths parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage =
            (com.cpdss.common.generated.discharge_plan.DischargeBerths) e.getUnfinishedMessage();
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
     *
     *
     * <pre>
     * primary key
     * </pre>
     *
     * <code>int64 id = 1;</code>
     *
     * @return The id.
     */
    public long getId() {
      return id_;
    }
    /**
     *
     *
     * <pre>
     * primary key
     * </pre>
     *
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
     *
     *
     * <pre>
     * primary key
     * </pre>
     *
     * <code>int64 id = 1;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearId() {

      id_ = 0L;
      onChanged();
      return this;
    }

    private long dischargeInfoId_;
    /**
     * <code>int64 dischargeInfoId = 2;</code>
     *
     * @return The dischargeInfoId.
     */
    public long getDischargeInfoId() {
      return dischargeInfoId_;
    }
    /**
     * <code>int64 dischargeInfoId = 2;</code>
     *
     * @param value The dischargeInfoId to set.
     * @return This builder for chaining.
     */
    public Builder setDischargeInfoId(long value) {

      dischargeInfoId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 dischargeInfoId = 2;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearDischargeInfoId() {

      dischargeInfoId_ = 0L;
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

    private java.lang.Object depth_ = "";
    /**
     * <code>string depth = 4;</code>
     *
     * @return The depth.
     */
    public java.lang.String getDepth() {
      java.lang.Object ref = depth_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        depth_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string depth = 4;</code>
     *
     * @return The bytes for depth.
     */
    public com.google.protobuf.ByteString getDepthBytes() {
      java.lang.Object ref = depth_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        depth_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string depth = 4;</code>
     *
     * @param value The depth to set.
     * @return This builder for chaining.
     */
    public Builder setDepth(java.lang.String value) {
      if (value == null) {
        throw new NullPointerException();
      }

      depth_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string depth = 4;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearDepth() {

      depth_ = getDefaultInstance().getDepth();
      onChanged();
      return this;
    }
    /**
     * <code>string depth = 4;</code>
     *
     * @param value The bytes for depth to set.
     * @return This builder for chaining.
     */
    public Builder setDepthBytes(com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      checkByteStringIsUtf8(value);

      depth_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object maxManifoldHeight_ = "";
    /**
     * <code>string maxManifoldHeight = 5;</code>
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
     * <code>string maxManifoldHeight = 5;</code>
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
     * <code>string maxManifoldHeight = 5;</code>
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
     * <code>string maxManifoldHeight = 5;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearMaxManifoldHeight() {

      maxManifoldHeight_ = getDefaultInstance().getMaxManifoldHeight();
      onChanged();
      return this;
    }
    /**
     * <code>string maxManifoldHeight = 5;</code>
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

    private java.lang.Object maxManifoldPressure_ = "";
    /**
     * <code>string maxManifoldPressure = 6;</code>
     *
     * @return The maxManifoldPressure.
     */
    public java.lang.String getMaxManifoldPressure() {
      java.lang.Object ref = maxManifoldPressure_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        maxManifoldPressure_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string maxManifoldPressure = 6;</code>
     *
     * @return The bytes for maxManifoldPressure.
     */
    public com.google.protobuf.ByteString getMaxManifoldPressureBytes() {
      java.lang.Object ref = maxManifoldPressure_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        maxManifoldPressure_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string maxManifoldPressure = 6;</code>
     *
     * @param value The maxManifoldPressure to set.
     * @return This builder for chaining.
     */
    public Builder setMaxManifoldPressure(java.lang.String value) {
      if (value == null) {
        throw new NullPointerException();
      }

      maxManifoldPressure_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string maxManifoldPressure = 6;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearMaxManifoldPressure() {

      maxManifoldPressure_ = getDefaultInstance().getMaxManifoldPressure();
      onChanged();
      return this;
    }
    /**
     * <code>string maxManifoldPressure = 6;</code>
     *
     * @param value The bytes for maxManifoldPressure to set.
     * @return This builder for chaining.
     */
    public Builder setMaxManifoldPressureBytes(com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      checkByteStringIsUtf8(value);

      maxManifoldPressure_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object hoseConnections_ = "";
    /**
     * <code>string hoseConnections = 7;</code>
     *
     * @return The hoseConnections.
     */
    public java.lang.String getHoseConnections() {
      java.lang.Object ref = hoseConnections_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        hoseConnections_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string hoseConnections = 7;</code>
     *
     * @return The bytes for hoseConnections.
     */
    public com.google.protobuf.ByteString getHoseConnectionsBytes() {
      java.lang.Object ref = hoseConnections_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        hoseConnections_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string hoseConnections = 7;</code>
     *
     * @param value The hoseConnections to set.
     * @return This builder for chaining.
     */
    public Builder setHoseConnections(java.lang.String value) {
      if (value == null) {
        throw new NullPointerException();
      }

      hoseConnections_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string hoseConnections = 7;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearHoseConnections() {

      hoseConnections_ = getDefaultInstance().getHoseConnections();
      onChanged();
      return this;
    }
    /**
     * <code>string hoseConnections = 7;</code>
     *
     * @param value The bytes for hoseConnections to set.
     * @return This builder for chaining.
     */
    public Builder setHoseConnectionsBytes(com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      checkByteStringIsUtf8(value);

      hoseConnections_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object seaDraftLimitation_ = "";
    /**
     * <code>string seaDraftLimitation = 8;</code>
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
     * <code>string seaDraftLimitation = 8;</code>
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
     * <code>string seaDraftLimitation = 8;</code>
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
     * <code>string seaDraftLimitation = 8;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearSeaDraftLimitation() {

      seaDraftLimitation_ = getDefaultInstance().getSeaDraftLimitation();
      onChanged();
      return this;
    }
    /**
     * <code>string seaDraftLimitation = 8;</code>
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
     * <code>string airDraftLimitation = 9;</code>
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
     * <code>string airDraftLimitation = 9;</code>
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
     * <code>string airDraftLimitation = 9;</code>
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
     * <code>string airDraftLimitation = 9;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearAirDraftLimitation() {

      airDraftLimitation_ = getDefaultInstance().getAirDraftLimitation();
      onChanged();
      return this;
    }
    /**
     * <code>string airDraftLimitation = 9;</code>
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

    private boolean airPurge_;
    /**
     * <code>bool airPurge = 10;</code>
     *
     * @return The airPurge.
     */
    public boolean getAirPurge() {
      return airPurge_;
    }
    /**
     * <code>bool airPurge = 10;</code>
     *
     * @param value The airPurge to set.
     * @return This builder for chaining.
     */
    public Builder setAirPurge(boolean value) {

      airPurge_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool airPurge = 10;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearAirPurge() {

      airPurge_ = false;
      onChanged();
      return this;
    }

    private boolean cargoCirculation_;
    /**
     * <code>bool cargoCirculation = 11;</code>
     *
     * @return The cargoCirculation.
     */
    public boolean getCargoCirculation() {
      return cargoCirculation_;
    }
    /**
     * <code>bool cargoCirculation = 11;</code>
     *
     * @param value The cargoCirculation to set.
     * @return This builder for chaining.
     */
    public Builder setCargoCirculation(boolean value) {

      cargoCirculation_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool cargoCirculation = 11;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearCargoCirculation() {

      cargoCirculation_ = false;
      onChanged();
      return this;
    }

    private java.lang.Object lineDisplacement_ = "";
    /**
     * <code>string lineDisplacement = 12;</code>
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
     * <code>string lineDisplacement = 12;</code>
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
     * <code>string lineDisplacement = 12;</code>
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
     * <code>string lineDisplacement = 12;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearLineDisplacement() {

      lineDisplacement_ = getDefaultInstance().getLineDisplacement();
      onChanged();
      return this;
    }
    /**
     * <code>string lineDisplacement = 12;</code>
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

    private java.lang.Object specialRegulationRestriction_ = "";
    /**
     * <code>string specialRegulationRestriction = 13;</code>
     *
     * @return The specialRegulationRestriction.
     */
    public java.lang.String getSpecialRegulationRestriction() {
      java.lang.Object ref = specialRegulationRestriction_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        specialRegulationRestriction_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string specialRegulationRestriction = 13;</code>
     *
     * @return The bytes for specialRegulationRestriction.
     */
    public com.google.protobuf.ByteString getSpecialRegulationRestrictionBytes() {
      java.lang.Object ref = specialRegulationRestriction_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        specialRegulationRestriction_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string specialRegulationRestriction = 13;</code>
     *
     * @param value The specialRegulationRestriction to set.
     * @return This builder for chaining.
     */
    public Builder setSpecialRegulationRestriction(java.lang.String value) {
      if (value == null) {
        throw new NullPointerException();
      }

      specialRegulationRestriction_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string specialRegulationRestriction = 13;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearSpecialRegulationRestriction() {

      specialRegulationRestriction_ = getDefaultInstance().getSpecialRegulationRestriction();
      onChanged();
      return this;
    }
    /**
     * <code>string specialRegulationRestriction = 13;</code>
     *
     * @param value The bytes for specialRegulationRestriction to set.
     * @return This builder for chaining.
     */
    public Builder setSpecialRegulationRestrictionBytes(com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      checkByteStringIsUtf8(value);

      specialRegulationRestriction_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object itemsToBeAgreedWith_ = "";
    /**
     * <code>string itemsToBeAgreedWith = 14;</code>
     *
     * @return The itemsToBeAgreedWith.
     */
    public java.lang.String getItemsToBeAgreedWith() {
      java.lang.Object ref = itemsToBeAgreedWith_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        itemsToBeAgreedWith_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string itemsToBeAgreedWith = 14;</code>
     *
     * @return The bytes for itemsToBeAgreedWith.
     */
    public com.google.protobuf.ByteString getItemsToBeAgreedWithBytes() {
      java.lang.Object ref = itemsToBeAgreedWith_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        itemsToBeAgreedWith_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string itemsToBeAgreedWith = 14;</code>
     *
     * @param value The itemsToBeAgreedWith to set.
     * @return This builder for chaining.
     */
    public Builder setItemsToBeAgreedWith(java.lang.String value) {
      if (value == null) {
        throw new NullPointerException();
      }

      itemsToBeAgreedWith_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string itemsToBeAgreedWith = 14;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearItemsToBeAgreedWith() {

      itemsToBeAgreedWith_ = getDefaultInstance().getItemsToBeAgreedWith();
      onChanged();
      return this;
    }
    /**
     * <code>string itemsToBeAgreedWith = 14;</code>
     *
     * @param value The bytes for itemsToBeAgreedWith to set.
     * @return This builder for chaining.
     */
    public Builder setItemsToBeAgreedWithBytes(com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      checkByteStringIsUtf8(value);

      itemsToBeAgreedWith_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object displacement_ = "";
    /**
     * <code>string displacement = 15;</code>
     *
     * @return The displacement.
     */
    public java.lang.String getDisplacement() {
      java.lang.Object ref = displacement_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        displacement_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string displacement = 15;</code>
     *
     * @return The bytes for displacement.
     */
    public com.google.protobuf.ByteString getDisplacementBytes() {
      java.lang.Object ref = displacement_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        displacement_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string displacement = 15;</code>
     *
     * @param value The displacement to set.
     * @return This builder for chaining.
     */
    public Builder setDisplacement(java.lang.String value) {
      if (value == null) {
        throw new NullPointerException();
      }

      displacement_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string displacement = 15;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearDisplacement() {

      displacement_ = getDefaultInstance().getDisplacement();
      onChanged();
      return this;
    }
    /**
     * <code>string displacement = 15;</code>
     *
     * @param value The bytes for displacement to set.
     * @return This builder for chaining.
     */
    public Builder setDisplacementBytes(com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      checkByteStringIsUtf8(value);

      displacement_ = value;
      onChanged();
      return this;
    }

    private boolean needFlushingOilAndCrudeStorage_;
    /**
     * <code>bool needFlushingOilAndCrudeStorage = 16;</code>
     *
     * @return The needFlushingOilAndCrudeStorage.
     */
    public boolean getNeedFlushingOilAndCrudeStorage() {
      return needFlushingOilAndCrudeStorage_;
    }
    /**
     * <code>bool needFlushingOilAndCrudeStorage = 16;</code>
     *
     * @param value The needFlushingOilAndCrudeStorage to set.
     * @return This builder for chaining.
     */
    public Builder setNeedFlushingOilAndCrudeStorage(boolean value) {

      needFlushingOilAndCrudeStorage_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool needFlushingOilAndCrudeStorage = 16;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearNeedFlushingOilAndCrudeStorage() {

      needFlushingOilAndCrudeStorage_ = false;
      onChanged();
      return this;
    }

    private boolean enableDayLightRestriction_;
    /**
     * <code>bool enableDayLightRestriction = 17;</code>
     *
     * @return The enableDayLightRestriction.
     */
    public boolean getEnableDayLightRestriction() {
      return enableDayLightRestriction_;
    }
    /**
     * <code>bool enableDayLightRestriction = 17;</code>
     *
     * @param value The enableDayLightRestriction to set.
     * @return This builder for chaining.
     */
    public Builder setEnableDayLightRestriction(boolean value) {

      enableDayLightRestriction_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool enableDayLightRestriction = 17;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearEnableDayLightRestriction() {

      enableDayLightRestriction_ = false;
      onChanged();
      return this;
    }

    private java.lang.Object freshCrudeOilQuantity_ = "";
    /**
     * <code>string freshCrudeOilQuantity = 18;</code>
     *
     * @return The freshCrudeOilQuantity.
     */
    public java.lang.String getFreshCrudeOilQuantity() {
      java.lang.Object ref = freshCrudeOilQuantity_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        freshCrudeOilQuantity_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string freshCrudeOilQuantity = 18;</code>
     *
     * @return The bytes for freshCrudeOilQuantity.
     */
    public com.google.protobuf.ByteString getFreshCrudeOilQuantityBytes() {
      java.lang.Object ref = freshCrudeOilQuantity_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        freshCrudeOilQuantity_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string freshCrudeOilQuantity = 18;</code>
     *
     * @param value The freshCrudeOilQuantity to set.
     * @return This builder for chaining.
     */
    public Builder setFreshCrudeOilQuantity(java.lang.String value) {
      if (value == null) {
        throw new NullPointerException();
      }

      freshCrudeOilQuantity_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string freshCrudeOilQuantity = 18;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearFreshCrudeOilQuantity() {

      freshCrudeOilQuantity_ = getDefaultInstance().getFreshCrudeOilQuantity();
      onChanged();
      return this;
    }
    /**
     * <code>string freshCrudeOilQuantity = 18;</code>
     *
     * @param value The bytes for freshCrudeOilQuantity to set.
     * @return This builder for chaining.
     */
    public Builder setFreshCrudeOilQuantityBytes(com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      checkByteStringIsUtf8(value);

      freshCrudeOilQuantity_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object freshCrudeOilTime_ = "";
    /**
     * <code>string freshCrudeOilTime = 19;</code>
     *
     * @return The freshCrudeOilTime.
     */
    public java.lang.String getFreshCrudeOilTime() {
      java.lang.Object ref = freshCrudeOilTime_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        freshCrudeOilTime_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string freshCrudeOilTime = 19;</code>
     *
     * @return The bytes for freshCrudeOilTime.
     */
    public com.google.protobuf.ByteString getFreshCrudeOilTimeBytes() {
      java.lang.Object ref = freshCrudeOilTime_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        freshCrudeOilTime_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string freshCrudeOilTime = 19;</code>
     *
     * @param value The freshCrudeOilTime to set.
     * @return This builder for chaining.
     */
    public Builder setFreshCrudeOilTime(java.lang.String value) {
      if (value == null) {
        throw new NullPointerException();
      }

      freshCrudeOilTime_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string freshCrudeOilTime = 19;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearFreshCrudeOilTime() {

      freshCrudeOilTime_ = getDefaultInstance().getFreshCrudeOilTime();
      onChanged();
      return this;
    }
    /**
     * <code>string freshCrudeOilTime = 19;</code>
     *
     * @param value The bytes for freshCrudeOilTime to set.
     * @return This builder for chaining.
     */
    public Builder setFreshCrudeOilTimeBytes(com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      checkByteStringIsUtf8(value);

      freshCrudeOilTime_ = value;
      onChanged();
      return this;
    }

    @java.lang.Override
    public final Builder setUnknownFields(final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }

    // @@protoc_insertion_point(builder_scope:DischargeBerths)
  }

  // @@protoc_insertion_point(class_scope:DischargeBerths)
  private static final com.cpdss.common.generated.discharge_plan.DischargeBerths DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new com.cpdss.common.generated.discharge_plan.DischargeBerths();
  }

  public static com.cpdss.common.generated.discharge_plan.DischargeBerths getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<DischargeBerths> PARSER =
      new com.google.protobuf.AbstractParser<DischargeBerths>() {
        @java.lang.Override
        public DischargeBerths parsePartialFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
          return new DischargeBerths(input, extensionRegistry);
        }
      };

  public static com.google.protobuf.Parser<DischargeBerths> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<DischargeBerths> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.cpdss.common.generated.discharge_plan.DischargeBerths getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
}
