package com.chrzanop.coding.algoexpert.arrays;

public class MajorityElement {

    // not sure about this approach - copied from algoexpert
    // O(n) time | O(1) space - where n is the number of elements in the array
    public int majorityElement(int[] array) {
        int answer = array[0];
        int counter = 0;

        for (int element : array) {
            if (counter == 0) {
                answer = element;
            }

            if (element == answer) {
                counter++;
            } else {
                counter--;
            }
        }
        return answer;
    }

    // O(n^2) time | O(1) space - where n is the number of elements in the array
    public int majorityElement2(int[] array) {
        int maxCount = 0;
        int n = array.length;
        int index = -1; // sentinels
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (array[i] == array[j])
                    count++;
            }

            // update maxCount if count of
            // current element is greater
            if (count > maxCount) {
                maxCount = count;
                index = i;
            }
        }

        // if maxCount is greater than n/2
        // return the corresponding element
        if (maxCount > n / 2)
            return array[index];

        else
            return -1;
    }

    public int majorityElement_Algo2(int[] array) {
        int answer = 0;
        for (int currentBit = 0; currentBit < 32; currentBit++) {
            int currentBitValue = 1 << currentBit;
            int onesCount = 0;
            for (int num : array) {
                if ((num & currentBitValue) != 0) {
                    onesCount++;
                }
            }

            if (onesCount > array.length / 2) {
                answer += currentBitValue;
            }
        }

        return answer;
    }
}
