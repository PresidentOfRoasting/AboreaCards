package com.example.demo.repos;

import com.example.demo.model.Job;
import com.example.demo.model.Nation;
import org.springframework.data.repository.CrudRepository;

public interface JobRepository extends CrudRepository<Job,Long> {
    Job findByName(String name);
}
