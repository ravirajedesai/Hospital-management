package com.jpapractice.jpademo.service;

import com.jpapractice.jpademo.model.Employee;
import com.jpapractice.jpademo.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo repo;

    public List<Employee> fetchAllEmployee(Pageable pageable,String search){
        if(search==null){
            return repo.findAll(pageable).getContent();
        }else {
            return repo.findByName(search,pageable).getContent();
        }

    }
    public Employee addEmployee(Employee employee){
        return repo.save(employee);
    }
}
