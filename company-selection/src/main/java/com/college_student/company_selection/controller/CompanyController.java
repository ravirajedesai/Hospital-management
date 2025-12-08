package com.college_student.company_selection.controller;

import com.college_student.company_selection.entity.CompanySelection;
import com.college_student.company_selection.service.CompanyServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    CompanyServices services;

    @GetMapping
    List<CompanySelection> getAllCompanies(){
        return services.getAllCompanies();
    }
    @GetMapping("/{id}")
    public CompanySelection getCompanyById(@PathVariable Long id){
        return services.getCompanyById(id)
                .orElseThrow(()->
                        new RuntimeException("Company Not Found With Id: "+id));
    }
    @DeleteMapping("/{id}")
    String deleteCompanyById(@PathVariable Long id){
        services.deleteCompanyById(id);
        return "Company Deleted With Id: "+id;
    }
    @PostMapping
    CompanySelection addCompany(@RequestBody CompanySelection companySelection){
        return services.addCompany(companySelection);
    }
}
