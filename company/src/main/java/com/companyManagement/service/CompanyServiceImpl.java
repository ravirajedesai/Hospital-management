package com.companyManagement.service;

import com.companyManagement.entity.Company;
import com.companyManagement.repo.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService{

    @Autowired
    CompanyRepo repo;

    @Override
    public Company addCompany(Company company) {
        return repo.save(company);
    }

    @Override
    public List<Company> getAllCompanies() {
        return repo.findAll();
    }

    @Override
    public Optional<Company> getCompanyById(Long id) {
        return repo.findById(id);
    }

    @Override
    public void deleteCompanyById(Long id) {
         repo.deleteById(id);
    }

}
