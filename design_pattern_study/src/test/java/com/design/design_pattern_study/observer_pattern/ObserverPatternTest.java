package com.design.design_pattern_study.observer_pattern;

import com.design.design_pattern_study.observer_pattern.message.ConcreteMessage;
import com.design.design_pattern_study.observer_pattern.observer.ConcreteObserver;
import com.design.design_pattern_study.observer_pattern.observer.Observer;
import com.design.design_pattern_study.observer_pattern.subject.ConcreteSubject;
import com.design.design_pattern_study.observer_pattern.subject.Subject;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

class ObserverPatternTest {
    @Test
    void 발행자가_구독자에게_메시지를_전달한다() {
        Subject subject = new ConcreteSubject(new HashSet<>());
        Observer observer = new ConcreteObserver();

        ConcreteMessage message = new ConcreteMessage();

        subject.attach(observer);
        subject.notifyMessage(message);
    }
}