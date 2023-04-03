package org.microservice.first.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@RefreshScope
public class CustomValueConfiguration {

  private final String myFirstCustomValue;
  private final String mySecondCustomValue;

  public CustomValueConfiguration(
    @Value("${custom-value.first}") String myFirstCustomValue,
    @Value("${custom-value.second}") String mySecondCustomValue) {
    this.myFirstCustomValue = myFirstCustomValue;
    this.mySecondCustomValue = mySecondCustomValue;
  }
}
