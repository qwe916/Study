package com.design.design_pattern_study.abstract_factory_pattern;

import com.design.design_pattern_study.abstract_factory_pattern.factory.AbstractFactory;
import com.design.design_pattern_study.abstract_factory_pattern.factory.ConcreteFactory1;
import com.design.design_pattern_study.abstract_factory_pattern.product.AbstractProductA;
import com.design.design_pattern_study.abstract_factory_pattern.product.AbstractProductB;
import org.junit.jupiter.api.Test;

class AbstractFactoryPatternTest {
    @Test
    void 추상_팩토리_패턴_테스트(){
        AbstractFactory factory = null;

        //공장 1 가동
        factory = new ConcreteFactory1();

        //제품 A 생성
        AbstractProductA productA = factory.createProductA();

        //제품 A 사용 - productA1 사용
        productA.use();

        //제품 B 생성
        AbstractProductB productB = factory.createProductB();

        //제품 B 사용 - productB1 사용
        productB.use();
    }

}