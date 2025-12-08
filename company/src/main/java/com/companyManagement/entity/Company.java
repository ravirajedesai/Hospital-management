package com.companyManagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long companyId;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "company_city")
    private String companyCity;
    @Column(name = "company_tech_stack")
    private String companyTechStack;

}
