/* Licensed at AlphaOri Technologies */
package com.cpdss.common.generated.discharge_plan;

public interface DischargeStudyDataTransferRequestOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:DischargeStudyDataTransferRequest)
    com.google.protobuf.MessageOrBuilder {

  /** <code>repeated .PortData portData = 1;</code> */
  java.util.List<com.cpdss.common.generated.discharge_plan.PortData> getPortDataList();
  /** <code>repeated .PortData portData = 1;</code> */
  com.cpdss.common.generated.discharge_plan.PortData getPortData(int index);
  /** <code>repeated .PortData portData = 1;</code> */
  int getPortDataCount();
  /** <code>repeated .PortData portData = 1;</code> */
  java.util.List<? extends com.cpdss.common.generated.discharge_plan.PortDataOrBuilder>
      getPortDataOrBuilderList();
  /** <code>repeated .PortData portData = 1;</code> */
  com.cpdss.common.generated.discharge_plan.PortDataOrBuilder getPortDataOrBuilder(int index);

  /**
   * <code>int64 dischargePatternId = 2;</code>
   *
   * @return The dischargePatternId.
   */
  long getDischargePatternId();

  /**
   * <code>int64 voyageId = 3;</code>
   *
   * @return The voyageId.
   */
  long getVoyageId();

  /**
   * <code>int64 vesselId = 4;</code>
   *
   * @return The vesselId.
   */
  long getVesselId();
}