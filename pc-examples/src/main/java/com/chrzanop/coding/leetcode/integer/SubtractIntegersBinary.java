package com.chrzanop.coding.leetcode.integer;

public class SubtractIntegersBinary {

    public static void main(String[] args) {
        System.out.println(binarySubtract("100","1"));
    }

    static String binarySubtract(String a, String b) {
        if (a.length() < b.length()) {
            throw new IllegalArgumentException("First operand must be at least as large as the second");
        }

        StringBuilder result = new StringBuilder();
        int borrow = 0;

        for (int i = a.length() - 1, j = b.length() - 1; i >= 0; i--, j--) {
            int bitA = a.charAt(i) - '0';
            int bitB = (j >= 0) ? b.charAt(j) - '0' : 0;

            int diff = bitA - bitB - borrow;
            if (diff < 0) {
                diff += 2;
                borrow = 1;
            } else {
                borrow = 0;
            }
            result.append(diff);
        }

        if (borrow != 0) {
            throw new IllegalArgumentException("Result would be negative");
        }

        // Strip leading zeros, keeping at least one digit
        int start = 0;
        while (start < result.length() - 1 && result.charAt(start) == '0') {
            start++;
        }

        return result.reverse().substring(start);
    }
}
