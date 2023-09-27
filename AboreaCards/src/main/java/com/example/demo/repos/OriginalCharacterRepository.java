package com.example.demo.repos;

import com.example.demo.model.OriginalCharacter;
import org.springframework.data.repository.CrudRepository;

public interface OriginalCharacterRepository extends CrudRepository<OriginalCharacter,Long> {
    OriginalCharacter findByName(String name);
}
