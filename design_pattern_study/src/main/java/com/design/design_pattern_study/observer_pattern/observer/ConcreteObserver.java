package com.design.design_pattern_study.observer_pattern.observer;

import com.design.design_pattern_study.observer_pattern.message.ConcreteMessage;

public class ConcreteObserver implements Observer<ConcreteMessage> {
    @Override
    public boolean update(ConcreteMessage message) {
        System.out.println(message.getMessage());
        return true;
    }
}
