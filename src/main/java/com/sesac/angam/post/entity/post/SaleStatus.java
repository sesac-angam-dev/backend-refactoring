package com.sesac.angam.post.entity.post;

public enum SaleStatus {
    BEFORE_SALE("판매전"),
    SELLING("판매중"),
    COMPLETED("판매완료");

    private final String value;

    SaleStatus(String value) {
        this.value = value;
    }
}
