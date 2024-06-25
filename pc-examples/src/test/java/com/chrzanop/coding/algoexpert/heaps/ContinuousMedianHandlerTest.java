package com.chrzanop.coding.algoexpert.heaps;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContinuousMedianHandlerTest {

    @Test
    void shouldPass() {
       ContinuousMedianHandler handler =
                new ContinuousMedianHandler();
        handler.insert(5);
        handler.insert(10);
        assertTrue(handler.getMedian() == 7.5);
        handler.insert(100);
        assertTrue(handler.getMedian() == 10);
    }

}