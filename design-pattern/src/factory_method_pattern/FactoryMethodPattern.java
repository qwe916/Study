package factory_method_pattern;


import factory_method_pattern.concreteCreator.CardDiscountPolicyInterfaceFactory;
import factory_method_pattern.creator.CardType;
import factory_method_pattern.concreteCreator.CardDiscountPolicyFactory;
import factory_method_pattern.creator.DiscountPolicyFactory;
import factory_method_pattern.creator.DiscountPolicyInterfaceFactory;
import factory_method_pattern.enumCreator.EnumDiscountPolicyFactory;
import factory_method_pattern.product.DiscountPolicy;

import java.math.BigDecimal;

class FactoryMethodPattern {
    public static void main(String[] args) {
        // Factory Method Pattern by abstract class
        DiscountPolicyFactory discountPolicyFactory = new CardDiscountPolicyFactory();
        BigDecimal 국민_finalFeeByAbstractClass = discountPolicyFactory.calculateDiscountAmount(new BigDecimal(10000), CardType.국민);
        System.out.println(국민_finalFeeByAbstractClass.toString()); // 9000.0

        // Factory Method Pattern by enum
        DiscountPolicy discountPolicy = EnumDiscountPolicyFactory.국민.createDiscountPolicy(new BigDecimal(String.valueOf(0.1)), new BigDecimal(1000));
        BigDecimal finalFeeByEnum = discountPolicy.calculateDiscountAmount(new BigDecimal(10000));
        System.out.println(finalFeeByEnum.toString()); // 9000.0

        // Factory Method Pattern by interface
        DiscountPolicyInterfaceFactory discountPolicyInterfaceFactory = new CardDiscountPolicyInterfaceFactory();
        BigDecimal finalFeeByInterface = discountPolicyInterfaceFactory.calculateDiscountAmount(new BigDecimal(10000), CardType.국민);
        System.out.println(finalFeeByInterface.toString()); // 9000.0

    }
}