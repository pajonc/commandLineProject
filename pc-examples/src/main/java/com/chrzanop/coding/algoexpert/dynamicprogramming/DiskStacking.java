package com.chrzanop.coding.algoexpert.dynamicprogramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiskStacking {


    // O(n^2) time | O(n) space
    public static List<Integer[]> diskStacking(List<Integer[]> disks) {

        // order by height of disk, smaller first
//        Collections.sort(disks, (o1, o2) -> Integer.compare(o1[2], o2[2]));
        disks.sort((disk1, disk2) -> disk1[2].compareTo(disk2[2]));


        int[] heights = new int[disks.size()];
        for (int i = 0; i < disks.size(); i++) {
            heights[i] = disks.get(i)[2];
        }
        int[] sequences = new int[disks.size()];
        for (int i = 0; i < disks.size(); i++) {
            sequences[i] = Integer.MIN_VALUE;
        }
        int maxHeightIdx = 0;
        for (int i = 1; i < disks.size(); i++) {
            int j = 0;
            Integer[] currentDisk = disks.get(i);
            int heightCurrentDisk = currentDisk[2];
            while (j < i) {
                Integer[] otherDisk = disks.get(j);
                if (areValidDimensions(otherDisk, currentDisk)) {
                    if(heightCurrentDisk + heights[j] > heights[i]) {
                        heights[i] = heightCurrentDisk + heights[j];
                        sequences[i] = j;
                    }
                }
                j++;
            }
            if (heights[i] >= heights[maxHeightIdx]) {
                maxHeightIdx = i;
            }

        }

        return buildSequence(disks, sequences, maxHeightIdx);


    }

    // o -other disk, c - current disk
    private static boolean areValidDimensions(Integer[] o, Integer[] c) {
        return o[0] < c[0] && o[1] < c[1] && o[2] < c[2];
    }


    private static List<Integer[]> buildSequence(List<Integer[]> array, int[] sequences, int currentIdx) {
        List<Integer[]> sequence = new ArrayList<>();
        while (currentIdx != Integer.MIN_VALUE) {
            sequence.add(0,array.get(currentIdx));
            currentIdx = sequences[currentIdx];
        }
        return sequence;

    }


//    public static List<Integer[]> diskStacking(List<Integer[]> disks) {
//
//        Collections.sort(disks, new Comparator<Integer[]>() {
//            @Override
//            public int compare(Integer[] o1, Integer[] o2) {
//                return Integer.compare(o1[2],o2[2]);
//            }
//        });
//
//        List<Integer> heights = new ArrayList<>();
//
//        for (int i = 0; i < disks.size(); i++) {
//            heights.add(disks.get(i)[2]);
//        }
//
//        int maxHeight = 0;
//        List<Integer[]> finalList  =  new ArrayList<Integer[]>();
//        finalList.add(disks.get(0));
//
//        for (int i = 1; i < heights.size(); i++) {
//            List<Integer[]> tempList  =  new ArrayList<Integer[]>();
//            tempList.add(disks.get(i));
//            int j = i-1;
//            while (j>=0) {
//                Integer[] disk = disks.get(j);
//                if(disk[0] < tempList.get(tempList.size()-1)[0] && disk[1] < tempList.get(tempList.size()-1)[1] && disk[2] < tempList.get(tempList.size()-1)[2]) {
//                    tempList.add(disk);
//                }
//                j--;
//            }
//            int tempHeight = countHeight(tempList);
//            if(maxHeight<tempHeight) {
//                maxHeight = tempHeight;
//                finalList.clear();
//                finalList.addAll(tempList);
//            }
//
//        }

//        int maxHeight = 0;
//        for (int i = 0; i < disks.size(); i++) {
//            List<Integer[]> tempDisks = new ArrayList<>();
//            tempDisks.add(disks.get(i));
//            for (int j = 1; j < disks.size(); j++) {
//                Integer[] lastDiskOnStack = tempDisks.get(tempDisks.size() - 1);
//                if(lastDiskOnStack[0] < disks.get(j)[0] && lastDiskOnStack[1] < disks.get(j)[1]) {
//                    tempDisks.add(disks.get(j));
//                }
//            }
//            int tempMaxHeight = countHeight(tempDisks);
//            if(maxHeight < tempMaxHeight) {
//                maxHeight = tempMaxHeight;
//                finalList.clear();
//                finalList.addAll(tempDisks);
//            }
//        }
//
//        return finalList;
//    }

    private static int countHeight(List<Integer[]> disks) {
//        disks.stream().map(disk -> disk[2]).reduce(0, (a,b) -> a+b);
        return disks.stream().mapToInt(disk -> disk[2]).sum();
    }
}
