package com.example.api_gateway2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {

    @GetMapping("/collegefallback")
    public String collegeFallback(){
        return "College Service is Down..";
    }
    @GetMapping("/studentfallback")
    public String studentFallback(){
        return "Student Service is Down..";
    }
    @GetMapping("/companyfallback")
    public String companyFallback(){
        return "Company Service is Down..";
    }
}
