package factory_method_pattern.creator;

import factory_method_pattern.product.DiscountPolicyInterface;

import java.math.BigDecimal;

public abstract class DiscountPolicyInterfaceFactory {
    public BigDecimal calculateDiscountAmount(BigDecimal price, CardType cardType) {
        DiscountPolicyInterface discountPolicy = createDiscountPolicy(cardType);
        return discountPolicy.calculateDiscountAmount(price);
    }

    protected abstract DiscountPolicyInterface createDiscountPolicy(CardType cardType);
}
