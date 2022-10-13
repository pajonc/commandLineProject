package com.chrzanop.recursion;

public class Factorial {

    public static void main(String[] args) {
        System.out.println(fact(1));
        System.out.println(fact(2));
        System.out.println(fact(3));
        System.out.println(fact(4));
    }

    private static int fact(int n) {
        if(n>=2) return n*fact(n-1);
        else return 1;
    }
}
