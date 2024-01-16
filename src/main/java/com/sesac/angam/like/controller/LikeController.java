package com.sesac.angam.like.controller;

import com.sesac.angam.like.dto.res.LikeCreateResponse;
import com.sesac.angam.like.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LikeController {
    private final LikeService likeService;
    @PostMapping("/post/{postId}/like/{userId}")
    public ResponseEntity<LikeCreateResponse> createLike(
            @PathVariable Long postId,
            @PathVariable Long userId) {
        return ResponseEntity.ok(likeService.createLike(userId, postId));
    }
}
