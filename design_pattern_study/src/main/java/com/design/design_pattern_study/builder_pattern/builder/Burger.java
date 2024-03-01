package com.design.design_pattern_study.builder_pattern.builder;

public class Burger {
    //필수 인자
    private int bun;
    private int patty;

    //선택적 인자
    private boolean cheese;
    private boolean tomato;

    public Burger(int bun, int patty, boolean cheese, boolean tomato) {
        this.bun = bun;
        this.patty = patty;
        this.cheese = cheese;
        this.tomato = tomato;
    }
}
