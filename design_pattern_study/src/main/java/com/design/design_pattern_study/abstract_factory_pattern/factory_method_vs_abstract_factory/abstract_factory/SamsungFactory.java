package com.design.design_pattern_study.abstract_factory_pattern.factory_method_vs_abstract_factory.abstract_factory;

import com.design.design_pattern_study.abstract_factory_pattern.factory_method_vs_abstract_factory.component.Phone;
import com.design.design_pattern_study.abstract_factory_pattern.factory_method_vs_abstract_factory.component.SamsungPhone;
import com.design.design_pattern_study.abstract_factory_pattern.factory_method_vs_abstract_factory.component.SamsungSmartWatch;
import com.design.design_pattern_study.abstract_factory_pattern.factory_method_vs_abstract_factory.component.SmartWatch;

public class SamsungFactory implements AbstractFactory {
    @Override
    public Phone createPhone() {
        return new SamsungPhone();
    }

    @Override
    public SmartWatch createSmartWatch() {
        return new SamsungSmartWatch();
    }
}
