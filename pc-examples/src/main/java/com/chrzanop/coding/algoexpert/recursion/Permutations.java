package com.chrzanop.coding.algoexpert.recursion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class Permutations {

    public static void main(String[] args) {
        for (int i = 0; i < 2 ; i++) {
            System.out.println("i: " +i );
        }
    }


    @Test
    public void TestCase1() {

        List<List<Integer>> perms = getPermutationsSecondApproach(Arrays.asList(1, 2, 3));
        assertTrue(perms.size() == 6);
        assertTrue(contains(perms, new ArrayList<Integer>(Arrays.asList(1, 2, 3))));
        assertTrue(contains(perms, new ArrayList<Integer>(Arrays.asList(1, 3, 2))));
        assertTrue(contains(perms, new ArrayList<Integer>(Arrays.asList(2, 1, 3))));
        assertTrue(contains(perms, new ArrayList<Integer>(Arrays.asList(2, 3, 1))));
        assertTrue(contains(perms, new ArrayList<Integer>(Arrays.asList(3, 1, 2))));
        assertTrue(contains(perms, new ArrayList<Integer>(Arrays.asList(3, 2, 1))));
    }

    public boolean contains(List<List<Integer>> arr1, List<Integer> arr2) {
        for (List<Integer> subArray : arr1) {
            if (subArray.equals(arr2)) {
                return true;
            }
        }
        return false;
    }



    // O(n^2*n!) time | O(n*n!) space
    public static List<List<Integer>> getPermutations(List<Integer> array) {
        List<List<Integer>> permutations = new ArrayList<List<Integer>>();
        getPermutations(array, new ArrayList<Integer>(), permutations);
        return permutations;
    }

    private static void getPermutations(List<Integer> array, List<Integer> currentPermutation, List<List<Integer>> permutations) {

        if(array.size() == 0 && currentPermutation.size()>0) {
            permutations.add(currentPermutation);
        } else {
            for (int i = 0; i < array.size() ; i++) {
                List<Integer> newArray = new ArrayList<>(array);
                newArray.remove(i);
                List<Integer> newPermutation = new ArrayList<>(currentPermutation);
                newPermutation.add(array.get(i));
                getPermutations(newArray, newPermutation, permutations);
            }
        }

    }


    public static List<List<Integer>> getPermutationsSecondApproach(List<Integer> nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.size()];
        getPermutationsSecondApproach(nums, result, used, new ArrayList<Integer>());
        return result;
    }

    private static void getPermutationsSecondApproach(List<Integer> nums, List<List<Integer>> result, boolean[] used, List<Integer> currentPermutation) {
        if(currentPermutation.size() == nums.size()) {
            result.add(currentPermutation);
            return;
        }

        for (int i=0; i < nums.size(); i++) {
            if(used[i]) {
                continue;
            }
            used[i] = true;
            List<Integer> newPermutation = new ArrayList<>(currentPermutation);
            newPermutation.add(nums.get(i));
            getPermutationsSecondApproach(nums, result, used, newPermutation);
            used[i] = false;
        }

    }




    public static List<List<Integer>> getPermutationsX(List<Integer> arr) {
        List<List<Integer>> result = new ArrayList<>();
        if(arr.size() == 0) {
            return result;
        }
        backTrack(arr, new ArrayList<Integer>(), result);
        return result;
    }

    private static void backTrack(List<Integer> arr, ArrayList<Integer> list, List<List<Integer>> result) {
        if(list.size() == arr.size()) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int x: arr) {
            if(list.contains(x)){
                continue;
            }
            list.add(x);
            backTrack(arr, list, result);
            list.remove(list.size()-1);
        }
    }





}
