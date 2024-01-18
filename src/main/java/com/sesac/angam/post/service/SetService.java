package com.sesac.angam.post.service;


import com.sesac.angam.post.entity.set.Set;
import com.sesac.angam.post.repository.SetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SetService {

    private final SetRepository setRepository;

    public Set save(Set entity) {
        return setRepository.save(entity);
    }
}
