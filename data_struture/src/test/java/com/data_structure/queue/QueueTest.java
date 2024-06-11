package com.data_structure.queue;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
    @Test
    void queueTest() {
        Queue<Object> queue = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            queue.offer(i);
        }

        for (int i = 0; i < 10; i++) {
            Assertions.assertThat(queue.poll()).isEqualTo(i);
        }
    }
}
