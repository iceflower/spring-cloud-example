package org.microservice.third.service;

import java.net.URI;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SlowService {

  private final RestTemplate restTemplate;
  private final CircuitBreaker circuitBreaker;

  public SlowService(RestTemplate restTemplate,
    CircuitBreakerFactory circuitBreakerFactory) {
    this.restTemplate = restTemplate;
    this.circuitBreaker = circuitBreakerFactory.create("slow-cb");
  }

  public String getAppName(final String appName, final int second) {

    return circuitBreaker.run(() -> {
      final var uri = URI.create(
        String.format("https://%s/slow/get-app-name/%d", appName, second));

      return restTemplate.getForEntity(uri, String.class)
        .getBody();
    }, throwable -> "failed to get app name");

  }
}
