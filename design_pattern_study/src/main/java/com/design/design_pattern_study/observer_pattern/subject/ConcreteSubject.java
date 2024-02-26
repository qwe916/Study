package com.design.design_pattern_study.observer_pattern.subject;

import com.design.design_pattern_study.observer_pattern.message.Message;
import com.design.design_pattern_study.observer_pattern.observer.Observer;

import java.util.Set;

public class ConcreteSubject implements Subject {
    private final Set<Observer> observers;

    public ConcreteSubject(Set<Observer> observers) {
        this.observers = observers;
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public boolean notifyMessage(Message message) {
        return observers.stream()
                .filter(observer -> observer.update(message))
                .count() == observers.size();
    }
}
