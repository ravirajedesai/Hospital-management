package com.dataJpa.springBootDataJpa.ser;

import com.dataJpa.springBootDataJpa.entity.Student;
import com.dataJpa.springBootDataJpa.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepo repo;
    @Override
    public boolean addStudentDetails(Student std) {
        boolean status= false;
        try {
            repo.save(std);
            status=true;
        }catch (Exception e) {
            e.printStackTrace();
            status = false;
        }
        return status;

    }

    @Override
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    @Override
    public Student getStudentById(long id) {
        Optional<Student>optional=repo.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }else {
            return null;
        }
    }

    @Override
    public boolean updateStudent(long id, float marks) {
       Student std= getStudentById(id);
       if(std !=null){
           std.setMarks(marks);
           repo.save(std);
           return true;
       }
        return false;
    }

    @Override
    public boolean deleteStudentById(long id) {
        boolean status= false;
        try{
            repo.deleteById(id);
            status=true;
        }catch (Exception e){
            e.printStackTrace();
            status=false;
        }
        return status;
    }
}
