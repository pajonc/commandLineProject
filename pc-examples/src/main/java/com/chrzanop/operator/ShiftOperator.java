package com.chrzanop.operator;

public class ShiftOperator {

    public static void main(String[] args) {
        int x = 4;
        System.out.println(4>>1);  // -> 2  (4/2)   0100 -> 00010
        System.out.println(4<<2); // -> 16  (2*2)   0100 -> 10000

        int n = 10;
        int hash = 15;
        System.out.println((n-1) & hash);
    }
}
