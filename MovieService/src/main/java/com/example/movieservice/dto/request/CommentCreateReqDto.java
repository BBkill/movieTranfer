package com.example.movieservice.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentCreateReqDto {

    private String movieName;
    private String author;
    private String content;
    private String replyUser;
}
