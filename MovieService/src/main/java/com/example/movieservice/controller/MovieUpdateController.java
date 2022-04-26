package com.example.movieservice.controller;

import com.example.movieservice.dto.request.MovieUpdateReqDto;
import com.example.movieservice.dto.response.MovieUpdateResDto;
import com.example.movieservice.service.MovieUpdateService;
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

    @PostMapping
    public ResponseEntity<MovieUpdateResDto> updateNewMovie(@RequestParam("file") MultipartFile file,
                                                            @RequestBody @Valid MovieUpdateReqDto reqDto) {
        return ResponseEntity.ok(service.upLoadMovie(file, reqDto));
    }

}
