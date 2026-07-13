package com.chrzanop.coding.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CanJumpDfsMemoization {

    private Map<Node, Boolean> memo = new HashMap<>();

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};

        CanJumpDfsMemoization canJumpWithDfsMemoization = new CanJumpDfsMemoization();

        canJumpWithDfsMemoization.canJump(nums);

        System.out.println("---------");

        int[] nums2 = {3,2,1,0,4};

        canJumpWithDfsMemoization.canJump(nums2);

    }
    
   void canJump(int[] nums) {
        Node[] nodes = new Node[nums.length];

        for (int i = 0; i < nums.length; i++) {
            Node node = new Node(nums[i], i);
            nodes[i] = node;
        }

        for (Node node : nodes) {
            if(node.index == nums.length-1) break;

            int reach = node.value;
            if (reach == 0) continue;
            int currentReach = 1;
            while (currentReach + node.index < nums.length && currentReach <= reach) {
                node.neighbours.add(nodes[currentReach + node.index]);
                currentReach++;
            }
        }
        startDfs(nodes[0], nums);
    }

    // Memoization map: stores whether a Node can reach the target index


    public void startDfs(Node root, int[] nums) {
        // Clear memo before starting a new run if necessary
        memo.clear();

        boolean canReachEnd = dfs(root, nums);

        System.out.println("Can reach the end? " + canReachEnd);
    }

    private boolean dfs(Node node, int[] nums) {
        // Base Case 1: If node is null, it's an invalid path
        if (node == null) {
            return false;
        }

        System.out.println("Node value: " + node.value);

        // Base Case 2: Target reached
        if (node.index == nums.length - 1) {
            return true;
        }

        // Memoization Check: If we have already evaluated this node, return the cached result
        if (memo.containsKey(node)) {
            return memo.get(node);
        }

        // Recursively check all neighbors
        for (int i = 0; i < node.neighbours.size(); i++) {
            if (dfs(node.neighbours.get(i), nums)) {
                // Cache the true result and return early (short-circuiting)
                memo.put(node, true);
                return true;
            }
        }

        // Cache the false result if no neighbors led to the target
        memo.put(node, false);
        return false;
    }

    static class Node {
        public int value;
        public int index;

        public List<Node> neighbours = new ArrayList();
        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
