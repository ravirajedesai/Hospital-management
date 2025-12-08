package com.student.student.demo.service;
import com.student.student.demo.feignClient.CollegeClient;
import com.student.student.demo.entity.Student;
import com.student.student.demo.exceptions.StudentNotFoundException;
import com.student.student.demo.feignClient.CompanyClient;
import com.student.student.demo.model.CollegeDTO;
import com.student.student.demo.model.CompanyDTO;
import com.student.student.demo.model.CompanyResponse;
import com.student.student.demo.model.StudentResponse;
import com.student.student.demo.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepo repo;

    @Autowired
    private CollegeClient collegeClient;

    @Autowired
    private CompanyClient companyClient;

    @Override
    public Student findById(Long id) {
        return repo.findById(id)
                .orElseThrow(()->
                        new StudentNotFoundException("Student Not Found With This Id: "+id));
    }

    @Override
    public List<Student> findAll() {
        return repo.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return repo.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        if(!repo.existsById(id)){
            throw new StudentNotFoundException("Student Not Found With This Id: "+id);
        }
        repo.deleteById(id);
    }
    public StudentResponse getStudentWithCollege(Long studId){
        Student student=findById(studId);

        CollegeDTO college=collegeClient.getStudentWithCollege(student.getCollegeId());

        StudentResponse studentResponse=new StudentResponse();
        studentResponse.setId(student.getId());
        studentResponse.setCity(student.getCity());
        studentResponse.setName(student.getName());
        studentResponse.setCollegeName(college.getCollegeName());
        studentResponse.setCollegeCity(college.getCollegeCity());
        return studentResponse;
    }
    @Override
    public CompanyResponse getStudentWithCompany(Long id) {
        Student student=findById(id);

        CompanyDTO company=companyClient.getStudentWithCompany(student.getCompanyId());

        CompanyResponse companyResponse=new CompanyResponse();
        companyResponse.setId(student.getId());
        companyResponse.setName(student.getName());
        companyResponse.setCity(student.getCity());
        companyResponse.setCompanyName(company.getCompanyName());
        companyResponse.setCompanyLocation(company.getCompanyLocation());
        return companyResponse;
    }

}
