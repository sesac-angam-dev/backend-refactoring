package com.sesac.angam.bid.service;

import com.sesac.angam.bid.dto.req.BidCreateRequest;
import com.sesac.angam.bid.dto.res.BidCreateResponse;
import com.sesac.angam.bid.dto.res.BidReadResponse;
import com.sesac.angam.bid.dto.res.BidReadResponses;
import com.sesac.angam.bid.dto.res.UserBidInfoResponse;
import com.sesac.angam.bid.entity.EstimatedBid;
import com.sesac.angam.bid.repository.EstimatedBidRepository;
import com.sesac.angam.post.entity.post.Post;
import com.sesac.angam.post.repository.PostRepository;
import com.sesac.angam.user.entity.User;
import com.sesac.angam.user.repository.UserRepository;
import com.sesac.angam.util.Calculator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EstimatedBidService {

    private final EstimatedBidRepository estimatedBidRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final Calculator calculator;

    @Transactional
    public BidCreateResponse createBid(Long userId, BidCreateRequest request) {
        User user = userRepository.getById(userId);
        Post post = postRepository.getById(request.getPostId());

        EstimatedBid estimatedBid = estimatedBidRepository.save(request.toEntity(user, post));

        return BidCreateResponse.fromEntity(estimatedBid);
    }

    @Transactional(readOnly = true)
    public BidReadResponses getBidResults(Long userId) {
        List<Post> posts = postRepository.findUserPostsBeforeEstimateCompleted(userId);

        List<BidReadResponse> bidReadResponses = posts.stream()
                .map(post -> createBidResults(post))
                .collect(Collectors.toList());

        return new BidReadResponses(bidReadResponses);
    }

    private BidReadResponse createBidResults(Post post) {
        List<EstimatedBid> estimatedBids = estimatedBidRepository.findAllByPost(post);

        //입찰정보
        List<UserBidInfoResponse> userBidInfoResponses = getUserBidInfoResponses(estimatedBids);
        //평균입찰가
        double meanBidAmount = calculator.calculateMeanBidAmount(estimatedBids);

        return BidReadResponse.fromEntity(post, meanBidAmount, userBidInfoResponses);
    }

    private List<UserBidInfoResponse> getUserBidInfoResponses(List<EstimatedBid> estimatedBids) {
        return estimatedBids.stream()
                .map(estimatedBid -> UserBidInfoResponse.fromEntity(estimatedBid))
                .toList();
    }
}