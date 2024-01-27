package com.sesac.angam.bid.dto.res;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class BidReadResponses {
    private List<BidReadResponse> bidReadResponses;

    public BidReadResponses(List<BidReadResponse> bidReadResponses) {
        this.bidReadResponses = bidReadResponses;
    }
}
