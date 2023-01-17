package com.api.managepersonaddresses.controllers;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


  @GetMapping("/keu")
    public String hello() {
        return "Hello World!";
    }
  
}
