


package com.example.demo.repos;

import com.example.demo.model.OwnedCharacter;
import org.springframework.data.repository.CrudRepository;

public interface OwnedCharacterRepository extends CrudRepository<OwnedCharacter,Long> {
    OwnedCharacter findByNameAndPersonId(String name, Long PersonId);

    OwnedCharacter findByIdAndPersonId(Long Id, Long PersonId);
}
