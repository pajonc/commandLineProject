package com.chrzanop.coding.algoexpert.binarysearchtrees;

import java.util.ArrayList;
import java.util.List;

public class ReconstructBST {

    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }

        private BST insert(int value) {
            BST currentNode = this;
            if (value < currentNode.value) {
                if (currentNode.left == null) {
                    BST node = new BST(value);
                    currentNode.left = node;
                } else {
                    currentNode.left.insert(value);
                }
            } else {
                if (currentNode.right == null) {
                    BST node = new BST(value);
                    currentNode.right = node;
                } else {
                    currentNode.right.insert(value);
                }
            }
            return this;
        }
    }

    // O(nlog(n)) time | O(h) space
    public BST reconstructBst(ArrayList<Integer> preOrderTraversalValues) {
        if (preOrderTraversalValues == null || preOrderTraversalValues.size() == 0) {
            return null;
        }
        BST root = new BST(preOrderTraversalValues.get(0));
        for (int i = 1; i < preOrderTraversalValues.size(); i++) {
            root.insert(preOrderTraversalValues.get(i));
        }
        return root;
    }

    // O(n2) | O(h) space - n number of nodes, h max height of bst tree   (BASED on solution 1 from algo expert)
    public BST reconstructBstMineBasedOnSolution1(ArrayList<Integer> preOrderTraversalValues) {
        if (preOrderTraversalValues == null || preOrderTraversalValues.size() == 0) {
            return null;
        }
        BST root = reconstructBstMineBasedOnSolution1(preOrderTraversalValues, preOrderTraversalValues.get(0), 1, preOrderTraversalValues.size() - 1);
        return root;
    }

    private BST reconstructBstMineBasedOnSolution1(ArrayList<Integer> preOrderTraversalValues, Integer value, int startIdx, int endIdx) {
        if (value == null) {
            return null;
        }
        BST bst = new BST(value);
        if (startIdx <= endIdx) {
            int i = startIdx;
            while (i <= endIdx) {
                if (value < preOrderTraversalValues.get(i)) {
                    break;
                }
                i++;
            }
            BST rightBst = reconstructBstMineBasedOnSolution1(preOrderTraversalValues, i <= endIdx ? preOrderTraversalValues.get(i) : null, i+1, endIdx);
            BST leftBst = reconstructBstMineBasedOnSolution1(preOrderTraversalValues, i > startIdx ? preOrderTraversalValues.get(startIdx) : null, startIdx + 1, i - 1);
            bst.left = leftBst;
            bst.right = rightBst;
        }

        return bst;
    }


    // O(n^2) time | O(n) space - where n is the length of the input array
    public BST reconstructBstAlgo1(List<Integer> preOrderTraversalValues) {
        if(preOrderTraversalValues.size()==0) {
            return null;
        }

        int currentValue = preOrderTraversalValues.get(0);
        int rightSubtreeRootIdx = preOrderTraversalValues.size();

        for(int i=1; i< preOrderTraversalValues.size();i++){
            if(preOrderTraversalValues.get(i)>=currentValue) {
                rightSubtreeRootIdx=i;
                break;
            }
        }

        BST leftSubtree = reconstructBstAlgo1(preOrderTraversalValues.subList(1, rightSubtreeRootIdx));
        BST rightSubtree = reconstructBstAlgo1(preOrderTraversalValues.subList(rightSubtreeRootIdx, preOrderTraversalValues.size()));

        BST bst = new BST(currentValue);
        bst.left = leftSubtree;
        bst.right = rightSubtree;

        return bst;
    }

    // O(n) time | O(n) space - where n is the length of the input array
    public BST reconstructBstAlgo2(List<Integer> preOrderTraversalValues) {
        TreeInfo treeInfo = new TreeInfo(0);
        return reconstructBstAlgo2(preOrderTraversalValues, Integer.MIN_VALUE, Integer.MAX_VALUE, treeInfo);
    }

    public BST reconstructBstAlgo2(List<Integer> preOrderTraversalValues, int leftLimit, int rightLimit, TreeInfo treeInfo) {
        if(preOrderTraversalValues.size()==treeInfo.rootIdx){
            return null;
        }
        int currentValue = preOrderTraversalValues.get(treeInfo.rootIdx);
        if(currentValue>=rightLimit || currentValue<leftLimit) {
            return null;
        }

        treeInfo.rootIdx+=1;
        BST leftSubtree = reconstructBstAlgo2(preOrderTraversalValues, leftLimit, currentValue, treeInfo);
        BST rightSubtree = reconstructBstAlgo2(preOrderTraversalValues, currentValue, rightLimit, treeInfo);

        BST bst = new BST(currentValue);
        bst.left = leftSubtree;
        bst.right = rightSubtree;

        return bst;
    }


    static class TreeInfo {
        public Integer rootIdx;

        public TreeInfo(Integer counter) {
            this.rootIdx = counter;
        }
    }


}
