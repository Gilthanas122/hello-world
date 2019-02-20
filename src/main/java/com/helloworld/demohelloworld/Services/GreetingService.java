package com.helloworld.demohelloworld.Services;

import com.helloworld.demohelloworld.Models.Hello;
import com.helloworld.demohelloworld.Repositories.HelloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingService {
    private HelloRepository helloRepository;

    @Autowired
    public GreetingService() {
        this.helloRepository = helloRepository;
    }

    public String greet() {
        return "Hello World5";
    }

    public List <Hello> listAll() {
        return helloRepository.findAll();
    }

    public Hello findByGreetingText(String greet) {
        return helloRepository.findByGreetingText(greet);
    }
}
