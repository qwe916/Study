package com.data_structure.collection_framework.map;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.TreeMap;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.*;

public class TreeMapTest {
    @Test
    void treeMap() {
        TreeMap<Object, Object> map = new TreeMap<>();

        for (int i = 10; i > 0; i--) {
            map.put(i, i);
        }

        map.forEach((k, v) -> System.out.println(k + " : " + v));
    }
}
