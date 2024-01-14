package com.sesac.angam.post.dto.res;

import com.sesac.angam.post.entity.post.Post;
import com.sesac.angam.post.entity.set.Set;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class PostCreateResponse {
    private Long setId;
    private List<Long> postIdList;

    @Builder
    private PostCreateResponse(Long setId, List<Long> postIdList) {
        this.setId = setId;
        this.postIdList = postIdList;
    }

    public static PostCreateResponse fromEntity(Set set, List<Post> posts) {
        return PostCreateResponse.builder()
                .setId(set.getId())
                .postIdList(getPostIdList(posts))
                .build();
    }

    private static List<Long> getPostIdList(List<Post> posts) {
        //TODO 왜 DB조회를 하지 않는가 ?
        return posts.stream()
                .map(post -> post.getId())
                .collect(Collectors.toList());
    }
}
