package com.chrzanop.coding.leetcode.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CousinsInBinaryTree {


    public static void main(String[] args) {
        /*
         * Constructing tree:
         *        1
         *       / \
         *      2   3
         *     / \   \
         *    4   5   6
         */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        CousinsInBinaryTree cousinsInBinaryTree = new CousinsInBinaryTree();
        List<List<Integer>> levels = cousinsInBinaryTree.levelOrder(root);

        System.out.println("Level-order traversal: " + levels);
        // Output: [[1], [2, 3], [4, 5, 6]]
        System.out.println(cousinsInBinaryTree.isCousinsBfs(root, 3, 5));
    }


    /**
     * Traverses the tree level-by-level and returns nodes grouped by depth.
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);

                // Add left child first to maintain left-to-right order
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }

                // Add right child
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }

            result.add(currentLevel);
        }

        return result;
    }


    public boolean isCousinsBfs(TreeNode root, int x, int y) {
        if (root == null) return false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            boolean foundX = false;
            boolean foundY = false;

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                // 1. Check if x and y are siblings (have the same parent)
                if (node.left != null && node.right != null) {
                    if ((node.left.val == x && node.right.val == y) ||
                            (node.left.val == y && node.right.val == x)) {
                        return false; // Same parent -> not cousins
                    }
                }

                // 2. Track presence at the current level
                if (node.val == x) foundX = true;
                if (node.val == y) foundY = true;

                // 3. Queue up children for the next level
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            // Both found at the same depth -> cousins
            if (foundX && foundY) return true;

            // Only one found at this depth -> different depths, cannot be cousins
            if (foundX || foundY) return false;
        }

        return false;
    }




    public boolean isCousinsDfs(TreeNode root, int x, int y) {
        List<Info> cousins = new ArrayList<Info>();
        dfs(root, null, x, y, cousins, 0);

        if(cousins.size() < 2) return false;

        return cousins.get(0).parent != cousins.get(1).parent && cousins.get(0).depth == cousins.get(1).depth;



    }

    void dfs(TreeNode node, TreeNode parent ,int x, int y, List<Info> cousins, int depth) {
        if(node == null) {
            return;
        }

        if( node.val == x || node.val == y ) {
            int parentVal = parent == null ? -1 : parent.val;
            cousins.add(new Info(parentVal, depth));
        }

        dfs(node.left, node, x, y, cousins, depth+1);
        dfs(node.right, node, x, y, cousins, depth+1);
    }

    static class Info {
        public int parent;
        public int depth;

        public Info(int parent, int depth) {
            this.parent = parent;
            this.depth = depth;
        }
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public class ExtTreeNode extends TreeNode {
        public int level;

    }
}
