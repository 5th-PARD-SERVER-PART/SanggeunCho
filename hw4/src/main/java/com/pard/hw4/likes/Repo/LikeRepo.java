package com.pard.hw4.likes.Repo;

import com.pard.hw4.likes.Entity.Likes;
import com.pard.hw4.posting.entity.Posting;
import com.pard.hw4.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeRepo extends JpaRepository<Likes, Long> {
    Optional<Likes> findByUserAndPosting(User user, Posting posting);
}
