package com.design.design_pattern_study.abstract_factory_pattern.factory_method_vs_abstract_factory.factory_method;

import com.design.design_pattern_study.abstract_factory_pattern.factory_method_vs_abstract_factory.component.ApplePhone;
import com.design.design_pattern_study.abstract_factory_pattern.factory_method_vs_abstract_factory.component.Component;
import com.design.design_pattern_study.abstract_factory_pattern.factory_method_vs_abstract_factory.component.Phone;
import com.design.design_pattern_study.abstract_factory_pattern.factory_method_vs_abstract_factory.component.SamsungPhone;

public class PhoneFactory implements ComponentAbstractFactory{
    @Override
    public Phone createComponent(String type) {
        return creteOperationSystem(type);
    }

    @Override
    public Phone creteOperationSystem(String type) {
        Phone phone = null;

        switch (type) {
            case "android":
                phone = new SamsungPhone();
                break;
            case "ios":
                phone = new ApplePhone();
                break;
            default:
                break;
        }

        return phone;
    }
}
