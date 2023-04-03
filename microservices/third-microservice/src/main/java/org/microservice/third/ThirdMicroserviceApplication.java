package org.microservice.third;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ThirdMicroserviceApplication {

  public static void main(String[] args) {
    SpringApplication.run(ThirdMicroserviceApplication.class, args);
  }

}
