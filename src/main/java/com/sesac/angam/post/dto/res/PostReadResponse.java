package com.sesac.angam.post.dto.res;

import com.sesac.angam.post.entity.post.Post;
import com.sesac.angam.post.entity.post.Size;
import com.sesac.angam.post.entity.post.WearNum;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class PostReadResponse {
    private Long postId;
    private String title;
    private String brand;
    private Size size;
    private int purchasePrice;
    private WearNum wearNum;
    private String history;
    private List<String> keywordList;
    private boolean isLiked;

    @Builder
    private PostReadResponse(Long postId, String title, String brand, Size size, int purchasePrice, WearNum wearNum, String history, List<String> keywordList, boolean isLiked) {
        this.postId = postId;
        this.title = title;
        this.brand = brand;
        this.size = size;
        this.purchasePrice = purchasePrice;
        this.wearNum = wearNum;
        this.history = history;
        this.keywordList = keywordList;
        this.isLiked = isLiked;
    }

    public static PostReadResponse fromEntity(Post post, List<String> keywords, boolean isLiked) {
        return PostReadResponse.builder()
                .postId(post.getId())
                .brand(post.getBrand())
                .title(post.getTitle())
                .size(post.getSize())
                .purchasePrice(post.getPurchasePrice())
                .wearNum(post.getWearNum())
                .keywordList(keywords)
                .history(post.getHistory())
                .isLiked(isLiked)
                .build();
    }
}
