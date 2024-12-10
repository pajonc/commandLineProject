package com.chrzanop.coding.algoexpert.binarysearchtrees;

import java.util.ArrayList;
import java.util.List;

public class RightSmallerThan {

    // O(n^2) time | O(n) space
    public static List<Integer> rightSmallerThanNaiveSolution(List<Integer> array) {
        List<Integer> rightSmallerThan = new ArrayList<Integer>();
        if(array.size()==0) {
            return rightSmallerThan;
        }
        for(int i=0; i<array.size();i++) {
            int counter = 0;
            for(int j=i+1; j < array.size(); j++) {
                if(array.get(i)>array.get(j)) counter++;
            }
            rightSmallerThan.add(counter);
        }
        return rightSmallerThan;
    }

    // Average case when the created BST is balanced
    // O(nlogn) time | O(n) space
    // Worst case when the created BST is unbalanced like a linked list
    // O(n^2) time | O(n) space
    public static List<Integer> rightSmallerThanWithBst(List<Integer> array) {
        List<Integer> rightSmallerCounts = new ArrayList<Integer>(array);
        if(array.size()==0) {
            return rightSmallerCounts;
        }
        BST specificBST = new BST(array.get(array.size()-1),null, null, 0);
        rightSmallerCounts.set(array.size()-1,0);

        for(int i=array.size()-2 ; i>=0; i--) {
            specificBST.insert(array.get(i),i,rightSmallerCounts);
        }

        return rightSmallerCounts;
    }

    static class BST {
        int value;
        BST left;
        BST right;
        int leftSubtreeSize;

        public BST(int value, BST left, BST right, int leftSubtreeSize) {
            this.value = value;
            this.left = left;
            this.right = right;
            this.leftSubtreeSize = leftSubtreeSize;
        }

        public void insert(int value, int idx, List<Integer> rightSmallerCounts) {
            insertHelper(value, idx, rightSmallerCounts, 0);
        }

        private void insertHelper(int value, int idx, List<Integer> rightSmallerCounts, int numSmallerAtInsertTime) {
            // to the left
            if(value<this.value) {
                leftSubtreeSize++;
                if(this.left==null) {
                    this.left = new BST(value, null, null, 0);
                    rightSmallerCounts.set(idx, numSmallerAtInsertTime);
                } else {
                    left.insertHelper(value, idx, rightSmallerCounts, numSmallerAtInsertTime);
                }
            // to the right
            } else {
                numSmallerAtInsertTime += this.leftSubtreeSize;
                if(value>this.value) numSmallerAtInsertTime++;
                if(this.right==null) {
                    this.right = new BST(value, null, null, 0);
                    rightSmallerCounts.set(idx, numSmallerAtInsertTime);
                } else {
                    this.right.insertHelper(value, idx, rightSmallerCounts, numSmallerAtInsertTime);
                }
            }
        }


    }

}
