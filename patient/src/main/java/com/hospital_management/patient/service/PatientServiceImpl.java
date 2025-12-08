package com.hospital_management.patient.service;

import com.hospital_management.patient.entity.Patient;
import com.hospital_management.patient.exception.PatientNotFound;
import com.hospital_management.patient.repo.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    PatientRepository repository;

    @Override
    public List<Patient> getAllPatients() {
        return repository.findAll();
    }
    @Override
    public Patient getPatientById(Long patientId) {
        return repository.findById(patientId)
                .orElseThrow(()-> new PatientNotFound(
                        "Patient Not Found With Id: "+patientId));
    }
    @Override
    public void deletePatientById(Long patientId) {
        repository.deleteById(patientId);
    }
    @Override
    public Patient addNewPatient(Patient patient) {
        if(patient.getAppointment()!=null){
            patient.getAppointment()
                    .forEach(a->a.setPatient(patient));
        }
        return repository.save(patient);
    }
}
