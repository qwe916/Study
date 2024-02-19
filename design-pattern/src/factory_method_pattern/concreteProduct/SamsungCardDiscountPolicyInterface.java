package factory_method_pattern.concreteProduct;

import factory_method_pattern.product.DiscountPolicyInterface;

import java.math.BigDecimal;

public class SamsungCardDiscountPolicyInterface implements DiscountPolicyInterface {
    protected BigDecimal defaultDiscountAmount;

    public SamsungCardDiscountPolicyInterface(BigDecimal defaultDiscountAmount) {
        this.defaultDiscountAmount = defaultDiscountAmount;
    }

    @Override
    public BigDecimal calculateDiscountAmount(BigDecimal price) {
        return defaultDiscountAmount;
    }
}
