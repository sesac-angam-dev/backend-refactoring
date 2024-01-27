package com.sesac.angam.bid.repository;

import com.sesac.angam.bid.entity.EstimatedBid;
import com.sesac.angam.post.entity.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstimatedBidRepository extends JpaRepository<EstimatedBid, Long> {

    List<EstimatedBid> findAllByPost(Post post);
}
