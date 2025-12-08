package com.employeeManagement.employee.dto;

import com.employeeManagement.employee.entity.Employee;
import lombok.Data;

@Data
public class EmployeeResponse {
    private Employee employee;
    private CompanyDTO company;
}
