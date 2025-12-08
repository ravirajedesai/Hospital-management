package com.student.student.demo.controller;
import com.student.student.demo.feignClient.CollegeClient;
import com.student.student.demo.entity.Student;

import com.student.student.demo.feignClient.CompanyClient;
import com.student.student.demo.model.*;
import com.student.student.demo.service.StudentService;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService service;

    @Autowired
    CollegeClient collegeClient;

    @Autowired
    CompanyClient companyClient;

    @PostMapping("/college-students")
    public StudentResponse saveCollegeStudent(@RequestBody StudentRequest request){

        CollegeDTO college;
        try{
            college=collegeClient.getStudentWithCollege(request.getCollegeId());
        }catch (FeignException.NotFound e){
            throw new RuntimeException("College not found with id: " + request.getCollegeId());
        }

        Student student=new Student();
        student.setName(request.getName());
        student.setCity(request.getCity());
        student.setCollegeId(request.getCollegeId());

        Student savedStudent=service.saveStudent(student);

        StudentResponse response=new StudentResponse();
        response.setId(savedStudent.getId());
        response.setName(savedStudent.getName());
        response.setCity(savedStudent.getCity());

        response.setCollegeName(college.getCollegeName());
        response.setCollegeCity(college.getCollegeCity());

        return response;
    }
    @PostMapping("/student-company")
    public CompanyResponse saveStudentCompany(@RequestBody CompanyRequest request){

        CompanyDTO companyDTO=companyClient.getStudentWithCompany(request.getCompanyId());

        Student student=new Student();
        student.setName(request.getStudentName());
        student.setCity(request.getStudentCity());
        student.setCompanyId(request.getCompanyId());

        Student savedStudent=service.saveStudent(student);

        CompanyResponse response=new CompanyResponse();
        response.setId(savedStudent.getId());
        response.setName(savedStudent.getName());
        response.setCity(savedStudent.getCity());
        response.setCompanyName(companyDTO.getCompanyName());
        response.setCompanyLocation(companyDTO.getCompanyLocation());
        return response;

    }
    @PostMapping
    public Student save(@RequestBody Student student){
        return service.saveStudent(student);
    }
    @GetMapping
    public List<Student> getAll(){
        return service.findAll();
    }
    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id){
        return service.findById(id);
    }
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id){
        service.deleteStudent(id);
        return "Student Deleted.."+id;
    }
    @GetMapping("/college/{id}")
    public CollegeDTO getStudentWithCollege(@PathVariable Long id) {
        Student student=service.findById(id);
        return collegeClient.getStudentWithCollege(id);
    }
    @GetMapping("/company/{id}")
    public CompanyDTO getStudentWithCompany(@PathVariable Long id){
        Student student=service.findById(id);
        return companyClient.getStudentWithCompany(id);
    }


}
