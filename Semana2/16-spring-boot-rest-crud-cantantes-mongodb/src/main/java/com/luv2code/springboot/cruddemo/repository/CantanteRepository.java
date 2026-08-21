package com.luv2code.springboot.cruddemo.repository;

import com.luv2code.springboot.cruddemo.entity.Futbolista;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CantanteRepository extends MongoRepository<Futbolista, String> {
    // MongoDB y Spring Data se encargan de toda la implementación.
}
