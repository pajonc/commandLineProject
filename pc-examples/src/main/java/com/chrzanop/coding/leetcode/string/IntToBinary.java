package com.chrzanop.coding.leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class IntToBinary {


    public static void main(String[] args) {
//        System.out.printf("5 to binary %s, should be accepted %s", toBinary(5), toBinary(5).equals("101"));
        System.out.printf("10 to binary %s, (toBinary) should be accepted %s\n", toBinary(10), toBinary(10).equals("1010"));
        System.out.printf("10 to binary %s, (toBinaryMethod2) should be accepted %s%n", toBinaryMethod2(10), toBinaryMethod2(10).equals("1010"));
        System.out.printf("10 to binary %s, (toBinaryByCheckingEachBit) should be accepted %s%n", toBinaryByCheckingEachBit(10), toBinaryByCheckingEachBit(10).equals("1010"));

    }


    static String toBinary(int n) {
        if (n == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.insert(0, n % 2);
            n /= 2;
        }
        return sb.toString();
    }


    // very complex approach and fully working for corner cases
    static String toBinaryMethod2(int n) {
        if (n == 0) return "0";

        List<Integer> holdIndexes = new ArrayList<>();

        while(n>0) {
            int i=0;
            int tempValue = 1;
            if(tempValue<n) {
                while(tempValue<=n) {
                    tempValue *= 2;
                    i++;
                }
                i = i -1;
                holdIndexes.add(i);
            }

            n = n - tempValue/2;
        }

        int size = holdIndexes.get(0);
        char[] binaryTable = new char[size+1];
        for (int i = 0; i < size+1; i++) {
            binaryTable[i] = '0';
        }

        for (Integer index : holdIndexes) {
            binaryTable[size - index] = '1';
        }

        return new String(binaryTable);
    }


    static String toBinaryByCheckingEachBit(int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = 31; i >= 0; i--) {
            sb.append((n >> i) & 1);
        }

        String binary = sb.toString().replaceFirst("^0+(?!$)", "");
//        System.out.println(binary);
        return binary;
    }
}
