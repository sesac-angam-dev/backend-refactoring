package com.sesac.angam.post.dto.req;

import com.sesac.angam.post.entity.post.Size;
import com.sesac.angam.post.entity.post.WearNum;
import lombok.Builder;
import org.antlr.v4.runtime.misc.NotNull;


public class PostCreateRequest {

    @NotNull
    private final String title;
    @NotNull
    private final String brand;
    @NotNull
    private final int purchasePrice;
    private final String history;
    @NotNull
    private final Size size;
    @NotNull
    private final WearNum wearNum;

    @Builder
    private PostCreateRequest(String title, String brand, String size, int purchasePrice, WearNum wearNum, String history) {
        this.title = title;
        this.brand = brand;
        this.size = Size.from(size);
        this.purchasePrice = purchasePrice;
        this.wearNum = wearNum;
        this.history = history;
    }
}
