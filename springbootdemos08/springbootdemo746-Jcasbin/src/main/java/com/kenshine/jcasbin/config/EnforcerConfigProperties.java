package com.kenshine.jcasbin.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author kenshine
 * 自定义配置
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "org.jcasbin")
public class EnforcerConfigProperties {
 
  private String url;
  
  private String driverClassName;
  
  private String username;
  
  private String password;
  
  private String modelPath;

  private String policyPath;
}
