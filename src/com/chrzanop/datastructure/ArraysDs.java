package com.chrzanop.datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysDs {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);
        System.out.println("input array: " + list);
        System.out.println("reversed array: " + reverseArray(list));

    }


    public static List<Integer> reverseArray(List<Integer> list) {
        // Write your code here
        List<Integer> reverse = new ArrayList();
        int length = list.size();
        for (int i = 0; i < list.size(); i++) {
            reverse.add(list.get(--length));
        }

        return reverse;
    }
}
