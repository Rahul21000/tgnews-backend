package com.tgnews.tgnews_api.dto;
import lombok.Data;


@Data
public class PostResponseDto {
        private Long id;
        private String title;
        private String content;
        private String author;
}
