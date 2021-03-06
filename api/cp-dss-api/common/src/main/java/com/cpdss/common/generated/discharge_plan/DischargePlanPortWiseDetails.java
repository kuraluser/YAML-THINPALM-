/* Licensed at AlphaOri Technologies */
package com.cpdss.common.generated.discharge_plan;

/** Protobuf type {@code DischargePlanPortWiseDetails} */
public final class DischargePlanPortWiseDetails extends com.google.protobuf.GeneratedMessageV3
    implements
    // @@protoc_insertion_point(message_implements:DischargePlanPortWiseDetails)
    DischargePlanPortWiseDetailsOrBuilder {
  private static final long serialVersionUID = 0L;
  // Use DischargePlanPortWiseDetails.newBuilder() to construct.
  private DischargePlanPortWiseDetails(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }

  private DischargePlanPortWiseDetails() {
    deballastingRates_ = java.util.Collections.emptyList();
    dischargingPlanBallastDetails_ = java.util.Collections.emptyList();
    dischargingPlanRobDetails_ = java.util.Collections.emptyList();
    dischargingPlanStowageDetails_ = java.util.Collections.emptyList();
    dischargingPlanCommingleDetails_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
    return new DischargePlanPortWiseDetails();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }

  private DischargePlanPortWiseDetails(
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
              if (!((mutable_bitField0_ & 0x00000001) != 0)) {
                deballastingRates_ =
                    new java.util.ArrayList<
                        com.cpdss.common.generated.loading_plan.LoadingPlanModels
                            .DeBallastingRate>();
                mutable_bitField0_ |= 0x00000001;
              }
              deballastingRates_.add(
                  input.readMessage(
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRate
                          .parser(),
                      extensionRegistry));
              break;
            }
          case 18:
            {
              if (!((mutable_bitField0_ & 0x00000002) != 0)) {
                dischargingPlanBallastDetails_ =
                    new java.util.ArrayList<
                        com.cpdss.common.generated.loading_plan.LoadingPlanModels
                            .LoadingPlanTankDetails>();
                mutable_bitField0_ |= 0x00000002;
              }
              dischargingPlanBallastDetails_.add(
                  input.readMessage(
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels
                          .LoadingPlanTankDetails.parser(),
                      extensionRegistry));
              break;
            }
          case 26:
            {
              if (!((mutable_bitField0_ & 0x00000004) != 0)) {
                dischargingPlanRobDetails_ =
                    new java.util.ArrayList<
                        com.cpdss.common.generated.loading_plan.LoadingPlanModels
                            .LoadingPlanTankDetails>();
                mutable_bitField0_ |= 0x00000004;
              }
              dischargingPlanRobDetails_.add(
                  input.readMessage(
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels
                          .LoadingPlanTankDetails.parser(),
                      extensionRegistry));
              break;
            }
          case 34:
            {
              com.cpdss.common.generated.loading_plan.LoadingPlanModels
                      .LoadingPlanStabilityParameters.Builder
                  subBuilder = null;
              if (dischargingPlanStabilityParameters_ != null) {
                subBuilder = dischargingPlanStabilityParameters_.toBuilder();
              }
              dischargingPlanStabilityParameters_ =
                  input.readMessage(
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels
                          .LoadingPlanStabilityParameters.parser(),
                      extensionRegistry);
              if (subBuilder != null) {
                subBuilder.mergeFrom(dischargingPlanStabilityParameters_);
                dischargingPlanStabilityParameters_ = subBuilder.buildPartial();
              }

              break;
            }
          case 42:
            {
              if (!((mutable_bitField0_ & 0x00000008) != 0)) {
                dischargingPlanStowageDetails_ =
                    new java.util.ArrayList<
                        com.cpdss.common.generated.loading_plan.LoadingPlanModels
                            .LoadingPlanTankDetails>();
                mutable_bitField0_ |= 0x00000008;
              }
              dischargingPlanStowageDetails_.add(
                  input.readMessage(
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels
                          .LoadingPlanTankDetails.parser(),
                      extensionRegistry));
              break;
            }
          case 48:
            {
              time_ = input.readInt32();
              break;
            }
          case 58:
            {
              if (!((mutable_bitField0_ & 0x00000010) != 0)) {
                dischargingPlanCommingleDetails_ =
                    new java.util.ArrayList<
                        com.cpdss.common.generated.loading_plan.LoadingPlanModels
                            .LoadingPlanCommingleDetails>();
                mutable_bitField0_ |= 0x00000010;
              }
              dischargingPlanCommingleDetails_.add(
                  input.readMessage(
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels
                          .LoadingPlanCommingleDetails.parser(),
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
        deballastingRates_ = java.util.Collections.unmodifiableList(deballastingRates_);
      }
      if (((mutable_bitField0_ & 0x00000002) != 0)) {
        dischargingPlanBallastDetails_ =
            java.util.Collections.unmodifiableList(dischargingPlanBallastDetails_);
      }
      if (((mutable_bitField0_ & 0x00000004) != 0)) {
        dischargingPlanRobDetails_ =
            java.util.Collections.unmodifiableList(dischargingPlanRobDetails_);
      }
      if (((mutable_bitField0_ & 0x00000008) != 0)) {
        dischargingPlanStowageDetails_ =
            java.util.Collections.unmodifiableList(dischargingPlanStowageDetails_);
      }
      if (((mutable_bitField0_ & 0x00000010) != 0)) {
        dischargingPlanCommingleDetails_ =
            java.util.Collections.unmodifiableList(dischargingPlanCommingleDetails_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }

  public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
    return com.cpdss.common.generated.discharge_plan.DischargePlanModels
        .internal_static_DischargePlanPortWiseDetails_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.cpdss.common.generated.discharge_plan.DischargePlanModels
        .internal_static_DischargePlanPortWiseDetails_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails.class,
            com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails.Builder.class);
  }

  public static final int DEBALLASTINGRATES_FIELD_NUMBER = 1;
  private java.util.List<com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRate>
      deballastingRates_;
  /** <code>repeated .DeBallastingRate deballastingRates = 1;</code> */
  public java.util.List<com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRate>
      getDeballastingRatesList() {
    return deballastingRates_;
  }
  /** <code>repeated .DeBallastingRate deballastingRates = 1;</code> */
  public java.util.List<
          ? extends
              com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRateOrBuilder>
      getDeballastingRatesOrBuilderList() {
    return deballastingRates_;
  }
  /** <code>repeated .DeBallastingRate deballastingRates = 1;</code> */
  public int getDeballastingRatesCount() {
    return deballastingRates_.size();
  }
  /** <code>repeated .DeBallastingRate deballastingRates = 1;</code> */
  public com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRate
      getDeballastingRates(int index) {
    return deballastingRates_.get(index);
  }
  /** <code>repeated .DeBallastingRate deballastingRates = 1;</code> */
  public com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRateOrBuilder
      getDeballastingRatesOrBuilder(int index) {
    return deballastingRates_.get(index);
  }

  public static final int DISCHARGINGPLANBALLASTDETAILS_FIELD_NUMBER = 2;
  private java.util.List<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails>
      dischargingPlanBallastDetails_;
  /** <code>repeated .LoadingPlanTankDetails dischargingPlanBallastDetails = 2;</code> */
  public java.util.List<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails>
      getDischargingPlanBallastDetailsList() {
    return dischargingPlanBallastDetails_;
  }
  /** <code>repeated .LoadingPlanTankDetails dischargingPlanBallastDetails = 2;</code> */
  public java.util.List<
          ? extends
              com.cpdss.common.generated.loading_plan.LoadingPlanModels
                  .LoadingPlanTankDetailsOrBuilder>
      getDischargingPlanBallastDetailsOrBuilderList() {
    return dischargingPlanBallastDetails_;
  }
  /** <code>repeated .LoadingPlanTankDetails dischargingPlanBallastDetails = 2;</code> */
  public int getDischargingPlanBallastDetailsCount() {
    return dischargingPlanBallastDetails_.size();
  }
  /** <code>repeated .LoadingPlanTankDetails dischargingPlanBallastDetails = 2;</code> */
  public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
      getDischargingPlanBallastDetails(int index) {
    return dischargingPlanBallastDetails_.get(index);
  }
  /** <code>repeated .LoadingPlanTankDetails dischargingPlanBallastDetails = 2;</code> */
  public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetailsOrBuilder
      getDischargingPlanBallastDetailsOrBuilder(int index) {
    return dischargingPlanBallastDetails_.get(index);
  }

  public static final int DISCHARGINGPLANROBDETAILS_FIELD_NUMBER = 3;
  private java.util.List<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails>
      dischargingPlanRobDetails_;
  /** <code>repeated .LoadingPlanTankDetails dischargingPlanRobDetails = 3;</code> */
  public java.util.List<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails>
      getDischargingPlanRobDetailsList() {
    return dischargingPlanRobDetails_;
  }
  /** <code>repeated .LoadingPlanTankDetails dischargingPlanRobDetails = 3;</code> */
  public java.util.List<
          ? extends
              com.cpdss.common.generated.loading_plan.LoadingPlanModels
                  .LoadingPlanTankDetailsOrBuilder>
      getDischargingPlanRobDetailsOrBuilderList() {
    return dischargingPlanRobDetails_;
  }
  /** <code>repeated .LoadingPlanTankDetails dischargingPlanRobDetails = 3;</code> */
  public int getDischargingPlanRobDetailsCount() {
    return dischargingPlanRobDetails_.size();
  }
  /** <code>repeated .LoadingPlanTankDetails dischargingPlanRobDetails = 3;</code> */
  public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
      getDischargingPlanRobDetails(int index) {
    return dischargingPlanRobDetails_.get(index);
  }
  /** <code>repeated .LoadingPlanTankDetails dischargingPlanRobDetails = 3;</code> */
  public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetailsOrBuilder
      getDischargingPlanRobDetailsOrBuilder(int index) {
    return dischargingPlanRobDetails_.get(index);
  }

  public static final int DISCHARGINGPLANSTABILITYPARAMETERS_FIELD_NUMBER = 4;
  private com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters
      dischargingPlanStabilityParameters_;
  /**
   * <code>.LoadingPlanStabilityParameters dischargingPlanStabilityParameters = 4;</code>
   *
   * @return Whether the dischargingPlanStabilityParameters field is set.
   */
  public boolean hasDischargingPlanStabilityParameters() {
    return dischargingPlanStabilityParameters_ != null;
  }
  /**
   * <code>.LoadingPlanStabilityParameters dischargingPlanStabilityParameters = 4;</code>
   *
   * @return The dischargingPlanStabilityParameters.
   */
  public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters
      getDischargingPlanStabilityParameters() {
    return dischargingPlanStabilityParameters_ == null
        ? com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters
            .getDefaultInstance()
        : dischargingPlanStabilityParameters_;
  }
  /** <code>.LoadingPlanStabilityParameters dischargingPlanStabilityParameters = 4;</code> */
  public com.cpdss.common.generated.loading_plan.LoadingPlanModels
          .LoadingPlanStabilityParametersOrBuilder
      getDischargingPlanStabilityParametersOrBuilder() {
    return getDischargingPlanStabilityParameters();
  }

  public static final int DISCHARGINGPLANSTOWAGEDETAILS_FIELD_NUMBER = 5;
  private java.util.List<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails>
      dischargingPlanStowageDetails_;
  /** <code>repeated .LoadingPlanTankDetails dischargingPlanStowageDetails = 5;</code> */
  public java.util.List<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails>
      getDischargingPlanStowageDetailsList() {
    return dischargingPlanStowageDetails_;
  }
  /** <code>repeated .LoadingPlanTankDetails dischargingPlanStowageDetails = 5;</code> */
  public java.util.List<
          ? extends
              com.cpdss.common.generated.loading_plan.LoadingPlanModels
                  .LoadingPlanTankDetailsOrBuilder>
      getDischargingPlanStowageDetailsOrBuilderList() {
    return dischargingPlanStowageDetails_;
  }
  /** <code>repeated .LoadingPlanTankDetails dischargingPlanStowageDetails = 5;</code> */
  public int getDischargingPlanStowageDetailsCount() {
    return dischargingPlanStowageDetails_.size();
  }
  /** <code>repeated .LoadingPlanTankDetails dischargingPlanStowageDetails = 5;</code> */
  public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
      getDischargingPlanStowageDetails(int index) {
    return dischargingPlanStowageDetails_.get(index);
  }
  /** <code>repeated .LoadingPlanTankDetails dischargingPlanStowageDetails = 5;</code> */
  public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetailsOrBuilder
      getDischargingPlanStowageDetailsOrBuilder(int index) {
    return dischargingPlanStowageDetails_.get(index);
  }

  public static final int TIME_FIELD_NUMBER = 6;
  private int time_;
  /**
   * <code>int32 time = 6;</code>
   *
   * @return The time.
   */
  public int getTime() {
    return time_;
  }

  public static final int DISCHARGINGPLANCOMMINGLEDETAILS_FIELD_NUMBER = 7;
  private java.util.List<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanCommingleDetails>
      dischargingPlanCommingleDetails_;
  /** <code>repeated .LoadingPlanCommingleDetails dischargingPlanCommingleDetails = 7;</code> */
  public java.util.List<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanCommingleDetails>
      getDischargingPlanCommingleDetailsList() {
    return dischargingPlanCommingleDetails_;
  }
  /** <code>repeated .LoadingPlanCommingleDetails dischargingPlanCommingleDetails = 7;</code> */
  public java.util.List<
          ? extends
              com.cpdss.common.generated.loading_plan.LoadingPlanModels
                  .LoadingPlanCommingleDetailsOrBuilder>
      getDischargingPlanCommingleDetailsOrBuilderList() {
    return dischargingPlanCommingleDetails_;
  }
  /** <code>repeated .LoadingPlanCommingleDetails dischargingPlanCommingleDetails = 7;</code> */
  public int getDischargingPlanCommingleDetailsCount() {
    return dischargingPlanCommingleDetails_.size();
  }
  /** <code>repeated .LoadingPlanCommingleDetails dischargingPlanCommingleDetails = 7;</code> */
  public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanCommingleDetails
      getDischargingPlanCommingleDetails(int index) {
    return dischargingPlanCommingleDetails_.get(index);
  }
  /** <code>repeated .LoadingPlanCommingleDetails dischargingPlanCommingleDetails = 7;</code> */
  public com.cpdss.common.generated.loading_plan.LoadingPlanModels
          .LoadingPlanCommingleDetailsOrBuilder
      getDischargingPlanCommingleDetailsOrBuilder(int index) {
    return dischargingPlanCommingleDetails_.get(index);
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
    for (int i = 0; i < deballastingRates_.size(); i++) {
      output.writeMessage(1, deballastingRates_.get(i));
    }
    for (int i = 0; i < dischargingPlanBallastDetails_.size(); i++) {
      output.writeMessage(2, dischargingPlanBallastDetails_.get(i));
    }
    for (int i = 0; i < dischargingPlanRobDetails_.size(); i++) {
      output.writeMessage(3, dischargingPlanRobDetails_.get(i));
    }
    if (dischargingPlanStabilityParameters_ != null) {
      output.writeMessage(4, getDischargingPlanStabilityParameters());
    }
    for (int i = 0; i < dischargingPlanStowageDetails_.size(); i++) {
      output.writeMessage(5, dischargingPlanStowageDetails_.get(i));
    }
    if (time_ != 0) {
      output.writeInt32(6, time_);
    }
    for (int i = 0; i < dischargingPlanCommingleDetails_.size(); i++) {
      output.writeMessage(7, dischargingPlanCommingleDetails_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < deballastingRates_.size(); i++) {
      size +=
          com.google.protobuf.CodedOutputStream.computeMessageSize(1, deballastingRates_.get(i));
    }
    for (int i = 0; i < dischargingPlanBallastDetails_.size(); i++) {
      size +=
          com.google.protobuf.CodedOutputStream.computeMessageSize(
              2, dischargingPlanBallastDetails_.get(i));
    }
    for (int i = 0; i < dischargingPlanRobDetails_.size(); i++) {
      size +=
          com.google.protobuf.CodedOutputStream.computeMessageSize(
              3, dischargingPlanRobDetails_.get(i));
    }
    if (dischargingPlanStabilityParameters_ != null) {
      size +=
          com.google.protobuf.CodedOutputStream.computeMessageSize(
              4, getDischargingPlanStabilityParameters());
    }
    for (int i = 0; i < dischargingPlanStowageDetails_.size(); i++) {
      size +=
          com.google.protobuf.CodedOutputStream.computeMessageSize(
              5, dischargingPlanStowageDetails_.get(i));
    }
    if (time_ != 0) {
      size += com.google.protobuf.CodedOutputStream.computeInt32Size(6, time_);
    }
    for (int i = 0; i < dischargingPlanCommingleDetails_.size(); i++) {
      size +=
          com.google.protobuf.CodedOutputStream.computeMessageSize(
              7, dischargingPlanCommingleDetails_.get(i));
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
    if (!(obj instanceof com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails)) {
      return super.equals(obj);
    }
    com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails other =
        (com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails) obj;

    if (!getDeballastingRatesList().equals(other.getDeballastingRatesList())) return false;
    if (!getDischargingPlanBallastDetailsList()
        .equals(other.getDischargingPlanBallastDetailsList())) return false;
    if (!getDischargingPlanRobDetailsList().equals(other.getDischargingPlanRobDetailsList()))
      return false;
    if (hasDischargingPlanStabilityParameters() != other.hasDischargingPlanStabilityParameters())
      return false;
    if (hasDischargingPlanStabilityParameters()) {
      if (!getDischargingPlanStabilityParameters()
          .equals(other.getDischargingPlanStabilityParameters())) return false;
    }
    if (!getDischargingPlanStowageDetailsList()
        .equals(other.getDischargingPlanStowageDetailsList())) return false;
    if (getTime() != other.getTime()) return false;
    if (!getDischargingPlanCommingleDetailsList()
        .equals(other.getDischargingPlanCommingleDetailsList())) return false;
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
    if (getDeballastingRatesCount() > 0) {
      hash = (37 * hash) + DEBALLASTINGRATES_FIELD_NUMBER;
      hash = (53 * hash) + getDeballastingRatesList().hashCode();
    }
    if (getDischargingPlanBallastDetailsCount() > 0) {
      hash = (37 * hash) + DISCHARGINGPLANBALLASTDETAILS_FIELD_NUMBER;
      hash = (53 * hash) + getDischargingPlanBallastDetailsList().hashCode();
    }
    if (getDischargingPlanRobDetailsCount() > 0) {
      hash = (37 * hash) + DISCHARGINGPLANROBDETAILS_FIELD_NUMBER;
      hash = (53 * hash) + getDischargingPlanRobDetailsList().hashCode();
    }
    if (hasDischargingPlanStabilityParameters()) {
      hash = (37 * hash) + DISCHARGINGPLANSTABILITYPARAMETERS_FIELD_NUMBER;
      hash = (53 * hash) + getDischargingPlanStabilityParameters().hashCode();
    }
    if (getDischargingPlanStowageDetailsCount() > 0) {
      hash = (37 * hash) + DISCHARGINGPLANSTOWAGEDETAILS_FIELD_NUMBER;
      hash = (53 * hash) + getDischargingPlanStowageDetailsList().hashCode();
    }
    hash = (37 * hash) + TIME_FIELD_NUMBER;
    hash = (53 * hash) + getTime();
    if (getDischargingPlanCommingleDetailsCount() > 0) {
      hash = (37 * hash) + DISCHARGINGPLANCOMMINGLEDETAILS_FIELD_NUMBER;
      hash = (53 * hash) + getDischargingPlanCommingleDetailsList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails parseFrom(
      java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails parseFrom(
      java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails parseFrom(
      byte[] data) throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails parseFrom(
      byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails parseFrom(
      java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails parseFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails
      parseDelimitedFrom(java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails
      parseDelimitedFrom(
          java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails parseFrom(
      com.google.protobuf.CodedInputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails parseFrom(
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
      com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails prototype) {
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
  /** Protobuf type {@code DischargePlanPortWiseDetails} */
  public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
      implements
      // @@protoc_insertion_point(builder_implements:DischargePlanPortWiseDetails)
      com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetailsOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanModels
          .internal_static_DischargePlanPortWiseDetails_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanModels
          .internal_static_DischargePlanPortWiseDetails_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails.class,
              com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails.Builder.class);
    }

    // Construct using
    // com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {
        getDeballastingRatesFieldBuilder();
        getDischargingPlanBallastDetailsFieldBuilder();
        getDischargingPlanRobDetailsFieldBuilder();
        getDischargingPlanStowageDetailsFieldBuilder();
        getDischargingPlanCommingleDetailsFieldBuilder();
      }
    }

    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (deballastingRatesBuilder_ == null) {
        deballastingRates_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        deballastingRatesBuilder_.clear();
      }
      if (dischargingPlanBallastDetailsBuilder_ == null) {
        dischargingPlanBallastDetails_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000002);
      } else {
        dischargingPlanBallastDetailsBuilder_.clear();
      }
      if (dischargingPlanRobDetailsBuilder_ == null) {
        dischargingPlanRobDetails_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000004);
      } else {
        dischargingPlanRobDetailsBuilder_.clear();
      }
      if (dischargingPlanStabilityParametersBuilder_ == null) {
        dischargingPlanStabilityParameters_ = null;
      } else {
        dischargingPlanStabilityParameters_ = null;
        dischargingPlanStabilityParametersBuilder_ = null;
      }
      if (dischargingPlanStowageDetailsBuilder_ == null) {
        dischargingPlanStowageDetails_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000008);
      } else {
        dischargingPlanStowageDetailsBuilder_.clear();
      }
      time_ = 0;

      if (dischargingPlanCommingleDetailsBuilder_ == null) {
        dischargingPlanCommingleDetails_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000010);
      } else {
        dischargingPlanCommingleDetailsBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanModels
          .internal_static_DischargePlanPortWiseDetails_descriptor;
    }

    @java.lang.Override
    public com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails
        getDefaultInstanceForType() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails
          .getDefaultInstance();
    }

    @java.lang.Override
    public com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails build() {
      com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails result =
          buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails buildPartial() {
      com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails result =
          new com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails(this);
      int from_bitField0_ = bitField0_;
      if (deballastingRatesBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          deballastingRates_ = java.util.Collections.unmodifiableList(deballastingRates_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.deballastingRates_ = deballastingRates_;
      } else {
        result.deballastingRates_ = deballastingRatesBuilder_.build();
      }
      if (dischargingPlanBallastDetailsBuilder_ == null) {
        if (((bitField0_ & 0x00000002) != 0)) {
          dischargingPlanBallastDetails_ =
              java.util.Collections.unmodifiableList(dischargingPlanBallastDetails_);
          bitField0_ = (bitField0_ & ~0x00000002);
        }
        result.dischargingPlanBallastDetails_ = dischargingPlanBallastDetails_;
      } else {
        result.dischargingPlanBallastDetails_ = dischargingPlanBallastDetailsBuilder_.build();
      }
      if (dischargingPlanRobDetailsBuilder_ == null) {
        if (((bitField0_ & 0x00000004) != 0)) {
          dischargingPlanRobDetails_ =
              java.util.Collections.unmodifiableList(dischargingPlanRobDetails_);
          bitField0_ = (bitField0_ & ~0x00000004);
        }
        result.dischargingPlanRobDetails_ = dischargingPlanRobDetails_;
      } else {
        result.dischargingPlanRobDetails_ = dischargingPlanRobDetailsBuilder_.build();
      }
      if (dischargingPlanStabilityParametersBuilder_ == null) {
        result.dischargingPlanStabilityParameters_ = dischargingPlanStabilityParameters_;
      } else {
        result.dischargingPlanStabilityParameters_ =
            dischargingPlanStabilityParametersBuilder_.build();
      }
      if (dischargingPlanStowageDetailsBuilder_ == null) {
        if (((bitField0_ & 0x00000008) != 0)) {
          dischargingPlanStowageDetails_ =
              java.util.Collections.unmodifiableList(dischargingPlanStowageDetails_);
          bitField0_ = (bitField0_ & ~0x00000008);
        }
        result.dischargingPlanStowageDetails_ = dischargingPlanStowageDetails_;
      } else {
        result.dischargingPlanStowageDetails_ = dischargingPlanStowageDetailsBuilder_.build();
      }
      result.time_ = time_;
      if (dischargingPlanCommingleDetailsBuilder_ == null) {
        if (((bitField0_ & 0x00000010) != 0)) {
          dischargingPlanCommingleDetails_ =
              java.util.Collections.unmodifiableList(dischargingPlanCommingleDetails_);
          bitField0_ = (bitField0_ & ~0x00000010);
        }
        result.dischargingPlanCommingleDetails_ = dischargingPlanCommingleDetails_;
      } else {
        result.dischargingPlanCommingleDetails_ = dischargingPlanCommingleDetailsBuilder_.build();
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
      if (other instanceof com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails) {
        return mergeFrom(
            (com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails) other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(
        com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails other) {
      if (other
          == com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails
              .getDefaultInstance()) return this;
      if (deballastingRatesBuilder_ == null) {
        if (!other.deballastingRates_.isEmpty()) {
          if (deballastingRates_.isEmpty()) {
            deballastingRates_ = other.deballastingRates_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureDeballastingRatesIsMutable();
            deballastingRates_.addAll(other.deballastingRates_);
          }
          onChanged();
        }
      } else {
        if (!other.deballastingRates_.isEmpty()) {
          if (deballastingRatesBuilder_.isEmpty()) {
            deballastingRatesBuilder_.dispose();
            deballastingRatesBuilder_ = null;
            deballastingRates_ = other.deballastingRates_;
            bitField0_ = (bitField0_ & ~0x00000001);
            deballastingRatesBuilder_ =
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
                    ? getDeballastingRatesFieldBuilder()
                    : null;
          } else {
            deballastingRatesBuilder_.addAllMessages(other.deballastingRates_);
          }
        }
      }
      if (dischargingPlanBallastDetailsBuilder_ == null) {
        if (!other.dischargingPlanBallastDetails_.isEmpty()) {
          if (dischargingPlanBallastDetails_.isEmpty()) {
            dischargingPlanBallastDetails_ = other.dischargingPlanBallastDetails_;
            bitField0_ = (bitField0_ & ~0x00000002);
          } else {
            ensureDischargingPlanBallastDetailsIsMutable();
            dischargingPlanBallastDetails_.addAll(other.dischargingPlanBallastDetails_);
          }
          onChanged();
        }
      } else {
        if (!other.dischargingPlanBallastDetails_.isEmpty()) {
          if (dischargingPlanBallastDetailsBuilder_.isEmpty()) {
            dischargingPlanBallastDetailsBuilder_.dispose();
            dischargingPlanBallastDetailsBuilder_ = null;
            dischargingPlanBallastDetails_ = other.dischargingPlanBallastDetails_;
            bitField0_ = (bitField0_ & ~0x00000002);
            dischargingPlanBallastDetailsBuilder_ =
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
                    ? getDischargingPlanBallastDetailsFieldBuilder()
                    : null;
          } else {
            dischargingPlanBallastDetailsBuilder_.addAllMessages(
                other.dischargingPlanBallastDetails_);
          }
        }
      }
      if (dischargingPlanRobDetailsBuilder_ == null) {
        if (!other.dischargingPlanRobDetails_.isEmpty()) {
          if (dischargingPlanRobDetails_.isEmpty()) {
            dischargingPlanRobDetails_ = other.dischargingPlanRobDetails_;
            bitField0_ = (bitField0_ & ~0x00000004);
          } else {
            ensureDischargingPlanRobDetailsIsMutable();
            dischargingPlanRobDetails_.addAll(other.dischargingPlanRobDetails_);
          }
          onChanged();
        }
      } else {
        if (!other.dischargingPlanRobDetails_.isEmpty()) {
          if (dischargingPlanRobDetailsBuilder_.isEmpty()) {
            dischargingPlanRobDetailsBuilder_.dispose();
            dischargingPlanRobDetailsBuilder_ = null;
            dischargingPlanRobDetails_ = other.dischargingPlanRobDetails_;
            bitField0_ = (bitField0_ & ~0x00000004);
            dischargingPlanRobDetailsBuilder_ =
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
                    ? getDischargingPlanRobDetailsFieldBuilder()
                    : null;
          } else {
            dischargingPlanRobDetailsBuilder_.addAllMessages(other.dischargingPlanRobDetails_);
          }
        }
      }
      if (other.hasDischargingPlanStabilityParameters()) {
        mergeDischargingPlanStabilityParameters(other.getDischargingPlanStabilityParameters());
      }
      if (dischargingPlanStowageDetailsBuilder_ == null) {
        if (!other.dischargingPlanStowageDetails_.isEmpty()) {
          if (dischargingPlanStowageDetails_.isEmpty()) {
            dischargingPlanStowageDetails_ = other.dischargingPlanStowageDetails_;
            bitField0_ = (bitField0_ & ~0x00000008);
          } else {
            ensureDischargingPlanStowageDetailsIsMutable();
            dischargingPlanStowageDetails_.addAll(other.dischargingPlanStowageDetails_);
          }
          onChanged();
        }
      } else {
        if (!other.dischargingPlanStowageDetails_.isEmpty()) {
          if (dischargingPlanStowageDetailsBuilder_.isEmpty()) {
            dischargingPlanStowageDetailsBuilder_.dispose();
            dischargingPlanStowageDetailsBuilder_ = null;
            dischargingPlanStowageDetails_ = other.dischargingPlanStowageDetails_;
            bitField0_ = (bitField0_ & ~0x00000008);
            dischargingPlanStowageDetailsBuilder_ =
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
                    ? getDischargingPlanStowageDetailsFieldBuilder()
                    : null;
          } else {
            dischargingPlanStowageDetailsBuilder_.addAllMessages(
                other.dischargingPlanStowageDetails_);
          }
        }
      }
      if (other.getTime() != 0) {
        setTime(other.getTime());
      }
      if (dischargingPlanCommingleDetailsBuilder_ == null) {
        if (!other.dischargingPlanCommingleDetails_.isEmpty()) {
          if (dischargingPlanCommingleDetails_.isEmpty()) {
            dischargingPlanCommingleDetails_ = other.dischargingPlanCommingleDetails_;
            bitField0_ = (bitField0_ & ~0x00000010);
          } else {
            ensureDischargingPlanCommingleDetailsIsMutable();
            dischargingPlanCommingleDetails_.addAll(other.dischargingPlanCommingleDetails_);
          }
          onChanged();
        }
      } else {
        if (!other.dischargingPlanCommingleDetails_.isEmpty()) {
          if (dischargingPlanCommingleDetailsBuilder_.isEmpty()) {
            dischargingPlanCommingleDetailsBuilder_.dispose();
            dischargingPlanCommingleDetailsBuilder_ = null;
            dischargingPlanCommingleDetails_ = other.dischargingPlanCommingleDetails_;
            bitField0_ = (bitField0_ & ~0x00000010);
            dischargingPlanCommingleDetailsBuilder_ =
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
                    ? getDischargingPlanCommingleDetailsFieldBuilder()
                    : null;
          } else {
            dischargingPlanCommingleDetailsBuilder_.addAllMessages(
                other.dischargingPlanCommingleDetails_);
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
      com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage =
            (com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails)
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

    private java.util.List<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRate>
        deballastingRates_ = java.util.Collections.emptyList();

    private void ensureDeballastingRatesIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        deballastingRates_ =
            new java.util.ArrayList<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRate>(
                deballastingRates_);
        bitField0_ |= 0x00000001;
      }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRate,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRate.Builder,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRateOrBuilder>
        deballastingRatesBuilder_;

    /** <code>repeated .DeBallastingRate deballastingRates = 1;</code> */
    public java.util.List<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRate>
        getDeballastingRatesList() {
      if (deballastingRatesBuilder_ == null) {
        return java.util.Collections.unmodifiableList(deballastingRates_);
      } else {
        return deballastingRatesBuilder_.getMessageList();
      }
    }
    /** <code>repeated .DeBallastingRate deballastingRates = 1;</code> */
    public int getDeballastingRatesCount() {
      if (deballastingRatesBuilder_ == null) {
        return deballastingRates_.size();
      } else {
        return deballastingRatesBuilder_.getCount();
      }
    }
    /** <code>repeated .DeBallastingRate deballastingRates = 1;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRate
        getDeballastingRates(int index) {
      if (deballastingRatesBuilder_ == null) {
        return deballastingRates_.get(index);
      } else {
        return deballastingRatesBuilder_.getMessage(index);
      }
    }
    /** <code>repeated .DeBallastingRate deballastingRates = 1;</code> */
    public Builder setDeballastingRates(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRate value) {
      if (deballastingRatesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDeballastingRatesIsMutable();
        deballastingRates_.set(index, value);
        onChanged();
      } else {
        deballastingRatesBuilder_.setMessage(index, value);
      }
      return this;
    }
    /** <code>repeated .DeBallastingRate deballastingRates = 1;</code> */
    public Builder setDeballastingRates(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRate.Builder
            builderForValue) {
      if (deballastingRatesBuilder_ == null) {
        ensureDeballastingRatesIsMutable();
        deballastingRates_.set(index, builderForValue.build());
        onChanged();
      } else {
        deballastingRatesBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .DeBallastingRate deballastingRates = 1;</code> */
    public Builder addDeballastingRates(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRate value) {
      if (deballastingRatesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDeballastingRatesIsMutable();
        deballastingRates_.add(value);
        onChanged();
      } else {
        deballastingRatesBuilder_.addMessage(value);
      }
      return this;
    }
    /** <code>repeated .DeBallastingRate deballastingRates = 1;</code> */
    public Builder addDeballastingRates(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRate value) {
      if (deballastingRatesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDeballastingRatesIsMutable();
        deballastingRates_.add(index, value);
        onChanged();
      } else {
        deballastingRatesBuilder_.addMessage(index, value);
      }
      return this;
    }
    /** <code>repeated .DeBallastingRate deballastingRates = 1;</code> */
    public Builder addDeballastingRates(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRate.Builder
            builderForValue) {
      if (deballastingRatesBuilder_ == null) {
        ensureDeballastingRatesIsMutable();
        deballastingRates_.add(builderForValue.build());
        onChanged();
      } else {
        deballastingRatesBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .DeBallastingRate deballastingRates = 1;</code> */
    public Builder addDeballastingRates(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRate.Builder
            builderForValue) {
      if (deballastingRatesBuilder_ == null) {
        ensureDeballastingRatesIsMutable();
        deballastingRates_.add(index, builderForValue.build());
        onChanged();
      } else {
        deballastingRatesBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .DeBallastingRate deballastingRates = 1;</code> */
    public Builder addAllDeballastingRates(
        java.lang.Iterable<
                ? extends
                    com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRate>
            values) {
      if (deballastingRatesBuilder_ == null) {
        ensureDeballastingRatesIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(values, deballastingRates_);
        onChanged();
      } else {
        deballastingRatesBuilder_.addAllMessages(values);
      }
      return this;
    }
    /** <code>repeated .DeBallastingRate deballastingRates = 1;</code> */
    public Builder clearDeballastingRates() {
      if (deballastingRatesBuilder_ == null) {
        deballastingRates_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        deballastingRatesBuilder_.clear();
      }
      return this;
    }
    /** <code>repeated .DeBallastingRate deballastingRates = 1;</code> */
    public Builder removeDeballastingRates(int index) {
      if (deballastingRatesBuilder_ == null) {
        ensureDeballastingRatesIsMutable();
        deballastingRates_.remove(index);
        onChanged();
      } else {
        deballastingRatesBuilder_.remove(index);
      }
      return this;
    }
    /** <code>repeated .DeBallastingRate deballastingRates = 1;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRate.Builder
        getDeballastingRatesBuilder(int index) {
      return getDeballastingRatesFieldBuilder().getBuilder(index);
    }
    /** <code>repeated .DeBallastingRate deballastingRates = 1;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRateOrBuilder
        getDeballastingRatesOrBuilder(int index) {
      if (deballastingRatesBuilder_ == null) {
        return deballastingRates_.get(index);
      } else {
        return deballastingRatesBuilder_.getMessageOrBuilder(index);
      }
    }
    /** <code>repeated .DeBallastingRate deballastingRates = 1;</code> */
    public java.util.List<
            ? extends
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRateOrBuilder>
        getDeballastingRatesOrBuilderList() {
      if (deballastingRatesBuilder_ != null) {
        return deballastingRatesBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(deballastingRates_);
      }
    }
    /** <code>repeated .DeBallastingRate deballastingRates = 1;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRate.Builder
        addDeballastingRatesBuilder() {
      return getDeballastingRatesFieldBuilder()
          .addBuilder(
              com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRate
                  .getDefaultInstance());
    }
    /** <code>repeated .DeBallastingRate deballastingRates = 1;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRate.Builder
        addDeballastingRatesBuilder(int index) {
      return getDeballastingRatesFieldBuilder()
          .addBuilder(
              index,
              com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRate
                  .getDefaultInstance());
    }
    /** <code>repeated .DeBallastingRate deballastingRates = 1;</code> */
    public java.util.List<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRate.Builder>
        getDeballastingRatesBuilderList() {
      return getDeballastingRatesFieldBuilder().getBuilderList();
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRate,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRate.Builder,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRateOrBuilder>
        getDeballastingRatesFieldBuilder() {
      if (deballastingRatesBuilder_ == null) {
        deballastingRatesBuilder_ =
            new com.google.protobuf.RepeatedFieldBuilderV3<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRate,
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRate.Builder,
                com.cpdss.common.generated.loading_plan.LoadingPlanModels
                    .DeBallastingRateOrBuilder>(
                deballastingRates_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        deballastingRates_ = null;
      }
      return deballastingRatesBuilder_;
    }

    private java.util.List<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails>
        dischargingPlanBallastDetails_ = java.util.Collections.emptyList();

    private void ensureDischargingPlanBallastDetailsIsMutable() {
      if (!((bitField0_ & 0x00000002) != 0)) {
        dischargingPlanBallastDetails_ =
            new java.util.ArrayList<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails>(
                dischargingPlanBallastDetails_);
        bitField0_ |= 0x00000002;
      }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
                .Builder,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels
                .LoadingPlanTankDetailsOrBuilder>
        dischargingPlanBallastDetailsBuilder_;

    /** <code>repeated .LoadingPlanTankDetails dischargingPlanBallastDetails = 2;</code> */
    public java.util.List<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails>
        getDischargingPlanBallastDetailsList() {
      if (dischargingPlanBallastDetailsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(dischargingPlanBallastDetails_);
      } else {
        return dischargingPlanBallastDetailsBuilder_.getMessageList();
      }
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanBallastDetails = 2;</code> */
    public int getDischargingPlanBallastDetailsCount() {
      if (dischargingPlanBallastDetailsBuilder_ == null) {
        return dischargingPlanBallastDetails_.size();
      } else {
        return dischargingPlanBallastDetailsBuilder_.getCount();
      }
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanBallastDetails = 2;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
        getDischargingPlanBallastDetails(int index) {
      if (dischargingPlanBallastDetailsBuilder_ == null) {
        return dischargingPlanBallastDetails_.get(index);
      } else {
        return dischargingPlanBallastDetailsBuilder_.getMessage(index);
      }
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanBallastDetails = 2;</code> */
    public Builder setDischargingPlanBallastDetails(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails value) {
      if (dischargingPlanBallastDetailsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDischargingPlanBallastDetailsIsMutable();
        dischargingPlanBallastDetails_.set(index, value);
        onChanged();
      } else {
        dischargingPlanBallastDetailsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanBallastDetails = 2;</code> */
    public Builder setDischargingPlanBallastDetails(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails.Builder
            builderForValue) {
      if (dischargingPlanBallastDetailsBuilder_ == null) {
        ensureDischargingPlanBallastDetailsIsMutable();
        dischargingPlanBallastDetails_.set(index, builderForValue.build());
        onChanged();
      } else {
        dischargingPlanBallastDetailsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanBallastDetails = 2;</code> */
    public Builder addDischargingPlanBallastDetails(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails value) {
      if (dischargingPlanBallastDetailsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDischargingPlanBallastDetailsIsMutable();
        dischargingPlanBallastDetails_.add(value);
        onChanged();
      } else {
        dischargingPlanBallastDetailsBuilder_.addMessage(value);
      }
      return this;
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanBallastDetails = 2;</code> */
    public Builder addDischargingPlanBallastDetails(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails value) {
      if (dischargingPlanBallastDetailsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDischargingPlanBallastDetailsIsMutable();
        dischargingPlanBallastDetails_.add(index, value);
        onChanged();
      } else {
        dischargingPlanBallastDetailsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanBallastDetails = 2;</code> */
    public Builder addDischargingPlanBallastDetails(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails.Builder
            builderForValue) {
      if (dischargingPlanBallastDetailsBuilder_ == null) {
        ensureDischargingPlanBallastDetailsIsMutable();
        dischargingPlanBallastDetails_.add(builderForValue.build());
        onChanged();
      } else {
        dischargingPlanBallastDetailsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanBallastDetails = 2;</code> */
    public Builder addDischargingPlanBallastDetails(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails.Builder
            builderForValue) {
      if (dischargingPlanBallastDetailsBuilder_ == null) {
        ensureDischargingPlanBallastDetailsIsMutable();
        dischargingPlanBallastDetails_.add(index, builderForValue.build());
        onChanged();
      } else {
        dischargingPlanBallastDetailsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanBallastDetails = 2;</code> */
    public Builder addAllDischargingPlanBallastDetails(
        java.lang.Iterable<
                ? extends
                    com.cpdss.common.generated.loading_plan.LoadingPlanModels
                        .LoadingPlanTankDetails>
            values) {
      if (dischargingPlanBallastDetailsBuilder_ == null) {
        ensureDischargingPlanBallastDetailsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, dischargingPlanBallastDetails_);
        onChanged();
      } else {
        dischargingPlanBallastDetailsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanBallastDetails = 2;</code> */
    public Builder clearDischargingPlanBallastDetails() {
      if (dischargingPlanBallastDetailsBuilder_ == null) {
        dischargingPlanBallastDetails_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000002);
        onChanged();
      } else {
        dischargingPlanBallastDetailsBuilder_.clear();
      }
      return this;
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanBallastDetails = 2;</code> */
    public Builder removeDischargingPlanBallastDetails(int index) {
      if (dischargingPlanBallastDetailsBuilder_ == null) {
        ensureDischargingPlanBallastDetailsIsMutable();
        dischargingPlanBallastDetails_.remove(index);
        onChanged();
      } else {
        dischargingPlanBallastDetailsBuilder_.remove(index);
      }
      return this;
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanBallastDetails = 2;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails.Builder
        getDischargingPlanBallastDetailsBuilder(int index) {
      return getDischargingPlanBallastDetailsFieldBuilder().getBuilder(index);
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanBallastDetails = 2;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetailsOrBuilder
        getDischargingPlanBallastDetailsOrBuilder(int index) {
      if (dischargingPlanBallastDetailsBuilder_ == null) {
        return dischargingPlanBallastDetails_.get(index);
      } else {
        return dischargingPlanBallastDetailsBuilder_.getMessageOrBuilder(index);
      }
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanBallastDetails = 2;</code> */
    public java.util.List<
            ? extends
                com.cpdss.common.generated.loading_plan.LoadingPlanModels
                    .LoadingPlanTankDetailsOrBuilder>
        getDischargingPlanBallastDetailsOrBuilderList() {
      if (dischargingPlanBallastDetailsBuilder_ != null) {
        return dischargingPlanBallastDetailsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(dischargingPlanBallastDetails_);
      }
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanBallastDetails = 2;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails.Builder
        addDischargingPlanBallastDetailsBuilder() {
      return getDischargingPlanBallastDetailsFieldBuilder()
          .addBuilder(
              com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
                  .getDefaultInstance());
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanBallastDetails = 2;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails.Builder
        addDischargingPlanBallastDetailsBuilder(int index) {
      return getDischargingPlanBallastDetailsFieldBuilder()
          .addBuilder(
              index,
              com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
                  .getDefaultInstance());
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanBallastDetails = 2;</code> */
    public java.util.List<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
                .Builder>
        getDischargingPlanBallastDetailsBuilderList() {
      return getDischargingPlanBallastDetailsFieldBuilder().getBuilderList();
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
                .Builder,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels
                .LoadingPlanTankDetailsOrBuilder>
        getDischargingPlanBallastDetailsFieldBuilder() {
      if (dischargingPlanBallastDetailsBuilder_ == null) {
        dischargingPlanBallastDetailsBuilder_ =
            new com.google.protobuf.RepeatedFieldBuilderV3<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails,
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
                    .Builder,
                com.cpdss.common.generated.loading_plan.LoadingPlanModels
                    .LoadingPlanTankDetailsOrBuilder>(
                dischargingPlanBallastDetails_,
                ((bitField0_ & 0x00000002) != 0),
                getParentForChildren(),
                isClean());
        dischargingPlanBallastDetails_ = null;
      }
      return dischargingPlanBallastDetailsBuilder_;
    }

    private java.util.List<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails>
        dischargingPlanRobDetails_ = java.util.Collections.emptyList();

    private void ensureDischargingPlanRobDetailsIsMutable() {
      if (!((bitField0_ & 0x00000004) != 0)) {
        dischargingPlanRobDetails_ =
            new java.util.ArrayList<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails>(
                dischargingPlanRobDetails_);
        bitField0_ |= 0x00000004;
      }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
                .Builder,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels
                .LoadingPlanTankDetailsOrBuilder>
        dischargingPlanRobDetailsBuilder_;

    /** <code>repeated .LoadingPlanTankDetails dischargingPlanRobDetails = 3;</code> */
    public java.util.List<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails>
        getDischargingPlanRobDetailsList() {
      if (dischargingPlanRobDetailsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(dischargingPlanRobDetails_);
      } else {
        return dischargingPlanRobDetailsBuilder_.getMessageList();
      }
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanRobDetails = 3;</code> */
    public int getDischargingPlanRobDetailsCount() {
      if (dischargingPlanRobDetailsBuilder_ == null) {
        return dischargingPlanRobDetails_.size();
      } else {
        return dischargingPlanRobDetailsBuilder_.getCount();
      }
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanRobDetails = 3;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
        getDischargingPlanRobDetails(int index) {
      if (dischargingPlanRobDetailsBuilder_ == null) {
        return dischargingPlanRobDetails_.get(index);
      } else {
        return dischargingPlanRobDetailsBuilder_.getMessage(index);
      }
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanRobDetails = 3;</code> */
    public Builder setDischargingPlanRobDetails(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails value) {
      if (dischargingPlanRobDetailsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDischargingPlanRobDetailsIsMutable();
        dischargingPlanRobDetails_.set(index, value);
        onChanged();
      } else {
        dischargingPlanRobDetailsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanRobDetails = 3;</code> */
    public Builder setDischargingPlanRobDetails(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails.Builder
            builderForValue) {
      if (dischargingPlanRobDetailsBuilder_ == null) {
        ensureDischargingPlanRobDetailsIsMutable();
        dischargingPlanRobDetails_.set(index, builderForValue.build());
        onChanged();
      } else {
        dischargingPlanRobDetailsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanRobDetails = 3;</code> */
    public Builder addDischargingPlanRobDetails(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails value) {
      if (dischargingPlanRobDetailsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDischargingPlanRobDetailsIsMutable();
        dischargingPlanRobDetails_.add(value);
        onChanged();
      } else {
        dischargingPlanRobDetailsBuilder_.addMessage(value);
      }
      return this;
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanRobDetails = 3;</code> */
    public Builder addDischargingPlanRobDetails(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails value) {
      if (dischargingPlanRobDetailsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDischargingPlanRobDetailsIsMutable();
        dischargingPlanRobDetails_.add(index, value);
        onChanged();
      } else {
        dischargingPlanRobDetailsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanRobDetails = 3;</code> */
    public Builder addDischargingPlanRobDetails(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails.Builder
            builderForValue) {
      if (dischargingPlanRobDetailsBuilder_ == null) {
        ensureDischargingPlanRobDetailsIsMutable();
        dischargingPlanRobDetails_.add(builderForValue.build());
        onChanged();
      } else {
        dischargingPlanRobDetailsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanRobDetails = 3;</code> */
    public Builder addDischargingPlanRobDetails(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails.Builder
            builderForValue) {
      if (dischargingPlanRobDetailsBuilder_ == null) {
        ensureDischargingPlanRobDetailsIsMutable();
        dischargingPlanRobDetails_.add(index, builderForValue.build());
        onChanged();
      } else {
        dischargingPlanRobDetailsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanRobDetails = 3;</code> */
    public Builder addAllDischargingPlanRobDetails(
        java.lang.Iterable<
                ? extends
                    com.cpdss.common.generated.loading_plan.LoadingPlanModels
                        .LoadingPlanTankDetails>
            values) {
      if (dischargingPlanRobDetailsBuilder_ == null) {
        ensureDischargingPlanRobDetailsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(values, dischargingPlanRobDetails_);
        onChanged();
      } else {
        dischargingPlanRobDetailsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanRobDetails = 3;</code> */
    public Builder clearDischargingPlanRobDetails() {
      if (dischargingPlanRobDetailsBuilder_ == null) {
        dischargingPlanRobDetails_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000004);
        onChanged();
      } else {
        dischargingPlanRobDetailsBuilder_.clear();
      }
      return this;
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanRobDetails = 3;</code> */
    public Builder removeDischargingPlanRobDetails(int index) {
      if (dischargingPlanRobDetailsBuilder_ == null) {
        ensureDischargingPlanRobDetailsIsMutable();
        dischargingPlanRobDetails_.remove(index);
        onChanged();
      } else {
        dischargingPlanRobDetailsBuilder_.remove(index);
      }
      return this;
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanRobDetails = 3;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails.Builder
        getDischargingPlanRobDetailsBuilder(int index) {
      return getDischargingPlanRobDetailsFieldBuilder().getBuilder(index);
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanRobDetails = 3;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetailsOrBuilder
        getDischargingPlanRobDetailsOrBuilder(int index) {
      if (dischargingPlanRobDetailsBuilder_ == null) {
        return dischargingPlanRobDetails_.get(index);
      } else {
        return dischargingPlanRobDetailsBuilder_.getMessageOrBuilder(index);
      }
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanRobDetails = 3;</code> */
    public java.util.List<
            ? extends
                com.cpdss.common.generated.loading_plan.LoadingPlanModels
                    .LoadingPlanTankDetailsOrBuilder>
        getDischargingPlanRobDetailsOrBuilderList() {
      if (dischargingPlanRobDetailsBuilder_ != null) {
        return dischargingPlanRobDetailsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(dischargingPlanRobDetails_);
      }
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanRobDetails = 3;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails.Builder
        addDischargingPlanRobDetailsBuilder() {
      return getDischargingPlanRobDetailsFieldBuilder()
          .addBuilder(
              com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
                  .getDefaultInstance());
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanRobDetails = 3;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails.Builder
        addDischargingPlanRobDetailsBuilder(int index) {
      return getDischargingPlanRobDetailsFieldBuilder()
          .addBuilder(
              index,
              com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
                  .getDefaultInstance());
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanRobDetails = 3;</code> */
    public java.util.List<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
                .Builder>
        getDischargingPlanRobDetailsBuilderList() {
      return getDischargingPlanRobDetailsFieldBuilder().getBuilderList();
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
                .Builder,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels
                .LoadingPlanTankDetailsOrBuilder>
        getDischargingPlanRobDetailsFieldBuilder() {
      if (dischargingPlanRobDetailsBuilder_ == null) {
        dischargingPlanRobDetailsBuilder_ =
            new com.google.protobuf.RepeatedFieldBuilderV3<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails,
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
                    .Builder,
                com.cpdss.common.generated.loading_plan.LoadingPlanModels
                    .LoadingPlanTankDetailsOrBuilder>(
                dischargingPlanRobDetails_,
                ((bitField0_ & 0x00000004) != 0),
                getParentForChildren(),
                isClean());
        dischargingPlanRobDetails_ = null;
      }
      return dischargingPlanRobDetailsBuilder_;
    }

    private com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters
        dischargingPlanStabilityParameters_;
    private com.google.protobuf.SingleFieldBuilderV3<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels
                .LoadingPlanStabilityParameters,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters
                .Builder,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels
                .LoadingPlanStabilityParametersOrBuilder>
        dischargingPlanStabilityParametersBuilder_;
    /**
     * <code>.LoadingPlanStabilityParameters dischargingPlanStabilityParameters = 4;</code>
     *
     * @return Whether the dischargingPlanStabilityParameters field is set.
     */
    public boolean hasDischargingPlanStabilityParameters() {
      return dischargingPlanStabilityParametersBuilder_ != null
          || dischargingPlanStabilityParameters_ != null;
    }
    /**
     * <code>.LoadingPlanStabilityParameters dischargingPlanStabilityParameters = 4;</code>
     *
     * @return The dischargingPlanStabilityParameters.
     */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters
        getDischargingPlanStabilityParameters() {
      if (dischargingPlanStabilityParametersBuilder_ == null) {
        return dischargingPlanStabilityParameters_ == null
            ? com.cpdss.common.generated.loading_plan.LoadingPlanModels
                .LoadingPlanStabilityParameters.getDefaultInstance()
            : dischargingPlanStabilityParameters_;
      } else {
        return dischargingPlanStabilityParametersBuilder_.getMessage();
      }
    }
    /** <code>.LoadingPlanStabilityParameters dischargingPlanStabilityParameters = 4;</code> */
    public Builder setDischargingPlanStabilityParameters(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters
            value) {
      if (dischargingPlanStabilityParametersBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        dischargingPlanStabilityParameters_ = value;
        onChanged();
      } else {
        dischargingPlanStabilityParametersBuilder_.setMessage(value);
      }

      return this;
    }
    /** <code>.LoadingPlanStabilityParameters dischargingPlanStabilityParameters = 4;</code> */
    public Builder setDischargingPlanStabilityParameters(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters
                .Builder
            builderForValue) {
      if (dischargingPlanStabilityParametersBuilder_ == null) {
        dischargingPlanStabilityParameters_ = builderForValue.build();
        onChanged();
      } else {
        dischargingPlanStabilityParametersBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /** <code>.LoadingPlanStabilityParameters dischargingPlanStabilityParameters = 4;</code> */
    public Builder mergeDischargingPlanStabilityParameters(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters
            value) {
      if (dischargingPlanStabilityParametersBuilder_ == null) {
        if (dischargingPlanStabilityParameters_ != null) {
          dischargingPlanStabilityParameters_ =
              com.cpdss.common.generated.loading_plan.LoadingPlanModels
                  .LoadingPlanStabilityParameters.newBuilder(dischargingPlanStabilityParameters_)
                  .mergeFrom(value)
                  .buildPartial();
        } else {
          dischargingPlanStabilityParameters_ = value;
        }
        onChanged();
      } else {
        dischargingPlanStabilityParametersBuilder_.mergeFrom(value);
      }

      return this;
    }
    /** <code>.LoadingPlanStabilityParameters dischargingPlanStabilityParameters = 4;</code> */
    public Builder clearDischargingPlanStabilityParameters() {
      if (dischargingPlanStabilityParametersBuilder_ == null) {
        dischargingPlanStabilityParameters_ = null;
        onChanged();
      } else {
        dischargingPlanStabilityParameters_ = null;
        dischargingPlanStabilityParametersBuilder_ = null;
      }

      return this;
    }
    /** <code>.LoadingPlanStabilityParameters dischargingPlanStabilityParameters = 4;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters
            .Builder
        getDischargingPlanStabilityParametersBuilder() {

      onChanged();
      return getDischargingPlanStabilityParametersFieldBuilder().getBuilder();
    }
    /** <code>.LoadingPlanStabilityParameters dischargingPlanStabilityParameters = 4;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels
            .LoadingPlanStabilityParametersOrBuilder
        getDischargingPlanStabilityParametersOrBuilder() {
      if (dischargingPlanStabilityParametersBuilder_ != null) {
        return dischargingPlanStabilityParametersBuilder_.getMessageOrBuilder();
      } else {
        return dischargingPlanStabilityParameters_ == null
            ? com.cpdss.common.generated.loading_plan.LoadingPlanModels
                .LoadingPlanStabilityParameters.getDefaultInstance()
            : dischargingPlanStabilityParameters_;
      }
    }
    /** <code>.LoadingPlanStabilityParameters dischargingPlanStabilityParameters = 4;</code> */
    private com.google.protobuf.SingleFieldBuilderV3<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels
                .LoadingPlanStabilityParameters,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters
                .Builder,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels
                .LoadingPlanStabilityParametersOrBuilder>
        getDischargingPlanStabilityParametersFieldBuilder() {
      if (dischargingPlanStabilityParametersBuilder_ == null) {
        dischargingPlanStabilityParametersBuilder_ =
            new com.google.protobuf.SingleFieldBuilderV3<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels
                    .LoadingPlanStabilityParameters,
                com.cpdss.common.generated.loading_plan.LoadingPlanModels
                    .LoadingPlanStabilityParameters.Builder,
                com.cpdss.common.generated.loading_plan.LoadingPlanModels
                    .LoadingPlanStabilityParametersOrBuilder>(
                getDischargingPlanStabilityParameters(), getParentForChildren(), isClean());
        dischargingPlanStabilityParameters_ = null;
      }
      return dischargingPlanStabilityParametersBuilder_;
    }

    private java.util.List<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails>
        dischargingPlanStowageDetails_ = java.util.Collections.emptyList();

    private void ensureDischargingPlanStowageDetailsIsMutable() {
      if (!((bitField0_ & 0x00000008) != 0)) {
        dischargingPlanStowageDetails_ =
            new java.util.ArrayList<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails>(
                dischargingPlanStowageDetails_);
        bitField0_ |= 0x00000008;
      }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
                .Builder,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels
                .LoadingPlanTankDetailsOrBuilder>
        dischargingPlanStowageDetailsBuilder_;

    /** <code>repeated .LoadingPlanTankDetails dischargingPlanStowageDetails = 5;</code> */
    public java.util.List<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails>
        getDischargingPlanStowageDetailsList() {
      if (dischargingPlanStowageDetailsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(dischargingPlanStowageDetails_);
      } else {
        return dischargingPlanStowageDetailsBuilder_.getMessageList();
      }
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanStowageDetails = 5;</code> */
    public int getDischargingPlanStowageDetailsCount() {
      if (dischargingPlanStowageDetailsBuilder_ == null) {
        return dischargingPlanStowageDetails_.size();
      } else {
        return dischargingPlanStowageDetailsBuilder_.getCount();
      }
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanStowageDetails = 5;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
        getDischargingPlanStowageDetails(int index) {
      if (dischargingPlanStowageDetailsBuilder_ == null) {
        return dischargingPlanStowageDetails_.get(index);
      } else {
        return dischargingPlanStowageDetailsBuilder_.getMessage(index);
      }
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanStowageDetails = 5;</code> */
    public Builder setDischargingPlanStowageDetails(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails value) {
      if (dischargingPlanStowageDetailsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDischargingPlanStowageDetailsIsMutable();
        dischargingPlanStowageDetails_.set(index, value);
        onChanged();
      } else {
        dischargingPlanStowageDetailsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanStowageDetails = 5;</code> */
    public Builder setDischargingPlanStowageDetails(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails.Builder
            builderForValue) {
      if (dischargingPlanStowageDetailsBuilder_ == null) {
        ensureDischargingPlanStowageDetailsIsMutable();
        dischargingPlanStowageDetails_.set(index, builderForValue.build());
        onChanged();
      } else {
        dischargingPlanStowageDetailsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanStowageDetails = 5;</code> */
    public Builder addDischargingPlanStowageDetails(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails value) {
      if (dischargingPlanStowageDetailsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDischargingPlanStowageDetailsIsMutable();
        dischargingPlanStowageDetails_.add(value);
        onChanged();
      } else {
        dischargingPlanStowageDetailsBuilder_.addMessage(value);
      }
      return this;
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanStowageDetails = 5;</code> */
    public Builder addDischargingPlanStowageDetails(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails value) {
      if (dischargingPlanStowageDetailsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDischargingPlanStowageDetailsIsMutable();
        dischargingPlanStowageDetails_.add(index, value);
        onChanged();
      } else {
        dischargingPlanStowageDetailsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanStowageDetails = 5;</code> */
    public Builder addDischargingPlanStowageDetails(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails.Builder
            builderForValue) {
      if (dischargingPlanStowageDetailsBuilder_ == null) {
        ensureDischargingPlanStowageDetailsIsMutable();
        dischargingPlanStowageDetails_.add(builderForValue.build());
        onChanged();
      } else {
        dischargingPlanStowageDetailsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanStowageDetails = 5;</code> */
    public Builder addDischargingPlanStowageDetails(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails.Builder
            builderForValue) {
      if (dischargingPlanStowageDetailsBuilder_ == null) {
        ensureDischargingPlanStowageDetailsIsMutable();
        dischargingPlanStowageDetails_.add(index, builderForValue.build());
        onChanged();
      } else {
        dischargingPlanStowageDetailsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanStowageDetails = 5;</code> */
    public Builder addAllDischargingPlanStowageDetails(
        java.lang.Iterable<
                ? extends
                    com.cpdss.common.generated.loading_plan.LoadingPlanModels
                        .LoadingPlanTankDetails>
            values) {
      if (dischargingPlanStowageDetailsBuilder_ == null) {
        ensureDischargingPlanStowageDetailsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, dischargingPlanStowageDetails_);
        onChanged();
      } else {
        dischargingPlanStowageDetailsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanStowageDetails = 5;</code> */
    public Builder clearDischargingPlanStowageDetails() {
      if (dischargingPlanStowageDetailsBuilder_ == null) {
        dischargingPlanStowageDetails_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000008);
        onChanged();
      } else {
        dischargingPlanStowageDetailsBuilder_.clear();
      }
      return this;
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanStowageDetails = 5;</code> */
    public Builder removeDischargingPlanStowageDetails(int index) {
      if (dischargingPlanStowageDetailsBuilder_ == null) {
        ensureDischargingPlanStowageDetailsIsMutable();
        dischargingPlanStowageDetails_.remove(index);
        onChanged();
      } else {
        dischargingPlanStowageDetailsBuilder_.remove(index);
      }
      return this;
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanStowageDetails = 5;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails.Builder
        getDischargingPlanStowageDetailsBuilder(int index) {
      return getDischargingPlanStowageDetailsFieldBuilder().getBuilder(index);
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanStowageDetails = 5;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetailsOrBuilder
        getDischargingPlanStowageDetailsOrBuilder(int index) {
      if (dischargingPlanStowageDetailsBuilder_ == null) {
        return dischargingPlanStowageDetails_.get(index);
      } else {
        return dischargingPlanStowageDetailsBuilder_.getMessageOrBuilder(index);
      }
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanStowageDetails = 5;</code> */
    public java.util.List<
            ? extends
                com.cpdss.common.generated.loading_plan.LoadingPlanModels
                    .LoadingPlanTankDetailsOrBuilder>
        getDischargingPlanStowageDetailsOrBuilderList() {
      if (dischargingPlanStowageDetailsBuilder_ != null) {
        return dischargingPlanStowageDetailsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(dischargingPlanStowageDetails_);
      }
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanStowageDetails = 5;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails.Builder
        addDischargingPlanStowageDetailsBuilder() {
      return getDischargingPlanStowageDetailsFieldBuilder()
          .addBuilder(
              com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
                  .getDefaultInstance());
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanStowageDetails = 5;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails.Builder
        addDischargingPlanStowageDetailsBuilder(int index) {
      return getDischargingPlanStowageDetailsFieldBuilder()
          .addBuilder(
              index,
              com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
                  .getDefaultInstance());
    }
    /** <code>repeated .LoadingPlanTankDetails dischargingPlanStowageDetails = 5;</code> */
    public java.util.List<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
                .Builder>
        getDischargingPlanStowageDetailsBuilderList() {
      return getDischargingPlanStowageDetailsFieldBuilder().getBuilderList();
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
                .Builder,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels
                .LoadingPlanTankDetailsOrBuilder>
        getDischargingPlanStowageDetailsFieldBuilder() {
      if (dischargingPlanStowageDetailsBuilder_ == null) {
        dischargingPlanStowageDetailsBuilder_ =
            new com.google.protobuf.RepeatedFieldBuilderV3<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails,
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
                    .Builder,
                com.cpdss.common.generated.loading_plan.LoadingPlanModels
                    .LoadingPlanTankDetailsOrBuilder>(
                dischargingPlanStowageDetails_,
                ((bitField0_ & 0x00000008) != 0),
                getParentForChildren(),
                isClean());
        dischargingPlanStowageDetails_ = null;
      }
      return dischargingPlanStowageDetailsBuilder_;
    }

    private int time_;
    /**
     * <code>int32 time = 6;</code>
     *
     * @return The time.
     */
    public int getTime() {
      return time_;
    }
    /**
     * <code>int32 time = 6;</code>
     *
     * @param value The time to set.
     * @return This builder for chaining.
     */
    public Builder setTime(int value) {

      time_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 time = 6;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearTime() {

      time_ = 0;
      onChanged();
      return this;
    }

    private java.util.List<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanCommingleDetails>
        dischargingPlanCommingleDetails_ = java.util.Collections.emptyList();

    private void ensureDischargingPlanCommingleDetailsIsMutable() {
      if (!((bitField0_ & 0x00000010) != 0)) {
        dischargingPlanCommingleDetails_ =
            new java.util.ArrayList<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels
                    .LoadingPlanCommingleDetails>(dischargingPlanCommingleDetails_);
        bitField0_ |= 0x00000010;
      }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanCommingleDetails,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanCommingleDetails
                .Builder,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels
                .LoadingPlanCommingleDetailsOrBuilder>
        dischargingPlanCommingleDetailsBuilder_;

    /** <code>repeated .LoadingPlanCommingleDetails dischargingPlanCommingleDetails = 7;</code> */
    public java.util.List<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanCommingleDetails>
        getDischargingPlanCommingleDetailsList() {
      if (dischargingPlanCommingleDetailsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(dischargingPlanCommingleDetails_);
      } else {
        return dischargingPlanCommingleDetailsBuilder_.getMessageList();
      }
    }
    /** <code>repeated .LoadingPlanCommingleDetails dischargingPlanCommingleDetails = 7;</code> */
    public int getDischargingPlanCommingleDetailsCount() {
      if (dischargingPlanCommingleDetailsBuilder_ == null) {
        return dischargingPlanCommingleDetails_.size();
      } else {
        return dischargingPlanCommingleDetailsBuilder_.getCount();
      }
    }
    /** <code>repeated .LoadingPlanCommingleDetails dischargingPlanCommingleDetails = 7;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanCommingleDetails
        getDischargingPlanCommingleDetails(int index) {
      if (dischargingPlanCommingleDetailsBuilder_ == null) {
        return dischargingPlanCommingleDetails_.get(index);
      } else {
        return dischargingPlanCommingleDetailsBuilder_.getMessage(index);
      }
    }
    /** <code>repeated .LoadingPlanCommingleDetails dischargingPlanCommingleDetails = 7;</code> */
    public Builder setDischargingPlanCommingleDetails(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanCommingleDetails
            value) {
      if (dischargingPlanCommingleDetailsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDischargingPlanCommingleDetailsIsMutable();
        dischargingPlanCommingleDetails_.set(index, value);
        onChanged();
      } else {
        dischargingPlanCommingleDetailsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /** <code>repeated .LoadingPlanCommingleDetails dischargingPlanCommingleDetails = 7;</code> */
    public Builder setDischargingPlanCommingleDetails(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanCommingleDetails
                .Builder
            builderForValue) {
      if (dischargingPlanCommingleDetailsBuilder_ == null) {
        ensureDischargingPlanCommingleDetailsIsMutable();
        dischargingPlanCommingleDetails_.set(index, builderForValue.build());
        onChanged();
      } else {
        dischargingPlanCommingleDetailsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .LoadingPlanCommingleDetails dischargingPlanCommingleDetails = 7;</code> */
    public Builder addDischargingPlanCommingleDetails(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanCommingleDetails
            value) {
      if (dischargingPlanCommingleDetailsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDischargingPlanCommingleDetailsIsMutable();
        dischargingPlanCommingleDetails_.add(value);
        onChanged();
      } else {
        dischargingPlanCommingleDetailsBuilder_.addMessage(value);
      }
      return this;
    }
    /** <code>repeated .LoadingPlanCommingleDetails dischargingPlanCommingleDetails = 7;</code> */
    public Builder addDischargingPlanCommingleDetails(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanCommingleDetails
            value) {
      if (dischargingPlanCommingleDetailsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDischargingPlanCommingleDetailsIsMutable();
        dischargingPlanCommingleDetails_.add(index, value);
        onChanged();
      } else {
        dischargingPlanCommingleDetailsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /** <code>repeated .LoadingPlanCommingleDetails dischargingPlanCommingleDetails = 7;</code> */
    public Builder addDischargingPlanCommingleDetails(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanCommingleDetails
                .Builder
            builderForValue) {
      if (dischargingPlanCommingleDetailsBuilder_ == null) {
        ensureDischargingPlanCommingleDetailsIsMutable();
        dischargingPlanCommingleDetails_.add(builderForValue.build());
        onChanged();
      } else {
        dischargingPlanCommingleDetailsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .LoadingPlanCommingleDetails dischargingPlanCommingleDetails = 7;</code> */
    public Builder addDischargingPlanCommingleDetails(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanCommingleDetails
                .Builder
            builderForValue) {
      if (dischargingPlanCommingleDetailsBuilder_ == null) {
        ensureDischargingPlanCommingleDetailsIsMutable();
        dischargingPlanCommingleDetails_.add(index, builderForValue.build());
        onChanged();
      } else {
        dischargingPlanCommingleDetailsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .LoadingPlanCommingleDetails dischargingPlanCommingleDetails = 7;</code> */
    public Builder addAllDischargingPlanCommingleDetails(
        java.lang.Iterable<
                ? extends
                    com.cpdss.common.generated.loading_plan.LoadingPlanModels
                        .LoadingPlanCommingleDetails>
            values) {
      if (dischargingPlanCommingleDetailsBuilder_ == null) {
        ensureDischargingPlanCommingleDetailsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, dischargingPlanCommingleDetails_);
        onChanged();
      } else {
        dischargingPlanCommingleDetailsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /** <code>repeated .LoadingPlanCommingleDetails dischargingPlanCommingleDetails = 7;</code> */
    public Builder clearDischargingPlanCommingleDetails() {
      if (dischargingPlanCommingleDetailsBuilder_ == null) {
        dischargingPlanCommingleDetails_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000010);
        onChanged();
      } else {
        dischargingPlanCommingleDetailsBuilder_.clear();
      }
      return this;
    }
    /** <code>repeated .LoadingPlanCommingleDetails dischargingPlanCommingleDetails = 7;</code> */
    public Builder removeDischargingPlanCommingleDetails(int index) {
      if (dischargingPlanCommingleDetailsBuilder_ == null) {
        ensureDischargingPlanCommingleDetailsIsMutable();
        dischargingPlanCommingleDetails_.remove(index);
        onChanged();
      } else {
        dischargingPlanCommingleDetailsBuilder_.remove(index);
      }
      return this;
    }
    /** <code>repeated .LoadingPlanCommingleDetails dischargingPlanCommingleDetails = 7;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanCommingleDetails
            .Builder
        getDischargingPlanCommingleDetailsBuilder(int index) {
      return getDischargingPlanCommingleDetailsFieldBuilder().getBuilder(index);
    }
    /** <code>repeated .LoadingPlanCommingleDetails dischargingPlanCommingleDetails = 7;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels
            .LoadingPlanCommingleDetailsOrBuilder
        getDischargingPlanCommingleDetailsOrBuilder(int index) {
      if (dischargingPlanCommingleDetailsBuilder_ == null) {
        return dischargingPlanCommingleDetails_.get(index);
      } else {
        return dischargingPlanCommingleDetailsBuilder_.getMessageOrBuilder(index);
      }
    }
    /** <code>repeated .LoadingPlanCommingleDetails dischargingPlanCommingleDetails = 7;</code> */
    public java.util.List<
            ? extends
                com.cpdss.common.generated.loading_plan.LoadingPlanModels
                    .LoadingPlanCommingleDetailsOrBuilder>
        getDischargingPlanCommingleDetailsOrBuilderList() {
      if (dischargingPlanCommingleDetailsBuilder_ != null) {
        return dischargingPlanCommingleDetailsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(dischargingPlanCommingleDetails_);
      }
    }
    /** <code>repeated .LoadingPlanCommingleDetails dischargingPlanCommingleDetails = 7;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanCommingleDetails
            .Builder
        addDischargingPlanCommingleDetailsBuilder() {
      return getDischargingPlanCommingleDetailsFieldBuilder()
          .addBuilder(
              com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanCommingleDetails
                  .getDefaultInstance());
    }
    /** <code>repeated .LoadingPlanCommingleDetails dischargingPlanCommingleDetails = 7;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanCommingleDetails
            .Builder
        addDischargingPlanCommingleDetailsBuilder(int index) {
      return getDischargingPlanCommingleDetailsFieldBuilder()
          .addBuilder(
              index,
              com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanCommingleDetails
                  .getDefaultInstance());
    }
    /** <code>repeated .LoadingPlanCommingleDetails dischargingPlanCommingleDetails = 7;</code> */
    public java.util.List<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanCommingleDetails
                .Builder>
        getDischargingPlanCommingleDetailsBuilderList() {
      return getDischargingPlanCommingleDetailsFieldBuilder().getBuilderList();
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanCommingleDetails,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanCommingleDetails
                .Builder,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels
                .LoadingPlanCommingleDetailsOrBuilder>
        getDischargingPlanCommingleDetailsFieldBuilder() {
      if (dischargingPlanCommingleDetailsBuilder_ == null) {
        dischargingPlanCommingleDetailsBuilder_ =
            new com.google.protobuf.RepeatedFieldBuilderV3<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels
                    .LoadingPlanCommingleDetails,
                com.cpdss.common.generated.loading_plan.LoadingPlanModels
                    .LoadingPlanCommingleDetails.Builder,
                com.cpdss.common.generated.loading_plan.LoadingPlanModels
                    .LoadingPlanCommingleDetailsOrBuilder>(
                dischargingPlanCommingleDetails_,
                ((bitField0_ & 0x00000010) != 0),
                getParentForChildren(),
                isClean());
        dischargingPlanCommingleDetails_ = null;
      }
      return dischargingPlanCommingleDetailsBuilder_;
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

    // @@protoc_insertion_point(builder_scope:DischargePlanPortWiseDetails)
  }

  // @@protoc_insertion_point(class_scope:DischargePlanPortWiseDetails)
  private static final com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails
      DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails();
  }

  public static com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails
      getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<DischargePlanPortWiseDetails> PARSER =
      new com.google.protobuf.AbstractParser<DischargePlanPortWiseDetails>() {
        @java.lang.Override
        public DischargePlanPortWiseDetails parsePartialFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
          return new DischargePlanPortWiseDetails(input, extensionRegistry);
        }
      };

  public static com.google.protobuf.Parser<DischargePlanPortWiseDetails> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<DischargePlanPortWiseDetails> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails
      getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
}
