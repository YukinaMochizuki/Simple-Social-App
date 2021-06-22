package com.example.apimock;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Post {
    private String name;
    private String type;
    private String time;
    private String location;
    private String content;
    private int pushCount;
    private int commentCount;
    private List<Comment> comment;
}
