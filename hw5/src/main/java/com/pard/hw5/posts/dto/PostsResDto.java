package com.pard.hw5.posts.dto;

import com.pard.hw5.posts.entity.Posts;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class PostsResDto {
    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor

    public static class PostsReadResponse {
        private Long postsId;
        private String title;
        private String content;
        private Timestamp createdAt;

        public static List<PostsReadResponse> postsToDto(List<Posts> posts){
            List<PostsReadResponse> ret = new ArrayList<>();
            for(Posts post : posts){
                PostsReadResponse p = new PostsReadResponse(post.getId(), post.getTitle(), post.getContent(), post.getCreatedAt());
                ret.add(p);
            }
            return ret;
        }
    }
}
