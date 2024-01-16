package com.sesac.angam.post.repository;

import com.sesac.angam.post.entity.post.Keyword;
import com.sesac.angam.post.entity.post.Post;
import com.sesac.angam.post.entity.post.PostKeyword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.security.Key;
import java.util.List;

public interface PostKeywordRepository extends JpaRepository<PostKeyword, Long> {

    @Query("SELECT k.keyword FROM Keyword k " +
            "JOIN PostKeyword pk " +
            "ON k.id = pk.keyword.id " +
            "WHERE pk.post = :post")
    List<String> findAllByPost(@Param("post") Post post);
}
