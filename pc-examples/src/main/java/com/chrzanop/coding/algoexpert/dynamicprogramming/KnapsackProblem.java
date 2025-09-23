package com.chrzanop.coding.algoexpert.dynamicprogramming;

import java.util.*;

public class KnapsackProblem {

    // O(nc) time | O(nc) space where n - length of items, c - size of capacity
    public static List<List<Integer>> knapsackProblem(
            int[][] items, int capacity) {

        int[][] knapsackValues = new int[items.length + 1][capacity + 1];

        for (int i = 1; i < knapsackValues.length; i++) {
            int itemValue = items[i - 1][0];
            int itemWeight = items[i - 1][1];
            for (int j = 0; j < knapsackValues[0].length; j++) {
                if (itemWeight <= j) {
                    int itemAboveIndex = knapsackValues[i - 1][j];
                    int itemAtValue = itemValue;
                    if (j - itemWeight >= 0) {
                        itemAtValue += knapsackValues[i - 1][j - itemWeight];
                    }
                    knapsackValues[i][j] = Math.max(itemAtValue, itemAboveIndex);
                } else {
                    knapsackValues[i][j] = knapsackValues[i - 1][j];
                }
            }
        }

        List<Integer> totalValue = Arrays.asList(knapsackValues[knapsackValues.length - 1][knapsackValues[0].length - 1]);
        List<Integer> finalItems = backTrack(knapsackValues, items);
        var result = new ArrayList<List<Integer>>();
        result.add(totalValue);
        Collections.sort(finalItems);
        result.add(finalItems);

        return result;

    }

    private static List<Integer> backTrack(int[][] knapsackValues, int[][] items) {
        List<Integer> finalItems = new ArrayList<>();
        int i = knapsackValues.length - 1;
        int j = knapsackValues[0].length - 1;
        while (i >= 1 && j >= 0) {
            if (knapsackValues[i][j] != knapsackValues[i - 1][j]) {
                finalItems.add(i - 1);
                j = j - items[i-1][1];
                i = i -1;
            } else {
                i -=1;
            }
        }
        return finalItems;
    }

    // quite complex approach
    public static List<List<Integer>> knapsackProblemMine(
            int[][] items, int capacity) {
//        items = Arrays.stream(items).sorted(Comparator.comparing(a -> a[0])).toArray(int[][]::new);

        int[][] originalItems = new int[items.length][items[0].length];
        for (int i = 0; i < items.length; i++) {
            originalItems[i] = items[i];
        }

        Arrays.sort(items, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o2[0], o1[0]);
            }
        });

        int maxValue = 0;

        List<List<Integer>> finalList = new ArrayList<>();

        for (int i = 0; i < items.length; i++) {
            int[] item = items[i];
            int itemWeight = item[1];
            int itemValue = item[0];
            if (itemWeight > capacity) {
                continue;
            }
            if (itemWeight == capacity && maxValue < itemValue) {
                finalList.clear();
                finalList.add(Arrays.stream(item).boxed().toList());
                maxValue = itemValue;
                continue;
            }
            List<List<Integer>> tempLists = new ArrayList<>();
            tempLists.add(Arrays.stream(item).boxed().toList());
            for (int j = 1; j < items.length; j++) {
                if (itemWeight == capacity) {
                    break;
                }
                int[] itemTemp = items[j];
                int itemTempValue = itemTemp[0];
                int itemTempWeight = itemTemp[1];
                if (itemWeight + itemTempWeight <= capacity) {
                    tempLists.add(Arrays.stream(itemTemp).boxed().toList());
                    itemWeight += itemTempWeight;
                    itemValue += itemTempValue;
                }
            }
            if (maxValue < itemValue) {
                finalList.clear();
                finalList.addAll(tempLists);
                maxValue = itemValue;
            }
        }

        var result = new ArrayList<List<Integer>>();
        List<Integer> totalValue = Arrays.asList(maxValue);
        List<Integer> finalItems = new ArrayList<>();
        {
            for (List<Integer> finalElement : finalList) {
                Integer value = finalElement.get(0);
                Integer weight = finalElement.get(1);
                for (int i = 0; i < originalItems.length; i++) {
                    int[] originalItem = originalItems[i];
                    int valueO = originalItem[0];
                    int weightO = originalItem[1];
                    if (valueO == value && weightO == weight) {
                        finalItems.add(i);
                    }
                }
            }
        }
        Collections.sort(finalItems);

        result.add(totalValue);
        result.add(finalItems);
        return result;
    }
}
