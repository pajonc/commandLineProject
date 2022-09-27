package com.chrzanop.ubs;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AddOneTailTest {


    @Test
    public void shouldTest() {

        AddOneTail addOneTail = new AddOneTail();

        assertArrayEquals(new int[]{1, 3}, addOneTail.addOne(new int[]{1, 2}));
        assertArrayEquals(new int[]{2, 0}, addOneTail.addOne(new int[]{1, 9}));
        assertArrayEquals(new int[]{1, 1, 0, 0, 0}, addOneTail.addOne(new int[]{1, 0, 9, 9, 9}));

    }

}