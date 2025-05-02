package com.pard.hw4.posting.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pard.hw4.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

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
    @JsonIgnore
    private User user;

    public static Posting from(String content, Timestamp date, User user) {
        return new Posting(null, content, date, user);
    }

    public void updateContent(String content) { this.content = content; }
}
