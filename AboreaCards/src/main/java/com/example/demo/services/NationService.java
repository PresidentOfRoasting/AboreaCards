package com.example.demo.services;

import com.example.demo.model.Nation;
import com.example.demo.repos.NationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class NationService {
    @Autowired
    NationRepository nationRepository;

    public NationService(NationRepository nationRepository) {
        this.nationRepository = nationRepository;
    }

    public void addNation(Nation nation){
        nationRepository.save(nation);
    }

    public void deleteNation(Nation nation){
        nationRepository.delete(nation);
    }

    public Nation updateNation(Long id, Nation updatedNation) {
        Nation existingNation = nationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found"));

        existingNation.setName(updatedNation.getName());

        return nationRepository.save(existingNation);
    }
}
