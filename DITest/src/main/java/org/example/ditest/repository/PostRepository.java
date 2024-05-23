package org.example.ditest.repository;

import org.apache.ibatis.annotations.Mapper;
import org.example.ditest.model.Post;

import java.util.List;

@Mapper
public interface PostRepository {
    List<Post> findAll();
    Post findById(int postId);
    void delete(int postId);
    void update(Post post);
    int insert(Post post);
}
