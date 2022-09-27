package com.chrzanop.recursive;

public class DrawTriangle {

    public static void main(String[] args) {

        for (int i = 1; i < 10; i++) {
            paint(drawTriangle(i));
        }

    }

    public static int drawTriangle(int size) {
        if (size == 1) {
            return 1;
        }
        return (size + 2) - 1;
    }

    public static void paint(int number) {
        for (int i = 0; i < number; i++) {
            System.out.print("*");
        }
        System.out.println();
    }



}
