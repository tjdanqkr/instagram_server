package com.example.demo.post.controller;

import com.example.demo.config.aspect.TokenRequired;
import com.example.demo.config.security.SecurityService;
import com.example.demo.post.dto.PostDto;
import com.example.demo.post.dto.PostUserDto;
import com.example.demo.post.service.PostService;
import com.example.demo.post.service.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("post")
@TokenRequired
public class PostController {
    @Autowired
    PostServiceImpl postService;
    @Autowired
    SecurityService securityService;

    @GetMapping()
    public List<PostUserDto> getAllPost(){
        return postService.getAllPost();
    }
    @PostMapping()
    public Integer postPost(@RequestBody PostDto postDto){
        Integer myId = Integer.valueOf(securityService.getSubject(securityService.getToken()));
        postDto.setUserId(myId);
        return postService.postPost(postDto);
    }
    @PutMapping("/{id}")
    public Integer updatePost(@RequestBody PostDto postDto, @PathVariable("id") String id){
        Integer myId = Integer.valueOf(securityService.getSubject(securityService.getToken()));
        postDto.setUserId(myId);
        postDto.setId(Integer.valueOf(id));
        return postService.updatePost(postDto);
    }
    @DeleteMapping("/{id}")
    public Integer deletePost(@PathVariable("id") Integer id){
        Integer myId = Integer.valueOf(securityService.getSubject(securityService.getToken()));
        PostDto postDto = new PostDto();
        postDto.setId(id);
        postDto.setUserId(myId);
        return postService.deletePost(postDto);
    }
    @GetMapping("/my")
    public List<PostUserDto> getMyPost(){
        Integer myId = Integer.valueOf(securityService.getSubject(securityService.getToken()));
        return postService.getMyPost(myId);
    }
    @GetMapping("/other")
    public List<PostUserDto> getOtherPost(){
        Integer myId = Integer.valueOf(securityService.getSubject(securityService.getToken()));
        return postService.getOtherPost(myId);
    }
    @GetMapping("/user/{id}")
    public List<PostUserDto> getPostByUserId(@PathVariable("id") Integer userId){
        return postService.getPostByUserId(userId);
    }
    @GetMapping("/{id}")
    public PostUserDto getPostByPostId(@PathVariable("id") Integer id){
        return postService.getPostById(id);
    }

    @GetMapping("/following")
    public List<PostUserDto> getPostByMyFollowing(){
        Integer myId = Integer.valueOf(
                securityService.getSubject(securityService.getToken())
        );
        return postService.getPostByMyFollowing(myId);
    }

    @GetMapping("/key/{key}")
    public List<PostUserDto> getPostByPostId(@PathVariable("key") String key){

        return postService.getPostByKey(key);
    }

}
