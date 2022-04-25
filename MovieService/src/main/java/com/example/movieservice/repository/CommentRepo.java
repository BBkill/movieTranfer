package com.example.movieservice.repository;

import com.example.movieservice.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepo extends MongoRepository<Comment, String> {
}
