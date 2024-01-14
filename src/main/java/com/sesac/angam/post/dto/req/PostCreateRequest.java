package com.sesac.angam.post.dto.req;

import com.sesac.angam.post.entity.post.Post;
import com.sesac.angam.post.entity.post.SaleStatus;
import com.sesac.angam.post.entity.post.Size;
import com.sesac.angam.post.entity.post.WearNum;
import com.sesac.angam.post.entity.set.Set;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class PostCreateRequest {

    private String title;
    private String brand;
    private int purchasePrice;
    private String history;
    private Size size;
    private WearNum wearNum;
    private List<String> keywords;

    private PostCreateRequest(String title, String brand, int purchasePrice, String history, Size size, WearNum wearNum, List<String> keywords) {
        this.title = title;
        this.brand = brand;
        this.purchasePrice = purchasePrice;
        this.history = history;
        this.size = size;
        this.wearNum = wearNum;
        this.keywords = keywords;
    }

    public Post toEntity(Set set) {
        return Post.builder()
                .brand(this.brand)
                .title(this.title)
                .history(this.history)
                .saleStatus(SaleStatus.BEFORE_SALE)
                .wearNum(this.wearNum)
                .purchasePrice(this.purchasePrice)
                .size(this.size)
                .set(set)
                .pickupRequested(false)
                .isDeleted(false)
                .build();
    }

}
