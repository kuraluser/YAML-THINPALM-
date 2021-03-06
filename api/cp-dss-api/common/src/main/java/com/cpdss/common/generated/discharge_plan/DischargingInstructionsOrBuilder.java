/* Licensed at AlphaOri Technologies */
package com.cpdss.common.generated.discharge_plan;

public interface DischargingInstructionsOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:DischargingInstructions)
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
   * <code>int64 instructionId = 3;</code>
   *
   * @return The instructionId.
   */
  long getInstructionId();

  /**
   * <code>string instruction = 4;</code>
   *
   * @return The instruction.
   */
  java.lang.String getInstruction();
  /**
   * <code>string instruction = 4;</code>
   *
   * @return The bytes for instruction.
   */
  com.google.protobuf.ByteString getInstructionBytes();

  /**
   * <code>bool isChecked = 5;</code>
   *
   * @return The isChecked.
   */
  boolean getIsChecked();

  /**
   * <code>bool isEditable = 6;</code>
   *
   * @return The isEditable.
   */
  boolean getIsEditable();
}
