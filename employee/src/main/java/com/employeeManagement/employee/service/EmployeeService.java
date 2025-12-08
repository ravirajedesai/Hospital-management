package com.employeeManagement.employee.service;

import com.employeeManagement.employee.dto.EmployeeResponse;
import com.employeeManagement.employee.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface EmployeeService {
    Page<Employee> getAllEmployees(int pageNo, int pageSize, Sort sort);

    Employee getEmployeeById(Long id);
    public void deleteEmployeeById(Long id);
    Employee addEmployee(Employee employee);

    public EmployeeResponse getEmployeeWithCompanyId(Long id);

}
