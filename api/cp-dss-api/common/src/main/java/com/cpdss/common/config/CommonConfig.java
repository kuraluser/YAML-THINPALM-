/* Licensed under Apache-2.0 */
package com.cpdss.common.config;

import com.cpdss.common.logging.Log4j2Config;
import javax.annotation.PostConstruct;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;

/**
 * Defines common configuration beans for the RICO framework
 *
 * @author r.krishnakumar
 */
@Configuration
@PropertySource(
    value = {"classpath:projectInfo.properties"},
    ignoreResourceNotFound = true)
public class CommonConfig implements ApplicationContextAware {

  private ApplicationContext applicationContext;

  @Value("${database:''}")
  private String dataBaseType;

  @Value("${multitenancy.enabled: 'n'}")
  private String isMultitenancyEnabled;

  @Value("${security.enabled: 'n'}")
  private String isSecurityEnabled;

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.applicationContext = applicationContext;
  }

  /** Method to init commonconfig */
  @PostConstruct
  public void initialize() {
    ClassPathResource classPathResource = new ClassPathResource("projectInfo.properties");
    if (!classPathResource.exists()) {
      throw new RuntimeException(
          "Failed to initialize CommonConfig. Run build task before starting the application");
    }
  }

  @Bean("dataBaseType")
  public String getDatabaseType() {
    return dataBaseType;
  }

  @Bean("log")
  @ConditionalOnProperty(name = "log.enabled", havingValue = "y")
  public boolean isLoggingEnabled() {
    applicationContext.getBean(Log4j2Config.class);
    return true;
  }

  @Bean("log")
  @ConditionalOnProperty(name = "log.enabled", havingValue = "y", matchIfMissing = true)
  public boolean isLoggingNotEnabled() {
    return true;
  }

  @Bean("cache")
  @ConditionalOnProperty(name = "cache.enabled", havingValue = "y")
  public boolean isCacheEnabled() {
    applicationContext.getBean("cacheManager");
    return true;
  }

  @Bean("cache")
  @ConditionalOnProperty(name = "cache.enabled", havingValue = "y", matchIfMissing = true)
  public boolean isCacheNotEnabled() {
    return true;
  }

  @Bean("multitenancy")
  public boolean isMultitenancyEnabled() {
    if ("y".contentEquals(this.isMultitenancyEnabled)) {
      return true;
    } else {
      return false;
    }
  }

  @Bean("security")
  public boolean isSecurityEnabled() {
    if ("y".contentEquals(this.isSecurityEnabled)) {
      return true;
    } else {
      return false;
    }
  }
}
