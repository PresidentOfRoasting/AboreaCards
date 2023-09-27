package com.example.demo.services;

import com.example.demo.model.Folk;
import com.example.demo.repos.FolkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FolkService {
    @Autowired
    FolkRepository folkRepository;

    public FolkService(FolkRepository folkRepository) {
        this.folkRepository = folkRepository;
    }

    public void addFolk(Folk folk){
        folkRepository.save(folk);
    }

    public void deleteFolk(Folk folk){
        folkRepository.delete(folk);
    }
}
