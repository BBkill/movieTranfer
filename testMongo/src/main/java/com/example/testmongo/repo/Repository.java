package com.example.testmongo.repo;

import com.example.testmongo.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Repository extends MongoRepository<Product, String> {
}
