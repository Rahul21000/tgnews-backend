package com.tgnews.tgnews_api.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ArticleDto {
    @NotNull(message = "title can't be blank")
    private String title;
    @NotNull(message = "content required")
    private String content;
    @NotNull(message = "author name required")
    private String author;
}
