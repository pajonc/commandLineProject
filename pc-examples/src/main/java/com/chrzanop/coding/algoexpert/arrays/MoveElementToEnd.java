package com.chrzanop.coding.algoexpert.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveElementToEnd {

    public static void main(String[] args) {
        MoveElementToEnd move = new MoveElementToEnd();
        List<Integer> array = new ArrayList<Integer>(Arrays.asList(2, 1, 2, 2, 2, 3, 4, 2));
        List<Integer> array2 = new ArrayList<Integer>(Arrays.asList(2, 1, 2, 2, 2, 3, 4, 2));
        int toMove = 2;

        List<Integer> results = move.moveElementToEnd(array, toMove);
        List<Integer> results2 = move.moveElementToEndSolution2(array2, toMove);

    }

    // O(n) time | O(1) space
    public List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        int idxToMove = 0;
        int idxNoToMove = 0;

        while (idxToMove < array.size()) {
            int current = array.get(idxToMove);
            if (array.get(idxToMove) == toMove) {
                if (idxToMove + 1 < array.size() && array.get(idxToMove + 1) != toMove) {
                    int revert = array.get(idxToMove + 1);
                    array.set(idxNoToMove, revert);
                    array.set(idxToMove + 1, current);
                    idxNoToMove++;
                    idxToMove++;
                } else {
                    idxToMove++;
                }
            } else {
                idxToMove += 1;
                idxNoToMove++;
            }
        }
        return array;
    }

    public List<Integer> moveElementToEndSolution2(List<Integer> array, int toMove) {
        int leftIdx = 0;
        int rightIdx = array.size() - 1;

        while (leftIdx < rightIdx) {
            while (array.get(rightIdx) == toMove && leftIdx < rightIdx) {
                rightIdx--;
            }

            if (array.get(leftIdx) == toMove) {
                int temp = array.get(rightIdx);
                array.set(rightIdx, array.get(leftIdx));
                array.set(leftIdx, temp);
            }
            leftIdx++;

        }

        return array;
    }

    /**
     * "array": [2, 1, 2, 2, 2, 3, 4, 2],
     *   "toMove": 2
     *
     *  "array": [],
     *   "toMove": 3
     *
     *   "array": [1, 2, 4, 5, 6],
     *   "toMove": 3
     *
     *   "array": [3, 1, 2, 4, 5],
     *   "toMove": 3
     *
     *   "array": [1, 2, 4, 5, 3],
     *   "toMove": 3
     *
     *   "array": [1, 2, 3, 4, 5],
     *   "toMove": 3
     *
     *   "array": [5, 5, 5, 5, 5, 5, 1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12],
     *   "toMove": 5
     *
     */
}
