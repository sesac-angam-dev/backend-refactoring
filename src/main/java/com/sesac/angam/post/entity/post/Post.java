package com.sesac.angam.post.entity.post;

import com.sesac.angam.like.entity.Like;
import com.sesac.angam.post.entity.set.Set;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
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
//    @OneToMany(mappedBy = "post")
//    private List<PostKeyword> postKeywords = new ArrayList<>();
//    @OneToMany(mappedBy = "post")
//    private List<Like> likes = new ArrayList<>();
}
