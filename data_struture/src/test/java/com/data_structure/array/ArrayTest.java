package com.data_structure.array;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayTest {
    @Test
    void arrayTest() {
        int[] array = new int[5];

        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        int[] array2 = {1, 2, 3, 4, 5};

        Assertions.assertThat(array).isEqualTo(array2);
    }
}
