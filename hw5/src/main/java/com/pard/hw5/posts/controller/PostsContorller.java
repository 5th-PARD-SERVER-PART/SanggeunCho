package com.pard.hw5.posts.controller;

import com.pard.hw5.posts.dto.PostsReqDto;
import com.pard.hw5.posts.dto.PostsResDto;
import com.pard.hw5.posts.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")

public class PostsContorller {
    private final PostsService postsService;

    @PostMapping("/{userId}")
    public void CreatePosts(@PathVariable Long userId, @RequestBody PostsReqDto.PostsCreateRequest req){
        postsService.createPosts(userId, req);
    }

    @GetMapping("/{userId}")
    public List<PostsResDto.PostsReadResponse> readByUserId(@PathVariable Long userId){
        return postsService.findByUserId(userId);
    }

    @PatchMapping("/{postsId}")
    public void update(@PathVariable Long postsId, @RequestBody PostsReqDto.PostsCreateRequest postsDto){
        postsService.update(postsId, postsDto);
    }

    @DeleteMapping("/{postsId}")
    public void delete(@PathVariable Long postsId){
        postsService.delete(postsId);
    }
}
