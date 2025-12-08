package com.dataJpa.springBootDataJpa.ser;

import com.dataJpa.springBootDataJpa.entity.Student;

import java.util.List;

public interface StudentService {
    public boolean addStudentDetails(Student std);
    public List<Student> getAllStudents();
    public Student getStudentById(long id);
    public boolean updateStudent(long id, float marks);
    public  boolean deleteStudentById(long id);
}
