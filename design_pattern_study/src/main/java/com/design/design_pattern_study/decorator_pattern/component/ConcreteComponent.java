package com.design.design_pattern_study.decorator_pattern.component;

public class ConcreteComponent implements Component {
    @Override
    public void execute() {
        System.out.println("ConcreteComponent execute(default behavior)");
    }
}
