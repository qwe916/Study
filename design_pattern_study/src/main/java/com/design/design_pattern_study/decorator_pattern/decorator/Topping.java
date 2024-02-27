package com.design.design_pattern_study.decorator_pattern.decorator;

import com.design.design_pattern_study.decorator_pattern.component.Coffee;

public abstract class Topping implements Coffee {
    protected final Coffee wrappee;

    protected Topping(Coffee wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public void makeCoffee() {
        wrappee.makeCoffee();
        addTopping();
    }

    protected abstract void addTopping();
}
