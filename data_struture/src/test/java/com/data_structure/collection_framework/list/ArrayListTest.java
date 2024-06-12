package com.data_structure.collection_framework.list;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;

public class ArrayListTest {
    @Test
    void ArrayList() {
        ArrayList<Object> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        ArrayList<Object> list2 = new java.util.ArrayList<>(list);

        assertThat(list).isEqualTo(list2);
    }
}
