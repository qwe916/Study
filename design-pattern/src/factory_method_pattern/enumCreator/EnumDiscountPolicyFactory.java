package factory_method_pattern.enumCreator;

import factory_method_pattern.concreteProduct.KookminCardDiscountPolicy;
import factory_method_pattern.concreteProduct.SamsungCardDiscountPolicy;
import factory_method_pattern.concreteProduct.ShinhanCardDiscountPolicy;
import factory_method_pattern.product.DiscountPolicy;

import java.math.BigDecimal;

public enum EnumDiscountPolicyFactory {
    국민 {
        @Override
        public DiscountPolicy createDiscountPolicy(BigDecimal discountRate, BigDecimal discountAmount) {
            return new KookminCardDiscountPolicy(discountRate, discountAmount);
        }
    },
    신한 {
        @Override
        public DiscountPolicy createDiscountPolicy(BigDecimal discountRate, BigDecimal discountAmount) {
            return new ShinhanCardDiscountPolicy(discountRate, discountAmount);
        }
    },
    삼성 {
        @Override
        public DiscountPolicy createDiscountPolicy(BigDecimal discountRate, BigDecimal discountAmount) {
            return new SamsungCardDiscountPolicy(discountRate, discountAmount);
        }
    };

    public abstract DiscountPolicy createDiscountPolicy(BigDecimal discountRate, BigDecimal discountAmount);
}
