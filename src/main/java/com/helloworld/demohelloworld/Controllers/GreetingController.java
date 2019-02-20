package com.helloworld.demohelloworld.Controllers;

import com.helloworld.demohelloworld.Models.Hello;
import com.helloworld.demohelloworld.Services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class GreetingController {

    private GreetingService service;

    @Autowired
    public GreetingController(GreetingService service) {
        this.service = service;
    }

    @RequestMapping("/greeting")
    public @ResponseBody String greeting6() {
        return service.greet();
    }

    @GetMapping ("/allgreets")
    @ResponseBody
    public List<Hello> returnAllGreets(){
        return service.listAll();
    }

    @GetMapping ("/findbygreet")
    @ResponseBody
    public Hello findByGreet(String greet){
        return service.findByGreetingText(greet);
    }

}
