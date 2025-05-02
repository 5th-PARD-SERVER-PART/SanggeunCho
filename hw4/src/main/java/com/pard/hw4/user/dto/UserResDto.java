package com.pard.hw4.user.dto;

import com.pard.hw4.posting.dto.PostingResDto;
import com.pard.hw4.user.entity.User;
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
        private List<PostingResDto.PostingReadResponse> postings;

        public static ReadUser from(User user){
            return new ReadUser(user.getName(),
                    PostingResDto.PostingReadResponse.postingToDto(
                            user.getPosting()));
        }
    }
}
