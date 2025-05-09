package com.pard.hw5.likes.controller;

import com.pard.hw5.likes.dto.LikesResDto;
import com.pard.hw5.likes.service.LikesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/like")

public class LikesController {
    private final LikesService likesService;

    @PostMapping("/toggle/{userId}/{postsId}")
    public ResponseEntity<LikesResDto> toggleLike(@PathVariable Long userId, @PathVariable Long postsId) {
        boolean liked = likesService.toggleLike(userId, postsId);
        return ResponseEntity.ok(new LikesResDto(liked));
    }
}
