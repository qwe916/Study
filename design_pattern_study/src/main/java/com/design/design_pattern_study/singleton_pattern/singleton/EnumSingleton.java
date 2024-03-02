package com.design.design_pattern_study.singleton_pattern.singleton;

public enum EnumSingleton {
    INSTANCE;

    EnumSingleton() {
    }

    public static EnumSingleton getInstance() {
        return INSTANCE;
    }

    public void print() {
        System.out.println("Hello, EnumSingleton!");
    }
}
