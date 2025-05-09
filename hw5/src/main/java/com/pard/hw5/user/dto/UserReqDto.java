package com.pard.hw5.user.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pard.hw5.posts.entity.Posts;
import com.pard.hw5.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class UserReqDto {
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor

    public static class UserReadRequest {
        private Long id;
        private String name;
        private String email;
        private List<Posts> posts;

        public static UserReadRequest from (User u){
            return new UserReadRequest(u.getId(), u.getName(), u.getEmail(), u.getPosts());
        }
    }
}
