package org.example.ditest.service;

import org.example.ditest.dto.PostDTO;
import org.example.ditest.entity.Post;
import org.example.ditest.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public List<Post> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts;
    }

    @Transactional
    public Post addPost(Post post) {
        Post savedPost = postRepository.save(post);
        return savedPost;
    }

    @Transactional
    public void deletePost(int postId) {
        postRepository.deleteById(postId);
    }

    @Transactional
    public Post updatePost(PostDTO postDto) {// update 필드는 body 로 제한
        Post post = postRepository.findById(postDto.getPostId()).get();
        post.setBody(postDto.getBody());
        Post updatedPost = postRepository.save(post);
        return updatedPost;
    }


    public Post getPost(int postId) {

        return postRepository.findById(postId).get();
    }
}
