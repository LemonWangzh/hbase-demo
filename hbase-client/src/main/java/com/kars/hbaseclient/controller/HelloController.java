package com.kars.hbaseclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Value("${server.port}")
    public String port;


    @GetMapping("/hi")
    @ResponseBody
    public String hi(){
        return "hi";
    }

    @GetMapping("/balabala")
    @ResponseBody
    public String balabala(){
        return "balabala port :"+port+" "+ UUID.randomUUID();
    }
}
