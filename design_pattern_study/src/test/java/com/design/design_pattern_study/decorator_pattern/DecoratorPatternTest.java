package com.design.design_pattern_study.decorator_pattern;

import com.design.design_pattern_study.decorator_pattern.component.Component;
import com.design.design_pattern_study.decorator_pattern.component.ConcreteComponent;
import com.design.design_pattern_study.decorator_pattern.decorator.ConcreteDecorator1;
import com.design.design_pattern_study.decorator_pattern.decorator.ConcreteDecorator2;
import org.junit.jupiter.api.Test;

class DecoratorPatternTest {
    @Test
    void 데코레이터_패턴_테스트() {
        Component concreteComponent = new ConcreteComponent();

        Component concreteDecorator1 = new ConcreteDecorator1(concreteComponent);
        concreteDecorator1.execute();
        System.out.println();

        Component concreteDecorator2 = new ConcreteDecorator2(concreteComponent);
        concreteDecorator2.execute();
        System.out.println();

        Component concreteDecorator1And2 = new ConcreteDecorator1(new ConcreteDecorator2(concreteComponent));
        concreteDecorator1And2.execute();
        System.out.println();

        Component concreteDecorator2And1 = new ConcreteDecorator2(new ConcreteDecorator1(concreteComponent));
        concreteDecorator2And1.execute();
    }

}