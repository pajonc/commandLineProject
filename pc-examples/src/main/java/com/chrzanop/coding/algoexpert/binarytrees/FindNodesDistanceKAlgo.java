package com.chrzanop.coding.algoexpert.binarytrees;

import java.util.*;

public class FindNodesDistanceKAlgo {


    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    static class Pair<U, V> {
        public final U first;
        public final V second;

        private Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }
    }

    public ArrayList<Integer> findNodesDistanceK(
            BinaryTree tree, int target, int k
    ) {
        HashMap<Integer, BinaryTree> nodesToParents = new HashMap<>();
        populateNodesToParents(tree, nodesToParents, null);
        BinaryTree targetNode = getNodeFromValue(target, tree, nodesToParents);

        return breadthFirstSearchForNodesDistanceK(targetNode, nodesToParents, k);
    }

    public ArrayList<Integer> breadthFirstSearchForNodesDistanceK(BinaryTree targetNode,
                                                                  HashMap<Integer, BinaryTree> nodesToParents,
                                                                  int k) {
        Queue<Pair<BinaryTree, Integer>> queue = new LinkedList<Pair<BinaryTree, Integer>>();
        queue.offer(new Pair<BinaryTree, Integer>(targetNode, 0));

        HashSet<Integer> seen = new HashSet<>(targetNode.value);
        seen.add(targetNode.value);

        while (queue.size() > 0) {
            Pair<BinaryTree, Integer> vals = queue.poll();
            BinaryTree currentNode = vals.first;
            Integer distanceFromTarget = vals.second;

            if(distanceFromTarget == k) {
                ArrayList<Integer> nodeDistanceK = new ArrayList<>();
                for(Pair<BinaryTree, Integer> pair : queue) {
                    nodeDistanceK.add(pair.first.value);
                }
                nodeDistanceK.add(currentNode.value);
                return nodeDistanceK;
            }

            List<BinaryTree> currentNodes = new ArrayList<>();
            currentNodes.add(currentNode.left);
            currentNodes.add(currentNode.right);
            currentNodes.add(nodesToParents.get(currentNode.value));

            for(BinaryTree node : currentNodes) {
                if(node ==null) continue;

                if(seen.contains(node.value)) continue;

                seen.add(node.value);
                queue.add(new Pair<BinaryTree, Integer>(node, distanceFromTarget + 1));
            }

        }
        return new ArrayList<>();
    }

    public BinaryTree getNodeFromValue(
            int value, BinaryTree tree, HashMap<Integer, BinaryTree> nodesToParents
    ) {
        if(tree.value == value) return tree;

        BinaryTree nodeParent = nodesToParents.get(value);
        if(nodeParent.left != null && nodeParent.left.value == value) {
            return nodeParent.left;
        }
        return nodeParent.right;
    }

    public void populateNodesToParents(
            BinaryTree node, Map<Integer, BinaryTree> nodesToParents, BinaryTree parent
    ) {
        if(node !=null) {
            nodesToParents.put(node.value, parent);
            populateNodesToParents(node.left, nodesToParents, node);
            populateNodesToParents(node.right, nodesToParents, node);
        }
    }


}
