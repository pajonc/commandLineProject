package com.chrzanop.coding.algoexpert.stacks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SunsetViews {

    // O(n) time | O(n) space - where n is the length of the input array
    public ArrayList<Integer> sunsetViews(int[] buildings, String direction) {

        int currentMax = 0;
        ArrayList<Integer> views = new ArrayList<Integer>();
        if (direction.equals("EAST")) {
            for (int i = buildings.length - 1; i >= 0; i--) {
                if (buildings[i] > currentMax) {
                    views.add(i);
                    currentMax = buildings[i];
                }
            }
            Collections.reverse(views);
//            swap(views);

        } else {
            for (int i = 0; i < buildings.length; i++) {
                if (buildings[i] > currentMax) {
                    views.add(i);
                    currentMax = buildings[i];
                }
            }
        }

        return views;
    }

    void swap(List<Integer> list) {
        int i = 0, j = list.size() - 1;
        while (i < j) {
            int temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
            i++;
            j--;
        }
    }







}
