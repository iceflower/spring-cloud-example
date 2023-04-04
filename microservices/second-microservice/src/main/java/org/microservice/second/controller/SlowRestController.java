package org.microservice.second.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/slow")
public class SlowRestController {

  private final String myName;

  public SlowRestController(@Value("${spring.application.name}") String myName) {
    this.myName = myName;
  }

  @GetMapping("/get-app-name/{second}")
  public String myName(@PathVariable("second") int second) throws InterruptedException {
    Thread.sleep(second * 1000L);
    return myName;
  }

}
