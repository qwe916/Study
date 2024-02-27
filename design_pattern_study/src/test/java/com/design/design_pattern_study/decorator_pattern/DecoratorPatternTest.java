package com.design.design_pattern_study.decorator_pattern;

import com.design.design_pattern_study.decorator_pattern.component.Coffee;
import com.design.design_pattern_study.decorator_pattern.component.Component;
import com.design.design_pattern_study.decorator_pattern.component.ConcreteComponent;
import com.design.design_pattern_study.decorator_pattern.component.Latte;
import com.design.design_pattern_study.decorator_pattern.decorator.ConcreteDecorator1;
import com.design.design_pattern_study.decorator_pattern.decorator.ConcreteDecorator2;
import com.design.design_pattern_study.decorator_pattern.decorator.CreamTopping;
import com.design.design_pattern_study.decorator_pattern.decorator.RecycleCup;
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

    @Test
    void 커피_데코레터_패턴_적용(){
        Coffee latte = new Latte();

        Coffee creamToppingLatte = new CreamTopping(latte);
        creamToppingLatte.makeCoffee();
        System.out.println();

        Coffee recycleCupLatte = new RecycleCup(latte);
        recycleCupLatte.makeCoffee();
        System.out.println();

        Coffee creamAndChocolateToppingLatte = new CreamTopping(new RecycleCup(latte));
        creamAndChocolateToppingLatte.makeCoffee();
    }
}