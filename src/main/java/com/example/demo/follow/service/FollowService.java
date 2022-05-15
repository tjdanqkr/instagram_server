package com.example.demo.follow.service;

import com.example.demo.follow.dto.FollowDto;
import com.example.demo.follow.dto.FollowUserDto;

import java.util.List;

public interface FollowService {

    List<FollowUserDto> getFollowing(Integer followerId);
    List<FollowUserDto> getFollower(Integer followingId);
    Integer insertFollow(FollowDto followDto);
    Integer deleteFollow(FollowDto followDto);
}
