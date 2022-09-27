package com.chrzanop.graph.tree;

import java.util.Deque;
import java.util.LinkedList;

public class DequeTest {

    public static void main(String[] args) {
        Deque<String> stack = new LinkedList<>();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");

        while (!stack.isEmpty()) {
            System.out.println(stack.pollLast());
        }

    }
}
