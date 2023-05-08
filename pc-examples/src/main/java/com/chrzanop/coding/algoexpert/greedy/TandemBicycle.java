package com.chrzanop.coding.algoexpert.greedy;

import java.util.Arrays;

public class TandemBicycle {

    // O(nlog(n)) time | O(1) space - where n is the number of tandem bicycles
    public int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
        Arrays.sort(redShirtSpeeds);
        Arrays.sort(blueShirtSpeeds);
        if (!fastest) {
            reverseArrayInPlace(redShirtSpeeds);
        }

        int totalSpeed = 0;

        for (int i = 0; i < redShirtSpeeds.length; i++) {
            int rider1 = redShirtSpeeds[i];
            int rider2 = blueShirtSpeeds[blueShirtSpeeds.length - i - 1];
            totalSpeed += Math.max(rider1, rider2);
        }

        return totalSpeed;
    }

    public int tandemBicycle_Mine(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
        Arrays.sort(redShirtSpeeds);
        Arrays.sort(blueShirtSpeeds);

        int totalSpeed = 0;
        if (fastest) {
            int i = redShirtSpeeds.length - 1;
            int j = 0;
            while (i >= 0) {
                totalSpeed = totalSpeed + Math.max(redShirtSpeeds[i], blueShirtSpeeds[j]);
                i--;
                j++;
            }
        } else {
            int i = 0;
            int j = 0;
            while (i < redShirtSpeeds.length) {
                totalSpeed = totalSpeed + Math.max(redShirtSpeeds[i], blueShirtSpeeds[j]);
                i++;
                j++;
            }

        }

        return totalSpeed;
    }


    private void reverseArrayInPlace(int[] array) {
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start += 1;
            end -= 1;
        }
    }

}
