/* Licensed at AlphaOri Technologies */
package com.cpdss.common.generated.discharge_plan;

public interface DSCowDetailsOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:DSCowDetails)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.CowTankDetails cowTankDetails = 1;</code>
   *
   * @return Whether the cowTankDetails field is set.
   */
  boolean hasCowTankDetails();
  /**
   * <code>.CowTankDetails cowTankDetails = 1;</code>
   *
   * @return The cowTankDetails.
   */
  com.cpdss.common.generated.discharge_plan.CowTankDetails getCowTankDetails();
  /** <code>.CowTankDetails cowTankDetails = 1;</code> */
  com.cpdss.common.generated.discharge_plan.CowTankDetailsOrBuilder getCowTankDetailsOrBuilder();

  /**
   * <code>int64 dischargeStudyId = 2;</code>
   *
   * @return The dischargeStudyId.
   */
  long getDischargeStudyId();

  /**
   * <code>float percent = 4;</code>
   *
   * @return The percent.
   */
  float getPercent();

  /**
   * <code>.COW_OPTION_TYPE cowOptionType = 5;</code>
   *
   * @return The enum numeric value on the wire for cowOptionType.
   */
  int getCowOptionTypeValue();
  /**
   * <code>.COW_OPTION_TYPE cowOptionType = 5;</code>
   *
   * @return The cowOptionType.
   */
  com.cpdss.common.generated.Common.COW_OPTION_TYPE getCowOptionType();
}
