/* Licensed at AlphaOri Technologies */
package com.cpdss.common.generated.discharge_plan;

public interface DischargingInstructionSubHeaderOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:DischargingInstructionSubHeader)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int64 instructionTypeId = 1;</code>
   *
   * @return The instructionTypeId.
   */
  long getInstructionTypeId();

  /**
   * <code>int64 instructionHeaderId = 2;</code>
   *
   * @return The instructionHeaderId.
   */
  long getInstructionHeaderId();

  /**
   * <code>int64 subHeaderId = 3;</code>
   *
   * @return The subHeaderId.
   */
  long getSubHeaderId();

  /**
   * <code>string subHeaderName = 4;</code>
   *
   * @return The subHeaderName.
   */
  java.lang.String getSubHeaderName();
  /**
   * <code>string subHeaderName = 4;</code>
   *
   * @return The bytes for subHeaderName.
   */
  com.google.protobuf.ByteString getSubHeaderNameBytes();

  /**
   * <code>bool isChecked = 5;</code>
   *
   * @return The isChecked.
   */
  boolean getIsChecked();

  /** <code>repeated .DischargingInstructions dischargingInstructionsList = 6;</code> */
  java.util.List<com.cpdss.common.generated.discharge_plan.DischargingInstructions>
      getDischargingInstructionsListList();
  /** <code>repeated .DischargingInstructions dischargingInstructionsList = 6;</code> */
  com.cpdss.common.generated.discharge_plan.DischargingInstructions getDischargingInstructionsList(
      int index);
  /** <code>repeated .DischargingInstructions dischargingInstructionsList = 6;</code> */
  int getDischargingInstructionsListCount();
  /** <code>repeated .DischargingInstructions dischargingInstructionsList = 6;</code> */
  java.util.List<
          ? extends com.cpdss.common.generated.discharge_plan.DischargingInstructionsOrBuilder>
      getDischargingInstructionsListOrBuilderList();
  /** <code>repeated .DischargingInstructions dischargingInstructionsList = 6;</code> */
  com.cpdss.common.generated.discharge_plan.DischargingInstructionsOrBuilder
      getDischargingInstructionsListOrBuilder(int index);

  /**
   * <code>bool isEditable = 7;</code>
   *
   * @return The isEditable.
   */
  boolean getIsEditable();

  /**
   * <code>bool IsHeaderInstruction = 8;</code>
   *
   * @return The isHeaderInstruction.
   */
  boolean getIsHeaderInstruction();
}
