package com.design.design_pattern_study.prototype_pattern.prototype;

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
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof ConcretePrototype prototype) || obj.hashCode() != this.hashCode()) {
            return false;
        }
        return prototype.field.equals(this.field);
    }
}
