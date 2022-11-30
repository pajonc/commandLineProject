package com.chrzanop.coding.algoexpert.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinRewardsTest {

    @Test
    void shouldPassMinRewards() {
        MinRewards minRewards = new MinRewards();
        int result = minRewards.minRewards(new int[]{8, 4, 2, 1, 3, 6, 7, 9, 5});
        assertTrue(result == 25);
    }
}