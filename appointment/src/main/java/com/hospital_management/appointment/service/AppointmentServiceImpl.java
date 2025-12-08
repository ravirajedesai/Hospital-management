package com.hospital_management.appointment.service;

import com.hospital_management.appointment.entity.Appointment;
import com.hospital_management.appointment.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService{
    @Autowired
    AppointmentRepository repository;

    @Override
    public List<Appointment> getAllAppointments() {
        return repository.findAll();
    }
    @Override
    public Appointment getAppointmentById(Long id) {
        return repository.findById(id)
                .orElseThrow(()->new RuntimeException("Not Found.."));
    }
    @Override
    public Appointment addAppointment(Appointment appointment) {
        return repository.save(appointment);
    }
    @Override
    public void deleteAppointmentById(Long id) {
        repository.deleteById(id);
    }
}
