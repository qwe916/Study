package com.design.design_pattern_study.decorator_pattern.decorator;

import com.design.design_pattern_study.decorator_pattern.component.Coffee;

public abstract class Cup  implements Coffee {
    protected final Coffee wrappee;

    protected Cup(Coffee wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public void makeCoffee() {
        wrappee.makeCoffee();
        addCup();
    }

    protected abstract void addCup();
}
