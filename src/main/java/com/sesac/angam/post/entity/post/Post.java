package com.sesac.angam.post.entity.post;

import jakarta.persistence.*;

@Entity
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
}
