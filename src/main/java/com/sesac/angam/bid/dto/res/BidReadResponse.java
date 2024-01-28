package com.sesac.angam.bid.dto.res;

import com.sesac.angam.bid.entity.EstimatedBid;
import com.sesac.angam.post.entity.post.Post;
import com.sesac.angam.util.Calculator;
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

    public static BidReadResponse fromEntity(Post post, List<EstimatedBid> estimatedBids, Calculator calculator) {
        return BidReadResponse.builder()
                .postId(post.getId())
                .title(post.getTitle())
                .brand(post.getBrand())
                .meanBidAmount(calculator.calculateMeanBidAmount(estimatedBids))
                .userInfoResponses(getUserBidInfoResponses(estimatedBids))
                .build();
    }

    private static List<UserBidInfoResponse> getUserBidInfoResponses(List<EstimatedBid> estimatedBids) {
        return estimatedBids.stream()
                .map(estimatedBid -> UserBidInfoResponse.fromEntity(estimatedBid))
                .toList();
    }
}
