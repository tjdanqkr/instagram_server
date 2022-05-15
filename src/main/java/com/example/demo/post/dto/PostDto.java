package com.example.demo.post.dto;

import lombok.Data;

@Data
public class PostDto {
    private Integer id;
    private Integer userId;
    private String img;
    private String content;
}
