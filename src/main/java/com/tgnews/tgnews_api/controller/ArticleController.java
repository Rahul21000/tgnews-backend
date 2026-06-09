package com.tgnews.tgnews_api.controller;

import com.tgnews.tgnews_api.dto.ArticleDto;
import com.tgnews.tgnews_api.dto.ArticleResponseDto;
import com.tgnews.tgnews_api.service.ArticleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/articles")
public class ArticleController {
   @Autowired
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    // CREATE
    @PostMapping("/create")
    public ResponseEntity<ArticleResponseDto> createArticle(@Valid @RequestBody ArticleDto articleDto) {
        return articleService.handleCreateArticle(articleDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleResponseDto> getArticleById(@PathVariable Long id) {
        return articleService.handleGetArticleById(id);
    }

    @GetMapping
    public ResponseEntity<List<ArticleResponseDto>> getAllArticles() {
        return articleService.handleGetAllArticle();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArticleResponseDto> updateArticle(@PathVariable Long id,
                                           @Valid @RequestBody ArticleDto articleDto) {
        return articleService.handleUpdateArticle(id, articleDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteArticle(@PathVariable Long id) {
        return articleService.handleDeleteArticle(id);
    }

}
