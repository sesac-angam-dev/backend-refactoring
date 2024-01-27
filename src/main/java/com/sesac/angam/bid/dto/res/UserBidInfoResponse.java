package com.sesac.angam.bid.dto.res;

import com.sesac.angam.bid.entity.EstimatedBid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserBidInfoResponse {
    private Long userId;
    private String name;
    private int bidAmount;

    @Builder
    private UserBidInfoResponse(Long userId, String name, int bidAmount) {
        this.userId = userId;
        this.name = name;
        this.bidAmount = bidAmount;
    }

    public static UserBidInfoResponse fromEntity(EstimatedBid estimatedBid) {
        return UserBidInfoResponse.builder()
                .userId(estimatedBid.getUser().getId())
                .name(estimatedBid.getUser().getName())
                .bidAmount(estimatedBid.getBidAmount())
                .build();
    }
}
