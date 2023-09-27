package com.example.demo.repos;

import com.example.demo.model.Adventure;
import org.springframework.data.repository.CrudRepository;

public interface AdventureRepository extends CrudRepository<Adventure,Long>  {
}
