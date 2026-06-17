package com.tgnews.tgnews_api.utils;

import com.tgnews.tgnews_api.dto.PostDto;
import com.tgnews.tgnews_api.entity.Post;

public class PostMapper {
    public static Post mapDtoToEntity(PostDto postDto){
        Post post = new Post();
        post.setCategory(postDto.getCategory());
        post.setTitle(postDto.getTitle());
        post.setContent((postDto.getContent()));
        post.setAuthor(postDto.getAuthor());
        return post;
    }

}
