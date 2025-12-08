package com.employeeManagement.employee.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee",
        uniqueConstraints = {
        @UniqueConstraint(name = "unique_employeeName_employeeDepartment",
                          columnNames = {"employee_name","employee_dept"})
                            })
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeId;
    @Column(name = "employee_name")
    private String employeeName;
    @Column(name = "employee_dept")
    private String employeeDepartment;
    @Column(name = "employee_salary")
    private Long employeeSalary;

    @Column(name = "company_id")
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_company_id")
    private Long Company;

}
