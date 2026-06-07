package com.tgnews.tgnews_api.controller;

import com.tgnews.tgnews_api.dto.ArticleResponseDto;
import com.tgnews.tgnews_api.entity.Article;
import com.tgnews.tgnews_api.service.ArticleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/articles")
public class ArticleController {
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    // CREATE
    @PostMapping
    public ArticleResponseDto createArticle(@RequestBody Article article) {
        return articleService.createArticle(article);
    }

    // GET ALL
    @GetMapping
    public List<ArticleResponseDto> getAllArticles() {
        return articleService.getAllArticles();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ArticleResponseDto getArticleById(@PathVariable Long id) {
        return articleService.getArticleById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ArticleResponseDto updateArticle(@PathVariable Long id,
                                            @RequestBody Article article) {
        return articleService.updateArticle(id, article);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteArticle(@PathVariable Long id) {
        return articleService.deleteArticle(id);
    }

}
