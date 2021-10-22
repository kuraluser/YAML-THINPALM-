// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: discharge_plan/discharge_plan_models.proto

package com.cpdss.common.generated.discharge_plan;

public interface DischargeSequenceReplyOrBuilder extends
    // @@protoc_insertion_point(interface_extends:DischargeSequenceReply)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int64 vesselId = 1;</code>
   * @return The vesselId.
   */
  long getVesselId();

  /**
   * <code>int64 voyageId = 2;</code>
   * @return The voyageId.
   */
  long getVoyageId();

  /**
   * <code>int64 dischargePatternId = 3;</code>
   * @return The dischargePatternId.
   */
  long getDischargePatternId();

  /**
   * <code>int64 portId = 4;</code>
   * @return The portId.
   */
  long getPortId();

  /**
   * <code>string startDate = 5;</code>
   * @return The startDate.
   */
  java.lang.String getStartDate();
  /**
   * <code>string startDate = 5;</code>
   * @return The bytes for startDate.
   */
  com.google.protobuf.ByteString
      getStartDateBytes();

  /**
   * <code>int32 interval = 6;</code>
   * @return The interval.
   */
  int getInterval();

  /**
   * <code>repeated .DischargeSequence dischargeSequences = 7;</code>
   */
  java.util.List<com.cpdss.common.generated.discharge_plan.DischargeSequence> 
      getDischargeSequencesList();
  /**
   * <code>repeated .DischargeSequence dischargeSequences = 7;</code>
   */
  com.cpdss.common.generated.discharge_plan.DischargeSequence getDischargeSequences(int index);
  /**
   * <code>repeated .DischargeSequence dischargeSequences = 7;</code>
   */
  int getDischargeSequencesCount();
  /**
   * <code>repeated .DischargeSequence dischargeSequences = 7;</code>
   */
  java.util.List<? extends com.cpdss.common.generated.discharge_plan.DischargeSequenceOrBuilder> 
      getDischargeSequencesOrBuilderList();
  /**
   * <code>repeated .DischargeSequence dischargeSequences = 7;</code>
   */
  com.cpdss.common.generated.discharge_plan.DischargeSequenceOrBuilder getDischargeSequencesOrBuilder(
      int index);

  /**
   * <code>repeated .LoadingPlanStabilityParameters dischargeSequenceStabilityParameters = 8;</code>
   */
  java.util.List<com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters> 
      getDischargeSequenceStabilityParametersList();
  /**
   * <code>repeated .LoadingPlanStabilityParameters dischargeSequenceStabilityParameters = 8;</code>
   */
  com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParameters getDischargeSequenceStabilityParameters(int index);
  /**
   * <code>repeated .LoadingPlanStabilityParameters dischargeSequenceStabilityParameters = 8;</code>
   */
  int getDischargeSequenceStabilityParametersCount();
  /**
   * <code>repeated .LoadingPlanStabilityParameters dischargeSequenceStabilityParameters = 8;</code>
   */
  java.util.List<? extends com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParametersOrBuilder> 
      getDischargeSequenceStabilityParametersOrBuilderList();
  /**
   * <code>repeated .LoadingPlanStabilityParameters dischargeSequenceStabilityParameters = 8;</code>
   */
  com.cpdss.common.generated.loading_plan.LoadingPlanModels.LoadingPlanStabilityParametersOrBuilder getDischargeSequenceStabilityParametersOrBuilder(
      int index);

  /**
   * <code>.ResponseStatus responseStatus = 9;</code>
   * @return Whether the responseStatus field is set.
   */
  boolean hasResponseStatus();
  /**
   * <code>.ResponseStatus responseStatus = 9;</code>
   * @return The responseStatus.
   */
  com.cpdss.common.generated.Common.ResponseStatus getResponseStatus();
  /**
   * <code>.ResponseStatus responseStatus = 9;</code>
   */
  com.cpdss.common.generated.Common.ResponseStatusOrBuilder getResponseStatusOrBuilder();

  /**
   * <code>int64 portRotationId = 10;</code>
   * @return The portRotationId.
   */
  long getPortRotationId();
}
