package com.example.testmongo;

import com.example.testmongo.model.Product;
import com.example.testmongo.repo.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TestMongoApplication {


    public static void main(String[] args) {
        SpringApplication.run(TestMongoApplication.class, args);
    }



}
