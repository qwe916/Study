package factory_method_pattern.creator;

import factory_method_pattern.product.DiscountPolicy;

import java.math.BigDecimal;

public abstract class DiscountPolicyFactory {
    public BigDecimal calculateDiscountAmount(BigDecimal price, CardType cardType) {
        DiscountPolicy discountPolicy = createDiscountPolicy(cardType);
        return discountPolicy.calculateDiscountAmount(price);
    }

    protected abstract DiscountPolicy createDiscountPolicy(CardType cardType);
}
