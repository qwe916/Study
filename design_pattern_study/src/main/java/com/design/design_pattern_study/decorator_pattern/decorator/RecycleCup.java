package com.design.design_pattern_study.decorator_pattern.decorator;

import com.design.design_pattern_study.decorator_pattern.component.Coffee;

public class RecycleCup extends Cup {
    public RecycleCup(Coffee wrappee) {
        super(wrappee);
    }

    @Override
    protected void addCup() {
        System.out.println("Recycle Cup");
    }
}
