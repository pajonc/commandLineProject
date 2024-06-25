package com.chrzanop.coding.algoexpert.heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class ContinuousMedianHandler {

    double median = 0;
    private Heap lowerHalf = new Heap(Heap::MAX_HEAP_FUNC, new ArrayList<>());
    private Heap greaterHalf = new Heap(Heap::MIN_HEAP_FUNC, new ArrayList<>());

    public void insert(int number) {
        if (lowerHalf.length == 0 || number < lowerHalf.peek()) {
            lowerHalf.insert(number);
        } else {
            greaterHalf.insert(number);
        }
        rebalanceHeaps();
        updateMedian();
    }

    void rebalanceHeaps() {
        if (lowerHalf.length - greaterHalf.length == 2) {
            greaterHalf.insert(lowerHalf.remove());
        } else if (greaterHalf.length - lowerHalf.length == 2) {
            lowerHalf.insert(greaterHalf.remove());
        }

    }

    public void updateMedian() {
        if (lowerHalf.length == greaterHalf.length) {
            median = ((double) lowerHalf.peek() + (double) greaterHalf.peek()) / 2;
        } else if (lowerHalf.length > greaterHalf.length) {
            median = lowerHalf.peek();
        } else {
            median = greaterHalf.peek();
        }
    }

    public double getMedian() {
        return median;
    }

    static class Heap {

        List<Integer> heap = new ArrayList<>();
        int length;
        BiFunction<Integer, Integer, Boolean> comparisonFunc;

        public Heap(BiFunction<Integer, Integer, Boolean> func, List<Integer> array) {
            this.comparisonFunc = func;
            heap = buildHeap(array);
            length = heap.size();

        }

        public List<Integer> buildHeap(List<Integer> array) {
            int firstParentIdx = (array.size() - 2) / 2;
            for (int currentIdx = firstParentIdx; currentIdx >= 0; currentIdx--) {
                siftDown(currentIdx, array.size() - 1, array);
            }
            return array;
        }

        public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
            int childOneIdx = 2 * currentIdx + 1;
            while (childOneIdx <= endIdx) {
                int childTwoIdx = 2 * currentIdx + 2 <= endIdx ? 2 * currentIdx + 2 : -1;
                int swapIdx;
                if (childTwoIdx != -1) {
                    if (comparisonFunc.apply(heap.get(childTwoIdx), heap.get(childOneIdx))) {
                        swapIdx = childTwoIdx;
                    } else {
                        swapIdx = childOneIdx;
                    }

                } else {
                    swapIdx = childOneIdx;
                }
                if (comparisonFunc.apply(heap.get(swapIdx), heap.get(currentIdx))) {
                    swap(currentIdx, swapIdx, heap);
                    currentIdx = swapIdx;
                    childOneIdx = 2 * currentIdx + 1;
                } else {
                    return;
                }
            }
        }

        public void siftUp(int currentIdx, List<Integer> heap) {
            int parentIdx = (currentIdx - 1) / 2;
            while (comparisonFunc.apply(heap.get(currentIdx), heap.get(parentIdx)) && currentIdx > 0) {
                swap(currentIdx, parentIdx, heap);
                currentIdx = parentIdx;
                parentIdx = (currentIdx - 1) / 2;
            }
        }

        public int peek() {
            return heap.get(0);
        }

        public int remove() {
            swap(0, heap.size() - 1, heap);
            int valueToRemove = heap.get(heap.size() - 1);
            heap.remove(heap.size() - 1);
            siftDown(0, heap.size() - 1, heap);
            length--;
            return valueToRemove;
        }

        public void insert(int value) {
            heap.add(value);
            siftUp(heap.size() - 1, heap);
            length++;
        }

        private void swap(int idx1, int idx2, List<Integer> heap) {
            int temp = heap.get(idx2);
            heap.set(idx2, heap.get(idx1));
            heap.set(idx1, temp);
        }


        public static boolean MAX_HEAP_FUNC(int a, int b) {
            return a > b;
        }

        public static boolean MIN_HEAP_FUNC(int a, int b) {
            return a < b;
        }
    }

}

