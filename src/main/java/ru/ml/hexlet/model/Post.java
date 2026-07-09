package ru.ml.hexlet.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class Post {
    @NonNull
    private String title;
    @NonNull
    private String content;
    private String author;
    private LocalDateTime createAt;
}
