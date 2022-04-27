package com.example.movieservice.dto.response;

import com.example.movieservice.model.Info;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentCreateResDto {

    private String username;
    private String movieId;
    private String content;
    private String replyUser;
    private Info info;
}
