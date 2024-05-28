package org.example.spring_jpa.service;

import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.example.spring_jpa.dto.PostDTO;
import org.example.spring_jpa.entity.Post;
import org.example.spring_jpa.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@Transactional(readOnly = true)
public class PostService {
  @Autowired
  private PostRepository postRepository;

  public PostService(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  public List<Post> getAllPosts() {
    return postRepository.findAll();
  }

  public Post getPostById(int postId){
    return postRepository.findById(postId).get();
  }

  @Transactional
  public Post setPost(Post post) {
    Post savedPost = postRepository.save(post);
    return savedPost;
  }

  @Transactional
  public Post updatePost(int postId, PostDTO postDto) {
    Post orgPost = postRepository.findById(postId).get();
    orgPost.setLikes(postDto.getLikes());
    Post updatedPost = postRepository.save(orgPost);
    return updatedPost;
  }

  @Transactional
  public void removePost(int postId){
    postRepository.deleteById(postId);
  }
}