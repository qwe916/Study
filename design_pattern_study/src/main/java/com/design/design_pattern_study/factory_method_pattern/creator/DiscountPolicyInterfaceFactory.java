package com.design.design_pattern_study.factory_method_pattern.creator;


import com.design.design_pattern_study.factory_method_pattern.product.DiscountPolicyInterface;

import java.math.BigDecimal;

public abstract class DiscountPolicyInterfaceFactory {
    public BigDecimal calculateDiscountAmount(BigDecimal price, CardType cardType) {
        DiscountPolicyInterface discountPolicy = createDiscountPolicy(cardType);
        return discountPolicy.calculateDiscountAmount(price);
    }

    protected abstract DiscountPolicyInterface createDiscountPolicy(CardType cardType);
}
