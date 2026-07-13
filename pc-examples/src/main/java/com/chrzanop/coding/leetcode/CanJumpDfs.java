package com.chrzanop.coding.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CanJumpDfs {

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};

        CanJumpDfs canJump = new CanJumpDfs();
        System.out.println(canJump.canJump(nums));
    }


    public boolean canJump(int[] nums) {

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

        Set<Boolean> checks = new HashSet();
        dfs(nodes[0],  checks, nums);

        return checks.contains(true);

    }

    void dfs(Node node, Set<Boolean> checks, int[] nums) {
        if(node!=null) System.out.println("Node value "+node.value);

        if (node!=null && node.index == nums.length - 1) {
            checks.add(true);
            return;
        }

        for (int i = 0; i < node.neighbours.size(); i++) {
            dfs(node.neighbours.get(i), checks, nums);
        }
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
