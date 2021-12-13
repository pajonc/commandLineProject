package com.chrzanop.datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayManipulation {


    public static long arrayManipulation(int n, List<List<Integer>> queries) {

        long maxElement = 0;
        List<Integer> zeroIndexed = new ArrayList<>(n);
        for (int k = 0; k < n; k++) {
            zeroIndexed.add(0);
        }
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(zeroIndexed);

        for (int i = 0; i < queries.size(); i++) {
            List<Integer> query = queries.get(i);
            int a = query.get(0) - 1;
            int b = query.get(1) - 1;
            int k = query.get(2);
            List<Integer> newZeroIndexed = new ArrayList<>(n);
            for (int j = 0; j < n; j++) {
                int element = matrix.get(i).get(j);
                if (j >= a && j <= b) {
                    element = element + k;
                    newZeroIndexed.add(j, element);
                } else {
                    newZeroIndexed.add(j, element);
                }
                if (element > maxElement) {
                    maxElement = element;
                }
            }
            matrix.add(newZeroIndexed);
        }

        return maxElement;
    }

    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> queries = new ArrayList<>();
        queries.add(Arrays.asList(1, 2, 100));
        queries.add(Arrays.asList(2, 5, 100));
        queries.add(Arrays.asList(3, 4, 100));

        System.out.println(arrayManipulation(n, queries));
    }
}
