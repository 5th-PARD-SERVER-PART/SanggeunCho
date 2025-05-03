package com.pard.hw4.posting.entity;

import com.pard.hw4.likes.Entity.Likes;
import com.pard.hw4.user.entity.User;
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

public class Posting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String content;
    @CreationTimestamp
    private Timestamp date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "posting")
    private List<Likes> likes = new ArrayList<>();

    public static Posting from(String content, Timestamp date, User user) {
        return new Posting(null, content, date, user, null);
    }

    public void updateContent(String content) { this.content = content; }
}
