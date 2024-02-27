package com.design.design_pattern_study.decorator_pattern.component;

public class Latte implements Coffee {
    @Override
    public void makeCoffee() {
        System.out.println("Latte");
    }
}
