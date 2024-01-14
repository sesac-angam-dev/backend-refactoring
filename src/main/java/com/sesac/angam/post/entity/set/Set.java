package com.sesac.angam.post.entity.set;

import com.sesac.angam.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
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

    public static Set from(User user) {
        return Set.builder()
                .user(user)
                .estimateStatus(EstimateStatus.BEFORE_ESTIMATE)
                .pickUpStatus(PickupStatus.BEFORE_PICKUP)
                .isDeleted(false)
                .build();
    }
}
