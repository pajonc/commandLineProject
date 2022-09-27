package com.chrzanop.datastructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeftRotationArray {

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        List<Integer> array2 = new ArrayList<>();
        array2.addAll(array);

        System.out.println(rotateLeft(2, array));
        System.out.println("---------------------");
        System.out.println(rotateLeftSecond(2, array2));


    }


    /*
     * Complete the 'rotateLeft' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER d
     *  2. INTEGER_ARRAY arr
     */

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {

        for (int i = 0; i < d; i++) {
            int intial = arr.get(0);
            for (int j = 0; j < arr.size()-1 ; j++) {
                arr.set(j, arr.get(j+1));
            }
            arr.set(arr.size()-1, intial);
        }

        return arr;

    }

    /*
     * Complete the 'rotateLeft' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER d
     *  2. INTEGER_ARRAY arr
     */

    public static List<Integer> rotateLeftSecond(int d, List<Integer> arr) {

        LinkedList<Integer> rotatedList = new LinkedList<>();

        rotatedList.addAll(arr);

        for (int i = 0; i < d; i++) {
            int first = rotatedList.pop();
            rotatedList.addLast(first);
        }

        return rotatedList;

    }



}
