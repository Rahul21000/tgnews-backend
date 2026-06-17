package com.tgnews.tgnews_api.service;

import com.tgnews.tgnews_api.dto.PostDto;
import com.tgnews.tgnews_api.dto.ResponseDto;
import com.tgnews.tgnews_api.exception.PostAlreadyExistException;
import com.tgnews.tgnews_api.exception.PostNotFoundException;
import org.springframework.http.ResponseEntity;

public interface PostService {
    ResponseEntity<ResponseDto> handleCreatePost(PostDto postDto) throws PostAlreadyExistException;
    ResponseEntity<ResponseDto> handleGetPostById(Long id) throws PostNotFoundException;
    ResponseEntity<ResponseDto> handleGetAllPosts() throws RuntimeException;
    ResponseEntity<ResponseDto> handleUpdatePost(Long id, PostDto postDto) throws PostNotFoundException;
    ResponseEntity<ResponseDto> handleDeletePost(Long id) throws PostNotFoundException;

}
