/* Licensed at AlphaOri Technologies */
package com.cpdss.common.generated.discharge_plan;

public interface CargoForCowOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:CargoForCow)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int64 cargoId = 1;</code>
   *
   * @return The cargoId.
   */
  long getCargoId();

  /**
   * <code>int64 cargoNominationId = 2;</code>
   *
   * @return The cargoNominationId.
   */
  long getCargoNominationId();

  /**
   * <code>int64 washingCargoId = 3;</code>
   *
   * @return The washingCargoId.
   */
  long getWashingCargoId();

  /**
   * <code>int64 washingCargoNominationId = 4;</code>
   *
   * @return The washingCargoNominationId.
   */
  long getWashingCargoNominationId();

  /**
   * <code>repeated int64 tankIds = 5;</code>
   *
   * @return A list containing the tankIds.
   */
  java.util.List<java.lang.Long> getTankIdsList();
  /**
   * <code>repeated int64 tankIds = 5;</code>
   *
   * @return The count of tankIds.
   */
  int getTankIdsCount();
  /**
   * <code>repeated int64 tankIds = 5;</code>
   *
   * @param index The index of the element to return.
   * @return The tankIds at the given index.
   */
  long getTankIds(int index);
}
