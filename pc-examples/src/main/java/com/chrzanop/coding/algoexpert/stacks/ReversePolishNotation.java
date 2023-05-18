package com.chrzanop.coding.algoexpert.stacks;

import java.util.Stack;

public class ReversePolishNotation {

    //O(n) time | O(n) space
    public int reversePolishNotation(String[] tokens) {

        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                Integer secondNum = stack.pop();
                Integer firstNum = stack.pop();
                stack.add(firstNum + secondNum);
            } else if (token.equals("-")) {
                Integer secondNum = stack.pop();
                Integer firstNum = stack.pop();
                stack.push(firstNum - secondNum);
            } else if (token.equals("*")) {
                Integer secondNum = stack.pop();
                Integer firstNum = stack.pop();
                stack.push(firstNum * secondNum);
            } else if (token.equals("/")) {
                Integer secondNum = stack.pop();
                stack.push(stack.pop() / secondNum);
            } else {
                stack.add(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

}
