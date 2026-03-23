package com.chrzanop.coding.algoexpert.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidStartingCityTest {

    @Test
    public void TestCase1() {
        int[] distances = new int[] {5, 25, 15, 10, 15};
        int[] fuel = new int[] {1, 2, 1, 0, 3};
        int mpg = 10;
        int expected = 4;
        var actual = new ValidStartingCity().validStartingCity(distances, fuel, mpg);
        assertTrue(expected == actual);
    }

    @Test
    public void TestCase2() {
        int[] distances = new int[] {5, 2, 3};
        int[] fuel = new int[] {1,0,1};
        int mpg = 5;
        int expected = 2;
        var actual = new ValidStartingCity().validStartingCity(distances, fuel, mpg);
        assertTrue(expected == actual);
    }

    @Test
    public void TestCase1Algo() {
        int[] distances = new int[] {5, 25, 15, 10, 15};
        int[] fuel = new int[] {1, 2, 1, 0, 3};
        int mpg = 10;
        int expected = 4;
        var actual = new ValidStartingCity().validStartingCityAlgo(distances, fuel, mpg);
        assertTrue(expected == actual);
    }

    @Test
    public void TestCaseN() {
        int[] distances = new int[] {5, 25, 15, 10, 15};
        int[] fuel = new int[] {1, 2, 1, 0, 3};
        int mpg = 10;
        int expected = 4;
        var actual = new ValidStartingCity().validStartingCityAlgoN(distances, fuel, mpg);
        assertTrue(expected == actual);
    }

}