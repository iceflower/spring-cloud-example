package org.microservice.third.service;

import java.net.URI;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GetMsaCustomizeValueService {

  private final RestTemplate restTemplate;
  private final CircuitBreaker circuitBreaker;

  public GetMsaCustomizeValueService(RestTemplate restTemplate,
    CircuitBreakerFactory circuitBreakerFactory) {
    this.restTemplate = restTemplate;
    this.circuitBreaker = circuitBreakerFactory.create("customize-value-cb");
  }

  public String getFirstValue(final String appName) {

    return circuitBreaker.run(() -> {
      final var uri = URI.create(String.format("http://%s/custom-value/first", appName));

      return restTemplate.getForEntity(uri, String.class)
        .getBody();
    }, throwable -> "default first value");

  }


  public String getSecondValue(final String appName) {
    return circuitBreaker.run(() -> {
      final var uri = URI.create(String.format("http://%s/custom-value/second", appName));

      return restTemplate.getForEntity(uri, String.class)
        .getBody();
    }, throwable -> "default second value");
  }
}
