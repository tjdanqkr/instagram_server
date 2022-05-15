package com.example.demo.user.service;

import com.example.demo.user.dto.SelectUserDto;
import com.example.demo.user.dto.UserDto;

import java.util.List;

public interface UserService {
    List<SelectUserDto> findUser();
    SelectUserDto findUserById(Integer id);
    Integer insertUser(UserDto userDto);
    Integer deleteUser(Integer id);
    Integer updateUser(Integer id, UserDto userDto);

    UserDto loginUser(UserDto userDto);


}
