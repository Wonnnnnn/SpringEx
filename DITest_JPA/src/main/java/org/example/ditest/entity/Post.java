package org.example.ditest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="postid", nullable = false)
    private Integer postId;

    @Column(nullable = false, length = 45)
    private String title;

    @Column(length = 100)
    private String body;

    private int likes;

    @Column(length = 8)
    private String userid;
}
