package com.sesac.angam.post.repository;

import com.sesac.angam.post.entity.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
