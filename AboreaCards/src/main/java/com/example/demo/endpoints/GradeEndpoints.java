package com.example.demo.endpoints;

import com.example.demo.annotations.Permission;
import com.example.demo.model.Grade;
import com.example.demo.services.GradeService;
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
public class GradeEndpoints {
    @Autowired
    private final GradeService gradeService;

    public GradeEndpoints(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @Permission({"Create","Read","Edit"})
    @PostMapping("/grades")
    public ResponseEntity<Void> addGrade(@RequestBody Grade grade){
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
