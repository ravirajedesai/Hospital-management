package com.student.student.demo.feignClient;

import com.student.student.demo.model.CollegeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "COLLEGE-SERVICE")
public interface CollegeClient {

    @GetMapping("/colleges/{id}")
    public CollegeDTO getStudentWithCollege(@PathVariable Long id);
    //, url = "http://localhost:8081"`
}
