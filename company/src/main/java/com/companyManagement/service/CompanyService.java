package com.companyManagement.service;

import com.companyManagement.entity.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    Company addCompany(Company company);
    List<Company> getAllCompanies();
    Optional<Company> getCompanyById(Long id);
    void deleteCompanyById(Long id);
}
