package com.example.demo.endpoints;

import com.example.demo.annotations.Permission;
import com.example.demo.model.OriginalCharacter;
import com.example.demo.model.OwnedCharacter;
import com.example.demo.services.OriginalCharacterService;
import com.example.demo.services.OwnedCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;

@RestController
@RequestMapping("/api")
public class OwnedCharacterEndpoints {
    private final OwnedCharacterService ownedCharacterService; // Mark as final

    @Autowired
    public OwnedCharacterEndpoints(OwnedCharacterService ownedCharacterService)
    {
        this.ownedCharacterService = ownedCharacterService;
    }

    @Permission({"Create", "Read", "Edit"})
    @PostMapping("/ownedCharacters")
    public ResponseEntity<Void> addOwnedCharacter(@PathVariable Long personId, @PathVariable String characterName) {
        ownedCharacterService.addOwnedCharacter(personId, characterName);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/ownedCharacters/{id}")
    public ResponseEntity<OwnedCharacter> updateOwnedCharacter(@PathVariable Long id, @RequestBody OwnedCharacter updatedOwnedCharacter) {
        OwnedCharacter updated = ownedCharacterService.updateOwnedCharacter(id, updatedOwnedCharacter); // Use the service method here
        return ResponseEntity.ok(updated);
    }
}