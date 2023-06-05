package com.chrzanop.coding.algoexpert.recursion;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BlackjackProbabilityTest {

    @Test
    public void TestCase1() {
        int target = 21;
        int startingHand = 15;
        float expected = 0.45f;
        float actual = new BlackjackProbability().blackjackProbability(target, startingHand);
        assertTrue(expected == actual);
    }

}