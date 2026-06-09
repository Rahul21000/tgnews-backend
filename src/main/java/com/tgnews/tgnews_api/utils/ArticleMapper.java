package com.tgnews.tgnews_api.utils;

import com.tgnews.tgnews_api.dto.ArticleDto;
import com.tgnews.tgnews_api.dto.ArticleResponseDto;
import com.tgnews.tgnews_api.entity.Article;

public class ArticleMapper {
    public static Article mapDtoToEntity(ArticleDto articleDto){
        Article article = new Article();
        article.setTitle(articleDto.getTitle());
        article.setContent((articleDto.getContent()));
        article.setAuthor(articleDto.getAuthor());
        return article;
    }
    public static ArticleResponseDto mapEntityToDto(Article article){
        ArticleResponseDto articleResponseDto = new ArticleResponseDto();
        articleResponseDto.setId(article.getId());
        articleResponseDto.setTitle(article.getTitle());
        articleResponseDto.setContent(article.getContent());
        articleResponseDto.setAuthor(article.getAuthor());
        return articleResponseDto;
    }
}
