/* Licensed at AlphaOri Technologies */
package com.cpdss.common.generated.discharge_plan;

/** Protobuf type {@code DischargingSequence} */
public final class DischargingSequence extends com.google.protobuf.GeneratedMessageV3
    implements
    // @@protoc_insertion_point(message_implements:DischargingSequence)
    DischargingSequenceOrBuilder {
  private static final long serialVersionUID = 0L;
  // Use DischargingSequence.newBuilder() to construct.
  private DischargingSequence(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }

  private DischargingSequence() {
    stageName_ = "";
    cargoValves_ = java.util.Collections.emptyList();
    ballastValves_ = java.util.Collections.emptyList();
    dischargingRates_ = java.util.Collections.emptyList();
    deBallastingRates_ = java.util.Collections.emptyList();
    dischargePlanPortWiseDetails_ = java.util.Collections.emptyList();
    dischargingPlanPortWiseDetails_ = java.util.Collections.emptyList();
    cargoDischargingRate1_ = "";
    cargoDischargingRate2_ = "";
    ballastOperations_ = java.util.Collections.emptyList();
    eductorOperation_ = java.util.Collections.emptyList();
    cargoOperations_ = java.util.Collections.emptyList();
    tankTransfers_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
    return new DischargingSequence();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }

  private DischargingSequence(
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
              cargoNominationId_ = input.readInt64();
              break;
            }
          case 16:
            {
              startTime_ = input.readInt32();
              break;
            }
          case 24:
            {
              endTime_ = input.readInt32();
              break;
            }
          case 32:
            {
              portId_ = input.readInt64();
              break;
            }
          case 40:
            {
              sequenceNumber_ = input.readInt32();
              break;
            }
          case 50:
            {
              java.lang.String s = input.readStringRequireUtf8();

              stageName_ = s;
              break;
            }
          case 56:
            {
              toLoadicator_ = input.readBool();
              break;
            }
          case 66:
            {
              if (!((mutable_bitField0_ & 0x00000001) != 0)) {
                cargoValves_ =
                    new java.util.ArrayList<
                        com.cpdss.common.generated.loading_plan.LoadingPlanModels.Valve>();
                mutable_bitField0_ |= 0x00000001;
              }
              cargoValves_.add(
                  input.readMessage(
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels.Valve.parser(),
                      extensionRegistry));
              break;
            }
          case 74:
            {
              if (!((mutable_bitField0_ & 0x00000002) != 0)) {
                ballastValves_ =
                    new java.util.ArrayList<
                        com.cpdss.common.generated.loading_plan.LoadingPlanModels.Valve>();
                mutable_bitField0_ |= 0x00000002;
              }
              ballastValves_.add(
                  input.readMessage(
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels.Valve.parser(),
                      extensionRegistry));
              break;
            }
          case 82:
            {
              if (!((mutable_bitField0_ & 0x00000004) != 0)) {
                dischargingRates_ =
                    new java.util.ArrayList<
                        com.cpdss.common.generated.discharge_plan.DischargingRate>();
                mutable_bitField0_ |= 0x00000004;
              }
              dischargingRates_.add(
                  input.readMessage(
                      com.cpdss.common.generated.discharge_plan.DischargingRate.parser(),
                      extensionRegistry));
              break;
            }
          case 90:
            {
              if (!((mutable_bitField0_ & 0x00000008) != 0)) {
                deBallastingRates_ =
                    new java.util.ArrayList<
                        com.cpdss.common.generated.loading_plan.LoadingPlanModels
                            .DeBallastingRate>();
                mutable_bitField0_ |= 0x00000008;
              }
              deBallastingRates_.add(
                  input.readMessage(
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRate
                          .parser(),
                      extensionRegistry));
              break;
            }
          case 98:
            {
              if (!((mutable_bitField0_ & 0x00000010) != 0)) {
                dischargePlanPortWiseDetails_ =
                    new java.util.ArrayList<
                        com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails>();
                mutable_bitField0_ |= 0x00000010;
              }
              dischargePlanPortWiseDetails_.add(
                  input.readMessage(
                      com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails
                          .parser(),
                      extensionRegistry));
              break;
            }
          case 106:
            {
              if (!((mutable_bitField0_ & 0x00000020) != 0)) {
                dischargingPlanPortWiseDetails_ =
                    new java.util.ArrayList<
                        com.cpdss.common.generated.loading_plan.LoadingPlanModels
                            .LoadingPlanPortWiseDetails>();
                mutable_bitField0_ |= 0x00000020;
              }
              dischargingPlanPortWiseDetails_.add(
                  input.readMessage(
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels
                          .LoadingPlanPortWiseDetails.parser(),
                      extensionRegistry));
              break;
            }
          case 114:
            {
              java.lang.String s = input.readStringRequireUtf8();

              cargoDischargingRate1_ = s;
              break;
            }
          case 122:
            {
              java.lang.String s = input.readStringRequireUtf8();

              cargoDischargingRate2_ = s;
              break;
            }
          case 130:
            {
              if (!((mutable_bitField0_ & 0x00000040) != 0)) {
                ballastOperations_ =
                    new java.util.ArrayList<
                        com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperation>();
                mutable_bitField0_ |= 0x00000040;
              }
              ballastOperations_.add(
                  input.readMessage(
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperation
                          .parser(),
                      extensionRegistry));
              break;
            }
          case 138:
            {
              if (!((mutable_bitField0_ & 0x00000080) != 0)) {
                eductorOperation_ =
                    new java.util.ArrayList<
                        com.cpdss.common.generated.loading_plan.LoadingPlanModels
                            .EductorOperation>();
                mutable_bitField0_ |= 0x00000080;
              }
              eductorOperation_.add(
                  input.readMessage(
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels.EductorOperation
                          .parser(),
                      extensionRegistry));
              break;
            }
          case 146:
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
          case 154:
            {
              if (!((mutable_bitField0_ & 0x00000100) != 0)) {
                cargoOperations_ =
                    new java.util.ArrayList<
                        com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperation>();
                mutable_bitField0_ |= 0x00000100;
              }
              cargoOperations_.add(
                  input.readMessage(
                      com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperation
                          .parser(),
                      extensionRegistry));
              break;
            }
          case 162:
            {
              if (!((mutable_bitField0_ & 0x00000200) != 0)) {
                tankTransfers_ =
                    new java.util.ArrayList<
                        com.cpdss.common.generated.discharge_plan.TankTransfer>();
                mutable_bitField0_ |= 0x00000200;
              }
              tankTransfers_.add(
                  input.readMessage(
                      com.cpdss.common.generated.discharge_plan.TankTransfer.parser(),
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
        cargoValves_ = java.util.Collections.unmodifiableList(cargoValves_);
      }
      if (((mutable_bitField0_ & 0x00000002) != 0)) {
        ballastValves_ = java.util.Collections.unmodifiableList(ballastValves_);
      }
      if (((mutable_bitField0_ & 0x00000004) != 0)) {
        dischargingRates_ = java.util.Collections.unmodifiableList(dischargingRates_);
      }
      if (((mutable_bitField0_ & 0x00000008) != 0)) {
        deBallastingRates_ = java.util.Collections.unmodifiableList(deBallastingRates_);
      }
      if (((mutable_bitField0_ & 0x00000010) != 0)) {
        dischargePlanPortWiseDetails_ =
            java.util.Collections.unmodifiableList(dischargePlanPortWiseDetails_);
      }
      if (((mutable_bitField0_ & 0x00000020) != 0)) {
        dischargingPlanPortWiseDetails_ =
            java.util.Collections.unmodifiableList(dischargingPlanPortWiseDetails_);
      }
      if (((mutable_bitField0_ & 0x00000040) != 0)) {
        ballastOperations_ = java.util.Collections.unmodifiableList(ballastOperations_);
      }
      if (((mutable_bitField0_ & 0x00000080) != 0)) {
        eductorOperation_ = java.util.Collections.unmodifiableList(eductorOperation_);
      }
      if (((mutable_bitField0_ & 0x00000100) != 0)) {
        cargoOperations_ = java.util.Collections.unmodifiableList(cargoOperations_);
      }
      if (((mutable_bitField0_ & 0x00000200) != 0)) {
        tankTransfers_ = java.util.Collections.unmodifiableList(tankTransfers_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }

  public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
    return com.cpdss.common.generated.discharge_plan.DischargePlanModels
        .internal_static_DischargingSequence_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.cpdss.common.generated.discharge_plan.DischargePlanModels
        .internal_static_DischargingSequence_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.cpdss.common.generated.discharge_plan.DischargingSequence.class,
            com.cpdss.common.generated.discharge_plan.DischargingSequence.Builder.class);
  }

  public static final int CARGONOMINATIONID_FIELD_NUMBER = 1;
  private long cargoNominationId_;
  /**
   * <code>int64 cargoNominationId = 1;</code>
   *
   * @return The cargoNominationId.
   */
  public long getCargoNominationId() {
    return cargoNominationId_;
  }

  public static final int STARTTIME_FIELD_NUMBER = 2;
  private int startTime_;
  /**
   * <code>int32 startTime = 2;</code>
   *
   * @return The startTime.
   */
  public int getStartTime() {
    return startTime_;
  }

  public static final int ENDTIME_FIELD_NUMBER = 3;
  private int endTime_;
  /**
   * <code>int32 endTime = 3;</code>
   *
   * @return The endTime.
   */
  public int getEndTime() {
    return endTime_;
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

  public static final int SEQUENCENUMBER_FIELD_NUMBER = 5;
  private int sequenceNumber_;
  /**
   * <code>int32 sequenceNumber = 5;</code>
   *
   * @return The sequenceNumber.
   */
  public int getSequenceNumber() {
    return sequenceNumber_;
  }

  public static final int STAGENAME_FIELD_NUMBER = 6;
  private volatile java.lang.Object stageName_;
  /**
   * <code>string stageName = 6;</code>
   *
   * @return The stageName.
   */
  public java.lang.String getStageName() {
    java.lang.Object ref = stageName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      stageName_ = s;
      return s;
    }
  }
  /**
   * <code>string stageName = 6;</code>
   *
   * @return The bytes for stageName.
   */
  public com.google.protobuf.ByteString getStageNameBytes() {
    java.lang.Object ref = stageName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
      stageName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int TOLOADICATOR_FIELD_NUMBER = 7;
  private boolean toLoadicator_;
  /**
   * <code>bool toLoadicator = 7;</code>
   *
   * @return The toLoadicator.
   */
  public boolean getToLoadicator() {
    return toLoadicator_;
  }

  public static final int CARGOVALVES_FIELD_NUMBER = 8;
  private java.util.List<com.cpdss.common.generated.loading_plan.LoadingPlanModels.Valve>
      cargoValves_;
  /** <code>repeated .Valve cargoValves = 8;</code> */
  public java.util.List<com.cpdss.common.generated.loading_plan.LoadingPlanModels.Valve>
      getCargoValvesList() {
    return cargoValves_;
  }
  /** <code>repeated .Valve cargoValves = 8;</code> */
  public java.util.List<
          ? extends com.cpdss.common.generated.loading_plan.LoadingPlanModels.ValveOrBuilder>
      getCargoValvesOrBuilderList() {
    return cargoValves_;
  }
  /** <code>repeated .Valve cargoValves = 8;</code> */
  public int getCargoValvesCount() {
    return cargoValves_.size();
  }
  /** <code>repeated .Valve cargoValves = 8;</code> */
  public com.cpdss.common.generated.loading_plan.LoadingPlanModels.Valve getCargoValves(int index) {
    return cargoValves_.get(index);
  }
  /** <code>repeated .Valve cargoValves = 8;</code> */
  public com.cpdss.common.generated.loading_plan.LoadingPlanModels.ValveOrBuilder
      getCargoValvesOrBuilder(int index) {
    return cargoValves_.get(index);
  }

  public static final int BALLASTVALVES_FIELD_NUMBER = 9;
  private java.util.List<com.cpdss.common.generated.loading_plan.LoadingPlanModels.Valve>
      ballastValves_;
  /** <code>repeated .Valve ballastValves = 9;</code> */
  public java.util.List<com.cpdss.common.generated.loading_plan.LoadingPlanModels.Valve>
      getBallastValvesList() {
    return ballastValves_;
  }
  /** <code>repeated .Valve ballastValves = 9;</code> */
  public java.util.List<
          ? extends com.cpdss.common.generated.loading_plan.LoadingPlanModels.ValveOrBuilder>
      getBallastValvesOrBuilderList() {
    return ballastValves_;
  }
  /** <code>repeated .Valve ballastValves = 9;</code> */
  public int getBallastValvesCount() {
    return ballastValves_.size();
  }
  /** <code>repeated .Valve ballastValves = 9;</code> */
  public com.cpdss.common.generated.loading_plan.LoadingPlanModels.Valve getBallastValves(
      int index) {
    return ballastValves_.get(index);
  }
  /** <code>repeated .Valve ballastValves = 9;</code> */
  public com.cpdss.common.generated.loading_plan.LoadingPlanModels.ValveOrBuilder
      getBallastValvesOrBuilder(int index) {
    return ballastValves_.get(index);
  }

  public static final int DISCHARGINGRATES_FIELD_NUMBER = 10;
  private java.util.List<com.cpdss.common.generated.discharge_plan.DischargingRate>
      dischargingRates_;
  /** <code>repeated .DischargingRate dischargingRates = 10;</code> */
  public java.util.List<com.cpdss.common.generated.discharge_plan.DischargingRate>
      getDischargingRatesList() {
    return dischargingRates_;
  }
  /** <code>repeated .DischargingRate dischargingRates = 10;</code> */
  public java.util.List<
          ? extends com.cpdss.common.generated.discharge_plan.DischargingRateOrBuilder>
      getDischargingRatesOrBuilderList() {
    return dischargingRates_;
  }
  /** <code>repeated .DischargingRate dischargingRates = 10;</code> */
  public int getDischargingRatesCount() {
    return dischargingRates_.size();
  }
  /** <code>repeated .DischargingRate dischargingRates = 10;</code> */
  public com.cpdss.common.generated.discharge_plan.DischargingRate getDischargingRates(int index) {
    return dischargingRates_.get(index);
  }
  /** <code>repeated .DischargingRate dischargingRates = 10;</code> */
  public com.cpdss.common.generated.discharge_plan.DischargingRateOrBuilder
      getDischargingRatesOrBuilder(int index) {
    return dischargingRates_.get(index);
  }

  public static final int DEBALLASTINGRATES_FIELD_NUMBER = 11;
  private java.util.List<com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRate>
      deBallastingRates_;
  /** <code>repeated .DeBallastingRate deBallastingRates = 11;</code> */
  public java.util.List<com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRate>
      getDeBallastingRatesList() {
    return deBallastingRates_;
  }
  /** <code>repeated .DeBallastingRate deBallastingRates = 11;</code> */
  public java.util.List<
          ? extends
              com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRateOrBuilder>
      getDeBallastingRatesOrBuilderList() {
    return deBallastingRates_;
  }
  /** <code>repeated .DeBallastingRate deBallastingRates = 11;</code> */
  public int getDeBallastingRatesCount() {
    return deBallastingRates_.size();
  }
  /** <code>repeated .DeBallastingRate deBallastingRates = 11;</code> */
  public com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRate
      getDeBallastingRates(int index) {
    return deBallastingRates_.get(index);
  }
  /** <code>repeated .DeBallastingRate deBallastingRates = 11;</code> */
  public com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRateOrBuilder
      getDeBallastingRatesOrBuilder(int index) {
    return deBallastingRates_.get(index);
  }

  public static final int DISCHARGEPLANPORTWISEDETAILS_FIELD_NUMBER = 12;
  private java.util.List<com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails>
      dischargePlanPortWiseDetails_;
  /** <code>repeated .DischargePlanPortWiseDetails dischargePlanPortWiseDetails = 12;</code> */
  public java.util.List<com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails>
      getDischargePlanPortWiseDetailsList() {
    return dischargePlanPortWiseDetails_;
  }
  /** <code>repeated .DischargePlanPortWiseDetails dischargePlanPortWiseDetails = 12;</code> */
  public java.util.List<
          ? extends com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetailsOrBuilder>
      getDischargePlanPortWiseDetailsOrBuilderList() {
    return dischargePlanPortWiseDetails_;
  }
  /** <code>repeated .DischargePlanPortWiseDetails dischargePlanPortWiseDetails = 12;</code> */
  public int getDischargePlanPortWiseDetailsCount() {
    return dischargePlanPortWiseDetails_.size();
  }
  /** <code>repeated .DischargePlanPortWiseDetails dischargePlanPortWiseDetails = 12;</code> */
  public com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails
      getDischargePlanPortWiseDetails(int index) {
    return dischargePlanPortWiseDetails_.get(index);
  }
  /** <code>repeated .DischargePlanPortWiseDetails dischargePlanPortWiseDetails = 12;</code> */
  public com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetailsOrBuilder
      getDischargePlanPortWiseDetailsOrBuilder(int index) {
    return dischargePlanPortWiseDetails_.get(index);
  }

  public static final int DISCHARGINGPLANPORTWISEDETAILS_FIELD_NUMBER = 13;
  private java.util.List<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanPortWiseDetails>
      dischargingPlanPortWiseDetails_;
  /** <code>repeated .LoadingPlanPortWiseDetails dischargingPlanPortWiseDetails = 13;</code> */
  public java.util.List<
          com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanPortWiseDetails>
      getDischargingPlanPortWiseDetailsList() {
    return dischargingPlanPortWiseDetails_;
  }
  /** <code>repeated .LoadingPlanPortWiseDetails dischargingPlanPortWiseDetails = 13;</code> */
  public java.util.List<
          ? extends
              com.cpdss.common.generated.loading_plan.LoadingPlanModels
                  .LoadingPlanPortWiseDetailsOrBuilder>
      getDischargingPlanPortWiseDetailsOrBuilderList() {
    return dischargingPlanPortWiseDetails_;
  }
  /** <code>repeated .LoadingPlanPortWiseDetails dischargingPlanPortWiseDetails = 13;</code> */
  public int getDischargingPlanPortWiseDetailsCount() {
    return dischargingPlanPortWiseDetails_.size();
  }
  /** <code>repeated .LoadingPlanPortWiseDetails dischargingPlanPortWiseDetails = 13;</code> */
  public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanPortWiseDetails
      getDischargingPlanPortWiseDetails(int index) {
    return dischargingPlanPortWiseDetails_.get(index);
  }
  /** <code>repeated .LoadingPlanPortWiseDetails dischargingPlanPortWiseDetails = 13;</code> */
  public com.cpdss.common.generated.loading_plan.LoadingPlanModels
          .LoadingPlanPortWiseDetailsOrBuilder
      getDischargingPlanPortWiseDetailsOrBuilder(int index) {
    return dischargingPlanPortWiseDetails_.get(index);
  }

  public static final int CARGODISCHARGINGRATE1_FIELD_NUMBER = 14;
  private volatile java.lang.Object cargoDischargingRate1_;
  /**
   * <code>string cargoDischargingRate1 = 14;</code>
   *
   * @return The cargoDischargingRate1.
   */
  public java.lang.String getCargoDischargingRate1() {
    java.lang.Object ref = cargoDischargingRate1_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      cargoDischargingRate1_ = s;
      return s;
    }
  }
  /**
   * <code>string cargoDischargingRate1 = 14;</code>
   *
   * @return The bytes for cargoDischargingRate1.
   */
  public com.google.protobuf.ByteString getCargoDischargingRate1Bytes() {
    java.lang.Object ref = cargoDischargingRate1_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
      cargoDischargingRate1_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int CARGODISCHARGINGRATE2_FIELD_NUMBER = 15;
  private volatile java.lang.Object cargoDischargingRate2_;
  /**
   * <code>string cargoDischargingRate2 = 15;</code>
   *
   * @return The cargoDischargingRate2.
   */
  public java.lang.String getCargoDischargingRate2() {
    java.lang.Object ref = cargoDischargingRate2_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      cargoDischargingRate2_ = s;
      return s;
    }
  }
  /**
   * <code>string cargoDischargingRate2 = 15;</code>
   *
   * @return The bytes for cargoDischargingRate2.
   */
  public com.google.protobuf.ByteString getCargoDischargingRate2Bytes() {
    java.lang.Object ref = cargoDischargingRate2_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
      cargoDischargingRate2_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int BALLASTOPERATIONS_FIELD_NUMBER = 16;
  private java.util.List<com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperation>
      ballastOperations_;
  /** <code>repeated .PumpOperation ballastOperations = 16;</code> */
  public java.util.List<com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperation>
      getBallastOperationsList() {
    return ballastOperations_;
  }
  /** <code>repeated .PumpOperation ballastOperations = 16;</code> */
  public java.util.List<
          ? extends
              com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperationOrBuilder>
      getBallastOperationsOrBuilderList() {
    return ballastOperations_;
  }
  /** <code>repeated .PumpOperation ballastOperations = 16;</code> */
  public int getBallastOperationsCount() {
    return ballastOperations_.size();
  }
  /** <code>repeated .PumpOperation ballastOperations = 16;</code> */
  public com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperation
      getBallastOperations(int index) {
    return ballastOperations_.get(index);
  }
  /** <code>repeated .PumpOperation ballastOperations = 16;</code> */
  public com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperationOrBuilder
      getBallastOperationsOrBuilder(int index) {
    return ballastOperations_.get(index);
  }

  public static final int EDUCTOROPERATION_FIELD_NUMBER = 17;
  private java.util.List<com.cpdss.common.generated.loading_plan.LoadingPlanModels.EductorOperation>
      eductorOperation_;
  /** <code>repeated .EductorOperation eductorOperation = 17;</code> */
  public java.util.List<com.cpdss.common.generated.loading_plan.LoadingPlanModels.EductorOperation>
      getEductorOperationList() {
    return eductorOperation_;
  }
  /** <code>repeated .EductorOperation eductorOperation = 17;</code> */
  public java.util.List<
          ? extends
              com.cpdss.common.generated.loading_plan.LoadingPlanModels.EductorOperationOrBuilder>
      getEductorOperationOrBuilderList() {
    return eductorOperation_;
  }
  /** <code>repeated .EductorOperation eductorOperation = 17;</code> */
  public int getEductorOperationCount() {
    return eductorOperation_.size();
  }
  /** <code>repeated .EductorOperation eductorOperation = 17;</code> */
  public com.cpdss.common.generated.loading_plan.LoadingPlanModels.EductorOperation
      getEductorOperation(int index) {
    return eductorOperation_.get(index);
  }
  /** <code>repeated .EductorOperation eductorOperation = 17;</code> */
  public com.cpdss.common.generated.loading_plan.LoadingPlanModels.EductorOperationOrBuilder
      getEductorOperationOrBuilder(int index) {
    return eductorOperation_.get(index);
  }

  public static final int CLEANINGTANKS_FIELD_NUMBER = 18;
  private com.cpdss.common.generated.discharge_plan.CleaningTanks cleaningTanks_;
  /**
   * <code>.CleaningTanks cleaningTanks = 18;</code>
   *
   * @return Whether the cleaningTanks field is set.
   */
  public boolean hasCleaningTanks() {
    return cleaningTanks_ != null;
  }
  /**
   * <code>.CleaningTanks cleaningTanks = 18;</code>
   *
   * @return The cleaningTanks.
   */
  public com.cpdss.common.generated.discharge_plan.CleaningTanks getCleaningTanks() {
    return cleaningTanks_ == null
        ? com.cpdss.common.generated.discharge_plan.CleaningTanks.getDefaultInstance()
        : cleaningTanks_;
  }
  /** <code>.CleaningTanks cleaningTanks = 18;</code> */
  public com.cpdss.common.generated.discharge_plan.CleaningTanksOrBuilder
      getCleaningTanksOrBuilder() {
    return getCleaningTanks();
  }

  public static final int CARGOOPERATIONS_FIELD_NUMBER = 19;
  private java.util.List<com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperation>
      cargoOperations_;
  /** <code>repeated .PumpOperation cargoOperations = 19;</code> */
  public java.util.List<com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperation>
      getCargoOperationsList() {
    return cargoOperations_;
  }
  /** <code>repeated .PumpOperation cargoOperations = 19;</code> */
  public java.util.List<
          ? extends
              com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperationOrBuilder>
      getCargoOperationsOrBuilderList() {
    return cargoOperations_;
  }
  /** <code>repeated .PumpOperation cargoOperations = 19;</code> */
  public int getCargoOperationsCount() {
    return cargoOperations_.size();
  }
  /** <code>repeated .PumpOperation cargoOperations = 19;</code> */
  public com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperation getCargoOperations(
      int index) {
    return cargoOperations_.get(index);
  }
  /** <code>repeated .PumpOperation cargoOperations = 19;</code> */
  public com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperationOrBuilder
      getCargoOperationsOrBuilder(int index) {
    return cargoOperations_.get(index);
  }

  public static final int TANKTRANSFERS_FIELD_NUMBER = 20;
  private java.util.List<com.cpdss.common.generated.discharge_plan.TankTransfer> tankTransfers_;
  /** <code>repeated .TankTransfer tankTransfers = 20;</code> */
  public java.util.List<com.cpdss.common.generated.discharge_plan.TankTransfer>
      getTankTransfersList() {
    return tankTransfers_;
  }
  /** <code>repeated .TankTransfer tankTransfers = 20;</code> */
  public java.util.List<? extends com.cpdss.common.generated.discharge_plan.TankTransferOrBuilder>
      getTankTransfersOrBuilderList() {
    return tankTransfers_;
  }
  /** <code>repeated .TankTransfer tankTransfers = 20;</code> */
  public int getTankTransfersCount() {
    return tankTransfers_.size();
  }
  /** <code>repeated .TankTransfer tankTransfers = 20;</code> */
  public com.cpdss.common.generated.discharge_plan.TankTransfer getTankTransfers(int index) {
    return tankTransfers_.get(index);
  }
  /** <code>repeated .TankTransfer tankTransfers = 20;</code> */
  public com.cpdss.common.generated.discharge_plan.TankTransferOrBuilder getTankTransfersOrBuilder(
      int index) {
    return tankTransfers_.get(index);
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
    if (cargoNominationId_ != 0L) {
      output.writeInt64(1, cargoNominationId_);
    }
    if (startTime_ != 0) {
      output.writeInt32(2, startTime_);
    }
    if (endTime_ != 0) {
      output.writeInt32(3, endTime_);
    }
    if (portId_ != 0L) {
      output.writeInt64(4, portId_);
    }
    if (sequenceNumber_ != 0) {
      output.writeInt32(5, sequenceNumber_);
    }
    if (!getStageNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 6, stageName_);
    }
    if (toLoadicator_ != false) {
      output.writeBool(7, toLoadicator_);
    }
    for (int i = 0; i < cargoValves_.size(); i++) {
      output.writeMessage(8, cargoValves_.get(i));
    }
    for (int i = 0; i < ballastValves_.size(); i++) {
      output.writeMessage(9, ballastValves_.get(i));
    }
    for (int i = 0; i < dischargingRates_.size(); i++) {
      output.writeMessage(10, dischargingRates_.get(i));
    }
    for (int i = 0; i < deBallastingRates_.size(); i++) {
      output.writeMessage(11, deBallastingRates_.get(i));
    }
    for (int i = 0; i < dischargePlanPortWiseDetails_.size(); i++) {
      output.writeMessage(12, dischargePlanPortWiseDetails_.get(i));
    }
    for (int i = 0; i < dischargingPlanPortWiseDetails_.size(); i++) {
      output.writeMessage(13, dischargingPlanPortWiseDetails_.get(i));
    }
    if (!getCargoDischargingRate1Bytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 14, cargoDischargingRate1_);
    }
    if (!getCargoDischargingRate2Bytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 15, cargoDischargingRate2_);
    }
    for (int i = 0; i < ballastOperations_.size(); i++) {
      output.writeMessage(16, ballastOperations_.get(i));
    }
    for (int i = 0; i < eductorOperation_.size(); i++) {
      output.writeMessage(17, eductorOperation_.get(i));
    }
    if (cleaningTanks_ != null) {
      output.writeMessage(18, getCleaningTanks());
    }
    for (int i = 0; i < cargoOperations_.size(); i++) {
      output.writeMessage(19, cargoOperations_.get(i));
    }
    for (int i = 0; i < tankTransfers_.size(); i++) {
      output.writeMessage(20, tankTransfers_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (cargoNominationId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream.computeInt64Size(1, cargoNominationId_);
    }
    if (startTime_ != 0) {
      size += com.google.protobuf.CodedOutputStream.computeInt32Size(2, startTime_);
    }
    if (endTime_ != 0) {
      size += com.google.protobuf.CodedOutputStream.computeInt32Size(3, endTime_);
    }
    if (portId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream.computeInt64Size(4, portId_);
    }
    if (sequenceNumber_ != 0) {
      size += com.google.protobuf.CodedOutputStream.computeInt32Size(5, sequenceNumber_);
    }
    if (!getStageNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(6, stageName_);
    }
    if (toLoadicator_ != false) {
      size += com.google.protobuf.CodedOutputStream.computeBoolSize(7, toLoadicator_);
    }
    for (int i = 0; i < cargoValves_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream.computeMessageSize(8, cargoValves_.get(i));
    }
    for (int i = 0; i < ballastValves_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream.computeMessageSize(9, ballastValves_.get(i));
    }
    for (int i = 0; i < dischargingRates_.size(); i++) {
      size +=
          com.google.protobuf.CodedOutputStream.computeMessageSize(10, dischargingRates_.get(i));
    }
    for (int i = 0; i < deBallastingRates_.size(); i++) {
      size +=
          com.google.protobuf.CodedOutputStream.computeMessageSize(11, deBallastingRates_.get(i));
    }
    for (int i = 0; i < dischargePlanPortWiseDetails_.size(); i++) {
      size +=
          com.google.protobuf.CodedOutputStream.computeMessageSize(
              12, dischargePlanPortWiseDetails_.get(i));
    }
    for (int i = 0; i < dischargingPlanPortWiseDetails_.size(); i++) {
      size +=
          com.google.protobuf.CodedOutputStream.computeMessageSize(
              13, dischargingPlanPortWiseDetails_.get(i));
    }
    if (!getCargoDischargingRate1Bytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(14, cargoDischargingRate1_);
    }
    if (!getCargoDischargingRate2Bytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(15, cargoDischargingRate2_);
    }
    for (int i = 0; i < ballastOperations_.size(); i++) {
      size +=
          com.google.protobuf.CodedOutputStream.computeMessageSize(16, ballastOperations_.get(i));
    }
    for (int i = 0; i < eductorOperation_.size(); i++) {
      size +=
          com.google.protobuf.CodedOutputStream.computeMessageSize(17, eductorOperation_.get(i));
    }
    if (cleaningTanks_ != null) {
      size += com.google.protobuf.CodedOutputStream.computeMessageSize(18, getCleaningTanks());
    }
    for (int i = 0; i < cargoOperations_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream.computeMessageSize(19, cargoOperations_.get(i));
    }
    for (int i = 0; i < tankTransfers_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream.computeMessageSize(20, tankTransfers_.get(i));
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
    if (!(obj instanceof com.cpdss.common.generated.discharge_plan.DischargingSequence)) {
      return super.equals(obj);
    }
    com.cpdss.common.generated.discharge_plan.DischargingSequence other =
        (com.cpdss.common.generated.discharge_plan.DischargingSequence) obj;

    if (getCargoNominationId() != other.getCargoNominationId()) return false;
    if (getStartTime() != other.getStartTime()) return false;
    if (getEndTime() != other.getEndTime()) return false;
    if (getPortId() != other.getPortId()) return false;
    if (getSequenceNumber() != other.getSequenceNumber()) return false;
    if (!getStageName().equals(other.getStageName())) return false;
    if (getToLoadicator() != other.getToLoadicator()) return false;
    if (!getCargoValvesList().equals(other.getCargoValvesList())) return false;
    if (!getBallastValvesList().equals(other.getBallastValvesList())) return false;
    if (!getDischargingRatesList().equals(other.getDischargingRatesList())) return false;
    if (!getDeBallastingRatesList().equals(other.getDeBallastingRatesList())) return false;
    if (!getDischargePlanPortWiseDetailsList().equals(other.getDischargePlanPortWiseDetailsList()))
      return false;
    if (!getDischargingPlanPortWiseDetailsList()
        .equals(other.getDischargingPlanPortWiseDetailsList())) return false;
    if (!getCargoDischargingRate1().equals(other.getCargoDischargingRate1())) return false;
    if (!getCargoDischargingRate2().equals(other.getCargoDischargingRate2())) return false;
    if (!getBallastOperationsList().equals(other.getBallastOperationsList())) return false;
    if (!getEductorOperationList().equals(other.getEductorOperationList())) return false;
    if (hasCleaningTanks() != other.hasCleaningTanks()) return false;
    if (hasCleaningTanks()) {
      if (!getCleaningTanks().equals(other.getCleaningTanks())) return false;
    }
    if (!getCargoOperationsList().equals(other.getCargoOperationsList())) return false;
    if (!getTankTransfersList().equals(other.getTankTransfersList())) return false;
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
    hash = (37 * hash) + CARGONOMINATIONID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getCargoNominationId());
    hash = (37 * hash) + STARTTIME_FIELD_NUMBER;
    hash = (53 * hash) + getStartTime();
    hash = (37 * hash) + ENDTIME_FIELD_NUMBER;
    hash = (53 * hash) + getEndTime();
    hash = (37 * hash) + PORTID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getPortId());
    hash = (37 * hash) + SEQUENCENUMBER_FIELD_NUMBER;
    hash = (53 * hash) + getSequenceNumber();
    hash = (37 * hash) + STAGENAME_FIELD_NUMBER;
    hash = (53 * hash) + getStageName().hashCode();
    hash = (37 * hash) + TOLOADICATOR_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(getToLoadicator());
    if (getCargoValvesCount() > 0) {
      hash = (37 * hash) + CARGOVALVES_FIELD_NUMBER;
      hash = (53 * hash) + getCargoValvesList().hashCode();
    }
    if (getBallastValvesCount() > 0) {
      hash = (37 * hash) + BALLASTVALVES_FIELD_NUMBER;
      hash = (53 * hash) + getBallastValvesList().hashCode();
    }
    if (getDischargingRatesCount() > 0) {
      hash = (37 * hash) + DISCHARGINGRATES_FIELD_NUMBER;
      hash = (53 * hash) + getDischargingRatesList().hashCode();
    }
    if (getDeBallastingRatesCount() > 0) {
      hash = (37 * hash) + DEBALLASTINGRATES_FIELD_NUMBER;
      hash = (53 * hash) + getDeBallastingRatesList().hashCode();
    }
    if (getDischargePlanPortWiseDetailsCount() > 0) {
      hash = (37 * hash) + DISCHARGEPLANPORTWISEDETAILS_FIELD_NUMBER;
      hash = (53 * hash) + getDischargePlanPortWiseDetailsList().hashCode();
    }
    if (getDischargingPlanPortWiseDetailsCount() > 0) {
      hash = (37 * hash) + DISCHARGINGPLANPORTWISEDETAILS_FIELD_NUMBER;
      hash = (53 * hash) + getDischargingPlanPortWiseDetailsList().hashCode();
    }
    hash = (37 * hash) + CARGODISCHARGINGRATE1_FIELD_NUMBER;
    hash = (53 * hash) + getCargoDischargingRate1().hashCode();
    hash = (37 * hash) + CARGODISCHARGINGRATE2_FIELD_NUMBER;
    hash = (53 * hash) + getCargoDischargingRate2().hashCode();
    if (getBallastOperationsCount() > 0) {
      hash = (37 * hash) + BALLASTOPERATIONS_FIELD_NUMBER;
      hash = (53 * hash) + getBallastOperationsList().hashCode();
    }
    if (getEductorOperationCount() > 0) {
      hash = (37 * hash) + EDUCTOROPERATION_FIELD_NUMBER;
      hash = (53 * hash) + getEductorOperationList().hashCode();
    }
    if (hasCleaningTanks()) {
      hash = (37 * hash) + CLEANINGTANKS_FIELD_NUMBER;
      hash = (53 * hash) + getCleaningTanks().hashCode();
    }
    if (getCargoOperationsCount() > 0) {
      hash = (37 * hash) + CARGOOPERATIONS_FIELD_NUMBER;
      hash = (53 * hash) + getCargoOperationsList().hashCode();
    }
    if (getTankTransfersCount() > 0) {
      hash = (37 * hash) + TANKTRANSFERS_FIELD_NUMBER;
      hash = (53 * hash) + getTankTransfersList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingSequence parseFrom(
      java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingSequence parseFrom(
      java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingSequence parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingSequence parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingSequence parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingSequence parseFrom(
      byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingSequence parseFrom(
      java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingSequence parseFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingSequence parseDelimitedFrom(
      java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingSequence parseDelimitedFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingSequence parseFrom(
      com.google.protobuf.CodedInputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingSequence parseFrom(
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
      com.cpdss.common.generated.discharge_plan.DischargingSequence prototype) {
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
  /** Protobuf type {@code DischargingSequence} */
  public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
      implements
      // @@protoc_insertion_point(builder_implements:DischargingSequence)
      com.cpdss.common.generated.discharge_plan.DischargingSequenceOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanModels
          .internal_static_DischargingSequence_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanModels
          .internal_static_DischargingSequence_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cpdss.common.generated.discharge_plan.DischargingSequence.class,
              com.cpdss.common.generated.discharge_plan.DischargingSequence.Builder.class);
    }

    // Construct using com.cpdss.common.generated.discharge_plan.DischargingSequence.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {
        getCargoValvesFieldBuilder();
        getBallastValvesFieldBuilder();
        getDischargingRatesFieldBuilder();
        getDeBallastingRatesFieldBuilder();
        getDischargePlanPortWiseDetailsFieldBuilder();
        getDischargingPlanPortWiseDetailsFieldBuilder();
        getBallastOperationsFieldBuilder();
        getEductorOperationFieldBuilder();
        getCargoOperationsFieldBuilder();
        getTankTransfersFieldBuilder();
      }
    }

    @java.lang.Override
    public Builder clear() {
      super.clear();
      cargoNominationId_ = 0L;

      startTime_ = 0;

      endTime_ = 0;

      portId_ = 0L;

      sequenceNumber_ = 0;

      stageName_ = "";

      toLoadicator_ = false;

      if (cargoValvesBuilder_ == null) {
        cargoValves_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        cargoValvesBuilder_.clear();
      }
      if (ballastValvesBuilder_ == null) {
        ballastValves_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000002);
      } else {
        ballastValvesBuilder_.clear();
      }
      if (dischargingRatesBuilder_ == null) {
        dischargingRates_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000004);
      } else {
        dischargingRatesBuilder_.clear();
      }
      if (deBallastingRatesBuilder_ == null) {
        deBallastingRates_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000008);
      } else {
        deBallastingRatesBuilder_.clear();
      }
      if (dischargePlanPortWiseDetailsBuilder_ == null) {
        dischargePlanPortWiseDetails_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000010);
      } else {
        dischargePlanPortWiseDetailsBuilder_.clear();
      }
      if (dischargingPlanPortWiseDetailsBuilder_ == null) {
        dischargingPlanPortWiseDetails_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000020);
      } else {
        dischargingPlanPortWiseDetailsBuilder_.clear();
      }
      cargoDischargingRate1_ = "";

      cargoDischargingRate2_ = "";

      if (ballastOperationsBuilder_ == null) {
        ballastOperations_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000040);
      } else {
        ballastOperationsBuilder_.clear();
      }
      if (eductorOperationBuilder_ == null) {
        eductorOperation_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000080);
      } else {
        eductorOperationBuilder_.clear();
      }
      if (cleaningTanksBuilder_ == null) {
        cleaningTanks_ = null;
      } else {
        cleaningTanks_ = null;
        cleaningTanksBuilder_ = null;
      }
      if (cargoOperationsBuilder_ == null) {
        cargoOperations_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000100);
      } else {
        cargoOperationsBuilder_.clear();
      }
      if (tankTransfersBuilder_ == null) {
        tankTransfers_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000200);
      } else {
        tankTransfersBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
      return com.cpdss.common.generated.discharge_plan.DischargePlanModels
          .internal_static_DischargingSequence_descriptor;
    }

    @java.lang.Override
    public com.cpdss.common.generated.discharge_plan.DischargingSequence
        getDefaultInstanceForType() {
      return com.cpdss.common.generated.discharge_plan.DischargingSequence.getDefaultInstance();
    }

    @java.lang.Override
    public com.cpdss.common.generated.discharge_plan.DischargingSequence build() {
      com.cpdss.common.generated.discharge_plan.DischargingSequence result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.cpdss.common.generated.discharge_plan.DischargingSequence buildPartial() {
      com.cpdss.common.generated.discharge_plan.DischargingSequence result =
          new com.cpdss.common.generated.discharge_plan.DischargingSequence(this);
      int from_bitField0_ = bitField0_;
      result.cargoNominationId_ = cargoNominationId_;
      result.startTime_ = startTime_;
      result.endTime_ = endTime_;
      result.portId_ = portId_;
      result.sequenceNumber_ = sequenceNumber_;
      result.stageName_ = stageName_;
      result.toLoadicator_ = toLoadicator_;
      if (cargoValvesBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          cargoValves_ = java.util.Collections.unmodifiableList(cargoValves_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.cargoValves_ = cargoValves_;
      } else {
        result.cargoValves_ = cargoValvesBuilder_.build();
      }
      if (ballastValvesBuilder_ == null) {
        if (((bitField0_ & 0x00000002) != 0)) {
          ballastValves_ = java.util.Collections.unmodifiableList(ballastValves_);
          bitField0_ = (bitField0_ & ~0x00000002);
        }
        result.ballastValves_ = ballastValves_;
      } else {
        result.ballastValves_ = ballastValvesBuilder_.build();
      }
      if (dischargingRatesBuilder_ == null) {
        if (((bitField0_ & 0x00000004) != 0)) {
          dischargingRates_ = java.util.Collections.unmodifiableList(dischargingRates_);
          bitField0_ = (bitField0_ & ~0x00000004);
        }
        result.dischargingRates_ = dischargingRates_;
      } else {
        result.dischargingRates_ = dischargingRatesBuilder_.build();
      }
      if (deBallastingRatesBuilder_ == null) {
        if (((bitField0_ & 0x00000008) != 0)) {
          deBallastingRates_ = java.util.Collections.unmodifiableList(deBallastingRates_);
          bitField0_ = (bitField0_ & ~0x00000008);
        }
        result.deBallastingRates_ = deBallastingRates_;
      } else {
        result.deBallastingRates_ = deBallastingRatesBuilder_.build();
      }
      if (dischargePlanPortWiseDetailsBuilder_ == null) {
        if (((bitField0_ & 0x00000010) != 0)) {
          dischargePlanPortWiseDetails_ =
              java.util.Collections.unmodifiableList(dischargePlanPortWiseDetails_);
          bitField0_ = (bitField0_ & ~0x00000010);
        }
        result.dischargePlanPortWiseDetails_ = dischargePlanPortWiseDetails_;
      } else {
        result.dischargePlanPortWiseDetails_ = dischargePlanPortWiseDetailsBuilder_.build();
      }
      if (dischargingPlanPortWiseDetailsBuilder_ == null) {
        if (((bitField0_ & 0x00000020) != 0)) {
          dischargingPlanPortWiseDetails_ =
              java.util.Collections.unmodifiableList(dischargingPlanPortWiseDetails_);
          bitField0_ = (bitField0_ & ~0x00000020);
        }
        result.dischargingPlanPortWiseDetails_ = dischargingPlanPortWiseDetails_;
      } else {
        result.dischargingPlanPortWiseDetails_ = dischargingPlanPortWiseDetailsBuilder_.build();
      }
      result.cargoDischargingRate1_ = cargoDischargingRate1_;
      result.cargoDischargingRate2_ = cargoDischargingRate2_;
      if (ballastOperationsBuilder_ == null) {
        if (((bitField0_ & 0x00000040) != 0)) {
          ballastOperations_ = java.util.Collections.unmodifiableList(ballastOperations_);
          bitField0_ = (bitField0_ & ~0x00000040);
        }
        result.ballastOperations_ = ballastOperations_;
      } else {
        result.ballastOperations_ = ballastOperationsBuilder_.build();
      }
      if (eductorOperationBuilder_ == null) {
        if (((bitField0_ & 0x00000080) != 0)) {
          eductorOperation_ = java.util.Collections.unmodifiableList(eductorOperation_);
          bitField0_ = (bitField0_ & ~0x00000080);
        }
        result.eductorOperation_ = eductorOperation_;
      } else {
        result.eductorOperation_ = eductorOperationBuilder_.build();
      }
      if (cleaningTanksBuilder_ == null) {
        result.cleaningTanks_ = cleaningTanks_;
      } else {
        result.cleaningTanks_ = cleaningTanksBuilder_.build();
      }
      if (cargoOperationsBuilder_ == null) {
        if (((bitField0_ & 0x00000100) != 0)) {
          cargoOperations_ = java.util.Collections.unmodifiableList(cargoOperations_);
          bitField0_ = (bitField0_ & ~0x00000100);
        }
        result.cargoOperations_ = cargoOperations_;
      } else {
        result.cargoOperations_ = cargoOperationsBuilder_.build();
      }
      if (tankTransfersBuilder_ == null) {
        if (((bitField0_ & 0x00000200) != 0)) {
          tankTransfers_ = java.util.Collections.unmodifiableList(tankTransfers_);
          bitField0_ = (bitField0_ & ~0x00000200);
        }
        result.tankTransfers_ = tankTransfers_;
      } else {
        result.tankTransfers_ = tankTransfersBuilder_.build();
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
      if (other instanceof com.cpdss.common.generated.discharge_plan.DischargingSequence) {
        return mergeFrom((com.cpdss.common.generated.discharge_plan.DischargingSequence) other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.cpdss.common.generated.discharge_plan.DischargingSequence other) {
      if (other
          == com.cpdss.common.generated.discharge_plan.DischargingSequence.getDefaultInstance())
        return this;
      if (other.getCargoNominationId() != 0L) {
        setCargoNominationId(other.getCargoNominationId());
      }
      if (other.getStartTime() != 0) {
        setStartTime(other.getStartTime());
      }
      if (other.getEndTime() != 0) {
        setEndTime(other.getEndTime());
      }
      if (other.getPortId() != 0L) {
        setPortId(other.getPortId());
      }
      if (other.getSequenceNumber() != 0) {
        setSequenceNumber(other.getSequenceNumber());
      }
      if (!other.getStageName().isEmpty()) {
        stageName_ = other.stageName_;
        onChanged();
      }
      if (other.getToLoadicator() != false) {
        setToLoadicator(other.getToLoadicator());
      }
      if (cargoValvesBuilder_ == null) {
        if (!other.cargoValves_.isEmpty()) {
          if (cargoValves_.isEmpty()) {
            cargoValves_ = other.cargoValves_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureCargoValvesIsMutable();
            cargoValves_.addAll(other.cargoValves_);
          }
          onChanged();
        }
      } else {
        if (!other.cargoValves_.isEmpty()) {
          if (cargoValvesBuilder_.isEmpty()) {
            cargoValvesBuilder_.dispose();
            cargoValvesBuilder_ = null;
            cargoValves_ = other.cargoValves_;
            bitField0_ = (bitField0_ & ~0x00000001);
            cargoValvesBuilder_ =
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
                    ? getCargoValvesFieldBuilder()
                    : null;
          } else {
            cargoValvesBuilder_.addAllMessages(other.cargoValves_);
          }
        }
      }
      if (ballastValvesBuilder_ == null) {
        if (!other.ballastValves_.isEmpty()) {
          if (ballastValves_.isEmpty()) {
            ballastValves_ = other.ballastValves_;
            bitField0_ = (bitField0_ & ~0x00000002);
          } else {
            ensureBallastValvesIsMutable();
            ballastValves_.addAll(other.ballastValves_);
          }
          onChanged();
        }
      } else {
        if (!other.ballastValves_.isEmpty()) {
          if (ballastValvesBuilder_.isEmpty()) {
            ballastValvesBuilder_.dispose();
            ballastValvesBuilder_ = null;
            ballastValves_ = other.ballastValves_;
            bitField0_ = (bitField0_ & ~0x00000002);
            ballastValvesBuilder_ =
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
                    ? getBallastValvesFieldBuilder()
                    : null;
          } else {
            ballastValvesBuilder_.addAllMessages(other.ballastValves_);
          }
        }
      }
      if (dischargingRatesBuilder_ == null) {
        if (!other.dischargingRates_.isEmpty()) {
          if (dischargingRates_.isEmpty()) {
            dischargingRates_ = other.dischargingRates_;
            bitField0_ = (bitField0_ & ~0x00000004);
          } else {
            ensureDischargingRatesIsMutable();
            dischargingRates_.addAll(other.dischargingRates_);
          }
          onChanged();
        }
      } else {
        if (!other.dischargingRates_.isEmpty()) {
          if (dischargingRatesBuilder_.isEmpty()) {
            dischargingRatesBuilder_.dispose();
            dischargingRatesBuilder_ = null;
            dischargingRates_ = other.dischargingRates_;
            bitField0_ = (bitField0_ & ~0x00000004);
            dischargingRatesBuilder_ =
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
                    ? getDischargingRatesFieldBuilder()
                    : null;
          } else {
            dischargingRatesBuilder_.addAllMessages(other.dischargingRates_);
          }
        }
      }
      if (deBallastingRatesBuilder_ == null) {
        if (!other.deBallastingRates_.isEmpty()) {
          if (deBallastingRates_.isEmpty()) {
            deBallastingRates_ = other.deBallastingRates_;
            bitField0_ = (bitField0_ & ~0x00000008);
          } else {
            ensureDeBallastingRatesIsMutable();
            deBallastingRates_.addAll(other.deBallastingRates_);
          }
          onChanged();
        }
      } else {
        if (!other.deBallastingRates_.isEmpty()) {
          if (deBallastingRatesBuilder_.isEmpty()) {
            deBallastingRatesBuilder_.dispose();
            deBallastingRatesBuilder_ = null;
            deBallastingRates_ = other.deBallastingRates_;
            bitField0_ = (bitField0_ & ~0x00000008);
            deBallastingRatesBuilder_ =
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
                    ? getDeBallastingRatesFieldBuilder()
                    : null;
          } else {
            deBallastingRatesBuilder_.addAllMessages(other.deBallastingRates_);
          }
        }
      }
      if (dischargePlanPortWiseDetailsBuilder_ == null) {
        if (!other.dischargePlanPortWiseDetails_.isEmpty()) {
          if (dischargePlanPortWiseDetails_.isEmpty()) {
            dischargePlanPortWiseDetails_ = other.dischargePlanPortWiseDetails_;
            bitField0_ = (bitField0_ & ~0x00000010);
          } else {
            ensureDischargePlanPortWiseDetailsIsMutable();
            dischargePlanPortWiseDetails_.addAll(other.dischargePlanPortWiseDetails_);
          }
          onChanged();
        }
      } else {
        if (!other.dischargePlanPortWiseDetails_.isEmpty()) {
          if (dischargePlanPortWiseDetailsBuilder_.isEmpty()) {
            dischargePlanPortWiseDetailsBuilder_.dispose();
            dischargePlanPortWiseDetailsBuilder_ = null;
            dischargePlanPortWiseDetails_ = other.dischargePlanPortWiseDetails_;
            bitField0_ = (bitField0_ & ~0x00000010);
            dischargePlanPortWiseDetailsBuilder_ =
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
                    ? getDischargePlanPortWiseDetailsFieldBuilder()
                    : null;
          } else {
            dischargePlanPortWiseDetailsBuilder_.addAllMessages(
                other.dischargePlanPortWiseDetails_);
          }
        }
      }
      if (dischargingPlanPortWiseDetailsBuilder_ == null) {
        if (!other.dischargingPlanPortWiseDetails_.isEmpty()) {
          if (dischargingPlanPortWiseDetails_.isEmpty()) {
            dischargingPlanPortWiseDetails_ = other.dischargingPlanPortWiseDetails_;
            bitField0_ = (bitField0_ & ~0x00000020);
          } else {
            ensureDischargingPlanPortWiseDetailsIsMutable();
            dischargingPlanPortWiseDetails_.addAll(other.dischargingPlanPortWiseDetails_);
          }
          onChanged();
        }
      } else {
        if (!other.dischargingPlanPortWiseDetails_.isEmpty()) {
          if (dischargingPlanPortWiseDetailsBuilder_.isEmpty()) {
            dischargingPlanPortWiseDetailsBuilder_.dispose();
            dischargingPlanPortWiseDetailsBuilder_ = null;
            dischargingPlanPortWiseDetails_ = other.dischargingPlanPortWiseDetails_;
            bitField0_ = (bitField0_ & ~0x00000020);
            dischargingPlanPortWiseDetailsBuilder_ =
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
                    ? getDischargingPlanPortWiseDetailsFieldBuilder()
                    : null;
          } else {
            dischargingPlanPortWiseDetailsBuilder_.addAllMessages(
                other.dischargingPlanPortWiseDetails_);
          }
        }
      }
      if (!other.getCargoDischargingRate1().isEmpty()) {
        cargoDischargingRate1_ = other.cargoDischargingRate1_;
        onChanged();
      }
      if (!other.getCargoDischargingRate2().isEmpty()) {
        cargoDischargingRate2_ = other.cargoDischargingRate2_;
        onChanged();
      }
      if (ballastOperationsBuilder_ == null) {
        if (!other.ballastOperations_.isEmpty()) {
          if (ballastOperations_.isEmpty()) {
            ballastOperations_ = other.ballastOperations_;
            bitField0_ = (bitField0_ & ~0x00000040);
          } else {
            ensureBallastOperationsIsMutable();
            ballastOperations_.addAll(other.ballastOperations_);
          }
          onChanged();
        }
      } else {
        if (!other.ballastOperations_.isEmpty()) {
          if (ballastOperationsBuilder_.isEmpty()) {
            ballastOperationsBuilder_.dispose();
            ballastOperationsBuilder_ = null;
            ballastOperations_ = other.ballastOperations_;
            bitField0_ = (bitField0_ & ~0x00000040);
            ballastOperationsBuilder_ =
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
                    ? getBallastOperationsFieldBuilder()
                    : null;
          } else {
            ballastOperationsBuilder_.addAllMessages(other.ballastOperations_);
          }
        }
      }
      if (eductorOperationBuilder_ == null) {
        if (!other.eductorOperation_.isEmpty()) {
          if (eductorOperation_.isEmpty()) {
            eductorOperation_ = other.eductorOperation_;
            bitField0_ = (bitField0_ & ~0x00000080);
          } else {
            ensureEductorOperationIsMutable();
            eductorOperation_.addAll(other.eductorOperation_);
          }
          onChanged();
        }
      } else {
        if (!other.eductorOperation_.isEmpty()) {
          if (eductorOperationBuilder_.isEmpty()) {
            eductorOperationBuilder_.dispose();
            eductorOperationBuilder_ = null;
            eductorOperation_ = other.eductorOperation_;
            bitField0_ = (bitField0_ & ~0x00000080);
            eductorOperationBuilder_ =
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
                    ? getEductorOperationFieldBuilder()
                    : null;
          } else {
            eductorOperationBuilder_.addAllMessages(other.eductorOperation_);
          }
        }
      }
      if (other.hasCleaningTanks()) {
        mergeCleaningTanks(other.getCleaningTanks());
      }
      if (cargoOperationsBuilder_ == null) {
        if (!other.cargoOperations_.isEmpty()) {
          if (cargoOperations_.isEmpty()) {
            cargoOperations_ = other.cargoOperations_;
            bitField0_ = (bitField0_ & ~0x00000100);
          } else {
            ensureCargoOperationsIsMutable();
            cargoOperations_.addAll(other.cargoOperations_);
          }
          onChanged();
        }
      } else {
        if (!other.cargoOperations_.isEmpty()) {
          if (cargoOperationsBuilder_.isEmpty()) {
            cargoOperationsBuilder_.dispose();
            cargoOperationsBuilder_ = null;
            cargoOperations_ = other.cargoOperations_;
            bitField0_ = (bitField0_ & ~0x00000100);
            cargoOperationsBuilder_ =
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
                    ? getCargoOperationsFieldBuilder()
                    : null;
          } else {
            cargoOperationsBuilder_.addAllMessages(other.cargoOperations_);
          }
        }
      }
      if (tankTransfersBuilder_ == null) {
        if (!other.tankTransfers_.isEmpty()) {
          if (tankTransfers_.isEmpty()) {
            tankTransfers_ = other.tankTransfers_;
            bitField0_ = (bitField0_ & ~0x00000200);
          } else {
            ensureTankTransfersIsMutable();
            tankTransfers_.addAll(other.tankTransfers_);
          }
          onChanged();
        }
      } else {
        if (!other.tankTransfers_.isEmpty()) {
          if (tankTransfersBuilder_.isEmpty()) {
            tankTransfersBuilder_.dispose();
            tankTransfersBuilder_ = null;
            tankTransfers_ = other.tankTransfers_;
            bitField0_ = (bitField0_ & ~0x00000200);
            tankTransfersBuilder_ =
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
                    ? getTankTransfersFieldBuilder()
                    : null;
          } else {
            tankTransfersBuilder_.addAllMessages(other.tankTransfers_);
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
      com.cpdss.common.generated.discharge_plan.DischargingSequence parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage =
            (com.cpdss.common.generated.discharge_plan.DischargingSequence)
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

    private long cargoNominationId_;
    /**
     * <code>int64 cargoNominationId = 1;</code>
     *
     * @return The cargoNominationId.
     */
    public long getCargoNominationId() {
      return cargoNominationId_;
    }
    /**
     * <code>int64 cargoNominationId = 1;</code>
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
     * <code>int64 cargoNominationId = 1;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearCargoNominationId() {

      cargoNominationId_ = 0L;
      onChanged();
      return this;
    }

    private int startTime_;
    /**
     * <code>int32 startTime = 2;</code>
     *
     * @return The startTime.
     */
    public int getStartTime() {
      return startTime_;
    }
    /**
     * <code>int32 startTime = 2;</code>
     *
     * @param value The startTime to set.
     * @return This builder for chaining.
     */
    public Builder setStartTime(int value) {

      startTime_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 startTime = 2;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearStartTime() {

      startTime_ = 0;
      onChanged();
      return this;
    }

    private int endTime_;
    /**
     * <code>int32 endTime = 3;</code>
     *
     * @return The endTime.
     */
    public int getEndTime() {
      return endTime_;
    }
    /**
     * <code>int32 endTime = 3;</code>
     *
     * @param value The endTime to set.
     * @return This builder for chaining.
     */
    public Builder setEndTime(int value) {

      endTime_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 endTime = 3;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearEndTime() {

      endTime_ = 0;
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

    private int sequenceNumber_;
    /**
     * <code>int32 sequenceNumber = 5;</code>
     *
     * @return The sequenceNumber.
     */
    public int getSequenceNumber() {
      return sequenceNumber_;
    }
    /**
     * <code>int32 sequenceNumber = 5;</code>
     *
     * @param value The sequenceNumber to set.
     * @return This builder for chaining.
     */
    public Builder setSequenceNumber(int value) {

      sequenceNumber_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 sequenceNumber = 5;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearSequenceNumber() {

      sequenceNumber_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object stageName_ = "";
    /**
     * <code>string stageName = 6;</code>
     *
     * @return The stageName.
     */
    public java.lang.String getStageName() {
      java.lang.Object ref = stageName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        stageName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string stageName = 6;</code>
     *
     * @return The bytes for stageName.
     */
    public com.google.protobuf.ByteString getStageNameBytes() {
      java.lang.Object ref = stageName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        stageName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string stageName = 6;</code>
     *
     * @param value The stageName to set.
     * @return This builder for chaining.
     */
    public Builder setStageName(java.lang.String value) {
      if (value == null) {
        throw new NullPointerException();
      }

      stageName_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string stageName = 6;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearStageName() {

      stageName_ = getDefaultInstance().getStageName();
      onChanged();
      return this;
    }
    /**
     * <code>string stageName = 6;</code>
     *
     * @param value The bytes for stageName to set.
     * @return This builder for chaining.
     */
    public Builder setStageNameBytes(com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      checkByteStringIsUtf8(value);

      stageName_ = value;
      onChanged();
      return this;
    }

    private boolean toLoadicator_;
    /**
     * <code>bool toLoadicator = 7;</code>
     *
     * @return The toLoadicator.
     */
    public boolean getToLoadicator() {
      return toLoadicator_;
    }
    /**
     * <code>bool toLoadicator = 7;</code>
     *
     * @param value The toLoadicator to set.
     * @return This builder for chaining.
     */
    public Builder setToLoadicator(boolean value) {

      toLoadicator_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool toLoadicator = 7;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearToLoadicator() {

      toLoadicator_ = false;
      onChanged();
      return this;
    }

    private java.util.List<com.cpdss.common.generated.loading_plan.LoadingPlanModels.Valve>
        cargoValves_ = java.util.Collections.emptyList();

    private void ensureCargoValvesIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        cargoValves_ =
            new java.util.ArrayList<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.Valve>(cargoValves_);
        bitField0_ |= 0x00000001;
      }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.Valve,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.Valve.Builder,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.ValveOrBuilder>
        cargoValvesBuilder_;

    /** <code>repeated .Valve cargoValves = 8;</code> */
    public java.util.List<com.cpdss.common.generated.loading_plan.LoadingPlanModels.Valve>
        getCargoValvesList() {
      if (cargoValvesBuilder_ == null) {
        return java.util.Collections.unmodifiableList(cargoValves_);
      } else {
        return cargoValvesBuilder_.getMessageList();
      }
    }
    /** <code>repeated .Valve cargoValves = 8;</code> */
    public int getCargoValvesCount() {
      if (cargoValvesBuilder_ == null) {
        return cargoValves_.size();
      } else {
        return cargoValvesBuilder_.getCount();
      }
    }
    /** <code>repeated .Valve cargoValves = 8;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.Valve getCargoValves(
        int index) {
      if (cargoValvesBuilder_ == null) {
        return cargoValves_.get(index);
      } else {
        return cargoValvesBuilder_.getMessage(index);
      }
    }
    /** <code>repeated .Valve cargoValves = 8;</code> */
    public Builder setCargoValves(
        int index, com.cpdss.common.generated.loading_plan.LoadingPlanModels.Valve value) {
      if (cargoValvesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureCargoValvesIsMutable();
        cargoValves_.set(index, value);
        onChanged();
      } else {
        cargoValvesBuilder_.setMessage(index, value);
      }
      return this;
    }
    /** <code>repeated .Valve cargoValves = 8;</code> */
    public Builder setCargoValves(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.Valve.Builder builderForValue) {
      if (cargoValvesBuilder_ == null) {
        ensureCargoValvesIsMutable();
        cargoValves_.set(index, builderForValue.build());
        onChanged();
      } else {
        cargoValvesBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .Valve cargoValves = 8;</code> */
    public Builder addCargoValves(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.Valve value) {
      if (cargoValvesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureCargoValvesIsMutable();
        cargoValves_.add(value);
        onChanged();
      } else {
        cargoValvesBuilder_.addMessage(value);
      }
      return this;
    }
    /** <code>repeated .Valve cargoValves = 8;</code> */
    public Builder addCargoValves(
        int index, com.cpdss.common.generated.loading_plan.LoadingPlanModels.Valve value) {
      if (cargoValvesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureCargoValvesIsMutable();
        cargoValves_.add(index, value);
        onChanged();
      } else {
        cargoValvesBuilder_.addMessage(index, value);
      }
      return this;
    }
    /** <code>repeated .Valve cargoValves = 8;</code> */
    public Builder addCargoValves(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.Valve.Builder builderForValue) {
      if (cargoValvesBuilder_ == null) {
        ensureCargoValvesIsMutable();
        cargoValves_.add(builderForValue.build());
        onChanged();
      } else {
        cargoValvesBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .Valve cargoValves = 8;</code> */
    public Builder addCargoValves(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.Valve.Builder builderForValue) {
      if (cargoValvesBuilder_ == null) {
        ensureCargoValvesIsMutable();
        cargoValves_.add(index, builderForValue.build());
        onChanged();
      } else {
        cargoValvesBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .Valve cargoValves = 8;</code> */
    public Builder addAllCargoValves(
        java.lang.Iterable<
                ? extends com.cpdss.common.generated.loading_plan.LoadingPlanModels.Valve>
            values) {
      if (cargoValvesBuilder_ == null) {
        ensureCargoValvesIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(values, cargoValves_);
        onChanged();
      } else {
        cargoValvesBuilder_.addAllMessages(values);
      }
      return this;
    }
    /** <code>repeated .Valve cargoValves = 8;</code> */
    public Builder clearCargoValves() {
      if (cargoValvesBuilder_ == null) {
        cargoValves_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        cargoValvesBuilder_.clear();
      }
      return this;
    }
    /** <code>repeated .Valve cargoValves = 8;</code> */
    public Builder removeCargoValves(int index) {
      if (cargoValvesBuilder_ == null) {
        ensureCargoValvesIsMutable();
        cargoValves_.remove(index);
        onChanged();
      } else {
        cargoValvesBuilder_.remove(index);
      }
      return this;
    }
    /** <code>repeated .Valve cargoValves = 8;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.Valve.Builder
        getCargoValvesBuilder(int index) {
      return getCargoValvesFieldBuilder().getBuilder(index);
    }
    /** <code>repeated .Valve cargoValves = 8;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.ValveOrBuilder
        getCargoValvesOrBuilder(int index) {
      if (cargoValvesBuilder_ == null) {
        return cargoValves_.get(index);
      } else {
        return cargoValvesBuilder_.getMessageOrBuilder(index);
      }
    }
    /** <code>repeated .Valve cargoValves = 8;</code> */
    public java.util.List<
            ? extends com.cpdss.common.generated.loading_plan.LoadingPlanModels.ValveOrBuilder>
        getCargoValvesOrBuilderList() {
      if (cargoValvesBuilder_ != null) {
        return cargoValvesBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(cargoValves_);
      }
    }
    /** <code>repeated .Valve cargoValves = 8;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.Valve.Builder
        addCargoValvesBuilder() {
      return getCargoValvesFieldBuilder()
          .addBuilder(
              com.cpdss.common.generated.loading_plan.LoadingPlanModels.Valve.getDefaultInstance());
    }
    /** <code>repeated .Valve cargoValves = 8;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.Valve.Builder
        addCargoValvesBuilder(int index) {
      return getCargoValvesFieldBuilder()
          .addBuilder(
              index,
              com.cpdss.common.generated.loading_plan.LoadingPlanModels.Valve.getDefaultInstance());
    }
    /** <code>repeated .Valve cargoValves = 8;</code> */
    public java.util.List<com.cpdss.common.generated.loading_plan.LoadingPlanModels.Valve.Builder>
        getCargoValvesBuilderList() {
      return getCargoValvesFieldBuilder().getBuilderList();
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.Valve,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.Valve.Builder,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.ValveOrBuilder>
        getCargoValvesFieldBuilder() {
      if (cargoValvesBuilder_ == null) {
        cargoValvesBuilder_ =
            new com.google.protobuf.RepeatedFieldBuilderV3<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.Valve,
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.Valve.Builder,
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.ValveOrBuilder>(
                cargoValves_, ((bitField0_ & 0x00000001) != 0), getParentForChildren(), isClean());
        cargoValves_ = null;
      }
      return cargoValvesBuilder_;
    }

    private java.util.List<com.cpdss.common.generated.loading_plan.LoadingPlanModels.Valve>
        ballastValves_ = java.util.Collections.emptyList();

    private void ensureBallastValvesIsMutable() {
      if (!((bitField0_ & 0x00000002) != 0)) {
        ballastValves_ =
            new java.util.ArrayList<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.Valve>(ballastValves_);
        bitField0_ |= 0x00000002;
      }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.Valve,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.Valve.Builder,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.ValveOrBuilder>
        ballastValvesBuilder_;

    /** <code>repeated .Valve ballastValves = 9;</code> */
    public java.util.List<com.cpdss.common.generated.loading_plan.LoadingPlanModels.Valve>
        getBallastValvesList() {
      if (ballastValvesBuilder_ == null) {
        return java.util.Collections.unmodifiableList(ballastValves_);
      } else {
        return ballastValvesBuilder_.getMessageList();
      }
    }
    /** <code>repeated .Valve ballastValves = 9;</code> */
    public int getBallastValvesCount() {
      if (ballastValvesBuilder_ == null) {
        return ballastValves_.size();
      } else {
        return ballastValvesBuilder_.getCount();
      }
    }
    /** <code>repeated .Valve ballastValves = 9;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.Valve getBallastValves(
        int index) {
      if (ballastValvesBuilder_ == null) {
        return ballastValves_.get(index);
      } else {
        return ballastValvesBuilder_.getMessage(index);
      }
    }
    /** <code>repeated .Valve ballastValves = 9;</code> */
    public Builder setBallastValves(
        int index, com.cpdss.common.generated.loading_plan.LoadingPlanModels.Valve value) {
      if (ballastValvesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureBallastValvesIsMutable();
        ballastValves_.set(index, value);
        onChanged();
      } else {
        ballastValvesBuilder_.setMessage(index, value);
      }
      return this;
    }
    /** <code>repeated .Valve ballastValves = 9;</code> */
    public Builder setBallastValves(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.Valve.Builder builderForValue) {
      if (ballastValvesBuilder_ == null) {
        ensureBallastValvesIsMutable();
        ballastValves_.set(index, builderForValue.build());
        onChanged();
      } else {
        ballastValvesBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .Valve ballastValves = 9;</code> */
    public Builder addBallastValves(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.Valve value) {
      if (ballastValvesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureBallastValvesIsMutable();
        ballastValves_.add(value);
        onChanged();
      } else {
        ballastValvesBuilder_.addMessage(value);
      }
      return this;
    }
    /** <code>repeated .Valve ballastValves = 9;</code> */
    public Builder addBallastValves(
        int index, com.cpdss.common.generated.loading_plan.LoadingPlanModels.Valve value) {
      if (ballastValvesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureBallastValvesIsMutable();
        ballastValves_.add(index, value);
        onChanged();
      } else {
        ballastValvesBuilder_.addMessage(index, value);
      }
      return this;
    }
    /** <code>repeated .Valve ballastValves = 9;</code> */
    public Builder addBallastValves(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.Valve.Builder builderForValue) {
      if (ballastValvesBuilder_ == null) {
        ensureBallastValvesIsMutable();
        ballastValves_.add(builderForValue.build());
        onChanged();
      } else {
        ballastValvesBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .Valve ballastValves = 9;</code> */
    public Builder addBallastValves(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.Valve.Builder builderForValue) {
      if (ballastValvesBuilder_ == null) {
        ensureBallastValvesIsMutable();
        ballastValves_.add(index, builderForValue.build());
        onChanged();
      } else {
        ballastValvesBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .Valve ballastValves = 9;</code> */
    public Builder addAllBallastValves(
        java.lang.Iterable<
                ? extends com.cpdss.common.generated.loading_plan.LoadingPlanModels.Valve>
            values) {
      if (ballastValvesBuilder_ == null) {
        ensureBallastValvesIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(values, ballastValves_);
        onChanged();
      } else {
        ballastValvesBuilder_.addAllMessages(values);
      }
      return this;
    }
    /** <code>repeated .Valve ballastValves = 9;</code> */
    public Builder clearBallastValves() {
      if (ballastValvesBuilder_ == null) {
        ballastValves_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000002);
        onChanged();
      } else {
        ballastValvesBuilder_.clear();
      }
      return this;
    }
    /** <code>repeated .Valve ballastValves = 9;</code> */
    public Builder removeBallastValves(int index) {
      if (ballastValvesBuilder_ == null) {
        ensureBallastValvesIsMutable();
        ballastValves_.remove(index);
        onChanged();
      } else {
        ballastValvesBuilder_.remove(index);
      }
      return this;
    }
    /** <code>repeated .Valve ballastValves = 9;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.Valve.Builder
        getBallastValvesBuilder(int index) {
      return getBallastValvesFieldBuilder().getBuilder(index);
    }
    /** <code>repeated .Valve ballastValves = 9;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.ValveOrBuilder
        getBallastValvesOrBuilder(int index) {
      if (ballastValvesBuilder_ == null) {
        return ballastValves_.get(index);
      } else {
        return ballastValvesBuilder_.getMessageOrBuilder(index);
      }
    }
    /** <code>repeated .Valve ballastValves = 9;</code> */
    public java.util.List<
            ? extends com.cpdss.common.generated.loading_plan.LoadingPlanModels.ValveOrBuilder>
        getBallastValvesOrBuilderList() {
      if (ballastValvesBuilder_ != null) {
        return ballastValvesBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(ballastValves_);
      }
    }
    /** <code>repeated .Valve ballastValves = 9;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.Valve.Builder
        addBallastValvesBuilder() {
      return getBallastValvesFieldBuilder()
          .addBuilder(
              com.cpdss.common.generated.loading_plan.LoadingPlanModels.Valve.getDefaultInstance());
    }
    /** <code>repeated .Valve ballastValves = 9;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.Valve.Builder
        addBallastValvesBuilder(int index) {
      return getBallastValvesFieldBuilder()
          .addBuilder(
              index,
              com.cpdss.common.generated.loading_plan.LoadingPlanModels.Valve.getDefaultInstance());
    }
    /** <code>repeated .Valve ballastValves = 9;</code> */
    public java.util.List<com.cpdss.common.generated.loading_plan.LoadingPlanModels.Valve.Builder>
        getBallastValvesBuilderList() {
      return getBallastValvesFieldBuilder().getBuilderList();
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.Valve,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.Valve.Builder,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.ValveOrBuilder>
        getBallastValvesFieldBuilder() {
      if (ballastValvesBuilder_ == null) {
        ballastValvesBuilder_ =
            new com.google.protobuf.RepeatedFieldBuilderV3<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.Valve,
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.Valve.Builder,
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.ValveOrBuilder>(
                ballastValves_,
                ((bitField0_ & 0x00000002) != 0),
                getParentForChildren(),
                isClean());
        ballastValves_ = null;
      }
      return ballastValvesBuilder_;
    }

    private java.util.List<com.cpdss.common.generated.discharge_plan.DischargingRate>
        dischargingRates_ = java.util.Collections.emptyList();

    private void ensureDischargingRatesIsMutable() {
      if (!((bitField0_ & 0x00000004) != 0)) {
        dischargingRates_ =
            new java.util.ArrayList<com.cpdss.common.generated.discharge_plan.DischargingRate>(
                dischargingRates_);
        bitField0_ |= 0x00000004;
      }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.discharge_plan.DischargingRate,
            com.cpdss.common.generated.discharge_plan.DischargingRate.Builder,
            com.cpdss.common.generated.discharge_plan.DischargingRateOrBuilder>
        dischargingRatesBuilder_;

    /** <code>repeated .DischargingRate dischargingRates = 10;</code> */
    public java.util.List<com.cpdss.common.generated.discharge_plan.DischargingRate>
        getDischargingRatesList() {
      if (dischargingRatesBuilder_ == null) {
        return java.util.Collections.unmodifiableList(dischargingRates_);
      } else {
        return dischargingRatesBuilder_.getMessageList();
      }
    }
    /** <code>repeated .DischargingRate dischargingRates = 10;</code> */
    public int getDischargingRatesCount() {
      if (dischargingRatesBuilder_ == null) {
        return dischargingRates_.size();
      } else {
        return dischargingRatesBuilder_.getCount();
      }
    }
    /** <code>repeated .DischargingRate dischargingRates = 10;</code> */
    public com.cpdss.common.generated.discharge_plan.DischargingRate getDischargingRates(
        int index) {
      if (dischargingRatesBuilder_ == null) {
        return dischargingRates_.get(index);
      } else {
        return dischargingRatesBuilder_.getMessage(index);
      }
    }
    /** <code>repeated .DischargingRate dischargingRates = 10;</code> */
    public Builder setDischargingRates(
        int index, com.cpdss.common.generated.discharge_plan.DischargingRate value) {
      if (dischargingRatesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDischargingRatesIsMutable();
        dischargingRates_.set(index, value);
        onChanged();
      } else {
        dischargingRatesBuilder_.setMessage(index, value);
      }
      return this;
    }
    /** <code>repeated .DischargingRate dischargingRates = 10;</code> */
    public Builder setDischargingRates(
        int index,
        com.cpdss.common.generated.discharge_plan.DischargingRate.Builder builderForValue) {
      if (dischargingRatesBuilder_ == null) {
        ensureDischargingRatesIsMutable();
        dischargingRates_.set(index, builderForValue.build());
        onChanged();
      } else {
        dischargingRatesBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .DischargingRate dischargingRates = 10;</code> */
    public Builder addDischargingRates(
        com.cpdss.common.generated.discharge_plan.DischargingRate value) {
      if (dischargingRatesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDischargingRatesIsMutable();
        dischargingRates_.add(value);
        onChanged();
      } else {
        dischargingRatesBuilder_.addMessage(value);
      }
      return this;
    }
    /** <code>repeated .DischargingRate dischargingRates = 10;</code> */
    public Builder addDischargingRates(
        int index, com.cpdss.common.generated.discharge_plan.DischargingRate value) {
      if (dischargingRatesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDischargingRatesIsMutable();
        dischargingRates_.add(index, value);
        onChanged();
      } else {
        dischargingRatesBuilder_.addMessage(index, value);
      }
      return this;
    }
    /** <code>repeated .DischargingRate dischargingRates = 10;</code> */
    public Builder addDischargingRates(
        com.cpdss.common.generated.discharge_plan.DischargingRate.Builder builderForValue) {
      if (dischargingRatesBuilder_ == null) {
        ensureDischargingRatesIsMutable();
        dischargingRates_.add(builderForValue.build());
        onChanged();
      } else {
        dischargingRatesBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .DischargingRate dischargingRates = 10;</code> */
    public Builder addDischargingRates(
        int index,
        com.cpdss.common.generated.discharge_plan.DischargingRate.Builder builderForValue) {
      if (dischargingRatesBuilder_ == null) {
        ensureDischargingRatesIsMutable();
        dischargingRates_.add(index, builderForValue.build());
        onChanged();
      } else {
        dischargingRatesBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .DischargingRate dischargingRates = 10;</code> */
    public Builder addAllDischargingRates(
        java.lang.Iterable<? extends com.cpdss.common.generated.discharge_plan.DischargingRate>
            values) {
      if (dischargingRatesBuilder_ == null) {
        ensureDischargingRatesIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(values, dischargingRates_);
        onChanged();
      } else {
        dischargingRatesBuilder_.addAllMessages(values);
      }
      return this;
    }
    /** <code>repeated .DischargingRate dischargingRates = 10;</code> */
    public Builder clearDischargingRates() {
      if (dischargingRatesBuilder_ == null) {
        dischargingRates_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000004);
        onChanged();
      } else {
        dischargingRatesBuilder_.clear();
      }
      return this;
    }
    /** <code>repeated .DischargingRate dischargingRates = 10;</code> */
    public Builder removeDischargingRates(int index) {
      if (dischargingRatesBuilder_ == null) {
        ensureDischargingRatesIsMutable();
        dischargingRates_.remove(index);
        onChanged();
      } else {
        dischargingRatesBuilder_.remove(index);
      }
      return this;
    }
    /** <code>repeated .DischargingRate dischargingRates = 10;</code> */
    public com.cpdss.common.generated.discharge_plan.DischargingRate.Builder
        getDischargingRatesBuilder(int index) {
      return getDischargingRatesFieldBuilder().getBuilder(index);
    }
    /** <code>repeated .DischargingRate dischargingRates = 10;</code> */
    public com.cpdss.common.generated.discharge_plan.DischargingRateOrBuilder
        getDischargingRatesOrBuilder(int index) {
      if (dischargingRatesBuilder_ == null) {
        return dischargingRates_.get(index);
      } else {
        return dischargingRatesBuilder_.getMessageOrBuilder(index);
      }
    }
    /** <code>repeated .DischargingRate dischargingRates = 10;</code> */
    public java.util.List<
            ? extends com.cpdss.common.generated.discharge_plan.DischargingRateOrBuilder>
        getDischargingRatesOrBuilderList() {
      if (dischargingRatesBuilder_ != null) {
        return dischargingRatesBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(dischargingRates_);
      }
    }
    /** <code>repeated .DischargingRate dischargingRates = 10;</code> */
    public com.cpdss.common.generated.discharge_plan.DischargingRate.Builder
        addDischargingRatesBuilder() {
      return getDischargingRatesFieldBuilder()
          .addBuilder(
              com.cpdss.common.generated.discharge_plan.DischargingRate.getDefaultInstance());
    }
    /** <code>repeated .DischargingRate dischargingRates = 10;</code> */
    public com.cpdss.common.generated.discharge_plan.DischargingRate.Builder
        addDischargingRatesBuilder(int index) {
      return getDischargingRatesFieldBuilder()
          .addBuilder(
              index,
              com.cpdss.common.generated.discharge_plan.DischargingRate.getDefaultInstance());
    }
    /** <code>repeated .DischargingRate dischargingRates = 10;</code> */
    public java.util.List<com.cpdss.common.generated.discharge_plan.DischargingRate.Builder>
        getDischargingRatesBuilderList() {
      return getDischargingRatesFieldBuilder().getBuilderList();
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.discharge_plan.DischargingRate,
            com.cpdss.common.generated.discharge_plan.DischargingRate.Builder,
            com.cpdss.common.generated.discharge_plan.DischargingRateOrBuilder>
        getDischargingRatesFieldBuilder() {
      if (dischargingRatesBuilder_ == null) {
        dischargingRatesBuilder_ =
            new com.google.protobuf.RepeatedFieldBuilderV3<
                com.cpdss.common.generated.discharge_plan.DischargingRate,
                com.cpdss.common.generated.discharge_plan.DischargingRate.Builder,
                com.cpdss.common.generated.discharge_plan.DischargingRateOrBuilder>(
                dischargingRates_,
                ((bitField0_ & 0x00000004) != 0),
                getParentForChildren(),
                isClean());
        dischargingRates_ = null;
      }
      return dischargingRatesBuilder_;
    }

    private java.util.List<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRate>
        deBallastingRates_ = java.util.Collections.emptyList();

    private void ensureDeBallastingRatesIsMutable() {
      if (!((bitField0_ & 0x00000008) != 0)) {
        deBallastingRates_ =
            new java.util.ArrayList<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRate>(
                deBallastingRates_);
        bitField0_ |= 0x00000008;
      }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRate,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRate.Builder,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRateOrBuilder>
        deBallastingRatesBuilder_;

    /** <code>repeated .DeBallastingRate deBallastingRates = 11;</code> */
    public java.util.List<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRate>
        getDeBallastingRatesList() {
      if (deBallastingRatesBuilder_ == null) {
        return java.util.Collections.unmodifiableList(deBallastingRates_);
      } else {
        return deBallastingRatesBuilder_.getMessageList();
      }
    }
    /** <code>repeated .DeBallastingRate deBallastingRates = 11;</code> */
    public int getDeBallastingRatesCount() {
      if (deBallastingRatesBuilder_ == null) {
        return deBallastingRates_.size();
      } else {
        return deBallastingRatesBuilder_.getCount();
      }
    }
    /** <code>repeated .DeBallastingRate deBallastingRates = 11;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRate
        getDeBallastingRates(int index) {
      if (deBallastingRatesBuilder_ == null) {
        return deBallastingRates_.get(index);
      } else {
        return deBallastingRatesBuilder_.getMessage(index);
      }
    }
    /** <code>repeated .DeBallastingRate deBallastingRates = 11;</code> */
    public Builder setDeBallastingRates(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRate value) {
      if (deBallastingRatesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDeBallastingRatesIsMutable();
        deBallastingRates_.set(index, value);
        onChanged();
      } else {
        deBallastingRatesBuilder_.setMessage(index, value);
      }
      return this;
    }
    /** <code>repeated .DeBallastingRate deBallastingRates = 11;</code> */
    public Builder setDeBallastingRates(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRate.Builder
            builderForValue) {
      if (deBallastingRatesBuilder_ == null) {
        ensureDeBallastingRatesIsMutable();
        deBallastingRates_.set(index, builderForValue.build());
        onChanged();
      } else {
        deBallastingRatesBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .DeBallastingRate deBallastingRates = 11;</code> */
    public Builder addDeBallastingRates(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRate value) {
      if (deBallastingRatesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDeBallastingRatesIsMutable();
        deBallastingRates_.add(value);
        onChanged();
      } else {
        deBallastingRatesBuilder_.addMessage(value);
      }
      return this;
    }
    /** <code>repeated .DeBallastingRate deBallastingRates = 11;</code> */
    public Builder addDeBallastingRates(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRate value) {
      if (deBallastingRatesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDeBallastingRatesIsMutable();
        deBallastingRates_.add(index, value);
        onChanged();
      } else {
        deBallastingRatesBuilder_.addMessage(index, value);
      }
      return this;
    }
    /** <code>repeated .DeBallastingRate deBallastingRates = 11;</code> */
    public Builder addDeBallastingRates(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRate.Builder
            builderForValue) {
      if (deBallastingRatesBuilder_ == null) {
        ensureDeBallastingRatesIsMutable();
        deBallastingRates_.add(builderForValue.build());
        onChanged();
      } else {
        deBallastingRatesBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .DeBallastingRate deBallastingRates = 11;</code> */
    public Builder addDeBallastingRates(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRate.Builder
            builderForValue) {
      if (deBallastingRatesBuilder_ == null) {
        ensureDeBallastingRatesIsMutable();
        deBallastingRates_.add(index, builderForValue.build());
        onChanged();
      } else {
        deBallastingRatesBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .DeBallastingRate deBallastingRates = 11;</code> */
    public Builder addAllDeBallastingRates(
        java.lang.Iterable<
                ? extends
                    com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRate>
            values) {
      if (deBallastingRatesBuilder_ == null) {
        ensureDeBallastingRatesIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(values, deBallastingRates_);
        onChanged();
      } else {
        deBallastingRatesBuilder_.addAllMessages(values);
      }
      return this;
    }
    /** <code>repeated .DeBallastingRate deBallastingRates = 11;</code> */
    public Builder clearDeBallastingRates() {
      if (deBallastingRatesBuilder_ == null) {
        deBallastingRates_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000008);
        onChanged();
      } else {
        deBallastingRatesBuilder_.clear();
      }
      return this;
    }
    /** <code>repeated .DeBallastingRate deBallastingRates = 11;</code> */
    public Builder removeDeBallastingRates(int index) {
      if (deBallastingRatesBuilder_ == null) {
        ensureDeBallastingRatesIsMutable();
        deBallastingRates_.remove(index);
        onChanged();
      } else {
        deBallastingRatesBuilder_.remove(index);
      }
      return this;
    }
    /** <code>repeated .DeBallastingRate deBallastingRates = 11;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRate.Builder
        getDeBallastingRatesBuilder(int index) {
      return getDeBallastingRatesFieldBuilder().getBuilder(index);
    }
    /** <code>repeated .DeBallastingRate deBallastingRates = 11;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRateOrBuilder
        getDeBallastingRatesOrBuilder(int index) {
      if (deBallastingRatesBuilder_ == null) {
        return deBallastingRates_.get(index);
      } else {
        return deBallastingRatesBuilder_.getMessageOrBuilder(index);
      }
    }
    /** <code>repeated .DeBallastingRate deBallastingRates = 11;</code> */
    public java.util.List<
            ? extends
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRateOrBuilder>
        getDeBallastingRatesOrBuilderList() {
      if (deBallastingRatesBuilder_ != null) {
        return deBallastingRatesBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(deBallastingRates_);
      }
    }
    /** <code>repeated .DeBallastingRate deBallastingRates = 11;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRate.Builder
        addDeBallastingRatesBuilder() {
      return getDeBallastingRatesFieldBuilder()
          .addBuilder(
              com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRate
                  .getDefaultInstance());
    }
    /** <code>repeated .DeBallastingRate deBallastingRates = 11;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRate.Builder
        addDeBallastingRatesBuilder(int index) {
      return getDeBallastingRatesFieldBuilder()
          .addBuilder(
              index,
              com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRate
                  .getDefaultInstance());
    }
    /** <code>repeated .DeBallastingRate deBallastingRates = 11;</code> */
    public java.util.List<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRate.Builder>
        getDeBallastingRatesBuilderList() {
      return getDeBallastingRatesFieldBuilder().getBuilderList();
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRate,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRate.Builder,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRateOrBuilder>
        getDeBallastingRatesFieldBuilder() {
      if (deBallastingRatesBuilder_ == null) {
        deBallastingRatesBuilder_ =
            new com.google.protobuf.RepeatedFieldBuilderV3<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRate,
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.DeBallastingRate.Builder,
                com.cpdss.common.generated.loading_plan.LoadingPlanModels
                    .DeBallastingRateOrBuilder>(
                deBallastingRates_,
                ((bitField0_ & 0x00000008) != 0),
                getParentForChildren(),
                isClean());
        deBallastingRates_ = null;
      }
      return deBallastingRatesBuilder_;
    }

    private java.util.List<com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails>
        dischargePlanPortWiseDetails_ = java.util.Collections.emptyList();

    private void ensureDischargePlanPortWiseDetailsIsMutable() {
      if (!((bitField0_ & 0x00000010) != 0)) {
        dischargePlanPortWiseDetails_ =
            new java.util.ArrayList<
                com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails>(
                dischargePlanPortWiseDetails_);
        bitField0_ |= 0x00000010;
      }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails,
            com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails.Builder,
            com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetailsOrBuilder>
        dischargePlanPortWiseDetailsBuilder_;

    /** <code>repeated .DischargePlanPortWiseDetails dischargePlanPortWiseDetails = 12;</code> */
    public java.util.List<com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails>
        getDischargePlanPortWiseDetailsList() {
      if (dischargePlanPortWiseDetailsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(dischargePlanPortWiseDetails_);
      } else {
        return dischargePlanPortWiseDetailsBuilder_.getMessageList();
      }
    }
    /** <code>repeated .DischargePlanPortWiseDetails dischargePlanPortWiseDetails = 12;</code> */
    public int getDischargePlanPortWiseDetailsCount() {
      if (dischargePlanPortWiseDetailsBuilder_ == null) {
        return dischargePlanPortWiseDetails_.size();
      } else {
        return dischargePlanPortWiseDetailsBuilder_.getCount();
      }
    }
    /** <code>repeated .DischargePlanPortWiseDetails dischargePlanPortWiseDetails = 12;</code> */
    public com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails
        getDischargePlanPortWiseDetails(int index) {
      if (dischargePlanPortWiseDetailsBuilder_ == null) {
        return dischargePlanPortWiseDetails_.get(index);
      } else {
        return dischargePlanPortWiseDetailsBuilder_.getMessage(index);
      }
    }
    /** <code>repeated .DischargePlanPortWiseDetails dischargePlanPortWiseDetails = 12;</code> */
    public Builder setDischargePlanPortWiseDetails(
        int index, com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails value) {
      if (dischargePlanPortWiseDetailsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDischargePlanPortWiseDetailsIsMutable();
        dischargePlanPortWiseDetails_.set(index, value);
        onChanged();
      } else {
        dischargePlanPortWiseDetailsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /** <code>repeated .DischargePlanPortWiseDetails dischargePlanPortWiseDetails = 12;</code> */
    public Builder setDischargePlanPortWiseDetails(
        int index,
        com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails.Builder
            builderForValue) {
      if (dischargePlanPortWiseDetailsBuilder_ == null) {
        ensureDischargePlanPortWiseDetailsIsMutable();
        dischargePlanPortWiseDetails_.set(index, builderForValue.build());
        onChanged();
      } else {
        dischargePlanPortWiseDetailsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .DischargePlanPortWiseDetails dischargePlanPortWiseDetails = 12;</code> */
    public Builder addDischargePlanPortWiseDetails(
        com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails value) {
      if (dischargePlanPortWiseDetailsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDischargePlanPortWiseDetailsIsMutable();
        dischargePlanPortWiseDetails_.add(value);
        onChanged();
      } else {
        dischargePlanPortWiseDetailsBuilder_.addMessage(value);
      }
      return this;
    }
    /** <code>repeated .DischargePlanPortWiseDetails dischargePlanPortWiseDetails = 12;</code> */
    public Builder addDischargePlanPortWiseDetails(
        int index, com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails value) {
      if (dischargePlanPortWiseDetailsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDischargePlanPortWiseDetailsIsMutable();
        dischargePlanPortWiseDetails_.add(index, value);
        onChanged();
      } else {
        dischargePlanPortWiseDetailsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /** <code>repeated .DischargePlanPortWiseDetails dischargePlanPortWiseDetails = 12;</code> */
    public Builder addDischargePlanPortWiseDetails(
        com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails.Builder
            builderForValue) {
      if (dischargePlanPortWiseDetailsBuilder_ == null) {
        ensureDischargePlanPortWiseDetailsIsMutable();
        dischargePlanPortWiseDetails_.add(builderForValue.build());
        onChanged();
      } else {
        dischargePlanPortWiseDetailsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .DischargePlanPortWiseDetails dischargePlanPortWiseDetails = 12;</code> */
    public Builder addDischargePlanPortWiseDetails(
        int index,
        com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails.Builder
            builderForValue) {
      if (dischargePlanPortWiseDetailsBuilder_ == null) {
        ensureDischargePlanPortWiseDetailsIsMutable();
        dischargePlanPortWiseDetails_.add(index, builderForValue.build());
        onChanged();
      } else {
        dischargePlanPortWiseDetailsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .DischargePlanPortWiseDetails dischargePlanPortWiseDetails = 12;</code> */
    public Builder addAllDischargePlanPortWiseDetails(
        java.lang.Iterable<
                ? extends com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails>
            values) {
      if (dischargePlanPortWiseDetailsBuilder_ == null) {
        ensureDischargePlanPortWiseDetailsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, dischargePlanPortWiseDetails_);
        onChanged();
      } else {
        dischargePlanPortWiseDetailsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /** <code>repeated .DischargePlanPortWiseDetails dischargePlanPortWiseDetails = 12;</code> */
    public Builder clearDischargePlanPortWiseDetails() {
      if (dischargePlanPortWiseDetailsBuilder_ == null) {
        dischargePlanPortWiseDetails_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000010);
        onChanged();
      } else {
        dischargePlanPortWiseDetailsBuilder_.clear();
      }
      return this;
    }
    /** <code>repeated .DischargePlanPortWiseDetails dischargePlanPortWiseDetails = 12;</code> */
    public Builder removeDischargePlanPortWiseDetails(int index) {
      if (dischargePlanPortWiseDetailsBuilder_ == null) {
        ensureDischargePlanPortWiseDetailsIsMutable();
        dischargePlanPortWiseDetails_.remove(index);
        onChanged();
      } else {
        dischargePlanPortWiseDetailsBuilder_.remove(index);
      }
      return this;
    }
    /** <code>repeated .DischargePlanPortWiseDetails dischargePlanPortWiseDetails = 12;</code> */
    public com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails.Builder
        getDischargePlanPortWiseDetailsBuilder(int index) {
      return getDischargePlanPortWiseDetailsFieldBuilder().getBuilder(index);
    }
    /** <code>repeated .DischargePlanPortWiseDetails dischargePlanPortWiseDetails = 12;</code> */
    public com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetailsOrBuilder
        getDischargePlanPortWiseDetailsOrBuilder(int index) {
      if (dischargePlanPortWiseDetailsBuilder_ == null) {
        return dischargePlanPortWiseDetails_.get(index);
      } else {
        return dischargePlanPortWiseDetailsBuilder_.getMessageOrBuilder(index);
      }
    }
    /** <code>repeated .DischargePlanPortWiseDetails dischargePlanPortWiseDetails = 12;</code> */
    public java.util.List<
            ? extends
                com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetailsOrBuilder>
        getDischargePlanPortWiseDetailsOrBuilderList() {
      if (dischargePlanPortWiseDetailsBuilder_ != null) {
        return dischargePlanPortWiseDetailsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(dischargePlanPortWiseDetails_);
      }
    }
    /** <code>repeated .DischargePlanPortWiseDetails dischargePlanPortWiseDetails = 12;</code> */
    public com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails.Builder
        addDischargePlanPortWiseDetailsBuilder() {
      return getDischargePlanPortWiseDetailsFieldBuilder()
          .addBuilder(
              com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails
                  .getDefaultInstance());
    }
    /** <code>repeated .DischargePlanPortWiseDetails dischargePlanPortWiseDetails = 12;</code> */
    public com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails.Builder
        addDischargePlanPortWiseDetailsBuilder(int index) {
      return getDischargePlanPortWiseDetailsFieldBuilder()
          .addBuilder(
              index,
              com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails
                  .getDefaultInstance());
    }
    /** <code>repeated .DischargePlanPortWiseDetails dischargePlanPortWiseDetails = 12;</code> */
    public java.util.List<
            com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails.Builder>
        getDischargePlanPortWiseDetailsBuilderList() {
      return getDischargePlanPortWiseDetailsFieldBuilder().getBuilderList();
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails,
            com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails.Builder,
            com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetailsOrBuilder>
        getDischargePlanPortWiseDetailsFieldBuilder() {
      if (dischargePlanPortWiseDetailsBuilder_ == null) {
        dischargePlanPortWiseDetailsBuilder_ =
            new com.google.protobuf.RepeatedFieldBuilderV3<
                com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails,
                com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetails.Builder,
                com.cpdss.common.generated.discharge_plan.DischargePlanPortWiseDetailsOrBuilder>(
                dischargePlanPortWiseDetails_,
                ((bitField0_ & 0x00000010) != 0),
                getParentForChildren(),
                isClean());
        dischargePlanPortWiseDetails_ = null;
      }
      return dischargePlanPortWiseDetailsBuilder_;
    }

    private java.util.List<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanPortWiseDetails>
        dischargingPlanPortWiseDetails_ = java.util.Collections.emptyList();

    private void ensureDischargingPlanPortWiseDetailsIsMutable() {
      if (!((bitField0_ & 0x00000020) != 0)) {
        dischargingPlanPortWiseDetails_ =
            new java.util.ArrayList<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels
                    .LoadingPlanPortWiseDetails>(dischargingPlanPortWiseDetails_);
        bitField0_ |= 0x00000020;
      }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanPortWiseDetails,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanPortWiseDetails
                .Builder,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels
                .LoadingPlanPortWiseDetailsOrBuilder>
        dischargingPlanPortWiseDetailsBuilder_;

    /** <code>repeated .LoadingPlanPortWiseDetails dischargingPlanPortWiseDetails = 13;</code> */
    public java.util.List<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanPortWiseDetails>
        getDischargingPlanPortWiseDetailsList() {
      if (dischargingPlanPortWiseDetailsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(dischargingPlanPortWiseDetails_);
      } else {
        return dischargingPlanPortWiseDetailsBuilder_.getMessageList();
      }
    }
    /** <code>repeated .LoadingPlanPortWiseDetails dischargingPlanPortWiseDetails = 13;</code> */
    public int getDischargingPlanPortWiseDetailsCount() {
      if (dischargingPlanPortWiseDetailsBuilder_ == null) {
        return dischargingPlanPortWiseDetails_.size();
      } else {
        return dischargingPlanPortWiseDetailsBuilder_.getCount();
      }
    }
    /** <code>repeated .LoadingPlanPortWiseDetails dischargingPlanPortWiseDetails = 13;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanPortWiseDetails
        getDischargingPlanPortWiseDetails(int index) {
      if (dischargingPlanPortWiseDetailsBuilder_ == null) {
        return dischargingPlanPortWiseDetails_.get(index);
      } else {
        return dischargingPlanPortWiseDetailsBuilder_.getMessage(index);
      }
    }
    /** <code>repeated .LoadingPlanPortWiseDetails dischargingPlanPortWiseDetails = 13;</code> */
    public Builder setDischargingPlanPortWiseDetails(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanPortWiseDetails
            value) {
      if (dischargingPlanPortWiseDetailsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDischargingPlanPortWiseDetailsIsMutable();
        dischargingPlanPortWiseDetails_.set(index, value);
        onChanged();
      } else {
        dischargingPlanPortWiseDetailsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /** <code>repeated .LoadingPlanPortWiseDetails dischargingPlanPortWiseDetails = 13;</code> */
    public Builder setDischargingPlanPortWiseDetails(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanPortWiseDetails.Builder
            builderForValue) {
      if (dischargingPlanPortWiseDetailsBuilder_ == null) {
        ensureDischargingPlanPortWiseDetailsIsMutable();
        dischargingPlanPortWiseDetails_.set(index, builderForValue.build());
        onChanged();
      } else {
        dischargingPlanPortWiseDetailsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .LoadingPlanPortWiseDetails dischargingPlanPortWiseDetails = 13;</code> */
    public Builder addDischargingPlanPortWiseDetails(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanPortWiseDetails
            value) {
      if (dischargingPlanPortWiseDetailsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDischargingPlanPortWiseDetailsIsMutable();
        dischargingPlanPortWiseDetails_.add(value);
        onChanged();
      } else {
        dischargingPlanPortWiseDetailsBuilder_.addMessage(value);
      }
      return this;
    }
    /** <code>repeated .LoadingPlanPortWiseDetails dischargingPlanPortWiseDetails = 13;</code> */
    public Builder addDischargingPlanPortWiseDetails(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanPortWiseDetails
            value) {
      if (dischargingPlanPortWiseDetailsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDischargingPlanPortWiseDetailsIsMutable();
        dischargingPlanPortWiseDetails_.add(index, value);
        onChanged();
      } else {
        dischargingPlanPortWiseDetailsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /** <code>repeated .LoadingPlanPortWiseDetails dischargingPlanPortWiseDetails = 13;</code> */
    public Builder addDischargingPlanPortWiseDetails(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanPortWiseDetails.Builder
            builderForValue) {
      if (dischargingPlanPortWiseDetailsBuilder_ == null) {
        ensureDischargingPlanPortWiseDetailsIsMutable();
        dischargingPlanPortWiseDetails_.add(builderForValue.build());
        onChanged();
      } else {
        dischargingPlanPortWiseDetailsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .LoadingPlanPortWiseDetails dischargingPlanPortWiseDetails = 13;</code> */
    public Builder addDischargingPlanPortWiseDetails(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanPortWiseDetails.Builder
            builderForValue) {
      if (dischargingPlanPortWiseDetailsBuilder_ == null) {
        ensureDischargingPlanPortWiseDetailsIsMutable();
        dischargingPlanPortWiseDetails_.add(index, builderForValue.build());
        onChanged();
      } else {
        dischargingPlanPortWiseDetailsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .LoadingPlanPortWiseDetails dischargingPlanPortWiseDetails = 13;</code> */
    public Builder addAllDischargingPlanPortWiseDetails(
        java.lang.Iterable<
                ? extends
                    com.cpdss.common.generated.loading_plan.LoadingPlanModels
                        .LoadingPlanPortWiseDetails>
            values) {
      if (dischargingPlanPortWiseDetailsBuilder_ == null) {
        ensureDischargingPlanPortWiseDetailsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, dischargingPlanPortWiseDetails_);
        onChanged();
      } else {
        dischargingPlanPortWiseDetailsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /** <code>repeated .LoadingPlanPortWiseDetails dischargingPlanPortWiseDetails = 13;</code> */
    public Builder clearDischargingPlanPortWiseDetails() {
      if (dischargingPlanPortWiseDetailsBuilder_ == null) {
        dischargingPlanPortWiseDetails_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000020);
        onChanged();
      } else {
        dischargingPlanPortWiseDetailsBuilder_.clear();
      }
      return this;
    }
    /** <code>repeated .LoadingPlanPortWiseDetails dischargingPlanPortWiseDetails = 13;</code> */
    public Builder removeDischargingPlanPortWiseDetails(int index) {
      if (dischargingPlanPortWiseDetailsBuilder_ == null) {
        ensureDischargingPlanPortWiseDetailsIsMutable();
        dischargingPlanPortWiseDetails_.remove(index);
        onChanged();
      } else {
        dischargingPlanPortWiseDetailsBuilder_.remove(index);
      }
      return this;
    }
    /** <code>repeated .LoadingPlanPortWiseDetails dischargingPlanPortWiseDetails = 13;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanPortWiseDetails
            .Builder
        getDischargingPlanPortWiseDetailsBuilder(int index) {
      return getDischargingPlanPortWiseDetailsFieldBuilder().getBuilder(index);
    }
    /** <code>repeated .LoadingPlanPortWiseDetails dischargingPlanPortWiseDetails = 13;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels
            .LoadingPlanPortWiseDetailsOrBuilder
        getDischargingPlanPortWiseDetailsOrBuilder(int index) {
      if (dischargingPlanPortWiseDetailsBuilder_ == null) {
        return dischargingPlanPortWiseDetails_.get(index);
      } else {
        return dischargingPlanPortWiseDetailsBuilder_.getMessageOrBuilder(index);
      }
    }
    /** <code>repeated .LoadingPlanPortWiseDetails dischargingPlanPortWiseDetails = 13;</code> */
    public java.util.List<
            ? extends
                com.cpdss.common.generated.loading_plan.LoadingPlanModels
                    .LoadingPlanPortWiseDetailsOrBuilder>
        getDischargingPlanPortWiseDetailsOrBuilderList() {
      if (dischargingPlanPortWiseDetailsBuilder_ != null) {
        return dischargingPlanPortWiseDetailsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(dischargingPlanPortWiseDetails_);
      }
    }
    /** <code>repeated .LoadingPlanPortWiseDetails dischargingPlanPortWiseDetails = 13;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanPortWiseDetails
            .Builder
        addDischargingPlanPortWiseDetailsBuilder() {
      return getDischargingPlanPortWiseDetailsFieldBuilder()
          .addBuilder(
              com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanPortWiseDetails
                  .getDefaultInstance());
    }
    /** <code>repeated .LoadingPlanPortWiseDetails dischargingPlanPortWiseDetails = 13;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanPortWiseDetails
            .Builder
        addDischargingPlanPortWiseDetailsBuilder(int index) {
      return getDischargingPlanPortWiseDetailsFieldBuilder()
          .addBuilder(
              index,
              com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanPortWiseDetails
                  .getDefaultInstance());
    }
    /** <code>repeated .LoadingPlanPortWiseDetails dischargingPlanPortWiseDetails = 13;</code> */
    public java.util.List<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanPortWiseDetails
                .Builder>
        getDischargingPlanPortWiseDetailsBuilderList() {
      return getDischargingPlanPortWiseDetailsFieldBuilder().getBuilderList();
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanPortWiseDetails,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanPortWiseDetails
                .Builder,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels
                .LoadingPlanPortWiseDetailsOrBuilder>
        getDischargingPlanPortWiseDetailsFieldBuilder() {
      if (dischargingPlanPortWiseDetailsBuilder_ == null) {
        dischargingPlanPortWiseDetailsBuilder_ =
            new com.google.protobuf.RepeatedFieldBuilderV3<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels
                    .LoadingPlanPortWiseDetails,
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanPortWiseDetails
                    .Builder,
                com.cpdss.common.generated.loading_plan.LoadingPlanModels
                    .LoadingPlanPortWiseDetailsOrBuilder>(
                dischargingPlanPortWiseDetails_,
                ((bitField0_ & 0x00000020) != 0),
                getParentForChildren(),
                isClean());
        dischargingPlanPortWiseDetails_ = null;
      }
      return dischargingPlanPortWiseDetailsBuilder_;
    }

    private java.lang.Object cargoDischargingRate1_ = "";
    /**
     * <code>string cargoDischargingRate1 = 14;</code>
     *
     * @return The cargoDischargingRate1.
     */
    public java.lang.String getCargoDischargingRate1() {
      java.lang.Object ref = cargoDischargingRate1_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        cargoDischargingRate1_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string cargoDischargingRate1 = 14;</code>
     *
     * @return The bytes for cargoDischargingRate1.
     */
    public com.google.protobuf.ByteString getCargoDischargingRate1Bytes() {
      java.lang.Object ref = cargoDischargingRate1_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        cargoDischargingRate1_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string cargoDischargingRate1 = 14;</code>
     *
     * @param value The cargoDischargingRate1 to set.
     * @return This builder for chaining.
     */
    public Builder setCargoDischargingRate1(java.lang.String value) {
      if (value == null) {
        throw new NullPointerException();
      }

      cargoDischargingRate1_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string cargoDischargingRate1 = 14;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearCargoDischargingRate1() {

      cargoDischargingRate1_ = getDefaultInstance().getCargoDischargingRate1();
      onChanged();
      return this;
    }
    /**
     * <code>string cargoDischargingRate1 = 14;</code>
     *
     * @param value The bytes for cargoDischargingRate1 to set.
     * @return This builder for chaining.
     */
    public Builder setCargoDischargingRate1Bytes(com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      checkByteStringIsUtf8(value);

      cargoDischargingRate1_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object cargoDischargingRate2_ = "";
    /**
     * <code>string cargoDischargingRate2 = 15;</code>
     *
     * @return The cargoDischargingRate2.
     */
    public java.lang.String getCargoDischargingRate2() {
      java.lang.Object ref = cargoDischargingRate2_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        cargoDischargingRate2_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string cargoDischargingRate2 = 15;</code>
     *
     * @return The bytes for cargoDischargingRate2.
     */
    public com.google.protobuf.ByteString getCargoDischargingRate2Bytes() {
      java.lang.Object ref = cargoDischargingRate2_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        cargoDischargingRate2_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string cargoDischargingRate2 = 15;</code>
     *
     * @param value The cargoDischargingRate2 to set.
     * @return This builder for chaining.
     */
    public Builder setCargoDischargingRate2(java.lang.String value) {
      if (value == null) {
        throw new NullPointerException();
      }

      cargoDischargingRate2_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string cargoDischargingRate2 = 15;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearCargoDischargingRate2() {

      cargoDischargingRate2_ = getDefaultInstance().getCargoDischargingRate2();
      onChanged();
      return this;
    }
    /**
     * <code>string cargoDischargingRate2 = 15;</code>
     *
     * @param value The bytes for cargoDischargingRate2 to set.
     * @return This builder for chaining.
     */
    public Builder setCargoDischargingRate2Bytes(com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      checkByteStringIsUtf8(value);

      cargoDischargingRate2_ = value;
      onChanged();
      return this;
    }

    private java.util.List<com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperation>
        ballastOperations_ = java.util.Collections.emptyList();

    private void ensureBallastOperationsIsMutable() {
      if (!((bitField0_ & 0x00000040) != 0)) {
        ballastOperations_ =
            new java.util.ArrayList<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperation>(
                ballastOperations_);
        bitField0_ |= 0x00000040;
      }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperation,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperation.Builder,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperationOrBuilder>
        ballastOperationsBuilder_;

    /** <code>repeated .PumpOperation ballastOperations = 16;</code> */
    public java.util.List<com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperation>
        getBallastOperationsList() {
      if (ballastOperationsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(ballastOperations_);
      } else {
        return ballastOperationsBuilder_.getMessageList();
      }
    }
    /** <code>repeated .PumpOperation ballastOperations = 16;</code> */
    public int getBallastOperationsCount() {
      if (ballastOperationsBuilder_ == null) {
        return ballastOperations_.size();
      } else {
        return ballastOperationsBuilder_.getCount();
      }
    }
    /** <code>repeated .PumpOperation ballastOperations = 16;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperation
        getBallastOperations(int index) {
      if (ballastOperationsBuilder_ == null) {
        return ballastOperations_.get(index);
      } else {
        return ballastOperationsBuilder_.getMessage(index);
      }
    }
    /** <code>repeated .PumpOperation ballastOperations = 16;</code> */
    public Builder setBallastOperations(
        int index, com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperation value) {
      if (ballastOperationsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureBallastOperationsIsMutable();
        ballastOperations_.set(index, value);
        onChanged();
      } else {
        ballastOperationsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /** <code>repeated .PumpOperation ballastOperations = 16;</code> */
    public Builder setBallastOperations(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperation.Builder
            builderForValue) {
      if (ballastOperationsBuilder_ == null) {
        ensureBallastOperationsIsMutable();
        ballastOperations_.set(index, builderForValue.build());
        onChanged();
      } else {
        ballastOperationsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .PumpOperation ballastOperations = 16;</code> */
    public Builder addBallastOperations(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperation value) {
      if (ballastOperationsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureBallastOperationsIsMutable();
        ballastOperations_.add(value);
        onChanged();
      } else {
        ballastOperationsBuilder_.addMessage(value);
      }
      return this;
    }
    /** <code>repeated .PumpOperation ballastOperations = 16;</code> */
    public Builder addBallastOperations(
        int index, com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperation value) {
      if (ballastOperationsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureBallastOperationsIsMutable();
        ballastOperations_.add(index, value);
        onChanged();
      } else {
        ballastOperationsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /** <code>repeated .PumpOperation ballastOperations = 16;</code> */
    public Builder addBallastOperations(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperation.Builder
            builderForValue) {
      if (ballastOperationsBuilder_ == null) {
        ensureBallastOperationsIsMutable();
        ballastOperations_.add(builderForValue.build());
        onChanged();
      } else {
        ballastOperationsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .PumpOperation ballastOperations = 16;</code> */
    public Builder addBallastOperations(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperation.Builder
            builderForValue) {
      if (ballastOperationsBuilder_ == null) {
        ensureBallastOperationsIsMutable();
        ballastOperations_.add(index, builderForValue.build());
        onChanged();
      } else {
        ballastOperationsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .PumpOperation ballastOperations = 16;</code> */
    public Builder addAllBallastOperations(
        java.lang.Iterable<
                ? extends com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperation>
            values) {
      if (ballastOperationsBuilder_ == null) {
        ensureBallastOperationsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(values, ballastOperations_);
        onChanged();
      } else {
        ballastOperationsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /** <code>repeated .PumpOperation ballastOperations = 16;</code> */
    public Builder clearBallastOperations() {
      if (ballastOperationsBuilder_ == null) {
        ballastOperations_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000040);
        onChanged();
      } else {
        ballastOperationsBuilder_.clear();
      }
      return this;
    }
    /** <code>repeated .PumpOperation ballastOperations = 16;</code> */
    public Builder removeBallastOperations(int index) {
      if (ballastOperationsBuilder_ == null) {
        ensureBallastOperationsIsMutable();
        ballastOperations_.remove(index);
        onChanged();
      } else {
        ballastOperationsBuilder_.remove(index);
      }
      return this;
    }
    /** <code>repeated .PumpOperation ballastOperations = 16;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperation.Builder
        getBallastOperationsBuilder(int index) {
      return getBallastOperationsFieldBuilder().getBuilder(index);
    }
    /** <code>repeated .PumpOperation ballastOperations = 16;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperationOrBuilder
        getBallastOperationsOrBuilder(int index) {
      if (ballastOperationsBuilder_ == null) {
        return ballastOperations_.get(index);
      } else {
        return ballastOperationsBuilder_.getMessageOrBuilder(index);
      }
    }
    /** <code>repeated .PumpOperation ballastOperations = 16;</code> */
    public java.util.List<
            ? extends
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperationOrBuilder>
        getBallastOperationsOrBuilderList() {
      if (ballastOperationsBuilder_ != null) {
        return ballastOperationsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(ballastOperations_);
      }
    }
    /** <code>repeated .PumpOperation ballastOperations = 16;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperation.Builder
        addBallastOperationsBuilder() {
      return getBallastOperationsFieldBuilder()
          .addBuilder(
              com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperation
                  .getDefaultInstance());
    }
    /** <code>repeated .PumpOperation ballastOperations = 16;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperation.Builder
        addBallastOperationsBuilder(int index) {
      return getBallastOperationsFieldBuilder()
          .addBuilder(
              index,
              com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperation
                  .getDefaultInstance());
    }
    /** <code>repeated .PumpOperation ballastOperations = 16;</code> */
    public java.util.List<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperation.Builder>
        getBallastOperationsBuilderList() {
      return getBallastOperationsFieldBuilder().getBuilderList();
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperation,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperation.Builder,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperationOrBuilder>
        getBallastOperationsFieldBuilder() {
      if (ballastOperationsBuilder_ == null) {
        ballastOperationsBuilder_ =
            new com.google.protobuf.RepeatedFieldBuilderV3<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperation,
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperation.Builder,
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperationOrBuilder>(
                ballastOperations_,
                ((bitField0_ & 0x00000040) != 0),
                getParentForChildren(),
                isClean());
        ballastOperations_ = null;
      }
      return ballastOperationsBuilder_;
    }

    private java.util.List<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.EductorOperation>
        eductorOperation_ = java.util.Collections.emptyList();

    private void ensureEductorOperationIsMutable() {
      if (!((bitField0_ & 0x00000080) != 0)) {
        eductorOperation_ =
            new java.util.ArrayList<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.EductorOperation>(
                eductorOperation_);
        bitField0_ |= 0x00000080;
      }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.EductorOperation,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.EductorOperation.Builder,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.EductorOperationOrBuilder>
        eductorOperationBuilder_;

    /** <code>repeated .EductorOperation eductorOperation = 17;</code> */
    public java.util.List<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.EductorOperation>
        getEductorOperationList() {
      if (eductorOperationBuilder_ == null) {
        return java.util.Collections.unmodifiableList(eductorOperation_);
      } else {
        return eductorOperationBuilder_.getMessageList();
      }
    }
    /** <code>repeated .EductorOperation eductorOperation = 17;</code> */
    public int getEductorOperationCount() {
      if (eductorOperationBuilder_ == null) {
        return eductorOperation_.size();
      } else {
        return eductorOperationBuilder_.getCount();
      }
    }
    /** <code>repeated .EductorOperation eductorOperation = 17;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.EductorOperation
        getEductorOperation(int index) {
      if (eductorOperationBuilder_ == null) {
        return eductorOperation_.get(index);
      } else {
        return eductorOperationBuilder_.getMessage(index);
      }
    }
    /** <code>repeated .EductorOperation eductorOperation = 17;</code> */
    public Builder setEductorOperation(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.EductorOperation value) {
      if (eductorOperationBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureEductorOperationIsMutable();
        eductorOperation_.set(index, value);
        onChanged();
      } else {
        eductorOperationBuilder_.setMessage(index, value);
      }
      return this;
    }
    /** <code>repeated .EductorOperation eductorOperation = 17;</code> */
    public Builder setEductorOperation(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.EductorOperation.Builder
            builderForValue) {
      if (eductorOperationBuilder_ == null) {
        ensureEductorOperationIsMutable();
        eductorOperation_.set(index, builderForValue.build());
        onChanged();
      } else {
        eductorOperationBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .EductorOperation eductorOperation = 17;</code> */
    public Builder addEductorOperation(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.EductorOperation value) {
      if (eductorOperationBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureEductorOperationIsMutable();
        eductorOperation_.add(value);
        onChanged();
      } else {
        eductorOperationBuilder_.addMessage(value);
      }
      return this;
    }
    /** <code>repeated .EductorOperation eductorOperation = 17;</code> */
    public Builder addEductorOperation(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.EductorOperation value) {
      if (eductorOperationBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureEductorOperationIsMutable();
        eductorOperation_.add(index, value);
        onChanged();
      } else {
        eductorOperationBuilder_.addMessage(index, value);
      }
      return this;
    }
    /** <code>repeated .EductorOperation eductorOperation = 17;</code> */
    public Builder addEductorOperation(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.EductorOperation.Builder
            builderForValue) {
      if (eductorOperationBuilder_ == null) {
        ensureEductorOperationIsMutable();
        eductorOperation_.add(builderForValue.build());
        onChanged();
      } else {
        eductorOperationBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .EductorOperation eductorOperation = 17;</code> */
    public Builder addEductorOperation(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.EductorOperation.Builder
            builderForValue) {
      if (eductorOperationBuilder_ == null) {
        ensureEductorOperationIsMutable();
        eductorOperation_.add(index, builderForValue.build());
        onChanged();
      } else {
        eductorOperationBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .EductorOperation eductorOperation = 17;</code> */
    public Builder addAllEductorOperation(
        java.lang.Iterable<
                ? extends
                    com.cpdss.common.generated.loading_plan.LoadingPlanModels.EductorOperation>
            values) {
      if (eductorOperationBuilder_ == null) {
        ensureEductorOperationIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(values, eductorOperation_);
        onChanged();
      } else {
        eductorOperationBuilder_.addAllMessages(values);
      }
      return this;
    }
    /** <code>repeated .EductorOperation eductorOperation = 17;</code> */
    public Builder clearEductorOperation() {
      if (eductorOperationBuilder_ == null) {
        eductorOperation_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000080);
        onChanged();
      } else {
        eductorOperationBuilder_.clear();
      }
      return this;
    }
    /** <code>repeated .EductorOperation eductorOperation = 17;</code> */
    public Builder removeEductorOperation(int index) {
      if (eductorOperationBuilder_ == null) {
        ensureEductorOperationIsMutable();
        eductorOperation_.remove(index);
        onChanged();
      } else {
        eductorOperationBuilder_.remove(index);
      }
      return this;
    }
    /** <code>repeated .EductorOperation eductorOperation = 17;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.EductorOperation.Builder
        getEductorOperationBuilder(int index) {
      return getEductorOperationFieldBuilder().getBuilder(index);
    }
    /** <code>repeated .EductorOperation eductorOperation = 17;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.EductorOperationOrBuilder
        getEductorOperationOrBuilder(int index) {
      if (eductorOperationBuilder_ == null) {
        return eductorOperation_.get(index);
      } else {
        return eductorOperationBuilder_.getMessageOrBuilder(index);
      }
    }
    /** <code>repeated .EductorOperation eductorOperation = 17;</code> */
    public java.util.List<
            ? extends
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.EductorOperationOrBuilder>
        getEductorOperationOrBuilderList() {
      if (eductorOperationBuilder_ != null) {
        return eductorOperationBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(eductorOperation_);
      }
    }
    /** <code>repeated .EductorOperation eductorOperation = 17;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.EductorOperation.Builder
        addEductorOperationBuilder() {
      return getEductorOperationFieldBuilder()
          .addBuilder(
              com.cpdss.common.generated.loading_plan.LoadingPlanModels.EductorOperation
                  .getDefaultInstance());
    }
    /** <code>repeated .EductorOperation eductorOperation = 17;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.EductorOperation.Builder
        addEductorOperationBuilder(int index) {
      return getEductorOperationFieldBuilder()
          .addBuilder(
              index,
              com.cpdss.common.generated.loading_plan.LoadingPlanModels.EductorOperation
                  .getDefaultInstance());
    }
    /** <code>repeated .EductorOperation eductorOperation = 17;</code> */
    public java.util.List<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.EductorOperation.Builder>
        getEductorOperationBuilderList() {
      return getEductorOperationFieldBuilder().getBuilderList();
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.EductorOperation,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.EductorOperation.Builder,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.EductorOperationOrBuilder>
        getEductorOperationFieldBuilder() {
      if (eductorOperationBuilder_ == null) {
        eductorOperationBuilder_ =
            new com.google.protobuf.RepeatedFieldBuilderV3<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.EductorOperation,
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.EductorOperation.Builder,
                com.cpdss.common.generated.loading_plan.LoadingPlanModels
                    .EductorOperationOrBuilder>(
                eductorOperation_,
                ((bitField0_ & 0x00000080) != 0),
                getParentForChildren(),
                isClean());
        eductorOperation_ = null;
      }
      return eductorOperationBuilder_;
    }

    private com.cpdss.common.generated.discharge_plan.CleaningTanks cleaningTanks_;
    private com.google.protobuf.SingleFieldBuilderV3<
            com.cpdss.common.generated.discharge_plan.CleaningTanks,
            com.cpdss.common.generated.discharge_plan.CleaningTanks.Builder,
            com.cpdss.common.generated.discharge_plan.CleaningTanksOrBuilder>
        cleaningTanksBuilder_;
    /**
     * <code>.CleaningTanks cleaningTanks = 18;</code>
     *
     * @return Whether the cleaningTanks field is set.
     */
    public boolean hasCleaningTanks() {
      return cleaningTanksBuilder_ != null || cleaningTanks_ != null;
    }
    /**
     * <code>.CleaningTanks cleaningTanks = 18;</code>
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
    /** <code>.CleaningTanks cleaningTanks = 18;</code> */
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
    /** <code>.CleaningTanks cleaningTanks = 18;</code> */
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
    /** <code>.CleaningTanks cleaningTanks = 18;</code> */
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
    /** <code>.CleaningTanks cleaningTanks = 18;</code> */
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
    /** <code>.CleaningTanks cleaningTanks = 18;</code> */
    public com.cpdss.common.generated.discharge_plan.CleaningTanks.Builder
        getCleaningTanksBuilder() {

      onChanged();
      return getCleaningTanksFieldBuilder().getBuilder();
    }
    /** <code>.CleaningTanks cleaningTanks = 18;</code> */
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
    /** <code>.CleaningTanks cleaningTanks = 18;</code> */
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

    private java.util.List<com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperation>
        cargoOperations_ = java.util.Collections.emptyList();

    private void ensureCargoOperationsIsMutable() {
      if (!((bitField0_ & 0x00000100) != 0)) {
        cargoOperations_ =
            new java.util.ArrayList<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperation>(
                cargoOperations_);
        bitField0_ |= 0x00000100;
      }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperation,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperation.Builder,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperationOrBuilder>
        cargoOperationsBuilder_;

    /** <code>repeated .PumpOperation cargoOperations = 19;</code> */
    public java.util.List<com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperation>
        getCargoOperationsList() {
      if (cargoOperationsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(cargoOperations_);
      } else {
        return cargoOperationsBuilder_.getMessageList();
      }
    }
    /** <code>repeated .PumpOperation cargoOperations = 19;</code> */
    public int getCargoOperationsCount() {
      if (cargoOperationsBuilder_ == null) {
        return cargoOperations_.size();
      } else {
        return cargoOperationsBuilder_.getCount();
      }
    }
    /** <code>repeated .PumpOperation cargoOperations = 19;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperation
        getCargoOperations(int index) {
      if (cargoOperationsBuilder_ == null) {
        return cargoOperations_.get(index);
      } else {
        return cargoOperationsBuilder_.getMessage(index);
      }
    }
    /** <code>repeated .PumpOperation cargoOperations = 19;</code> */
    public Builder setCargoOperations(
        int index, com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperation value) {
      if (cargoOperationsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureCargoOperationsIsMutable();
        cargoOperations_.set(index, value);
        onChanged();
      } else {
        cargoOperationsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /** <code>repeated .PumpOperation cargoOperations = 19;</code> */
    public Builder setCargoOperations(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperation.Builder
            builderForValue) {
      if (cargoOperationsBuilder_ == null) {
        ensureCargoOperationsIsMutable();
        cargoOperations_.set(index, builderForValue.build());
        onChanged();
      } else {
        cargoOperationsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .PumpOperation cargoOperations = 19;</code> */
    public Builder addCargoOperations(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperation value) {
      if (cargoOperationsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureCargoOperationsIsMutable();
        cargoOperations_.add(value);
        onChanged();
      } else {
        cargoOperationsBuilder_.addMessage(value);
      }
      return this;
    }
    /** <code>repeated .PumpOperation cargoOperations = 19;</code> */
    public Builder addCargoOperations(
        int index, com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperation value) {
      if (cargoOperationsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureCargoOperationsIsMutable();
        cargoOperations_.add(index, value);
        onChanged();
      } else {
        cargoOperationsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /** <code>repeated .PumpOperation cargoOperations = 19;</code> */
    public Builder addCargoOperations(
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperation.Builder
            builderForValue) {
      if (cargoOperationsBuilder_ == null) {
        ensureCargoOperationsIsMutable();
        cargoOperations_.add(builderForValue.build());
        onChanged();
      } else {
        cargoOperationsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .PumpOperation cargoOperations = 19;</code> */
    public Builder addCargoOperations(
        int index,
        com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperation.Builder
            builderForValue) {
      if (cargoOperationsBuilder_ == null) {
        ensureCargoOperationsIsMutable();
        cargoOperations_.add(index, builderForValue.build());
        onChanged();
      } else {
        cargoOperationsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .PumpOperation cargoOperations = 19;</code> */
    public Builder addAllCargoOperations(
        java.lang.Iterable<
                ? extends com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperation>
            values) {
      if (cargoOperationsBuilder_ == null) {
        ensureCargoOperationsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(values, cargoOperations_);
        onChanged();
      } else {
        cargoOperationsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /** <code>repeated .PumpOperation cargoOperations = 19;</code> */
    public Builder clearCargoOperations() {
      if (cargoOperationsBuilder_ == null) {
        cargoOperations_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000100);
        onChanged();
      } else {
        cargoOperationsBuilder_.clear();
      }
      return this;
    }
    /** <code>repeated .PumpOperation cargoOperations = 19;</code> */
    public Builder removeCargoOperations(int index) {
      if (cargoOperationsBuilder_ == null) {
        ensureCargoOperationsIsMutable();
        cargoOperations_.remove(index);
        onChanged();
      } else {
        cargoOperationsBuilder_.remove(index);
      }
      return this;
    }
    /** <code>repeated .PumpOperation cargoOperations = 19;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperation.Builder
        getCargoOperationsBuilder(int index) {
      return getCargoOperationsFieldBuilder().getBuilder(index);
    }
    /** <code>repeated .PumpOperation cargoOperations = 19;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperationOrBuilder
        getCargoOperationsOrBuilder(int index) {
      if (cargoOperationsBuilder_ == null) {
        return cargoOperations_.get(index);
      } else {
        return cargoOperationsBuilder_.getMessageOrBuilder(index);
      }
    }
    /** <code>repeated .PumpOperation cargoOperations = 19;</code> */
    public java.util.List<
            ? extends
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperationOrBuilder>
        getCargoOperationsOrBuilderList() {
      if (cargoOperationsBuilder_ != null) {
        return cargoOperationsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(cargoOperations_);
      }
    }
    /** <code>repeated .PumpOperation cargoOperations = 19;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperation.Builder
        addCargoOperationsBuilder() {
      return getCargoOperationsFieldBuilder()
          .addBuilder(
              com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperation
                  .getDefaultInstance());
    }
    /** <code>repeated .PumpOperation cargoOperations = 19;</code> */
    public com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperation.Builder
        addCargoOperationsBuilder(int index) {
      return getCargoOperationsFieldBuilder()
          .addBuilder(
              index,
              com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperation
                  .getDefaultInstance());
    }
    /** <code>repeated .PumpOperation cargoOperations = 19;</code> */
    public java.util.List<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperation.Builder>
        getCargoOperationsBuilderList() {
      return getCargoOperationsFieldBuilder().getBuilderList();
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperation,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperation.Builder,
            com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperationOrBuilder>
        getCargoOperationsFieldBuilder() {
      if (cargoOperationsBuilder_ == null) {
        cargoOperationsBuilder_ =
            new com.google.protobuf.RepeatedFieldBuilderV3<
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperation,
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperation.Builder,
                com.cpdss.common.generated.loading_plan.LoadingPlanModels.PumpOperationOrBuilder>(
                cargoOperations_,
                ((bitField0_ & 0x00000100) != 0),
                getParentForChildren(),
                isClean());
        cargoOperations_ = null;
      }
      return cargoOperationsBuilder_;
    }

    private java.util.List<com.cpdss.common.generated.discharge_plan.TankTransfer> tankTransfers_ =
        java.util.Collections.emptyList();

    private void ensureTankTransfersIsMutable() {
      if (!((bitField0_ & 0x00000200) != 0)) {
        tankTransfers_ =
            new java.util.ArrayList<com.cpdss.common.generated.discharge_plan.TankTransfer>(
                tankTransfers_);
        bitField0_ |= 0x00000200;
      }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.discharge_plan.TankTransfer,
            com.cpdss.common.generated.discharge_plan.TankTransfer.Builder,
            com.cpdss.common.generated.discharge_plan.TankTransferOrBuilder>
        tankTransfersBuilder_;

    /** <code>repeated .TankTransfer tankTransfers = 20;</code> */
    public java.util.List<com.cpdss.common.generated.discharge_plan.TankTransfer>
        getTankTransfersList() {
      if (tankTransfersBuilder_ == null) {
        return java.util.Collections.unmodifiableList(tankTransfers_);
      } else {
        return tankTransfersBuilder_.getMessageList();
      }
    }
    /** <code>repeated .TankTransfer tankTransfers = 20;</code> */
    public int getTankTransfersCount() {
      if (tankTransfersBuilder_ == null) {
        return tankTransfers_.size();
      } else {
        return tankTransfersBuilder_.getCount();
      }
    }
    /** <code>repeated .TankTransfer tankTransfers = 20;</code> */
    public com.cpdss.common.generated.discharge_plan.TankTransfer getTankTransfers(int index) {
      if (tankTransfersBuilder_ == null) {
        return tankTransfers_.get(index);
      } else {
        return tankTransfersBuilder_.getMessage(index);
      }
    }
    /** <code>repeated .TankTransfer tankTransfers = 20;</code> */
    public Builder setTankTransfers(
        int index, com.cpdss.common.generated.discharge_plan.TankTransfer value) {
      if (tankTransfersBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureTankTransfersIsMutable();
        tankTransfers_.set(index, value);
        onChanged();
      } else {
        tankTransfersBuilder_.setMessage(index, value);
      }
      return this;
    }
    /** <code>repeated .TankTransfer tankTransfers = 20;</code> */
    public Builder setTankTransfers(
        int index, com.cpdss.common.generated.discharge_plan.TankTransfer.Builder builderForValue) {
      if (tankTransfersBuilder_ == null) {
        ensureTankTransfersIsMutable();
        tankTransfers_.set(index, builderForValue.build());
        onChanged();
      } else {
        tankTransfersBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .TankTransfer tankTransfers = 20;</code> */
    public Builder addTankTransfers(com.cpdss.common.generated.discharge_plan.TankTransfer value) {
      if (tankTransfersBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureTankTransfersIsMutable();
        tankTransfers_.add(value);
        onChanged();
      } else {
        tankTransfersBuilder_.addMessage(value);
      }
      return this;
    }
    /** <code>repeated .TankTransfer tankTransfers = 20;</code> */
    public Builder addTankTransfers(
        int index, com.cpdss.common.generated.discharge_plan.TankTransfer value) {
      if (tankTransfersBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureTankTransfersIsMutable();
        tankTransfers_.add(index, value);
        onChanged();
      } else {
        tankTransfersBuilder_.addMessage(index, value);
      }
      return this;
    }
    /** <code>repeated .TankTransfer tankTransfers = 20;</code> */
    public Builder addTankTransfers(
        com.cpdss.common.generated.discharge_plan.TankTransfer.Builder builderForValue) {
      if (tankTransfersBuilder_ == null) {
        ensureTankTransfersIsMutable();
        tankTransfers_.add(builderForValue.build());
        onChanged();
      } else {
        tankTransfersBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .TankTransfer tankTransfers = 20;</code> */
    public Builder addTankTransfers(
        int index, com.cpdss.common.generated.discharge_plan.TankTransfer.Builder builderForValue) {
      if (tankTransfersBuilder_ == null) {
        ensureTankTransfersIsMutable();
        tankTransfers_.add(index, builderForValue.build());
        onChanged();
      } else {
        tankTransfersBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /** <code>repeated .TankTransfer tankTransfers = 20;</code> */
    public Builder addAllTankTransfers(
        java.lang.Iterable<? extends com.cpdss.common.generated.discharge_plan.TankTransfer>
            values) {
      if (tankTransfersBuilder_ == null) {
        ensureTankTransfersIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(values, tankTransfers_);
        onChanged();
      } else {
        tankTransfersBuilder_.addAllMessages(values);
      }
      return this;
    }
    /** <code>repeated .TankTransfer tankTransfers = 20;</code> */
    public Builder clearTankTransfers() {
      if (tankTransfersBuilder_ == null) {
        tankTransfers_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000200);
        onChanged();
      } else {
        tankTransfersBuilder_.clear();
      }
      return this;
    }
    /** <code>repeated .TankTransfer tankTransfers = 20;</code> */
    public Builder removeTankTransfers(int index) {
      if (tankTransfersBuilder_ == null) {
        ensureTankTransfersIsMutable();
        tankTransfers_.remove(index);
        onChanged();
      } else {
        tankTransfersBuilder_.remove(index);
      }
      return this;
    }
    /** <code>repeated .TankTransfer tankTransfers = 20;</code> */
    public com.cpdss.common.generated.discharge_plan.TankTransfer.Builder getTankTransfersBuilder(
        int index) {
      return getTankTransfersFieldBuilder().getBuilder(index);
    }
    /** <code>repeated .TankTransfer tankTransfers = 20;</code> */
    public com.cpdss.common.generated.discharge_plan.TankTransferOrBuilder
        getTankTransfersOrBuilder(int index) {
      if (tankTransfersBuilder_ == null) {
        return tankTransfers_.get(index);
      } else {
        return tankTransfersBuilder_.getMessageOrBuilder(index);
      }
    }
    /** <code>repeated .TankTransfer tankTransfers = 20;</code> */
    public java.util.List<? extends com.cpdss.common.generated.discharge_plan.TankTransferOrBuilder>
        getTankTransfersOrBuilderList() {
      if (tankTransfersBuilder_ != null) {
        return tankTransfersBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(tankTransfers_);
      }
    }
    /** <code>repeated .TankTransfer tankTransfers = 20;</code> */
    public com.cpdss.common.generated.discharge_plan.TankTransfer.Builder
        addTankTransfersBuilder() {
      return getTankTransfersFieldBuilder()
          .addBuilder(com.cpdss.common.generated.discharge_plan.TankTransfer.getDefaultInstance());
    }
    /** <code>repeated .TankTransfer tankTransfers = 20;</code> */
    public com.cpdss.common.generated.discharge_plan.TankTransfer.Builder addTankTransfersBuilder(
        int index) {
      return getTankTransfersFieldBuilder()
          .addBuilder(
              index, com.cpdss.common.generated.discharge_plan.TankTransfer.getDefaultInstance());
    }
    /** <code>repeated .TankTransfer tankTransfers = 20;</code> */
    public java.util.List<com.cpdss.common.generated.discharge_plan.TankTransfer.Builder>
        getTankTransfersBuilderList() {
      return getTankTransfersFieldBuilder().getBuilderList();
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.cpdss.common.generated.discharge_plan.TankTransfer,
            com.cpdss.common.generated.discharge_plan.TankTransfer.Builder,
            com.cpdss.common.generated.discharge_plan.TankTransferOrBuilder>
        getTankTransfersFieldBuilder() {
      if (tankTransfersBuilder_ == null) {
        tankTransfersBuilder_ =
            new com.google.protobuf.RepeatedFieldBuilderV3<
                com.cpdss.common.generated.discharge_plan.TankTransfer,
                com.cpdss.common.generated.discharge_plan.TankTransfer.Builder,
                com.cpdss.common.generated.discharge_plan.TankTransferOrBuilder>(
                tankTransfers_,
                ((bitField0_ & 0x00000200) != 0),
                getParentForChildren(),
                isClean());
        tankTransfers_ = null;
      }
      return tankTransfersBuilder_;
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

    // @@protoc_insertion_point(builder_scope:DischargingSequence)
  }

  // @@protoc_insertion_point(class_scope:DischargingSequence)
  private static final com.cpdss.common.generated.discharge_plan.DischargingSequence
      DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new com.cpdss.common.generated.discharge_plan.DischargingSequence();
  }

  public static com.cpdss.common.generated.discharge_plan.DischargingSequence getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<DischargingSequence> PARSER =
      new com.google.protobuf.AbstractParser<DischargingSequence>() {
        @java.lang.Override
        public DischargingSequence parsePartialFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
          return new DischargingSequence(input, extensionRegistry);
        }
      };

  public static com.google.protobuf.Parser<DischargingSequence> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<DischargingSequence> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.cpdss.common.generated.discharge_plan.DischargingSequence getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
}
