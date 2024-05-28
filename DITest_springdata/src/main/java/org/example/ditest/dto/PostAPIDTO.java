package org.example.ditest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostAPIDTO {
    private int postId;
    private int Likes;
    private String body;
}
