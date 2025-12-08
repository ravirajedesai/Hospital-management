package com.jpapractice.jpademo.repo;

import com.jpapractice.jpademo.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {

    Page<Employee> findByName(String name, Pageable pageable);
}
