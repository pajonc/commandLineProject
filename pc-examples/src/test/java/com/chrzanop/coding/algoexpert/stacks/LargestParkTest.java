package com.chrzanop.coding.algoexpert.stacks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LargestParkTest {

    @Test
    void shouldPassTestCase() {
        LargestPark largestPark = new LargestPark();

        boolean[][] land = {
                {true, true, true, false, true, true},
                {true, true, false, false, true, true},
                {true, true, false, false, true, true},
                {true, true, false, false, true, false},
                {false, true, false, false, false, false},
                {false, false, false, false, false, false}};
        int maxArea = largestPark.largestPark(land);

        System.out.println(maxArea);
    }

}