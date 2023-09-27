package com.example.demo.services;

import com.example.demo.model.Grade;
import com.example.demo.repos.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradeService {
    @Autowired
    GradeRepository gradeRepository;

    public GradeService(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    public void addGame(Grade grade){
        gradeRepository.save(grade);
    }

    public void deleteGame(Grade grade){
        gradeRepository.delete(grade);
    }
}
