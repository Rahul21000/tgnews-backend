package com.tgnews.tgnews_api.service;

import com.tgnews.tgnews_api.dto.ArticleDto;
import com.tgnews.tgnews_api.dto.ResponseDto;
import com.tgnews.tgnews_api.exception.ArticleNotFoundException;
import org.springframework.http.ResponseEntity;

public interface ArticleService{
    ResponseEntity<ResponseDto> handleCreateArticle(ArticleDto articleDto) throws RuntimeException;
    ResponseEntity<ResponseDto> handleGetArticleById(Long id) throws ArticleNotFoundException;
    ResponseEntity<ResponseDto> handleGetAllArticle() throws RuntimeException;
    ResponseEntity<ResponseDto> handleUpdateArticle(Long id, ArticleDto articleDto) throws ArticleNotFoundException;
    ResponseEntity<ResponseDto> handleDeleteArticle(Long id);

}
