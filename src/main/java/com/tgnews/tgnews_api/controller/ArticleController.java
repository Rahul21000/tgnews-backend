package com.tgnews.tgnews_api.controller;

import com.tgnews.tgnews_api.dto.ArticleDto;
import com.tgnews.tgnews_api.dto.ResponseDto;
import com.tgnews.tgnews_api.service.ArticleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<ResponseDto> createArticle(@Valid @RequestBody ArticleDto articleDto) {
        return articleService.handleCreateArticle(articleDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> getArticleById(@PathVariable Long id) {
        return articleService.handleGetArticleById(id);
    }

    @GetMapping
    public ResponseEntity<ResponseDto> getAllArticles() {
        return articleService.handleGetAllArticle();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> updateArticle(@PathVariable Long id,
                                           @Valid @RequestBody ArticleDto articleDto) {
        return articleService.handleUpdateArticle(id, articleDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteArticle(@PathVariable Long id){
        return articleService.handleDeleteArticle(id);
    }

}
