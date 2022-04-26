package com.example.movieservice.controller;

import com.example.movieservice.dto.request.MovieUpdateReqDto;
import com.example.movieservice.dto.response.MovieUpdateResDto;
import com.example.movieservice.service.MovieUpdateService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/update-movie")
public class MovieUpdateController {

    private final MovieUpdateService service;

    @Autowired
    public MovieUpdateController(MovieUpdateService service) {
        this.service = service;
    }

    @PostMapping("/upload")
    public String uploadNewMovie(@RequestParam("file") MultipartFile file) {
        return service.upLoadMovie(file);
    }

    @PostMapping("/update")
    public ResponseEntity<MovieUpdateResDto> updateNewMovie(@RequestBody MovieUpdateReqDto reqDto) {
        return ResponseEntity.ok(service.insertMovie(reqDto));
    }

}
