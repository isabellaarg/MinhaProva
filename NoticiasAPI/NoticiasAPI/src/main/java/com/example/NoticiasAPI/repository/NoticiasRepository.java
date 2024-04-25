package com.example.NoticiasAPI.repository;

import com.example.NoticiasAPI.model.NoticiasEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticiasRepository extends MongoRepository<NoticiasEntity, String> {
}
