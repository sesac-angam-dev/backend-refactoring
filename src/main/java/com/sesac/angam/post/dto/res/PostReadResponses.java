package com.sesac.angam.post.dto.res;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class PostReadResponses {
    private List<PostReadResponse> postReadResponses;

    public PostReadResponses(List<PostReadResponse> postReadResponses) {
        this.postReadResponses = postReadResponses;
    }
}
