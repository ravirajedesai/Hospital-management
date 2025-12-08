package com.hospital_management.patient.Controller;

import com.hospital_management.patient.entity.Patient;
import com.hospital_management.patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientService service;
    @GetMapping
    ResponseEntity<List<Patient>> getAllPatients(){
        List<Patient> patients= service.getAllPatients();
        return ResponseEntity.ok(patients);
    }
    @GetMapping("/{patientId}")
    ResponseEntity<Patient> getPatientById(@PathVariable Long patientId){
        Patient patient= service.getPatientById(patientId);
        return ResponseEntity.ok(patient);
    }
    @DeleteMapping("/{patientId}")
    void deletePatientById(@PathVariable Long patientId){
        service.deletePatientById(patientId);
    }
    @PostMapping
    ResponseEntity<Patient> addPatient(@RequestBody Patient patient){

        if(patient.getAppointment()!=null){
            patient.getAppointment().forEach(a->a.setPatient(patient));
        }
        Patient patient1= service.addNewPatient(patient);
        return ResponseEntity.ok(patient1);
    }
}
