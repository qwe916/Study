package com.design.design_pattern_study.builder_pattern.telescope;

public class TelescopeBurger {
    //필수 인자
    private int bun;
    private int patty;

    //선택적 인자
    private boolean cheese;
    private boolean tomato;

    public TelescopeBurger(int bun, int patty) {
        this.bun = bun;
        this.patty = patty;
    }

    public TelescopeBurger(int bun, int patty, boolean cheese) {
        this(bun, patty);
        this.cheese = cheese;
    }

    public TelescopeBurger(int bun, int patty, boolean cheese, boolean tomato) {
        this(bun, patty, cheese);
        this.tomato = tomato;
    }
}
