package com.pard.hw4.likes.Service;

import com.pard.hw4.likes.Entity.Likes;
import com.pard.hw4.likes.Repo.LikeRepo;
import com.pard.hw4.posting.entity.Posting;
import com.pard.hw4.posting.repo.PostingRepo;
import com.pard.hw4.user.entity.User;
import com.pard.hw4.user.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor

public class LikeService {
    private final LikeRepo likeRepo;
    private final PostingRepo postingRepo;
    private final UserRepo userRepo;

    public boolean toggleLike(Long userId, Long postingId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        Posting posting = postingRepo.findById(postingId).orElseThrow(() -> new RuntimeException("Posting not found"));

        Optional<Likes> existingLike = likeRepo.findByUserAndPosting(user, posting);

        if (existingLike.isPresent()) {
            Likes like = existingLike.get();
            like.toggle();
            likeRepo.save(like);
            return like.isLiked();
        } else {
            Likes newLike = new Likes(user, posting, true);
            likeRepo.save(newLike);
            return true;
        }
    }
}