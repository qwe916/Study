package com.design.design_pattern_study.factory_method_pattern.concreteProduct;

import com.design.design_pattern_study.factory_method_pattern.product.DiscountPolicyInterface;

import java.math.BigDecimal;
import java.util.Optional;

public class KookminCardDiscountPolicyInterface implements DiscountPolicyInterface {
    protected BigDecimal discountRate;
    protected BigDecimal discountAmount;


    @Override
    public BigDecimal calculateDiscountAmount(BigDecimal price) {
        if(Optional.ofNullable(discountRate).isPresent()){
            return price.subtract(price.multiply(discountRate));
        }
        return price.subtract(discountAmount);
    }

    public KookminCardDiscountPolicyInterface(BigDecimal discountRate, BigDecimal discountAmount) {
        this.discountRate = discountRate;
        this.discountAmount = discountAmount;
    }
}
