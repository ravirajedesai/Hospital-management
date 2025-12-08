package com.hospital_management.patient.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;
    @Column(nullable = false)
    private String patientName;
    @Column(nullable = false,unique = true)
    private String patientEmail;
    @Column(nullable = false)
    private String patientGender;

    @OneToMany(mappedBy = "patient",
                cascade = CascadeType.ALL,
                orphanRemoval = true)
    private List<Appointment> appointment;
}
