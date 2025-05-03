package com.pard.hw4.likes.Dto;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class LikeResDto {
    private String message;

    public LikeResDto(boolean liked){
        this.message = liked ? "Liked" : "Unliked";
    }

    public String getMessage(){
        return message;
    }
}
