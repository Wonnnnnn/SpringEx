//package org.example.spring_jpa.repository;
//
//import org.example.spring_jpa.entity.Post;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Repository
//public class MemoryPostRepositoryImpl implements PostRepository{
//  private static Map<Integer, Post> posts = new HashMap<>();
//  private static int seq = 0;
//
//  @Override
//  public List<Post> findAll() {
//    return new ArrayList<>(posts.values());
//  }
//
//  @Override
//  public Post findById(int postId) {
//    return posts.get(postId);
//  }
//
//  @Override
//  public int insert(Post post) {
//    seq++;
//    post.setPostId(seq);
//    posts.put(seq, post);
//    return seq;
//  }
//
//  @Override
//  public void update(Post post) {
//    posts.put(post.getPostId(), post);
//  }
//
//  @Override
//  public void delete(int postId) {
//    posts.remove(postId);
//  }
//
//}