package com.student.student.demo.feignClient;

import com.student.student.demo.model.CompanyDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name ="COMPANY-SERVICE")
public interface CompanyClient {

    @GetMapping("/company/{id}")
    public CompanyDTO getStudentWithCompany(@PathVariable Long id);
}
