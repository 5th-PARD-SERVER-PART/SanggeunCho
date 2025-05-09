package com.pard.hw5.likes.entity;

import com.pard.hw5.posts.entity.Posts;
import com.pard.hw5.user.domain.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Posts posts;

    private boolean liked;

    public Likes(User user, Posts posts, boolean liked) {
        this.user = user;
        this.posts = posts;
        this.liked = liked;
    }

    public void toggle(){
        this.liked = !this.liked;
    }
}