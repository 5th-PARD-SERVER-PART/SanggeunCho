package com.pard.hw5.likes.service;

import com.pard.hw5.likes.entity.Likes;
import com.pard.hw5.likes.repo.LikesRepo;
import com.pard.hw5.posts.entity.Posts;
import com.pard.hw5.posts.repo.PostsRepo;
import com.pard.hw5.posts.service.PostsService;
import com.pard.hw5.user.domain.User;
import com.pard.hw5.user.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor

public class LikesService {
    private final LikesRepo likesRepo;
    private final PostsRepo postsRepo;
    private final UserRepo userRepo;

    public boolean toggleLike(Long userId, Long postingId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        Posts posts = postsRepo.findById(postingId).orElseThrow(() -> new RuntimeException("Posting not found"));

        Optional<Likes> existingLike = likesRepo.findByUserAndPosts(user, posts);

        if (existingLike.isPresent()) {
            Likes like = existingLike.get();
            like.toggle();
            likesRepo.save(like);
            return like.isLiked();
        } else {
            Likes newLike = new Likes(user, posts, true);
            likesRepo.save(newLike);
            return true;
        }
    }
}
