package com.tgnews.tgnews_api.service;

import com.tgnews.tgnews_api.dto.ArticleDto;
import com.tgnews.tgnews_api.dto.ArticleResponseDto;
import com.tgnews.tgnews_api.entity.Article;
import com.tgnews.tgnews_api.repository.ArticleRepository;
import com.tgnews.tgnews_api.utils.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleServiceImpl implements ArticleService{
    @Autowired
    private final ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public ResponseEntity<ArticleResponseDto> handleCreateArticle(ArticleDto articleDto) {
        Article article = ArticleMapper.mapDtoToEntity(articleDto);
        Article savedArticle = articleRepository.save(article);
        ArticleResponseDto articleResponseDto = ArticleMapper.mapEntityToDto(savedArticle);
        return ResponseEntity.status(HttpStatus.CREATED).body(articleResponseDto);
    }

    @Override
    public ResponseEntity<ArticleResponseDto> handleGetArticleById(Long id) {
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Article not found"));
        ArticleResponseDto articleResponseDto = ArticleMapper.mapEntityToDto(article);
        return ResponseEntity.status(HttpStatus.CREATED).body(articleResponseDto);
    }

    @Override
    public ResponseEntity<List<ArticleResponseDto>> handleGetAllArticle() {
        List<ArticleResponseDto> articles = articleRepository.findAll()
                .stream()
                .map(ArticleMapper::mapEntityToDto)
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(articles);
    }

    @Override
    public ResponseEntity<ArticleResponseDto> handleUpdateArticle(Long id, ArticleDto articleDto) {
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Article not found"));
        Article savedArticle = articleRepository.save(article);
        article.setTitle(articleDto.getTitle());
        article.setContent(articleDto.getContent());
        article.setAuthor(articleDto.getAuthor());

        ArticleResponseDto articleResponseDto = ArticleMapper.mapEntityToDto(savedArticle);
        return ResponseEntity.status(HttpStatus.OK).body(articleResponseDto);
    }

    @Override
    public ResponseEntity<String> handleDeleteArticle(Long id) {
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Article not found"));

        articleRepository.delete(article);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Article deleted successfully");
    }
}
