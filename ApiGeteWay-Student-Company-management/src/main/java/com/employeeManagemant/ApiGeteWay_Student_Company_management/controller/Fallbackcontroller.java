package com.employeeManagemant.ApiGeteWay_Student_Company_management.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Fallbackcontroller {
    @GetMapping("/companyFallback")
    public String companyFallback(){
        return "Company Service Currently Unavailable..Plz try letter";
    }
    @GetMapping("/employeeFallback")
    public String employeeFallback(){
        return "Employee Service Currently Unavailable..Plz try letter";
    }
}
