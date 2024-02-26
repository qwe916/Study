package com.design.design_pattern_study.observer_pattern.subject;

import com.design.design_pattern_study.observer_pattern.user.entity.User;
import com.design.design_pattern_study.observer_pattern.user.dto.UserInfoUpdateRequest;
import com.design.design_pattern_study.observer_pattern.user.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class UserSubject {
    private final ApplicationEventPublisher applicationEventPublisher;
    private final UserRepository userRepository;

    @Transactional
    public User updateUserInfo(UserInfoUpdateRequest userInfoUpdateRequest, String nickname) {
        User user = userRepository.findByNickname(nickname).orElseThrow();
        User updateUser = user.updateInfo(userInfoUpdateRequest.nickname(), userInfoUpdateRequest.email());
        applicationEventPublisher.publishEvent(userInfoUpdateRequest);
        return updateUser;
    }
}
