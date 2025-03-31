package com.chrzanop.coding.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class SimplifyPath {

    public String simplifyPath(String complexPath) {

        Deque<String> stack = new LinkedList<>();
        String current = "";

        for (int i = 0; i < complexPath.length(); i++) {
            char character = complexPath.charAt(i);
            if (character == '/') {
                if (current.equals("..")) {
                    if(!stack.isEmpty()) stack.pop();
                } else if (!current.equals("") && !current.equals(".")) {
                    stack.push(current);
                }
                current = "";
            } else {
                current += character;
            }
        }
        StringBuilder simplifiedPath = new StringBuilder();
        while (!stack.isEmpty()) {
            simplifiedPath.append("/").append(stack.pollLast());
        }

        return simplifiedPath.toString();

    }
}
