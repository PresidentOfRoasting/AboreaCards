package com.example.demo.services;

import com.example.demo.model.*;
import com.example.demo.repos.CompanionCharacterRepository;
import com.example.demo.repos.OriginalCharacterRepository;
import com.example.demo.repos.OwnedCharacterRepository;
import com.example.demo.repos.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class OwnedCharacterService {
    @Autowired
    OwnedCharacterRepository ownedCharacterRepository;
    OriginalCharacterRepository originalCharacterRepository;
    PersonRepository personRepository;
    CompanionCharacterRepository companionCharacterRepository;

    public OwnedCharacterService(OwnedCharacterRepository ownedCharacterRepository, OriginalCharacterRepository originalCharacterRepository,
                                 CompanionCharacterRepository companionCharacterRepository, PersonRepository personRepository) {
        this.ownedCharacterRepository = ownedCharacterRepository;
        this.originalCharacterRepository = originalCharacterRepository;
        this.companionCharacterRepository = companionCharacterRepository;
        this.personRepository = personRepository;
    }

    public void addOwnedCharacter(long personId, String originalCharacterName){
        OriginalCharacter originalCharacter = originalCharacterRepository.findByName(originalCharacterName);
        OwnedCharacter ownedCharacter = new OwnedCharacter();
        ownedCharacter.setOriginalCharacter(originalCharacter);
        ownedCharacter.setArmor(originalCharacter.getArmor());
        ownedCharacter.setAttack(originalCharacter.getAttack());
        ownedCharacter.setDescription(originalCharacter.getDescription());
        ownedCharacter.setDoubleAttack(originalCharacter.getDoubleAttack());
        ownedCharacter.setName(originalCharacter.getName());
        ownedCharacter.setNamed(originalCharacter.getNamed());
        ownedCharacter.setFolk(originalCharacter.getFolk());
        //ownedCharacter.setGame(actualGame.Id);
        ownedCharacter.setGrade(originalCharacter.getGrade());
        Optional<Person> person = personRepository.findById(personId);
        person.ifPresent(ownedCharacter::setPerson);
        ownedCharacter.setCompanion(originalCharacter.getCompanion());
        ownedCharacterRepository.save(ownedCharacter);

        if (originalCharacter.getCompanion())
        {
            if (originalCharacter.getName() == "Gorn")
            {
                if (Adventure.ThrowDices.ThrowTenDice() > 8)
                {
                    var companionCharacters = originalCharacter.getCompanionCharacters();
                    var companionCharacter = companionCharacters.get(0);
                    ownedCharacter = new OwnedCharacter();
                    ownedCharacter.setOriginalCharacter(originalCharacter);
                    ownedCharacter.setCompanionCharacter(companionCharacter);
                    ownedCharacter.setName(companionCharacter.getName());
                    ownedCharacter.setNation(companionCharacter.getNation());
                    ownedCharacter.setArmor(companionCharacter.getArmor());
                    ownedCharacter.setAttack(companionCharacter.getAttack());
                    ownedCharacter.setInitiative(companionCharacter.getInitiative());
                    ownedCharacter.setLivePoints(companionCharacter.getLivePoints());
                    ownedCharacter.setDescription(companionCharacter.getDescription());
                    //ownedCharacter.setGame(actualGame.Id);
                    person.ifPresent(ownedCharacter::setPerson);
                    ownedCharacterRepository.save(ownedCharacter);
                }
            }
            else
            {
                var companionCharacters = originalCharacter.getCompanionCharacters();
                for (int i = 0; i < companionCharacters.size(); i++)
                {
                    var companionCharacter = companionCharacters.get(i);
                    ownedCharacter = new OwnedCharacter();
                    ownedCharacter.setOriginalCharacter(originalCharacter);
                    ownedCharacter.setCompanionCharacter(companionCharacter);
                    ownedCharacter.setName(companionCharacter.getName());
                    ownedCharacter.setNation(companionCharacter.getNation());
                    ownedCharacter.setArmor(companionCharacter.getArmor());
                    ownedCharacter.setAttack(companionCharacter.getAttack());
                    ownedCharacter.setInitiative(companionCharacter.getInitiative());
                    ownedCharacter.setLivePoints(companionCharacter.getLivePoints());
                    ownedCharacter.setDescription(companionCharacter.getDescription());
                    //ownedCharacter.setGame(actualGame.Id);
                    person.ifPresent(ownedCharacter::setPerson);
                    ownedCharacterRepository.save(ownedCharacter);
                }
            }
        }
    }

    public OwnedCharacter updateOwnedCharacter(Long id, OwnedCharacter updatedOwnedCharacter) {
        OwnedCharacter existingOwnedCharacter = ownedCharacterRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found"));

        existingOwnedCharacter.setName(updatedOwnedCharacter.getName());

        return ownedCharacterRepository.save(existingOwnedCharacter);
    }

    public void deleteOwnedCharacter(OwnedCharacter ownedCharacter){
        ownedCharacterRepository.delete(ownedCharacter);
    }
}

