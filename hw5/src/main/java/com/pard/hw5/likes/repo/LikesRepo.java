package com.pard.hw5.likes.repo;

import com.pard.hw5.likes.entity.Likes;
import com.pard.hw5.posts.entity.Posts;
import com.pard.hw5.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikesRepo extends JpaRepository<Likes, Long> {
    Optional<Likes> findByUserAndPosts(User user, Posts posts);
}
