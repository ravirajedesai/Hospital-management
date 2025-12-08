package com._Microservices.microservice28.Controller;

import com._Microservices.microservice28.Bean.Limits;
import com._Microservices.microservice28.Configuration.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitController {
    @Autowired
    Configuration configuration;
    @GetMapping("/limits")
    public Limits retriveLimits(){
        return new Limits(configuration.getMinimum(),configuration.getMaximum());
        //return new Limits(1,10);

    }
}
