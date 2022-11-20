package com.chrzanop.coding.algoexpert.arrays;

import static org.junit.Assert.assertTrue;

public class ArrayOfProducts {


    public static void main(String[] args) {

        ArrayOfProducts aop = new ArrayOfProducts();

        int[] input = new int[] {5, 1, 4, 2};
        int[] expected = new int[] {8, 40, 10, 20};
        int[] input3 = new int[]{-5, 2, -4, 14, -6};
        int[] expected3 = new int[]{672, -1680, 840, -240, 560};

        int[] result = aop.arrayOfProducts(input);

        for (int i = 0; i < result.length; i++) {
            assertTrue(result[i] == expected[i]);
        }

        int[] result2 = aop.arrayOfProductsSolution2(input);

        for (int i = 0; i < result2.length; i++) {
            assertTrue(result2[i] == expected[i]);
        }

        int[] result3 = aop.arrayOfProductsSolution2(input3);

        for (int i = 0; i < result3.length; i++) {
            assertTrue(result3[i] == expected3[i]);
        }



    }

    // O(n2) time | O(n) space
    public int[] arrayOfProducts(int[] array) {

        int[] products = new int[array.length];

        int currentProduct = 1;
        for(int i = 0; i<array.length; i++) {
            for(int j = 0; j<array.length; j++) {
                if (i != j) {
                    currentProduct = currentProduct * array[j];
                }
            }
            products[i] = currentProduct;
            currentProduct = 1;
        }

        // Write your code here.
        return products;
    }

    // O(3n) --> O(n) time | O(n) space
    public int[] arrayOfProductsSolution2(int[] array) {

        int[] left = new int[array.length];
        int[] right = new int[array.length];
        int[] products = new int[array.length];

        int currentLeft = 1;
        for (int i=0; i<array.length; i++) {
            left[i] = currentLeft;
            currentLeft *= array[i];
        }

        int currentRight = 1;
        for (int i=array.length-1; i>=0; i--) {
            right[i] = currentRight;
            currentRight *= array[i];
        }

        for(int i=0; i<array.length; i++) {
            products[i] = left[i] * right[i];
        }


        return products;
    }
}


