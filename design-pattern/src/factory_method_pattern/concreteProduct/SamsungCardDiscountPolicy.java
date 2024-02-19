package factory_method_pattern.concreteProduct;

import factory_method_pattern.product.DiscountPolicy;

import java.math.BigDecimal;

public class SamsungCardDiscountPolicy extends DiscountPolicy {
    public SamsungCardDiscountPolicy(BigDecimal discountRate, BigDecimal discountAmount) {
        this.discountRate = discountRate;
        this.discountAmount = discountAmount;
    }
}
