package com.bookAppointment.doctor_service.controller;

import com.bookAppointment.doctor_service.entity.Doctor;
import com.bookAppointment.doctor_service.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    DoctorService service;

    @GetMapping
    public ResponseEntity<Page<Doctor>> getAllDoctors(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "5") int pageSize,
            @RequestParam(defaultValue = "doctorName") String  sortBy
    ){
        Page<Doctor> doctor=service.getAllDoctors(pageNo,pageSize,sortBy);
        return ResponseEntity.ok(doctor);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id){
        Doctor getDoctor=service.getDoctorById(id);
        return ResponseEntity.ok(getDoctor);
    }
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteDoctorById(@PathVariable Long id){
        service.deleteDoctorById(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping
    ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor){
        Doctor addDoctor=service.addDoctor(doctor);
        return ResponseEntity.status(HttpStatus.CREATED).body(addDoctor);
    }
}
