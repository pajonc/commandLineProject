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