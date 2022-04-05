package com.chrzanop.datastructure;

public class MergeSortedArrays {


    public static void main(String[] args) {
        int[] nums1 = {4, 7, 20, 100};
        int[] nums2 = {9, 13, 103};
        final int[] merge = merge(nums1, nums2);
        System.out.println(merge);
        System.out.println(mediana(merge));
        System.out.println(mediana(nums1));
    }


    public static int mediana(int[] sortedArray) {
        if (sortedArray.length == 0) {
            throw new RuntimeException("Array is empty");
        }

        if (sortedArray.length == 1) {
            return sortedArray[0];
        }
        if (sortedArray.length == 2) {
            return (sortedArray[0] + sortedArray[1]) / 2;
        }

        if (sortedArray.length % 2 > 0) {
            int half = (sortedArray.length - 1) / 2;
            return sortedArray[half];
        } else {
            int half = sortedArray.length / 2;
            return (sortedArray[half - 1 ] + sortedArray[half]) / 2;
        }

    }


    public static int[] merge(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        if (nums1.length == 0) {
            return nums2;
        } else if (nums2.length == 0) {
            return nums1;
        } else {
            int j = 0, k = 0;
            for (int i = 0; i < nums.length; i++) {
                if (j < nums1.length && k < nums2.length) {
                    if (nums1[j] < nums2[k]) {
                        nums[i] = nums1[j];
                        j++;
                    } else {
                        nums[i] = nums2[k];
                        k++;
                    }
                } else if (j < nums1.length) {
                    nums[i] = nums1[j];
                    j++;
                } else if (k < nums2.length) {
                    nums[i] = nums2[k];
                    k++;
                }
            }
        }
        return nums;
    }

}
