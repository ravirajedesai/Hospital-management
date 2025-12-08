package com.springJdbc.springJdbcexample.Service;


import com.springJdbc.springJdbcexample.Model.Student;
import com.springJdbc.springJdbcexample.Reposito.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    StudentRepo repo;

    public StudentRepo getRepo() {
        return repo;
    }

    @Autowired
    public void setRepo(StudentRepo repo) {
        this.repo = repo;
    }

    public void addStudent(Student s) {
        repo.save(s);
    }

    public List<Student> getStudent() {
        return repo.findAll();
    }
}
