package com.sesac.angam.post.entity.set;

import com.sesac.angam.user.entity.User;
import jakarta.persistence.*;

@Entity
@Table(name = "sets")
public class Set {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "set_id")
    private Long id;
    private boolean isDeleted;
    @Enumerated(EnumType.STRING)
    private EstimateStatus estimateStatus;
    @Enumerated(EnumType.STRING)
    private PickupStatus pickUpStatus;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="users")
    private User user;
}
