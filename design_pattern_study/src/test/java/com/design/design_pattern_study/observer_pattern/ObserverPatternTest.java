package com.design.design_pattern_study.observer_pattern;

import com.design.design_pattern_study.observer_pattern.message.ConcreteMessage;
import com.design.design_pattern_study.observer_pattern.observer.ConcreteObserver;
import com.design.design_pattern_study.observer_pattern.observer.Observer;
import com.design.design_pattern_study.observer_pattern.subject.ConcreteSubject;
import com.design.design_pattern_study.observer_pattern.subject.Subject;
import com.design.design_pattern_study.observer_pattern.subject.UserSubject;
import com.design.design_pattern_study.observer_pattern.user.dto.UserInfoUpdateRequest;
import com.design.design_pattern_study.observer_pattern.user.entity.User;
import com.design.design_pattern_study.observer_pattern.user.repo.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;

@SpringBootTest
class ObserverPatternTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserSubject userSubject;

    @BeforeEach
    void setUp() {
        userRepository.save(new User("nickname", "email"));
    }

    @AfterEach
    void tearDown() {
        userRepository.deleteAll();
    }

    @Test
    void 발행자가_구독자에게_메시지를_전달한다() {
        Subject subject = new ConcreteSubject(new HashSet<>());
        Observer observer = new ConcreteObserver();

        ConcreteMessage message = new ConcreteMessage();

        subject.attach(observer);
        subject.notifyMessage(message);
    }

    @Test
    void 발행자가_구독자에게_메시지를_전달한다_2() {
        UserInfoUpdateRequest userInfoUpdateRequest = new UserInfoUpdateRequest("newNickname", "newEmail");
        User updateUserInfo = userSubject.updateUserInfo(userInfoUpdateRequest, "nickname");
        Assertions.assertThat(updateUserInfo.getNickname()).isEqualTo("newNickname");
    }
}