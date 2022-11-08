package com.chrzanop.coding.algoexpert.arrays;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * validate subsequence in order of main array
 */

public class ValidSubsequence {


    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10);
        List<Integer> sequence = Arrays.asList(1, 6, -1, 10);

        System.out.println("First: "+isValidSubsequence(array, sequence));
        System.out.println("Second: "+isValidSubsequence2(array, sequence));
        System.out.println("Third: "+isValidSubsequence3(array, sequence));

    }


    // O(n) time | O(1) space
    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {

        Iterator iterator = array.iterator();
        int j = 0;
        while (iterator.hasNext()) {
            if (j == sequence.size()) {
                break;
            }
            Integer element = (Integer) iterator.next();
            if (element == sequence.get(j)) {
                j = j + 1;
            }
        }
        return j == sequence.size();
    }

    // O(n) time | O(1) space
    public static boolean isValidSubsequence3(List<Integer> array, List<Integer> sequence) {

        int arrayIdx = 0, seqIdx = 0;
        while(arrayIdx<array.size() && seqIdx < sequence.size()) {
            if(array.get(arrayIdx).equals(sequence.get(seqIdx))) {
                seqIdx+=1;
            }
            arrayIdx+=1;
        }

        return seqIdx == sequence.size();
    }


    // O(n) time | O(1) space
    public static boolean isValidSubsequence2(List<Integer> array, List<Integer> sequence) {

        int seqIdx = 0;
        for (Integer element : array) {
            if(seqIdx==sequence.size()) {
                break;
            }
            if (element == sequence.get(seqIdx)) {
                seqIdx += 1;
            }
        }

        return seqIdx == sequence.size();

    }


}
