package com.example.testbootcamp.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class welcomeController {
    @GetMapping(path = "/name")
    public String name(){
        return "My name is Abdulaziz";
    }
    @GetMapping(path = "/age")
    public String age(){
        return "My age is 23";
    }
    @GetMapping(path = "/check/status")
    public String checkStatus(){
        return "Everything is OK";
    }
    @GetMapping(path = "/health")
    public String health(){
        return "Server health is up and running";
    }
}
