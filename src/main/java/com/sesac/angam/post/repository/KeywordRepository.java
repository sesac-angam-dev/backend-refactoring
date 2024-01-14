package com.sesac.angam.post.repository;

import com.sesac.angam.post.entity.post.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface KeywordRepository extends JpaRepository<Keyword, Long> {
    Optional<Keyword> findByKeyword(String keyword);

    List<Keyword> findByKeywordIn(List<String> keywords);
}
