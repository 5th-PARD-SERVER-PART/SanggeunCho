package com.pard.hw4.likes.Dto;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class LikeReqDto {
    private Long userId;
    private Long postingId;
}
