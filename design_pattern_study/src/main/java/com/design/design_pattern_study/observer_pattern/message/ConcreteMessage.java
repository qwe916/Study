package com.design.design_pattern_study.observer_pattern.message;

public class ConcreteMessage implements Message{
    @Override
    public String getMessage() {
        return "발행자가 발행한 메시지입니다.";
    }
}
