package com.tgnews.tgnews_api.service;

import com.tgnews.tgnews_api.dto.ArticleResponseDto;
import com.tgnews.tgnews_api.entity.Article;
import com.tgnews.tgnews_api.repository.ArticleRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    // Create Article
    public ArticleResponseDto createArticle(Article article) {
        Article savedArticle = articleRepository.save(article);
        return mapToDto(savedArticle);
    }


    // GET ALL Article
    public List<ArticleResponseDto> getAllArticles() {
        return articleRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    //Get  Article
    public ArticleResponseDto getArticleById(Long id) {

        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Article not found"));

        return mapToDto(article);
    }

    // Update Article
    public ArticleResponseDto updateArticle(Long id, Article updatedArticle) {

        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Article not found"));

        article.setTitle(updatedArticle.getTitle());
        article.setContent(updatedArticle.getContent());
        article.setAuthor(updatedArticle.getAuthor());

        Article savedArticle = articleRepository.save(article);

        return mapToDto(savedArticle);
    }

    // Delete Article
    @DeleteMapping("/{id}")
    public String deleteArticle(Long id) {

        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Article not found"));

        articleRepository.delete(article);

        return "Article deleted successfully";
    }

    private ArticleResponseDto mapToDto(Article article) {

        return new ArticleResponseDto(
                article.getId(),
                article.getTitle(),
                article.getContent(),
                article.getAuthor()
        );
    }

}
