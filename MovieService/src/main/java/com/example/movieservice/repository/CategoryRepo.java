package com.example.movieservice.repository;

import com.example.movieservice.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepo extends MongoRepository<Category, String> {
}
