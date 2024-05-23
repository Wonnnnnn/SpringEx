package org.example.ditest.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Post {
    private Integer postId;
    private String title;
    private String body;
    private int likes;
}
