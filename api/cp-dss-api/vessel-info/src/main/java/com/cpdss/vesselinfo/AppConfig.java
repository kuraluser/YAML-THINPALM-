/* Licensed at AlphaOri Technologies */
package com.cpdss.vesselinfo;

import com.cpdss.common.config.CommonConfig;
import com.cpdss.common.grpc.GrpcServerConfig;
import com.cpdss.common.logging.Log4j2Config;
import com.cpdss.common.springdata.SpringDataConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({CommonConfig.class, Log4j2Config.class, GrpcServerConfig.class, SpringDataConfig.class})
public class AppConfig {}
