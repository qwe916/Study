package com.design.design_pattern_study.abstract_factory_pattern.factory_method_vs_abstract_factory.factory_method;

import com.design.design_pattern_study.abstract_factory_pattern.factory_method_vs_abstract_factory.component.AppleSmartWatch;
import com.design.design_pattern_study.abstract_factory_pattern.factory_method_vs_abstract_factory.component.Component;
import com.design.design_pattern_study.abstract_factory_pattern.factory_method_vs_abstract_factory.component.SamsungSmartWatch;
import com.design.design_pattern_study.abstract_factory_pattern.factory_method_vs_abstract_factory.component.SmartWatch;

public class SmartWatchFactory implements ComponentAbstractFactory {

    @Override
    public SmartWatch createComponent(String type) {
        return creteOperationSystem(type);
    }

    @Override
    public SmartWatch creteOperationSystem(String type) {
        SmartWatch smartWatch = null;

        switch (type) {
            case "android":
                smartWatch = new SamsungSmartWatch();
                break;
            case "ios":
                smartWatch = new AppleSmartWatch();
                break;
            default:
                break;
        }

        return smartWatch;
    }

}
