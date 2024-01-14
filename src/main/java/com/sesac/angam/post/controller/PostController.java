package com.sesac.angam.post.controller;

import com.sesac.angam.post.dto.req.PostCreateRequests;
import com.sesac.angam.post.dto.res.PostCreateResponse;
import com.sesac.angam.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/post")
    public ResponseEntity<PostCreateResponse> createSet(@RequestParam Long userId, @RequestBody PostCreateRequests requests) {
        return ResponseEntity.ok(postService.createPosts(userId, requests));
    }
}
