package com.sesac.angam.post.entity.set;

public enum PickupStatus {
    BEFORE_PICKUP("수거전"),
    PICKUPING("수거중"),
    COMPLETED("수거완료");

    private final String value;

    PickupStatus(String value) {
        this.value = value;
    }
}
