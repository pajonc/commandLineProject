package com.chrzanop.coding.algoexpert.tries;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MultiStringSearchTest {

    @Test
    public void TestCase1() {
        boolean[] expected = {true, false, true, true, false, true, false};
        List<Boolean> output = MultiStringSearch.multiStringSearch(
                "this is a big string",
                new String[] {"this", "yo", "is", "a", "bigger", "string", "kappa"}

        );
        assertTrue(compare(output, expected));

        boolean[] expected2 = {true, true, false, true, true, false};
        List<Boolean> output2 = MultiStringSearch.multiStringSearch(
        "abcdefghijklmnopqrstuvwxyz",
                new String[] {"abc", "mnopqr", "wyz", "no", "e", "tuuv"}
                );
        assertTrue(compare(output2, expected2));
    }

    @Test
    public void TestCase1Complex() {
        boolean[] expected = {true, false, true, true, false, true, false};
        List<Boolean> output = MultiStringSearch.multiStringSearchComplex(
                "this is a big string",
                new String[] {"this", "yo", "is", "a", "bigger", "string", "kappa"}
        );
        assertTrue(compare(output, expected));

        boolean[] expected2 = {false};
        List<Boolean> output2 = MultiStringSearch.multiStringSearchComplex(
                "abcdefghijklmnopqrstuvwxyz",
                new String[] { "tuuv"}
        );
        assertTrue(compare(output2, expected2));
    }

    @Test
    public void TestCase1Algo() {
        boolean[] expected = {true, false, true, true, false, true, false};
        List<Boolean> output = MultiStringSearch.multiStringSearchComplexAlgo(
                "this is a big string",
                new String[] {"this", "yo", "is", "a", "bigger", "string", "kappa"}
        );
        assertTrue(compare(output, expected));

        boolean[] expected2 = {true, true, false, true, true, false};
        List<Boolean> output2 = MultiStringSearch.multiStringSearchComplexAlgo(
                "abcdefghijklmnopqrstuvwxyz",
                new String[] {"abc", "mnopqr", "wyz", "no", "e", "tuuv"}
        );
        assertTrue(compare(output2, expected2));
    }

    public boolean compare(List<Boolean> arr1, boolean[] arr2) {
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