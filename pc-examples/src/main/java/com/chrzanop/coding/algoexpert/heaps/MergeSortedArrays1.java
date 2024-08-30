package com.chrzanop.coding.algoexpert.heaps;

import java.util.ArrayList;
import java.util.List;

public class MergeSortedArrays1 {

    public static List<Integer> mergeSortedArrays(List<List<Integer>> arrays) {
        List<Integer> mergedSorted = new ArrayList<>();
        int[] indexes = new int[arrays.size()];
        int n = arrays.stream().map(List::size).reduce(0, Integer::sum);
        List<Integer> helperList = buildHelperList(arrays, indexes);
        while (n > 0) {
            int minIdx = getMinIdx(helperList);
            int idx = indexes[minIdx];
            int sizeK = arrays.get(minIdx).size();
            if (idx < sizeK) {
                mergedSorted.add(arrays.get(minIdx).get(indexes[minIdx]));
                indexes[minIdx] = indexes[minIdx] + 1;
                helperList = buildHelperList(arrays, indexes);
            }
            n--;
        }
        return mergedSorted;
    }

    private static List<Integer> buildHelperList(List<List<Integer>> arrays, int[] indexes) {
        List<Integer> helperList = new ArrayList<>();
        for (int k = 0; k < indexes.length; k++) {
            try {
                helperList.add(arrays.get(k).get(indexes[k]));
            } catch (Exception ex) {
                System.out.println("out of bound, setting to max");
                helperList.add(Integer.MAX_VALUE);
            }
        }
        return helperList;
    }

    static int getMinIdx(List<Integer> input) {
        int i = 0;
        Integer minElement = input.get(0);
        for (int j = 1; j < input.size(); j++) {
            if (input.get(j) < minElement) {
                minElement = input.get(j);
                i = j;
            }
        }
        return i;
    }

}
