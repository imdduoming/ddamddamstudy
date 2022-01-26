package com.warrior.ddamddam.user.repository;

import com.warrior.ddamddam.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    boolean existsByUsername(String username);

    Optional<User> findByApiId(Long kakaoId);
//    Optional<User> findByNaverId(Long naverId);
}