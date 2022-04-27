package com.example.movieservice.controller;

import com.example.movieservice.dto.request.MovieUpdateReqDto;
import com.example.movieservice.dto.response.MovieUpdateResDto;
import com.example.movieservice.service.MovieUpdateService;
import core.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/update-movie")
public class MovieUpdateController {

    private final MovieUpdateService service;

    @Autowired
    public MovieUpdateController(MovieUpdateService service) {
        this.service = service;
    }

    @PostMapping("/upload")
    public Result<String> uploadNewMovie(@RequestParam("file") MultipartFile file) {
        return Result.success(service.upLoadMovie(file));
    }

    @PostMapping("/update")
    public Result<MovieUpdateResDto> updateNewMovie(@RequestBody MovieUpdateReqDto reqDto) {
        return Result.success(service.insertMovie(reqDto));
    }

}
