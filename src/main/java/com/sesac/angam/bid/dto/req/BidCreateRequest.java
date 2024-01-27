package com.sesac.angam.bid.dto.req;

import com.sesac.angam.bid.entity.EstimatedBid;
import com.sesac.angam.post.entity.post.Post;
import com.sesac.angam.user.entity.User;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BidCreateRequest {
    private Long postId;

    @Positive(message = "양수를 입력해주세요.")
    private int bidAmount;

    private BidCreateRequest(Long postId, int bidAmount) {
        this.postId = postId;
        this.bidAmount = bidAmount;
    }

    public EstimatedBid toEntity(User user, Post post) {
        return EstimatedBid.builder()
                .post(post)
                .bidAmount(this.bidAmount)
                .user(user)
                .isDeleted(false)
                .build();
    }
}
