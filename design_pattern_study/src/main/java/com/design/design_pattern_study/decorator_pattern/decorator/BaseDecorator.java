package com.design.design_pattern_study.decorator_pattern.decorator;

import com.design.design_pattern_study.decorator_pattern.component.Component;

public abstract class BaseDecorator implements Component {
    private final Component wrappee;

    public BaseDecorator(Component component) {
        this.wrappee = component;
    }

    @Override
    public void execute() {
        wrappee.execute();
    }
}
