package com.chrzanop.math;

public class PrimeNumber {

    public static boolean isPrimeNumber(int liczba) {
        if (liczba < 2) {
            return false;
        }
        for (int i = 2; i <= liczba / 2; i++) {
            if (liczba % i == 0) {
                return false;
            }
        }
        return true;
    }


    public static int countPrimes(int n) {
        boolean[] primes = new boolean[n+1];
        for (int i = 0; i < primes.length; i++) {
            primes[i] = true;
        }

        primes[0] = false;
        primes[1] = false;

        for (int i = 2; i * i < primes.length; i++) {
            if (primes[i]) {
                for (int j = i; j * i < primes.length; j++) {
                    System.out.println(": " + j * i);
                    primes[(i * j)] = false;
                }
            }
        }

        int counter = 0;
        for (int m = 0; m < primes.length; m++) {
            if (primes[m]) counter++;
        }

        return counter;
    }

    public static void main(String[] args) {

        boolean a = isPrimeNumber(13);
        System.out.println(a);
        System.out.println("-----------------------");
        System.out.println(countPrimes(10));
    }

}
