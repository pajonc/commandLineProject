package com.chrzanop.kadane;

public class Kadane {

    public static void main(String[] args) {
        Kadane kadane = new Kadane();

        int[] array = {1, -3, 2, 1, -1};

        System.out.println(kadane.maxSubarray(array));
    }

    public int maxSubarray(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int currentMax = 0, globalMax = 0;

        for (int i = 0; i < array.length; i++) {

            if (i == 0) {
                currentMax = array[i];
                globalMax = currentMax;
                continue;
            }
            currentMax = Math.max(array[i], array[i] + array[i - 1]);
            globalMax = Math.max(currentMax, globalMax);

        }


        return globalMax;
    }
}
