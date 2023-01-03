package com.chrzanop.coding.algoexpert.recursion;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class NthFibonacciNumber {

    public static void main(String[] args) {
        assertTrue(getNthFib(6) == 5);
        assertTrue(getNthFib(6, new HashMap<Integer, Integer>() {{
            put(1, 0);
            put(2, 1);
        }}) == 5);
        assertTrue(getNthFibLoop(6) == 5);
    }


    //O(2^n) time | O(n) space for frames on stack
    public static int getNthFib(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        return getNthFib(n - 1) + getNthFib(n - 2);
    }

    //O(n) time | O(n) space - memoize
    public static int getNthFib(int n, Map<Integer, Integer> memoize) {
        if (memoize.containsKey(n)) {
            return memoize.get(n);
        } else {
            memoize.put(n, getNthFib(n - 1, memoize) + getNthFib(n - 2, memoize));
            return memoize.get(n);
        }
    }

    //O(n) time | O(1) space - dynamic programming
    public static int getNthFibLoop(int n) {
        int[] lastTwo = {0, 1};
        int counter = 3;
        while (counter <= n) {
            int lastFib = lastTwo[0] + lastTwo[1];
            lastTwo[0] = lastTwo[1];
            lastTwo[1] = lastFib;
            counter++;
        }
        return n > 1 ? lastTwo[1] : lastTwo[0];
    }


}
