package com.chrzanop.coding.algoexpert.arrays;

import org.junit.jupiter.api.Test;

import static com.chrzanop.coding.algoexpert.arrays.MinRewards.minRewards;
import static com.chrzanop.coding.algoexpert.arrays.MinRewards.minRewardsCreative;
import static org.junit.jupiter.api.Assertions.*;

class MinRewardsTest {

    @Test
    void shouldPassMinRewardsNaiveSolution() {
        MinRewards minRewards = new MinRewards();
        int result = minRewards.minRewardsNaiveSolution(new int[]{8, 4, 2, 1, 3, 6, 7, 9, 5});
        assertTrue(result == 25);
    }

    @Test
    void shouldPassMinRewards() {
        int result = minRewards(new int[]{8, 4, 2, 1, 3, 6, 7, 9, 5});
        assertTrue(result == 25);
    }

    @Test
    void shouldPassMinRewardsCreative() {
        int result = minRewardsCreative(new int[]{8, 4, 2, 1, 3, 6, 7, 9, 5});
        assertTrue(result == 25);
    }


}