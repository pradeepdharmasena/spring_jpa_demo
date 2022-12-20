package com.ap.spring_demo_01.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**/
@RestController
public class Controller {
    @Value("${welcome.message}")
    private String message;

    @GetMapping("/")
    public String helloWorld(){
        return (message);
    }
}
