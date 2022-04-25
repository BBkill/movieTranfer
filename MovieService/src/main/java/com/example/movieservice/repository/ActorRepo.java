package com.example.movieservice.repository;

import com.example.movieservice.model.Actor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ActorRepo extends MongoRepository<Actor, String> {
}
