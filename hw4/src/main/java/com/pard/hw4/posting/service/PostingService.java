package com.pard.hw4.posting.service;

import com.pard.hw4.posting.dto.PostingReqDto;
import com.pard.hw4.posting.dto.PostingResDto;
import com.pard.hw4.posting.entity.Posting;
import com.pard.hw4.posting.repo.PostingRepo;
import com.pard.hw4.user.entity.User;
import com.pard.hw4.user.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class PostingService {
    private final UserRepo userRepo;
    private final PostingRepo postingRepo;

    public void createPosting(Long userId, PostingReqDto.PostingCreateRequest req){
        Optional<User> u = userRepo.findById(userId);
        User user = u.get();
        Posting posting = Posting.from(req.getContent(), req.getDate(), user);
        postingRepo.save(posting);
    }

    public PostingResDto.PostingReadResponse readPosting(Long postingId){
        Optional<Posting> p = postingRepo.findById(postingId);
        Posting posting = p.get();
        return new PostingResDto.PostingReadResponse(postingId, posting.getContent(), posting.getDate());
    }

    public List<PostingResDto.PostingReadResponse> findByUserId(Long userId){
        List<Posting> postings = postingRepo.findByUserId(userId);
        List<PostingResDto.PostingReadResponse> postingDtos = postings.stream().map(
                posting -> PostingResDto.PostingReadResponse.builder()
                        .postingId(posting.getId())
                        .content(posting.getContent())
                        .date(posting.getDate())
                        .build()).toList();

        return postingDtos;
    }

    @Transactional
    public void update(Long postingId, PostingReqDto.PostingCreateRequest postingDto){
        Posting posting = postingRepo.findById(postingId).get();
        posting.updateContent(postingDto.getContent());
        postingRepo.save(posting);
    }

    public void delete(Long postingId){
        postingRepo.deleteById(postingId);
    }
}
