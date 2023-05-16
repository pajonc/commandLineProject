package com.chrzanop.coding.algoexpert.stacks;

import java.util.Deque;
import java.util.LinkedList;

public class BestDigits {

    // O(n) time | O(n) space - where n is the number of string length
    public String bestDigits(String number, int numDigits) {
        Deque<Character> stack = new LinkedList<>();
        if (number.length() <= numDigits) {
            return number;
        }

        for (int i = 0; i < number.length(); i++) {
            char character = number.charAt(i);
            while (!stack.isEmpty() && character > stack.peek() && numDigits > 0) {
                stack.pop();
                numDigits--;
            }
            stack.push(character);
        }

        while (numDigits > 0) {
            stack.pop();
            numDigits--;
        }
        // build final string from stack
        StringBuilder bestDigitString = new StringBuilder();
        while (!stack.isEmpty()) {
            bestDigitString.append(String.valueOf(stack.pop()));
        }
        bestDigitString.reverse();

        return bestDigitString.toString();
    }
}
