package com.design.design_pattern_study.observer_pattern.user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nickname;
    @Column(unique = true)
    private String email;

    public User updateInfo(String nickname, String email) {
        this.nickname = nickname;
        this.email = email;
        return this;
    }

    public User(String nickname, String email) {
        this.nickname = nickname;
        this.email = email;
    }
}
