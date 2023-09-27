package com.example.demo.repos;

import com.example.demo.model.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game,Long>  {
}
