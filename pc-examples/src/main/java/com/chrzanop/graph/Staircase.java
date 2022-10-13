package com.chrzanop.graph;

import java.util.Deque;
import java.util.LinkedList;

public class Staircase {


    public static void main(String[] args) {
        Staircase staircase = new Staircase();

        System.out.println(staircase.count(1, 2, 4));
    }

    public int count(int leftStep, int rightStep, int stairs) {
        int count = 0;
        Node node = new Node(0);
        Deque<Node> stack = new LinkedList<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            if (current.data == stairs){
                count = count + 1;
            }
            Node right = current.insertRight(rightStep, stairs);
            if (right != null) {
                stack.push(right);
            }
            Node left = current.insertLeft(leftStep, stairs);
            if (left != null) {
                stack.push(left);
            }
        }
        return count;
    }


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


        public Node insertLeft(int leftStep, int max) {
            if (data + leftStep <= max) {
                left = new Node(data + leftStep);
                return left;
            } else {
                return null;
            }

        }


        public Node insertRight(int rightStep, int max) {
            if (data + rightStep <= max) {
                right = new Node(data + rightStep);
                return right;
            } else {
                return null;
            }
        }

    }


}


