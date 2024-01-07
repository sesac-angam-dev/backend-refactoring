package com.sesac.angam.post.dto.res;

import lombok.Builder;

import java.util.List;

public class PostCreateResponse {
    private Long setId;
    private List<Long> postIdList;

    @Builder
    public PostCreateResponse(Long setId, List<Long> postIdList) {
        this.setId = setId;
        this.postIdList = postIdList;
    }
}
