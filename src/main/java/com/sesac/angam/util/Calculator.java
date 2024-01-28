package com.sesac.angam.util;

import com.sesac.angam.bid.entity.EstimatedBid;

import java.util.List;

public class Calculator {
    public double calculateMeanBidAmount(List<EstimatedBid> estimatedBids) {
        int num = estimatedBids.size();
        int bidSum = estimatedBids.stream()
                .mapToInt(bid -> bid.getBidAmount())
                .sum();

        return (double) bidSum / num;
    }
}
