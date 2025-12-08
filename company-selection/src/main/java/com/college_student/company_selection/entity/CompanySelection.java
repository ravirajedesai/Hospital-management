package com.college_student.company_selection.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanySelection {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Company_Id;
    private String Company_Name;
    private String Company_Location;
}
