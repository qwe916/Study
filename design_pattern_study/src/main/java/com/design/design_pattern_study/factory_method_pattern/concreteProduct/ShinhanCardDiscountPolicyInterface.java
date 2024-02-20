package com.design.design_pattern_study.factory_method_pattern.concreteProduct;

import com.design.design_pattern_study.factory_method_pattern.product.DiscountPolicyInterface;

import java.math.BigDecimal;
import java.util.Optional;

public class ShinhanCardDiscountPolicyInterface implements DiscountPolicyInterface {
    protected BigDecimal discountRate;
    protected BigDecimal discountAmount;
    protected BigDecimal defaultDiscountAmount;

    public ShinhanCardDiscountPolicyInterface(BigDecimal discountRate, BigDecimal discountAmount, BigDecimal defaultDiscountAmount) {
        this.discountRate = discountRate;
        this.discountAmount = discountAmount;
        this.defaultDiscountAmount = defaultDiscountAmount;
    }

    @Override
    public BigDecimal calculateDiscountAmount(BigDecimal price) {
        if(Optional.ofNullable(discountRate).isPresent()){
            return price.subtract(price.multiply(discountRate));
        } else if(Optional.ofNullable(discountAmount).isPresent()){
            return price.subtract(discountAmount);
        }
        return defaultDiscountAmount;
    }
}
