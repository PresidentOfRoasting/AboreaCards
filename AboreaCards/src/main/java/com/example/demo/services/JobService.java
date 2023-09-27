package com.example.demo.services;

import com.example.demo.model.Job;
import com.example.demo.repos.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {
    @Autowired
    JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public void addJob(Job job){
        jobRepository.save(job);
    }

    public void deleteJob(Job job){
        jobRepository.delete(job);
    }
}
