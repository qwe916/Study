package com.data_structure.collection_framework.set;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetTest {
    @Test
    void treeSet() {
        TreeSet<Object> set = new TreeSet<>((o1, o2) -> o2.hashCode() - o1.hashCode());

        for (int i = 0; i < 10; i++) {
            set.add(i);
        }

        set.iterator().forEachRemaining(System.out::println);
    }
}
