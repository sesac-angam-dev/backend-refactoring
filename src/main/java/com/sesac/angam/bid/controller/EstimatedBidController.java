package com.sesac.angam.bid.controller;

import com.sesac.angam.bid.dto.req.BidCreateRequest;
import com.sesac.angam.bid.dto.res.BidCreateResponse;
import com.sesac.angam.bid.service.EstimatedBidService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class EstimatedBidController {
    private final EstimatedBidService estimatedBidService;

    @PostMapping("/user/{userId}/estimated-bid")
    public ResponseEntity<BidCreateResponse> createBid(@PathVariable Long userId, @Validated @RequestBody BidCreateRequest request) {
        return ResponseEntity.ok(estimatedBidService.createBid(userId, request));
    }
}
