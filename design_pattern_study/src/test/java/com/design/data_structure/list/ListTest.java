package com.design.data_structure.list;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ListTest {
    @Test
    void listTest(){
        ArrayList<Object> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        ArrayList<Object> list2 = new ArrayList<>(list);

        Assertions.assertThat(list).isEqualTo(list2);
    }
}
