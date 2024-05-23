package org.example.ditest.repository;

import org.example.ditest.model.Post;

import java.util.*;

public class PostRepositoryImpl implements PostRepository{
    private static int sequence;
    private static Map<Integer, Post> posts = new HashMap<>();
    @Override
    public List<Post> findAll() {
        return new ArrayList<>(posts.values());
    }

    @Override
    public Post findById(int postId) {
        return posts.get(postId);
    }

    @Override
    public void delete(int postId) {
        posts.remove(postId);
    }

    @Override
    public void update(Post post) { // update 는 likes 로 제한
        posts.put(post.getPostId(),post);
    }

    @Override
    public int insert(Post post) {
        sequence++;
        post.setPostId(sequence);
        posts.put(sequence,post);
        return sequence;
    }
}
