package com.sesac.angam.like.repository;

import com.sesac.angam.like.entity.Like;
import com.sesac.angam.post.entity.post.Post;
import com.sesac.angam.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
    boolean existsByUserAndPost(User user, Post post);
}
