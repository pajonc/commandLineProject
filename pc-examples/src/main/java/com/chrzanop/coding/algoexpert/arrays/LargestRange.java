package com.chrzanop.coding.algoexpert.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LargestRange {


    public static void main(String[] args) {
        int[] range = largestRange3(new int[]{1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6});
        System.out.println(range[0] + " " + range[1]);

        int[] range2 = largestRange3(new int[]{7, 8});
        System.out.println(range2[0] + " " + range2[1]);

        int[] range3 = largestRange3(new int[]{1});
        System.out.println(range3[0] + " " + range3[1]);
    }


//    // O(nlogn) time | O(1) space -
//    public static int[] largestRange(int[] array) {
//        Arrays.sort(array);
//        int max = 0;
//        int[] range = new int[2];
//        int i = 0;
//
//        while (i < array.length) {
//            int current = array[i];
//            int j = i + 1;
//            while (j < array.length) {
//                if (array[j] == current + 1) {
//                    current = array[j];
//                    j++;
//                } else {
//                    break;
//                }
//            }
//            int currentDiff = j - i - 1;
//            if (currentDiff > max) {
//                max = currentDiff;
//                range = new int[]{array[i], array[j - 1]};
//            }
//            i = j;
//        }
//
//        return range;
//    }

    // O(n) time | O(n) space
    public static int[] largestRange2(int[] array) {

        int[] range = new int[2];
        Map<Integer, Boolean> valueToVisited = new HashMap<>(array.length);

        for (int i = 0; i < array.length; i++) {
            valueToVisited.put(array[i], false);
        }
        int longestRange = 0;

        for (int i = 0; i < array.length; i++) {

            valueToVisited.put(array[i], true);
            int counter = 1;
            int currentLeft = array[i]-1;
            int currentRight = array[i]+1;

            while (valueToVisited.containsKey(currentLeft) && !valueToVisited.get(currentLeft)) {
                valueToVisited.put(currentLeft, true);
                currentLeft--;
                counter++;
            }

            while (valueToVisited.containsKey(currentRight) && !valueToVisited.get(currentRight)) {
                valueToVisited.put(currentRight, true);
                currentRight++;
                counter++;
            }

            if (counter > longestRange) {
                longestRange = counter;
                range = new int[]{currentLeft+1, currentRight-1};
            }

        }


        return range;
    }


    public static int[] largestRange3(int[] array) {

        int[] range = new int[2];
        int longestRange = 0;
        Map<Integer,Boolean> valueToVisited = new HashMap<>(array.length);

        for(int num : array) {
            valueToVisited.put(num, true);
        }


        for(int num : array) {

            if(!valueToVisited.get(num)) {
                continue;
            }

            valueToVisited.put(num, false);

            int currentLength = 1;
            int currentLeft = num -1;
            int currentRight = num + 1;

            while(valueToVisited.containsKey(currentLeft)) {
                valueToVisited.put(currentLeft, false);
                currentLength++;
                currentLeft--;
            }

            while(valueToVisited.containsKey(currentRight)) {
                valueToVisited.put(currentRight, false);
                currentLength++;
                currentRight++;
            }

            if(currentLength>longestRange) {
                longestRange = currentLength;
                range = new int[] {currentLeft+1, currentRight-1};
            }

        }

        return range;
    }


}
