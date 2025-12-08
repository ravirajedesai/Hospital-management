package com.hospital_management.appointment.service;

import com.hospital_management.appointment.entity.Appointment;

import java.util.List;

public interface AppointmentService {
    List<Appointment> getAllAppointments();
    Appointment getAppointmentById(Long id);
    Appointment addAppointment(Appointment appointment);
    void deleteAppointmentById(Long id);
}
