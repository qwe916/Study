package com.design.design_pattern_study.abstract_factory_pattern.factory_method_vs_abstract_factory.abstract_factory;

import com.design.design_pattern_study.abstract_factory_pattern.factory_method_vs_abstract_factory.component.Phone;
import com.design.design_pattern_study.abstract_factory_pattern.factory_method_vs_abstract_factory.component.SmartWatch;

public interface AbstractFactory {
    Phone createPhone();
    SmartWatch createSmartWatch();
}
