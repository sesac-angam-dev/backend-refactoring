package com.sesac.angam.post.dto.req;

import lombok.Getter;

import java.util.List;

@Getter
public class PostCreateRequests {
    private final List<PostCreateRequest> postCreateRequests;

    public PostCreateRequests(List<PostCreateRequest> postCreateRequests) {
        this.postCreateRequests = postCreateRequests;
    }
}
