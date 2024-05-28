package org.example.spring_jpa.controller;

import org.example.spring_jpa.entity.Post;
import org.example.spring_jpa.dto.PostDTO;
import org.example.spring_jpa.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {
  private final PostService postService;

  @Autowired
  public PostController(PostService postService) {
    this.postService = postService;
  }

  @GetMapping
  public String getAllPosts(Model model){
    List<Post> allPosts = postService.getAllPosts();
    model.addAttribute("posts", allPosts);
    return "post/postList";
  }

  @GetMapping("/add")
  public String addPost(){
    return "post/postForm";
  }

  @PostMapping("/add")
  public String addPost(@ModelAttribute Post post){
    postService.setPost(post);
    return "redirect:/posts";
  }

  @GetMapping("/postInfo/{postId}")
  public String getPostInfo(@PathVariable int postId,
                            Model model){
    Post post = postService.getPostById(postId);
    model.addAttribute("post", post);
    return "post/postInfo";
  }

  @GetMapping("/update/{postId}")
  public String updatePost(@PathVariable int postId,
                           Model model){
    Post post = postService.getPostById(postId);
    model.addAttribute("post", post);
    return "post/postUpdateForm";
  }

  @PostMapping("/update/{postId}")
  public String updatePost(@PathVariable int postId,
                           @ModelAttribute PostDTO postDto){
    System.out.println("updatePost 호출됨");
    postService.updatePost(postId, postDto);
    return "redirect:/posts";
  }

  @GetMapping("/delete/{postId}")
  public String deletePost(@PathVariable int postId){
    postService.removePost(postId);
    return "redirect:/posts";
  }
}