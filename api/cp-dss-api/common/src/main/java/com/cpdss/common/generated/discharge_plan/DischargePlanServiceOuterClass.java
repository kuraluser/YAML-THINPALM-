// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: discharge_plan/discharge_plan_service.proto

package com.cpdss.common.generated.discharge_plan;

public final class DischargePlanServiceOuterClass {
  private DischargePlanServiceOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n+discharge_plan/discharge_plan_service." +
      "proto\032\014common.proto\032*discharge_plan/disc" +
      "harge_plan_models.proto2\275\001\n\033DischargeInf" +
      "ormationService\022P\n\027getDischargeInformati" +
      "on\022\034.DischargeInformationRequest\032\025.Disch" +
      "argeInformation\"\000\022L\n\034getOrSaveRulesForDi" +
      "scharging\022\025.DischargeRuleRequest\032\023.Disch" +
      "argeRuleReply\"\0002k\n\024DischargePlanService\022" +
      "S\n\032LoadingPlanSynchronization\022\".Discharg" +
      "eStudyDataTransferRequest\032\017.ResponseStat" +
      "us\"\000B-\n)com.cpdss.common.generated.disch" +
      "arge_planP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.cpdss.common.generated.Common.getDescriptor(),
          com.cpdss.common.generated.discharge_plan.DischargePlanModels.getDescriptor(),
        });
    com.cpdss.common.generated.Common.getDescriptor();
    com.cpdss.common.generated.discharge_plan.DischargePlanModels.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
