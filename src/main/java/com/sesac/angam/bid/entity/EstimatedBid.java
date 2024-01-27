package com.sesac.angam.bid.entity;

import com.sesac.angam.post.entity.post.Post;
import com.sesac.angam.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class EstimatedBid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "estimated_bid_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="users")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="posts")
    private Post post;

    private int bidAmount;

    private boolean isDeleted=Boolean.FALSE;
}
