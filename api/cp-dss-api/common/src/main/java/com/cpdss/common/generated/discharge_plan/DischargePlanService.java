/* Licensed at AlphaOri Technologies */
package com.cpdss.common.generated.discharge_plan;

public final class DischargePlanService {
  private DischargePlanService() {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistryLite registry) {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions((com.google.protobuf.ExtensionRegistryLite) registry);
  }

  public static com.google.protobuf.Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }

  private static com.google.protobuf.Descriptors.FileDescriptor descriptor;

  static {
    java.lang.String[] descriptorData = {
      "\n+discharge_plan/discharge_plan_service."
          + "proto\032\014common.proto\032*discharge_plan/disc"
          + "harge_plan_models.proto2o\n\033DischargeInfo"
          + "rmationService\022P\n\027getDischargeInformatio"
          + "n\022\034.DischargeInformationRequest\032\025.Discha"
          + "rgeInformation\"\000B-\n)com.cpdss.common.gen"
          + "erated.discharge_planP\001b\006proto3"
    };
    descriptor =
        com.google.protobuf.Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(
            descriptorData,
            new com.google.protobuf.Descriptors.FileDescriptor[] {
              com.cpdss.common.generated.Common.getDescriptor(),
              com.cpdss.common.generated.discharge_plan.DischargePlanModels.getDescriptor(),
            });
    com.cpdss.common.generated.Common.getDescriptor();
    com.cpdss.common.generated.discharge_plan.DischargePlanModels.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
