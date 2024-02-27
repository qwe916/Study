package com.design.design_pattern_study.decorator_pattern.decorator;

import com.design.design_pattern_study.decorator_pattern.component.Coffee;

public class CreamTopping extends Topping {
    public CreamTopping(Coffee coffee) {
        super(coffee);
    }

    @Override
    protected void addTopping() {
        System.out.println("Cream Topping");
    }
}
