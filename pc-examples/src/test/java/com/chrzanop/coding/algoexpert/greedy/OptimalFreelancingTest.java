package com.chrzanop.coding.algoexpert.greedy;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class OptimalFreelancingTest {

    @Test
    public void TestCase1() {
        HashMap[] input = new HashMap[1];
        HashMap<String, Integer> job = new HashMap<String, Integer>();
        job.put("deadline", 1);
        job.put("payment", 1);
        input[0] = job;
        int expected = 1;
        int actual = new OptimalFreelancing().optimalFreelancing(input);
        assertTrue(expected == actual);
    }

}