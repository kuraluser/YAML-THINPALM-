/* Licensed at AlphaOri Technologies */
package com.cpdss.common.grpc;

import com.cpdss.common.exception.CommonGrpcServerInterruptException;
import com.cpdss.common.utils.AppContext;
import io.grpc.*;
import io.grpc.ForwardingServerCallListener.SimpleForwardingServerCallListener;
import lombok.extern.log4j.Log4j2;

/**
 * Interceptor for grpc server method calls
 *
 * @author krishna
 */
@Log4j2
public class GrpcServerInterceptor implements ServerInterceptor {

  private boolean isMultitenant;

  public GrpcServerInterceptor(boolean isMultitenant) {
    this.isMultitenant = isMultitenant;
  }

  /**
   * Grpc Server interceptor which intercepts the incoming request and gets the tenant id and user
   * id from the Metadata and sets in the Current Thread local
   */
  @Override
  public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
      ServerCall<ReqT, RespT> serverCall,
      Metadata metadata,
      ServerCallHandler<ReqT, RespT> serverCallHandler) {
    if (this.isMultitenant) {
      String tenantID =
          metadata.get(Metadata.Key.of("X-TenantID", Metadata.ASCII_STRING_MARSHALLER));
      if (tenantID == null) {
        log.error("X-TenantID not present in the Request Header");
        throw new CommonGrpcServerInterruptException(
            "X-TenantID not present in the Request Header");
      }
      AppContext.setCurrentTenant(tenantID);
    }
    String userID = metadata.get(Metadata.Key.of("X-UserID", Metadata.ASCII_STRING_MARSHALLER));
    if (userID != null) {
      AppContext.setCurrentUserId(userID);
    }
    ServerCall.Listener<ReqT> delegate = serverCallHandler.startCall(serverCall, metadata);
    return new SimpleForwardingServerCallListener<ReqT>(delegate) {
      @Override
      public void onHalfClose() {
        try {
          super.onHalfClose();
        } catch (Exception e) {
          log.error("Error on half close", e);
          serverCall.close(
              Status.INTERNAL.withCause(e).withDescription("error message"), new Metadata());
        }
      }

      @Override
      public void onComplete() {
        try {
          AppContext.clear();
          super.onComplete();
        } catch (Exception e) {
          log.error("Error on complete", e);
          serverCall.close(
              Status.INTERNAL.withCause(e).withDescription("error message"), new Metadata());
        }
      }
    };
  }
}
