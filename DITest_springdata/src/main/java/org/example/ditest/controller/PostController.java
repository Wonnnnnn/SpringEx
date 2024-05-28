package org.example.ditest.controller;

import org.example.ditest.entity.Post;
import org.example.ditest.dto.PostAPIDTO;
import org.example.ditest.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    @Autowired
    private PostService postService;

//    public PostController(PostService postService) {
//        this.postService = postService;
//    }

    @GetMapping("/posts")
    public List<Post> viewAllPosts() {
        List<Post> allPosts = postService.getAllPosts();
        return allPosts;
    }

    @PostMapping("/posts")
    public Post addPost(@RequestBody Post post) {
        return postService.addPost(post);
    }

    @PostMapping("/posts/{postid}")
    public Post updatePost(@PathVariable int postid, @RequestBody PostAPIDTO postAPIDTO) {
        postAPIDTO.setPostId(postid);
        Post post = postService.updatePost(postAPIDTO);
        return post;
    }

    @DeleteMapping("/posts/{postId}")
    public void deletePost(@PathVariable int postId) {
        postService.deletePost(postId);
    }

    @GetMapping("/posts/{postId}")
    public Post viewPost(@PathVariable int postId) {
        Post post = postService.getPost(postId);
        return post;
    }



}
