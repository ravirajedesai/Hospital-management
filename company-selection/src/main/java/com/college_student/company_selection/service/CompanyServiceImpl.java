package com.college_student.company_selection.service;

import com.college_student.company_selection.entity.CompanySelection;
import com.college_student.company_selection.repo.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyServices {

    @Autowired
    CompanyRepo repo;

    @Override
    public List<CompanySelection> getAllCompanies() {
        return repo.findAll();
    }
    @Override
    public CompanySelection addCompany(CompanySelection companySelection) {
        return repo.save(companySelection);
    }
    @Override
    public String deleteCompanyById(Long id) {
        repo.deleteById(id);
        return "Company Deleted With Id: "+id;
    }
    @Override
    public Optional<CompanySelection> getCompanyById(Long id) {
        return repo.findById(id);
    }
}
