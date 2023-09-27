package com.example.demo.services;

import com.example.demo.model.Region;
import com.example.demo.repos.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegionService {
    @Autowired
    RegionRepository regionRepository;

    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    public void addNation(Region region){
        regionRepository.save(region);
    }

    public void deleteNation(Region region){
        regionRepository.delete(region);
    }
}
