package com.sesac.angam.like.entity;

import com.sesac.angam.post.entity.post.Post;
import com.sesac.angam.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "likes")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="users")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="posts")
    private Post post;

    private boolean isDeleted=Boolean.FALSE;

    public Like(User user, Post post) {
        this.user = user;
        this.post = post;
    }

    public void changeLikeStatusDeleted() {
        this.isDeleted = true;
    }
}
