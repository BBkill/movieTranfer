package com.example.movieservice.repository;

import com.example.movieservice.model.Reaction;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReactionRepo extends MongoRepository<Reaction, String> {
}
