package org.microservice.third.controller;

import com.netflix.discovery.shared.Application;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.microservice.third.service.GetMsaCustomizeValueService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CircuitBreakerDemoRestController {

  private final GetMsaCustomizeValueService getMsaCustomizeValueService;

  @GetMapping("/get/{app-name}/first-value")
  public String getFirstValue(@PathVariable("app-name") String appName) {

    return getMsaCustomizeValueService.getFirstValue(appName);
  }

  @GetMapping("/get/{app-name}/second-value")
  public String getSecondValue(@PathVariable("app-name") String appName) {

    return getMsaCustomizeValueService.getSecondValue(appName);
  }
}
