package com.design.design_pattern_study.factory_method_pattern.product;

import java.math.BigDecimal;

public interface DiscountPolicyInterface {
    BigDecimal calculateDiscountAmount(BigDecimal price);
}
