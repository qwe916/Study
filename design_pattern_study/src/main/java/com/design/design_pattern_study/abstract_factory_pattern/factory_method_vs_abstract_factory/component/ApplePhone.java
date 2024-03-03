package com.design.design_pattern_study.abstract_factory_pattern.factory_method_vs_abstract_factory.component;

import com.design.design_pattern_study.abstract_factory_pattern.factory_method_vs_abstract_factory.component.Phone;

public class ApplePhone extends Phone {
    @Override
    public void operate() {
        System.out.println("Apple Phone is operating...");
    }
}
