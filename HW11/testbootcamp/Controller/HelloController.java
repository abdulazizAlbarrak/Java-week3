package com.example.testbootcamp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/get")
public class HelloController {
    @GetMapping(path = "/hello")
    public String helloWorld(){
        return "Hello World";
    }
    @GetMapping(path = "/name")
    public String getName(){
        return "Aziz";
    }
}
