/* Licensed at AlphaOri Technologies */
package com.cpdss.common.generated.discharge_plan;

/** Protobuf type {@code DischargingPlanReply} */
public final class DischargingPlanReply extends com.google.protobuf.GeneratedMessageV3
    implements
    // @@protoc_insertion_point(message_implements:DischargingPlanReply)
    DischargingPlanReplyOrBuilder {
  private static final long serialVersionUID = 0L;
  // Use DischargingPlanReply.newBuilder() to construct.
  private DischargingPlanReply(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }

  private DischargingPlanReply() {
    dischargingSequences_ = java.util.Collections.emptyList();
    portDischargingPlanStowageDetails_ = java.util.Collections.emptyList();
    portDischargingPlanBallastDetails_ = java.util.Collections.emptyList();
    portDischargingPlanRobDetails_ = java.util.Collections.emptyList();
    portDischargingPlanStabilityParameters_ = java.util.Collections.emptyList();
    portDischargingPlanCommingleDetails_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
    return new DischargingPlanReply();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }

  private DischargingPlanReply(
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
              loadingInfoId_ = input.readInt64();
              break;
            }
          case 18:
            {
              if (!((mutable_bitField0_ & 0x00000001) != 0)) {
                dischargingSequences_ =
                    new java.util.ArrayList<
                        com.cpdss.common.generated.loading_plan.LoadingPlanModels
                            .LoadingSequence>();
                mutable_bitField0_ |= 0x00000001;
              }
              dischargingSequences_.add(
                  input.readMessage(
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingSequence
                          .parser(),
                      extensionRegistry));
              break;
            }
          case 26:
            {
              if (!((mutable_bitField0_ & 0x00000002) != 0)) {
                portDischargingPlanStowageDetails_ =
                    new java.util.ArrayList<
                        com.cpdss.common.generated.loading_plan.LoadingPlanModels
                            .LoadingPlanTankDetails>();
                mutable_bitField0_ |= 0x00000002;
              }
              portDischargingPlanStowageDetails_.add(
                  input.readMessage(
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels
                          .LoadingPlanTankDetails.parser(),
                      extensionRegistry));
              break;
            }
          case 34:
            {
              if (!((mutable_bitField0_ & 0x00000004) != 0)) {
                portDischargingPlanBallastDetails_ =
                    new java.util.ArrayList<
                        com.cpdss.common.generated.loading_plan.LoadingPlanModels
                            .LoadingPlanTankDetails>();
                mutable_bitField0_ |= 0x00000004;
              }
              portDischargingPlanBallastDetails_.add(
                  input.readMessage(
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels
                          .LoadingPlanTankDetails.parser(),
                      extensionRegistry));
              break;
            }
          case 42:
            {
              if (!((mutable_bitField0_ & 0x00000008) != 0)) {
                portDischargingPlanRobDetails_ =
                    new java.util.ArrayList<
                        com.cpdss.common.generated.loading_plan.LoadingPlanModels
                            .LoadingPlanTankDetails>();
                mutable_bitField0_ |= 0x00000008;
              }
              portDischargingPlanRobDetails_.add(
                  input.readMessage(
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels
                          .LoadingPlanTankDetails.parser(),
                      extensionRegistry));
              break;
            }
          case 50:
            {
              if (!((mutable_bitField0_ & 0x00000010) != 0)) {
                portDischargingPlanStabilityParameters_ =
                    new java.util.ArrayList<
                        com.cpdss.common.generated.loading_plan.LoadingPlanModels
                            .LoadingPlanStabilityParameters>();
                mutable_bitField0_ |= 0x00000010;
              }
              portDischargingPlanStabilityParameters_.add(
                  input.readMessage(
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels
                          .LoadingPlanStabilityParameters.parser(),
                      extensionRegistry));
              break;
            }
          case 58:
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
          case 66:
            {
              com.cpdss.common.generated.discharge_plan.DischargeInformation.Builder subBuilder =
                  null;
              if (dischargingInformation_ != null) {
                subBuilder = dischargingInformation_.toBuilder();
              }
              dischargingInformation_ =
                  input.readMessage(
                      com.cpdss.common.generated.discharge_plan.DischargeInformation.parser(),
                      extensionRegistry);
              if (subBuilder != null) {
                subBuilder.mergeFrom(dischargingInformation_);
                dischargingInformation_ = subBuilder.buildPartial();
              }

              break;
            }
          case 74:
            {
              if (!((mutable_bitField0_ & 0x00000020) != 0)) {
                portDischargingPlanCommingleDetails_ =
                    new java.util.ArrayList<
                        com.cpdss.common.generated.loading_plan.LoadingPlanModels
                            .LoadingPlanCommingleDetails>();
                mutable_bitField0_ |= 0x00000020;
              }
              portDischargingPlanCommingleDetails_.add(
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
        dischargingSequences_ = java.util.Collections.unmodifiableList(dischargingSequences_);
      }
      if (((mutable_bitField0_ & 0x00000002) != 0)) {
        portDischargingPlanStowageDetails_ =
            java.util.Collections.unmodifiableList(portDischargingPlanStowageDetails_);
      }
      if (((mutable_bitField0_ & 0x00000004) != 0)) {
        portDischargingPlanBallastDetails_ =
            java.util.Collections.unmodifiableList(portDischargingPlanBallastDetails_);
      }
      if (((mutable_bitField0_ & 0x00000008) != 0)) {
        portDischargingPlanRobDetails_ =
            java.util.Collections.unmodifiableList(portDischargingPlanRobDetails_);
      }
      if (((mutable_bitField0_ & 0x00000010) != 0)) {
        portDischargingPlanStabilityParameters_ =
            java.util.Collections.unmodifiableList(portDischargingPlanStabilityParameters_);
      }
      if (((mutable_bitField0_ & 0x00000020) != 0)) {
        portDischargingPlanCommingleDetails_ =
            java.util.Collections.unmodifiableList(portDischargingPlanCommingleDetails_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }

  public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
    return com.cpdss.common.generated.discharge_plan.DischargePlanModels
        .internal_static_DischargingPlanReply_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.cpdss.common.generated.discharge_plan.DischargePlanModels
        .internal_static_DischargingPlanReply_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.cpdss.common.generated.discharge_plan.DischargingPlanReply.class,
            com.cpdss.common.generated.discharge_plan.DischargingPlanReply.Builder.class);
  }

  public static final int RESPONSESTATUS_FIELD_NUMBER = 7;
  private com.cpdss.common.generated.Common.ResponseStatus responseStatus_;
  /**
   * <code>.ResponseStatus responseStatus = 7;</code>
   *
   * @return Whether the responseStatus field is set.
   */
  public boolean hasResponseStatus() {
    return responseStatus_ != null;
  }
  /**
   * <code>.ResponseStatus responseStatus = 7;</code>
   *
   * @return The responseStatus.
   */
  public com.cpdss.common.generated.Common.ResponseStatus getResponseStatus() {
    return responseStatus_ == null
        ? com.cpdss.common.generated.Common.ResponseStatus.getDefaultInstance()
        : responseStatus_;
  }
  /** <code>.ResponseStatus responseStatus = 7;</code> */
  public com.cpdss.common.generated.Common.ResponseStatusOrBuilder getResponseStatusOrBuilder() {
    return getResponseStatus();
  }

  public static final int LOADINGINFOID_FIELD_NUMBER = 1;
  private long loadingInfoId_;
  /**
   * <code>int64 loadingInfoId = 1;</code>
   *
   * @return The loadingInfoId.
   */
  public long getLoadingInfoId() {
    return loadingInfoId_;
  }

  public static final int DISCHARGINGINFORMATION_FIELD_NUMBER = 8;
  private com.cpdss.common.generated.discharge_plan.DischargeInformation dischargingInformation_;
  /**
   * <code>.DischargeInformation dischargingInformation = 8;</code>
   *
   * @return Whether the dischargingInformation field is set.
   */
  public boolean hasDischargingInformation() {
    return dischargingInformation_ != null;
  }
  /**
   * <code>.DischargeInformation dischargingInformation = 8;</code>
   *
   * @return The dischargingInformation.
   */
  public com.cpdss.common.generated.discharge_plan.DischargeInformation
      getDischargingInformation() {
    return dischargingInformation_ == null
        ? com.cpdss.common.generated.discharge_plan.DischargeInformation.getDefaultInstance()
        : dischargingInformation_;
  }
  /** <code>.DischargeInformation dischargingInformation = 8;</code> */
  public com.cpdss.common.generated.discharge_plan.DischargeInformationOrBuilder
      getDischargingInformationOrBuilder() {
    return getDischargingInformation();
  }

  public static final int DISCHARGINGSEQUENCES_FIELD_NUMBER = 2;
  private java.util.List<com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingSequence>
      dischargingSequences_;
  /** <code>repeated .LoadingSequence dischargingSequences = 2;</code> */
  public java.util.List<com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingSequence>
      getDischargingSequencesList() {
    return dischargingSequences_;
  }
  /** <code>repeated .LoadingSequence dischargingSequences = 2;</code> */
  public java.util.List<
          ? extends
              com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingSequenceOrBuilder>
      getDischargingSequencesOrBuilderList() {
    return dischargingSequences_;
  }
  /** <code>repeated .LoadingSequence dischargingSequences = 2;</code> */
  public int getDischargingSequencesCount() {
    return dischargingSequences_.size();
  }
  /** <code>repeated .LoadingSequence dischargingSequences = 2;</code> */
  public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingSequence
      getDischargingSequences(int index) {
    return dischargingSequences_.get(index);
  }
  /** <code>repeated .LoadingSequence dischargingSequences = 2;</code> */
  public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingSequenceOrBuilder
      getDischargingSequencesOrBuilder(int index) {
    return dischargingSequences_.get(index);
  }

  public static final int PORTDISCHARGINGPLANSTOWAGEDETAILS_FIELD_NUMBER = 3;
  private java.util.List<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails>
      portDischargingPlanStowageDetails_;
  /** <code>repeated .LoadingPlanTankDetails portDischargingPlanStowageDetails = 3;</code> */
  public java.util.List<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails>
      getPortDischargingPlanStowageDetailsList() {
    return portDischargingPlanStowageDetails_;
  }
  /** <code>repeated .LoadingPlanTankDetails portDischargingPlanStowageDetails = 3;</code> */
  public java.util.List<
          ? extends
              com.cpdss.common.generated.loading_plan.LoadingPlanModels
                  .LoadingPlanTankDetailsOrBuilder>
      getPortDischargingPlanStowageDetailsOrBuilderList() {
    return portDischargingPlanStowageDetails_;
  }
  /** <code>repeated .LoadingPlanTankDetails portDischargingPlanStowageDetails = 3;</code> */
  public int getPortDischargingPlanStowageDetailsCount() {
    return portDischargingPlanStowageDetails_.size();
  }
  /** <code>repeated .LoadingPlanTankDetails portDischargingPlanStowageDetails = 3;</code> */
  public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
      getPortDischargingPlanStowageDetails(int index) {
    return portDischargingPlanStowageDetails_.get(index);
  }
  /** <code>repeated .LoadingPlanTankDetails portDischargingPlanStowageDetails = 3;</code> */
  public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetailsOrBuilder
      getPortDischargingPlanStowageDetailsOrBuilder(int index) {
    return portDischargingPlanStowageDetails_.get(index);
  }

  public static final int PORTDISCHARGINGPLANBALLASTDETAILS_FIELD_NUMBER = 4;
  private java.util.List<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails>
      portDischargingPlanBallastDetails_;
  /** <code>repeated .LoadingPlanTankDetails portDischargingPlanBallastDetails = 4;</code> */
  public java.util.List<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails>
      getPortDischargingPlanBallastDetailsList() {
    return portDischargingPlanBallastDetails_;
  }
  /** <code>repeated .LoadingPlanTankDetails portDischargingPlanBallastDetails = 4;</code> */
  public java.util.List<
          ? extends
              com.cpdss.common.generated.loading_plan.LoadingPlanModels
                  .LoadingPlanTankDetailsOrBuilder>
      getPortDischargingPlanBallastDetailsOrBuilderList() {
    return portDischargingPlanBallastDetails_;
  }
  /** <code>repeated .LoadingPlanTankDetails portDischargingPlanBallastDetails = 4;</code> */
  public int getPortDischargingPlanBallastDetailsCount() {
    return portDischargingPlanBallastDetails_.size();
  }
  /** <code>repeated .LoadingPlanTankDetails portDischargingPlanBallastDetails = 4;</code> */
  public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
      getPortDischargingPlanBallastDetails(int index) {
    return portDischargingPlanBallastDetails_.get(index);
  }
  /** <code>repeated .LoadingPlanTankDetails portDischargingPlanBallastDetails = 4;</code> */
  public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetailsOrBuilder
      getPortDischargingPlanBallastDetailsOrBuilder(int index) {
    return portDischargingPlanBallastDetails_.get(index);
  }

  public static final int PORTDISCHARGINGPLANROBDETAILS_FIELD_NUMBER = 5;
  private java.util.List<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails>
      portDischargingPlanRobDetails_;
  /** <code>repeated .LoadingPlanTankDetails portDischargingPlanRobDetails = 5;</code> */
  public java.util.List<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails>
      getPortDischargingPlanRobDetailsList() {
    return portDischargingPlanRobDetails_;
  }
  /** <code>repeated .LoadingPlanTankDetails portDischargingPlanRobDetails = 5;</code> */
  public java.util.List<
          ? extends
              com.cpdss.common.generated.loading_plan.LoadingPlanModels
                  .LoadingPlanTankDetailsOrBuilder>
      getPortDischargingPlanRobDetailsOrBuilderList() {
    return portDischargingPlanRobDetails_;
  }
  /** <code>repeated .LoadingPlanTankDetails portDischargingPlanRobDetails = 5;</code> */
  public int getPortDischargingPlanRobDetailsCount() {
    return portDischargingPlanRobDetails_.size();
  }
  /** <code>repeated .LoadingPlanTankDetails portDischargingPlanRobDetails = 5;</code> */
  public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
      getPortDischargingPlanRobDetails(int index) {
    return portDischargingPlanRobDetails_.get(index);
  }
  /** <code>repeated .LoadingPlanTankDetails portDischargingPlanRobDetails = 5;</code> */
  public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetailsOrBuilder
      getPortDischargingPlanRobDetailsOrBuilder(int index) {
    return portDischargingPlanRobDetails_.get(index);
  }

  public static final int PORTDISCHARGINGPLANSTABILITYPARAMETERS_FIELD_NUMBER = 6;
  private java.util.List<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters>
      portDischargingPlanStabilityParameters_;
  /**
   * <code>repeated .LoadingPlanStabilityParameters portDischargingPlanStabilityParameters = 6;
   * </code>
   */
  public java.util.List<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters>
      getPortDischargingPlanStabilityParametersList() {
    return portDischargingPlanStabilityParameters_;
  }
  /**
   * <code>repeated .LoadingPlanStabilityParameters portDischargingPlanStabilityParameters = 6;
   * </code>
   */
  public java.util.List<
          ? extends
              com.cpdss.common.generated.loading_plan.LoadingPlanModels
                  .LoadingPlanStabilityParametersOrBuilder>
      getPortDischargingPlanStabilityParametersOrBuilderList() {
    return portDischargingPlanStabilityParameters_;
  }
  /**
   * <code>repeated .LoadingPlanStabilityParameters portDischargingPlanStabilityParameters = 6;
   * </code>
   */
  public int getPortDischargingPlanStabilityParametersCount() {
    return portDischargingPlanStabilityParameters_.size();
  }
  /**
   * <code>repeated .LoadingPlanStabilityParameters portDischargingPlanStabilityParameters = 6;
   * </code>
   */
  public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters
      getPortDischargingPlanStabilityParameters(int index) {
    return portDischargingPlanStabilityParameters_.get(index);
  }
  /**
   * <code>repeated .LoadingPlanStabilityParameters portDischargingPlanStabilityParameters = 6;
   * </code>
   */
  public com.cpdss.common.generated.loading_plan.LoadingPlanModels
          .LoadingPlanStabilityParametersOrBuilder
      getPortDischargingPlanStabilityParametersOrBuilder(int index) {
    return portDischargingPlanStabilityParameters_.get(index);
  }

  public static final int PORTDISCHARGINGPLANCOMMINGLEDETAILS_FIELD_NUMBER = 9;
  private java.util.List<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanCommingleDetails>
      portDischargingPlanCommingleDetails_;
  /** <code>repeated .LoadingPlanCommingleDetails portDischargingPlanCommingleDetails = 9;</code> */
  public java.util.List<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanCommingleDetails>
      getPortDischargingPlanCommingleDetailsList() {
    return portDischargingPlanCommingleDetails_;
  }
  /** <code>repeated .LoadingPlanCommingleDetails portDischargingPlanCommingleDetails = 9;</code> */
  public java.util.List<
          ? extends
              com.cpdss.common.generated.loading_plan.LoadingPlanModels
                  .LoadingPlanCommingleDetailsOrBuilder>
      getPortDischargingPlanCommingleDetailsOrBuilderList() {
    return portDischargingPlanCommingleDetails_;
  }
  /** <code>repeated .LoadingPlanCommingleDetails portDischargingPlanCommingleDetails = 9;</code> */
  public int getPortDischargingPlanCommingleDetailsCount() {
    return portDischargingPlanCommingleDetails_.size();
  }
  /** <code>repeated .LoadingPlanCommingleDetails portDischargingPlanCommingleDetails = 9;</code> */
  public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanCommingleDetails
      getPortDischargingPlanCommingleDetails(int index) {
    return portDischargingPlanCommingleDetails_.get(index);
  }
  /** <code>repeated .LoadingPlanCommingleDetails portDischargingPlanCommingleDetails = 9;</code> */
  public com.cpdss.common.generated.loading_plan.LoadingPlanModels
          .LoadingPlanCommingleDetailsOrBuilder
      getPortDischargingPlanCommingleDetailsOrBuilder(int index) {
    return portDischargingPlanCommingleDetails_.get(index);
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
    if (loadingInfoId_ != 0L) {
      output.writeInt64(1, loadingInfoId_);
    }
    for (int i = 0; i < dischargingSequences_.size(); i++) {
      output.writeMessage(2, dischargingSequences_.get(i));
    }
    for (int i = 0; i < portDischargingPlanStowageDetails_.size(); i++) {
      output.writeMessage(3, portDischargingPlanStowageDetails_.get(i));
    }
    for (int i = 0; i < portDischargingPlanBallastDetails_.size(); i++) {
      output.writeMessage(4, portDischargingPlanBallastDetails_.get(i));
    }
    for (int i = 0; i < portDischargingPlanRobDetails_.size(); i++) {
      output.writeMessage(5, portDischargingPlanRobDetails_.get(i));
    }
    for (int i = 0; i < portDischargingPlanStabilityParameters_.size(); i++) {
      output.writeMessage(6, portDischargingPlanStabilityParameters_.get(i));
    }
    if (responseStatus_ != null) {
      output.writeMessage(7, getResponseStatus());
    }
    if (dischargingInformation_ != null) {
      output.writeMessage(8, getDischargingInformation());
    }
    for (int i = 0; i < portDischargingPlanCommingleDetails_.size(); i++) {
      output.writeMessage(9, portDischargingPlanCommingleDetails_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (loadingInfoId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream.computeInt64Size(1, loadingInfoId_);
    }
    for (int i = 0; i < dischargingSequences_.size(); i++) {
      size +=
          com.google.protobuf.CodedOutputStream.computeMessageSize(2, dischargingSequences_.get(i));
    }
    for (int i = 0; i < portDischargingPlanStowageDetails_.size(); i++) {
      size +=
          com.google.protobuf.CodedOutputStream.computeMessageSize(
              3, portDischargingPlanStowageDetails_.get(i));
    }
    for (int i = 0; i < portDischargingPlanBallastDetails_.size(); i++) {
      size +=
          com.google.protobuf.CodedOutputStream.computeMessageSize(
              4, portDischargingPlanBallastDetails_.get(i));
    }
    for (int i = 0; i < portDischargingPlanRobDetails_.size(); i++) {
      size +=
          com.google.protobuf.CodedOutputStream.computeMessageSize(
              5, portDischargingPlanRobDetails_.get(i));
    }
    for (int i = 0; i < portDischargingPlanStabilityParameters_.size(); i++) {
      size +=
          com.google.protobuf.CodedOutputStream.computeMessageSize(
              6, portDischargingPlanStabilityParameters_.get(i));
    }
    if (responseStatus_ != null) {
      size += com.google.protobuf.CodedOutputStream.computeMessageSize(7, getResponseStatus());
    }
    if (dischargingInformation_ != null) {
      size +=
          com.google.protobuf.CodedOutputStream.computeMessageSize(8, getDischargingInformation());
    }
    for (int i = 0; i < portDischargingPlanCommingleDetails_.size(); i++) {
      size +=
          com.google.protobuf.CodedOutputStream.computeMessageSize(
              9, portDischargingPlanCommingleDetails_.get(i));
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
    if (!(obj instanceof com.cpdss.common.generated.discharge_plan.DischargingPlanReply)) {
      return super.equals(obj);
    }
    com.cpdss.common.generated.discharge_plan.DischargingPlanReply other =
        (com.cpdss.common.generated.discharge_plan.DischargingPlanReply) obj;

    if (hasResponseStatus() != other.hasResponseStatus()) return false;
    if (hasResponseStatus()) {
      if (!getResponseStatus().equals(other.getResponseStatus())) return false;
    }
    if (getLoadingInfoId() != other.getLoadingInfoId()) return false;
    if (hasDischargingInformation() != other.hasDischargingInformation()) return false;
    if (hasDischargingInformation()) {
      if (!getDischargingInformation().equals(other.getDischargingInformation())) return false;
    }
    if (!getDischargingSequencesList().equals(other.getDischargingSequencesList())) return false;
    if (!getPortDischargingPlanStowageDetailsList()
        .equals(other.getPortDischargingPlanStowageDetailsList())) return false;
    if (!getPortDischargingPlanBallastDetailsList()
        .equals(other.getPortDischargingPlanBallastDetailsList())) return false;
    if (!getPortDischargingPlanRobDetailsList()
        .equals(other.getPortDischargingPlanRobDetailsList())) return false;
    if (!getPortDischargingPlanStabilityParametersList()
        .equals(other.getPortDischargingPlanStabilityParametersList())) return false;
    if (!getPortDischargingPlanCommingleDetailsList()
        .equals(other.getPortDischargingPlanCommingleDetailsList())) return false;
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
    hash = (37 * hash) + LOADINGINFOID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getLoadingInfoId());
    if (hasDischargingInformation()) {
      hash = (37 * hash) + DISCHARGINGINFORMATION_FIELD_NUMBER;
      hash = (53 * hash) + getDischargingInformation().hashCode();
    }
    if (getDischargingSequencesCount() > 0) {
      hash = (37 * hash) + DISCHARGINGSEQUENCES_FIELD_NUMBER;
      hash = (53 * hash) + getDischargingSequencesList().hashCode();
    }
    if (getPortDischargingPlanStowageDetailsCount() > 0) {
      hash = (37 * hash) + PORTDISCHARGINGPLANSTOWAGEDETAILS_FIELD_NUMBER;
      hash = (53 * hash) + getPortDischargingPlanStowageDetailsList().hashCode();
    }
    if (getPortDischargingPlanBallastDetailsCount() > 0) {
      hash = (37 * hash) + PORTDISCHARGINGPLANBALLASTDETAILS_FIELD_NUMBER;
      hash = (53 * hash) + getPortDischargingPlanBallastDetailsList().hashCode();
    }
    if (getPortDischargingPlanRobDetailsCount() > 0) {
      hash = (37 * hash) + PORTDISCHARGINGPLANROBDETAILS_FIELD_NUMBER;
      hash = (53 * hash) + getPortDischargingPlanRobDetailsList().hashCode();
    }
    if (getPortDischargingPlanStabilityParametersCount() > 0) {
      hash = (37 * hash) + PORTDISCHARGINGPLANSTABILITYPARAMETERS_FIELD_NUMBER;
      hash = (53 * hash) + getPortDischargingPlanStabilityParametersList().hashCode();
    }
    if (getPortDischargingPlanCommingleDetailsCount() > 0) {
      hash = (37 * hash) + PORTDISCHARGINGPLANCOMMINGLEDETAILS_FIELD_NUMBER;
      hash = (53 * hash) + getPortDischargingPlanCommingleDetailsList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingPlanReply parseFrom(
      java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingPlanReply parseFrom(
      java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingPlanReply parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingPlanReply parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingPlanReply parseFrom(
      byte[] data) throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingPlanReply parseFrom(
      byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingPlanReply parseFrom(
      java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingPlanReply parseFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingPlanReply parseDelimitedFrom(
      java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingPlanReply parseDelimitedFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingPlanReply parseFrom(
      com.google.protobuf.CodedInputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingPlanReply parseFrom(
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
      com.cpdss.common.generated.discharge_plan.DischargingPlanReply prototype) {
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
  /** Protobuf type {@code DischargingPlanReply} */
  public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
      implements
      // @@protoc_insertion_point(builder_implements:DischargingPlanReply)
      com.cpdss.common.generated.discharge_plan.DischargingPlanReplyOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanModels
          .internal_static_DischargingPlanReply_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanModels
          .internal_static_DischargingPlanReply_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.discharge_plan.DischargingPlanReply.class,
              com.cpdss.common.generated.discharge_plan.DischargingPlanReply.Builder.class);
    }

    // Construct using com.cpdss.common.generated.discharge_plan.DischargingPlanReply.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {
        getDischargingSequencesFieldBuilder();
        getPortDischargingPlanStowageDetailsFieldBuilder();
        getPortDischargingPlanBallastDetailsFieldBuilder();
        getPortDischargingPlanRobDetailsFieldBuilder();
        getPortDischargingPlanStabilityParametersFieldBuilder();
        getPortDischargingPlanCommingleDetailsFieldBuilder();
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
      loadingInfoId_ = 0L;

      if (dischargingInformationBuilder_ == null) {
        dischargingInformation_ = null;
      } else {
        dischargingInformation_ = null;
        dischargingInformationBuilder_ = null;
      }
      if (dischargingSequencesBuilder_ == null) {
        dischargingSequences_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        dischargingSequencesBuilder_.clear();
      }
      if (portDischargingPlanStowageDetailsBuilder_ == null) {
        portDischargingPlanStowageDetails_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000002);
      } else {
        portDischargingPlanStowageDetailsBuilder_.clear();
      }
      if (portDischargingPlanBallastDetailsBuilder_ == null) {
        portDischargingPlanBallastDetails_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000004);
      } else {
        portDischargingPlanBallastDetailsBuilder_.clear();
      }
      if (portDischargingPlanRobDetailsBuilder_ == null) {
        portDischargingPlanRobDetails_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000008);
      } else {
        portDischargingPlanRobDetailsBuilder_.clear();
      }
      if (portDischargingPlanStabilityParametersBuilder_ == null) {
        portDischargingPlanStabilityParameters_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000010);
      } else {
        portDischargingPlanStabilityParametersBuilder_.clear();
      }
      if (portDischargingPlanCommingleDetailsBuilder_ == null) {
        portDischargingPlanCommingleDetails_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000020);
      } else {
        portDischargingPlanCommingleDetailsBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanModels
          .internal_static_DischargingPlanReply_descriptor;
    }

    @java.lang.Override
    public com.cpdss.common.generated.discharge_plan.DischargingPlanReply
        getDefaultInstanceForType() {
      return com.cpdss.common.generated.discharge_plan.DischargingPlanReply.getDefaultInstance();
    }

    @java.lang.Override
    public com.cpdss.common.generated.discharge_plan.DischargingPlanReply build() {
      com.cpdss.common.generated.discharge_plan.DischargingPlanReply result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.cpdss.common.generated.discharge_plan.DischargingPlanReply buildPartial() {
      com.cpdss.common.generated.discharge_plan.DischargingPlanReply result =
          new com.cpdss.common.generated.discharge_plan.DischargingPlanReply(this);
      int from_bitField0_ = bitField0_;
      if (responseStatusBuilder_ == null) {
        result.responseStatus_ = responseStatus_;
      } else {
        result.responseStatus_ = responseStatusBuilder_.build();
      }
      result.loadingInfoId_ = loadingInfoId_;
      if (dischargingInformationBuilder_ == null) {
        result.dischargingInformation_ = dischargingInformation_;
      } else {
        result.dischargingInformation_ = dischargingInformationBuilder_.build();
      }
      if (dischargingSequencesBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          dischargingSequences_ = java.util.Collections.unmodifiableList(dischargingSequences_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.dischargingSequences_ = dischargingSequences_;
      } else {
        result.dischargingSequences_ = dischargingSequencesBuilder_.build();
      }
      if (portDischargingPlanStowageDetailsBuilder_ == null) {
        if (((bitField0_ & 0x00000002) != 0)) {
          portDischargingPlanStowageDetails_ =
              java.util.Collections.unmodifiableList(portDischargingPlanStowageDetails_);
          bitField0_ = (bitField0_ & ~0x00000002);
        }
        result.portDischargingPlanStowageDetails_ = portDischargingPlanStowageDetails_;
      } else {
        result.portDischargingPlanStowageDetails_ =
            portDischargingPlanStowageDetailsBuilder_.build();
      }
      if (portDischargingPlanBallastDetailsBuilder_ == null) {
        if (((bitField0_ & 0x00000004) != 0)) {
          portDischargingPlanBallastDetails_ =
              java.util.Collections.unmodifiableList(portDischargingPlanBallastDetails_);
          bitField0_ = (bitField0_ & ~0x00000004);
        }
        result.portDischargingPlanBallastDetails_ = portDischargingPlanBallastDetails_;
      } else {
        result.portDischargingPlanBallastDetails_ =
            portDischargingPlanBallastDetailsBuilder_.build();
      }
      if (portDischargingPlanRobDetailsBuilder_ == null) {
        if (((bitField0_ & 0x00000008) != 0)) {
          portDischargingPlanRobDetails_ =
              java.util.Collections.unmodifiableList(portDischargingPlanRobDetails_);
          bitField0_ = (bitField0_ & ~0x00000008);
        }
        result.portDischargingPlanRobDetails_ = portDischargingPlanRobDetails_;
      } else {
        result.portDischargingPlanRobDetails_ = portDischargingPlanRobDetailsBuilder_.build();
      }
      if (portDischargingPlanStabilityParametersBuilder_ == null) {
        if (((bitField0_ & 0x00000010) != 0)) {
          portDischargingPlanStabilityParameters_ =
              java.util.Collections.unmodifiableList(portDischargingPlanStabilityParameters_);
          bitField0_ = (bitField0_ & ~0x00000010);
        }
        result.portDischargingPlanStabilityParameters_ = portDischargingPlanStabilityParameters_;
      } else {
        result.portDischargingPlanStabilityParameters_ =
            portDischargingPlanStabilityParametersBuilder_.build();
      }
      if (portDischargingPlanCommingleDetailsBuilder_ == null) {
        if (((bitField0_ & 0x00000020) != 0)) {
          portDischargingPlanCommingleDetails_ =
              java.util.Collections.unmodifiableList(portDischargingPlanCommingleDetails_);
          bitField0_ = (bitField0_ & ~0x00000020);
        }
        result.portDischargingPlanCommingleDetails_ = portDischargingPlanCommingleDetails_;
      } else {
        result.portDischargingPlanCommingleDetails_ =
            portDischargingPlanCommingleDetailsBuilder_.build();
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
      if (other instanceof com.cpdss.common.generated.discharge_plan.DischargingPlanReply) {
        return mergeFrom((com.cpdss.common.generated.discharge_plan.DischargingPlanReply) other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.cpdss.common.generated.discharge_plan.DischargingPlanReply other) {
      if (other
          == com.cpdss.common.generated.discharge_plan.DischargingPlanReply.getDefaultInstance())
        return this;
      if (other.hasResponseStatus()) {
        mergeResponseStatus(other.getResponseStatus());
      }
      if (other.getLoadingInfoId() != 0L) {
        setLoadingInfoId(other.getLoadingInfoId());
      }
      if (other.hasDischargingInformation()) {
        mergeDischargingInformation(other.getDischargingInformation());
      }
      if (dischargingSequencesBuilder_ == null) {
        if (!other.dischargingSequences_.isEmpty()) {
          if (dischargingSequences_.isEmpty()) {
            dischargingSequences_ = other.dischargingSequences_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureDischargingSequencesIsMutable();
            dischargingSequences_.addAll(other.dischargingSequences_);
          }
          onChanged();
        }
      } else {
        if (!other.dischargingSequences_.isEmpty()) {
          if (dischargingSequencesBuilder_.isEmpty()) {
            dischargingSequencesBuilder_.dispose();
            dischargingSequencesBuilder_ = null;
            dischargingSequences_ = other.dischargingSequences_;
            bitField0_ = (bitField0_ & ~0x00000001);
            dischargingSequencesBuilder_ =
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
                    ? getDischargingSequencesFieldBuilder()
                    : null;
          } else {
            dischargingSequencesBuilder_.addAllMessages(other.dischargingSequences_);
          }
        }
      }
      if (portDischargingPlanStowageDetailsBuilder_ == null) {
        if (!other.portDischargingPlanStowageDetails_.isEmpty()) {
          if (portDischargingPlanStowageDetails_.isEmpty()) {
            portDischargingPlanStowageDetails_ = other.portDischargingPlanStowageDetails_;
            bitField0_ = (bitField0_ & ~0x00000002);
          } else {
            ensurePortDischargingPlanStowageDetailsIsMutable();
            portDischargingPlanStowageDetails_.addAll(other.portDischargingPlanStowageDetails_);
          }
          onChanged();
        }
      } else {
        if (!other.portDischargingPlanStowageDetails_.isEmpty()) {
          if (portDischargingPlanStowageDetailsBuilder_.isEmpty()) {
            portDischargingPlanStowageDetailsBuilder_.dispose();
            portDischargingPlanStowageDetailsBuilder_ = null;
            portDischargingPlanStowageDetails_ = other.portDischargingPlanStowageDetails_;
            bitField0_ = (bitField0_ & ~0x00000002);
            portDischargingPlanStowageDetailsBuilder_ =
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
                    ? getPortDischargingPlanStowageDetailsFieldBuilder()
                    : null;
          } else {
            portDischargingPlanStowageDetailsBuilder_.addAllMessages(
                other.portDischargingPlanStowageDetails_);
          }
        }
      }
      if (portDischargingPlanBallastDetailsBuilder_ == null) {
        if (!other.portDischargingPlanBallastDetails_.isEmpty()) {
          if (portDischargingPlanBallastDetails_.isEmpty()) {
            portDischargingPlanBallastDetails_ = other.portDischargingPlanBallastDetails_;
            bitField0_ = (bitField0_ & ~0x00000004);
          } else {
            ensurePortDischargingPlanBallastDetailsIsMutable();
            portDischargingPlanBallastDetails_.addAll(other.portDischargingPlanBallastDetails_);
          }
          onChanged();
        }
      } else {
        if (!other.portDischargingPlanBallastDetails_.isEmpty()) {
          if (portDischargingPlanBallastDetailsBuilder_.isEmpty()) {
            portDischargingPlanBallastDetailsBuilder_.dispose();
            portDischargingPlanBallastDetailsBuilder_ = null;
            portDischargingPlanBallastDetails_ = other.portDischargingPlanBallastDetails_;
            bitField0_ = (bitField0_ & ~0x00000004);
            portDischargingPlanBallastDetailsBuilder_ =
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
                    ? getPortDischargingPlanBallastDetailsFieldBuilder()
                    : null;
          } else {
            portDischargingPlanBallastDetailsBuilder_.addAllMessages(
                other.portDischargingPlanBallastDetails_);
          }
        }
      }
      if (portDischargingPlanRobDetailsBuilder_ == null) {
        if (!other.portDischargingPlanRobDetails_.isEmpty()) {
          if (portDischargingPlanRobDetails_.isEmpty()) {
            portDischargingPlanRobDetails_ = other.portDischargingPlanRobDetails_;
            bitField0_ = (bitField0_ & ~0x00000008);
          } else {
            ensurePortDischargingPlanRobDetailsIsMutable();
            portDischargingPlanRobDetails_.addAll(other.portDischargingPlanRobDetails_);
          }
          onChanged();
        }
      } else {
        if (!other.portDischargingPlanRobDetails_.isEmpty()) {
          if (portDischargingPlanRobDetailsBuilder_.isEmpty()) {
            portDischargingPlanRobDetailsBuilder_.dispose();
            portDischargingPlanRobDetailsBuilder_ = null;
            portDischargingPlanRobDetails_ = other.portDischargingPlanRobDetails_;
            bitField0_ = (bitField0_ & ~0x00000008);
            portDischargingPlanRobDetailsBuilder_ =
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
                    ? getPortDischargingPlanRobDetailsFieldBuilder()
                    : null;
          } else {
            portDischargingPlanRobDetailsBuilder_.addAllMessages(
                other.portDischargingPlanRobDetails_);
          }
        }
      }
      if (portDischargingPlanStabilityParametersBuilder_ == null) {
        if (!other.portDischargingPlanStabilityParameters_.isEmpty()) {
          if (portDischargingPlanStabilityParameters_.isEmpty()) {
            portDischargingPlanStabilityParameters_ = other.portDischargingPlanStabilityParameters_;
            bitField0_ = (bitField0_ & ~0x00000010);
          } else {
            ensurePortDischargingPlanStabilityParametersIsMutable();
            portDischargingPlanStabilityParameters_.addAll(
                other.portDischargingPlanStabilityParameters_);
          }
          onChanged();
        }
      } else {
        if (!other.portDischargingPlanStabilityParameters_.isEmpty()) {
          if (portDischargingPlanStabilityParametersBuilder_.isEmpty()) {
            portDischargingPlanStabilityParametersBuilder_.dispose();
            portDischargingPlanStabilityParametersBuilder_ = null;
            portDischargingPlanStabilityParameters_ = other.portDischargingPlanStabilityParameters_;
            bitField0_ = (bitField0_ & ~0x00000010);
            portDischargingPlanStabilityParametersBuilder_ =
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
                    ? getPortDischargingPlanStabilityParametersFieldBuilder()
                    : null;
          } else {
            portDischargingPlanStabilityParametersBuilder_.addAllMessages(
                other.portDischargingPlanStabilityParameters_);
          }
        }
      }
      if (portDischargingPlanCommingleDetailsBuilder_ == null) {
        if (!other.portDischargingPlanCommingleDetails_.isEmpty()) {
          if (portDischargingPlanCommingleDetails_.isEmpty()) {
            portDischargingPlanCommingleDetails_ = other.portDischargingPlanCommingleDetails_;
            bitField0_ = (bitField0_ & ~0x00000020);
          } else {
            ensurePortDischargingPlanCommingleDetailsIsMutable();
            portDischargingPlanCommingleDetails_.addAll(other.portDischargingPlanCommingleDetails_);
          }
          onChanged();
        }
      } else {
        if (!other.portDischargingPlanCommingleDetails_.isEmpty()) {
          if (portDischargingPlanCommingleDetailsBuilder_.isEmpty()) {
            portDischargingPlanCommingleDetailsBuilder_.dispose();
            portDischargingPlanCommingleDetailsBuilder_ = null;
            portDischargingPlanCommingleDetails_ = other.portDischargingPlanCommingleDetails_;
            bitField0_ = (bitField0_ & ~0x00000020);
            portDischargingPlanCommingleDetailsBuilder_ =
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
                    ? getPortDischargingPlanCommingleDetailsFieldBuilder()
                    : null;
          } else {
            portDischargingPlanCommingleDetailsBuilder_.addAllMessages(
                other.portDischargingPlanCommingleDetails_);
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
      com.cpdss.common.generated.discharge_plan.DischargingPlanReply parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage =
            (com.cpdss.common.generated.discharge_plan.DischargingPlanReply)
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
     * <code>.ResponseStatus responseStatus = 7;</code>
     *
     * @return Whether the responseStatus field is set.
     */
    public boolean hasResponseStatus() {
      return responseStatusBuilder_ != null || responseStatus_ != null;
    }
    /**
     * <code>.ResponseStatus responseStatus = 7;</code>
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
    /** <code>.ResponseStatus responseStatus = 7;</code> */
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
    /** <code>.ResponseStatus responseStatus = 7;</code> */
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
    /** <code>.ResponseStatus responseStatus = 7;</code> */
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
    /** <code>.ResponseStatus responseStatus = 7;</code> */
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
    /** <code>.ResponseStatus responseStatus = 7;</code> */
    public com.cpdss.common.generated.Common.ResponseStatus.Builder getResponseStatusBuilder() {

      onChanged();
      return getResponseStatusFieldBuilder().getBuilder();
    }
    /** <code>.ResponseStatus responseStatus = 7;</code> */
    public com.cpdss.common.generated.Common.ResponseStatusOrBuilder getResponseStatusOrBuilder() {
      if (responseStatusBuilder_ != null) {
        return responseStatusBuilder_.getMessageOrBuilder();
      } else {
        return responseStatus_ == null
            ? com.cpdss.common.generated.Common.ResponseStatus.getDefaultInstance()
            : responseStatus_;
      }
    }
    /** <code>.ResponseStatus responseStatus = 7;</code> */
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

    private long loadingInfoId_;
    /**
     * <code>int64 loadingInfoId = 1;</code>
     *
     * @return The loadingInfoId.
     */
    public long getLoadingInfoId() {
      return loadingInfoId_;
    }
    /**
     * <code>int64 loadingInfoId = 1;</code>
     *
     * @param value The loadingInfoId to set.
     * @return This builder for chaining.
     */
    public Builder setLoadingInfoId(long value) {

      loadingInfoId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 loadingInfoId = 1;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearLoadingInfoId() {

      loadingInfoId_ = 0L;
      onChanged();
      return this;
    }

    private com.cpdss.common.generated.discharge_plan.DischargeInformation dischargingInformation_;
    private com.google.protobuf.SingleFieldBuilderV3<
            com.cpdss.common.generated.discharge_plan.DischargeInformation,
            com.cpdss.common.generated.discharge_plan.DischargeInformation.Builder,
            com.cpdss.common.generated.discharge_plan.DischargeInformationOrBuilder>
        dischargingInformationBuilder_;
    /**
     * <code>.DischargeInformation dischargingInformation = 8;</code>
     *
     * @return Whether the dischargingInformation field is set.
     */
    public boolean hasDischargingInformation() {
      return dischargingInformationBuilder_ != null || dischargingInformation_ != null;
    }
    /**
     * <code>.DischargeInformation dischargingInformation = 8;</code>
     *
     * @return The dischargingInformation.
     */
    public com.cpdss.common.generated.discharge_plan.DischargeInformation
        getDischargingInformation() {
      if (dischargingInformationBuilder_ == null) {
        return dischargingInformation_ == null
            ? com.cpdss.common.generated.discharge_plan.DischargeInformation.getDefaultInstance()
            : dischargingInformation_;
      } else {
        return dischargingInformationBuilder_.getMessage();
      }
    }
    /** <code>.DischargeInformation dischargingInformation = 8;</code> */
    public Builder setDischargingInformation(
        com.cpdss.common.generated.discharge_plan.DischargeInformation value) {
      if (dischargingInformationBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        dischargingInformation_ = value;
        onChanged();
      } else {
        dischargingInformationBuilder_.setMessage(value);
      }

      return this;
    }
    /** <code>.DischargeInformation dischargingInformation = 8;</code> */
    public Builder setDischargingInformation(
        com.cpdss.common.generated.discharge_plan.DischargeInformation.Builder builderForValue) {
      if (dischargingInformationBuilder_ == null) {
        dischargingInformation_ = builderForValue.build();
        onChanged();
      } else {
        dischargingInformationBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /** <code>.DischargeInformation dischargingInformation = 8;</code> */
    public Builder mergeDischargingInformation(
        com.cpdss.common.generated.discharge_plan.DischargeInformation value) {
      if (dischargingInformationBuilder_ == null) {
        if (dischargingInformation_ != null) {
          dischargingInformation_ =
              com.cpdss.common.generated.discharge_plan.DischargeInformation.newBuilder(
                      dischargingInformation_)
                  .mergeFrom(value)
                  .buildPartial();
        } else {
          dischargingInformation_ = value;
        }
        onChanged();
      } else {
        dischargingInformationBuilder_.mergeFrom(value);
      }

      return this;
    }
    /** <code>.DischargeInformation dischargingInformation = 8;</code> */
    public Builder clearDischargingInformation() {
      if (dischargingInformationBuilder_ == null) {
        dischargingInformation_ = null;
        onChanged();
      } else {
        dischargingInformation_ = null;
        dischargingInformationBuilder_ = null;
      }

      return this;
    }
    /** <code>.DischargeInformation dischargingInformation = 8;</code> */
    public com.cpdss.common.generated.discharge_plan.DischargeInformation.Builder
        getDischargingInformationBuilder() {

      onChanged();
      return getDischargingInformationFieldBuilder().getBuilder();
    }
    /** <code>.DischargeInformation dischargingInformation = 8;</code> */
    public com.cpdss.common.generated.discharge_plan.DischargeInformationOrBuilder
        getDischargingInformationOrBuilder() {
      if (dischargingInformationBuilder_ != null) {
        return dischargingInformationBuilder_.getMessageOrBuilder();
      } else {
        return dischargingInformation_ == null
            ? com.cpdss.common.generated.discharge_plan.DischargeInformation.getDefaultInstance()
            : dischargingInformation_;
      }
    }
    /** <code>.DischargeInformation dischargingInformation = 8;</code> */
    private com.google.protobuf.SingleFieldBuilderV3<
            com.cpdss.common.generated.discharge_plan.DischargeInformation,
            com.cpdss.common.generated.discharge_plan.DischargeInformation.Builder,
            com.cpdss.common.generated.discharge_plan.DischargeInformationOrBuilder>
        getDischargingInformationFieldBuilder() {
      if (dischargingInformationBuilder_ == null) {
        dischargingInformationBuilder_ =
            new com.google.protobuf.SingleFieldBuilderV3<
                com.cpdss.common.generated.discharge_plan.DischargeInformation,
                com.cpdss.common.generated.discharge_plan.DischargeInformation.Builder,
                com.cpdss.common.generated.discharge_plan.DischargeInformationOrBuilder>(
                getDischargingInformation(), getParentForChildren(), isClean());
        dischargingInformation_ = null;
      }
      return dischargingInformationBuilder_;
    }

    private java.util.List<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingSequence>
        dischargingSequences_ = java.util.Collections.emptyList();

    private void ensureDischargingSequencesIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        dischargingSequences_ =
            new java.util.ArrayList<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingSequence>(
                dischargingSequences_);
        bitField0_ |= 0x00000001;
      }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingSequence,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingSequence.Builder,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingSequenceOrBuilder>
        dischargingSequencesBuilder_;

    /** <code>repeated .LoadingSequence dischargingSequences = 2;</code> */
    public java.util.List<com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingSequence>
        getDischargingSequencesList() {
      if (dischargingSequencesBuilder_ == null) {
        return java.util.Collections.unmodifiableList(dischargingSequences_);
      } else {
        return dischargingSequencesBuilder_.getMessageList();
      }
    }
    /** <code>repeated .LoadingSequence dischargingSequences = 2;</code> */
    public int getDischargingSequencesCount() {
      if (dischargingSequencesBuilder_ == null) {
        return dischargingSequences_.size();
      } else {
        return dischargingSequencesBuilder_.getCount();
      }
    }
    /** <code>repeated .LoadingSequence dischargingSequences = 2;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingSequence
        getDischargingSequences(int index) {
      if (dischargingSequencesBuilder_ == null) {
        return dischargingSequences_.get(index);
      } else {
        return dischargingSequencesBuilder_.getMessage(index);
      }
    }
    /** <code>repeated .LoadingSequence dischargingSequences = 2;</code> */
    public Builder setDischargingSequences(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingSequence value) {
      if (dischargingSequencesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDischargingSequencesIsMutable();
        dischargingSequences_.set(index, value);
        onChanged();
      } else {
        dischargingSequencesBuilder_.setMessage(index, value);
      }
      return this;
    }
    /** <code>repeated .LoadingSequence dischargingSequences = 2;</code> */
    public Builder setDischargingSequences(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingSequence.Builder
            builderForValue) {
      if (dischargingSequencesBuilder_ == null) {
        ensureDischargingSequencesIsMutable();
        dischargingSequences_.set(index, builderForValue.build());
        onChanged();
      } else {
        dischargingSequencesBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .LoadingSequence dischargingSequences = 2;</code> */
    public Builder addDischargingSequences(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingSequence value) {
      if (dischargingSequencesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDischargingSequencesIsMutable();
        dischargingSequences_.add(value);
        onChanged();
      } else {
        dischargingSequencesBuilder_.addMessage(value);
      }
      return this;
    }
    /** <code>repeated .LoadingSequence dischargingSequences = 2;</code> */
    public Builder addDischargingSequences(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingSequence value) {
      if (dischargingSequencesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDischargingSequencesIsMutable();
        dischargingSequences_.add(index, value);
        onChanged();
      } else {
        dischargingSequencesBuilder_.addMessage(index, value);
      }
      return this;
    }
    /** <code>repeated .LoadingSequence dischargingSequences = 2;</code> */
    public Builder addDischargingSequences(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingSequence.Builder
            builderForValue) {
      if (dischargingSequencesBuilder_ == null) {
        ensureDischargingSequencesIsMutable();
        dischargingSequences_.add(builderForValue.build());
        onChanged();
      } else {
        dischargingSequencesBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .LoadingSequence dischargingSequences = 2;</code> */
    public Builder addDischargingSequences(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingSequence.Builder
            builderForValue) {
      if (dischargingSequencesBuilder_ == null) {
        ensureDischargingSequencesIsMutable();
        dischargingSequences_.add(index, builderForValue.build());
        onChanged();
      } else {
        dischargingSequencesBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .LoadingSequence dischargingSequences = 2;</code> */
    public Builder addAllDischargingSequences(
        java.lang.Iterable<
                ? extends com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingSequence>
            values) {
      if (dischargingSequencesBuilder_ == null) {
        ensureDischargingSequencesIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(values, dischargingSequences_);
        onChanged();
      } else {
        dischargingSequencesBuilder_.addAllMessages(values);
      }
      return this;
    }
    /** <code>repeated .LoadingSequence dischargingSequences = 2;</code> */
    public Builder clearDischargingSequences() {
      if (dischargingSequencesBuilder_ == null) {
        dischargingSequences_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        dischargingSequencesBuilder_.clear();
      }
      return this;
    }
    /** <code>repeated .LoadingSequence dischargingSequences = 2;</code> */
    public Builder removeDischargingSequences(int index) {
      if (dischargingSequencesBuilder_ == null) {
        ensureDischargingSequencesIsMutable();
        dischargingSequences_.remove(index);
        onChanged();
      } else {
        dischargingSequencesBuilder_.remove(index);
      }
      return this;
    }
    /** <code>repeated .LoadingSequence dischargingSequences = 2;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingSequence.Builder
        getDischargingSequencesBuilder(int index) {
      return getDischargingSequencesFieldBuilder().getBuilder(index);
    }
    /** <code>repeated .LoadingSequence dischargingSequences = 2;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingSequenceOrBuilder
        getDischargingSequencesOrBuilder(int index) {
      if (dischargingSequencesBuilder_ == null) {
        return dischargingSequences_.get(index);
      } else {
        return dischargingSequencesBuilder_.getMessageOrBuilder(index);
      }
    }
    /** <code>repeated .LoadingSequence dischargingSequences = 2;</code> */
    public java.util.List<
            ? extends
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingSequenceOrBuilder>
        getDischargingSequencesOrBuilderList() {
      if (dischargingSequencesBuilder_ != null) {
        return dischargingSequencesBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(dischargingSequences_);
      }
    }
    /** <code>repeated .LoadingSequence dischargingSequences = 2;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingSequence.Builder
        addDischargingSequencesBuilder() {
      return getDischargingSequencesFieldBuilder()
          .addBuilder(
              com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingSequence
                  .getDefaultInstance());
    }
    /** <code>repeated .LoadingSequence dischargingSequences = 2;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingSequence.Builder
        addDischargingSequencesBuilder(int index) {
      return getDischargingSequencesFieldBuilder()
          .addBuilder(
              index,
              com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingSequence
                  .getDefaultInstance());
    }
    /** <code>repeated .LoadingSequence dischargingSequences = 2;</code> */
    public java.util.List<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingSequence.Builder>
        getDischargingSequencesBuilderList() {
      return getDischargingSequencesFieldBuilder().getBuilderList();
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingSequence,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingSequence.Builder,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingSequenceOrBuilder>
        getDischargingSequencesFieldBuilder() {
      if (dischargingSequencesBuilder_ == null) {
        dischargingSequencesBuilder_ =
            new com.google.protobuf.RepeatedFieldBuilderV3<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingSequence,
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingSequence.Builder,
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingSequenceOrBuilder>(
                dischargingSequences_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        dischargingSequences_ = null;
      }
      return dischargingSequencesBuilder_;
    }

    private java.util.List<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails>
        portDischargingPlanStowageDetails_ = java.util.Collections.emptyList();

    private void ensurePortDischargingPlanStowageDetailsIsMutable() {
      if (!((bitField0_ & 0x00000002) != 0)) {
        portDischargingPlanStowageDetails_ =
            new java.util.ArrayList<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails>(
                portDischargingPlanStowageDetails_);
        bitField0_ |= 0x00000002;
      }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
                .Builder,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels
                .LoadingPlanTankDetailsOrBuilder>
        portDischargingPlanStowageDetailsBuilder_;

    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanStowageDetails = 3;</code> */
    public java.util.List<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails>
        getPortDischargingPlanStowageDetailsList() {
      if (portDischargingPlanStowageDetailsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(portDischargingPlanStowageDetails_);
      } else {
        return portDischargingPlanStowageDetailsBuilder_.getMessageList();
      }
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanStowageDetails = 3;</code> */
    public int getPortDischargingPlanStowageDetailsCount() {
      if (portDischargingPlanStowageDetailsBuilder_ == null) {
        return portDischargingPlanStowageDetails_.size();
      } else {
        return portDischargingPlanStowageDetailsBuilder_.getCount();
      }
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanStowageDetails = 3;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
        getPortDischargingPlanStowageDetails(int index) {
      if (portDischargingPlanStowageDetailsBuilder_ == null) {
        return portDischargingPlanStowageDetails_.get(index);
      } else {
        return portDischargingPlanStowageDetailsBuilder_.getMessage(index);
      }
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanStowageDetails = 3;</code> */
    public Builder setPortDischargingPlanStowageDetails(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails value) {
      if (portDischargingPlanStowageDetailsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensurePortDischargingPlanStowageDetailsIsMutable();
        portDischargingPlanStowageDetails_.set(index, value);
        onChanged();
      } else {
        portDischargingPlanStowageDetailsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanStowageDetails = 3;</code> */
    public Builder setPortDischargingPlanStowageDetails(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails.Builder
            builderForValue) {
      if (portDischargingPlanStowageDetailsBuilder_ == null) {
        ensurePortDischargingPlanStowageDetailsIsMutable();
        portDischargingPlanStowageDetails_.set(index, builderForValue.build());
        onChanged();
      } else {
        portDischargingPlanStowageDetailsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanStowageDetails = 3;</code> */
    public Builder addPortDischargingPlanStowageDetails(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails value) {
      if (portDischargingPlanStowageDetailsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensurePortDischargingPlanStowageDetailsIsMutable();
        portDischargingPlanStowageDetails_.add(value);
        onChanged();
      } else {
        portDischargingPlanStowageDetailsBuilder_.addMessage(value);
      }
      return this;
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanStowageDetails = 3;</code> */
    public Builder addPortDischargingPlanStowageDetails(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails value) {
      if (portDischargingPlanStowageDetailsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensurePortDischargingPlanStowageDetailsIsMutable();
        portDischargingPlanStowageDetails_.add(index, value);
        onChanged();
      } else {
        portDischargingPlanStowageDetailsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanStowageDetails = 3;</code> */
    public Builder addPortDischargingPlanStowageDetails(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails.Builder
            builderForValue) {
      if (portDischargingPlanStowageDetailsBuilder_ == null) {
        ensurePortDischargingPlanStowageDetailsIsMutable();
        portDischargingPlanStowageDetails_.add(builderForValue.build());
        onChanged();
      } else {
        portDischargingPlanStowageDetailsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanStowageDetails = 3;</code> */
    public Builder addPortDischargingPlanStowageDetails(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails.Builder
            builderForValue) {
      if (portDischargingPlanStowageDetailsBuilder_ == null) {
        ensurePortDischargingPlanStowageDetailsIsMutable();
        portDischargingPlanStowageDetails_.add(index, builderForValue.build());
        onChanged();
      } else {
        portDischargingPlanStowageDetailsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanStowageDetails = 3;</code> */
    public Builder addAllPortDischargingPlanStowageDetails(
        java.lang.Iterable<
                ? extends
                    com.cpdss.common.generated.loading_plan.LoadingPlanModels
                        .LoadingPlanTankDetails>
            values) {
      if (portDischargingPlanStowageDetailsBuilder_ == null) {
        ensurePortDischargingPlanStowageDetailsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, portDischargingPlanStowageDetails_);
        onChanged();
      } else {
        portDischargingPlanStowageDetailsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanStowageDetails = 3;</code> */
    public Builder clearPortDischargingPlanStowageDetails() {
      if (portDischargingPlanStowageDetailsBuilder_ == null) {
        portDischargingPlanStowageDetails_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000002);
        onChanged();
      } else {
        portDischargingPlanStowageDetailsBuilder_.clear();
      }
      return this;
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanStowageDetails = 3;</code> */
    public Builder removePortDischargingPlanStowageDetails(int index) {
      if (portDischargingPlanStowageDetailsBuilder_ == null) {
        ensurePortDischargingPlanStowageDetailsIsMutable();
        portDischargingPlanStowageDetails_.remove(index);
        onChanged();
      } else {
        portDischargingPlanStowageDetailsBuilder_.remove(index);
      }
      return this;
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanStowageDetails = 3;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails.Builder
        getPortDischargingPlanStowageDetailsBuilder(int index) {
      return getPortDischargingPlanStowageDetailsFieldBuilder().getBuilder(index);
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanStowageDetails = 3;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetailsOrBuilder
        getPortDischargingPlanStowageDetailsOrBuilder(int index) {
      if (portDischargingPlanStowageDetailsBuilder_ == null) {
        return portDischargingPlanStowageDetails_.get(index);
      } else {
        return portDischargingPlanStowageDetailsBuilder_.getMessageOrBuilder(index);
      }
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanStowageDetails = 3;</code> */
    public java.util.List<
            ? extends
                com.cpdss.common.generated.loading_plan.LoadingPlanModels
                    .LoadingPlanTankDetailsOrBuilder>
        getPortDischargingPlanStowageDetailsOrBuilderList() {
      if (portDischargingPlanStowageDetailsBuilder_ != null) {
        return portDischargingPlanStowageDetailsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(portDischargingPlanStowageDetails_);
      }
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanStowageDetails = 3;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails.Builder
        addPortDischargingPlanStowageDetailsBuilder() {
      return getPortDischargingPlanStowageDetailsFieldBuilder()
          .addBuilder(
              com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
                  .getDefaultInstance());
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanStowageDetails = 3;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails.Builder
        addPortDischargingPlanStowageDetailsBuilder(int index) {
      return getPortDischargingPlanStowageDetailsFieldBuilder()
          .addBuilder(
              index,
              com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
                  .getDefaultInstance());
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanStowageDetails = 3;</code> */
    public java.util.List<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
                .Builder>
        getPortDischargingPlanStowageDetailsBuilderList() {
      return getPortDischargingPlanStowageDetailsFieldBuilder().getBuilderList();
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
                .Builder,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels
                .LoadingPlanTankDetailsOrBuilder>
        getPortDischargingPlanStowageDetailsFieldBuilder() {
      if (portDischargingPlanStowageDetailsBuilder_ == null) {
        portDischargingPlanStowageDetailsBuilder_ =
            new com.google.protobuf.RepeatedFieldBuilderV3<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails,
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
                    .Builder,
                com.cpdss.common.generated.loading_plan.LoadingPlanModels
                    .LoadingPlanTankDetailsOrBuilder>(
                portDischargingPlanStowageDetails_,
                ((bitField0_ & 0x00000002) != 0),
                getParentForChildren(),
                isClean());
        portDischargingPlanStowageDetails_ = null;
      }
      return portDischargingPlanStowageDetailsBuilder_;
    }

    private java.util.List<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails>
        portDischargingPlanBallastDetails_ = java.util.Collections.emptyList();

    private void ensurePortDischargingPlanBallastDetailsIsMutable() {
      if (!((bitField0_ & 0x00000004) != 0)) {
        portDischargingPlanBallastDetails_ =
            new java.util.ArrayList<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails>(
                portDischargingPlanBallastDetails_);
        bitField0_ |= 0x00000004;
      }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
                .Builder,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels
                .LoadingPlanTankDetailsOrBuilder>
        portDischargingPlanBallastDetailsBuilder_;

    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanBallastDetails = 4;</code> */
    public java.util.List<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails>
        getPortDischargingPlanBallastDetailsList() {
      if (portDischargingPlanBallastDetailsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(portDischargingPlanBallastDetails_);
      } else {
        return portDischargingPlanBallastDetailsBuilder_.getMessageList();
      }
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanBallastDetails = 4;</code> */
    public int getPortDischargingPlanBallastDetailsCount() {
      if (portDischargingPlanBallastDetailsBuilder_ == null) {
        return portDischargingPlanBallastDetails_.size();
      } else {
        return portDischargingPlanBallastDetailsBuilder_.getCount();
      }
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanBallastDetails = 4;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
        getPortDischargingPlanBallastDetails(int index) {
      if (portDischargingPlanBallastDetailsBuilder_ == null) {
        return portDischargingPlanBallastDetails_.get(index);
      } else {
        return portDischargingPlanBallastDetailsBuilder_.getMessage(index);
      }
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanBallastDetails = 4;</code> */
    public Builder setPortDischargingPlanBallastDetails(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails value) {
      if (portDischargingPlanBallastDetailsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensurePortDischargingPlanBallastDetailsIsMutable();
        portDischargingPlanBallastDetails_.set(index, value);
        onChanged();
      } else {
        portDischargingPlanBallastDetailsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanBallastDetails = 4;</code> */
    public Builder setPortDischargingPlanBallastDetails(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails.Builder
            builderForValue) {
      if (portDischargingPlanBallastDetailsBuilder_ == null) {
        ensurePortDischargingPlanBallastDetailsIsMutable();
        portDischargingPlanBallastDetails_.set(index, builderForValue.build());
        onChanged();
      } else {
        portDischargingPlanBallastDetailsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanBallastDetails = 4;</code> */
    public Builder addPortDischargingPlanBallastDetails(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails value) {
      if (portDischargingPlanBallastDetailsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensurePortDischargingPlanBallastDetailsIsMutable();
        portDischargingPlanBallastDetails_.add(value);
        onChanged();
      } else {
        portDischargingPlanBallastDetailsBuilder_.addMessage(value);
      }
      return this;
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanBallastDetails = 4;</code> */
    public Builder addPortDischargingPlanBallastDetails(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails value) {
      if (portDischargingPlanBallastDetailsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensurePortDischargingPlanBallastDetailsIsMutable();
        portDischargingPlanBallastDetails_.add(index, value);
        onChanged();
      } else {
        portDischargingPlanBallastDetailsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanBallastDetails = 4;</code> */
    public Builder addPortDischargingPlanBallastDetails(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails.Builder
            builderForValue) {
      if (portDischargingPlanBallastDetailsBuilder_ == null) {
        ensurePortDischargingPlanBallastDetailsIsMutable();
        portDischargingPlanBallastDetails_.add(builderForValue.build());
        onChanged();
      } else {
        portDischargingPlanBallastDetailsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanBallastDetails = 4;</code> */
    public Builder addPortDischargingPlanBallastDetails(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails.Builder
            builderForValue) {
      if (portDischargingPlanBallastDetailsBuilder_ == null) {
        ensurePortDischargingPlanBallastDetailsIsMutable();
        portDischargingPlanBallastDetails_.add(index, builderForValue.build());
        onChanged();
      } else {
        portDischargingPlanBallastDetailsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanBallastDetails = 4;</code> */
    public Builder addAllPortDischargingPlanBallastDetails(
        java.lang.Iterable<
                ? extends
                    com.cpdss.common.generated.loading_plan.LoadingPlanModels
                        .LoadingPlanTankDetails>
            values) {
      if (portDischargingPlanBallastDetailsBuilder_ == null) {
        ensurePortDischargingPlanBallastDetailsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, portDischargingPlanBallastDetails_);
        onChanged();
      } else {
        portDischargingPlanBallastDetailsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanBallastDetails = 4;</code> */
    public Builder clearPortDischargingPlanBallastDetails() {
      if (portDischargingPlanBallastDetailsBuilder_ == null) {
        portDischargingPlanBallastDetails_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000004);
        onChanged();
      } else {
        portDischargingPlanBallastDetailsBuilder_.clear();
      }
      return this;
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanBallastDetails = 4;</code> */
    public Builder removePortDischargingPlanBallastDetails(int index) {
      if (portDischargingPlanBallastDetailsBuilder_ == null) {
        ensurePortDischargingPlanBallastDetailsIsMutable();
        portDischargingPlanBallastDetails_.remove(index);
        onChanged();
      } else {
        portDischargingPlanBallastDetailsBuilder_.remove(index);
      }
      return this;
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanBallastDetails = 4;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails.Builder
        getPortDischargingPlanBallastDetailsBuilder(int index) {
      return getPortDischargingPlanBallastDetailsFieldBuilder().getBuilder(index);
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanBallastDetails = 4;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetailsOrBuilder
        getPortDischargingPlanBallastDetailsOrBuilder(int index) {
      if (portDischargingPlanBallastDetailsBuilder_ == null) {
        return portDischargingPlanBallastDetails_.get(index);
      } else {
        return portDischargingPlanBallastDetailsBuilder_.getMessageOrBuilder(index);
      }
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanBallastDetails = 4;</code> */
    public java.util.List<
            ? extends
                com.cpdss.common.generated.loading_plan.LoadingPlanModels
                    .LoadingPlanTankDetailsOrBuilder>
        getPortDischargingPlanBallastDetailsOrBuilderList() {
      if (portDischargingPlanBallastDetailsBuilder_ != null) {
        return portDischargingPlanBallastDetailsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(portDischargingPlanBallastDetails_);
      }
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanBallastDetails = 4;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails.Builder
        addPortDischargingPlanBallastDetailsBuilder() {
      return getPortDischargingPlanBallastDetailsFieldBuilder()
          .addBuilder(
              com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
                  .getDefaultInstance());
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanBallastDetails = 4;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails.Builder
        addPortDischargingPlanBallastDetailsBuilder(int index) {
      return getPortDischargingPlanBallastDetailsFieldBuilder()
          .addBuilder(
              index,
              com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
                  .getDefaultInstance());
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanBallastDetails = 4;</code> */
    public java.util.List<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
                .Builder>
        getPortDischargingPlanBallastDetailsBuilderList() {
      return getPortDischargingPlanBallastDetailsFieldBuilder().getBuilderList();
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
                .Builder,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels
                .LoadingPlanTankDetailsOrBuilder>
        getPortDischargingPlanBallastDetailsFieldBuilder() {
      if (portDischargingPlanBallastDetailsBuilder_ == null) {
        portDischargingPlanBallastDetailsBuilder_ =
            new com.google.protobuf.RepeatedFieldBuilderV3<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails,
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
                    .Builder,
                com.cpdss.common.generated.loading_plan.LoadingPlanModels
                    .LoadingPlanTankDetailsOrBuilder>(
                portDischargingPlanBallastDetails_,
                ((bitField0_ & 0x00000004) != 0),
                getParentForChildren(),
                isClean());
        portDischargingPlanBallastDetails_ = null;
      }
      return portDischargingPlanBallastDetailsBuilder_;
    }

    private java.util.List<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails>
        portDischargingPlanRobDetails_ = java.util.Collections.emptyList();

    private void ensurePortDischargingPlanRobDetailsIsMutable() {
      if (!((bitField0_ & 0x00000008) != 0)) {
        portDischargingPlanRobDetails_ =
            new java.util.ArrayList<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails>(
                portDischargingPlanRobDetails_);
        bitField0_ |= 0x00000008;
      }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
                .Builder,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels
                .LoadingPlanTankDetailsOrBuilder>
        portDischargingPlanRobDetailsBuilder_;

    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanRobDetails = 5;</code> */
    public java.util.List<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails>
        getPortDischargingPlanRobDetailsList() {
      if (portDischargingPlanRobDetailsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(portDischargingPlanRobDetails_);
      } else {
        return portDischargingPlanRobDetailsBuilder_.getMessageList();
      }
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanRobDetails = 5;</code> */
    public int getPortDischargingPlanRobDetailsCount() {
      if (portDischargingPlanRobDetailsBuilder_ == null) {
        return portDischargingPlanRobDetails_.size();
      } else {
        return portDischargingPlanRobDetailsBuilder_.getCount();
      }
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanRobDetails = 5;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
        getPortDischargingPlanRobDetails(int index) {
      if (portDischargingPlanRobDetailsBuilder_ == null) {
        return portDischargingPlanRobDetails_.get(index);
      } else {
        return portDischargingPlanRobDetailsBuilder_.getMessage(index);
      }
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanRobDetails = 5;</code> */
    public Builder setPortDischargingPlanRobDetails(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails value) {
      if (portDischargingPlanRobDetailsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensurePortDischargingPlanRobDetailsIsMutable();
        portDischargingPlanRobDetails_.set(index, value);
        onChanged();
      } else {
        portDischargingPlanRobDetailsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanRobDetails = 5;</code> */
    public Builder setPortDischargingPlanRobDetails(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails.Builder
            builderForValue) {
      if (portDischargingPlanRobDetailsBuilder_ == null) {
        ensurePortDischargingPlanRobDetailsIsMutable();
        portDischargingPlanRobDetails_.set(index, builderForValue.build());
        onChanged();
      } else {
        portDischargingPlanRobDetailsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanRobDetails = 5;</code> */
    public Builder addPortDischargingPlanRobDetails(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails value) {
      if (portDischargingPlanRobDetailsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensurePortDischargingPlanRobDetailsIsMutable();
        portDischargingPlanRobDetails_.add(value);
        onChanged();
      } else {
        portDischargingPlanRobDetailsBuilder_.addMessage(value);
      }
      return this;
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanRobDetails = 5;</code> */
    public Builder addPortDischargingPlanRobDetails(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails value) {
      if (portDischargingPlanRobDetailsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensurePortDischargingPlanRobDetailsIsMutable();
        portDischargingPlanRobDetails_.add(index, value);
        onChanged();
      } else {
        portDischargingPlanRobDetailsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanRobDetails = 5;</code> */
    public Builder addPortDischargingPlanRobDetails(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails.Builder
            builderForValue) {
      if (portDischargingPlanRobDetailsBuilder_ == null) {
        ensurePortDischargingPlanRobDetailsIsMutable();
        portDischargingPlanRobDetails_.add(builderForValue.build());
        onChanged();
      } else {
        portDischargingPlanRobDetailsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanRobDetails = 5;</code> */
    public Builder addPortDischargingPlanRobDetails(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails.Builder
            builderForValue) {
      if (portDischargingPlanRobDetailsBuilder_ == null) {
        ensurePortDischargingPlanRobDetailsIsMutable();
        portDischargingPlanRobDetails_.add(index, builderForValue.build());
        onChanged();
      } else {
        portDischargingPlanRobDetailsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanRobDetails = 5;</code> */
    public Builder addAllPortDischargingPlanRobDetails(
        java.lang.Iterable<
                ? extends
                    com.cpdss.common.generated.loading_plan.LoadingPlanModels
                        .LoadingPlanTankDetails>
            values) {
      if (portDischargingPlanRobDetailsBuilder_ == null) {
        ensurePortDischargingPlanRobDetailsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, portDischargingPlanRobDetails_);
        onChanged();
      } else {
        portDischargingPlanRobDetailsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanRobDetails = 5;</code> */
    public Builder clearPortDischargingPlanRobDetails() {
      if (portDischargingPlanRobDetailsBuilder_ == null) {
        portDischargingPlanRobDetails_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000008);
        onChanged();
      } else {
        portDischargingPlanRobDetailsBuilder_.clear();
      }
      return this;
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanRobDetails = 5;</code> */
    public Builder removePortDischargingPlanRobDetails(int index) {
      if (portDischargingPlanRobDetailsBuilder_ == null) {
        ensurePortDischargingPlanRobDetailsIsMutable();
        portDischargingPlanRobDetails_.remove(index);
        onChanged();
      } else {
        portDischargingPlanRobDetailsBuilder_.remove(index);
      }
      return this;
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanRobDetails = 5;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails.Builder
        getPortDischargingPlanRobDetailsBuilder(int index) {
      return getPortDischargingPlanRobDetailsFieldBuilder().getBuilder(index);
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanRobDetails = 5;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetailsOrBuilder
        getPortDischargingPlanRobDetailsOrBuilder(int index) {
      if (portDischargingPlanRobDetailsBuilder_ == null) {
        return portDischargingPlanRobDetails_.get(index);
      } else {
        return portDischargingPlanRobDetailsBuilder_.getMessageOrBuilder(index);
      }
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanRobDetails = 5;</code> */
    public java.util.List<
            ? extends
                com.cpdss.common.generated.loading_plan.LoadingPlanModels
                    .LoadingPlanTankDetailsOrBuilder>
        getPortDischargingPlanRobDetailsOrBuilderList() {
      if (portDischargingPlanRobDetailsBuilder_ != null) {
        return portDischargingPlanRobDetailsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(portDischargingPlanRobDetails_);
      }
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanRobDetails = 5;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails.Builder
        addPortDischargingPlanRobDetailsBuilder() {
      return getPortDischargingPlanRobDetailsFieldBuilder()
          .addBuilder(
              com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
                  .getDefaultInstance());
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanRobDetails = 5;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails.Builder
        addPortDischargingPlanRobDetailsBuilder(int index) {
      return getPortDischargingPlanRobDetailsFieldBuilder()
          .addBuilder(
              index,
              com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
                  .getDefaultInstance());
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanRobDetails = 5;</code> */
    public java.util.List<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
                .Builder>
        getPortDischargingPlanRobDetailsBuilderList() {
      return getPortDischargingPlanRobDetailsFieldBuilder().getBuilderList();
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
                .Builder,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels
                .LoadingPlanTankDetailsOrBuilder>
        getPortDischargingPlanRobDetailsFieldBuilder() {
      if (portDischargingPlanRobDetailsBuilder_ == null) {
        portDischargingPlanRobDetailsBuilder_ =
            new com.google.protobuf.RepeatedFieldBuilderV3<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails,
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
                    .Builder,
                com.cpdss.common.generated.loading_plan.LoadingPlanModels
                    .LoadingPlanTankDetailsOrBuilder>(
                portDischargingPlanRobDetails_,
                ((bitField0_ & 0x00000008) != 0),
                getParentForChildren(),
                isClean());
        portDischargingPlanRobDetails_ = null;
      }
      return portDischargingPlanRobDetailsBuilder_;
    }

    private java.util.List<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels
                .LoadingPlanStabilityParameters>
        portDischargingPlanStabilityParameters_ = java.util.Collections.emptyList();

    private void ensurePortDischargingPlanStabilityParametersIsMutable() {
      if (!((bitField0_ & 0x00000010) != 0)) {
        portDischargingPlanStabilityParameters_ =
            new java.util.ArrayList<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels
                    .LoadingPlanStabilityParameters>(portDischargingPlanStabilityParameters_);
        bitField0_ |= 0x00000010;
      }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels
                .LoadingPlanStabilityParameters,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters
                .Builder,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels
                .LoadingPlanStabilityParametersOrBuilder>
        portDischargingPlanStabilityParametersBuilder_;

    /**
     * <code>repeated .LoadingPlanStabilityParameters portDischargingPlanStabilityParameters = 6;
     * </code>
     */
    public java.util.List<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels
                .LoadingPlanStabilityParameters>
        getPortDischargingPlanStabilityParametersList() {
      if (portDischargingPlanStabilityParametersBuilder_ == null) {
        return java.util.Collections.unmodifiableList(portDischargingPlanStabilityParameters_);
      } else {
        return portDischargingPlanStabilityParametersBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .LoadingPlanStabilityParameters portDischargingPlanStabilityParameters = 6;
     * </code>
     */
    public int getPortDischargingPlanStabilityParametersCount() {
      if (portDischargingPlanStabilityParametersBuilder_ == null) {
        return portDischargingPlanStabilityParameters_.size();
      } else {
        return portDischargingPlanStabilityParametersBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .LoadingPlanStabilityParameters portDischargingPlanStabilityParameters = 6;
     * </code>
     */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters
        getPortDischargingPlanStabilityParameters(int index) {
      if (portDischargingPlanStabilityParametersBuilder_ == null) {
        return portDischargingPlanStabilityParameters_.get(index);
      } else {
        return portDischargingPlanStabilityParametersBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .LoadingPlanStabilityParameters portDischargingPlanStabilityParameters = 6;
     * </code>
     */
    public Builder setPortDischargingPlanStabilityParameters(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters
            value) {
      if (portDischargingPlanStabilityParametersBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensurePortDischargingPlanStabilityParametersIsMutable();
        portDischargingPlanStabilityParameters_.set(index, value);
        onChanged();
      } else {
        portDischargingPlanStabilityParametersBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .LoadingPlanStabilityParameters portDischargingPlanStabilityParameters = 6;
     * </code>
     */
    public Builder setPortDischargingPlanStabilityParameters(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters
                .Builder
            builderForValue) {
      if (portDischargingPlanStabilityParametersBuilder_ == null) {
        ensurePortDischargingPlanStabilityParametersIsMutable();
        portDischargingPlanStabilityParameters_.set(index, builderForValue.build());
        onChanged();
      } else {
        portDischargingPlanStabilityParametersBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .LoadingPlanStabilityParameters portDischargingPlanStabilityParameters = 6;
     * </code>
     */
    public Builder addPortDischargingPlanStabilityParameters(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters
            value) {
      if (portDischargingPlanStabilityParametersBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensurePortDischargingPlanStabilityParametersIsMutable();
        portDischargingPlanStabilityParameters_.add(value);
        onChanged();
      } else {
        portDischargingPlanStabilityParametersBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .LoadingPlanStabilityParameters portDischargingPlanStabilityParameters = 6;
     * </code>
     */
    public Builder addPortDischargingPlanStabilityParameters(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters
            value) {
      if (portDischargingPlanStabilityParametersBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensurePortDischargingPlanStabilityParametersIsMutable();
        portDischargingPlanStabilityParameters_.add(index, value);
        onChanged();
      } else {
        portDischargingPlanStabilityParametersBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .LoadingPlanStabilityParameters portDischargingPlanStabilityParameters = 6;
     * </code>
     */
    public Builder addPortDischargingPlanStabilityParameters(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters
                .Builder
            builderForValue) {
      if (portDischargingPlanStabilityParametersBuilder_ == null) {
        ensurePortDischargingPlanStabilityParametersIsMutable();
        portDischargingPlanStabilityParameters_.add(builderForValue.build());
        onChanged();
      } else {
        portDischargingPlanStabilityParametersBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .LoadingPlanStabilityParameters portDischargingPlanStabilityParameters = 6;
     * </code>
     */
    public Builder addPortDischargingPlanStabilityParameters(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters
                .Builder
            builderForValue) {
      if (portDischargingPlanStabilityParametersBuilder_ == null) {
        ensurePortDischargingPlanStabilityParametersIsMutable();
        portDischargingPlanStabilityParameters_.add(index, builderForValue.build());
        onChanged();
      } else {
        portDischargingPlanStabilityParametersBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .LoadingPlanStabilityParameters portDischargingPlanStabilityParameters = 6;
     * </code>
     */
    public Builder addAllPortDischargingPlanStabilityParameters(
        java.lang.Iterable<
                ? extends
                    com.cpdss.common.generated.loading_plan.LoadingPlanModels
                        .LoadingPlanStabilityParameters>
            values) {
      if (portDischargingPlanStabilityParametersBuilder_ == null) {
        ensurePortDischargingPlanStabilityParametersIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, portDischargingPlanStabilityParameters_);
        onChanged();
      } else {
        portDischargingPlanStabilityParametersBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .LoadingPlanStabilityParameters portDischargingPlanStabilityParameters = 6;
     * </code>
     */
    public Builder clearPortDischargingPlanStabilityParameters() {
      if (portDischargingPlanStabilityParametersBuilder_ == null) {
        portDischargingPlanStabilityParameters_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000010);
        onChanged();
      } else {
        portDischargingPlanStabilityParametersBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .LoadingPlanStabilityParameters portDischargingPlanStabilityParameters = 6;
     * </code>
     */
    public Builder removePortDischargingPlanStabilityParameters(int index) {
      if (portDischargingPlanStabilityParametersBuilder_ == null) {
        ensurePortDischargingPlanStabilityParametersIsMutable();
        portDischargingPlanStabilityParameters_.remove(index);
        onChanged();
      } else {
        portDischargingPlanStabilityParametersBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .LoadingPlanStabilityParameters portDischargingPlanStabilityParameters = 6;
     * </code>
     */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters
            .Builder
        getPortDischargingPlanStabilityParametersBuilder(int index) {
      return getPortDischargingPlanStabilityParametersFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .LoadingPlanStabilityParameters portDischargingPlanStabilityParameters = 6;
     * </code>
     */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels
            .LoadingPlanStabilityParametersOrBuilder
        getPortDischargingPlanStabilityParametersOrBuilder(int index) {
      if (portDischargingPlanStabilityParametersBuilder_ == null) {
        return portDischargingPlanStabilityParameters_.get(index);
      } else {
        return portDischargingPlanStabilityParametersBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .LoadingPlanStabilityParameters portDischargingPlanStabilityParameters = 6;
     * </code>
     */
    public java.util.List<
            ? extends
                com.cpdss.common.generated.loading_plan.LoadingPlanModels
                    .LoadingPlanStabilityParametersOrBuilder>
        getPortDischargingPlanStabilityParametersOrBuilderList() {
      if (portDischargingPlanStabilityParametersBuilder_ != null) {
        return portDischargingPlanStabilityParametersBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(portDischargingPlanStabilityParameters_);
      }
    }
    /**
     * <code>repeated .LoadingPlanStabilityParameters portDischargingPlanStabilityParameters = 6;
     * </code>
     */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters
            .Builder
        addPortDischargingPlanStabilityParametersBuilder() {
      return getPortDischargingPlanStabilityParametersFieldBuilder()
          .addBuilder(
              com.cpdss.common.generated.loading_plan.LoadingPlanModels
                  .LoadingPlanStabilityParameters.getDefaultInstance());
    }
    /**
     * <code>repeated .LoadingPlanStabilityParameters portDischargingPlanStabilityParameters = 6;
     * </code>
     */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters
            .Builder
        addPortDischargingPlanStabilityParametersBuilder(int index) {
      return getPortDischargingPlanStabilityParametersFieldBuilder()
          .addBuilder(
              index,
              com.cpdss.common.generated.loading_plan.LoadingPlanModels
                  .LoadingPlanStabilityParameters.getDefaultInstance());
    }
    /**
     * <code>repeated .LoadingPlanStabilityParameters portDischargingPlanStabilityParameters = 6;
     * </code>
     */
    public java.util.List<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters
                .Builder>
        getPortDischargingPlanStabilityParametersBuilderList() {
      return getPortDischargingPlanStabilityParametersFieldBuilder().getBuilderList();
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels
                .LoadingPlanStabilityParameters,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters
                .Builder,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels
                .LoadingPlanStabilityParametersOrBuilder>
        getPortDischargingPlanStabilityParametersFieldBuilder() {
      if (portDischargingPlanStabilityParametersBuilder_ == null) {
        portDischargingPlanStabilityParametersBuilder_ =
            new com.google.protobuf.RepeatedFieldBuilderV3<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels
                    .LoadingPlanStabilityParameters,
                com.cpdss.common.generated.loading_plan.LoadingPlanModels
                    .LoadingPlanStabilityParameters.Builder,
                com.cpdss.common.generated.loading_plan.LoadingPlanModels
                    .LoadingPlanStabilityParametersOrBuilder>(
                portDischargingPlanStabilityParameters_,
                ((bitField0_ & 0x00000010) != 0),
                getParentForChildren(),
                isClean());
        portDischargingPlanStabilityParameters_ = null;
      }
      return portDischargingPlanStabilityParametersBuilder_;
    }

    private java.util.List<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanCommingleDetails>
        portDischargingPlanCommingleDetails_ = java.util.Collections.emptyList();

    private void ensurePortDischargingPlanCommingleDetailsIsMutable() {
      if (!((bitField0_ & 0x00000020) != 0)) {
        portDischargingPlanCommingleDetails_ =
            new java.util.ArrayList<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels
                    .LoadingPlanCommingleDetails>(portDischargingPlanCommingleDetails_);
        bitField0_ |= 0x00000020;
      }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanCommingleDetails,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanCommingleDetails
                .Builder,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels
                .LoadingPlanCommingleDetailsOrBuilder>
        portDischargingPlanCommingleDetailsBuilder_;

    /**
     * <code>repeated .LoadingPlanCommingleDetails portDischargingPlanCommingleDetails = 9;</code>
     */
    public java.util.List<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanCommingleDetails>
        getPortDischargingPlanCommingleDetailsList() {
      if (portDischargingPlanCommingleDetailsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(portDischargingPlanCommingleDetails_);
      } else {
        return portDischargingPlanCommingleDetailsBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .LoadingPlanCommingleDetails portDischargingPlanCommingleDetails = 9;</code>
     */
    public int getPortDischargingPlanCommingleDetailsCount() {
      if (portDischargingPlanCommingleDetailsBuilder_ == null) {
        return portDischargingPlanCommingleDetails_.size();
      } else {
        return portDischargingPlanCommingleDetailsBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .LoadingPlanCommingleDetails portDischargingPlanCommingleDetails = 9;</code>
     */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanCommingleDetails
        getPortDischargingPlanCommingleDetails(int index) {
      if (portDischargingPlanCommingleDetailsBuilder_ == null) {
        return portDischargingPlanCommingleDetails_.get(index);
      } else {
        return portDischargingPlanCommingleDetailsBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .LoadingPlanCommingleDetails portDischargingPlanCommingleDetails = 9;</code>
     */
    public Builder setPortDischargingPlanCommingleDetails(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanCommingleDetails
            value) {
      if (portDischargingPlanCommingleDetailsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensurePortDischargingPlanCommingleDetailsIsMutable();
        portDischargingPlanCommingleDetails_.set(index, value);
        onChanged();
      } else {
        portDischargingPlanCommingleDetailsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .LoadingPlanCommingleDetails portDischargingPlanCommingleDetails = 9;</code>
     */
    public Builder setPortDischargingPlanCommingleDetails(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanCommingleDetails
                .Builder
            builderForValue) {
      if (portDischargingPlanCommingleDetailsBuilder_ == null) {
        ensurePortDischargingPlanCommingleDetailsIsMutable();
        portDischargingPlanCommingleDetails_.set(index, builderForValue.build());
        onChanged();
      } else {
        portDischargingPlanCommingleDetailsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .LoadingPlanCommingleDetails portDischargingPlanCommingleDetails = 9;</code>
     */
    public Builder addPortDischargingPlanCommingleDetails(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanCommingleDetails
            value) {
      if (portDischargingPlanCommingleDetailsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensurePortDischargingPlanCommingleDetailsIsMutable();
        portDischargingPlanCommingleDetails_.add(value);
        onChanged();
      } else {
        portDischargingPlanCommingleDetailsBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .LoadingPlanCommingleDetails portDischargingPlanCommingleDetails = 9;</code>
     */
    public Builder addPortDischargingPlanCommingleDetails(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanCommingleDetails
            value) {
      if (portDischargingPlanCommingleDetailsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensurePortDischargingPlanCommingleDetailsIsMutable();
        portDischargingPlanCommingleDetails_.add(index, value);
        onChanged();
      } else {
        portDischargingPlanCommingleDetailsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .LoadingPlanCommingleDetails portDischargingPlanCommingleDetails = 9;</code>
     */
    public Builder addPortDischargingPlanCommingleDetails(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanCommingleDetails
                .Builder
            builderForValue) {
      if (portDischargingPlanCommingleDetailsBuilder_ == null) {
        ensurePortDischargingPlanCommingleDetailsIsMutable();
        portDischargingPlanCommingleDetails_.add(builderForValue.build());
        onChanged();
      } else {
        portDischargingPlanCommingleDetailsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .LoadingPlanCommingleDetails portDischargingPlanCommingleDetails = 9;</code>
     */
    public Builder addPortDischargingPlanCommingleDetails(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanCommingleDetails
                .Builder
            builderForValue) {
      if (portDischargingPlanCommingleDetailsBuilder_ == null) {
        ensurePortDischargingPlanCommingleDetailsIsMutable();
        portDischargingPlanCommingleDetails_.add(index, builderForValue.build());
        onChanged();
      } else {
        portDischargingPlanCommingleDetailsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .LoadingPlanCommingleDetails portDischargingPlanCommingleDetails = 9;</code>
     */
    public Builder addAllPortDischargingPlanCommingleDetails(
        java.lang.Iterable<
                ? extends
                    com.cpdss.common.generated.loading_plan.LoadingPlanModels
                        .LoadingPlanCommingleDetails>
            values) {
      if (portDischargingPlanCommingleDetailsBuilder_ == null) {
        ensurePortDischargingPlanCommingleDetailsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, portDischargingPlanCommingleDetails_);
        onChanged();
      } else {
        portDischargingPlanCommingleDetailsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .LoadingPlanCommingleDetails portDischargingPlanCommingleDetails = 9;</code>
     */
    public Builder clearPortDischargingPlanCommingleDetails() {
      if (portDischargingPlanCommingleDetailsBuilder_ == null) {
        portDischargingPlanCommingleDetails_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000020);
        onChanged();
      } else {
        portDischargingPlanCommingleDetailsBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .LoadingPlanCommingleDetails portDischargingPlanCommingleDetails = 9;</code>
     */
    public Builder removePortDischargingPlanCommingleDetails(int index) {
      if (portDischargingPlanCommingleDetailsBuilder_ == null) {
        ensurePortDischargingPlanCommingleDetailsIsMutable();
        portDischargingPlanCommingleDetails_.remove(index);
        onChanged();
      } else {
        portDischargingPlanCommingleDetailsBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .LoadingPlanCommingleDetails portDischargingPlanCommingleDetails = 9;</code>
     */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanCommingleDetails
            .Builder
        getPortDischargingPlanCommingleDetailsBuilder(int index) {
      return getPortDischargingPlanCommingleDetailsFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .LoadingPlanCommingleDetails portDischargingPlanCommingleDetails = 9;</code>
     */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels
            .LoadingPlanCommingleDetailsOrBuilder
        getPortDischargingPlanCommingleDetailsOrBuilder(int index) {
      if (portDischargingPlanCommingleDetailsBuilder_ == null) {
        return portDischargingPlanCommingleDetails_.get(index);
      } else {
        return portDischargingPlanCommingleDetailsBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .LoadingPlanCommingleDetails portDischargingPlanCommingleDetails = 9;</code>
     */
    public java.util.List<
            ? extends
                com.cpdss.common.generated.loading_plan.LoadingPlanModels
                    .LoadingPlanCommingleDetailsOrBuilder>
        getPortDischargingPlanCommingleDetailsOrBuilderList() {
      if (portDischargingPlanCommingleDetailsBuilder_ != null) {
        return portDischargingPlanCommingleDetailsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(portDischargingPlanCommingleDetails_);
      }
    }
    /**
     * <code>repeated .LoadingPlanCommingleDetails portDischargingPlanCommingleDetails = 9;</code>
     */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanCommingleDetails
            .Builder
        addPortDischargingPlanCommingleDetailsBuilder() {
      return getPortDischargingPlanCommingleDetailsFieldBuilder()
          .addBuilder(
              com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanCommingleDetails
                  .getDefaultInstance());
    }
    /**
     * <code>repeated .LoadingPlanCommingleDetails portDischargingPlanCommingleDetails = 9;</code>
     */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanCommingleDetails
            .Builder
        addPortDischargingPlanCommingleDetailsBuilder(int index) {
      return getPortDischargingPlanCommingleDetailsFieldBuilder()
          .addBuilder(
              index,
              com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanCommingleDetails
                  .getDefaultInstance());
    }
    /**
     * <code>repeated .LoadingPlanCommingleDetails portDischargingPlanCommingleDetails = 9;</code>
     */
    public java.util.List<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanCommingleDetails
                .Builder>
        getPortDischargingPlanCommingleDetailsBuilderList() {
      return getPortDischargingPlanCommingleDetailsFieldBuilder().getBuilderList();
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanCommingleDetails,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanCommingleDetails
                .Builder,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels
                .LoadingPlanCommingleDetailsOrBuilder>
        getPortDischargingPlanCommingleDetailsFieldBuilder() {
      if (portDischargingPlanCommingleDetailsBuilder_ == null) {
        portDischargingPlanCommingleDetailsBuilder_ =
            new com.google.protobuf.RepeatedFieldBuilderV3<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels
                    .LoadingPlanCommingleDetails,
                com.cpdss.common.generated.loading_plan.LoadingPlanModels
                    .LoadingPlanCommingleDetails.Builder,
                com.cpdss.common.generated.loading_plan.LoadingPlanModels
                    .LoadingPlanCommingleDetailsOrBuilder>(
                portDischargingPlanCommingleDetails_,
                ((bitField0_ & 0x00000020) != 0),
                getParentForChildren(),
                isClean());
        portDischargingPlanCommingleDetails_ = null;
      }
      return portDischargingPlanCommingleDetailsBuilder_;
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

    // @@protoc_insertion_point(builder_scope:DischargingPlanReply)
  }

  // @@protoc_insertion_point(class_scope:DischargingPlanReply)
  private static final com.cpdss.common.generated.discharge_plan.DischargingPlanReply
      DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new com.cpdss.common.generated.discharge_plan.DischargingPlanReply();
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingPlanReply
      getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<DischargingPlanReply> PARSER =
      new com.google.protobuf.AbstractParser<DischargingPlanReply>() {
        @java.lang.Override
        public DischargingPlanReply parsePartialFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
          return new DischargingPlanReply(input, extensionRegistry);
        }
      };

  public static com.google.protobuf.Parser<DischargingPlanReply> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<DischargingPlanReply> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.cpdss.common.generated.discharge_plan.DischargingPlanReply
      getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
}
