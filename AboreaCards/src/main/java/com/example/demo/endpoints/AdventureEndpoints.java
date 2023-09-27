package com.example.demo.endpoints;

import com.example.demo.annotations.Permission;
import com.example.demo.model.Adventure;
import com.example.demo.services.AdventureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AdventureEndpoints {
    private final AdventureService adventureService;

    @Autowired
    public AdventureEndpoints(AdventureService adventureService) {
        this.adventureService = adventureService;
    }

    @Permission({"Create","Read","Edit"})
    @PostMapping("/adventures")
    public ResponseEntity<Void> addAdventure(@RequestBody Adventure adventure){
        adventureService.addAdventure(adventure);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
