package com.example.demo.repos;

import com.example.demo.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person,Long> {
    Person findByName(String name);
}
