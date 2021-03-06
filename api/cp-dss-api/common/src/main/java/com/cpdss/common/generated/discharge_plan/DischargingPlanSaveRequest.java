/* Licensed at AlphaOri Technologies */
package com.cpdss.common.generated.discharge_plan;

/** Protobuf type {@code DischargingPlanSaveRequest} */
public final class DischargingPlanSaveRequest extends com.google.protobuf.GeneratedMessageV3
    implements
    // @@protoc_insertion_point(message_implements:DischargingPlanSaveRequest)
    DischargingPlanSaveRequestOrBuilder {
  private static final long serialVersionUID = 0L;
  // Use DischargingPlanSaveRequest.newBuilder() to construct.
  private DischargingPlanSaveRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }

  private DischargingPlanSaveRequest() {
    processId_ = "";
    dischargingSequences_ = java.util.Collections.emptyList();
    portDischargingPlanStowageDetails_ = java.util.Collections.emptyList();
    portDischargingPlanBallastDetails_ = java.util.Collections.emptyList();
    portDischargingPlanRobDetails_ = java.util.Collections.emptyList();
    portDischargingPlanStabilityParameters_ = java.util.Collections.emptyList();
    dischargingSequenceStabilityParameters_ = java.util.Collections.emptyList();
    algoErrors_ = java.util.Collections.emptyList();
    dischargingPlanDetailsFromAlgo_ = "";
    portDischargingPlanCommingleDetails_ = java.util.Collections.emptyList();
    driveTankDetails_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
    return new DischargingPlanSaveRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }

  private DischargingPlanSaveRequest(
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
              dischargingInfoId_ = input.readInt64();
              break;
            }
          case 18:
            {
              java.lang.String s = input.readStringRequireUtf8();

              processId_ = s;
              break;
            }
          case 26:
            {
              if (!((mutable_bitField0_ & 0x00000001) != 0)) {
                dischargingSequences_ =
                    new java.util.ArrayList<
                        com.cpdss.common.generated.discharge_plan.DischargingSequence>();
                mutable_bitField0_ |= 0x00000001;
              }
              dischargingSequences_.add(
                  input.readMessage(
                      com.cpdss.common.generated.discharge_plan.DischargingSequence.parser(),
                      extensionRegistry));
              break;
            }
          case 34:
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
          case 42:
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
          case 50:
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
          case 58:
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
          case 66:
            {
              if (!((mutable_bitField0_ & 0x00000020) != 0)) {
                dischargingSequenceStabilityParameters_ =
                    new java.util.ArrayList<
                        com.cpdss.common.generated.loading_plan.LoadingPlanModels
                            .LoadingPlanStabilityParameters>();
                mutable_bitField0_ |= 0x00000020;
              }
              dischargingSequenceStabilityParameters_.add(
                  input.readMessage(
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels
                          .LoadingPlanStabilityParameters.parser(),
                      extensionRegistry));
              break;
            }
          case 74:
            {
              if (!((mutable_bitField0_ & 0x00000040) != 0)) {
                algoErrors_ =
                    new java.util.ArrayList<com.cpdss.common.generated.LoadableStudy.AlgoErrors>();
                mutable_bitField0_ |= 0x00000040;
              }
              algoErrors_.add(
                  input.readMessage(
                      com.cpdss.common.generated.LoadableStudy.AlgoErrors.parser(),
                      extensionRegistry));
              break;
            }
          case 80:
            {
              hasLoadicator_ = input.readBool();
              break;
            }
          case 90:
            {
              java.lang.String s = input.readStringRequireUtf8();

              dischargingPlanDetailsFromAlgo_ = s;
              break;
            }
          case 98:
            {
              if (!((mutable_bitField0_ & 0x00000080) != 0)) {
                portDischargingPlanCommingleDetails_ =
                    new java.util.ArrayList<
                        com.cpdss.common.generated.loading_plan.LoadingPlanModels
                            .LoadingPlanCommingleDetails>();
                mutable_bitField0_ |= 0x00000080;
              }
              portDischargingPlanCommingleDetails_.add(
                  input.readMessage(
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels
                          .LoadingPlanCommingleDetails.parser(),
                      extensionRegistry));
              break;
            }
          case 106:
            {
              if (!((mutable_bitField0_ & 0x00000100) != 0)) {
                driveTankDetails_ =
                    new java.util.ArrayList<
                        com.cpdss.common.generated.discharge_plan.DriveTankDetail>();
                mutable_bitField0_ |= 0x00000100;
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
        dischargingSequenceStabilityParameters_ =
            java.util.Collections.unmodifiableList(dischargingSequenceStabilityParameters_);
      }
      if (((mutable_bitField0_ & 0x00000040) != 0)) {
        algoErrors_ = java.util.Collections.unmodifiableList(algoErrors_);
      }
      if (((mutable_bitField0_ & 0x00000080) != 0)) {
        portDischargingPlanCommingleDetails_ =
            java.util.Collections.unmodifiableList(portDischargingPlanCommingleDetails_);
      }
      if (((mutable_bitField0_ & 0x00000100) != 0)) {
        driveTankDetails_ = java.util.Collections.unmodifiableList(driveTankDetails_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }

  public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
    return com.cpdss.common.generated.discharge_plan.DischargePlanModels
        .internal_static_DischargingPlanSaveRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.cpdss.common.generated.discharge_plan.DischargePlanModels
        .internal_static_DischargingPlanSaveRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.cpdss.common.generated.discharge_plan.DischargingPlanSaveRequest.class,
            com.cpdss.common.generated.discharge_plan.DischargingPlanSaveRequest.Builder.class);
  }

  public static final int DISCHARGINGINFOID_FIELD_NUMBER = 1;
  private long dischargingInfoId_;
  /**
   * <code>int64 dischargingInfoId = 1;</code>
   *
   * @return The dischargingInfoId.
   */
  public long getDischargingInfoId() {
    return dischargingInfoId_;
  }

  public static final int PROCESSID_FIELD_NUMBER = 2;
  private volatile java.lang.Object processId_;
  /**
   * <code>string processId = 2;</code>
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
   * <code>string processId = 2;</code>
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

  public static final int DISCHARGINGSEQUENCES_FIELD_NUMBER = 3;
  private java.util.List<com.cpdss.common.generated.discharge_plan.DischargingSequence>
      dischargingSequences_;
  /** <code>repeated .DischargingSequence dischargingSequences = 3;</code> */
  public java.util.List<com.cpdss.common.generated.discharge_plan.DischargingSequence>
      getDischargingSequencesList() {
    return dischargingSequences_;
  }
  /** <code>repeated .DischargingSequence dischargingSequences = 3;</code> */
  public java.util.List<
          ? extends com.cpdss.common.generated.discharge_plan.DischargingSequenceOrBuilder>
      getDischargingSequencesOrBuilderList() {
    return dischargingSequences_;
  }
  /** <code>repeated .DischargingSequence dischargingSequences = 3;</code> */
  public int getDischargingSequencesCount() {
    return dischargingSequences_.size();
  }
  /** <code>repeated .DischargingSequence dischargingSequences = 3;</code> */
  public com.cpdss.common.generated.discharge_plan.DischargingSequence getDischargingSequences(
      int index) {
    return dischargingSequences_.get(index);
  }
  /** <code>repeated .DischargingSequence dischargingSequences = 3;</code> */
  public com.cpdss.common.generated.discharge_plan.DischargingSequenceOrBuilder
      getDischargingSequencesOrBuilder(int index) {
    return dischargingSequences_.get(index);
  }

  public static final int PORTDISCHARGINGPLANSTOWAGEDETAILS_FIELD_NUMBER = 4;
  private java.util.List<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails>
      portDischargingPlanStowageDetails_;
  /** <code>repeated .LoadingPlanTankDetails portDischargingPlanStowageDetails = 4;</code> */
  public java.util.List<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails>
      getPortDischargingPlanStowageDetailsList() {
    return portDischargingPlanStowageDetails_;
  }
  /** <code>repeated .LoadingPlanTankDetails portDischargingPlanStowageDetails = 4;</code> */
  public java.util.List<
          ? extends
              com.cpdss.common.generated.loading_plan.LoadingPlanModels
                  .LoadingPlanTankDetailsOrBuilder>
      getPortDischargingPlanStowageDetailsOrBuilderList() {
    return portDischargingPlanStowageDetails_;
  }
  /** <code>repeated .LoadingPlanTankDetails portDischargingPlanStowageDetails = 4;</code> */
  public int getPortDischargingPlanStowageDetailsCount() {
    return portDischargingPlanStowageDetails_.size();
  }
  /** <code>repeated .LoadingPlanTankDetails portDischargingPlanStowageDetails = 4;</code> */
  public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
      getPortDischargingPlanStowageDetails(int index) {
    return portDischargingPlanStowageDetails_.get(index);
  }
  /** <code>repeated .LoadingPlanTankDetails portDischargingPlanStowageDetails = 4;</code> */
  public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetailsOrBuilder
      getPortDischargingPlanStowageDetailsOrBuilder(int index) {
    return portDischargingPlanStowageDetails_.get(index);
  }

  public static final int PORTDISCHARGINGPLANBALLASTDETAILS_FIELD_NUMBER = 5;
  private java.util.List<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails>
      portDischargingPlanBallastDetails_;
  /** <code>repeated .LoadingPlanTankDetails portDischargingPlanBallastDetails = 5;</code> */
  public java.util.List<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails>
      getPortDischargingPlanBallastDetailsList() {
    return portDischargingPlanBallastDetails_;
  }
  /** <code>repeated .LoadingPlanTankDetails portDischargingPlanBallastDetails = 5;</code> */
  public java.util.List<
          ? extends
              com.cpdss.common.generated.loading_plan.LoadingPlanModels
                  .LoadingPlanTankDetailsOrBuilder>
      getPortDischargingPlanBallastDetailsOrBuilderList() {
    return portDischargingPlanBallastDetails_;
  }
  /** <code>repeated .LoadingPlanTankDetails portDischargingPlanBallastDetails = 5;</code> */
  public int getPortDischargingPlanBallastDetailsCount() {
    return portDischargingPlanBallastDetails_.size();
  }
  /** <code>repeated .LoadingPlanTankDetails portDischargingPlanBallastDetails = 5;</code> */
  public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
      getPortDischargingPlanBallastDetails(int index) {
    return portDischargingPlanBallastDetails_.get(index);
  }
  /** <code>repeated .LoadingPlanTankDetails portDischargingPlanBallastDetails = 5;</code> */
  public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetailsOrBuilder
      getPortDischargingPlanBallastDetailsOrBuilder(int index) {
    return portDischargingPlanBallastDetails_.get(index);
  }

  public static final int PORTDISCHARGINGPLANROBDETAILS_FIELD_NUMBER = 6;
  private java.util.List<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails>
      portDischargingPlanRobDetails_;
  /** <code>repeated .LoadingPlanTankDetails portDischargingPlanRobDetails = 6;</code> */
  public java.util.List<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails>
      getPortDischargingPlanRobDetailsList() {
    return portDischargingPlanRobDetails_;
  }
  /** <code>repeated .LoadingPlanTankDetails portDischargingPlanRobDetails = 6;</code> */
  public java.util.List<
          ? extends
              com.cpdss.common.generated.loading_plan.LoadingPlanModels
                  .LoadingPlanTankDetailsOrBuilder>
      getPortDischargingPlanRobDetailsOrBuilderList() {
    return portDischargingPlanRobDetails_;
  }
  /** <code>repeated .LoadingPlanTankDetails portDischargingPlanRobDetails = 6;</code> */
  public int getPortDischargingPlanRobDetailsCount() {
    return portDischargingPlanRobDetails_.size();
  }
  /** <code>repeated .LoadingPlanTankDetails portDischargingPlanRobDetails = 6;</code> */
  public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
      getPortDischargingPlanRobDetails(int index) {
    return portDischargingPlanRobDetails_.get(index);
  }
  /** <code>repeated .LoadingPlanTankDetails portDischargingPlanRobDetails = 6;</code> */
  public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetailsOrBuilder
      getPortDischargingPlanRobDetailsOrBuilder(int index) {
    return portDischargingPlanRobDetails_.get(index);
  }

  public static final int PORTDISCHARGINGPLANSTABILITYPARAMETERS_FIELD_NUMBER = 7;
  private java.util.List<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters>
      portDischargingPlanStabilityParameters_;
  /**
   * <code>repeated .LoadingPlanStabilityParameters portDischargingPlanStabilityParameters = 7;
   * </code>
   */
  public java.util.List<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters>
      getPortDischargingPlanStabilityParametersList() {
    return portDischargingPlanStabilityParameters_;
  }
  /**
   * <code>repeated .LoadingPlanStabilityParameters portDischargingPlanStabilityParameters = 7;
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
   * <code>repeated .LoadingPlanStabilityParameters portDischargingPlanStabilityParameters = 7;
   * </code>
   */
  public int getPortDischargingPlanStabilityParametersCount() {
    return portDischargingPlanStabilityParameters_.size();
  }
  /**
   * <code>repeated .LoadingPlanStabilityParameters portDischargingPlanStabilityParameters = 7;
   * </code>
   */
  public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters
      getPortDischargingPlanStabilityParameters(int index) {
    return portDischargingPlanStabilityParameters_.get(index);
  }
  /**
   * <code>repeated .LoadingPlanStabilityParameters portDischargingPlanStabilityParameters = 7;
   * </code>
   */
  public com.cpdss.common.generated.loading_plan.LoadingPlanModels
          .LoadingPlanStabilityParametersOrBuilder
      getPortDischargingPlanStabilityParametersOrBuilder(int index) {
    return portDischargingPlanStabilityParameters_.get(index);
  }

  public static final int DISCHARGINGSEQUENCESTABILITYPARAMETERS_FIELD_NUMBER = 8;
  private java.util.List<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters>
      dischargingSequenceStabilityParameters_;
  /**
   * <code>repeated .LoadingPlanStabilityParameters dischargingSequenceStabilityParameters = 8;
   * </code>
   */
  public java.util.List<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters>
      getDischargingSequenceStabilityParametersList() {
    return dischargingSequenceStabilityParameters_;
  }
  /**
   * <code>repeated .LoadingPlanStabilityParameters dischargingSequenceStabilityParameters = 8;
   * </code>
   */
  public java.util.List<
          ? extends
              com.cpdss.common.generated.loading_plan.LoadingPlanModels
                  .LoadingPlanStabilityParametersOrBuilder>
      getDischargingSequenceStabilityParametersOrBuilderList() {
    return dischargingSequenceStabilityParameters_;
  }
  /**
   * <code>repeated .LoadingPlanStabilityParameters dischargingSequenceStabilityParameters = 8;
   * </code>
   */
  public int getDischargingSequenceStabilityParametersCount() {
    return dischargingSequenceStabilityParameters_.size();
  }
  /**
   * <code>repeated .LoadingPlanStabilityParameters dischargingSequenceStabilityParameters = 8;
   * </code>
   */
  public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters
      getDischargingSequenceStabilityParameters(int index) {
    return dischargingSequenceStabilityParameters_.get(index);
  }
  /**
   * <code>repeated .LoadingPlanStabilityParameters dischargingSequenceStabilityParameters = 8;
   * </code>
   */
  public com.cpdss.common.generated.loading_plan.LoadingPlanModels
          .LoadingPlanStabilityParametersOrBuilder
      getDischargingSequenceStabilityParametersOrBuilder(int index) {
    return dischargingSequenceStabilityParameters_.get(index);
  }

  public static final int ALGOERRORS_FIELD_NUMBER = 9;
  private java.util.List<com.cpdss.common.generated.LoadableStudy.AlgoErrors> algoErrors_;
  /** <code>repeated .AlgoErrors algoErrors = 9;</code> */
  public java.util.List<com.cpdss.common.generated.LoadableStudy.AlgoErrors> getAlgoErrorsList() {
    return algoErrors_;
  }
  /** <code>repeated .AlgoErrors algoErrors = 9;</code> */
  public java.util.List<? extends com.cpdss.common.generated.LoadableStudy.AlgoErrorsOrBuilder>
      getAlgoErrorsOrBuilderList() {
    return algoErrors_;
  }
  /** <code>repeated .AlgoErrors algoErrors = 9;</code> */
  public int getAlgoErrorsCount() {
    return algoErrors_.size();
  }
  /** <code>repeated .AlgoErrors algoErrors = 9;</code> */
  public com.cpdss.common.generated.LoadableStudy.AlgoErrors getAlgoErrors(int index) {
    return algoErrors_.get(index);
  }
  /** <code>repeated .AlgoErrors algoErrors = 9;</code> */
  public com.cpdss.common.generated.LoadableStudy.AlgoErrorsOrBuilder getAlgoErrorsOrBuilder(
      int index) {
    return algoErrors_.get(index);
  }

  public static final int HASLOADICATOR_FIELD_NUMBER = 10;
  private boolean hasLoadicator_;
  /**
   * <code>bool hasLoadicator = 10;</code>
   *
   * @return The hasLoadicator.
   */
  public boolean getHasLoadicator() {
    return hasLoadicator_;
  }

  public static final int DISCHARGINGPLANDETAILSFROMALGO_FIELD_NUMBER = 11;
  private volatile java.lang.Object dischargingPlanDetailsFromAlgo_;
  /**
   * <code>string dischargingPlanDetailsFromAlgo = 11;</code>
   *
   * @return The dischargingPlanDetailsFromAlgo.
   */
  public java.lang.String getDischargingPlanDetailsFromAlgo() {
    java.lang.Object ref = dischargingPlanDetailsFromAlgo_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      dischargingPlanDetailsFromAlgo_ = s;
      return s;
    }
  }
  /**
   * <code>string dischargingPlanDetailsFromAlgo = 11;</code>
   *
   * @return The bytes for dischargingPlanDetailsFromAlgo.
   */
  public com.google.protobuf.ByteString getDischargingPlanDetailsFromAlgoBytes() {
    java.lang.Object ref = dischargingPlanDetailsFromAlgo_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
      dischargingPlanDetailsFromAlgo_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int PORTDISCHARGINGPLANCOMMINGLEDETAILS_FIELD_NUMBER = 12;
  private java.util.List<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanCommingleDetails>
      portDischargingPlanCommingleDetails_;
  /**
   * <code>repeated .LoadingPlanCommingleDetails portDischargingPlanCommingleDetails = 12;</code>
   */
  public java.util.List<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanCommingleDetails>
      getPortDischargingPlanCommingleDetailsList() {
    return portDischargingPlanCommingleDetails_;
  }
  /**
   * <code>repeated .LoadingPlanCommingleDetails portDischargingPlanCommingleDetails = 12;</code>
   */
  public java.util.List<
          ? extends
              com.cpdss.common.generated.loading_plan.LoadingPlanModels
                  .LoadingPlanCommingleDetailsOrBuilder>
      getPortDischargingPlanCommingleDetailsOrBuilderList() {
    return portDischargingPlanCommingleDetails_;
  }
  /**
   * <code>repeated .LoadingPlanCommingleDetails portDischargingPlanCommingleDetails = 12;</code>
   */
  public int getPortDischargingPlanCommingleDetailsCount() {
    return portDischargingPlanCommingleDetails_.size();
  }
  /**
   * <code>repeated .LoadingPlanCommingleDetails portDischargingPlanCommingleDetails = 12;</code>
   */
  public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanCommingleDetails
      getPortDischargingPlanCommingleDetails(int index) {
    return portDischargingPlanCommingleDetails_.get(index);
  }
  /**
   * <code>repeated .LoadingPlanCommingleDetails portDischargingPlanCommingleDetails = 12;</code>
   */
  public com.cpdss.common.generated.loading_plan.LoadingPlanModels
          .LoadingPlanCommingleDetailsOrBuilder
      getPortDischargingPlanCommingleDetailsOrBuilder(int index) {
    return portDischargingPlanCommingleDetails_.get(index);
  }

  public static final int DRIVETANKDETAILS_FIELD_NUMBER = 13;
  private java.util.List<com.cpdss.common.generated.discharge_plan.DriveTankDetail>
      driveTankDetails_;
  /** <code>repeated .DriveTankDetail driveTankDetails = 13;</code> */
  public java.util.List<com.cpdss.common.generated.discharge_plan.DriveTankDetail>
      getDriveTankDetailsList() {
    return driveTankDetails_;
  }
  /** <code>repeated .DriveTankDetail driveTankDetails = 13;</code> */
  public java.util.List<
          ? extends com.cpdss.common.generated.discharge_plan.DriveTankDetailOrBuilder>
      getDriveTankDetailsOrBuilderList() {
    return driveTankDetails_;
  }
  /** <code>repeated .DriveTankDetail driveTankDetails = 13;</code> */
  public int getDriveTankDetailsCount() {
    return driveTankDetails_.size();
  }
  /** <code>repeated .DriveTankDetail driveTankDetails = 13;</code> */
  public com.cpdss.common.generated.discharge_plan.DriveTankDetail getDriveTankDetails(int index) {
    return driveTankDetails_.get(index);
  }
  /** <code>repeated .DriveTankDetail driveTankDetails = 13;</code> */
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
    if (dischargingInfoId_ != 0L) {
      output.writeInt64(1, dischargingInfoId_);
    }
    if (!getProcessIdBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, processId_);
    }
    for (int i = 0; i < dischargingSequences_.size(); i++) {
      output.writeMessage(3, dischargingSequences_.get(i));
    }
    for (int i = 0; i < portDischargingPlanStowageDetails_.size(); i++) {
      output.writeMessage(4, portDischargingPlanStowageDetails_.get(i));
    }
    for (int i = 0; i < portDischargingPlanBallastDetails_.size(); i++) {
      output.writeMessage(5, portDischargingPlanBallastDetails_.get(i));
    }
    for (int i = 0; i < portDischargingPlanRobDetails_.size(); i++) {
      output.writeMessage(6, portDischargingPlanRobDetails_.get(i));
    }
    for (int i = 0; i < portDischargingPlanStabilityParameters_.size(); i++) {
      output.writeMessage(7, portDischargingPlanStabilityParameters_.get(i));
    }
    for (int i = 0; i < dischargingSequenceStabilityParameters_.size(); i++) {
      output.writeMessage(8, dischargingSequenceStabilityParameters_.get(i));
    }
    for (int i = 0; i < algoErrors_.size(); i++) {
      output.writeMessage(9, algoErrors_.get(i));
    }
    if (hasLoadicator_ != false) {
      output.writeBool(10, hasLoadicator_);
    }
    if (!getDischargingPlanDetailsFromAlgoBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(
          output, 11, dischargingPlanDetailsFromAlgo_);
    }
    for (int i = 0; i < portDischargingPlanCommingleDetails_.size(); i++) {
      output.writeMessage(12, portDischargingPlanCommingleDetails_.get(i));
    }
    for (int i = 0; i < driveTankDetails_.size(); i++) {
      output.writeMessage(13, driveTankDetails_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (dischargingInfoId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream.computeInt64Size(1, dischargingInfoId_);
    }
    if (!getProcessIdBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, processId_);
    }
    for (int i = 0; i < dischargingSequences_.size(); i++) {
      size +=
          com.google.protobuf.CodedOutputStream.computeMessageSize(3, dischargingSequences_.get(i));
    }
    for (int i = 0; i < portDischargingPlanStowageDetails_.size(); i++) {
      size +=
          com.google.protobuf.CodedOutputStream.computeMessageSize(
              4, portDischargingPlanStowageDetails_.get(i));
    }
    for (int i = 0; i < portDischargingPlanBallastDetails_.size(); i++) {
      size +=
          com.google.protobuf.CodedOutputStream.computeMessageSize(
              5, portDischargingPlanBallastDetails_.get(i));
    }
    for (int i = 0; i < portDischargingPlanRobDetails_.size(); i++) {
      size +=
          com.google.protobuf.CodedOutputStream.computeMessageSize(
              6, portDischargingPlanRobDetails_.get(i));
    }
    for (int i = 0; i < portDischargingPlanStabilityParameters_.size(); i++) {
      size +=
          com.google.protobuf.CodedOutputStream.computeMessageSize(
              7, portDischargingPlanStabilityParameters_.get(i));
    }
    for (int i = 0; i < dischargingSequenceStabilityParameters_.size(); i++) {
      size +=
          com.google.protobuf.CodedOutputStream.computeMessageSize(
              8, dischargingSequenceStabilityParameters_.get(i));
    }
    for (int i = 0; i < algoErrors_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream.computeMessageSize(9, algoErrors_.get(i));
    }
    if (hasLoadicator_ != false) {
      size += com.google.protobuf.CodedOutputStream.computeBoolSize(10, hasLoadicator_);
    }
    if (!getDischargingPlanDetailsFromAlgoBytes().isEmpty()) {
      size +=
          com.google.protobuf.GeneratedMessageV3.computeStringSize(
              11, dischargingPlanDetailsFromAlgo_);
    }
    for (int i = 0; i < portDischargingPlanCommingleDetails_.size(); i++) {
      size +=
          com.google.protobuf.CodedOutputStream.computeMessageSize(
              12, portDischargingPlanCommingleDetails_.get(i));
    }
    for (int i = 0; i < driveTankDetails_.size(); i++) {
      size +=
          com.google.protobuf.CodedOutputStream.computeMessageSize(13, driveTankDetails_.get(i));
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
    if (!(obj instanceof com.cpdss.common.generated.discharge_plan.DischargingPlanSaveRequest)) {
      return super.equals(obj);
    }
    com.cpdss.common.generated.discharge_plan.DischargingPlanSaveRequest other =
        (com.cpdss.common.generated.discharge_plan.DischargingPlanSaveRequest) obj;

    if (getDischargingInfoId() != other.getDischargingInfoId()) return false;
    if (!getProcessId().equals(other.getProcessId())) return false;
    if (!getDischargingSequencesList().equals(other.getDischargingSequencesList())) return false;
    if (!getPortDischargingPlanStowageDetailsList()
        .equals(other.getPortDischargingPlanStowageDetailsList())) return false;
    if (!getPortDischargingPlanBallastDetailsList()
        .equals(other.getPortDischargingPlanBallastDetailsList())) return false;
    if (!getPortDischargingPlanRobDetailsList()
        .equals(other.getPortDischargingPlanRobDetailsList())) return false;
    if (!getPortDischargingPlanStabilityParametersList()
        .equals(other.getPortDischargingPlanStabilityParametersList())) return false;
    if (!getDischargingSequenceStabilityParametersList()
        .equals(other.getDischargingSequenceStabilityParametersList())) return false;
    if (!getAlgoErrorsList().equals(other.getAlgoErrorsList())) return false;
    if (getHasLoadicator() != other.getHasLoadicator()) return false;
    if (!getDischargingPlanDetailsFromAlgo().equals(other.getDischargingPlanDetailsFromAlgo()))
      return false;
    if (!getPortDischargingPlanCommingleDetailsList()
        .equals(other.getPortDischargingPlanCommingleDetailsList())) return false;
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
    hash = (37 * hash) + DISCHARGINGINFOID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getDischargingInfoId());
    hash = (37 * hash) + PROCESSID_FIELD_NUMBER;
    hash = (53 * hash) + getProcessId().hashCode();
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
    if (getDischargingSequenceStabilityParametersCount() > 0) {
      hash = (37 * hash) + DISCHARGINGSEQUENCESTABILITYPARAMETERS_FIELD_NUMBER;
      hash = (53 * hash) + getDischargingSequenceStabilityParametersList().hashCode();
    }
    if (getAlgoErrorsCount() > 0) {
      hash = (37 * hash) + ALGOERRORS_FIELD_NUMBER;
      hash = (53 * hash) + getAlgoErrorsList().hashCode();
    }
    hash = (37 * hash) + HASLOADICATOR_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(getHasLoadicator());
    hash = (37 * hash) + DISCHARGINGPLANDETAILSFROMALGO_FIELD_NUMBER;
    hash = (53 * hash) + getDischargingPlanDetailsFromAlgo().hashCode();
    if (getPortDischargingPlanCommingleDetailsCount() > 0) {
      hash = (37 * hash) + PORTDISCHARGINGPLANCOMMINGLEDETAILS_FIELD_NUMBER;
      hash = (53 * hash) + getPortDischargingPlanCommingleDetailsList().hashCode();
    }
    if (getDriveTankDetailsCount() > 0) {
      hash = (37 * hash) + DRIVETANKDETAILS_FIELD_NUMBER;
      hash = (53 * hash) + getDriveTankDetailsList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingPlanSaveRequest parseFrom(
      java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingPlanSaveRequest parseFrom(
      java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingPlanSaveRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingPlanSaveRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingPlanSaveRequest parseFrom(
      byte[] data) throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingPlanSaveRequest parseFrom(
      byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingPlanSaveRequest parseFrom(
      java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingPlanSaveRequest parseFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingPlanSaveRequest
      parseDelimitedFrom(java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingPlanSaveRequest
      parseDelimitedFrom(
          java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingPlanSaveRequest parseFrom(
      com.google.protobuf.CodedInputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingPlanSaveRequest parseFrom(
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
      com.cpdss.common.generated.discharge_plan.DischargingPlanSaveRequest prototype) {
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
  /** Protobuf type {@code DischargingPlanSaveRequest} */
  public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
      implements
      // @@protoc_insertion_point(builder_implements:DischargingPlanSaveRequest)
      com.cpdss.common.generated.discharge_plan.DischargingPlanSaveRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanModels
          .internal_static_DischargingPlanSaveRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanModels
          .internal_static_DischargingPlanSaveRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.discharge_plan.DischargingPlanSaveRequest.class,
              com.cpdss.common.generated.discharge_plan.DischargingPlanSaveRequest.Builder.class);
    }

    // Construct using
    // com.cpdss.common.generated.discharge_plan.DischargingPlanSaveRequest.newBuilder()
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
        getDischargingSequenceStabilityParametersFieldBuilder();
        getAlgoErrorsFieldBuilder();
        getPortDischargingPlanCommingleDetailsFieldBuilder();
        getDriveTankDetailsFieldBuilder();
      }
    }

    @java.lang.Override
    public Builder clear() {
      super.clear();
      dischargingInfoId_ = 0L;

      processId_ = "";

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
      if (dischargingSequenceStabilityParametersBuilder_ == null) {
        dischargingSequenceStabilityParameters_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000020);
      } else {
        dischargingSequenceStabilityParametersBuilder_.clear();
      }
      if (algoErrorsBuilder_ == null) {
        algoErrors_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000040);
      } else {
        algoErrorsBuilder_.clear();
      }
      hasLoadicator_ = false;

      dischargingPlanDetailsFromAlgo_ = "";

      if (portDischargingPlanCommingleDetailsBuilder_ == null) {
        portDischargingPlanCommingleDetails_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000080);
      } else {
        portDischargingPlanCommingleDetailsBuilder_.clear();
      }
      if (driveTankDetailsBuilder_ == null) {
        driveTankDetails_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000100);
      } else {
        driveTankDetailsBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanModels
          .internal_static_DischargingPlanSaveRequest_descriptor;
    }

    @java.lang.Override
    public com.cpdss.common.generated.discharge_plan.DischargingPlanSaveRequest
        getDefaultInstanceForType() {
      return com.cpdss.common.generated.discharge_plan.DischargingPlanSaveRequest
          .getDefaultInstance();
    }

    @java.lang.Override
    public com.cpdss.common.generated.discharge_plan.DischargingPlanSaveRequest build() {
      com.cpdss.common.generated.discharge_plan.DischargingPlanSaveRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.cpdss.common.generated.discharge_plan.DischargingPlanSaveRequest buildPartial() {
      com.cpdss.common.generated.discharge_plan.DischargingPlanSaveRequest result =
          new com.cpdss.common.generated.discharge_plan.DischargingPlanSaveRequest(this);
      int from_bitField0_ = bitField0_;
      result.dischargingInfoId_ = dischargingInfoId_;
      result.processId_ = processId_;
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
      if (dischargingSequenceStabilityParametersBuilder_ == null) {
        if (((bitField0_ & 0x00000020) != 0)) {
          dischargingSequenceStabilityParameters_ =
              java.util.Collections.unmodifiableList(dischargingSequenceStabilityParameters_);
          bitField0_ = (bitField0_ & ~0x00000020);
        }
        result.dischargingSequenceStabilityParameters_ = dischargingSequenceStabilityParameters_;
      } else {
        result.dischargingSequenceStabilityParameters_ =
            dischargingSequenceStabilityParametersBuilder_.build();
      }
      if (algoErrorsBuilder_ == null) {
        if (((bitField0_ & 0x00000040) != 0)) {
          algoErrors_ = java.util.Collections.unmodifiableList(algoErrors_);
          bitField0_ = (bitField0_ & ~0x00000040);
        }
        result.algoErrors_ = algoErrors_;
      } else {
        result.algoErrors_ = algoErrorsBuilder_.build();
      }
      result.hasLoadicator_ = hasLoadicator_;
      result.dischargingPlanDetailsFromAlgo_ = dischargingPlanDetailsFromAlgo_;
      if (portDischargingPlanCommingleDetailsBuilder_ == null) {
        if (((bitField0_ & 0x00000080) != 0)) {
          portDischargingPlanCommingleDetails_ =
              java.util.Collections.unmodifiableList(portDischargingPlanCommingleDetails_);
          bitField0_ = (bitField0_ & ~0x00000080);
        }
        result.portDischargingPlanCommingleDetails_ = portDischargingPlanCommingleDetails_;
      } else {
        result.portDischargingPlanCommingleDetails_ =
            portDischargingPlanCommingleDetailsBuilder_.build();
      }
      if (driveTankDetailsBuilder_ == null) {
        if (((bitField0_ & 0x00000100) != 0)) {
          driveTankDetails_ = java.util.Collections.unmodifiableList(driveTankDetails_);
          bitField0_ = (bitField0_ & ~0x00000100);
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
      if (other instanceof com.cpdss.common.generated.discharge_plan.DischargingPlanSaveRequest) {
        return mergeFrom(
            (com.cpdss.common.generated.discharge_plan.DischargingPlanSaveRequest) other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(
        com.cpdss.common.generated.discharge_plan.DischargingPlanSaveRequest other) {
      if (other
          == com.cpdss.common.generated.discharge_plan.DischargingPlanSaveRequest
              .getDefaultInstance()) return this;
      if (other.getDischargingInfoId() != 0L) {
        setDischargingInfoId(other.getDischargingInfoId());
      }
      if (!other.getProcessId().isEmpty()) {
        processId_ = other.processId_;
        onChanged();
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
      if (dischargingSequenceStabilityParametersBuilder_ == null) {
        if (!other.dischargingSequenceStabilityParameters_.isEmpty()) {
          if (dischargingSequenceStabilityParameters_.isEmpty()) {
            dischargingSequenceStabilityParameters_ = other.dischargingSequenceStabilityParameters_;
            bitField0_ = (bitField0_ & ~0x00000020);
          } else {
            ensureDischargingSequenceStabilityParametersIsMutable();
            dischargingSequenceStabilityParameters_.addAll(
                other.dischargingSequenceStabilityParameters_);
          }
          onChanged();
        }
      } else {
        if (!other.dischargingSequenceStabilityParameters_.isEmpty()) {
          if (dischargingSequenceStabilityParametersBuilder_.isEmpty()) {
            dischargingSequenceStabilityParametersBuilder_.dispose();
            dischargingSequenceStabilityParametersBuilder_ = null;
            dischargingSequenceStabilityParameters_ = other.dischargingSequenceStabilityParameters_;
            bitField0_ = (bitField0_ & ~0x00000020);
            dischargingSequenceStabilityParametersBuilder_ =
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
                    ? getDischargingSequenceStabilityParametersFieldBuilder()
                    : null;
          } else {
            dischargingSequenceStabilityParametersBuilder_.addAllMessages(
                other.dischargingSequenceStabilityParameters_);
          }
        }
      }
      if (algoErrorsBuilder_ == null) {
        if (!other.algoErrors_.isEmpty()) {
          if (algoErrors_.isEmpty()) {
            algoErrors_ = other.algoErrors_;
            bitField0_ = (bitField0_ & ~0x00000040);
          } else {
            ensureAlgoErrorsIsMutable();
            algoErrors_.addAll(other.algoErrors_);
          }
          onChanged();
        }
      } else {
        if (!other.algoErrors_.isEmpty()) {
          if (algoErrorsBuilder_.isEmpty()) {
            algoErrorsBuilder_.dispose();
            algoErrorsBuilder_ = null;
            algoErrors_ = other.algoErrors_;
            bitField0_ = (bitField0_ & ~0x00000040);
            algoErrorsBuilder_ =
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
                    ? getAlgoErrorsFieldBuilder()
                    : null;
          } else {
            algoErrorsBuilder_.addAllMessages(other.algoErrors_);
          }
        }
      }
      if (other.getHasLoadicator() != false) {
        setHasLoadicator(other.getHasLoadicator());
      }
      if (!other.getDischargingPlanDetailsFromAlgo().isEmpty()) {
        dischargingPlanDetailsFromAlgo_ = other.dischargingPlanDetailsFromAlgo_;
        onChanged();
      }
      if (portDischargingPlanCommingleDetailsBuilder_ == null) {
        if (!other.portDischargingPlanCommingleDetails_.isEmpty()) {
          if (portDischargingPlanCommingleDetails_.isEmpty()) {
            portDischargingPlanCommingleDetails_ = other.portDischargingPlanCommingleDetails_;
            bitField0_ = (bitField0_ & ~0x00000080);
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
            bitField0_ = (bitField0_ & ~0x00000080);
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
      if (driveTankDetailsBuilder_ == null) {
        if (!other.driveTankDetails_.isEmpty()) {
          if (driveTankDetails_.isEmpty()) {
            driveTankDetails_ = other.driveTankDetails_;
            bitField0_ = (bitField0_ & ~0x00000100);
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
            bitField0_ = (bitField0_ & ~0x00000100);
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
      com.cpdss.common.generated.discharge_plan.DischargingPlanSaveRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage =
            (com.cpdss.common.generated.discharge_plan.DischargingPlanSaveRequest)
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

    private long dischargingInfoId_;
    /**
     * <code>int64 dischargingInfoId = 1;</code>
     *
     * @return The dischargingInfoId.
     */
    public long getDischargingInfoId() {
      return dischargingInfoId_;
    }
    /**
     * <code>int64 dischargingInfoId = 1;</code>
     *
     * @param value The dischargingInfoId to set.
     * @return This builder for chaining.
     */
    public Builder setDischargingInfoId(long value) {

      dischargingInfoId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 dischargingInfoId = 1;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearDischargingInfoId() {

      dischargingInfoId_ = 0L;
      onChanged();
      return this;
    }

    private java.lang.Object processId_ = "";
    /**
     * <code>string processId = 2;</code>
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
     * <code>string processId = 2;</code>
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
     * <code>string processId = 2;</code>
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
     * <code>string processId = 2;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearProcessId() {

      processId_ = getDefaultInstance().getProcessId();
      onChanged();
      return this;
    }
    /**
     * <code>string processId = 2;</code>
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

    private java.util.List<com.cpdss.common.generated.discharge_plan.DischargingSequence>
        dischargingSequences_ = java.util.Collections.emptyList();

    private void ensureDischargingSequencesIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        dischargingSequences_ =
            new java.util.ArrayList<com.cpdss.common.generated.discharge_plan.DischargingSequence>(
                dischargingSequences_);
        bitField0_ |= 0x00000001;
      }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.discharge_plan.DischargingSequence,
            com.cpdss.common.generated.discharge_plan.DischargingSequence.Builder,
            com.cpdss.common.generated.discharge_plan.DischargingSequenceOrBuilder>
        dischargingSequencesBuilder_;

    /** <code>repeated .DischargingSequence dischargingSequences = 3;</code> */
    public java.util.List<com.cpdss.common.generated.discharge_plan.DischargingSequence>
        getDischargingSequencesList() {
      if (dischargingSequencesBuilder_ == null) {
        return java.util.Collections.unmodifiableList(dischargingSequences_);
      } else {
        return dischargingSequencesBuilder_.getMessageList();
      }
    }
    /** <code>repeated .DischargingSequence dischargingSequences = 3;</code> */
    public int getDischargingSequencesCount() {
      if (dischargingSequencesBuilder_ == null) {
        return dischargingSequences_.size();
      } else {
        return dischargingSequencesBuilder_.getCount();
      }
    }
    /** <code>repeated .DischargingSequence dischargingSequences = 3;</code> */
    public com.cpdss.common.generated.discharge_plan.DischargingSequence getDischargingSequences(
        int index) {
      if (dischargingSequencesBuilder_ == null) {
        return dischargingSequences_.get(index);
      } else {
        return dischargingSequencesBuilder_.getMessage(index);
      }
    }
    /** <code>repeated .DischargingSequence dischargingSequences = 3;</code> */
    public Builder setDischargingSequences(
        int index, com.cpdss.common.generated.discharge_plan.DischargingSequence value) {
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
    /** <code>repeated .DischargingSequence dischargingSequences = 3;</code> */
    public Builder setDischargingSequences(
        int index,
        com.cpdss.common.generated.discharge_plan.DischargingSequence.Builder builderForValue) {
      if (dischargingSequencesBuilder_ == null) {
        ensureDischargingSequencesIsMutable();
        dischargingSequences_.set(index, builderForValue.build());
        onChanged();
      } else {
        dischargingSequencesBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .DischargingSequence dischargingSequences = 3;</code> */
    public Builder addDischargingSequences(
        com.cpdss.common.generated.discharge_plan.DischargingSequence value) {
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
    /** <code>repeated .DischargingSequence dischargingSequences = 3;</code> */
    public Builder addDischargingSequences(
        int index, com.cpdss.common.generated.discharge_plan.DischargingSequence value) {
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
    /** <code>repeated .DischargingSequence dischargingSequences = 3;</code> */
    public Builder addDischargingSequences(
        com.cpdss.common.generated.discharge_plan.DischargingSequence.Builder builderForValue) {
      if (dischargingSequencesBuilder_ == null) {
        ensureDischargingSequencesIsMutable();
        dischargingSequences_.add(builderForValue.build());
        onChanged();
      } else {
        dischargingSequencesBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .DischargingSequence dischargingSequences = 3;</code> */
    public Builder addDischargingSequences(
        int index,
        com.cpdss.common.generated.discharge_plan.DischargingSequence.Builder builderForValue) {
      if (dischargingSequencesBuilder_ == null) {
        ensureDischargingSequencesIsMutable();
        dischargingSequences_.add(index, builderForValue.build());
        onChanged();
      } else {
        dischargingSequencesBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .DischargingSequence dischargingSequences = 3;</code> */
    public Builder addAllDischargingSequences(
        java.lang.Iterable<? extends com.cpdss.common.generated.discharge_plan.DischargingSequence>
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
    /** <code>repeated .DischargingSequence dischargingSequences = 3;</code> */
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
    /** <code>repeated .DischargingSequence dischargingSequences = 3;</code> */
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
    /** <code>repeated .DischargingSequence dischargingSequences = 3;</code> */
    public com.cpdss.common.generated.discharge_plan.DischargingSequence.Builder
        getDischargingSequencesBuilder(int index) {
      return getDischargingSequencesFieldBuilder().getBuilder(index);
    }
    /** <code>repeated .DischargingSequence dischargingSequences = 3;</code> */
    public com.cpdss.common.generated.discharge_plan.DischargingSequenceOrBuilder
        getDischargingSequencesOrBuilder(int index) {
      if (dischargingSequencesBuilder_ == null) {
        return dischargingSequences_.get(index);
      } else {
        return dischargingSequencesBuilder_.getMessageOrBuilder(index);
      }
    }
    /** <code>repeated .DischargingSequence dischargingSequences = 3;</code> */
    public java.util.List<
            ? extends com.cpdss.common.generated.discharge_plan.DischargingSequenceOrBuilder>
        getDischargingSequencesOrBuilderList() {
      if (dischargingSequencesBuilder_ != null) {
        return dischargingSequencesBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(dischargingSequences_);
      }
    }
    /** <code>repeated .DischargingSequence dischargingSequences = 3;</code> */
    public com.cpdss.common.generated.discharge_plan.DischargingSequence.Builder
        addDischargingSequencesBuilder() {
      return getDischargingSequencesFieldBuilder()
          .addBuilder(
              com.cpdss.common.generated.discharge_plan.DischargingSequence.getDefaultInstance());
    }
    /** <code>repeated .DischargingSequence dischargingSequences = 3;</code> */
    public com.cpdss.common.generated.discharge_plan.DischargingSequence.Builder
        addDischargingSequencesBuilder(int index) {
      return getDischargingSequencesFieldBuilder()
          .addBuilder(
              index,
              com.cpdss.common.generated.discharge_plan.DischargingSequence.getDefaultInstance());
    }
    /** <code>repeated .DischargingSequence dischargingSequences = 3;</code> */
    public java.util.List<com.cpdss.common.generated.discharge_plan.DischargingSequence.Builder>
        getDischargingSequencesBuilderList() {
      return getDischargingSequencesFieldBuilder().getBuilderList();
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.discharge_plan.DischargingSequence,
            com.cpdss.common.generated.discharge_plan.DischargingSequence.Builder,
            com.cpdss.common.generated.discharge_plan.DischargingSequenceOrBuilder>
        getDischargingSequencesFieldBuilder() {
      if (dischargingSequencesBuilder_ == null) {
        dischargingSequencesBuilder_ =
            new com.google.protobuf.RepeatedFieldBuilderV3<
                com.cpdss.common.generated.discharge_plan.DischargingSequence,
                com.cpdss.common.generated.discharge_plan.DischargingSequence.Builder,
                com.cpdss.common.generated.discharge_plan.DischargingSequenceOrBuilder>(
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

    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanStowageDetails = 4;</code> */
    public java.util.List<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails>
        getPortDischargingPlanStowageDetailsList() {
      if (portDischargingPlanStowageDetailsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(portDischargingPlanStowageDetails_);
      } else {
        return portDischargingPlanStowageDetailsBuilder_.getMessageList();
      }
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanStowageDetails = 4;</code> */
    public int getPortDischargingPlanStowageDetailsCount() {
      if (portDischargingPlanStowageDetailsBuilder_ == null) {
        return portDischargingPlanStowageDetails_.size();
      } else {
        return portDischargingPlanStowageDetailsBuilder_.getCount();
      }
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanStowageDetails = 4;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
        getPortDischargingPlanStowageDetails(int index) {
      if (portDischargingPlanStowageDetailsBuilder_ == null) {
        return portDischargingPlanStowageDetails_.get(index);
      } else {
        return portDischargingPlanStowageDetailsBuilder_.getMessage(index);
      }
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanStowageDetails = 4;</code> */
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
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanStowageDetails = 4;</code> */
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
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanStowageDetails = 4;</code> */
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
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanStowageDetails = 4;</code> */
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
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanStowageDetails = 4;</code> */
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
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanStowageDetails = 4;</code> */
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
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanStowageDetails = 4;</code> */
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
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanStowageDetails = 4;</code> */
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
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanStowageDetails = 4;</code> */
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
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanStowageDetails = 4;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails.Builder
        getPortDischargingPlanStowageDetailsBuilder(int index) {
      return getPortDischargingPlanStowageDetailsFieldBuilder().getBuilder(index);
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanStowageDetails = 4;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetailsOrBuilder
        getPortDischargingPlanStowageDetailsOrBuilder(int index) {
      if (portDischargingPlanStowageDetailsBuilder_ == null) {
        return portDischargingPlanStowageDetails_.get(index);
      } else {
        return portDischargingPlanStowageDetailsBuilder_.getMessageOrBuilder(index);
      }
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanStowageDetails = 4;</code> */
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
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanStowageDetails = 4;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails.Builder
        addPortDischargingPlanStowageDetailsBuilder() {
      return getPortDischargingPlanStowageDetailsFieldBuilder()
          .addBuilder(
              com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
                  .getDefaultInstance());
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanStowageDetails = 4;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails.Builder
        addPortDischargingPlanStowageDetailsBuilder(int index) {
      return getPortDischargingPlanStowageDetailsFieldBuilder()
          .addBuilder(
              index,
              com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
                  .getDefaultInstance());
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanStowageDetails = 4;</code> */
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

    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanBallastDetails = 5;</code> */
    public java.util.List<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails>
        getPortDischargingPlanBallastDetailsList() {
      if (portDischargingPlanBallastDetailsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(portDischargingPlanBallastDetails_);
      } else {
        return portDischargingPlanBallastDetailsBuilder_.getMessageList();
      }
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanBallastDetails = 5;</code> */
    public int getPortDischargingPlanBallastDetailsCount() {
      if (portDischargingPlanBallastDetailsBuilder_ == null) {
        return portDischargingPlanBallastDetails_.size();
      } else {
        return portDischargingPlanBallastDetailsBuilder_.getCount();
      }
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanBallastDetails = 5;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
        getPortDischargingPlanBallastDetails(int index) {
      if (portDischargingPlanBallastDetailsBuilder_ == null) {
        return portDischargingPlanBallastDetails_.get(index);
      } else {
        return portDischargingPlanBallastDetailsBuilder_.getMessage(index);
      }
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanBallastDetails = 5;</code> */
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
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanBallastDetails = 5;</code> */
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
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanBallastDetails = 5;</code> */
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
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanBallastDetails = 5;</code> */
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
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanBallastDetails = 5;</code> */
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
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanBallastDetails = 5;</code> */
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
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanBallastDetails = 5;</code> */
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
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanBallastDetails = 5;</code> */
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
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanBallastDetails = 5;</code> */
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
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanBallastDetails = 5;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails.Builder
        getPortDischargingPlanBallastDetailsBuilder(int index) {
      return getPortDischargingPlanBallastDetailsFieldBuilder().getBuilder(index);
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanBallastDetails = 5;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetailsOrBuilder
        getPortDischargingPlanBallastDetailsOrBuilder(int index) {
      if (portDischargingPlanBallastDetailsBuilder_ == null) {
        return portDischargingPlanBallastDetails_.get(index);
      } else {
        return portDischargingPlanBallastDetailsBuilder_.getMessageOrBuilder(index);
      }
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanBallastDetails = 5;</code> */
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
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanBallastDetails = 5;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails.Builder
        addPortDischargingPlanBallastDetailsBuilder() {
      return getPortDischargingPlanBallastDetailsFieldBuilder()
          .addBuilder(
              com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
                  .getDefaultInstance());
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanBallastDetails = 5;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails.Builder
        addPortDischargingPlanBallastDetailsBuilder(int index) {
      return getPortDischargingPlanBallastDetailsFieldBuilder()
          .addBuilder(
              index,
              com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
                  .getDefaultInstance());
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanBallastDetails = 5;</code> */
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

    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanRobDetails = 6;</code> */
    public java.util.List<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails>
        getPortDischargingPlanRobDetailsList() {
      if (portDischargingPlanRobDetailsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(portDischargingPlanRobDetails_);
      } else {
        return portDischargingPlanRobDetailsBuilder_.getMessageList();
      }
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanRobDetails = 6;</code> */
    public int getPortDischargingPlanRobDetailsCount() {
      if (portDischargingPlanRobDetailsBuilder_ == null) {
        return portDischargingPlanRobDetails_.size();
      } else {
        return portDischargingPlanRobDetailsBuilder_.getCount();
      }
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanRobDetails = 6;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
        getPortDischargingPlanRobDetails(int index) {
      if (portDischargingPlanRobDetailsBuilder_ == null) {
        return portDischargingPlanRobDetails_.get(index);
      } else {
        return portDischargingPlanRobDetailsBuilder_.getMessage(index);
      }
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanRobDetails = 6;</code> */
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
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanRobDetails = 6;</code> */
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
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanRobDetails = 6;</code> */
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
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanRobDetails = 6;</code> */
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
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanRobDetails = 6;</code> */
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
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanRobDetails = 6;</code> */
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
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanRobDetails = 6;</code> */
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
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanRobDetails = 6;</code> */
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
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanRobDetails = 6;</code> */
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
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanRobDetails = 6;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails.Builder
        getPortDischargingPlanRobDetailsBuilder(int index) {
      return getPortDischargingPlanRobDetailsFieldBuilder().getBuilder(index);
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanRobDetails = 6;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetailsOrBuilder
        getPortDischargingPlanRobDetailsOrBuilder(int index) {
      if (portDischargingPlanRobDetailsBuilder_ == null) {
        return portDischargingPlanRobDetails_.get(index);
      } else {
        return portDischargingPlanRobDetailsBuilder_.getMessageOrBuilder(index);
      }
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanRobDetails = 6;</code> */
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
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanRobDetails = 6;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails.Builder
        addPortDischargingPlanRobDetailsBuilder() {
      return getPortDischargingPlanRobDetailsFieldBuilder()
          .addBuilder(
              com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
                  .getDefaultInstance());
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanRobDetails = 6;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails.Builder
        addPortDischargingPlanRobDetailsBuilder(int index) {
      return getPortDischargingPlanRobDetailsFieldBuilder()
          .addBuilder(
              index,
              com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanTankDetails
                  .getDefaultInstance());
    }
    /** <code>repeated .LoadingPlanTankDetails portDischargingPlanRobDetails = 6;</code> */
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
     * <code>repeated .LoadingPlanStabilityParameters portDischargingPlanStabilityParameters = 7;
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
     * <code>repeated .LoadingPlanStabilityParameters portDischargingPlanStabilityParameters = 7;
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
     * <code>repeated .LoadingPlanStabilityParameters portDischargingPlanStabilityParameters = 7;
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
     * <code>repeated .LoadingPlanStabilityParameters portDischargingPlanStabilityParameters = 7;
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
     * <code>repeated .LoadingPlanStabilityParameters portDischargingPlanStabilityParameters = 7;
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
     * <code>repeated .LoadingPlanStabilityParameters portDischargingPlanStabilityParameters = 7;
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
     * <code>repeated .LoadingPlanStabilityParameters portDischargingPlanStabilityParameters = 7;
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
     * <code>repeated .LoadingPlanStabilityParameters portDischargingPlanStabilityParameters = 7;
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
     * <code>repeated .LoadingPlanStabilityParameters portDischargingPlanStabilityParameters = 7;
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
     * <code>repeated .LoadingPlanStabilityParameters portDischargingPlanStabilityParameters = 7;
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
     * <code>repeated .LoadingPlanStabilityParameters portDischargingPlanStabilityParameters = 7;
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
     * <code>repeated .LoadingPlanStabilityParameters portDischargingPlanStabilityParameters = 7;
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
     * <code>repeated .LoadingPlanStabilityParameters portDischargingPlanStabilityParameters = 7;
     * </code>
     */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters
            .Builder
        getPortDischargingPlanStabilityParametersBuilder(int index) {
      return getPortDischargingPlanStabilityParametersFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .LoadingPlanStabilityParameters portDischargingPlanStabilityParameters = 7;
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
     * <code>repeated .LoadingPlanStabilityParameters portDischargingPlanStabilityParameters = 7;
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
     * <code>repeated .LoadingPlanStabilityParameters portDischargingPlanStabilityParameters = 7;
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
     * <code>repeated .LoadingPlanStabilityParameters portDischargingPlanStabilityParameters = 7;
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
     * <code>repeated .LoadingPlanStabilityParameters portDischargingPlanStabilityParameters = 7;
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
            com.cpdss.common.generated.loading_plan.LoadingPlanModels
                .LoadingPlanStabilityParameters>
        dischargingSequenceStabilityParameters_ = java.util.Collections.emptyList();

    private void ensureDischargingSequenceStabilityParametersIsMutable() {
      if (!((bitField0_ & 0x00000020) != 0)) {
        dischargingSequenceStabilityParameters_ =
            new java.util.ArrayList<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels
                    .LoadingPlanStabilityParameters>(dischargingSequenceStabilityParameters_);
        bitField0_ |= 0x00000020;
      }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels
                .LoadingPlanStabilityParameters,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters
                .Builder,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels
                .LoadingPlanStabilityParametersOrBuilder>
        dischargingSequenceStabilityParametersBuilder_;

    /**
     * <code>repeated .LoadingPlanStabilityParameters dischargingSequenceStabilityParameters = 8;
     * </code>
     */
    public java.util.List<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels
                .LoadingPlanStabilityParameters>
        getDischargingSequenceStabilityParametersList() {
      if (dischargingSequenceStabilityParametersBuilder_ == null) {
        return java.util.Collections.unmodifiableList(dischargingSequenceStabilityParameters_);
      } else {
        return dischargingSequenceStabilityParametersBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .LoadingPlanStabilityParameters dischargingSequenceStabilityParameters = 8;
     * </code>
     */
    public int getDischargingSequenceStabilityParametersCount() {
      if (dischargingSequenceStabilityParametersBuilder_ == null) {
        return dischargingSequenceStabilityParameters_.size();
      } else {
        return dischargingSequenceStabilityParametersBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .LoadingPlanStabilityParameters dischargingSequenceStabilityParameters = 8;
     * </code>
     */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters
        getDischargingSequenceStabilityParameters(int index) {
      if (dischargingSequenceStabilityParametersBuilder_ == null) {
        return dischargingSequenceStabilityParameters_.get(index);
      } else {
        return dischargingSequenceStabilityParametersBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .LoadingPlanStabilityParameters dischargingSequenceStabilityParameters = 8;
     * </code>
     */
    public Builder setDischargingSequenceStabilityParameters(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters
            value) {
      if (dischargingSequenceStabilityParametersBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDischargingSequenceStabilityParametersIsMutable();
        dischargingSequenceStabilityParameters_.set(index, value);
        onChanged();
      } else {
        dischargingSequenceStabilityParametersBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .LoadingPlanStabilityParameters dischargingSequenceStabilityParameters = 8;
     * </code>
     */
    public Builder setDischargingSequenceStabilityParameters(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters
                .Builder
            builderForValue) {
      if (dischargingSequenceStabilityParametersBuilder_ == null) {
        ensureDischargingSequenceStabilityParametersIsMutable();
        dischargingSequenceStabilityParameters_.set(index, builderForValue.build());
        onChanged();
      } else {
        dischargingSequenceStabilityParametersBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .LoadingPlanStabilityParameters dischargingSequenceStabilityParameters = 8;
     * </code>
     */
    public Builder addDischargingSequenceStabilityParameters(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters
            value) {
      if (dischargingSequenceStabilityParametersBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDischargingSequenceStabilityParametersIsMutable();
        dischargingSequenceStabilityParameters_.add(value);
        onChanged();
      } else {
        dischargingSequenceStabilityParametersBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .LoadingPlanStabilityParameters dischargingSequenceStabilityParameters = 8;
     * </code>
     */
    public Builder addDischargingSequenceStabilityParameters(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters
            value) {
      if (dischargingSequenceStabilityParametersBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDischargingSequenceStabilityParametersIsMutable();
        dischargingSequenceStabilityParameters_.add(index, value);
        onChanged();
      } else {
        dischargingSequenceStabilityParametersBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .LoadingPlanStabilityParameters dischargingSequenceStabilityParameters = 8;
     * </code>
     */
    public Builder addDischargingSequenceStabilityParameters(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters
                .Builder
            builderForValue) {
      if (dischargingSequenceStabilityParametersBuilder_ == null) {
        ensureDischargingSequenceStabilityParametersIsMutable();
        dischargingSequenceStabilityParameters_.add(builderForValue.build());
        onChanged();
      } else {
        dischargingSequenceStabilityParametersBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .LoadingPlanStabilityParameters dischargingSequenceStabilityParameters = 8;
     * </code>
     */
    public Builder addDischargingSequenceStabilityParameters(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters
                .Builder
            builderForValue) {
      if (dischargingSequenceStabilityParametersBuilder_ == null) {
        ensureDischargingSequenceStabilityParametersIsMutable();
        dischargingSequenceStabilityParameters_.add(index, builderForValue.build());
        onChanged();
      } else {
        dischargingSequenceStabilityParametersBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .LoadingPlanStabilityParameters dischargingSequenceStabilityParameters = 8;
     * </code>
     */
    public Builder addAllDischargingSequenceStabilityParameters(
        java.lang.Iterable<
                ? extends
                    com.cpdss.common.generated.loading_plan.LoadingPlanModels
                        .LoadingPlanStabilityParameters>
            values) {
      if (dischargingSequenceStabilityParametersBuilder_ == null) {
        ensureDischargingSequenceStabilityParametersIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, dischargingSequenceStabilityParameters_);
        onChanged();
      } else {
        dischargingSequenceStabilityParametersBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .LoadingPlanStabilityParameters dischargingSequenceStabilityParameters = 8;
     * </code>
     */
    public Builder clearDischargingSequenceStabilityParameters() {
      if (dischargingSequenceStabilityParametersBuilder_ == null) {
        dischargingSequenceStabilityParameters_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000020);
        onChanged();
      } else {
        dischargingSequenceStabilityParametersBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .LoadingPlanStabilityParameters dischargingSequenceStabilityParameters = 8;
     * </code>
     */
    public Builder removeDischargingSequenceStabilityParameters(int index) {
      if (dischargingSequenceStabilityParametersBuilder_ == null) {
        ensureDischargingSequenceStabilityParametersIsMutable();
        dischargingSequenceStabilityParameters_.remove(index);
        onChanged();
      } else {
        dischargingSequenceStabilityParametersBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .LoadingPlanStabilityParameters dischargingSequenceStabilityParameters = 8;
     * </code>
     */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters
            .Builder
        getDischargingSequenceStabilityParametersBuilder(int index) {
      return getDischargingSequenceStabilityParametersFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .LoadingPlanStabilityParameters dischargingSequenceStabilityParameters = 8;
     * </code>
     */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels
            .LoadingPlanStabilityParametersOrBuilder
        getDischargingSequenceStabilityParametersOrBuilder(int index) {
      if (dischargingSequenceStabilityParametersBuilder_ == null) {
        return dischargingSequenceStabilityParameters_.get(index);
      } else {
        return dischargingSequenceStabilityParametersBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .LoadingPlanStabilityParameters dischargingSequenceStabilityParameters = 8;
     * </code>
     */
    public java.util.List<
            ? extends
                com.cpdss.common.generated.loading_plan.LoadingPlanModels
                    .LoadingPlanStabilityParametersOrBuilder>
        getDischargingSequenceStabilityParametersOrBuilderList() {
      if (dischargingSequenceStabilityParametersBuilder_ != null) {
        return dischargingSequenceStabilityParametersBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(dischargingSequenceStabilityParameters_);
      }
    }
    /**
     * <code>repeated .LoadingPlanStabilityParameters dischargingSequenceStabilityParameters = 8;
     * </code>
     */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters
            .Builder
        addDischargingSequenceStabilityParametersBuilder() {
      return getDischargingSequenceStabilityParametersFieldBuilder()
          .addBuilder(
              com.cpdss.common.generated.loading_plan.LoadingPlanModels
                  .LoadingPlanStabilityParameters.getDefaultInstance());
    }
    /**
     * <code>repeated .LoadingPlanStabilityParameters dischargingSequenceStabilityParameters = 8;
     * </code>
     */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters
            .Builder
        addDischargingSequenceStabilityParametersBuilder(int index) {
      return getDischargingSequenceStabilityParametersFieldBuilder()
          .addBuilder(
              index,
              com.cpdss.common.generated.loading_plan.LoadingPlanModels
                  .LoadingPlanStabilityParameters.getDefaultInstance());
    }
    /**
     * <code>repeated .LoadingPlanStabilityParameters dischargingSequenceStabilityParameters = 8;
     * </code>
     */
    public java.util.List<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters
                .Builder>
        getDischargingSequenceStabilityParametersBuilderList() {
      return getDischargingSequenceStabilityParametersFieldBuilder().getBuilderList();
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels
                .LoadingPlanStabilityParameters,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters
                .Builder,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels
                .LoadingPlanStabilityParametersOrBuilder>
        getDischargingSequenceStabilityParametersFieldBuilder() {
      if (dischargingSequenceStabilityParametersBuilder_ == null) {
        dischargingSequenceStabilityParametersBuilder_ =
            new com.google.protobuf.RepeatedFieldBuilderV3<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels
                    .LoadingPlanStabilityParameters,
                com.cpdss.common.generated.loading_plan.LoadingPlanModels
                    .LoadingPlanStabilityParameters.Builder,
                com.cpdss.common.generated.loading_plan.LoadingPlanModels
                    .LoadingPlanStabilityParametersOrBuilder>(
                dischargingSequenceStabilityParameters_,
                ((bitField0_ & 0x00000020) != 0),
                getParentForChildren(),
                isClean());
        dischargingSequenceStabilityParameters_ = null;
      }
      return dischargingSequenceStabilityParametersBuilder_;
    }

    private java.util.List<com.cpdss.common.generated.LoadableStudy.AlgoErrors> algoErrors_ =
        java.util.Collections.emptyList();

    private void ensureAlgoErrorsIsMutable() {
      if (!((bitField0_ & 0x00000040) != 0)) {
        algoErrors_ =
            new java.util.ArrayList<com.cpdss.common.generated.LoadableStudy.AlgoErrors>(
                algoErrors_);
        bitField0_ |= 0x00000040;
      }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.LoadableStudy.AlgoErrors,
            com.cpdss.common.generated.LoadableStudy.AlgoErrors.Builder,
            com.cpdss.common.generated.LoadableStudy.AlgoErrorsOrBuilder>
        algoErrorsBuilder_;

    /** <code>repeated .AlgoErrors algoErrors = 9;</code> */
    public java.util.List<com.cpdss.common.generated.LoadableStudy.AlgoErrors> getAlgoErrorsList() {
      if (algoErrorsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(algoErrors_);
      } else {
        return algoErrorsBuilder_.getMessageList();
      }
    }
    /** <code>repeated .AlgoErrors algoErrors = 9;</code> */
    public int getAlgoErrorsCount() {
      if (algoErrorsBuilder_ == null) {
        return algoErrors_.size();
      } else {
        return algoErrorsBuilder_.getCount();
      }
    }
    /** <code>repeated .AlgoErrors algoErrors = 9;</code> */
    public com.cpdss.common.generated.LoadableStudy.AlgoErrors getAlgoErrors(int index) {
      if (algoErrorsBuilder_ == null) {
        return algoErrors_.get(index);
      } else {
        return algoErrorsBuilder_.getMessage(index);
      }
    }
    /** <code>repeated .AlgoErrors algoErrors = 9;</code> */
    public Builder setAlgoErrors(
        int index, com.cpdss.common.generated.LoadableStudy.AlgoErrors value) {
      if (algoErrorsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureAlgoErrorsIsMutable();
        algoErrors_.set(index, value);
        onChanged();
      } else {
        algoErrorsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /** <code>repeated .AlgoErrors algoErrors = 9;</code> */
    public Builder setAlgoErrors(
        int index, com.cpdss.common.generated.LoadableStudy.AlgoErrors.Builder builderForValue) {
      if (algoErrorsBuilder_ == null) {
        ensureAlgoErrorsIsMutable();
        algoErrors_.set(index, builderForValue.build());
        onChanged();
      } else {
        algoErrorsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .AlgoErrors algoErrors = 9;</code> */
    public Builder addAlgoErrors(com.cpdss.common.generated.LoadableStudy.AlgoErrors value) {
      if (algoErrorsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureAlgoErrorsIsMutable();
        algoErrors_.add(value);
        onChanged();
      } else {
        algoErrorsBuilder_.addMessage(value);
      }
      return this;
    }
    /** <code>repeated .AlgoErrors algoErrors = 9;</code> */
    public Builder addAlgoErrors(
        int index, com.cpdss.common.generated.LoadableStudy.AlgoErrors value) {
      if (algoErrorsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureAlgoErrorsIsMutable();
        algoErrors_.add(index, value);
        onChanged();
      } else {
        algoErrorsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /** <code>repeated .AlgoErrors algoErrors = 9;</code> */
    public Builder addAlgoErrors(
        com.cpdss.common.generated.LoadableStudy.AlgoErrors.Builder builderForValue) {
      if (algoErrorsBuilder_ == null) {
        ensureAlgoErrorsIsMutable();
        algoErrors_.add(builderForValue.build());
        onChanged();
      } else {
        algoErrorsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .AlgoErrors algoErrors = 9;</code> */
    public Builder addAlgoErrors(
        int index, com.cpdss.common.generated.LoadableStudy.AlgoErrors.Builder builderForValue) {
      if (algoErrorsBuilder_ == null) {
        ensureAlgoErrorsIsMutable();
        algoErrors_.add(index, builderForValue.build());
        onChanged();
      } else {
        algoErrorsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .AlgoErrors algoErrors = 9;</code> */
    public Builder addAllAlgoErrors(
        java.lang.Iterable<? extends com.cpdss.common.generated.LoadableStudy.AlgoErrors> values) {
      if (algoErrorsBuilder_ == null) {
        ensureAlgoErrorsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(values, algoErrors_);
        onChanged();
      } else {
        algoErrorsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /** <code>repeated .AlgoErrors algoErrors = 9;</code> */
    public Builder clearAlgoErrors() {
      if (algoErrorsBuilder_ == null) {
        algoErrors_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000040);
        onChanged();
      } else {
        algoErrorsBuilder_.clear();
      }
      return this;
    }
    /** <code>repeated .AlgoErrors algoErrors = 9;</code> */
    public Builder removeAlgoErrors(int index) {
      if (algoErrorsBuilder_ == null) {
        ensureAlgoErrorsIsMutable();
        algoErrors_.remove(index);
        onChanged();
      } else {
        algoErrorsBuilder_.remove(index);
      }
      return this;
    }
    /** <code>repeated .AlgoErrors algoErrors = 9;</code> */
    public com.cpdss.common.generated.LoadableStudy.AlgoErrors.Builder getAlgoErrorsBuilder(
        int index) {
      return getAlgoErrorsFieldBuilder().getBuilder(index);
    }
    /** <code>repeated .AlgoErrors algoErrors = 9;</code> */
    public com.cpdss.common.generated.LoadableStudy.AlgoErrorsOrBuilder getAlgoErrorsOrBuilder(
        int index) {
      if (algoErrorsBuilder_ == null) {
        return algoErrors_.get(index);
      } else {
        return algoErrorsBuilder_.getMessageOrBuilder(index);
      }
    }
    /** <code>repeated .AlgoErrors algoErrors = 9;</code> */
    public java.util.List<? extends com.cpdss.common.generated.LoadableStudy.AlgoErrorsOrBuilder>
        getAlgoErrorsOrBuilderList() {
      if (algoErrorsBuilder_ != null) {
        return algoErrorsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(algoErrors_);
      }
    }
    /** <code>repeated .AlgoErrors algoErrors = 9;</code> */
    public com.cpdss.common.generated.LoadableStudy.AlgoErrors.Builder addAlgoErrorsBuilder() {
      return getAlgoErrorsFieldBuilder()
          .addBuilder(com.cpdss.common.generated.LoadableStudy.AlgoErrors.getDefaultInstance());
    }
    /** <code>repeated .AlgoErrors algoErrors = 9;</code> */
    public com.cpdss.common.generated.LoadableStudy.AlgoErrors.Builder addAlgoErrorsBuilder(
        int index) {
      return getAlgoErrorsFieldBuilder()
          .addBuilder(
              index, com.cpdss.common.generated.LoadableStudy.AlgoErrors.getDefaultInstance());
    }
    /** <code>repeated .AlgoErrors algoErrors = 9;</code> */
    public java.util.List<com.cpdss.common.generated.LoadableStudy.AlgoErrors.Builder>
        getAlgoErrorsBuilderList() {
      return getAlgoErrorsFieldBuilder().getBuilderList();
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.LoadableStudy.AlgoErrors,
            com.cpdss.common.generated.LoadableStudy.AlgoErrors.Builder,
            com.cpdss.common.generated.LoadableStudy.AlgoErrorsOrBuilder>
        getAlgoErrorsFieldBuilder() {
      if (algoErrorsBuilder_ == null) {
        algoErrorsBuilder_ =
            new com.google.protobuf.RepeatedFieldBuilderV3<
                com.cpdss.common.generated.LoadableStudy.AlgoErrors,
                com.cpdss.common.generated.LoadableStudy.AlgoErrors.Builder,
                com.cpdss.common.generated.LoadableStudy.AlgoErrorsOrBuilder>(
                algoErrors_, ((bitField0_ & 0x00000040) != 0), getParentForChildren(), isClean());
        algoErrors_ = null;
      }
      return algoErrorsBuilder_;
    }

    private boolean hasLoadicator_;
    /**
     * <code>bool hasLoadicator = 10;</code>
     *
     * @return The hasLoadicator.
     */
    public boolean getHasLoadicator() {
      return hasLoadicator_;
    }
    /**
     * <code>bool hasLoadicator = 10;</code>
     *
     * @param value The hasLoadicator to set.
     * @return This builder for chaining.
     */
    public Builder setHasLoadicator(boolean value) {

      hasLoadicator_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool hasLoadicator = 10;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearHasLoadicator() {

      hasLoadicator_ = false;
      onChanged();
      return this;
    }

    private java.lang.Object dischargingPlanDetailsFromAlgo_ = "";
    /**
     * <code>string dischargingPlanDetailsFromAlgo = 11;</code>
     *
     * @return The dischargingPlanDetailsFromAlgo.
     */
    public java.lang.String getDischargingPlanDetailsFromAlgo() {
      java.lang.Object ref = dischargingPlanDetailsFromAlgo_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        dischargingPlanDetailsFromAlgo_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string dischargingPlanDetailsFromAlgo = 11;</code>
     *
     * @return The bytes for dischargingPlanDetailsFromAlgo.
     */
    public com.google.protobuf.ByteString getDischargingPlanDetailsFromAlgoBytes() {
      java.lang.Object ref = dischargingPlanDetailsFromAlgo_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        dischargingPlanDetailsFromAlgo_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string dischargingPlanDetailsFromAlgo = 11;</code>
     *
     * @param value The dischargingPlanDetailsFromAlgo to set.
     * @return This builder for chaining.
     */
    public Builder setDischargingPlanDetailsFromAlgo(java.lang.String value) {
      if (value == null) {
        throw new NullPointerException();
      }

      dischargingPlanDetailsFromAlgo_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string dischargingPlanDetailsFromAlgo = 11;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearDischargingPlanDetailsFromAlgo() {

      dischargingPlanDetailsFromAlgo_ = getDefaultInstance().getDischargingPlanDetailsFromAlgo();
      onChanged();
      return this;
    }
    /**
     * <code>string dischargingPlanDetailsFromAlgo = 11;</code>
     *
     * @param value The bytes for dischargingPlanDetailsFromAlgo to set.
     * @return This builder for chaining.
     */
    public Builder setDischargingPlanDetailsFromAlgoBytes(com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      checkByteStringIsUtf8(value);

      dischargingPlanDetailsFromAlgo_ = value;
      onChanged();
      return this;
    }

    private java.util.List<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanCommingleDetails>
        portDischargingPlanCommingleDetails_ = java.util.Collections.emptyList();

    private void ensurePortDischargingPlanCommingleDetailsIsMutable() {
      if (!((bitField0_ & 0x00000080) != 0)) {
        portDischargingPlanCommingleDetails_ =
            new java.util.ArrayList<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels
                    .LoadingPlanCommingleDetails>(portDischargingPlanCommingleDetails_);
        bitField0_ |= 0x00000080;
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
     * <code>repeated .LoadingPlanCommingleDetails portDischargingPlanCommingleDetails = 12;</code>
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
     * <code>repeated .LoadingPlanCommingleDetails portDischargingPlanCommingleDetails = 12;</code>
     */
    public int getPortDischargingPlanCommingleDetailsCount() {
      if (portDischargingPlanCommingleDetailsBuilder_ == null) {
        return portDischargingPlanCommingleDetails_.size();
      } else {
        return portDischargingPlanCommingleDetailsBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .LoadingPlanCommingleDetails portDischargingPlanCommingleDetails = 12;</code>
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
     * <code>repeated .LoadingPlanCommingleDetails portDischargingPlanCommingleDetails = 12;</code>
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
     * <code>repeated .LoadingPlanCommingleDetails portDischargingPlanCommingleDetails = 12;</code>
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
     * <code>repeated .LoadingPlanCommingleDetails portDischargingPlanCommingleDetails = 12;</code>
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
     * <code>repeated .LoadingPlanCommingleDetails portDischargingPlanCommingleDetails = 12;</code>
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
     * <code>repeated .LoadingPlanCommingleDetails portDischargingPlanCommingleDetails = 12;</code>
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
     * <code>repeated .LoadingPlanCommingleDetails portDischargingPlanCommingleDetails = 12;</code>
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
     * <code>repeated .LoadingPlanCommingleDetails portDischargingPlanCommingleDetails = 12;</code>
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
     * <code>repeated .LoadingPlanCommingleDetails portDischargingPlanCommingleDetails = 12;</code>
     */
    public Builder clearPortDischargingPlanCommingleDetails() {
      if (portDischargingPlanCommingleDetailsBuilder_ == null) {
        portDischargingPlanCommingleDetails_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000080);
        onChanged();
      } else {
        portDischargingPlanCommingleDetailsBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .LoadingPlanCommingleDetails portDischargingPlanCommingleDetails = 12;</code>
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
     * <code>repeated .LoadingPlanCommingleDetails portDischargingPlanCommingleDetails = 12;</code>
     */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanCommingleDetails
            .Builder
        getPortDischargingPlanCommingleDetailsBuilder(int index) {
      return getPortDischargingPlanCommingleDetailsFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .LoadingPlanCommingleDetails portDischargingPlanCommingleDetails = 12;</code>
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
     * <code>repeated .LoadingPlanCommingleDetails portDischargingPlanCommingleDetails = 12;</code>
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
     * <code>repeated .LoadingPlanCommingleDetails portDischargingPlanCommingleDetails = 12;</code>
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
     * <code>repeated .LoadingPlanCommingleDetails portDischargingPlanCommingleDetails = 12;</code>
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
     * <code>repeated .LoadingPlanCommingleDetails portDischargingPlanCommingleDetails = 12;</code>
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
                ((bitField0_ & 0x00000080) != 0),
                getParentForChildren(),
                isClean());
        portDischargingPlanCommingleDetails_ = null;
      }
      return portDischargingPlanCommingleDetailsBuilder_;
    }

    private java.util.List<com.cpdss.common.generated.discharge_plan.DriveTankDetail>
        driveTankDetails_ = java.util.Collections.emptyList();

    private void ensureDriveTankDetailsIsMutable() {
      if (!((bitField0_ & 0x00000100) != 0)) {
        driveTankDetails_ =
            new java.util.ArrayList<com.cpdss.common.generated.discharge_plan.DriveTankDetail>(
                driveTankDetails_);
        bitField0_ |= 0x00000100;
      }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.discharge_plan.DriveTankDetail,
            com.cpdss.common.generated.discharge_plan.DriveTankDetail.Builder,
            com.cpdss.common.generated.discharge_plan.DriveTankDetailOrBuilder>
        driveTankDetailsBuilder_;

    /** <code>repeated .DriveTankDetail driveTankDetails = 13;</code> */
    public java.util.List<com.cpdss.common.generated.discharge_plan.DriveTankDetail>
        getDriveTankDetailsList() {
      if (driveTankDetailsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(driveTankDetails_);
      } else {
        return driveTankDetailsBuilder_.getMessageList();
      }
    }
    /** <code>repeated .DriveTankDetail driveTankDetails = 13;</code> */
    public int getDriveTankDetailsCount() {
      if (driveTankDetailsBuilder_ == null) {
        return driveTankDetails_.size();
      } else {
        return driveTankDetailsBuilder_.getCount();
      }
    }
    /** <code>repeated .DriveTankDetail driveTankDetails = 13;</code> */
    public com.cpdss.common.generated.discharge_plan.DriveTankDetail getDriveTankDetails(
        int index) {
      if (driveTankDetailsBuilder_ == null) {
        return driveTankDetails_.get(index);
      } else {
        return driveTankDetailsBuilder_.getMessage(index);
      }
    }
    /** <code>repeated .DriveTankDetail driveTankDetails = 13;</code> */
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
    /** <code>repeated .DriveTankDetail driveTankDetails = 13;</code> */
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
    /** <code>repeated .DriveTankDetail driveTankDetails = 13;</code> */
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
    /** <code>repeated .DriveTankDetail driveTankDetails = 13;</code> */
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
    /** <code>repeated .DriveTankDetail driveTankDetails = 13;</code> */
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
    /** <code>repeated .DriveTankDetail driveTankDetails = 13;</code> */
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
    /** <code>repeated .DriveTankDetail driveTankDetails = 13;</code> */
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
    /** <code>repeated .DriveTankDetail driveTankDetails = 13;</code> */
    public Builder clearDriveTankDetails() {
      if (driveTankDetailsBuilder_ == null) {
        driveTankDetails_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000100);
        onChanged();
      } else {
        driveTankDetailsBuilder_.clear();
      }
      return this;
    }
    /** <code>repeated .DriveTankDetail driveTankDetails = 13;</code> */
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
    /** <code>repeated .DriveTankDetail driveTankDetails = 13;</code> */
    public com.cpdss.common.generated.discharge_plan.DriveTankDetail.Builder
        getDriveTankDetailsBuilder(int index) {
      return getDriveTankDetailsFieldBuilder().getBuilder(index);
    }
    /** <code>repeated .DriveTankDetail driveTankDetails = 13;</code> */
    public com.cpdss.common.generated.discharge_plan.DriveTankDetailOrBuilder
        getDriveTankDetailsOrBuilder(int index) {
      if (driveTankDetailsBuilder_ == null) {
        return driveTankDetails_.get(index);
      } else {
        return driveTankDetailsBuilder_.getMessageOrBuilder(index);
      }
    }
    /** <code>repeated .DriveTankDetail driveTankDetails = 13;</code> */
    public java.util.List<
            ? extends com.cpdss.common.generated.discharge_plan.DriveTankDetailOrBuilder>
        getDriveTankDetailsOrBuilderList() {
      if (driveTankDetailsBuilder_ != null) {
        return driveTankDetailsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(driveTankDetails_);
      }
    }
    /** <code>repeated .DriveTankDetail driveTankDetails = 13;</code> */
    public com.cpdss.common.generated.discharge_plan.DriveTankDetail.Builder
        addDriveTankDetailsBuilder() {
      return getDriveTankDetailsFieldBuilder()
          .addBuilder(
              com.cpdss.common.generated.discharge_plan.DriveTankDetail.getDefaultInstance());
    }
    /** <code>repeated .DriveTankDetail driveTankDetails = 13;</code> */
    public com.cpdss.common.generated.discharge_plan.DriveTankDetail.Builder
        addDriveTankDetailsBuilder(int index) {
      return getDriveTankDetailsFieldBuilder()
          .addBuilder(
              index,
              com.cpdss.common.generated.discharge_plan.DriveTankDetail.getDefaultInstance());
    }
    /** <code>repeated .DriveTankDetail driveTankDetails = 13;</code> */
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
                ((bitField0_ & 0x00000100) != 0),
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

    // @@protoc_insertion_point(builder_scope:DischargingPlanSaveRequest)
  }

  // @@protoc_insertion_point(class_scope:DischargingPlanSaveRequest)
  private static final com.cpdss.common.generated.discharge_plan.DischargingPlanSaveRequest
      DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new com.cpdss.common.generated.discharge_plan.DischargingPlanSaveRequest();
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingPlanSaveRequest
      getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<DischargingPlanSaveRequest> PARSER =
      new com.google.protobuf.AbstractParser<DischargingPlanSaveRequest>() {
        @java.lang.Override
        public DischargingPlanSaveRequest parsePartialFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
          return new DischargingPlanSaveRequest(input, extensionRegistry);
        }
      };

  public static com.google.protobuf.Parser<DischargingPlanSaveRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<DischargingPlanSaveRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.cpdss.common.generated.discharge_plan.DischargingPlanSaveRequest
      getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
}
