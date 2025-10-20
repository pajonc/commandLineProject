package com.chrzanop.coding.algoexpert.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiceThrowsTest {


    @Test
    public void TestCase1() {
        var numDice = 2;
        var numSides = 6;
        var target = 7;
        var expected = 6;
        var actual = new DiceThrows().diceThrows(numDice, numSides, target);
        assertTrue(expected == actual);
    }

    @Test
    public void TestCase2() {
        var numDice = 2;
        var numSides = 3;
        var target = 4;
        var expected = 3;
        var actual = new DiceThrows().diceThrows(numDice, numSides, target);
        assertTrue(expected == actual);
    }

    @Test
    public void TestCase3() {
        var numDice = 2;
        var numSides = 3;
        var target = 4;
        var expected = 3;
        var actual = new DiceThrows().diceThrowsAlgo1(numDice, numSides, target);
        assertTrue(expected == actual);
    }

    @Test
    public void TestCase3_1() {
        var numDice = 2;
        var numSides = 3;
        var target = 4;
        var expected = 3;
        var actual = new DiceThrows().diceThrowsAlgo2(numDice, numSides, target);
        assertTrue(expected == actual);
    }

    @Test
    public void TestCase4() {
        var numDice = 3;
        var numSides = 6;
        var target = 3;
        var expected = 1;
        var actual = new DiceThrows().diceThrowsAlgo1(numDice, numSides, target);
        assertTrue(expected == actual);
    }


    @Test
    public void TestCase5() {
        var numDice = 3;
        var numSides = 4;
        var target = 3;
        var expected = 1;
        var actual = new DiceThrows().diceThrowsMine(numDice, numSides, target);
        assertTrue(expected == actual);
    }

    @Test
    public void TestCase6() {
        var numDice = 2;
        var numSides = 6;
        var target = 7;
        var expected = 6;
        var actual = new DiceThrows().diceThrowsMine(numDice, numSides, target);
        assertTrue(expected == actual);
    }

    @Test
    public void TestCase7() {
        var numDice = 3;
        var numSides = 6;
        var target = 5;
        var expected = 6;
        var actual = new DiceThrows().diceThrowsMine(numDice, numSides, target);
        assertTrue(expected == actual);
    }

}