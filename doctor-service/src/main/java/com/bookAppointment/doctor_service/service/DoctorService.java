package com.bookAppointment.doctor_service.service;

import com.bookAppointment.doctor_service.entity.Doctor;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DoctorService {

    Page<Doctor> getAllDoctors(int pageNo,int pageSize,String sortBy);

    Doctor getDoctorById(Long id);
    void deleteDoctorById(Long id);
    Doctor addDoctor(Doctor doctor);
}
