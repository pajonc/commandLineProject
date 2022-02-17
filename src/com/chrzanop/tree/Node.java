package com.chrzanop.tree;

public class Node {

    private Node left, right;
    private int data;

    public Node(int data) {
        this.data = data;
    }

    public void insert(int value) {
        if (value <= data) {
            if (left == null) {
                left = new Node(value);
            } else {
                left.insert(value);
            }
        } else {
            if (right == null) {
                right = new Node(value);
            } else {
                right.insert(value);
            }
        }

    }

    public boolean contains(int value) {
        if (value == data) {
            return true;
        } else if (value < data) {
            if (left == null) {
                return false;
            } else {
                return left.contains(value);
            }

        } else if (value > data) {
            if (right == null) {
                return false;
            } else {
                return right.contains(value);
            }
        }
        return false;
    }

    public void printInOrder() {
        if (left != null) {
            left.printInOrder();
        }
        System.out.println(data);
        if (right != null) {
            right.printInOrder();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "left=" + left +
                ", right=" + right +
                ", data=" + data +
                '}';
    }

    public static void main(String[] args) {
        Node rootNode = new Node(10);
        rootNode.insert(7);
        rootNode.insert(20);
        rootNode.insert(9);
        rootNode.insert(3);
        rootNode.insert(30);
        rootNode.insert(18);
        rootNode.insert(19);

        System.out.println(rootNode.contains(9));

        rootNode.printInOrder();
    }


}


//    Node{
//        left=Node{left=Node{left=null, right=null, data=3},
//        right=Node{left=null, right=null, data=9}, data=7},
//        right=Node{left=Node{left=null, right=Node{left=null, right=null, data=19}, data=18},
//        right=Node{left=null, right=null, data=30}, data=20},
//        data=10
//    }