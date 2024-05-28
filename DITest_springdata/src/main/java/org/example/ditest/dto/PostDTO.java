package org.example.ditest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostDTO {
    private String title;
    private String body;
    private int postId;
    private int Likes;
}