package com.example.demo.follow.controller;

import com.example.demo.config.aspect.TokenRequired;
import com.example.demo.config.security.SecurityService;
import com.example.demo.follow.dto.FollowDto;
import com.example.demo.follow.dto.FollowUserDto;
import com.example.demo.follow.service.FollowService;
import com.example.demo.follow.service.FollowServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@TokenRequired
@RequestMapping("follow")
public class FollowController {
    @Autowired
    FollowServiceImpl followService;
    @Autowired
    SecurityService securityService;
    @GetMapping("/my/following")
    public List<FollowUserDto> getMyFollowing(){
        Integer myId = Integer.valueOf(securityService.getSubject(securityService.getToken()));
        return followService.getFollowing(myId);
    }
    @GetMapping("/my/follower")
    public List<FollowUserDto> getMyFollower(){
        Integer myId = Integer.valueOf(securityService.getSubject(securityService.getToken()));
        return followService.getFollower(myId);
    }
    @GetMapping("/following/{id}")
    public List<FollowUserDto> getFollowing(@PathVariable("id") String id){

        return followService.getFollowing(Integer.valueOf(id));
    }
    @GetMapping("/follower/{id}")
    public List<FollowUserDto> getFollower(@PathVariable("id") String id){
        FollowDto followDto = new FollowDto();
        Integer myId = Integer.valueOf(securityService.getSubject(securityService.getToken()));
        followDto.setFollower(Integer.valueOf(id));
        followDto.setFollowing(myId);
        return followService.getFollowerByOne(followDto);
    }
    @PostMapping("/{id}")
    public Integer insertFollow(@PathVariable("id") String id ){
        FollowDto followDto =new FollowDto();
        Integer myId = Integer.valueOf(securityService.getSubject(securityService.getToken()));
        followDto.setFollower(Integer.valueOf(id));
        followDto.setFollowing(myId);
        return followService.insertFollow(followDto);
    }
    @DeleteMapping("/{id}")
    public Integer deleteFollow(@PathVariable("id") String id){
        FollowDto followDto =new FollowDto();
        Integer myId = Integer.valueOf(securityService.getSubject(securityService.getToken()));
        followDto.setFollowing(myId);
        followDto.setFollower(Integer.valueOf(id));
        return followService.deleteFollow(followDto);
    }

}
