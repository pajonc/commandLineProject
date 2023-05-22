package com.chrzanop.coding.algoexpert.arrays;

public class BestSeat {

    //O(n) time | O(1) space where n is the length of the seats
    public int bestSeat_Mine(int[] seats) {
        int emptySeatCounter = 0;
        int bestSeat = -1;
        for (int i = 1; i < seats.length; i++) {
            if (seats[i] == 0) {
                emptySeatCounter++;
                continue;
            }
            if (emptySeatCounter > 0) {
                int bestSeatCalc = emptySeatCounter / 2;
                bestSeat = i - bestSeatCalc - 1;
            }
            emptySeatCounter = 0;

        }
        return bestSeat;
    }

    public int bestSeat(int[] seats) {
        int bestSeat = -1;
        int maxSpace = 0;
        int i=0,j=1;

        while(i<seats.length && j<seats.length) {
            if(seats[j]==1){
                int localMaxSpace = j-i-1;
                if(localMaxSpace>0 && localMaxSpace>maxSpace) {
                    bestSeat = (j+i)/2;
                }
                i=j;
            }
            j++;
        }

        return bestSeat;
    }
}
