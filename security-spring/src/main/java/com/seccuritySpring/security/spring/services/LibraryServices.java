package com.seccuritySpring.security.spring.services;


import com.seccuritySpring.security.spring.entity.Library;
import org.springframework.stereotype.Service;

import java.util.List;

public interface LibraryServices {
    List<Library> getAllStudents();
    Library getStudentById(Long id);
    Library addStudent(Library library);
    String deleteStudentById(Long id);
}
