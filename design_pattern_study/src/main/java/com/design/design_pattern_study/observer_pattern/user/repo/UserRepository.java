package com.design.design_pattern_study.observer_pattern.user.repo;

import com.design.design_pattern_study.observer_pattern.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByNickname(String nickname);
}
