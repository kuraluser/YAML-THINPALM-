/* Licensed at AlphaOri Technologies */
package com.cpdss.common.generated.discharge_plan;

/** Protobuf type {@code DischargeSequenceReply} */
public final class DischargeSequenceReply extends com.google.protobuf.GeneratedMessageV3
    implements
    // @@protoc_insertion_point(message_implements:DischargeSequenceReply)
    DischargeSequenceReplyOrBuilder {
  private static final long serialVersionUID = 0L;
  // Use DischargeSequenceReply.newBuilder() to construct.
  private DischargeSequenceReply(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }

  private DischargeSequenceReply() {
    startDate_ = "";
    dischargeSequences_ = java.util.Collections.emptyList();
    dischargeSequenceStabilityParameters_ = java.util.Collections.emptyList();
    driveTankDetails_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
    return new DischargeSequenceReply();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }

  private DischargeSequenceReply(
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
              dischargePatternId_ = input.readInt64();
              break;
            }
          case 32:
            {
              portId_ = input.readInt64();
              break;
            }
          case 42:
            {
              java.lang.String s = input.readStringRequireUtf8();

              startDate_ = s;
              break;
            }
          case 48:
            {
              interval_ = input.readInt32();
              break;
            }
          case 58:
            {
              if (!((mutable_bitField0_ & 0x00000001) != 0)) {
                dischargeSequences_ =
                    new java.util.ArrayList<
                        com.cpdss.common.generated.discharge_plan.DischargingSequence>();
                mutable_bitField0_ |= 0x00000001;
              }
              dischargeSequences_.add(
                  input.readMessage(
                      com.cpdss.common.generated.discharge_plan.DischargingSequence.parser(),
                      extensionRegistry));
              break;
            }
          case 66:
            {
              if (!((mutable_bitField0_ & 0x00000002) != 0)) {
                dischargeSequenceStabilityParameters_ =
                    new java.util.ArrayList<
                        com.cpdss.common.generated.loading_plan.LoadingPlanModels
                            .LoadingPlanStabilityParameters>();
                mutable_bitField0_ |= 0x00000002;
              }
              dischargeSequenceStabilityParameters_.add(
                  input.readMessage(
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels
                          .LoadingPlanStabilityParameters.parser(),
                      extensionRegistry));
              break;
            }
          case 74:
            {
              com.cpdss.common.generated.Common.ResponseStatus.Builder subBuilder = null;
              if (responseStatus_ != null) {
                subBuilder = responseStatus_.toBuilder();
              }
              responseStatus_ =
                  input.readMessage(
                      com.cpdss.common.generated.Common.ResponseStatus.parser(), extensionRegistry);
              if (subBuilder != null) {
                subBuilder.mergeFrom(responseStatus_);
                responseStatus_ = subBuilder.buildPartial();
              }

              break;
            }
          case 80:
            {
              portRotationId_ = input.readInt64();
              break;
            }
          case 90:
            {
              com.cpdss.common.generated.discharge_plan.CleaningTanks.Builder subBuilder = null;
              if (cleaningTanks_ != null) {
                subBuilder = cleaningTanks_.toBuilder();
              }
              cleaningTanks_ =
                  input.readMessage(
                      com.cpdss.common.generated.discharge_plan.CleaningTanks.parser(),
                      extensionRegistry);
              if (subBuilder != null) {
                subBuilder.mergeFrom(cleaningTanks_);
                cleaningTanks_ = subBuilder.buildPartial();
              }

              break;
            }
          case 98:
            {
              if (!((mutable_bitField0_ & 0x00000004) != 0)) {
                driveTankDetails_ =
                    new java.util.ArrayList<
                        com.cpdss.common.generated.discharge_plan.DriveTankDetail>();
                mutable_bitField0_ |= 0x00000004;
              }
              driveTankDetails_.add(
                  input.readMessage(
                      com.cpdss.common.generated.discharge_plan.DriveTankDetail.parser(),
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
        dischargeSequences_ = java.util.Collections.unmodifiableList(dischargeSequences_);
      }
      if (((mutable_bitField0_ & 0x00000002) != 0)) {
        dischargeSequenceStabilityParameters_ =
            java.util.Collections.unmodifiableList(dischargeSequenceStabilityParameters_);
      }
      if (((mutable_bitField0_ & 0x00000004) != 0)) {
        driveTankDetails_ = java.util.Collections.unmodifiableList(driveTankDetails_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }

  public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
    return com.cpdss.common.generated.discharge_plan.DischargePlanModels
        .internal_static_DischargeSequenceReply_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.cpdss.common.generated.discharge_plan.DischargePlanModels
        .internal_static_DischargeSequenceReply_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.cpdss.common.generated.discharge_plan.DischargeSequenceReply.class,
            com.cpdss.common.generated.discharge_plan.DischargeSequenceReply.Builder.class);
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

  public static final int DISCHARGEPATTERNID_FIELD_NUMBER = 3;
  private long dischargePatternId_;
  /**
   * <code>int64 dischargePatternId = 3;</code>
   *
   * @return The dischargePatternId.
   */
  public long getDischargePatternId() {
    return dischargePatternId_;
  }

  public static final int PORTID_FIELD_NUMBER = 4;
  private long portId_;
  /**
   * <code>int64 portId = 4;</code>
   *
   * @return The portId.
   */
  public long getPortId() {
    return portId_;
  }

  public static final int STARTDATE_FIELD_NUMBER = 5;
  private volatile java.lang.Object startDate_;
  /**
   * <code>string startDate = 5;</code>
   *
   * @return The startDate.
   */
  public java.lang.String getStartDate() {
    java.lang.Object ref = startDate_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      startDate_ = s;
      return s;
    }
  }
  /**
   * <code>string startDate = 5;</code>
   *
   * @return The bytes for startDate.
   */
  public com.google.protobuf.ByteString getStartDateBytes() {
    java.lang.Object ref = startDate_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
      startDate_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int INTERVAL_FIELD_NUMBER = 6;
  private int interval_;
  /**
   * <code>int32 interval = 6;</code>
   *
   * @return The interval.
   */
  public int getInterval() {
    return interval_;
  }

  public static final int DISCHARGESEQUENCES_FIELD_NUMBER = 7;
  private java.util.List<com.cpdss.common.generated.discharge_plan.DischargingSequence>
      dischargeSequences_;
  /** <code>repeated .DischargingSequence dischargeSequences = 7;</code> */
  public java.util.List<com.cpdss.common.generated.discharge_plan.DischargingSequence>
      getDischargeSequencesList() {
    return dischargeSequences_;
  }
  /** <code>repeated .DischargingSequence dischargeSequences = 7;</code> */
  public java.util.List<
          ? extends com.cpdss.common.generated.discharge_plan.DischargingSequenceOrBuilder>
      getDischargeSequencesOrBuilderList() {
    return dischargeSequences_;
  }
  /** <code>repeated .DischargingSequence dischargeSequences = 7;</code> */
  public int getDischargeSequencesCount() {
    return dischargeSequences_.size();
  }
  /** <code>repeated .DischargingSequence dischargeSequences = 7;</code> */
  public com.cpdss.common.generated.discharge_plan.DischargingSequence getDischargeSequences(
      int index) {
    return dischargeSequences_.get(index);
  }
  /** <code>repeated .DischargingSequence dischargeSequences = 7;</code> */
  public com.cpdss.common.generated.discharge_plan.DischargingSequenceOrBuilder
      getDischargeSequencesOrBuilder(int index) {
    return dischargeSequences_.get(index);
  }

  public static final int DISCHARGESEQUENCESTABILITYPARAMETERS_FIELD_NUMBER = 8;
  private java.util.List<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters>
      dischargeSequenceStabilityParameters_;
  /**
   * <code>repeated .LoadingPlanStabilityParameters dischargeSequenceStabilityParameters = 8;</code>
   */
  public java.util.List<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters>
      getDischargeSequenceStabilityParametersList() {
    return dischargeSequenceStabilityParameters_;
  }
  /**
   * <code>repeated .LoadingPlanStabilityParameters dischargeSequenceStabilityParameters = 8;</code>
   */
  public java.util.List<
          ? extends
              com.cpdss.common.generated.loading_plan.LoadingPlanModels
                  .LoadingPlanStabilityParametersOrBuilder>
      getDischargeSequenceStabilityParametersOrBuilderList() {
    return dischargeSequenceStabilityParameters_;
  }
  /**
   * <code>repeated .LoadingPlanStabilityParameters dischargeSequenceStabilityParameters = 8;</code>
   */
  public int getDischargeSequenceStabilityParametersCount() {
    return dischargeSequenceStabilityParameters_.size();
  }
  /**
   * <code>repeated .LoadingPlanStabilityParameters dischargeSequenceStabilityParameters = 8;</code>
   */
  public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters
      getDischargeSequenceStabilityParameters(int index) {
    return dischargeSequenceStabilityParameters_.get(index);
  }
  /**
   * <code>repeated .LoadingPlanStabilityParameters dischargeSequenceStabilityParameters = 8;</code>
   */
  public com.cpdss.common.generated.loading_plan.LoadingPlanModels
          .LoadingPlanStabilityParametersOrBuilder
      getDischargeSequenceStabilityParametersOrBuilder(int index) {
    return dischargeSequenceStabilityParameters_.get(index);
  }

  public static final int RESPONSESTATUS_FIELD_NUMBER = 9;
  private com.cpdss.common.generated.Common.ResponseStatus responseStatus_;
  /**
   * <code>.ResponseStatus responseStatus = 9;</code>
   *
   * @return Whether the responseStatus field is set.
   */
  public boolean hasResponseStatus() {
    return responseStatus_ != null;
  }
  /**
   * <code>.ResponseStatus responseStatus = 9;</code>
   *
   * @return The responseStatus.
   */
  public com.cpdss.common.generated.Common.ResponseStatus getResponseStatus() {
    return responseStatus_ == null
        ? com.cpdss.common.generated.Common.ResponseStatus.getDefaultInstance()
        : responseStatus_;
  }
  /** <code>.ResponseStatus responseStatus = 9;</code> */
  public com.cpdss.common.generated.Common.ResponseStatusOrBuilder getResponseStatusOrBuilder() {
    return getResponseStatus();
  }

  public static final int PORTROTATIONID_FIELD_NUMBER = 10;
  private long portRotationId_;
  /**
   * <code>int64 portRotationId = 10;</code>
   *
   * @return The portRotationId.
   */
  public long getPortRotationId() {
    return portRotationId_;
  }

  public static final int CLEANINGTANKS_FIELD_NUMBER = 11;
  private com.cpdss.common.generated.discharge_plan.CleaningTanks cleaningTanks_;
  /**
   * <code>.CleaningTanks cleaningTanks = 11;</code>
   *
   * @return Whether the cleaningTanks field is set.
   */
  public boolean hasCleaningTanks() {
    return cleaningTanks_ != null;
  }
  /**
   * <code>.CleaningTanks cleaningTanks = 11;</code>
   *
   * @return The cleaningTanks.
   */
  public com.cpdss.common.generated.discharge_plan.CleaningTanks getCleaningTanks() {
    return cleaningTanks_ == null
        ? com.cpdss.common.generated.discharge_plan.CleaningTanks.getDefaultInstance()
        : cleaningTanks_;
  }
  /** <code>.CleaningTanks cleaningTanks = 11;</code> */
  public com.cpdss.common.generated.discharge_plan.CleaningTanksOrBuilder
      getCleaningTanksOrBuilder() {
    return getCleaningTanks();
  }

  public static final int DRIVETANKDETAILS_FIELD_NUMBER = 12;
  private java.util.List<com.cpdss.common.generated.discharge_plan.DriveTankDetail>
      driveTankDetails_;
  /** <code>repeated .DriveTankDetail driveTankDetails = 12;</code> */
  public java.util.List<com.cpdss.common.generated.discharge_plan.DriveTankDetail>
      getDriveTankDetailsList() {
    return driveTankDetails_;
  }
  /** <code>repeated .DriveTankDetail driveTankDetails = 12;</code> */
  public java.util.List<
          ? extends com.cpdss.common.generated.discharge_plan.DriveTankDetailOrBuilder>
      getDriveTankDetailsOrBuilderList() {
    return driveTankDetails_;
  }
  /** <code>repeated .DriveTankDetail driveTankDetails = 12;</code> */
  public int getDriveTankDetailsCount() {
    return driveTankDetails_.size();
  }
  /** <code>repeated .DriveTankDetail driveTankDetails = 12;</code> */
  public com.cpdss.common.generated.discharge_plan.DriveTankDetail getDriveTankDetails(int index) {
    return driveTankDetails_.get(index);
  }
  /** <code>repeated .DriveTankDetail driveTankDetails = 12;</code> */
  public com.cpdss.common.generated.discharge_plan.DriveTankDetailOrBuilder
      getDriveTankDetailsOrBuilder(int index) {
    return driveTankDetails_.get(index);
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
    if (dischargePatternId_ != 0L) {
      output.writeInt64(3, dischargePatternId_);
    }
    if (portId_ != 0L) {
      output.writeInt64(4, portId_);
    }
    if (!getStartDateBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 5, startDate_);
    }
    if (interval_ != 0) {
      output.writeInt32(6, interval_);
    }
    for (int i = 0; i < dischargeSequences_.size(); i++) {
      output.writeMessage(7, dischargeSequences_.get(i));
    }
    for (int i = 0; i < dischargeSequenceStabilityParameters_.size(); i++) {
      output.writeMessage(8, dischargeSequenceStabilityParameters_.get(i));
    }
    if (responseStatus_ != null) {
      output.writeMessage(9, getResponseStatus());
    }
    if (portRotationId_ != 0L) {
      output.writeInt64(10, portRotationId_);
    }
    if (cleaningTanks_ != null) {
      output.writeMessage(11, getCleaningTanks());
    }
    for (int i = 0; i < driveTankDetails_.size(); i++) {
      output.writeMessage(12, driveTankDetails_.get(i));
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
    if (dischargePatternId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream.computeInt64Size(3, dischargePatternId_);
    }
    if (portId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream.computeInt64Size(4, portId_);
    }
    if (!getStartDateBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, startDate_);
    }
    if (interval_ != 0) {
      size += com.google.protobuf.CodedOutputStream.computeInt32Size(6, interval_);
    }
    for (int i = 0; i < dischargeSequences_.size(); i++) {
      size +=
          com.google.protobuf.CodedOutputStream.computeMessageSize(7, dischargeSequences_.get(i));
    }
    for (int i = 0; i < dischargeSequenceStabilityParameters_.size(); i++) {
      size +=
          com.google.protobuf.CodedOutputStream.computeMessageSize(
              8, dischargeSequenceStabilityParameters_.get(i));
    }
    if (responseStatus_ != null) {
      size += com.google.protobuf.CodedOutputStream.computeMessageSize(9, getResponseStatus());
    }
    if (portRotationId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream.computeInt64Size(10, portRotationId_);
    }
    if (cleaningTanks_ != null) {
      size += com.google.protobuf.CodedOutputStream.computeMessageSize(11, getCleaningTanks());
    }
    for (int i = 0; i < driveTankDetails_.size(); i++) {
      size +=
          com.google.protobuf.CodedOutputStream.computeMessageSize(12, driveTankDetails_.get(i));
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
    if (!(obj instanceof com.cpdss.common.generated.discharge_plan.DischargeSequenceReply)) {
      return super.equals(obj);
    }
    com.cpdss.common.generated.discharge_plan.DischargeSequenceReply other =
        (com.cpdss.common.generated.discharge_plan.DischargeSequenceReply) obj;

    if (getVesselId() != other.getVesselId()) return false;
    if (getVoyageId() != other.getVoyageId()) return false;
    if (getDischargePatternId() != other.getDischargePatternId()) return false;
    if (getPortId() != other.getPortId()) return false;
    if (!getStartDate().equals(other.getStartDate())) return false;
    if (getInterval() != other.getInterval()) return false;
    if (!getDischargeSequencesList().equals(other.getDischargeSequencesList())) return false;
    if (!getDischargeSequenceStabilityParametersList()
        .equals(other.getDischargeSequenceStabilityParametersList())) return false;
    if (hasResponseStatus() != other.hasResponseStatus()) return false;
    if (hasResponseStatus()) {
      if (!getResponseStatus().equals(other.getResponseStatus())) return false;
    }
    if (getPortRotationId() != other.getPortRotationId()) return false;
    if (hasCleaningTanks() != other.hasCleaningTanks()) return false;
    if (hasCleaningTanks()) {
      if (!getCleaningTanks().equals(other.getCleaningTanks())) return false;
    }
    if (!getDriveTankDetailsList().equals(other.getDriveTankDetailsList())) return false;
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
    hash = (37 * hash) + DISCHARGEPATTERNID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getDischargePatternId());
    hash = (37 * hash) + PORTID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getPortId());
    hash = (37 * hash) + STARTDATE_FIELD_NUMBER;
    hash = (53 * hash) + getStartDate().hashCode();
    hash = (37 * hash) + INTERVAL_FIELD_NUMBER;
    hash = (53 * hash) + getInterval();
    if (getDischargeSequencesCount() > 0) {
      hash = (37 * hash) + DISCHARGESEQUENCES_FIELD_NUMBER;
      hash = (53 * hash) + getDischargeSequencesList().hashCode();
    }
    if (getDischargeSequenceStabilityParametersCount() > 0) {
      hash = (37 * hash) + DISCHARGESEQUENCESTABILITYPARAMETERS_FIELD_NUMBER;
      hash = (53 * hash) + getDischargeSequenceStabilityParametersList().hashCode();
    }
    if (hasResponseStatus()) {
      hash = (37 * hash) + RESPONSESTATUS_FIELD_NUMBER;
      hash = (53 * hash) + getResponseStatus().hashCode();
    }
    hash = (37 * hash) + PORTROTATIONID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getPortRotationId());
    if (hasCleaningTanks()) {
      hash = (37 * hash) + CLEANINGTANKS_FIELD_NUMBER;
      hash = (53 * hash) + getCleaningTanks().hashCode();
    }
    if (getDriveTankDetailsCount() > 0) {
      hash = (37 * hash) + DRIVETANKDETAILS_FIELD_NUMBER;
      hash = (53 * hash) + getDriveTankDetailsList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.cpdss.common.generated.discharge_plan.DischargeSequenceReply parseFrom(
      java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargeSequenceReply parseFrom(
      java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargeSequenceReply parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargeSequenceReply parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargeSequenceReply parseFrom(
      byte[] data) throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargeSequenceReply parseFrom(
      byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargeSequenceReply parseFrom(
      java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargeSequenceReply parseFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargeSequenceReply parseDelimitedFrom(
      java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargeSequenceReply parseDelimitedFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargeSequenceReply parseFrom(
      com.google.protobuf.CodedInputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargeSequenceReply parseFrom(
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
      com.cpdss.common.generated.discharge_plan.DischargeSequenceReply prototype) {
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
  /** Protobuf type {@code DischargeSequenceReply} */
  public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
      implements
      // @@protoc_insertion_point(builder_implements:DischargeSequenceReply)
      com.cpdss.common.generated.discharge_plan.DischargeSequenceReplyOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanModels
          .internal_static_DischargeSequenceReply_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanModels
          .internal_static_DischargeSequenceReply_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.discharge_plan.DischargeSequenceReply.class,
              com.cpdss.common.generated.discharge_plan.DischargeSequenceReply.Builder.class);
    }

    // Construct using com.cpdss.common.generated.discharge_plan.DischargeSequenceReply.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {
        getDischargeSequencesFieldBuilder();
        getDischargeSequenceStabilityParametersFieldBuilder();
        getDriveTankDetailsFieldBuilder();
      }
    }

    @java.lang.Override
    public Builder clear() {
      super.clear();
      vesselId_ = 0L;

      voyageId_ = 0L;

      dischargePatternId_ = 0L;

      portId_ = 0L;

      startDate_ = "";

      interval_ = 0;

      if (dischargeSequencesBuilder_ == null) {
        dischargeSequences_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        dischargeSequencesBuilder_.clear();
      }
      if (dischargeSequenceStabilityParametersBuilder_ == null) {
        dischargeSequenceStabilityParameters_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000002);
      } else {
        dischargeSequenceStabilityParametersBuilder_.clear();
      }
      if (responseStatusBuilder_ == null) {
        responseStatus_ = null;
      } else {
        responseStatus_ = null;
        responseStatusBuilder_ = null;
      }
      portRotationId_ = 0L;

      if (cleaningTanksBuilder_ == null) {
        cleaningTanks_ = null;
      } else {
        cleaningTanks_ = null;
        cleaningTanksBuilder_ = null;
      }
      if (driveTankDetailsBuilder_ == null) {
        driveTankDetails_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000004);
      } else {
        driveTankDetailsBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanModels
          .internal_static_DischargeSequenceReply_descriptor;
    }

    @java.lang.Override
    public com.cpdss.common.generated.discharge_plan.DischargeSequenceReply
        getDefaultInstanceForType() {
      return com.cpdss.common.generated.discharge_plan.DischargeSequenceReply.getDefaultInstance();
    }

    @java.lang.Override
    public com.cpdss.common.generated.discharge_plan.DischargeSequenceReply build() {
      com.cpdss.common.generated.discharge_plan.DischargeSequenceReply result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.cpdss.common.generated.discharge_plan.DischargeSequenceReply buildPartial() {
      com.cpdss.common.generated.discharge_plan.DischargeSequenceReply result =
          new com.cpdss.common.generated.discharge_plan.DischargeSequenceReply(this);
      int from_bitField0_ = bitField0_;
      result.vesselId_ = vesselId_;
      result.voyageId_ = voyageId_;
      result.dischargePatternId_ = dischargePatternId_;
      result.portId_ = portId_;
      result.startDate_ = startDate_;
      result.interval_ = interval_;
      if (dischargeSequencesBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          dischargeSequences_ = java.util.Collections.unmodifiableList(dischargeSequences_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.dischargeSequences_ = dischargeSequences_;
      } else {
        result.dischargeSequences_ = dischargeSequencesBuilder_.build();
      }
      if (dischargeSequenceStabilityParametersBuilder_ == null) {
        if (((bitField0_ & 0x00000002) != 0)) {
          dischargeSequenceStabilityParameters_ =
              java.util.Collections.unmodifiableList(dischargeSequenceStabilityParameters_);
          bitField0_ = (bitField0_ & ~0x00000002);
        }
        result.dischargeSequenceStabilityParameters_ = dischargeSequenceStabilityParameters_;
      } else {
        result.dischargeSequenceStabilityParameters_ =
            dischargeSequenceStabilityParametersBuilder_.build();
      }
      if (responseStatusBuilder_ == null) {
        result.responseStatus_ = responseStatus_;
      } else {
        result.responseStatus_ = responseStatusBuilder_.build();
      }
      result.portRotationId_ = portRotationId_;
      if (cleaningTanksBuilder_ == null) {
        result.cleaningTanks_ = cleaningTanks_;
      } else {
        result.cleaningTanks_ = cleaningTanksBuilder_.build();
      }
      if (driveTankDetailsBuilder_ == null) {
        if (((bitField0_ & 0x00000004) != 0)) {
          driveTankDetails_ = java.util.Collections.unmodifiableList(driveTankDetails_);
          bitField0_ = (bitField0_ & ~0x00000004);
        }
        result.driveTankDetails_ = driveTankDetails_;
      } else {
        result.driveTankDetails_ = driveTankDetailsBuilder_.build();
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
      if (other instanceof com.cpdss.common.generated.discharge_plan.DischargeSequenceReply) {
        return mergeFrom((com.cpdss.common.generated.discharge_plan.DischargeSequenceReply) other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(
        com.cpdss.common.generated.discharge_plan.DischargeSequenceReply other) {
      if (other
          == com.cpdss.common.generated.discharge_plan.DischargeSequenceReply.getDefaultInstance())
        return this;
      if (other.getVesselId() != 0L) {
        setVesselId(other.getVesselId());
      }
      if (other.getVoyageId() != 0L) {
        setVoyageId(other.getVoyageId());
      }
      if (other.getDischargePatternId() != 0L) {
        setDischargePatternId(other.getDischargePatternId());
      }
      if (other.getPortId() != 0L) {
        setPortId(other.getPortId());
      }
      if (!other.getStartDate().isEmpty()) {
        startDate_ = other.startDate_;
        onChanged();
      }
      if (other.getInterval() != 0) {
        setInterval(other.getInterval());
      }
      if (dischargeSequencesBuilder_ == null) {
        if (!other.dischargeSequences_.isEmpty()) {
          if (dischargeSequences_.isEmpty()) {
            dischargeSequences_ = other.dischargeSequences_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureDischargeSequencesIsMutable();
            dischargeSequences_.addAll(other.dischargeSequences_);
          }
          onChanged();
        }
      } else {
        if (!other.dischargeSequences_.isEmpty()) {
          if (dischargeSequencesBuilder_.isEmpty()) {
            dischargeSequencesBuilder_.dispose();
            dischargeSequencesBuilder_ = null;
            dischargeSequences_ = other.dischargeSequences_;
            bitField0_ = (bitField0_ & ~0x00000001);
            dischargeSequencesBuilder_ =
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
                    ? getDischargeSequencesFieldBuilder()
                    : null;
          } else {
            dischargeSequencesBuilder_.addAllMessages(other.dischargeSequences_);
          }
        }
      }
      if (dischargeSequenceStabilityParametersBuilder_ == null) {
        if (!other.dischargeSequenceStabilityParameters_.isEmpty()) {
          if (dischargeSequenceStabilityParameters_.isEmpty()) {
            dischargeSequenceStabilityParameters_ = other.dischargeSequenceStabilityParameters_;
            bitField0_ = (bitField0_ & ~0x00000002);
          } else {
            ensureDischargeSequenceStabilityParametersIsMutable();
            dischargeSequenceStabilityParameters_.addAll(
                other.dischargeSequenceStabilityParameters_);
          }
          onChanged();
        }
      } else {
        if (!other.dischargeSequenceStabilityParameters_.isEmpty()) {
          if (dischargeSequenceStabilityParametersBuilder_.isEmpty()) {
            dischargeSequenceStabilityParametersBuilder_.dispose();
            dischargeSequenceStabilityParametersBuilder_ = null;
            dischargeSequenceStabilityParameters_ = other.dischargeSequenceStabilityParameters_;
            bitField0_ = (bitField0_ & ~0x00000002);
            dischargeSequenceStabilityParametersBuilder_ =
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
                    ? getDischargeSequenceStabilityParametersFieldBuilder()
                    : null;
          } else {
            dischargeSequenceStabilityParametersBuilder_.addAllMessages(
                other.dischargeSequenceStabilityParameters_);
          }
        }
      }
      if (other.hasResponseStatus()) {
        mergeResponseStatus(other.getResponseStatus());
      }
      if (other.getPortRotationId() != 0L) {
        setPortRotationId(other.getPortRotationId());
      }
      if (other.hasCleaningTanks()) {
        mergeCleaningTanks(other.getCleaningTanks());
      }
      if (driveTankDetailsBuilder_ == null) {
        if (!other.driveTankDetails_.isEmpty()) {
          if (driveTankDetails_.isEmpty()) {
            driveTankDetails_ = other.driveTankDetails_;
            bitField0_ = (bitField0_ & ~0x00000004);
          } else {
            ensureDriveTankDetailsIsMutable();
            driveTankDetails_.addAll(other.driveTankDetails_);
          }
          onChanged();
        }
      } else {
        if (!other.driveTankDetails_.isEmpty()) {
          if (driveTankDetailsBuilder_.isEmpty()) {
            driveTankDetailsBuilder_.dispose();
            driveTankDetailsBuilder_ = null;
            driveTankDetails_ = other.driveTankDetails_;
            bitField0_ = (bitField0_ & ~0x00000004);
            driveTankDetailsBuilder_ =
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
                    ? getDriveTankDetailsFieldBuilder()
                    : null;
          } else {
            driveTankDetailsBuilder_.addAllMessages(other.driveTankDetails_);
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
      com.cpdss.common.generated.discharge_plan.DischargeSequenceReply parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage =
            (com.cpdss.common.generated.discharge_plan.DischargeSequenceReply)
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

    private long dischargePatternId_;
    /**
     * <code>int64 dischargePatternId = 3;</code>
     *
     * @return The dischargePatternId.
     */
    public long getDischargePatternId() {
      return dischargePatternId_;
    }
    /**
     * <code>int64 dischargePatternId = 3;</code>
     *
     * @param value The dischargePatternId to set.
     * @return This builder for chaining.
     */
    public Builder setDischargePatternId(long value) {

      dischargePatternId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 dischargePatternId = 3;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearDischargePatternId() {

      dischargePatternId_ = 0L;
      onChanged();
      return this;
    }

    private long portId_;
    /**
     * <code>int64 portId = 4;</code>
     *
     * @return The portId.
     */
    public long getPortId() {
      return portId_;
    }
    /**
     * <code>int64 portId = 4;</code>
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
     * <code>int64 portId = 4;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearPortId() {

      portId_ = 0L;
      onChanged();
      return this;
    }

    private java.lang.Object startDate_ = "";
    /**
     * <code>string startDate = 5;</code>
     *
     * @return The startDate.
     */
    public java.lang.String getStartDate() {
      java.lang.Object ref = startDate_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        startDate_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string startDate = 5;</code>
     *
     * @return The bytes for startDate.
     */
    public com.google.protobuf.ByteString getStartDateBytes() {
      java.lang.Object ref = startDate_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        startDate_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string startDate = 5;</code>
     *
     * @param value The startDate to set.
     * @return This builder for chaining.
     */
    public Builder setStartDate(java.lang.String value) {
      if (value == null) {
        throw new NullPointerException();
      }

      startDate_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string startDate = 5;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearStartDate() {

      startDate_ = getDefaultInstance().getStartDate();
      onChanged();
      return this;
    }
    /**
     * <code>string startDate = 5;</code>
     *
     * @param value The bytes for startDate to set.
     * @return This builder for chaining.
     */
    public Builder setStartDateBytes(com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      checkByteStringIsUtf8(value);

      startDate_ = value;
      onChanged();
      return this;
    }

    private int interval_;
    /**
     * <code>int32 interval = 6;</code>
     *
     * @return The interval.
     */
    public int getInterval() {
      return interval_;
    }
    /**
     * <code>int32 interval = 6;</code>
     *
     * @param value The interval to set.
     * @return This builder for chaining.
     */
    public Builder setInterval(int value) {

      interval_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 interval = 6;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearInterval() {

      interval_ = 0;
      onChanged();
      return this;
    }

    private java.util.List<com.cpdss.common.generated.discharge_plan.DischargingSequence>
        dischargeSequences_ = java.util.Collections.emptyList();

    private void ensureDischargeSequencesIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        dischargeSequences_ =
            new java.util.ArrayList<com.cpdss.common.generated.discharge_plan.DischargingSequence>(
                dischargeSequences_);
        bitField0_ |= 0x00000001;
      }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.discharge_plan.DischargingSequence,
            com.cpdss.common.generated.discharge_plan.DischargingSequence.Builder,
            com.cpdss.common.generated.discharge_plan.DischargingSequenceOrBuilder>
        dischargeSequencesBuilder_;

    /** <code>repeated .DischargingSequence dischargeSequences = 7;</code> */
    public java.util.List<com.cpdss.common.generated.discharge_plan.DischargingSequence>
        getDischargeSequencesList() {
      if (dischargeSequencesBuilder_ == null) {
        return java.util.Collections.unmodifiableList(dischargeSequences_);
      } else {
        return dischargeSequencesBuilder_.getMessageList();
      }
    }
    /** <code>repeated .DischargingSequence dischargeSequences = 7;</code> */
    public int getDischargeSequencesCount() {
      if (dischargeSequencesBuilder_ == null) {
        return dischargeSequences_.size();
      } else {
        return dischargeSequencesBuilder_.getCount();
      }
    }
    /** <code>repeated .DischargingSequence dischargeSequences = 7;</code> */
    public com.cpdss.common.generated.discharge_plan.DischargingSequence getDischargeSequences(
        int index) {
      if (dischargeSequencesBuilder_ == null) {
        return dischargeSequences_.get(index);
      } else {
        return dischargeSequencesBuilder_.getMessage(index);
      }
    }
    /** <code>repeated .DischargingSequence dischargeSequences = 7;</code> */
    public Builder setDischargeSequences(
        int index, com.cpdss.common.generated.discharge_plan.DischargingSequence value) {
      if (dischargeSequencesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDischargeSequencesIsMutable();
        dischargeSequences_.set(index, value);
        onChanged();
      } else {
        dischargeSequencesBuilder_.setMessage(index, value);
      }
      return this;
    }
    /** <code>repeated .DischargingSequence dischargeSequences = 7;</code> */
    public Builder setDischargeSequences(
        int index,
        com.cpdss.common.generated.discharge_plan.DischargingSequence.Builder builderForValue) {
      if (dischargeSequencesBuilder_ == null) {
        ensureDischargeSequencesIsMutable();
        dischargeSequences_.set(index, builderForValue.build());
        onChanged();
      } else {
        dischargeSequencesBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .DischargingSequence dischargeSequences = 7;</code> */
    public Builder addDischargeSequences(
        com.cpdss.common.generated.discharge_plan.DischargingSequence value) {
      if (dischargeSequencesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDischargeSequencesIsMutable();
        dischargeSequences_.add(value);
        onChanged();
      } else {
        dischargeSequencesBuilder_.addMessage(value);
      }
      return this;
    }
    /** <code>repeated .DischargingSequence dischargeSequences = 7;</code> */
    public Builder addDischargeSequences(
        int index, com.cpdss.common.generated.discharge_plan.DischargingSequence value) {
      if (dischargeSequencesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDischargeSequencesIsMutable();
        dischargeSequences_.add(index, value);
        onChanged();
      } else {
        dischargeSequencesBuilder_.addMessage(index, value);
      }
      return this;
    }
    /** <code>repeated .DischargingSequence dischargeSequences = 7;</code> */
    public Builder addDischargeSequences(
        com.cpdss.common.generated.discharge_plan.DischargingSequence.Builder builderForValue) {
      if (dischargeSequencesBuilder_ == null) {
        ensureDischargeSequencesIsMutable();
        dischargeSequences_.add(builderForValue.build());
        onChanged();
      } else {
        dischargeSequencesBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .DischargingSequence dischargeSequences = 7;</code> */
    public Builder addDischargeSequences(
        int index,
        com.cpdss.common.generated.discharge_plan.DischargingSequence.Builder builderForValue) {
      if (dischargeSequencesBuilder_ == null) {
        ensureDischargeSequencesIsMutable();
        dischargeSequences_.add(index, builderForValue.build());
        onChanged();
      } else {
        dischargeSequencesBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .DischargingSequence dischargeSequences = 7;</code> */
    public Builder addAllDischargeSequences(
        java.lang.Iterable<? extends com.cpdss.common.generated.discharge_plan.DischargingSequence>
            values) {
      if (dischargeSequencesBuilder_ == null) {
        ensureDischargeSequencesIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(values, dischargeSequences_);
        onChanged();
      } else {
        dischargeSequencesBuilder_.addAllMessages(values);
      }
      return this;
    }
    /** <code>repeated .DischargingSequence dischargeSequences = 7;</code> */
    public Builder clearDischargeSequences() {
      if (dischargeSequencesBuilder_ == null) {
        dischargeSequences_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        dischargeSequencesBuilder_.clear();
      }
      return this;
    }
    /** <code>repeated .DischargingSequence dischargeSequences = 7;</code> */
    public Builder removeDischargeSequences(int index) {
      if (dischargeSequencesBuilder_ == null) {
        ensureDischargeSequencesIsMutable();
        dischargeSequences_.remove(index);
        onChanged();
      } else {
        dischargeSequencesBuilder_.remove(index);
      }
      return this;
    }
    /** <code>repeated .DischargingSequence dischargeSequences = 7;</code> */
    public com.cpdss.common.generated.discharge_plan.DischargingSequence.Builder
        getDischargeSequencesBuilder(int index) {
      return getDischargeSequencesFieldBuilder().getBuilder(index);
    }
    /** <code>repeated .DischargingSequence dischargeSequences = 7;</code> */
    public com.cpdss.common.generated.discharge_plan.DischargingSequenceOrBuilder
        getDischargeSequencesOrBuilder(int index) {
      if (dischargeSequencesBuilder_ == null) {
        return dischargeSequences_.get(index);
      } else {
        return dischargeSequencesBuilder_.getMessageOrBuilder(index);
      }
    }
    /** <code>repeated .DischargingSequence dischargeSequences = 7;</code> */
    public java.util.List<
            ? extends com.cpdss.common.generated.discharge_plan.DischargingSequenceOrBuilder>
        getDischargeSequencesOrBuilderList() {
      if (dischargeSequencesBuilder_ != null) {
        return dischargeSequencesBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(dischargeSequences_);
      }
    }
    /** <code>repeated .DischargingSequence dischargeSequences = 7;</code> */
    public com.cpdss.common.generated.discharge_plan.DischargingSequence.Builder
        addDischargeSequencesBuilder() {
      return getDischargeSequencesFieldBuilder()
          .addBuilder(
              com.cpdss.common.generated.discharge_plan.DischargingSequence.getDefaultInstance());
    }
    /** <code>repeated .DischargingSequence dischargeSequences = 7;</code> */
    public com.cpdss.common.generated.discharge_plan.DischargingSequence.Builder
        addDischargeSequencesBuilder(int index) {
      return getDischargeSequencesFieldBuilder()
          .addBuilder(
              index,
              com.cpdss.common.generated.discharge_plan.DischargingSequence.getDefaultInstance());
    }
    /** <code>repeated .DischargingSequence dischargeSequences = 7;</code> */
    public java.util.List<com.cpdss.common.generated.discharge_plan.DischargingSequence.Builder>
        getDischargeSequencesBuilderList() {
      return getDischargeSequencesFieldBuilder().getBuilderList();
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.discharge_plan.DischargingSequence,
            com.cpdss.common.generated.discharge_plan.DischargingSequence.Builder,
            com.cpdss.common.generated.discharge_plan.DischargingSequenceOrBuilder>
        getDischargeSequencesFieldBuilder() {
      if (dischargeSequencesBuilder_ == null) {
        dischargeSequencesBuilder_ =
            new com.google.protobuf.RepeatedFieldBuilderV3<
                com.cpdss.common.generated.discharge_plan.DischargingSequence,
                com.cpdss.common.generated.discharge_plan.DischargingSequence.Builder,
                com.cpdss.common.generated.discharge_plan.DischargingSequenceOrBuilder>(
                dischargeSequences_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        dischargeSequences_ = null;
      }
      return dischargeSequencesBuilder_;
    }

    private java.util.List<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels
                .LoadingPlanStabilityParameters>
        dischargeSequenceStabilityParameters_ = java.util.Collections.emptyList();

    private void ensureDischargeSequenceStabilityParametersIsMutable() {
      if (!((bitField0_ & 0x00000002) != 0)) {
        dischargeSequenceStabilityParameters_ =
            new java.util.ArrayList<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels
                    .LoadingPlanStabilityParameters>(dischargeSequenceStabilityParameters_);
        bitField0_ |= 0x00000002;
      }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels
                .LoadingPlanStabilityParameters,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters
                .Builder,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels
                .LoadingPlanStabilityParametersOrBuilder>
        dischargeSequenceStabilityParametersBuilder_;

    /**
     * <code>repeated .LoadingPlanStabilityParameters dischargeSequenceStabilityParameters = 8;
     * </code>
     */
    public java.util.List<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels
                .LoadingPlanStabilityParameters>
        getDischargeSequenceStabilityParametersList() {
      if (dischargeSequenceStabilityParametersBuilder_ == null) {
        return java.util.Collections.unmodifiableList(dischargeSequenceStabilityParameters_);
      } else {
        return dischargeSequenceStabilityParametersBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .LoadingPlanStabilityParameters dischargeSequenceStabilityParameters = 8;
     * </code>
     */
    public int getDischargeSequenceStabilityParametersCount() {
      if (dischargeSequenceStabilityParametersBuilder_ == null) {
        return dischargeSequenceStabilityParameters_.size();
      } else {
        return dischargeSequenceStabilityParametersBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .LoadingPlanStabilityParameters dischargeSequenceStabilityParameters = 8;
     * </code>
     */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters
        getDischargeSequenceStabilityParameters(int index) {
      if (dischargeSequenceStabilityParametersBuilder_ == null) {
        return dischargeSequenceStabilityParameters_.get(index);
      } else {
        return dischargeSequenceStabilityParametersBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .LoadingPlanStabilityParameters dischargeSequenceStabilityParameters = 8;
     * </code>
     */
    public Builder setDischargeSequenceStabilityParameters(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters
            value) {
      if (dischargeSequenceStabilityParametersBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDischargeSequenceStabilityParametersIsMutable();
        dischargeSequenceStabilityParameters_.set(index, value);
        onChanged();
      } else {
        dischargeSequenceStabilityParametersBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .LoadingPlanStabilityParameters dischargeSequenceStabilityParameters = 8;
     * </code>
     */
    public Builder setDischargeSequenceStabilityParameters(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters
                .Builder
            builderForValue) {
      if (dischargeSequenceStabilityParametersBuilder_ == null) {
        ensureDischargeSequenceStabilityParametersIsMutable();
        dischargeSequenceStabilityParameters_.set(index, builderForValue.build());
        onChanged();
      } else {
        dischargeSequenceStabilityParametersBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .LoadingPlanStabilityParameters dischargeSequenceStabilityParameters = 8;
     * </code>
     */
    public Builder addDischargeSequenceStabilityParameters(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters
            value) {
      if (dischargeSequenceStabilityParametersBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDischargeSequenceStabilityParametersIsMutable();
        dischargeSequenceStabilityParameters_.add(value);
        onChanged();
      } else {
        dischargeSequenceStabilityParametersBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .LoadingPlanStabilityParameters dischargeSequenceStabilityParameters = 8;
     * </code>
     */
    public Builder addDischargeSequenceStabilityParameters(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters
            value) {
      if (dischargeSequenceStabilityParametersBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDischargeSequenceStabilityParametersIsMutable();
        dischargeSequenceStabilityParameters_.add(index, value);
        onChanged();
      } else {
        dischargeSequenceStabilityParametersBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .LoadingPlanStabilityParameters dischargeSequenceStabilityParameters = 8;
     * </code>
     */
    public Builder addDischargeSequenceStabilityParameters(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters
                .Builder
            builderForValue) {
      if (dischargeSequenceStabilityParametersBuilder_ == null) {
        ensureDischargeSequenceStabilityParametersIsMutable();
        dischargeSequenceStabilityParameters_.add(builderForValue.build());
        onChanged();
      } else {
        dischargeSequenceStabilityParametersBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .LoadingPlanStabilityParameters dischargeSequenceStabilityParameters = 8;
     * </code>
     */
    public Builder addDischargeSequenceStabilityParameters(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters
                .Builder
            builderForValue) {
      if (dischargeSequenceStabilityParametersBuilder_ == null) {
        ensureDischargeSequenceStabilityParametersIsMutable();
        dischargeSequenceStabilityParameters_.add(index, builderForValue.build());
        onChanged();
      } else {
        dischargeSequenceStabilityParametersBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .LoadingPlanStabilityParameters dischargeSequenceStabilityParameters = 8;
     * </code>
     */
    public Builder addAllDischargeSequenceStabilityParameters(
        java.lang.Iterable<
                ? extends
                    com.cpdss.common.generated.loading_plan.LoadingPlanModels
                        .LoadingPlanStabilityParameters>
            values) {
      if (dischargeSequenceStabilityParametersBuilder_ == null) {
        ensureDischargeSequenceStabilityParametersIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, dischargeSequenceStabilityParameters_);
        onChanged();
      } else {
        dischargeSequenceStabilityParametersBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .LoadingPlanStabilityParameters dischargeSequenceStabilityParameters = 8;
     * </code>
     */
    public Builder clearDischargeSequenceStabilityParameters() {
      if (dischargeSequenceStabilityParametersBuilder_ == null) {
        dischargeSequenceStabilityParameters_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000002);
        onChanged();
      } else {
        dischargeSequenceStabilityParametersBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .LoadingPlanStabilityParameters dischargeSequenceStabilityParameters = 8;
     * </code>
     */
    public Builder removeDischargeSequenceStabilityParameters(int index) {
      if (dischargeSequenceStabilityParametersBuilder_ == null) {
        ensureDischargeSequenceStabilityParametersIsMutable();
        dischargeSequenceStabilityParameters_.remove(index);
        onChanged();
      } else {
        dischargeSequenceStabilityParametersBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .LoadingPlanStabilityParameters dischargeSequenceStabilityParameters = 8;
     * </code>
     */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters
            .Builder
        getDischargeSequenceStabilityParametersBuilder(int index) {
      return getDischargeSequenceStabilityParametersFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .LoadingPlanStabilityParameters dischargeSequenceStabilityParameters = 8;
     * </code>
     */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels
            .LoadingPlanStabilityParametersOrBuilder
        getDischargeSequenceStabilityParametersOrBuilder(int index) {
      if (dischargeSequenceStabilityParametersBuilder_ == null) {
        return dischargeSequenceStabilityParameters_.get(index);
      } else {
        return dischargeSequenceStabilityParametersBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .LoadingPlanStabilityParameters dischargeSequenceStabilityParameters = 8;
     * </code>
     */
    public java.util.List<
            ? extends
                com.cpdss.common.generated.loading_plan.LoadingPlanModels
                    .LoadingPlanStabilityParametersOrBuilder>
        getDischargeSequenceStabilityParametersOrBuilderList() {
      if (dischargeSequenceStabilityParametersBuilder_ != null) {
        return dischargeSequenceStabilityParametersBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(dischargeSequenceStabilityParameters_);
      }
    }
    /**
     * <code>repeated .LoadingPlanStabilityParameters dischargeSequenceStabilityParameters = 8;
     * </code>
     */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters
            .Builder
        addDischargeSequenceStabilityParametersBuilder() {
      return getDischargeSequenceStabilityParametersFieldBuilder()
          .addBuilder(
              com.cpdss.common.generated.loading_plan.LoadingPlanModels
                  .LoadingPlanStabilityParameters.getDefaultInstance());
    }
    /**
     * <code>repeated .LoadingPlanStabilityParameters dischargeSequenceStabilityParameters = 8;
     * </code>
     */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters
            .Builder
        addDischargeSequenceStabilityParametersBuilder(int index) {
      return getDischargeSequenceStabilityParametersFieldBuilder()
          .addBuilder(
              index,
              com.cpdss.common.generated.loading_plan.LoadingPlanModels
                  .LoadingPlanStabilityParameters.getDefaultInstance());
    }
    /**
     * <code>repeated .LoadingPlanStabilityParameters dischargeSequenceStabilityParameters = 8;
     * </code>
     */
    public java.util.List<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters
                .Builder>
        getDischargeSequenceStabilityParametersBuilderList() {
      return getDischargeSequenceStabilityParametersFieldBuilder().getBuilderList();
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels
                .LoadingPlanStabilityParameters,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters
                .Builder,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels
                .LoadingPlanStabilityParametersOrBuilder>
        getDischargeSequenceStabilityParametersFieldBuilder() {
      if (dischargeSequenceStabilityParametersBuilder_ == null) {
        dischargeSequenceStabilityParametersBuilder_ =
            new com.google.protobuf.RepeatedFieldBuilderV3<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels
                    .LoadingPlanStabilityParameters,
                com.cpdss.common.generated.loading_plan.LoadingPlanModels
                    .LoadingPlanStabilityParameters.Builder,
                com.cpdss.common.generated.loading_plan.LoadingPlanModels
                    .LoadingPlanStabilityParametersOrBuilder>(
                dischargeSequenceStabilityParameters_,
                ((bitField0_ & 0x00000002) != 0),
                getParentForChildren(),
                isClean());
        dischargeSequenceStabilityParameters_ = null;
      }
      return dischargeSequenceStabilityParametersBuilder_;
    }

    private com.cpdss.common.generated.Common.ResponseStatus responseStatus_;
    private com.google.protobuf.SingleFieldBuilderV3<
            com.cpdss.common.generated.Common.ResponseStatus,
            com.cpdss.common.generated.Common.ResponseStatus.Builder,
            com.cpdss.common.generated.Common.ResponseStatusOrBuilder>
        responseStatusBuilder_;
    /**
     * <code>.ResponseStatus responseStatus = 9;</code>
     *
     * @return Whether the responseStatus field is set.
     */
    public boolean hasResponseStatus() {
      return responseStatusBuilder_ != null || responseStatus_ != null;
    }
    /**
     * <code>.ResponseStatus responseStatus = 9;</code>
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
    /** <code>.ResponseStatus responseStatus = 9;</code> */
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
    /** <code>.ResponseStatus responseStatus = 9;</code> */
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
    /** <code>.ResponseStatus responseStatus = 9;</code> */
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
    /** <code>.ResponseStatus responseStatus = 9;</code> */
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
    /** <code>.ResponseStatus responseStatus = 9;</code> */
    public com.cpdss.common.generated.Common.ResponseStatus.Builder getResponseStatusBuilder() {

      onChanged();
      return getResponseStatusFieldBuilder().getBuilder();
    }
    /** <code>.ResponseStatus responseStatus = 9;</code> */
    public com.cpdss.common.generated.Common.ResponseStatusOrBuilder getResponseStatusOrBuilder() {
      if (responseStatusBuilder_ != null) {
        return responseStatusBuilder_.getMessageOrBuilder();
      } else {
        return responseStatus_ == null
            ? com.cpdss.common.generated.Common.ResponseStatus.getDefaultInstance()
            : responseStatus_;
      }
    }
    /** <code>.ResponseStatus responseStatus = 9;</code> */
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

    private long portRotationId_;
    /**
     * <code>int64 portRotationId = 10;</code>
     *
     * @return The portRotationId.
     */
    public long getPortRotationId() {
      return portRotationId_;
    }
    /**
     * <code>int64 portRotationId = 10;</code>
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
     * <code>int64 portRotationId = 10;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearPortRotationId() {

      portRotationId_ = 0L;
      onChanged();
      return this;
    }

    private com.cpdss.common.generated.discharge_plan.CleaningTanks cleaningTanks_;
    private com.google.protobuf.SingleFieldBuilderV3<
            com.cpdss.common.generated.discharge_plan.CleaningTanks,
            com.cpdss.common.generated.discharge_plan.CleaningTanks.Builder,
            com.cpdss.common.generated.discharge_plan.CleaningTanksOrBuilder>
        cleaningTanksBuilder_;
    /**
     * <code>.CleaningTanks cleaningTanks = 11;</code>
     *
     * @return Whether the cleaningTanks field is set.
     */
    public boolean hasCleaningTanks() {
      return cleaningTanksBuilder_ != null || cleaningTanks_ != null;
    }
    /**
     * <code>.CleaningTanks cleaningTanks = 11;</code>
     *
     * @return The cleaningTanks.
     */
    public com.cpdss.common.generated.discharge_plan.CleaningTanks getCleaningTanks() {
      if (cleaningTanksBuilder_ == null) {
        return cleaningTanks_ == null
            ? com.cpdss.common.generated.discharge_plan.CleaningTanks.getDefaultInstance()
            : cleaningTanks_;
      } else {
        return cleaningTanksBuilder_.getMessage();
      }
    }
    /** <code>.CleaningTanks cleaningTanks = 11;</code> */
    public Builder setCleaningTanks(com.cpdss.common.generated.discharge_plan.CleaningTanks value) {
      if (cleaningTanksBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        cleaningTanks_ = value;
        onChanged();
      } else {
        cleaningTanksBuilder_.setMessage(value);
      }

      return this;
    }
    /** <code>.CleaningTanks cleaningTanks = 11;</code> */
    public Builder setCleaningTanks(
        com.cpdss.common.generated.discharge_plan.CleaningTanks.Builder builderForValue) {
      if (cleaningTanksBuilder_ == null) {
        cleaningTanks_ = builderForValue.build();
        onChanged();
      } else {
        cleaningTanksBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /** <code>.CleaningTanks cleaningTanks = 11;</code> */
    public Builder mergeCleaningTanks(
        com.cpdss.common.generated.discharge_plan.CleaningTanks value) {
      if (cleaningTanksBuilder_ == null) {
        if (cleaningTanks_ != null) {
          cleaningTanks_ =
              com.cpdss.common.generated.discharge_plan.CleaningTanks.newBuilder(cleaningTanks_)
                  .mergeFrom(value)
                  .buildPartial();
        } else {
          cleaningTanks_ = value;
        }
        onChanged();
      } else {
        cleaningTanksBuilder_.mergeFrom(value);
      }

      return this;
    }
    /** <code>.CleaningTanks cleaningTanks = 11;</code> */
    public Builder clearCleaningTanks() {
      if (cleaningTanksBuilder_ == null) {
        cleaningTanks_ = null;
        onChanged();
      } else {
        cleaningTanks_ = null;
        cleaningTanksBuilder_ = null;
      }

      return this;
    }
    /** <code>.CleaningTanks cleaningTanks = 11;</code> */
    public com.cpdss.common.generated.discharge_plan.CleaningTanks.Builder
        getCleaningTanksBuilder() {

      onChanged();
      return getCleaningTanksFieldBuilder().getBuilder();
    }
    /** <code>.CleaningTanks cleaningTanks = 11;</code> */
    public com.cpdss.common.generated.discharge_plan.CleaningTanksOrBuilder
        getCleaningTanksOrBuilder() {
      if (cleaningTanksBuilder_ != null) {
        return cleaningTanksBuilder_.getMessageOrBuilder();
      } else {
        return cleaningTanks_ == null
            ? com.cpdss.common.generated.discharge_plan.CleaningTanks.getDefaultInstance()
            : cleaningTanks_;
      }
    }
    /** <code>.CleaningTanks cleaningTanks = 11;</code> */
    private com.google.protobuf.SingleFieldBuilderV3<
            com.cpdss.common.generated.discharge_plan.CleaningTanks,
            com.cpdss.common.generated.discharge_plan.CleaningTanks.Builder,
            com.cpdss.common.generated.discharge_plan.CleaningTanksOrBuilder>
        getCleaningTanksFieldBuilder() {
      if (cleaningTanksBuilder_ == null) {
        cleaningTanksBuilder_ =
            new com.google.protobuf.SingleFieldBuilderV3<
                com.cpdss.common.generated.discharge_plan.CleaningTanks,
                com.cpdss.common.generated.discharge_plan.CleaningTanks.Builder,
                com.cpdss.common.generated.discharge_plan.CleaningTanksOrBuilder>(
                getCleaningTanks(), getParentForChildren(), isClean());
        cleaningTanks_ = null;
      }
      return cleaningTanksBuilder_;
    }

    private java.util.List<com.cpdss.common.generated.discharge_plan.DriveTankDetail>
        driveTankDetails_ = java.util.Collections.emptyList();

    private void ensureDriveTankDetailsIsMutable() {
      if (!((bitField0_ & 0x00000004) != 0)) {
        driveTankDetails_ =
            new java.util.ArrayList<com.cpdss.common.generated.discharge_plan.DriveTankDetail>(
                driveTankDetails_);
        bitField0_ |= 0x00000004;
      }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.discharge_plan.DriveTankDetail,
            com.cpdss.common.generated.discharge_plan.DriveTankDetail.Builder,
            com.cpdss.common.generated.discharge_plan.DriveTankDetailOrBuilder>
        driveTankDetailsBuilder_;

    /** <code>repeated .DriveTankDetail driveTankDetails = 12;</code> */
    public java.util.List<com.cpdss.common.generated.discharge_plan.DriveTankDetail>
        getDriveTankDetailsList() {
      if (driveTankDetailsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(driveTankDetails_);
      } else {
        return driveTankDetailsBuilder_.getMessageList();
      }
    }
    /** <code>repeated .DriveTankDetail driveTankDetails = 12;</code> */
    public int getDriveTankDetailsCount() {
      if (driveTankDetailsBuilder_ == null) {
        return driveTankDetails_.size();
      } else {
        return driveTankDetailsBuilder_.getCount();
      }
    }
    /** <code>repeated .DriveTankDetail driveTankDetails = 12;</code> */
    public com.cpdss.common.generated.discharge_plan.DriveTankDetail getDriveTankDetails(
        int index) {
      if (driveTankDetailsBuilder_ == null) {
        return driveTankDetails_.get(index);
      } else {
        return driveTankDetailsBuilder_.getMessage(index);
      }
    }
    /** <code>repeated .DriveTankDetail driveTankDetails = 12;</code> */
    public Builder setDriveTankDetails(
        int index, com.cpdss.common.generated.discharge_plan.DriveTankDetail value) {
      if (driveTankDetailsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDriveTankDetailsIsMutable();
        driveTankDetails_.set(index, value);
        onChanged();
      } else {
        driveTankDetailsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /** <code>repeated .DriveTankDetail driveTankDetails = 12;</code> */
    public Builder setDriveTankDetails(
        int index,
        com.cpdss.common.generated.discharge_plan.DriveTankDetail.Builder builderForValue) {
      if (driveTankDetailsBuilder_ == null) {
        ensureDriveTankDetailsIsMutable();
        driveTankDetails_.set(index, builderForValue.build());
        onChanged();
      } else {
        driveTankDetailsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .DriveTankDetail driveTankDetails = 12;</code> */
    public Builder addDriveTankDetails(
        com.cpdss.common.generated.discharge_plan.DriveTankDetail value) {
      if (driveTankDetailsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDriveTankDetailsIsMutable();
        driveTankDetails_.add(value);
        onChanged();
      } else {
        driveTankDetailsBuilder_.addMessage(value);
      }
      return this;
    }
    /** <code>repeated .DriveTankDetail driveTankDetails = 12;</code> */
    public Builder addDriveTankDetails(
        int index, com.cpdss.common.generated.discharge_plan.DriveTankDetail value) {
      if (driveTankDetailsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDriveTankDetailsIsMutable();
        driveTankDetails_.add(index, value);
        onChanged();
      } else {
        driveTankDetailsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /** <code>repeated .DriveTankDetail driveTankDetails = 12;</code> */
    public Builder addDriveTankDetails(
        com.cpdss.common.generated.discharge_plan.DriveTankDetail.Builder builderForValue) {
      if (driveTankDetailsBuilder_ == null) {
        ensureDriveTankDetailsIsMutable();
        driveTankDetails_.add(builderForValue.build());
        onChanged();
      } else {
        driveTankDetailsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .DriveTankDetail driveTankDetails = 12;</code> */
    public Builder addDriveTankDetails(
        int index,
        com.cpdss.common.generated.discharge_plan.DriveTankDetail.Builder builderForValue) {
      if (driveTankDetailsBuilder_ == null) {
        ensureDriveTankDetailsIsMutable();
        driveTankDetails_.add(index, builderForValue.build());
        onChanged();
      } else {
        driveTankDetailsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .DriveTankDetail driveTankDetails = 12;</code> */
    public Builder addAllDriveTankDetails(
        java.lang.Iterable<? extends com.cpdss.common.generated.discharge_plan.DriveTankDetail>
            values) {
      if (driveTankDetailsBuilder_ == null) {
        ensureDriveTankDetailsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(values, driveTankDetails_);
        onChanged();
      } else {
        driveTankDetailsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /** <code>repeated .DriveTankDetail driveTankDetails = 12;</code> */
    public Builder clearDriveTankDetails() {
      if (driveTankDetailsBuilder_ == null) {
        driveTankDetails_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000004);
        onChanged();
      } else {
        driveTankDetailsBuilder_.clear();
      }
      return this;
    }
    /** <code>repeated .DriveTankDetail driveTankDetails = 12;</code> */
    public Builder removeDriveTankDetails(int index) {
      if (driveTankDetailsBuilder_ == null) {
        ensureDriveTankDetailsIsMutable();
        driveTankDetails_.remove(index);
        onChanged();
      } else {
        driveTankDetailsBuilder_.remove(index);
      }
      return this;
    }
    /** <code>repeated .DriveTankDetail driveTankDetails = 12;</code> */
    public com.cpdss.common.generated.discharge_plan.DriveTankDetail.Builder
        getDriveTankDetailsBuilder(int index) {
      return getDriveTankDetailsFieldBuilder().getBuilder(index);
    }
    /** <code>repeated .DriveTankDetail driveTankDetails = 12;</code> */
    public com.cpdss.common.generated.discharge_plan.DriveTankDetailOrBuilder
        getDriveTankDetailsOrBuilder(int index) {
      if (driveTankDetailsBuilder_ == null) {
        return driveTankDetails_.get(index);
      } else {
        return driveTankDetailsBuilder_.getMessageOrBuilder(index);
      }
    }
    /** <code>repeated .DriveTankDetail driveTankDetails = 12;</code> */
    public java.util.List<
            ? extends com.cpdss.common.generated.discharge_plan.DriveTankDetailOrBuilder>
        getDriveTankDetailsOrBuilderList() {
      if (driveTankDetailsBuilder_ != null) {
        return driveTankDetailsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(driveTankDetails_);
      }
    }
    /** <code>repeated .DriveTankDetail driveTankDetails = 12;</code> */
    public com.cpdss.common.generated.discharge_plan.DriveTankDetail.Builder
        addDriveTankDetailsBuilder() {
      return getDriveTankDetailsFieldBuilder()
          .addBuilder(
              com.cpdss.common.generated.discharge_plan.DriveTankDetail.getDefaultInstance());
    }
    /** <code>repeated .DriveTankDetail driveTankDetails = 12;</code> */
    public com.cpdss.common.generated.discharge_plan.DriveTankDetail.Builder
        addDriveTankDetailsBuilder(int index) {
      return getDriveTankDetailsFieldBuilder()
          .addBuilder(
              index,
              com.cpdss.common.generated.discharge_plan.DriveTankDetail.getDefaultInstance());
    }
    /** <code>repeated .DriveTankDetail driveTankDetails = 12;</code> */
    public java.util.List<com.cpdss.common.generated.discharge_plan.DriveTankDetail.Builder>
        getDriveTankDetailsBuilderList() {
      return getDriveTankDetailsFieldBuilder().getBuilderList();
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.discharge_plan.DriveTankDetail,
            com.cpdss.common.generated.discharge_plan.DriveTankDetail.Builder,
            com.cpdss.common.generated.discharge_plan.DriveTankDetailOrBuilder>
        getDriveTankDetailsFieldBuilder() {
      if (driveTankDetailsBuilder_ == null) {
        driveTankDetailsBuilder_ =
            new com.google.protobuf.RepeatedFieldBuilderV3<
                com.cpdss.common.generated.discharge_plan.DriveTankDetail,
                com.cpdss.common.generated.discharge_plan.DriveTankDetail.Builder,
                com.cpdss.common.generated.discharge_plan.DriveTankDetailOrBuilder>(
                driveTankDetails_,
                ((bitField0_ & 0x00000004) != 0),
                getParentForChildren(),
                isClean());
        driveTankDetails_ = null;
      }
      return driveTankDetailsBuilder_;
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

    // @@protoc_insertion_point(builder_scope:DischargeSequenceReply)
  }

  // @@protoc_insertion_point(class_scope:DischargeSequenceReply)
  private static final com.cpdss.common.generated.discharge_plan.DischargeSequenceReply
      DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new com.cpdss.common.generated.discharge_plan.DischargeSequenceReply();
  }

  public static com.cpdss.common.generated.discharge_plan.DischargeSequenceReply
      getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<DischargeSequenceReply> PARSER =
      new com.google.protobuf.AbstractParser<DischargeSequenceReply>() {
        @java.lang.Override
        public DischargeSequenceReply parsePartialFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
          return new DischargeSequenceReply(input, extensionRegistry);
        }
      };

  public static com.google.protobuf.Parser<DischargeSequenceReply> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<DischargeSequenceReply> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.cpdss.common.generated.discharge_plan.DischargeSequenceReply
      getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
}
