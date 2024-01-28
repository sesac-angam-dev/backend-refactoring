package com.sesac.angam.util;

import com.sesac.angam.bid.entity.EstimatedBid;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Calculator {
    public double calculateMeanBidAmount(List<EstimatedBid> estimatedBids) {
        int num = estimatedBids.size();
        int bidSum = estimatedBids.stream()
                .mapToInt(bid -> bid.getBidAmount())
                .sum();

        return (double) bidSum / num;
    }
}
