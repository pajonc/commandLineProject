package com.chrzanop.coding.algoexpert.heaps;

import java.util.ArrayList;
import java.util.List;

public class SortKSortedArray {

    public int[] sortKSortedArray(int[] array, int k) {
        List<Integer> heapValues = new ArrayList<>();
        for (int i = 0; i < Math.min(k + 1, array.length); i++) {
            heapValues.add(array[i]);
        }
        MinHeap heap = new MinHeap(heapValues);
        List<Integer> sortedList = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            System.out.println(heap.peek());
            sortedList.add(heap.remove());
            if (k + 1 < array.length) {
                heap.insert(array[k + 1]);
            }
            k = k + 1;
        }

        for (int i = 0; i < sortedList.size(); i++) {
            array[i] = sortedList.get(i);
        }

        return array;


    }

    private void swap(int[] array, int i, int j) {
        int tempI = array[i];
        array[i] = array[j];
        array[j] = tempI;
    }

    static class MinHeap {

        private List<Integer> heap = new ArrayList<>();

        public MinHeap(List<Integer> array) {
            this.heap = buildHeap(array);
        }

        public List<Integer> buildHeap(List<Integer> array) {
            int firstParentIdx = (array.size() - 1) / 2;
            for (int currentIdx = firstParentIdx; currentIdx >= 0; currentIdx--) {
                siftDown( array, currentIdx);
            }
            return array;
        }

        public void insert(int value) {
            heap.add(value);
            siftUp(heap, heap.size() - 1);
        }

        public int remove() {
            swap(0, heap.size() - 1, heap);
            int valueToRemove = heap.get(heap.size() - 1);
            heap.remove(heap.size() - 1);
            siftDown(0, heap.size() - 1, heap);
            return valueToRemove;
        }

        public Integer peek() {
            return heap.get(0);
        }


        public void siftDown(List<Integer> heap, int currentIdx) {
            int childOneIdx = currentIdx * 2 + 1;
            while(childOneIdx <= heap.size()-1) {
                int childTwoIdx = currentIdx * 2 + 2 <= heap.size()-1 ? currentIdx * 2 + 2 : -1;
                int idxToSwap;
                if(childTwoIdx != -1 && heap.get(childTwoIdx) < heap.get(childOneIdx)) {
                    idxToSwap = childTwoIdx;
                } else {
                    idxToSwap = childOneIdx;
                }
                if(heap.get(idxToSwap) < heap.get(currentIdx)) {
                    swap(currentIdx, idxToSwap, heap);
                    currentIdx = idxToSwap;
                    childOneIdx = currentIdx * 2 + 1;
                } else {
                    return;
                }
            }
        }

        public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
            int childOneIdx = currentIdx * 2 + 1;
            while (childOneIdx <= endIdx) {
                int childTwoIdx = currentIdx * 2 + 2 <= endIdx ? currentIdx * 2 + 2 : -1;
                int idxToSwap;
                if (childTwoIdx != -1 && heap.get(childTwoIdx) < heap.get(childOneIdx)) {
                    idxToSwap = childTwoIdx;
                } else {
                    idxToSwap = childOneIdx;
                }
                if (heap.get(idxToSwap) < heap.get(currentIdx)) {
                    swap(currentIdx, idxToSwap, heap);
                    currentIdx = idxToSwap;
                    childOneIdx = currentIdx * 2 + 1;
                } else {
                    return;
                }
            }
        }

        private void siftUp(List<Integer> heap, int currentIdx) {
            int parentIdx = (currentIdx - 1) / 2;
            while (currentIdx > 0 && heap.get(currentIdx) < heap.get(parentIdx)) {
                swap(parentIdx, currentIdx, heap);
                currentIdx = parentIdx;
                parentIdx = (currentIdx - 1) / 2;
            }
        }

        public boolean isEmpty() {
            return heap.size() == 0;
        }

        private void swap( int i, int j, List<Integer> array) {
            int tempI = array.get(i);
            array.set(i, array.get(j));
            array.set(j, tempI);
        }

    }

}
