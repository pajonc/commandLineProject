package com.chrzanop.coding.algoexpert.arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SweetAndSavory {

    // O(n* log(n)) time | O(n) space - where n is the number of dishes
    public int[] sweetAndSavory(int[] dishes, int target) {
        List<Integer> sweetDishes = new ArrayList<>();
        List<Integer> savoryDishes = new ArrayList<>();

        for(int dish : dishes) {
            if(dish<0){
                sweetDishes.add(dish);
            } else {
                savoryDishes.add(dish);
            }
        }
        sweetDishes.sort(Comparator.comparingInt(Math::abs));
        savoryDishes.sort(Comparator.naturalOrder());
        // Collections.sort(savory);

        int[] bestPair = new int[2];
        int bestDifference = Integer.MAX_VALUE;
        int sweetIndex = 0, savoryIndex = 0;

        while(sweetIndex < sweetDishes.size() && savoryIndex < savoryDishes.size() ) {
            int currentSum = sweetDishes.get(sweetIndex) + savoryDishes.get(savoryIndex);

            if(currentSum <= target) {
                int currentDifference = target - currentSum;
                if(currentDifference < bestDifference) {
                    bestPair[0] = sweetDishes.get(sweetIndex);
                    bestPair[1] = savoryDishes.get(savoryIndex);
                    bestDifference = currentDifference;
                }
                savoryIndex++;
            } else {
                sweetIndex++;
            }
        }

        return bestPair;
    }
}
