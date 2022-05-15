package com.example.demo.follow.service;

import com.example.demo.follow.dto.FollowDto;
import com.example.demo.follow.dto.FollowUserDto;
import com.example.demo.follow.repository.FollowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FollowServiceImpl implements FollowService{
    @Autowired
    FollowMapper followMapper;
    @Override
    public List<FollowUserDto> getFollowing(Integer followerId) {
        return followMapper.getFollowing(followerId);
    }

    @Override
    public List<FollowUserDto> getFollower(Integer followingId) {
        return followMapper.getFollower(followingId);
    }

    @Override
    public Integer insertFollow(FollowDto followDto) {
        return followMapper.insertFollow(followDto);
    }

    @Override
    public Integer deleteFollow(FollowDto followDto) {
        return followMapper.deleteFollow(followDto);
    }
}
