/* Licensed at AlphaOri Technologies */
package com.cpdss.common.generated.discharge_plan;

public interface DischargeInformationRequestOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:DischargeInformationRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int64 companyId = 1;</code>
   *
   * @return The companyId.
   */
  long getCompanyId();

  /**
   * <code>int64 vesselId = 2;</code>
   *
   * @return The vesselId.
   */
  long getVesselId();

  /**
   * <code>int64 voyageId = 3;</code>
   *
   * @return The voyageId.
   */
  long getVoyageId();

  /**
   * <code>int64 dischargeInfoId = 4;</code>
   *
   * @return The dischargeInfoId.
   */
  long getDischargeInfoId();

  /**
   * <code>int64 dischargePatternId = 5;</code>
   *
   * @return The dischargePatternId.
   */
  long getDischargePatternId();

  /**
   * <code>int64 portRotationId = 6;</code>
   *
   * @return The portRotationId.
   */
  long getPortRotationId();

  /**
   * <code>int64 synopticTableId = 7;</code>
   *
   * @return The synopticTableId.
   */
  long getSynopticTableId();
}
