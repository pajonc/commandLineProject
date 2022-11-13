package com.chrzanop.coding.algoexpert.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveElementToEnd {

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<Integer>(Arrays.asList(2, 1, 2, 2, 2, 3, 4, 2));
        int toMove = 2;

        List<Integer> results = moveElementToEnd(array, toMove);

    }

    // O(n) time | O(1) space
    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
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
