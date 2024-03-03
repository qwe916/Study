package com.design.design_pattern_study.abstract_factory_pattern.factory_method_vs_abstract_factory.abstract_factory;

import com.design.design_pattern_study.abstract_factory_pattern.factory_method_vs_abstract_factory.component.ApplePhone;
import com.design.design_pattern_study.abstract_factory_pattern.factory_method_vs_abstract_factory.component.AppleSmartWatch;
import com.design.design_pattern_study.abstract_factory_pattern.factory_method_vs_abstract_factory.component.Phone;
import com.design.design_pattern_study.abstract_factory_pattern.factory_method_vs_abstract_factory.component.SmartWatch;

public class AppleFactory implements AbstractFactory {
    @Override
    public SmartWatch createSmartWatch() {
        return new AppleSmartWatch();
    }

    @Override
    public Phone createPhone() {
        return new ApplePhone();
    }
}
