package com.chrzanop.graph.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeTraversal {


/*
                     10
                  /     \
                 5       15
               /  \     /  \
              4    8   13  null
*/


    public static void main(String[] args) {
        Node root = new Node(10);
        root.insert(5);
        root.insert(15);
        root.insert(8);
//        root.insert(4);
//        root.insert(13);

        System.out.println("%%%%%%%%%%%%%%%%% pre order");
        root.printPreOrder(root);
        System.out.println("%%%%%%%%%%%%%%%%% in order");
        root.printInOrder(root);
        System.out.println("%%%%%%%%%%%%%%%%% post order");
        root.printPostOrder(root);

        System.out.println("============ inorder traversal recursive: ");
        List<Integer> inOrderIntegers = recursiveInOrderTraversal(root, new ArrayList<>());
        System.out.println("============ inorder traversal recursive: ");
        List<Integer> preOrderIntegers = recursivePreOrderTraversal(root, new ArrayList<>());
        System.out.println("============ postorder traversal recursive: ");
        List<Integer> postOrderIntegers = recursivePostOrderTraversal(root, new ArrayList<>());

        System.out.println("////////////////// inorder traversal stack: ");
        System.out.println(iterativeInOrderTraversal(root));
        System.out.println("////////////////// preorder traversal stack: ");
        List<Integer> preorder = iterativePreOrderTraversal(root);
        System.out.println(preorder);
        Node root2 = new Node(30);
        root2.insert(25);
        root2.insert(35);
        root2.insert(10);
        root2.insert(20);
        root2.insert(15);
        root2.insert(18);
        root2.insert(33);
        root2.insert(37);
        root2.insert(29);
        List<Integer> preorder2 = iterativePreOrderTraversal(root2);
        System.out.println(preorder2);
        List<Integer> postOrder2 = iterativePostOrderTraversal(root2);
        System.out.println(postOrder2);

    }


    public static List<Integer> recursivePreOrderTraversal(Node root, List<Integer> list) {
        if (root == null) {
            return list;
        }
        System.out.println(root.data);
        list.add(root.data);
        if (root.left != null) {
            recursivePreOrderTraversal(root.left, list);
        }
        if (root.right != null) {
            recursivePreOrderTraversal(root.right, list);
        }

        return list;
    }


    public static List<Integer> recursiveInOrderTraversal(Node root, List<Integer> list) {
        if (root.left != null) {
            recursiveInOrderTraversal(root.left, list);
        }
        System.out.println(root.data);
        list.add(root.data);
        if (root.right != null) {
            recursiveInOrderTraversal(root.right, list);
        }

        return list;
    }


    public static List<Integer> recursivePostOrderTraversal(Node root, List<Integer> list) {
        if (root == null) {
            return list;
        }
        if (root.left != null) {
            recursivePostOrderTraversal(root.left, list);
        }
        if (root.right != null) {
            recursivePostOrderTraversal(root.right, list);
        }
        System.out.println(root.data);
        list.add(root.data);

        return list;
    }

    public static List<Integer> iterativePreOrderTraversal(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output_arr = new LinkedList<>();

        if (root == null) {
            return output_arr;
        }
        stack.add(root);

        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            output_arr.add(node.data);

            if (node.right != null) {
                stack.add(node.right);
            }

            if (node.left != null) {
                stack.add(node.left);
            }
        }

        return output_arr;

    }


    //     10
    // 5        15
    //   8

    // 10 5 8 15


    public static List<Integer> iterativeInOrderTraversal(Node root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }
        Deque<Node> stack = new LinkedList<>();
        Node current = root;

        while (!stack.isEmpty() || current != null) {

            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.poll();
            list.add(current.data);
            current = current.right;
        }

        return list;
    }


    public static List<Integer> iterativePostOrderTraversal(Node root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }
        Deque<Node> stack = new LinkedList<>();
        Node current = root;
        Node lastVisitedNode = null;

        while (!stack.isEmpty() || current != null) {

            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                Node peekNode = stack.peek();
                if (peekNode.right != null && peekNode.right != lastVisitedNode) {
                    current = peekNode.right;
                } else {
                    list.add(peekNode.data);
                    lastVisitedNode = stack.pop();
                }
            }
        }

        return list;
    }


}