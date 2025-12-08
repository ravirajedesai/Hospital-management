package com.student.student.demo.service;
import com.student.student.demo.entity.Student;
import com.student.student.demo.model.CompanyResponse;
import com.student.student.demo.model.StudentResponse;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentService {

    Student findById(Long id);
    List<Student> findAll();
    Student saveStudent(Student student);
    void deleteStudent(Long id);


    StudentResponse getStudentWithCollege(Long id);
    CompanyResponse getStudentWithCompany(Long id);
}
