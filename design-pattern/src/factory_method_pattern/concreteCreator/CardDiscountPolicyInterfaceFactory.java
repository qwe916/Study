package factory_method_pattern.concreteCreator;

import factory_method_pattern.concreteProduct.*;
import factory_method_pattern.creator.CardType;
import factory_method_pattern.creator.DiscountPolicyInterfaceFactory;
import factory_method_pattern.product.DiscountPolicyInterface;

import java.math.BigDecimal;

public class CardDiscountPolicyInterfaceFactory extends DiscountPolicyInterfaceFactory {
    @Override
    protected DiscountPolicyInterface createDiscountPolicy(CardType cardType) {
        return switch (cardType) {
            case 국민 -> new KookminCardDiscountPolicyInterface(new BigDecimal(String.valueOf(0.1)), new BigDecimal(String.valueOf(1000)));
            case 신한 -> new ShinhanCardDiscountPolicyInterface(new BigDecimal(String.valueOf(0.05)), new BigDecimal(String.valueOf(500)), new BigDecimal(String.valueOf(5000)));
            case 삼성 -> new SamsungCardDiscountPolicyInterface(new BigDecimal(String.valueOf(700)));
        };
    }
}
