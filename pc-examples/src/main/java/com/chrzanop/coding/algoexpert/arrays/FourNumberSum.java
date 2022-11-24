package com.chrzanop.coding.algoexpert.arrays;

import java.util.*;

import static org.junit.Assert.assertTrue;

public class FourNumberSum {


    public List<Integer[]> fourNumberSum(int[] array, int targetSum) {

        List<Integer[]> quadruplets = new ArrayList<Integer[]>();
        Map<Integer, List<Integer[]>> allPairSums = new HashMap<>();

        for (int i = 1; i < array.length - 1; i++) {
            // right check
            for (int j = i + 1; j < array.length; j++) {
                int currentSum = array[i] + array[j];
                int difference = targetSum - currentSum;
                if (allPairSums.containsKey(difference)) {
                    for (Integer[] pair : allPairSums.get(difference)) {
                        Integer[] newQuadruplet = {array[i], array[j], pair[0], pair[1]};
                        quadruplets.add(newQuadruplet);
                    }
                }
            }
            // left fullfill
            for (int j = 0; j < i; j++) {
                int currentSum = array[j] + array[i];
                Integer[] pair = {array[j], array[i]};
                if (!allPairSums.containsKey(currentSum)) {
                    List<Integer[]> pairGroup = new ArrayList<Integer[]>();
                    pairGroup.add(pair);
                    allPairSums.put(currentSum, pairGroup);
                } else {
                    allPairSums.get(currentSum).add(pair);
                }

            }


        }


        return quadruplets;
    }
}
