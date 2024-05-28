package org.example.ditest.service;

import org.example.ditest.repository.PostRepository;
import org.springframework.transaction.annotation.Transactional;
import org.example.ditest.entity.Post;
import org.example.ditest.dto.PostAPIDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional(readOnly=false)
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Transactional
    public List<Post> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts;
    }

    @Transactional
    public Post addPost(Post post) {
        Post postsave = postRepository.save(post);
        return postsave;
    }

    public void deletePost(int postId) {
        postRepository.deleteById(postId);
    }

    @Transactional
    public Post updatePost(PostAPIDTO postAPIDTO) {
        Post post = postRepository.findById(postAPIDTO.getPostId()).get();
        post.setLikes(postAPIDTO.getLikes());
        Post updatedPost = postRepository.save(post);
        return updatedPost;
    }

    public Post getPost(int postId) {
        return postRepository.findById(postId).get();
    }
}
