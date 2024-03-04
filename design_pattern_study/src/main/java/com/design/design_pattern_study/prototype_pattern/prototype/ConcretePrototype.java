package com.design.design_pattern_study.prototype_pattern.prototype;

import java.util.Objects;

public class ConcretePrototype implements Prototype {
    private String field;

    public ConcretePrototype(String field) {
        this.field = field;
    }

    public ConcretePrototype(ConcretePrototype prototype) {
        this.field = prototype.field;
    }

    @Override
    public Prototype clone() {
        return new ConcretePrototype(this);
    }

    @Override
    public int hashCode() {
        return Objects.hash(field);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ConcretePrototype concretePrototype = (ConcretePrototype) obj;
        return Objects.equals(field, concretePrototype.field);
    }
}
