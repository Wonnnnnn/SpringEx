package org.example.ditest.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.ditest.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JPAPostRepository implements PostRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Post> findAll() {
        List<Post> result = em.createQuery("SELECT p FROM Post p", Post.class).getResultList();
        return result;
    }

    @Override
    public Optional<Post> findById(int postId) {
        return Optional.ofNullable(em.find(Post.class, postId));
    }

    @Override
    public void deleteById(int postId) {
        Post findpost = em.find(Post.class, postId);
        if(findpost != null) {
            em.remove(findpost);
        }
    }

    @Override
    public Post save(Post post) {
        em.persist(post);
        return em.find(Post.class, post);
    }
}
