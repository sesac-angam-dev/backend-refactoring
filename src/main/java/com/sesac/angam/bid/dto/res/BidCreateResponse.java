package com.sesac.angam.bid.dto.res;

import com.sesac.angam.bid.entity.EstimatedBid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BidCreateResponse {
    private Long bidId;
    private int bidAmount;

    @Builder
    private BidCreateResponse(Long bidId, int bidAmount) {
        this.bidId = bidId;
        this.bidAmount = bidAmount;
    }

    public static BidCreateResponse fromEntity(EstimatedBid estimatedBid) {
        return BidCreateResponse.builder()
                .bidId(estimatedBid.getId())
                .bidAmount(estimatedBid.getBidAmount())
                .build();
    }
}
