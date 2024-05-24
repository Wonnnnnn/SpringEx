package org.example.ditest.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.ditest.model.Post;

import java.util.List;

@Mapper
public interface PostRepository {
//    @Select("select * from post")
    List<Post> findAll();
//    @Select("select * from post where postId = #{postId}")
    Post findById(int postId);
    void delete(int postId);
    void update(Post post);
    int insert(Post post);
}
