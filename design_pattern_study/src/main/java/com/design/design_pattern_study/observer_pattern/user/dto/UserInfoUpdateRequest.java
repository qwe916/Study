package com.design.design_pattern_study.observer_pattern.user.dto;

public record UserInfoUpdateRequest(
        String nickname,
        String email
) {
}
