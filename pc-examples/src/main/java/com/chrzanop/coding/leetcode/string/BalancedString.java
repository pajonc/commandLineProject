package com.chrzanop.coding.leetcode.string;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class BalancedString {

    public static void main(String[] args) {
        String str1 = "()()";
        System.out.println(isBalancedString(str1));
        String str2 = "({[]})";
        System.out.println(isBalancedString(str2));
        String str3 = "(()";
        System.out.println(isBalancedString(str3));
        String str4 =")(()";
        System.out.println(isBalancedString(str4));
        String str5 = "({)}";
        System.out.println(isBalancedString(str5));
    }


    static boolean isBalancedString(String str) {
        System.out.println("Checking string if balanced "+ str);

        if (str == null || str.isBlank()) return false;

        Deque<Character> stack = new ArrayDeque<>();

        for (char c : str.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty() || stack.pop() != c) return false;
            }
        }

        return stack.isEmpty();
    }

}
