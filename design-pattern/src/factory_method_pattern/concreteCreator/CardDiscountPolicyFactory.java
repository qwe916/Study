package factory_method_pattern.concreteCreator;

import factory_method_pattern.creator.CardType;
import factory_method_pattern.concreteProduct.KookminCardDiscountPolicy;
import factory_method_pattern.concreteProduct.SamsungCardDiscountPolicy;
import factory_method_pattern.concreteProduct.ShinhanCardDiscountPolicy;
import factory_method_pattern.creator.DiscountPolicyFactory;
import factory_method_pattern.product.DiscountPolicy;

import java.math.BigDecimal;

public class CardDiscountPolicyFactory extends DiscountPolicyFactory {
    @Override
    protected DiscountPolicy createDiscountPolicy(CardType cardType) {
        return switch (cardType) {
            case 국민 -> new KookminCardDiscountPolicy(new BigDecimal(String.valueOf(0.1)), new BigDecimal(String.valueOf(1000)));
            case 신한 -> new ShinhanCardDiscountPolicy(new BigDecimal(String.valueOf(0.05)), new BigDecimal(String.valueOf(500)));
            case 삼성 -> new SamsungCardDiscountPolicy(new BigDecimal(String.valueOf(0.07)), new BigDecimal(String.valueOf(700)));
        };
    }
}
