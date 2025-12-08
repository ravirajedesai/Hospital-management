package com.hospital_management.patient.Controller;

import com.hospital_management.patient.entity.Appointment;
import com.hospital_management.patient.service.AppointmentService;
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
    ResponseEntity<List<Appointment>> getAllAppointments(){
        List<Appointment> appointment=service.getAllAppointments();
        return ResponseEntity.ok(appointment);
    }
    @GetMapping("/{id}")
    ResponseEntity<Appointment> getAppointmentById(@PathVariable Long id){
        Appointment appointmentById=service.getAppointmentById(id);
        return ResponseEntity.ok(appointmentById);
    }
    @DeleteMapping("/{id}")
    void deleteAppointment(@PathVariable Long id){
        service.deleteAppointment(id);
    }
    @PostMapping
    ResponseEntity<Appointment> addAppointment(@RequestBody Appointment appointment){
        Appointment add=service.addAppointment(appointment);
        return ResponseEntity.ok(add);
    }
}
