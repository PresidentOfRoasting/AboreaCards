package com.example.demo.endpoints;

import com.example.demo.annotations.Permission;
import com.example.demo.model.OriginalCharacter;
import com.example.demo.services.OriginalCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class OriginalCharacterEndpoints {
    private final OriginalCharacterService originalCharacterService; // Mark as final

    @Autowired
    public OriginalCharacterEndpoints(OriginalCharacterService originalCharacterService)
    {
        this.originalCharacterService = originalCharacterService;
    }

    @Permission({"Create", "Read", "Edit"})
    @PostMapping("/originalCharacters")
    public ResponseEntity<Void> addOriginalCharacter(@RequestBody OriginalCharacter originalCharacter) {
        originalCharacterService.addOriginalCharacter(originalCharacter);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/originalCharacters/{id}")
    public ResponseEntity<OriginalCharacter> updateOriginalCharacter(@PathVariable Long id, @RequestBody OriginalCharacter updatedOriginalCharacter) {
        OriginalCharacter updated = originalCharacterService.updateOriginalCharacter(id, updatedOriginalCharacter); // Use the service method here
        return ResponseEntity.ok(updated);
    }
}