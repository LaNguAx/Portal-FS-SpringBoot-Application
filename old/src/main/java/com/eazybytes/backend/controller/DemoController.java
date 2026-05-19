package com.eazybytes.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // @GetMapping("/home")
    @RequestMapping(path = "/home",method = {RequestMethod.GET, RequestMethod.POST}, consumes = "application/json", produces = "application/json")
    public String sayHello() {
        return "Hello World!";
    }

}

