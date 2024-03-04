package com.design.design_pattern_study.prototype_pattern;

import com.design.design_pattern_study.prototype_pattern.prototype.Circle;
import com.design.design_pattern_study.prototype_pattern.prototype.ConcretePrototype;
import com.design.design_pattern_study.prototype_pattern.prototype.Prototype;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PrototypePatternTest {
    @Test
    void 프로토타입_패턴_테스트(){
        Prototype prototype = new ConcretePrototype("field");
        Prototype clone = prototype.clone();
        Assertions.assertThat(prototype).isEqualTo(clone);
    }

    @Test
    void Cloneable_인터페이스_테스트(){
        Circle circle = new Circle(1, 2, 3);
        Circle clone = circle.clone();
        Assertions.assertThat(circle).isEqualTo(clone);
    }
}