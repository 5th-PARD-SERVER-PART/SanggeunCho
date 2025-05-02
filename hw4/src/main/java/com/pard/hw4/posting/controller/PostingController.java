package com.pard.hw4.posting.controller;

import com.pard.hw4.posting.dto.PostingReqDto;
import com.pard.hw4.posting.dto.PostingResDto;
import com.pard.hw4.posting.service.PostingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posting")

public class PostingController {
    private final PostingService postingService;

    @PostMapping("/{userId}")
    public void CreatePosting(@PathVariable Long userId, @RequestBody PostingReqDto.PostingCreateRequest req){
        postingService.createPosting(userId, req);
    }

    @GetMapping("/{userId}")
    public List<PostingResDto.PostingReadResponse> readByUserId(@PathVariable Long userId){
        return postingService.findByUserId(userId);
    }

    @PatchMapping("/{postingId}")
    public void update(@PathVariable Long postingId, @RequestBody PostingReqDto.PostingCreateRequest postingDto){
        postingService.update(postingId, postingDto);
    }

    @DeleteMapping("/{postingId}")
    public void delete(@PathVariable Long postingId){
        postingService.delete(postingId);
    }

}
