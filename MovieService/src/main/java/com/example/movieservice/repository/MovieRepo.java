package com.example.movieservice.repository;

import com.example.movieservice.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MovieRepo extends MongoRepository<Movie, String> {

    Movie findByName(String name);
}
