package com.rest.SpringBootRest.Service;

import com.rest.SpringBootRest.Model.JobPost;
import com.rest.SpringBootRest.Repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service public class JobService {
    @Autowired
    private JobRepo repo;

    public void addJob(JobPost jobPost){repo.addJob(jobPost);}
    public List<JobPost> getAllJobs(){
        return repo.getAllJobs();
    }
}
