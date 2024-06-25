package com.chrzanop.coding.algoexpert.heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopRentals2 {

    public int laptopRentals(ArrayList<ArrayList<Integer>> times) {
        if (times.size() == 0) {
            return 0;
        }

        List<Integer> startTimes = new ArrayList<>();
        List<Integer> endTimes = new ArrayList<>();

        for (ArrayList<Integer> range : times) {
            startTimes.add(range.get(0));
            endTimes.add(range.get(1));
        }

        Collections.sort(startTimes, (a, b) -> Integer.compare(a, b));
        Collections.sort(endTimes, (a, b) -> Integer.compare(a, b));
        int requiredLaptops = 1;

        int i = 1, j = 0;
        while (i < startTimes.size()) {
            int startTime = startTimes.get(i);
            int endTime = endTimes.get(j);
            if (startTime < endTime) {
                requiredLaptops++;
                i++;
            } else {
                i++;
                j++;
            }
        }
        return requiredLaptops;
    }

}
