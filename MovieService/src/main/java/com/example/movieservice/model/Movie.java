package com.example.movieservice.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Date;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "movie")
@Builder
public class Movie {

    @Id
    private Long id;
    private String name;
    private int age;
    private String director;
    private String country;
    private float rate;
    private Date releaseDate;
    private String description;
    private long length;
    private String movieLink; //link
    private String posterLink; //link
    private Set<Actor> actors;
    private Set<Category> categories;
    private List<Comment> comments;
    private Set<Reaction> reactions;
    private long view;
    private Info info;
}
