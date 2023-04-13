package com.chrzanop.coding.algoexpert.binarysearchtrees;

import java.util.ArrayList;
import java.util.List;

public class SameBSTs {


    // O(n^2) time | O(n^2) space
    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
        if (arrayOne.size() != arrayTwo.size()) {
            return false;
        }

        if (arrayOne.size() == 0 && arrayTwo.size() == 0) {
            return true;
        }

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
        for (int i = 1; i < array.size() ; i++) {
            if(array.get(i).intValue()< array.get(0).intValue()) {
                smaller.add(array.get(i));
            }
        }
        return smaller;
    }

    private static List<Integer> getBiggerOrEqual(List<Integer> array) {
        List<Integer> biggerOrEqual = new ArrayList<>();
        for (int i = 1; i < array.size() ; i++) {
            if(array.get(i).intValue()>= array.get(0).intValue()) {
                biggerOrEqual.add(array.get(i));
            }
        }
        return biggerOrEqual;
    }

}

