package com.example.demo.endpoints;

import com.example.demo.annotations.Permission;
import com.example.demo.model.Folk;
import com.example.demo.services.FolkService;
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
public class FolkEndpoints {
    private final FolkService folkService;

    @Autowired
    public FolkEndpoints(FolkService folkService) {
        this.folkService = folkService;
    }

    @Permission({"Create","Read","Edit"})
    @PostMapping("/folks")
    public ResponseEntity<Void> addFolk(@RequestBody Folk folk){
        folkService.addFolk(folk);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
