package com.sesac.angam.post.repository;

import com.sesac.angam.exception.BaseException;
import com.sesac.angam.post.entity.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import static com.sesac.angam.exception.ExceptionCode.POST_NOT_FOUND;

public interface PostRepository extends JpaRepository<Post,Long> {

    @Query("select p from Post p " +
            "where p.set.estimateStatus='ESTIMATING' or p.set.estimateStatus='BEFORE_ESTIMATE'")
    List<Post> findAllPostsBeforeEstimateCompleted();

    @Query("select p from Post p " +
            "join p.set s " +
            "where s.user.id=:userId and s.estimateStatus!='COMPLETED'")
    List<Post> findUserPostsBeforeEstimateCompleted(@Param("userId")Long userId);

    default Post getById(Long id) {
        return this.findById(id)
                .orElseThrow(() -> new BaseException(POST_NOT_FOUND));
    }
}
