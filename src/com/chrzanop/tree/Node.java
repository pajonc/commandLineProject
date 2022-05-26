package com.chrzanop.tree;

public class Node {

    Node left, right;
    int data;
    boolean visited = false;

    public Node(int data) {
        this.data = data;

    }

    public Node(Node left, Node right, int data) {
        this.left = left;
        this.right = right;
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

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
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

    public void printInOrder(Node node) {
        if(node == null) {
            return;
        }
        if (node.left != null) {
            printInOrder(node.left);
        }
        System.out.println(node.data);
        if (node.right != null) {
            printInOrder(node.right);
        }
    }

    public void printPreOrder(Node node) {
        if(node == null) {
            return;
        }
        System.out.println(node.data);
        if (node.left != null) {
            printPreOrder(node.left);
        }

        if (node.right != null) {
            printPreOrder(node.right);
        }
    }


    public void printPostOrder(Node node) {
        if(node == null) {
            return;
        }
        if (node.left != null) {
            printPostOrder(node.left);
        }

        if (node.right != null) {
            printPostOrder(node.right);
        }
        System.out.println(node.data);
    }


}


//    Node{
//        left=Node{left=Node{left=null, right=null, data=3},
//        right=Node{left=null, right=null, data=9}, data=7},
//        right=Node{left=Node{left=null, right=Node{left=null, right=null, data=19}, data=18},
//        right=Node{left=null, right=null, data=30}, data=20},
//        data=10
//    }