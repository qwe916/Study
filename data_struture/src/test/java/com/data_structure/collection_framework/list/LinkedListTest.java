package com.data_structure.collection_framework.list;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.assertj.core.api.Assertions.*;

public class LinkedListTest {
    @Test
    void linkedList() {
        LinkedList<Object> list = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        LinkedList<Object> list2 = new LinkedList<>(list);

        assertThat(list).isEqualTo(list2);
    }

    @Test
    void linkedListQueue() {
        LinkedList<Object> list = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            list.offer(i);
        }

        for (int i = 0; i < 10; i++) {
            assertThat(list.poll()).isEqualTo(i);
        }
    }

    @Test
    void linkedListStack() {
        LinkedList<Object> list = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            list.push(i);
        }

        for (int i = 0; i < 10; i++) {
            assertThat(list.pop()).isEqualTo(9 - i);
        }
    }

    @Test
    void linkedListDeque() {
        LinkedList<Object> list = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            list.offerFirst(i);
        }

        for (int i = 0; i < 10; i++) {
            assertThat(list.pollFirst()).isEqualTo(9 - i);
        }
    }
}
