package com.bookAppointment.doctor_service.service;

import com.bookAppointment.doctor_service.entity.Doctor;
import com.bookAppointment.doctor_service.exception.DoctorNotFound;
import com.bookAppointment.doctor_service.repository.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService{
    @Autowired
    DoctorRepo repo;

    @Override
    public Page<Doctor> getAllDoctors(int pageNo,int pageSize,String sortBy) {
        Pageable pageable= PageRequest.of(pageNo,pageSize, Sort.by(sortBy));
        return repo.findAll(pageable);
    }
    @Override
    public Doctor getDoctorById(Long id) {
        return repo.findById(id)
                .orElseThrow(()->
                new DoctorNotFound("Doctor Not Found With This Id: "+id));
    }
    @Override
    public void deleteDoctorById(Long id) {
        if(!repo.existsById(id)){
            throw new DoctorNotFound("Doctor Not Found With This Id: "+id);
        }
        repo.deleteById(id);
    }
    @Override
    public Doctor addDoctor(Doctor doctor) {
        Doctor newDoctor=repo.save(doctor);
        return newDoctor;
    }
}
