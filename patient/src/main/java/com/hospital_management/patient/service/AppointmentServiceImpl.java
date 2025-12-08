package com.hospital_management.patient.service;

import com.hospital_management.patient.entity.Appointment;
import com.hospital_management.patient.exception.AppointmentNotFound;
import com.hospital_management.patient.exception.PatientNotFound;
import com.hospital_management.patient.repo.AppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService{
    @Autowired
    AppointmentRepo repo;

    @Override
    public List<Appointment> getAllAppointments() {
        return repo.findAll();
    }
    @Override
    public Appointment getAppointmentById(Long id) {
        return repo.findById(id).orElseThrow(()->
                new AppointmentNotFound("Appointment Not Found For This Id: "+id));
    }
    @Override
    public void deleteAppointment(Long id) {
        repo.deleteById(id);
    }
    @Override
    public Appointment addAppointment(Appointment appointment) {
//        if(appointment.getPatient()!=null){
//            appointment.setPatient(appointment.getPatient());
//        }
        return repo.save(appointment);
    }
}
