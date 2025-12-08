package com.seccuritySpring.security.spring.services;

import com.seccuritySpring.security.spring.entity.Library;
import com.seccuritySpring.security.spring.repository.LibRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryServices{
    @Autowired
    LibRepo repo;

    @Override
    public List<Library> getAllStudents() {
        return repo.findAll();
    }
    @Override
    public Library getStudentById(Long id) {
        return repo.findById(id)
                .orElseThrow(
                        ()->new RuntimeException(
                                "Student Not Found With This Id: "+id));
    }

    @Override
    public Library addStudent(Library library) {
        return repo.save(library);
    }

    @Override
    public String deleteStudentById(Long id) {
        repo.deleteById(id);
        return "Student Deleted of This Id: "+id;
    }
}
