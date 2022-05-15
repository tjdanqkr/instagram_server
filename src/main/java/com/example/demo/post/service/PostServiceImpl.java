package com.example.demo.post.service;

import com.example.demo.post.dto.PostDto;
import com.example.demo.post.dto.PostUserDto;
import com.example.demo.post.repository.PostMapper;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{
    @Autowired
    PostMapper postMapper;
    @Override
    public List<PostUserDto> getAllPost() {
        return postMapper.getPostAll();
    }
    @Override
    public List<PostUserDto> getMyPost(Integer userId) {
        return postMapper.getPostByUserId(userId);
    }
    @Override
    public List<PostUserDto> getOtherPost(Integer userId) {
        return postMapper.getPostByNotUserId(userId);
    }
    @Override
    public List<PostUserDto> getPostByUserId(Integer userId) {
        return postMapper.getPostByUserId(userId);
    }
    @Override
    public PostUserDto getPostById(Integer postId) {
        return postMapper.getPostById(postId);
    }
    @Override
    public Integer postPost(PostDto postDto) {
        return postMapper.insertPost(postDto);
    }
    @Override
    public Integer updatePost(PostDto postDto) {
        return postMapper.updatePost(postDto);
    }
    @Override
    public Integer deletePost(PostDto postDto) {
        return postMapper.deletePost(postDto);
    }

    @Override
    public List<PostUserDto> getPostByMyFollowing(Integer userId) {
        return postMapper.getPostByMyFollowing(userId);
    }
    @Override
    public List<PostUserDto> getPostByKey(String key) {
        return postMapper.getPostByKey(key);
    }
}
