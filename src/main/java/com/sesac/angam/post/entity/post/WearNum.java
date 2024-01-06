package com.sesac.angam.post.entity.post;

public enum WearNum {
    ZERO_TIMES("0회"),
    LESS_THAN_5_TIMES("5회 미만"),
    FIVE_OR_MORE_TIMES("5회 이상"),
    LESS_THAN_30_TIMES("30회 미만");

    private final String value;

    WearNum(String value){
        this.value = value;
    }
}
