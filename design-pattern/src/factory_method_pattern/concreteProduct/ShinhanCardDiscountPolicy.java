package factory_method_pattern.concreteProduct;

import factory_method_pattern.product.DiscountPolicy;

import java.math.BigDecimal;

public class ShinhanCardDiscountPolicy extends DiscountPolicy {
    public ShinhanCardDiscountPolicy(BigDecimal discountRate, BigDecimal discountAmount) {
        this.discountRate = discountRate;
        this.discountAmount = discountAmount;
    }
}
