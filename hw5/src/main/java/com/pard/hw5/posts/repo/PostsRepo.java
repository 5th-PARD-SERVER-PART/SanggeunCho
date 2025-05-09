package com.pard.hw5.posts.repo;

import com.pard.hw5.posts.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostsRepo extends JpaRepository<Posts, Long> {
    List<Posts> findByUserId(Long userId);
}
