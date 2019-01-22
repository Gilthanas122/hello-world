package com.helloworld.demohelloworld;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @GetMapping("/")
    public String helloWorld(){
        System.out.println("Hello world");
        return "hello world";
    }
}
