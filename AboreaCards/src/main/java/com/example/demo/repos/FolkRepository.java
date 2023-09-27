package com.example.demo.repos;

import com.example.demo.model.Folk;
import org.springframework.data.repository.CrudRepository;

public interface FolkRepository extends CrudRepository<Folk,Long>  {
}
