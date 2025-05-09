package com.pard.hw5.likes.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class LikesResDto {
    private String message;

    public LikesResDto(boolean liked) {
        this.message = liked ? "Liked" : "Unliked";
    }

    public String getMessage() { return message; }
}
