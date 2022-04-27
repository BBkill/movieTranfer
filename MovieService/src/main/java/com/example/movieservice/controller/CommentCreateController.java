package com.example.movieservice.controller;

import com.example.movieservice.dto.request.CommentCreateReqDto;
import com.example.movieservice.model.Comment;
import com.example.movieservice.service.CommentMovieService;
import core.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/movie/create-comment")
public class CommentCreateController {

    private final CommentMovieService service;

    @Autowired
    public CommentCreateController(CommentMovieService service) {
        this.service = service;
    }

    @PostMapping
    public Result<Comment> creatComment(@RequestBody CommentCreateReqDto reqDto) {
        return Result.success(service.create(reqDto));
    }
}
