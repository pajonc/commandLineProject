package com.chrzanop.coding.algoexpert.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JuiceBottling {

    // O(n^3) time | O(n^2) space - where n is the length of prices
    public ArrayList<Integer> juiceBottlingAlgo1(int[] prices) {
        int numSizes = prices.length;
        int[] maxProfit = new int[numSizes];
        ArrayList<ArrayList<Integer>> solutions = new ArrayList<>();
        for (int i = 0; i < numSizes; i++) {
            solutions.add(new ArrayList<>());
        }

        for (int size = 0; size < numSizes; size++) {
            for (int dividingPoint = 0; dividingPoint <= size; dividingPoint++) {
                int maxProfitValue = maxProfit[size - dividingPoint];
                int priceAtDividingPoint = prices[dividingPoint];
                int possibleProfit = maxProfitValue + priceAtDividingPoint;

                if(possibleProfit > maxProfit[size]) {
                    maxProfit[size] = possibleProfit;
                    ArrayList<Integer> newSolution = new ArrayList<>();
                    newSolution.add(dividingPoint);
                    newSolution.addAll(solutions.get(size - dividingPoint));
                    solutions.set(size, newSolution);
                }

            }
        }
        return solutions.get(numSizes-1);
    }


    // not working
    public ArrayList<Integer> juiceBottlingAlgo1Try(int[] prices) {

        List<SolutionWithProfit> subSolutions = new ArrayList<>();

        subSolutions.add(new SolutionWithProfit(new ArrayList<>(), 0));
        subSolutions.add(new SolutionWithProfit(new ArrayList<>(Arrays.asList(1)), prices[1]));

        for (int i = 2; i < prices.length; i++) {
            int currentProfit = prices[i];
            int targetQuantity = i;
            ArrayList<Integer> solution = new ArrayList<>(Arrays.asList(i));
            for (int j = 1; j < i; j++) {
                int localProfit = 0;
                int quantityIndex = j;
                ArrayList<Integer> newSolution = new ArrayList<>();
                while (targetQuantity>0) {
                    localProfit += prices[quantityIndex];
                    newSolution.add(quantityIndex);
                    targetQuantity = targetQuantity - quantityIndex;
                    quantityIndex =  targetQuantity;
                }
                if(localProfit>currentProfit) {
                    solution = new ArrayList<>(newSolution);
                    currentProfit = localProfit;
                }
            }
            subSolutions.add(new SolutionWithProfit(solution, currentProfit));
        }


        return subSolutions.get(subSolutions.size()-1).solution;

    }

    class SolutionWithProfit {
        private ArrayList<Integer> solution;
        private Integer profit;

        public SolutionWithProfit(ArrayList<Integer> solution, Integer profit) {
            this.solution = solution;
            this.profit = profit;
        }

        public List<Integer> getSolution() {
            return solution;
        }

        public void setSolution(ArrayList<Integer> solution) {
            this.solution = solution;
        }

        public Integer getProfit() {
            return profit;
        }

        public void setProfit(Integer profit) {
            this.profit = profit;
        }
    }

    public ArrayList<Integer> juiceBottling(int[] prices) {

        List<List<Integer>> subSolutions = new ArrayList<>();

        juiceBottle(prices, 0, subSolutions, new ArrayList<>(), 1);

        Integer maxSubset = Integer.MIN_VALUE;
        ArrayList<Integer> result = null;
        for (List<Integer> subset : subSolutions) {
            int countedSize = countSize(subset, prices);
            if (countedSize > maxSubset) {
                result = new ArrayList<>(subset);
                maxSubset = countedSize;
            }
        }
        Collections.sort(result);

        return result;
    }


    void juiceBottle(int[] prices, int currentJuiceSize, List<List<Integer>> subSolutions, List<Integer> currentSolution, int quantityIdx) {

        if (currentJuiceSize == prices.length - 1) {
            subSolutions.add(currentSolution);
            return;
        }

        for (int quantityValueIndex = quantityIdx; quantityValueIndex < prices.length; quantityValueIndex++) {
            if (currentJuiceSize + quantityValueIndex > prices.length - 1) continue;
            List<Integer> newCurrentSolution = new ArrayList<>(currentSolution);
            newCurrentSolution.add(quantityValueIndex);
            int newJuiceSize = currentJuiceSize + quantityValueIndex;
            juiceBottle(prices, newJuiceSize, subSolutions, newCurrentSolution, quantityValueIndex);
        }

    }

    int countSize(List<Integer> currentSolution, int[] prices) {
        int sumedPrice = 0;
        for (Integer index : currentSolution) {
            sumedPrice += prices[index];

        }
        return sumedPrice;
    }


}
