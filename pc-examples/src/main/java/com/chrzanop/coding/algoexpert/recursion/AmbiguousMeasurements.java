package com.chrzanop.coding.algoexpert.recursion;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class AmbiguousMeasurements {


    @Test
    public void shouldPassTestCase() {
        int[][] cups = new int[][]{{200, 210}, {450, 465}, {800, 850}};
        int low = 2100;
        int high = 2300;
        boolean expected = true;
        boolean actual = ambiguousMeasurementsMine(cups, low, high);
        assertTrue(expected == actual);
    }


    public static boolean ambiguousMeasurements(int[][] measuringCups, int low, int high) {

        Map<String, Boolean> memoize = new HashMap<>();
        return ambiguousMeasurements(measuringCups, low, high, memoize);

    }

    /**
     * Decresing low and high (similar to emptying big Cup) and looking if cups will finally match the recursive condition
     * where base condition is in this case responsible for interrupt of tree traversal
     * @param measuringCups
     * @param low
     * @param high
     * @param memoize
     * @return
     */
    private static boolean ambiguousMeasurements(int[][] measuringCups, int low, int high, Map<String, Boolean> memoize) {

        String key = buildKey(low, high);
        if(memoize.containsKey(key)) {
            return memoize.get(key);
        }

        if(low < 0 & high <0) {
            return false;
        }

        boolean isValid = false;
        for (int i = 0; i < measuringCups.length; i++) {
            int cupLow = measuringCups[i][0];
            int cupHigh = measuringCups[i][1];

            if (cupLow>= low && cupHigh<=high) {
                isValid = true;
                break;
            }

            int newLow = low - cupLow;
            int newHigh = high - cupHigh;

            isValid = ambiguousMeasurements(measuringCups, newLow, newHigh, memoize);
            if(isValid) {
                break;
            }
        }

        if(!isValid) {
            memoize.put(buildKey(low, high), false);
        }

        return isValid;
    }


    private static String buildKey(int low, int high) {
        return low + "-" + high;
    }


    /**
     * Filling up to target low and high from bottom of targeted CUP
     * @param measuringCups
     * @param low
     * @param high
     * @return
     */

    public static boolean ambiguousMeasurementsMine(int[][] measuringCups, int low, int high) {

        Map<String, Boolean> memoize = new HashMap<>();

        return ambiguousMeasurementsMine(measuringCups, low, high, 0, 0, memoize);

    }

    private static boolean ambiguousMeasurementsMine(int[][] measuringCups, int low, int high, int cupLow, int cupHigh, Map<String, Boolean> memoize) {

        String key = buildKey(low, high);
        if(memoize.containsKey(key)) {
            return memoize.get(key);
        }

        if (cupLow >= low && cupHigh > high) {
            return false;
        }

        boolean isValid = false;
        for (int[] cups : measuringCups) {

            if (cupLow >= low && cupHigh <= high) {
                isValid = true;
                break;
            }

            int cupLowNew = cupLow + cups[0];
            int cupHighNew = cupHigh + cups[1];

            isValid = ambiguousMeasurementsMine(measuringCups, low, high, cupLowNew, cupHighNew, memoize);
            if (isValid) {
                break;
            }
        }

        memoize.put(buildKey(cupLow, cupHigh), false);

        return isValid;
    }



}
