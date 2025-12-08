package com.hospital_management.patient.service;

import com.hospital_management.patient.entity.Appointment;

import java.util.List;

public interface AppointmentService {
    List<Appointment> getAllAppointments();
    Appointment getAppointmentById(Long id);
    void deleteAppointment(Long id);
    Appointment addAppointment(Appointment appointment);
}
