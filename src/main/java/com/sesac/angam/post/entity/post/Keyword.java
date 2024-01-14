package com.sesac.angam.post.entity.post;

import jakarta.persistence.*;
import lombok.*;
import java.util.Objects;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "keywords")
public class Keyword {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "keyword_id")
    private Long id;
    private String keyword;
    private boolean isDeleted=Boolean.FALSE;

    public Keyword (String keyword){
        this.keyword = keyword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        return Objects.equals(this.keyword, o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(keyword);
    }
}
