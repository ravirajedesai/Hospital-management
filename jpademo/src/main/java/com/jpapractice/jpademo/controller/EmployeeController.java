package com.jpapractice.jpademo.controller;

import com.jpapractice.jpademo.model.Employee;
import com.jpapractice.jpademo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping
    public List<Employee> getAllEmployees
            (@RequestParam(required = false,defaultValue = "1") int pageNo,
             @RequestParam(required = false,defaultValue = "5") int pageSize,
             @RequestParam(required = false,defaultValue = "id") String sortBy,
             @RequestParam(required = false,defaultValue = "ASC")String sortDir,
             @RequestParam(required = false)String search){
        Sort sort=null;
        if(sortDir.equalsIgnoreCase("ASC")){
            sort=Sort.by(sortBy).ascending();
        }else {
            sort=Sort.by(sortBy).descending();
        }
        return service.fetchAllEmployee(PageRequest.of(pageNo-1,pageSize,sort),search);
    }
    @PostMapping
    Employee addEmployee(@RequestBody Employee employee){
        return service.addEmployee(employee);
    }
}
