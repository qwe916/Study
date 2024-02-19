package factory_method_pattern.concreteProduct;

import factory_method_pattern.product.DiscountPolicy;

import java.math.BigDecimal;

public class KookminCardDiscountPolicy extends DiscountPolicy {
    public KookminCardDiscountPolicy(BigDecimal discountRate, BigDecimal discountAmount) {
        this.discountRate = discountRate;
        this.discountAmount = discountAmount;
    }
}