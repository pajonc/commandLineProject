package com.chrzanop.coding.algoexpert.dynamicprogramming;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MaxSumIncreasingSubsequenceTest {

    @Test
    public void TestCase1() {
        int[] input = {10, 70, 20, 30, 50, 11, 30};
        int[][] expected = {{110}, {10, 20, 30, 50}};
        List<List<Integer>> lists = MaxSumIncreasingSubsequence.maxSumIncreasingSubsequence(input);
        assertTrue( compare(lists, expected));
    }

    @Test
    public void TestCase2() {
        int[] input = {1};
        int[][] expected = {{1}, {1}};
        List<List<Integer>> lists = MaxSumIncreasingSubsequence.maxSumIncreasingSubsequence(input);
        assertTrue( compare(lists, expected));
    }

    @Test
    public void TestCase3() {
        int[] input = {-1,1};
        int[][] expected = {{1}, {1}};
        List<List<Integer>> lists = MaxSumIncreasingSubsequence.maxSumIncreasingSubsequence(input);
        assertTrue( compare(lists, expected));
    }

    @Test
    public void TestCase4() {
        int[] input = {8, 12, 2, 3, 15, 5, 7};
        int[][] expected = {{35}, {8,12,15}};
        List<List<Integer>> lists = MaxSumIncreasingSubsequence.maxSumIncreasingSubsequence(input);
        assertTrue( compare(lists, expected));
    }

    @Test
    public void TestCase5() {
        int[] input = {10, 15, 4, 5, 11, 14, 31, 25, 31, 23, 25, 31, 50};
        int[][] expected = {{164}, {10, 11, 14, 23, 25, 31, 50}};
        List<List<Integer>> lists = MaxSumIncreasingSubsequence.maxSumIncreasingSubsequence(input);
        assertTrue( compare(lists, expected));
    }

    public static boolean compare(List<List<Integer>> arr1, int[][] arr2) {
        if (arr1.get(0).get(0) != arr2[0][0]) {
            return false;
        }
        for (int i = 0; i < arr1.get(1).size(); i++) {
            if (arr1.get(1).get(i) != arr2[1][i]) {
                return false;
            }
        }
        return true;
    }

}