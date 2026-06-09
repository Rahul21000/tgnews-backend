package com.tgnews.tgnews_api.service;

import com.tgnews.tgnews_api.dto.ArticleDto;
import com.tgnews.tgnews_api.dto.ArticleResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ArticleService{
    ResponseEntity<ArticleResponseDto> handleCreateArticle(ArticleDto articleDto);
    ResponseEntity<ArticleResponseDto> handleGetArticleById(Long id);
    ResponseEntity<List<ArticleResponseDto>> handleGetAllArticle();
    ResponseEntity<ArticleResponseDto> handleUpdateArticle(Long id, ArticleDto articleDto);
    ResponseEntity<String> handleDeleteArticle(Long id);

}
