package org.example.ditest.repository;

import org.example.ditest.entity.Post;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class PostRepositoryImplTest {

    static Map<Integer, Post> posts = new HashMap<>();
    static int sequence;
    @BeforeEach
    void initAll() {
        System.out.println("before each");
    }

    @BeforeAll
    static void init() {
        sequence = 0;
    }


    @Test
    @DisplayName("findidtest")
    void findById() {
    }

    @Test
    @DisplayName("insert test")
    void insert() {
        sequence++;
        Post post = new Post(sequence, "title1", "body1", 0);
        posts.put(sequence, post);
        org.assertj.core.api.Assertions.assertThat(posts.get(sequence)).isEqualTo("title1");
//        Assertions.assertEquals(sequence, posts.get(sequence).getPostId());
//        if(posts.get(sequence).getPostId() == sequence) {
//            System.out.println("success");
//        }

    }

    @AfterEach
    void tearDown() {
        System.out.println("after each");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("after all");
    }

}