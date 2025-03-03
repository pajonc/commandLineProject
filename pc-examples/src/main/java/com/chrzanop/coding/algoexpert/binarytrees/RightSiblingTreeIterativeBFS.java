package com.chrzanop.coding.algoexpert.binarytrees;

import java.util.LinkedList;

public class RightSiblingTreeIterativeBFS {

    //
    public static BinaryTree rightSiblingTree(BinaryTree root) {
        LinkedList<BinaryTree> queue = new LinkedList<>();
        queue.offer(root);
        BinaryTree lelt = null, right =null;
        int size = 0;
        BinaryTree node = null, prev = null;

        while (!queue.isEmpty()) {
            size = queue.size();
            prev = null;
            for (int i = 0; i < size; i++) {
                node =  queue.remove();
                if(node ==null) {
                    prev = null;
                    continue;
                }
                lelt = node.left;
                right = node.right;

                node.right = null;

                if(prev!=null) {
                    prev.right = node;
                }
                prev = node;
                queue.add(lelt);
                queue.add(right);
            }
        }

        return root;
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
     # continue;
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
