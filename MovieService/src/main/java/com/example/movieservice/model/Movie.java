package com.example.movieservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
public class Movie {

    @Id
    private Long id;
    private String name;
    private int age;
    private Set<Actor> actors;
    private String director;
    private String country;
    private float rate;
    private Date releaseDate;
    private String description;
    private long length;
    private String movie; //link
    private String poster; //link
    private Set<Category> categories;
    private List<Comment> comments;
    private Set<Reaction> reactions;
    private long view;
    private Info info;
}
