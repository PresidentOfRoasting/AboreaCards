package com.example.demo.services;

import com.example.demo.model.Adventure;
import com.example.demo.repos.AdventureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdventureService {
    @Autowired
    AdventureRepository adventureRepository;

    public AdventureService(AdventureRepository adventureRepository) {
        this.adventureRepository = adventureRepository;
    }

    public void addAdventure(Adventure adventure){
        adventureRepository.save(adventure);
    }

    public void deleteAdventure(Adventure adventure){
        adventureRepository.delete(adventure);
    }
}
