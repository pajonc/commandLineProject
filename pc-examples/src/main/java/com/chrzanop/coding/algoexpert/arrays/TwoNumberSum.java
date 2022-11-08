package com.chrzanop.coding.algoexpert.arrays;


//@Test
//public void TestCase1() {
//        int[] output = Program.twoNumberSum(new int[] {3, 5, -4, 8, 11, 1, -1, 6}, 10);
//        Utils.assertTrue(output.length == 2);
//        Utils.assertTrue(contains(output, -1));
//        Utils.assertTrue(contains(output, 11));
//        }
//
//public boolean contains(int[] output, int val) {
//
//        for (var el : output) {
//        if (el == val) return true;
//        }
//        return false;
//        }

/*
Input:  array of distinct integers and targetSum
@return 2 dimensional array of two different integers summing up to the target sum
 */


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TwoNumberSum {

    public static void main(String[] args) {

        int[] inputArray = {3, 5, -4, 8, 11, 1, -1, 6};
        int targetSum = 10;
        int[] result = twoNumberSum(inputArray, targetSum);
        int[] result2 = twoNumberSum2(inputArray, targetSum);
        int[] result3 = twoNumberSum3(inputArray, targetSum);

        System.out.println(result[0] + " : " + result[1]);
        System.out.println(result2[0] + " : " + result2[1]);
        System.out.println(result3[0] + " : " + result3[1]);

//             new int[] (3, 5, -4, 8, 11, 1, -1, 6},  10
    }


    /*
    Complexity: O(n^2) time | O(1) space
     */
    public static int[] twoNumberSum(int[] array, int targetSum) {

        int[] result = new int[2];
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i == j) continue;
                if (array[i] + array[j] == targetSum) {
                    return new int[]{array[i], array[j]};
                }
            }
        }
        return new int[0];
    }

    /*
    Complexity: O(n) time | O(n) space
    x + y = targetSum --> y = targetSum -x
    x - value for testing from array
    y - value added to hash set which is previous x
   */
    public static int[] twoNumberSum2(int[] array, int targetSum) {

        Set<Integer> uniqueInts = new HashSet<>();

        for (int i = 0; i < array.length; i++) {
            int x = array[i];
            int y = targetSum - x;
            if (uniqueInts.contains(y)) {
                return new int[]{x, y};
            }
            uniqueInts.add(x);

        }
        return new int[0];
    }

    public static int[] twoNumberSum3(int[] array, int targetSum) {

        Arrays.sort(array);
        int left = 0;
        int right = array.length-1;
        for (int i = 0; i < array.length; i++) {
            int sum = array[left] + array[right];
            if(sum == targetSum) {
                return new int[] {array[left], array[right]};
            } else if (sum<targetSum) {
                left = left + 1;
            } else {
                right = right -1;
            }
        }
        return new int[0];
    }


}
