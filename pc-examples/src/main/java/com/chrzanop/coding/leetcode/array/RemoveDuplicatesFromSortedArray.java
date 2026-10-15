package com.chrzanop.coding.leetcode.array;

public class RemoveDuplicatesFromSortedArray {


    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();

        removeDuplicatesFromSortedArray.removeDuplicatesMine(new int[]{1,1,2});

        System.out.println(removeDuplicatesFromSortedArray.removeDuplicates(new int[]{1,1,2}));
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[k - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    public int removeDuplicatesMine(int[] nums) {

        int[] expectedNums = new int[nums.length];

        int k = removeDuplicatesLogic(nums, expectedNums);

        System.out.println(k);

        return k;

    }

    int removeDuplicatesLogic(int[] nums, int[] expectedNums) {

        int j=0;
        expectedNums[0] = nums[0];
        for(int i=1; i<nums.length;i++) {
            if(nums[i] != expectedNums[j]) {
                j=j+1;
                expectedNums[j] = nums[i];
            }
        }

        return j+1;
    }
}
