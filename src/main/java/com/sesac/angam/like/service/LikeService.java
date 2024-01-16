package com.sesac.angam.like.service;

import com.sesac.angam.exception.BaseException;
import com.sesac.angam.like.dto.res.LikeCreateResponse;
import com.sesac.angam.like.dto.res.LikeDeleteResponse;
import com.sesac.angam.like.entity.Like;
import com.sesac.angam.post.entity.post.Post;
import com.sesac.angam.like.repository.LikeRepository;
import com.sesac.angam.user.entity.User;
import com.sesac.angam.util.PostUtil;
import com.sesac.angam.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.sesac.angam.exception.ExceptionCode.LIKE_NOT_FOUND;
import static com.sesac.angam.exception.ExceptionCode.POST_ALREADY_LIKED;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final UserUtil userUtil;
    private final PostUtil postUtil;
    private final LikeRepository likeRepository;

    @Transactional
    public LikeCreateResponse createLike(Long userId, Long postId) {
        User user = userUtil.getUser(userId);
        Post post = postUtil.getPost(postId);
        validateLikeExistence(user, post);

        Like like = likeRepository.save(new Like(user, post));

        return LikeCreateResponse.fromEntity(like);
    }

    @Transactional
    public LikeDeleteResponse changeLikeStatusDeleted(Long likeId) {
        Like like = getLike(likeId);
        like.changeLikeStatusDeleted();

        return LikeDeleteResponse.fromEntity(like);

    }

    private Like getLike(Long likeId) {
        return likeRepository.findById(likeId)
                .orElseThrow(() -> new BaseException(LIKE_NOT_FOUND));
    }

    private void validateLikeExistence(User user, Post post) {
        if(likeRepository.existsByUserAndPostAndIsDeletedIsFalse(user, post)) {
            throw new BaseException(POST_ALREADY_LIKED);
        }
    }
}
