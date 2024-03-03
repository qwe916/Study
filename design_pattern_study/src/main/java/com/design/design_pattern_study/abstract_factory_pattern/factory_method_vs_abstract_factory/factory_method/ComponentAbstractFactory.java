package com.design.design_pattern_study.abstract_factory_pattern.factory_method_vs_abstract_factory.factory_method;

import com.design.design_pattern_study.abstract_factory_pattern.factory_method_vs_abstract_factory.component.Component;

public interface ComponentAbstractFactory {
    Component createComponent(String type);
    Component creteOperationSystem(String type);
}
