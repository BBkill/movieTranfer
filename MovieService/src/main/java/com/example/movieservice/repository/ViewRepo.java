package com.example.movieservice.repository;

import com.example.movieservice.model.View;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ViewRepo extends MongoRepository<View, String> {
}
