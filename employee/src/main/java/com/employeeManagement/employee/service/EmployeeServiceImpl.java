package com.employeeManagement.employee.service;

import com.employeeManagement.employee.dto.CompanyDTO;
import com.employeeManagement.employee.dto.EmployeeResponse;
import com.employeeManagement.employee.entity.Employee;
import com.employeeManagement.employee.exception.EmployeeNotFound;
import com.employeeManagement.employee.feign.CompanyClient;
import com.employeeManagement.employee.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeRepo repo;

    @Autowired
    CompanyClient client;

    @Override
    public Page<Employee> getAllEmployees(int pageNo,int pageSize,Sort sort){
        Pageable pageable= PageRequest.of(pageNo,pageSize,sort);
        return repo.findAll(pageable);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return repo.findById(id)
                .orElseThrow(()->
                        new EmployeeNotFound("Employee Not Found With This Id: "+id));
    }

    @Override
    public void deleteEmployeeById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return repo.save(employee);
    }

    @Override
    public EmployeeResponse getEmployeeWithCompanyId(Long employeeId) {

        Employee employee=repo.findById(employeeId).orElseThrow(()->
                new EmployeeNotFound("Employee Not Found With This Id: "+employeeId));

        CompanyDTO companyDTO=client.getCompanyById(employee.getCompanyId());

        EmployeeResponse response=new EmployeeResponse();
        response.setEmployee(employee);
        response.setCompany(companyDTO);
        return response;
    }
}
