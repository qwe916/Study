package com.design.design_pattern_study.observer_pattern.subject;


import com.design.design_pattern_study.observer_pattern.message.Message;
import com.design.design_pattern_study.observer_pattern.observer.Observer;

public interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    boolean notifyMessage(Message message);
}
