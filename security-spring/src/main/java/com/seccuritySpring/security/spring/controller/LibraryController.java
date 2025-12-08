package com.seccuritySpring.security.spring.controller;

import com.seccuritySpring.security.spring.entity.Library;
import com.seccuritySpring.security.spring.services.LibraryServices;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController {
    @Autowired
    LibraryServices services;

    @GetMapping
    List<Library> getStudent(){
       return services.getAllStudents();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Library> getStudentById(@PathVariable Long id){
        Library student= services.getStudentById(id);
        return ResponseEntity.ok(student);
    }
    @PostMapping
    Library addStudent(@RequestBody Library library){
        return services.addStudent(library);
    }
    @DeleteMapping("/{id}")
    String deleteStudentById(@PathVariable Long id){
        services.deleteStudentById(id);
        return "Student Deleted With Id: "+id;
    }
    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

}
