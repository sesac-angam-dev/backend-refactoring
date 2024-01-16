package com.sesac.angam.post.repository;

import com.sesac.angam.post.entity.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {

    @Query("select p from Post p " +
            "where p.set.estimateStatus='ESTIMATING' or p.set.estimateStatus='BEFORE_ESTIMATE'")
    List<Post> findAllPostsBeforeEstimateCompleted();
}
