package com.example.demo.follow.repository;

import com.example.demo.follow.dto.FollowDto;
import com.example.demo.follow.dto.FollowUserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FollowMapper {
    List<FollowUserDto> getFollowing(Integer followerId);
    List<FollowUserDto> getFollower(Integer followingId);
    List<FollowUserDto> getFollowerByOne(FollowDto followDto);
    Integer insertFollow(FollowDto followDto);
    Integer deleteFollow(FollowDto followDto);
}
