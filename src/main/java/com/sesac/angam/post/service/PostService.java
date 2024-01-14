package com.sesac.angam.post.service;

import com.sesac.angam.post.dto.req.PostCreateRequest;
import com.sesac.angam.post.dto.req.PostCreateRequests;
import com.sesac.angam.post.dto.res.PostCreateResponse;
import com.sesac.angam.post.entity.post.Post;
import com.sesac.angam.post.entity.set.Set;
import com.sesac.angam.post.repository.PostRepository;
import com.sesac.angam.post.repository.SetRepository;
import com.sesac.angam.user.entity.User;
import com.sesac.angam.util.UserUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class PostService {

    private final UserUtil userUtil;
    private final SetRepository setRepository;
    private final PostRepository postRepository;
    private final KeywordService keywordService;

    @Transactional
    public PostCreateResponse createPosts(Long userId, PostCreateRequests requests) {
        User user = userUtil.getUser(userId);
        Set set = setRepository.save(Set.from(user));
        List<Post> posts = createPosts(set, requests);

        return PostCreateResponse.fromEntity(set, posts);
    }

    private List<Post> createPosts(Set set, PostCreateRequests requests) {
        return requests.getPostCreateRequests().stream()
                .map(request -> createPost(set, request))
                .collect(Collectors.toList());
    }

    private Post createPost(Set set, PostCreateRequest request) {
        Post post = postRepository.save(request.toEntity(set));
        createKeywordsIfPresent(post, request.getKeywords());

        return post;
    }

    private void createKeywordsIfPresent(Post post, List<String> keywords) {
        if (keywords != null && !keywords.isEmpty()) {
            keywordService.createKeywords(post, keywords);
        }
    }
}
