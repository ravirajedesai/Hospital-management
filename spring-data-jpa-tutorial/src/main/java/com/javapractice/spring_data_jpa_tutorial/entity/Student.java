package com.javapractice.spring_data_jpa_tutorial.entity;

import jakarta.persistence.Entity;

@Entity
public class Student {
    private Long studentId;
    private String firstName;
    private String lastName;
    private String emailId;
    private String guardianName;
    private String guardianEmail;
    private String guardianMobile;

}
