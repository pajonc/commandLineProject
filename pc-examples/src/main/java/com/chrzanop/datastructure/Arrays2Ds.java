package com.chrzanop.datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Arrays2Ds {

    private int topSize = 3;
    private int middleSize = 1;
    private int bottomSize = 3;

    public static void main(String[] args) {
        List<List<Integer>> arrTable = new ArrayList<List<Integer>>();
        arrTable.add(Arrays.asList(-9, -9, -9, 1, 1, 1));
        arrTable.add(Arrays.asList(0, -9, 0, 4, 3, 2));
        arrTable.add(Arrays.asList(-9, -9, -9, 1, 2, 3));
        arrTable.add(Arrays.asList(0, 0, 8, 6, 6, 0));
        arrTable.add(Arrays.asList(0, 0, 0, -2, 0, 0));
        arrTable.add(Arrays.asList(0, 0, 1, 2, 4, 0));
        System.out.println(arrTable);
        System.out.println("------------");
        System.out.println("Max hourglass sum: " + hourglassSum(arrTable));


    }

    public static int hourglassSum(List<List<Integer>> arrTable) {
        int maxHourGlassSum = 0;
        int tick = 0;

        for (int j = 0; j < 4; j++) {

            for (int k = 0; k < 4; k++) {

                int top = arrTable.get(j).get(k) + arrTable.get(j).get(k + 1) + arrTable.get(j).get(k + 2);
                int middle = arrTable.get(j + 1).get(k + 1);
                int bottom = arrTable.get(j + 2).get(k) + arrTable.get(j + 2).get(k + 1) + arrTable.get(j + 2).get(k + 2);

                int value = top + middle + bottom;

                if (maxHourGlassSum < value || tick == 0) {
                    maxHourGlassSum = value;
                    tick++;
                }

            }
        }

        return maxHourGlassSum;

    }


}

/*
    Given a  2D Array, :

        1 1 1 0 0 0
        0 1 0 0 0 0
        1 1 1 0 0 0
        0 0 0 0 0 0
        0 0 0 0 0 0
        0 0 0 0 0 0
        An hourglass in  is a subset of values with indices falling in this pattern in 's graphical representation:

        a b c
        d
        e f g

        There are  hourglasses in . An hourglass sum is the sum of an hourglass' values. Calculate the hourglass sum for every hourglass in , then print the maximum hourglass sum. The array will always be .

Example


-9 -9 -9  1 1 1
 0 -9  0  4 3 2
-9 -9 -9  1 2 3
 0  0  8  6 6 0
 0  0  0 -2 0 0
 0  0  1  2 4 0
The  hourglass sums are:

-63, -34, -9, 12,
-10,   0, 28, 23,
-27, -11, -2, 10,
  9,  17, 25, 18
*/