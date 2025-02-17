package com.edzamo.rest.webservice.restfullwebservice.interfaces.controller;


import com.edzamo.rest.webservice.restfullwebservice.interfaces.dto.HelloWorldDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {


  @GetMapping(path = "/hello-word")
  public String helloWord() {
    return "Hello Word";
  }

  @GetMapping(path = "/hello-word-bean")
  public HelloWorldDto helloWordBean() {
    return new HelloWorldDto("Hello Word Bean");
  }

  /**
   * Path Parameters
   * user/{id}/todos/{id} ==> user/1/todos/200
   *
   * @param name front browser
   * @return class HelloWorldDto
   */
  @GetMapping(path = "/hello-word/path-variable/{name}")
  public HelloWorldDto helloWordPathVariable(@PathVariable String name) {
    return new HelloWorldDto(String.format("Hello World, %s", name));
  }
}
