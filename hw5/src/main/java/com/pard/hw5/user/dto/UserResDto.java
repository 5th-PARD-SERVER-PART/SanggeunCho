package com.pard.hw5.user.dto;

import com.pard.hw5.posts.dto.PostsResDto;
import com.pard.hw5.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class UserResDto {
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor

    public static class ReadUser{
        private String name;
        private String email;
        private List<PostsResDto.PostsReadResponse> posts;

        public static ReadUser from(User user){
            return new ReadUser(user.getName(), user.getEmail(),
                    PostsResDto.PostsReadResponse.postsToDto(
                    user.getPosts()));
        }
    }
}
