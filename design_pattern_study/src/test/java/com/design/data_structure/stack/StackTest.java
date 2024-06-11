package com.design.data_structure.stack;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StackTest {
    @Test
    void stackTest(){
        Stack<Object> stack = new Stack<>();

        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }

        List<Object> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(stack.pop());
        }

        Assertions.assertThat(list).containsExactly(9, 8, 7, 6, 5, 4, 3, 2, 1, 0);
    }
}
