package com.chrzanop.coding.algoexpert.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class DiceThrows {

    // O(d*s*t) time | O(d*t) space - where d is the number of dice, s is the number of sides,
    // and t is the target
    public int diceThrowsAlgo1(int numDice, int numSides, int target) {
        Integer[][] storedResults = new Integer[numDice + 1][target + 1];
        return diceThrowsHelper(numDice, numSides, target, storedResults);
    }

    private int diceThrowsHelper(int numDice, int numSides, int target, Integer[][] storedResults) {
        if (numDice == 0) {
            return target == 0 ? 1 : 0;
        }

        if (storedResults[numDice][target] != null) {
            return storedResults[numDice][target];
        }

        int numWaysToReachTarget = 0;
        for (int currentTarget = Math.max(0, target - numSides); currentTarget < target; currentTarget++) {
            numWaysToReachTarget += diceThrowsHelper(numDice - 1, numSides, currentTarget, storedResults);
        }

        storedResults[numDice][target] = numWaysToReachTarget;

        return numWaysToReachTarget;

    }


    public int diceThrowsAlgo2(int numDice, int numSides, int target) {
        int[][] storedResults = new int[numDice+1][target+1];
        storedResults[0][0] = 1;

        for (int currentNumDice = 1; currentNumDice <= numDice; currentNumDice++) {
            for (int currentTarget = 0; currentTarget <= target; currentTarget++) {
                int numWaysToReachTarget = 0;
                for (int currentNumSides = 1; currentNumSides <= Math.min(currentTarget, numSides) ; currentNumSides++) {
                    numWaysToReachTarget += storedResults[currentNumDice - 1][currentTarget - currentNumSides];
                }
                storedResults[currentNumDice][currentTarget] = numWaysToReachTarget;
            }
        }
        return storedResults[numDice][target];
    }



    public int diceThrowsMine(int numDice, int numSides, int target) {
        Integer[][] storedResults = new Integer[numDice + 1][target + 1];
        return diceThrowsHelperMine(numDice, numSides, target, storedResults);
    }

    private int diceThrowsHelperMine(int numDice, int numSides, int target, Integer[][] storedResults) {
        if (numDice == 0) {
            return target == 0 ? 1 : 0;
        }

        if (storedResults[numDice][target] != null) {
            return storedResults[numDice][target];
        }

        int numWaysToReachTarget = 0;
        for (int side = 1; side <= numSides; side++) {
            if (target - side < 0) continue;
            numWaysToReachTarget += diceThrowsHelperMine(numDice - 1, numSides, target - side, storedResults);
        }

        storedResults[numDice][target] = numWaysToReachTarget;

        return numWaysToReachTarget;

    }


    //   space  where n - numSides, m - numDice
    public int diceThrows(int numDice, int numSides, int target) {
        List<Integer> numSidesList = new ArrayList<>();
        int i = 0;
        while (i < numSides) {
            numSidesList.add(i + 1);
            i++;
        }
        ArrayList<List<Integer>> perms = new ArrayList<>();
        backTrack(numDice, numSidesList, target, perms, new ArrayList<>());

        return perms.size();
    }

    void backTrack(int numDice, List<Integer> numSidesList, int target, List<List<Integer>> perms, List<Integer> currentPerm) {

        if (currentPerm.size() == numDice) {
            int localTarget = currentPerm.stream().mapToInt(Integer::intValue).sum();
            List<Integer> newPerm = new ArrayList<>(currentPerm);
            if (localTarget == target) {
                perms.add(newPerm);
            }
            return;
        }

        for (int i = 0; i < numSidesList.size(); i++) {
            Integer value = numSidesList.get(i);
            currentPerm.add(value);
            backTrack(numDice, numSidesList, target, perms, currentPerm);
            currentPerm.remove(value);
        }

    }

}
