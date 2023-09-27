package com.example.demo.endpoints;

import com.example.demo.annotations.Permission;
import com.example.demo.model.Nation;
import com.example.demo.services.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;

@RestController
@RequestMapping("/api")
public class NationEndpoints {
    private final NationService nationService; // Mark as final

    @Autowired
    public NationEndpoints(NationService nationService) {
        this.nationService = nationService;
    }

    @Permission({"Create", "Read", "Edit"})
    @PostMapping("/nations")
    public ResponseEntity<Void> addNation(@RequestBody Nation nation) {
        nationService.addNation(nation);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/nations/{id}")
    public ResponseEntity<Nation> updateNation(@PathVariable Long id, @RequestBody Nation updatedNation) {
        Nation updated = nationService.updateNation(id, updatedNation); // Use the service method here
        return ResponseEntity.ok(updated);
    }
}