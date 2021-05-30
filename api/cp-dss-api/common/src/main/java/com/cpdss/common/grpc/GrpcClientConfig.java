/* Licensed at AlphaOri Technologies */
package com.cpdss.common.grpc;

import io.grpc.ClientInterceptor;
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import lombok.EqualsAndHashCode;
import lombok.extern.log4j.Log4j2;
import net.devh.boot.grpc.client.channelfactory.GrpcChannelConfigurer;
import net.devh.boot.grpc.client.config.GrpcChannelProperties;
import net.devh.boot.grpc.client.config.GrpcChannelsProperties;
import net.devh.boot.grpc.client.config.NegotiationType;
import net.devh.boot.grpc.client.interceptor.GrpcGlobalClientInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

/**
 * Configuration class only for GRPC Client
 *
 * @author r.krishnakumar
 */
@EqualsAndHashCode(callSuper = true)
@Configuration
@Log4j2
@DependsOn("log")
public class GrpcClientConfig extends GrpcChannelsProperties {

  @Value("#{${ro.grpc.client.targets}}")
  private Map<String, String> targets;

  @Value("${ro.grpc.client.target.serviceType:static}")
  private String serviceType;

  /**
   * Grpc client channel configuration
   *
   * @return
   */
  @Bean(name = "GrpcChannelConfigurer")
  public GrpcChannelConfigurer keepAliveClientConfigurer() {
    targets.forEach(
        (targetName, targetAddress) -> {
          GrpcChannelProperties properties = new GrpcChannelProperties();
          if (serviceType.contentEquals("static")) {
            properties.setAddress(serviceType + "://" + targetAddress);
          } else {
            properties.setAddress(serviceType + ":/" + targetAddress);
          }
          properties.setNegotiationType(NegotiationType.PLAINTEXT);
          getClient().put(targetName, properties);
        });
    return (channelBuilder, name) -> {
      if (channelBuilder instanceof NettyChannelBuilder) {
        ((NettyChannelBuilder) channelBuilder)
            .enableRetry()
            .maxRetryAttempts(5)
            .keepAliveTime(30, TimeUnit.SECONDS)
            .keepAliveTimeout(5, TimeUnit.SECONDS);
      }
    };
  }

  /**
   * Grpc Client interceptor
   *
   * @return
   */
  @GrpcGlobalClientInterceptor
  public ClientInterceptor logClientInterceptor() {
    return new GrpcClientInterceptor();
  }
}
