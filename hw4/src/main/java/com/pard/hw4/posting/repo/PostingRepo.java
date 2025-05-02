package com.pard.hw4.posting.repo;

import com.pard.hw4.posting.entity.Posting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostingRepo extends JpaRepository<Posting, Long> {
    List<Posting> findByUserId(Long userId);
}
