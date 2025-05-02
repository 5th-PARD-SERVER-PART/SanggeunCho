package com.pard.hw4.user.dto;

import com.pard.hw4.posting.dto.PostingResDto;
import com.pard.hw4.posting.entity.Posting;
import com.pard.hw4.user.entity.User;
import com.fasterxml.jackson.annotation.JsonInclude;
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
        private List<Posting> postings;

        public static UserReadRequest from(User u){
            return new UserReadRequest(u.getId(), u.getName(), u.getPosting());
        }
    }

    @Getter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserCreateRequest{
        private String name;
    }
}
