package com.pard.hw5.posts.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

public class PostsReqDto {
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor

    public static class PostsCreateRequest {
        private String title;
        private String content;
        private Timestamp createdAt;
    }
}
