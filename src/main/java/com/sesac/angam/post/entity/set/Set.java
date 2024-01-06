package com.sesac.angam.post.entity.set;

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
}
