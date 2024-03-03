package com.design.design_pattern_study.abstract_factory_pattern.factory;

import com.design.design_pattern_study.abstract_factory_pattern.product.AbstractProductA;
import com.design.design_pattern_study.abstract_factory_pattern.product.AbstractProductB;

public interface AbstractFactory {
    AbstractProductA createProductA();
    AbstractProductB createProductB();
}
