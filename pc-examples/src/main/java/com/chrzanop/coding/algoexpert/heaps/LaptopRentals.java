package com.chrzanop.coding.algoexpert.heaps;

import java.util.ArrayList;
import java.util.Collections;

public class LaptopRentals {

    public int laptopRentals(ArrayList<ArrayList<Integer>> times) {
        if (times.size() == 0) {
            return 0;
        }
        Collections.sort(times, (a, b) -> Integer.compare(a.get(0), b.get(0)));

        ArrayList<ArrayList<Integer>> timesWhenLaptopIsUsed
                = new ArrayList<ArrayList<Integer>>();
        timesWhenLaptopIsUsed.add(times.get(0));

        MinHeap minHeap = new MinHeap(timesWhenLaptopIsUsed);
        for (int i = 1; i < times.size(); i++) {
            ArrayList<Integer> currentInterval = times.get(i);
            if (minHeap.peek().get(1) <= currentInterval.get(0)) {
                minHeap.remove();
            }
            minHeap.insert(times.get(i));
        }

        return timesWhenLaptopIsUsed.size();
    }


    static class MinHeap {

        ArrayList<ArrayList<Integer>> heap = new ArrayList<ArrayList<Integer>>();

        public MinHeap(ArrayList<ArrayList<Integer>> array) {
            heap = buildHeap(array);
        }

        public ArrayList<ArrayList<Integer>> buildHeap(
                ArrayList<ArrayList<Integer>> array) {
            int firstParentIdx = (array.size() - 1) / 2;
            for (int currentIdx = firstParentIdx; currentIdx >= 0; currentIdx--) {
                siftDown(currentIdx, array.size() - 1, array);
            }
            return array;
        }

        public void siftDown(int currentIdx, int endIdx, ArrayList<ArrayList<Integer>> heap) {
            int newCurrentIdx = currentIdx;
            int childOneIdx = currentIdx * 2 + 1;
            while (childOneIdx <= endIdx) {
                int childTwoIdx = (newCurrentIdx * 2 + 2 <= endIdx) ? newCurrentIdx * 2 + 2 : -1;
                int idxToSwap;
                if (childTwoIdx != -1 && heap.get(childTwoIdx).get(1) < heap.get(childOneIdx).get(1)) {
                    idxToSwap = childTwoIdx;
                } else {
                    idxToSwap = childOneIdx;
                }
                if (heap.get(idxToSwap).get(1) < heap.get(currentIdx).get(1)) {
                    swap(newCurrentIdx, idxToSwap, heap);
                    newCurrentIdx = idxToSwap;
                    childOneIdx = newCurrentIdx * 2 + 1;
                } else {
                    return;
                }
            }
        }

        public void siftUp(int currentIdx, ArrayList<ArrayList<Integer>> heap) {
            int parentIdx = (currentIdx - 1) / 2;
            while (heap.get(currentIdx).get(1) < heap.get(parentIdx).get(1) && currentIdx > 0) {
                swap(currentIdx, parentIdx, heap);
                currentIdx = parentIdx;
                parentIdx = (currentIdx - 1) / 2;
            }
        }

        public ArrayList<Integer> peek() {
            return heap.get(0);
        }

        public ArrayList<Integer> remove() {
            swap(0, heap.size() - 1, heap);
            ArrayList<Integer> valueToRemove = heap.get(heap.size() - 1);
            heap.remove(heap.size() - 1);
            siftDown(0, heap.size() - 1, heap);
            return valueToRemove;
        }

        public void insert(ArrayList<Integer> value) {
            heap.add(value);
            siftUp(heap.size() - 1, heap);
        }

        private void swap(int idx1, int idx2, ArrayList<ArrayList<Integer>> heap) {
            ArrayList<Integer> temp = heap.get(idx1);
            heap.set(idx1, heap.get(idx2));
            heap.set(idx2, temp);
        }

    }

}
