package org.example.ditest.service;

import org.assertj.core.api.Assertions;
import org.example.ditest.entity.Post;
import org.example.ditest.repository.PostRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PostServiceTest {
    private PostRepository postRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void 게시판_글작성_테스트() {

        //given
        Post post = new Post(null, "test1","body1", 0,"");
//        //when
//        Post post1 = postRepository.insert(post);
//        //then
//        Assertions.assertThat(newid).isEqualTo(1);

    }
}