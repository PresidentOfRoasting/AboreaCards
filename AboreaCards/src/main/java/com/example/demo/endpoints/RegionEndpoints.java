package com.example.demo.endpoints;

import com.example.demo.annotations.Permission;
import com.example.demo.model.Region;
import com.example.demo.services.RegionService;
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
public class RegionEndpoints {
    @Autowired
    private final RegionService regionService;

    public RegionEndpoints(RegionService regionService) {
        this.regionService = regionService;
    }

    @Permission({"Create","Read","Edit"})
    @PostMapping("/regions")
    public ResponseEntity<Void> addRegion(@RequestBody Region region){
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
