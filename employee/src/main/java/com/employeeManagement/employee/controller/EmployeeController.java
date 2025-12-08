package com.employeeManagement.employee.controller;

import com.employeeManagement.employee.dto.EmployeeResponse;
import com.employeeManagement.employee.entity.Employee;
import com.employeeManagement.employee.repo.EmployeeRepo;
import com.employeeManagement.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @GetMapping
    Page<Employee> getAllEmployees(@RequestParam(required = false,defaultValue = "1") int pageNo,
                                   @RequestParam(required = false,defaultValue = "5") int pageSize,
                                   @RequestParam(required = false,defaultValue = "employeeId") String sortBy,
                                   @RequestParam(required = false,defaultValue = "ASC") String sortDir){

        Sort sort=sortDir.equalsIgnoreCase("ASC")?
                Sort.by(sortBy).ascending():
                Sort.by(sortBy).descending();
        return service.getAllEmployees(pageNo,pageSize,sort);
    }
    @PostMapping
    Employee addEmployee(@RequestBody Employee employee){
        return service.addEmployee(employee);
    }
    @DeleteMapping("/{id}")
    public void deleteEmployees(@PathVariable Long id){
        service.deleteEmployeeById(id);
    }
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
       return service.getEmployeeById(id);
    }
    @GetMapping("details/{id}")
    public EmployeeResponse getEmployeeDetails(@PathVariable Long id){
        return service.getEmployeeWithCompanyId(id);
    }
}
