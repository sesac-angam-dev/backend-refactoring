package com.sesac.angam.post.entity.set;

public enum EstimateStatus {
    BEFORE_ESTIMATE("심사전"),
    ESTIMATING("심사중"),
    COMPLETED("심사완료");
    private final String value;
    EstimateStatus(String value) {
        this.value = value;
    }
}
