package com.design.design_pattern_study.factory_method_pattern;

import com.design.design_pattern_study.factory_method_pattern.concreteCreator.CardDiscountPolicyFactory;
import com.design.design_pattern_study.factory_method_pattern.concreteCreator.CardDiscountPolicyInterfaceFactory;
import com.design.design_pattern_study.factory_method_pattern.creator.CardType;
import com.design.design_pattern_study.factory_method_pattern.creator.DiscountPolicyFactory;
import com.design.design_pattern_study.factory_method_pattern.creator.DiscountPolicyInterfaceFactory;
import com.design.design_pattern_study.factory_method_pattern.enumCreator.EnumDiscountPolicyFactory;
import com.design.design_pattern_study.factory_method_pattern.product.DiscountPolicy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class FactoryMethodPatternTest {
    @Test
    void 추상클래스_팩토리_메서드_패턴() {
        DiscountPolicyFactory discountPolicyFactory = new CardDiscountPolicyFactory();
        BigDecimal 국민_finalFeeByAbstractClass = discountPolicyFactory.calculateDiscountAmount(new BigDecimal(10000), CardType.국민);
        Assertions.assertThat(국민_finalFeeByAbstractClass).isEqualTo(new BigDecimal("9000.0"));
    }

    @Test
    void 열거형_팩토리_메서드_패턴() {
        DiscountPolicy discountPolicy = EnumDiscountPolicyFactory.국민.createDiscountPolicy(new BigDecimal(String.valueOf(0.1)), new BigDecimal(1000));
        BigDecimal finalFeeByEnum = discountPolicy.calculateDiscountAmount(new BigDecimal(10000));
        Assertions.assertThat(finalFeeByEnum).isEqualTo(new BigDecimal("9000.0"));
    }

    @Test
    void 인터페이스_팩토리_메서드_패턴() {
        DiscountPolicyInterfaceFactory discountPolicyInterfaceFactory = new CardDiscountPolicyInterfaceFactory();
        BigDecimal finalFeeByInterface = discountPolicyInterfaceFactory.calculateDiscountAmount(new BigDecimal(10000), CardType.국민);
        Assertions.assertThat(finalFeeByInterface).isEqualTo(new BigDecimal("9000.0"));
    }
}