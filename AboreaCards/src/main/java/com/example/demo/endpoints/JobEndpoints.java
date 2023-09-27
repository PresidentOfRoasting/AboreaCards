package com.example.demo.endpoints;

import com.example.demo.annotations.Permission;
import com.example.demo.model.Job;
import com.example.demo.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;

@RestController
@RequestMapping("/api")
public class JobEndpoints {
    @Autowired
    private final JobService jobService;

    public JobEndpoints(JobService jobService) {
        this.jobService = jobService;
    }

    @Permission({"Create","Read","Edit"})
    @PostMapping("/jobs")
    public ResponseEntity<Void> addJob(@RequestBody Job job){
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
