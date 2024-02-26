package com.design.design_pattern_study.observer_pattern.observer;


public interface Observer<T> {
    boolean update(T message);
}
