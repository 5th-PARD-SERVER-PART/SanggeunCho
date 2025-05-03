package com.pard.hw4.likes.Controller;

import com.pard.hw4.likes.Dto.LikeResDto;
import com.pard.hw4.likes.Service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/like")

public class LikeController {
    private final LikeService likeService;

    @PostMapping("/toggle/{userId}/{postingId}")
    public ResponseEntity<LikeResDto> toggleLike(@PathVariable Long userId, @PathVariable Long postingId) {
        boolean liked = likeService.toggleLike(userId, postingId);
        return ResponseEntity.ok(new LikeResDto(liked));
    }
}
