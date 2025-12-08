package com.college_student.company_selection.service;

import com.college_student.company_selection.entity.CompanySelection;

import java.util.List;
import java.util.Optional;

public interface CompanyServices {
    List<CompanySelection> getAllCompanies();
    CompanySelection addCompany(CompanySelection companySelection);
    String deleteCompanyById(Long id);
    Optional<CompanySelection> getCompanyById(Long id);
}
