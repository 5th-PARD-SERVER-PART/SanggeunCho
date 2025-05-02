package com.pard.hw4.posting.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

public class PostingReqDto {
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PostingCreateRequest {
        private String content;
        private Timestamp date;
    }
}
