package com.example.testmongo.config;

import com.example.testmongo.model.Product;
import com.example.testmongo.repo.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class InsertPro {

    private final Repository repository;

    @Autowired
    public InsertPro(Repository repository) {
        this.repository = repository;
    }

    @Bean
    private void runner() {
        Product product = new Product("car", "fast");
        repository.save(product);
    }
}
