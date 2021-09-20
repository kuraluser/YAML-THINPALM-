/* Licensed at AlphaOri Technologies */
package com.cpdss.common.generated.loading_plan;

public final class LoadingPlanServiceOuterClass {
  private LoadingPlanServiceOuterClass() {}

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
      "\n\'loading_plan/loading_plan_service.prot"
          + "o\032\014common.proto\032&loading_plan/loading_pl"
          + "an_models.proto\032\024loadable_study.proto2\255\t"
          + "\n\031LoadingInformationService\022J\n\025GetLoadin"
          + "gInformation\022\032.LoadingInformationRequest"
          + "\032\023.LoadingInformation\"\000\022I\n\026SaveLoadingIn"
          + "formation\022\023.LoadingInformation\032\030.Loading"
          + "InfoSaveResponse\"\000\022G\n\024SaveLoadingInfoRat"
          + "es\022\023.LoadingInformation\032\030.LoadingInfoSav"
          + "eResponse\"\000\022H\n\025SaveLoadingInfoBerths\022\023.L"
          + "oadingInformation\032\030.LoadingInfoSaveRespo"
          + "nse\"\000\022K\n\030SaveLoadingInfoMachinery\022\023.Load"
          + "ingInformation\032\030.LoadingInfoSaveResponse"
          + "\"\000\022H\n\025SaveLoadingInfoDelays\022\023.LoadingInf"
          + "ormation\032\030.LoadingInfoSaveResponse\"\000\022H\n\025"
          + "SaveLoadingInfoStages\022\023.LoadingInformati"
          + "on\032\030.LoadingInfoSaveResponse\"\000\022j\n\034GetLoa"
          + "digInformationByVoyage\022$.LoadingInformat"
          + "ionSynopticalRequest\032\".LoadingInformatio"
          + "nSynopticalReply\"\000\022I\n\014UpdateUllage\022\033.Upd"
          + "ateUllageLoadingRequest\032\032.UpdateUllageLo"
          + "adingReplay\"\000\022C\n\031SaveAlgoLoadingPlanStat"
          + "us\022\022.AlgoStatusRequest\032\020.AlgoStatusReply"
          + "\"\000\022G\n\023GenerateLoadingPlan\022\027.LoadingInfoA"
          + "lgoRequest\032\025.LoadingInfoAlgoReply\"\000\022P\n\030G"
          + "etLoadingInfoAlgoStatus\022\031.LoadingInfoSta"
          + "tusRequest\032\027.LoadingInfoStatusReply\"\000\022@\n"
          + "\030GetLoadingInfoAlgoErrors\022\021.AlgoErrorReq"
          + "uest\032\017.AlgoErrorReply\"\000\022Q\n\025UploadPortTid"
          + "eDetails\022\030.UploadTideDetailRequest\032\034.Upl"
          + "oadTideDetailStatusReply\"\000\022Y\n\027DownloadPo"
          + "rtTideDetails\022\032.DownloadTideDetailReques"
          + "t\032\036.DownloadTideDetailStatusReply\"\0000\0012\216\003"
          + "\n\031LoadingInstructionService\022R\n\026GetLoadin"
          + "gInstructions\022\032.LoadingInstructionReques"
          + "t\032\032.LoadingInstructionDetails\"\000\022D\n\025AddLo"
          + "adingInstruction\022\030.LoadingInstructionsSa"
          + "ve\032\017.ResponseStatus\"\000\022J\n\031UpdateLoadingIn"
          + "structions\022\032.LoadingInstructionsUpdate\032\017"
          + ".ResponseStatus\"\000\022I\n\031DeleteLoadingInstru"
          + "ctions\022\031.LoadingInstructionStatus\032\017.Resp"
          + "onseStatus\"\000\022@\n\020EditInstructions\022\031.Loadi"
          + "ngInstructionStatus\032\017.ResponseStatus\"\0002\372"
          + "\007\n\022LoadingPlanService\022N\n\032LoadingPlanSync"
          + "hronization\022\027.LoadingPlanSyncDetails\032\025.L"
          + "oadingPlanSyncReply\"\000\022F\n\017SaveLoadingPlan"
          + "\022\027.LoadingPlanSaveRequest\032\030.LoadingPlanS"
          + "aveResponse\"\000\022A\n\016GetLoadingPlan\022\032.Loadin"
          + "gInformationRequest\032\021.LoadingPlanReply\"\000"
          + "\022P\n\034GetOrSaveRulesForLoadingPlan\022\027.Loadi"
          + "ngPlanRuleRequest\032\025.LoadingPlanRuleReply"
          + "\"\000\022G\n\023GetLoadingSequences\022\027.LoadingSeque"
          + "nceRequest\032\025.LoadingSequenceReply\"\000\022U\n\026G"
          + "etUpdateUllageDetails\022\033.UpdateUllageDeta"
          + "ilsRequest\032\034.UpdateUllageDetailsResponse"
          + "\"\000\022V\n\027GetBillOfLaddingDetails\022\025.BillOfLa"
          + "ddingRequest\032\".LoadingInformationSynopti"
          + "calReply\"\000\022L\n\035GetCargoNominationMaxQuant"
          + "ity\022\023.MaxQuantityRequest\032\024.MaxQuantityRe"
          + "sponse\"\000\022Y\n\021GetLoadicatorData\022!.LoadingI"
          + "nfoLoadicatorDataRequest\032\037.LoadingInfoLo"
          + "adicatorDataReply\"\000\022B\n\030GetLoadableStudyS"
          + "horeTwo\022\022.UllageBillRequest\032\020.UllageBill"
          + "Reply\"\000\022_\n\037validateStowageAndBillOfLaddi"
          + "ng\022).StowageAndBillOfLaddingValidationRe"
          + "quest\032\017.ResponseStatus\"\000\022q\n\036GetLoadingPl"
          + "anCommingleDetails\022$.LoadingInformationS"
          + "ynopticalRequest\032\'.LoadablePlanCommingle"
          + "CargoDetailsReply\"\000B+\n\'com.cpdss.common."
          + "generated.loading_planP\000b\006proto3"
    };
    descriptor =
        com.google.protobuf.Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(
            descriptorData,
            new com.google.protobuf.Descriptors.FileDescriptor[] {
              com.cpdss.common.generated.Common.getDescriptor(),
              com.cpdss.common.generated.loading_plan.LoadingPlanModels.getDescriptor(),
              com.cpdss.common.generated.LoadableStudy.getDescriptor(),
            });
    com.cpdss.common.generated.Common.getDescriptor();
    com.cpdss.common.generated.loading_plan.LoadingPlanModels.getDescriptor();
    com.cpdss.common.generated.LoadableStudy.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
