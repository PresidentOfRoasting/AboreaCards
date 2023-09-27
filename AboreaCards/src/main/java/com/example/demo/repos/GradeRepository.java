package com.example.demo.repos;

import com.example.demo.model.Grade;
import org.springframework.data.repository.CrudRepository;

public interface GradeRepository extends CrudRepository<Grade,Long>  {
}
