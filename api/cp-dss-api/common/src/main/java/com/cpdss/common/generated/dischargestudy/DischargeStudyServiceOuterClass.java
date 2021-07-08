/* Licensed at AlphaOri Technologies */
package com.cpdss.common.generated.dischargestudy;

public final class DischargeStudyServiceOuterClass {
  private DischargeStudyServiceOuterClass() {}

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
      "\n,dischargestudy/discharge_study_service"
          + ".proto\032\014common.proto\032&loading_plan/loadi"
          + "ng_plan_models.proto2\200\001\n\025DischargeStudyS"
          + "ervice\022g\n\031getDischargeStudyByVoyage\022$.Lo"
          + "adingInformationSynopticalRequest\032\".Load"
          + "ingInformationSynopticalReply\"\000B-\n)com.c"
          + "pdss.common.generated.dischargestudyP\000b\006"
          + "proto3"
    };
    descriptor =
        com.google.protobuf.Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(
            descriptorData,
            new com.google.protobuf.Descriptors.FileDescriptor[] {
              com.cpdss.common.generated.Common.getDescriptor(),
              com.cpdss.common.generated.loading_plan.LoadingPlanModels.getDescriptor(),
            });
    com.cpdss.common.generated.Common.getDescriptor();
    com.cpdss.common.generated.loading_plan.LoadingPlanModels.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
