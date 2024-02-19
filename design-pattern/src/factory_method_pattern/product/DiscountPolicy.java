package factory_method_pattern.product;

import java.math.BigDecimal;
import java.util.Optional;

public abstract class DiscountPolicy {
    protected BigDecimal discountRate;
    protected BigDecimal discountAmount;

    public  BigDecimal calculateDiscountAmount(BigDecimal price){
        if(Optional.ofNullable(discountRate).isPresent()){
            return price.subtract(price.multiply(discountRate));
        }
        return price.subtract(discountAmount);
    }
}
