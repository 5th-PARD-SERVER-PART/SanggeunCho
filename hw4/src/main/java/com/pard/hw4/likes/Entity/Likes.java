package com.pard.hw4.likes.Entity;

import com.pard.hw4.posting.entity.Posting;
import com.pard.hw4.user.entity.User;
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
    private Posting posting;

    private boolean liked;

    public Likes(User user, Posting posting, boolean liked) {
        this.user = user;
        this.posting = posting;
        this.liked = liked;
    }

    public void toggle(){
        this.liked = !this.liked;
    }
}
