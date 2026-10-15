package com.chrzanop.coding.leetcode;

public class MyAtoi {

    public static void main(String[] args) {
        String s = " 042";
        System.out.println("output "+myAtoi(s));
    }


        public static int myAtoi(String s) {
            // 1. Handle edge case for empty string
            if (s == null || s.isEmpty()) {
                return 0;
            }

            int index = 0;
            int n = s.length();

            // 2. Discard leading whitespaces
            while (index < n && s.charAt(index) == ' ') {
                index++;
            }

            // Check if string was only whitespaces
            if (index == n) {
                return 0;
            }

            // 3. Check for sign
            int sign = 1;
            char firstChar = s.charAt(index);
            if (firstChar == '+') {
                index++;
            } else if (firstChar == '-') {
                sign = -1;
                index++;
            }

            // 4. Convert digits and prevent 32-bit overflow
            int result = 0;
            while (index < n) {
                char curr = s.charAt(index);

                // Stop if the character is not a digit
                if (curr < '0' || curr > '9') {
                    break;
                }

                int digit = curr - '0';

                // Check for overflow/underflow before multiplying
                if (result > (Integer.MAX_VALUE - digit) / 10) {
                    return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }

                result = result * 10 + digit;
                index++;
            }

            return result * sign;
        }

}
