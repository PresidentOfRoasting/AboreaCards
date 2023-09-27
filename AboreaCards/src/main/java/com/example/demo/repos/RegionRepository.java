package com.example.demo.repos;

import com.example.demo.model.Region;
import org.springframework.data.repository.CrudRepository;

public interface RegionRepository extends CrudRepository<Region,Long> {
    Region findByName(String name);
}
