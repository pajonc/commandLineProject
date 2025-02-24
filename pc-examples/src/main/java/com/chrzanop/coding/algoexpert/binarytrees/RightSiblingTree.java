package com.chrzanop.coding.algoexpert.binarytrees;

public class RightSiblingTree {

    // O(n) time | O(d) space - where n is the number of nodes in BT
    // and d is the depth (height) of the Binary Tree
    public static BinaryTree rightSiblingTree(BinaryTree root) {
        traverseAndMutateAlgo(root, null, true);
        return root;
    }

    private static void traverseAndMutate(BinaryTree node, BinaryTree parent, boolean isLeft) {
        if (node == null) {
            return;
        }
        BinaryTree nodeRight = node.right;
        traverseAndMutate(node.left, node, true);
        if(parent == null) {
            node.right = null;
        }
        if (parent != null && parent.right != null && isLeft) {
            node.right = parent.right;
        }
        if(parent!=null && parent.right!=null && parent.right.left!=null && !isLeft) {
            node.right = parent.right.left;
        }
        traverseAndMutate(nodeRight, node, false);
    }

    private static void traverseAndMutateAlgo(BinaryTree node, BinaryTree parent, boolean isLeftChild) {
        if (node == null) {
            return;
        }
        BinaryTree nodeLeft = node.left;
        BinaryTree nodeRight = node.right;
        traverseAndMutateAlgo(nodeLeft, node, true);
        if(parent == null) {
            node.right = null;
        } else if (isLeftChild) {
            node.right = parent.right;
        } else {
            if(parent.right == null) {
                node.right = null;
            } else {
                node.right = parent.right.left;
            }
        }
        traverseAndMutateAlgo(nodeRight, node, false);
    }

    // This is the class of the input root. Do not edit it.
    static class BinaryTree {
        int value;
        BinaryTree left = null;
        BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    /**   python - Iterative solution Breadth first search

     def rightSiblingTree(root):

     queue=deque()
     queue.append([root,0])

     while queue:
     node,level=queue.popleft()

     if node==None:
     #impt because of test case
     if queue and queue[-1][0]!=None:
     queue.append([None,level+1])
     continue

     queue.append([node.left,level+1])
     queue.append([node.right,level+1])

     if queue and queue[0][1]==level:
     node.right=queue[0][0]
     else:
     node.right=None

     return root

     */

}
