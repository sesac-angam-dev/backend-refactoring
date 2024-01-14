package com.sesac.angam.user.repository;

import com.sesac.angam.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
