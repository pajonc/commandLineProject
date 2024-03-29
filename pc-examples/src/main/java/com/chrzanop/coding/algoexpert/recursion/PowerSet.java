package com.chrzanop.coding.algoexpert.recursion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class PowerSet {

    @Test
    public void TestCase1() {
        List<List<Integer>> output = powerset(new ArrayList<Integer>(Arrays.asList(1, 2, 3)));
        assertTrue(output.size() == 8);
        assertTrue(contains(output, new int[]{}));
        assertTrue(contains(output, new int[]{1}));
        assertTrue(contains(output, new int[]{2}));
        assertTrue(contains(output, new int[]{1, 2}));
        assertTrue(contains(output, new int[]{3}));
        assertTrue(contains(output, new int[]{1, 3}));
        assertTrue(contains(output, new int[]{2, 3}));
        assertTrue(contains(output, new int[]{1, 2, 3}));
    }

    // Time and Space --> O(2^n * n)
    public static List<List<Integer>> powerset(List<Integer> array) {

        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<Integer>());

        for (Integer element : array) {
            int length = subsets.size();
            for (int i = 0; i < length; i++) {
                List<Integer> subset = new ArrayList<>(subsets.get(i));
                subset.add(element);
                subsets.add(subset);
            }
        }

        return subsets;
    }


    public static List<List<Integer>> powersetRec(List<Integer> array) {
        return powersetRec(array, array.size()-1);
    }

    private static List<List<Integer>> powersetRec(List<Integer> array, int idx) {
        if(idx<0) {
            List<List<Integer>> emptySet = new ArrayList<List<Integer>>();
            emptySet.add(new ArrayList<Integer>());
            return emptySet;
        }
        int ele = array.get(idx);
        List<List<Integer>> subsets = powersetRec(array, idx -1);
        int length = subsets.size();
        for (int i = 0; i < length; i++) {
            List<Integer> currentSubset = new ArrayList<>(subsets.get(i));
            currentSubset.add(ele);
            subsets.add(currentSubset);
        }
        return subsets;
    }



    boolean contains(List<List<Integer>> arr1, int[] arr2) {
        for (List<Integer> subArr : arr1) {
            Collections.sort(subArr);
            if (compare(subArr, arr2)) {
                return true;
            }
        }
        return false;
    }

    boolean compare(List<Integer> arr1, int[] arr2) {
        if (arr1.size() != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.size(); i++) {
            if (arr1.get(i) != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}
