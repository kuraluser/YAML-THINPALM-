/* Licensed under Apache-2.0 */
package com.cpdss.loadablestudy;

import com.cpdss.common.config.CommonConfig;
import com.cpdss.common.grpc.GrpcServerConfig;
import com.cpdss.common.logging.Log4j2Config;
import com.cpdss.common.springdata.SpringDataConfig;
import com.cpdss.loadablestudy.service.LoadableStudyService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({CommonConfig.class, Log4j2Config.class, SpringDataConfig.class, GrpcServerConfig.class})
public class AppConfig {
	
}
