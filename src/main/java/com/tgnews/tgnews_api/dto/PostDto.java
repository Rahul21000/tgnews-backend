package com.tgnews.tgnews_api.dto;

import com.tgnews.tgnews_api.enums.NewsCategory;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class PostDto {
    @NotNull(message = "Category is required")
    private NewsCategory category;
    @NotNull(message = "Title can't be blank")
    private String title;
    @NotNull(message = "Content is required")
    private String content;
    @NotNull(message = "Image URL is required")
    private MultipartFile image;
    @NotNull(message = "Author name is required")
    private String author;
}
