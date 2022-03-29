package com.chrzanop.recursive;

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fibonacci(0));
        System.out.println(fibonacci(1));
        System.out.println(fibonacci(2));
        System.out.println(fibonacci(3));
        System.out.println(fibonacci(4));
        System.out.println(fibonacci(5));

        System.out.println("----------------");
        System.out.println(fibonacciLoop(0));
        System.out.println(fibonacciLoop(1));
        System.out.println(fibonacciLoop(2));
        System.out.println(fibonacciLoop(3));
        System.out.println(fibonacciLoop(4));
        System.out.println(fibonacciLoop(5));
    }

    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static int fibonacciLoop(int n) {

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int previous = 1, next = 1;
        for (int i = 0; i < n; i++) {

            if(i >= 2) {
                int temp = previous;
                previous = next;
                next = previous + temp;
            }
        }
        return next;

    }


}
