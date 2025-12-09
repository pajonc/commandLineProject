package com.chrzanop.coding.algoexpert.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence {

    // O(nlog(n)) time | O(n) space
    public static List<Integer> longestIncreasingSubsequenceAlgo2(int[] array) {
        int[] sequences = new int[array.length];
        int[] indices = new int[array.length+1];
        Arrays.fill(indices, Integer.MIN_VALUE);
        int length = 0;
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            int newLength = binarySearch(1, length, indices, array, num);
            sequences[i] = indices[newLength-1];
            indices[newLength] = i;
            length = Math.max(length, newLength);
        }
        return buildSequenceAlgo2(array, sequences, indices[length]);
    }

    private static int binarySearch(int startIdx, int endIdx, int[] indicies, int[] array, int num) {
        if(startIdx>endIdx) {
            return startIdx;
        }
        int middleIdx = (startIdx+endIdx) / 2;
        if( array[indicies[middleIdx]] < num ) {
            startIdx = middleIdx+1;
        } else {
            endIdx = middleIdx -1;
        }
        return binarySearch(startIdx, endIdx, indicies, array, num);
    }

    private static List<Integer> buildSequenceAlgo2(int[] array, int[] sequences, int currentIdx){
        List<Integer> sequence = new ArrayList<>();
        while (currentIdx != Integer.MIN_VALUE) {
            sequence.add(0, array[currentIdx]);
            currentIdx = sequences[currentIdx];
        }
        return sequence;
    }


    // O(n^2) time | O(n) space
    public static List<Integer> longestIncreasingSubsequenceAlgo1(int[] array) {
        int[] lengths = new int[array.length];
        Arrays.fill(lengths, 1);
        int[] sequences = new int[array.length];
        Arrays.fill(sequences, Integer.MIN_VALUE);

        int maxLengthIndex = 0;
        for (int i = 0; i < array.length; i++) {
            int currentNum = array[i];
            for (int j = 0; j < i; j++) {
                int otherNum = array[j];
                if (otherNum < currentNum && 1 + lengths[j] >= lengths[i]) {
                    sequences[i] = j;
                    lengths[i] = lengths[j] + 1;
                }
            }
            if (lengths[i] > lengths[maxLengthIndex]) {
                maxLengthIndex = i;
            }
        }

        return buildSequence(array, sequences, maxLengthIndex);
    }

    private static List<Integer> buildSequence(int[] array, int[] sequences, int currentIdx) {
        List<Integer> sequence = new ArrayList<>();
        while (currentIdx != Integer.MIN_VALUE) {
            sequence.add(0, array[currentIdx]);
            currentIdx = sequences[currentIdx];
        }
        return sequence;
    }


    // quite complex approach, consumes a lot of memory
    public static List<Integer> longestIncreasingSubsequence(int[] array) {
        List<Integer> longestSubsequence = new ArrayList<Integer>();

        int[] lengths = new int[array.length];
        List<List<List<Integer>>> sequences = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            int currentValue = array[i];
            List<List<Integer>> buildSequencesAtIndex = new ArrayList<>();
            List<Integer> localSeq = new ArrayList<>();
            localSeq.add(currentValue);
            buildSequencesAtIndex.add(localSeq);
            sequences.add(buildSequencesAtIndex);
            lengths[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                List<List<Integer>> sequencesAtIndex = sequences.get(j);
                for (int k = 0; k < sequencesAtIndex.size(); k++) {
                    List<Integer> sequenceAtIndex = sequencesAtIndex.get(k);
                    if (sequenceAtIndex.get(sequenceAtIndex.size() - 1) < currentValue) {
                        List<Integer> newSeq = new ArrayList<>(sequenceAtIndex);
                        newSeq.add(currentValue);
                        buildSequencesAtIndex.add(newSeq);
                        lengths[i] = Math.max(lengths[i], newSeq.size());
                    }
                }
            }
        }

        int index = 0;
        int maximumLength = lengths[0];
        for (int i = 1; i < lengths.length; i++) {
            if (lengths[i] > maximumLength) {
                maximumLength = lengths[i];
                index = i;
            }
        }

        List<List<Integer>> lists = sequences.get(index);
        for (List<Integer> sequence : lists) {
            if (sequence.size() > longestSubsequence.size()) {
                longestSubsequence = sequence;
            }
        }

        return longestSubsequence;
    }


}
