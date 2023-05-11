package com.chrzanop.coding.algoexpert.stacks;

import org.junit.Test;

import static com.chrzanop.coding.algoexpert.stacks.BalancedBrackets.balancedBrackets;
import static org.junit.jupiter.api.Assertions.*;

public class BalancedBracketsTest {

    @Test
    public void TestCase1() {
        String input = "([])(){}(())()()";
        assertTrue(balancedBrackets(input));
    }

}