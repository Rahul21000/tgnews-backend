package com.tgnews.tgnews_api.controller;

import com.tgnews.tgnews_api.dto.PostDto;
import com.tgnews.tgnews_api.dto.ResponseDto;
import com.tgnews.tgnews_api.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/articles")
public class PostController {
   @Autowired
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // CREATE
    @PostMapping(value = "/create",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ResponseDto> createPost(@ModelAttribute @Valid PostDto postDto) {
        return postService.handleCreatePost(postDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> getPostById(@PathVariable Long id) {
        return postService.handleGetPostById(id);
    }

    @GetMapping
    public ResponseEntity<ResponseDto> getAllPosts() {
        return postService.handleGetAllPosts();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> updatePost(@PathVariable Long id,
                                                  @Valid @RequestBody PostDto postDto) {
        return postService.handleUpdatePost(id, postDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deletePost(@PathVariable Long id){
        return postService.handleDeletePost(id);
    }

}
