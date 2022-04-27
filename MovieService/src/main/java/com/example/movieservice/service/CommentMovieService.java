package com.example.movieservice.service;

import com.example.movieservice.dto.request.CommentCreateReqDto;
import com.example.movieservice.model.Comment;

public interface CommentMovieService {

    Comment create(CommentCreateReqDto reqDto);
}
