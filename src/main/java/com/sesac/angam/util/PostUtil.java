package com.sesac.angam.util;

import com.sesac.angam.exception.BaseException;
import com.sesac.angam.post.entity.post.Post;
import com.sesac.angam.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.sesac.angam.exception.ExceptionCode.POST_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class PostUtil {
    private final PostRepository postRepository;

    public Post getPost(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new BaseException(POST_NOT_FOUND));
    }
}
