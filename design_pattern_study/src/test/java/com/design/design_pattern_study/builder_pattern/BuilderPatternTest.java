package com.design.design_pattern_study.builder_pattern;

import com.design.design_pattern_study.builder_pattern.builder.Burger;
import com.design.design_pattern_study.builder_pattern.builder.BurgerBuilder;
import com.design.design_pattern_study.builder_pattern.javabean_pattern.JavaBeanBurger;
import com.design.design_pattern_study.builder_pattern.simple_builder.SimpleBuilderBurger;
import com.design.design_pattern_study.builder_pattern.telescope.TelescopeBurger;
import org.junit.jupiter.api.Test;

class BuilderPatternTest {
    @Test
    void 점층적_생성자_패턴_테스트(){
        //필수 인자만 전달
        TelescopeBurger telescopeBurger = new TelescopeBurger(1, 2);

        //필수 인자 + 선택적 인자 전달
        TelescopeBurger telescopeBurger1 = new TelescopeBurger(1, 2, true);
    }

    @Test
    void 자바빈_패턴_테스트(){
        JavaBeanBurger javaBeanBurger = new JavaBeanBurger();
        javaBeanBurger.setBun(1);
        javaBeanBurger.setPatty(2);
        javaBeanBurger.setCheese(true);
    }

    @Test
    void 빌더_패턴_테스트(){
        //필수 인자만 전달
        Burger burger = new BurgerBuilder()
                .bun(1)
                .patty(2)
                .build();


        //필수 인자 + 선택적 인자 전달
        Burger burger1 = new BurgerBuilder()
                .bun(1)
                .patty(2)
                .cheese(true)
                .tomato(true)
                .build();
    }

    @Test
    void 심플_빌더_패턴_테스트(){
        SimpleBuilderBurger burger = SimpleBuilderBurger.builder()
                .bun(1)
                .patty(2)
                .cheese(true)
                .tomato(true)
                .build();
    }
}