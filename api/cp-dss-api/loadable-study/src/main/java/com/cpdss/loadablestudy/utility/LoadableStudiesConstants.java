/* Licensed at AlphaOri Technologies */
package com.cpdss.loadablestudy.utility;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class LoadableStudiesConstants {

  public static final String SUCCESS = "SUCCESS";
  public static final String FAILED = "FAILED";

  public static final String STATUS_ACTIVE = "ACTIVE";
  public static final String STATUS_CONFIRMED = "CONFIRMED";
  public static final String STATUS_CLOSE = "CLOSED";

  public static final String OPERATION_TYPE_ARR = "ARR";
  public static final String OPERATION_TYPE_DEP = "DEP";

  public static final String DATE_FORMAT = "dd-MM-yyyy HH:mm";

  public static final String INVALID_LOADABLE_STUDY_ID = "INVALID_LOADABLE_STUDY_ID";
  public static final String INVALID_LOADABLE_QUANTITY = "INVALID_LOADABLE_QUANTITY";

  public static final Long FRESH_WATER_TANK_CATEGORY_ID = 3L;
  public static final Long FUEL_OIL_TANK_CATEGORY_ID = 5L;
  public static final Long DIESEL_OIL_TANK_CATEGORY_ID = 6L;
  public static final Long LUBRICATING_OIL_TANK_CATEGORY_ID = 14L;
  public static final Long LUBRICANT_OIL_TANK_CATEGORY_ID = 19L;
  public static final Long FUEL_VOID_TANK_CATEGORY_ID = 22L;
  public static final Long FRESH_WATER_VOID_TANK_CATEGORY_ID = 23L;
  public static final Long BALLAST_VOID_TANK_CATEGORY_ID = 16L;
  public static final Long BALLAST_TANK_CATEGORY_ID = 2L;

  public static final Long LOADING_OPERATION_ID = 1L;
  public static final Long DISCHARGING_OPERATION_ID = 2L;
  public static final Long BUNKERING_OPERATION_ID = 3L;
  public static final Long TRANSIT_OPERATION_ID = 4L;
  public static final Long STS_LOADING_OPERATION_ID = 5L;
  public static final Long STS_DISCHARGING_OPERATION_ID = 6L;

  public static final Long LS_STATUS_PENDING = 1l;
  public static final Long LS_STATUS_CONFIRMED = 2l;

  public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");
  public static final Long CLOSE_VOYAGE_STATUS = 2L;
  public static final Long OPEN_VOYAGE_STATUS = 1L;
  public static final Long CONFIRMED_STATUS_ID = 2L;
  public static final Long LOADABLE_STUDY_INITIAL_STATUS_ID = 1L;
  private static final Long LOAD_LINE_TROPICAL_TO_SUMMER_ID = 7L;
  private static final Long LOAD_LINE_TROPICAL_TO_WINTER_ID = 8L;
  private static final Long LOAD_LINE_SUMMER_TO_WINTER_ID = 9L;
  public static final int CASE_1 = 1;
  public static final int CASE_2 = 2;
  public static final int CASE_3 = 3;
  public static final List<Long> CASE_1_LOAD_LINES =
      Arrays.asList(
          LOAD_LINE_TROPICAL_TO_SUMMER_ID,
          LOAD_LINE_TROPICAL_TO_WINTER_ID,
          LOAD_LINE_SUMMER_TO_WINTER_ID);
}
