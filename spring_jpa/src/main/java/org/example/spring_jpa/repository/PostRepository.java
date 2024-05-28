package org.example.spring_jpa.repository;

import org.example.spring_jpa.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
//  List<Post> findAll();
//  Post findById(int postId);
//  void delete(int postId);
//  void update(Post post);
//  int insert(Post post);
}
