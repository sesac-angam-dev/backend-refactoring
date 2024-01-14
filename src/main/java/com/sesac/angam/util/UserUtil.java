package com.sesac.angam.util;

import com.sesac.angam.exception.BaseException;
import com.sesac.angam.exception.ExceptionCode;
import com.sesac.angam.user.entity.User;
import com.sesac.angam.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserUtil {
    private final UserRepository userRepository;

    public User getUser(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new BaseException(ExceptionCode.USER_NOT_FOUND));
    }
}
