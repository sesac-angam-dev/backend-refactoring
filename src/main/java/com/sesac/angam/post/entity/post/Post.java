package com.sesac.angam.post.entity.post;

import com.sesac.angam.post.entity.set.Set;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;
    private String title;
    private String brand;
    private int purchasePrice;
    private String history;
    private boolean pickupRequested;
    private boolean isDeleted;
    @Enumerated(EnumType.STRING)
    private Size size;
    @Enumerated(EnumType.STRING)
    private WearNum wearNum;
    @Enumerated(EnumType.STRING)
    private SaleStatus saleStatus;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="set_id")
    private Set set;
}
