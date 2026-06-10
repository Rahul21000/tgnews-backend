package com.tgnews.tgnews_api.service;

import com.tgnews.tgnews_api.dto.ArticleDto;
import com.tgnews.tgnews_api.dto.ArticleResponseDto;
import com.tgnews.tgnews_api.dto.ResponseDto;
import com.tgnews.tgnews_api.entity.Article;
import com.tgnews.tgnews_api.exception.ArticleNotFoundException;
import com.tgnews.tgnews_api.repository.ArticleRepository;
import com.tgnews.tgnews_api.utils.ArticleMapper;
import com.tgnews.tgnews_api.utils.ResponseUtils;
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
    @Autowired
    private ResponseUtils responseUtils;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public ResponseEntity<ResponseDto> handleCreateArticle(ArticleDto articleDto) {
        Article article = ArticleMapper.mapDtoToEntity(articleDto);
        Article savedArticle = articleRepository.save(article);
        return responseUtils.handleResponseInPayload(savedArticle,"Article created successfully",201,HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ResponseDto> handleGetArticleById(Long id) throws ArticleNotFoundException {
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new ArticleNotFoundException("Article not found"));
        return responseUtils.handleResponseInPayload(article,"Article fetch successfully",200,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseDto> handleGetAllArticle() {
        List<ArticleResponseDto> articles = articleRepository.findAll()
                .stream()
                .map(ArticleMapper::mapEntityToDto)
                .collect(Collectors.toList());

        return responseUtils.handleResponseInPayload(articles,"Articles fetched successfully",200,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseDto> handleUpdateArticle(Long id, ArticleDto articleDto) {
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Article not found"));
        article.setTitle(articleDto.getTitle());
        article.setContent(articleDto.getContent());
        article.setAuthor(articleDto.getAuthor());
        Article savedArticle = articleRepository.save(article);
        return responseUtils.handleResponseInPayload(savedArticle,"Article updated successfully",200,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseDto> handleDeleteArticle(Long id) {
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Article not found"));

        articleRepository.delete(article);
        return responseUtils.handleResponseInPayload(null,"Article created successfully",400,HttpStatus.NO_CONTENT);
    }
}
