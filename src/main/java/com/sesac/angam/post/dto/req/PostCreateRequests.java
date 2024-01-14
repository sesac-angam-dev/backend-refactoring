package com.sesac.angam.post.dto.req;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class PostCreateRequests {
    private List<PostCreateRequest> postCreateRequests;

    public PostCreateRequests(List<PostCreateRequest> postCreateRequests) {
        this.postCreateRequests = postCreateRequests;
    }
}
