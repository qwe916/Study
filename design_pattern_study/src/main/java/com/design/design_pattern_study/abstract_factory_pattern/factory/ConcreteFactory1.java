package com.design.design_pattern_study.abstract_factory_pattern.factory;

import com.design.design_pattern_study.abstract_factory_pattern.product.*;

public class ConcreteFactory1 implements AbstractFactory{
    @Override
    public AbstractProductA createProductA() {
        return new ConcreteProductA1();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ConcreteProductB1();
    }
}
