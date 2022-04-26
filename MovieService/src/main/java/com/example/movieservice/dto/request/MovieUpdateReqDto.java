package com.example.movieservice.dto.request;

import com.example.movieservice.model.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieUpdateReqDto {

    private String name;
    private int age;
    private String director;
    private String country;
    private Date releaseDate;
    private String description;
    private long length;
    private Actor[] actors;
    private Category[] categories;
    private String accessToken;
}
