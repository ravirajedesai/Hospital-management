package com.hospital_management.appointment.controller;

import com.hospital_management.appointment.entity.Appointment;
import com.hospital_management.appointment.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    AppointmentService service;

    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppointments(){
        List<Appointment> appointment=service.getAllAppointments();
        return ResponseEntity.ok(appointment);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable Long id){
        Appointment byId=service.getAppointmentById(id);
        return ResponseEntity.ok(byId);
    }
    @DeleteMapping("/{id}")
    void deleteAppointmentById(@PathVariable Long id){
        service.deleteAppointmentById(id);
    }
    @PostMapping
    ResponseEntity<Appointment> addAppointment(@RequestBody Appointment appointment){
        Appointment add=service.addAppointment(appointment);
        return ResponseEntity.ok(add);
    }

}
