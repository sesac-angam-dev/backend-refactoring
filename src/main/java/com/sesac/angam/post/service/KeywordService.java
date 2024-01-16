package com.sesac.angam.post.service;

import com.sesac.angam.post.entity.post.Keyword;
import com.sesac.angam.post.entity.post.Post;
import com.sesac.angam.post.entity.post.PostKeyword;
import com.sesac.angam.post.repository.KeywordRepository;
import com.sesac.angam.post.repository.PostKeywordRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class KeywordService {
    private final KeywordRepository keywordRepository;
    private final PostKeywordRepository postKeywordRepository;

    public void createKeywords(Post post, List<String> keywords) {
        List<Keyword> foundKeywords = keywordRepository.findByKeywordIn(keywords);

        keywords.stream().map(keyword -> createKeyword(foundKeywords, keyword))
                .forEach(keyword -> saveKeyword(post, keyword));
    }

    public List<String> getKeywords(Post post) {
        return postKeywordRepository.findAllByPost(post);
    }

    private Keyword createKeyword(List<Keyword> foundKeywords, String keyword) {
        return foundKeywords.stream()
                .filter(foundKeyword -> foundKeyword.equals(keyword))
                .findAny()
                .orElseGet(() -> keywordRepository.save(new Keyword(keyword)));
    }

    private void saveKeyword(Post post, Keyword keyword) {
        PostKeyword postKeyword = new PostKeyword(keyword, post);
        postKeywordRepository.save(postKeyword);
    }
}
