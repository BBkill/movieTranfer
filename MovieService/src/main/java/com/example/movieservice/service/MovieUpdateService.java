package com.example.movieservice.service;

import com.example.movieservice.dto.request.MovieUpdateReqDto;
import com.example.movieservice.dto.response.MovieUpdateResDto;
import org.springframework.web.multipart.MultipartFile;

public interface MovieUpdateService {
    MovieUpdateResDto upLoadMovie(MultipartFile file, MovieUpdateReqDto reqDto);
}
