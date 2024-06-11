package com.data_structure.deque;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;

public class DequeTest {
    @Test
    void dequeTest() {
        Deque<Object> objects = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            objects.offerFirst(i);
        }

        for (int i = 0; i < 10; i++) {
            Assertions.assertThat(objects.pollFirst()).isEqualTo(9 - i);
        }
    }
}
