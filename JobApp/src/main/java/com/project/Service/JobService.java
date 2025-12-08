package com.project.Service;

import com.project.Model.JobPost;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

public class JobService {

    public void AddJobs(){


    }
    public List<JobPost> getAllJobs(){

    }

    @SpringBootApplication
    public static class JobAppApplication {

        public static void main(String[] args) {
            SpringApplication.run(JobAppApplication.class, args);
        }

    }
}
