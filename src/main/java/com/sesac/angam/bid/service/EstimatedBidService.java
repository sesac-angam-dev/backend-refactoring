package com.sesac.angam.bid.service;

import com.sesac.angam.bid.dto.req.BidCreateRequest;
import com.sesac.angam.bid.dto.res.BidCreateResponse;
import com.sesac.angam.bid.entity.EstimatedBid;
import com.sesac.angam.bid.repository.EstimatedBidRepository;
import com.sesac.angam.post.entity.post.Post;
import com.sesac.angam.post.repository.PostRepository;
import com.sesac.angam.user.entity.User;
import com.sesac.angam.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EstimatedBidService {

    private final EstimatedBidRepository estimatedBidRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public BidCreateResponse createBid(Long userId, BidCreateRequest request) {
        User user = userRepository.getById(userId);
        Post post = postRepository.getById(request.getPostId());

        EstimatedBid estimatedBid = estimatedBidRepository.save(request.toEntity(user, post));

        return BidCreateResponse.fromEntity(estimatedBid);
    }

}
