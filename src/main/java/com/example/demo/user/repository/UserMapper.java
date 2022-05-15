package com.example.demo.user.repository;

import com.example.demo.user.dto.SelectUserDto;
import com.example.demo.user.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Mapper
public interface UserMapper {
    List<SelectUserDto> getUser();
    SelectUserDto getUserById(Integer id);
    Integer insertUser(UserDto UserDto);

    Integer updateUser(Integer id, UserDto UserDto );
    Integer deleteUser(Integer id);

    UserDto loginUser(UserDto UserDto);

}
