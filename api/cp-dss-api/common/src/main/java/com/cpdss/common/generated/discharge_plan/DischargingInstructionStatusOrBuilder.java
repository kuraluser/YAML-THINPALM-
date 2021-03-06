/* Licensed at AlphaOri Technologies */
package com.cpdss.common.generated.discharge_plan;

public interface DischargingInstructionStatusOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:DischargingInstructionStatus)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int64 instructionId = 1;</code>
   *
   * @return The instructionId.
   */
  long getInstructionId();

  /**
   * <code>bool isChecked = 2;</code>
   *
   * @return The isChecked.
   */
  boolean getIsChecked();

  /**
   * <code>string instruction = 3;</code>
   *
   * @return The instruction.
   */
  java.lang.String getInstruction();
  /**
   * <code>string instruction = 3;</code>
   *
   * @return The bytes for instruction.
   */
  com.google.protobuf.ByteString getInstructionBytes();
}
