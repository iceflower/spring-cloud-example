package org.microservice.first.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@RefreshScope
public class CustomValueConfiguration {

  @Value("${custom-value.first}")
  private String myFirstCustomValue;
  @Value("${custom-value.second}")
  private String mySecondCustomValue;

}
