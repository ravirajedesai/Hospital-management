package com.rest.SpringBootRest.Repo;

import com.rest.SpringBootRest.Model.JobPost;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class JobRepo {

    // Sample in-memory job list
    private List<JobPost> jobs = new ArrayList<>(Arrays.asList(
            new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
                    Arrays.asList("Core Java", "Spring Boot", "JPA"))
    ));

    // Method to add new job
    public void addJob(JobPost jobPost) {
        jobs.add(jobPost);
    }

    // Method to get all jobs
    public List<JobPost> getAllJobs() {
        return jobs;
    }
}
