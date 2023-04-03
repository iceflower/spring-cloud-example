package org.microservice.second.controller;

import org.microservice.second.config.CustomValueConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/custom-value")
public class CustomValueRestController {
  private final CustomValueConfiguration customValueConfiguration;

  public CustomValueRestController(CustomValueConfiguration customValueConfiguration) {
    this.customValueConfiguration = customValueConfiguration;
  }

  @GetMapping("/first")
  public String getFirstCustomValue() {

    return customValueConfiguration.getMyFirstCustomValue();
  }

  @GetMapping("/second")
  public String getSecondCustomValue() {

    return customValueConfiguration.getMySecondCustomValue();
  }

}
