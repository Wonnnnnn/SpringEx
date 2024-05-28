package org.example.ditest.controller;


import org.example.ditest.dto.PostDTO;
import org.example.ditest.entity.Post;
import org.example.ditest.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/")
public class PostController {
    @Autowired
    private PostService postService;

//    @Autowired
//    public PostController(PostService postService) {
//        this.postService = postService;
//    }

    @GetMapping("posts")
    //@ResponseBody
    public String viewAllPosts(Model model) {
        List<Post> allPosts = postService.getAllPosts();
        log.info("All posts : {}", allPosts);
        model.addAttribute("allPosts", allPosts);
        return "post/postView";
    }

    @GetMapping("/posts/{postId}")
    public Post viewPost(@PathVariable int postId) {
        Post post = postService.getPost(postId);
        return post;
    }

    @GetMapping("/addPosts")
    public String addPost(Model model) {
        Post post = new Post();
        model.addAttribute("post", post);
        return "post/postAdd";
    }

    @PostMapping("/addPosts")
    public String addPostProcess(@ModelAttribute Post post) {
        postService.addPost(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/update/{postId}")
    public String updatePost(@PathVariable int postId, Model model) {
        Post post1 = postService.getPost(postId);
        model.addAttribute("post", post1);
        return "post/postUpdate";
    }

    @PostMapping("/posts/update/{postId}")
    public String updatePost(@PathVariable int postId, @ModelAttribute PostDTO postDto) {
        postDto.setPostId(postId);
        postService.updatePost(postDto);
        return "redirect:/posts";
    }

    @GetMapping("/posts/delete/{postId}")
    public String deletePost(@PathVariable int postId) {
        log.info("Delete post : {}", postId);
        postService.deletePost(postId);
        return "redirect:/posts";
    }
}

