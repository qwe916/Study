package com.data_structure.collection_framework.map;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HashMapTest {
    @Test
    void hashMap() {
        HashMap<Object, Object> map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            map.put(i, i);
        }

        HashMap<Object, Object> map2 = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            map2.put(i, i);
        }

        assertThat(map).isEqualTo(map2);
    }

    @Test
    void linkedHashMap(){
        LinkedHashMap<Object, Object> map = new LinkedHashMap<>();

        for (int i = 0; i < 10; i++) {
            map.put(i, i);
        }

        LinkedHashMap<Object, Object> map2 = new LinkedHashMap<>();

        for (int i = 0; i < 10; i++) {
            map2.put(i, i);
        }

        assertThat(map).isEqualTo(map2);
    }
}
