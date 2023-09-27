package com.example.demo.services;

import com.example.demo.model.OriginalCharacter;
import com.example.demo.repos.OriginalCharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class OriginalCharacterService {
    @Autowired
    OriginalCharacterRepository originalCharacterRepository;

    public OriginalCharacterService(OriginalCharacterRepository originalCharacterRepository) {
        this.originalCharacterRepository = originalCharacterRepository;
    }

    public void addOriginalCharacter(OriginalCharacter originalCharacter){
        originalCharacterRepository.save(originalCharacter);
    }

    public void deleteOriginalCharacter(OriginalCharacter originalCharacter){
        originalCharacterRepository.delete(originalCharacter);
    }

    public OriginalCharacter updateOriginalCharacter(Long id, OriginalCharacter updatedOriginalCharacter) {
        OriginalCharacter existingOriginalCharacter = originalCharacterRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found"));

        existingOriginalCharacter.setName(updatedOriginalCharacter.getName());

        return originalCharacterRepository.save(existingOriginalCharacter);
    }
}
