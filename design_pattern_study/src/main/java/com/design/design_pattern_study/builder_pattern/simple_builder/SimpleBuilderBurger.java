package com.design.design_pattern_study.builder_pattern.simple_builder;

public class SimpleBuilderBurger {
    private int bun;
    private int patty;
    private boolean cheese;
    private boolean tomato;

    public SimpleBuilderBurger(int bun, int patty, boolean cheese, boolean tomato) {
        this.bun = bun;
        this.patty = patty;
        this.cheese = cheese;
        this.tomato = tomato;
    }

    public static SimpleBuilderBurger.Builder builder() {
        return new SimpleBuilderBurger.Builder();
    }

    public static class Builder {
        private int bun;
        private int patty;
        private boolean cheese;
        private boolean tomato;

        public Builder bun(int bun) {
            this.bun = bun;
            return this;
        }

        public Builder patty(int patty) {
            this.patty = patty;
            return this;
        }

        public Builder cheese(boolean cheese) {
            this.cheese = cheese;
            return this;
        }

        public Builder tomato(boolean tomato) {
            this.tomato = tomato;
            return this;
        }

        public SimpleBuilderBurger build() {
            return new SimpleBuilderBurger(bun, patty, cheese, tomato);
        }
    }
}
