package com.example.movieservice.repository;

import com.example.movieservice.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepo extends MongoRepository<Movie, String> {
}
