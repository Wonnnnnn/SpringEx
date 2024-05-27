package org.example.ditest.repository;

import org.apache.ibatis.annotations.Mapper;
import org.example.ditest.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
/*//    @Select("select * from post")
    List<Post> findAll();
//    @Select("select * from post where postId = #{postId}")
    Post findById(int postId);
    void delete(int postId);
    void update(Post post);
    int insert(Post post);*/

}
