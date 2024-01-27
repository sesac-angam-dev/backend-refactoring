package com.sesac.angam.bid.dto.res;

import com.sesac.angam.post.entity.post.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class BidReadResponse {
    private Long postId;
    private String title;
    private String brand;
    private double meanBidAmount;
    private List<UserBidInfoResponse> userBidInfoResponses;

    @Builder
    private BidReadResponse(Long postId, String title, String brand, Double meanBidAmount, List<UserBidInfoResponse> userInfoResponses) {
        this.postId = postId;
        this.title = title;
        this.brand = brand;
        this.meanBidAmount = meanBidAmount;
        this.userBidInfoResponses = userInfoResponses;
    }

    public static BidReadResponse fromEntity(Post post, Double meanBidAmount, List<UserBidInfoResponse> userInfoResponses) {
        return BidReadResponse.builder()
                .postId(post.getId())
                .title(post.getTitle())
                .brand(post.getBrand())
                .meanBidAmount(meanBidAmount)
                .userInfoResponses(userInfoResponses)
                .build();
    }
}
