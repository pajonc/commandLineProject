package com.chrzanop.coding.algoexpert.binarytrees;

import java.util.*;

public class FindNodesDistanceK {

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    static class BinaryTreeDistance {
        public BinaryTree binaryTree;
        public int distance;

        public BinaryTreeDistance(BinaryTree binaryTree, int distance) {
            this.binaryTree = binaryTree;
            this.distance = distance;
        }
    }


    public ArrayList<Integer> findNodesDistanceK(BinaryTree tree, int target, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Map<Integer, BinaryTree> parents = new HashMap<>();
        populateNodesToParents(tree, parents, null);
        BinaryTree targetTree = findTarget(tree, target, parents);
        Set<Integer> visited = new HashSet<>();

        Queue<BinaryTreeDistance> queue = new LinkedList<>();
        BinaryTreeDistance btd = new BinaryTreeDistance(targetTree, 0);
        queue.offer(btd);
        // breadth first search traverse
        while (queue.peek() != null) {
            BinaryTreeDistance binaryTreeDistance = queue.poll();
            if (binaryTreeDistance.distance == k) {
                result.add(binaryTreeDistance.binaryTree.value);
            } else if (!visited.contains(binaryTreeDistance.binaryTree.value)) {
                binaryTreeDistance.distance += 1;
                if ( parents.get(binaryTreeDistance.binaryTree.value) !=null && !visited.contains(parents.get(binaryTreeDistance.binaryTree.value).value)) {
                    queue.offer(new BinaryTreeDistance(parents.get(binaryTreeDistance.binaryTree.value), binaryTreeDistance.distance));
                }
                if (binaryTreeDistance.binaryTree.left != null && !visited.contains(binaryTreeDistance.binaryTree.left.value)) {
                    queue.offer(new BinaryTreeDistance(binaryTreeDistance.binaryTree.left, binaryTreeDistance.distance));
                }
                if (binaryTreeDistance.binaryTree.right != null && !visited.contains(binaryTreeDistance.binaryTree.right.value)) {
                    queue.offer(new BinaryTreeDistance(binaryTreeDistance.binaryTree.right, binaryTreeDistance.distance));
                }
                visited.add(binaryTreeDistance.binaryTree.value);
            }
        }
        return result;
    }

    private void populateNodesToParents(BinaryTree binaryTree, Map<Integer, BinaryTree> parents, BinaryTree parent) {
        parents.put(binaryTree.value, parent);
        if (binaryTree.left != null) {
            populateNodesToParents(binaryTree.left, parents, binaryTree);
        }
        if (binaryTree.right != null) {
            populateNodesToParents(binaryTree.right, parents, binaryTree);
        }
    }

    private BinaryTree findTarget(BinaryTree tree, int target, Map<Integer, BinaryTree> parents) {
        if(tree.value == target) return tree;
        BinaryTree parent = parents.get(target);
        if (parent.left != null && parent.left.value == target) {
            return parent.left;
        } else {
            return parent.right;
        }
    }

}
