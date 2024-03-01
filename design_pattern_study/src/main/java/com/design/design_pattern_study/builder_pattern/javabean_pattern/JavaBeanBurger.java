package com.design.design_pattern_study.builder_pattern.javabean_pattern;

public class JavaBeanBurger {
    //필수 인자
    private int bun;
    private int patty;

    //선택적 인자
    private boolean cheese;
    private boolean tomato;

    public JavaBeanBurger() {
    }

    public void setBun(int bun) {
        this.bun = bun;
    }

    public void setPatty(int patty) {
        this.patty = patty;
    }

    public void setCheese(boolean cheese) {
        this.cheese = cheese;
    }

    public void setTomato(boolean tomato) {
        this.tomato = tomato;
    }
}
