package com.example.movieservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "movie")
public class Comment {

    private Long id;
    private Long userId;
    private Long movieId;
    private String content;
    private Long replyId;
    private Info info;
}
