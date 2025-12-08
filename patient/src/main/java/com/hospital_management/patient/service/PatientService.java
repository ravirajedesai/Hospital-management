package com.hospital_management.patient.service;

import com.hospital_management.patient.entity.Patient;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PatientService{
    List<Patient> getAllPatients();
    Patient getPatientById(Long patientId);
    void deletePatientById(Long patientId);
    Patient addNewPatient(Patient patient);
}
