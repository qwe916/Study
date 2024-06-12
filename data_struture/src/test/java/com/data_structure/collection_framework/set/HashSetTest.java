package com.data_structure.collection_framework.set;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class HashSetTest {
    @Test
    void hashSet() {
        HashSet<Object> set = new HashSet<>();

        for (int i = 0; i < 10; i++) {
            set.add(i);
        }

        HashSet<Object> set2 = new HashSet<>();

        for (int i = 0; i < 10; i++) {
            set2.add(i);
        }

        Assertions.assertThat(set).isEqualTo(set2);
    }

    @Test
    void linkedHashSet() {
        LinkedHashSet<Object> set = new LinkedHashSet<>();

        for (int i = 0; i < 10; i++) {
            set.add(i);
        }

        LinkedHashSet<Object> set2 = new LinkedHashSet<>();

        for (int i = 0; i < 10; i++) {
            set2.add(i);
        }

        Assertions.assertThat(set).isEqualTo(set2);
    }
}
