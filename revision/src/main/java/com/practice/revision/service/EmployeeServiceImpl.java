package com.practice.revision.service;

import com.practice.revision.exception.EmployeeNotFoundException;
import com.practice.revision.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    List<Employee> employees=new ArrayList<>();

    @Override
    public Employee save(Employee employee) {
        if(employee.getEmployeeId()==null || employee.getEmail().isEmpty())
            {
                employee.setEmployeeId(UUID.randomUUID().toString());
            }
        employees.add(employee);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @Override
    public Employee getEmployeeById(String id) {
        return employees
                .stream()
                .filter(e -> e
                        .getEmployeeId()
                        .equals(id))
                .findFirst()
                .orElseThrow(()->
                        new EmployeeNotFoundException("Employee Not Found With Id: "+id));
    }

    @Override
    public String deleteById(String id) {
        Employee employee = employees
                .stream()
                .filter(e -> e
                        .getEmployeeId()
                        .equals(id))
                .findFirst()
                .orElseThrow(()->
                        new RuntimeException("Employee Id is Wrong: "+id));
        employees.remove(employee);
        return "Employee Deleted With Id: "+id;

    }
}
