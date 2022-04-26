package com.example.movieservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieUpdateResDto {

    private String name;
    private int age;
    private String director;
    private String country;
    private Date releaseDate;
    private String description;
    private long length;
}
