package com.tgnews.tgnews_api.service;

import com.tgnews.tgnews_api.dto.PostDto;
import com.tgnews.tgnews_api.dto.PostResponseDto;
import com.tgnews.tgnews_api.dto.ResponseDto;
import com.tgnews.tgnews_api.entity.Post;
import com.tgnews.tgnews_api.exception.PostAlreadyExistException;
import com.tgnews.tgnews_api.exception.PostNotFoundException;
import com.tgnews.tgnews_api.repository.PostRepository;
import com.tgnews.tgnews_api.utils.PostMapper;
import com.tgnews.tgnews_api.utils.ImageUploadUtil;
import com.tgnews.tgnews_api.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private final PostRepository postRepository;
    @Autowired
    private ResponseUtils responseUtils;
    @Autowired
    private final ImageUploadUtil imageUploadUtil;

    public PostServiceImpl(PostRepository postRepository, ImageUploadUtil imageUploadUtil) {
        this.postRepository = postRepository;
        this.imageUploadUtil = imageUploadUtil;
    }

    @Override
    public ResponseEntity<ResponseDto> handleCreatePost(PostDto postDto) throws PostAlreadyExistException {
        if(postRepository.existsByTitle(postDto.getTitle())){
            throw new PostAlreadyExistException("Article already exists with title: " + postDto.getTitle());
        }
        Post post = PostMapper.mapDtoToEntity(postDto);
        String imageUrl = imageUploadUtil.uploadImage(postDto.getImage());
        post.setImageUrl(imageUrl);
        Post savedPost = postRepository.save(post);
        return responseUtils.handleResponseInPayload(savedPost,"Article created successfully",HttpStatus.CREATED.value(),HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ResponseDto> handleGetPostById(Long id) throws PostNotFoundException {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException("Article not found id: " + id));
        return responseUtils.handleResponseInPayload(post,"Article fetch successfully",200,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseDto> handleGetAllPosts() throws PostNotFoundException {
        List<PostResponseDto> articles = postRepository.findAll()
                .stream()
                .map(PostMapper::mapEntityToDto)
                .collect(Collectors.toList());

        return responseUtils.handleResponseInPayload(articles,"Articles fetched successfully",200,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseDto> handleUpdatePost(Long id, PostDto postDto) throws PostNotFoundException {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException("Article not found id " + id));
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setAuthor(postDto.getAuthor());
        Post savedPost = postRepository.save(post);
        return responseUtils.handleResponseInPayload(savedPost,"Article updated successfully",200,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseDto> handleDeletePost(Long id) throws PostNotFoundException {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException("Article not found"));

        postRepository.delete(post);
        return responseUtils.handleResponseInPayload(null,"Article deleted successfully",400,HttpStatus.NO_CONTENT);
    }
}
