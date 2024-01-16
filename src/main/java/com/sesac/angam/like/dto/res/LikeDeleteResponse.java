package com.sesac.angam.like.dto.res;

import com.sesac.angam.like.entity.Like;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LikeDeleteResponse {
    private Long likeId;
    private Long userId;
    private Long postId;
    private boolean isDeleted;

    @Builder
    public LikeDeleteResponse(Long likeId, Long userId, Long postId, boolean isDeleted) {
        this.likeId = likeId;
        this.userId = userId;
        this.postId = postId;
        this.isDeleted = isDeleted;
    }

    public static LikeDeleteResponse fromEntity(Like like) {
        return LikeDeleteResponse.builder()
                .likeId(like.getId())
                .postId(like.getPost().getId())
                .userId(like.getUser().getId())
                .isDeleted(like.isDeleted())
                .build();
    }
}
