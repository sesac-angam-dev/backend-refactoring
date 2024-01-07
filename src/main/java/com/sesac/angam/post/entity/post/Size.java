package com.sesac.angam.post.entity.post;

import com.sesac.angam.exception.BaseException;

import java.util.Arrays;

import static com.sesac.angam.exception.ExceptionCode.SIZE_NOT_FOUND;

public enum Size {
    FREE("Free"),
    XS("XS"),
    S("S"),
    M("M"),
    L("L"),
    XL("XL"),
    XXL("2XL");
    private final String value;

    Size(String value){
        this.value = value;
    }

    public static Size from(String size) {
        return Arrays.stream(Size.values())
                .filter(value -> size.equals(value))
                .findFirst()
                .orElseThrow(() -> new BaseException(SIZE_NOT_FOUND));
    }

}
