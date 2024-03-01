package com.design.design_pattern_study.builder_pattern.builder;

public class BurgerBuilder {
    // 필수 인자
    private int bun;
    private int patty;

    // 선택적 인자
    private boolean cheese;
    private boolean tomato;

    public BurgerBuilder bun(int bun) {
        this.bun = bun;
        return this;
    }

    public BurgerBuilder patty(int patty) {
        this.patty = patty;
        return this;
    }

    public BurgerBuilder cheese(boolean cheese) {
        this.cheese = cheese;
        return this;
    }

    public BurgerBuilder tomato(boolean tomato) {
        this.tomato = tomato;
        return this;
    }

    public Burger build() {
        return new Burger(bun, patty, cheese, tomato);
    }
}
