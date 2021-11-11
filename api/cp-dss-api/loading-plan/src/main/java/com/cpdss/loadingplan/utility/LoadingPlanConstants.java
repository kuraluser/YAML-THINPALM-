/* Licensed at AlphaOri Technologies */
package com.cpdss.loadingplan.utility;

import java.util.Arrays;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class LoadingPlanConstants {
  public static final String SUCCESS = "SUCCESS";
  public static final String FAILED = "FAILED";
  public static final List<String> LOADING_SYNCHRONIZATION_IDENTIFIERS =
      Arrays.asList("loading_information", "cargo_topping_off_sequence");
  public static final String FAILED_WITH_RESOURCE_EXC = "FAILED_WITH_RESOURCE_EXC";
  public static final String FAILED_WITH_EXC = "FAILED_WITH_EXC";

  @Getter
  @AllArgsConstructor
  public enum LoadingPlanTables {
    PORT_LOADING_PLAN_STABILITY_PARAMETERS("port_loading_plan_stability_parameters"),
    PORT_LOADING_PLAN_ROB_DETAILS("port_loading_plan_rob_details"),
    LOADING_PLAN_BALLAST_DETAILS("loading_plan_ballast_details"),
    LOADING_PLAN_ROB_DETAILS("loading_plan_rob_details"),
    LOADING_PLAN_PORTWISE_DETAILS("loading_plan_portwise_details"),
    PORT_LOADING_PLAN_STOWAGE_BALLAST_DETAILS("port_loading_plan_stowage_ballast_details"),
    PORT_LOADING_PLAN_STOWAGE_BALLAST_DETAILS_TEMP(
        "port_loading_plan_stowage_ballast_details_temp"),
    PORT_LOADING_PLAN_STOWAGE_DETAILS("port_loading_plan_stowage_details"),
    PORT_LOADING_PLAN_STOWAGE_DETAILS_TEMP("port_loading_plan_stowage_details_temp"),
    LOADING_SEQUENCE("loading_sequence"),
    LOADING_PLAN_STOWAGE_DETAILS("loading_plan_stowage_details"),
    LOADING_SEQUENCE_STABILITY_PARAMETERS("loading_sequence_stability_parameters"),
    LOADING_PLAN_STABILITY_PARAMETERS("loading_plan_stability_parameters"),
    LOADING_INFORMATION("loading_information"),
    CARGO_TOPPING_OFF_SEQUENCE("cargo_topping_off_sequence"),
    LOADING_BERTH_DETAILS("loading_berth_details"),
    LOADING_DELAY("loading_delay"),
    LOADING_MACHINARY_IN_USE("loading_machinary_in_use"),
    STAGES_MIN_AMOUNT("stages_min_amount"),
    STAGES_DURATION("stages_duration"),
    LOADING_INFORMATION_STATUS("loading_information_status"),
    LOADING_INFORMATION_ARRIVAL_STATUS("loading_information_arrival_status"),
    LOADING_INFORMATION_DEPARTURE_STATUS("loading_information_departure_status"),
    PORT_LOADABLE_PLAN_COMMINGLE_DETAILS_TEMP("port_loadable_plan_commingle_details_temp"),
    PORT_LOADABLE_PLAN_COMMINGLE_DETAILS("port_loadable_plan_commingle_details"),
    BILL_OF_LADDING("bill_of_ladding"),
    PYUSER("pyuser"),
    VOYAGE("voyage");

    public final String table;
  }
}