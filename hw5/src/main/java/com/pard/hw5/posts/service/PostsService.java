package com.pard.hw5.posts.service;

import com.pard.hw5.posts.dto.PostsReqDto;
import com.pard.hw5.posts.dto.PostsResDto;
import com.pard.hw5.posts.entity.Posts;
import com.pard.hw5.posts.repo.PostsRepo;
import com.pard.hw5.user.domain.User;
import com.pard.hw5.user.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class PostsService {
    private final UserRepo userRepo;
    private final PostsRepo postsRepo;

    public void createPosts(Long userId, PostsReqDto.PostsCreateRequest req){
        Optional<User> u = userRepo.findById(userId);
        User user = u.get();
        Posts posts = Posts.from(req.getTitle(), req.getContent(), req.getCreatedAt(), user);
        postsRepo.save(posts);
    }

    public PostsResDto.PostsReadResponse readPosts(Long postsId){
        Optional<Posts> p = postsRepo.findById(postsId);
        Posts posts = p.get();
        return new PostsResDto.PostsReadResponse(postsId, posts.getTitle(), posts.getContent(), posts.getCreatedAt());
    }

    public List<PostsResDto.PostsReadResponse> findByUserId(Long userId){
        List<Posts> posts = postsRepo.findByUserId(userId);
        List<PostsResDto.PostsReadResponse> postsDtos = posts.stream().map(
                post -> PostsResDto.PostsReadResponse.builder()
                        .postsId(post.getId())
                        .title(post.getTitle())
                        .content(post.getContent())
                        .createdAt(post.getCreatedAt())
                        .build()).toList();

        return postsDtos;
    }

    @Transactional
    public void update(Long postsId, PostsReqDto.PostsCreateRequest postsDto){
        Posts posts = postsRepo.findById(postsId).get();
        posts.updatePosts(postsDto.getTitle(), postsDto.getContent());
        postsRepo.save(posts);
    }

    public void delete(Long postsId){
        postsRepo.deleteById(postsId);
    }
}
