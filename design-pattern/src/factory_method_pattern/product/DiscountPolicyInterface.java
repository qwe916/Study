package factory_method_pattern.product;

import java.math.BigDecimal;

public interface DiscountPolicyInterface {
    public BigDecimal calculateDiscountAmount(BigDecimal price);
}
