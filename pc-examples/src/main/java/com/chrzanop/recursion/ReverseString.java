package com.chrzanop.recursion;

public class ReverseString {

    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'c', 'd'};

        char[] chars1 = reverseString(chars);

        System.out.println(chars1);

        reverseString2(chars);


    }

    public static char[] reverseString(char[] input) {

        int len = input.length;
        char[] newChars = new char[input.length];
        int j = 0;

        for (int i = len - 1; i >= 0; i--) {
            newChars[j] = input[i];
            j++;
        }

        return newChars;
    }

    public static void reverseString2(char[] input) {

        int a_pointer = 0;
        int b_pointer = input.length - 1;

        while (a_pointer <= b_pointer) {
            char temp = input[a_pointer];
            input[a_pointer] = input[b_pointer];
            input[b_pointer] = temp;
            a_pointer = a_pointer + 1;
            b_pointer = b_pointer - 1;
        }

        System.out.println(input);

    }


}
