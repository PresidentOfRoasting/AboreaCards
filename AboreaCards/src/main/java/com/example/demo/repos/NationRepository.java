package com.example.demo.repos;

import com.example.demo.model.Nation;
import org.springframework.data.repository.CrudRepository;

public interface NationRepository extends CrudRepository<Nation,Long> {
    Nation findByName(String name);
}
