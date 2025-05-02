package com.pard.hw4.posting.dto;

import com.pard.hw4.posting.entity.Posting;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class PostingResDto {
    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PostingReadResponse {
        private Long postingId;
        private String content;
        private Timestamp date;

        public static List<PostingReadResponse> postingToDto(List<Posting> postings){
            List<PostingReadResponse> ret = new ArrayList<>();
            for(Posting posting : postings){
                PostingReadResponse p =
                        new PostingReadResponse(posting.getId(), posting.getContent(), posting.getDate());
                ret.add(p);
            }
            return ret;
        }
    }
}
