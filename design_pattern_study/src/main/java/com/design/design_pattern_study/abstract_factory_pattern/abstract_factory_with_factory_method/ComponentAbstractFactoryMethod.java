package com.design.design_pattern_study.abstract_factory_pattern.abstract_factory_with_factory_method;

import com.design.design_pattern_study.abstract_factory_pattern.factory_method_vs_abstract_factory.component.Component;
import com.design.design_pattern_study.abstract_factory_pattern.factory_method_vs_abstract_factory.component.Phone;
import com.design.design_pattern_study.abstract_factory_pattern.factory_method_vs_abstract_factory.component.SmartWatch;

import java.util.ArrayList;
import java.util.List;

public interface ComponentAbstractFactoryMethod {
    //서브 클래스에서 구현할 팩토리 메서드
    Phone createPhone();
    SmartWatch createSmartWatch();

    default List<Component> createOperation(){
        Phone phone = createPhone();
        SmartWatch smartWatch = createSmartWatch();

        phone.추가세팅();
        smartWatch.추가세팅();

        return new ArrayList<>(List.of(phone, smartWatch));
    }
}
