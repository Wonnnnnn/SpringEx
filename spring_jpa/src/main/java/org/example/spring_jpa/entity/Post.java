package org.example.spring_jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer postId;
  @Column(nullable = false, length = 45)
  private String title;
  @Column(length = 100)
  private String body;
  private int likes;
  @Column(length = 8)
  private String userId;
}