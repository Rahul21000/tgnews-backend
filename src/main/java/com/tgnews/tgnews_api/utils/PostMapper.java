package com.tgnews.tgnews_api.utils;

import com.tgnews.tgnews_api.dto.PostDto;
import com.tgnews.tgnews_api.dto.PostResponseDto;
import com.tgnews.tgnews_api.entity.Post;

public class PostMapper {
    public static Post mapDtoToEntity(PostDto postDto){
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setContent((postDto.getContent()));
        post.setAuthor(postDto.getAuthor());
        return post;
    }
    public static PostResponseDto mapEntityToDto(Post post){
        PostResponseDto postResponseDto = new PostResponseDto();
        postResponseDto.setId(post.getId());
        postResponseDto.setTitle(post.getTitle());
        postResponseDto.setContent(post.getContent());
        postResponseDto.setAuthor(post.getAuthor());
        return postResponseDto;
    }
}
