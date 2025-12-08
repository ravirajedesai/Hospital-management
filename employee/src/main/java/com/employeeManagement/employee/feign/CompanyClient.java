package com.employeeManagement.employee.feign;

import com.employeeManagement.employee.dto.CompanyDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "company-service")
public interface CompanyClient {
    @GetMapping("/company/{id}")
    CompanyDTO getCompanyById(@PathVariable Long id);
}
