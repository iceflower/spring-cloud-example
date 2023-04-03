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

  public String getFirstValue(final String appName) {

    return circuitBreaker.run(() -> {
      final var uri = URI.create(String.format("https://%s/custom-value/first", appName));

      return restTemplate.getForEntity(uri, String.class)
        .getBody();
    }, throwable -> "default first value");

  }


  public String getSecondValue(final String appName) {
    return circuitBreaker.run(() -> {
      final var uri = URI.create(String.format("https://%s/custom-value/second", appName));

      return restTemplate.getForEntity(uri, String.class)
        .getBody();
    }, throwable -> "default second value");
  }
}
