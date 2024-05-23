package org.example.ditest.service;

import org.example.ditest.model.Post;
import org.example.ditest.model.PostDTO;
import org.example.ditest.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts;
    }

    public Post addPost(Post post) {
        int postId = postRepository.insert(post);
        return postRepository.findById(postId);
    }

    public void deletePost(int postId) {
        postRepository.delete(postId);
    }

    public Post updatePost(PostDTO postDTO) {
        Post post = postRepository.findById(postDTO.getPostId());
        post.setLikes(postDTO.getLikes());
        postRepository.update(post);
        return post;
    }

    public Post getPost(int postId) {
        return postRepository.findById(postId);
    }
}
