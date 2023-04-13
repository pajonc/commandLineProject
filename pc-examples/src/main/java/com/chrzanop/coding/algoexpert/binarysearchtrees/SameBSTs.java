package com.chrzanop.coding.algoexpert.binarysearchtrees;

import java.util.ArrayList;
import java.util.List;

public class SameBSTs {


    // O(n^2) time | O(d) space - where n is the number of nodes in each array and d is the depth of the
    // BST that they represent
    public static boolean sameBstsAlgo2(List<Integer> arrayOne, List<Integer> arrayTwo) {
        return sameBstsAlgo2(arrayOne, arrayTwo, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);

    }

    public static boolean sameBstsAlgo2(List<Integer> arrayOne, List<Integer> arrayTwo, int rootIdxOne, int rootIdxTwo, int minVal, int maxVal) {
        // situation when there is no nodes for current root element
        if (rootIdxOne == -1 || rootIdxTwo == -1) return rootIdxOne == rootIdxTwo;

        // if root nodes differs return false (not same BSTs)
        if (arrayOne.get(rootIdxOne).intValue() != arrayTwo.get(rootIdxTwo).intValue()) {
            return false;
        }

        int leftRootIdxOne = getIdxOfFirstSmaller(arrayOne, rootIdxOne, minVal);
        int leftRootIdxTwo = getIdxOfFirstSmaller(arrayTwo, rootIdxTwo, minVal);
        int rightRootIdxOne = getIdxOfFirstBiggerOrGreater(arrayOne, rootIdxOne, maxVal);
        int rightRootIdxTwo = getIdxOfFirstBiggerOrGreater(arrayTwo, rootIdxTwo, maxVal);

        int current = arrayOne.get(rootIdxOne);

        boolean leftAreSame = sameBstsAlgo2(arrayOne, arrayTwo, leftRootIdxOne, leftRootIdxTwo, minVal, current);
        boolean rightAreSame = sameBstsAlgo2(arrayOne, arrayTwo, rightRootIdxOne, rightRootIdxTwo, current, maxVal);

        return leftAreSame && rightAreSame;

    }

    private static int getIdxOfFirstSmaller(List<Integer> array, int staringIdx, int minVal) {
        int currentValue = array.get(staringIdx).intValue();
        for (int i = staringIdx + 1; i < array.size(); i++) {
            if (array.get(i).intValue() < currentValue && array.get(i).intValue() >= minVal)
                return i;
        }
        return -1;
    }

    private static int getIdxOfFirstBiggerOrGreater(List<Integer> array, int staringIdx, int maxVal) {
        int currentValue = array.get(staringIdx).intValue();
        for (int i = staringIdx + 1; i < array.size(); i++) {
            if (array.get(i).intValue() >= currentValue && array.get(i).intValue() < maxVal)
                return i;
        }
        return -1;
    }


    // O(n^2) time | O(n^2) space
    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
        // different arrays means not same BSTs (in other words different nodes structure)
        if (arrayOne.size() != arrayTwo.size()) {
            return false;
        }

        // if no child nodes then both arrays should have same situation to meet same BSTs assumption,
        // otherwise not same BSTs
        if (arrayOne.size() == 0 && arrayTwo.size() == 0) {
            return true;
        }

        // root nodes should be same to meet same BSTs check
        if (arrayOne.get(0).intValue() != arrayTwo.get(0).intValue()) {
            return false;
        }

//        // left
//        int root = arrayOne.get(0);
//        int i = 1;
//        List<Integer> leftArrayOne = new ArrayList<>();
//        List<Integer> rightArrayOne = new ArrayList<>();
//        while (i < arrayOne.size()) {
//            if (arrayOne.get(i) < root) {
//                leftArrayOne.add(arrayOne.get(i));
//            } else {
//                rightArrayOne.add(arrayOne.get(i));
//            }
//            i++;
//        }
//        i = 1;
//        // right
//        List<Integer> leftArrayTwo = new ArrayList<>();
//        List<Integer> rightArrayTwo = new ArrayList<>();
//        while (i < arrayTwo.size()) {
//            if (arrayTwo.get(i) < root) {
//                leftArrayTwo.add(arrayTwo.get(i));
//            } else {
//                rightArrayTwo.add(arrayTwo.get(i));
//            }
//            i++;
//        }

        List<Integer> leftOne = getSmaller(arrayOne);
        List<Integer> leftTwo = getSmaller(arrayTwo);
        List<Integer> rightOne = getBiggerOrEqual(arrayOne);
        List<Integer> rightTwo = getBiggerOrEqual(arrayTwo);

        boolean left = sameBsts(leftOne, leftTwo);
        boolean right = sameBsts(rightOne, rightTwo);

        return left & right;

    }

    private static List<Integer> getSmaller(List<Integer> array) {
        List<Integer> smaller = new ArrayList<>();
        for (int i = 1; i < array.size(); i++) {
            if (array.get(i).intValue() < array.get(0).intValue()) {
                smaller.add(array.get(i));
            }
        }
        return smaller;
    }

    private static List<Integer> getBiggerOrEqual(List<Integer> array) {
        List<Integer> biggerOrEqual = new ArrayList<>();
        for (int i = 1; i < array.size(); i++) {
            if (array.get(i).intValue() >= array.get(0).intValue()) {
                biggerOrEqual.add(array.get(i));
            }
        }
        return biggerOrEqual;
    }

}

