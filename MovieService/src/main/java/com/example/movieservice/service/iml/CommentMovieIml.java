package com.example.movieservice.service.iml;

import com.example.movieservice.dto.request.CommentCreateReqDto;
import com.example.movieservice.model.Comment;
import com.example.movieservice.model.Info;
import com.example.movieservice.repository.CommentRepo;
import com.example.movieservice.repository.MovieRepo;
import com.example.movieservice.service.CommentMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CommentMovieIml implements CommentMovieService {

    private final MovieRepo movieRepo;
    private final CommentRepo commentRepo;

    @Autowired
    public CommentMovieIml(MovieRepo movieRepo, CommentRepo commentRepo) {
        this.movieRepo = movieRepo;
        this.commentRepo = commentRepo;
    }

    @Override
    public Comment create(CommentCreateReqDto reqDto) {

        Info info = Info.builder()
                .createdAt(new Date())
                .createdBy(reqDto.getAuthor())
                .updatedBy(reqDto.getAuthor())
                .updatedAt(new Date())
                .build();

        Comment comment = new Comment();
        comment.setContent(reqDto.getContent());
        comment.setMovieId(movieRepo.findByName(reqDto.getMovieName()).getId());
        comment.setInfo(info);
        comment.setUsername("barack"); //TODO: map user name
        comment.setReplyUser("obama"); //TODO: map reply user name
        return  commentRepo.save(comment);
    }


}
