package com.design.design_pattern_study.observer_pattern.observer;

import com.design.design_pattern_study.observer_pattern.user.dto.UserInfoUpdateRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Component
public class UserObserver {
    @TransactionalEventListener
    public void updateUserInfoWithTransaction(UserInfoUpdateRequest userInfoUpdateRequest) {
        log.info("유저 정보가 업데이트 되었습니다. {}", userInfoUpdateRequest);
    }

    @EventListener
    public void updateUserInfo(UserInfoUpdateRequest userInfoUpdateRequest) {
        log.info("유저 정보가 업데이트 되었습니다. {}", userInfoUpdateRequest);
    }
}
