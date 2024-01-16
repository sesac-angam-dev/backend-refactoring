package com.sesac.angam.like.dto.res;

import com.sesac.angam.like.entity.Like;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LikeCreateResponse {

    private Long likeId;

    private LikeCreateResponse(Long likeId) {
        this.likeId = likeId;
    }

    public static LikeCreateResponse fromEntity(Like like) {
        return new LikeCreateResponse(like.getId());
    }
}
