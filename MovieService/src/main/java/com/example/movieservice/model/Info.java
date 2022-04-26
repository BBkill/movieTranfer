package com.example.movieservice.model;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Info {

    private Date createdAt;
    private String createdBy;
    private Date updatedAt;
    private String updatedBy;
}
