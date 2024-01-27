package com.sesac.angam.user.repository;

import com.sesac.angam.exception.BaseException;
import com.sesac.angam.exception.ExceptionCode;
import com.sesac.angam.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import static com.sesac.angam.exception.ExceptionCode.USER_NOT_FOUND;

public interface UserRepository extends JpaRepository<User, Long> {
    default User getById(Long id) {
        return this.findById(id)
                .orElseThrow(() -> new BaseException(USER_NOT_FOUND));
    }
}
