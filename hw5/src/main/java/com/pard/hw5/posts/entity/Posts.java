package com.pard.hw5.posts.entity;

import com.pard.hw5.likes.entity.Likes;
import com.pard.hw5.user.domain.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    @CreationTimestamp
    private Timestamp createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "posts")
    private List<Likes> likes = new ArrayList();

    public static Posts from (String title, String content, Timestamp createdAt, User user){
        return new Posts(null, title, content, createdAt, user, null);
    }

    public void updatePosts(String title, String content){
        this.title = title;
        this.content = content;
    }


}
