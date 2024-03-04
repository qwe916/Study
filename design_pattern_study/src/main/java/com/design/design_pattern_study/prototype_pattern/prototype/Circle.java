package com.design.design_pattern_study.prototype_pattern.prototype;

import java.util.Objects;

public class Circle implements Cloneable {
    private int x, y, r;

    public Circle(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public Circle(Circle circle) {
        this.x = circle.x;
        this.y = circle.y;
        this.r = circle.r;
    }

    public Circle clone() {
        return new Circle(this);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, r);
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Circle circle) || obj.hashCode() != this.hashCode()) {
            return false;
        }
        return circle.x == this.x && circle.y == this.y && circle.r == this.r;
    }
}
