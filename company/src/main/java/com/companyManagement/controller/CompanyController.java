package com.companyManagement.controller;

import com.companyManagement.entity.Company;
import com.companyManagement.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    CompanyService service;

    @GetMapping
    List<Company> getAllCompanies(){
        return service.getAllCompanies();
    }
    @GetMapping("/{id}")
    Company getCompanyById(@PathVariable Long id){
        return service.getCompanyById(id).orElseThrow(()->new RuntimeException("Not Found.."));
    }
    @PostMapping
    Company addCompany(@RequestBody Company company){
        return service.addCompany(company);
    }
    @DeleteMapping("/{id}")
    void deleteCompanyById(@PathVariable Long id){
        service.deleteCompanyById(id);
    }
}
