package com.design.design_pattern_study.decorator_pattern.decorator;

import com.design.design_pattern_study.decorator_pattern.component.Component;

public class ConcreteDecorator1 extends BaseDecorator {
    public ConcreteDecorator1(Component component) {
        super(component);
    }

    @Override
    public void execute() {
        super.execute();
        extra();
    }

    private void extra(){
        System.out.println("ConcreteDecorator1 execute");
    }
}
