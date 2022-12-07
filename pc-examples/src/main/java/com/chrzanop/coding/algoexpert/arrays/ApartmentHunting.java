package com.chrzanop.coding.algoexpert.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class ApartmentHunting {

    public static void main(String[] args) {
        List<Map<String, Boolean>> blocks = new ArrayList<Map<String, Boolean>>();

        blocks.add(0, new HashMap<String, Boolean>());
        blocks.get(0).put("gym", false);
        blocks.get(0).put("school", true);
        blocks.get(0).put("store", false);

        blocks.add(1, new HashMap<String, Boolean>());
        blocks.get(1).put("gym", true);
        blocks.get(1).put("school", false);
        blocks.get(1).put("store", false);

        blocks.add(2, new HashMap<String, Boolean>());
        blocks.get(2).put("gym", true);
        blocks.get(2).put("school", true);
        blocks.get(2).put("store", false);

        blocks.add(3, new HashMap<String, Boolean>());
        blocks.get(3).put("gym", false);
        blocks.get(3).put("school", true);
        blocks.get(3).put("store", false);

        blocks.add(4, new HashMap<String, Boolean>());
        blocks.get(4).put("gym", false);
        blocks.get(4).put("school", true);
        blocks.get(4).put("store", true);

        String[] reqs = new String[]{"gym", "school", "store"};
        int actual = apartmentHunting(blocks, reqs);
        assertTrue(actual == 3);
    }


    // O(br) time | O(br) space - where b is the number of blocks and r is the number of
    // requirements
    public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {
        int[][] minDistancesFromBlocks = new int[reqs.length][];

        // O(2*br) time
        for (int i = 0; i < reqs.length; i++) {
            minDistancesFromBlocks[i] = getMinDistances(blocks, reqs[i]);
        }
        // O(br +r) --> O(r(b+1)) time
        int[] maxDistancesAtBlocks = getMaxDistancesAtBlocks(blocks, minDistancesFromBlocks);
        //O(b) time
        return getIdxAtMinValue(maxDistancesAtBlocks);
    }

    // O(2b)
    // calculate min distances for current req
    private static int[] getMinDistances(List<Map<String, Boolean>> blocks, String req) {
        int[] minDistances = new int[blocks.size()];
        int closestReqIdx = Integer.MAX_VALUE;
        // from left to right
        for (int i = 0; i < blocks.size(); i++) {
            if (blocks.get(i).get(req)) {
                closestReqIdx = i;
            }
            minDistances[i] = getDistanceBetween(closestReqIdx, i);
        }
        //from right to left
        for (int i = blocks.size() - 1; i >= 0; i--) {
            if (blocks.get(i).get(req)) {
                closestReqIdx = i;
            }
            minDistances[i] = Math.min(minDistances[i], getDistanceBetween(i, closestReqIdx));
        }
        return minDistances;
    }

    // O(br)
    private static int[] getMaxDistancesAtBlocks(List<Map<String, Boolean>> blocks, int[][] minDistancesFromBlocks) {
        int[] maxDistancesAtBlocks = new int[blocks.size()];
        for (int i = 0; i < blocks.size(); i++) {
            int[] minDistancesAtBlock = new int[minDistancesFromBlocks.length];
            for (int j = 0; j < minDistancesFromBlocks.length; j++) {
                minDistancesAtBlock[j] = minDistancesFromBlocks[j][i];
            }
            maxDistancesAtBlocks[i] = arrayMax(minDistancesAtBlock);
        }
        return maxDistancesAtBlocks;
    }


    private static int getDistanceBetween(int a, int b) {
        return Math.abs(a - b);
    }

    private static int arrayMax(int[] array) {
        int max = array[0];
        for (int a : array) {
            if (a > max) {
                max = a;
            }
        }
        return max;
    }

    private static int getIdxAtMinValue(int[] array) {
        int idxAtMinValue = 0;
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            int currentValue = array[i];
            if (currentValue < minValue) {
                minValue = currentValue;
                idxAtMinValue = i;
            }

        }
        return idxAtMinValue;
    }

    // O(b^2*r) time |  O(b) space
    public static int apartmentHuntingMine(List<Map<String, Boolean>> blocks, String[] reqs) {

        int blocksLength = blocks.size();
        List<Integer> maxDistance = new ArrayList<>(blocksLength);


        for (int i = 0; i < blocksLength; i++) {

            int currentMaxDistance = 0;

            for (String req : reqs) {

                int leastDistance = findLeastDistance(req, i, blocks);
                currentMaxDistance = Math.max(currentMaxDistance, leastDistance);
            }

            maxDistance.add(currentMaxDistance);
        }

        int leastDistanceBlock = Integer.MAX_VALUE;
        int idx = -1;
        int idxLocal = 0;
        for (Integer currentLeast : maxDistance) {

            if (leastDistanceBlock > currentLeast) {
                idx = idxLocal;
                leastDistanceBlock = currentLeast;
            }
            idxLocal++;

        }


        return idx;
    }

    private static int findLeastDistance(String req, int idx, List<Map<String, Boolean>> blocks) {


        if (blocks.get(idx).get(req)) {
            return 0;
        }

        int leastDistance = 0, counterLeft = 1, counterRight = 1;
        boolean countDownLeft = true, countUpRight = true;
        int blocksLength = blocks.size();
        int i = idx - 1;
        int j = idx + 1;

        // check Left
        while (i >= 0 && countDownLeft) {
            if (blocks.get(i).get(req)) {
                countDownLeft = false;
                break;
            }
            i--;
            counterLeft++;
        }
        // check Right
        while (j < blocksLength) {
            if (blocks.get(j).get(req)) {
                countUpRight = false;
                break;
            }
            j++;
            counterRight++;
        }

        if (!countDownLeft && !countUpRight) {
            return Math.min(counterLeft, counterRight);
        }
        if (!countDownLeft && countUpRight) {
            return counterLeft;
        }
        if (countDownLeft && !countUpRight) {
            return counterRight;
        }

        return 0;

    }


}
