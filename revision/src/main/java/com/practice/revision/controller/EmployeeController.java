package com.practice.revision.controller;

import com.practice.revision.model.Employee;
import com.practice.revision.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/employees")
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    private Employee save(@RequestBody Employee employee){
        return employeeService.save(employee);
    }
    @GetMapping
    public List<Employee>getAllEmployees(){
        return employeeService.getAllEmployees();
    }
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable String id){
        return employeeService.getEmployeeById(id);
    }
//    @DeleteMapping("/{id}")
//    public String deleteEmployeeById(@PathVariable String id){
//        return employeeService.deleteById(id);
//    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable String id) {
        boolean deleted = Boolean.parseBoolean(employeeService.deleteById(id));

        if (deleted) {
            return ResponseEntity.noContent().build(); // 204 Success
        }
        return ResponseEntity.notFound().build(); // 404 Not Found
    }

}
